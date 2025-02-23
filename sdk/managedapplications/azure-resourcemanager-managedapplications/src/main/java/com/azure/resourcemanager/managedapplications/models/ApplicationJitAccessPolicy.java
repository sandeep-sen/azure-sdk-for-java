// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managedapplications.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Managed application Jit access policy.
 */
@Fluent
public final class ApplicationJitAccessPolicy implements JsonSerializable<ApplicationJitAccessPolicy> {
    /*
     * Whether the JIT access is enabled.
     */
    private boolean jitAccessEnabled;

    /*
     * JIT approval mode.
     */
    private JitApprovalMode jitApprovalMode;

    /*
     * The JIT approvers
     */
    private List<JitApproverDefinition> jitApprovers;

    /*
     * The maximum duration JIT access is granted. This is an ISO8601 time period value.
     */
    private String maximumJitAccessDuration;

    /**
     * Creates an instance of ApplicationJitAccessPolicy class.
     */
    public ApplicationJitAccessPolicy() {
    }

    /**
     * Get the jitAccessEnabled property: Whether the JIT access is enabled.
     * 
     * @return the jitAccessEnabled value.
     */
    public boolean jitAccessEnabled() {
        return this.jitAccessEnabled;
    }

    /**
     * Set the jitAccessEnabled property: Whether the JIT access is enabled.
     * 
     * @param jitAccessEnabled the jitAccessEnabled value to set.
     * @return the ApplicationJitAccessPolicy object itself.
     */
    public ApplicationJitAccessPolicy withJitAccessEnabled(boolean jitAccessEnabled) {
        this.jitAccessEnabled = jitAccessEnabled;
        return this;
    }

    /**
     * Get the jitApprovalMode property: JIT approval mode.
     * 
     * @return the jitApprovalMode value.
     */
    public JitApprovalMode jitApprovalMode() {
        return this.jitApprovalMode;
    }

    /**
     * Set the jitApprovalMode property: JIT approval mode.
     * 
     * @param jitApprovalMode the jitApprovalMode value to set.
     * @return the ApplicationJitAccessPolicy object itself.
     */
    public ApplicationJitAccessPolicy withJitApprovalMode(JitApprovalMode jitApprovalMode) {
        this.jitApprovalMode = jitApprovalMode;
        return this;
    }

    /**
     * Get the jitApprovers property: The JIT approvers.
     * 
     * @return the jitApprovers value.
     */
    public List<JitApproverDefinition> jitApprovers() {
        return this.jitApprovers;
    }

    /**
     * Set the jitApprovers property: The JIT approvers.
     * 
     * @param jitApprovers the jitApprovers value to set.
     * @return the ApplicationJitAccessPolicy object itself.
     */
    public ApplicationJitAccessPolicy withJitApprovers(List<JitApproverDefinition> jitApprovers) {
        this.jitApprovers = jitApprovers;
        return this;
    }

    /**
     * Get the maximumJitAccessDuration property: The maximum duration JIT access is granted. This is an ISO8601 time
     * period value.
     * 
     * @return the maximumJitAccessDuration value.
     */
    public String maximumJitAccessDuration() {
        return this.maximumJitAccessDuration;
    }

    /**
     * Set the maximumJitAccessDuration property: The maximum duration JIT access is granted. This is an ISO8601 time
     * period value.
     * 
     * @param maximumJitAccessDuration the maximumJitAccessDuration value to set.
     * @return the ApplicationJitAccessPolicy object itself.
     */
    public ApplicationJitAccessPolicy withMaximumJitAccessDuration(String maximumJitAccessDuration) {
        this.maximumJitAccessDuration = maximumJitAccessDuration;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (jitApprovers() != null) {
            jitApprovers().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeBooleanField("jitAccessEnabled", this.jitAccessEnabled);
        jsonWriter.writeStringField("jitApprovalMode",
            this.jitApprovalMode == null ? null : this.jitApprovalMode.toString());
        jsonWriter.writeArrayField("jitApprovers", this.jitApprovers, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("maximumJitAccessDuration", this.maximumJitAccessDuration);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ApplicationJitAccessPolicy from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ApplicationJitAccessPolicy if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ApplicationJitAccessPolicy.
     */
    public static ApplicationJitAccessPolicy fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ApplicationJitAccessPolicy deserializedApplicationJitAccessPolicy = new ApplicationJitAccessPolicy();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("jitAccessEnabled".equals(fieldName)) {
                    deserializedApplicationJitAccessPolicy.jitAccessEnabled = reader.getBoolean();
                } else if ("jitApprovalMode".equals(fieldName)) {
                    deserializedApplicationJitAccessPolicy.jitApprovalMode
                        = JitApprovalMode.fromString(reader.getString());
                } else if ("jitApprovers".equals(fieldName)) {
                    List<JitApproverDefinition> jitApprovers
                        = reader.readArray(reader1 -> JitApproverDefinition.fromJson(reader1));
                    deserializedApplicationJitAccessPolicy.jitApprovers = jitApprovers;
                } else if ("maximumJitAccessDuration".equals(fieldName)) {
                    deserializedApplicationJitAccessPolicy.maximumJitAccessDuration = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedApplicationJitAccessPolicy;
        });
    }
}
