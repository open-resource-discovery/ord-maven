# ORD Maven

This repository contains the **ORD Maven** project, which generates Java **annotations** and **models** from the [Open Resource Discovery (ORD) specification](https://github.tools.sap/CentralEngineering/open-resource-discovery-specification).  
Generation, build, and continuous integration (CI) are fully automated via GitHub Actions.
---

## Overview

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
- Node.js 18+ (for code generation)

### Clone the Repository

```bash
git clone https://github.tools.sap/CPA/ord-maven.git
cd ord-maven
mvn clean install
```
## Using as Dependency

To include the generated artifacts in your Maven project, add the following dependencies:

```xml
<dependencies>
    <dependency>
        <groupId>org.openresourcediscovery</groupId>
        <artifactId>ord-annotations</artifactId>
        <version>0.0.1-sap-1</version>
    </dependency>

    <dependency>
        <groupId>org.openresourcediscovery</groupId>
        <artifactId>ord-models</artifactId>
        <version>0.0.1-sap-1</version>
    </dependency>
</dependencies>
```

You also need to configure the repository:
```xml
<repositories>
<repository>
<id>annotations-milestones</id>
<name>Milestones Repository</name>
<url>https://int.repositories.cloud.sap/artifactory/deploy-milestones</url>
<releases><enabled>true</enabled></releases>
<snapshots><enabled>true</enabled></snapshots>
</repository>
</repositories>
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

## License

This project is licensed under the [Apache License 2.0](LICENSE).

