// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.apimanagement.fluent.models.LoggerUpdateParameters;
import java.io.IOException;
import java.util.Map;

/**
 * Logger update contract.
 */
@Fluent
public final class LoggerUpdateContract implements JsonSerializable<LoggerUpdateContract> {
    /*
     * Logger entity update contract properties.
     */
    private LoggerUpdateParameters innerProperties;

    /**
     * Creates an instance of LoggerUpdateContract class.
     */
    public LoggerUpdateContract() {
    }

    /**
     * Get the innerProperties property: Logger entity update contract properties.
     * 
     * @return the innerProperties value.
     */
    private LoggerUpdateParameters innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the loggerType property: Logger type.
     * 
     * @return the loggerType value.
     */
    public LoggerType loggerType() {
        return this.innerProperties() == null ? null : this.innerProperties().loggerType();
    }

    /**
     * Set the loggerType property: Logger type.
     * 
     * @param loggerType the loggerType value to set.
     * @return the LoggerUpdateContract object itself.
     */
    public LoggerUpdateContract withLoggerType(LoggerType loggerType) {
        if (this.innerProperties() == null) {
            this.innerProperties = new LoggerUpdateParameters();
        }
        this.innerProperties().withLoggerType(loggerType);
        return this;
    }

    /**
     * Get the description property: Logger description.
     * 
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Set the description property: Logger description.
     * 
     * @param description the description value to set.
     * @return the LoggerUpdateContract object itself.
     */
    public LoggerUpdateContract withDescription(String description) {
        if (this.innerProperties() == null) {
            this.innerProperties = new LoggerUpdateParameters();
        }
        this.innerProperties().withDescription(description);
        return this;
    }

    /**
     * Get the credentials property: Logger credentials.
     * 
     * @return the credentials value.
     */
    public Map<String, String> credentials() {
        return this.innerProperties() == null ? null : this.innerProperties().credentials();
    }

    /**
     * Set the credentials property: Logger credentials.
     * 
     * @param credentials the credentials value to set.
     * @return the LoggerUpdateContract object itself.
     */
    public LoggerUpdateContract withCredentials(Map<String, String> credentials) {
        if (this.innerProperties() == null) {
            this.innerProperties = new LoggerUpdateParameters();
        }
        this.innerProperties().withCredentials(credentials);
        return this;
    }

    /**
     * Get the isBuffered property: Whether records are buffered in the logger before publishing. Default is assumed to
     * be true.
     * 
     * @return the isBuffered value.
     */
    public Boolean isBuffered() {
        return this.innerProperties() == null ? null : this.innerProperties().isBuffered();
    }

    /**
     * Set the isBuffered property: Whether records are buffered in the logger before publishing. Default is assumed to
     * be true.
     * 
     * @param isBuffered the isBuffered value to set.
     * @return the LoggerUpdateContract object itself.
     */
    public LoggerUpdateContract withIsBuffered(Boolean isBuffered) {
        if (this.innerProperties() == null) {
            this.innerProperties = new LoggerUpdateParameters();
        }
        this.innerProperties().withIsBuffered(isBuffered);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LoggerUpdateContract from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LoggerUpdateContract if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the LoggerUpdateContract.
     */
    public static LoggerUpdateContract fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            LoggerUpdateContract deserializedLoggerUpdateContract = new LoggerUpdateContract();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedLoggerUpdateContract.innerProperties = LoggerUpdateParameters.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedLoggerUpdateContract;
        });
    }
}
