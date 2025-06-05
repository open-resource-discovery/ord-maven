
package com.sap.ord.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Labels
 * <p>
 * Generic labels that can be applied to most ORD information.
 * They are defined as an object that may have arbitrary keys.
 * The value of a key is an array of strings.
 * 
 * Labels can be used to attach technical information that cannot be expressed natively in ORD.
 * An ORD aggregator should allow to categorize and query information based on the labels provided.
 * 
 * If multiple parties rely on the existence of certain label information,
 * standardization through ORD SHOULD be preferred.
 * 
 * All labels attached to a `Package` will be inherited to the resources they contain.
 * Duplicate labels will be merged by the ORD aggregator according to the following rules:
 * * Values of the same label key will be merged.
 * * Duplicate values of the same label key will be removed.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
public class Labels {


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Labels.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Labels) == false) {
            return false;
        }
        Labels rhs = ((Labels) other);
        return true;
    }

}
