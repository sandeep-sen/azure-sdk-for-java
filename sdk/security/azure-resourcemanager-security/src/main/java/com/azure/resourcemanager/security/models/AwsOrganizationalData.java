// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The AWS organization data.
 */
@Immutable
public class AwsOrganizationalData implements JsonSerializable<AwsOrganizationalData> {
    /*
     * The multi cloud account's membership type in the organization
     */
    private OrganizationMembershipType organizationMembershipType
        = OrganizationMembershipType.fromString("AwsOrganizationalData");

    /**
     * Creates an instance of AwsOrganizationalData class.
     */
    public AwsOrganizationalData() {
    }

    /**
     * Get the organizationMembershipType property: The multi cloud account's membership type in the organization.
     * 
     * @return the organizationMembershipType value.
     */
    public OrganizationMembershipType organizationMembershipType() {
        return this.organizationMembershipType;
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
        jsonWriter.writeStringField("organizationMembershipType",
            this.organizationMembershipType == null ? null : this.organizationMembershipType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AwsOrganizationalData from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AwsOrganizationalData if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AwsOrganizationalData.
     */
    public static AwsOrganizationalData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("organizationMembershipType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("Organization".equals(discriminatorValue)) {
                    return AwsOrganizationalDataMaster.fromJson(readerToUse.reset());
                } else if ("Member".equals(discriminatorValue)) {
                    return AwsOrganizationalDataMember.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static AwsOrganizationalData fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AwsOrganizationalData deserializedAwsOrganizationalData = new AwsOrganizationalData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("organizationMembershipType".equals(fieldName)) {
                    deserializedAwsOrganizationalData.organizationMembershipType
                        = OrganizationMembershipType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAwsOrganizationalData;
        });
    }
}
