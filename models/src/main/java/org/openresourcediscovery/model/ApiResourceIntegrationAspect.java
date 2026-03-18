
package org.openresourcediscovery.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Api Resource Integration Aspect
 * <p>
 * API resource related integration aspect
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId",
    "minVersion",
    "subset"
})
@Generated("jsonschema2pojo")
public class ApiResourceIntegrationAspect {

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
     * Minimum version of the references resource that the integration requires.
     * 
     * 
     */
    @JsonProperty("minVersion")
    @JsonPropertyDescription("Minimum version of the references resource that the integration requires.\n")
    private String minVersion;
    /**
     * List of individual API operations that are sufficient to achieve the aspect.
     * 
     */
    @JsonProperty("subset")
    @JsonPropertyDescription("List of individual API operations that are sufficient to achieve the aspect.")
    private List<ApiResourceIntegrationAspectSubset> subset = new ArrayList<ApiResourceIntegrationAspectSubset>();

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

    public ApiResourceIntegrationAspect withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    /**
     * Minimum version of the references resource that the integration requires.
     * 
     * 
     */
    @JsonProperty("minVersion")
    public String getMinVersion() {
        return minVersion;
    }

    /**
     * Minimum version of the references resource that the integration requires.
     * 
     * 
     */
    @JsonProperty("minVersion")
    public void setMinVersion(String minVersion) {
        this.minVersion = minVersion;
    }

    public ApiResourceIntegrationAspect withMinVersion(String minVersion) {
        this.minVersion = minVersion;
        return this;
    }

    /**
     * List of individual API operations that are sufficient to achieve the aspect.
     * 
     */
    @JsonProperty("subset")
    public List<ApiResourceIntegrationAspectSubset> getSubset() {
        return subset;
    }

    /**
     * List of individual API operations that are sufficient to achieve the aspect.
     * 
     */
    @JsonProperty("subset")
    public void setSubset(List<ApiResourceIntegrationAspectSubset> subset) {
        this.subset = subset;
    }

    public ApiResourceIntegrationAspect withSubset(List<ApiResourceIntegrationAspectSubset> subset) {
        this.subset = subset;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiResourceIntegrationAspect.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ordId");
        sb.append('=');
        sb.append(((this.ordId == null)?"<null>":this.ordId));
        sb.append(',');
        sb.append("minVersion");
        sb.append('=');
        sb.append(((this.minVersion == null)?"<null>":this.minVersion));
        sb.append(',');
        sb.append("subset");
        sb.append('=');
        sb.append(((this.subset == null)?"<null>":this.subset));
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
        result = ((result* 31)+((this.minVersion == null)? 0 :this.minVersion.hashCode()));
        result = ((result* 31)+((this.ordId == null)? 0 :this.ordId.hashCode()));
        result = ((result* 31)+((this.subset == null)? 0 :this.subset.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApiResourceIntegrationAspect) == false) {
            return false;
        }
        ApiResourceIntegrationAspect rhs = ((ApiResourceIntegrationAspect) other);
        return ((((this.minVersion == rhs.minVersion)||((this.minVersion!= null)&&this.minVersion.equals(rhs.minVersion)))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.subset == rhs.subset)||((this.subset!= null)&&this.subset.equals(rhs.subset))));
    }

}
