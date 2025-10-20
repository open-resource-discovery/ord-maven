
package org.openresourcediscovery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Api Resource
 * <p>
 * The API Resource provides a high-level description of an exposed API.
 * You can find more information, such as the API resource definitions, in the links in the table below.
 * 
 * An API Resource bundles multiple endpoints and resources together.
 * They share the same API namespace and lifecycle (API major version).
 * However, the exact granularity of this is up to the implementer of the API.
 * As a consequence, an API resource MUST NOT bundle together endpoints from different API versions or namespaces.
 * 
 * A common practice is to bundle endpoints that are based on the same domain or Business Object.
 * 
 * Please note that APIs can be described, but still be [`disabled`](#api-resource_disabled).
 * 
 * If the API is not created or owned by the user of the system or by third parties (like partners), it MUST be assigned to dedicated [Packages](#package) that state this the ownership via the `vendor` property.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId",
    "localId",
    "correlationIds",
    "title",
    "shortDescription",
    "description",
    "partOfPackage",
    "partOfGroups",
    "partOfConsumptionBundles",
    "defaultConsumptionBundle",
    "partOfProducts",
    "version",
    "lastUpdate",
    "visibility",
    "releaseStatus",
    "disabled",
    "minSystemVersion",
    "deprecationDate",
    "sunsetDate",
    "successors",
    "changelogEntries",
    "entryPoints",
    "direction",
    "apiProtocol",
    "resourceDefinitions",
    "implementationStandard",
    "customImplementationStandard",
    "customImplementationStandardDescription",
    "compatibleWith",
    "responsible",
    "supportedUseCases",
    "usage",
    "entityTypeMappings",
    "exposedEntityTypes",
    "apiResourceLinks",
    "links",
    "extensible",
    "countries",
    "lineOfBusiness",
    "industry",
    "tags",
    "labels",
    "documentationLabels",
    "policyLevel",
    "customPolicyLevel",
    "policyLevels",
    "systemInstanceAware"
})
@Generated("jsonschema2pojo")
public class ApiResource {

    /**
     * The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.
     * 
     * It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    @JsonPropertyDescription("The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.\n\nIt MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.")
    private String ordId;
    /**
     * The locally unique ID under which this resource can be looked up / resolved in the described system itself.
     * Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.
     * 
     * It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID.
     * But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID.
     * 
     */
    @JsonProperty("localId")
    @JsonPropertyDescription("The locally unique ID under which this resource can be looked up / resolved in the described system itself.\nUnlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.\n\nIt MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID.\nBut since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID.")
    private String localId;
    /**
     * Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).
     * 
     * They express an "identity" / "equals" / "mappable" relationship to the target ID.
     * 
     * If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.
     * 
     * MUST be a valid [Correlation ID](../index.md#correlation-id).
     * 
     */
    @JsonProperty("correlationIds")
    @JsonPropertyDescription("Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).\n\nThey express an \"identity\" / \"equals\" / \"mappable\" relationship to the target ID.\n\nIf a \"part of\" relationship needs to be expressed, use the `partOfGroups` assignment instead.\n\nMUST be a valid [Correlation ID](../index.md#correlation-id).")
    private List<String> correlationIds = new ArrayList<String>();
    /**
     * Human-readable title.
     * 
     * MUST NOT exceed 255 chars.
     * MUST NOT contain line breaks.
     * (Required)
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("Human-readable title.\n\nMUST NOT exceed 255 chars.\nMUST NOT contain line breaks.")
    private String title;
    /**
     * Plain text short description.
     * 
     * MUST NOT exceed 255 chars.
     * MUST NOT contain line breaks.
     * (Required)
     * 
     */
    @JsonProperty("shortDescription")
    @JsonPropertyDescription("Plain text short description.\n\nMUST NOT exceed 255 chars.\nMUST NOT contain line breaks.")
    private String shortDescription;
    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description SHOULD not be excessive in length and is not meant to provide full documentation.
     * Detailed documentation SHOULD be attached as (typed) links.
     * (Required)
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nThe description SHOULD not be excessive in length and is not meant to provide full documentation.\nDetailed documentation SHOULD be attached as (typed) links.")
    private String description;
    /**
     * Defines which Package the resource is part of.
     * 
     * MUST be a valid reference to a [Package](#package) ORD ID.
     * 
     * Every resource MUST be part of one package.
     * (Required)
     * 
     */
    @JsonProperty("partOfPackage")
    @JsonPropertyDescription("Defines which Package the resource is part of.\n\nMUST be a valid reference to a [Package](#package) ORD ID.\n\nEvery resource MUST be part of one package.")
    private String partOfPackage;
    /**
     * Defines which groups the resource is assigned to.
     * 
     * The property is optional, but if given the value MUST be an array of valid Group IDs.
     * 
     * Groups are a lightweight custom taxonomy concept.
     * They express a "part of" relationship to the chosen group concept.
     * If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.
     * 
     * All resources that share the same group ID assignment are effectively grouped together.
     * 
     */
    @JsonProperty("partOfGroups")
    @JsonPropertyDescription("Defines which groups the resource is assigned to.\n\nThe property is optional, but if given the value MUST be an array of valid Group IDs.\n\nGroups are a lightweight custom taxonomy concept.\nThey express a \"part of\" relationship to the chosen group concept.\nIf an \"identity / equals\" relationship needs to be expressed, use the `correlationIds` instead.\n\nAll resources that share the same group ID assignment are effectively grouped together.")
    private List<String> partOfGroups = new ArrayList<String>();
    /**
     * List of references to the consumption bundles in this resource belongs to.
     * 
     * MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.
     * 
     * An API resource SHOULD be associated to one or multiple consumption bundles, if it is of direction `inbound` or `mixed`.
     * Some ORD consumer use cases MAY depend on an association to a consumption bundle.
     * If none is given, the resource may not appear as it's unknown how it can be consumed.
     * 
     * If a resource has no direct incoming consumption characteristics:
     * - MUST NOT assign consumption bundle to API or Event resources with `direction`: `outbound` (no inbound consumption)
     * - MUST NOT assign consumption bundle if resource is not accessible directly, but only via intermediaries like event brokers or gateways.
     *   - In this case the intermediary SHOULD describe the consumption bundle instead (potentially also re-describing the resources as well).
     * 
     */
    @JsonProperty("partOfConsumptionBundles")
    @JsonPropertyDescription("List of references to the consumption bundles in this resource belongs to.\n\nMUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.\n\nAn API resource SHOULD be associated to one or multiple consumption bundles, if it is of direction `inbound` or `mixed`.\nSome ORD consumer use cases MAY depend on an association to a consumption bundle.\nIf none is given, the resource may not appear as it's unknown how it can be consumed.\n\nIf a resource has no direct incoming consumption characteristics:\n- MUST NOT assign consumption bundle to API or Event resources with `direction`: `outbound` (no inbound consumption)\n- MUST NOT assign consumption bundle if resource is not accessible directly, but only via intermediaries like event brokers or gateways.\n  - In this case the intermediary SHOULD describe the consumption bundle instead (potentially also re-describing the resources as well).")
    private List<ConsumptionBundleReference> partOfConsumptionBundles = new ArrayList<ConsumptionBundleReference>();
    /**
     * References the default consumption bundle to use for this resource.
     * 
     * MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.
     * 
     * Can be used by clients to make a deterministic and preferred choice when multiple options are available.
     * 
     * The value MUST be an existing option in the corresponding `partOfConsumptionBundles` array.
     * 
     */
    @JsonProperty("defaultConsumptionBundle")
    @JsonPropertyDescription("References the default consumption bundle to use for this resource.\n\nMUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.\n\nCan be used by clients to make a deterministic and preferred choice when multiple options are available.\n\nThe value MUST be an existing option in the corresponding `partOfConsumptionBundles` array.")
    private String defaultConsumptionBundle;
    /**
     * List of products the resources of the package are a part of.
     * 
     * MUST be a valid reference to a [Product](#product) ORD ID.
     * 
     * `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("partOfProducts")
    @JsonPropertyDescription("List of products the resources of the package are a part of.\n\nMUST be a valid reference to a [Product](#product) ORD ID.\n\n`partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.")
    private List<String> partOfProducts = new ArrayList<String>();
    /**
     * The complete [SemVer](https://semver.org/) version string.
     * 
     * It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.
     * It SHOULD be changed if the ORD information or referenced resource definitions changed.
     * It SHOULD express minor and patch changes that don't lead to incompatible changes.
     * 
     * When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical.
     * In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://spec.openapis.org/oas/v3.1.1.html#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.
     * 
     * If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`.
     * The `version` MUST not be bumped for changes in extensions.
     * 
     * The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.
     * 
     * Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly.
     * For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented.
     * (Required)
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("The complete [SemVer](https://semver.org/) version string.\n\nIt MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.\nIt SHOULD be changed if the ORD information or referenced resource definitions changed.\nIt SHOULD express minor and patch changes that don't lead to incompatible changes.\n\nWhen the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical.\nIn case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://spec.openapis.org/oas/v3.1.1.html#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.\n\nIf the resource has been extended by the user, the change MUST be indicated via `lastUpdate`.\nThe `version` MUST not be bumped for changes in extensions.\n\nThe general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.\n\nNote: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly.\nFor example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented.")
    private String version;
    /**
     * Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     * When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time.
     * Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.
     * 
     * If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.
     * 
     * Together with `perspectives`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.
     * 
     */
    @JsonProperty("lastUpdate")
    @JsonPropertyDescription("Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.\n\nThe date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).\n\nWhen retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time.\nTherefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.\n\nIf the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.\n\nTogether with `perspectives`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.")
    private Date lastUpdate;
    /**
     * The visibility states who is allowed to "see" the described resource or capability.
     * (Required)
     * 
     */
    @JsonProperty("visibility")
    @JsonPropertyDescription("The visibility states who is allowed to \"see\" the described resource or capability.")
    private String visibility;
    /**
     * The `releaseStatus` specifies the stability of the resource and its external contract.
     * (Required)
     * 
     */
    @JsonProperty("releaseStatus")
    @JsonPropertyDescription("The `releaseStatus` specifies the stability of the resource and its external contract.")
    private String releaseStatus;
    /**
     * Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so.
     * This can happen either because it has not been setup for use or disabled by an admin / user.
     * 
     * If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance aware perspective.
     * 
     * This property can only reflect the knowledge of the described system instance itself.
     * Outside factors for availability can't need to be considered (e.g. network connectivity, middlewares).
     * 
     * A disabled resource MAY skip describing its resource definitions.
     * 
     * 
     */
    @JsonProperty("disabled")
    @JsonPropertyDescription("Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so.\nThis can happen either because it has not been setup for use or disabled by an admin / user.\n\nIf the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance aware perspective.\n\nThis property can only reflect the knowledge of the described system instance itself.\nOutside factors for availability can't need to be considered (e.g. network connectivity, middlewares).\n\nA disabled resource MAY skip describing its resource definitions.\n")
    private Boolean disabled = false;
    /**
     * The resource has been introduced in the given [system version](../index.md#def-system-version).
     * This implies that the resource is only available if the system instance is of at least that system version.
     * 
     */
    @JsonProperty("minSystemVersion")
    @JsonPropertyDescription("The resource has been introduced in the given [system version](../index.md#def-system-version).\nThis implies that the resource is only available if the system instance is of at least that system version.")
    private String minSystemVersion;
    /**
     * The deprecation date defines when the resource has been set as deprecated.
     * This is not to be confused with the `sunsetDate` which defines when the resource will be actually sunset, aka. decommissioned / removed / archived.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     */
    @JsonProperty("deprecationDate")
    @JsonPropertyDescription("The deprecation date defines when the resource has been set as deprecated.\nThis is not to be confused with the `sunsetDate` which defines when the resource will be actually sunset, aka. decommissioned / removed / archived.\n\nThe date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).")
    private Date deprecationDate;
    /**
     * The sunset date defines when the resource is scheduled to be decommissioned / removed / archived.
     * 
     * If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known).
     * Once the sunset date is known and ready to be communicated externally, it MUST be provided here.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     */
    @JsonProperty("sunsetDate")
    @JsonPropertyDescription("The sunset date defines when the resource is scheduled to be decommissioned / removed / archived.\n\nIf the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known).\nOnce the sunset date is known and ready to be communicated externally, it MUST be provided here.\n\nThe date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).")
    private Date sunsetDate;
    /**
     * The successor resource(s).
     * 
     * MUST be a valid reference to an ORD ID.
     * 
     * If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists.
     * If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`.
     * 
     */
    @JsonProperty("successors")
    @JsonPropertyDescription("The successor resource(s).\n\nMUST be a valid reference to an ORD ID.\n\nIf the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists.\nIf `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`.")
    private List<String> successors = new ArrayList<String>();
    /**
     * Contains changelog entries that summarize changes with special regards to version and releaseStatus
     * 
     */
    @JsonProperty("changelogEntries")
    @JsonPropertyDescription("Contains changelog entries that summarize changes with special regards to version and releaseStatus")
    private List<ChangelogEntry> changelogEntries = new ArrayList<ChangelogEntry>();
    /**
     * List of [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the target host.
     * 
     * If the API resource can be accessed through an entry point, it MUST be described here.
     * 
     * The list of entry points MUST not include duplicates.
     * If multiple entry points are provided they MUST be arbitrarily exchangeable without effects.
     * This means that the URLs are just an alias to each other and the `resourceDefinitions` apply to all entry points equally.
     * In case of multiple entry points it is RECOMMENDED to provide a `defaultEntryPoint` through `partOfConsumptionBundles`.
     * The entry point URLs SHOULD match with the target host(s) in the resource definition files (e.g. OpenAPI `servers`).
     * If there is no match, the information in ORD takes precedence.
     * 
     * **Provider View:**
     * If the URL is relative to the system that describes the ORD information,
     * it is RECOMMENDED to use relative references and (if known) to provide the `describedSystemInstance`.`baseUrl`.
     * If the URL is not relative to the described system instance [base URL](../index.md#def-base-url), a full URL MUST be provided.
     * If the entry points are rewritten by middleware - incl. the special case of client/consumer specific entry points - it is RECOMMENDED to provide relative URLs, so only the `describedSystemInstance`.`baseUrl` has to be rewritten.
     * The provider should not have to describe all middleware or consumer specific entry points. If they are enriched later by the aggregator, it MAY omit the entry points.
     * 
     * **Consumer View**:
     * When fetching the information from an ORD Aggregator, the consumer MAY rely on receiving full URLs.
     * 
     */
    @JsonProperty("entryPoints")
    @JsonPropertyDescription("List of [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the target host.\n\nIf the API resource can be accessed through an entry point, it MUST be described here.\n\nThe list of entry points MUST not include duplicates.\nIf multiple entry points are provided they MUST be arbitrarily exchangeable without effects.\nThis means that the URLs are just an alias to each other and the `resourceDefinitions` apply to all entry points equally.\nIn case of multiple entry points it is RECOMMENDED to provide a `defaultEntryPoint` through `partOfConsumptionBundles`.\nThe entry point URLs SHOULD match with the target host(s) in the resource definition files (e.g. OpenAPI `servers`).\nIf there is no match, the information in ORD takes precedence.\n\n**Provider View:**\nIf the URL is relative to the system that describes the ORD information,\nit is RECOMMENDED to use relative references and (if known) to provide the `describedSystemInstance`.`baseUrl`.\nIf the URL is not relative to the described system instance [base URL](../index.md#def-base-url), a full URL MUST be provided.\nIf the entry points are rewritten by middleware - incl. the special case of client/consumer specific entry points - it is RECOMMENDED to provide relative URLs, so only the `describedSystemInstance`.`baseUrl` has to be rewritten.\nThe provider should not have to describe all middleware or consumer specific entry points. If they are enriched later by the aggregator, it MAY omit the entry points.\n\n**Consumer View**:\nWhen fetching the information from an ORD Aggregator, the consumer MAY rely on receiving full URLs.")
    private List<String> entryPoints = new ArrayList<String>();
    /**
     * Direction of the API Resource consumption.
     * If not provided, "inbound" is assumed.
     * 
     * In case of SOAP APIs, the direction is already indicated through the `apiProtocol`, making this property redundant and optional. But if it is provided, it MUST not be in contradiction with the `apiProtocol` direction.
     * 
     */
    @JsonProperty("direction")
    @JsonPropertyDescription("Direction of the API Resource consumption.\nIf not provided, \"inbound\" is assumed.\n\nIn case of SOAP APIs, the direction is already indicated through the `apiProtocol`, making this property redundant and optional. But if it is provided, it MUST not be in contradiction with the `apiProtocol` direction.")
    private String direction = "inbound";
    /**
     * API Protocol including the protocol version if applicable
     * (Required)
     * 
     */
    @JsonProperty("apiProtocol")
    @JsonPropertyDescription("API Protocol including the protocol version if applicable")
    private String apiProtocol;
    /**
     * List of available machine-readable definitions, which describe the resource or capability in detail.
     * 
     * Each definition is to be understood as an alternative description format, describing the same resource / capability.
     * As a consequence the same definition type MUST NOT be provided more than once.
     * 
     * It is RECOMMENDED to provide the definitions as they enable machine-readable use cases.
     * If the definitions are added or changed, the `version` MUST be incremented.
     * An ORD aggregator MAY only (re)fetch the definitions again when the `version` was incremented.
     * 
     */
    @JsonProperty("resourceDefinitions")
    @JsonPropertyDescription("List of available machine-readable definitions, which describe the resource or capability in detail.\n\nEach definition is to be understood as an alternative description format, describing the same resource / capability.\nAs a consequence the same definition type MUST NOT be provided more than once.\n\nIt is RECOMMENDED to provide the definitions as they enable machine-readable use cases.\nIf the definitions are added or changed, the `version` MUST be incremented.\nAn ORD aggregator MAY only (re)fetch the definitions again when the `version` was incremented.")
    private List<ApiResourceDefinition> resourceDefinitions = new ArrayList<ApiResourceDefinition>();
    /**
     * Declares this API to be a valid implementation of an externally standardized API contract, sub-protocol or protocol variant.
     * 
     * All APIs that share the same implementation standard MAY be treated the same or similar by a consumer client.
     * 
     */
    @JsonProperty("implementationStandard")
    @JsonPropertyDescription("Declares this API to be a valid implementation of an externally standardized API contract, sub-protocol or protocol variant.\n\nAll APIs that share the same implementation standard MAY be treated the same or similar by a consumer client.")
    private String implementationStandard;
    /**
     * If the fixed `implementationStandard` values need to be extended, an arbitrary `customImplementationStandard` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `implementationStandard` is set to `custom`.
     * 
     */
    @JsonProperty("customImplementationStandard")
    @JsonPropertyDescription("If the fixed `implementationStandard` values need to be extended, an arbitrary `customImplementationStandard` can be provided.\n\nMUST be a valid [Specification ID](../index.md#specification-id).\n\nMUST only be provided if `implementationStandard` is set to `custom`.")
    private String customImplementationStandard;
    /**
     * Full description of the custom implementation standard, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * MUST only be provided if `implementationStandard` is set to `custom`.
     * 
     * SHOULD contain documentation and links that describe the used standard.
     * 
     */
    @JsonProperty("customImplementationStandardDescription")
    @JsonPropertyDescription("Full description of the custom implementation standard, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nMUST only be provided if `implementationStandard` is set to `custom`.\n\nSHOULD contain documentation and links that describe the used standard.")
    private String customImplementationStandardDescription;
    /**
     * A reference to the interface (API contract) that this API implements.
     * Serves as a declaration of compatible implementation of API contract, effectively functioning as an "implementationOf" relationship.
     * 
     * MUST be a valid reference to an (usually external) [API Resource](#api-resource) ORD ID.
     * 
     * All APIs that share the same `compatibleWith` value MAY be treated the same or similar by a consumer client.
     * 
     */
    @JsonProperty("compatibleWith")
    @JsonPropertyDescription("A reference to the interface (API contract) that this API implements.\nServes as a declaration of compatible implementation of API contract, effectively functioning as an \"implementationOf\" relationship.\n\nMUST be a valid reference to an (usually external) [API Resource](#api-resource) ORD ID.\n\nAll APIs that share the same `compatibleWith` value MAY be treated the same or similar by a consumer client.")
    private List<String> compatibleWith = new ArrayList<String>();
    /**
     * Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.
     * 
     */
    @JsonProperty("responsible")
    @JsonPropertyDescription("Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.")
    private String responsible;
    /**
     * List of use cases (types) how the resource is meant to be used for.
     * 
     * This helps consumers better to understand which use cases had been in mind by the provider
     * and are therefore explicitly supported.
     * This is obviously described from a provider perspective, but stating what consumer use cases it potentially supports.
     * As it's not possible to create a list of options that are mutually exclusive, all options that apply should be provided.
     * 
     * If no array is defined, it is assumed that this information is not provided.
     * 
     */
    @JsonProperty("supportedUseCases")
    @JsonPropertyDescription("List of use cases (types) how the resource is meant to be used for.\n\nThis helps consumers better to understand which use cases had been in mind by the provider\nand are therefore explicitly supported.\nThis is obviously described from a provider perspective, but stating what consumer use cases it potentially supports.\nAs it's not possible to create a list of options that are mutually exclusive, all options that apply should be provided.\n\nIf no array is defined, it is assumed that this information is not provided.")
    private List<String> supportedUseCases = new ArrayList<String>();
    /**
     * Usage
     * <p>
     * Define from where the API resource can be used and accessed
     * 
     */
    @JsonProperty("usage")
    @JsonPropertyDescription("Define from where the API resource can be used and accessed")
    private String usage = "external";
    /**
     * Describes mappings between the API Models of the described resource to the underlying, conceptual entity types.
     * 
     */
    @JsonProperty("entityTypeMappings")
    @JsonPropertyDescription("Describes mappings between the API Models of the described resource to the underlying, conceptual entity types.")
    private List<EntityTypeMapping> entityTypeMappings = new ArrayList<EntityTypeMapping>();
    /**
     * Optional list of [entity types](#entity-type) that are exposed by the resource.
     * 
     * This replaces `entityTypeMappings`. If both is given, the `exposedEntityTypes` wins.
     * 
     * MUST be a valid reference to an [EntityType](#entity-type) ORD ID.
     * 
     */
    @JsonProperty("exposedEntityTypes")
    @JsonPropertyDescription("Optional list of [entity types](#entity-type) that are exposed by the resource.\n\nThis replaces `entityTypeMappings`. If both is given, the `exposedEntityTypes` wins.\n\nMUST be a valid reference to an [EntityType](#entity-type) ORD ID.")
    private List<ExposedEntityType> exposedEntityTypes = new ArrayList<ExposedEntityType>();
    /**
     * Links with semantic meaning that are specific to API Resources.
     * 
     */
    @JsonProperty("apiResourceLinks")
    @JsonPropertyDescription("Links with semantic meaning that are specific to API Resources.")
    private List<APIEventResourceLink> apiResourceLinks = new ArrayList<APIEventResourceLink>();
    /**
     * Generic Links with arbitrary meaning and content.
     * 
     * If applicable, `apiResourceLinks` MUST be used instead of generic `links`.
     * 
     */
    @JsonProperty("links")
    @JsonPropertyDescription("Generic Links with arbitrary meaning and content.\n\nIf applicable, `apiResourceLinks` MUST be used instead of generic `links`.")
    private List<Link> links = new ArrayList<Link>();
    /**
     * Extensible
     * <p>
     * Contains information about the extensibility of this resource.
     * 
     * If applicable, a description and further resources about extending this resource are provided.
     * 
     */
    @JsonProperty("extensible")
    @JsonPropertyDescription("Contains information about the extensibility of this resource.\n\nIf applicable, a description and further resources about extending this resource are provided.")
    private Extensible extensible;
    /**
     * List of countries that the package resources are applicable to.
     * 
     * MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).
     * 
     * `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("countries")
    @JsonPropertyDescription("List of countries that the package resources are applicable to.\n\nMUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).\n\n`countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains.")
    private List<String> countries = new ArrayList<String>();
    /**
     * List of line of business tags.
     * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     * 
     * `lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("lineOfBusiness")
    @JsonPropertyDescription("List of line of business tags.\nNo special characters are allowed except `-`, `_`, `.`, `/` and ` `.\n\n`lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains.")
    private List<String> lineOfBusiness = new ArrayList<String>();
    /**
     * List of industry tags.
     * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     * 
     * `industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("industry")
    @JsonPropertyDescription("List of industry tags.\nNo special characters are allowed except `-`, `_`, `.`, `/` and ` `.\n\n`industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains.")
    private List<String> industry = new ArrayList<String>();
    /**
     * List of free text style tags.
     * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     * 
     * Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("tags")
    @JsonPropertyDescription("List of free text style tags.\nNo special characters are allowed except `-`, `_`, `.`, `/` and ` `.\n\nTags that are assigned to a `Package` are inherited to all of the ORD resources it contains.")
    private List<String> tags = new ArrayList<String>();
    /**
     * Labels
     * <p>
     * Generic labels that can be applied to most ORD information.
     * They are defined as an object that may have arbitrary keys.
     * The value of a key is an array of strings.
     * 
     * Labels can be used to attach technical information that cannot be expressed natively in ORD.
     * An ORD aggregator should allow to categorize and query information based on the labels provided.
     * 
     * If multiple parties rely on the existence of certain label information,
     * standardization through ORD SHOULD be preferred.
     * 
     * All labels attached to a `Package` will be inherited to the resources they contain.
     * Duplicate labels will be merged by the ORD aggregator according to the following rules:
     * * Values of the same label key will be merged.
     * * Duplicate values of the same label key will be removed.
     * 
     */
    @JsonProperty("labels")
    @JsonPropertyDescription("Generic labels that can be applied to most ORD information.\nThey are defined as an object that may have arbitrary keys.\nThe value of a key is an array of strings.\n\nLabels can be used to attach technical information that cannot be expressed natively in ORD.\nAn ORD aggregator should allow to categorize and query information based on the labels provided.\n\nIf multiple parties rely on the existence of certain label information,\nstandardization through ORD SHOULD be preferred.\n\nAll labels attached to a `Package` will be inherited to the resources they contain.\nDuplicate labels will be merged by the ORD aggregator according to the following rules:\n* Values of the same label key will be merged.\n* Duplicate values of the same label key will be removed.")
    private Labels labels;
    /**
     * Documentation Labels
     * <p>
     * Generic documentation labels that can be applied to most ORD information.
     * They are defined as an object that may have arbitrary keys.
     * The value of a key is an array of [CommonMark](https://spec.commonmark.org/) (Markdown) text.
     * 
     * Documentation Labels can be used to attach human readable documentation that cannot be expressed natively in ORD.
     * A documentation tool (like an API Catalog) can use the documentation labels to provide generic documentation "snippets".
     * Due to the given structure they can be displayed e.g. as tables.
     * 
     * The key of the documentation Label is plain-text (MUST not contain line breaks) and denotes the subject matter that is described.
     * The values (multiple can be provided for the same key) are [CommonMark](https://spec.commonmark.org/) (Markdown) text
     * which describes the subject matter or lists options for the key.
     * 
     * In contrast to regular labels, documentation labels are not meant to be used to categorize or query information.
     * 
     */
    @JsonProperty("documentationLabels")
    @JsonPropertyDescription("Generic documentation labels that can be applied to most ORD information.\nThey are defined as an object that may have arbitrary keys.\nThe value of a key is an array of [CommonMark](https://spec.commonmark.org/) (Markdown) text.\n\nDocumentation Labels can be used to attach human readable documentation that cannot be expressed natively in ORD.\nA documentation tool (like an API Catalog) can use the documentation labels to provide generic documentation \"snippets\".\nDue to the given structure they can be displayed e.g. as tables.\n\nThe key of the documentation Label is plain-text (MUST not contain line breaks) and denotes the subject matter that is described.\nThe values (multiple can be provided for the same key) are [CommonMark](https://spec.commonmark.org/) (Markdown) text\nwhich describes the subject matter or lists options for the key.\n\nIn contrast to regular labels, documentation labels are not meant to be used to categorize or query information.")
    private DocumentationLabels documentationLabels;
    /**
     * The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.
     * Depending on the chosen policy level, additional expectations and validations rules will be applied.
     * 
     * The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * 
     */
    @JsonProperty("policyLevel")
    @JsonPropertyDescription("The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.\nDepending on the chosen policy level, additional expectations and validations rules will be applied.\n\nThe policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.\n")
    private String policyLevel = "none";
    /**
     * If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.
     * The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.
     * 
     * MUST only be provided if `policyLevel` is set to `custom`.
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("customPolicyLevel")
    @JsonPropertyDescription("If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.\nThe policy level is inherited from packages to resources they contain, but can be overwritten at resource level.\n\nMUST only be provided if `policyLevel` is set to `custom`.\nMUST be a valid [Specification ID](../index.md#specification-id).")
    private String customPolicyLevel;
    /**
     * A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.
     * For each chosen policy level, additional expectations and validations rules will be applied.
     * 
     * Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * A policy level MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("policyLevels")
    @JsonPropertyDescription("A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.\nFor each chosen policy level, additional expectations and validations rules will be applied.\n\nPolicy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.\n\nA policy level MUST be a valid [Specification ID](../index.md#specification-id).")
    private List<String> policyLevels = new ArrayList<String>();
    /**
     * All resources that are [system instance aware](../index.md#def-system-instance-aware) should now be put together in one ORD document that has `perspective`: `system-instance`.
     * All resources that are [system instance unaware](../index.md#def-system-instance-unaware) should now be put together in one ORD document that has `perspective`: `system-version`.
     * 
     * Defines whether this ORD resource is **system instance aware**.
     * This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.
     * 
     * If this behavior applies, `systemInstanceAware` MUST be set to true.
     * An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions,
     * not just once per system type, but once per **system instance**.
     * 
     */
    @JsonProperty("systemInstanceAware")
    @JsonPropertyDescription("All resources that are [system instance aware](../index.md#def-system-instance-aware) should now be put together in one ORD document that has `perspective`: `system-instance`.\nAll resources that are [system instance unaware](../index.md#def-system-instance-unaware) should now be put together in one ORD document that has `perspective`: `system-version`.\n\nDefines whether this ORD resource is **system instance aware**.\nThis is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.\n\nIf this behavior applies, `systemInstanceAware` MUST be set to true.\nAn ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions,\nnot just once per system type, but once per **system instance**.")
    private Boolean systemInstanceAware = false;

    /**
     * The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.
     * 
     * It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public String getOrdId() {
        return ordId;
    }

    /**
     * The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.
     * 
     * It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public ApiResource withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    /**
     * The locally unique ID under which this resource can be looked up / resolved in the described system itself.
     * Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.
     * 
     * It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID.
     * But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID.
     * 
     */
    @JsonProperty("localId")
    public String getLocalId() {
        return localId;
    }

    /**
     * The locally unique ID under which this resource can be looked up / resolved in the described system itself.
     * Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.
     * 
     * It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID.
     * But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID.
     * 
     */
    @JsonProperty("localId")
    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public ApiResource withLocalId(String localId) {
        this.localId = localId;
        return this;
    }

    /**
     * Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).
     * 
     * They express an "identity" / "equals" / "mappable" relationship to the target ID.
     * 
     * If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.
     * 
     * MUST be a valid [Correlation ID](../index.md#correlation-id).
     * 
     */
    @JsonProperty("correlationIds")
    public List<String> getCorrelationIds() {
        return correlationIds;
    }

    /**
     * Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).
     * 
     * They express an "identity" / "equals" / "mappable" relationship to the target ID.
     * 
     * If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.
     * 
     * MUST be a valid [Correlation ID](../index.md#correlation-id).
     * 
     */
    @JsonProperty("correlationIds")
    public void setCorrelationIds(List<String> correlationIds) {
        this.correlationIds = correlationIds;
    }

    public ApiResource withCorrelationIds(List<String> correlationIds) {
        this.correlationIds = correlationIds;
        return this;
    }

    /**
     * Human-readable title.
     * 
     * MUST NOT exceed 255 chars.
     * MUST NOT contain line breaks.
     * (Required)
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Human-readable title.
     * 
     * MUST NOT exceed 255 chars.
     * MUST NOT contain line breaks.
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public ApiResource withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Plain text short description.
     * 
     * MUST NOT exceed 255 chars.
     * MUST NOT contain line breaks.
     * (Required)
     * 
     */
    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Plain text short description.
     * 
     * MUST NOT exceed 255 chars.
     * MUST NOT contain line breaks.
     * (Required)
     * 
     */
    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public ApiResource withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description SHOULD not be excessive in length and is not meant to provide full documentation.
     * Detailed documentation SHOULD be attached as (typed) links.
     * (Required)
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description SHOULD not be excessive in length and is not meant to provide full documentation.
     * Detailed documentation SHOULD be attached as (typed) links.
     * (Required)
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public ApiResource withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Defines which Package the resource is part of.
     * 
     * MUST be a valid reference to a [Package](#package) ORD ID.
     * 
     * Every resource MUST be part of one package.
     * (Required)
     * 
     */
    @JsonProperty("partOfPackage")
    public String getPartOfPackage() {
        return partOfPackage;
    }

    /**
     * Defines which Package the resource is part of.
     * 
     * MUST be a valid reference to a [Package](#package) ORD ID.
     * 
     * Every resource MUST be part of one package.
     * (Required)
     * 
     */
    @JsonProperty("partOfPackage")
    public void setPartOfPackage(String partOfPackage) {
        this.partOfPackage = partOfPackage;
    }

    public ApiResource withPartOfPackage(String partOfPackage) {
        this.partOfPackage = partOfPackage;
        return this;
    }

    /**
     * Defines which groups the resource is assigned to.
     * 
     * The property is optional, but if given the value MUST be an array of valid Group IDs.
     * 
     * Groups are a lightweight custom taxonomy concept.
     * They express a "part of" relationship to the chosen group concept.
     * If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.
     * 
     * All resources that share the same group ID assignment are effectively grouped together.
     * 
     */
    @JsonProperty("partOfGroups")
    public List<String> getPartOfGroups() {
        return partOfGroups;
    }

    /**
     * Defines which groups the resource is assigned to.
     * 
     * The property is optional, but if given the value MUST be an array of valid Group IDs.
     * 
     * Groups are a lightweight custom taxonomy concept.
     * They express a "part of" relationship to the chosen group concept.
     * If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.
     * 
     * All resources that share the same group ID assignment are effectively grouped together.
     * 
     */
    @JsonProperty("partOfGroups")
    public void setPartOfGroups(List<String> partOfGroups) {
        this.partOfGroups = partOfGroups;
    }

    public ApiResource withPartOfGroups(List<String> partOfGroups) {
        this.partOfGroups = partOfGroups;
        return this;
    }

    /**
     * List of references to the consumption bundles in this resource belongs to.
     * 
     * MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.
     * 
     * An API resource SHOULD be associated to one or multiple consumption bundles, if it is of direction `inbound` or `mixed`.
     * Some ORD consumer use cases MAY depend on an association to a consumption bundle.
     * If none is given, the resource may not appear as it's unknown how it can be consumed.
     * 
     * If a resource has no direct incoming consumption characteristics:
     * - MUST NOT assign consumption bundle to API or Event resources with `direction`: `outbound` (no inbound consumption)
     * - MUST NOT assign consumption bundle if resource is not accessible directly, but only via intermediaries like event brokers or gateways.
     *   - In this case the intermediary SHOULD describe the consumption bundle instead (potentially also re-describing the resources as well).
     * 
     */
    @JsonProperty("partOfConsumptionBundles")
    public List<ConsumptionBundleReference> getPartOfConsumptionBundles() {
        return partOfConsumptionBundles;
    }

    /**
     * List of references to the consumption bundles in this resource belongs to.
     * 
     * MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.
     * 
     * An API resource SHOULD be associated to one or multiple consumption bundles, if it is of direction `inbound` or `mixed`.
     * Some ORD consumer use cases MAY depend on an association to a consumption bundle.
     * If none is given, the resource may not appear as it's unknown how it can be consumed.
     * 
     * If a resource has no direct incoming consumption characteristics:
     * - MUST NOT assign consumption bundle to API or Event resources with `direction`: `outbound` (no inbound consumption)
     * - MUST NOT assign consumption bundle if resource is not accessible directly, but only via intermediaries like event brokers or gateways.
     *   - In this case the intermediary SHOULD describe the consumption bundle instead (potentially also re-describing the resources as well).
     * 
     */
    @JsonProperty("partOfConsumptionBundles")
    public void setPartOfConsumptionBundles(List<ConsumptionBundleReference> partOfConsumptionBundles) {
        this.partOfConsumptionBundles = partOfConsumptionBundles;
    }

    public ApiResource withPartOfConsumptionBundles(List<ConsumptionBundleReference> partOfConsumptionBundles) {
        this.partOfConsumptionBundles = partOfConsumptionBundles;
        return this;
    }

    /**
     * References the default consumption bundle to use for this resource.
     * 
     * MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.
     * 
     * Can be used by clients to make a deterministic and preferred choice when multiple options are available.
     * 
     * The value MUST be an existing option in the corresponding `partOfConsumptionBundles` array.
     * 
     */
    @JsonProperty("defaultConsumptionBundle")
    public String getDefaultConsumptionBundle() {
        return defaultConsumptionBundle;
    }

    /**
     * References the default consumption bundle to use for this resource.
     * 
     * MUST be a valid reference to a [Consumption Bundle](#consumption-bundle) ORD ID.
     * 
     * Can be used by clients to make a deterministic and preferred choice when multiple options are available.
     * 
     * The value MUST be an existing option in the corresponding `partOfConsumptionBundles` array.
     * 
     */
    @JsonProperty("defaultConsumptionBundle")
    public void setDefaultConsumptionBundle(String defaultConsumptionBundle) {
        this.defaultConsumptionBundle = defaultConsumptionBundle;
    }

    public ApiResource withDefaultConsumptionBundle(String defaultConsumptionBundle) {
        this.defaultConsumptionBundle = defaultConsumptionBundle;
        return this;
    }

    /**
     * List of products the resources of the package are a part of.
     * 
     * MUST be a valid reference to a [Product](#product) ORD ID.
     * 
     * `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("partOfProducts")
    public List<String> getPartOfProducts() {
        return partOfProducts;
    }

    /**
     * List of products the resources of the package are a part of.
     * 
     * MUST be a valid reference to a [Product](#product) ORD ID.
     * 
     * `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("partOfProducts")
    public void setPartOfProducts(List<String> partOfProducts) {
        this.partOfProducts = partOfProducts;
    }

    public ApiResource withPartOfProducts(List<String> partOfProducts) {
        this.partOfProducts = partOfProducts;
        return this;
    }

    /**
     * The complete [SemVer](https://semver.org/) version string.
     * 
     * It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.
     * It SHOULD be changed if the ORD information or referenced resource definitions changed.
     * It SHOULD express minor and patch changes that don't lead to incompatible changes.
     * 
     * When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical.
     * In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://spec.openapis.org/oas/v3.1.1.html#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.
     * 
     * If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`.
     * The `version` MUST not be bumped for changes in extensions.
     * 
     * The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.
     * 
     * Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly.
     * For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented.
     * (Required)
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * The complete [SemVer](https://semver.org/) version string.
     * 
     * It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.
     * It SHOULD be changed if the ORD information or referenced resource definitions changed.
     * It SHOULD express minor and patch changes that don't lead to incompatible changes.
     * 
     * When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical.
     * In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://spec.openapis.org/oas/v3.1.1.html#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.
     * 
     * If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`.
     * The `version` MUST not be bumped for changes in extensions.
     * 
     * The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.
     * 
     * Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly.
     * For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented.
     * (Required)
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public ApiResource withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     * When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time.
     * Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.
     * 
     * If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.
     * 
     * Together with `perspectives`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.
     * 
     */
    @JsonProperty("lastUpdate")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     * When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time.
     * Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.
     * 
     * If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.
     * 
     * Together with `perspectives`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.
     * 
     */
    @JsonProperty("lastUpdate")
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public ApiResource withLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    /**
     * The visibility states who is allowed to "see" the described resource or capability.
     * (Required)
     * 
     */
    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    /**
     * The visibility states who is allowed to "see" the described resource or capability.
     * (Required)
     * 
     */
    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public ApiResource withVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    /**
     * The `releaseStatus` specifies the stability of the resource and its external contract.
     * (Required)
     * 
     */
    @JsonProperty("releaseStatus")
    public String getReleaseStatus() {
        return releaseStatus;
    }

    /**
     * The `releaseStatus` specifies the stability of the resource and its external contract.
     * (Required)
     * 
     */
    @JsonProperty("releaseStatus")
    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public ApiResource withReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
        return this;
    }

    /**
     * Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so.
     * This can happen either because it has not been setup for use or disabled by an admin / user.
     * 
     * If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance aware perspective.
     * 
     * This property can only reflect the knowledge of the described system instance itself.
     * Outside factors for availability can't need to be considered (e.g. network connectivity, middlewares).
     * 
     * A disabled resource MAY skip describing its resource definitions.
     * 
     * 
     */
    @JsonProperty("disabled")
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so.
     * This can happen either because it has not been setup for use or disabled by an admin / user.
     * 
     * If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance aware perspective.
     * 
     * This property can only reflect the knowledge of the described system instance itself.
     * Outside factors for availability can't need to be considered (e.g. network connectivity, middlewares).
     * 
     * A disabled resource MAY skip describing its resource definitions.
     * 
     * 
     */
    @JsonProperty("disabled")
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public ApiResource withDisabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    /**
     * The resource has been introduced in the given [system version](../index.md#def-system-version).
     * This implies that the resource is only available if the system instance is of at least that system version.
     * 
     */
    @JsonProperty("minSystemVersion")
    public String getMinSystemVersion() {
        return minSystemVersion;
    }

    /**
     * The resource has been introduced in the given [system version](../index.md#def-system-version).
     * This implies that the resource is only available if the system instance is of at least that system version.
     * 
     */
    @JsonProperty("minSystemVersion")
    public void setMinSystemVersion(String minSystemVersion) {
        this.minSystemVersion = minSystemVersion;
    }

    public ApiResource withMinSystemVersion(String minSystemVersion) {
        this.minSystemVersion = minSystemVersion;
        return this;
    }

    /**
     * The deprecation date defines when the resource has been set as deprecated.
     * This is not to be confused with the `sunsetDate` which defines when the resource will be actually sunset, aka. decommissioned / removed / archived.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     */
    @JsonProperty("deprecationDate")
    public Date getDeprecationDate() {
        return deprecationDate;
    }

    /**
     * The deprecation date defines when the resource has been set as deprecated.
     * This is not to be confused with the `sunsetDate` which defines when the resource will be actually sunset, aka. decommissioned / removed / archived.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     */
    @JsonProperty("deprecationDate")
    public void setDeprecationDate(Date deprecationDate) {
        this.deprecationDate = deprecationDate;
    }

    public ApiResource withDeprecationDate(Date deprecationDate) {
        this.deprecationDate = deprecationDate;
        return this;
    }

    /**
     * The sunset date defines when the resource is scheduled to be decommissioned / removed / archived.
     * 
     * If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known).
     * Once the sunset date is known and ready to be communicated externally, it MUST be provided here.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     */
    @JsonProperty("sunsetDate")
    public Date getSunsetDate() {
        return sunsetDate;
    }

    /**
     * The sunset date defines when the resource is scheduled to be decommissioned / removed / archived.
     * 
     * If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known).
     * Once the sunset date is known and ready to be communicated externally, it MUST be provided here.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     */
    @JsonProperty("sunsetDate")
    public void setSunsetDate(Date sunsetDate) {
        this.sunsetDate = sunsetDate;
    }

    public ApiResource withSunsetDate(Date sunsetDate) {
        this.sunsetDate = sunsetDate;
        return this;
    }

    /**
     * The successor resource(s).
     * 
     * MUST be a valid reference to an ORD ID.
     * 
     * If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists.
     * If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`.
     * 
     */
    @JsonProperty("successors")
    public List<String> getSuccessors() {
        return successors;
    }

    /**
     * The successor resource(s).
     * 
     * MUST be a valid reference to an ORD ID.
     * 
     * If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists.
     * If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`.
     * 
     */
    @JsonProperty("successors")
    public void setSuccessors(List<String> successors) {
        this.successors = successors;
    }

    public ApiResource withSuccessors(List<String> successors) {
        this.successors = successors;
        return this;
    }

    /**
     * Contains changelog entries that summarize changes with special regards to version and releaseStatus
     * 
     */
    @JsonProperty("changelogEntries")
    public List<ChangelogEntry> getChangelogEntries() {
        return changelogEntries;
    }

    /**
     * Contains changelog entries that summarize changes with special regards to version and releaseStatus
     * 
     */
    @JsonProperty("changelogEntries")
    public void setChangelogEntries(List<ChangelogEntry> changelogEntries) {
        this.changelogEntries = changelogEntries;
    }

    public ApiResource withChangelogEntries(List<ChangelogEntry> changelogEntries) {
        this.changelogEntries = changelogEntries;
        return this;
    }

    /**
     * List of [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the target host.
     * 
     * If the API resource can be accessed through an entry point, it MUST be described here.
     * 
     * The list of entry points MUST not include duplicates.
     * If multiple entry points are provided they MUST be arbitrarily exchangeable without effects.
     * This means that the URLs are just an alias to each other and the `resourceDefinitions` apply to all entry points equally.
     * In case of multiple entry points it is RECOMMENDED to provide a `defaultEntryPoint` through `partOfConsumptionBundles`.
     * The entry point URLs SHOULD match with the target host(s) in the resource definition files (e.g. OpenAPI `servers`).
     * If there is no match, the information in ORD takes precedence.
     * 
     * **Provider View:**
     * If the URL is relative to the system that describes the ORD information,
     * it is RECOMMENDED to use relative references and (if known) to provide the `describedSystemInstance`.`baseUrl`.
     * If the URL is not relative to the described system instance [base URL](../index.md#def-base-url), a full URL MUST be provided.
     * If the entry points are rewritten by middleware - incl. the special case of client/consumer specific entry points - it is RECOMMENDED to provide relative URLs, so only the `describedSystemInstance`.`baseUrl` has to be rewritten.
     * The provider should not have to describe all middleware or consumer specific entry points. If they are enriched later by the aggregator, it MAY omit the entry points.
     * 
     * **Consumer View**:
     * When fetching the information from an ORD Aggregator, the consumer MAY rely on receiving full URLs.
     * 
     */
    @JsonProperty("entryPoints")
    public List<String> getEntryPoints() {
        return entryPoints;
    }

    /**
     * List of [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the target host.
     * 
     * If the API resource can be accessed through an entry point, it MUST be described here.
     * 
     * The list of entry points MUST not include duplicates.
     * If multiple entry points are provided they MUST be arbitrarily exchangeable without effects.
     * This means that the URLs are just an alias to each other and the `resourceDefinitions` apply to all entry points equally.
     * In case of multiple entry points it is RECOMMENDED to provide a `defaultEntryPoint` through `partOfConsumptionBundles`.
     * The entry point URLs SHOULD match with the target host(s) in the resource definition files (e.g. OpenAPI `servers`).
     * If there is no match, the information in ORD takes precedence.
     * 
     * **Provider View:**
     * If the URL is relative to the system that describes the ORD information,
     * it is RECOMMENDED to use relative references and (if known) to provide the `describedSystemInstance`.`baseUrl`.
     * If the URL is not relative to the described system instance [base URL](../index.md#def-base-url), a full URL MUST be provided.
     * If the entry points are rewritten by middleware - incl. the special case of client/consumer specific entry points - it is RECOMMENDED to provide relative URLs, so only the `describedSystemInstance`.`baseUrl` has to be rewritten.
     * The provider should not have to describe all middleware or consumer specific entry points. If they are enriched later by the aggregator, it MAY omit the entry points.
     * 
     * **Consumer View**:
     * When fetching the information from an ORD Aggregator, the consumer MAY rely on receiving full URLs.
     * 
     */
    @JsonProperty("entryPoints")
    public void setEntryPoints(List<String> entryPoints) {
        this.entryPoints = entryPoints;
    }

    public ApiResource withEntryPoints(List<String> entryPoints) {
        this.entryPoints = entryPoints;
        return this;
    }

    /**
     * Direction of the API Resource consumption.
     * If not provided, "inbound" is assumed.
     * 
     * In case of SOAP APIs, the direction is already indicated through the `apiProtocol`, making this property redundant and optional. But if it is provided, it MUST not be in contradiction with the `apiProtocol` direction.
     * 
     */
    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    /**
     * Direction of the API Resource consumption.
     * If not provided, "inbound" is assumed.
     * 
     * In case of SOAP APIs, the direction is already indicated through the `apiProtocol`, making this property redundant and optional. But if it is provided, it MUST not be in contradiction with the `apiProtocol` direction.
     * 
     */
    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public ApiResource withDirection(String direction) {
        this.direction = direction;
        return this;
    }

    /**
     * API Protocol including the protocol version if applicable
     * (Required)
     * 
     */
    @JsonProperty("apiProtocol")
    public String getApiProtocol() {
        return apiProtocol;
    }

    /**
     * API Protocol including the protocol version if applicable
     * (Required)
     * 
     */
    @JsonProperty("apiProtocol")
    public void setApiProtocol(String apiProtocol) {
        this.apiProtocol = apiProtocol;
    }

    public ApiResource withApiProtocol(String apiProtocol) {
        this.apiProtocol = apiProtocol;
        return this;
    }

    /**
     * List of available machine-readable definitions, which describe the resource or capability in detail.
     * 
     * Each definition is to be understood as an alternative description format, describing the same resource / capability.
     * As a consequence the same definition type MUST NOT be provided more than once.
     * 
     * It is RECOMMENDED to provide the definitions as they enable machine-readable use cases.
     * If the definitions are added or changed, the `version` MUST be incremented.
     * An ORD aggregator MAY only (re)fetch the definitions again when the `version` was incremented.
     * 
     */
    @JsonProperty("resourceDefinitions")
    public List<ApiResourceDefinition> getResourceDefinitions() {
        return resourceDefinitions;
    }

    /**
     * List of available machine-readable definitions, which describe the resource or capability in detail.
     * 
     * Each definition is to be understood as an alternative description format, describing the same resource / capability.
     * As a consequence the same definition type MUST NOT be provided more than once.
     * 
     * It is RECOMMENDED to provide the definitions as they enable machine-readable use cases.
     * If the definitions are added or changed, the `version` MUST be incremented.
     * An ORD aggregator MAY only (re)fetch the definitions again when the `version` was incremented.
     * 
     */
    @JsonProperty("resourceDefinitions")
    public void setResourceDefinitions(List<ApiResourceDefinition> resourceDefinitions) {
        this.resourceDefinitions = resourceDefinitions;
    }

    public ApiResource withResourceDefinitions(List<ApiResourceDefinition> resourceDefinitions) {
        this.resourceDefinitions = resourceDefinitions;
        return this;
    }

    /**
     * Declares this API to be a valid implementation of an externally standardized API contract, sub-protocol or protocol variant.
     * 
     * All APIs that share the same implementation standard MAY be treated the same or similar by a consumer client.
     * 
     */
    @JsonProperty("implementationStandard")
    public String getImplementationStandard() {
        return implementationStandard;
    }

    /**
     * Declares this API to be a valid implementation of an externally standardized API contract, sub-protocol or protocol variant.
     * 
     * All APIs that share the same implementation standard MAY be treated the same or similar by a consumer client.
     * 
     */
    @JsonProperty("implementationStandard")
    public void setImplementationStandard(String implementationStandard) {
        this.implementationStandard = implementationStandard;
    }

    public ApiResource withImplementationStandard(String implementationStandard) {
        this.implementationStandard = implementationStandard;
        return this;
    }

    /**
     * If the fixed `implementationStandard` values need to be extended, an arbitrary `customImplementationStandard` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `implementationStandard` is set to `custom`.
     * 
     */
    @JsonProperty("customImplementationStandard")
    public String getCustomImplementationStandard() {
        return customImplementationStandard;
    }

    /**
     * If the fixed `implementationStandard` values need to be extended, an arbitrary `customImplementationStandard` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `implementationStandard` is set to `custom`.
     * 
     */
    @JsonProperty("customImplementationStandard")
    public void setCustomImplementationStandard(String customImplementationStandard) {
        this.customImplementationStandard = customImplementationStandard;
    }

    public ApiResource withCustomImplementationStandard(String customImplementationStandard) {
        this.customImplementationStandard = customImplementationStandard;
        return this;
    }

    /**
     * Full description of the custom implementation standard, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * MUST only be provided if `implementationStandard` is set to `custom`.
     * 
     * SHOULD contain documentation and links that describe the used standard.
     * 
     */
    @JsonProperty("customImplementationStandardDescription")
    public String getCustomImplementationStandardDescription() {
        return customImplementationStandardDescription;
    }

    /**
     * Full description of the custom implementation standard, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * MUST only be provided if `implementationStandard` is set to `custom`.
     * 
     * SHOULD contain documentation and links that describe the used standard.
     * 
     */
    @JsonProperty("customImplementationStandardDescription")
    public void setCustomImplementationStandardDescription(String customImplementationStandardDescription) {
        this.customImplementationStandardDescription = customImplementationStandardDescription;
    }

    public ApiResource withCustomImplementationStandardDescription(String customImplementationStandardDescription) {
        this.customImplementationStandardDescription = customImplementationStandardDescription;
        return this;
    }

    /**
     * A reference to the interface (API contract) that this API implements.
     * Serves as a declaration of compatible implementation of API contract, effectively functioning as an "implementationOf" relationship.
     * 
     * MUST be a valid reference to an (usually external) [API Resource](#api-resource) ORD ID.
     * 
     * All APIs that share the same `compatibleWith` value MAY be treated the same or similar by a consumer client.
     * 
     */
    @JsonProperty("compatibleWith")
    public List<String> getCompatibleWith() {
        return compatibleWith;
    }

    /**
     * A reference to the interface (API contract) that this API implements.
     * Serves as a declaration of compatible implementation of API contract, effectively functioning as an "implementationOf" relationship.
     * 
     * MUST be a valid reference to an (usually external) [API Resource](#api-resource) ORD ID.
     * 
     * All APIs that share the same `compatibleWith` value MAY be treated the same or similar by a consumer client.
     * 
     */
    @JsonProperty("compatibleWith")
    public void setCompatibleWith(List<String> compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public ApiResource withCompatibleWith(List<String> compatibleWith) {
        this.compatibleWith = compatibleWith;
        return this;
    }

    /**
     * Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.
     * 
     */
    @JsonProperty("responsible")
    public String getResponsible() {
        return responsible;
    }

    /**
     * Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.
     * 
     */
    @JsonProperty("responsible")
    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public ApiResource withResponsible(String responsible) {
        this.responsible = responsible;
        return this;
    }

    /**
     * List of use cases (types) how the resource is meant to be used for.
     * 
     * This helps consumers better to understand which use cases had been in mind by the provider
     * and are therefore explicitly supported.
     * This is obviously described from a provider perspective, but stating what consumer use cases it potentially supports.
     * As it's not possible to create a list of options that are mutually exclusive, all options that apply should be provided.
     * 
     * If no array is defined, it is assumed that this information is not provided.
     * 
     */
    @JsonProperty("supportedUseCases")
    public List<String> getSupportedUseCases() {
        return supportedUseCases;
    }

    /**
     * List of use cases (types) how the resource is meant to be used for.
     * 
     * This helps consumers better to understand which use cases had been in mind by the provider
     * and are therefore explicitly supported.
     * This is obviously described from a provider perspective, but stating what consumer use cases it potentially supports.
     * As it's not possible to create a list of options that are mutually exclusive, all options that apply should be provided.
     * 
     * If no array is defined, it is assumed that this information is not provided.
     * 
     */
    @JsonProperty("supportedUseCases")
    public void setSupportedUseCases(List<String> supportedUseCases) {
        this.supportedUseCases = supportedUseCases;
    }

    public ApiResource withSupportedUseCases(List<String> supportedUseCases) {
        this.supportedUseCases = supportedUseCases;
        return this;
    }

    /**
     * Usage
     * <p>
     * Define from where the API resource can be used and accessed
     * 
     */
    @JsonProperty("usage")
    public String getUsage() {
        return usage;
    }

    /**
     * Usage
     * <p>
     * Define from where the API resource can be used and accessed
     * 
     */
    @JsonProperty("usage")
    public void setUsage(String usage) {
        this.usage = usage;
    }

    public ApiResource withUsage(String usage) {
        this.usage = usage;
        return this;
    }

    /**
     * Describes mappings between the API Models of the described resource to the underlying, conceptual entity types.
     * 
     */
    @JsonProperty("entityTypeMappings")
    public List<EntityTypeMapping> getEntityTypeMappings() {
        return entityTypeMappings;
    }

    /**
     * Describes mappings between the API Models of the described resource to the underlying, conceptual entity types.
     * 
     */
    @JsonProperty("entityTypeMappings")
    public void setEntityTypeMappings(List<EntityTypeMapping> entityTypeMappings) {
        this.entityTypeMappings = entityTypeMappings;
    }

    public ApiResource withEntityTypeMappings(List<EntityTypeMapping> entityTypeMappings) {
        this.entityTypeMappings = entityTypeMappings;
        return this;
    }

    /**
     * Optional list of [entity types](#entity-type) that are exposed by the resource.
     * 
     * This replaces `entityTypeMappings`. If both is given, the `exposedEntityTypes` wins.
     * 
     * MUST be a valid reference to an [EntityType](#entity-type) ORD ID.
     * 
     */
    @JsonProperty("exposedEntityTypes")
    public List<ExposedEntityType> getExposedEntityTypes() {
        return exposedEntityTypes;
    }

    /**
     * Optional list of [entity types](#entity-type) that are exposed by the resource.
     * 
     * This replaces `entityTypeMappings`. If both is given, the `exposedEntityTypes` wins.
     * 
     * MUST be a valid reference to an [EntityType](#entity-type) ORD ID.
     * 
     */
    @JsonProperty("exposedEntityTypes")
    public void setExposedEntityTypes(List<ExposedEntityType> exposedEntityTypes) {
        this.exposedEntityTypes = exposedEntityTypes;
    }

    public ApiResource withExposedEntityTypes(List<ExposedEntityType> exposedEntityTypes) {
        this.exposedEntityTypes = exposedEntityTypes;
        return this;
    }

    /**
     * Links with semantic meaning that are specific to API Resources.
     * 
     */
    @JsonProperty("apiResourceLinks")
    public List<APIEventResourceLink> getApiResourceLinks() {
        return apiResourceLinks;
    }

    /**
     * Links with semantic meaning that are specific to API Resources.
     * 
     */
    @JsonProperty("apiResourceLinks")
    public void setApiResourceLinks(List<APIEventResourceLink> apiResourceLinks) {
        this.apiResourceLinks = apiResourceLinks;
    }

    public ApiResource withApiResourceLinks(List<APIEventResourceLink> apiResourceLinks) {
        this.apiResourceLinks = apiResourceLinks;
        return this;
    }

    /**
     * Generic Links with arbitrary meaning and content.
     * 
     * If applicable, `apiResourceLinks` MUST be used instead of generic `links`.
     * 
     */
    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Generic Links with arbitrary meaning and content.
     * 
     * If applicable, `apiResourceLinks` MUST be used instead of generic `links`.
     * 
     */
    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public ApiResource withLinks(List<Link> links) {
        this.links = links;
        return this;
    }

    /**
     * Extensible
     * <p>
     * Contains information about the extensibility of this resource.
     * 
     * If applicable, a description and further resources about extending this resource are provided.
     * 
     */
    @JsonProperty("extensible")
    public Extensible getExtensible() {
        return extensible;
    }

    /**
     * Extensible
     * <p>
     * Contains information about the extensibility of this resource.
     * 
     * If applicable, a description and further resources about extending this resource are provided.
     * 
     */
    @JsonProperty("extensible")
    public void setExtensible(Extensible extensible) {
        this.extensible = extensible;
    }

    public ApiResource withExtensible(Extensible extensible) {
        this.extensible = extensible;
        return this;
    }

    /**
     * List of countries that the package resources are applicable to.
     * 
     * MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).
     * 
     * `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("countries")
    public List<String> getCountries() {
        return countries;
    }

    /**
     * List of countries that the package resources are applicable to.
     * 
     * MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).
     * 
     * `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("countries")
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public ApiResource withCountries(List<String> countries) {
        this.countries = countries;
        return this;
    }

    /**
     * List of line of business tags.
     * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     * 
     * `lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("lineOfBusiness")
    public List<String> getLineOfBusiness() {
        return lineOfBusiness;
    }

    /**
     * List of line of business tags.
     * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     * 
     * `lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("lineOfBusiness")
    public void setLineOfBusiness(List<String> lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }

    public ApiResource withLineOfBusiness(List<String> lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
        return this;
    }

    /**
     * List of industry tags.
     * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     * 
     * `industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("industry")
    public List<String> getIndustry() {
        return industry;
    }

    /**
     * List of industry tags.
     * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     * 
     * `industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("industry")
    public void setIndustry(List<String> industry) {
        this.industry = industry;
    }

    public ApiResource withIndustry(List<String> industry) {
        this.industry = industry;
        return this;
    }

    /**
     * List of free text style tags.
     * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     * 
     * Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    /**
     * List of free text style tags.
     * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     * 
     * Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public ApiResource withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Labels
     * <p>
     * Generic labels that can be applied to most ORD information.
     * They are defined as an object that may have arbitrary keys.
     * The value of a key is an array of strings.
     * 
     * Labels can be used to attach technical information that cannot be expressed natively in ORD.
     * An ORD aggregator should allow to categorize and query information based on the labels provided.
     * 
     * If multiple parties rely on the existence of certain label information,
     * standardization through ORD SHOULD be preferred.
     * 
     * All labels attached to a `Package` will be inherited to the resources they contain.
     * Duplicate labels will be merged by the ORD aggregator according to the following rules:
     * * Values of the same label key will be merged.
     * * Duplicate values of the same label key will be removed.
     * 
     */
    @JsonProperty("labels")
    public Labels getLabels() {
        return labels;
    }

    /**
     * Labels
     * <p>
     * Generic labels that can be applied to most ORD information.
     * They are defined as an object that may have arbitrary keys.
     * The value of a key is an array of strings.
     * 
     * Labels can be used to attach technical information that cannot be expressed natively in ORD.
     * An ORD aggregator should allow to categorize and query information based on the labels provided.
     * 
     * If multiple parties rely on the existence of certain label information,
     * standardization through ORD SHOULD be preferred.
     * 
     * All labels attached to a `Package` will be inherited to the resources they contain.
     * Duplicate labels will be merged by the ORD aggregator according to the following rules:
     * * Values of the same label key will be merged.
     * * Duplicate values of the same label key will be removed.
     * 
     */
    @JsonProperty("labels")
    public void setLabels(Labels labels) {
        this.labels = labels;
    }

    public ApiResource withLabels(Labels labels) {
        this.labels = labels;
        return this;
    }

    /**
     * Documentation Labels
     * <p>
     * Generic documentation labels that can be applied to most ORD information.
     * They are defined as an object that may have arbitrary keys.
     * The value of a key is an array of [CommonMark](https://spec.commonmark.org/) (Markdown) text.
     * 
     * Documentation Labels can be used to attach human readable documentation that cannot be expressed natively in ORD.
     * A documentation tool (like an API Catalog) can use the documentation labels to provide generic documentation "snippets".
     * Due to the given structure they can be displayed e.g. as tables.
     * 
     * The key of the documentation Label is plain-text (MUST not contain line breaks) and denotes the subject matter that is described.
     * The values (multiple can be provided for the same key) are [CommonMark](https://spec.commonmark.org/) (Markdown) text
     * which describes the subject matter or lists options for the key.
     * 
     * In contrast to regular labels, documentation labels are not meant to be used to categorize or query information.
     * 
     */
    @JsonProperty("documentationLabels")
    public DocumentationLabels getDocumentationLabels() {
        return documentationLabels;
    }

    /**
     * Documentation Labels
     * <p>
     * Generic documentation labels that can be applied to most ORD information.
     * They are defined as an object that may have arbitrary keys.
     * The value of a key is an array of [CommonMark](https://spec.commonmark.org/) (Markdown) text.
     * 
     * Documentation Labels can be used to attach human readable documentation that cannot be expressed natively in ORD.
     * A documentation tool (like an API Catalog) can use the documentation labels to provide generic documentation "snippets".
     * Due to the given structure they can be displayed e.g. as tables.
     * 
     * The key of the documentation Label is plain-text (MUST not contain line breaks) and denotes the subject matter that is described.
     * The values (multiple can be provided for the same key) are [CommonMark](https://spec.commonmark.org/) (Markdown) text
     * which describes the subject matter or lists options for the key.
     * 
     * In contrast to regular labels, documentation labels are not meant to be used to categorize or query information.
     * 
     */
    @JsonProperty("documentationLabels")
    public void setDocumentationLabels(DocumentationLabels documentationLabels) {
        this.documentationLabels = documentationLabels;
    }

    public ApiResource withDocumentationLabels(DocumentationLabels documentationLabels) {
        this.documentationLabels = documentationLabels;
        return this;
    }

    /**
     * The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.
     * Depending on the chosen policy level, additional expectations and validations rules will be applied.
     * 
     * The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * 
     */
    @JsonProperty("policyLevel")
    public String getPolicyLevel() {
        return policyLevel;
    }

    /**
     * The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.
     * Depending on the chosen policy level, additional expectations and validations rules will be applied.
     * 
     * The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * 
     */
    @JsonProperty("policyLevel")
    public void setPolicyLevel(String policyLevel) {
        this.policyLevel = policyLevel;
    }

    public ApiResource withPolicyLevel(String policyLevel) {
        this.policyLevel = policyLevel;
        return this;
    }

    /**
     * If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.
     * The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.
     * 
     * MUST only be provided if `policyLevel` is set to `custom`.
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("customPolicyLevel")
    public String getCustomPolicyLevel() {
        return customPolicyLevel;
    }

    /**
     * If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.
     * The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.
     * 
     * MUST only be provided if `policyLevel` is set to `custom`.
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("customPolicyLevel")
    public void setCustomPolicyLevel(String customPolicyLevel) {
        this.customPolicyLevel = customPolicyLevel;
    }

    public ApiResource withCustomPolicyLevel(String customPolicyLevel) {
        this.customPolicyLevel = customPolicyLevel;
        return this;
    }

    /**
     * A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.
     * For each chosen policy level, additional expectations and validations rules will be applied.
     * 
     * Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * A policy level MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("policyLevels")
    public List<String> getPolicyLevels() {
        return policyLevels;
    }

    /**
     * A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.
     * For each chosen policy level, additional expectations and validations rules will be applied.
     * 
     * Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * A policy level MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("policyLevels")
    public void setPolicyLevels(List<String> policyLevels) {
        this.policyLevels = policyLevels;
    }

    public ApiResource withPolicyLevels(List<String> policyLevels) {
        this.policyLevels = policyLevels;
        return this;
    }

    /**
     * All resources that are [system instance aware](../index.md#def-system-instance-aware) should now be put together in one ORD document that has `perspective`: `system-instance`.
     * All resources that are [system instance unaware](../index.md#def-system-instance-unaware) should now be put together in one ORD document that has `perspective`: `system-version`.
     * 
     * Defines whether this ORD resource is **system instance aware**.
     * This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.
     * 
     * If this behavior applies, `systemInstanceAware` MUST be set to true.
     * An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions,
     * not just once per system type, but once per **system instance**.
     * 
     */
    @JsonProperty("systemInstanceAware")
    public Boolean getSystemInstanceAware() {
        return systemInstanceAware;
    }

    /**
     * All resources that are [system instance aware](../index.md#def-system-instance-aware) should now be put together in one ORD document that has `perspective`: `system-instance`.
     * All resources that are [system instance unaware](../index.md#def-system-instance-unaware) should now be put together in one ORD document that has `perspective`: `system-version`.
     * 
     * Defines whether this ORD resource is **system instance aware**.
     * This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.
     * 
     * If this behavior applies, `systemInstanceAware` MUST be set to true.
     * An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions,
     * not just once per system type, but once per **system instance**.
     * 
     */
    @JsonProperty("systemInstanceAware")
    public void setSystemInstanceAware(Boolean systemInstanceAware) {
        this.systemInstanceAware = systemInstanceAware;
    }

    public ApiResource withSystemInstanceAware(Boolean systemInstanceAware) {
        this.systemInstanceAware = systemInstanceAware;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiResource.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ordId");
        sb.append('=');
        sb.append(((this.ordId == null)?"<null>":this.ordId));
        sb.append(',');
        sb.append("localId");
        sb.append('=');
        sb.append(((this.localId == null)?"<null>":this.localId));
        sb.append(',');
        sb.append("correlationIds");
        sb.append('=');
        sb.append(((this.correlationIds == null)?"<null>":this.correlationIds));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("shortDescription");
        sb.append('=');
        sb.append(((this.shortDescription == null)?"<null>":this.shortDescription));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("partOfPackage");
        sb.append('=');
        sb.append(((this.partOfPackage == null)?"<null>":this.partOfPackage));
        sb.append(',');
        sb.append("partOfGroups");
        sb.append('=');
        sb.append(((this.partOfGroups == null)?"<null>":this.partOfGroups));
        sb.append(',');
        sb.append("partOfConsumptionBundles");
        sb.append('=');
        sb.append(((this.partOfConsumptionBundles == null)?"<null>":this.partOfConsumptionBundles));
        sb.append(',');
        sb.append("defaultConsumptionBundle");
        sb.append('=');
        sb.append(((this.defaultConsumptionBundle == null)?"<null>":this.defaultConsumptionBundle));
        sb.append(',');
        sb.append("partOfProducts");
        sb.append('=');
        sb.append(((this.partOfProducts == null)?"<null>":this.partOfProducts));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("lastUpdate");
        sb.append('=');
        sb.append(((this.lastUpdate == null)?"<null>":this.lastUpdate));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null)?"<null>":this.visibility));
        sb.append(',');
        sb.append("releaseStatus");
        sb.append('=');
        sb.append(((this.releaseStatus == null)?"<null>":this.releaseStatus));
        sb.append(',');
        sb.append("disabled");
        sb.append('=');
        sb.append(((this.disabled == null)?"<null>":this.disabled));
        sb.append(',');
        sb.append("minSystemVersion");
        sb.append('=');
        sb.append(((this.minSystemVersion == null)?"<null>":this.minSystemVersion));
        sb.append(',');
        sb.append("deprecationDate");
        sb.append('=');
        sb.append(((this.deprecationDate == null)?"<null>":this.deprecationDate));
        sb.append(',');
        sb.append("sunsetDate");
        sb.append('=');
        sb.append(((this.sunsetDate == null)?"<null>":this.sunsetDate));
        sb.append(',');
        sb.append("successors");
        sb.append('=');
        sb.append(((this.successors == null)?"<null>":this.successors));
        sb.append(',');
        sb.append("changelogEntries");
        sb.append('=');
        sb.append(((this.changelogEntries == null)?"<null>":this.changelogEntries));
        sb.append(',');
        sb.append("entryPoints");
        sb.append('=');
        sb.append(((this.entryPoints == null)?"<null>":this.entryPoints));
        sb.append(',');
        sb.append("direction");
        sb.append('=');
        sb.append(((this.direction == null)?"<null>":this.direction));
        sb.append(',');
        sb.append("apiProtocol");
        sb.append('=');
        sb.append(((this.apiProtocol == null)?"<null>":this.apiProtocol));
        sb.append(',');
        sb.append("resourceDefinitions");
        sb.append('=');
        sb.append(((this.resourceDefinitions == null)?"<null>":this.resourceDefinitions));
        sb.append(',');
        sb.append("implementationStandard");
        sb.append('=');
        sb.append(((this.implementationStandard == null)?"<null>":this.implementationStandard));
        sb.append(',');
        sb.append("customImplementationStandard");
        sb.append('=');
        sb.append(((this.customImplementationStandard == null)?"<null>":this.customImplementationStandard));
        sb.append(',');
        sb.append("customImplementationStandardDescription");
        sb.append('=');
        sb.append(((this.customImplementationStandardDescription == null)?"<null>":this.customImplementationStandardDescription));
        sb.append(',');
        sb.append("compatibleWith");
        sb.append('=');
        sb.append(((this.compatibleWith == null)?"<null>":this.compatibleWith));
        sb.append(',');
        sb.append("responsible");
        sb.append('=');
        sb.append(((this.responsible == null)?"<null>":this.responsible));
        sb.append(',');
        sb.append("supportedUseCases");
        sb.append('=');
        sb.append(((this.supportedUseCases == null)?"<null>":this.supportedUseCases));
        sb.append(',');
        sb.append("usage");
        sb.append('=');
        sb.append(((this.usage == null)?"<null>":this.usage));
        sb.append(',');
        sb.append("entityTypeMappings");
        sb.append('=');
        sb.append(((this.entityTypeMappings == null)?"<null>":this.entityTypeMappings));
        sb.append(',');
        sb.append("exposedEntityTypes");
        sb.append('=');
        sb.append(((this.exposedEntityTypes == null)?"<null>":this.exposedEntityTypes));
        sb.append(',');
        sb.append("apiResourceLinks");
        sb.append('=');
        sb.append(((this.apiResourceLinks == null)?"<null>":this.apiResourceLinks));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("extensible");
        sb.append('=');
        sb.append(((this.extensible == null)?"<null>":this.extensible));
        sb.append(',');
        sb.append("countries");
        sb.append('=');
        sb.append(((this.countries == null)?"<null>":this.countries));
        sb.append(',');
        sb.append("lineOfBusiness");
        sb.append('=');
        sb.append(((this.lineOfBusiness == null)?"<null>":this.lineOfBusiness));
        sb.append(',');
        sb.append("industry");
        sb.append('=');
        sb.append(((this.industry == null)?"<null>":this.industry));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
        sb.append(',');
        sb.append("documentationLabels");
        sb.append('=');
        sb.append(((this.documentationLabels == null)?"<null>":this.documentationLabels));
        sb.append(',');
        sb.append("policyLevel");
        sb.append('=');
        sb.append(((this.policyLevel == null)?"<null>":this.policyLevel));
        sb.append(',');
        sb.append("customPolicyLevel");
        sb.append('=');
        sb.append(((this.customPolicyLevel == null)?"<null>":this.customPolicyLevel));
        sb.append(',');
        sb.append("policyLevels");
        sb.append('=');
        sb.append(((this.policyLevels == null)?"<null>":this.policyLevels));
        sb.append(',');
        sb.append("systemInstanceAware");
        sb.append('=');
        sb.append(((this.systemInstanceAware == null)?"<null>":this.systemInstanceAware));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.deprecationDate == null)? 0 :this.deprecationDate.hashCode()));
        result = ((result* 31)+((this.customImplementationStandard == null)? 0 :this.customImplementationStandard.hashCode()));
        result = ((result* 31)+((this.lineOfBusiness == null)? 0 :this.lineOfBusiness.hashCode()));
        result = ((result* 31)+((this.entryPoints == null)? 0 :this.entryPoints.hashCode()));
        result = ((result* 31)+((this.exposedEntityTypes == null)? 0 :this.exposedEntityTypes.hashCode()));
        result = ((result* 31)+((this.defaultConsumptionBundle == null)? 0 :this.defaultConsumptionBundle.hashCode()));
        result = ((result* 31)+((this.usage == null)? 0 :this.usage.hashCode()));
        result = ((result* 31)+((this.entityTypeMappings == null)? 0 :this.entityTypeMappings.hashCode()));
        result = ((result* 31)+((this.successors == null)? 0 :this.successors.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.partOfPackage == null)? 0 :this.partOfPackage.hashCode()));
        result = ((result* 31)+((this.customImplementationStandardDescription == null)? 0 :this.customImplementationStandardDescription.hashCode()));
        result = ((result* 31)+((this.industry == null)? 0 :this.industry.hashCode()));
        result = ((result* 31)+((this.customPolicyLevel == null)? 0 :this.customPolicyLevel.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        result = ((result* 31)+((this.localId == null)? 0 :this.localId.hashCode()));
        result = ((result* 31)+((this.policyLevels == null)? 0 :this.policyLevels.hashCode()));
        result = ((result* 31)+((this.correlationIds == null)? 0 :this.correlationIds.hashCode()));
        result = ((result* 31)+((this.responsible == null)? 0 :this.responsible.hashCode()));
        result = ((result* 31)+((this.releaseStatus == null)? 0 :this.releaseStatus.hashCode()));
        result = ((result* 31)+((this.disabled == null)? 0 :this.disabled.hashCode()));
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        result = ((result* 31)+((this.minSystemVersion == null)? 0 :this.minSystemVersion.hashCode()));
        result = ((result* 31)+((this.resourceDefinitions == null)? 0 :this.resourceDefinitions.hashCode()));
        result = ((result* 31)+((this.extensible == null)? 0 :this.extensible.hashCode()));
        result = ((result* 31)+((this.direction == null)? 0 :this.direction.hashCode()));
        result = ((result* 31)+((this.supportedUseCases == null)? 0 :this.supportedUseCases.hashCode()));
        result = ((result* 31)+((this.visibility == null)? 0 :this.visibility.hashCode()));
        result = ((result* 31)+((this.compatibleWith == null)? 0 :this.compatibleWith.hashCode()));
        result = ((result* 31)+((this.implementationStandard == null)? 0 :this.implementationStandard.hashCode()));
        result = ((result* 31)+((this.partOfConsumptionBundles == null)? 0 :this.partOfConsumptionBundles.hashCode()));
        result = ((result* 31)+((this.sunsetDate == null)? 0 :this.sunsetDate.hashCode()));
        result = ((result* 31)+((this.shortDescription == null)? 0 :this.shortDescription.hashCode()));
        result = ((result* 31)+((this.countries == null)? 0 :this.countries.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.apiProtocol == null)? 0 :this.apiProtocol.hashCode()));
        result = ((result* 31)+((this.systemInstanceAware == null)? 0 :this.systemInstanceAware.hashCode()));
        result = ((result* 31)+((this.changelogEntries == null)? 0 :this.changelogEntries.hashCode()));
        result = ((result* 31)+((this.partOfGroups == null)? 0 :this.partOfGroups.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        result = ((result* 31)+((this.partOfProducts == null)? 0 :this.partOfProducts.hashCode()));
        result = ((result* 31)+((this.policyLevel == null)? 0 :this.policyLevel.hashCode()));
        result = ((result* 31)+((this.documentationLabels == null)? 0 :this.documentationLabels.hashCode()));
        result = ((result* 31)+((this.lastUpdate == null)? 0 :this.lastUpdate.hashCode()));
        result = ((result* 31)+((this.apiResourceLinks == null)? 0 :this.apiResourceLinks.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApiResource) == false) {
            return false;
        }
        ApiResource rhs = ((ApiResource) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((this.deprecationDate == rhs.deprecationDate)||((this.deprecationDate!= null)&&this.deprecationDate.equals(rhs.deprecationDate)))&&((this.customImplementationStandard == rhs.customImplementationStandard)||((this.customImplementationStandard!= null)&&this.customImplementationStandard.equals(rhs.customImplementationStandard))))&&((this.lineOfBusiness == rhs.lineOfBusiness)||((this.lineOfBusiness!= null)&&this.lineOfBusiness.equals(rhs.lineOfBusiness))))&&((this.entryPoints == rhs.entryPoints)||((this.entryPoints!= null)&&this.entryPoints.equals(rhs.entryPoints))))&&((this.exposedEntityTypes == rhs.exposedEntityTypes)||((this.exposedEntityTypes!= null)&&this.exposedEntityTypes.equals(rhs.exposedEntityTypes))))&&((this.defaultConsumptionBundle == rhs.defaultConsumptionBundle)||((this.defaultConsumptionBundle!= null)&&this.defaultConsumptionBundle.equals(rhs.defaultConsumptionBundle))))&&((this.usage == rhs.usage)||((this.usage!= null)&&this.usage.equals(rhs.usage))))&&((this.entityTypeMappings == rhs.entityTypeMappings)||((this.entityTypeMappings!= null)&&this.entityTypeMappings.equals(rhs.entityTypeMappings))))&&((this.successors == rhs.successors)||((this.successors!= null)&&this.successors.equals(rhs.successors))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.partOfPackage == rhs.partOfPackage)||((this.partOfPackage!= null)&&this.partOfPackage.equals(rhs.partOfPackage))))&&((this.customImplementationStandardDescription == rhs.customImplementationStandardDescription)||((this.customImplementationStandardDescription!= null)&&this.customImplementationStandardDescription.equals(rhs.customImplementationStandardDescription))))&&((this.industry == rhs.industry)||((this.industry!= null)&&this.industry.equals(rhs.industry))))&&((this.customPolicyLevel == rhs.customPolicyLevel)||((this.customPolicyLevel!= null)&&this.customPolicyLevel.equals(rhs.customPolicyLevel))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.localId == rhs.localId)||((this.localId!= null)&&this.localId.equals(rhs.localId))))&&((this.policyLevels == rhs.policyLevels)||((this.policyLevels!= null)&&this.policyLevels.equals(rhs.policyLevels))))&&((this.correlationIds == rhs.correlationIds)||((this.correlationIds!= null)&&this.correlationIds.equals(rhs.correlationIds))))&&((this.responsible == rhs.responsible)||((this.responsible!= null)&&this.responsible.equals(rhs.responsible))))&&((this.releaseStatus == rhs.releaseStatus)||((this.releaseStatus!= null)&&this.releaseStatus.equals(rhs.releaseStatus))))&&((this.disabled == rhs.disabled)||((this.disabled!= null)&&this.disabled.equals(rhs.disabled))))&&((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links))))&&((this.minSystemVersion == rhs.minSystemVersion)||((this.minSystemVersion!= null)&&this.minSystemVersion.equals(rhs.minSystemVersion))))&&((this.resourceDefinitions == rhs.resourceDefinitions)||((this.resourceDefinitions!= null)&&this.resourceDefinitions.equals(rhs.resourceDefinitions))))&&((this.extensible == rhs.extensible)||((this.extensible!= null)&&this.extensible.equals(rhs.extensible))))&&((this.direction == rhs.direction)||((this.direction!= null)&&this.direction.equals(rhs.direction))))&&((this.supportedUseCases == rhs.supportedUseCases)||((this.supportedUseCases!= null)&&this.supportedUseCases.equals(rhs.supportedUseCases))))&&((this.visibility == rhs.visibility)||((this.visibility!= null)&&this.visibility.equals(rhs.visibility))))&&((this.compatibleWith == rhs.compatibleWith)||((this.compatibleWith!= null)&&this.compatibleWith.equals(rhs.compatibleWith))))&&((this.implementationStandard == rhs.implementationStandard)||((this.implementationStandard!= null)&&this.implementationStandard.equals(rhs.implementationStandard))))&&((this.partOfConsumptionBundles == rhs.partOfConsumptionBundles)||((this.partOfConsumptionBundles!= null)&&this.partOfConsumptionBundles.equals(rhs.partOfConsumptionBundles))))&&((this.sunsetDate == rhs.sunsetDate)||((this.sunsetDate!= null)&&this.sunsetDate.equals(rhs.sunsetDate))))&&((this.shortDescription == rhs.shortDescription)||((this.shortDescription!= null)&&this.shortDescription.equals(rhs.shortDescription))))&&((this.countries == rhs.countries)||((this.countries!= null)&&this.countries.equals(rhs.countries))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.apiProtocol == rhs.apiProtocol)||((this.apiProtocol!= null)&&this.apiProtocol.equals(rhs.apiProtocol))))&&((this.systemInstanceAware == rhs.systemInstanceAware)||((this.systemInstanceAware!= null)&&this.systemInstanceAware.equals(rhs.systemInstanceAware))))&&((this.changelogEntries == rhs.changelogEntries)||((this.changelogEntries!= null)&&this.changelogEntries.equals(rhs.changelogEntries))))&&((this.partOfGroups == rhs.partOfGroups)||((this.partOfGroups!= null)&&this.partOfGroups.equals(rhs.partOfGroups))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.partOfProducts == rhs.partOfProducts)||((this.partOfProducts!= null)&&this.partOfProducts.equals(rhs.partOfProducts))))&&((this.policyLevel == rhs.policyLevel)||((this.policyLevel!= null)&&this.policyLevel.equals(rhs.policyLevel))))&&((this.documentationLabels == rhs.documentationLabels)||((this.documentationLabels!= null)&&this.documentationLabels.equals(rhs.documentationLabels))))&&((this.lastUpdate == rhs.lastUpdate)||((this.lastUpdate!= null)&&this.lastUpdate.equals(rhs.lastUpdate))))&&((this.apiResourceLinks == rhs.apiResourceLinks)||((this.apiResourceLinks!= null)&&this.apiResourceLinks.equals(rhs.apiResourceLinks))));
    }

}
