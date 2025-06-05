
package com.sap.ord.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Data Product Link
 * <p>
 * Links with specific semantic meaning that are related to Data Product resources.
 * If a generic [Link](#link) can also be expressed via Data Product Link, the latter MUST be chosen.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "customType",
    "url"
})
public class DataProductLink {

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
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the Data Product Link.
     * 
     * The link target SHOULD be absolute and SHOULD be openly accessible.
     * If a relative link is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).
     * (Required)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("[URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the Data Product Link.\n\nThe link target SHOULD be absolute and SHOULD be openly accessible.\nIf a relative link is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).")
    private String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataProductLink() {
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
     *     [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the Data Product Link.
     *     
     *     The link target SHOULD be absolute and SHOULD be openly accessible.
     *     If a relative link is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).
     */
    public DataProductLink(String type, String customType, String url) {
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

    public DataProductLink withType(String type) {
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

    public DataProductLink withCustomType(String customType) {
        this.customType = customType;
        return this;
    }

    /**
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the Data Product Link.
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
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the Data Product Link.
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

    public DataProductLink withUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DataProductLink.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof DataProductLink) == false) {
            return false;
        }
        DataProductLink rhs = ((DataProductLink) other);
        return ((((this.customType == rhs.customType)||((this.customType!= null)&&this.customType.equals(rhs.customType)))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
