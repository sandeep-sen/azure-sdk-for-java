// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.desktopvirtualization.models.ScalingHostPoolReference;
import com.azure.resourcemanager.desktopvirtualization.models.ScalingHostPoolType;
import com.azure.resourcemanager.desktopvirtualization.models.ScalingSchedule;
import java.io.IOException;
import java.util.List;

/**
 * Scaling plan properties.
 */
@Fluent
public final class ScalingPlanProperties implements JsonSerializable<ScalingPlanProperties> {
    /*
     * ObjectId of scaling plan. (internal use)
     */
    private String objectId;

    /*
     * Description of scaling plan.
     */
    private String description;

    /*
     * User friendly name of scaling plan.
     */
    private String friendlyName;

    /*
     * Timezone of the scaling plan.
     */
    private String timeZone;

    /*
     * HostPool type for desktop.
     */
    private ScalingHostPoolType hostPoolType;

    /*
     * Exclusion tag for scaling plan.
     */
    private String exclusionTag;

    /*
     * List of ScalingPlanPooledSchedule definitions.
     */
    private List<ScalingSchedule> schedules;

    /*
     * List of ScalingHostPoolReference definitions.
     */
    private List<ScalingHostPoolReference> hostPoolReferences;

    /**
     * Creates an instance of ScalingPlanProperties class.
     */
    public ScalingPlanProperties() {
    }

    /**
     * Get the objectId property: ObjectId of scaling plan. (internal use).
     * 
     * @return the objectId value.
     */
    public String objectId() {
        return this.objectId;
    }

    /**
     * Get the description property: Description of scaling plan.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: Description of scaling plan.
     * 
     * @param description the description value to set.
     * @return the ScalingPlanProperties object itself.
     */
    public ScalingPlanProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the friendlyName property: User friendly name of scaling plan.
     * 
     * @return the friendlyName value.
     */
    public String friendlyName() {
        return this.friendlyName;
    }

    /**
     * Set the friendlyName property: User friendly name of scaling plan.
     * 
     * @param friendlyName the friendlyName value to set.
     * @return the ScalingPlanProperties object itself.
     */
    public ScalingPlanProperties withFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Get the timeZone property: Timezone of the scaling plan.
     * 
     * @return the timeZone value.
     */
    public String timeZone() {
        return this.timeZone;
    }

    /**
     * Set the timeZone property: Timezone of the scaling plan.
     * 
     * @param timeZone the timeZone value to set.
     * @return the ScalingPlanProperties object itself.
     */
    public ScalingPlanProperties withTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    /**
     * Get the hostPoolType property: HostPool type for desktop.
     * 
     * @return the hostPoolType value.
     */
    public ScalingHostPoolType hostPoolType() {
        return this.hostPoolType;
    }

    /**
     * Set the hostPoolType property: HostPool type for desktop.
     * 
     * @param hostPoolType the hostPoolType value to set.
     * @return the ScalingPlanProperties object itself.
     */
    public ScalingPlanProperties withHostPoolType(ScalingHostPoolType hostPoolType) {
        this.hostPoolType = hostPoolType;
        return this;
    }

    /**
     * Get the exclusionTag property: Exclusion tag for scaling plan.
     * 
     * @return the exclusionTag value.
     */
    public String exclusionTag() {
        return this.exclusionTag;
    }

    /**
     * Set the exclusionTag property: Exclusion tag for scaling plan.
     * 
     * @param exclusionTag the exclusionTag value to set.
     * @return the ScalingPlanProperties object itself.
     */
    public ScalingPlanProperties withExclusionTag(String exclusionTag) {
        this.exclusionTag = exclusionTag;
        return this;
    }

    /**
     * Get the schedules property: List of ScalingPlanPooledSchedule definitions.
     * 
     * @return the schedules value.
     */
    public List<ScalingSchedule> schedules() {
        return this.schedules;
    }

    /**
     * Set the schedules property: List of ScalingPlanPooledSchedule definitions.
     * 
     * @param schedules the schedules value to set.
     * @return the ScalingPlanProperties object itself.
     */
    public ScalingPlanProperties withSchedules(List<ScalingSchedule> schedules) {
        this.schedules = schedules;
        return this;
    }

    /**
     * Get the hostPoolReferences property: List of ScalingHostPoolReference definitions.
     * 
     * @return the hostPoolReferences value.
     */
    public List<ScalingHostPoolReference> hostPoolReferences() {
        return this.hostPoolReferences;
    }

    /**
     * Set the hostPoolReferences property: List of ScalingHostPoolReference definitions.
     * 
     * @param hostPoolReferences the hostPoolReferences value to set.
     * @return the ScalingPlanProperties object itself.
     */
    public ScalingPlanProperties withHostPoolReferences(List<ScalingHostPoolReference> hostPoolReferences) {
        this.hostPoolReferences = hostPoolReferences;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (timeZone() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property timeZone in model ScalingPlanProperties"));
        }
        if (schedules() != null) {
            schedules().forEach(e -> e.validate());
        }
        if (hostPoolReferences() != null) {
            hostPoolReferences().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ScalingPlanProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("timeZone", this.timeZone);
        jsonWriter.writeStringField("description", this.description);
        jsonWriter.writeStringField("friendlyName", this.friendlyName);
        jsonWriter.writeStringField("hostPoolType", this.hostPoolType == null ? null : this.hostPoolType.toString());
        jsonWriter.writeStringField("exclusionTag", this.exclusionTag);
        jsonWriter.writeArrayField("schedules", this.schedules, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("hostPoolReferences", this.hostPoolReferences,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ScalingPlanProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ScalingPlanProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ScalingPlanProperties.
     */
    public static ScalingPlanProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ScalingPlanProperties deserializedScalingPlanProperties = new ScalingPlanProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("timeZone".equals(fieldName)) {
                    deserializedScalingPlanProperties.timeZone = reader.getString();
                } else if ("objectId".equals(fieldName)) {
                    deserializedScalingPlanProperties.objectId = reader.getString();
                } else if ("description".equals(fieldName)) {
                    deserializedScalingPlanProperties.description = reader.getString();
                } else if ("friendlyName".equals(fieldName)) {
                    deserializedScalingPlanProperties.friendlyName = reader.getString();
                } else if ("hostPoolType".equals(fieldName)) {
                    deserializedScalingPlanProperties.hostPoolType = ScalingHostPoolType.fromString(reader.getString());
                } else if ("exclusionTag".equals(fieldName)) {
                    deserializedScalingPlanProperties.exclusionTag = reader.getString();
                } else if ("schedules".equals(fieldName)) {
                    List<ScalingSchedule> schedules = reader.readArray(reader1 -> ScalingSchedule.fromJson(reader1));
                    deserializedScalingPlanProperties.schedules = schedules;
                } else if ("hostPoolReferences".equals(fieldName)) {
                    List<ScalingHostPoolReference> hostPoolReferences
                        = reader.readArray(reader1 -> ScalingHostPoolReference.fromJson(reader1));
                    deserializedScalingPlanProperties.hostPoolReferences = hostPoolReferences;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedScalingPlanProperties;
        });
    }
}
