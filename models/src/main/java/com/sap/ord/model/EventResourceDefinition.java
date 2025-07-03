
package com.sap.ord.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Event Resource Definition
 * <p>
 * Link and categorization of a machine-readable API definition.
 * For example, AsyncAPI or OpenAPI with callbacks, etc.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "customType",
    "mediaType",
    "url",
    "accessStrategies"
})
public class EventResourceDefinition implements com.sap.ord.service.hooks.PartialOrdPojo {

    /**
     * Type of the event resource definition
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of the event resource definition")
    private String type;
    /**
     * If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customType")
    @JsonPropertyDescription("If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.\n\nMUST be a valid [Specification ID](../index.md#specification-id).\n\nMUST only be provided if `type` is set to `custom`.")
    private String customType;
    /**
     * The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format.
     * A consuming application can use this information to know which file format parser it needs to use.
     * For example, for OpenAPI 3, it's valid to express the same definition in both YAML and JSON.
     * 
     * If no Media Type is registered for the referenced file,
     * `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
     * 
     * (Required)
     * 
     */
    @JsonProperty("mediaType")
    @JsonPropertyDescription("The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format.\nA consuming application can use this information to know which file format parser it needs to use.\nFor example, for OpenAPI 3, it's valid to express the same definition in both YAML and JSON.\n\nIf no Media Type is registered for the referenced file,\n`text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.\n")
    private String mediaType;
    /**
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.
     * 
     * It is RECOMMENDED to provide a relative URL (to base URL).
     * (Required)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("[URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.\n\nIt is RECOMMENDED to provide a relative URL (to base URL).")
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
    @JsonPropertyDescription("List of supported access strategies for retrieving metadata from the ORD provider.\nAn ORD Consumer/ORD Aggregator MAY choose any of the strategies.\n\nThe access strategies only apply to the metadata access and not the actual API access.\nThe actual access to the APIs for clients is described via Consumption Bundles.\n\nIf this property is not provided, the definition URL will be available through the same access strategy as this ORD document.\nIt is RECOMMENDED anyway that the attached metadata definitions are available with the same access strategies, to simplify the aggregator crawling process.")
    private List<AccessStrategy> accessStrategies = new ArrayList<AccessStrategy>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EventResourceDefinition() {
    }

    /**
     * 
     * @param accessStrategies
     *     List of supported access strategies for retrieving metadata from the ORD provider.
     *     An ORD Consumer/ORD Aggregator MAY choose any of the strategies.
     *     
     *     The access strategies only apply to the metadata access and not the actual API access.
     *     The actual access to the APIs for clients is described via Consumption Bundles.
     *     
     *     If this property is not provided, the definition URL will be available through the same access strategy as this ORD document.
     *     It is RECOMMENDED anyway that the attached metadata definitions are available with the same access strategies, to simplify the aggregator crawling process.
     * @param customType
     *     If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     *     
     *     MUST be a valid [Specification ID](../index.md#specification-id).
     *     
     *     MUST only be provided if `type` is set to `custom`.
     * @param mediaType
     *     The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format.
     *     A consuming application can use this information to know which file format parser it needs to use.
     *     For example, for OpenAPI 3, it's valid to express the same definition in both YAML and JSON.
     *     
     *     If no Media Type is registered for the referenced file,
     *     `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
     *     .
     * @param type
     *     Type of the event resource definition.
     * @param url
     *     [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the resource definition file.
     *     
     *     It is RECOMMENDED to provide a relative URL (to base URL).
     */
    public EventResourceDefinition(String type, String customType, String mediaType, String url, List<AccessStrategy> accessStrategies) {
        super();
        this.type = type;
        this.customType = customType;
        this.mediaType = mediaType;
        this.url = url;
        this.accessStrategies = accessStrategies;
    }

    /**
     * Type of the event resource definition
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type of the event resource definition
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public EventResourceDefinition withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customType")
    public String getCustomType() {
        return customType;
    }

    /**
     * If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customType")
    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public EventResourceDefinition withCustomType(String customType) {
        this.customType = customType;
        return this;
    }

    /**
     * The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format.
     * A consuming application can use this information to know which file format parser it needs to use.
     * For example, for OpenAPI 3, it's valid to express the same definition in both YAML and JSON.
     * 
     * If no Media Type is registered for the referenced file,
     * `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
     * 
     * (Required)
     * 
     */
    @JsonProperty("mediaType")
    public String getMediaType() {
        return mediaType;
    }

    /**
     * The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format.
     * A consuming application can use this information to know which file format parser it needs to use.
     * For example, for OpenAPI 3, it's valid to express the same definition in both YAML and JSON.
     * 
     * If no Media Type is registered for the referenced file,
     * `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
     * 
     * (Required)
     * 
     */
    @JsonProperty("mediaType")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public EventResourceDefinition withMediaType(String mediaType) {
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

    public EventResourceDefinition withUrl(String url) {
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

    public EventResourceDefinition withAccessStrategies(List<AccessStrategy> accessStrategies) {
        this.accessStrategies = accessStrategies;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EventResourceDefinition.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("customType");
        sb.append('=');
        sb.append(((this.customType == null)?"<null>":this.customType));
        sb.append(',');
        sb.append("mediaType");
        sb.append('=');
        sb.append(((this.mediaType == null)?"<null>":this.mediaType));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("accessStrategies");
        sb.append('=');
        sb.append(((this.accessStrategies == null)?"<null>":this.accessStrategies));
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
        result = ((result* 31)+((this.accessStrategies == null)? 0 :this.accessStrategies.hashCode()));
        result = ((result* 31)+((this.customType == null)? 0 :this.customType.hashCode()));
        result = ((result* 31)+((this.mediaType == null)? 0 :this.mediaType.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventResourceDefinition) == false) {
            return false;
        }
        EventResourceDefinition rhs = ((EventResourceDefinition) other);
        return ((((((this.accessStrategies == rhs.accessStrategies)||((this.accessStrategies!= null)&&this.accessStrategies.equals(rhs.accessStrategies)))&&((this.customType == rhs.customType)||((this.customType!= null)&&this.customType.equals(rhs.customType))))&&((this.mediaType == rhs.mediaType)||((this.mediaType!= null)&&this.mediaType.equals(rhs.mediaType))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
