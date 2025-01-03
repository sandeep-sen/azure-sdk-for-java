// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

/**
 * Samples for GitHubOwners Get.
 */
public final class GitHubOwnersGetSamples {
    /*
     * x-ms-original-file:
     * specification/security/resource-manager/Microsoft.Security/preview/2024-05-15-preview/examples/
     * SecurityConnectorsDevOps/GetGitHubOwners_example.json
     */
    /**
     * Sample code: Get_GitHubOwners.
     * 
     * @param manager Entry point to SecurityManager.
     */
    public static void getGitHubOwners(com.azure.resourcemanager.security.SecurityManager manager) {
        manager.gitHubOwners()
            .getWithResponse("myRg", "mySecurityConnectorName", "myGitHubOwner", com.azure.core.util.Context.NONE);
    }
}
