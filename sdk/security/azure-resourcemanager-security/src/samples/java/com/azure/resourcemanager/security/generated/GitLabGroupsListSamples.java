// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

/**
 * Samples for GitLabGroups List.
 */
public final class GitLabGroupsListSamples {
    /*
     * x-ms-original-file:
     * specification/security/resource-manager/Microsoft.Security/preview/2024-05-15-preview/examples/
     * SecurityConnectorsDevOps/ListGitLabGroups_example.json
     */
    /**
     * Sample code: List_GitLabGroups.
     * 
     * @param manager Entry point to SecurityManager.
     */
    public static void listGitLabGroups(com.azure.resourcemanager.security.SecurityManager manager) {
        manager.gitLabGroups().list("myRg", "mySecurityConnectorName", com.azure.core.util.Context.NONE);
    }
}
