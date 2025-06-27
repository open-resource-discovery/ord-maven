
package com.sap.ord.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Documentation Labels
 * <p>
 * Generic documentation labels that can be applied to most ORD information.
 * They are defined as an object that may have arbitrary keys.
 * The value of a key is an array of [CommonMark](https://spec.commonmark.org/) (Markdown) text.
 * 
 * Documentation Labels can be used to attach human readable documentation that cannot be expressed natively in ORD.
 * A documentation tool (like an API Catalog) can use the documentation labels to provide generic documentation "snippets".
 * Due to the given structure they can be displayed e.g. as tables.
 * 
 * The key of the documentation Label is plain-text (MUST not contain line breaks) and denotes the subject matter that is described.
 * The values (multiple can be provided for the same key) are [CommonMark](https://spec.commonmark.org/) (Markdown) text
 * which describes the subject matter or lists options for the key.
 * 
 * In contrast to regular labels, documentation labels are not meant to be used to categorize or query information.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
public class DocumentationLabels implements com.sap.ord.service.hooks.PartialOrdPojo {


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DocumentationLabels.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof DocumentationLabels) == false) {
            return false;
        }
        DocumentationLabels rhs = ((DocumentationLabels) other);
        return true;
    }

}
