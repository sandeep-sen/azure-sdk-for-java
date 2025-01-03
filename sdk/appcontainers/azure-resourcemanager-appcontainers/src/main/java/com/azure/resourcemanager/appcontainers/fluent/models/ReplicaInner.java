// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.appcontainers.models.ContainerAppReplicaRunningState;
import com.azure.resourcemanager.appcontainers.models.ReplicaContainer;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * Container App Revision Replica.
 */
@Fluent
public final class ReplicaInner extends ProxyResource {
    /*
     * Replica resource specific properties
     */
    private ReplicaProperties innerProperties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SystemData systemData;

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
     * Creates an instance of ReplicaInner class.
     */
    public ReplicaInner() {
    }

    /**
     * Get the innerProperties property: Replica resource specific properties.
     * 
     * @return the innerProperties value.
     */
    private ReplicaProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
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
     * Get the createdTime property: Timestamp describing when the pod was created by controller.
     * 
     * @return the createdTime value.
     */
    public OffsetDateTime createdTime() {
        return this.innerProperties() == null ? null : this.innerProperties().createdTime();
    }

    /**
     * Get the runningState property: Current running state of the replica.
     * 
     * @return the runningState value.
     */
    public ContainerAppReplicaRunningState runningState() {
        return this.innerProperties() == null ? null : this.innerProperties().runningState();
    }

    /**
     * Get the runningStateDetails property: The details of replica current running state.
     * 
     * @return the runningStateDetails value.
     */
    public String runningStateDetails() {
        return this.innerProperties() == null ? null : this.innerProperties().runningStateDetails();
    }

    /**
     * Get the containers property: The containers collection under a replica.
     * 
     * @return the containers value.
     */
    public List<ReplicaContainer> containers() {
        return this.innerProperties() == null ? null : this.innerProperties().containers();
    }

    /**
     * Set the containers property: The containers collection under a replica.
     * 
     * @param containers the containers value to set.
     * @return the ReplicaInner object itself.
     */
    public ReplicaInner withContainers(List<ReplicaContainer> containers) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ReplicaProperties();
        }
        this.innerProperties().withContainers(containers);
        return this;
    }

    /**
     * Get the initContainers property: The init containers collection under a replica.
     * 
     * @return the initContainers value.
     */
    public List<ReplicaContainer> initContainers() {
        return this.innerProperties() == null ? null : this.innerProperties().initContainers();
    }

    /**
     * Set the initContainers property: The init containers collection under a replica.
     * 
     * @param initContainers the initContainers value to set.
     * @return the ReplicaInner object itself.
     */
    public ReplicaInner withInitContainers(List<ReplicaContainer> initContainers) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ReplicaProperties();
        }
        this.innerProperties().withInitContainers(initContainers);
        return this;
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
     * Reads an instance of ReplicaInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ReplicaInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ReplicaInner.
     */
    public static ReplicaInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ReplicaInner deserializedReplicaInner = new ReplicaInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedReplicaInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedReplicaInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedReplicaInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedReplicaInner.innerProperties = ReplicaProperties.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedReplicaInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedReplicaInner;
        });
    }
}
