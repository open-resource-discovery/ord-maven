
package org.neonephos.ord.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Entity Type Mapping
 * <p>
 * An API or Event resource may optionally define its `entityTypeMappings`.
 * This is used to map and correlate the API models to the underlying, conceptual **entity types**.
 * 
 * If the mapping from API resource to entity types is not defined,
 * certain use-cases that rely on this explicit connection will not be possible.
 * 
 * This mapping is meant to be rather fine granular.
 * Therefore, the mapping needs to be done on basis of one of the referenced resource definitions,
 * as only there we know the details and the actual contents of the API Model of the API resource.
 * 
 * For the various resource definition formats the selection of API models may need to be expressed differently.
 * As a consequence, there are different types of selectors that are specialized toward certain resource definition formats.
 * 
 * The target of the mapping is a correlation to an entity type via a [Correlation ID](../../#/v1/README?id=correlation-id)
 * or to an [ORD ID](../../spec-v1/#ord-id) of an entity type.
 * It is assumed that the entity types are described in more detail or on a different abstraction level via metadata.
 * When the correlation ID is used, an ORD consumer may need to know how to access the entity type metadata through conventions.
 * This can be determined either by the namespace of the correlation ID,
 * or through a defined and known `implementationStandard` that can resolve the `localId` fragment of the correlation ID .
 * 
 * At SAP, the metadata about entity types could be retrieved via the CSN_EXPOSURE service.
 * To indicate this, the service needs to be implemented and described in ORD with `implementationStandard` set to `sap:csn-exposure:v1`).
 * 
 * ODM 2.0 relies on the entity type mappings and uses the the mapping to express the relationship of an API to the
 * corresponding ODM entity. ORD consumers like SAP Business Accelerator Hub consume the mapping to make the relationships navigate-able for customers.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiModelSelectors",
    "entityTypeTargets"
})
@Generated("jsonschema2pojo")
public class EntityTypeMapping implements org.neonephos.ord.service.hooks.PartialOrdPojo {

    /**
     * List of selectors for API models within an API Resource.
     * If multiple selectors are given, every selected API model maps to the entity type target(s).
     * If omitted, the complete API resource will be mapped to the `entityTypeTargets` (less specific).
     * 
     * Multiple selectors can be useful, e.g. with a CRUD REST API, to combine the similar API models.
     * 
     * Depending on the chosen API protocol and the available resource definition formats,
     * different kind of selectors need to be used.
     * 
     */
    @JsonProperty("apiModelSelectors")
    @JsonPropertyDescription("List of selectors for API models within an API Resource.\nIf multiple selectors are given, every selected API model maps to the entity type target(s).\nIf omitted, the complete API resource will be mapped to the `entityTypeTargets` (less specific).\n\nMultiple selectors can be useful, e.g. with a CRUD REST API, to combine the similar API models.\n\nDepending on the chosen API protocol and the available resource definition formats,\ndifferent kind of selectors need to be used.")
    private List<Object> apiModelSelectors = new ArrayList<Object>();
    /**
     * List of entity types the ORD resource maps to.
     * If `apiModelSelectors` are given, the mapping is more precise by also pointing to the specific model in the API.
     * 
     * If multiple entity types are defined as the mapping target,
     * all of them can be at least partially mapped to the source API model(s).
     * 
     * Entity types can be referenced using either using an [ORD ID](../../spec-v1/#ord-id) or a [Correlation ID](../../spec-v1/#correlation-id).
     * (Required)
     * 
     */
    @JsonProperty("entityTypeTargets")
    @JsonPropertyDescription("List of entity types the ORD resource maps to.\nIf `apiModelSelectors` are given, the mapping is more precise by also pointing to the specific model in the API.\n\nIf multiple entity types are defined as the mapping target,\nall of them can be at least partially mapped to the source API model(s).\n\nEntity types can be referenced using either using an [ORD ID](../../spec-v1/#ord-id) or a [Correlation ID](../../spec-v1/#correlation-id).")
    private List<Object> entityTypeTargets = new ArrayList<Object>();

    /**
     * List of selectors for API models within an API Resource.
     * If multiple selectors are given, every selected API model maps to the entity type target(s).
     * If omitted, the complete API resource will be mapped to the `entityTypeTargets` (less specific).
     * 
     * Multiple selectors can be useful, e.g. with a CRUD REST API, to combine the similar API models.
     * 
     * Depending on the chosen API protocol and the available resource definition formats,
     * different kind of selectors need to be used.
     * 
     */
    @JsonProperty("apiModelSelectors")
    public List<Object> getApiModelSelectors() {
        return apiModelSelectors;
    }

    /**
     * List of selectors for API models within an API Resource.
     * If multiple selectors are given, every selected API model maps to the entity type target(s).
     * If omitted, the complete API resource will be mapped to the `entityTypeTargets` (less specific).
     * 
     * Multiple selectors can be useful, e.g. with a CRUD REST API, to combine the similar API models.
     * 
     * Depending on the chosen API protocol and the available resource definition formats,
     * different kind of selectors need to be used.
     * 
     */
    @JsonProperty("apiModelSelectors")
    public void setApiModelSelectors(List<Object> apiModelSelectors) {
        this.apiModelSelectors = apiModelSelectors;
    }

    public EntityTypeMapping withApiModelSelectors(List<Object> apiModelSelectors) {
        this.apiModelSelectors = apiModelSelectors;
        return this;
    }

    /**
     * List of entity types the ORD resource maps to.
     * If `apiModelSelectors` are given, the mapping is more precise by also pointing to the specific model in the API.
     * 
     * If multiple entity types are defined as the mapping target,
     * all of them can be at least partially mapped to the source API model(s).
     * 
     * Entity types can be referenced using either using an [ORD ID](../../spec-v1/#ord-id) or a [Correlation ID](../../spec-v1/#correlation-id).
     * (Required)
     * 
     */
    @JsonProperty("entityTypeTargets")
    public List<Object> getEntityTypeTargets() {
        return entityTypeTargets;
    }

    /**
     * List of entity types the ORD resource maps to.
     * If `apiModelSelectors` are given, the mapping is more precise by also pointing to the specific model in the API.
     * 
     * If multiple entity types are defined as the mapping target,
     * all of them can be at least partially mapped to the source API model(s).
     * 
     * Entity types can be referenced using either using an [ORD ID](../../spec-v1/#ord-id) or a [Correlation ID](../../spec-v1/#correlation-id).
     * (Required)
     * 
     */
    @JsonProperty("entityTypeTargets")
    public void setEntityTypeTargets(List<Object> entityTypeTargets) {
        this.entityTypeTargets = entityTypeTargets;
    }

    public EntityTypeMapping withEntityTypeTargets(List<Object> entityTypeTargets) {
        this.entityTypeTargets = entityTypeTargets;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EntityTypeMapping.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("apiModelSelectors");
        sb.append('=');
        sb.append(((this.apiModelSelectors == null)?"<null>":this.apiModelSelectors));
        sb.append(',');
        sb.append("entityTypeTargets");
        sb.append('=');
        sb.append(((this.entityTypeTargets == null)?"<null>":this.entityTypeTargets));
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
        result = ((result* 31)+((this.entityTypeTargets == null)? 0 :this.entityTypeTargets.hashCode()));
        result = ((result* 31)+((this.apiModelSelectors == null)? 0 :this.apiModelSelectors.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EntityTypeMapping) == false) {
            return false;
        }
        EntityTypeMapping rhs = ((EntityTypeMapping) other);
        return (((this.entityTypeTargets == rhs.entityTypeTargets)||((this.entityTypeTargets!= null)&&this.entityTypeTargets.equals(rhs.entityTypeTargets)))&&((this.apiModelSelectors == rhs.apiModelSelectors)||((this.apiModelSelectors!= null)&&this.apiModelSelectors.equals(rhs.apiModelSelectors))));
    }

}
