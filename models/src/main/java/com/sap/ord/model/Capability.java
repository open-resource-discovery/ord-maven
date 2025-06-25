
package com.sap.ord.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Capability
 * <p>
 * Capabilities can be used to describe use case specific capabilities, most notably supported features or additional information (like configuration) that needs to be understood from outside.
 * This is a generic ORD concept that aims to cover many different capability discovery use cases that would otherwise need be implemented as individual service provider interfaces (SPIs).
 * 
 * If a capability needs to expose more information than possible with generic capability properties, a custom capability definition can be defined and referenced in ORD.
 * This is the same idea and mechanism as with API resources and their resource definition formats.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId",
    "localId",
    "correlationIds",
    "type",
    "customType",
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
    "relatedEntityTypes",
    "definitions",
    "links",
    "tags",
    "labels",
    "documentationLabels",
    "systemInstanceAware"
})
public class Capability {

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
     * Type of the Capability
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of the Capability")
    private String type;
    /**
     * If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customType")
    @JsonPropertyDescription("If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.\n\nMUST be a valid [Specification ID](../index.md#specification-id).\n\nMUST only be provided if `type` is set to `custom`.")
    private String customType;
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
     * Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.
     * 
     */
    @JsonProperty("lastUpdate")
    @JsonPropertyDescription("Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.\n\nThe date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).\n\nWhen retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time.\nTherefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.\n\nIf the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.\n\nTogether with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.")
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
     * Optional list of related EntityType Resources.
     * MUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID.
     * 
     */
    @JsonProperty("relatedEntityTypes")
    @JsonPropertyDescription("Optional list of related EntityType Resources.\nMUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID.")
    private List<String> relatedEntityTypes = new ArrayList<String>();
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
    @JsonProperty("definitions")
    @JsonPropertyDescription("List of available machine-readable definitions, which describe the resource or capability in detail.\n\nEach definition is to be understood as an alternative description format, describing the same resource / capability.\nAs a consequence the same definition type MUST NOT be provided more than once.\n\nIt is RECOMMENDED to provide the definitions as they enable machine-readable use cases.\nIf the definitions are added or changed, the `version` MUST be incremented.\nAn ORD aggregator MAY only (re)fetch the definitions again when the `version` was incremented.")
    private List<CapabilityDefinition> definitions = new ArrayList<CapabilityDefinition>();
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
     * Defines whether this ORD resource is **system instance aware**.
     * This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.
     * 
     * If this behavior applies, `systemInstanceAware` MUST be set to true.
     * An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions,
     * not just once per system type, but once per **system instance**.
     * 
     */
    @JsonProperty("systemInstanceAware")
    @JsonPropertyDescription("Defines whether this ORD resource is **system instance aware**.\nThis is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.\n\nIf this behavior applies, `systemInstanceAware` MUST be set to true.\nAn ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions,\nnot just once per system type, but once per **system instance**.")
    private Boolean systemInstanceAware = false;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Capability() {
    }

    /**
     * 
     * @param visibility
     *     The visibility states who is allowed to "see" the described resource or capability.
     * @param description
     *     Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     *     
     *     The description SHOULD not be excessive in length and is not meant to provide full documentation.
     *     Detailed documentation SHOULD be attached as (typed) links.
     * @param partOfPackage
     *     Defines which Package the resource is part of.
     *     
     *     MUST be a valid reference to a [Package](#package) ORD ID.
     *     
     *     Every resource MUST be part of one package.
     * @param shortDescription
     *     Plain text short description.
     *     
     *     MUST NOT exceed 255 chars.
     *     MUST NOT contain line breaks.
     * @param type
     *     Type of the Capability.
     * @param title
     *     Human-readable title.
     *     
     *     MUST NOT exceed 255 chars.
     *     MUST NOT contain line breaks.
     * @param ordId
     *     The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.
     *     
     *     It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.
     * @param localId
     *     The locally unique ID under which this resource can be looked up / resolved in the described system itself.
     *     Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.
     *     
     *     It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID.
     *     But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID.
     * @param version
     *     The complete [SemVer](https://semver.org/) version string.
     *     
     *     It MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.
     *     It SHOULD be changed if the ORD information or referenced resource definitions changed.
     *     It SHOULD express minor and patch changes that don't lead to incompatible changes.
     *     
     *     When the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical.
     *     In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://spec.openapis.org/oas/v3.1.1.html#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.
     *     
     *     If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`.
     *     The `version` MUST not be bumped for changes in extensions.
     *     
     *     The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.
     *     
     *     Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly.
     *     For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented.
     * @param systemInstanceAware
     *     Defines whether this ORD resource is **system instance aware**.
     *     This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.
     *     
     *     If this behavior applies, `systemInstanceAware` MUST be set to true.
     *     An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions,
     *     not just once per system type, but once per **system instance**.
     * @param partOfGroups
     *     Defines which groups the resource is assigned to.
     *     
     *     The property is optional, but if given the value MUST be an array of valid Group IDs.
     *     
     *     Groups are a lightweight custom taxonomy concept.
     *     They express a "part of" relationship to the chosen group concept.
     *     If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.
     *     
     *     All resources that share the same group ID assignment are effectively grouped together.
     * @param tags
     *     List of free text style tags.
     *     No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     *     
     *     Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * @param customType
     *     If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     *     
     *     MUST be a valid [Specification ID](../index.md#specification-id).
     *     
     *     MUST only be provided if `type` is set to `custom`.
     * @param correlationIds
     *     Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).
     *     
     *     They express an "identity" / "equals" / "mappable" relationship to the target ID.
     *     
     *     If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.
     *     
     *     MUST be a valid [Correlation ID](../index.md#correlation-id).
     * @param lastUpdate
     *     Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.
     *     
     *     The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     *     
     *     When retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time.
     *     Therefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.
     *     
     *     If the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.
     *     
     *     Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.
     * @param releaseStatus
     *     The `releaseStatus` specifies the stability of the resource and its external contract.
     * @param relatedEntityTypes
     *     Optional list of related EntityType Resources.
     *     MUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID.
     * @param disabled
     *     Indicates that this resource is currently not available for consumption at runtime, but could be configured to be so.
     *     This can happen either because it has not been setup for use or disabled by an admin / user.
     *     
     *     If the resource is not available in principle for a particular system instance, e.g. due to lack of entitlement, it MUST not be described in the system-instance aware perspective.
     *     
     *     This property can only reflect the knowledge of the described system instance itself.
     *     Outside factors for availability can't need to be considered (e.g. network connectivity, middlewares).
     *     
     *     A disabled resource MAY skip describing its resource definitions.
     *     .
     * @param links
     *     Generic Links with arbitrary meaning and content.
     * @param minSystemVersion
     *     The resource has been introduced in the given [system version](../index.md#def-system-version).
     *     This implies that the resource is only available if the system instance is of at least that system version.
     * @param definitions
     *     List of available machine-readable definitions, which describe the resource or capability in detail.
     *     
     *     Each definition is to be understood as an alternative description format, describing the same resource / capability.
     *     As a consequence the same definition type MUST NOT be provided more than once.
     *     
     *     It is RECOMMENDED to provide the definitions as they enable machine-readable use cases.
     *     If the definitions are added or changed, the `version` MUST be incremented.
     *     An ORD aggregator MAY only (re)fetch the definitions again when the `version` was incremented.
     */
    public Capability(String ordId, String localId, List<String> correlationIds, String type, String customType, String title, String shortDescription, String description, String partOfPackage, List<String> partOfGroups, String version, Date lastUpdate, String visibility, String releaseStatus, Boolean disabled, String minSystemVersion, List<String> relatedEntityTypes, List<CapabilityDefinition> definitions, List<Link> links, List<String> tags, Labels labels, DocumentationLabels documentationLabels, Boolean systemInstanceAware) {
        super();
        this.ordId = ordId;
        this.localId = localId;
        this.correlationIds = correlationIds;
        this.type = type;
        this.customType = customType;
        this.title = title;
        this.shortDescription = shortDescription;
        this.description = description;
        this.partOfPackage = partOfPackage;
        this.partOfGroups = partOfGroups;
        this.version = version;
        this.lastUpdate = lastUpdate;
        this.visibility = visibility;
        this.releaseStatus = releaseStatus;
        this.disabled = disabled;
        this.minSystemVersion = minSystemVersion;
        this.relatedEntityTypes = relatedEntityTypes;
        this.definitions = definitions;
        this.links = links;
        this.tags = tags;
        this.labels = labels;
        this.documentationLabels = documentationLabels;
        this.systemInstanceAware = systemInstanceAware;
    }

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

    public Capability withOrdId(String ordId) {
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

    public Capability withLocalId(String localId) {
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

    public Capability withCorrelationIds(List<String> correlationIds) {
        this.correlationIds = correlationIds;
        return this;
    }

    /**
     * Type of the Capability
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type of the Capability
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Capability withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customType")
    public String getCustomType() {
        return customType;
    }

    /**
     * If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customType")
    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public Capability withCustomType(String customType) {
        this.customType = customType;
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

    public Capability withTitle(String title) {
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

    public Capability withShortDescription(String shortDescription) {
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

    public Capability withDescription(String description) {
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

    public Capability withPartOfPackage(String partOfPackage) {
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

    public Capability withPartOfGroups(List<String> partOfGroups) {
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

    public Capability withVersion(String version) {
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
     * Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.
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
     * Together with `systemInstanceAware`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.
     * 
     */
    @JsonProperty("lastUpdate")
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Capability withLastUpdate(Date lastUpdate) {
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

    public Capability withVisibility(String visibility) {
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

    public Capability withReleaseStatus(String releaseStatus) {
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

    public Capability withDisabled(Boolean disabled) {
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

    public Capability withMinSystemVersion(String minSystemVersion) {
        this.minSystemVersion = minSystemVersion;
        return this;
    }

    /**
     * Optional list of related EntityType Resources.
     * MUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID.
     * 
     */
    @JsonProperty("relatedEntityTypes")
    public List<String> getRelatedEntityTypes() {
        return relatedEntityTypes;
    }

    /**
     * Optional list of related EntityType Resources.
     * MUST be a valid reference to an [EntityType Resource](#entity-type) ORD ID.
     * 
     */
    @JsonProperty("relatedEntityTypes")
    public void setRelatedEntityTypes(List<String> relatedEntityTypes) {
        this.relatedEntityTypes = relatedEntityTypes;
    }

    public Capability withRelatedEntityTypes(List<String> relatedEntityTypes) {
        this.relatedEntityTypes = relatedEntityTypes;
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
    @JsonProperty("definitions")
    public List<CapabilityDefinition> getDefinitions() {
        return definitions;
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
    @JsonProperty("definitions")
    public void setDefinitions(List<CapabilityDefinition> definitions) {
        this.definitions = definitions;
    }

    public Capability withDefinitions(List<CapabilityDefinition> definitions) {
        this.definitions = definitions;
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

    public Capability withLinks(List<Link> links) {
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

    public Capability withTags(List<String> tags) {
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

    public Capability withLabels(Labels labels) {
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

    public Capability withDocumentationLabels(DocumentationLabels documentationLabels) {
        this.documentationLabels = documentationLabels;
        return this;
    }

    /**
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

    public Capability withSystemInstanceAware(Boolean systemInstanceAware) {
        this.systemInstanceAware = systemInstanceAware;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Capability.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("customType");
        sb.append('=');
        sb.append(((this.customType == null)?"<null>":this.customType));
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
        sb.append("relatedEntityTypes");
        sb.append('=');
        sb.append(((this.relatedEntityTypes == null)?"<null>":this.relatedEntityTypes));
        sb.append(',');
        sb.append("definitions");
        sb.append('=');
        sb.append(((this.definitions == null)?"<null>":this.definitions));
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
        result = ((result* 31)+((this.visibility == null)? 0 :this.visibility.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.partOfPackage == null)? 0 :this.partOfPackage.hashCode()));
        result = ((result* 31)+((this.shortDescription == null)? 0 :this.shortDescription.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        result = ((result* 31)+((this.localId == null)? 0 :this.localId.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.systemInstanceAware == null)? 0 :this.systemInstanceAware.hashCode()));
        result = ((result* 31)+((this.partOfGroups == null)? 0 :this.partOfGroups.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        result = ((result* 31)+((this.documentationLabels == null)? 0 :this.documentationLabels.hashCode()));
        result = ((result* 31)+((this.customType == null)? 0 :this.customType.hashCode()));
        result = ((result* 31)+((this.correlationIds == null)? 0 :this.correlationIds.hashCode()));
        result = ((result* 31)+((this.lastUpdate == null)? 0 :this.lastUpdate.hashCode()));
        result = ((result* 31)+((this.releaseStatus == null)? 0 :this.releaseStatus.hashCode()));
        result = ((result* 31)+((this.relatedEntityTypes == null)? 0 :this.relatedEntityTypes.hashCode()));
        result = ((result* 31)+((this.disabled == null)? 0 :this.disabled.hashCode()));
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        result = ((result* 31)+((this.minSystemVersion == null)? 0 :this.minSystemVersion.hashCode()));
        result = ((result* 31)+((this.definitions == null)? 0 :this.definitions.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Capability) == false) {
            return false;
        }
        Capability rhs = ((Capability) other);
        return ((((((((((((((((((((((((this.visibility == rhs.visibility)||((this.visibility!= null)&&this.visibility.equals(rhs.visibility)))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.partOfPackage == rhs.partOfPackage)||((this.partOfPackage!= null)&&this.partOfPackage.equals(rhs.partOfPackage))))&&((this.shortDescription == rhs.shortDescription)||((this.shortDescription!= null)&&this.shortDescription.equals(rhs.shortDescription))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.localId == rhs.localId)||((this.localId!= null)&&this.localId.equals(rhs.localId))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.systemInstanceAware == rhs.systemInstanceAware)||((this.systemInstanceAware!= null)&&this.systemInstanceAware.equals(rhs.systemInstanceAware))))&&((this.partOfGroups == rhs.partOfGroups)||((this.partOfGroups!= null)&&this.partOfGroups.equals(rhs.partOfGroups))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.documentationLabels == rhs.documentationLabels)||((this.documentationLabels!= null)&&this.documentationLabels.equals(rhs.documentationLabels))))&&((this.customType == rhs.customType)||((this.customType!= null)&&this.customType.equals(rhs.customType))))&&((this.correlationIds == rhs.correlationIds)||((this.correlationIds!= null)&&this.correlationIds.equals(rhs.correlationIds))))&&((this.lastUpdate == rhs.lastUpdate)||((this.lastUpdate!= null)&&this.lastUpdate.equals(rhs.lastUpdate))))&&((this.releaseStatus == rhs.releaseStatus)||((this.releaseStatus!= null)&&this.releaseStatus.equals(rhs.releaseStatus))))&&((this.relatedEntityTypes == rhs.relatedEntityTypes)||((this.relatedEntityTypes!= null)&&this.relatedEntityTypes.equals(rhs.relatedEntityTypes))))&&((this.disabled == rhs.disabled)||((this.disabled!= null)&&this.disabled.equals(rhs.disabled))))&&((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links))))&&((this.minSystemVersion == rhs.minSystemVersion)||((this.minSystemVersion!= null)&&this.minSystemVersion.equals(rhs.minSystemVersion))))&&((this.definitions == rhs.definitions)||((this.definitions!= null)&&this.definitions.equals(rhs.definitions))));
    }

}
