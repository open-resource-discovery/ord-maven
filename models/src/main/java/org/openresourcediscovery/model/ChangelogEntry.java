
package org.openresourcediscovery.model;

import java.net.URI;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Changelog Entry
 * <p>
 * A changelog entry can be used to indicate changes.
 * Usually they lead to a change of the version number or the release status.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "version",
    "releaseStatus",
    "date",
    "description",
    "url"
})
@Generated("jsonschema2pojo")
public class ChangelogEntry implements org.openresourcediscovery.service.hooks.PartialOrdPojo {

    /**
     * Full version number that corresponds to the `version` that is described by the changelog entry.
     * 
     * Ideally it follows the [Semantic Versioning 2.0.0](https://semver.org/) standard,
     * but since it should reflect the actual version string / scheme used, this is not a mandatory requirement.
     * (Required)
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("Full version number that corresponds to the `version` that is described by the changelog entry.\n\nIdeally it follows the [Semantic Versioning 2.0.0](https://semver.org/) standard,\nbut since it should reflect the actual version string / scheme used, this is not a mandatory requirement.")
    private String version;
    /**
     * The `releaseStatus` specifies the stability of the resource and its external contract.
     * (Required)
     * 
     */
    @JsonProperty("releaseStatus")
    @JsonPropertyDescription("The `releaseStatus` specifies the stability of the resource and its external contract.")
    private String releaseStatus;
    /**
     * Date of change, without time or timezone information.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * (Required)
     * 
     */
    @JsonProperty("date")
    @JsonPropertyDescription("Date of change, without time or timezone information.\n\nThe date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).")
    private String date;
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
     * Optional [URL](https://tools.ietf.org/html/rfc3986) that links to a more detailed changelog entry.
     * 
     * The link target MUST be absolute and SHOULD be openly accessible.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("Optional [URL](https://tools.ietf.org/html/rfc3986) that links to a more detailed changelog entry.\n\nThe link target MUST be absolute and SHOULD be openly accessible.")
    private URI url;

    /**
     * Full version number that corresponds to the `version` that is described by the changelog entry.
     * 
     * Ideally it follows the [Semantic Versioning 2.0.0](https://semver.org/) standard,
     * but since it should reflect the actual version string / scheme used, this is not a mandatory requirement.
     * (Required)
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Full version number that corresponds to the `version` that is described by the changelog entry.
     * 
     * Ideally it follows the [Semantic Versioning 2.0.0](https://semver.org/) standard,
     * but since it should reflect the actual version string / scheme used, this is not a mandatory requirement.
     * (Required)
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public ChangelogEntry withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * The `releaseStatus` specifies the stability of the resource and its external contract.
     * (Required)
     * 
     */
    @JsonProperty("releaseStatus")
    public String getReleaseStatus() {
        return releaseStatus;
    }

    /**
     * The `releaseStatus` specifies the stability of the resource and its external contract.
     * (Required)
     * 
     */
    @JsonProperty("releaseStatus")
    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public ChangelogEntry withReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
        return this;
    }

    /**
     * Date of change, without time or timezone information.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * (Required)
     * 
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * Date of change, without time or timezone information.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * (Required)
     * 
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public ChangelogEntry withDate(String date) {
        this.date = date;
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

    public ChangelogEntry withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Optional [URL](https://tools.ietf.org/html/rfc3986) that links to a more detailed changelog entry.
     * 
     * The link target MUST be absolute and SHOULD be openly accessible.
     * 
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * Optional [URL](https://tools.ietf.org/html/rfc3986) that links to a more detailed changelog entry.
     * 
     * The link target MUST be absolute and SHOULD be openly accessible.
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    public ChangelogEntry withUrl(URI url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChangelogEntry.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("releaseStatus");
        sb.append('=');
        sb.append(((this.releaseStatus == null)?"<null>":this.releaseStatus));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
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
        result = ((result* 31)+((this.releaseStatus == null)? 0 :this.releaseStatus.hashCode()));
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChangelogEntry) == false) {
            return false;
        }
        ChangelogEntry rhs = ((ChangelogEntry) other);
        return ((((((this.releaseStatus == rhs.releaseStatus)||((this.releaseStatus!= null)&&this.releaseStatus.equals(rhs.releaseStatus)))&&((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
