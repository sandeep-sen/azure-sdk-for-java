// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Update the administrative state on list of resources.
 */
@Fluent
public final class UpdateDeviceAdministrativeState extends EnableDisableOnResources {
    /*
     * Administrative state.
     */
    private DeviceAdministrativeState state;

    /**
     * Creates an instance of UpdateDeviceAdministrativeState class.
     */
    public UpdateDeviceAdministrativeState() {
    }

    /**
     * Get the state property: Administrative state.
     * 
     * @return the state value.
     */
    public DeviceAdministrativeState state() {
        return this.state;
    }

    /**
     * Set the state property: Administrative state.
     * 
     * @param state the state value to set.
     * @return the UpdateDeviceAdministrativeState object itself.
     */
    public UpdateDeviceAdministrativeState withState(DeviceAdministrativeState state) {
        this.state = state;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateDeviceAdministrativeState withResourceIds(List<String> resourceIds) {
        super.withResourceIds(resourceIds);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("resourceIds", resourceIds(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("state", this.state == null ? null : this.state.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of UpdateDeviceAdministrativeState from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of UpdateDeviceAdministrativeState if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the UpdateDeviceAdministrativeState.
     */
    public static UpdateDeviceAdministrativeState fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            UpdateDeviceAdministrativeState deserializedUpdateDeviceAdministrativeState
                = new UpdateDeviceAdministrativeState();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("resourceIds".equals(fieldName)) {
                    List<String> resourceIds = reader.readArray(reader1 -> reader1.getString());
                    deserializedUpdateDeviceAdministrativeState.withResourceIds(resourceIds);
                } else if ("state".equals(fieldName)) {
                    deserializedUpdateDeviceAdministrativeState.state
                        = DeviceAdministrativeState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedUpdateDeviceAdministrativeState;
        });
    }
}
