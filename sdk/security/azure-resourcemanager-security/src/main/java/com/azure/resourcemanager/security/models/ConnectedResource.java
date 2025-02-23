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
 * Describes properties of a connected resource.
 */
@Immutable
public final class ConnectedResource implements JsonSerializable<ConnectedResource> {
    /*
     * The Azure resource id of the connected resource
     */
    private String connectedResourceId;

    /*
     * The allowed tcp ports
     */
    private String tcpPorts;

    /*
     * The allowed udp ports
     */
    private String udpPorts;

    /**
     * Creates an instance of ConnectedResource class.
     */
    public ConnectedResource() {
    }

    /**
     * Get the connectedResourceId property: The Azure resource id of the connected resource.
     * 
     * @return the connectedResourceId value.
     */
    public String connectedResourceId() {
        return this.connectedResourceId;
    }

    /**
     * Get the tcpPorts property: The allowed tcp ports.
     * 
     * @return the tcpPorts value.
     */
    public String tcpPorts() {
        return this.tcpPorts;
    }

    /**
     * Get the udpPorts property: The allowed udp ports.
     * 
     * @return the udpPorts value.
     */
    public String udpPorts() {
        return this.udpPorts;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ConnectedResource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ConnectedResource if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ConnectedResource.
     */
    public static ConnectedResource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ConnectedResource deserializedConnectedResource = new ConnectedResource();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("connectedResourceId".equals(fieldName)) {
                    deserializedConnectedResource.connectedResourceId = reader.getString();
                } else if ("tcpPorts".equals(fieldName)) {
                    deserializedConnectedResource.tcpPorts = reader.getString();
                } else if ("udpPorts".equals(fieldName)) {
                    deserializedConnectedResource.udpPorts = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedConnectedResource;
        });
    }
}
