// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.generated;

import com.azure.resourcemanager.automation.models.Webhook;

/**
 * Samples for Webhook Update.
 */
public final class WebhookUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/automation/resource-manager/Microsoft.Automation/stable/2015-10-31/examples/updateWebhook.json
     */
    /**
     * Sample code: Update webhook.
     * 
     * @param manager Entry point to AutomationManager.
     */
    public static void updateWebhook(com.azure.resourcemanager.automation.AutomationManager manager) {
        Webhook resource = manager.webhooks()
            .getWithResponse("rg", "myAutomationAccount33", "TestWebhook", com.azure.core.util.Context.NONE)
            .getValue();
        resource.update().withName("TestWebhook").withIsEnabled(false).withDescription("updated webhook").apply();
    }
}
