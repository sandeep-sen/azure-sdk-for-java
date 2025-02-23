// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.managednetworkfabric.fluent.models.NeighborGroupPatchProperties;
import java.io.IOException;
import java.util.Map;

/**
 * The Neighbor Group Patch definition.
 */
@Fluent
public final class NeighborGroupPatch extends TagsUpdate {
    /*
     * Neighbor Group Patch properties.
     */
    private NeighborGroupPatchProperties innerProperties;

    /**
     * Creates an instance of NeighborGroupPatch class.
     */
    public NeighborGroupPatch() {
    }

    /**
     * Get the innerProperties property: Neighbor Group Patch properties.
     * 
     * @return the innerProperties value.
     */
    private NeighborGroupPatchProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NeighborGroupPatch withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the destination property: An array of destination IPv4 Addresses or IPv6 Addresses.
     * 
     * @return the destination value.
     */
    public NeighborGroupDestination destination() {
        return this.innerProperties() == null ? null : this.innerProperties().destination();
    }

    /**
     * Set the destination property: An array of destination IPv4 Addresses or IPv6 Addresses.
     * 
     * @param destination the destination value to set.
     * @return the NeighborGroupPatch object itself.
     */
    public NeighborGroupPatch withDestination(NeighborGroupDestination destination) {
        if (this.innerProperties() == null) {
            this.innerProperties = new NeighborGroupPatchProperties();
        }
        this.innerProperties().withDestination(destination);
        return this;
    }

    /**
     * Get the annotation property: Switch configuration description.
     * 
     * @return the annotation value.
     */
    public String annotation() {
        return this.innerProperties() == null ? null : this.innerProperties().annotation();
    }

    /**
     * Set the annotation property: Switch configuration description.
     * 
     * @param annotation the annotation value to set.
     * @return the NeighborGroupPatch object itself.
     */
    public NeighborGroupPatch withAnnotation(String annotation) {
        if (this.innerProperties() == null) {
            this.innerProperties = new NeighborGroupPatchProperties();
        }
        this.innerProperties().withAnnotation(annotation);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
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
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NeighborGroupPatch from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NeighborGroupPatch if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the NeighborGroupPatch.
     */
    public static NeighborGroupPatch fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NeighborGroupPatch deserializedNeighborGroupPatch = new NeighborGroupPatch();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedNeighborGroupPatch.withTags(tags);
                } else if ("properties".equals(fieldName)) {
                    deserializedNeighborGroupPatch.innerProperties = NeighborGroupPatchProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNeighborGroupPatch;
        });
    }
}
