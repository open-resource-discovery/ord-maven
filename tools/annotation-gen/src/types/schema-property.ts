export type SchemaProperty = {
  type?: string;
  description?: string;
  default?: unknown;
  enum?: string[];
  items?: SchemaProperty;
  $ref?: string;
  anyOf?: SchemaProperty[];
};
