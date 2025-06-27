
package com.sap.ord.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Extensible
 * <p>
 * Contains information about the extensibility of this resource.
 * 
 * If applicable, a description and further resources about extending this resource are provided.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "supported",
    "description"
})
public class Extensible implements com.sap.ord.service.hooks.PartialOrdPojo {

    /**
     * This property defines whether the resource is extensible.
     * 
     * **Not extensible** means that the data model of the resource (i.e. API or event) cannot be extended with custom fields.
     * **Manually extensible** means that in addition to defining a custom field, manual activities to include the field in the data model of the resource (i.e. API or event) are required. E.g. using a specific mapping tool or by selecting the resource in the data model extension tool.
     * **Automatically extensible** means that after defining a custom field in the local domain model, the resource (i.e. API or event) is automatically extended as part of the default extension field definition.
     * (Required)
     * 
     */
    @JsonProperty("supported")
    @JsonPropertyDescription("This property defines whether the resource is extensible.\n\n**Not extensible** means that the data model of the resource (i.e. API or event) cannot be extended with custom fields.\n**Manually extensible** means that in addition to defining a custom field, manual activities to include the field in the data model of the resource (i.e. API or event) are required. E.g. using a specific mapping tool or by selecting the resource in the data model extension tool.\n**Automatically extensible** means that after defining a custom field in the local domain model, the resource (i.e. API or event) is automatically extended as part of the default extension field definition.")
    private Extensible.Supported supported;
    /**
     * A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * This description may contain detailed steps on how to extend the API.
     * Links to external resources can be provided within the description as markdown links.
     * 
     * This description MUST be provided if `supported` is set to `manual` or `automatic`.
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nThis description may contain detailed steps on how to extend the API.\nLinks to external resources can be provided within the description as markdown links.\n\nThis description MUST be provided if `supported` is set to `manual` or `automatic`.")
    private String description;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Extensible() {
    }

    /**
     * 
     * @param description
     *     A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     *     
     *     This description may contain detailed steps on how to extend the API.
     *     Links to external resources can be provided within the description as markdown links.
     *     
     *     This description MUST be provided if `supported` is set to `manual` or `automatic`.
     * @param supported
     *     This property defines whether the resource is extensible.
     *     
     *     **Not extensible** means that the data model of the resource (i.e. API or event) cannot be extended with custom fields.
     *     **Manually extensible** means that in addition to defining a custom field, manual activities to include the field in the data model of the resource (i.e. API or event) are required. E.g. using a specific mapping tool or by selecting the resource in the data model extension tool.
     *     **Automatically extensible** means that after defining a custom field in the local domain model, the resource (i.e. API or event) is automatically extended as part of the default extension field definition.
     */
    public Extensible(Extensible.Supported supported, String description) {
        super();
        this.supported = supported;
        this.description = description;
    }

    /**
     * This property defines whether the resource is extensible.
     * 
     * **Not extensible** means that the data model of the resource (i.e. API or event) cannot be extended with custom fields.
     * **Manually extensible** means that in addition to defining a custom field, manual activities to include the field in the data model of the resource (i.e. API or event) are required. E.g. using a specific mapping tool or by selecting the resource in the data model extension tool.
     * **Automatically extensible** means that after defining a custom field in the local domain model, the resource (i.e. API or event) is automatically extended as part of the default extension field definition.
     * (Required)
     * 
     */
    @JsonProperty("supported")
    public Extensible.Supported getSupported() {
        return supported;
    }

    /**
     * This property defines whether the resource is extensible.
     * 
     * **Not extensible** means that the data model of the resource (i.e. API or event) cannot be extended with custom fields.
     * **Manually extensible** means that in addition to defining a custom field, manual activities to include the field in the data model of the resource (i.e. API or event) are required. E.g. using a specific mapping tool or by selecting the resource in the data model extension tool.
     * **Automatically extensible** means that after defining a custom field in the local domain model, the resource (i.e. API or event) is automatically extended as part of the default extension field definition.
     * (Required)
     * 
     */
    @JsonProperty("supported")
    public void setSupported(Extensible.Supported supported) {
        this.supported = supported;
    }

    public Extensible withSupported(Extensible.Supported supported) {
        this.supported = supported;
        return this;
    }

    /**
     * A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * This description may contain detailed steps on how to extend the API.
     * Links to external resources can be provided within the description as markdown links.
     * 
     * This description MUST be provided if `supported` is set to `manual` or `automatic`.
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * A description about the extensibility capabilities of this API, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * This description may contain detailed steps on how to extend the API.
     * Links to external resources can be provided within the description as markdown links.
     * 
     * This description MUST be provided if `supported` is set to `manual` or `automatic`.
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Extensible withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Extensible.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("supported");
        sb.append('=');
        sb.append(((this.supported == null)?"<null>":this.supported));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
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
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.supported == null)? 0 :this.supported.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Extensible) == false) {
            return false;
        }
        Extensible rhs = ((Extensible) other);
        return (((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description)))&&((this.supported == rhs.supported)||((this.supported!= null)&&this.supported.equals(rhs.supported))));
    }


    /**
     * This property defines whether the resource is extensible.
     * 
     * **Not extensible** means that the data model of the resource (i.e. API or event) cannot be extended with custom fields.
     * **Manually extensible** means that in addition to defining a custom field, manual activities to include the field in the data model of the resource (i.e. API or event) are required. E.g. using a specific mapping tool or by selecting the resource in the data model extension tool.
     * **Automatically extensible** means that after defining a custom field in the local domain model, the resource (i.e. API or event) is automatically extended as part of the default extension field definition.
     * 
     */
    public enum Supported {

        NO("no"),
        MANUAL("manual"),
        AUTOMATIC("automatic");
        private final String value;
        private final static Map<String, Extensible.Supported> CONSTANTS = new HashMap<String, Extensible.Supported>();

        static {
            for (Extensible.Supported c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Supported(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Extensible.Supported fromValue(String value) {
            Extensible.Supported constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
