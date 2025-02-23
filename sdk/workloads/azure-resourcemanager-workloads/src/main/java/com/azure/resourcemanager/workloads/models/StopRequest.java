// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.workloads.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Stop SAP instance(s) request body.
 */
@Fluent
public final class StopRequest implements JsonSerializable<StopRequest> {
    /*
     * This parameter defines how long (in seconds) the soft shutdown waits until the RFC/HTTP clients no longer
     * consider the server for calls with load balancing. Value 0 means that the kernel does not wait, but goes directly
     * into the next shutdown state, i.e. hard stop.
     */
    private Long softStopTimeoutSeconds;

    /**
     * Creates an instance of StopRequest class.
     */
    public StopRequest() {
    }

    /**
     * Get the softStopTimeoutSeconds property: This parameter defines how long (in seconds) the soft shutdown waits
     * until the RFC/HTTP clients no longer consider the server for calls with load balancing. Value 0 means that the
     * kernel does not wait, but goes directly into the next shutdown state, i.e. hard stop.
     * 
     * @return the softStopTimeoutSeconds value.
     */
    public Long softStopTimeoutSeconds() {
        return this.softStopTimeoutSeconds;
    }

    /**
     * Set the softStopTimeoutSeconds property: This parameter defines how long (in seconds) the soft shutdown waits
     * until the RFC/HTTP clients no longer consider the server for calls with load balancing. Value 0 means that the
     * kernel does not wait, but goes directly into the next shutdown state, i.e. hard stop.
     * 
     * @param softStopTimeoutSeconds the softStopTimeoutSeconds value to set.
     * @return the StopRequest object itself.
     */
    public StopRequest withSoftStopTimeoutSeconds(Long softStopTimeoutSeconds) {
        this.softStopTimeoutSeconds = softStopTimeoutSeconds;
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
        jsonWriter.writeNumberField("softStopTimeoutSeconds", this.softStopTimeoutSeconds);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of StopRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of StopRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the StopRequest.
     */
    public static StopRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            StopRequest deserializedStopRequest = new StopRequest();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("softStopTimeoutSeconds".equals(fieldName)) {
                    deserializedStopRequest.softStopTimeoutSeconds = reader.getNullable(JsonReader::getLong);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedStopRequest;
        });
    }
}
