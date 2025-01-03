// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurestack.generated;

/**
 * Samples for CustomerSubscriptions Delete.
 */
public final class CustomerSubscriptionsDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/azurestack/resource-manager/Microsoft.AzureStack/stable/2022-06-01/examples/CustomerSubscription/
     * Delete.json
     */
    /**
     * Sample code: Deletes a customer subscription under a registration.
     * 
     * @param manager Entry point to AzureStackManager.
     */
    public static void
        deletesACustomerSubscriptionUnderARegistration(com.azure.resourcemanager.azurestack.AzureStackManager manager) {
        manager.customerSubscriptions()
            .deleteWithResponse("azurestack", "testregistration", "E09A4E93-29A7-4EBA-A6D4-76202383F07F",
                com.azure.core.util.Context.NONE);
    }
}
