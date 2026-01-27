
package org.openresourcediscovery.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Event Compatibility
 * <p>
 * Describes the compatibility of the Event with other Events. This can be used to express that an Event is compatible with another Event version.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId",
    "maxVersion"
})
@Generated("jsonschema2pojo")
public class EventCompatibility {

    /**
     * ORD ID of the EventResource that serves as contract that this resource is compatible with.
     * 
     * MUST be a valid reference to an (usually external) [Event Resource](#event-resource) ORD ID.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    @JsonPropertyDescription("ORD ID of the EventResource that serves as contract that this resource is compatible with.\n\nMUST be a valid reference to an (usually external) [Event Resource](#event-resource) ORD ID.")
    private String ordId;
    /**
     * Specifies the maximum version of the interface contract that this resource is compatible with. This is the version, that the resource fully implements and supports.
     * 
     * Even if the interface contract evolves compatible, this resource will not be compatible with versions beyond the specified one. It is important to consider, given the example of an event version 1.0, that has the fields A and B. Being compatible with version 1.0 means to have exactly the fields A and B and potential tenant specific extensions in a dedicated namespace.
     * If an event contract changes to version 1.1 compatible by adding field C, the event declaring compatibility towards 1.0, will miss field C. Only if adopting the contract of 1.1 with having fields A, B, and C, such an event is also
     * compatible with version 1.1 of the contract. However, a client relying on version 1.0 of the contract, can still work with the event being compatible with version 1.1 of the contract.
     * 
     * Following the [Semantic Versioning 2.0.0](https://semver.org/) standard, patch versions (x.y.Z) must not have impact on the schema/contract. Therefore, the maxVersion are only the major.minor parts of a semantic version.
     * (Required)
     * 
     */
    @JsonProperty("maxVersion")
    @JsonPropertyDescription("Specifies the maximum version of the interface contract that this resource is compatible with. This is the version, that the resource fully implements and supports.\n\nEven if the interface contract evolves compatible, this resource will not be compatible with versions beyond the specified one. It is important to consider, given the example of an event version 1.0, that has the fields A and B. Being compatible with version 1.0 means to have exactly the fields A and B and potential tenant specific extensions in a dedicated namespace.\nIf an event contract changes to version 1.1 compatible by adding field C, the event declaring compatibility towards 1.0, will miss field C. Only if adopting the contract of 1.1 with having fields A, B, and C, such an event is also\ncompatible with version 1.1 of the contract. However, a client relying on version 1.0 of the contract, can still work with the event being compatible with version 1.1 of the contract.\n\nFollowing the [Semantic Versioning 2.0.0](https://semver.org/) standard, patch versions (x.y.Z) must not have impact on the schema/contract. Therefore, the maxVersion are only the major.minor parts of a semantic version.")
    private String maxVersion;

    /**
     * ORD ID of the EventResource that serves as contract that this resource is compatible with.
     * 
     * MUST be a valid reference to an (usually external) [Event Resource](#event-resource) ORD ID.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public String getOrdId() {
        return ordId;
    }

    /**
     * ORD ID of the EventResource that serves as contract that this resource is compatible with.
     * 
     * MUST be a valid reference to an (usually external) [Event Resource](#event-resource) ORD ID.
     * (Required)
     * 
     */
    @JsonProperty("ordId")
    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public EventCompatibility withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    /**
     * Specifies the maximum version of the interface contract that this resource is compatible with. This is the version, that the resource fully implements and supports.
     * 
     * Even if the interface contract evolves compatible, this resource will not be compatible with versions beyond the specified one. It is important to consider, given the example of an event version 1.0, that has the fields A and B. Being compatible with version 1.0 means to have exactly the fields A and B and potential tenant specific extensions in a dedicated namespace.
     * If an event contract changes to version 1.1 compatible by adding field C, the event declaring compatibility towards 1.0, will miss field C. Only if adopting the contract of 1.1 with having fields A, B, and C, such an event is also
     * compatible with version 1.1 of the contract. However, a client relying on version 1.0 of the contract, can still work with the event being compatible with version 1.1 of the contract.
     * 
     * Following the [Semantic Versioning 2.0.0](https://semver.org/) standard, patch versions (x.y.Z) must not have impact on the schema/contract. Therefore, the maxVersion are only the major.minor parts of a semantic version.
     * (Required)
     * 
     */
    @JsonProperty("maxVersion")
    public String getMaxVersion() {
        return maxVersion;
    }

    /**
     * Specifies the maximum version of the interface contract that this resource is compatible with. This is the version, that the resource fully implements and supports.
     * 
     * Even if the interface contract evolves compatible, this resource will not be compatible with versions beyond the specified one. It is important to consider, given the example of an event version 1.0, that has the fields A and B. Being compatible with version 1.0 means to have exactly the fields A and B and potential tenant specific extensions in a dedicated namespace.
     * If an event contract changes to version 1.1 compatible by adding field C, the event declaring compatibility towards 1.0, will miss field C. Only if adopting the contract of 1.1 with having fields A, B, and C, such an event is also
     * compatible with version 1.1 of the contract. However, a client relying on version 1.0 of the contract, can still work with the event being compatible with version 1.1 of the contract.
     * 
     * Following the [Semantic Versioning 2.0.0](https://semver.org/) standard, patch versions (x.y.Z) must not have impact on the schema/contract. Therefore, the maxVersion are only the major.minor parts of a semantic version.
     * (Required)
     * 
     */
    @JsonProperty("maxVersion")
    public void setMaxVersion(String maxVersion) {
        this.maxVersion = maxVersion;
    }

    public EventCompatibility withMaxVersion(String maxVersion) {
        this.maxVersion = maxVersion;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EventCompatibility.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ordId");
        sb.append('=');
        sb.append(((this.ordId == null)?"<null>":this.ordId));
        sb.append(',');
        sb.append("maxVersion");
        sb.append('=');
        sb.append(((this.maxVersion == null)?"<null>":this.maxVersion));
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
        result = ((result* 31)+((this.maxVersion == null)? 0 :this.maxVersion.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventCompatibility) == false) {
            return false;
        }
        EventCompatibility rhs = ((EventCompatibility) other);
        return (((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId)))&&((this.maxVersion == rhs.maxVersion)||((this.maxVersion!= null)&&this.maxVersion.equals(rhs.maxVersion))));
    }

}
