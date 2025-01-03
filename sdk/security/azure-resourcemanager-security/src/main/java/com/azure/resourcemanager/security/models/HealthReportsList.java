// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.fluent.models.HealthReportInner;
import java.io.IOException;
import java.util.List;

/**
 * Page of health reports list.
 */
@Immutable
public final class HealthReportsList implements JsonSerializable<HealthReportsList> {
    /*
     * Collection of health reports in this page
     */
    private List<HealthReportInner> value;

    /*
     * The URI to fetch the next page
     */
    private String nextLink;

    /**
     * Creates an instance of HealthReportsList class.
     */
    public HealthReportsList() {
    }

    /**
     * Get the value property: Collection of health reports in this page.
     * 
     * @return the value value.
     */
    public List<HealthReportInner> value() {
        return this.value;
    }

    /**
     * Get the nextLink property: The URI to fetch the next page.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of HealthReportsList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of HealthReportsList if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the HealthReportsList.
     */
    public static HealthReportsList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            HealthReportsList deserializedHealthReportsList = new HealthReportsList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<HealthReportInner> value = reader.readArray(reader1 -> HealthReportInner.fromJson(reader1));
                    deserializedHealthReportsList.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedHealthReportsList.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedHealthReportsList;
        });
    }
}
