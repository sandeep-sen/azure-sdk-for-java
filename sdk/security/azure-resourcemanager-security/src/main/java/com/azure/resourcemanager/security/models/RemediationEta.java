// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The ETA (estimated time of arrival) for remediation.
 */
@Fluent
public final class RemediationEta implements JsonSerializable<RemediationEta> {
    /*
     * ETA for remediation.
     */
    private OffsetDateTime eta;

    /*
     * Justification for change of Eta.
     */
    private String justification;

    /**
     * Creates an instance of RemediationEta class.
     */
    public RemediationEta() {
    }

    /**
     * Get the eta property: ETA for remediation.
     * 
     * @return the eta value.
     */
    public OffsetDateTime eta() {
        return this.eta;
    }

    /**
     * Set the eta property: ETA for remediation.
     * 
     * @param eta the eta value to set.
     * @return the RemediationEta object itself.
     */
    public RemediationEta withEta(OffsetDateTime eta) {
        this.eta = eta;
        return this;
    }

    /**
     * Get the justification property: Justification for change of Eta.
     * 
     * @return the justification value.
     */
    public String justification() {
        return this.justification;
    }

    /**
     * Set the justification property: Justification for change of Eta.
     * 
     * @param justification the justification value to set.
     * @return the RemediationEta object itself.
     */
    public RemediationEta withJustification(String justification) {
        this.justification = justification;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (eta() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property eta in model RemediationEta"));
        }
        if (justification() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property justification in model RemediationEta"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(RemediationEta.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("eta",
            this.eta == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.eta));
        jsonWriter.writeStringField("justification", this.justification);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RemediationEta from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RemediationEta if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RemediationEta.
     */
    public static RemediationEta fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RemediationEta deserializedRemediationEta = new RemediationEta();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("eta".equals(fieldName)) {
                    deserializedRemediationEta.eta = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("justification".equals(fieldName)) {
                    deserializedRemediationEta.justification = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRemediationEta;
        });
    }
}
