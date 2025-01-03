// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

/**
 * Samples for DevOpsPolicies Get.
 */
public final class DevOpsPoliciesGetSamples {
    /*
     * x-ms-original-file:
     * specification/security/resource-manager/Microsoft.Security/preview/2024-05-15-preview/examples/
     * SecurityConnectorsDevOps/GetDevOpsPolicies_example.json
     */
    /**
     * Sample code: Get_DevOpsPolicies.
     * 
     * @param manager Entry point to SecurityManager.
     */
    public static void getDevOpsPolicies(com.azure.resourcemanager.security.SecurityManager manager) {
        manager.devOpsPolicies()
            .getWithResponse("myRg", "mySecurityConnectorName", "myDevOpsPolicy", com.azure.core.util.Context.NONE);
    }
}
