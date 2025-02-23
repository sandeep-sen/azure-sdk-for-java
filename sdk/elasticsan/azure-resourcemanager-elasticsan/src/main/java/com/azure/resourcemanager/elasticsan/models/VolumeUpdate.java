// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.elasticsan.fluent.models.VolumeUpdateProperties;
import java.io.IOException;

/**
 * Response for Volume request.
 */
@Fluent
public final class VolumeUpdate implements JsonSerializable<VolumeUpdate> {
    /*
     * Properties of Volume.
     */
    private VolumeUpdateProperties innerProperties;

    /**
     * Creates an instance of VolumeUpdate class.
     */
    public VolumeUpdate() {
    }

    /**
     * Get the innerProperties property: Properties of Volume.
     * 
     * @return the innerProperties value.
     */
    private VolumeUpdateProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the sizeGiB property: Volume size.
     * 
     * @return the sizeGiB value.
     */
    public Long sizeGiB() {
        return this.innerProperties() == null ? null : this.innerProperties().sizeGiB();
    }

    /**
     * Set the sizeGiB property: Volume size.
     * 
     * @param sizeGiB the sizeGiB value to set.
     * @return the VolumeUpdate object itself.
     */
    public VolumeUpdate withSizeGiB(Long sizeGiB) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VolumeUpdateProperties();
        }
        this.innerProperties().withSizeGiB(sizeGiB);
        return this;
    }

    /**
     * Get the managedBy property: Parent resource information.
     * 
     * @return the managedBy value.
     */
    public ManagedByInfo managedBy() {
        return this.innerProperties() == null ? null : this.innerProperties().managedBy();
    }

    /**
     * Set the managedBy property: Parent resource information.
     * 
     * @param managedBy the managedBy value to set.
     * @return the VolumeUpdate object itself.
     */
    public VolumeUpdate withManagedBy(ManagedByInfo managedBy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VolumeUpdateProperties();
        }
        this.innerProperties().withManagedBy(managedBy);
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
     * Reads an instance of VolumeUpdate from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of VolumeUpdate if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the VolumeUpdate.
     */
    public static VolumeUpdate fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            VolumeUpdate deserializedVolumeUpdate = new VolumeUpdate();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedVolumeUpdate.innerProperties = VolumeUpdateProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedVolumeUpdate;
        });
    }
}
