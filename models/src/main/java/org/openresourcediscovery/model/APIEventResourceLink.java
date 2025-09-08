
package org.openresourcediscovery.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * API and Event Resource Link
 * <p>
 * Links with specific semantic meaning that are related to API or event resources.
 * 
 * If a generic [Link](#link) can also be expressed via an API / Event Resource Link, the latter MUST be chosen.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "customType",
    "url"
})
@Generated("jsonschema2pojo")
public class APIEventResourceLink implements org.openresourcediscovery.service.hooks.PartialOrdPojo {

    /**
     * See also: [WADG0001 WebAPI type extension](https://webapi-discovery.github.io/rfcs/rfc0001.html#webapiactions)
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("See also: [WADG0001 WebAPI type extension](https://webapi-discovery.github.io/rfcs/rfc0001.html#webapiactions)")
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
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the API or Event Resource Link.
     * 
     * The link target SHOULD be absolute and SHOULD be openly accessible.
     * If a relative link is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).
     * (Required)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("[URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the API or Event Resource Link.\n\nThe link target SHOULD be absolute and SHOULD be openly accessible.\nIf a relative link is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).")
    private String url;

    /**
     * See also: [WADG0001 WebAPI type extension](https://webapi-discovery.github.io/rfcs/rfc0001.html#webapiactions)
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * See also: [WADG0001 WebAPI type extension](https://webapi-discovery.github.io/rfcs/rfc0001.html#webapiactions)
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public APIEventResourceLink withType(String type) {
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

    public APIEventResourceLink withCustomType(String customType) {
        this.customType = customType;
        return this;
    }

    /**
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the API or Event Resource Link.
     * 
     * The link target SHOULD be absolute and SHOULD be openly accessible.
     * If a relative link is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).
     * (Required)
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the API or Event Resource Link.
     * 
     * The link target SHOULD be absolute and SHOULD be openly accessible.
     * If a relative link is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).
     * (Required)
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public APIEventResourceLink withUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(APIEventResourceLink.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.customType == null)? 0 :this.customType.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof APIEventResourceLink) == false) {
            return false;
        }
        APIEventResourceLink rhs = ((APIEventResourceLink) other);
        return ((((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type)))&&((this.customType == rhs.customType)||((this.customType!= null)&&this.customType.equals(rhs.customType))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
