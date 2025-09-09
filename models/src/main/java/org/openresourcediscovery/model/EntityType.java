
package org.openresourcediscovery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Entity Type
 * <p>
 * An [**Entity Type**](../concepts/grouping-and-bundling#entity-type) describes either a business concept / term or an underlying conceptual model.
 * The same entity type can be exposed through one or multiple API and events resources.
 * 
 * To learn more about the concept, see [Entity Type](../concepts/grouping-and-bundling#entity-type).
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
    "partOfProducts",
    "version",
    "lastUpdate",
    "visibility",
    "releaseStatus",
    "deprecationDate",
    "sunsetDate",
    "successors",
    "changelogEntries",
    "level",
    "relatedEntityTypes",
    "links",
    "extensible",
    "tags",
    "labels",
    "documentationLabels",
    "policyLevel",
    "customPolicyLevel",
    "policyLevels",
    "systemInstanceAware"
})
@Generated("jsonschema2pojo")
public class EntityType {

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
     * (Required)
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
     * Defining the abstraction level of the entity type using the DDD terminology.
     * 
     * In Domain-Driven Design, there is a concept of entities and aggregates.
     * There are root entities which may contain further sub entities by composition.
     * The complete "package" is then called an aggregate, which gets its name and identity from the root entity.
     * An aggregate is a cluster of domain objects that can be treated as a single unit.
     * The root is the entity that is referenced from outside the aggregate. There must be only one root per aggregate.
     * The root ensures the integrity of the aggregate. A sub entity is any other non-root entity in the aggregate.
     * 
     * Source, see [Martin Fowler on DDD Aggregate](https://martinfowler.com/bliki/DDD_Aggregate.html)
     * (Required)
     * 
     */
    @JsonProperty("level")
    @JsonPropertyDescription("Defining the abstraction level of the entity type using the DDD terminology.\n\nIn Domain-Driven Design, there is a concept of entities and aggregates.\nThere are root entities which may contain further sub entities by composition.\nThe complete \"package\" is then called an aggregate, which gets its name and identity from the root entity.\nAn aggregate is a cluster of domain objects that can be treated as a single unit.\nThe root is the entity that is referenced from outside the aggregate. There must be only one root per aggregate.\nThe root ensures the integrity of the aggregate. A sub entity is any other non-root entity in the aggregate.\n\nSource, see [Martin Fowler on DDD Aggregate](https://martinfowler.com/bliki/DDD_Aggregate.html)")
    private String level;
    /**
     * States that this Entity Type is related to another Entity Type.
     * 
     * Usually this happens if there are similar conceptual entity types across different namespaces.
     * 
     */
    @JsonProperty("relatedEntityTypes")
    @JsonPropertyDescription("States that this Entity Type is related to another Entity Type.\n\nUsually this happens if there are similar conceptual entity types across different namespaces.")
    private List<RelatedEntityType> relatedEntityTypes = new ArrayList<RelatedEntityType>();
    /**
     * Generic Links with arbitrary meaning and content.
     * 
     */
    @JsonProperty("links")
    @JsonPropertyDescription("Generic Links with arbitrary meaning and content.")
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

    public EntityType withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    /**
     * The locally unique ID under which this resource can be looked up / resolved in the described system itself.
     * Unlike the ORD ID it's not globally unique, but it may be useful to document the original ID / technical name.
     * 
     * It MAY also be used as the `<resourceName>` fragment in the ORD ID, IF it can fulfill the charset and length limitations within the ORD ID.
     * But since this is not always possible, no assumptions MUST be made about the local ID being the same as the `<resourceName>` fragment in the ORD ID.
     * (Required)
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
     * (Required)
     * 
     */
    @JsonProperty("localId")
    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public EntityType withLocalId(String localId) {
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

    public EntityType withCorrelationIds(List<String> correlationIds) {
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

    public EntityType withTitle(String title) {
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

    public EntityType withShortDescription(String shortDescription) {
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

    public EntityType withDescription(String description) {
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

    public EntityType withPartOfPackage(String partOfPackage) {
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

    public EntityType withPartOfGroups(List<String> partOfGroups) {
        this.partOfGroups = partOfGroups;
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

    public EntityType withPartOfProducts(List<String> partOfProducts) {
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

    public EntityType withVersion(String version) {
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

    public EntityType withLastUpdate(Date lastUpdate) {
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

    public EntityType withVisibility(String visibility) {
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

    public EntityType withReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
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

    public EntityType withDeprecationDate(Date deprecationDate) {
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

    public EntityType withSunsetDate(Date sunsetDate) {
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

    public EntityType withSuccessors(List<String> successors) {
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

    public EntityType withChangelogEntries(List<ChangelogEntry> changelogEntries) {
        this.changelogEntries = changelogEntries;
        return this;
    }

    /**
     * Defining the abstraction level of the entity type using the DDD terminology.
     * 
     * In Domain-Driven Design, there is a concept of entities and aggregates.
     * There are root entities which may contain further sub entities by composition.
     * The complete "package" is then called an aggregate, which gets its name and identity from the root entity.
     * An aggregate is a cluster of domain objects that can be treated as a single unit.
     * The root is the entity that is referenced from outside the aggregate. There must be only one root per aggregate.
     * The root ensures the integrity of the aggregate. A sub entity is any other non-root entity in the aggregate.
     * 
     * Source, see [Martin Fowler on DDD Aggregate](https://martinfowler.com/bliki/DDD_Aggregate.html)
     * (Required)
     * 
     */
    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    /**
     * Defining the abstraction level of the entity type using the DDD terminology.
     * 
     * In Domain-Driven Design, there is a concept of entities and aggregates.
     * There are root entities which may contain further sub entities by composition.
     * The complete "package" is then called an aggregate, which gets its name and identity from the root entity.
     * An aggregate is a cluster of domain objects that can be treated as a single unit.
     * The root is the entity that is referenced from outside the aggregate. There must be only one root per aggregate.
     * The root ensures the integrity of the aggregate. A sub entity is any other non-root entity in the aggregate.
     * 
     * Source, see [Martin Fowler on DDD Aggregate](https://martinfowler.com/bliki/DDD_Aggregate.html)
     * (Required)
     * 
     */
    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    public EntityType withLevel(String level) {
        this.level = level;
        return this;
    }

    /**
     * States that this Entity Type is related to another Entity Type.
     * 
     * Usually this happens if there are similar conceptual entity types across different namespaces.
     * 
     */
    @JsonProperty("relatedEntityTypes")
    public List<RelatedEntityType> getRelatedEntityTypes() {
        return relatedEntityTypes;
    }

    /**
     * States that this Entity Type is related to another Entity Type.
     * 
     * Usually this happens if there are similar conceptual entity types across different namespaces.
     * 
     */
    @JsonProperty("relatedEntityTypes")
    public void setRelatedEntityTypes(List<RelatedEntityType> relatedEntityTypes) {
        this.relatedEntityTypes = relatedEntityTypes;
    }

    public EntityType withRelatedEntityTypes(List<RelatedEntityType> relatedEntityTypes) {
        this.relatedEntityTypes = relatedEntityTypes;
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

    public EntityType withLinks(List<Link> links) {
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

    public EntityType withExtensible(Extensible extensible) {
        this.extensible = extensible;
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

    public EntityType withTags(List<String> tags) {
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

    public EntityType withLabels(Labels labels) {
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

    public EntityType withDocumentationLabels(DocumentationLabels documentationLabels) {
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

    public EntityType withPolicyLevel(String policyLevel) {
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

    public EntityType withCustomPolicyLevel(String customPolicyLevel) {
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

    public EntityType withPolicyLevels(List<String> policyLevels) {
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

    public EntityType withSystemInstanceAware(Boolean systemInstanceAware) {
        this.systemInstanceAware = systemInstanceAware;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EntityType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("level");
        sb.append('=');
        sb.append(((this.level == null)?"<null>":this.level));
        sb.append(',');
        sb.append("relatedEntityTypes");
        sb.append('=');
        sb.append(((this.relatedEntityTypes == null)?"<null>":this.relatedEntityTypes));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("extensible");
        sb.append('=');
        sb.append(((this.extensible == null)?"<null>":this.extensible));
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
        result = ((result* 31)+((this.successors == null)? 0 :this.successors.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.partOfPackage == null)? 0 :this.partOfPackage.hashCode()));
        result = ((result* 31)+((this.customPolicyLevel == null)? 0 :this.customPolicyLevel.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        result = ((result* 31)+((this.localId == null)? 0 :this.localId.hashCode()));
        result = ((result* 31)+((this.policyLevels == null)? 0 :this.policyLevels.hashCode()));
        result = ((result* 31)+((this.correlationIds == null)? 0 :this.correlationIds.hashCode()));
        result = ((result* 31)+((this.releaseStatus == null)? 0 :this.releaseStatus.hashCode()));
        result = ((result* 31)+((this.relatedEntityTypes == null)? 0 :this.relatedEntityTypes.hashCode()));
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        result = ((result* 31)+((this.extensible == null)? 0 :this.extensible.hashCode()));
        result = ((result* 31)+((this.visibility == null)? 0 :this.visibility.hashCode()));
        result = ((result* 31)+((this.level == null)? 0 :this.level.hashCode()));
        result = ((result* 31)+((this.sunsetDate == null)? 0 :this.sunsetDate.hashCode()));
        result = ((result* 31)+((this.shortDescription == null)? 0 :this.shortDescription.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.systemInstanceAware == null)? 0 :this.systemInstanceAware.hashCode()));
        result = ((result* 31)+((this.changelogEntries == null)? 0 :this.changelogEntries.hashCode()));
        result = ((result* 31)+((this.partOfGroups == null)? 0 :this.partOfGroups.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        result = ((result* 31)+((this.partOfProducts == null)? 0 :this.partOfProducts.hashCode()));
        result = ((result* 31)+((this.policyLevel == null)? 0 :this.policyLevel.hashCode()));
        result = ((result* 31)+((this.documentationLabels == null)? 0 :this.documentationLabels.hashCode()));
        result = ((result* 31)+((this.lastUpdate == null)? 0 :this.lastUpdate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EntityType) == false) {
            return false;
        }
        EntityType rhs = ((EntityType) other);
        return (((((((((((((((((((((((((((((this.deprecationDate == rhs.deprecationDate)||((this.deprecationDate!= null)&&this.deprecationDate.equals(rhs.deprecationDate)))&&((this.successors == rhs.successors)||((this.successors!= null)&&this.successors.equals(rhs.successors))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.partOfPackage == rhs.partOfPackage)||((this.partOfPackage!= null)&&this.partOfPackage.equals(rhs.partOfPackage))))&&((this.customPolicyLevel == rhs.customPolicyLevel)||((this.customPolicyLevel!= null)&&this.customPolicyLevel.equals(rhs.customPolicyLevel))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.localId == rhs.localId)||((this.localId!= null)&&this.localId.equals(rhs.localId))))&&((this.policyLevels == rhs.policyLevels)||((this.policyLevels!= null)&&this.policyLevels.equals(rhs.policyLevels))))&&((this.correlationIds == rhs.correlationIds)||((this.correlationIds!= null)&&this.correlationIds.equals(rhs.correlationIds))))&&((this.releaseStatus == rhs.releaseStatus)||((this.releaseStatus!= null)&&this.releaseStatus.equals(rhs.releaseStatus))))&&((this.relatedEntityTypes == rhs.relatedEntityTypes)||((this.relatedEntityTypes!= null)&&this.relatedEntityTypes.equals(rhs.relatedEntityTypes))))&&((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links))))&&((this.extensible == rhs.extensible)||((this.extensible!= null)&&this.extensible.equals(rhs.extensible))))&&((this.visibility == rhs.visibility)||((this.visibility!= null)&&this.visibility.equals(rhs.visibility))))&&((this.level == rhs.level)||((this.level!= null)&&this.level.equals(rhs.level))))&&((this.sunsetDate == rhs.sunsetDate)||((this.sunsetDate!= null)&&this.sunsetDate.equals(rhs.sunsetDate))))&&((this.shortDescription == rhs.shortDescription)||((this.shortDescription!= null)&&this.shortDescription.equals(rhs.shortDescription))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.systemInstanceAware == rhs.systemInstanceAware)||((this.systemInstanceAware!= null)&&this.systemInstanceAware.equals(rhs.systemInstanceAware))))&&((this.changelogEntries == rhs.changelogEntries)||((this.changelogEntries!= null)&&this.changelogEntries.equals(rhs.changelogEntries))))&&((this.partOfGroups == rhs.partOfGroups)||((this.partOfGroups!= null)&&this.partOfGroups.equals(rhs.partOfGroups))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.partOfProducts == rhs.partOfProducts)||((this.partOfProducts!= null)&&this.partOfProducts.equals(rhs.partOfProducts))))&&((this.policyLevel == rhs.policyLevel)||((this.policyLevel!= null)&&this.policyLevel.equals(rhs.policyLevel))))&&((this.documentationLabels == rhs.documentationLabels)||((this.documentationLabels!= null)&&this.documentationLabels.equals(rhs.documentationLabels))))&&((this.lastUpdate == rhs.lastUpdate)||((this.lastUpdate!= null)&&this.lastUpdate.equals(rhs.lastUpdate))));
    }

}
