
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
 * Agent
 * <p>
 * An **Agent** provides a high-level description of an AI-powered autonomous system that can perform tasks, make decisions, and interact with users or other systems to achieve specific business goals.
 * 
 * An Agent can relate to specific entity types it works with, declare integration dependencies on external systems it requires, and expose its capabilities through APIs using protocols like A2A (Agent-to-Agent).
 * 
 * Agents enable intelligent automation and decision-making within business processes by providing semantic understanding and context-aware capabilities beyond traditional API-based integrations.
 * 
 * For more details, see [AI Agents and Protocols](../concepts/ai-agents-and-protocols.md).
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
    "version",
    "lastUpdate",
    "visibility",
    "releaseStatus",
    "disabled",
    "minSystemVersion",
    "partOfProducts",
    "responsible",
    "deprecationDate",
    "sunsetDate",
    "successors",
    "changelogEntries",
    "policyLevels",
    "countries",
    "lineOfBusiness",
    "industry",
    "relatedEntityTypes",
    "exposedApiResources",
    "integrationDependencies",
    "links",
    "tags",
    "labels",
    "documentationLabels"
})
@Generated("jsonschema2pojo")
public class Agent {

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
     * For example: If a resource within a `Package` changes, but the Package itself did not, the Package version does not need to be incremented.
     * (Required)
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("The complete [SemVer](https://semver.org/) version string.\n\nIt MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.\nIt SHOULD be changed if the ORD information or referenced resource definitions changed.\nIt SHOULD express minor and patch changes that don't lead to incompatible changes.\n\nWhen the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical.\nIn case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://spec.openapis.org/oas/v3.1.1.html#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.\n\nIf the resource has been extended by the user, the change MUST be indicated via `lastUpdate`.\nThe `version` MUST not be bumped for changes in extensions.\n\nThe general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.\n\nNote: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly.\nFor example: If a resource within a `Package` changes, but the Package itself did not, the Package version does not need to be incremented.")
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
     * If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance-aware perspective.
     * 
     * This property can only reflect the knowledge of the described system instance itself.
     * Outside factors for availability can't need to be considered (e.g. network connectivity, middlewares).
     * 
     * A disabled resource MAY skip describing its resource definitions.
     * 
     * 
     */
    @JsonProperty("disabled")
    @JsonPropertyDescription("Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so.\nThis can happen either because it has not been setup for use or disabled by an admin / user.\n\nIf the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance-aware perspective.\n\nThis property can only reflect the knowledge of the described system instance itself.\nOutside factors for availability can't need to be considered (e.g. network connectivity, middlewares).\n\nA disabled resource MAY skip describing its resource definitions.\n")
    private Boolean disabled = false;
    /**
     * The resource has been introduced in the given [system version](../index.md#system-version).
     * This implies that the resource is only available if the system instance is of at least that system version.
     * 
     * It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.
     * 
     */
    @JsonProperty("minSystemVersion")
    @JsonPropertyDescription("The resource has been introduced in the given [system version](../index.md#system-version).\nThis implies that the resource is only available if the system instance is of at least that system version.\n\nIt MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.")
    private String minSystemVersion;
    /**
     * List of products the resources of the Package are a part of.
     * 
     * MUST be a valid reference to a [Product](#product) ORD ID.
     * 
     * `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("partOfProducts")
    @JsonPropertyDescription("List of products the resources of the Package are a part of.\n\nMUST be a valid reference to a [Product](#product) ORD ID.\n\n`partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.")
    private List<String> partOfProducts = new ArrayList<String>();
    /**
     * Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.
     * 
     */
    @JsonProperty("responsible")
    @JsonPropertyDescription("Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.")
    private String responsible;
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
     * List of countries that the Package resources are applicable to.
     * 
     * MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).
     * 
     * `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("countries")
    @JsonPropertyDescription("List of countries that the Package resources are applicable to.\n\nMUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).\n\n`countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains.")
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
     * Optional list of related EntityType Resources.
     * 
     * MUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID.
     * 
     */
    @JsonProperty("relatedEntityTypes")
    @JsonPropertyDescription("Optional list of related EntityType Resources.\n\nMUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID.")
    private List<String> relatedEntityTypes = new ArrayList<String>();
    /**
     * Optional list of API Resources that expose the functionality of the agent. Typically using the A2A protocol, but other protocols are possible as well.
     * 
     * MUST be a valid reference to an [API Resource](#api-resource) ORD ID.
     * 
     */
    @JsonProperty("exposedApiResources")
    @JsonPropertyDescription("Optional list of API Resources that expose the functionality of the agent. Typically using the A2A protocol, but other protocols are possible as well.\n\nMUST be a valid reference to an [API Resource](#api-resource) ORD ID.")
    private List<ExposedApiResourcesTarget> exposedApiResources = new ArrayList<ExposedApiResourcesTarget>();
    /**
     * Optional list of integration dependencies that the agent relies on.
     * 
     * MUST be a valid reference to an [Integration Dependency](#integration-dependency) ORD ID.
     * 
     */
    @JsonProperty("integrationDependencies")
    @JsonPropertyDescription("Optional list of integration dependencies that the agent relies on.\n\nMUST be a valid reference to an [Integration Dependency](#integration-dependency) ORD ID.")
    private List<String> integrationDependencies = new ArrayList<String>();
    /**
     * Generic Links with arbitrary meaning and content.
     * 
     */
    @JsonProperty("links")
    @JsonPropertyDescription("Generic Links with arbitrary meaning and content.")
    private List<Link> links = new ArrayList<Link>();
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

    public Agent withOrdId(String ordId) {
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

    public Agent withLocalId(String localId) {
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

    public Agent withCorrelationIds(List<String> correlationIds) {
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

    public Agent withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Plain text short description.
     * 
     * MUST NOT exceed 255 chars.
     * MUST NOT contain line breaks.
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
     * 
     */
    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Agent withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description SHOULD not be excessive in length and is not meant to provide full documentation.
     * Detailed documentation SHOULD be attached as (typed) links.
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
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Agent withDescription(String description) {
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

    public Agent withPartOfPackage(String partOfPackage) {
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

    public Agent withPartOfGroups(List<String> partOfGroups) {
        this.partOfGroups = partOfGroups;
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
     * For example: If a resource within a `Package` changes, but the Package itself did not, the Package version does not need to be incremented.
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
     * For example: If a resource within a `Package` changes, but the Package itself did not, the Package version does not need to be incremented.
     * (Required)
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Agent withVersion(String version) {
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

    public Agent withLastUpdate(Date lastUpdate) {
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

    public Agent withVisibility(String visibility) {
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

    public Agent withReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
        return this;
    }

    /**
     * Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so.
     * This can happen either because it has not been setup for use or disabled by an admin / user.
     * 
     * If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance-aware perspective.
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
     * If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance-aware perspective.
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

    public Agent withDisabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    /**
     * The resource has been introduced in the given [system version](../index.md#system-version).
     * This implies that the resource is only available if the system instance is of at least that system version.
     * 
     * It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.
     * 
     */
    @JsonProperty("minSystemVersion")
    public String getMinSystemVersion() {
        return minSystemVersion;
    }

    /**
     * The resource has been introduced in the given [system version](../index.md#system-version).
     * This implies that the resource is only available if the system instance is of at least that system version.
     * 
     * It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.
     * 
     */
    @JsonProperty("minSystemVersion")
    public void setMinSystemVersion(String minSystemVersion) {
        this.minSystemVersion = minSystemVersion;
    }

    public Agent withMinSystemVersion(String minSystemVersion) {
        this.minSystemVersion = minSystemVersion;
        return this;
    }

    /**
     * List of products the resources of the Package are a part of.
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
     * List of products the resources of the Package are a part of.
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

    public Agent withPartOfProducts(List<String> partOfProducts) {
        this.partOfProducts = partOfProducts;
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

    public Agent withResponsible(String responsible) {
        this.responsible = responsible;
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

    public Agent withDeprecationDate(Date deprecationDate) {
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

    public Agent withSunsetDate(Date sunsetDate) {
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

    public Agent withSuccessors(List<String> successors) {
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

    public Agent withChangelogEntries(List<ChangelogEntry> changelogEntries) {
        this.changelogEntries = changelogEntries;
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

    public Agent withPolicyLevels(List<String> policyLevels) {
        this.policyLevels = policyLevels;
        return this;
    }

    /**
     * List of countries that the Package resources are applicable to.
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
     * List of countries that the Package resources are applicable to.
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

    public Agent withCountries(List<String> countries) {
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

    public Agent withLineOfBusiness(List<String> lineOfBusiness) {
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

    public Agent withIndustry(List<String> industry) {
        this.industry = industry;
        return this;
    }

    /**
     * Optional list of related EntityType Resources.
     * 
     * MUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID.
     * 
     */
    @JsonProperty("relatedEntityTypes")
    public List<String> getRelatedEntityTypes() {
        return relatedEntityTypes;
    }

    /**
     * Optional list of related EntityType Resources.
     * 
     * MUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID.
     * 
     */
    @JsonProperty("relatedEntityTypes")
    public void setRelatedEntityTypes(List<String> relatedEntityTypes) {
        this.relatedEntityTypes = relatedEntityTypes;
    }

    public Agent withRelatedEntityTypes(List<String> relatedEntityTypes) {
        this.relatedEntityTypes = relatedEntityTypes;
        return this;
    }

    /**
     * Optional list of API Resources that expose the functionality of the agent. Typically using the A2A protocol, but other protocols are possible as well.
     * 
     * MUST be a valid reference to an [API Resource](#api-resource) ORD ID.
     * 
     */
    @JsonProperty("exposedApiResources")
    public List<ExposedApiResourcesTarget> getExposedApiResources() {
        return exposedApiResources;
    }

    /**
     * Optional list of API Resources that expose the functionality of the agent. Typically using the A2A protocol, but other protocols are possible as well.
     * 
     * MUST be a valid reference to an [API Resource](#api-resource) ORD ID.
     * 
     */
    @JsonProperty("exposedApiResources")
    public void setExposedApiResources(List<ExposedApiResourcesTarget> exposedApiResources) {
        this.exposedApiResources = exposedApiResources;
    }

    public Agent withExposedApiResources(List<ExposedApiResourcesTarget> exposedApiResources) {
        this.exposedApiResources = exposedApiResources;
        return this;
    }

    /**
     * Optional list of integration dependencies that the agent relies on.
     * 
     * MUST be a valid reference to an [Integration Dependency](#integration-dependency) ORD ID.
     * 
     */
    @JsonProperty("integrationDependencies")
    public List<String> getIntegrationDependencies() {
        return integrationDependencies;
    }

    /**
     * Optional list of integration dependencies that the agent relies on.
     * 
     * MUST be a valid reference to an [Integration Dependency](#integration-dependency) ORD ID.
     * 
     */
    @JsonProperty("integrationDependencies")
    public void setIntegrationDependencies(List<String> integrationDependencies) {
        this.integrationDependencies = integrationDependencies;
    }

    public Agent withIntegrationDependencies(List<String> integrationDependencies) {
        this.integrationDependencies = integrationDependencies;
        return this;
    }

    /**
     * Generic Links with arbitrary meaning and content.
     * 
     */
    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Generic Links with arbitrary meaning and content.
     * 
     */
    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Agent withLinks(List<Link> links) {
        this.links = links;
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

    public Agent withTags(List<String> tags) {
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

    public Agent withLabels(Labels labels) {
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

    public Agent withDocumentationLabels(DocumentationLabels documentationLabels) {
        this.documentationLabels = documentationLabels;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Agent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("partOfProducts");
        sb.append('=');
        sb.append(((this.partOfProducts == null)?"<null>":this.partOfProducts));
        sb.append(',');
        sb.append("responsible");
        sb.append('=');
        sb.append(((this.responsible == null)?"<null>":this.responsible));
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
        sb.append("policyLevels");
        sb.append('=');
        sb.append(((this.policyLevels == null)?"<null>":this.policyLevels));
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
        sb.append("relatedEntityTypes");
        sb.append('=');
        sb.append(((this.relatedEntityTypes == null)?"<null>":this.relatedEntityTypes));
        sb.append(',');
        sb.append("exposedApiResources");
        sb.append('=');
        sb.append(((this.exposedApiResources == null)?"<null>":this.exposedApiResources));
        sb.append(',');
        sb.append("integrationDependencies");
        sb.append('=');
        sb.append(((this.integrationDependencies == null)?"<null>":this.integrationDependencies));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
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
        result = ((result* 31)+((this.lineOfBusiness == null)? 0 :this.lineOfBusiness.hashCode()));
        result = ((result* 31)+((this.successors == null)? 0 :this.successors.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.partOfPackage == null)? 0 :this.partOfPackage.hashCode()));
        result = ((result* 31)+((this.industry == null)? 0 :this.industry.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        result = ((result* 31)+((this.localId == null)? 0 :this.localId.hashCode()));
        result = ((result* 31)+((this.policyLevels == null)? 0 :this.policyLevels.hashCode()));
        result = ((result* 31)+((this.correlationIds == null)? 0 :this.correlationIds.hashCode()));
        result = ((result* 31)+((this.responsible == null)? 0 :this.responsible.hashCode()));
        result = ((result* 31)+((this.releaseStatus == null)? 0 :this.releaseStatus.hashCode()));
        result = ((result* 31)+((this.relatedEntityTypes == null)? 0 :this.relatedEntityTypes.hashCode()));
        result = ((result* 31)+((this.exposedApiResources == null)? 0 :this.exposedApiResources.hashCode()));
        result = ((result* 31)+((this.disabled == null)? 0 :this.disabled.hashCode()));
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        result = ((result* 31)+((this.minSystemVersion == null)? 0 :this.minSystemVersion.hashCode()));
        result = ((result* 31)+((this.visibility == null)? 0 :this.visibility.hashCode()));
        result = ((result* 31)+((this.integrationDependencies == null)? 0 :this.integrationDependencies.hashCode()));
        result = ((result* 31)+((this.sunsetDate == null)? 0 :this.sunsetDate.hashCode()));
        result = ((result* 31)+((this.shortDescription == null)? 0 :this.shortDescription.hashCode()));
        result = ((result* 31)+((this.countries == null)? 0 :this.countries.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.changelogEntries == null)? 0 :this.changelogEntries.hashCode()));
        result = ((result* 31)+((this.partOfGroups == null)? 0 :this.partOfGroups.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        result = ((result* 31)+((this.partOfProducts == null)? 0 :this.partOfProducts.hashCode()));
        result = ((result* 31)+((this.documentationLabels == null)? 0 :this.documentationLabels.hashCode()));
        result = ((result* 31)+((this.lastUpdate == null)? 0 :this.lastUpdate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Agent) == false) {
            return false;
        }
        Agent rhs = ((Agent) other);
        return ((((((((((((((((((((((((((((((((this.deprecationDate == rhs.deprecationDate)||((this.deprecationDate!= null)&&this.deprecationDate.equals(rhs.deprecationDate)))&&((this.lineOfBusiness == rhs.lineOfBusiness)||((this.lineOfBusiness!= null)&&this.lineOfBusiness.equals(rhs.lineOfBusiness))))&&((this.successors == rhs.successors)||((this.successors!= null)&&this.successors.equals(rhs.successors))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.partOfPackage == rhs.partOfPackage)||((this.partOfPackage!= null)&&this.partOfPackage.equals(rhs.partOfPackage))))&&((this.industry == rhs.industry)||((this.industry!= null)&&this.industry.equals(rhs.industry))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.localId == rhs.localId)||((this.localId!= null)&&this.localId.equals(rhs.localId))))&&((this.policyLevels == rhs.policyLevels)||((this.policyLevels!= null)&&this.policyLevels.equals(rhs.policyLevels))))&&((this.correlationIds == rhs.correlationIds)||((this.correlationIds!= null)&&this.correlationIds.equals(rhs.correlationIds))))&&((this.responsible == rhs.responsible)||((this.responsible!= null)&&this.responsible.equals(rhs.responsible))))&&((this.releaseStatus == rhs.releaseStatus)||((this.releaseStatus!= null)&&this.releaseStatus.equals(rhs.releaseStatus))))&&((this.relatedEntityTypes == rhs.relatedEntityTypes)||((this.relatedEntityTypes!= null)&&this.relatedEntityTypes.equals(rhs.relatedEntityTypes))))&&((this.exposedApiResources == rhs.exposedApiResources)||((this.exposedApiResources!= null)&&this.exposedApiResources.equals(rhs.exposedApiResources))))&&((this.disabled == rhs.disabled)||((this.disabled!= null)&&this.disabled.equals(rhs.disabled))))&&((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links))))&&((this.minSystemVersion == rhs.minSystemVersion)||((this.minSystemVersion!= null)&&this.minSystemVersion.equals(rhs.minSystemVersion))))&&((this.visibility == rhs.visibility)||((this.visibility!= null)&&this.visibility.equals(rhs.visibility))))&&((this.integrationDependencies == rhs.integrationDependencies)||((this.integrationDependencies!= null)&&this.integrationDependencies.equals(rhs.integrationDependencies))))&&((this.sunsetDate == rhs.sunsetDate)||((this.sunsetDate!= null)&&this.sunsetDate.equals(rhs.sunsetDate))))&&((this.shortDescription == rhs.shortDescription)||((this.shortDescription!= null)&&this.shortDescription.equals(rhs.shortDescription))))&&((this.countries == rhs.countries)||((this.countries!= null)&&this.countries.equals(rhs.countries))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.changelogEntries == rhs.changelogEntries)||((this.changelogEntries!= null)&&this.changelogEntries.equals(rhs.changelogEntries))))&&((this.partOfGroups == rhs.partOfGroups)||((this.partOfGroups!= null)&&this.partOfGroups.equals(rhs.partOfGroups))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.partOfProducts == rhs.partOfProducts)||((this.partOfProducts!= null)&&this.partOfProducts.equals(rhs.partOfProducts))))&&((this.documentationLabels == rhs.documentationLabels)||((this.documentationLabels!= null)&&this.documentationLabels.equals(rhs.documentationLabels))))&&((this.lastUpdate == rhs.lastUpdate)||((this.lastUpdate!= null)&&this.lastUpdate.equals(rhs.lastUpdate))));
    }

}
