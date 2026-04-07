import { SchemaProperty } from "../types/schema-property";

export function resolveJavaType(prop: SchemaProperty = { type: "string" }): string {
  if (prop.$ref) return prop.$ref.split("/").pop()!;

  if (prop.type === "array" && prop.items?.anyOf?.length) {
    const refItem = prop.items.anyOf.find((i) => typeof i.$ref === "string");
    if (refItem?.$ref) return `${refItem.$ref.split("/").pop()}[]`;
  }

  if (prop.type === "array" && typeof prop.items?.$ref === "string") {
    return `${prop.items.$ref.split("/").pop()}[]`;
  }

  switch (prop.type) {
    case "boolean":
      return "boolean";
    case "number":
    case "integer":
      return "double";
    case "array":
      return `${resolveJavaType(prop.items)}[]`;
    default: // covers 'object' and 'string'
      return "String";
  }
}
