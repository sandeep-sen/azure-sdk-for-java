// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.models.State;
import java.io.IOException;

/**
 * Regulatory compliance control details and state.
 */
@Fluent
public final class RegulatoryComplianceControlInner extends ProxyResource {
    /*
     * Regulatory compliance control data
     */
    private RegulatoryComplianceControlProperties innerProperties;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of RegulatoryComplianceControlInner class.
     */
    public RegulatoryComplianceControlInner() {
    }

    /**
     * Get the innerProperties property: Regulatory compliance control data.
     * 
     * @return the innerProperties value.
     */
    private RegulatoryComplianceControlProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Get the description property: The description of the regulatory compliance control.
     * 
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Get the state property: Aggregative state based on the control's supported assessments states.
     * 
     * @return the state value.
     */
    public State state() {
        return this.innerProperties() == null ? null : this.innerProperties().state();
    }

    /**
     * Set the state property: Aggregative state based on the control's supported assessments states.
     * 
     * @param state the state value to set.
     * @return the RegulatoryComplianceControlInner object itself.
     */
    public RegulatoryComplianceControlInner withState(State state) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RegulatoryComplianceControlProperties();
        }
        this.innerProperties().withState(state);
        return this;
    }

    /**
     * Get the passedAssessments property: The number of supported regulatory compliance assessments of the given
     * control with a passed state.
     * 
     * @return the passedAssessments value.
     */
    public Integer passedAssessments() {
        return this.innerProperties() == null ? null : this.innerProperties().passedAssessments();
    }

    /**
     * Get the failedAssessments property: The number of supported regulatory compliance assessments of the given
     * control with a failed state.
     * 
     * @return the failedAssessments value.
     */
    public Integer failedAssessments() {
        return this.innerProperties() == null ? null : this.innerProperties().failedAssessments();
    }

    /**
     * Get the skippedAssessments property: The number of supported regulatory compliance assessments of the given
     * control with a skipped state.
     * 
     * @return the skippedAssessments value.
     */
    public Integer skippedAssessments() {
        return this.innerProperties() == null ? null : this.innerProperties().skippedAssessments();
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
     * Reads an instance of RegulatoryComplianceControlInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RegulatoryComplianceControlInner if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RegulatoryComplianceControlInner.
     */
    public static RegulatoryComplianceControlInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RegulatoryComplianceControlInner deserializedRegulatoryComplianceControlInner
                = new RegulatoryComplianceControlInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedRegulatoryComplianceControlInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedRegulatoryComplianceControlInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedRegulatoryComplianceControlInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedRegulatoryComplianceControlInner.innerProperties
                        = RegulatoryComplianceControlProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRegulatoryComplianceControlInner;
        });
    }
}
