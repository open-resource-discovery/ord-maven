
package org.openresourcediscovery.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * ORD Document
 * <p>
 * The [ORD Document](../index.md#ord-document) object serves as a wrapper for the **ORD resources** and **ORD taxonomy** and adds further top-level information
 * that are specific to the document/the service it describes.
 * 
 * The constraints and considerations on [ORD Documents](../index.md#ord-document) MUST be followed.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "$schema",
    "openResourceDiscovery",
    "description",
    "perspective",
    "describedSystemInstance",
    "describedSystemType",
    "describedSystemVersion",
    "policyLevel",
    "customPolicyLevel",
    "policyLevels",
    "apiResources",
    "eventResources",
    "entityTypes",
    "capabilities",
    "dataProducts",
    "integrationDependencies",
    "vendors",
    "products",
    "packages",
    "consumptionBundles",
    "groups",
    "groupTypes",
    "tombstones"
})
@Generated("jsonschema2pojo")
public class DocumentSchema implements org.openresourcediscovery.service.hooks.PartialOrdPojo {

    /**
     * Optional [URL](https://tools.ietf.org/html/rfc3986) to the Open Resource Discovery document schema (defined as a JSON Schema).
     * If provided, this enables code intelligence and validation in supported editors (like VSCode) and tools.
     * 
     */
    @JsonProperty("$schema")
    @JsonPropertyDescription("Optional [URL](https://tools.ietf.org/html/rfc3986) to the Open Resource Discovery document schema (defined as a JSON Schema).\nIf provided, this enables code intelligence and validation in supported editors (like VSCode) and tools.")
    private String $schema;
    /**
     * Version of the Open Resource Discovery specification that is used to describe this document.
     * (Required)
     * 
     */
    @JsonProperty("openResourceDiscovery")
    @JsonPropertyDescription("Version of the Open Resource Discovery specification that is used to describe this document.")
    private DocumentSchema.OpenResourceDiscovery openResourceDiscovery;
    /**
     * Optional description of the ORD document itself.
     * Please note that this information is NOT further processed or considered by an ORD aggregator.
     * 
     * Notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Optional description of the ORD document itself.\nPlease note that this information is NOT further processed or considered by an ORD aggregator.\n\nNotated in [CommonMark](https://spec.commonmark.org/) (Markdown).")
    private String description;
    /**
     * With ORD it's possible to describe a system from a static or a dynamic [perspective](../index.md#perspectives) (for more details, follow the link).
     * 
     * It is strongly RECOMMENDED to mark all static ORD documents with perspective `system-version`.
     * 
     * It is RECOMMENDED to describe dynamic metadata in both static system-version perspective and additionally describe the system-instance perspective where it diverges from the static metadata.
     * 
     * If not provided, this defaults to `system-instance`, which is the most precise description but also the most costly to replicate.
     * 
     * Please read the [article on perspectives](../concepts/perspectives) for more explanations.
     * 
     */
    @JsonProperty("perspective")
    @JsonPropertyDescription("With ORD it's possible to describe a system from a static or a dynamic [perspective](../index.md#perspectives) (for more details, follow the link).\n\nIt is strongly RECOMMENDED to mark all static ORD documents with perspective `system-version`.\n\nIt is RECOMMENDED to describe dynamic metadata in both static system-version perspective and additionally describe the system-instance perspective where it diverges from the static metadata.\n\nIf not provided, this defaults to `system-instance`, which is the most precise description but also the most costly to replicate.\n\nPlease read the [article on perspectives](../concepts/perspectives) for more explanations.")
    private String perspective = "system instance";
    /**
     * System Instance
     * <p>
     * A [system instance](../index.md#def-system-instance) is a concrete, running instance of a system type.
     * In a multi-tenant system, it corresponds to a tenant.
     * In a single-tenant system, it corresponds to the [system installation](../index.md#def-system-deployment) itself.
     * 
     */
    @JsonProperty("describedSystemInstance")
    @JsonPropertyDescription("A [system instance](../index.md#def-system-instance) is a concrete, running instance of a system type.\nIn a multi-tenant system, it corresponds to a tenant.\nIn a single-tenant system, it corresponds to the [system installation](../index.md#def-system-deployment) itself.")
    private SystemInstance describedSystemInstance;
    /**
     * System Type
     * <p>
     * A [system type](../index.md#def-system-type) is the abstract type of an application or service, from operational perspective.
     * 
     */
    @JsonProperty("describedSystemType")
    @JsonPropertyDescription("A [system type](../index.md#def-system-type) is the abstract type of an application or service, from operational perspective.")
    private SystemType describedSystemType;
    /**
     * System Version
     * <p>
     * A [system version](../index.md#def-system-version) states the design-time version / release of a [system instance](../index.md#def-system-instance).
     * It provides versioning for operational purposes for the [system type](../index.md#def-system-type).
     * 
     */
    @JsonProperty("describedSystemVersion")
    @JsonPropertyDescription("A [system version](../index.md#def-system-version) states the design-time version / release of a [system instance](../index.md#def-system-instance).\nIt provides versioning for operational purposes for the [system type](../index.md#def-system-type).")
    private SystemVersion describedSystemVersion;
    /**
     * The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.
     * Depending on the chosen policy level, additional expectations and validations rules will be applied.
     * 
     * The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * 
     */
    @JsonProperty("policyLevel")
    @JsonPropertyDescription("The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.\nDepending on the chosen policy level, additional expectations and validations rules will be applied.\n\nThe policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.\n")
    private String policyLevel = "none";
    /**
     * If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.
     * The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.
     * 
     * MUST only be provided if `policyLevel` is set to `custom`.
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("customPolicyLevel")
    @JsonPropertyDescription("If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.\nThe policy level is inherited from packages to resources they contain, but can be overwritten at resource level.\n\nMUST only be provided if `policyLevel` is set to `custom`.\nMUST be a valid [Specification ID](../index.md#specification-id).")
    private String customPolicyLevel;
    /**
     * A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.
     * For each chosen policy level, additional expectations and validations rules will be applied.
     * 
     * Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * A policy level MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("policyLevels")
    @JsonPropertyDescription("A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.\nFor each chosen policy level, additional expectations and validations rules will be applied.\n\nPolicy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.\n\nA policy level MUST be a valid [Specification ID](../index.md#specification-id).")
    private List<String> policyLevels = new ArrayList<String>();
    /**
     * Array of all API Resources that are described in this ORD document.
     * 
     */
    @JsonProperty("apiResources")
    @JsonPropertyDescription("Array of all API Resources that are described in this ORD document.")
    private List<ApiResource> apiResources = new ArrayList<ApiResource>();
    /**
     * Array of all event resources that are described in this ORD document.
     * 
     */
    @JsonProperty("eventResources")
    @JsonPropertyDescription("Array of all event resources that are described in this ORD document.")
    private List<EventResource> eventResources = new ArrayList<EventResource>();
    /**
     * Array of all entity types that are described in this ORD document.
     * 
     */
    @JsonProperty("entityTypes")
    @JsonPropertyDescription("Array of all entity types that are described in this ORD document.")
    private List<EntityType> entityTypes = new ArrayList<EntityType>();
    /**
     * Array of all capabilities that are described in this ORD document.
     * 
     */
    @JsonProperty("capabilities")
    @JsonPropertyDescription("Array of all capabilities that are described in this ORD document.")
    private List<Capability> capabilities = new ArrayList<Capability>();
    /**
     * Array of all data products that are described in this ORD document.
     * 
     */
    @JsonProperty("dataProducts")
    @JsonPropertyDescription("Array of all data products that are described in this ORD document.")
    private List<DataProduct> dataProducts = new ArrayList<DataProduct>();
    /**
     * Array of all integration dependencies that are described in this ORD document.
     * 
     */
    @JsonProperty("integrationDependencies")
    @JsonPropertyDescription("Array of all integration dependencies that are described in this ORD document.")
    private List<IntegrationDependency> integrationDependencies = new ArrayList<IntegrationDependency>();
    /**
     * Array of all Vendors that are described in this ORD document.
     * 
     */
    @JsonProperty("vendors")
    @JsonPropertyDescription("Array of all Vendors that are described in this ORD document.")
    private List<Vendor> vendors = new ArrayList<Vendor>();
    /**
     * Array of all Products that are described in this ORD document.
     * 
     */
    @JsonProperty("products")
    @JsonPropertyDescription("Array of all Products that are described in this ORD document.")
    private List<Product> products = new ArrayList<Product>();
    /**
     * Array of all Packages that are described in this ORD document.
     * 
     */
    @JsonProperty("packages")
    @JsonPropertyDescription("Array of all Packages that are described in this ORD document.")
    private List<Package> packages = new ArrayList<Package>();
    /**
     * Array of all Consumption Bundles that are described in this ORD document.
     * 
     */
    @JsonProperty("consumptionBundles")
    @JsonPropertyDescription("Array of all Consumption Bundles that are described in this ORD document.")
    private List<ConsumptionBundle> consumptionBundles = new ArrayList<ConsumptionBundle>();
    /**
     * Array of all Groups that are described in this ORD document.
     * 
     */
    @JsonProperty("groups")
    @JsonPropertyDescription("Array of all Groups that are described in this ORD document.")
    private List<Group> groups = new ArrayList<Group>();
    /**
     * Array of all Group Types that are described in this ORD document.
     * 
     */
    @JsonProperty("groupTypes")
    @JsonPropertyDescription("Array of all Group Types that are described in this ORD document.")
    private List<GroupType> groupTypes = new ArrayList<GroupType>();
    /**
     * List of ORD information (resources or taxonomy) that have been "tombstoned", indicating removal or archival.
     * This MUST be indicated explicitly, just removing the ORD information itself is not sufficient.
     * 
     * A tombstone entry MAY be removed after a grace period of 31 days.
     * 
     */
    @JsonProperty("tombstones")
    @JsonPropertyDescription("List of ORD information (resources or taxonomy) that have been \"tombstoned\", indicating removal or archival.\nThis MUST be indicated explicitly, just removing the ORD information itself is not sufficient.\n\nA tombstone entry MAY be removed after a grace period of 31 days.")
    private List<Tombstone> tombstones = new ArrayList<Tombstone>();

    /**
     * Optional [URL](https://tools.ietf.org/html/rfc3986) to the Open Resource Discovery document schema (defined as a JSON Schema).
     * If provided, this enables code intelligence and validation in supported editors (like VSCode) and tools.
     * 
     */
    @JsonProperty("$schema")
    public String get$schema() {
        return $schema;
    }

    /**
     * Optional [URL](https://tools.ietf.org/html/rfc3986) to the Open Resource Discovery document schema (defined as a JSON Schema).
     * If provided, this enables code intelligence and validation in supported editors (like VSCode) and tools.
     * 
     */
    @JsonProperty("$schema")
    public void set$schema(String $schema) {
        this.$schema = $schema;
    }

    public DocumentSchema with$schema(String $schema) {
        this.$schema = $schema;
        return this;
    }

    /**
     * Version of the Open Resource Discovery specification that is used to describe this document.
     * (Required)
     * 
     */
    @JsonProperty("openResourceDiscovery")
    public DocumentSchema.OpenResourceDiscovery getOpenResourceDiscovery() {
        return openResourceDiscovery;
    }

    /**
     * Version of the Open Resource Discovery specification that is used to describe this document.
     * (Required)
     * 
     */
    @JsonProperty("openResourceDiscovery")
    public void setOpenResourceDiscovery(DocumentSchema.OpenResourceDiscovery openResourceDiscovery) {
        this.openResourceDiscovery = openResourceDiscovery;
    }

    public DocumentSchema withOpenResourceDiscovery(DocumentSchema.OpenResourceDiscovery openResourceDiscovery) {
        this.openResourceDiscovery = openResourceDiscovery;
        return this;
    }

    /**
     * Optional description of the ORD document itself.
     * Please note that this information is NOT further processed or considered by an ORD aggregator.
     * 
     * Notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Optional description of the ORD document itself.
     * Please note that this information is NOT further processed or considered by an ORD aggregator.
     * 
     * Notated in [CommonMark](https://spec.commonmark.org/) (Markdown).
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public DocumentSchema withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * With ORD it's possible to describe a system from a static or a dynamic [perspective](../index.md#perspectives) (for more details, follow the link).
     * 
     * It is strongly RECOMMENDED to mark all static ORD documents with perspective `system-version`.
     * 
     * It is RECOMMENDED to describe dynamic metadata in both static system-version perspective and additionally describe the system-instance perspective where it diverges from the static metadata.
     * 
     * If not provided, this defaults to `system-instance`, which is the most precise description but also the most costly to replicate.
     * 
     * Please read the [article on perspectives](../concepts/perspectives) for more explanations.
     * 
     */
    @JsonProperty("perspective")
    public String getPerspective() {
        return perspective;
    }

    /**
     * With ORD it's possible to describe a system from a static or a dynamic [perspective](../index.md#perspectives) (for more details, follow the link).
     * 
     * It is strongly RECOMMENDED to mark all static ORD documents with perspective `system-version`.
     * 
     * It is RECOMMENDED to describe dynamic metadata in both static system-version perspective and additionally describe the system-instance perspective where it diverges from the static metadata.
     * 
     * If not provided, this defaults to `system-instance`, which is the most precise description but also the most costly to replicate.
     * 
     * Please read the [article on perspectives](../concepts/perspectives) for more explanations.
     * 
     */
    @JsonProperty("perspective")
    public void setPerspective(String perspective) {
        this.perspective = perspective;
    }

    public DocumentSchema withPerspective(String perspective) {
        this.perspective = perspective;
        return this;
    }

    /**
     * System Instance
     * <p>
     * A [system instance](../index.md#def-system-instance) is a concrete, running instance of a system type.
     * In a multi-tenant system, it corresponds to a tenant.
     * In a single-tenant system, it corresponds to the [system installation](../index.md#def-system-deployment) itself.
     * 
     */
    @JsonProperty("describedSystemInstance")
    public SystemInstance getDescribedSystemInstance() {
        return describedSystemInstance;
    }

    /**
     * System Instance
     * <p>
     * A [system instance](../index.md#def-system-instance) is a concrete, running instance of a system type.
     * In a multi-tenant system, it corresponds to a tenant.
     * In a single-tenant system, it corresponds to the [system installation](../index.md#def-system-deployment) itself.
     * 
     */
    @JsonProperty("describedSystemInstance")
    public void setDescribedSystemInstance(SystemInstance describedSystemInstance) {
        this.describedSystemInstance = describedSystemInstance;
    }

    public DocumentSchema withDescribedSystemInstance(SystemInstance describedSystemInstance) {
        this.describedSystemInstance = describedSystemInstance;
        return this;
    }

    /**
     * System Type
     * <p>
     * A [system type](../index.md#def-system-type) is the abstract type of an application or service, from operational perspective.
     * 
     */
    @JsonProperty("describedSystemType")
    public SystemType getDescribedSystemType() {
        return describedSystemType;
    }

    /**
     * System Type
     * <p>
     * A [system type](../index.md#def-system-type) is the abstract type of an application or service, from operational perspective.
     * 
     */
    @JsonProperty("describedSystemType")
    public void setDescribedSystemType(SystemType describedSystemType) {
        this.describedSystemType = describedSystemType;
    }

    public DocumentSchema withDescribedSystemType(SystemType describedSystemType) {
        this.describedSystemType = describedSystemType;
        return this;
    }

    /**
     * System Version
     * <p>
     * A [system version](../index.md#def-system-version) states the design-time version / release of a [system instance](../index.md#def-system-instance).
     * It provides versioning for operational purposes for the [system type](../index.md#def-system-type).
     * 
     */
    @JsonProperty("describedSystemVersion")
    public SystemVersion getDescribedSystemVersion() {
        return describedSystemVersion;
    }

    /**
     * System Version
     * <p>
     * A [system version](../index.md#def-system-version) states the design-time version / release of a [system instance](../index.md#def-system-instance).
     * It provides versioning for operational purposes for the [system type](../index.md#def-system-type).
     * 
     */
    @JsonProperty("describedSystemVersion")
    public void setDescribedSystemVersion(SystemVersion describedSystemVersion) {
        this.describedSystemVersion = describedSystemVersion;
    }

    public DocumentSchema withDescribedSystemVersion(SystemVersion describedSystemVersion) {
        this.describedSystemVersion = describedSystemVersion;
        return this;
    }

    /**
     * The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.
     * Depending on the chosen policy level, additional expectations and validations rules will be applied.
     * 
     * The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * 
     */
    @JsonProperty("policyLevel")
    public String getPolicyLevel() {
        return policyLevel;
    }

    /**
     * The [policy level](../../spec-extensions/policy-levels/) (aka. compliance level) that the described resources need to be compliant with.
     * Depending on the chosen policy level, additional expectations and validations rules will be applied.
     * 
     * The policy level can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * 
     */
    @JsonProperty("policyLevel")
    public void setPolicyLevel(String policyLevel) {
        this.policyLevel = policyLevel;
    }

    public DocumentSchema withPolicyLevel(String policyLevel) {
        this.policyLevel = policyLevel;
        return this;
    }

    /**
     * If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.
     * The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.
     * 
     * MUST only be provided if `policyLevel` is set to `custom`.
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("customPolicyLevel")
    public String getCustomPolicyLevel() {
        return customPolicyLevel;
    }

    /**
     * If the fixed `policyLevel` values need to be extended, an arbitrary `customPolicyLevel` can be provided.
     * The policy level is inherited from packages to resources they contain, but can be overwritten at resource level.
     * 
     * MUST only be provided if `policyLevel` is set to `custom`.
     * MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("customPolicyLevel")
    public void setCustomPolicyLevel(String customPolicyLevel) {
        this.customPolicyLevel = customPolicyLevel;
    }

    public DocumentSchema withCustomPolicyLevel(String customPolicyLevel) {
        this.customPolicyLevel = customPolicyLevel;
        return this;
    }

    /**
     * A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.
     * For each chosen policy level, additional expectations and validations rules will be applied.
     * 
     * Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * A policy level MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("policyLevels")
    public List<String> getPolicyLevels() {
        return policyLevels;
    }

    /**
     * A list of [policy levels](../../spec-extensions/policy-levels/) that the described resources need to be compliant with.
     * For each chosen policy level, additional expectations and validations rules will be applied.
     * 
     * Policy levels can be defined on ORD Document level, but also be overwritten on an individual package or resource level.
     * 
     * A policy level MUST be a valid [Specification ID](../index.md#specification-id).
     * 
     */
    @JsonProperty("policyLevels")
    public void setPolicyLevels(List<String> policyLevels) {
        this.policyLevels = policyLevels;
    }

    public DocumentSchema withPolicyLevels(List<String> policyLevels) {
        this.policyLevels = policyLevels;
        return this;
    }

    /**
     * Array of all API Resources that are described in this ORD document.
     * 
     */
    @JsonProperty("apiResources")
    public List<ApiResource> getApiResources() {
        return apiResources;
    }

    /**
     * Array of all API Resources that are described in this ORD document.
     * 
     */
    @JsonProperty("apiResources")
    public void setApiResources(List<ApiResource> apiResources) {
        this.apiResources = apiResources;
    }

    public DocumentSchema withApiResources(List<ApiResource> apiResources) {
        this.apiResources = apiResources;
        return this;
    }

    /**
     * Array of all event resources that are described in this ORD document.
     * 
     */
    @JsonProperty("eventResources")
    public List<EventResource> getEventResources() {
        return eventResources;
    }

    /**
     * Array of all event resources that are described in this ORD document.
     * 
     */
    @JsonProperty("eventResources")
    public void setEventResources(List<EventResource> eventResources) {
        this.eventResources = eventResources;
    }

    public DocumentSchema withEventResources(List<EventResource> eventResources) {
        this.eventResources = eventResources;
        return this;
    }

    /**
     * Array of all entity types that are described in this ORD document.
     * 
     */
    @JsonProperty("entityTypes")
    public List<EntityType> getEntityTypes() {
        return entityTypes;
    }

    /**
     * Array of all entity types that are described in this ORD document.
     * 
     */
    @JsonProperty("entityTypes")
    public void setEntityTypes(List<EntityType> entityTypes) {
        this.entityTypes = entityTypes;
    }

    public DocumentSchema withEntityTypes(List<EntityType> entityTypes) {
        this.entityTypes = entityTypes;
        return this;
    }

    /**
     * Array of all capabilities that are described in this ORD document.
     * 
     */
    @JsonProperty("capabilities")
    public List<Capability> getCapabilities() {
        return capabilities;
    }

    /**
     * Array of all capabilities that are described in this ORD document.
     * 
     */
    @JsonProperty("capabilities")
    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

    public DocumentSchema withCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    /**
     * Array of all data products that are described in this ORD document.
     * 
     */
    @JsonProperty("dataProducts")
    public List<DataProduct> getDataProducts() {
        return dataProducts;
    }

    /**
     * Array of all data products that are described in this ORD document.
     * 
     */
    @JsonProperty("dataProducts")
    public void setDataProducts(List<DataProduct> dataProducts) {
        this.dataProducts = dataProducts;
    }

    public DocumentSchema withDataProducts(List<DataProduct> dataProducts) {
        this.dataProducts = dataProducts;
        return this;
    }

    /**
     * Array of all integration dependencies that are described in this ORD document.
     * 
     */
    @JsonProperty("integrationDependencies")
    public List<IntegrationDependency> getIntegrationDependencies() {
        return integrationDependencies;
    }

    /**
     * Array of all integration dependencies that are described in this ORD document.
     * 
     */
    @JsonProperty("integrationDependencies")
    public void setIntegrationDependencies(List<IntegrationDependency> integrationDependencies) {
        this.integrationDependencies = integrationDependencies;
    }

    public DocumentSchema withIntegrationDependencies(List<IntegrationDependency> integrationDependencies) {
        this.integrationDependencies = integrationDependencies;
        return this;
    }

    /**
     * Array of all Vendors that are described in this ORD document.
     * 
     */
    @JsonProperty("vendors")
    public List<Vendor> getVendors() {
        return vendors;
    }

    /**
     * Array of all Vendors that are described in this ORD document.
     * 
     */
    @JsonProperty("vendors")
    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public DocumentSchema withVendors(List<Vendor> vendors) {
        this.vendors = vendors;
        return this;
    }

    /**
     * Array of all Products that are described in this ORD document.
     * 
     */
    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Array of all Products that are described in this ORD document.
     * 
     */
    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DocumentSchema withProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    /**
     * Array of all Packages that are described in this ORD document.
     * 
     */
    @JsonProperty("packages")
    public List<Package> getPackages() {
        return packages;
    }

    /**
     * Array of all Packages that are described in this ORD document.
     * 
     */
    @JsonProperty("packages")
    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public DocumentSchema withPackages(List<Package> packages) {
        this.packages = packages;
        return this;
    }

    /**
     * Array of all Consumption Bundles that are described in this ORD document.
     * 
     */
    @JsonProperty("consumptionBundles")
    public List<ConsumptionBundle> getConsumptionBundles() {
        return consumptionBundles;
    }

    /**
     * Array of all Consumption Bundles that are described in this ORD document.
     * 
     */
    @JsonProperty("consumptionBundles")
    public void setConsumptionBundles(List<ConsumptionBundle> consumptionBundles) {
        this.consumptionBundles = consumptionBundles;
    }

    public DocumentSchema withConsumptionBundles(List<ConsumptionBundle> consumptionBundles) {
        this.consumptionBundles = consumptionBundles;
        return this;
    }

    /**
     * Array of all Groups that are described in this ORD document.
     * 
     */
    @JsonProperty("groups")
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Array of all Groups that are described in this ORD document.
     * 
     */
    @JsonProperty("groups")
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public DocumentSchema withGroups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

    /**
     * Array of all Group Types that are described in this ORD document.
     * 
     */
    @JsonProperty("groupTypes")
    public List<GroupType> getGroupTypes() {
        return groupTypes;
    }

    /**
     * Array of all Group Types that are described in this ORD document.
     * 
     */
    @JsonProperty("groupTypes")
    public void setGroupTypes(List<GroupType> groupTypes) {
        this.groupTypes = groupTypes;
    }

    public DocumentSchema withGroupTypes(List<GroupType> groupTypes) {
        this.groupTypes = groupTypes;
        return this;
    }

    /**
     * List of ORD information (resources or taxonomy) that have been "tombstoned", indicating removal or archival.
     * This MUST be indicated explicitly, just removing the ORD information itself is not sufficient.
     * 
     * A tombstone entry MAY be removed after a grace period of 31 days.
     * 
     */
    @JsonProperty("tombstones")
    public List<Tombstone> getTombstones() {
        return tombstones;
    }

    /**
     * List of ORD information (resources or taxonomy) that have been "tombstoned", indicating removal or archival.
     * This MUST be indicated explicitly, just removing the ORD information itself is not sufficient.
     * 
     * A tombstone entry MAY be removed after a grace period of 31 days.
     * 
     */
    @JsonProperty("tombstones")
    public void setTombstones(List<Tombstone> tombstones) {
        this.tombstones = tombstones;
    }

    public DocumentSchema withTombstones(List<Tombstone> tombstones) {
        this.tombstones = tombstones;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DocumentSchema.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("$schema");
        sb.append('=');
        sb.append(((this.$schema == null)?"<null>":this.$schema));
        sb.append(',');
        sb.append("openResourceDiscovery");
        sb.append('=');
        sb.append(((this.openResourceDiscovery == null)?"<null>":this.openResourceDiscovery));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("perspective");
        sb.append('=');
        sb.append(((this.perspective == null)?"<null>":this.perspective));
        sb.append(',');
        sb.append("describedSystemInstance");
        sb.append('=');
        sb.append(((this.describedSystemInstance == null)?"<null>":this.describedSystemInstance));
        sb.append(',');
        sb.append("describedSystemType");
        sb.append('=');
        sb.append(((this.describedSystemType == null)?"<null>":this.describedSystemType));
        sb.append(',');
        sb.append("describedSystemVersion");
        sb.append('=');
        sb.append(((this.describedSystemVersion == null)?"<null>":this.describedSystemVersion));
        sb.append(',');
        sb.append("policyLevel");
        sb.append('=');
        sb.append(((this.policyLevel == null)?"<null>":this.policyLevel));
        sb.append(',');
        sb.append("customPolicyLevel");
        sb.append('=');
        sb.append(((this.customPolicyLevel == null)?"<null>":this.customPolicyLevel));
        sb.append(',');
        sb.append("policyLevels");
        sb.append('=');
        sb.append(((this.policyLevels == null)?"<null>":this.policyLevels));
        sb.append(',');
        sb.append("apiResources");
        sb.append('=');
        sb.append(((this.apiResources == null)?"<null>":this.apiResources));
        sb.append(',');
        sb.append("eventResources");
        sb.append('=');
        sb.append(((this.eventResources == null)?"<null>":this.eventResources));
        sb.append(',');
        sb.append("entityTypes");
        sb.append('=');
        sb.append(((this.entityTypes == null)?"<null>":this.entityTypes));
        sb.append(',');
        sb.append("capabilities");
        sb.append('=');
        sb.append(((this.capabilities == null)?"<null>":this.capabilities));
        sb.append(',');
        sb.append("dataProducts");
        sb.append('=');
        sb.append(((this.dataProducts == null)?"<null>":this.dataProducts));
        sb.append(',');
        sb.append("integrationDependencies");
        sb.append('=');
        sb.append(((this.integrationDependencies == null)?"<null>":this.integrationDependencies));
        sb.append(',');
        sb.append("vendors");
        sb.append('=');
        sb.append(((this.vendors == null)?"<null>":this.vendors));
        sb.append(',');
        sb.append("products");
        sb.append('=');
        sb.append(((this.products == null)?"<null>":this.products));
        sb.append(',');
        sb.append("packages");
        sb.append('=');
        sb.append(((this.packages == null)?"<null>":this.packages));
        sb.append(',');
        sb.append("consumptionBundles");
        sb.append('=');
        sb.append(((this.consumptionBundles == null)?"<null>":this.consumptionBundles));
        sb.append(',');
        sb.append("groups");
        sb.append('=');
        sb.append(((this.groups == null)?"<null>":this.groups));
        sb.append(',');
        sb.append("groupTypes");
        sb.append('=');
        sb.append(((this.groupTypes == null)?"<null>":this.groupTypes));
        sb.append(',');
        sb.append("tombstones");
        sb.append('=');
        sb.append(((this.tombstones == null)?"<null>":this.tombstones));
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
        result = ((result* 31)+((this.openResourceDiscovery == null)? 0 :this.openResourceDiscovery.hashCode()));
        result = ((result* 31)+((this.describedSystemInstance == null)? 0 :this.describedSystemInstance.hashCode()));
        result = ((result* 31)+((this.groupTypes == null)? 0 :this.groupTypes.hashCode()));
        result = ((result* 31)+((this.capabilities == null)? 0 :this.capabilities.hashCode()));
        result = ((result* 31)+((this.$schema == null)? 0 :this.$schema.hashCode()));
        result = ((result* 31)+((this.integrationDependencies == null)? 0 :this.integrationDependencies.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.dataProducts == null)? 0 :this.dataProducts.hashCode()));
        result = ((result* 31)+((this.groups == null)? 0 :this.groups.hashCode()));
        result = ((result* 31)+((this.consumptionBundles == null)? 0 :this.consumptionBundles.hashCode()));
        result = ((result* 31)+((this.customPolicyLevel == null)? 0 :this.customPolicyLevel.hashCode()));
        result = ((result* 31)+((this.packages == null)? 0 :this.packages.hashCode()));
        result = ((result* 31)+((this.describedSystemVersion == null)? 0 :this.describedSystemVersion.hashCode()));
        result = ((result* 31)+((this.policyLevels == null)? 0 :this.policyLevels.hashCode()));
        result = ((result* 31)+((this.eventResources == null)? 0 :this.eventResources.hashCode()));
        result = ((result* 31)+((this.products == null)? 0 :this.products.hashCode()));
        result = ((result* 31)+((this.policyLevel == null)? 0 :this.policyLevel.hashCode()));
        result = ((result* 31)+((this.tombstones == null)? 0 :this.tombstones.hashCode()));
        result = ((result* 31)+((this.apiResources == null)? 0 :this.apiResources.hashCode()));
        result = ((result* 31)+((this.perspective == null)? 0 :this.perspective.hashCode()));
        result = ((result* 31)+((this.entityTypes == null)? 0 :this.entityTypes.hashCode()));
        result = ((result* 31)+((this.describedSystemType == null)? 0 :this.describedSystemType.hashCode()));
        result = ((result* 31)+((this.vendors == null)? 0 :this.vendors.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DocumentSchema) == false) {
            return false;
        }
        DocumentSchema rhs = ((DocumentSchema) other);
        return ((((((((((((((((((((((((this.openResourceDiscovery == rhs.openResourceDiscovery)||((this.openResourceDiscovery!= null)&&this.openResourceDiscovery.equals(rhs.openResourceDiscovery)))&&((this.describedSystemInstance == rhs.describedSystemInstance)||((this.describedSystemInstance!= null)&&this.describedSystemInstance.equals(rhs.describedSystemInstance))))&&((this.groupTypes == rhs.groupTypes)||((this.groupTypes!= null)&&this.groupTypes.equals(rhs.groupTypes))))&&((this.capabilities == rhs.capabilities)||((this.capabilities!= null)&&this.capabilities.equals(rhs.capabilities))))&&((this.$schema == rhs.$schema)||((this.$schema!= null)&&this.$schema.equals(rhs.$schema))))&&((this.integrationDependencies == rhs.integrationDependencies)||((this.integrationDependencies!= null)&&this.integrationDependencies.equals(rhs.integrationDependencies))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.dataProducts == rhs.dataProducts)||((this.dataProducts!= null)&&this.dataProducts.equals(rhs.dataProducts))))&&((this.groups == rhs.groups)||((this.groups!= null)&&this.groups.equals(rhs.groups))))&&((this.consumptionBundles == rhs.consumptionBundles)||((this.consumptionBundles!= null)&&this.consumptionBundles.equals(rhs.consumptionBundles))))&&((this.customPolicyLevel == rhs.customPolicyLevel)||((this.customPolicyLevel!= null)&&this.customPolicyLevel.equals(rhs.customPolicyLevel))))&&((this.packages == rhs.packages)||((this.packages!= null)&&this.packages.equals(rhs.packages))))&&((this.describedSystemVersion == rhs.describedSystemVersion)||((this.describedSystemVersion!= null)&&this.describedSystemVersion.equals(rhs.describedSystemVersion))))&&((this.policyLevels == rhs.policyLevels)||((this.policyLevels!= null)&&this.policyLevels.equals(rhs.policyLevels))))&&((this.eventResources == rhs.eventResources)||((this.eventResources!= null)&&this.eventResources.equals(rhs.eventResources))))&&((this.products == rhs.products)||((this.products!= null)&&this.products.equals(rhs.products))))&&((this.policyLevel == rhs.policyLevel)||((this.policyLevel!= null)&&this.policyLevel.equals(rhs.policyLevel))))&&((this.tombstones == rhs.tombstones)||((this.tombstones!= null)&&this.tombstones.equals(rhs.tombstones))))&&((this.apiResources == rhs.apiResources)||((this.apiResources!= null)&&this.apiResources.equals(rhs.apiResources))))&&((this.perspective == rhs.perspective)||((this.perspective!= null)&&this.perspective.equals(rhs.perspective))))&&((this.entityTypes == rhs.entityTypes)||((this.entityTypes!= null)&&this.entityTypes.equals(rhs.entityTypes))))&&((this.describedSystemType == rhs.describedSystemType)||((this.describedSystemType!= null)&&this.describedSystemType.equals(rhs.describedSystemType))))&&((this.vendors == rhs.vendors)||((this.vendors!= null)&&this.vendors.equals(rhs.vendors))));
    }


    /**
     * Version of the Open Resource Discovery specification that is used to describe this document.
     * 
     */
    @Generated("jsonschema2pojo")
    public enum OpenResourceDiscovery {

        _1_0("1.0"),
        _1_1("1.1"),
        _1_2("1.2"),
        _1_3("1.3"),
        _1_4("1.4"),
        _1_5("1.5"),
        _1_6("1.6"),
        _1_7("1.7"),
        _1_8("1.8"),
        _1_9("1.9"),
        _1_10("1.10"),
        _1_11("1.11"),
        _1_12("1.12");
        private final String value;
        private final static Map<String, DocumentSchema.OpenResourceDiscovery> CONSTANTS = new HashMap<String, DocumentSchema.OpenResourceDiscovery>();

        static {
            for (DocumentSchema.OpenResourceDiscovery c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        OpenResourceDiscovery(String value) {
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
        public static DocumentSchema.OpenResourceDiscovery fromValue(String value) {
            DocumentSchema.OpenResourceDiscovery constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
