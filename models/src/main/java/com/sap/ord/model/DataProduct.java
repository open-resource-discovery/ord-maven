
package com.sap.ord.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Data Product
 * <p>
 * A [Data Product](../concepts/data-product) is a data set exposed for consumption outside the boundaries of the producing application via APIs and described by high quality metadata that can be accessed through the [ORD Aggregator](../../spec-v1/#ord-aggregator).
 * 
 * Please note that this concept is in beta, see [Data Product - Beta Status](../concepts/data-product#beta-status).
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
    "disabled",
    "minSystemVersion",
    "lifecycleStatus",
    "deprecationDate",
    "sunsetDate",
    "successors",
    "changelogEntries",
    "type",
    "category",
    "entityTypes",
    "inputPorts",
    "outputPorts",
    "responsible",
    "dataProductLinks",
    "links",
    "industry",
    "lineOfBusiness",
    "countries",
    "tags",
    "labels",
    "documentationLabels",
    "policyLevel",
    "customPolicyLevel",
    "policyLevels",
    "systemInstanceAware"
})
public class DataProduct {

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
     * List of products this Data Product is a part of or is related to, its e.g. data source systems.
     * 
     * MUST be a valid reference to a [Product](#product) ORD ID.
     * 
     * `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * 
     */
    @JsonProperty("partOfProducts")
    @JsonPropertyDescription("List of products this Data Product is a part of or is related to, its e.g. data source systems.\n\nMUST be a valid reference to a [Product](#product) ORD ID.\n\n`partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.")
    private List<String> partOfProducts = new ArrayList<String>();
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
     * The visibility/exposure of the data product. A public data product might have private APIs for trusted consumers therefore the having the property on data product
     * (Required)
     * 
     */
    @JsonProperty("visibility")
    @JsonPropertyDescription("The visibility/exposure of the data product. A public data product might have private APIs for trusted consumers therefore the having the property on data product")
    private String visibility;
    /**
     * The `releaseStatus` specifies the stability towards incompatible changes in the future.
     * In the context of data products, it it covers only properties on the data product level.
     * APIs that are part of the input and output ports have their own independent `releaseStatus` and `version`.
     * (Required)
     * 
     */
    @JsonProperty("releaseStatus")
    @JsonPropertyDescription("The `releaseStatus` specifies the stability towards incompatible changes in the future.\nIn the context of data products, it it covers only properties on the data product level.\nAPIs that are part of the input and output ports have their own independent `releaseStatus` and `version`.")
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
     * Lifecycle status of the Data Product as a whole.
     * 
     * MUST be provided when describing the system-instance aware (run-time) perspective.
     * SHOULD NOT be provided in static (design-time) perspective. Static aggregators MUST ignore this property.
     * 
     */
    @JsonProperty("lifecycleStatus")
    @JsonPropertyDescription("Lifecycle status of the Data Product as a whole.\n\nMUST be provided when describing the system-instance aware (run-time) perspective.\nSHOULD NOT be provided in static (design-time) perspective. Static aggregators MUST ignore this property.")
    private String lifecycleStatus;
    /**
     * The deprecation date defines when the resource has been set as deprecated.
     * This is not to be confused with the `sunsetDate` which defines when the resource will be actually decommissioned / removed.
     * 
     * If the `releaseStatus` is set to `deprecated`, the `deprecationDate` SHOULD be provided.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     */
    @JsonProperty("deprecationDate")
    @JsonPropertyDescription("The deprecation date defines when the resource has been set as deprecated.\nThis is not to be confused with the `sunsetDate` which defines when the resource will be actually decommissioned / removed.\n\nIf the `releaseStatus` is set to `deprecated`, the `deprecationDate` SHOULD be provided.\n\nThe date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).")
    private Date deprecationDate;
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
     * Contains changelog entries that summarize changes with special regards to version and releaseStatus
     * 
     */
    @JsonProperty("changelogEntries")
    @JsonPropertyDescription("Contains changelog entries that summarize changes with special regards to version and releaseStatus")
    private List<ChangelogEntry> changelogEntries = new ArrayList<ChangelogEntry>();
    /**
     * Type of the data product. Based on the type some properties of a data product may become optional/mandatory.
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of the data product. Based on the type some properties of a data product may become optional/mandatory.")
    private String type;
    /**
     * Category of the data-set within data product. Based on its definition, a data product is a "data set" - which can include on the values below.
     * Based on the type some properties of a data product may become optional/mandatory.
     * Consumers might still do analytics on business object like data products.
     * (Required)
     * 
     */
    @JsonProperty("category")
    @JsonPropertyDescription("Category of the data-set within data product. Based on its definition, a data product is a \"data set\" - which can include on the values below.\nBased on the type some properties of a data product may become optional/mandatory.\nConsumers might still do analytics on business object like data products.")
    private String category;
    /**
     * Aggregated list of entity types that are at least partially exposed by the data product. Detailed mapping can be found on the output port schema level.
     * 
     */
    @JsonProperty("entityTypes")
    @JsonPropertyDescription("Aggregated list of entity types that are at least partially exposed by the data product. Detailed mapping can be found on the output port schema level.")
    private List<String> entityTypes = new ArrayList<String>();
    /**
     * The input ports of a data product indicate the data inputs for lineage purposes.
     * 
     * It is a list of Integration Dependencies, whose aspects will form the actual input ports.
     * 
     * Input ports can also be understood as the public interface to ingest data into the data product.
     * Data products of type `derived` consume data through the input ports. Different input ports allowing ingestion of different sub-sets building up the data-set for the data product.
     * Data products of type `base` might not have any input ports. Their data sets are typically based directly on the applications / services own data.
     * 
     */
    @JsonProperty("inputPorts")
    @JsonPropertyDescription("The input ports of a data product indicate the data inputs for lineage purposes.\n\nIt is a list of Integration Dependencies, whose aspects will form the actual input ports.\n\nInput ports can also be understood as the public interface to ingest data into the data product.\nData products of type `derived` consume data through the input ports. Different input ports allowing ingestion of different sub-sets building up the data-set for the data product.\nData products of type `base` might not have any input ports. Their data sets are typically based directly on the applications / services own data.")
    private List<DataProductInputPort> inputPorts = new ArrayList<DataProductInputPort>();
    /**
     * Output ports are the interface (APIs and Events) through which the data of the data product can be accessed.
     * 
     * Output ports of the same data product might produce different facets of the data set with different qualities.
     * A data set can also be made available via different protocols, which also results in different ports.
     * 
     * As long as different output ports are accessing the same model beneath, they should belong to the same data product.
     * If the above criteria cannot be reasonably met, consider splitting the data product into multiple smaller data products.
     * (Required)
     * 
     */
    @JsonProperty("outputPorts")
    @JsonPropertyDescription("Output ports are the interface (APIs and Events) through which the data of the data product can be accessed.\n\nOutput ports of the same data product might produce different facets of the data set with different qualities.\nA data set can also be made available via different protocols, which also results in different ports.\n\nAs long as different output ports are accessing the same model beneath, they should belong to the same data product.\nIf the above criteria cannot be reasonably met, consider splitting the data product into multiple smaller data products.")
    private List<DataProductOutputPort> outputPorts = new ArrayList<DataProductOutputPort>();
    /**
     * Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.
     * (Required)
     * 
     */
    @JsonProperty("responsible")
    @JsonPropertyDescription("Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.")
    private String responsible;
    /**
     * Links with semantic meaning that are specific to Data Product Resources.
     * 
     */
    @JsonProperty("dataProductLinks")
    @JsonPropertyDescription("Links with semantic meaning that are specific to Data Product Resources.")
    private List<DataProductLink> dataProductLinks = new ArrayList<DataProductLink>();
    /**
     * Generic Links with arbitrary meaning and content.
     * 
     */
    @JsonProperty("links")
    @JsonPropertyDescription("Generic Links with arbitrary meaning and content.")
    private List<Link> links = new ArrayList<Link>();
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
    public DataProduct() {
    }

    /**
     * 
     * @param deprecationDate
     *     The deprecation date defines when the resource has been set as deprecated.
     *     This is not to be confused with the `sunsetDate` which defines when the resource will be actually decommissioned / removed.
     *     
     *     If the `releaseStatus` is set to `deprecated`, the `deprecationDate` SHOULD be provided.
     *     
     *     The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * @param lineOfBusiness
     *     List of line of business tags.
     *     No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     *     
     *     `lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * @param lifecycleStatus
     *     Lifecycle status of the Data Product as a whole.
     *     
     *     MUST be provided when describing the system-instance aware (run-time) perspective.
     *     SHOULD NOT be provided in static (design-time) perspective. Static aggregators MUST ignore this property.
     * @param successors
     *     The successor resource(s).
     *     
     *     MUST be a valid reference to an ORD ID.
     *     
     *     If the `releaseStatus` is set to `deprecated`, `successors` MUST be provided if one exists.
     *     If `successors` is given, the described resource SHOULD set its `releaseStatus` to `deprecated`.
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
     * @param industry
     *     List of industry tags.
     *     No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     *     
     *     `industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * @param customPolicyLevel
     *     If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.
     *     The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.
     *     
     *     MUST only be provided if `policyLevel` is set to `custom`.
     *     MUST be a valid [Specification ID](../index.md#specification-id).
     * @param title
     *     Human-readable title.
     *     
     *     MUST NOT exceed 255 chars.
     *     MUST NOT contain line breaks.
     * @param type
     *     Type of the data product. Based on the type some properties of a data product may become optional/mandatory.
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
     * @param policyLevels
     *     A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.
     *     For each chosen policy level, additional expectations and validations rules will be applied.
     *     
     *     Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     *     
     *     A policy level MUST be a valid [Specification ID](../index.md#specification-id).
     * @param correlationIds
     *     Correlation IDs can be used to create a reference to related data in other repositories (especially to the system of record).
     *     
     *     They express an "identity" / "equals" / "mappable" relationship to the target ID.
     *     
     *     If a "part of" relationship needs to be expressed, use the `partOfGroups` assignment instead.
     *     
     *     MUST be a valid [Correlation ID](../index.md#correlation-id).
     * @param outputPorts
     *     Output ports are the interface (APIs and Events) through which the data of the data product can be accessed.
     *     
     *     Output ports of the same data product might produce different facets of the data set with different qualities.
     *     A data set can also be made available via different protocols, which also results in different ports.
     *     
     *     As long as different output ports are accessing the same model beneath, they should belong to the same data product.
     *     If the above criteria cannot be reasonably met, consider splitting the data product into multiple smaller data products.
     * @param responsible
     *     Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.
     * @param releaseStatus
     *     The `releaseStatus` specifies the stability towards incompatible changes in the future.
     *     In the context of data products, it it covers only properties on the data product level.
     *     APIs that are part of the input and output ports have their own independent `releaseStatus` and `version`.
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
     * @param entityTypes
     *     Aggregated list of entity types that are at least partially exposed by the data product. Detailed mapping can be found on the output port schema level.
     * @param links
     *     Generic Links with arbitrary meaning and content.
     * @param minSystemVersion
     *     The resource has been introduced in the given [system version](../index.md#def-system-version).
     *     This implies that the resource is only available if the system instance is of at least that system version.
     * @param dataProductLinks
     *     Links with semantic meaning that are specific to Data Product Resources.
     * @param visibility
     *     The visibility/exposure of the data product. A public data product might have private APIs for trusted consumers therefore the having the property on data product.
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
     * @param countries
     *     List of countries that the package resources are applicable to.
     *     
     *     MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).
     *     
     *     `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
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
     * @param systemInstanceAware
     *     Defines whether this ORD resource is **system instance aware**.
     *     This is the case (and relevant) when the referenced resource definitions are potentially different between **system instances**.
     *     
     *     If this behavior applies, `systemInstanceAware` MUST be set to true.
     *     An ORD aggregator that represents a system instance aware perspective MUST fetch the referenced resource definitions,
     *     not just once per system type, but once per **system instance**.
     * @param changelogEntries
     *     Contains changelog entries that summarize changes with special regards to version and releaseStatus.
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
     * @param partOfProducts
     *     List of products this Data Product is a part of or is related to, its e.g. data source systems.
     *     
     *     MUST be a valid reference to a [Product](#product) ORD ID.
     *     
     *     `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * @param policyLevel
     *     The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.
     *     Depending on the chosen policy level, additional expectations and validations rules will be applied.
     *     
     *     The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     *     .
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
     * @param inputPorts
     *     The input ports of a data product indicate the data inputs for lineage purposes.
     *     
     *     It is a list of Integration Dependencies, whose aspects will form the actual input ports.
     *     
     *     Input ports can also be understood as the public interface to ingest data into the data product.
     *     Data products of type `derived` consume data through the input ports. Different input ports allowing ingestion of different sub-sets building up the data-set for the data product.
     *     Data products of type `base` might not have any input ports. Their data sets are typically based directly on the applications / services own data.
     * @param category
     *     Category of the data-set within data product. Based on its definition, a data product is a "data set" - which can include on the values below.
     *     Based on the type some properties of a data product may become optional/mandatory.
     *     Consumers might still do analytics on business object like data products.
     */
    public DataProduct(String ordId, String localId, List<String> correlationIds, String title, String shortDescription, String description, String partOfPackage, List<String> partOfGroups, List<String> partOfProducts, String version, Date lastUpdate, String visibility, String releaseStatus, Boolean disabled, String minSystemVersion, String lifecycleStatus, Date deprecationDate, Date sunsetDate, List<String> successors, List<ChangelogEntry> changelogEntries, String type, String category, List<String> entityTypes, List<DataProductInputPort> inputPorts, List<DataProductOutputPort> outputPorts, String responsible, List<DataProductLink> dataProductLinks, List<Link> links, List<String> industry, List<String> lineOfBusiness, List<String> countries, List<String> tags, Labels labels, DocumentationLabels documentationLabels, String policyLevel, String customPolicyLevel, List<String> policyLevels, Boolean systemInstanceAware) {
        super();
        this.ordId = ordId;
        this.localId = localId;
        this.correlationIds = correlationIds;
        this.title = title;
        this.shortDescription = shortDescription;
        this.description = description;
        this.partOfPackage = partOfPackage;
        this.partOfGroups = partOfGroups;
        this.partOfProducts = partOfProducts;
        this.version = version;
        this.lastUpdate = lastUpdate;
        this.visibility = visibility;
        this.releaseStatus = releaseStatus;
        this.disabled = disabled;
        this.minSystemVersion = minSystemVersion;
        this.lifecycleStatus = lifecycleStatus;
        this.deprecationDate = deprecationDate;
        this.sunsetDate = sunsetDate;
        this.successors = successors;
        this.changelogEntries = changelogEntries;
        this.type = type;
        this.category = category;
        this.entityTypes = entityTypes;
        this.inputPorts = inputPorts;
        this.outputPorts = outputPorts;
        this.responsible = responsible;
        this.dataProductLinks = dataProductLinks;
        this.links = links;
        this.industry = industry;
        this.lineOfBusiness = lineOfBusiness;
        this.countries = countries;
        this.tags = tags;
        this.labels = labels;
        this.documentationLabels = documentationLabels;
        this.policyLevel = policyLevel;
        this.customPolicyLevel = customPolicyLevel;
        this.policyLevels = policyLevels;
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

    public DataProduct withOrdId(String ordId) {
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

    public DataProduct withLocalId(String localId) {
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

    public DataProduct withCorrelationIds(List<String> correlationIds) {
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

    public DataProduct withTitle(String title) {
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

    public DataProduct withShortDescription(String shortDescription) {
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

    public DataProduct withDescription(String description) {
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

    public DataProduct withPartOfPackage(String partOfPackage) {
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

    public DataProduct withPartOfGroups(List<String> partOfGroups) {
        this.partOfGroups = partOfGroups;
        return this;
    }

    /**
     * List of products this Data Product is a part of or is related to, its e.g. data source systems.
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
     * List of products this Data Product is a part of or is related to, its e.g. data source systems.
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

    public DataProduct withPartOfProducts(List<String> partOfProducts) {
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

    public DataProduct withVersion(String version) {
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

    public DataProduct withLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    /**
     * The visibility/exposure of the data product. A public data product might have private APIs for trusted consumers therefore the having the property on data product
     * (Required)
     * 
     */
    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    /**
     * The visibility/exposure of the data product. A public data product might have private APIs for trusted consumers therefore the having the property on data product
     * (Required)
     * 
     */
    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public DataProduct withVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    /**
     * The `releaseStatus` specifies the stability towards incompatible changes in the future.
     * In the context of data products, it it covers only properties on the data product level.
     * APIs that are part of the input and output ports have their own independent `releaseStatus` and `version`.
     * (Required)
     * 
     */
    @JsonProperty("releaseStatus")
    public String getReleaseStatus() {
        return releaseStatus;
    }

    /**
     * The `releaseStatus` specifies the stability towards incompatible changes in the future.
     * In the context of data products, it it covers only properties on the data product level.
     * APIs that are part of the input and output ports have their own independent `releaseStatus` and `version`.
     * (Required)
     * 
     */
    @JsonProperty("releaseStatus")
    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public DataProduct withReleaseStatus(String releaseStatus) {
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

    public DataProduct withDisabled(Boolean disabled) {
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

    public DataProduct withMinSystemVersion(String minSystemVersion) {
        this.minSystemVersion = minSystemVersion;
        return this;
    }

    /**
     * Lifecycle status of the Data Product as a whole.
     * 
     * MUST be provided when describing the system-instance aware (run-time) perspective.
     * SHOULD NOT be provided in static (design-time) perspective. Static aggregators MUST ignore this property.
     * 
     */
    @JsonProperty("lifecycleStatus")
    public String getLifecycleStatus() {
        return lifecycleStatus;
    }

    /**
     * Lifecycle status of the Data Product as a whole.
     * 
     * MUST be provided when describing the system-instance aware (run-time) perspective.
     * SHOULD NOT be provided in static (design-time) perspective. Static aggregators MUST ignore this property.
     * 
     */
    @JsonProperty("lifecycleStatus")
    public void setLifecycleStatus(String lifecycleStatus) {
        this.lifecycleStatus = lifecycleStatus;
    }

    public DataProduct withLifecycleStatus(String lifecycleStatus) {
        this.lifecycleStatus = lifecycleStatus;
        return this;
    }

    /**
     * The deprecation date defines when the resource has been set as deprecated.
     * This is not to be confused with the `sunsetDate` which defines when the resource will be actually decommissioned / removed.
     * 
     * If the `releaseStatus` is set to `deprecated`, the `deprecationDate` SHOULD be provided.
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
     * This is not to be confused with the `sunsetDate` which defines when the resource will be actually decommissioned / removed.
     * 
     * If the `releaseStatus` is set to `deprecated`, the `deprecationDate` SHOULD be provided.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * 
     */
    @JsonProperty("deprecationDate")
    public void setDeprecationDate(Date deprecationDate) {
        this.deprecationDate = deprecationDate;
    }

    public DataProduct withDeprecationDate(Date deprecationDate) {
        this.deprecationDate = deprecationDate;
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

    public DataProduct withSunsetDate(Date sunsetDate) {
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

    public DataProduct withSuccessors(List<String> successors) {
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

    public DataProduct withChangelogEntries(List<ChangelogEntry> changelogEntries) {
        this.changelogEntries = changelogEntries;
        return this;
    }

    /**
     * Type of the data product. Based on the type some properties of a data product may become optional/mandatory.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type of the data product. Based on the type some properties of a data product may become optional/mandatory.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public DataProduct withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Category of the data-set within data product. Based on its definition, a data product is a "data set" - which can include on the values below.
     * Based on the type some properties of a data product may become optional/mandatory.
     * Consumers might still do analytics on business object like data products.
     * (Required)
     * 
     */
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    /**
     * Category of the data-set within data product. Based on its definition, a data product is a "data set" - which can include on the values below.
     * Based on the type some properties of a data product may become optional/mandatory.
     * Consumers might still do analytics on business object like data products.
     * (Required)
     * 
     */
    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    public DataProduct withCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * Aggregated list of entity types that are at least partially exposed by the data product. Detailed mapping can be found on the output port schema level.
     * 
     */
    @JsonProperty("entityTypes")
    public List<String> getEntityTypes() {
        return entityTypes;
    }

    /**
     * Aggregated list of entity types that are at least partially exposed by the data product. Detailed mapping can be found on the output port schema level.
     * 
     */
    @JsonProperty("entityTypes")
    public void setEntityTypes(List<String> entityTypes) {
        this.entityTypes = entityTypes;
    }

    public DataProduct withEntityTypes(List<String> entityTypes) {
        this.entityTypes = entityTypes;
        return this;
    }

    /**
     * The input ports of a data product indicate the data inputs for lineage purposes.
     * 
     * It is a list of Integration Dependencies, whose aspects will form the actual input ports.
     * 
     * Input ports can also be understood as the public interface to ingest data into the data product.
     * Data products of type `derived` consume data through the input ports. Different input ports allowing ingestion of different sub-sets building up the data-set for the data product.
     * Data products of type `base` might not have any input ports. Their data sets are typically based directly on the applications / services own data.
     * 
     */
    @JsonProperty("inputPorts")
    public List<DataProductInputPort> getInputPorts() {
        return inputPorts;
    }

    /**
     * The input ports of a data product indicate the data inputs for lineage purposes.
     * 
     * It is a list of Integration Dependencies, whose aspects will form the actual input ports.
     * 
     * Input ports can also be understood as the public interface to ingest data into the data product.
     * Data products of type `derived` consume data through the input ports. Different input ports allowing ingestion of different sub-sets building up the data-set for the data product.
     * Data products of type `base` might not have any input ports. Their data sets are typically based directly on the applications / services own data.
     * 
     */
    @JsonProperty("inputPorts")
    public void setInputPorts(List<DataProductInputPort> inputPorts) {
        this.inputPorts = inputPorts;
    }

    public DataProduct withInputPorts(List<DataProductInputPort> inputPorts) {
        this.inputPorts = inputPorts;
        return this;
    }

    /**
     * Output ports are the interface (APIs and Events) through which the data of the data product can be accessed.
     * 
     * Output ports of the same data product might produce different facets of the data set with different qualities.
     * A data set can also be made available via different protocols, which also results in different ports.
     * 
     * As long as different output ports are accessing the same model beneath, they should belong to the same data product.
     * If the above criteria cannot be reasonably met, consider splitting the data product into multiple smaller data products.
     * (Required)
     * 
     */
    @JsonProperty("outputPorts")
    public List<DataProductOutputPort> getOutputPorts() {
        return outputPorts;
    }

    /**
     * Output ports are the interface (APIs and Events) through which the data of the data product can be accessed.
     * 
     * Output ports of the same data product might produce different facets of the data set with different qualities.
     * A data set can also be made available via different protocols, which also results in different ports.
     * 
     * As long as different output ports are accessing the same model beneath, they should belong to the same data product.
     * If the above criteria cannot be reasonably met, consider splitting the data product into multiple smaller data products.
     * (Required)
     * 
     */
    @JsonProperty("outputPorts")
    public void setOutputPorts(List<DataProductOutputPort> outputPorts) {
        this.outputPorts = outputPorts;
    }

    public DataProduct withOutputPorts(List<DataProductOutputPort> outputPorts) {
        this.outputPorts = outputPorts;
        return this;
    }

    /**
     * Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.
     * (Required)
     * 
     */
    @JsonProperty("responsible")
    public String getResponsible() {
        return responsible;
    }

    /**
     * Contains typically the organization that is responsible in the sense of RACI matrix for this ORD resource. This includes support and feature requests. It is maintained as correlation id to for example support components.
     * (Required)
     * 
     */
    @JsonProperty("responsible")
    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public DataProduct withResponsible(String responsible) {
        this.responsible = responsible;
        return this;
    }

    /**
     * Links with semantic meaning that are specific to Data Product Resources.
     * 
     */
    @JsonProperty("dataProductLinks")
    public List<DataProductLink> getDataProductLinks() {
        return dataProductLinks;
    }

    /**
     * Links with semantic meaning that are specific to Data Product Resources.
     * 
     */
    @JsonProperty("dataProductLinks")
    public void setDataProductLinks(List<DataProductLink> dataProductLinks) {
        this.dataProductLinks = dataProductLinks;
    }

    public DataProduct withDataProductLinks(List<DataProductLink> dataProductLinks) {
        this.dataProductLinks = dataProductLinks;
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

    public DataProduct withLinks(List<Link> links) {
        this.links = links;
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

    public DataProduct withIndustry(List<String> industry) {
        this.industry = industry;
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

    public DataProduct withLineOfBusiness(List<String> lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
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

    public DataProduct withCountries(List<String> countries) {
        this.countries = countries;
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

    public DataProduct withTags(List<String> tags) {
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

    public DataProduct withLabels(Labels labels) {
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

    public DataProduct withDocumentationLabels(DocumentationLabels documentationLabels) {
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

    public DataProduct withPolicyLevel(String policyLevel) {
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

    public DataProduct withCustomPolicyLevel(String customPolicyLevel) {
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

    public DataProduct withPolicyLevels(List<String> policyLevels) {
        this.policyLevels = policyLevels;
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

    public DataProduct withSystemInstanceAware(Boolean systemInstanceAware) {
        this.systemInstanceAware = systemInstanceAware;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DataProduct.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("disabled");
        sb.append('=');
        sb.append(((this.disabled == null)?"<null>":this.disabled));
        sb.append(',');
        sb.append("minSystemVersion");
        sb.append('=');
        sb.append(((this.minSystemVersion == null)?"<null>":this.minSystemVersion));
        sb.append(',');
        sb.append("lifecycleStatus");
        sb.append('=');
        sb.append(((this.lifecycleStatus == null)?"<null>":this.lifecycleStatus));
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
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("category");
        sb.append('=');
        sb.append(((this.category == null)?"<null>":this.category));
        sb.append(',');
        sb.append("entityTypes");
        sb.append('=');
        sb.append(((this.entityTypes == null)?"<null>":this.entityTypes));
        sb.append(',');
        sb.append("inputPorts");
        sb.append('=');
        sb.append(((this.inputPorts == null)?"<null>":this.inputPorts));
        sb.append(',');
        sb.append("outputPorts");
        sb.append('=');
        sb.append(((this.outputPorts == null)?"<null>":this.outputPorts));
        sb.append(',');
        sb.append("responsible");
        sb.append('=');
        sb.append(((this.responsible == null)?"<null>":this.responsible));
        sb.append(',');
        sb.append("dataProductLinks");
        sb.append('=');
        sb.append(((this.dataProductLinks == null)?"<null>":this.dataProductLinks));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("industry");
        sb.append('=');
        sb.append(((this.industry == null)?"<null>":this.industry));
        sb.append(',');
        sb.append("lineOfBusiness");
        sb.append('=');
        sb.append(((this.lineOfBusiness == null)?"<null>":this.lineOfBusiness));
        sb.append(',');
        sb.append("countries");
        sb.append('=');
        sb.append(((this.countries == null)?"<null>":this.countries));
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
        result = ((result* 31)+((this.lineOfBusiness == null)? 0 :this.lineOfBusiness.hashCode()));
        result = ((result* 31)+((this.lifecycleStatus == null)? 0 :this.lifecycleStatus.hashCode()));
        result = ((result* 31)+((this.successors == null)? 0 :this.successors.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.partOfPackage == null)? 0 :this.partOfPackage.hashCode()));
        result = ((result* 31)+((this.industry == null)? 0 :this.industry.hashCode()));
        result = ((result* 31)+((this.customPolicyLevel == null)? 0 :this.customPolicyLevel.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        result = ((result* 31)+((this.localId == null)? 0 :this.localId.hashCode()));
        result = ((result* 31)+((this.policyLevels == null)? 0 :this.policyLevels.hashCode()));
        result = ((result* 31)+((this.correlationIds == null)? 0 :this.correlationIds.hashCode()));
        result = ((result* 31)+((this.outputPorts == null)? 0 :this.outputPorts.hashCode()));
        result = ((result* 31)+((this.responsible == null)? 0 :this.responsible.hashCode()));
        result = ((result* 31)+((this.releaseStatus == null)? 0 :this.releaseStatus.hashCode()));
        result = ((result* 31)+((this.disabled == null)? 0 :this.disabled.hashCode()));
        result = ((result* 31)+((this.entityTypes == null)? 0 :this.entityTypes.hashCode()));
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        result = ((result* 31)+((this.minSystemVersion == null)? 0 :this.minSystemVersion.hashCode()));
        result = ((result* 31)+((this.dataProductLinks == null)? 0 :this.dataProductLinks.hashCode()));
        result = ((result* 31)+((this.visibility == null)? 0 :this.visibility.hashCode()));
        result = ((result* 31)+((this.sunsetDate == null)? 0 :this.sunsetDate.hashCode()));
        result = ((result* 31)+((this.shortDescription == null)? 0 :this.shortDescription.hashCode()));
        result = ((result* 31)+((this.countries == null)? 0 :this.countries.hashCode()));
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
        result = ((result* 31)+((this.inputPorts == null)? 0 :this.inputPorts.hashCode()));
        result = ((result* 31)+((this.category == null)? 0 :this.category.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DataProduct) == false) {
            return false;
        }
        DataProduct rhs = ((DataProduct) other);
        return (((((((((((((((((((((((((((((((((((((((this.deprecationDate == rhs.deprecationDate)||((this.deprecationDate!= null)&&this.deprecationDate.equals(rhs.deprecationDate)))&&((this.lineOfBusiness == rhs.lineOfBusiness)||((this.lineOfBusiness!= null)&&this.lineOfBusiness.equals(rhs.lineOfBusiness))))&&((this.lifecycleStatus == rhs.lifecycleStatus)||((this.lifecycleStatus!= null)&&this.lifecycleStatus.equals(rhs.lifecycleStatus))))&&((this.successors == rhs.successors)||((this.successors!= null)&&this.successors.equals(rhs.successors))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.partOfPackage == rhs.partOfPackage)||((this.partOfPackage!= null)&&this.partOfPackage.equals(rhs.partOfPackage))))&&((this.industry == rhs.industry)||((this.industry!= null)&&this.industry.equals(rhs.industry))))&&((this.customPolicyLevel == rhs.customPolicyLevel)||((this.customPolicyLevel!= null)&&this.customPolicyLevel.equals(rhs.customPolicyLevel))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.localId == rhs.localId)||((this.localId!= null)&&this.localId.equals(rhs.localId))))&&((this.policyLevels == rhs.policyLevels)||((this.policyLevels!= null)&&this.policyLevels.equals(rhs.policyLevels))))&&((this.correlationIds == rhs.correlationIds)||((this.correlationIds!= null)&&this.correlationIds.equals(rhs.correlationIds))))&&((this.outputPorts == rhs.outputPorts)||((this.outputPorts!= null)&&this.outputPorts.equals(rhs.outputPorts))))&&((this.responsible == rhs.responsible)||((this.responsible!= null)&&this.responsible.equals(rhs.responsible))))&&((this.releaseStatus == rhs.releaseStatus)||((this.releaseStatus!= null)&&this.releaseStatus.equals(rhs.releaseStatus))))&&((this.disabled == rhs.disabled)||((this.disabled!= null)&&this.disabled.equals(rhs.disabled))))&&((this.entityTypes == rhs.entityTypes)||((this.entityTypes!= null)&&this.entityTypes.equals(rhs.entityTypes))))&&((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links))))&&((this.minSystemVersion == rhs.minSystemVersion)||((this.minSystemVersion!= null)&&this.minSystemVersion.equals(rhs.minSystemVersion))))&&((this.dataProductLinks == rhs.dataProductLinks)||((this.dataProductLinks!= null)&&this.dataProductLinks.equals(rhs.dataProductLinks))))&&((this.visibility == rhs.visibility)||((this.visibility!= null)&&this.visibility.equals(rhs.visibility))))&&((this.sunsetDate == rhs.sunsetDate)||((this.sunsetDate!= null)&&this.sunsetDate.equals(rhs.sunsetDate))))&&((this.shortDescription == rhs.shortDescription)||((this.shortDescription!= null)&&this.shortDescription.equals(rhs.shortDescription))))&&((this.countries == rhs.countries)||((this.countries!= null)&&this.countries.equals(rhs.countries))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.systemInstanceAware == rhs.systemInstanceAware)||((this.systemInstanceAware!= null)&&this.systemInstanceAware.equals(rhs.systemInstanceAware))))&&((this.changelogEntries == rhs.changelogEntries)||((this.changelogEntries!= null)&&this.changelogEntries.equals(rhs.changelogEntries))))&&((this.partOfGroups == rhs.partOfGroups)||((this.partOfGroups!= null)&&this.partOfGroups.equals(rhs.partOfGroups))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.partOfProducts == rhs.partOfProducts)||((this.partOfProducts!= null)&&this.partOfProducts.equals(rhs.partOfProducts))))&&((this.policyLevel == rhs.policyLevel)||((this.policyLevel!= null)&&this.policyLevel.equals(rhs.policyLevel))))&&((this.documentationLabels == rhs.documentationLabels)||((this.documentationLabels!= null)&&this.documentationLabels.equals(rhs.documentationLabels))))&&((this.lastUpdate == rhs.lastUpdate)||((this.lastUpdate!= null)&&this.lastUpdate.equals(rhs.lastUpdate))))&&((this.inputPorts == rhs.inputPorts)||((this.inputPorts!= null)&&this.inputPorts.equals(rhs.inputPorts))))&&((this.category == rhs.category)||((this.category!= null)&&this.category.equals(rhs.category))));
    }

}
