
package org.openresourcediscovery.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * File
 * <p>
 * File that can be attached on ORD package level.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "url",
    "description",
    "mediaType"
})
@Generated("jsonschema2pojo")
public class File {

    /**
     * Human readable title of the file.
     * 
     * MUST be unique within the collection of files provided.
     * (Required)
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("Human readable title of the file.\n\nMUST be unique within the collection of files provided.")
    private String title;
    /**
     * [URL](https://tools.ietf.org/html/rfc3986) of the link.
     * 
     * The file target MAY be relative or absolute.
     * If a relative URL is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).
     * If an absolute URL is given, then it MUST be openly accessible.
     * (Required)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("[URL](https://tools.ietf.org/html/rfc3986) of the link.\n\nThe file target MAY be relative or absolute.\nIf a relative URL is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).\nIf an absolute URL is given, then it MUST be openly accessible.")
    private String url;
    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description SHOULD not be excessive in length and is not meant to provide full documentation.
     * Detailed documentation SHOULD be attached as (typed) links.
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nThe description SHOULD not be excessive in length and is not meant to provide full documentation.\nDetailed documentation SHOULD be attached as (typed) links.")
    private String description;
    /**
     * The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format.
     * A consuming application can use this information to know which file format parser it needs to use.
     * 
     * If no Media Type is registered for the referenced file, `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
     * 
     * (Required)
     * 
     */
    @JsonProperty("mediaType")
    @JsonPropertyDescription("The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format.\nA consuming application can use this information to know which file format parser it needs to use.\n\nIf no Media Type is registered for the referenced file, `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.\n")
    private String mediaType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Human readable title of the file.
     * 
     * MUST be unique within the collection of files provided.
     * (Required)
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Human readable title of the file.
     * 
     * MUST be unique within the collection of files provided.
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public File withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * [URL](https://tools.ietf.org/html/rfc3986) of the link.
     * 
     * The file target MAY be relative or absolute.
     * If a relative URL is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).
     * If an absolute URL is given, then it MUST be openly accessible.
     * (Required)
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * [URL](https://tools.ietf.org/html/rfc3986) of the link.
     * 
     * The file target MAY be relative or absolute.
     * If a relative URL is given, it is relative to the [`describedSystemInstance.baseUrl`](#system-instance_baseurl).
     * If an absolute URL is given, then it MUST be openly accessible.
     * (Required)
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public File withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description SHOULD not be excessive in length and is not meant to provide full documentation.
     * Detailed documentation SHOULD be attached as (typed) links.
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description SHOULD not be excessive in length and is not meant to provide full documentation.
     * Detailed documentation SHOULD be attached as (typed) links.
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public File withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * The [Media Type](https://www.iana.org/assignments/media-types/media-types.xhtml) of the definition serialization format.
     * A consuming application can use this information to know which file format parser it needs to use.
     * 
     * If no Media Type is registered for the referenced file, `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
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
     * 
     * If no Media Type is registered for the referenced file, `text/plain` MAY be used for arbitrary plain-text and `application/octet-stream` for arbitrary binary data.
     * 
     * (Required)
     * 
     */
    @JsonProperty("mediaType")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public File withMediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public File withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(File.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("mediaType");
        sb.append('=');
        sb.append(((this.mediaType == null)?"<null>":this.mediaType));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
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
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.mediaType == null)? 0 :this.mediaType.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof File) == false) {
            return false;
        }
        File rhs = ((File) other);
        return ((((((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description)))&&((this.mediaType == rhs.mediaType)||((this.mediaType!= null)&&this.mediaType.equals(rhs.mediaType))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
