import * as fs from "node:fs";

export function readOrdSpecVersion(specPackageJson: string): string {
  return (
    process.env.ORD_SPEC_VERSION?.trim() || JSON.parse(fs.readFileSync(specPackageJson, "utf8")).version || "0.0.0"
  );
}
