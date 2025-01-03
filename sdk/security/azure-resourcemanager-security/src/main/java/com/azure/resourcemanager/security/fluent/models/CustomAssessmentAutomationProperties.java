// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.models.SeverityEnum;
import com.azure.resourcemanager.security.models.SupportedCloudEnum;
import java.io.IOException;

/**
 * describes the Custom Assessment Automation properties.
 */
@Fluent
public final class CustomAssessmentAutomationProperties
    implements JsonSerializable<CustomAssessmentAutomationProperties> {
    /*
     * GZip encoded KQL query representing the assessment automation results required.
     */
    private String compressedQuery;

    /*
     * Relevant cloud for the custom assessment automation.
     */
    private SupportedCloudEnum supportedCloud = SupportedCloudEnum.AWS;

    /*
     * The severity to relate to the assessments generated by this assessment automation.
     */
    private SeverityEnum severity = SeverityEnum.LOW;

    /*
     * The display name of the assessments generated by this assessment automation.
     */
    private String displayName;

    /*
     * The description to relate to the assessments generated by this assessment automation.
     */
    private String description;

    /*
     * The remediation description to relate to the assessments generated by this assessment automation.
     */
    private String remediationDescription;

    /*
     * The assessment metadata key used when an assessment is generated for this assessment automation.
     */
    private String assessmentKey;

    /**
     * Creates an instance of CustomAssessmentAutomationProperties class.
     */
    public CustomAssessmentAutomationProperties() {
    }

    /**
     * Get the compressedQuery property: GZip encoded KQL query representing the assessment automation results required.
     * 
     * @return the compressedQuery value.
     */
    public String compressedQuery() {
        return this.compressedQuery;
    }

    /**
     * Set the compressedQuery property: GZip encoded KQL query representing the assessment automation results required.
     * 
     * @param compressedQuery the compressedQuery value to set.
     * @return the CustomAssessmentAutomationProperties object itself.
     */
    public CustomAssessmentAutomationProperties withCompressedQuery(String compressedQuery) {
        this.compressedQuery = compressedQuery;
        return this;
    }

    /**
     * Get the supportedCloud property: Relevant cloud for the custom assessment automation.
     * 
     * @return the supportedCloud value.
     */
    public SupportedCloudEnum supportedCloud() {
        return this.supportedCloud;
    }

    /**
     * Set the supportedCloud property: Relevant cloud for the custom assessment automation.
     * 
     * @param supportedCloud the supportedCloud value to set.
     * @return the CustomAssessmentAutomationProperties object itself.
     */
    public CustomAssessmentAutomationProperties withSupportedCloud(SupportedCloudEnum supportedCloud) {
        this.supportedCloud = supportedCloud;
        return this;
    }

    /**
     * Get the severity property: The severity to relate to the assessments generated by this assessment automation.
     * 
     * @return the severity value.
     */
    public SeverityEnum severity() {
        return this.severity;
    }

    /**
     * Set the severity property: The severity to relate to the assessments generated by this assessment automation.
     * 
     * @param severity the severity value to set.
     * @return the CustomAssessmentAutomationProperties object itself.
     */
    public CustomAssessmentAutomationProperties withSeverity(SeverityEnum severity) {
        this.severity = severity;
        return this;
    }

    /**
     * Get the displayName property: The display name of the assessments generated by this assessment automation.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: The display name of the assessments generated by this assessment automation.
     * 
     * @param displayName the displayName value to set.
     * @return the CustomAssessmentAutomationProperties object itself.
     */
    public CustomAssessmentAutomationProperties withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the description property: The description to relate to the assessments generated by this assessment
     * automation.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The description to relate to the assessments generated by this assessment
     * automation.
     * 
     * @param description the description value to set.
     * @return the CustomAssessmentAutomationProperties object itself.
     */
    public CustomAssessmentAutomationProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the remediationDescription property: The remediation description to relate to the assessments generated by
     * this assessment automation.
     * 
     * @return the remediationDescription value.
     */
    public String remediationDescription() {
        return this.remediationDescription;
    }

    /**
     * Set the remediationDescription property: The remediation description to relate to the assessments generated by
     * this assessment automation.
     * 
     * @param remediationDescription the remediationDescription value to set.
     * @return the CustomAssessmentAutomationProperties object itself.
     */
    public CustomAssessmentAutomationProperties withRemediationDescription(String remediationDescription) {
        this.remediationDescription = remediationDescription;
        return this;
    }

    /**
     * Get the assessmentKey property: The assessment metadata key used when an assessment is generated for this
     * assessment automation.
     * 
     * @return the assessmentKey value.
     */
    public String assessmentKey() {
        return this.assessmentKey;
    }

    /**
     * Set the assessmentKey property: The assessment metadata key used when an assessment is generated for this
     * assessment automation.
     * 
     * @param assessmentKey the assessmentKey value to set.
     * @return the CustomAssessmentAutomationProperties object itself.
     */
    public CustomAssessmentAutomationProperties withAssessmentKey(String assessmentKey) {
        this.assessmentKey = assessmentKey;
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
        jsonWriter.writeStringField("compressedQuery", this.compressedQuery);
        jsonWriter.writeStringField("supportedCloud",
            this.supportedCloud == null ? null : this.supportedCloud.toString());
        jsonWriter.writeStringField("severity", this.severity == null ? null : this.severity.toString());
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("description", this.description);
        jsonWriter.writeStringField("remediationDescription", this.remediationDescription);
        jsonWriter.writeStringField("assessmentKey", this.assessmentKey);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CustomAssessmentAutomationProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CustomAssessmentAutomationProperties if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the CustomAssessmentAutomationProperties.
     */
    public static CustomAssessmentAutomationProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CustomAssessmentAutomationProperties deserializedCustomAssessmentAutomationProperties
                = new CustomAssessmentAutomationProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("compressedQuery".equals(fieldName)) {
                    deserializedCustomAssessmentAutomationProperties.compressedQuery = reader.getString();
                } else if ("supportedCloud".equals(fieldName)) {
                    deserializedCustomAssessmentAutomationProperties.supportedCloud
                        = SupportedCloudEnum.fromString(reader.getString());
                } else if ("severity".equals(fieldName)) {
                    deserializedCustomAssessmentAutomationProperties.severity
                        = SeverityEnum.fromString(reader.getString());
                } else if ("displayName".equals(fieldName)) {
                    deserializedCustomAssessmentAutomationProperties.displayName = reader.getString();
                } else if ("description".equals(fieldName)) {
                    deserializedCustomAssessmentAutomationProperties.description = reader.getString();
                } else if ("remediationDescription".equals(fieldName)) {
                    deserializedCustomAssessmentAutomationProperties.remediationDescription = reader.getString();
                } else if ("assessmentKey".equals(fieldName)) {
                    deserializedCustomAssessmentAutomationProperties.assessmentKey = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCustomAssessmentAutomationProperties;
        });
    }
}
