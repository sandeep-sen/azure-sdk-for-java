// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A more specific scope used to identify the alerts to suppress.
 */
@Fluent
public final class ScopeElement implements JsonSerializable<ScopeElement> {
    /*
     * The alert entity type to suppress by.
     */
    private String field;

    /*
     * A more specific scope used to identify the alerts to suppress.
     */
    private Map<String, Object> additionalProperties;

    /**
     * Creates an instance of ScopeElement class.
     */
    public ScopeElement() {
    }

    /**
     * Get the field property: The alert entity type to suppress by.
     * 
     * @return the field value.
     */
    public String field() {
        return this.field;
    }

    /**
     * Set the field property: The alert entity type to suppress by.
     * 
     * @param field the field value to set.
     * @return the ScopeElement object itself.
     */
    public ScopeElement withField(String field) {
        this.field = field;
        return this;
    }

    /**
     * Get the additionalProperties property: A more specific scope used to identify the alerts to suppress.
     * 
     * @return the additionalProperties value.
     */
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: A more specific scope used to identify the alerts to suppress.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the ScopeElement object itself.
     */
    public ScopeElement withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
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
        jsonWriter.writeStringField("field", this.field);
        if (additionalProperties != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ScopeElement from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ScopeElement if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ScopeElement.
     */
    public static ScopeElement fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ScopeElement deserializedScopeElement = new ScopeElement();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("field".equals(fieldName)) {
                    deserializedScopeElement.field = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedScopeElement.additionalProperties = additionalProperties;

            return deserializedScopeElement;
        });
    }
}
