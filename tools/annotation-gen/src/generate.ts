import * as fs from "fs";
import * as path from "path";
import assert from "node:assert";

import { SchemaDefinition } from "./types/schema-definition";
import { readOrdSpecVersion } from "./utils/read-ord-spec-version";
import { generateOrdAnnotations } from "./generators/ord-annotations";
import { generateOrdSpecProperties } from "./generators/ord-spec-properties";

/**
 * CLI:
 *   --schema <path to Document.annotated.schema.json>
 *   --outDir <generated sources base dir>
 *   --pkg    <java package for generated annotations>
 *   --specPkg <path to specification's package.json> (optional)
 * Env:
 *   ORD_SPEC_VERSION overrides version read from package.json
 */
const args = new Map<string, string>([
  ["pkg", "org.openresourcediscovery.annotations"],
  ["outDir", "annotations/target/generated-sources"],
  ["specPkg", require.resolve("@open-resource-discovery/specification/package.json")],
  [
    "schema",
    require.resolve("@open-resource-discovery/specification/dist/generated/spec/v1/schemas/Document.schema.json"),
  ],
]);

for (let i = 2; i < process.argv.length; i += 2) {
  const k = process.argv[i]?.replace(/^--/, "");
  const v = process.argv[i + 1];
  if (k && v) args.set(k, v);
}

// ----- main -----
function run(args: Map<string, string>): void {
  const javaPackage = args.get("pkg")!;
  const schemaPath = args.get("schema")!;
  const outputBase = args.get("outDir")!;
  const outputFile = path.join(outputBase, "java", ...javaPackage.split("."), "Ord.java");

  assert(fs.existsSync(schemaPath), `Schema not found: ${schemaPath}`);

  const version = readOrdSpecVersion(args.get("specPkg")!);
  const metaInf = path.join(outputBase, "resources", "META-INF");
  const pkgDir = path.join(outputBase, "java", ...javaPackage.split("."));
  const { definitions = {} } = JSON.parse(fs.readFileSync(schemaPath, "utf8")) as {
    definitions?: Record<string, SchemaDefinition>;
  };

  fs.mkdirSync(pkgDir, { recursive: true });
  fs.mkdirSync(metaInf, { recursive: true });
  fs.mkdirSync(path.dirname(outputFile), { recursive: true });
  fs.writeFileSync(outputFile, generateOrdAnnotations(version, javaPackage, definitions));
  fs.writeFileSync(path.join(metaInf, "ord-spec.properties"), generateOrdSpecProperties(version));

  console.log(`Generated: ${outputFile}`); // eslint-disable-line no-console
}

run(args);
