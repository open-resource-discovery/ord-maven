import { SchemaDefinition } from "../types/schema-definition";
import { resolveJavaType } from "../utils/resolve-java-type";
import { resolveName } from "../utils/resolve-name";
import { SchemaProperty } from "../types/schema-property";

const PART_OF_DOCUMENT = 'DocumentReference partOfDocument() default @DocumentReference(name = "ord-document");';
const TOP_LEVEL_FIELDS = Object.freeze(
  new Set([
    "SystemInstance",
    "SystemType",
    "SystemVersion",
    "ApiResource",
    "EventResource",
    "EntityType",
    "Capability",
    "DataProduct",
    "Agent",
    "IntegrationDependency",
    "Vendor",
    "Product",
    "Package",
    "ConsumptionBundle",
    "Group",
    "GroupType",
    "Tombstone",
  ]),
);

function buildRequiredArray(def: SchemaDefinition): string {
  return `{ ${(def.required || []).map((f) => JSON.stringify(f)).join(",")} }`;
}

function generateProperties(name: string, def: SchemaDefinition): string[] {
  if (!def.properties || Object.keys(def.properties).length === 0) {
    return [`${name}Entry[] value() default {};`];
  }

  // All properties considered optional; defaults are emitted where meaningful
  return Object.entries(def.properties)
    .filter(([_, s]) => !(!s.$ref && !s.enum && s.type === "object"))
    .map(([name, schema]) => {
      const javaType = resolveJavaType(schema);

      return `
            /** ${(schema.description || "").replace(/\n/g, " ")} */

            ${javaType} ${resolveName(name)}() default ${generateDefaultValue(javaType, schema)};`;
    });
}

function generateEntry(name: string, definition: SchemaDefinition): string {
  return `
      @Target(ElementType.TYPE)
      @Retention(RetentionPolicy.RUNTIME)
      @interface ${name} {
        ${!TOP_LEVEL_FIELDS.has(name) ? "" : `${PART_OF_DOCUMENT}\n`}
    
        String[] requiredFields() default ${buildRequiredArray(definition)};
    
        ${generateProperties(name, definition).join("\n")}
      }
    
      ${!definition.patternProperties ? "" : generatePatternEntry(name, definition)}`;
}

function generateDefaultValue(javaType: string, schema: SchemaProperty): string {
  if (schema.type === "array") {
    return `{}`;
  }

  if (schema.$ref) {
    return `@${javaType}`;
  }

  switch (javaType) {
    case "double":
      return `${schema.default ?? 0}`;
    case "boolean":
      return `${schema.default ?? false}`;
    case "String":
      return `"${typeof schema.default !== "string" ? "" : schema.default}"`;
    default:
      return "";
  }
}

function generatePatternEntry(name: string, definition: SchemaDefinition): string {
  return `
      @Target(ElementType.TYPE)
      @Retention(RetentionPolicy.RUNTIME)
      @interface ${name}Entry {
        String key();
    
        ${resolveJavaType(Object.values(definition.patternProperties!)[0].items)}[] values();
      }`;
}

export function generateOrdAnnotations(
  version: string,
  javaPackage: string,
  definitions: Record<string, SchemaDefinition>,
): string {
  return `
package ${javaPackage};

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface Ord {

  String VERSION = "${version}";

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.RUNTIME)
  @interface Documents {
    Document[] value();
  }

  @Target(ElementType.TYPE)
  @Repeatable(Documents.class)
  @Retention(RetentionPolicy.RUNTIME)
  @interface Document {
    String name() default "ord-document";

    String description() default "";

    String perspective() default "system-instance";

    String[] policyLevels() default {};

    AccessStrategy[] accessStrategies() default { @AccessStrategy(type = "open") };

    Group[] groups() default {};

    Vendor[] vendors() default { };

    Product[] products() default {};

    Package[] packages() default {};

    GroupType[] groupTypes() default {};

    Tombstone[] tombstones() default {};

    ConsumptionBundle[] consumptionBundles() default {};

    SystemType describedSystemType() default @SystemType;

    SystemVersion describedSystemVersion() default @SystemVersion;

    SystemInstance describedSystemInstance() default @SystemInstance;

  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.RUNTIME)
  @interface DocumentReference {
    String name();
  }

  ${Object.entries(definitions)
    .map(([name, def]) => generateEntry(name, def))
    .join("\n")}
}`;
}
