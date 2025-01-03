// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.models.EndOfSupportStatus;
import java.io.IOException;

/**
 * Represents a software data.
 */
@Fluent
public final class SoftwareInner extends ProxyResource {
    /*
     * Properties of the Software Inventory resource
     */
    private SoftwareProperties innerProperties = new SoftwareProperties();

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
     * Creates an instance of SoftwareInner class.
     */
    public SoftwareInner() {
    }

    /**
     * Get the innerProperties property: Properties of the Software Inventory resource.
     * 
     * @return the innerProperties value.
     */
    private SoftwareProperties innerProperties() {
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
     * Get the deviceId property: Unique identifier for the virtual machine in the service.
     * 
     * @return the deviceId value.
     */
    public String deviceId() {
        return this.innerProperties() == null ? null : this.innerProperties().deviceId();
    }

    /**
     * Set the deviceId property: Unique identifier for the virtual machine in the service.
     * 
     * @param deviceId the deviceId value to set.
     * @return the SoftwareInner object itself.
     */
    public SoftwareInner withDeviceId(String deviceId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SoftwareProperties();
        }
        this.innerProperties().withDeviceId(deviceId);
        return this;
    }

    /**
     * Get the osPlatform property: Platform of the operating system running on the device.
     * 
     * @return the osPlatform value.
     */
    public String osPlatform() {
        return this.innerProperties() == null ? null : this.innerProperties().osPlatform();
    }

    /**
     * Set the osPlatform property: Platform of the operating system running on the device.
     * 
     * @param osPlatform the osPlatform value to set.
     * @return the SoftwareInner object itself.
     */
    public SoftwareInner withOsPlatform(String osPlatform) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SoftwareProperties();
        }
        this.innerProperties().withOsPlatform(osPlatform);
        return this;
    }

    /**
     * Get the vendor property: Name of the software vendor.
     * 
     * @return the vendor value.
     */
    public String vendor() {
        return this.innerProperties() == null ? null : this.innerProperties().vendor();
    }

    /**
     * Set the vendor property: Name of the software vendor.
     * 
     * @param vendor the vendor value to set.
     * @return the SoftwareInner object itself.
     */
    public SoftwareInner withVendor(String vendor) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SoftwareProperties();
        }
        this.innerProperties().withVendor(vendor);
        return this;
    }

    /**
     * Get the softwareName property: Name of the software product.
     * 
     * @return the softwareName value.
     */
    public String softwareName() {
        return this.innerProperties() == null ? null : this.innerProperties().softwareName();
    }

    /**
     * Set the softwareName property: Name of the software product.
     * 
     * @param softwareName the softwareName value to set.
     * @return the SoftwareInner object itself.
     */
    public SoftwareInner withSoftwareName(String softwareName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SoftwareProperties();
        }
        this.innerProperties().withSoftwareName(softwareName);
        return this;
    }

    /**
     * Get the version property: Version number of the software product.
     * 
     * @return the version value.
     */
    public String version() {
        return this.innerProperties() == null ? null : this.innerProperties().version();
    }

    /**
     * Set the version property: Version number of the software product.
     * 
     * @param version the version value to set.
     * @return the SoftwareInner object itself.
     */
    public SoftwareInner withVersion(String version) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SoftwareProperties();
        }
        this.innerProperties().withVersion(version);
        return this;
    }

    /**
     * Get the endOfSupportStatus property: End of support status.
     * 
     * @return the endOfSupportStatus value.
     */
    public EndOfSupportStatus endOfSupportStatus() {
        return this.innerProperties() == null ? null : this.innerProperties().endOfSupportStatus();
    }

    /**
     * Set the endOfSupportStatus property: End of support status.
     * 
     * @param endOfSupportStatus the endOfSupportStatus value to set.
     * @return the SoftwareInner object itself.
     */
    public SoftwareInner withEndOfSupportStatus(EndOfSupportStatus endOfSupportStatus) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SoftwareProperties();
        }
        this.innerProperties().withEndOfSupportStatus(endOfSupportStatus);
        return this;
    }

    /**
     * Get the endOfSupportDate property: The end of support date in case the product is upcoming end of support.
     * 
     * @return the endOfSupportDate value.
     */
    public String endOfSupportDate() {
        return this.innerProperties() == null ? null : this.innerProperties().endOfSupportDate();
    }

    /**
     * Set the endOfSupportDate property: The end of support date in case the product is upcoming end of support.
     * 
     * @param endOfSupportDate the endOfSupportDate value to set.
     * @return the SoftwareInner object itself.
     */
    public SoftwareInner withEndOfSupportDate(String endOfSupportDate) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SoftwareProperties();
        }
        this.innerProperties().withEndOfSupportDate(endOfSupportDate);
        return this;
    }

    /**
     * Get the numberOfKnownVulnerabilities property: Number of weaknesses.
     * 
     * @return the numberOfKnownVulnerabilities value.
     */
    public Integer numberOfKnownVulnerabilities() {
        return this.innerProperties() == null ? null : this.innerProperties().numberOfKnownVulnerabilities();
    }

    /**
     * Set the numberOfKnownVulnerabilities property: Number of weaknesses.
     * 
     * @param numberOfKnownVulnerabilities the numberOfKnownVulnerabilities value to set.
     * @return the SoftwareInner object itself.
     */
    public SoftwareInner withNumberOfKnownVulnerabilities(Integer numberOfKnownVulnerabilities) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SoftwareProperties();
        }
        this.innerProperties().withNumberOfKnownVulnerabilities(numberOfKnownVulnerabilities);
        return this;
    }

    /**
     * Get the firstSeenAt property: First time that the software was seen in the device.
     * 
     * @return the firstSeenAt value.
     */
    public String firstSeenAt() {
        return this.innerProperties() == null ? null : this.innerProperties().firstSeenAt();
    }

    /**
     * Set the firstSeenAt property: First time that the software was seen in the device.
     * 
     * @param firstSeenAt the firstSeenAt value to set.
     * @return the SoftwareInner object itself.
     */
    public SoftwareInner withFirstSeenAt(String firstSeenAt) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SoftwareProperties();
        }
        this.innerProperties().withFirstSeenAt(firstSeenAt);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property innerProperties in model SoftwareInner"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SoftwareInner.class);

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
     * Reads an instance of SoftwareInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SoftwareInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SoftwareInner.
     */
    public static SoftwareInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SoftwareInner deserializedSoftwareInner = new SoftwareInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedSoftwareInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedSoftwareInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedSoftwareInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedSoftwareInner.innerProperties = SoftwareProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSoftwareInner;
        });
    }
}
