
package com.sap.ord.model;

import java.net.URI;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Package Link
 * <p>
 * Links with specific semantic meaning that are related to `Package`.
 * 
 * If a generic [Link](#link) can also be expressed via a Package Link, the latter MUST be chosen.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "customType",
    "url"
})
public class PackageLink {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
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
     * [URL](https://tools.ietf.org/html/rfc3986) to the PackageLink.
     * 
     * The link target MUST be absolute and SHOULD be openly accessible.
     * (Required)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("[URL](https://tools.ietf.org/html/rfc3986) to the PackageLink.\n\nThe link target MUST be absolute and SHOULD be openly accessible.")
    private URI url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PackageLink() {
    }

    /**
     * 
     * @param customType
     *     If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     *     
     *     MUST be a valid [Specification ID](../index.md#specification-id).
     *     
     *     MUST only be provided if `type` is set to `custom`.
     * @param url
     *     [URL](https://tools.ietf.org/html/rfc3986) to the PackageLink.
     *     
     *     The link target MUST be absolute and SHOULD be openly accessible.
     */
    public PackageLink(String type, String customType, URI url) {
        super();
        this.type = type;
        this.customType = customType;
        this.url = url;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public PackageLink withType(String type) {
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

    public PackageLink withCustomType(String customType) {
        this.customType = customType;
        return this;
    }

    /**
     * [URL](https://tools.ietf.org/html/rfc3986) to the PackageLink.
     * 
     * The link target MUST be absolute and SHOULD be openly accessible.
     * (Required)
     * 
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * [URL](https://tools.ietf.org/html/rfc3986) to the PackageLink.
     * 
     * The link target MUST be absolute and SHOULD be openly accessible.
     * (Required)
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    public PackageLink withUrl(URI url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PackageLink.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("customType");
        sb.append('=');
        sb.append(((this.customType == null)?"<null>":this.customType));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
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
        result = ((result* 31)+((this.customType == null)? 0 :this.customType.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PackageLink) == false) {
            return false;
        }
        PackageLink rhs = ((PackageLink) other);
        return ((((this.customType == rhs.customType)||((this.customType!= null)&&this.customType.equals(rhs.customType)))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
