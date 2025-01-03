// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The live event metadata insertion endpoint.
 */
@Fluent
public final class LiveEventTimedMetadataEndpoint implements JsonSerializable<LiveEventTimedMetadataEndpoint> {
    /*
     * The metadata endpoint URL.
     */
    private String url;

    /**
     * Creates an instance of LiveEventTimedMetadataEndpoint class.
     */
    public LiveEventTimedMetadataEndpoint() {
    }

    /**
     * Get the url property: The metadata endpoint URL.
     * 
     * @return the url value.
     */
    public String url() {
        return this.url;
    }

    /**
     * Set the url property: The metadata endpoint URL.
     * 
     * @param url the url value to set.
     * @return the LiveEventTimedMetadataEndpoint object itself.
     */
    public LiveEventTimedMetadataEndpoint withUrl(String url) {
        this.url = url;
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
        jsonWriter.writeStringField("url", this.url);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LiveEventTimedMetadataEndpoint from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LiveEventTimedMetadataEndpoint if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the LiveEventTimedMetadataEndpoint.
     */
    public static LiveEventTimedMetadataEndpoint fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            LiveEventTimedMetadataEndpoint deserializedLiveEventTimedMetadataEndpoint
                = new LiveEventTimedMetadataEndpoint();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("url".equals(fieldName)) {
                    deserializedLiveEventTimedMetadataEndpoint.url = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedLiveEventTimedMetadataEndpoint;
        });
    }
}
