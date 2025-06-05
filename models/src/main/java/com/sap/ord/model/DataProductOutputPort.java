
package com.sap.ord.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Data Product Output Port
 * <p>
 * A data product output port references the APIs or Events that can be used to access the data-set.
 * It MAY provide full access to the complete data set, but can also just expose a subset of it - if other output ports cover the missing parts.
 * 
 * Referenced API or Event ORD resources don't need to be provided within the same ORD document.
 * If a data product is built against a specific API contract of another application or data product, this API resource should be referred to.
 * In this case the other application is responsible for the lifecycle of the API contract and will update its ORD description independently.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId"
})
public class DataProductOutputPort {

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
     * No args constructor for use in serialization
     * 
     */
    public DataProductOutputPort() {
    }

    /**
     * 
     * @param ordId
     *     The ORD ID is a stable, globally unique ID for ORD resources or taxonomy.
     *     
     *     It MUST be a valid [ORD ID](../index.md#ord-id) of the appropriate ORD type.
     */
    public DataProductOutputPort(String ordId) {
        super();
        this.ordId = ordId;
    }

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

    public DataProductOutputPort withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DataProductOutputPort.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof DataProductOutputPort) == false) {
            return false;
        }
        DataProductOutputPort rhs = ((DataProductOutputPort) other);
        return ((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId)));
    }

}
