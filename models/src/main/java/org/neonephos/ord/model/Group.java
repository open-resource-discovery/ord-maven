
package org.neonephos.ord.model;

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
 * Group
 * <p>
 * Group (instance) that resources can be assigned to.
 * 
 * Groups are a lightweight custom taxonomy concept.
 * They express a "part of" relationship to the chosen group concept.
 * If an "identity / equals" relationship needs to be expressed, use the `correlationIds` instead.
 * 
 * To learn more about the concept, see [Group Concept Documentation](../concepts/grouping-and-bundling#Groups).
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groupId",
    "groupTypeId",
    "title",
    "description"
})
@Generated("jsonschema2pojo")
public class Group implements org.neonephos.ord.service.hooks.PartialOrdPojo {

    /**
     * The Group ID consists of two [Concept IDs](../../spec-v1/#concept-id) separated by a `:`.
     * 
     * The first two fragments MUST be equal to the used Group Type ID (`groupTypeId`).
     * The last two fragments MUST be a valid [Concept ID](../../spec-v1/#concept-id), indicating the group instance assignment.
     * 
     * The ID concept is a bit unusual, but it ensures globally unique and conflict free group assignments.
     * (Required)
     * 
     */
    @JsonProperty("groupId")
    @JsonPropertyDescription("The Group ID consists of two [Concept IDs](../../spec-v1/#concept-id) separated by a `:`.\n\nThe first two fragments MUST be equal to the used Group Type ID (`groupTypeId`).\nThe last two fragments MUST be a valid [Concept ID](../../spec-v1/#concept-id), indicating the group instance assignment.\n\nThe ID concept is a bit unusual, but it ensures globally unique and conflict free group assignments.")
    private String groupId;
    /**
     * Group Type ID.
     * 
     * MUST match with the first two fragments of the own `groupId`.
     * (Required)
     * 
     */
    @JsonProperty("groupTypeId")
    @JsonPropertyDescription("Group Type ID.\n\nMUST match with the first two fragments of the own `groupId`.")
    private String groupTypeId;
    /**
     * Human readable title of the group assignment (for UI).
     * (Required)
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("Human readable title of the group assignment (for UI).")
    private String title;
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * The Group ID consists of two [Concept IDs](../../spec-v1/#concept-id) separated by a `:`.
     * 
     * The first two fragments MUST be equal to the used Group Type ID (`groupTypeId`).
     * The last two fragments MUST be a valid [Concept ID](../../spec-v1/#concept-id), indicating the group instance assignment.
     * 
     * The ID concept is a bit unusual, but it ensures globally unique and conflict free group assignments.
     * (Required)
     * 
     */
    @JsonProperty("groupId")
    public String getGroupId() {
        return groupId;
    }

    /**
     * The Group ID consists of two [Concept IDs](../../spec-v1/#concept-id) separated by a `:`.
     * 
     * The first two fragments MUST be equal to the used Group Type ID (`groupTypeId`).
     * The last two fragments MUST be a valid [Concept ID](../../spec-v1/#concept-id), indicating the group instance assignment.
     * 
     * The ID concept is a bit unusual, but it ensures globally unique and conflict free group assignments.
     * (Required)
     * 
     */
    @JsonProperty("groupId")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Group withGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    /**
     * Group Type ID.
     * 
     * MUST match with the first two fragments of the own `groupId`.
     * (Required)
     * 
     */
    @JsonProperty("groupTypeId")
    public String getGroupTypeId() {
        return groupTypeId;
    }

    /**
     * Group Type ID.
     * 
     * MUST match with the first two fragments of the own `groupId`.
     * (Required)
     * 
     */
    @JsonProperty("groupTypeId")
    public void setGroupTypeId(String groupTypeId) {
        this.groupTypeId = groupTypeId;
    }

    public Group withGroupTypeId(String groupTypeId) {
        this.groupTypeId = groupTypeId;
        return this;
    }

    /**
     * Human readable title of the group assignment (for UI).
     * (Required)
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Human readable title of the group assignment (for UI).
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Group withTitle(String title) {
        this.title = title;
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

    public Group withDescription(String description) {
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

    public Group withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Group.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("groupId");
        sb.append('=');
        sb.append(((this.groupId == null)?"<null>":this.groupId));
        sb.append(',');
        sb.append("groupTypeId");
        sb.append('=');
        sb.append(((this.groupTypeId == null)?"<null>":this.groupTypeId));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
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
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.groupId == null)? 0 :this.groupId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Group) == false) {
            return false;
        }
        Group rhs = ((Group) other);
        return ((((((this.groupTypeId == rhs.groupTypeId)||((this.groupTypeId!= null)&&this.groupTypeId.equals(rhs.groupTypeId)))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.groupId == rhs.groupId)||((this.groupId!= null)&&this.groupId.equals(rhs.groupId))));
    }

}
