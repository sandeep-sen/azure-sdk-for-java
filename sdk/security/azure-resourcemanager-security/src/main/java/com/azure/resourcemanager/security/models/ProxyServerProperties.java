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
 * For a non-Azure machine that is not connected directly to the internet, specify a proxy server that the non-Azure
 * machine can use.
 */
@Fluent
public final class ProxyServerProperties implements JsonSerializable<ProxyServerProperties> {
    /*
     * Proxy server IP
     */
    private String ip;

    /*
     * Proxy server port
     */
    private String port;

    /**
     * Creates an instance of ProxyServerProperties class.
     */
    public ProxyServerProperties() {
    }

    /**
     * Get the ip property: Proxy server IP.
     * 
     * @return the ip value.
     */
    public String ip() {
        return this.ip;
    }

    /**
     * Set the ip property: Proxy server IP.
     * 
     * @param ip the ip value to set.
     * @return the ProxyServerProperties object itself.
     */
    public ProxyServerProperties withIp(String ip) {
        this.ip = ip;
        return this;
    }

    /**
     * Get the port property: Proxy server port.
     * 
     * @return the port value.
     */
    public String port() {
        return this.port;
    }

    /**
     * Set the port property: Proxy server port.
     * 
     * @param port the port value to set.
     * @return the ProxyServerProperties object itself.
     */
    public ProxyServerProperties withPort(String port) {
        this.port = port;
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
        jsonWriter.writeStringField("ip", this.ip);
        jsonWriter.writeStringField("port", this.port);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ProxyServerProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ProxyServerProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ProxyServerProperties.
     */
    public static ProxyServerProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ProxyServerProperties deserializedProxyServerProperties = new ProxyServerProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("ip".equals(fieldName)) {
                    deserializedProxyServerProperties.ip = reader.getString();
                } else if ("port".equals(fieldName)) {
                    deserializedProxyServerProperties.port = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedProxyServerProperties;
        });
    }
}
