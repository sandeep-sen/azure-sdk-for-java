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
 * Details of the sub-assessment.
 */
@Immutable
public class AdditionalData implements JsonSerializable<AdditionalData> {
    /*
     * Sub-assessment resource type
     */
    private AssessedResourceType assessedResourceType = AssessedResourceType.fromString("AdditionalData");

    /**
     * Creates an instance of AdditionalData class.
     */
    public AdditionalData() {
    }

    /**
     * Get the assessedResourceType property: Sub-assessment resource type.
     * 
     * @return the assessedResourceType value.
     */
    public AssessedResourceType assessedResourceType() {
        return this.assessedResourceType;
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
        jsonWriter.writeStringField("assessedResourceType",
            this.assessedResourceType == null ? null : this.assessedResourceType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AdditionalData from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AdditionalData if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the AdditionalData.
     */
    public static AdditionalData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("assessedResourceType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("SqlServerVulnerability".equals(discriminatorValue)) {
                    return SqlServerVulnerabilityProperties.fromJson(readerToUse.reset());
                } else if ("ContainerRegistryVulnerability".equals(discriminatorValue)) {
                    return ContainerRegistryVulnerabilityProperties.fromJson(readerToUse.reset());
                } else if ("ServerVulnerabilityAssessment".equals(discriminatorValue)) {
                    return ServerVulnerabilityProperties.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static AdditionalData fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AdditionalData deserializedAdditionalData = new AdditionalData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("assessedResourceType".equals(fieldName)) {
                    deserializedAdditionalData.assessedResourceType
                        = AssessedResourceType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAdditionalData;
        });
    }
}
