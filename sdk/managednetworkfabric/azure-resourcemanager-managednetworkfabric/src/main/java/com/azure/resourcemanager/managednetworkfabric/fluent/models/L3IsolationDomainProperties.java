// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.managednetworkfabric.models.AdministrativeState;
import com.azure.resourcemanager.managednetworkfabric.models.AggregateRouteConfiguration;
import com.azure.resourcemanager.managednetworkfabric.models.AnnotationResource;
import com.azure.resourcemanager.managednetworkfabric.models.ConfigurationState;
import com.azure.resourcemanager.managednetworkfabric.models.ConnectedSubnetRoutePolicy;
import com.azure.resourcemanager.managednetworkfabric.models.ProvisioningState;
import com.azure.resourcemanager.managednetworkfabric.models.RedistributeConnectedSubnets;
import com.azure.resourcemanager.managednetworkfabric.models.RedistributeStaticRoutes;
import java.io.IOException;

/**
 * L3 Isolation Domain Properties defines the properties of the resource.
 */
@Fluent
public final class L3IsolationDomainProperties extends AnnotationResource {
    /*
     * ARM Resource ID of the Network Fabric.
     */
    private String networkFabricId;

    /*
     * Configuration state of the resource.
     */
    private ConfigurationState configurationState;

    /*
     * Provisioning state of the resource.
     */
    private ProvisioningState provisioningState;

    /*
     * Administrative state of the resource.
     */
    private AdministrativeState administrativeState;

    /*
     * Advertise Connected Subnets. Ex: "True" | "False".
     */
    private RedistributeConnectedSubnets redistributeConnectedSubnets;

    /*
     * Advertise Static Routes. Ex: "True" | "False".
     */
    private RedistributeStaticRoutes redistributeStaticRoutes;

    /*
     * Aggregate route configurations.
     */
    private AggregateRouteConfiguration aggregateRouteConfiguration;

    /*
     * Connected Subnet RoutePolicy
     */
    private ConnectedSubnetRoutePolicy connectedSubnetRoutePolicy;

    /**
     * Creates an instance of L3IsolationDomainProperties class.
     */
    public L3IsolationDomainProperties() {
    }

    /**
     * Get the networkFabricId property: ARM Resource ID of the Network Fabric.
     * 
     * @return the networkFabricId value.
     */
    public String networkFabricId() {
        return this.networkFabricId;
    }

    /**
     * Set the networkFabricId property: ARM Resource ID of the Network Fabric.
     * 
     * @param networkFabricId the networkFabricId value to set.
     * @return the L3IsolationDomainProperties object itself.
     */
    public L3IsolationDomainProperties withNetworkFabricId(String networkFabricId) {
        this.networkFabricId = networkFabricId;
        return this;
    }

    /**
     * Get the configurationState property: Configuration state of the resource.
     * 
     * @return the configurationState value.
     */
    public ConfigurationState configurationState() {
        return this.configurationState;
    }

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the administrativeState property: Administrative state of the resource.
     * 
     * @return the administrativeState value.
     */
    public AdministrativeState administrativeState() {
        return this.administrativeState;
    }

    /**
     * Get the redistributeConnectedSubnets property: Advertise Connected Subnets. Ex: "True" | "False".
     * 
     * @return the redistributeConnectedSubnets value.
     */
    public RedistributeConnectedSubnets redistributeConnectedSubnets() {
        return this.redistributeConnectedSubnets;
    }

    /**
     * Set the redistributeConnectedSubnets property: Advertise Connected Subnets. Ex: "True" | "False".
     * 
     * @param redistributeConnectedSubnets the redistributeConnectedSubnets value to set.
     * @return the L3IsolationDomainProperties object itself.
     */
    public L3IsolationDomainProperties
        withRedistributeConnectedSubnets(RedistributeConnectedSubnets redistributeConnectedSubnets) {
        this.redistributeConnectedSubnets = redistributeConnectedSubnets;
        return this;
    }

    /**
     * Get the redistributeStaticRoutes property: Advertise Static Routes. Ex: "True" | "False".
     * 
     * @return the redistributeStaticRoutes value.
     */
    public RedistributeStaticRoutes redistributeStaticRoutes() {
        return this.redistributeStaticRoutes;
    }

    /**
     * Set the redistributeStaticRoutes property: Advertise Static Routes. Ex: "True" | "False".
     * 
     * @param redistributeStaticRoutes the redistributeStaticRoutes value to set.
     * @return the L3IsolationDomainProperties object itself.
     */
    public L3IsolationDomainProperties withRedistributeStaticRoutes(RedistributeStaticRoutes redistributeStaticRoutes) {
        this.redistributeStaticRoutes = redistributeStaticRoutes;
        return this;
    }

    /**
     * Get the aggregateRouteConfiguration property: Aggregate route configurations.
     * 
     * @return the aggregateRouteConfiguration value.
     */
    public AggregateRouteConfiguration aggregateRouteConfiguration() {
        return this.aggregateRouteConfiguration;
    }

    /**
     * Set the aggregateRouteConfiguration property: Aggregate route configurations.
     * 
     * @param aggregateRouteConfiguration the aggregateRouteConfiguration value to set.
     * @return the L3IsolationDomainProperties object itself.
     */
    public L3IsolationDomainProperties
        withAggregateRouteConfiguration(AggregateRouteConfiguration aggregateRouteConfiguration) {
        this.aggregateRouteConfiguration = aggregateRouteConfiguration;
        return this;
    }

    /**
     * Get the connectedSubnetRoutePolicy property: Connected Subnet RoutePolicy.
     * 
     * @return the connectedSubnetRoutePolicy value.
     */
    public ConnectedSubnetRoutePolicy connectedSubnetRoutePolicy() {
        return this.connectedSubnetRoutePolicy;
    }

    /**
     * Set the connectedSubnetRoutePolicy property: Connected Subnet RoutePolicy.
     * 
     * @param connectedSubnetRoutePolicy the connectedSubnetRoutePolicy value to set.
     * @return the L3IsolationDomainProperties object itself.
     */
    public L3IsolationDomainProperties
        withConnectedSubnetRoutePolicy(ConnectedSubnetRoutePolicy connectedSubnetRoutePolicy) {
        this.connectedSubnetRoutePolicy = connectedSubnetRoutePolicy;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L3IsolationDomainProperties withAnnotation(String annotation) {
        super.withAnnotation(annotation);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (networkFabricId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property networkFabricId in model L3IsolationDomainProperties"));
        }
        if (aggregateRouteConfiguration() != null) {
            aggregateRouteConfiguration().validate();
        }
        if (connectedSubnetRoutePolicy() != null) {
            connectedSubnetRoutePolicy().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(L3IsolationDomainProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("annotation", annotation());
        jsonWriter.writeStringField("networkFabricId", this.networkFabricId);
        jsonWriter.writeStringField("redistributeConnectedSubnets",
            this.redistributeConnectedSubnets == null ? null : this.redistributeConnectedSubnets.toString());
        jsonWriter.writeStringField("redistributeStaticRoutes",
            this.redistributeStaticRoutes == null ? null : this.redistributeStaticRoutes.toString());
        jsonWriter.writeJsonField("aggregateRouteConfiguration", this.aggregateRouteConfiguration);
        jsonWriter.writeJsonField("connectedSubnetRoutePolicy", this.connectedSubnetRoutePolicy);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of L3IsolationDomainProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of L3IsolationDomainProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the L3IsolationDomainProperties.
     */
    public static L3IsolationDomainProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            L3IsolationDomainProperties deserializedL3IsolationDomainProperties = new L3IsolationDomainProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("annotation".equals(fieldName)) {
                    deserializedL3IsolationDomainProperties.withAnnotation(reader.getString());
                } else if ("networkFabricId".equals(fieldName)) {
                    deserializedL3IsolationDomainProperties.networkFabricId = reader.getString();
                } else if ("configurationState".equals(fieldName)) {
                    deserializedL3IsolationDomainProperties.configurationState
                        = ConfigurationState.fromString(reader.getString());
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedL3IsolationDomainProperties.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else if ("administrativeState".equals(fieldName)) {
                    deserializedL3IsolationDomainProperties.administrativeState
                        = AdministrativeState.fromString(reader.getString());
                } else if ("redistributeConnectedSubnets".equals(fieldName)) {
                    deserializedL3IsolationDomainProperties.redistributeConnectedSubnets
                        = RedistributeConnectedSubnets.fromString(reader.getString());
                } else if ("redistributeStaticRoutes".equals(fieldName)) {
                    deserializedL3IsolationDomainProperties.redistributeStaticRoutes
                        = RedistributeStaticRoutes.fromString(reader.getString());
                } else if ("aggregateRouteConfiguration".equals(fieldName)) {
                    deserializedL3IsolationDomainProperties.aggregateRouteConfiguration
                        = AggregateRouteConfiguration.fromJson(reader);
                } else if ("connectedSubnetRoutePolicy".equals(fieldName)) {
                    deserializedL3IsolationDomainProperties.connectedSubnetRoutePolicy
                        = ConnectedSubnetRoutePolicy.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedL3IsolationDomainProperties;
        });
    }
}
