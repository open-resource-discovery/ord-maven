
package com.sap.ord.model;

import java.net.URI;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Credential Exchange Strategy
 * <p>
 * The credential exchange strategy specifies how a set of credentials for a particular usage
 * of the APIs in the consumption bundle can be obtained.
 * Until a SAP-wide strategy for obtaining such credentials exists and is agreed upon,
 * both LoBs and aggregators (namely Unified Customer Landscape) can define their own strategy specifications.
 * 
 * While the actual flow in term of API calls can differ between the different strategies,
 * the end goal would always be the possibility for automatically obtaining credentials for each client
 * that would like to use the APIs from a particular bundle.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "customType",
    "customDescription",
    "callbackUrl"
})
public class CredentialExchangeStrategy {

    /**
     * The type of credential exchange strategy.
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("The type of credential exchange strategy.")
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
     * Human-readable description about how the credential exchange is achieved, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customDescription")
    @JsonPropertyDescription("Human-readable description about how the credential exchange is achieved, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).\n\nMUST only be provided if `type` is set to `custom`.")
    private String customDescription;
    /**
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the credential exchange callback endpoint.
     * 
     * This allows requesting a set of credentials that can be used for consuming all the APIs and Events that are part of the bundle.
     * 
     * The interface contract/protocol is dependent and defined by the chosen `type`.
     * 
     * Whenever a client wants to consume a resource within a particular bundle, this endpoint can be called to obtain the credentials that this client can use.
     * 
     * The returned credentials MUST be valid for all resources that are part of the respective bundle.
     * The endpoint SHOULD return a different set of credentials on each invocation.
     * 
     */
    @JsonProperty("callbackUrl")
    @JsonPropertyDescription("[URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the credential exchange callback endpoint.\n\nThis allows requesting a set of credentials that can be used for consuming all the APIs and Events that are part of the bundle.\n\nThe interface contract/protocol is dependent and defined by the chosen `type`.\n\nWhenever a client wants to consume a resource within a particular bundle, this endpoint can be called to obtain the credentials that this client can use.\n\nThe returned credentials MUST be valid for all resources that are part of the respective bundle.\nThe endpoint SHOULD return a different set of credentials on each invocation.")
    private URI callbackUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CredentialExchangeStrategy() {
    }

    /**
     * 
     * @param customType
     *     If the fixed `type` enum values need to be extended, an arbitrary `customType` can be provided.
     *     
     *     MUST be a valid [Specification ID](../index.md#specification-id).
     *     
     *     MUST only be provided if `type` is set to `custom`.
     * @param customDescription
     *     Human-readable description about how the credential exchange is achieved, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     *     
     *     MUST only be provided if `type` is set to `custom`.
     * @param callbackUrl
     *     [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the credential exchange callback endpoint.
     *     
     *     This allows requesting a set of credentials that can be used for consuming all the APIs and Events that are part of the bundle.
     *     
     *     The interface contract/protocol is dependent and defined by the chosen `type`.
     *     
     *     Whenever a client wants to consume a resource within a particular bundle, this endpoint can be called to obtain the credentials that this client can use.
     *     
     *     The returned credentials MUST be valid for all resources that are part of the respective bundle.
     *     The endpoint SHOULD return a different set of credentials on each invocation.
     * @param type
     *     The type of credential exchange strategy.
     */
    public CredentialExchangeStrategy(String type, String customType, String customDescription, URI callbackUrl) {
        super();
        this.type = type;
        this.customType = customType;
        this.customDescription = customDescription;
        this.callbackUrl = callbackUrl;
    }

    /**
     * The type of credential exchange strategy.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * The type of credential exchange strategy.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public CredentialExchangeStrategy withType(String type) {
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

    public CredentialExchangeStrategy withCustomType(String customType) {
        this.customType = customType;
        return this;
    }

    /**
     * Human-readable description about how the credential exchange is achieved, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customDescription")
    public String getCustomDescription() {
        return customDescription;
    }

    /**
     * Human-readable description about how the credential exchange is achieved, notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     * MUST only be provided if `type` is set to `custom`.
     * 
     */
    @JsonProperty("customDescription")
    public void setCustomDescription(String customDescription) {
        this.customDescription = customDescription;
    }

    public CredentialExchangeStrategy withCustomDescription(String customDescription) {
        this.customDescription = customDescription;
        return this;
    }

    /**
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the credential exchange callback endpoint.
     * 
     * This allows requesting a set of credentials that can be used for consuming all the APIs and Events that are part of the bundle.
     * 
     * The interface contract/protocol is dependent and defined by the chosen `type`.
     * 
     * Whenever a client wants to consume a resource within a particular bundle, this endpoint can be called to obtain the credentials that this client can use.
     * 
     * The returned credentials MUST be valid for all resources that are part of the respective bundle.
     * The endpoint SHOULD return a different set of credentials on each invocation.
     * 
     */
    @JsonProperty("callbackUrl")
    public URI getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * [URL reference](https://tools.ietf.org/html/rfc3986#section-4.1) (URL or relative reference) to the credential exchange callback endpoint.
     * 
     * This allows requesting a set of credentials that can be used for consuming all the APIs and Events that are part of the bundle.
     * 
     * The interface contract/protocol is dependent and defined by the chosen `type`.
     * 
     * Whenever a client wants to consume a resource within a particular bundle, this endpoint can be called to obtain the credentials that this client can use.
     * 
     * The returned credentials MUST be valid for all resources that are part of the respective bundle.
     * The endpoint SHOULD return a different set of credentials on each invocation.
     * 
     */
    @JsonProperty("callbackUrl")
    public void setCallbackUrl(URI callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public CredentialExchangeStrategy withCallbackUrl(URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CredentialExchangeStrategy.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("callbackUrl");
        sb.append('=');
        sb.append(((this.callbackUrl == null)?"<null>":this.callbackUrl));
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
        result = ((result* 31)+((this.customType == null)? 0 :this.customType.hashCode()));
        result = ((result* 31)+((this.callbackUrl == null)? 0 :this.callbackUrl.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.customDescription == null)? 0 :this.customDescription.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CredentialExchangeStrategy) == false) {
            return false;
        }
        CredentialExchangeStrategy rhs = ((CredentialExchangeStrategy) other);
        return (((((this.customType == rhs.customType)||((this.customType!= null)&&this.customType.equals(rhs.customType)))&&((this.callbackUrl == rhs.callbackUrl)||((this.callbackUrl!= null)&&this.callbackUrl.equals(rhs.callbackUrl))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.customDescription == rhs.customDescription)||((this.customDescription!= null)&&this.customDescription.equals(rhs.customDescription))));
    }

}
