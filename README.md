[![REUSE status](https://api.reuse.software/badge/github.com/open-resource-discovery/ord-maven)](https://api.reuse.software/info/github.com/open-resource-discovery/ord-maven)
[![CI](https://img.shields.io/github/actions/workflow/status/open-resource-discovery/ord-maven/ci.yml?label=CI)](https://github.com/open-resource-discovery/ord-maven/actions/workflows/ci.yml)
[![Maven version: ord-models](https://img.shields.io/maven-central/v/org.open-resource-discovery/ord-models?label=ord-models)](https://central.sonatype.com/artifact/org.open-resource-discovery/ord-models)
[![Maven version: ord-annotations](https://img.shields.io/maven-central/v/org.open-resource-discovery/ord-annotations?label=ord-annotations)](https://central.sonatype.com/artifact/org.open-resource-discovery/ord-annotations)

# ORD Maven

This repository contains the **ORD Maven** project, which generates Java **annotations** and **models** from the [Open Resource Discovery (ORD) specification](https://github.com/open-resource-discovery/specification).  
Generation, build, and continuous integration (CI) are fully automated via GitHub Actions.

---

## Overview

ORD Maven provides:

1. **Annotation generation** via the script in `scripts/generate-java-annotations`.
2. **Model generation** via the script in `scripts/generate-java-models`.
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
- Run the code generation for ord-models.
- Run the code generation for ord-annotations.
- Build and install the modules ord-annotations and ord-models into your local Maven repository.

## Using as Dependency

To include the generated artifacts in your Maven project, add the following dependencies:

- [ord-models](https://central.sonatype.com/artifact/org.open-resource-discovery/ord-models)
```xml
<project>
    ...
    <dependencies>
        ...
        <dependency>
            <groupId>org.open-resource-discovery</groupId>
            <artifactId>ord-models</artifactId>
        </dependency>
        ...
    </dependencies>
    ...
</project>
```
- [ord-annotations](https://central.sonatype.com/artifact/org.open-resource-discovery/ord-annotations)
```xml
<project>
    ...
    <dependencies>
        ...
        <dependency>
            <groupId>org.open-resource-discovery</groupId>
            <artifactId>ord-annotations</artifactId>
        </dependency>
        ...
    </dependencies>
    ...
</project>
```

You also need to configure the repository in your `settings.xml`:
```xml
<repositories>
    <repository>
        <id>central</id>
        <name>Maven Central Repository</name>
        <url>https://repo1.maven.org/maven2/</url>
        <releases>
            <enabled>true</enabled>
        </releases>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
</repositories>
```

## Continuous Integration (CI)

This repository uses **GitHub Actions** to keep the generated code in sync with the upstream [ORD specification](https://github.com/open-resource-discovery/specification).

The CI pipeline runs on each push to `main`. It performs the following steps:

1. **Checkout** this repository.
4. **Generate** Java models (POJOs) using the script in `scripts/generate-java-models`.
3. **Generate** Java annotation interfaces using the script in `scripts/generate-java-annotations`.
5. **Build** all Maven modules with Java 17+ + Maven 3.9.
6. **Open a Pull Request** with the regenerated code (`annotations/` and `models/`), which is auto-merged if checks pass.

This ensures that the published artifacts always reflect the latest version of the ORD specification without requiring manual updates.

## License

This project is licensed under the [Apache License 2.0](LICENSE).

