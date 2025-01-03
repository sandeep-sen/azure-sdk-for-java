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
 * The sensitivity label.
 */
@Fluent
public final class SensitivityLabel implements JsonSerializable<SensitivityLabel> {
    /*
     * The name of the sensitivity label.
     */
    private String displayName;

    /*
     * The description of the sensitivity label.
     */
    private String description;

    /*
     * The rank of the sensitivity label.
     */
    private Rank rank;

    /*
     * The order of the sensitivity label.
     */
    private Integer order;

    /*
     * Indicates whether the label is enabled or not.
     */
    private Boolean enabled;

    /**
     * Creates an instance of SensitivityLabel class.
     */
    public SensitivityLabel() {
    }

    /**
     * Get the displayName property: The name of the sensitivity label.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: The name of the sensitivity label.
     * 
     * @param displayName the displayName value to set.
     * @return the SensitivityLabel object itself.
     */
    public SensitivityLabel withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the description property: The description of the sensitivity label.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The description of the sensitivity label.
     * 
     * @param description the description value to set.
     * @return the SensitivityLabel object itself.
     */
    public SensitivityLabel withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the rank property: The rank of the sensitivity label.
     * 
     * @return the rank value.
     */
    public Rank rank() {
        return this.rank;
    }

    /**
     * Set the rank property: The rank of the sensitivity label.
     * 
     * @param rank the rank value to set.
     * @return the SensitivityLabel object itself.
     */
    public SensitivityLabel withRank(Rank rank) {
        this.rank = rank;
        return this;
    }

    /**
     * Get the order property: The order of the sensitivity label.
     * 
     * @return the order value.
     */
    public Integer order() {
        return this.order;
    }

    /**
     * Set the order property: The order of the sensitivity label.
     * 
     * @param order the order value to set.
     * @return the SensitivityLabel object itself.
     */
    public SensitivityLabel withOrder(Integer order) {
        this.order = order;
        return this;
    }

    /**
     * Get the enabled property: Indicates whether the label is enabled or not.
     * 
     * @return the enabled value.
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: Indicates whether the label is enabled or not.
     * 
     * @param enabled the enabled value to set.
     * @return the SensitivityLabel object itself.
     */
    public SensitivityLabel withEnabled(Boolean enabled) {
        this.enabled = enabled;
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
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("description", this.description);
        jsonWriter.writeStringField("rank", this.rank == null ? null : this.rank.toString());
        jsonWriter.writeNumberField("order", this.order);
        jsonWriter.writeBooleanField("enabled", this.enabled);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SensitivityLabel from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SensitivityLabel if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the SensitivityLabel.
     */
    public static SensitivityLabel fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SensitivityLabel deserializedSensitivityLabel = new SensitivityLabel();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("displayName".equals(fieldName)) {
                    deserializedSensitivityLabel.displayName = reader.getString();
                } else if ("description".equals(fieldName)) {
                    deserializedSensitivityLabel.description = reader.getString();
                } else if ("rank".equals(fieldName)) {
                    deserializedSensitivityLabel.rank = Rank.fromString(reader.getString());
                } else if ("order".equals(fieldName)) {
                    deserializedSensitivityLabel.order = reader.getNullable(JsonReader::getInt);
                } else if ("enabled".equals(fieldName)) {
                    deserializedSensitivityLabel.enabled = reader.getNullable(JsonReader::getBoolean);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSensitivityLabel;
        });
    }
}
