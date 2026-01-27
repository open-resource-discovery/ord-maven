
package org.openresourcediscovery.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Exposed API Resource
 * <p>
 * Reference to an API Resource that exposes the functionality of an agent.
 * 
 * This is a complex object to allow additional properties / selections to be attached in the future.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId"
})
@Generated("jsonschema2pojo")
public class ExposedApiResourcesTarget {

    /**
     * The API Resource ORD ID that this reference points to.
     * 
     * MUST be a valid reference to an [API Resource](#api-resource) ORD ID.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    @JsonPropertyDescription("The API Resource ORD ID that this reference points to.\n\nMUST be a valid reference to an [API Resource](#api-resource) ORD ID.")
    private String ordId;

    /**
     * The API Resource ORD ID that this reference points to.
     * 
     * MUST be a valid reference to an [API Resource](#api-resource) ORD ID.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public String getOrdId() {
        return ordId;
    }

    /**
     * The API Resource ORD ID that this reference points to.
     * 
     * MUST be a valid reference to an [API Resource](#api-resource) ORD ID.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public ExposedApiResourcesTarget withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ExposedApiResourcesTarget.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ordId");
        sb.append('=');
        sb.append(((this.ordId == null)?"<null>":this.ordId));
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
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExposedApiResourcesTarget) == false) {
            return false;
        }
        ExposedApiResourcesTarget rhs = ((ExposedApiResourcesTarget) other);
        return ((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId)));
    }

}
