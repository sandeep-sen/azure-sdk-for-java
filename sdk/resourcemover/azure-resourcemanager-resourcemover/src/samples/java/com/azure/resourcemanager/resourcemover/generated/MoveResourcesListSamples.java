// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcemover.generated;

/**
 * Samples for MoveResources List.
 */
public final class MoveResourcesListSamples {
    /*
     * x-ms-original-file:
     * specification/resourcemover/resource-manager/Microsoft.Migrate/stable/2023-08-01/examples/MoveResources_List.json
     */
    /**
     * Sample code: MoveResources_List.
     * 
     * @param manager Entry point to ResourceMoverManager.
     */
    public static void moveResourcesList(com.azure.resourcemanager.resourcemover.ResourceMoverManager manager) {
        manager.moveResources().list("rg1", "movecollection1", null, com.azure.core.util.Context.NONE);
    }
}
