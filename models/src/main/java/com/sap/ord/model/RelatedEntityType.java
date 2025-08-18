
package com.sap.ord.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Related Entity Type
 * <p>
 * Defines the relation between Entity Types (via its ORD ID).
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId",
    "relationType"
})
@Generated("jsonschema2pojo")
public class RelatedEntityType implements com.sap.ord.service.hooks.PartialOrdPojo {

    /**
     * The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.
     * 
     * It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    @JsonPropertyDescription("The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.\n\nIt MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.")
    private String ordId;
    /**
     * Optional type of the relationship, which defines a stricter semantic what the relationship implies.
     * 
     * If not provided, the relationship type has no semantics, it's "related somehow".
     * 
     */
    @JsonProperty("relationType")
    @JsonPropertyDescription("Optional type of the relationship, which defines a stricter semantic what the relationship implies.\n\nIf not provided, the relationship type has no semantics, it's \"related somehow\".")
    private String relationType;

    /**
     * The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.
     * 
     * It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public String getOrdId() {
        return ordId;
    }

    /**
     * The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.
     * 
     * It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public RelatedEntityType withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    /**
     * Optional type of the relationship, which defines a stricter semantic what the relationship implies.
     * 
     * If not provided, the relationship type has no semantics, it's "related somehow".
     * 
     */
    @JsonProperty("relationType")
    public String getRelationType() {
        return relationType;
    }

    /**
     * Optional type of the relationship, which defines a stricter semantic what the relationship implies.
     * 
     * If not provided, the relationship type has no semantics, it's "related somehow".
     * 
     */
    @JsonProperty("relationType")
    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public RelatedEntityType withRelationType(String relationType) {
        this.relationType = relationType;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RelatedEntityType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ordId");
        sb.append('=');
        sb.append(((this.ordId == null)?"<null>":this.ordId));
        sb.append(',');
        sb.append("relationType");
        sb.append('=');
        sb.append(((this.relationType == null)?"<null>":this.relationType));
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
        result = ((result* 31)+((this.relationType == null)? 0 :this.relationType.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RelatedEntityType) == false) {
            return false;
        }
        RelatedEntityType rhs = ((RelatedEntityType) other);
        return (((this.relationType == rhs.relationType)||((this.relationType!= null)&&this.relationType.equals(rhs.relationType)))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))));
    }

}
