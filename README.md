# ORD Maven

This repository contains the **ORD Maven** project, which generates Java **annotations** and **models** from the [Open Resource Discovery (ORD) specification](https://github.com/open-resource-discovery/specification).  
Generation, build, and continuous integration (CI) are fully automated via GitHub Actions.

---

## Overview

ORD Maven provides:

1. **Annotation generation** via the TypeScript script in `tools/annotation-gen/src/generateAnnotations.ts`.
2. **Model generation** from `Document.schema.json`.
3. **Modular packaging** as `ord-annotations` and `ord-models`.
4. **Automated PR updates** through GitHub Actions.

This enables Java projects to consume up-to-date annotations and models directly from the ORD specification.

## Prerequisites

- Java 11+ (JDK)
- Maven 3.9+
- Node.js 18+ (for code generation)


## Build & Usage (Local)

Clone the repo and run:

```bash
git clone https://github.com/open-resource-discovery/ord-maven.git
cd ord-maven
mvn clean install
```
This will:
- Run the code generator (tools/annotation-gen) against the ORD specification.
- Build and install the modules ord-annotations and ord-models into your local Maven repository.

## Using as Dependency

### 1. Add the GitHub package maven repository

```xml
<repositories>
  <repository>
    <id>github</id>
      <url>https://maven.pkg.github.com/open-resource-discovery/ord-maven</url>
    </repository>
</repositories>
```

### 2. Add the dependencies

To include the generated artifacts in your Maven project, add the following dependency:

```xml
<dependencies>
  <dependency>
    <groupId>org.openresourcediscovery</groupId>
    <artifactId>annotations</artifactId>
    <version>0.0.1</version>
  </dependency>
</dependencies>
```

## Continuous Integration (CI)

This repository uses **GitHub Actions** to keep the generated code in sync with the upstream [ORD specification](https://github.com/open-resource-discovery/specification).

The CI pipeline runs on each push to `main` and nightly via a scheduled job. It performs the following steps:

1. **Checkout** both this repository and the upstream `specification` repo.
2. **Verify** the presence of the annotated schema (`Document.annotated.schema.json`).
3. **Generate** Java annotation interfaces using the custom generator script (`tools/annotation-gen/src/generateAnnotations.ts`).
4. **Generate** Java models (POJOs) from the specification schemas.
5. **Build** all Maven modules with Java 11 + Maven 3.9.
6. **Open a Pull Request** with the regenerated code (`annotations/` and `models/`), which is auto-merged if checks pass.

This ensures that the published artifacts always reflect the latest version of the ORD specification without requiring manual updates.

## License

This project is licensed under the [Apache License 2.0](LICENSE).

