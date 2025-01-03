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
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The information type.
 */
@Fluent
public final class InformationType implements JsonSerializable<InformationType> {
    /*
     * The name of the information type.
     */
    private String displayName;

    /*
     * The description of the information type.
     */
    private String description;

    /*
     * The order of the information type.
     */
    private Integer order;

    /*
     * The recommended label id to be associated with this information type.
     */
    private UUID recommendedLabelId;

    /*
     * Indicates whether the information type is enabled or not.
     */
    private Boolean enabled;

    /*
     * Indicates whether the information type is custom or not.
     */
    private Boolean custom;

    /*
     * The information type keywords.
     */
    private List<InformationProtectionKeyword> keywords;

    /**
     * Creates an instance of InformationType class.
     */
    public InformationType() {
    }

    /**
     * Get the displayName property: The name of the information type.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: The name of the information type.
     * 
     * @param displayName the displayName value to set.
     * @return the InformationType object itself.
     */
    public InformationType withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the description property: The description of the information type.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The description of the information type.
     * 
     * @param description the description value to set.
     * @return the InformationType object itself.
     */
    public InformationType withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the order property: The order of the information type.
     * 
     * @return the order value.
     */
    public Integer order() {
        return this.order;
    }

    /**
     * Set the order property: The order of the information type.
     * 
     * @param order the order value to set.
     * @return the InformationType object itself.
     */
    public InformationType withOrder(Integer order) {
        this.order = order;
        return this;
    }

    /**
     * Get the recommendedLabelId property: The recommended label id to be associated with this information type.
     * 
     * @return the recommendedLabelId value.
     */
    public UUID recommendedLabelId() {
        return this.recommendedLabelId;
    }

    /**
     * Set the recommendedLabelId property: The recommended label id to be associated with this information type.
     * 
     * @param recommendedLabelId the recommendedLabelId value to set.
     * @return the InformationType object itself.
     */
    public InformationType withRecommendedLabelId(UUID recommendedLabelId) {
        this.recommendedLabelId = recommendedLabelId;
        return this;
    }

    /**
     * Get the enabled property: Indicates whether the information type is enabled or not.
     * 
     * @return the enabled value.
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: Indicates whether the information type is enabled or not.
     * 
     * @param enabled the enabled value to set.
     * @return the InformationType object itself.
     */
    public InformationType withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the custom property: Indicates whether the information type is custom or not.
     * 
     * @return the custom value.
     */
    public Boolean custom() {
        return this.custom;
    }

    /**
     * Set the custom property: Indicates whether the information type is custom or not.
     * 
     * @param custom the custom value to set.
     * @return the InformationType object itself.
     */
    public InformationType withCustom(Boolean custom) {
        this.custom = custom;
        return this;
    }

    /**
     * Get the keywords property: The information type keywords.
     * 
     * @return the keywords value.
     */
    public List<InformationProtectionKeyword> keywords() {
        return this.keywords;
    }

    /**
     * Set the keywords property: The information type keywords.
     * 
     * @param keywords the keywords value to set.
     * @return the InformationType object itself.
     */
    public InformationType withKeywords(List<InformationProtectionKeyword> keywords) {
        this.keywords = keywords;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (keywords() != null) {
            keywords().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("description", this.description);
        jsonWriter.writeNumberField("order", this.order);
        jsonWriter.writeStringField("recommendedLabelId", Objects.toString(this.recommendedLabelId, null));
        jsonWriter.writeBooleanField("enabled", this.enabled);
        jsonWriter.writeBooleanField("custom", this.custom);
        jsonWriter.writeArrayField("keywords", this.keywords, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of InformationType from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of InformationType if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the InformationType.
     */
    public static InformationType fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            InformationType deserializedInformationType = new InformationType();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("displayName".equals(fieldName)) {
                    deserializedInformationType.displayName = reader.getString();
                } else if ("description".equals(fieldName)) {
                    deserializedInformationType.description = reader.getString();
                } else if ("order".equals(fieldName)) {
                    deserializedInformationType.order = reader.getNullable(JsonReader::getInt);
                } else if ("recommendedLabelId".equals(fieldName)) {
                    deserializedInformationType.recommendedLabelId
                        = reader.getNullable(nonNullReader -> UUID.fromString(nonNullReader.getString()));
                } else if ("enabled".equals(fieldName)) {
                    deserializedInformationType.enabled = reader.getNullable(JsonReader::getBoolean);
                } else if ("custom".equals(fieldName)) {
                    deserializedInformationType.custom = reader.getNullable(JsonReader::getBoolean);
                } else if ("keywords".equals(fieldName)) {
                    List<InformationProtectionKeyword> keywords
                        = reader.readArray(reader1 -> InformationProtectionKeyword.fromJson(reader1));
                    deserializedInformationType.keywords = keywords;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedInformationType;
        });
    }
}
