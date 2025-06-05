
package com.sap.ord.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Package
 * <p>
 * A [**Package**](../concepts/grouping-and-bundling#package) organizes a set of related resources together, by publishing and catalog presentation concerns.
 * 
 * The Package can also be used to indicate which products or vendors provided the packaged resources.
 * For partner or customer content, the package can indicate this via the `vendor` and `partOfProducts` assignments.
 * In any case, the Package `ordID` namespace MUST reflect the namespace of the providing application (which hosts the resource), not the resource definition owner, which could be a customer or partner.
 * 
 * A package SHOULD contain at least one resource. Avoid empty packages.
 * 
 * The package assignment of a resource MAY change, so consumers MUST not rely on this to be stable.
 * 
 * A package does not have a `visibility` property.
 * Whether it is displayed is decided by the fact, whether it contains any visible resources according to the visibility role of the aggregator.
 * 
 * To learn more about the concept and further guidance, see [Package](../concepts/grouping-and-bundling#package).
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId",
    "localId",
    "title",
    "shortDescription",
    "description",
    "version",
    "policyLevel",
    "customPolicyLevel",
    "policyLevels",
    "packageLinks",
    "links",
    "licenseType",
    "supportInfo",
    "vendor",
    "partOfProducts",
    "countries",
    "lineOfBusiness",
    "industry",
    "runtimeRestriction",
    "tags",
    "labels",
    "documentationLabels"
})
public class Package {

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
     * Links with semantic meaning that are specific to packages.
     * 
     */
    @JsonProperty("packageLinks")
    @JsonPropertyDescription("Links with semantic meaning that are specific to packages.")
    private List<PackageLink> packageLinks = new ArrayList<PackageLink>();
    /**
     * Generic links with arbitrary meaning and content.
     * 
     * `packageLinks` MUST be preferred if applicable.
     * 
     */
    @JsonProperty("links")
    @JsonPropertyDescription("Generic links with arbitrary meaning and content.\n\n`packageLinks` MUST be preferred if applicable.")
    private List<Link> links = new ArrayList<Link>();
    /**
     * Standardized identifier for the license.
     * It MUST conform to the [SPDX License List](https://spdx.org/licenses).
     * 
     */
    @JsonProperty("licenseType")
    @JsonPropertyDescription("Standardized identifier for the license.\nIt MUST conform to the [SPDX License List](https://spdx.org/licenses).")
    private String licenseType;
    /**
     * Optional information that should be provided when creating a support ticket for the resources bundled in this package.
     * This can for example be a "component" name that needs to be chosen in the support portal.
     * 
     * Notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * Please also note that if you want to provide link(s) where you can find support information,
     * you can use `packageLinks` with a link of type `support`.
     * 
     */
    @JsonProperty("supportInfo")
    @JsonPropertyDescription("Optional information that should be provided when creating a support ticket for the resources bundled in this package.\nThis can for example be a \"component\" name that needs to be chosen in the support portal.\n\nNotated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nPlease also note that if you want to provide link(s) where you can find support information,\nyou can use `packageLinks` with a link of type `support`.")
    private String supportInfo;
    /**
     * Vendor / organization that is the creator (or responsible party) of the resources that are part of the `Package`.
     * 
     * MUST be a valid reference to a [Vendor](#vendor) ORD ID.
     * 
     * MUST be set to `customer:vendor:Customer:` if the contents of the package are created by the customer / user.
     * 
     * MUST be set to a registered partner vendor, if the contents of the package are created by a partner / third party.
     * (Required)
     * 
     */
    @JsonProperty("vendor")
    @JsonPropertyDescription("Vendor / organization that is the creator (or responsible party) of the resources that are part of the `Package`.\n\nMUST be a valid reference to a [Vendor](#vendor) ORD ID.\n\nMUST be set to `customer:vendor:Customer:` if the contents of the package are created by the customer / user.\n\nMUST be set to a registered partner vendor, if the contents of the package are created by a partner / third party.")
    private String vendor;
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
     * If provided, all resources that are part of this package can only run on the listed runtime.
     * 
     * MUST be a valid [system namespace](../index.md#system-namespace).
     * 
     */
    @JsonProperty("runtimeRestriction")
    @JsonPropertyDescription("If provided, all resources that are part of this package can only run on the listed runtime.\n\nMUST be a valid [system namespace](../index.md#system-namespace).")
    private String runtimeRestriction;
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
    public Package() {
    }

    /**
     * 
     * @param lineOfBusiness
     *     List of line of business tags.
     *     No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     *     
     *     `lineOfBusiness` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * @param description
     *     Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     *     
     *     The description SHOULD not be excessive in length and is not meant to provide full documentation.
     *     Detailed documentation SHOULD be attached as (typed) links.
     * @param industry
     *     List of industry tags.
     *     No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     *     
     *     `industry` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * @param shortDescription
     *     Plain text short description.
     *     
     *     MUST NOT exceed 255 chars.
     *     MUST NOT contain line breaks.
     * @param customPolicyLevel
     *     If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.
     *     The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.
     *     
     *     MUST only be provided if `policyLevel` is set to `custom`.
     *     MUST be a valid [Specification ID](../index.md#specification-id).
     * @param countries
     *     List of countries that the package resources are applicable to.
     *     
     *     MUST be expressed as an array of country codes according to [IES ISO-3166 ALPHA-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).
     *     
     *     `countries` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
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
     * @param policyLevels
     *     A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.
     *     For each chosen policy level, additional expectations and validations rules will be applied.
     *     
     *     Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     *     
     *     A policy level MUST be a valid [Specification ID](../index.md#specification-id).
     * @param tags
     *     List of free text style tags.
     *     No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
     *     
     *     Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * @param policyLevel
     *     The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.
     *     Depending on the chosen policy level, additional expectations and validations rules will be applied.
     *     
     *     The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     *     .
     * @param partOfProducts
     *     List of products the resources of the package are a part of.
     *     
     *     MUST be a valid reference to a [Product](#product) ORD ID.
     *     
     *     `partOfProducts` that are assigned to a `Package` are inherited to all of the ORD resources it contains.
     * @param licenseType
     *     Standardized identifier for the license.
     *     It MUST conform to the [SPDX License List](https://spdx.org/licenses).
     * @param vendor
     *     Vendor / organization that is the creator (or responsible party) of the resources that are part of the `Package`.
     *     
     *     MUST be a valid reference to a [Vendor](#vendor) ORD ID.
     *     
     *     MUST be set to `customer:vendor:Customer:` if the contents of the package are created by the customer / user.
     *     
     *     MUST be set to a registered partner vendor, if the contents of the package are created by a partner / third party.
     * @param links
     *     Generic links with arbitrary meaning and content.
     *     
     *     `packageLinks` MUST be preferred if applicable.
     * @param runtimeRestriction
     *     If provided, all resources that are part of this package can only run on the listed runtime.
     *     
     *     MUST be a valid [system namespace](../index.md#system-namespace).
     * @param packageLinks
     *     Links with semantic meaning that are specific to packages.
     * @param supportInfo
     *     Optional information that should be provided when creating a support ticket for the resources bundled in this package.
     *     This can for example be a "component" name that needs to be chosen in the support portal.
     *     
     *     Notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     *     
     *     Please also note that if you want to provide link(s) where you can find support information,
     *     you can use `packageLinks` with a link of type `support`.
     */
    public Package(String ordId, String localId, String title, String shortDescription, String description, String version, String policyLevel, String customPolicyLevel, List<String> policyLevels, List<PackageLink> packageLinks, List<Link> links, String licenseType, String supportInfo, String vendor, List<String> partOfProducts, List<String> countries, List<String> lineOfBusiness, List<String> industry, String runtimeRestriction, List<String> tags, Labels labels, DocumentationLabels documentationLabels) {
        super();
        this.ordId = ordId;
        this.localId = localId;
        this.title = title;
        this.shortDescription = shortDescription;
        this.description = description;
        this.version = version;
        this.policyLevel = policyLevel;
        this.customPolicyLevel = customPolicyLevel;
        this.policyLevels = policyLevels;
        this.packageLinks = packageLinks;
        this.links = links;
        this.licenseType = licenseType;
        this.supportInfo = supportInfo;
        this.vendor = vendor;
        this.partOfProducts = partOfProducts;
        this.countries = countries;
        this.lineOfBusiness = lineOfBusiness;
        this.industry = industry;
        this.runtimeRestriction = runtimeRestriction;
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

    public Package withOrdId(String ordId) {
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

    public Package withLocalId(String localId) {
        this.localId = localId;
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

    public Package withTitle(String title) {
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

    public Package withShortDescription(String shortDescription) {
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

    public Package withDescription(String description) {
        this.description = description;
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

    public Package withVersion(String version) {
        this.version = version;
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

    public Package withPolicyLevel(String policyLevel) {
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

    public Package withCustomPolicyLevel(String customPolicyLevel) {
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

    public Package withPolicyLevels(List<String> policyLevels) {
        this.policyLevels = policyLevels;
        return this;
    }

    /**
     * Links with semantic meaning that are specific to packages.
     * 
     */
    @JsonProperty("packageLinks")
    public List<PackageLink> getPackageLinks() {
        return packageLinks;
    }

    /**
     * Links with semantic meaning that are specific to packages.
     * 
     */
    @JsonProperty("packageLinks")
    public void setPackageLinks(List<PackageLink> packageLinks) {
        this.packageLinks = packageLinks;
    }

    public Package withPackageLinks(List<PackageLink> packageLinks) {
        this.packageLinks = packageLinks;
        return this;
    }

    /**
     * Generic links with arbitrary meaning and content.
     * 
     * `packageLinks` MUST be preferred if applicable.
     * 
     */
    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Generic links with arbitrary meaning and content.
     * 
     * `packageLinks` MUST be preferred if applicable.
     * 
     */
    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Package withLinks(List<Link> links) {
        this.links = links;
        return this;
    }

    /**
     * Standardized identifier for the license.
     * It MUST conform to the [SPDX License List](https://spdx.org/licenses).
     * 
     */
    @JsonProperty("licenseType")
    public String getLicenseType() {
        return licenseType;
    }

    /**
     * Standardized identifier for the license.
     * It MUST conform to the [SPDX License List](https://spdx.org/licenses).
     * 
     */
    @JsonProperty("licenseType")
    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public Package withLicenseType(String licenseType) {
        this.licenseType = licenseType;
        return this;
    }

    /**
     * Optional information that should be provided when creating a support ticket for the resources bundled in this package.
     * This can for example be a "component" name that needs to be chosen in the support portal.
     * 
     * Notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * Please also note that if you want to provide link(s) where you can find support information,
     * you can use `packageLinks` with a link of type `support`.
     * 
     */
    @JsonProperty("supportInfo")
    public String getSupportInfo() {
        return supportInfo;
    }

    /**
     * Optional information that should be provided when creating a support ticket for the resources bundled in this package.
     * This can for example be a "component" name that needs to be chosen in the support portal.
     * 
     * Notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * Please also note that if you want to provide link(s) where you can find support information,
     * you can use `packageLinks` with a link of type `support`.
     * 
     */
    @JsonProperty("supportInfo")
    public void setSupportInfo(String supportInfo) {
        this.supportInfo = supportInfo;
    }

    public Package withSupportInfo(String supportInfo) {
        this.supportInfo = supportInfo;
        return this;
    }

    /**
     * Vendor / organization that is the creator (or responsible party) of the resources that are part of the `Package`.
     * 
     * MUST be a valid reference to a [Vendor](#vendor) ORD ID.
     * 
     * MUST be set to `customer:vendor:Customer:` if the contents of the package are created by the customer / user.
     * 
     * MUST be set to a registered partner vendor, if the contents of the package are created by a partner / third party.
     * (Required)
     * 
     */
    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    /**
     * Vendor / organization that is the creator (or responsible party) of the resources that are part of the `Package`.
     * 
     * MUST be a valid reference to a [Vendor](#vendor) ORD ID.
     * 
     * MUST be set to `customer:vendor:Customer:` if the contents of the package are created by the customer / user.
     * 
     * MUST be set to a registered partner vendor, if the contents of the package are created by a partner / third party.
     * (Required)
     * 
     */
    @JsonProperty("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Package withVendor(String vendor) {
        this.vendor = vendor;
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

    public Package withPartOfProducts(List<String> partOfProducts) {
        this.partOfProducts = partOfProducts;
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

    public Package withCountries(List<String> countries) {
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

    public Package withLineOfBusiness(List<String> lineOfBusiness) {
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

    public Package withIndustry(List<String> industry) {
        this.industry = industry;
        return this;
    }

    /**
     * If provided, all resources that are part of this package can only run on the listed runtime.
     * 
     * MUST be a valid [system namespace](../index.md#system-namespace).
     * 
     */
    @JsonProperty("runtimeRestriction")
    public String getRuntimeRestriction() {
        return runtimeRestriction;
    }

    /**
     * If provided, all resources that are part of this package can only run on the listed runtime.
     * 
     * MUST be a valid [system namespace](../index.md#system-namespace).
     * 
     */
    @JsonProperty("runtimeRestriction")
    public void setRuntimeRestriction(String runtimeRestriction) {
        this.runtimeRestriction = runtimeRestriction;
    }

    public Package withRuntimeRestriction(String runtimeRestriction) {
        this.runtimeRestriction = runtimeRestriction;
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

    public Package withTags(List<String> tags) {
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

    public Package withLabels(Labels labels) {
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

    public Package withDocumentationLabels(DocumentationLabels documentationLabels) {
        this.documentationLabels = documentationLabels;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Package.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ordId");
        sb.append('=');
        sb.append(((this.ordId == null)?"<null>":this.ordId));
        sb.append(',');
        sb.append("localId");
        sb.append('=');
        sb.append(((this.localId == null)?"<null>":this.localId));
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
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
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
        sb.append("packageLinks");
        sb.append('=');
        sb.append(((this.packageLinks == null)?"<null>":this.packageLinks));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("licenseType");
        sb.append('=');
        sb.append(((this.licenseType == null)?"<null>":this.licenseType));
        sb.append(',');
        sb.append("supportInfo");
        sb.append('=');
        sb.append(((this.supportInfo == null)?"<null>":this.supportInfo));
        sb.append(',');
        sb.append("vendor");
        sb.append('=');
        sb.append(((this.vendor == null)?"<null>":this.vendor));
        sb.append(',');
        sb.append("partOfProducts");
        sb.append('=');
        sb.append(((this.partOfProducts == null)?"<null>":this.partOfProducts));
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
        sb.append("runtimeRestriction");
        sb.append('=');
        sb.append(((this.runtimeRestriction == null)?"<null>":this.runtimeRestriction));
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
        result = ((result* 31)+((this.lineOfBusiness == null)? 0 :this.lineOfBusiness.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.industry == null)? 0 :this.industry.hashCode()));
        result = ((result* 31)+((this.shortDescription == null)? 0 :this.shortDescription.hashCode()));
        result = ((result* 31)+((this.customPolicyLevel == null)? 0 :this.customPolicyLevel.hashCode()));
        result = ((result* 31)+((this.countries == null)? 0 :this.countries.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        result = ((result* 31)+((this.localId == null)? 0 :this.localId.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.policyLevels == null)? 0 :this.policyLevels.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        result = ((result* 31)+((this.policyLevel == null)? 0 :this.policyLevel.hashCode()));
        result = ((result* 31)+((this.partOfProducts == null)? 0 :this.partOfProducts.hashCode()));
        result = ((result* 31)+((this.licenseType == null)? 0 :this.licenseType.hashCode()));
        result = ((result* 31)+((this.documentationLabels == null)? 0 :this.documentationLabels.hashCode()));
        result = ((result* 31)+((this.vendor == null)? 0 :this.vendor.hashCode()));
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        result = ((result* 31)+((this.runtimeRestriction == null)? 0 :this.runtimeRestriction.hashCode()));
        result = ((result* 31)+((this.packageLinks == null)? 0 :this.packageLinks.hashCode()));
        result = ((result* 31)+((this.supportInfo == null)? 0 :this.supportInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Package) == false) {
            return false;
        }
        Package rhs = ((Package) other);
        return (((((((((((((((((((((((this.lineOfBusiness == rhs.lineOfBusiness)||((this.lineOfBusiness!= null)&&this.lineOfBusiness.equals(rhs.lineOfBusiness)))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.industry == rhs.industry)||((this.industry!= null)&&this.industry.equals(rhs.industry))))&&((this.shortDescription == rhs.shortDescription)||((this.shortDescription!= null)&&this.shortDescription.equals(rhs.shortDescription))))&&((this.customPolicyLevel == rhs.customPolicyLevel)||((this.customPolicyLevel!= null)&&this.customPolicyLevel.equals(rhs.customPolicyLevel))))&&((this.countries == rhs.countries)||((this.countries!= null)&&this.countries.equals(rhs.countries))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.localId == rhs.localId)||((this.localId!= null)&&this.localId.equals(rhs.localId))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.policyLevels == rhs.policyLevels)||((this.policyLevels!= null)&&this.policyLevels.equals(rhs.policyLevels))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.policyLevel == rhs.policyLevel)||((this.policyLevel!= null)&&this.policyLevel.equals(rhs.policyLevel))))&&((this.partOfProducts == rhs.partOfProducts)||((this.partOfProducts!= null)&&this.partOfProducts.equals(rhs.partOfProducts))))&&((this.licenseType == rhs.licenseType)||((this.licenseType!= null)&&this.licenseType.equals(rhs.licenseType))))&&((this.documentationLabels == rhs.documentationLabels)||((this.documentationLabels!= null)&&this.documentationLabels.equals(rhs.documentationLabels))))&&((this.vendor == rhs.vendor)||((this.vendor!= null)&&this.vendor.equals(rhs.vendor))))&&((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links))))&&((this.runtimeRestriction == rhs.runtimeRestriction)||((this.runtimeRestriction!= null)&&this.runtimeRestriction.equals(rhs.runtimeRestriction))))&&((this.packageLinks == rhs.packageLinks)||((this.packageLinks!= null)&&this.packageLinks.equals(rhs.packageLinks))))&&((this.supportInfo == rhs.supportInfo)||((this.supportInfo!= null)&&this.supportInfo.equals(rhs.supportInfo))));
    }

}
