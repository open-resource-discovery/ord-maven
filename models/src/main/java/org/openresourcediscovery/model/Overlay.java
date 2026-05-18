package org.openresourcediscovery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
import java.util.List;

/**
 * Overlay
 * <p>
 * An Overlay Resource is a standalone, versioned resource that references a metadata patch file.
 * Overlays enrich / patch resource definition files (e.g. OpenAPI) without modifying the originals, e.g. to add AI-optimized descriptions, apply governance annotations, or adapt definitions for a specific audience / purpose.
 *
 * Use an Overlay Resource for overlays that serve a different concern or audience than the original metadata — such as AI enrichment, governance annotations, or audience-specific adaptations — and are managed independently or applied across multiple resources.
 * For producer-owned overlays that belong to a single resource, they SHOULD instead be attached directly as a `resourceDefinitions` entry with `type: ord:overlay:v1`.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "ordId",
  "title",
  "description",
  "version",
  "lastUpdate",
  "visibility",
  "releaseStatus",
  "relatedApiResources",
  "relatedEventResources",
  "definitions",
  "tags",
  "labels"
})
public class Overlay {

  /**
   * The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.
   *
   * It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.
   * (Required)
   *
   */
  @JsonProperty("ordId")
  @JsonPropertyDescription(
      "The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.\n\nIt MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.")
  private String ordId;
  /**
   * Human-readable title.
   *
   * MUST NOT exceed 255 chars.
   * MUST NOT contain line breaks.
   *
   */
  @JsonProperty("title")
  @JsonPropertyDescription("Human-readable title.\n\nMUST NOT exceed 255 chars.\nMUST NOT contain line breaks.")
  private String title;
  /**
   * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
   *
   * The description SHOULD not be excessive in length and is not meant to provide full documentation.
   * Detailed documentation SHOULD be attached as (typed) links.
   *
   */
  @JsonProperty("description")
  @JsonPropertyDescription(
      "Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nThe description SHOULD not be excessive in length and is not meant to provide full documentation.\nDetailed documentation SHOULD be attached as (typed) links.")
  private String description;
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
  @JsonPropertyDescription(
      "The complete [SemVer](https://semver.org/) version string.\n\nIt MUST follow the [Semantic Versioning 2.0.0](https://semver.org/) standard.\nIt SHOULD be changed if the ORD information or referenced resource definitions changed.\nIt SHOULD express minor and patch changes that don't lead to incompatible changes.\n\nWhen the `version` major version changes, the [ORD ID](../index.md#ord-id) `<majorVersion>` fragment MUST be updated to be identical.\nIn case that a resource definition file also contains a version number (e.g. [OpenAPI `info`.`version`](https://spec.openapis.org/oas/v3.1.1.html#info-object)), it MUST be equal with the resource `version` to avoid inconsistencies.\n\nIf the resource has been extended by the user, the change MUST be indicated via `lastUpdate`.\nThe `version` MUST not be bumped for changes in extensions.\n\nThe general [Version and Lifecycle](../index.md#version-and-lifecycle) flow MUST be followed.\n\nNote: A change is only relevant for a version increment, if it affects the ORD resource or ORD taxonomy directly.\nFor example: If a resource within a `Package` changes, but the Package itself did not, the Package version does not need to be incremented.")
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
  @JsonPropertyDescription(
      "Optional, but RECOMMENDED indicator when (date-time) the last change to the resource (including its definitions) happened.\n\nThe date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).\n\nWhen retrieved from an ORD aggregator, `lastUpdate` will be reliable there and reflect either the provider based update time or the aggregator processing time.\nTherefore consumers MAY rely on it to detect changes to the metadata and the attached resource definition files.\n\nIf the resource has attached definitions, either the `version` or `lastUpdate` property MUST be defined and updated to let the ORD aggregator know that they need to be fetched again.\n\nTogether with `perspectives`, this property SHOULD be used to optimize the metadata crawling process of the ORD aggregators.")
  private Date lastUpdate;
  /**
   * Defines metadata access control - which categories of consumers are allowed to discover and access the resource and its metadata.
   *
   * This controls who can see that the resource exists and retrieve its metadata level information.
   * It does NOT control runtime access to the resource itself - that is managed separately through authentication and authorization mechanisms.
   *
   * Use this to prevent exposing internal implementation details to inappropriate consumer audiences.
   * (Required)
   *
   */
  @JsonProperty("visibility")
  @JsonPropertyDescription(
      "Defines metadata access control - which categories of consumers are allowed to discover and access the resource and its metadata.\n\nThis controls who can see that the resource exists and retrieve its metadata level information.\nIt does NOT control runtime access to the resource itself - that is managed separately through authentication and authorization mechanisms.\n\nUse this to prevent exposing internal implementation details to inappropriate consumer audiences.")
  private String visibility;
  /**
   * Defines the maturity level and stability commitment for the resource's API contract (interface, behavior, data models).
   *
   * This indicates whether the resource may undergo backward-incompatible changes. It helps consumers understand the risk
   * of depending on the resource and whether it's suitable for production use.
   *
   * Note: This is independent of `visibility` and does not imply availability guarantees or SLAs - it concerns only the API contract stability.
   *
   * See [Lifecycle](../index.md#lifecycle) and [Compatibility](../concepts/compatibility.md) for more details.
   * (Required)
   *
   */
  @JsonProperty("releaseStatus")
  @JsonPropertyDescription(
      "Defines the maturity level and stability commitment for the resource's API contract (interface, behavior, data models).\n\nThis indicates whether the resource may undergo backward-incompatible changes. It helps consumers understand the risk\nof depending on the resource and whether it's suitable for production use.\n\nNote: This is independent of `visibility` and does not imply availability guarantees or SLAs - it concerns only the API contract stability.\n\nSee [Lifecycle](../index.md#lifecycle) and [Compatibility](../concepts/compatibility.md) for more details.")
  private String releaseStatus;
  /**
   * Optional list of API Resources whose definition files this overlay patches.
   *
   * SHOULD be provided when the target resource is described in an ORD document accessible to the same aggregator,
   * as it enables efficient indexing without requiring the aggregator to parse each overlay file.
   * Use `relationType: ord:patches` to express the patching relationship.
   *
   * May be omitted when the target resource is not described in an accessible ORD document,
   * or when the overlay is cross-cutting and patches resources from multiple providers.
   *
   */
  @JsonProperty("relatedApiResources")
  @JsonPropertyDescription(
      "Optional list of API Resources whose definition files this overlay patches.\n\nSHOULD be provided when the target resource is described in an ORD document accessible to the same aggregator,\nas it enables efficient indexing without requiring the aggregator to parse each overlay file.\nUse `relationType: ord:patches` to express the patching relationship.\n\nMay be omitted when the target resource is not described in an accessible ORD document,\nor when the overlay is cross-cutting and patches resources from multiple providers.")
  private List<RelatedApiResource> relatedApiResources;
  /**
   * Optional list of Event Resources whose definition files this overlay patches.
   *
   * SHOULD be provided when the target resource is described in an ORD document accessible to the same aggregator,
   * as it enables efficient indexing without requiring the aggregator to parse each overlay file.
   * Use `relationType: ord:patches` to express the patching relationship.
   *
   * May be omitted when the target resource is not described in an accessible ORD document,
   * or when the overlay is cross-cutting and patches resources from multiple providers.
   *
   */
  @JsonProperty("relatedEventResources")
  @JsonPropertyDescription(
      "Optional list of Event Resources whose definition files this overlay patches.\n\nSHOULD be provided when the target resource is described in an ORD document accessible to the same aggregator,\nas it enables efficient indexing without requiring the aggregator to parse each overlay file.\nUse `relationType: ord:patches` to express the patching relationship.\n\nMay be omitted when the target resource is not described in an accessible ORD document,\nor when the overlay is cross-cutting and patches resources from multiple providers.")
  private List<RelatedEventResource> relatedEventResources;
  /**
   * List of overlay definition files referenced by this ORD Overlay Resource.
   * Each entry points to an ORD Overlay document (`type: ord:overlay:v1`) that contains the actual patches.
   *
   */
  @JsonProperty("definitions")
  @JsonPropertyDescription(
      "List of overlay definition files referenced by this ORD Overlay Resource.\nEach entry points to an ORD Overlay document (`type: ord:overlay:v1`) that contains the actual patches.")
  private List<OverlayDefinition> definitions;
  /**
   * List of free text style tags.
   * No special characters are allowed except `-`, `_`, `.`, `/` and ` `.
   *
   * Tags that are assigned to a `Package` are inherited to all of the ORD resources it contains.
   *
   */
  @JsonProperty("tags")
  @JsonPropertyDescription(
      "List of free text style tags.\nNo special characters are allowed except `-`, `_`, `.`, `/` and ` `.\n\nTags that are assigned to a `Package` are inherited to all of the ORD resources it contains.")
  private List<String> tags;
  /**
   * Labels
   * <p>
   * Generic key-value labels that can be applied to most ORD information.
   * They are defined as an object that may have arbitrary keys.
   * The value of a key is an array of strings.
   *
   * Labels can be used to attach technical information that cannot be expressed natively in ORD.
   * An ORD aggregator should allow to categorize and query information based on the labels provided.
   *
   * To learn more about the concept, see [Labels](../concepts/grouping-and-bundling#labels).
   *
   * If multiple parties rely on the existence of certain label information,
   * standardization through ORD SHOULD be preferred.
   *
   * All labels attached to a `Package` will be inherited to the resources they contain.
   * Duplicate labels will be merged by the ORD aggregator according to the following rules:
   * * Values of the same label key will be merged.
   * * Duplicate values of the same label key will be removed.
   *
   * **RECOMMENDATION**: Use a [Concept ID](../index.md#concept-id) as the label key to indicate ownership and avoid naming conflicts.
   * The namespace in the Concept ID clearly identifies who owns and defines the label's semantics.
   *
   */
  @JsonProperty("labels")
  @JsonPropertyDescription(
      "Generic key-value labels that can be applied to most ORD information.\nThey are defined as an object that may have arbitrary keys.\nThe value of a key is an array of strings.\n\nLabels can be used to attach technical information that cannot be expressed natively in ORD.\nAn ORD aggregator should allow to categorize and query information based on the labels provided.\n\nTo learn more about the concept, see [Labels](../concepts/grouping-and-bundling#labels).\n\nIf multiple parties rely on the existence of certain label information,\nstandardization through ORD SHOULD be preferred.\n\nAll labels attached to a `Package` will be inherited to the resources they contain.\nDuplicate labels will be merged by the ORD aggregator according to the following rules:\n* Values of the same label key will be merged.\n* Duplicate values of the same label key will be removed.\n\n**RECOMMENDATION**: Use a [Concept ID](../index.md#concept-id) as the label key to indicate ownership and avoid naming conflicts.\nThe namespace in the Concept ID clearly identifies who owns and defines the label's semantics.")
  private Labels labels;

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

  public Overlay withOrdId(String ordId) {
    this.ordId = ordId;
    return this;
  }

  /**
   * Human-readable title.
   *
   * MUST NOT exceed 255 chars.
   * MUST NOT contain line breaks.
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
   *
   */
  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }

  public Overlay withTitle(String title) {
    this.title = title;
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

  public Overlay withDescription(String description) {
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

  public Overlay withVersion(String version) {
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

  public Overlay withLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Defines metadata access control - which categories of consumers are allowed to discover and access the resource and its metadata.
   *
   * This controls who can see that the resource exists and retrieve its metadata level information.
   * It does NOT control runtime access to the resource itself - that is managed separately through authentication and authorization mechanisms.
   *
   * Use this to prevent exposing internal implementation details to inappropriate consumer audiences.
   * (Required)
   *
   */
  @JsonProperty("visibility")
  public String getVisibility() {
    return visibility;
  }

  /**
   * Defines metadata access control - which categories of consumers are allowed to discover and access the resource and its metadata.
   *
   * This controls who can see that the resource exists and retrieve its metadata level information.
   * It does NOT control runtime access to the resource itself - that is managed separately through authentication and authorization mechanisms.
   *
   * Use this to prevent exposing internal implementation details to inappropriate consumer audiences.
   * (Required)
   *
   */
  @JsonProperty("visibility")
  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  public Overlay withVisibility(String visibility) {
    this.visibility = visibility;
    return this;
  }

  /**
   * Defines the maturity level and stability commitment for the resource's API contract (interface, behavior, data models).
   *
   * This indicates whether the resource may undergo backward-incompatible changes. It helps consumers understand the risk
   * of depending on the resource and whether it's suitable for production use.
   *
   * Note: This is independent of `visibility` and does not imply availability guarantees or SLAs - it concerns only the API contract stability.
   *
   * See [Lifecycle](../index.md#lifecycle) and [Compatibility](../concepts/compatibility.md) for more details.
   * (Required)
   *
   */
  @JsonProperty("releaseStatus")
  public String getReleaseStatus() {
    return releaseStatus;
  }

  /**
   * Defines the maturity level and stability commitment for the resource's API contract (interface, behavior, data models).
   *
   * This indicates whether the resource may undergo backward-incompatible changes. It helps consumers understand the risk
   * of depending on the resource and whether it's suitable for production use.
   *
   * Note: This is independent of `visibility` and does not imply availability guarantees or SLAs - it concerns only the API contract stability.
   *
   * See [Lifecycle](../index.md#lifecycle) and [Compatibility](../concepts/compatibility.md) for more details.
   * (Required)
   *
   */
  @JsonProperty("releaseStatus")
  public void setReleaseStatus(String releaseStatus) {
    this.releaseStatus = releaseStatus;
  }

  public Overlay withReleaseStatus(String releaseStatus) {
    this.releaseStatus = releaseStatus;
    return this;
  }

  /**
   * Optional list of API Resources whose definition files this overlay patches.
   *
   * SHOULD be provided when the target resource is described in an ORD document accessible to the same aggregator,
   * as it enables efficient indexing without requiring the aggregator to parse each overlay file.
   * Use `relationType: ord:patches` to express the patching relationship.
   *
   * May be omitted when the target resource is not described in an accessible ORD document,
   * or when the overlay is cross-cutting and patches resources from multiple providers.
   *
   */
  @JsonProperty("relatedApiResources")
  public List<RelatedApiResource> getRelatedApiResources() {
    return relatedApiResources;
  }

  /**
   * Optional list of API Resources whose definition files this overlay patches.
   *
   * SHOULD be provided when the target resource is described in an ORD document accessible to the same aggregator,
   * as it enables efficient indexing without requiring the aggregator to parse each overlay file.
   * Use `relationType: ord:patches` to express the patching relationship.
   *
   * May be omitted when the target resource is not described in an accessible ORD document,
   * or when the overlay is cross-cutting and patches resources from multiple providers.
   *
   */
  @JsonProperty("relatedApiResources")
  public void setRelatedApiResources(List<RelatedApiResource> relatedApiResources) {
    this.relatedApiResources = relatedApiResources;
  }

  public Overlay withRelatedApiResources(List<RelatedApiResource> relatedApiResources) {
    this.relatedApiResources = relatedApiResources;
    return this;
  }

  /**
   * Optional list of Event Resources whose definition files this overlay patches.
   *
   * SHOULD be provided when the target resource is described in an ORD document accessible to the same aggregator,
   * as it enables efficient indexing without requiring the aggregator to parse each overlay file.
   * Use `relationType: ord:patches` to express the patching relationship.
   *
   * May be omitted when the target resource is not described in an accessible ORD document,
   * or when the overlay is cross-cutting and patches resources from multiple providers.
   *
   */
  @JsonProperty("relatedEventResources")
  public List<RelatedEventResource> getRelatedEventResources() {
    return relatedEventResources;
  }

  /**
   * Optional list of Event Resources whose definition files this overlay patches.
   *
   * SHOULD be provided when the target resource is described in an ORD document accessible to the same aggregator,
   * as it enables efficient indexing without requiring the aggregator to parse each overlay file.
   * Use `relationType: ord:patches` to express the patching relationship.
   *
   * May be omitted when the target resource is not described in an accessible ORD document,
   * or when the overlay is cross-cutting and patches resources from multiple providers.
   *
   */
  @JsonProperty("relatedEventResources")
  public void setRelatedEventResources(List<RelatedEventResource> relatedEventResources) {
    this.relatedEventResources = relatedEventResources;
  }

  public Overlay withRelatedEventResources(List<RelatedEventResource> relatedEventResources) {
    this.relatedEventResources = relatedEventResources;
    return this;
  }

  /**
   * List of overlay definition files referenced by this ORD Overlay Resource.
   * Each entry points to an ORD Overlay document (`type: ord:overlay:v1`) that contains the actual patches.
   *
   */
  @JsonProperty("definitions")
  public List<OverlayDefinition> getDefinitions() {
    return definitions;
  }

  /**
   * List of overlay definition files referenced by this ORD Overlay Resource.
   * Each entry points to an ORD Overlay document (`type: ord:overlay:v1`) that contains the actual patches.
   *
   */
  @JsonProperty("definitions")
  public void setDefinitions(List<OverlayDefinition> definitions) {
    this.definitions = definitions;
  }

  public Overlay withDefinitions(List<OverlayDefinition> definitions) {
    this.definitions = definitions;
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

  public Overlay withTags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  /**
   * Labels
   * <p>
   * Generic key-value labels that can be applied to most ORD information.
   * They are defined as an object that may have arbitrary keys.
   * The value of a key is an array of strings.
   *
   * Labels can be used to attach technical information that cannot be expressed natively in ORD.
   * An ORD aggregator should allow to categorize and query information based on the labels provided.
   *
   * To learn more about the concept, see [Labels](../concepts/grouping-and-bundling#labels).
   *
   * If multiple parties rely on the existence of certain label information,
   * standardization through ORD SHOULD be preferred.
   *
   * All labels attached to a `Package` will be inherited to the resources they contain.
   * Duplicate labels will be merged by the ORD aggregator according to the following rules:
   * * Values of the same label key will be merged.
   * * Duplicate values of the same label key will be removed.
   *
   * **RECOMMENDATION**: Use a [Concept ID](../index.md#concept-id) as the label key to indicate ownership and avoid naming conflicts.
   * The namespace in the Concept ID clearly identifies who owns and defines the label's semantics.
   *
   */
  @JsonProperty("labels")
  public Labels getLabels() {
    return labels;
  }

  /**
   * Labels
   * <p>
   * Generic key-value labels that can be applied to most ORD information.
   * They are defined as an object that may have arbitrary keys.
   * The value of a key is an array of strings.
   *
   * Labels can be used to attach technical information that cannot be expressed natively in ORD.
   * An ORD aggregator should allow to categorize and query information based on the labels provided.
   *
   * To learn more about the concept, see [Labels](../concepts/grouping-and-bundling#labels).
   *
   * If multiple parties rely on the existence of certain label information,
   * standardization through ORD SHOULD be preferred.
   *
   * All labels attached to a `Package` will be inherited to the resources they contain.
   * Duplicate labels will be merged by the ORD aggregator according to the following rules:
   * * Values of the same label key will be merged.
   * * Duplicate values of the same label key will be removed.
   *
   * **RECOMMENDATION**: Use a [Concept ID](../index.md#concept-id) as the label key to indicate ownership and avoid naming conflicts.
   * The namespace in the Concept ID clearly identifies who owns and defines the label's semantics.
   *
   */
  @JsonProperty("labels")
  public void setLabels(Labels labels) {
    this.labels = labels;
  }

  public Overlay withLabels(Labels labels) {
    this.labels = labels;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Overlay.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("ordId");
    sb.append('=');
    sb.append(((this.ordId == null) ? "<null>" : this.ordId));
    sb.append(',');
    sb.append("title");
    sb.append('=');
    sb.append(((this.title == null) ? "<null>" : this.title));
    sb.append(',');
    sb.append("description");
    sb.append('=');
    sb.append(((this.description == null) ? "<null>" : this.description));
    sb.append(',');
    sb.append("version");
    sb.append('=');
    sb.append(((this.version == null) ? "<null>" : this.version));
    sb.append(',');
    sb.append("lastUpdate");
    sb.append('=');
    sb.append(((this.lastUpdate == null) ? "<null>" : this.lastUpdate));
    sb.append(',');
    sb.append("visibility");
    sb.append('=');
    sb.append(((this.visibility == null) ? "<null>" : this.visibility));
    sb.append(',');
    sb.append("releaseStatus");
    sb.append('=');
    sb.append(((this.releaseStatus == null) ? "<null>" : this.releaseStatus));
    sb.append(',');
    sb.append("relatedApiResources");
    sb.append('=');
    sb.append(((this.relatedApiResources == null) ? "<null>" : this.relatedApiResources));
    sb.append(',');
    sb.append("relatedEventResources");
    sb.append('=');
    sb.append(((this.relatedEventResources == null) ? "<null>" : this.relatedEventResources));
    sb.append(',');
    sb.append("definitions");
    sb.append('=');
    sb.append(((this.definitions == null) ? "<null>" : this.definitions));
    sb.append(',');
    sb.append("tags");
    sb.append('=');
    sb.append(((this.tags == null) ? "<null>" : this.tags));
    sb.append(',');
    sb.append("labels");
    sb.append('=');
    sb.append(((this.labels == null) ? "<null>" : this.labels));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = ((result * 31) + ((this.visibility == null) ? 0 : this.visibility.hashCode()));
    result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
    result = ((result * 31) + ((this.relatedApiResources == null) ? 0 : this.relatedApiResources.hashCode()));
    result = ((result * 31) + ((this.title == null) ? 0 : this.title.hashCode()));
    result = ((result * 31) + ((this.ordId == null) ? 0 : this.ordId.hashCode()));
    result = ((result * 31) + ((this.version == null) ? 0 : this.version.hashCode()));
    result = ((result * 31) + ((this.tags == null) ? 0 : this.tags.hashCode()));
    result = ((result * 31) + ((this.labels == null) ? 0 : this.labels.hashCode()));
    result = ((result * 31) + ((this.relatedEventResources == null) ? 0 : this.relatedEventResources.hashCode()));
    result = ((result * 31) + ((this.lastUpdate == null) ? 0 : this.lastUpdate.hashCode()));
    result = ((result * 31) + ((this.releaseStatus == null) ? 0 : this.releaseStatus.hashCode()));
    result = ((result * 31) + ((this.definitions == null) ? 0 : this.definitions.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof Overlay) == false) {
      return false;
    }
    Overlay rhs = ((Overlay) other);
    return (((((((((((((this.visibility == rhs.visibility)
                                                    || ((this
                                                                .visibility
                                                            != null)
                                                        && this
                                                            .visibility
                                                            .equals(
                                                                rhs.visibility)))
                                                && ((this.description
                                                        == rhs.description)
                                                    || ((this
                                                                .description
                                                            != null)
                                                        && this
                                                            .description
                                                            .equals(
                                                                rhs.description))))
                                            && ((this.relatedApiResources
                                                    == rhs.relatedApiResources)
                                                || ((this
                                                            .relatedApiResources
                                                        != null)
                                                    && this
                                                        .relatedApiResources
                                                        .equals(
                                                            rhs.relatedApiResources))))
                                        && ((this.title == rhs.title)
                                            || ((this.title != null)
                                                && this.title.equals(
                                                    rhs.title))))
                                    && ((this.ordId == rhs.ordId)
                                        || ((this.ordId != null)
                                            && this.ordId.equals(
                                                rhs.ordId))))
                                && ((this.version == rhs.version)
                                    || ((this.version != null)
                                        && this.version.equals(rhs.version))))
                            && ((this.tags == rhs.tags)
                                || ((this.tags != null) && this.tags.equals(rhs.tags))))
                        && ((this.labels == rhs.labels)
                            || ((this.labels != null) && this.labels.equals(rhs.labels))))
                    && ((this.relatedEventResources == rhs.relatedEventResources)
                        || ((this.relatedEventResources != null)
                            && this.relatedEventResources.equals(
                                rhs.relatedEventResources))))
                && ((this.lastUpdate == rhs.lastUpdate)
                    || ((this.lastUpdate != null) && this.lastUpdate.equals(rhs.lastUpdate))))
            && ((this.releaseStatus == rhs.releaseStatus)
                || ((this.releaseStatus != null) && this.releaseStatus.equals(rhs.releaseStatus))))
        && ((this.definitions == rhs.definitions)
            || ((this.definitions != null) && this.definitions.equals(rhs.definitions))));
  }
}
