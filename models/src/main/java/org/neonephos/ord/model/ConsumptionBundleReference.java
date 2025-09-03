
package org.neonephos.ord.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Consumption Bundle Reference
 * <p>
 * Reference to a Consumption bundle.
 * 
 * This is a complex object to allow additional properties / selections to be attached.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId",
    "defaultEntryPoint"
})
@Generated("jsonschema2pojo")
public class ConsumptionBundleReference implements org.neonephos.ord.service.hooks.PartialOrdPojo {

    /**
     * The consumption bundle ORD ID (`ConsumptionBundle.ordId`) this reference points to.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    @JsonPropertyDescription("The consumption bundle ORD ID (`ConsumptionBundle.ordId`) this reference points to.")
    private String ordId;
    /**
     * In case that an API Resource has multiple entry points, this will indicate which entry point should be used by default
     * when discovering this resource from the context of the referenced Consumption Bundle.
     * 
     * MUST NOT be provided for Event Resources, as they don't have entry points.
     * MUST only be provided if the resource has more than one entry point.
     * MUST be in the list of `entryPoints` of the affected resource.
     * 
     */
    @JsonProperty("defaultEntryPoint")
    @JsonPropertyDescription("In case that an API Resource has multiple entry points, this will indicate which entry point should be used by default\nwhen discovering this resource from the context of the referenced Consumption Bundle.\n\nMUST NOT be provided for Event Resources, as they don't have entry points.\nMUST only be provided if the resource has more than one entry point.\nMUST be in the list of `entryPoints` of the affected resource.")
    private String defaultEntryPoint;

    /**
     * The consumption bundle ORD ID (`ConsumptionBundle.ordId`) this reference points to.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public String getOrdId() {
        return ordId;
    }

    /**
     * The consumption bundle ORD ID (`ConsumptionBundle.ordId`) this reference points to.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public ConsumptionBundleReference withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    /**
     * In case that an API Resource has multiple entry points, this will indicate which entry point should be used by default
     * when discovering this resource from the context of the referenced Consumption Bundle.
     * 
     * MUST NOT be provided for Event Resources, as they don't have entry points.
     * MUST only be provided if the resource has more than one entry point.
     * MUST be in the list of `entryPoints` of the affected resource.
     * 
     */
    @JsonProperty("defaultEntryPoint")
    public String getDefaultEntryPoint() {
        return defaultEntryPoint;
    }

    /**
     * In case that an API Resource has multiple entry points, this will indicate which entry point should be used by default
     * when discovering this resource from the context of the referenced Consumption Bundle.
     * 
     * MUST NOT be provided for Event Resources, as they don't have entry points.
     * MUST only be provided if the resource has more than one entry point.
     * MUST be in the list of `entryPoints` of the affected resource.
     * 
     */
    @JsonProperty("defaultEntryPoint")
    public void setDefaultEntryPoint(String defaultEntryPoint) {
        this.defaultEntryPoint = defaultEntryPoint;
    }

    public ConsumptionBundleReference withDefaultEntryPoint(String defaultEntryPoint) {
        this.defaultEntryPoint = defaultEntryPoint;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ConsumptionBundleReference.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ordId");
        sb.append('=');
        sb.append(((this.ordId == null)?"<null>":this.ordId));
        sb.append(',');
        sb.append("defaultEntryPoint");
        sb.append('=');
        sb.append(((this.defaultEntryPoint == null)?"<null>":this.defaultEntryPoint));
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
        result = ((result* 31)+((this.defaultEntryPoint == null)? 0 :this.defaultEntryPoint.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ConsumptionBundleReference) == false) {
            return false;
        }
        ConsumptionBundleReference rhs = ((ConsumptionBundleReference) other);
        return (((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId)))&&((this.defaultEntryPoint == rhs.defaultEntryPoint)||((this.defaultEntryPoint!= null)&&this.defaultEntryPoint.equals(rhs.defaultEntryPoint))));
    }

}
