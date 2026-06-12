package org.openresourcediscovery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 * Aspect
 * <p>
 * An (integration) aspect is the constituent part that makes up an Integration Dependency.
 *
 * Each aspect can list references to resources, which could be owned and defined by the integration target or by the described system itself.
 * In case the reference links to own resources, it is implied that they are to be used by the integration target to fulfill the Integration Dependency.
 *
 * If multiple resources are given within an aspect, they are considered alternatives to each other (OR condition).
 * In case an AND condition is needed, multiple aspects need to be added to the Integration Dependency.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "title",
  "description",
  "mandatory",
  "supportMultipleProviders",
  "apiResources",
  "eventResources",
  "capabilities",
  "labels"
})
public class IntegrationAspect {

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
   * If true, the aspect is mandatory to realize the Integration Dependency it contains.
   * (Required)
   *
   */
  @JsonProperty("mandatory")
  @JsonPropertyDescription("If true, the aspect is mandatory to realize the Integration Dependency it contains.")
  private Boolean mandatory;
  /**
   * If true, the references resources can be provided by multiple system instances.
   * If not, only one integration target is supported.
   *
   */
  @JsonProperty("supportMultipleProviders")
  @JsonPropertyDescription(
      "If true, the references resources can be provided by multiple system instances.\nIf not, only one integration target is supported.")
  private Boolean supportMultipleProviders;
  /**
   * List of API Resource Dependencies.
   *
   */
  @JsonProperty("apiResources")
  @JsonPropertyDescription("List of API Resource Dependencies.")
  private List<ApiResourceIntegrationAspect> apiResources;
  /**
   * List of Event Resource Dependencies.
   *
   */
  @JsonProperty("eventResources")
  @JsonPropertyDescription("List of Event Resource Dependencies.")
  private List<EventResourceIntegrationAspect> eventResources;
  /**
   * List of Capability Dependencies.
   *
   */
  @JsonProperty("capabilities")
  @JsonPropertyDescription("List of Capability Dependencies.")
  private List<CapabilityIntegrationAspect> capabilities;
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

  public IntegrationAspect withTitle(String title) {
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

  public IntegrationAspect withDescription(String description) {
    this.description = description;
    return this;
  }

  /**
   * If true, the aspect is mandatory to realize the Integration Dependency it contains.
   * (Required)
   *
   */
  @JsonProperty("mandatory")
  public Boolean getMandatory() {
    return mandatory;
  }

  /**
   * If true, the aspect is mandatory to realize the Integration Dependency it contains.
   * (Required)
   *
   */
  @JsonProperty("mandatory")
  public void setMandatory(Boolean mandatory) {
    this.mandatory = mandatory;
  }

  public IntegrationAspect withMandatory(Boolean mandatory) {
    this.mandatory = mandatory;
    return this;
  }

  /**
   * If true, the references resources can be provided by multiple system instances.
   * If not, only one integration target is supported.
   *
   */
  @JsonProperty("supportMultipleProviders")
  public Boolean getSupportMultipleProviders() {
    return supportMultipleProviders;
  }

  /**
   * If true, the references resources can be provided by multiple system instances.
   * If not, only one integration target is supported.
   *
   */
  @JsonProperty("supportMultipleProviders")
  public void setSupportMultipleProviders(Boolean supportMultipleProviders) {
    this.supportMultipleProviders = supportMultipleProviders;
  }

  public IntegrationAspect withSupportMultipleProviders(Boolean supportMultipleProviders) {
    this.supportMultipleProviders = supportMultipleProviders;
    return this;
  }

  /**
   * List of API Resource Dependencies.
   *
   */
  @JsonProperty("apiResources")
  public List<ApiResourceIntegrationAspect> getApiResources() {
    return apiResources;
  }

  /**
   * List of API Resource Dependencies.
   *
   */
  @JsonProperty("apiResources")
  public void setApiResources(List<ApiResourceIntegrationAspect> apiResources) {
    this.apiResources = apiResources;
  }

  public IntegrationAspect withApiResources(List<ApiResourceIntegrationAspect> apiResources) {
    this.apiResources = apiResources;
    return this;
  }

  /**
   * List of Event Resource Dependencies.
   *
   */
  @JsonProperty("eventResources")
  public List<EventResourceIntegrationAspect> getEventResources() {
    return eventResources;
  }

  /**
   * List of Event Resource Dependencies.
   *
   */
  @JsonProperty("eventResources")
  public void setEventResources(List<EventResourceIntegrationAspect> eventResources) {
    this.eventResources = eventResources;
  }

  public IntegrationAspect withEventResources(List<EventResourceIntegrationAspect> eventResources) {
    this.eventResources = eventResources;
    return this;
  }

  /**
   * List of Capability Dependencies.
   *
   */
  @JsonProperty("capabilities")
  public List<CapabilityIntegrationAspect> getCapabilities() {
    return capabilities;
  }

  /**
   * List of Capability Dependencies.
   *
   */
  @JsonProperty("capabilities")
  public void setCapabilities(List<CapabilityIntegrationAspect> capabilities) {
    this.capabilities = capabilities;
  }

  public IntegrationAspect withCapabilities(List<CapabilityIntegrationAspect> capabilities) {
    this.capabilities = capabilities;
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

  public IntegrationAspect withLabels(Labels labels) {
    this.labels = labels;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(IntegrationAspect.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("title");
    sb.append('=');
    sb.append(((this.title == null) ? "<null>" : this.title));
    sb.append(',');
    sb.append("description");
    sb.append('=');
    sb.append(((this.description == null) ? "<null>" : this.description));
    sb.append(',');
    sb.append("mandatory");
    sb.append('=');
    sb.append(((this.mandatory == null) ? "<null>" : this.mandatory));
    sb.append(',');
    sb.append("supportMultipleProviders");
    sb.append('=');
    sb.append(((this.supportMultipleProviders == null) ? "<null>" : this.supportMultipleProviders));
    sb.append(',');
    sb.append("apiResources");
    sb.append('=');
    sb.append(((this.apiResources == null) ? "<null>" : this.apiResources));
    sb.append(',');
    sb.append("eventResources");
    sb.append('=');
    sb.append(((this.eventResources == null) ? "<null>" : this.eventResources));
    sb.append(',');
    sb.append("capabilities");
    sb.append('=');
    sb.append(((this.capabilities == null) ? "<null>" : this.capabilities));
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
    result = ((result * 31) + ((this.capabilities == null) ? 0 : this.capabilities.hashCode()));
    result = ((result * 31) + ((this.apiResources == null) ? 0 : this.apiResources.hashCode()));
    result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
    result = ((result * 31) + ((this.title == null) ? 0 : this.title.hashCode()));
    result = ((result * 31) + ((this.mandatory == null) ? 0 : this.mandatory.hashCode()));
    result = ((result * 31) + ((this.eventResources == null) ? 0 : this.eventResources.hashCode()));
    result = ((result * 31)
        + ((this.supportMultipleProviders == null) ? 0 : this.supportMultipleProviders.hashCode()));
    result = ((result * 31) + ((this.labels == null) ? 0 : this.labels.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof IntegrationAspect) == false) {
      return false;
    }
    IntegrationAspect rhs = ((IntegrationAspect) other);
    return (((((((((this.capabilities == rhs.capabilities)
                                    || ((this.capabilities != null)
                                        && this.capabilities.equals(
                                            rhs.capabilities)))
                                && ((this.apiResources == rhs.apiResources)
                                    || ((this.apiResources != null)
                                        && this.apiResources.equals(
                                            rhs.apiResources))))
                            && ((this.description == rhs.description)
                                || ((this.description != null)
                                    && this.description.equals(rhs.description))))
                        && ((this.title == rhs.title)
                            || ((this.title != null) && this.title.equals(rhs.title))))
                    && ((this.mandatory == rhs.mandatory)
                        || ((this.mandatory != null) && this.mandatory.equals(rhs.mandatory))))
                && ((this.eventResources == rhs.eventResources)
                    || ((this.eventResources != null)
                        && this.eventResources.equals(rhs.eventResources))))
            && ((this.supportMultipleProviders == rhs.supportMultipleProviders)
                || ((this.supportMultipleProviders != null)
                    && this.supportMultipleProviders.equals(rhs.supportMultipleProviders))))
        && ((this.labels == rhs.labels) || ((this.labels != null) && this.labels.equals(rhs.labels))));
  }
}
