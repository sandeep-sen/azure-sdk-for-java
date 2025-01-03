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
 * Regulatory compliance assessment details and state.
 */
@Fluent
public final class RegulatoryComplianceAssessmentInner extends ProxyResource {
    /*
     * Regulatory compliance assessment data
     */
    private RegulatoryComplianceAssessmentProperties innerProperties;

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
     * Creates an instance of RegulatoryComplianceAssessmentInner class.
     */
    public RegulatoryComplianceAssessmentInner() {
    }

    /**
     * Get the innerProperties property: Regulatory compliance assessment data.
     * 
     * @return the innerProperties value.
     */
    private RegulatoryComplianceAssessmentProperties innerProperties() {
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
     * Get the description property: The description of the regulatory compliance assessment.
     * 
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Get the assessmentType property: The expected type of assessment contained in the AssessmentDetailsLink.
     * 
     * @return the assessmentType value.
     */
    public String assessmentType() {
        return this.innerProperties() == null ? null : this.innerProperties().assessmentType();
    }

    /**
     * Get the assessmentDetailsLink property: Link to more detailed assessment results data. The response type will be
     * according to the assessmentType field.
     * 
     * @return the assessmentDetailsLink value.
     */
    public String assessmentDetailsLink() {
        return this.innerProperties() == null ? null : this.innerProperties().assessmentDetailsLink();
    }

    /**
     * Get the state property: Aggregative state based on the assessment's scanned resources states.
     * 
     * @return the state value.
     */
    public State state() {
        return this.innerProperties() == null ? null : this.innerProperties().state();
    }

    /**
     * Set the state property: Aggregative state based on the assessment's scanned resources states.
     * 
     * @param state the state value to set.
     * @return the RegulatoryComplianceAssessmentInner object itself.
     */
    public RegulatoryComplianceAssessmentInner withState(State state) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RegulatoryComplianceAssessmentProperties();
        }
        this.innerProperties().withState(state);
        return this;
    }

    /**
     * Get the passedResources property: The given assessment's related resources count with passed state.
     * 
     * @return the passedResources value.
     */
    public Integer passedResources() {
        return this.innerProperties() == null ? null : this.innerProperties().passedResources();
    }

    /**
     * Get the failedResources property: The given assessment's related resources count with failed state.
     * 
     * @return the failedResources value.
     */
    public Integer failedResources() {
        return this.innerProperties() == null ? null : this.innerProperties().failedResources();
    }

    /**
     * Get the skippedResources property: The given assessment's related resources count with skipped state.
     * 
     * @return the skippedResources value.
     */
    public Integer skippedResources() {
        return this.innerProperties() == null ? null : this.innerProperties().skippedResources();
    }

    /**
     * Get the unsupportedResources property: The given assessment's related resources count with unsupported state.
     * 
     * @return the unsupportedResources value.
     */
    public Integer unsupportedResources() {
        return this.innerProperties() == null ? null : this.innerProperties().unsupportedResources();
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
     * Reads an instance of RegulatoryComplianceAssessmentInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RegulatoryComplianceAssessmentInner if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RegulatoryComplianceAssessmentInner.
     */
    public static RegulatoryComplianceAssessmentInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RegulatoryComplianceAssessmentInner deserializedRegulatoryComplianceAssessmentInner
                = new RegulatoryComplianceAssessmentInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedRegulatoryComplianceAssessmentInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedRegulatoryComplianceAssessmentInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedRegulatoryComplianceAssessmentInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedRegulatoryComplianceAssessmentInner.innerProperties
                        = RegulatoryComplianceAssessmentProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRegulatoryComplianceAssessmentInner;
        });
    }
}
