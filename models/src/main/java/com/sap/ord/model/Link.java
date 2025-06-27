
package com.sap.ord.model;

import java.net.URI;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Link
 * <p>
 * Link that can be attached to packages or Open Resource Discovery resources.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "url",
    "description"
})
public class Link implements com.sap.ord.service.hooks.PartialOrdPojo {

    /**
     * Human readable title of the link.
     * 
     * MUST be unique within the collection of links provided.
     * (Required)
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("Human readable title of the link.\n\nMUST be unique within the collection of links provided.")
    private String title;
    /**
     * [URL](https://tools.ietf.org/html/rfc3986) of the link.
     * 
     * The link target MUST be absolute and SHOULD be openly accessible.
     * (Required)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("[URL](https://tools.ietf.org/html/rfc3986) of the link.\n\nThe link target MUST be absolute and SHOULD be openly accessible.")
    private URI url;
    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown)
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown)")
    private String description;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Link() {
    }

    /**
     * 
     * @param description
     *     Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * @param title
     *     Human readable title of the link.
     *     
     *     MUST be unique within the collection of links provided.
     * @param url
     *     [URL](https://tools.ietf.org/html/rfc3986) of the link.
     *     
     *     The link target MUST be absolute and SHOULD be openly accessible.
     */
    public Link(String title, URI url, String description) {
        super();
        this.title = title;
        this.url = url;
        this.description = description;
    }

    /**
     * Human readable title of the link.
     * 
     * MUST be unique within the collection of links provided.
     * (Required)
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Human readable title of the link.
     * 
     * MUST be unique within the collection of links provided.
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Link withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * [URL](https://tools.ietf.org/html/rfc3986) of the link.
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
     * [URL](https://tools.ietf.org/html/rfc3986) of the link.
     * 
     * The link target MUST be absolute and SHOULD be openly accessible.
     * (Required)
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    public Link withUrl(URI url) {
        this.url = url;
        return this;
    }

    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown)
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown)
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Link withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Link.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Link) == false) {
            return false;
        }
        Link rhs = ((Link) other);
        return ((((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description)))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
