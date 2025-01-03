// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The environment details of the resource.
 */
@Fluent
public final class EnvironmentDetails implements JsonSerializable<EnvironmentDetails> {
    /*
     * The native resource id of the resource (in case of Azure - the resource Id, in case of MC - the native resource
     * id)
     */
    private String nativeResourceId;

    /*
     * The hierarchy id of the connector (in case of Azure - the subscription Id, in case of MC - the hierarchyId id)
     */
    private String environmentHierarchyId;

    /*
     * The organizational hierarchy id of the connector (in case of Azure - the subscription Id, in case of MC - the
     * organizational hierarchyId id)
     */
    private String organizationalHierarchyId;

    /*
     * The subscription Id
     */
    private String subscriptionId;

    /*
     * The tenant Id
     */
    private String tenantId;

    /**
     * Creates an instance of EnvironmentDetails class.
     */
    public EnvironmentDetails() {
    }

    /**
     * Get the nativeResourceId property: The native resource id of the resource (in case of Azure - the resource Id, in
     * case of MC - the native resource id).
     * 
     * @return the nativeResourceId value.
     */
    public String nativeResourceId() {
        return this.nativeResourceId;
    }

    /**
     * Set the nativeResourceId property: The native resource id of the resource (in case of Azure - the resource Id, in
     * case of MC - the native resource id).
     * 
     * @param nativeResourceId the nativeResourceId value to set.
     * @return the EnvironmentDetails object itself.
     */
    public EnvironmentDetails withNativeResourceId(String nativeResourceId) {
        this.nativeResourceId = nativeResourceId;
        return this;
    }

    /**
     * Get the environmentHierarchyId property: The hierarchy id of the connector (in case of Azure - the subscription
     * Id, in case of MC - the hierarchyId id).
     * 
     * @return the environmentHierarchyId value.
     */
    public String environmentHierarchyId() {
        return this.environmentHierarchyId;
    }

    /**
     * Set the environmentHierarchyId property: The hierarchy id of the connector (in case of Azure - the subscription
     * Id, in case of MC - the hierarchyId id).
     * 
     * @param environmentHierarchyId the environmentHierarchyId value to set.
     * @return the EnvironmentDetails object itself.
     */
    public EnvironmentDetails withEnvironmentHierarchyId(String environmentHierarchyId) {
        this.environmentHierarchyId = environmentHierarchyId;
        return this;
    }

    /**
     * Get the organizationalHierarchyId property: The organizational hierarchy id of the connector (in case of Azure -
     * the subscription Id, in case of MC - the organizational hierarchyId id).
     * 
     * @return the organizationalHierarchyId value.
     */
    public String organizationalHierarchyId() {
        return this.organizationalHierarchyId;
    }

    /**
     * Set the organizationalHierarchyId property: The organizational hierarchy id of the connector (in case of Azure -
     * the subscription Id, in case of MC - the organizational hierarchyId id).
     * 
     * @param organizationalHierarchyId the organizationalHierarchyId value to set.
     * @return the EnvironmentDetails object itself.
     */
    public EnvironmentDetails withOrganizationalHierarchyId(String organizationalHierarchyId) {
        this.organizationalHierarchyId = organizationalHierarchyId;
        return this;
    }

    /**
     * Get the subscriptionId property: The subscription Id.
     * 
     * @return the subscriptionId value.
     */
    public String subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Set the subscriptionId property: The subscription Id.
     * 
     * @param subscriptionId the subscriptionId value to set.
     * @return the EnvironmentDetails object itself.
     */
    public EnvironmentDetails withSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    /**
     * Get the tenantId property: The tenant Id.
     * 
     * @return the tenantId value.
     */
    public String tenantId() {
        return this.tenantId;
    }

    /**
     * Set the tenantId property: The tenant Id.
     * 
     * @param tenantId the tenantId value to set.
     * @return the EnvironmentDetails object itself.
     */
    public EnvironmentDetails withTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("nativeResourceId", this.nativeResourceId);
        jsonWriter.writeStringField("environmentHierarchyId", this.environmentHierarchyId);
        jsonWriter.writeStringField("organizationalHierarchyId", this.organizationalHierarchyId);
        jsonWriter.writeStringField("subscriptionId", this.subscriptionId);
        jsonWriter.writeStringField("tenantId", this.tenantId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of EnvironmentDetails from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of EnvironmentDetails if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the EnvironmentDetails.
     */
    public static EnvironmentDetails fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            EnvironmentDetails deserializedEnvironmentDetails = new EnvironmentDetails();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("nativeResourceId".equals(fieldName)) {
                    deserializedEnvironmentDetails.nativeResourceId = reader.getString();
                } else if ("environmentHierarchyId".equals(fieldName)) {
                    deserializedEnvironmentDetails.environmentHierarchyId = reader.getString();
                } else if ("organizationalHierarchyId".equals(fieldName)) {
                    deserializedEnvironmentDetails.organizationalHierarchyId = reader.getString();
                } else if ("subscriptionId".equals(fieldName)) {
                    deserializedEnvironmentDetails.subscriptionId = reader.getString();
                } else if ("tenantId".equals(fieldName)) {
                    deserializedEnvironmentDetails.tenantId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedEnvironmentDetails;
        });
    }
}
