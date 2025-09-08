
package org.openresourcediscovery.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Event Resource Integration Aspect Subset
 * <p>
 * Defines that Event Resource Integration Aspect only requires a subset of the referenced contract.
 * 
 * For events, this could be a list of the events that need to be subscribed in order to make the integration work.
 * This information helps to narrow down what is really necessary and can help optimize the integration, e.g. by only publishing the events that are really needed.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventType"
})
@Generated("jsonschema2pojo")
public class EventResourceIntegrationAspectSubset implements org.openresourcediscovery.service.hooks.PartialOrdPojo {

    /**
     * The type ID of the individual event or message.
     * 
     * This MUST be an ID that is understood by the used protocol and resource definition format.
     * E.g. for CloudEvents, the [type](https://github.com/cloudevents/spec/blob/v1.0.2/cloudevents/spec.md#type) can be used.
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    @JsonPropertyDescription("The type ID of the individual event or message.\n\nThis MUST be an ID that is understood by the used protocol and resource definition format.\nE.g. for CloudEvents, the [type](https://github.com/cloudevents/spec/blob/v1.0.2/cloudevents/spec.md#type) can be used.")
    private String eventType;

    /**
     * The type ID of the individual event or message.
     * 
     * This MUST be an ID that is understood by the used protocol and resource definition format.
     * E.g. for CloudEvents, the [type](https://github.com/cloudevents/spec/blob/v1.0.2/cloudevents/spec.md#type) can be used.
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    public String getEventType() {
        return eventType;
    }

    /**
     * The type ID of the individual event or message.
     * 
     * This MUST be an ID that is understood by the used protocol and resource definition format.
     * E.g. for CloudEvents, the [type](https://github.com/cloudevents/spec/blob/v1.0.2/cloudevents/spec.md#type) can be used.
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public EventResourceIntegrationAspectSubset withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EventResourceIntegrationAspectSubset.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventType");
        sb.append('=');
        sb.append(((this.eventType == null)?"<null>":this.eventType));
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
        result = ((result* 31)+((this.eventType == null)? 0 :this.eventType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventResourceIntegrationAspectSubset) == false) {
            return false;
        }
        EventResourceIntegrationAspectSubset rhs = ((EventResourceIntegrationAspectSubset) other);
        return ((this.eventType == rhs.eventType)||((this.eventType!= null)&&this.eventType.equals(rhs.eventType)));
    }

}
