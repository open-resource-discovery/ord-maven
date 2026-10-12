package org.openresourcediscovery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Capability Integration Aspect Subset
 * <p>
 * Defines that the Capability Integration Aspect only requires a subset of the referenced capability.
 *
 * For bundling capabilities such as `agent-plugin`, this is the list of contained skills that need to be available to make the integration work.
 * Without a `subset`, the dependency implies the whole capability (e.g. the entire plugin).
 * With a `subset`, only the listed skills are required, allowing consumers to understand / load only the minimal surface area needed.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"skillName"})
public class CapabilityIntegrationAspectSubset {

  /**
   * The name of the individual skill within the referenced capability.
   *
   * This MUST be a name that is understood within the referenced capability's definition (e.g. the skill `name` inside an `agent-plugin` bundle).
   * Where the referenced capability uses the Agent Skills format, `skillName` MUST match the `name` field in the referenced skill's `SKILL.md` frontmatter.
   * (Required)
   *
   */
  @JsonProperty("skillName")
  @JsonPropertyDescription(
      "The name of the individual skill within the referenced capability.\n\nThis MUST be a name that is understood within the referenced capability's definition (e.g. the skill `name` inside an `agent-plugin` bundle).\nWhere the referenced capability uses the Agent Skills format, `skillName` MUST match the `name` field in the referenced skill's `SKILL.md` frontmatter.")
  private String skillName;

  /**
   * The name of the individual skill within the referenced capability.
   *
   * This MUST be a name that is understood within the referenced capability's definition (e.g. the skill `name` inside an `agent-plugin` bundle).
   * Where the referenced capability uses the Agent Skills format, `skillName` MUST match the `name` field in the referenced skill's `SKILL.md` frontmatter.
   * (Required)
   *
   */
  @JsonProperty("skillName")
  public String getSkillName() {
    return skillName;
  }

  /**
   * The name of the individual skill within the referenced capability.
   *
   * This MUST be a name that is understood within the referenced capability's definition (e.g. the skill `name` inside an `agent-plugin` bundle).
   * Where the referenced capability uses the Agent Skills format, `skillName` MUST match the `name` field in the referenced skill's `SKILL.md` frontmatter.
   * (Required)
   *
   */
  @JsonProperty("skillName")
  public void setSkillName(String skillName) {
    this.skillName = skillName;
  }

  public CapabilityIntegrationAspectSubset withSkillName(String skillName) {
    this.skillName = skillName;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(CapabilityIntegrationAspectSubset.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("skillName");
    sb.append('=');
    sb.append(((this.skillName == null) ? "<null>" : this.skillName));
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
    result = ((result * 31) + ((this.skillName == null) ? 0 : this.skillName.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof CapabilityIntegrationAspectSubset) == false) {
      return false;
    }
    CapabilityIntegrationAspectSubset rhs = ((CapabilityIntegrationAspectSubset) other);
    return ((this.skillName == rhs.skillName)
        || ((this.skillName != null) && this.skillName.equals(rhs.skillName)));
  }
}
