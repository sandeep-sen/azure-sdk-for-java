// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The CSPM monitoring for AWS offering.
 */
@Fluent
public final class CspmMonitorAwsOffering extends CloudOffering {
    /*
     * The type of the security offering.
     */
    private OfferingType offeringType = OfferingType.CSPM_MONITOR_AWS;

    /*
     * The native cloud connection configuration
     */
    private CspmMonitorAwsOfferingNativeCloudConnection nativeCloudConnection;

    /**
     * Creates an instance of CspmMonitorAwsOffering class.
     */
    public CspmMonitorAwsOffering() {
    }

    /**
     * Get the offeringType property: The type of the security offering.
     * 
     * @return the offeringType value.
     */
    @Override
    public OfferingType offeringType() {
        return this.offeringType;
    }

    /**
     * Get the nativeCloudConnection property: The native cloud connection configuration.
     * 
     * @return the nativeCloudConnection value.
     */
    public CspmMonitorAwsOfferingNativeCloudConnection nativeCloudConnection() {
        return this.nativeCloudConnection;
    }

    /**
     * Set the nativeCloudConnection property: The native cloud connection configuration.
     * 
     * @param nativeCloudConnection the nativeCloudConnection value to set.
     * @return the CspmMonitorAwsOffering object itself.
     */
    public CspmMonitorAwsOffering
        withNativeCloudConnection(CspmMonitorAwsOfferingNativeCloudConnection nativeCloudConnection) {
        this.nativeCloudConnection = nativeCloudConnection;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (nativeCloudConnection() != null) {
            nativeCloudConnection().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("offeringType", this.offeringType == null ? null : this.offeringType.toString());
        jsonWriter.writeJsonField("nativeCloudConnection", this.nativeCloudConnection);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CspmMonitorAwsOffering from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CspmMonitorAwsOffering if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the CspmMonitorAwsOffering.
     */
    public static CspmMonitorAwsOffering fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CspmMonitorAwsOffering deserializedCspmMonitorAwsOffering = new CspmMonitorAwsOffering();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("description".equals(fieldName)) {
                    deserializedCspmMonitorAwsOffering.withDescription(reader.getString());
                } else if ("offeringType".equals(fieldName)) {
                    deserializedCspmMonitorAwsOffering.offeringType = OfferingType.fromString(reader.getString());
                } else if ("nativeCloudConnection".equals(fieldName)) {
                    deserializedCspmMonitorAwsOffering.nativeCloudConnection
                        = CspmMonitorAwsOfferingNativeCloudConnection.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCspmMonitorAwsOffering;
        });
    }
}
