// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.fluent.models.AutomationProperties;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The update model of security automation resource.
 */
@Fluent
public final class AutomationUpdateModel extends Tags {
    /*
     * Security automation data
     */
    private AutomationProperties innerProperties;

    /**
     * Creates an instance of AutomationUpdateModel class.
     */
    public AutomationUpdateModel() {
    }

    /**
     * Get the innerProperties property: Security automation data.
     * 
     * @return the innerProperties value.
     */
    private AutomationProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AutomationUpdateModel withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the description property: The security automation description.
     * 
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Set the description property: The security automation description.
     * 
     * @param description the description value to set.
     * @return the AutomationUpdateModel object itself.
     */
    public AutomationUpdateModel withDescription(String description) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutomationProperties();
        }
        this.innerProperties().withDescription(description);
        return this;
    }

    /**
     * Get the isEnabled property: Indicates whether the security automation is enabled.
     * 
     * @return the isEnabled value.
     */
    public Boolean isEnabled() {
        return this.innerProperties() == null ? null : this.innerProperties().isEnabled();
    }

    /**
     * Set the isEnabled property: Indicates whether the security automation is enabled.
     * 
     * @param isEnabled the isEnabled value to set.
     * @return the AutomationUpdateModel object itself.
     */
    public AutomationUpdateModel withIsEnabled(Boolean isEnabled) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutomationProperties();
        }
        this.innerProperties().withIsEnabled(isEnabled);
        return this;
    }

    /**
     * Get the scopes property: A collection of scopes on which the security automations logic is applied. Supported
     * scopes are the subscription itself or a resource group under that subscription. The automation will only apply on
     * defined scopes.
     * 
     * @return the scopes value.
     */
    public List<AutomationScope> scopes() {
        return this.innerProperties() == null ? null : this.innerProperties().scopes();
    }

    /**
     * Set the scopes property: A collection of scopes on which the security automations logic is applied. Supported
     * scopes are the subscription itself or a resource group under that subscription. The automation will only apply on
     * defined scopes.
     * 
     * @param scopes the scopes value to set.
     * @return the AutomationUpdateModel object itself.
     */
    public AutomationUpdateModel withScopes(List<AutomationScope> scopes) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutomationProperties();
        }
        this.innerProperties().withScopes(scopes);
        return this;
    }

    /**
     * Get the sources property: A collection of the source event types which evaluate the security automation set of
     * rules.
     * 
     * @return the sources value.
     */
    public List<AutomationSource> sources() {
        return this.innerProperties() == null ? null : this.innerProperties().sources();
    }

    /**
     * Set the sources property: A collection of the source event types which evaluate the security automation set of
     * rules.
     * 
     * @param sources the sources value to set.
     * @return the AutomationUpdateModel object itself.
     */
    public AutomationUpdateModel withSources(List<AutomationSource> sources) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutomationProperties();
        }
        this.innerProperties().withSources(sources);
        return this;
    }

    /**
     * Get the actions property: A collection of the actions which are triggered if all the configured rules
     * evaluations, within at least one rule set, are true.
     * 
     * @return the actions value.
     */
    public List<AutomationAction> actions() {
        return this.innerProperties() == null ? null : this.innerProperties().actions();
    }

    /**
     * Set the actions property: A collection of the actions which are triggered if all the configured rules
     * evaluations, within at least one rule set, are true.
     * 
     * @param actions the actions value to set.
     * @return the AutomationUpdateModel object itself.
     */
    public AutomationUpdateModel withActions(List<AutomationAction> actions) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutomationProperties();
        }
        this.innerProperties().withActions(actions);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
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
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AutomationUpdateModel from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AutomationUpdateModel if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AutomationUpdateModel.
     */
    public static AutomationUpdateModel fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AutomationUpdateModel deserializedAutomationUpdateModel = new AutomationUpdateModel();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedAutomationUpdateModel.withTags(tags);
                } else if ("properties".equals(fieldName)) {
                    deserializedAutomationUpdateModel.innerProperties = AutomationProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAutomationUpdateModel;
        });
    }
}
