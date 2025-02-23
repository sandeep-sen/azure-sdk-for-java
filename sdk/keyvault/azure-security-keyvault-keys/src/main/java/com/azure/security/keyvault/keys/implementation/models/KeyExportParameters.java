// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.security.keyvault.keys.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.security.keyvault.keys.models.KeyExportEncryptionAlgorithm;
import java.io.IOException;

/**
 * The export key parameters.
 */
@Fluent
public final class KeyExportParameters implements JsonSerializable<KeyExportParameters> {
    /*
     * The export key encryption Json web key. This key MUST be a RSA key that supports encryption.
     */
    private JsonWebKey wrappingKey;

    /*
     * The export key encryption key identifier. This key MUST be a RSA key that supports encryption.
     */
    private String wrappingKid;

    /*
     * The encryption algorithm to use to protected the exported key material
     */
    private KeyExportEncryptionAlgorithm enc;

    /**
     * Creates an instance of KeyExportParameters class.
     */
    public KeyExportParameters() {
    }

    /**
     * Get the wrappingKey property: The export key encryption Json web key. This key MUST be a RSA key that supports
     * encryption.
     * 
     * @return the wrappingKey value.
     */
    public JsonWebKey getWrappingKey() {
        return this.wrappingKey;
    }

    /**
     * Set the wrappingKey property: The export key encryption Json web key. This key MUST be a RSA key that supports
     * encryption.
     * 
     * @param wrappingKey the wrappingKey value to set.
     * @return the KeyExportParameters object itself.
     */
    public KeyExportParameters setWrappingKey(JsonWebKey wrappingKey) {
        this.wrappingKey = wrappingKey;
        return this;
    }

    /**
     * Get the wrappingKid property: The export key encryption key identifier. This key MUST be a RSA key that supports
     * encryption.
     * 
     * @return the wrappingKid value.
     */
    public String getWrappingKid() {
        return this.wrappingKid;
    }

    /**
     * Set the wrappingKid property: The export key encryption key identifier. This key MUST be a RSA key that supports
     * encryption.
     * 
     * @param wrappingKid the wrappingKid value to set.
     * @return the KeyExportParameters object itself.
     */
    public KeyExportParameters setWrappingKid(String wrappingKid) {
        this.wrappingKid = wrappingKid;
        return this;
    }

    /**
     * Get the enc property: The encryption algorithm to use to protected the exported key material.
     * 
     * @return the enc value.
     */
    public KeyExportEncryptionAlgorithm getEnc() {
        return this.enc;
    }

    /**
     * Set the enc property: The encryption algorithm to use to protected the exported key material.
     * 
     * @param enc the enc value to set.
     * @return the KeyExportParameters object itself.
     */
    public KeyExportParameters setEnc(KeyExportEncryptionAlgorithm enc) {
        this.enc = enc;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("wrappingKey", this.wrappingKey);
        jsonWriter.writeStringField("wrappingKid", this.wrappingKid);
        jsonWriter.writeStringField("enc", this.enc == null ? null : this.enc.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of KeyExportParameters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of KeyExportParameters if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the KeyExportParameters.
     */
    public static KeyExportParameters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            KeyExportParameters deserializedKeyExportParameters = new KeyExportParameters();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("wrappingKey".equals(fieldName)) {
                    deserializedKeyExportParameters.wrappingKey = JsonWebKey.fromJson(reader);
                } else if ("wrappingKid".equals(fieldName)) {
                    deserializedKeyExportParameters.wrappingKid = reader.getString();
                } else if ("enc".equals(fieldName)) {
                    deserializedKeyExportParameters.enc = KeyExportEncryptionAlgorithm.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedKeyExportParameters;
        });
    }
}
