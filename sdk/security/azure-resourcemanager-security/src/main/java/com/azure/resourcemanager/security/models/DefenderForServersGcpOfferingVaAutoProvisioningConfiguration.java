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

/**
 * configuration for Vulnerability Assessment autoprovisioning.
 */
@Fluent
public final class DefenderForServersGcpOfferingVaAutoProvisioningConfiguration
    implements JsonSerializable<DefenderForServersGcpOfferingVaAutoProvisioningConfiguration> {
    /*
     * The Vulnerability Assessment solution to be provisioned. Can be either 'TVM' or 'Qualys'
     */
    private Type type;

    /**
     * Creates an instance of DefenderForServersGcpOfferingVaAutoProvisioningConfiguration class.
     */
    public DefenderForServersGcpOfferingVaAutoProvisioningConfiguration() {
    }

    /**
     * Get the type property: The Vulnerability Assessment solution to be provisioned. Can be either 'TVM' or 'Qualys'.
     * 
     * @return the type value.
     */
    public Type type() {
        return this.type;
    }

    /**
     * Set the type property: The Vulnerability Assessment solution to be provisioned. Can be either 'TVM' or 'Qualys'.
     * 
     * @param type the type value to set.
     * @return the DefenderForServersGcpOfferingVaAutoProvisioningConfiguration object itself.
     */
    public DefenderForServersGcpOfferingVaAutoProvisioningConfiguration withType(Type type) {
        this.type = type;
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
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DefenderForServersGcpOfferingVaAutoProvisioningConfiguration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DefenderForServersGcpOfferingVaAutoProvisioningConfiguration if the JsonReader was
     * pointing to an instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the
     * DefenderForServersGcpOfferingVaAutoProvisioningConfiguration.
     */
    public static DefenderForServersGcpOfferingVaAutoProvisioningConfiguration fromJson(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            DefenderForServersGcpOfferingVaAutoProvisioningConfiguration deserializedDefenderForServersGcpOfferingVaAutoProvisioningConfiguration
                = new DefenderForServersGcpOfferingVaAutoProvisioningConfiguration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedDefenderForServersGcpOfferingVaAutoProvisioningConfiguration.type
                        = Type.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDefenderForServersGcpOfferingVaAutoProvisioningConfiguration;
        });
    }
}
