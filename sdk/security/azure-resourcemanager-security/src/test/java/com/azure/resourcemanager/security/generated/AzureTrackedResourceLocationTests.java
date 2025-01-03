// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.AzureTrackedResourceLocation;
import org.junit.jupiter.api.Assertions;

public final class AzureTrackedResourceLocationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureTrackedResourceLocation model
            = BinaryData.fromString("{\"location\":\"eyl\"}").toObject(AzureTrackedResourceLocation.class);
        Assertions.assertEquals("eyl", model.location());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureTrackedResourceLocation model = new AzureTrackedResourceLocation().withLocation("eyl");
        model = BinaryData.fromObject(model).toObject(AzureTrackedResourceLocation.class);
        Assertions.assertEquals("eyl", model.location());
    }
}
