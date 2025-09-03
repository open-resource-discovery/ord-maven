
package org.neonephos.ord.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Data Product Input Port
 * <p>
 * An input port of a data product states where it retrieves its data inputs from.
 * 
 * It is described as via an ORD Integration Dependency.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId"
})
@Generated("jsonschema2pojo")
public class DataProductInputPort implements org.neonephos.ord.service.hooks.PartialOrdPojo {

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

    public DataProductInputPort withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DataProductInputPort.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof DataProductInputPort) == false) {
            return false;
        }
        DataProductInputPort rhs = ((DataProductInputPort) other);
        return ((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId)));
    }

}
