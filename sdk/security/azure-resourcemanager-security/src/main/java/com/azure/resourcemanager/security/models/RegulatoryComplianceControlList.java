// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.fluent.models.RegulatoryComplianceControlInner;
import java.io.IOException;
import java.util.List;

/**
 * List of regulatory compliance controls response.
 */
@Fluent
public final class RegulatoryComplianceControlList implements JsonSerializable<RegulatoryComplianceControlList> {
    /*
     * List of regulatory compliance controls
     */
    private List<RegulatoryComplianceControlInner> value;

    /*
     * The URI to fetch the next page.
     */
    private String nextLink;

    /**
     * Creates an instance of RegulatoryComplianceControlList class.
     */
    public RegulatoryComplianceControlList() {
    }

    /**
     * Get the value property: List of regulatory compliance controls.
     * 
     * @return the value value.
     */
    public List<RegulatoryComplianceControlInner> value() {
        return this.value;
    }

    /**
     * Set the value property: List of regulatory compliance controls.
     * 
     * @param value the value value to set.
     * @return the RegulatoryComplianceControlList object itself.
     */
    public RegulatoryComplianceControlList withValue(List<RegulatoryComplianceControlInner> value) {
        this.value = value;
        return this;
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
        if (value() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property value in model RegulatoryComplianceControlList"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(RegulatoryComplianceControlList.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RegulatoryComplianceControlList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RegulatoryComplianceControlList if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RegulatoryComplianceControlList.
     */
    public static RegulatoryComplianceControlList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RegulatoryComplianceControlList deserializedRegulatoryComplianceControlList
                = new RegulatoryComplianceControlList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<RegulatoryComplianceControlInner> value
                        = reader.readArray(reader1 -> RegulatoryComplianceControlInner.fromJson(reader1));
                    deserializedRegulatoryComplianceControlList.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedRegulatoryComplianceControlList.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRegulatoryComplianceControlList;
        });
    }
}
