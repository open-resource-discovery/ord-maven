
package org.openresourcediscovery.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * API Resource Integration Aspect Subset
 * <p>
 * Defines that API Resource Integration Aspect only requires a subset of the referenced contract.
 * 
 * For APIs, this is a list of the operations or tools that need to be available in order to make the integration work.
 * This information helps to narrow down what is really necessary and can help optimize the integration.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "operationId"
})
@Generated("jsonschema2pojo")
public class ApiResourceIntegrationAspectSubset {

    /**
     * The ID of the individual API operation or tool.
     * 
     * This MUST be an ID that is understood by the used protocol and resource definition format.
     * E.g. for OpenAPI this is the `operationId`, for MCP this is the tool `name`.
     * (Required)
     * 
     */
    @JsonProperty("operationId")
    @JsonPropertyDescription("The ID of the individual API operation or tool.\n\nThis MUST be an ID that is understood by the used protocol and resource definition format.\nE.g. for OpenAPI this is the `operationId`, for MCP this is the tool `name`.")
    private String operationId;

    /**
     * The ID of the individual API operation or tool.
     * 
     * This MUST be an ID that is understood by the used protocol and resource definition format.
     * E.g. for OpenAPI this is the `operationId`, for MCP this is the tool `name`.
     * (Required)
     * 
     */
    @JsonProperty("operationId")
    public String getOperationId() {
        return operationId;
    }

    /**
     * The ID of the individual API operation or tool.
     * 
     * This MUST be an ID that is understood by the used protocol and resource definition format.
     * E.g. for OpenAPI this is the `operationId`, for MCP this is the tool `name`.
     * (Required)
     * 
     */
    @JsonProperty("operationId")
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public ApiResourceIntegrationAspectSubset withOperationId(String operationId) {
        this.operationId = operationId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiResourceIntegrationAspectSubset.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("operationId");
        sb.append('=');
        sb.append(((this.operationId == null)?"<null>":this.operationId));
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
        result = ((result* 31)+((this.operationId == null)? 0 :this.operationId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApiResourceIntegrationAspectSubset) == false) {
            return false;
        }
        ApiResourceIntegrationAspectSubset rhs = ((ApiResourceIntegrationAspectSubset) other);
        return ((this.operationId == rhs.operationId)||((this.operationId!= null)&&this.operationId.equals(rhs.operationId)));
    }

}
