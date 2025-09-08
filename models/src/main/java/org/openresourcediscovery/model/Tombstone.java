
package org.openresourcediscovery.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Tombstone
 * <p>
 * A tombstone indicates that a previously published ORD resource or taxonomy has been removed / decommissioned / archived.
 * This MUST be indicated explicitly, so ORD aggregators and consumers can learn about the removal.
 * 
 * Exactly one of the IDs MUST be provided to state which ORD resource or taxonomy item the Tombstone addresses.
 * 
 * The tombstone MUST be kept sufficiently long (at least 31 days) so that all ORD aggregators can learn about the tombstone.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId",
    "groupId",
    "groupTypeId",
    "removalDate",
    "description"
})
@Generated("jsonschema2pojo")
public class Tombstone implements org.openresourcediscovery.service.hooks.PartialOrdPojo {

    /**
     * [ORD ID](../index.md#ord-id) of the ORD resource/taxonomy that has been removed.
     * 
     */
    @JsonProperty("ordId")
    @JsonPropertyDescription("[ORD ID](../index.md#ord-id) of the ORD resource/taxonomy that has been removed.")
    private String ordId;
    /**
     * Group ID of the group that has been removed.
     * 
     */
    @JsonProperty("groupId")
    @JsonPropertyDescription("Group ID of the group that has been removed.")
    private String groupId;
    /**
     * Group Type ID of the group type that has been removed.
     * 
     */
    @JsonProperty("groupTypeId")
    @JsonPropertyDescription("Group Type ID of the group type that has been removed.")
    private String groupTypeId;
    /**
     * The date when the ORD resource/taxonomy was removed.
     * This is related to the `sunsetDate` that can be set to announce a resource as deprecated *before* the removal and setting of a tombstone.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * (Required)
     * 
     */
    @JsonProperty("removalDate")
    @JsonPropertyDescription("The date when the ORD resource/taxonomy was removed.\nThis is related to the `sunsetDate` that can be set to announce a resource as deprecated *before* the removal and setting of a tombstone.\n\nThe date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).")
    private Date removalDate;
    /**
     * Optional description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description of a Tombstone MAY be added to the changelog of the removed resource by an ORD aggregator.
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Optional description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nThe description of a Tombstone MAY be added to the changelog of the removed resource by an ORD aggregator.")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * [ORD ID](../index.md#ord-id) of the ORD resource/taxonomy that has been removed.
     * 
     */
    @JsonProperty("ordId")
    public String getOrdId() {
        return ordId;
    }

    /**
     * [ORD ID](../index.md#ord-id) of the ORD resource/taxonomy that has been removed.
     * 
     */
    @JsonProperty("ordId")
    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public Tombstone withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    /**
     * Group ID of the group that has been removed.
     * 
     */
    @JsonProperty("groupId")
    public String getGroupId() {
        return groupId;
    }

    /**
     * Group ID of the group that has been removed.
     * 
     */
    @JsonProperty("groupId")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Tombstone withGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    /**
     * Group Type ID of the group type that has been removed.
     * 
     */
    @JsonProperty("groupTypeId")
    public String getGroupTypeId() {
        return groupTypeId;
    }

    /**
     * Group Type ID of the group type that has been removed.
     * 
     */
    @JsonProperty("groupTypeId")
    public void setGroupTypeId(String groupTypeId) {
        this.groupTypeId = groupTypeId;
    }

    public Tombstone withGroupTypeId(String groupTypeId) {
        this.groupTypeId = groupTypeId;
        return this;
    }

    /**
     * The date when the ORD resource/taxonomy was removed.
     * This is related to the `sunsetDate` that can be set to announce a resource as deprecated *before* the removal and setting of a tombstone.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * (Required)
     * 
     */
    @JsonProperty("removalDate")
    public Date getRemovalDate() {
        return removalDate;
    }

    /**
     * The date when the ORD resource/taxonomy was removed.
     * This is related to the `sunsetDate` that can be set to announce a resource as deprecated *before* the removal and setting of a tombstone.
     * 
     * The date format MUST comply with [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
     * (Required)
     * 
     */
    @JsonProperty("removalDate")
    public void setRemovalDate(Date removalDate) {
        this.removalDate = removalDate;
    }

    public Tombstone withRemovalDate(Date removalDate) {
        this.removalDate = removalDate;
        return this;
    }

    /**
     * Optional description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description of a Tombstone MAY be added to the changelog of the removed resource by an ORD aggregator.
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Optional description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * The description of a Tombstone MAY be added to the changelog of the removed resource by an ORD aggregator.
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Tombstone withDescription(String description) {
        this.description = description;
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

    public Tombstone withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Tombstone.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ordId");
        sb.append('=');
        sb.append(((this.ordId == null)?"<null>":this.ordId));
        sb.append(',');
        sb.append("groupId");
        sb.append('=');
        sb.append(((this.groupId == null)?"<null>":this.groupId));
        sb.append(',');
        sb.append("groupTypeId");
        sb.append('=');
        sb.append(((this.groupTypeId == null)?"<null>":this.groupTypeId));
        sb.append(',');
        sb.append("removalDate");
        sb.append('=');
        sb.append(((this.removalDate == null)?"<null>":this.removalDate));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
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
        result = ((result* 31)+((this.groupTypeId == null)? 0 :this.groupTypeId.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.removalDate == null)? 0 :this.removalDate.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        result = ((result* 31)+((this.groupId == null)? 0 :this.groupId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tombstone) == false) {
            return false;
        }
        Tombstone rhs = ((Tombstone) other);
        return (((((((this.groupTypeId == rhs.groupTypeId)||((this.groupTypeId!= null)&&this.groupTypeId.equals(rhs.groupTypeId)))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.removalDate == rhs.removalDate)||((this.removalDate!= null)&&this.removalDate.equals(rhs.removalDate))))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.groupId == rhs.groupId)||((this.groupId!= null)&&this.groupId.equals(rhs.groupId))));
    }

}
