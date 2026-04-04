// @ts-check
const { configs } = require("@sap/eslint-config");

module.exports = [
  ...configs.recommended,
  {
    languageOptions: {
      parserOptions: {
        project: "./tsconfig.json",
      },
    },
    rules: {
      "@typescript-eslint/no-unnecessary-type-assertion": "off",
    },
  },
];
