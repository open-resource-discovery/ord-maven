import * as fs from "fs";
import * as path from "path";

/**
 * CLI:
 *   --schema <path to Document.annotated.schema.json>
 *   --outDir <generated sources base dir>
 *   --pkg    <java package for generated annotations>
 *   --specPkg <path to specification's package.json> (optional)
 * Env:
 *   ORD_SPEC_VERSION overrides version read from package.json
 */
const args = new Map<string, string>();
for (let i = 2; i < process.argv.length; i += 2) {
  const k = process.argv[i]?.replace(/^--/, "");
  const v = process.argv[i + 1];
  if (k && v) args.set(k, v);
}

const SCHEMA_PATH =
  args.get("schema") ||
  "ord-spec/static/spec-v1/interfaces/Document.annotated.schema.json";

const OUTPUT_BASE = args.get("outDir") || "annotations/target/generated-sources";
const JAVA_PACKAGE = args.get("pkg") || "org.openresourcediscovery.annotations";

/** Try to infer spec package.json from --specPkg or from schema path */
const SPEC_PKG_JSON =
  args.get("specPkg") || findSpecPackageJson(SCHEMA_PATH) || "ord-spec/package.json";

const OUTPUT_DIR = path.join(OUTPUT_BASE, ...JAVA_PACKAGE.split("."));
const OUTPUT_FILE = path.join(OUTPUT_DIR, "Ord.java");

// --- Schema model types ---
type SchemaProperty = {
  type?: string;
  description?: string;
  default?: unknown;
  enum?: string[];
  items?: SchemaProperty;
  $ref?: string;
  anyOf?: SchemaProperty[];
};

type SchemaDefinition = {
  properties?: Record<string, SchemaProperty>;
  patternProperties?: Record<string, SchemaProperty>;
  required?: string[];
  "x-ums-type"?: string; // "root" or nested
};

type AllDefs = Record<string, SchemaDefinition>;

// ----- helpers -----
function findSpecPackageJson(schemaPath: string): string | null {
  try {
    let dir = path.resolve(path.dirname(schemaPath));
    for (let i = 0; i < 5; i++) {
      const candidate = path.join(dir, "package.json");
      if (fs.existsSync(candidate)) return candidate;
      dir = path.dirname(dir);
    }
  } catch { /* ignore */ }
  return null;
}

function buildRequiredArray(def: SchemaDefinition): string {
  const reqList = def.required ?? [];
  if (!reqList.length) return "default {}";
  const items = reqList.map((f) => `"${f}"`).join(", ");
  return `default { ${items} }`;
}

function resolveJavaType(prop: SchemaProperty = { type: "string" }): string {
  if (prop.$ref) return prop.$ref.split("/").pop()!;
  if (prop.type === "array" && prop.items?.anyOf?.length) {
    const refItem = prop.items.anyOf.find((i) => typeof i.$ref === "string");
    if (refItem?.$ref) return `${refItem.$ref.split("/").pop()}[]`;
  }
  if (prop.type === "array" && typeof prop.items?.$ref === "string") {
    return `${prop.items.$ref.split("/").pop()}[]`;
  }
  if (prop.type === "array") return `${resolveJavaType(prop.items)}[]`;
  if (prop.type === "object") return "String";
  switch (prop.type) {
    case "string": return "String";
    case "boolean": return "boolean";
    case "number":
    case "integer": return "double";
    default: return "String";
  }
}

function buildDefaultAnnotation(def: SchemaDefinition, annotationName: string): string {
  const req = def.required ?? [];
  const props = def.properties ?? {};
  const args = req.map((name) => {
    const prop = props[name];
    const type = resolveJavaType(prop);
    let val: string;
    if (type === "String") {
      val = `"${typeof prop.default === "string" ? prop.default : ""}"`;
    } else if (type === "boolean") {
      val = `${prop.default ?? false}`;
    } else if (type === "double") {
      val = `${prop.default ?? 0}`;
    } else if (type.endsWith("[]")) {
      val = `{}`;
    } else {
      val = `@${type}()`;
    }
    return `${name} = ${val}`;
  }).join(", ");
  return `@${annotationName}${req.length ? `(${args})` : `()`}`;
}

function generateProps(def: SchemaDefinition, allDefs: AllDefs): string {
  const props = def.properties ?? {};

  if (!Object.keys(props).length && def.patternProperties) {
    const entryName = `Entry`;
    return `\n    ${entryName}[] value() default {};`;
  }

  // All properties considered optional; defaults are emitted where meaningful
  return Object.entries(props)
    .filter(([_, s]) => !(s.type === "object" && !s.enum && !s.$ref))
    .map(([name, schema]) => {
      const javaType = resolveJavaType(schema);
      const isRef = !!schema.$ref;
      const isArray = schema.type === "array";
      const anyOfRefs = schema.items?.anyOf?.filter((i) => i.$ref) ?? [];
      const isAnyOfArray = isArray && anyOfRefs.length > 0;
      const isArrayRef = isArray && !!schema.items?.$ref;

      let defaultClause = "";
      if (isAnyOfArray) {
        const refName = anyOfRefs[0].$ref!.split("/").pop()!;
        defaultClause = ` default { ${buildDefaultAnnotation(allDefs[refName], refName)} }`;
      } else if (isArrayRef) {
        const refName = schema.items!.$ref!.split("/").pop()!;
        defaultClause = ` default { ${buildDefaultAnnotation(allDefs[refName], refName)} }`;
      } else if (isRef) {
        const refName = schema.$ref!.split("/").pop()!;
        defaultClause = ` default ${buildDefaultAnnotation(allDefs[refName], refName)}`;
      } else if (javaType === "String") {
        const v = typeof schema.default === "string" ? schema.default : "";
        defaultClause = ` default "${v}"`;
      } else if (javaType === "boolean") {
        defaultClause = ` default ${schema.default ?? false}`;
      } else if (javaType === "double") {
        defaultClause = ` default ${schema.default ?? 0}`;
      } else if (isArray) {
        defaultClause = ` default {}`;
      }

      const comment = schema.description ? `    /** ${schema.description.replace(/\n/g, " ")} */\n` : "";
      return `${comment}    ${javaType} ${name}()${defaultClause};`;
    })
    .join("\n\n");
}

function readOrdSpecVersion(): string {
  const envVer = process.env.ORD_SPEC_VERSION;
  if (envVer && envVer.trim()) return envVer.trim();
  try {
    const raw = fs.readFileSync(SPEC_PKG_JSON, "utf8");
    const pkg = JSON.parse(raw);
    return (pkg.version ?? "0.0.0").toString();
  } catch {
    return "0.0.0";
  }
}

function writeOrdSpecInfo(outBaseDir: string, javaPkg: string, version: string): void {
  const pkgDir = path.join(outBaseDir, ...javaPkg.split("."));
  fs.mkdirSync(pkgDir, { recursive: true });

  const java = `package ${javaPkg};

public final class OrdSpecInfo {
  private OrdSpecInfo() {}
  public static final String VERSION = "${version}";
}
`;
  fs.writeFileSync(path.join(pkgDir, "OrdSpecInfo.java"), java, "utf8");

  const metaInf = path.join(outBaseDir, "META-INF");
  fs.mkdirSync(metaInf, { recursive: true });
  fs.writeFileSync(path.join(metaInf, "ord-spec.properties"), `ord.spec.version=${version}\n`, "utf8");
}

// ----- main -----
function run(): void {
  try {
    if (!fs.existsSync(SCHEMA_PATH)) {
      console.error(`Schema not found: ${SCHEMA_PATH}`);
      process.exit(2);
    }

    const raw = fs.readFileSync(SCHEMA_PATH, "utf8");
    const doc = JSON.parse(raw) as { definitions?: Record<string, SchemaDefinition> };
    const defs = doc.definitions ?? {};

    const patternEntries = Object.entries(defs)
      .filter(([_, def]) => def.patternProperties)
      .map(([name, def]) => {
        const schema = Object.values(def.patternProperties!)[0];
        const baseType = resolveJavaType(schema.items ?? { type: "string" });
        const entryName = `${name}Entry`;
        return `
  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ${entryName} {
    String key();
    ${baseType}[] values();
  }`;
      });

    fs.mkdirSync(OUTPUT_DIR, { recursive: true });

    const nested = Object.entries(defs)
      .filter(([_, d]) => d["x-ums-type"] !== "root")
      .map(([name, def]) => {
        const requiredArray = buildRequiredArray(def);
        const prefix = `    String[] requiredFields() ${requiredArray};\n`;
        const originalBody =
          (!def.properties || Object.keys(def.properties).length === 0) && def.patternProperties
            ? `\n    ${name}Entry[] value() default {};`
            : generateProps(def, defs);
        const body = prefix + originalBody;

        return `
  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ${name} {
${body}
  }`;
      });

    const roots = Object.entries(defs)
      .filter(([_, d]) => d["x-ums-type"] === "root")
      .map(([name, def]) => {
        const requiredArray = buildRequiredArray(def);
        const prefix = `    String[] requiredFields() ${requiredArray};\n`;
        const originalBody =
          (!def.properties || Object.keys(def.properties).length === 0) && def.patternProperties
            ? `\n    ${name}Entry[] value() default {};`
            : generateProps(def, defs);
        const body = prefix + originalBody;

        return `
  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ${name} {
${body}
  }`;
      });

    const all = [...patternEntries, ...nested, ...roots].join("\n");
    const content = `package ${JAVA_PACKAGE};

import java.lang.annotation.*;

public interface Ord {${all}

}`;

    const specVersion = readOrdSpecVersion();
    writeOrdSpecInfo(OUTPUT_BASE, JAVA_PACKAGE, specVersion);

    fs.writeFileSync(OUTPUT_FILE, content.trim(), "utf8");
    console.log(`Generated: ${OUTPUT_FILE}`);
  } catch (err) {
    console.error("Annotation generation failed:", err);
    process.exit(1);
  }
}

run();
