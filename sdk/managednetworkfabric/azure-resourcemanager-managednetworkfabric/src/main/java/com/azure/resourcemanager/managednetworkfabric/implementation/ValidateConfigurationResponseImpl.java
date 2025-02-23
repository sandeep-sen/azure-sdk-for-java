// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.implementation;

import com.azure.core.management.exception.ManagementError;
import com.azure.resourcemanager.managednetworkfabric.fluent.models.ValidateConfigurationResponseInner;
import com.azure.resourcemanager.managednetworkfabric.models.ConfigurationState;
import com.azure.resourcemanager.managednetworkfabric.models.ValidateConfigurationResponse;

public final class ValidateConfigurationResponseImpl implements ValidateConfigurationResponse {
    private ValidateConfigurationResponseInner innerObject;

    private final com.azure.resourcemanager.managednetworkfabric.ManagedNetworkFabricManager serviceManager;

    ValidateConfigurationResponseImpl(ValidateConfigurationResponseInner innerObject,
        com.azure.resourcemanager.managednetworkfabric.ManagedNetworkFabricManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public ConfigurationState configurationState() {
        return this.innerModel().configurationState();
    }

    public String url() {
        return this.innerModel().url();
    }

    public ManagementError error() {
        return this.innerModel().error();
    }

    public ValidateConfigurationResponseInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.managednetworkfabric.ManagedNetworkFabricManager manager() {
        return this.serviceManager;
    }
}
