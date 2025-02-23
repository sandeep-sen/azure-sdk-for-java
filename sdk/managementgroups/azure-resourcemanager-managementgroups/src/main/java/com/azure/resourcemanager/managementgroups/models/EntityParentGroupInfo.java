// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managementgroups.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * (Optional) The ID of the parent management group.
 */
@Fluent
public final class EntityParentGroupInfo implements JsonSerializable<EntityParentGroupInfo> {
    /*
     * The fully qualified ID for the parent management group. For example,
     * /providers/Microsoft.Management/managementGroups/0000000-0000-0000-0000-000000000000
     */
    private String id;

    /**
     * Creates an instance of EntityParentGroupInfo class.
     */
    public EntityParentGroupInfo() {
    }

    /**
     * Get the id property: The fully qualified ID for the parent management group. For example,
     * /providers/Microsoft.Management/managementGroups/0000000-0000-0000-0000-000000000000.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: The fully qualified ID for the parent management group. For example,
     * /providers/Microsoft.Management/managementGroups/0000000-0000-0000-0000-000000000000.
     * 
     * @param id the id value to set.
     * @return the EntityParentGroupInfo object itself.
     */
    public EntityParentGroupInfo withId(String id) {
        this.id = id;
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
        jsonWriter.writeStringField("id", this.id);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of EntityParentGroupInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of EntityParentGroupInfo if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the EntityParentGroupInfo.
     */
    public static EntityParentGroupInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            EntityParentGroupInfo deserializedEntityParentGroupInfo = new EntityParentGroupInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedEntityParentGroupInfo.id = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedEntityParentGroupInfo;
        });
    }
}
