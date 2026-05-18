package org.openresourcediscovery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Extensible
 * <p>
 * Contains information about the extensibility of this resource.
 *
 * If applicable, a description and further resources about extending this resource are provided.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"supported", "description"})
public class Extensible {

  /**
   * Extensibility Support Level
   * <p>
   * Defines whether and how the resource can be extended with custom fields.
   * (Required)
   *
   */
  @JsonProperty("supported")
  @JsonPropertyDescription("Defines whether and how the resource can be extended with custom fields.")
  private String supported;
  /**
   * A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
   *
   * This description may contain detailed steps on how to extend the API.
   * Links to external resources can be provided within the description as markdown links.
   *
   * This description MUST be provided if `supported` is set to `manual` or `automatic`.
   *
   */
  @JsonProperty("description")
  @JsonPropertyDescription(
      "A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nThis description may contain detailed steps on how to extend the API.\nLinks to external resources can be provided within the description as markdown links.\n\nThis description MUST be provided if `supported` is set to `manual` or `automatic`.")
  private String description;

  /**
   * Extensibility Support Level
   * <p>
   * Defines whether and how the resource can be extended with custom fields.
   * (Required)
   *
   */
  @JsonProperty("supported")
  public String getSupported() {
    return supported;
  }

  /**
   * Extensibility Support Level
   * <p>
   * Defines whether and how the resource can be extended with custom fields.
   * (Required)
   *
   */
  @JsonProperty("supported")
  public void setSupported(String supported) {
    this.supported = supported;
  }

  public Extensible withSupported(String supported) {
    this.supported = supported;
    return this;
  }

  /**
   * A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
   *
   * This description may contain detailed steps on how to extend the API.
   * Links to external resources can be provided within the description as markdown links.
   *
   * This description MUST be provided if `supported` is set to `manual` or `automatic`.
   *
   */
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  /**
   * A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
   *
   * This description may contain detailed steps on how to extend the API.
   * Links to external resources can be provided within the description as markdown links.
   *
   * This description MUST be provided if `supported` is set to `manual` or `automatic`.
   *
   */
  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  public Extensible withDescription(String description) {
    this.description = description;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Extensible.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("supported");
    sb.append('=');
    sb.append(((this.supported == null) ? "<null>" : this.supported));
    sb.append(',');
    sb.append("description");
    sb.append('=');
    sb.append(((this.description == null) ? "<null>" : this.description));
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
    result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
    result = ((result * 31) + ((this.supported == null) ? 0 : this.supported.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof Extensible) == false) {
      return false;
    }
    Extensible rhs = ((Extensible) other);
    return (((this.description == rhs.description)
            || ((this.description != null) && this.description.equals(rhs.description)))
        && ((this.supported == rhs.supported)
            || ((this.supported != null) && this.supported.equals(rhs.supported))));
  }
}
