
package org.openresourcediscovery.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Access Strategy
 * <p>
 * Defines the [access strategy](../../spec-extensions/access-strategies/) for accessing the resource definitions.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "customType",
    "customDescription"
})
@Generated("jsonschema2pojo")
public class AccessStrategy {

    /**
     * Defines the authentication/authorization strategy through which the referenced `resourceDefinitions` are accessible.
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Defines the authentication/authorization strategy through which the referenced `resourceDefinitions` are accessible.")
    private String type;
    /**
     * If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customType")
    @JsonPropertyDescription("If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.\n\nMUST be a valid [Specification ID](../index.md#specification-id).\n\nMUST only be provided if `type` is set to `custom`.")
    private String customType;
    /**
     * Human-readable description about how the access is set up, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customDescription")
    @JsonPropertyDescription("Human-readable description about how the access is set up, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nMUST only be provided if `type` is set to `custom`.")
    private String customDescription;

    /**
     * Defines the authentication/authorization strategy through which the referenced `resourceDefinitions` are accessible.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Defines the authentication/authorization strategy through which the referenced `resourceDefinitions` are accessible.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public AccessStrategy withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customType")
    public String getCustomType() {
        return customType;
    }

    /**
     * If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     * 
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customType")
    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public AccessStrategy withCustomType(String customType) {
        this.customType = customType;
        return this;
    }

    /**
     * Human-readable description about how the access is set up, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customDescription")
    public String getCustomDescription() {
        return customDescription;
    }

    /**
     * Human-readable description about how the access is set up, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customDescription")
    public void setCustomDescription(String customDescription) {
        this.customDescription = customDescription;
    }

    public AccessStrategy withCustomDescription(String customDescription) {
        this.customDescription = customDescription;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AccessStrategy.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("customType");
        sb.append('=');
        sb.append(((this.customType == null)?"<null>":this.customType));
        sb.append(',');
        sb.append("customDescription");
        sb.append('=');
        sb.append(((this.customDescription == null)?"<null>":this.customDescription));
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
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.customType == null)? 0 :this.customType.hashCode()));
        result = ((result* 31)+((this.customDescription == null)? 0 :this.customDescription.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccessStrategy) == false) {
            return false;
        }
        AccessStrategy rhs = ((AccessStrategy) other);
        return ((((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type)))&&((this.customType == rhs.customType)||((this.customType!= null)&&this.customType.equals(rhs.customType))))&&((this.customDescription == rhs.customDescription)||((this.customDescription!= null)&&this.customDescription.equals(rhs.customDescription))));
    }

}
