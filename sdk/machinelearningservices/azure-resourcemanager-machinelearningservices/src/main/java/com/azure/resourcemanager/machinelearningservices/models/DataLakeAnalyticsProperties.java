// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearningservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The DataLakeAnalyticsProperties model. */
@Fluent
public final class DataLakeAnalyticsProperties {
    @JsonIgnore
    private final ClientLogger logger = new ClientLogger(DataLakeAnalyticsProperties.class);

    /*
     * DataLake Store Account Name
     */
    @JsonProperty(value = "dataLakeStoreAccountName")
    private String dataLakeStoreAccountName;

    /**
     * Get the dataLakeStoreAccountName property: DataLake Store Account Name.
     *
     * @return the dataLakeStoreAccountName value.
     */
    public String dataLakeStoreAccountName() {
        return this.dataLakeStoreAccountName;
    }

    /**
     * Set the dataLakeStoreAccountName property: DataLake Store Account Name.
     *
     * @param dataLakeStoreAccountName the dataLakeStoreAccountName value to set.
     * @return the DataLakeAnalyticsProperties object itself.
     */
    public DataLakeAnalyticsProperties withDataLakeStoreAccountName(String dataLakeStoreAccountName) {
        this.dataLakeStoreAccountName = dataLakeStoreAccountName;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
