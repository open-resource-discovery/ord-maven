import { SchemaProperty } from "./schema-property";

export type SchemaDefinition = {
  properties?: Record<string, SchemaProperty>;
  patternProperties?: Record<string, SchemaProperty>;
  required?: string[];
};
