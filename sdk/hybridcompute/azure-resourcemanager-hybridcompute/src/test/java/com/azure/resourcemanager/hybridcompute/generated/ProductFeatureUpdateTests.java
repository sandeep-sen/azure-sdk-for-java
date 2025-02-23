// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hybridcompute.models.LicenseProfileSubscriptionStatusUpdate;
import com.azure.resourcemanager.hybridcompute.models.ProductFeatureUpdate;
import org.junit.jupiter.api.Assertions;

public final class ProductFeatureUpdateTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ProductFeatureUpdate model = BinaryData.fromString("{\"name\":\"ncw\",\"subscriptionStatus\":\"Enable\"}")
            .toObject(ProductFeatureUpdate.class);
        Assertions.assertEquals("ncw", model.name());
        Assertions.assertEquals(LicenseProfileSubscriptionStatusUpdate.ENABLE, model.subscriptionStatus());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ProductFeatureUpdate model = new ProductFeatureUpdate().withName("ncw")
            .withSubscriptionStatus(LicenseProfileSubscriptionStatusUpdate.ENABLE);
        model = BinaryData.fromObject(model).toObject(ProductFeatureUpdate.class);
        Assertions.assertEquals("ncw", model.name());
        Assertions.assertEquals(LicenseProfileSubscriptionStatusUpdate.ENABLE, model.subscriptionStatus());
    }
}
