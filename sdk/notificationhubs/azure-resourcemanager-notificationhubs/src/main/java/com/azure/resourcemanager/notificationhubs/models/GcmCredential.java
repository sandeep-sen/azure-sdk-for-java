// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.notificationhubs.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.notificationhubs.fluent.models.GcmCredentialProperties;
import java.io.IOException;

/**
 * Description of a NotificationHub GcmCredential.
 */
@Fluent
public final class GcmCredential implements JsonSerializable<GcmCredential> {
    /*
     * Description of a NotificationHub GcmCredential.
     */
    private GcmCredentialProperties innerProperties = new GcmCredentialProperties();

    /**
     * Creates an instance of GcmCredential class.
     */
    public GcmCredential() {
    }

    /**
     * Get the innerProperties property: Description of a NotificationHub GcmCredential.
     * 
     * @return the innerProperties value.
     */
    private GcmCredentialProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the gcmEndpoint property: Gets or sets the GCM endpoint.
     * 
     * @return the gcmEndpoint value.
     */
    public String gcmEndpoint() {
        return this.innerProperties() == null ? null : this.innerProperties().gcmEndpoint();
    }

    /**
     * Set the gcmEndpoint property: Gets or sets the GCM endpoint.
     * 
     * @param gcmEndpoint the gcmEndpoint value to set.
     * @return the GcmCredential object itself.
     */
    public GcmCredential withGcmEndpoint(String gcmEndpoint) {
        if (this.innerProperties() == null) {
            this.innerProperties = new GcmCredentialProperties();
        }
        this.innerProperties().withGcmEndpoint(gcmEndpoint);
        return this;
    }

    /**
     * Get the googleApiKey property: Gets or sets the Google API key.
     * 
     * @return the googleApiKey value.
     */
    public String googleApiKey() {
        return this.innerProperties() == null ? null : this.innerProperties().googleApiKey();
    }

    /**
     * Set the googleApiKey property: Gets or sets the Google API key.
     * 
     * @param googleApiKey the googleApiKey value to set.
     * @return the GcmCredential object itself.
     */
    public GcmCredential withGoogleApiKey(String googleApiKey) {
        if (this.innerProperties() == null) {
            this.innerProperties = new GcmCredentialProperties();
        }
        this.innerProperties().withGoogleApiKey(googleApiKey);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property innerProperties in model GcmCredential"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(GcmCredential.class);

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
     * Reads an instance of GcmCredential from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GcmCredential if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GcmCredential.
     */
    public static GcmCredential fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GcmCredential deserializedGcmCredential = new GcmCredential();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedGcmCredential.innerProperties = GcmCredentialProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGcmCredential;
        });
    }
}
