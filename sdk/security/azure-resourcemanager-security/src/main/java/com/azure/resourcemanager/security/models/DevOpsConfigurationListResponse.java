// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.fluent.models.DevOpsConfigurationInner;
import java.io.IOException;
import java.util.List;

/**
 * List of RP resources which supports pagination.
 */
@Fluent
public final class DevOpsConfigurationListResponse implements JsonSerializable<DevOpsConfigurationListResponse> {
    /*
     * Gets or sets list of resources.
     */
    private List<DevOpsConfigurationInner> value;

    /*
     * Gets or sets next link to scroll over the results.
     */
    private String nextLink;

    /**
     * Creates an instance of DevOpsConfigurationListResponse class.
     */
    public DevOpsConfigurationListResponse() {
    }

    /**
     * Get the value property: Gets or sets list of resources.
     * 
     * @return the value value.
     */
    public List<DevOpsConfigurationInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Gets or sets list of resources.
     * 
     * @param value the value value to set.
     * @return the DevOpsConfigurationListResponse object itself.
     */
    public DevOpsConfigurationListResponse withValue(List<DevOpsConfigurationInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Gets or sets next link to scroll over the results.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Gets or sets next link to scroll over the results.
     * 
     * @param nextLink the nextLink value to set.
     * @return the DevOpsConfigurationListResponse object itself.
     */
    public DevOpsConfigurationListResponse withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("nextLink", this.nextLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DevOpsConfigurationListResponse from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DevOpsConfigurationListResponse if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DevOpsConfigurationListResponse.
     */
    public static DevOpsConfigurationListResponse fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DevOpsConfigurationListResponse deserializedDevOpsConfigurationListResponse
                = new DevOpsConfigurationListResponse();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<DevOpsConfigurationInner> value
                        = reader.readArray(reader1 -> DevOpsConfigurationInner.fromJson(reader1));
                    deserializedDevOpsConfigurationListResponse.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedDevOpsConfigurationListResponse.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDevOpsConfigurationListResponse;
        });
    }
}
