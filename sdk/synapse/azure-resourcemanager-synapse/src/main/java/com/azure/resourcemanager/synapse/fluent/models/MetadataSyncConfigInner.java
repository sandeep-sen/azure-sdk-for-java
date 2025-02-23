// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Metadata sync configuration
 * 
 * Configuration for metadata sync.
 */
@Fluent
public final class MetadataSyncConfigInner extends ProxyResource {
    /*
     * Metadata Sync Config properties
     */
    private MetadataSyncConfigProperties innerProperties;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of MetadataSyncConfigInner class.
     */
    public MetadataSyncConfigInner() {
    }

    /**
     * Get the innerProperties property: Metadata Sync Config properties.
     * 
     * @return the innerProperties value.
     */
    private MetadataSyncConfigProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Get the enabled property: Indicates whether the metadata sync is enabled or disabled.
     * 
     * @return the enabled value.
     */
    public Boolean enabled() {
        return this.innerProperties() == null ? null : this.innerProperties().enabled();
    }

    /**
     * Set the enabled property: Indicates whether the metadata sync is enabled or disabled.
     * 
     * @param enabled the enabled value to set.
     * @return the MetadataSyncConfigInner object itself.
     */
    public MetadataSyncConfigInner withEnabled(Boolean enabled) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetadataSyncConfigProperties();
        }
        this.innerProperties().withEnabled(enabled);
        return this;
    }

    /**
     * Get the syncIntervalInMinutes property: The Sync Interval in minutes.
     * 
     * @return the syncIntervalInMinutes value.
     */
    public Integer syncIntervalInMinutes() {
        return this.innerProperties() == null ? null : this.innerProperties().syncIntervalInMinutes();
    }

    /**
     * Set the syncIntervalInMinutes property: The Sync Interval in minutes.
     * 
     * @param syncIntervalInMinutes the syncIntervalInMinutes value to set.
     * @return the MetadataSyncConfigInner object itself.
     */
    public MetadataSyncConfigInner withSyncIntervalInMinutes(Integer syncIntervalInMinutes) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetadataSyncConfigProperties();
        }
        this.innerProperties().withSyncIntervalInMinutes(syncIntervalInMinutes);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetadataSyncConfigInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetadataSyncConfigInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MetadataSyncConfigInner.
     */
    public static MetadataSyncConfigInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MetadataSyncConfigInner deserializedMetadataSyncConfigInner = new MetadataSyncConfigInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedMetadataSyncConfigInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedMetadataSyncConfigInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedMetadataSyncConfigInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedMetadataSyncConfigInner.innerProperties = MetadataSyncConfigProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMetadataSyncConfigInner;
        });
    }
}
