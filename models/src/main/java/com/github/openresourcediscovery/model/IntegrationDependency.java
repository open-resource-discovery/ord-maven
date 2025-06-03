
package com.github.openresourcediscovery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Integration Dependency
 * <p>
 * An [Integration Dependency](../concepts/integration-dependency) states that the described system (self) can integrate with external systems (integration target) to achieve an integration purpose.
 * The purpose could be to enable a certain feature or integration scenario, but it could also be a mandatory prerequisite for the described system to work.
 * 
 * The integration dependency includes a list of individual **aspects** that the integration consists of.
 * Aspects are an "ingredient" for the integration scenario (and are logically combined with AND condition).
 * Each aspect can express alternatives (OR condition) on what API and event resources can be used to achieve the same outcome.
 * 
 * The direction of connection establishment, data flow is not directly implied and needs to be inferred from the referenced resources.
 * 
 * It is not in scope for the Integration Dependency to describe scenarios that external consumers have with the own exposed resources.
 * This would overstep the boundary of self-description.
 * 
 * If an integration scenario consists of two sides integration with each other, each need to describe its own part in it as an Integration Dependency.
 * Therefore, if an integration with multiple types of systems need to be setup, this SHOULD be separated into distinct Integration Dependencies.
 * 
 * An integration dependency is also not meant to describe a bigger process.
 * Instead it focuses on the technical necessaries to create an integration for one particular purpose.
 * 
 * To learn more about the concept, see [Integration Dependency](../concepts/integration-dependency).
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
    "sunsetDate",
    "successors",
    "mandatory",
    "aspects",
    "relatedIntegrationDependencies",
    "links",
    "tags",
    "labels",
    "documentationLabels"
})
public class IntegrationDependency {

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
     * In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.
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
    @JsonPropertyDescription("The complete [SemVer](https://semver.org/) version string.\n\nIt MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.\nIt SHOULD be changed if the ORD information or referenced resource definitions changed.\nIt SHOULD express minor and patch changes that don't lead to incompatible changes.\n\nWhen the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical.\nIn case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.\n\nIf the resource has been extended by the user, the change MUST be indicated via `lastUpdate`.\nThe `version` MUST not be bumped for changes in extensions.\n\nThe general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.\n\nNote: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly.\nFor example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented.")
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
     * The sunset date defines when the resource is scheduled to be decommissioned/removed.
     * 
     * If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known).
     * Once the sunset date is known and ready to be communicated externally, it MUST be provided here.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     */
    @JsonProperty("sunsetDate")
    @JsonPropertyDescription("The sunset date defines when the resource is scheduled to be decommissioned/removed.\n\nIf the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known).\nOnce the sunset date is known and ready to be communicated externally, it MUST be provided here.\n\nThe date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).")
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
     * If true, the Integration Dependency is mandatory for the described system to function.
     * (Required)
     * 
     */
    @JsonProperty("mandatory")
    @JsonPropertyDescription("If true, the Integration Dependency is mandatory for the described system to function.")
    private Boolean mandatory;
    /**
     * List of integration aspects that make up the Integration Dependency.
     * 
     * Each aspect listed is a dedicated, constituent part (AND condition).
     * 
     */
    @JsonProperty("aspects")
    @JsonPropertyDescription("List of integration aspects that make up the Integration Dependency.\n\nEach aspect listed is a dedicated, constituent part (AND condition).")
    private List<IntegrationAspect> aspects = new ArrayList<IntegrationAspect>();
    /**
     * If an Integration Dependency conceptually belongs or related to another Integration Dependency, this can be indicated here.
     * One situation would be where two systems each have an Integration Dependency to describe a two-sided integration from each side.
     * 
     */
    @JsonProperty("relatedIntegrationDependencies")
    @JsonPropertyDescription("If an Integration Dependency conceptually belongs or related to another Integration Dependency, this can be indicated here.\nOne situation would be where two systems each have an Integration Dependency to describe a two-sided integration from each side.")
    private List<String> relatedIntegrationDependencies = new ArrayList<String>();
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
     * No args constructor for use in serialization
     * 
     */
    public IntegrationDependency() {
    }

    /**
     * 
     * @param visibility
     *     The visibility states who is allowed to "see" the described resource or capability.
     * @param successors
     *     The successor resource(s).
     *     
     *     MUST be a valid reference to an ORD ID.
     *     
     *     If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists.
     *     If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`.
     * @param aspects
     *     List of integration aspects that make up the Integration Dependency.
     *     
     *     Each aspect listed is a dedicated, constituent part (AND condition).
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
     * @param sunsetDate
     *     The sunset date defines when the resource is scheduled to be decommissioned/removed.
     *     
     *     If the `releaseStatus` is set to `deprecated`, the `sunsetDate` SHOULD be provided (if already known).
     *     Once the sunset date is known and ready to be communicated externally, it MUST be provided here.
     *     
     *     The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * @param shortDescription
     *     Plain text short description.
     *     
     *     MUST NOT exceed 255 chars.
     *     MUST NOT contain line breaks.
     * @param relatedIntegrationDependencies
     *     If an Integration Dependency conceptually belongs or related to another Integration Dependency, this can be indicated here.
     *     One situation would be where two systems each have an Integration Dependency to describe a two-sided integration from each side.
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
     *     In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.
     *     
     *     If the resource has been extended by the user, the change MUST be indicated via `lastUpdate`.
     *     The `version` MUST not be bumped for changes in extensions.
     *     
     *     The general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.
     *     
     *     Note: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly.
     *     For example: If a resource within a `Package` changes, but the package itself did not, the package version does not need to be incremented.
     * @param mandatory
     *     If true, the Integration Dependency is mandatory for the described system to function.
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
     * @param links
     *     Generic Links with arbitrary meaning and content.
     */
    public IntegrationDependency(String ordId, String localId, List<String> correlationIds, String title, String shortDescription, String description, String partOfPackage, List<String> partOfGroups, String version, Date lastUpdate, String visibility, String releaseStatus, Date sunsetDate, List<String> successors, Boolean mandatory, List<IntegrationAspect> aspects, List<String> relatedIntegrationDependencies, List<Link> links, List<String> tags, Labels labels, DocumentationLabels documentationLabels) {
        super();
        this.ordId = ordId;
        this.localId = localId;
        this.correlationIds = correlationIds;
        this.title = title;
        this.shortDescription = shortDescription;
        this.description = description;
        this.partOfPackage = partOfPackage;
        this.partOfGroups = partOfGroups;
        this.version = version;
        this.lastUpdate = lastUpdate;
        this.visibility = visibility;
        this.releaseStatus = releaseStatus;
        this.sunsetDate = sunsetDate;
        this.successors = successors;
        this.mandatory = mandatory;
        this.aspects = aspects;
        this.relatedIntegrationDependencies = relatedIntegrationDependencies;
        this.links = links;
        this.tags = tags;
        this.labels = labels;
        this.documentationLabels = documentationLabels;
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

    public IntegrationDependency withOrdId(String ordId) {
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

    public IntegrationDependency withLocalId(String localId) {
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

    public IntegrationDependency withCorrelationIds(List<String> correlationIds) {
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

    public IntegrationDependency withTitle(String title) {
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

    public IntegrationDependency withShortDescription(String shortDescription) {
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

    public IntegrationDependency withDescription(String description) {
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

    public IntegrationDependency withPartOfPackage(String partOfPackage) {
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

    public IntegrationDependency withPartOfGroups(List<String> partOfGroups) {
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
     * In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.
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
     * In case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://swagger.io/specification/#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.
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

    public IntegrationDependency withVersion(String version) {
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

    public IntegrationDependency withLastUpdate(Date lastUpdate) {
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

    public IntegrationDependency withVisibility(String visibility) {
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

    public IntegrationDependency withReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
        return this;
    }

    /**
     * The sunset date defines when the resource is scheduled to be decommissioned/removed.
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
     * The sunset date defines when the resource is scheduled to be decommissioned/removed.
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

    public IntegrationDependency withSunsetDate(Date sunsetDate) {
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

    public IntegrationDependency withSuccessors(List<String> successors) {
        this.successors = successors;
        return this;
    }

    /**
     * If true, the Integration Dependency is mandatory for the described system to function.
     * (Required)
     * 
     */
    @JsonProperty("mandatory")
    public Boolean getMandatory() {
        return mandatory;
    }

    /**
     * If true, the Integration Dependency is mandatory for the described system to function.
     * (Required)
     * 
     */
    @JsonProperty("mandatory")
    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public IntegrationDependency withMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
        return this;
    }

    /**
     * List of integration aspects that make up the Integration Dependency.
     * 
     * Each aspect listed is a dedicated, constituent part (AND condition).
     * 
     */
    @JsonProperty("aspects")
    public List<IntegrationAspect> getAspects() {
        return aspects;
    }

    /**
     * List of integration aspects that make up the Integration Dependency.
     * 
     * Each aspect listed is a dedicated, constituent part (AND condition).
     * 
     */
    @JsonProperty("aspects")
    public void setAspects(List<IntegrationAspect> aspects) {
        this.aspects = aspects;
    }

    public IntegrationDependency withAspects(List<IntegrationAspect> aspects) {
        this.aspects = aspects;
        return this;
    }

    /**
     * If an Integration Dependency conceptually belongs or related to another Integration Dependency, this can be indicated here.
     * One situation would be where two systems each have an Integration Dependency to describe a two-sided integration from each side.
     * 
     */
    @JsonProperty("relatedIntegrationDependencies")
    public List<String> getRelatedIntegrationDependencies() {
        return relatedIntegrationDependencies;
    }

    /**
     * If an Integration Dependency conceptually belongs or related to another Integration Dependency, this can be indicated here.
     * One situation would be where two systems each have an Integration Dependency to describe a two-sided integration from each side.
     * 
     */
    @JsonProperty("relatedIntegrationDependencies")
    public void setRelatedIntegrationDependencies(List<String> relatedIntegrationDependencies) {
        this.relatedIntegrationDependencies = relatedIntegrationDependencies;
    }

    public IntegrationDependency withRelatedIntegrationDependencies(List<String> relatedIntegrationDependencies) {
        this.relatedIntegrationDependencies = relatedIntegrationDependencies;
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

    public IntegrationDependency withLinks(List<Link> links) {
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

    public IntegrationDependency withTags(List<String> tags) {
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

    public IntegrationDependency withLabels(Labels labels) {
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

    public IntegrationDependency withDocumentationLabels(DocumentationLabels documentationLabels) {
        this.documentationLabels = documentationLabels;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IntegrationDependency.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("sunsetDate");
        sb.append('=');
        sb.append(((this.sunsetDate == null)?"<null>":this.sunsetDate));
        sb.append(',');
        sb.append("successors");
        sb.append('=');
        sb.append(((this.successors == null)?"<null>":this.successors));
        sb.append(',');
        sb.append("mandatory");
        sb.append('=');
        sb.append(((this.mandatory == null)?"<null>":this.mandatory));
        sb.append(',');
        sb.append("aspects");
        sb.append('=');
        sb.append(((this.aspects == null)?"<null>":this.aspects));
        sb.append(',');
        sb.append("relatedIntegrationDependencies");
        sb.append('=');
        sb.append(((this.relatedIntegrationDependencies == null)?"<null>":this.relatedIntegrationDependencies));
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
        result = ((result* 31)+((this.visibility == null)? 0 :this.visibility.hashCode()));
        result = ((result* 31)+((this.successors == null)? 0 :this.successors.hashCode()));
        result = ((result* 31)+((this.aspects == null)? 0 :this.aspects.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.partOfPackage == null)? 0 :this.partOfPackage.hashCode()));
        result = ((result* 31)+((this.sunsetDate == null)? 0 :this.sunsetDate.hashCode()));
        result = ((result* 31)+((this.shortDescription == null)? 0 :this.shortDescription.hashCode()));
        result = ((result* 31)+((this.relatedIntegrationDependencies == null)? 0 :this.relatedIntegrationDependencies.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        result = ((result* 31)+((this.localId == null)? 0 :this.localId.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.mandatory == null)? 0 :this.mandatory.hashCode()));
        result = ((result* 31)+((this.partOfGroups == null)? 0 :this.partOfGroups.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        result = ((result* 31)+((this.documentationLabels == null)? 0 :this.documentationLabels.hashCode()));
        result = ((result* 31)+((this.correlationIds == null)? 0 :this.correlationIds.hashCode()));
        result = ((result* 31)+((this.lastUpdate == null)? 0 :this.lastUpdate.hashCode()));
        result = ((result* 31)+((this.releaseStatus == null)? 0 :this.releaseStatus.hashCode()));
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IntegrationDependency) == false) {
            return false;
        }
        IntegrationDependency rhs = ((IntegrationDependency) other);
        return ((((((((((((((((((((((this.visibility == rhs.visibility)||((this.visibility!= null)&&this.visibility.equals(rhs.visibility)))&&((this.successors == rhs.successors)||((this.successors!= null)&&this.successors.equals(rhs.successors))))&&((this.aspects == rhs.aspects)||((this.aspects!= null)&&this.aspects.equals(rhs.aspects))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.partOfPackage == rhs.partOfPackage)||((this.partOfPackage!= null)&&this.partOfPackage.equals(rhs.partOfPackage))))&&((this.sunsetDate == rhs.sunsetDate)||((this.sunsetDate!= null)&&this.sunsetDate.equals(rhs.sunsetDate))))&&((this.shortDescription == rhs.shortDescription)||((this.shortDescription!= null)&&this.shortDescription.equals(rhs.shortDescription))))&&((this.relatedIntegrationDependencies == rhs.relatedIntegrationDependencies)||((this.relatedIntegrationDependencies!= null)&&this.relatedIntegrationDependencies.equals(rhs.relatedIntegrationDependencies))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.localId == rhs.localId)||((this.localId!= null)&&this.localId.equals(rhs.localId))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.mandatory == rhs.mandatory)||((this.mandatory!= null)&&this.mandatory.equals(rhs.mandatory))))&&((this.partOfGroups == rhs.partOfGroups)||((this.partOfGroups!= null)&&this.partOfGroups.equals(rhs.partOfGroups))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.documentationLabels == rhs.documentationLabels)||((this.documentationLabels!= null)&&this.documentationLabels.equals(rhs.documentationLabels))))&&((this.correlationIds == rhs.correlationIds)||((this.correlationIds!= null)&&this.correlationIds.equals(rhs.correlationIds))))&&((this.lastUpdate == rhs.lastUpdate)||((this.lastUpdate!= null)&&this.lastUpdate.equals(rhs.lastUpdate))))&&((this.releaseStatus == rhs.releaseStatus)||((this.releaseStatus!= null)&&this.releaseStatus.equals(rhs.releaseStatus))))&&((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links))));
    }

}
