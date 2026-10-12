package org.openresourcediscovery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 * Api Resource Integration Aspect
 * <p>
 * API resource related integration aspect
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ordId", "minVersion", "subset", "labels"})
public class ApiResourceIntegrationAspect {

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
   * Minimum version of the references resource that the integration requires.
   *
   *
   */
  @JsonProperty("minVersion")
  @JsonPropertyDescription("Minimum version of the references resource that the integration requires.\n")
  private String minVersion;
  /**
   * Narrows the dependency to only the listed API operations (or MCP tools) that are required to achieve the aspect.
   *
   * If `subset` is not provided, the dependency implies that all operations of the referenced resource may be used.
   * If `subset` is provided, only the listed operations are required — consumers MUST NOT assume that other operations are available or permitted.
   *
   * For more details and examples, see [Integration Dependency](../concepts/integration-dependency).
   *
   */
  @JsonProperty("subset")
  @JsonPropertyDescription(
      "Narrows the dependency to only the listed API operations (or MCP tools) that are required to achieve the aspect.\n\nIf `subset` is not provided, the dependency implies that all operations of the referenced resource may be used.\nIf `subset` is provided, only the listed operations are required \u2014 consumers MUST NOT assume that other operations are available or permitted.\n\nFor more details and examples, see [Integration Dependency](../concepts/integration-dependency).")
  private List<ApiResourceIntegrationAspectSubset> subset;
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

  public ApiResourceIntegrationAspect withOrdId(String ordId) {
    this.ordId = ordId;
    return this;
  }

  /**
   * Minimum version of the references resource that the integration requires.
   *
   *
   */
  @JsonProperty("minVersion")
  public String getMinVersion() {
    return minVersion;
  }

  /**
   * Minimum version of the references resource that the integration requires.
   *
   *
   */
  @JsonProperty("minVersion")
  public void setMinVersion(String minVersion) {
    this.minVersion = minVersion;
  }

  public ApiResourceIntegrationAspect withMinVersion(String minVersion) {
    this.minVersion = minVersion;
    return this;
  }

  /**
   * Narrows the dependency to only the listed API operations (or MCP tools) that are required to achieve the aspect.
   *
   * If `subset` is not provided, the dependency implies that all operations of the referenced resource may be used.
   * If `subset` is provided, only the listed operations are required — consumers MUST NOT assume that other operations are available or permitted.
   *
   * For more details and examples, see [Integration Dependency](../concepts/integration-dependency).
   *
   */
  @JsonProperty("subset")
  public List<ApiResourceIntegrationAspectSubset> getSubset() {
    return subset;
  }

  /**
   * Narrows the dependency to only the listed API operations (or MCP tools) that are required to achieve the aspect.
   *
   * If `subset` is not provided, the dependency implies that all operations of the referenced resource may be used.
   * If `subset` is provided, only the listed operations are required — consumers MUST NOT assume that other operations are available or permitted.
   *
   * For more details and examples, see [Integration Dependency](../concepts/integration-dependency).
   *
   */
  @JsonProperty("subset")
  public void setSubset(List<ApiResourceIntegrationAspectSubset> subset) {
    this.subset = subset;
  }

  public ApiResourceIntegrationAspect withSubset(List<ApiResourceIntegrationAspectSubset> subset) {
    this.subset = subset;
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

  public ApiResourceIntegrationAspect withLabels(Labels labels) {
    this.labels = labels;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(ApiResourceIntegrationAspect.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("ordId");
    sb.append('=');
    sb.append(((this.ordId == null) ? "<null>" : this.ordId));
    sb.append(',');
    sb.append("minVersion");
    sb.append('=');
    sb.append(((this.minVersion == null) ? "<null>" : this.minVersion));
    sb.append(',');
    sb.append("subset");
    sb.append('=');
    sb.append(((this.subset == null) ? "<null>" : this.subset));
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
    result = ((result * 31) + ((this.minVersion == null) ? 0 : this.minVersion.hashCode()));
    result = ((result * 31) + ((this.ordId == null) ? 0 : this.ordId.hashCode()));
    result = ((result * 31) + ((this.subset == null) ? 0 : this.subset.hashCode()));
    result = ((result * 31) + ((this.labels == null) ? 0 : this.labels.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof ApiResourceIntegrationAspect) == false) {
      return false;
    }
    ApiResourceIntegrationAspect rhs = ((ApiResourceIntegrationAspect) other);
    return (((((this.minVersion == rhs.minVersion)
                    || ((this.minVersion != null) && this.minVersion.equals(rhs.minVersion)))
                && ((this.ordId == rhs.ordId)
                    || ((this.ordId != null) && this.ordId.equals(rhs.ordId))))
            && ((this.subset == rhs.subset) || ((this.subset != null) && this.subset.equals(rhs.subset))))
        && ((this.labels == rhs.labels) || ((this.labels != null) && this.labels.equals(rhs.labels))));
  }
}
