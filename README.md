# ORD-Maven Project

This repository contains the **ORD-Maven** project that generates Java annotation interfaces and model classes from the Open Resource Discovery (ORD) specification. It uses GitHub Actions to automate generation, build, and continuous integration (CI) tasks.

---

## Project Overview

The ORD-Maven project is responsible for:

1. **Generating** Java annotation interfaces from generateJavaAnnotations.ts Skript in the ORD specification.
2. **Generating** Java POJOs (models) from Document.schema.json definitions.
3. **Packaging** both artifacts as Maven modules.
4. **Automating** PR creation and auto‑merge via GitHub Actions.

This allows other Java projects to consume up‑to‑date types and models directly from the source specification.

## Getting Started

### Prerequisites

- Java 11+ (JDK)
- Maven 3.6+
- Node.js 18+ (for code generation steps)
- GitHub account with permissions to push and create PRs in this repo

### Clone the Repository

```bash
git clone https://github.tools.sap/CPA/ord-maven.git
cd ord-maven
```

## Generating Code

All code generation is handled by the `ci.yml` workflow:

1. Clones this repo and the ORD specification repo (`ord-spec`).
2. Installs Node.js dependencies and runs `npm run generate` in `ord-spec`.
3. Generates Java annotation interfaces via a TypeScript helper.
4. Downloads and runs `jsonschema2pojo` to generate Java POJOs from `Document.schema.json`.
5. Patches generated model classes to implement `PartialOrdPojo` marker interface.
6. Copies generated sources into `annotations/src/main/java` and `models/src/main/java`.
7. Commits any changes back to the `generated-sources` branch via a pull request.

## Building with Maven

To build both modules locally:

```bash
# Generate sources first (if not running GH Actions locally)
# (skip if .java sources already exist in annotations/ and models/)
cd ord-maven
mvn clean install
```

This command will compile both the annotations and models modules, run tests, and package JARs.

## CI/CD Workflow

All workflows live under `.github/workflows`:

### Workflow Triggers

- \`\` runs daily at midnight UTC and on manual dispatch.
- \`\` runs every 5 minutes (for testing) and on manual dispatch.

### Self‑Hosted Runner

The `ci.yml` job uses a self‑hosted runner labeled `solinas`:

```yaml
runs-on: [self-hosted, solinas]
```

Ensure your org has a healthy runner with these labels.

### Secrets & Permissions

- \`\`: A personal access token with `repo` scopes used to create PRs and enable auto‑merge.
- **Workflow permissions** (in repo settings) must allow write access to `contents` and `pull-requests`.

## Automated Pull Request & Auto‑Merge

1. Regenerates (or updates) source files.
2. Uses [`peter-evans/create-pull-request`](https://github.com/peter-evans/create-pull-request) to open or update a PR on branch `generated-sources`.
3. Uses GitHub’s REST/GraphQL API with `peter-evans/enable-pull-request-automerge` (or a custom curl step) to enable auto‑merge (squash) once all required checks pass.

```yaml
uses: peter-evans/create-pull-request@v7
# …
uses: peter-evans/enable-pull-request-automerge@v2
```

## Branch Protection Rules

Protect `main` by requiring:

- Status check: **CI – Generate Models & Annotations, Build ORD-Java**
- Status check: **CI Check** (if you have a separate build+test workflow)
- Allow auto‑merge when checks pass

Configure under **Settings → Branches → Branch protection rules**.

## Contributing

1. Fork the repository.
2. Create a new feature branch: `feature/my-feature`.
3. Push your changes and open a pull request.
4. Ensure CI workflows pass before merging.

For major changes, please open an issue first to discuss.

## License

This project is licensed under the [Apache License 2.0](LICENSE).

