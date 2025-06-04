package com.github.openresourcediscovery.annotations;

import java.lang.annotation.*;

public interface Ord {
  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface LabelsEntry {
    String key();
    String[] values();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface DocumentationLabelsEntry {
    String key();
    String[] values();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ConsumptionBundleReference {
    /** The consumption bundle ORD ID (`ConsumptionBundle.ordId`) this reference points to. */
    String ordId();

    /** In case that an API Resource has multiple entry points, this will indicate which entry point should be used by default when discovering this resource from the context of the referenced Consumption Bundle.  MUST NOT be provided for Event Resources, as they don't have entry points. MUST only be provided if the resource has more than one entry point. MUST be in the list of `entryPoints` of the affected resource. */
    String defaultEntryPoint() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface DataProductInputPort {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface DataProductOutputPort {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ApiResourceDefinition {
    /** Type of the API Resource Definition If "custom" is chosen, a customType MUST be provided */
    String type();

    /** If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `type` is set to `custom`. */
    String customType() default "";

    /** The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format. A consuming application can use this information to know which file format parser it needs to use. For example, for OpenAPI 3, it's valid to express the same definition in both YAML and JSON.  If no Media Type is registered for the referenced file, `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.  */
    String mediaType();

    /** [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.  It is RECOMMENDED to provide a relative URL (to base URL). */
    String url();

    /** List of supported access strategies for retrieving metadata from the ORD provider. An ORD Consumer/ORD Aggregator MAY choose any of the strategies.  The access strategies only apply to the metadata access and not the actual API access. The actual access to the APIs for clients is described via Consumption Bundles.  If this property is not provided, the definition URL will be available through the same access strategy as this ORD document. It is RECOMMENDED anyway that the attached metadata definitions are available with the same access strategies, to simplify the aggregator crawling process. */
    AccessStrategy[] accessStrategies() default { @AccessStrategy(type = "") };
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface EventResourceDefinition {
    /** Type of the event resource definition */
    String type();

    /** If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `type` is set to `custom`. */
    String customType() default "";

    /** The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format. A consuming application can use this information to know which file format parser it needs to use. For example, for OpenAPI 3, it's valid to express the same definition in both YAML and JSON.  If no Media Type is registered for the referenced file, `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.  */
    String mediaType();

    /** [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.  It is RECOMMENDED to provide a relative URL (to base URL). */
    String url();

    /** List of supported access strategies for retrieving metadata from the ORD provider. An ORD Consumer/ORD Aggregator MAY choose any of the strategies.  The access strategies only apply to the metadata access and not the actual API access. The actual access to the APIs for clients is described via Consumption Bundles.  If this property is not provided, the definition URL will be available through the same access strategy as this ORD document. It is RECOMMENDED anyway that the attached metadata definitions are available with the same access strategies, to simplify the aggregator crawling process. */
    AccessStrategy[] accessStrategies() default { @AccessStrategy(type = "") };
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface CapabilityDefinition {
    /** Type of the capability resource definition */
    String type();

    /** If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `type` is set to `custom`. */
    String customType() default "";

    /** The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format. A consuming application can use this information to know which file format parser it needs to use. For example, for OpenAPI 3, it's valid to express the same definition in both YAML and JSON.  If no Media Type is registered for the referenced file, `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.  */
    String mediaType();

    /** [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.  It is RECOMMENDED to provide a relative URL (to base URL). */
    String url();

    /** List of supported access strategies for retrieving metadata from the ORD provider. An ORD Consumer/ORD Aggregator MAY choose any of the strategies.  The access strategies only apply to the metadata access and not the actual API access. The actual access to the APIs for clients is described via Consumption Bundles.  If this property is not provided, the definition URL will be available through the same access strategy as this ORD document. It is RECOMMENDED anyway that the attached metadata definitions are available with the same access strategies, to simplify the aggregator crawling process. */
    AccessStrategy[] accessStrategies() default { @AccessStrategy(type = "") };
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface IntegrationAspect {
    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description() default "";

    /** If true, the aspect is mandatory to realize the Integration Dependency it contains. */
    boolean mandatory();

    /** If true, the references resources can be provided by multiple system instances. If not, only one integration target is supported. */
    boolean supportMultipleProviders() default false;

    /** List of API Resource Dependencies. */
    ApiResourceIntegrationAspect[] apiResources() default { @ApiResourceIntegrationAspect(ordId = "") };

    /** List of Event Resource Dependencies. */
    EventResourceIntegrationAspect[] eventResources() default { @EventResourceIntegrationAspect(ordId = "") };
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ApiResourceIntegrationAspect {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** Minimum version of the references resource that the integration requires.  */
    String minVersion() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface EventResourceIntegrationAspect {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** Minimum version of the references resource that the integration requires.  */
    String minVersion() default "";

    /** List of individual events or messages that are sufficient to achieve the aspect. */
    EventResourceIntegrationAspectSubset[] subset() default { @EventResourceIntegrationAspectSubset(eventType = "") };

    /** In case that the event subscriptions are limited to known [system types](../index.md#def-system-type), they can be listed here as [system namespaces](../index.md#system-namespace).  If given, only system types of the defined namespaces are supported as integration partners. If not given, there is no restriction which system type provides the events. */
    String[] systemTypeRestriction() default {};
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface EventResourceIntegrationAspectSubset {
    /** The type ID of the individual event or message.  This MUST be an ID that is understood by the used protocol and resource definition format. E.g. for CloudEvents, the [type](https://github.com/cloudevents/spec/blob/v1.0.2/cloudevents/spec.md#type) can be used. */
    String eventType();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ChangelogEntry {
    /** Full version number that corresponds to the `version` that is described by the changelog entry.  Ideally it follows the [Semantic Versioning 2.0.0](https://semver.org/) standard, but since it should reflect the actual version string / scheme used, this is not a mandatory requirement. */
    String version();

    /** The `releaseStatus` specifies the stability of the resource and its external contract. */
    String releaseStatus();

    /** Date of change, without time or timezone information.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String date();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description() default "";

    /** Optional [URL](https://tools.ietf.org/html/rfc3986) that links to a more detailed changelog entry.  The link target MUST be absolute and SHOULD be openly accessible. */
    String url() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Link {
    /** Human readable title of the link.  MUST be unique within the collection of links provided. */
    String title();

    /** [URL](https://tools.ietf.org/html/rfc3986) of the link.  The link target MUST be absolute and SHOULD be openly accessible. */
    String url();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown) */
    String description() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface PackageLink {
    String type();

    /** If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `type` is set to `custom`. */
    String customType() default "";

    /** [URL](https://tools.ietf.org/html/rfc3986) to the PackageLink.  The link target MUST be absolute and SHOULD be openly accessible. */
    String url();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface APIEventResourceLink {
    /** See also: [WADG0001 WebAPI type extension](https://webapi-discovery.github.io/rfcs/rfc0001.html#webapiactions) */
    String type();

    /** If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `type` is set to `custom`. */
    String customType() default "";

    /** [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the API or Event Resource Link.  The link target SHOULD be absolute and SHOULD be openly accessible. If a relative link is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl). */
    String url();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface DataProductLink {
    String type();

    /** If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `type` is set to `custom`. */
    String customType() default "";

    /** [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the Data Product Link.  The link target SHOULD be absolute and SHOULD be openly accessible. If a relative link is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl). */
    String url();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface SystemInstance {
    /** Optional [base URL](../index.md#def-base-url) of the **system instance**. By providing the base URL, relative URLs in the document are resolved relative to it.  The `baseUrl` MUST not contain a leading slash.  MUST be provided if the base URL is not known to the ORD aggregators. MUST be provided when the document needs to be fully self contained, e.g. when used for manual imports. */
    String baseUrl() default "";

    /** Optional local ID for the system instance, as known by the described system.  In case of multi-tenant systems, it is equivalent to the local tenant id. */
    String localId() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface SystemType {
    /** The system namespace is a unique identifier for the system type. It is used to reference the system type in the ORD. */
    String systemNamespace() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface SystemVersion {
    /** The version number of the system instance (run-time) or the version of the described static system type.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. */
    String version() default "";

    /** Human-readable title of the system version. */
    String title() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface AccessStrategy {
    /** Defines the authentication/authorization strategy through which the referenced `resourceDefinitions` are accessible. */
    String type();

    /** If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `type` is set to `custom`. */
    String customType() default "";

    /** Human-readable description about how the access is set up, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  MUST only be provided if `type` is set to `custom`. */
    String customDescription() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface CredentialExchangeStrategy {
    /** The type of credential exchange strategy. */
    String type();

    /** If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `type` is set to `custom`. */
    String customType() default "";

    /** Human-readable description about how the credential exchange is achieved, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  MUST only be provided if `type` is set to `custom`. */
    String customDescription() default "";

    /** [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the credential exchange callback endpoint.  This allows requesting a set of credentials that can be used for consuming all the APIs and Events that are part of the bundle.  The interface contract/protocol is dependent and defined by the chosen `type`.  Whenever a client wants to consume a resource within a particular bundle, this endpoint can be called to obtain the credentials that this client can use.  The returned credentials MUST be valid for all resources that are part of the respective bundle. The endpoint SHOULD return a different set of credentials on each invocation. */
    String callbackUrl() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Labels {

    LabelsEntry[] value() default {};
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface DocumentationLabels {

    DocumentationLabelsEntry[] value() default {};
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Extensible {
    /** This property defines whether the resource is extensible.  **Not extensible** means that the data model of the resource (i.e. API or event) cannot be extended with custom fields. **Manually extensible** means that in addition to defining a custom field, manual activities to include the field in the data model of the resource (i.e. API or event) are required. E.g. using a specific mapping tool or by selecting the resource in the data model extension tool. **Automatically extensible** means that after defining a custom field in the local domain model, the resource (i.e. API or event) is automatically extended as part of the default extension field definition. */
    String supported();

    /** A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  This description may contain detailed steps on how to extend the API. Links to external resources can be provided within the description as markdown links.  This description MUST be provided if `supported` is set to `manual` or `automatic`. */
    String description() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface EntityTypeMapping {
    /** List of selectors for API models within an API Resource. If multiple selectors are given, every selected API model maps to the entity type target(s). If omitted, the complete API resource will be mapped to the `entityTypeTargets` (less specific).  Multiple selectors can be useful, e.g. with a CRUD REST API, to combine the similar API models.  Depending on the chosen API protocol and the available resource definition formats, different kind of selectors need to be used. */
    ApiModelSelectorOData[] apiModelSelectors() default { @ApiModelSelectorOData(type = "", entitySetName = "") };

    /** List of entity types the ORD resource maps to. If `apiModelSelectors` are given, the mapping is more precise by also pointing to the specific model in the API.  If multiple entity types are defined as the mapping target, all of them can be at least partially mapped to the source API model(s).  Entity types can be referenced using either using an [ORD ID](../../spec-v1/#ord-id) or a [Correlation ID](../../spec-v1/#correlation-id). */
    EntityTypeOrdIdTarget[] entityTypeTargets() default { @EntityTypeOrdIdTarget(ordId = "") };
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ApiModelSelectorOData {
    /** The type for OData selectors is fixed to `odata`. */
    String type();

    /** OData entity set name.  As defined in the EDMX, e.g. `<EntitySet Name="AttachmentContent">`. */
    String entitySetName();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ApiModelSelectorJsonPointer {
    /** The type for generic JSON Pointer selectors is fixed to `json-pointer`. */
    String type();

    /** JSON Pointer to the entity type schema / description within the resource definition format.  MUST be a valid JSON Pointer according to [RFC6901](https://datatracker.ietf.org/doc/html/rfc6901).  The JSON pointers MUST point to each instance of the mapped entity type in the resource definition file, BEFORE `$ref` JSON Schema References are resolved (dereferenced). */
    String jsonPointer();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface EntityTypeOrdIdTarget {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface EntityTypeCorrelationIdTarget {
    String correlationId();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface RelatedEntityType {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ExposedEntityType {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Tombstone {
    /** [ORD ID](../index.md#ord-id) of the ORD resource/taxonomy that has been removed. */
    String ordId() default "";

    /** Group ID of the group that has been removed. */
    String groupId() default "";

    /** Group Type ID of the group type that has been removed. */
    String groupTypeId() default "";

    /** The date when the ORD resource/taxonomy was removed. This is related to the `sunsetDate` that can be set to announce a resource as deprecated *before* the removal and setting of a tombstone.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String removalDate();

    /** Optional description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description of a Tombstone MAY be added to the changelog of the removed resource by an ORD aggregator. */
    String description() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Package {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** The locally unique ID under which this resource can be looked up / resolved in the described system itself. Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.  It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID. But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID. */
    String localId() default "";

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description();

    /** The complete [SemVer](https://semver.org/) version string.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. It SHOULD be changed if the ORD information or referenced resource definitions changed. It SHOULD express minor and patch changes that don't lead to incompatible changes.  When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical. In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.  If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`. The `version` MUST not be bumped for changes in extensions.  The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.  Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly. For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented. */
    String version();

    /** The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with. Depending on the chosen policy level, additional expectations and validations rules will be applied.  The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  */
    String policyLevel() default "none";

    /** If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided. The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.  MUST only be provided if `policyLevel` is set to `custom`. MUST be a valid [Specification ID](../index.md#specification-id). */
    String customPolicyLevel() default "";

    /** A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with. For each chosen policy level, additional expectations and validations rules will be applied.  Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  A policy level MUST be a valid [Specification ID](../index.md#specification-id). */
    String[] policyLevels() default {};

    /** Links with semantic meaning that are specific to packages. */
    PackageLink[] packageLinks() default { @PackageLink(type = "", url = "") };

    /** Generic links with arbitrary meaning and content.  `packageLinks` MUST be preferred if applicable. */
    Link[] links() default { @Link(title = "", url = "") };

    /** Standardized identifier for the license. It MUST conform to the [SPDX License List](https://spdx.org/licenses). */
    String licenseType() default "";

    /** Optional information that should be provided when creating a support ticket for the resources bundled in this package. This can for example be a "component" name that needs to be chosen in the support portal.  Notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  Please also note that if you want to provide link(s) where you can find support information, you can use `packageLinks` with a link of type `support`. */
    String supportInfo() default "";

    /** Vendor / organization that is the creator (or responsible party) of the resources that are part of the `Package`.  MUST be a valid reference to a [Vendor](#vendor) ORD ID.  MUST be set to `customer:vendor:Customer:` if the contents of the package are created by the customer / user.  MUST be set to a registered partner vendor, if the contents of the package are created by a partner / third party. */
    String vendor();

    /** List of products the resources of the package are a part of.  MUST be a valid reference to a [Product](#product) ORD ID.  `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] partOfProducts() default {};

    /** List of countries that the package resources are applicable to.  MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).  `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] countries() default {};

    /** List of line of business tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  `lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] lineOfBusiness() default {};

    /** List of industry tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  `industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] industry() default {};

    /** If provided, all resources that are part of this package can only run on the listed runtime.  MUST be a valid [system namespace](../index.md#system-namespace). */
    String runtimeRestriction() default "";

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ConsumptionBundle {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** The locally unique ID under which this resource can be looked up / resolved in the described system itself. Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.  It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID. But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID. */
    String localId() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription() default "";

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description() default "";

    /** The complete [SemVer](https://semver.org/) version string.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. It SHOULD be changed if the ORD information or referenced resource definitions changed. It SHOULD express minor and patch changes that don't lead to incompatible changes.  When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical. In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.  If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`. The `version` MUST not be bumped for changes in extensions.  The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.  Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly. For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented. */
    String version() default "";

    /** Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).  When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time. Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.  If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.  Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators. */
    String lastUpdate() default "";

    /** The visibility states who is allowed to "see" the described resource or capability. */
    String visibility() default "";

    /** Defines the supported strategies for how the consumption credentials can be exchanged.  Ideally, the system type supports a strategy that can automate the exchange. */
    CredentialExchangeStrategy[] credentialExchangeStrategies() default { @CredentialExchangeStrategy(type = "") };

    /** Generic links with arbitrary meaning and content. */
    Link[] links() default { @Link(title = "", url = "") };

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ApiResource {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** The locally unique ID under which this resource can be looked up / resolved in the described system itself. Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.  It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID. But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID. */
    String localId() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description();

    /** Defines which Package the resource is part of.  MUST be a valid reference to a [Package](#package) ORD ID.  Every resource MUST be part of one package. */
    String partOfPackage();

    /** Defines which groups the resource is assigned to.  The property is optional, but if given the value MUST be an array of valid Group IDs.  Groups are a lightweight custom taxonomy concept. They express a "part of" relationship to the chosen group concept. If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.  All resources that share the same group ID assignment are effectively grouped together. */
    String[] partOfGroups() default {};

    /** List of references to the consumption bundles in this resource belongs to.  MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.  An API resource SHOULD be associated to one or multiple consumption bundles, if it is of direction `inbound` or `mixed`. Some ORD consumer use cases MAY depend on an association to a consumption bundle. If none is given, the resource may not appear as it's unknown how it can be consumed.  If a resource has no direct incoming consumption characteristics: - MUST NOT assign consumption bundle to API or Event resources with `direction`: `outbound` (no inbound consumption) - MUST NOT assign consumption bundle if resource is not accessible directly, but only via intermediaries like event brokers or gateways.   - In this case the intermediary SHOULD describe the consumption bundle instead (potentially also re-describing the resources as well). */
    ConsumptionBundleReference[] partOfConsumptionBundles() default { @ConsumptionBundleReference(ordId = "") };

    /** References the default consumption bundle to use for this resource.  MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.  Can be used by clients to make a deterministic and preferred choice when multiple options are available.  The value MUST be an existing option in the corresponding `partOfConsumptionBundles` array. */
    String defaultConsumptionBundle() default "";

    /** List of products the resources of the package are a part of.  MUST be a valid reference to a [Product](#product) ORD ID.  `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] partOfProducts() default {};

    /** The complete [SemVer](https://semver.org/) version string.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. It SHOULD be changed if the ORD information or referenced resource definitions changed. It SHOULD express minor and patch changes that don't lead to incompatible changes.  When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical. In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.  If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`. The `version` MUST not be bumped for changes in extensions.  The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.  Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly. For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented. */
    String version();

    /** Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).  When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time. Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.  If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.  Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators. */
    String lastUpdate() default "";

    /** The visibility states who is allowed to "see" the described resource or capability. */
    String visibility();

    /** The `releaseStatus` specifies the stability of the resource and its external contract. */
    String releaseStatus();

    /** Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so. This can happen either because it has not been setup for use or disabled by an admin / user.  If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance aware perspective.  This property can only reflect the knowledge of the described system instance itself. Outside factors for availability can't need to be considered (e.g. network connectivity, middlewares).  A disabled resource MAY skip describing its resource definitions.  */
    boolean disabled() default false;

    /** The resource has been introduced in the given [system version](../index.md#def-system-version). This implies that the resource is only available if the system instance is of at least that system version. */
    String minSystemVersion() default "";

    /** The deprecation date defines when the resource has been set as deprecated. This is not to be confused with the `sunsetDate` which defines when the resource will be actually decommissioned / removed.  If the `releaseStatus` is set to `deprecated`, the `deprecationDate` SHOULD be provided.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String deprecationDate() default "";

    /** The sunset date defines when the resource is scheduled to be decommissioned/removed.  If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known). Once the sunset date is known and ready to be communicated externally, it MUST be provided here.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String sunsetDate() default "";

    /** The successor resource(s).  MUST be a valid reference to an ORD ID.  If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists. If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`. */
    String[] successors() default {};

    /** Contains changelog entries that summarize changes with special regards to version and releaseStatus */
    ChangelogEntry[] changelogEntries() default { @ChangelogEntry(version = "", releaseStatus = "", date = "") };

    /** List of [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the target host.  If the API resource can be accessed through an entry point, it MUST be described here.  The list of entry points MUST not include duplicates. If multiple entry points are provided they MUST be arbitrarily exchangeable without effects. This means that the URLs are just an alias to each other and the `resourceDefinitions` apply to all entry points equally. In case of multiple entry points it is RECOMMENDED to provide a `defaultEntryPoint` through `partOfConsumptionBundles`. The entry point URLs SHOULD match with the target host(s) in the resource definition files (e.g. OpenAPI `servers`). If there is no match, the information in ORD takes precedence.  **Provider View:** If the URL is relative to the system that describes the ORD information, it is RECOMMENDED to use relative references and (if known) to provide the `describedSystemInstance`.`baseUrl`. If the URL is not relative to the described system instance [base URL](../index.md#def-base-url), a full URL MUST be provided.  **Consumer View**: When fetching the information from an ORD Aggregator, the consumer MAY rely on receiving full URLs. */
    String[] entryPoints() default {};

    /** Direction of the API Resource consumption. If not provided, "inbound" is assumed.  In case of SOAP APIs, the direction is already indicated through the `apiProtocol`, making this property redundant and optional. But if it is provided, it MUST not be in contradiction with the `apiProtocol` direction. */
    String direction() default "inbound";

    /** API Protocol including the protocol version if applicable */
    String apiProtocol();

    /** List of available machine-readable definitions, which describe the resource or capability in detail.  Each definition is to be understood as an alternative description format, describing the same resource / capability. As a consequence the same definition type MUST NOT be provided more than once.  It is RECOMMENDED to provide the definitions as they enable machine-readable use cases. If the definitions are added or changed, the `version` MUST be incremented. An ORD aggregator MAY only (re)fetch the definitions again when the `version` was incremented. */
    ApiResourceDefinition[] resourceDefinitions() default { @ApiResourceDefinition(type = "", mediaType = "", url = "") };

    /** Declares this API to be a valid implementation of an externally standardized API contract, sub-protocol or protocol variant.  All APIs that share the same implementation standard MAY be treated the same or similar by a consumer client. */
    String implementationStandard() default "";

    /** If the fixed `implementationStandard` values need to be extended, an arbitrary `customImplementationStandard` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `implementationStandard` is set to `custom`. */
    String customImplementationStandard() default "";

    /** Full description of the custom implementation standard, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  MUST only be provided if `implementationStandard` is set to `custom`.  SHOULD contain documentation and links that describe the used standard. */
    String customImplementationStandardDescription() default "";

    /** A reference to the interface (API contract) that this API implements. Serves as a declaration of compatible implementation of API contract, effectively functioning as an "implementationOf" relationship.  MUST be a valid reference to an (usually external) [API Resource](#api-resource) ORD ID.  All APIs that share the same `compatibleWith` value MAY be treated the same or similar by a consumer client. */
    String[] compatibleWith() default {};

    /** Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components. */
    String responsible() default "";

    /** List of use cases (types) how the resource is meant to be used for.  This helps consumers better to understand which use cases had been in mind by the provider and are therefore explicitly supported. This is obviously described from a provider perspective, but stating what consumer use cases it potentially supports. As it's not possible to create a list of options that are mutually exclusive, all options that apply should be provided.  If no array is defined, it is assumed that this information is not provided. */
    String[] supportedUseCases() default {};

    /** Define from where the API resource can be used and accessed */
    String usage() default "external";

    /** Describes mappings between the API Models of the described resource to the underlying, conceptual entity types. */
    EntityTypeMapping[] entityTypeMappings() default { @EntityTypeMapping(entityTypeTargets = {}) };

    /** Optional list of [entity types](#entity-type) that are exposed by the resource.  This replaces `entityTypeMappings`. If both is given, the `exposedEntityTypes` wins.  MUST be a valid reference to an [EntityType](#entity-type) ORD ID. */
    ExposedEntityType[] exposedEntityTypes() default { @ExposedEntityType(ordId = "") };

    /** Links with semantic meaning that are specific to API Resources. */
    APIEventResourceLink[] apiResourceLinks() default { @APIEventResourceLink(url = "", type = "") };

    /** Generic Links with arbitrary meaning and content.  If applicable, `apiResourceLinks` MUST be used instead of generic `links`. */
    Link[] links() default { @Link(title = "", url = "") };

    /** Describes extensibility (by customers or partners) of this resource. Extensibility usually happens at run-time by the end-users. Extensions can be field or entity extensions that come on top of the baseline contract.  Changes in extensions do not lead to an increase in the `version`, but MUST lead to an updated `lastUpdate` date.  Since the extensions are managed by the customer or a partner, whether those changes are compatible or not is not guaranteed by the base contract of the resource. */
    Extensible extensible() default @Extensible(supported = "");

    /** List of countries that the package resources are applicable to.  MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).  `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] countries() default {};

    /** List of line of business tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  `lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] lineOfBusiness() default {};

    /** List of industry tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  `industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] industry() default {};

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();

    /** The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with. Depending on the chosen policy level, additional expectations and validations rules will be applied.  The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  */
    String policyLevel() default "none";

    /** If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided. The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.  MUST only be provided if `policyLevel` is set to `custom`. MUST be a valid [Specification ID](../index.md#specification-id). */
    String customPolicyLevel() default "";

    /** A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with. For each chosen policy level, additional expectations and validations rules will be applied.  Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  A policy level MUST be a valid [Specification ID](../index.md#specification-id). */
    String[] policyLevels() default {};

    /** Defines whether this ORD resource is **system instance aware**. This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.  If this behavior applies, `systemInstanceAware` MUST be set to true. An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions, not just once per system type, but once per **system instance**. */
    boolean systemInstanceAware() default false;
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface EventResource {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** The locally unique ID under which this resource can be looked up / resolved in the described system itself. Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.  It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID. But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID. */
    String localId() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description();

    /** Defines which Package the resource is part of.  MUST be a valid reference to a [Package](#package) ORD ID.  Every resource MUST be part of one package. */
    String partOfPackage();

    /** Defines which groups the resource is assigned to.  The property is optional, but if given the value MUST be an array of valid Group IDs.  Groups are a lightweight custom taxonomy concept. They express a "part of" relationship to the chosen group concept. If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.  All resources that share the same group ID assignment are effectively grouped together. */
    String[] partOfGroups() default {};

    /** List of references to the consumption bundles in this resource belongs to.  MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.  An API resource SHOULD be associated to one or multiple consumption bundles, if it is of direction `inbound` or `mixed`. Some ORD consumer use cases MAY depend on an association to a consumption bundle. If none is given, the resource may not appear as it's unknown how it can be consumed.  If a resource has no direct incoming consumption characteristics: - MUST NOT assign consumption bundle to API or Event resources with `direction`: `outbound` (no inbound consumption) - MUST NOT assign consumption bundle if resource is not accessible directly, but only via intermediaries like event brokers or gateways.   - In this case the intermediary SHOULD describe the consumption bundle instead (potentially also re-describing the resources as well). */
    ConsumptionBundleReference[] partOfConsumptionBundles() default { @ConsumptionBundleReference(ordId = "") };

    /** References the default consumption bundle to use for this resource.  MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.  Can be used by clients to make a deterministic and preferred choice when multiple options are available.  The value MUST be an existing option in the corresponding `partOfConsumptionBundles` array. */
    String defaultConsumptionBundle() default "";

    /** List of products the resources of the package are a part of.  MUST be a valid reference to a [Product](#product) ORD ID.  `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] partOfProducts() default {};

    /** The complete [SemVer](https://semver.org/) version string.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. It SHOULD be changed if the ORD information or referenced resource definitions changed. It SHOULD express minor and patch changes that don't lead to incompatible changes.  When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical. In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.  If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`. The `version` MUST not be bumped for changes in extensions.  The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.  Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly. For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented. */
    String version();

    /** Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).  When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time. Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.  If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.  Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators. */
    String lastUpdate() default "";

    /** The visibility states who is allowed to "see" the described resource or capability. */
    String visibility();

    /** The `releaseStatus` specifies the stability of the resource and its external contract. */
    String releaseStatus();

    /** Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so. This can happen either because it has not been setup for use or disabled by an admin / user.  If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance aware perspective.  This property can only reflect the knowledge of the described system instance itself. Outside factors for availability can't need to be considered (e.g. network connectivity, middlewares).  A disabled resource MAY skip describing its resource definitions.  */
    boolean disabled() default false;

    /** The resource has been introduced in the given [system version](../index.md#def-system-version). This implies that the resource is only available if the system instance is of at least that system version. */
    String minSystemVersion() default "";

    /** The deprecation date defines when the resource has been set as deprecated. This is not to be confused with the `sunsetDate` which defines when the resource will be actually decommissioned / removed.  If the `releaseStatus` is set to `deprecated`, the `deprecationDate` SHOULD be provided.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String deprecationDate() default "";

    /** The sunset date defines when the resource is scheduled to be decommissioned/removed.  If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known). Once the sunset date is known and ready to be communicated externally, it MUST be provided here.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String sunsetDate() default "";

    /** The successor resource(s).  MUST be a valid reference to an ORD ID.  If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists. If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`. */
    String[] successors() default {};

    /** Contains changelog entries that summarize changes with special regards to version and releaseStatus */
    ChangelogEntry[] changelogEntries() default { @ChangelogEntry(version = "", releaseStatus = "", date = "") };

    /** List of available machine-readable definitions, which describe the resource or capability in detail.  Each definition is to be understood as an alternative description format, describing the same resource / capability. As a consequence the same definition type MUST NOT be provided more than once.  It is RECOMMENDED to provide the definitions as they enable machine-readable use cases. If the definitions are added or changed, the `version` MUST be incremented. An ORD aggregator MAY only (re)fetch the definitions again when the `version` was incremented. */
    EventResourceDefinition[] resourceDefinitions() default { @EventResourceDefinition(type = "", mediaType = "", url = "") };

    /** Declares this EventResource to be a valid implementation of a standardized or shared contract.  All implementations of the same implementation standard MAY be treated the same by a consumer. However, there MAY be differences in the access strategy, and compatible customizations by the implementer. The implementation standard MAY define the role of the implementor (producer, consumer, both) and how it is determined.  As of now, only custom implementation standards are supported. */
    String implementationStandard() default "";

    /** If the fixed `implementationStandard` values need to be extended, an arbitrary `customImplementationStandard` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `implementationStandard` is set to `custom`. */
    String customImplementationStandard() default "";

    /** Full description of the custom implementation standard, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  MUST only be provided if `implementationStandard` is set to `custom`.  SHOULD contain documentation and links that describe the used standard. */
    String customImplementationStandardDescription() default "";

    /** Declares this event resource is a compatible implementation of the referenced contract. This is also sometimes known as [Service Provider Interface](https://en.wikipedia.org/wiki/Service_provider_interface).  MUST be a valid reference to an (usually external) [Event Resource](#event-resource) ORD ID.  All event resources that share the same `compatibleWith` value MAY be treated the same or similar by a consumer client. */
    String[] compatibleWith() default {};

    /** Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components. */
    String responsible() default "";

    /** Describes mappings between the API Models of the described resource to the underlying, conceptual entity types. */
    EntityTypeMapping[] entityTypeMappings() default { @EntityTypeMapping(entityTypeTargets = {}) };

    /** Optional list of [entity types](#entity-type) that are exposed by the resource.  This replaces `entityTypeMappings`. If both is given, the `exposedEntityTypes` wins.  MUST be a valid reference to an [EntityType](#entity-type) ORD ID. */
    ExposedEntityType[] exposedEntityTypes() default { @ExposedEntityType(ordId = "") };

    /** Links with semantic meaning that are specific to event resources.  If applicable, `eventResourceLinks` MUST be used instead of generic `links`. */
    APIEventResourceLink[] eventResourceLinks() default { @APIEventResourceLink(url = "", type = "") };

    /** Generic Links with arbitrary meaning and content. */
    Link[] links() default { @Link(title = "", url = "") };

    /** Describes extensibility (by customers or partners) of this resource. Extensibility usually happens at run-time by the end-users. Extensions can be field or entity extensions that come on top of the baseline contract.  Changes in extensions do not lead to an increase in the `version`, but MUST lead to an updated `lastUpdate` date.  Since the extensions are managed by the customer or a partner, whether those changes are compatible or not is not guaranteed by the base contract of the resource. */
    Extensible extensible() default @Extensible(supported = "");

    /** List of countries that the package resources are applicable to.  MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).  `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] countries() default {};

    /** List of line of business tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  `lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] lineOfBusiness() default {};

    /** List of industry tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  `industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] industry() default {};

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();

    /** The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with. Depending on the chosen policy level, additional expectations and validations rules will be applied.  The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  */
    String policyLevel() default "none";

    /** If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided. The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.  MUST only be provided if `policyLevel` is set to `custom`. MUST be a valid [Specification ID](../index.md#specification-id). */
    String customPolicyLevel() default "";

    /** A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with. For each chosen policy level, additional expectations and validations rules will be applied.  Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  A policy level MUST be a valid [Specification ID](../index.md#specification-id). */
    String[] policyLevels() default {};

    /** Defines whether this ORD resource is **system instance aware**. This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.  If this behavior applies, `systemInstanceAware` MUST be set to true. An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions, not just once per system type, but once per **system instance**. */
    boolean systemInstanceAware() default false;
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface EntityType {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** The locally unique ID under which this resource can be looked up / resolved in the described system itself. Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.  It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID. But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID. */
    String localId();

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription() default "";

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description() default "";

    /** Defines which Package the resource is part of.  MUST be a valid reference to a [Package](#package) ORD ID.  Every resource MUST be part of one package. */
    String partOfPackage();

    /** Defines which groups the resource is assigned to.  The property is optional, but if given the value MUST be an array of valid Group IDs.  Groups are a lightweight custom taxonomy concept. They express a "part of" relationship to the chosen group concept. If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.  All resources that share the same group ID assignment are effectively grouped together. */
    String[] partOfGroups() default {};

    /** List of products the resources of the package are a part of.  MUST be a valid reference to a [Product](#product) ORD ID.  `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] partOfProducts() default {};

    /** The complete [SemVer](https://semver.org/) version string.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. It SHOULD be changed if the ORD information or referenced resource definitions changed. It SHOULD express minor and patch changes that don't lead to incompatible changes.  When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical. In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.  If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`. The `version` MUST not be bumped for changes in extensions.  The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.  Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly. For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented. */
    String version();

    /** Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).  When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time. Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.  If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.  Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators. */
    String lastUpdate() default "";

    /** The visibility states who is allowed to "see" the described resource or capability. */
    String visibility();

    /** The `releaseStatus` specifies the stability of the resource and its external contract. */
    String releaseStatus();

    /** The deprecation date defines when the resource has been set as deprecated. This is not to be confused with the `sunsetDate` which defines when the resource will be actually decommissioned / removed.  If the `releaseStatus` is set to `deprecated`, the `deprecationDate` SHOULD be provided.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String deprecationDate() default "";

    /** The sunset date defines when the resource is scheduled to be decommissioned/removed.  If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known). Once the sunset date is known and ready to be communicated externally, it MUST be provided here.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String sunsetDate() default "";

    /** The successor resource(s).  MUST be a valid reference to an ORD ID.  If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists. If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`. */
    String[] successors() default {};

    /** Contains changelog entries that summarize changes with special regards to version and releaseStatus */
    ChangelogEntry[] changelogEntries() default { @ChangelogEntry(version = "", releaseStatus = "", date = "") };

    /** Defining the abstraction level of the entity type using the DDD terminology.  In Domain-Driven Design, there is a concept of entities and aggregates. There are root entities which may contain further sub entities by composition. The complete "package" is then called an aggregate, which gets its name and identity from the root entity. An aggregate is a cluster of domain objects that can be treated as a single unit. The root is the entity that is referenced from outside the aggregate. There must be only one root per aggregate. The root ensures the integrity of the aggregate. A sub entity is any other non-root entity in the aggregate.  Source, see [Martin Fowler on DDD Aggregate](https://martinfowler.com/bliki/DDD_Aggregate.html) */
    String level();

    /** States that this Entity Type is related to another Entity Type.  Usually this happens if there are similar conceptual entity types across different namespaces. */
    RelatedEntityType[] relatedEntityTypes() default { @RelatedEntityType(ordId = "") };

    /** Generic Links with arbitrary meaning and content. */
    Link[] links() default { @Link(title = "", url = "") };

    /** Describes extensibility (by customers or partners) of this resource. Extensibility usually happens at run-time by the end-users. Extensions can be field or entity extensions that come on top of the baseline contract.  Changes in extensions do not lead to an increase in the `version`, but MUST lead to an updated `lastUpdate` date.  Since the extensions are managed by the customer or a partner, whether those changes are compatible or not is not guaranteed by the base contract of the resource. */
    Extensible extensible() default @Extensible(supported = "");

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();

    /** The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with. Depending on the chosen policy level, additional expectations and validations rules will be applied.  The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  */
    String policyLevel() default "none";

    /** If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided. The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.  MUST only be provided if `policyLevel` is set to `custom`. MUST be a valid [Specification ID](../index.md#specification-id). */
    String customPolicyLevel() default "";

    /** A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with. For each chosen policy level, additional expectations and validations rules will be applied.  Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  A policy level MUST be a valid [Specification ID](../index.md#specification-id). */
    String[] policyLevels() default {};

    /** Defines whether this ORD resource is **system instance aware**. This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.  If this behavior applies, `systemInstanceAware` MUST be set to true. An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions, not just once per system type, but once per **system instance**. */
    boolean systemInstanceAware() default false;
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface DataProduct {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** The locally unique ID under which this resource can be looked up / resolved in the described system itself. Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.  It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID. But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID. */
    String localId() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description();

    /** Defines which Package the resource is part of.  MUST be a valid reference to a [Package](#package) ORD ID.  Every resource MUST be part of one package. */
    String partOfPackage();

    /** Defines which groups the resource is assigned to.  The property is optional, but if given the value MUST be an array of valid Group IDs.  Groups are a lightweight custom taxonomy concept. They express a "part of" relationship to the chosen group concept. If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.  All resources that share the same group ID assignment are effectively grouped together. */
    String[] partOfGroups() default {};

    /** List of products this Data Product is a part of or is related to, its e.g. data source systems.  MUST be a valid reference to a [Product](#product) ORD ID.  `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] partOfProducts() default {};

    /** The complete [SemVer](https://semver.org/) version string.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. It SHOULD be changed if the ORD information or referenced resource definitions changed. It SHOULD express minor and patch changes that don't lead to incompatible changes.  When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical. In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.  If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`. The `version` MUST not be bumped for changes in extensions.  The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.  Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly. For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented. */
    String version();

    /** Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).  When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time. Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.  If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.  Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators. */
    String lastUpdate() default "";

    /** The visibility/exposure of the data product. A public data product might have private APIs for trusted consumers therefore the having the property on data product */
    String visibility();

    /** The `releaseStatus` specifies the stability towards incompatible changes in the future. In the context of data products, it it covers only properties on the data product level. APIs that are part of the input and output ports have their own independent `releaseStatus` and `version`. */
    String releaseStatus();

    /** Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so. This can happen either because it has not been setup for use or disabled by an admin / user.  If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance aware perspective.  This property can only reflect the knowledge of the described system instance itself. Outside factors for availability can't need to be considered (e.g. network connectivity, middlewares).  A disabled resource MAY skip describing its resource definitions.  */
    boolean disabled() default false;

    /** The resource has been introduced in the given [system version](../index.md#def-system-version). This implies that the resource is only available if the system instance is of at least that system version. */
    String minSystemVersion() default "";

    /** Lifecycle status of the Data Product as a whole.  MUST be provided when describing the system-instance aware (run-time) perspective. SHOULD NOT be provided in static (design-time) perspective. Static aggregators MUST ignore this property. */
    String lifecycleStatus() default "";

    /** The deprecation date defines when the resource has been set as deprecated. This is not to be confused with the `sunsetDate` which defines when the resource will be actually decommissioned / removed.  If the `releaseStatus` is set to `deprecated`, the `deprecationDate` SHOULD be provided.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String deprecationDate() default "";

    /** The sunset date defines when the resource is scheduled to be decommissioned/removed.  If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known). Once the sunset date is known and ready to be communicated externally, it MUST be provided here.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String sunsetDate() default "";

    /** The successor resource(s).  MUST be a valid reference to an ORD ID.  If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists. If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`. */
    String[] successors() default {};

    /** Contains changelog entries that summarize changes with special regards to version and releaseStatus */
    ChangelogEntry[] changelogEntries() default { @ChangelogEntry(version = "", releaseStatus = "", date = "") };

    /** Type of the data product. Based on the type some properties of a data product may become optional/mandatory. */
    String type();

    /** Category of the data-set within data product. Based on its definition, a data product is a "data set" - which can include on the values below. Based on the type some properties of a data product may become optional/mandatory. Consumers might still do analytics on business object like data products. */
    String category();

    /** Aggregated list of entity types that are at least partially exposed by the data product. Detailed mapping can be found on the output port schema level. */
    String[] entityTypes() default {};

    /** The input ports of a data product indicate the data inputs for lineage purposes.  It is a list of Integration Dependencies, whose aspects will form the actual input ports.  Input ports can also be understood as the public interface to ingest data into the data product. Data products of type `derived` consume data through the input ports. Different input ports allowing ingestion of different sub-sets building up the data-set for the data product. Data products of type `base` might not have any input ports. Their data sets are typically based directly on the applications / services own data. */
    DataProductInputPort[] inputPorts() default { @DataProductInputPort(ordId = "") };

    /** Output ports are the interface (APIs and Events) through which the data of the data product can be accessed.  Output ports of the same data product might produce different facets of the data set with different qualities. A data set can also be made available via different protocols, which also results in different ports.  As long as different output ports are accessing the same model beneath, they should belong to the same data product. If the above criteria cannot be reasonably met, consider splitting the data product into multiple smaller data products. */
    DataProductOutputPort[] outputPorts() default { @DataProductOutputPort(ordId = "") };

    /** Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components. */
    String responsible();

    /** Links with semantic meaning that are specific to Data Product Resources. */
    DataProductLink[] dataProductLinks() default { @DataProductLink(url = "", type = "") };

    /** Generic Links with arbitrary meaning and content. */
    Link[] links() default { @Link(title = "", url = "") };

    /** List of industry tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  `industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] industry() default {};

    /** List of line of business tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  `lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] lineOfBusiness() default {};

    /** List of countries that the package resources are applicable to.  MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).  `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] countries() default {};

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();

    /** The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with. Depending on the chosen policy level, additional expectations and validations rules will be applied.  The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  */
    String policyLevel() default "none";

    /** If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided. The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.  MUST only be provided if `policyLevel` is set to `custom`. MUST be a valid [Specification ID](../index.md#specification-id). */
    String customPolicyLevel() default "";

    /** A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with. For each chosen policy level, additional expectations and validations rules will be applied.  Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.  A policy level MUST be a valid [Specification ID](../index.md#specification-id). */
    String[] policyLevels() default {};

    /** Defines whether this ORD resource is **system instance aware**. This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.  If this behavior applies, `systemInstanceAware` MUST be set to true. An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions, not just once per system type, but once per **system instance**. */
    boolean systemInstanceAware() default false;
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Product {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description() default "";

    /** Vendor / organization that is responsible for the Product.  MUST be a valid reference to a [Vendor](#vendor) ORD ID. */
    String vendor();

    /** Optional product parent ORD ID, if a hierarchical product structure needs to be expressed.  MUST be a valid reference to a [Product](#product) ORD ID. */
    String parent() default "";

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Capability {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** The locally unique ID under which this resource can be looked up / resolved in the described system itself. Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.  It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID. But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID. */
    String localId() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Type of the Capability */
    String type();

    /** If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.  MUST be a valid [Specification ID](../index.md#specification-id).  MUST only be provided if `type` is set to `custom`. */
    String customType() default "";

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription() default "";

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description() default "";

    /** Defines which Package the resource is part of.  MUST be a valid reference to a [Package](#package) ORD ID.  Every resource MUST be part of one package. */
    String partOfPackage();

    /** Defines which groups the resource is assigned to.  The property is optional, but if given the value MUST be an array of valid Group IDs.  Groups are a lightweight custom taxonomy concept. They express a "part of" relationship to the chosen group concept. If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.  All resources that share the same group ID assignment are effectively grouped together. */
    String[] partOfGroups() default {};

    /** The complete [SemVer](https://semver.org/) version string.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. It SHOULD be changed if the ORD information or referenced resource definitions changed. It SHOULD express minor and patch changes that don't lead to incompatible changes.  When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical. In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.  If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`. The `version` MUST not be bumped for changes in extensions.  The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.  Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly. For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented. */
    String version();

    /** Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).  When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time. Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.  If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.  Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators. */
    String lastUpdate() default "";

    /** The visibility states who is allowed to "see" the described resource or capability. */
    String visibility();

    /** The `releaseStatus` specifies the stability of the resource and its external contract. */
    String releaseStatus();

    /** Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so. This can happen either because it has not been setup for use or disabled by an admin / user.  If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance aware perspective.  This property can only reflect the knowledge of the described system instance itself. Outside factors for availability can't need to be considered (e.g. network connectivity, middlewares).  A disabled resource MAY skip describing its resource definitions.  */
    boolean disabled() default false;

    /** The resource has been introduced in the given [system version](../index.md#def-system-version). This implies that the resource is only available if the system instance is of at least that system version. */
    String minSystemVersion() default "";

    /** Optional list of related EntityType Resources. MUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID. */
    String[] relatedEntityTypes() default {};

    /** List of available machine-readable definitions, which describe the resource or capability in detail.  Each definition is to be understood as an alternative description format, describing the same resource / capability. As a consequence the same definition type MUST NOT be provided more than once.  It is RECOMMENDED to provide the definitions as they enable machine-readable use cases. If the definitions are added or changed, the `version` MUST be incremented. An ORD aggregator MAY only (re)fetch the definitions again when the `version` was incremented. */
    CapabilityDefinition[] definitions() default { @CapabilityDefinition(type = "", mediaType = "", url = "") };

    /** Generic Links with arbitrary meaning and content. */
    Link[] links() default { @Link(title = "", url = "") };

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();

    /** Defines whether this ORD resource is **system instance aware**. This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.  If this behavior applies, `systemInstanceAware` MUST be set to true. An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions, not just once per system type, but once per **system instance**. */
    boolean systemInstanceAware() default false;
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface IntegrationDependency {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** The locally unique ID under which this resource can be looked up / resolved in the described system itself. Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.  It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID. But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID. */
    String localId() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription() default "";

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description() default "";

    /** Defines which Package the resource is part of.  MUST be a valid reference to a [Package](#package) ORD ID.  Every resource MUST be part of one package. */
    String partOfPackage();

    /** Defines which groups the resource is assigned to.  The property is optional, but if given the value MUST be an array of valid Group IDs.  Groups are a lightweight custom taxonomy concept. They express a "part of" relationship to the chosen group concept. If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.  All resources that share the same group ID assignment are effectively grouped together. */
    String[] partOfGroups() default {};

    /** The complete [SemVer](https://semver.org/) version string.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. It SHOULD be changed if the ORD information or referenced resource definitions changed. It SHOULD express minor and patch changes that don't lead to incompatible changes.  When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical. In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.  If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`. The `version` MUST not be bumped for changes in extensions.  The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.  Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly. For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented. */
    String version();

    /** Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).  When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time. Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.  If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.  Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators. */
    String lastUpdate() default "";

    /** The visibility states who is allowed to "see" the described resource or capability. */
    String visibility();

    /** The `releaseStatus` specifies the stability of the resource and its external contract. */
    String releaseStatus();

    /** The sunset date defines when the resource is scheduled to be decommissioned/removed.  If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known). Once the sunset date is known and ready to be communicated externally, it MUST be provided here.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). */
    String sunsetDate() default "";

    /** The successor resource(s).  MUST be a valid reference to an ORD ID.  If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists. If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`. */
    String[] successors() default {};

    /** If true, the Integration Dependency is mandatory for the described system to function. */
    boolean mandatory();

    /** List of integration aspects that make up the Integration Dependency.  Each aspect listed is a dedicated, constituent part (AND condition). */
    IntegrationAspect[] aspects() default { @IntegrationAspect(title = "", mandatory = false) };

    /** If an Integration Dependency conceptually belongs or related to another Integration Dependency, this can be indicated here. One situation would be where two systems each have an Integration Dependency to describe a two-sided integration from each side. */
    String[] relatedIntegrationDependencies() default {};

    /** Generic Links with arbitrary meaning and content. */
    Link[] links() default { @Link(title = "", url = "") };

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Vendor {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Optional list of partner vendors, referenced through their ORD ID.  MUST be a valid reference to a [Vendor](#vendor) ORD ID.  This property can be used to indicate partnership relations between vendors. */
    String[] partners() default {};

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface GroupType {
    /** GroupType ID, which MUST be a valid [Concept ID](../../spec-v1/#concept-id). */
    String groupTypeId();

    /** Human readable title of the group type. */
    String title();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Group {
    /** The Group ID consists of two [Concept IDs](../../spec-v1/#concept-id) separated by a `:`.  The first two fragments MUST be equal to the used Group Type ID (`groupTypeId`). The last two fragments MUST be a valid [Concept ID](../../spec-v1/#concept-id), indicating the group instance assignment.  The ID concept is a bit unusual, but it ensures globally unique and conflict free group assignments. */
    String groupId();

    /** Group Type ID.  MUST match with the first two fragments of the own `groupId`. */
    String groupTypeId();

    /** Human readable title of the group assignment (for UI). */
    String title();

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description() default "";
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.SOURCE)
  public @interface OrdResource {
    /** The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.  It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type. */
    String ordId();

    /** The locally unique ID under which this resource can be looked up / resolved in the described system itself. Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.  It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID. But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID. */
    String localId() default "";

    /** Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).  They express an "identity" / "equals" / "mappable" relationship to the target ID.  If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.  MUST be a valid [Correlation ID](../index.md#correlation-id). */
    String[] correlationIds() default {};

    /** Human-readable title.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String title();

    /** Plain text short description.  MUST NOT exceed 255 chars. MUST NOT contain line breaks. */
    String shortDescription() default "";

    /** Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).  The description SHOULD not be excessive in length and is not meant to provide full documentation. Detailed documentation SHOULD be attached as (typed) links. */
    String description();

    /** Defines which Package the resource is part of.  MUST be a valid reference to a [Package](#package) ORD ID.  Every resource MUST be part of one package. */
    String partOfPackage();

    /** Defines which groups the resource is assigned to.  The property is optional, but if given the value MUST be an array of valid Group IDs.  Groups are a lightweight custom taxonomy concept. They express a "part of" relationship to the chosen group concept. If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.  All resources that share the same group ID assignment are effectively grouped together. */
    String[] partOfGroups() default {};

    /** The complete [SemVer](https://semver.org/) version string.  It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard. It SHOULD be changed if the ORD information or referenced resource definitions changed. It SHOULD express minor and patch changes that don't lead to incompatible changes.  When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical. In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.  If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`. The `version` MUST not be bumped for changes in extensions.  The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.  Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly. For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented. */
    String version();

    /** Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.  The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).  When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time. Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.  If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.  Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators. */
    String lastUpdate() default "";

    /** The visibility states who is allowed to "see" the described resource or capability. */
    String visibility();

    /** The `releaseStatus` specifies the stability of the resource and its external contract. */
    String releaseStatus();

    /** Generic links with arbitrary meaning and content.  `packageLinks` MUST be preferred if applicable. */
    Link[] links() default { @Link(title = "", url = "") };

    /** List of free text style tags. No special characters are allowed except `-`, `_`, `.`, `/` and ` `.  Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains. */
    String[] tags() default {};

    /** Generic labels that can be applied to most ORD information. */
    Labels labels() default @Labels();

    /** Generic documentation labels that can be applied to most ORD information. */
    DocumentationLabels documentationLabels() default @DocumentationLabels();
  }

}