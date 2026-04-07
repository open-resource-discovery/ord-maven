package org.openresourcediscovery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.processing.Generated;

/**
 * Capability Integration Aspect
 * <p>
 * Capability related integration aspect
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ordId", "minVersion"})
@Generated("jsonschema2pojo")
public class CapabilityIntegrationAspect {

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

  public CapabilityIntegrationAspect withOrdId(String ordId) {
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

  public CapabilityIntegrationAspect withMinVersion(String minVersion) {
    this.minVersion = minVersion;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(CapabilityIntegrationAspect.class.getName())
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
    result = ((result * 31) + ((this.ordId == null) ? 0 : this.ordId.hashCode()));
    result = ((result * 31) + ((this.minVersion == null) ? 0 : this.minVersion.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof CapabilityIntegrationAspect) == false) {
      return false;
    }
    CapabilityIntegrationAspect rhs = ((CapabilityIntegrationAspect) other);
    return (((this.ordId == rhs.ordId) || ((this.ordId != null) && this.ordId.equals(rhs.ordId)))
        && ((this.minVersion == rhs.minVersion)
            || ((this.minVersion != null) && this.minVersion.equals(rhs.minVersion))));
  }
}
