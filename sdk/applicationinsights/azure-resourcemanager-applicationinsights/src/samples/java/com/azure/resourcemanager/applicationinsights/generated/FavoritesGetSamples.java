// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.applicationinsights.generated;

/**
 * Samples for Favorites Get.
 */
public final class FavoritesGetSamples {
    /*
     * x-ms-original-file:
     * specification/applicationinsights/resource-manager/Microsoft.Insights/stable/2015-05-01/examples/FavoriteGet.json
     */
    /**
     * Sample code: FavoriteGet.
     * 
     * @param manager Entry point to ApplicationInsightsManager.
     */
    public static void favoriteGet(com.azure.resourcemanager.applicationinsights.ApplicationInsightsManager manager) {
        manager.favorites()
            .getWithResponse("my-resource-group", "my-ai-component", "deadb33f-5e0d-4064-8ebb-1a4ed0313eb2",
                com.azure.core.util.Context.NONE);
    }
}
