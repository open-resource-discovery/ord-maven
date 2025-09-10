
package org.openresourcediscovery.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Event Resource Integration Aspect
 * <p>
 * Event resource related integration aspect
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ordId",
    "minVersion",
    "subset",
    "systemTypeRestriction"
})
@Generated("jsonschema2pojo")
public class EventResourceIntegrationAspect {

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
     * List of individual events or messages that are sufficient to achieve the aspect.
     * 
     */
    @JsonProperty("subset")
    @JsonPropertyDescription("List of individual events or messages that are sufficient to achieve the aspect.")
    private List<EventResourceIntegrationAspectSubset> subset = new ArrayList<EventResourceIntegrationAspectSubset>();
    /**
     * In case that the event subscriptions are limited to known [system types](../index.md#def-system-type), they can be listed here as [system namespaces](../index.md#system-namespace).
     * 
     * If given, only system types of the defined namespaces are supported as integration partners.
     * If not given, there is no restriction which system type provides the events.
     * 
     */
    @JsonProperty("systemTypeRestriction")
    @JsonPropertyDescription("In case that the event subscriptions are limited to known [system types](../index.md#def-system-type), they can be listed here as [system namespaces](../index.md#system-namespace).\n\nIf given, only system types of the defined namespaces are supported as integration partners.\nIf not given, there is no restriction which system type provides the events.")
    private List<String> systemTypeRestriction = new ArrayList<String>();

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

    public EventResourceIntegrationAspect withOrdId(String ordId) {
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

    public EventResourceIntegrationAspect withMinVersion(String minVersion) {
        this.minVersion = minVersion;
        return this;
    }

    /**
     * List of individual events or messages that are sufficient to achieve the aspect.
     * 
     */
    @JsonProperty("subset")
    public List<EventResourceIntegrationAspectSubset> getSubset() {
        return subset;
    }

    /**
     * List of individual events or messages that are sufficient to achieve the aspect.
     * 
     */
    @JsonProperty("subset")
    public void setSubset(List<EventResourceIntegrationAspectSubset> subset) {
        this.subset = subset;
    }

    public EventResourceIntegrationAspect withSubset(List<EventResourceIntegrationAspectSubset> subset) {
        this.subset = subset;
        return this;
    }

    /**
     * In case that the event subscriptions are limited to known [system types](../index.md#def-system-type), they can be listed here as [system namespaces](../index.md#system-namespace).
     * 
     * If given, only system types of the defined namespaces are supported as integration partners.
     * If not given, there is no restriction which system type provides the events.
     * 
     */
    @JsonProperty("systemTypeRestriction")
    public List<String> getSystemTypeRestriction() {
        return systemTypeRestriction;
    }

    /**
     * In case that the event subscriptions are limited to known [system types](../index.md#def-system-type), they can be listed here as [system namespaces](../index.md#system-namespace).
     * 
     * If given, only system types of the defined namespaces are supported as integration partners.
     * If not given, there is no restriction which system type provides the events.
     * 
     */
    @JsonProperty("systemTypeRestriction")
    public void setSystemTypeRestriction(List<String> systemTypeRestriction) {
        this.systemTypeRestriction = systemTypeRestriction;
    }

    public EventResourceIntegrationAspect withSystemTypeRestriction(List<String> systemTypeRestriction) {
        this.systemTypeRestriction = systemTypeRestriction;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EventResourceIntegrationAspect.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("systemTypeRestriction");
        sb.append('=');
        sb.append(((this.systemTypeRestriction == null)?"<null>":this.systemTypeRestriction));
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
        result = ((result* 31)+((this.systemTypeRestriction == null)? 0 :this.systemTypeRestriction.hashCode()));
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
        if ((other instanceof EventResourceIntegrationAspect) == false) {
            return false;
        }
        EventResourceIntegrationAspect rhs = ((EventResourceIntegrationAspect) other);
        return (((((this.systemTypeRestriction == rhs.systemTypeRestriction)||((this.systemTypeRestriction!= null)&&this.systemTypeRestriction.equals(rhs.systemTypeRestriction)))&&((this.minVersion == rhs.minVersion)||((this.minVersion!= null)&&this.minVersion.equals(rhs.minVersion))))&&((this.ordId == rhs.ordId)||((this.ordId!= null)&&this.ordId.equals(rhs.ordId))))&&((this.subset == rhs.subset)||((this.subset!= null)&&this.subset.equals(rhs.subset))));
    }

}
