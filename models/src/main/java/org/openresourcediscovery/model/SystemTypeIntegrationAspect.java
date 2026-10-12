package org.openresourcediscovery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * System Type Integration Aspect
 * <p>
 * System-type related integration aspect.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"systemNamespace", "minSystemVersion"})
public class SystemTypeIntegrationAspect {

  /**
   * The [system namespace](../concepts/identifiers.md#system-namespace) that identifies the required system type.
   * (Required)
   *
   */
  @JsonProperty("systemNamespace")
  @JsonPropertyDescription(
      "The [system namespace](../concepts/identifiers.md#system-namespace) that identifies the required system type.")
  private String systemNamespace;
  /**
   * Minimum [system version](../index.md#system-version) that the integration requires.
   * The target system version MUST be greater than or equal to this value according to Semantic Versioning precedence.
   *
   */
  @JsonProperty("minSystemVersion")
  @JsonPropertyDescription(
      "Minimum [system version](../index.md#system-version) that the integration requires.\nThe target system version MUST be greater than or equal to this value according to Semantic Versioning precedence.")
  private String minSystemVersion;

  /**
   * The [system namespace](../concepts/identifiers.md#system-namespace) that identifies the required system type.
   * (Required)
   *
   */
  @JsonProperty("systemNamespace")
  public String getSystemNamespace() {
    return systemNamespace;
  }

  /**
   * The [system namespace](../concepts/identifiers.md#system-namespace) that identifies the required system type.
   * (Required)
   *
   */
  @JsonProperty("systemNamespace")
  public void setSystemNamespace(String systemNamespace) {
    this.systemNamespace = systemNamespace;
  }

  public SystemTypeIntegrationAspect withSystemNamespace(String systemNamespace) {
    this.systemNamespace = systemNamespace;
    return this;
  }

  /**
   * Minimum [system version](../index.md#system-version) that the integration requires.
   * The target system version MUST be greater than or equal to this value according to Semantic Versioning precedence.
   *
   */
  @JsonProperty("minSystemVersion")
  public String getMinSystemVersion() {
    return minSystemVersion;
  }

  /**
   * Minimum [system version](../index.md#system-version) that the integration requires.
   * The target system version MUST be greater than or equal to this value according to Semantic Versioning precedence.
   *
   */
  @JsonProperty("minSystemVersion")
  public void setMinSystemVersion(String minSystemVersion) {
    this.minSystemVersion = minSystemVersion;
  }

  public SystemTypeIntegrationAspect withMinSystemVersion(String minSystemVersion) {
    this.minSystemVersion = minSystemVersion;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(SystemTypeIntegrationAspect.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("systemNamespace");
    sb.append('=');
    sb.append(((this.systemNamespace == null) ? "<null>" : this.systemNamespace));
    sb.append(',');
    sb.append("minSystemVersion");
    sb.append('=');
    sb.append(((this.minSystemVersion == null) ? "<null>" : this.minSystemVersion));
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
    result = ((result * 31) + ((this.systemNamespace == null) ? 0 : this.systemNamespace.hashCode()));
    result = ((result * 31) + ((this.minSystemVersion == null) ? 0 : this.minSystemVersion.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof SystemTypeIntegrationAspect) == false) {
      return false;
    }
    SystemTypeIntegrationAspect rhs = ((SystemTypeIntegrationAspect) other);
    return (((this.systemNamespace == rhs.systemNamespace)
            || ((this.systemNamespace != null) && this.systemNamespace.equals(rhs.systemNamespace)))
        && ((this.minSystemVersion == rhs.minSystemVersion)
            || ((this.minSystemVersion != null) && this.minSystemVersion.equals(rhs.minSystemVersion))));
  }
}
