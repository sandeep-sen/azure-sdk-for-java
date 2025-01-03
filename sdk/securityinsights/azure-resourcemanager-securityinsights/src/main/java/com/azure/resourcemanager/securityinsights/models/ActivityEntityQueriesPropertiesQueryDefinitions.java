// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The Activity query definitions.
 */
@Fluent
public final class ActivityEntityQueriesPropertiesQueryDefinitions
    implements JsonSerializable<ActivityEntityQueriesPropertiesQueryDefinitions> {
    /*
     * The Activity query to run on a given entity
     */
    private String query;

    /**
     * Creates an instance of ActivityEntityQueriesPropertiesQueryDefinitions class.
     */
    public ActivityEntityQueriesPropertiesQueryDefinitions() {
    }

    /**
     * Get the query property: The Activity query to run on a given entity.
     * 
     * @return the query value.
     */
    public String query() {
        return this.query;
    }

    /**
     * Set the query property: The Activity query to run on a given entity.
     * 
     * @param query the query value to set.
     * @return the ActivityEntityQueriesPropertiesQueryDefinitions object itself.
     */
    public ActivityEntityQueriesPropertiesQueryDefinitions withQuery(String query) {
        this.query = query;
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
        jsonWriter.writeStringField("query", this.query);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ActivityEntityQueriesPropertiesQueryDefinitions from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ActivityEntityQueriesPropertiesQueryDefinitions if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ActivityEntityQueriesPropertiesQueryDefinitions.
     */
    public static ActivityEntityQueriesPropertiesQueryDefinitions fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ActivityEntityQueriesPropertiesQueryDefinitions deserializedActivityEntityQueriesPropertiesQueryDefinitions
                = new ActivityEntityQueriesPropertiesQueryDefinitions();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("query".equals(fieldName)) {
                    deserializedActivityEntityQueriesPropertiesQueryDefinitions.query = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedActivityEntityQueriesPropertiesQueryDefinitions;
        });
    }
}
