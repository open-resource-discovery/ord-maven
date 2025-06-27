
package com.sap.ord.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Group Type
 * <p>
 * A Group Type defines the semantics of [group assignments](#group).
 * What the Group Type means and how it is to be used correctly SHOULD be described in the `description` (which may include markdown links).
 * 
 * Group Types can be defined centrally (ownership by authority namespace) or decentrally (defined by application / service itself).
 * 
 * To learn more about the concept, see [Group Concept Documentation](../concepts/grouping-and-bundling#Groups).
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groupTypeId",
    "title",
    "description"
})
public class GroupType implements com.sap.ord.service.hooks.PartialOrdPojo {

    /**
     * GroupType ID, which MUST be a valid [Concept ID](../../spec-v1/#concept-id).
     * (Required)
     * 
     */
    @JsonProperty("groupTypeId")
    @JsonPropertyDescription("GroupType ID, which MUST be a valid [Concept ID](../../spec-v1/#concept-id).")
    private String groupTypeId;
    /**
     * Human readable title of the group type.
     * (Required)
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("Human readable title of the group type.")
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

    /**
     * No args constructor for use in serialization
     * 
     */
    public GroupType() {
    }

    /**
     * 
     * @param groupTypeId
     *     GroupType ID, which MUST be a valid [Concept ID](../../spec-v1/#concept-id).
     * @param description
     *     Full description, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     *     
     *     The description SHOULD not be excessive in length and is not meant to provide full documentation.
     *     Detailed documentation SHOULD be attached as (typed) links.
     * @param title
     *     Human readable title of the group type.
     */
    public GroupType(String groupTypeId, String title, String description) {
        super();
        this.groupTypeId = groupTypeId;
        this.title = title;
        this.description = description;
    }

    /**
     * GroupType ID, which MUST be a valid [Concept ID](../../spec-v1/#concept-id).
     * (Required)
     * 
     */
    @JsonProperty("groupTypeId")
    public String getGroupTypeId() {
        return groupTypeId;
    }

    /**
     * GroupType ID, which MUST be a valid [Concept ID](../../spec-v1/#concept-id).
     * (Required)
     * 
     */
    @JsonProperty("groupTypeId")
    public void setGroupTypeId(String groupTypeId) {
        this.groupTypeId = groupTypeId;
    }

    public GroupType withGroupTypeId(String groupTypeId) {
        this.groupTypeId = groupTypeId;
        return this;
    }

    /**
     * Human readable title of the group type.
     * (Required)
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Human readable title of the group type.
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public GroupType withTitle(String title) {
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

    public GroupType withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GroupType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GroupType) == false) {
            return false;
        }
        GroupType rhs = ((GroupType) other);
        return ((((this.groupTypeId == rhs.groupTypeId)||((this.groupTypeId!= null)&&this.groupTypeId.equals(rhs.groupTypeId)))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))));
    }

}
