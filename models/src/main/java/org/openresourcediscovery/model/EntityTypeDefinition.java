package org.openresourcediscovery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 * Entity Type Definition
 * <p>
 * Machine-readable definition that describes the entity type's internal model structure.
 *
 * Entity Type definitions represent an internal implementation detail - the underlying domain model of your application.
 * This can be used to describe a shared internal model multiple APIs and Events are based on.
 * However, interaction with the actual data happens through API Resources or Event Resources that expose these entity types with a defined interface and contract.
 *
 * Each definition is an alternative description format for the same entity type.
 * The same definition type MUST NOT be provided more than once, except with different `visibility` or `mediaType`.
 *
 * **Why Entity Types are private by default**: Since entity type definitions are internal implementation details, they SHOULD be marked as `private` visibility by default.
 *
 * **Finding related APIs**: To discover which APIs expose a particular Entity Type, check the API Resource's `relatedEntityTypes` property.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "mediaType", "url", "accessStrategies", "visibility"})
public class EntityTypeDefinition {

  /**
   * Type of the entity type resource definition.
   *
   * MUST be either:
   * - any valid [Specification ID](../index.md#specification-id), or
   * - one of the pre-defined values listed below.
   * (Required)
   *
   */
  @JsonProperty("type")
  @JsonPropertyDescription(
      "Type of the entity type resource definition.\n\nMUST be either:\n- any valid [Specification ID](../index.md#specification-id), or\n- one of the pre-defined values listed below.")
  private String type;
  /**
   * [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) that describes the format of the definition.
   *
   * Media Types under `application/*` and `text/*` are allowed.
   * If no Media Type is registered for the referenced file,
   * `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
   * (Required)
   *
   */
  @JsonProperty("mediaType")
  @JsonPropertyDescription(
      "[Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) that describes the format of the definition.\n\nMedia Types under `application/*` and `text/*` are allowed.\nIf no Media Type is registered for the referenced file,\n`text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.")
  private String mediaType;
  /**
   * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.
   *
   * It is RECOMMENDED to provide a relative URL (to base URL).
   * (Required)
   *
   */
  @JsonProperty("url")
  @JsonPropertyDescription(
      "[URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.\n\nIt is RECOMMENDED to provide a relative URL (to base URL).")
  private String url;
  /**
   * List of supported access strategies for retrieving metadata from the ORD provider.
   * An ORD Consumer/ORD Aggregator MAY choose any of the strategies.
   *
   * The access strategies only apply to the metadata access and not the actual API access.
   * The actual access to the APIs for clients is described via Consumption Bundles.
   *
   * If this property is not provided, the definition URL will be available through the same access strategy as this ORD document.
   * It is RECOMMENDED anyway that the attached metadata definitions are available with the same access strategies, to simplify the aggregator crawling process.
   *
   */
  @JsonProperty("accessStrategies")
  @JsonPropertyDescription(
      "List of supported access strategies for retrieving metadata from the ORD provider.\nAn ORD Consumer/ORD Aggregator MAY choose any of the strategies.\n\nThe access strategies only apply to the metadata access and not the actual API access.\nThe actual access to the APIs for clients is described via Consumption Bundles.\n\nIf this property is not provided, the definition URL will be available through the same access strategy as this ORD document.\nIt is RECOMMENDED anyway that the attached metadata definitions are available with the same access strategies, to simplify the aggregator crawling process.")
  private List<AccessStrategy> accessStrategies;
  /**
   * Who is allowed to access the entity type definition. Defaults to `private`.
   *
   * Entity Type definitions are internal implementation details and SHOULD remain `private` by default.
   * Consumers interact with the data through related API Resources, not the internal model directly.
   *
   * The visibility MUST be equal to or more restrictive than the Entity Type resource's visibility.
   *
   * Only use `public` visibility when the internal model definition itself needs open access for standardization or documentation purposes.
   * (Required)
   *
   */
  @JsonProperty("visibility")
  @JsonPropertyDescription(
      "Who is allowed to access the entity type definition. Defaults to `private`.\n\nEntity Type definitions are internal implementation details and SHOULD remain `private` by default.\nConsumers interact with the data through related API Resources, not the internal model directly.\n\nThe visibility MUST be equal to or more restrictive than the Entity Type resource's visibility.\n\nOnly use `public` visibility when the internal model definition itself needs open access for standardization or documentation purposes.")
  private String visibility = "private";

  /**
   * Type of the entity type resource definition.
   *
   * MUST be either:
   * - any valid [Specification ID](../index.md#specification-id), or
   * - one of the pre-defined values listed below.
   * (Required)
   *
   */
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  /**
   * Type of the entity type resource definition.
   *
   * MUST be either:
   * - any valid [Specification ID](../index.md#specification-id), or
   * - one of the pre-defined values listed below.
   * (Required)
   *
   */
  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  public EntityTypeDefinition withType(String type) {
    this.type = type;
    return this;
  }

  /**
   * [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) that describes the format of the definition.
   *
   * Media Types under `application/*` and `text/*` are allowed.
   * If no Media Type is registered for the referenced file,
   * `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
   * (Required)
   *
   */
  @JsonProperty("mediaType")
  public String getMediaType() {
    return mediaType;
  }

  /**
   * [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) that describes the format of the definition.
   *
   * Media Types under `application/*` and `text/*` are allowed.
   * If no Media Type is registered for the referenced file,
   * `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
   * (Required)
   *
   */
  @JsonProperty("mediaType")
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public EntityTypeDefinition withMediaType(String mediaType) {
    this.mediaType = mediaType;
    return this;
  }

  /**
   * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.
   *
   * It is RECOMMENDED to provide a relative URL (to base URL).
   * (Required)
   *
   */
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  /**
   * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.
   *
   * It is RECOMMENDED to provide a relative URL (to base URL).
   * (Required)
   *
   */
  @JsonProperty("url")
  public void setUrl(String url) {
    this.url = url;
  }

  public EntityTypeDefinition withUrl(String url) {
    this.url = url;
    return this;
  }

  /**
   * List of supported access strategies for retrieving metadata from the ORD provider.
   * An ORD Consumer/ORD Aggregator MAY choose any of the strategies.
   *
   * The access strategies only apply to the metadata access and not the actual API access.
   * The actual access to the APIs for clients is described via Consumption Bundles.
   *
   * If this property is not provided, the definition URL will be available through the same access strategy as this ORD document.
   * It is RECOMMENDED anyway that the attached metadata definitions are available with the same access strategies, to simplify the aggregator crawling process.
   *
   */
  @JsonProperty("accessStrategies")
  public List<AccessStrategy> getAccessStrategies() {
    return accessStrategies;
  }

  /**
   * List of supported access strategies for retrieving metadata from the ORD provider.
   * An ORD Consumer/ORD Aggregator MAY choose any of the strategies.
   *
   * The access strategies only apply to the metadata access and not the actual API access.
   * The actual access to the APIs for clients is described via Consumption Bundles.
   *
   * If this property is not provided, the definition URL will be available through the same access strategy as this ORD document.
   * It is RECOMMENDED anyway that the attached metadata definitions are available with the same access strategies, to simplify the aggregator crawling process.
   *
   */
  @JsonProperty("accessStrategies")
  public void setAccessStrategies(List<AccessStrategy> accessStrategies) {
    this.accessStrategies = accessStrategies;
  }

  public EntityTypeDefinition withAccessStrategies(List<AccessStrategy> accessStrategies) {
    this.accessStrategies = accessStrategies;
    return this;
  }

  /**
   * Who is allowed to access the entity type definition. Defaults to `private`.
   *
   * Entity Type definitions are internal implementation details and SHOULD remain `private` by default.
   * Consumers interact with the data through related API Resources, not the internal model directly.
   *
   * The visibility MUST be equal to or more restrictive than the Entity Type resource's visibility.
   *
   * Only use `public` visibility when the internal model definition itself needs open access for standardization or documentation purposes.
   * (Required)
   *
   */
  @JsonProperty("visibility")
  public String getVisibility() {
    return visibility;
  }

  /**
   * Who is allowed to access the entity type definition. Defaults to `private`.
   *
   * Entity Type definitions are internal implementation details and SHOULD remain `private` by default.
   * Consumers interact with the data through related API Resources, not the internal model directly.
   *
   * The visibility MUST be equal to or more restrictive than the Entity Type resource's visibility.
   *
   * Only use `public` visibility when the internal model definition itself needs open access for standardization or documentation purposes.
   * (Required)
   *
   */
  @JsonProperty("visibility")
  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  public EntityTypeDefinition withVisibility(String visibility) {
    this.visibility = visibility;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(EntityTypeDefinition.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("type");
    sb.append('=');
    sb.append(((this.type == null) ? "<null>" : this.type));
    sb.append(',');
    sb.append("mediaType");
    sb.append('=');
    sb.append(((this.mediaType == null) ? "<null>" : this.mediaType));
    sb.append(',');
    sb.append("url");
    sb.append('=');
    sb.append(((this.url == null) ? "<null>" : this.url));
    sb.append(',');
    sb.append("accessStrategies");
    sb.append('=');
    sb.append(((this.accessStrategies == null) ? "<null>" : this.accessStrategies));
    sb.append(',');
    sb.append("visibility");
    sb.append('=');
    sb.append(((this.visibility == null) ? "<null>" : this.visibility));
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
    result = ((result * 31) + ((this.accessStrategies == null) ? 0 : this.accessStrategies.hashCode()));
    result = ((result * 31) + ((this.mediaType == null) ? 0 : this.mediaType.hashCode()));
    result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
    result = ((result * 31) + ((this.visibility == null) ? 0 : this.visibility.hashCode()));
    result = ((result * 31) + ((this.url == null) ? 0 : this.url.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof EntityTypeDefinition) == false) {
      return false;
    }
    EntityTypeDefinition rhs = ((EntityTypeDefinition) other);
    return ((((((this.accessStrategies == rhs.accessStrategies)
                        || ((this.accessStrategies != null)
                            && this.accessStrategies.equals(rhs.accessStrategies)))
                    && ((this.mediaType == rhs.mediaType)
                        || ((this.mediaType != null) && this.mediaType.equals(rhs.mediaType))))
                && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
            && ((this.visibility == rhs.visibility)
                || ((this.visibility != null) && this.visibility.equals(rhs.visibility))))
        && ((this.url == rhs.url) || ((this.url != null) && this.url.equals(rhs.url))));
  }
}
