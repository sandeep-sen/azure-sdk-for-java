// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.fluent.models.ApplicationInner;
import java.io.IOException;
import java.util.List;

/**
 * Page of a security applications list.
 */
@Immutable
public final class ApplicationsList implements JsonSerializable<ApplicationsList> {
    /*
     * Collection of applications in this page
     */
    private List<ApplicationInner> value;

    /*
     * The URI to fetch the next page
     */
    private String nextLink;

    /**
     * Creates an instance of ApplicationsList class.
     */
    public ApplicationsList() {
    }

    /**
     * Get the value property: Collection of applications in this page.
     * 
     * @return the value value.
     */
    public List<ApplicationInner> value() {
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
     * Reads an instance of ApplicationsList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ApplicationsList if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ApplicationsList.
     */
    public static ApplicationsList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ApplicationsList deserializedApplicationsList = new ApplicationsList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<ApplicationInner> value = reader.readArray(reader1 -> ApplicationInner.fromJson(reader1));
                    deserializedApplicationsList.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedApplicationsList.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedApplicationsList;
        });
    }
}
