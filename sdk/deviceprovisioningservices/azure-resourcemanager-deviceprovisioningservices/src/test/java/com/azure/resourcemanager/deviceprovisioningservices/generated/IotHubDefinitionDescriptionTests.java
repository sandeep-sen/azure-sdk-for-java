// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.deviceprovisioningservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.deviceprovisioningservices.models.IotHubDefinitionDescription;
import org.junit.jupiter.api.Assertions;

public final class IotHubDefinitionDescriptionTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IotHubDefinitionDescription model = BinaryData.fromString(
            "{\"applyAllocationPolicy\":false,\"allocationWeight\":1695010462,\"name\":\"jvtbvpyss\",\"connectionString\":\"dnrujqguhmuouqfp\",\"location\":\"wzwbnguitn\"}")
            .toObject(IotHubDefinitionDescription.class);
        Assertions.assertEquals(false, model.applyAllocationPolicy());
        Assertions.assertEquals(1695010462, model.allocationWeight());
        Assertions.assertEquals("dnrujqguhmuouqfp", model.connectionString());
        Assertions.assertEquals("wzwbnguitn", model.location());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IotHubDefinitionDescription model = new IotHubDefinitionDescription().withApplyAllocationPolicy(false)
            .withAllocationWeight(1695010462)
            .withConnectionString("dnrujqguhmuouqfp")
            .withLocation("wzwbnguitn");
        model = BinaryData.fromObject(model).toObject(IotHubDefinitionDescription.class);
        Assertions.assertEquals(false, model.applyAllocationPolicy());
        Assertions.assertEquals(1695010462, model.allocationWeight());
        Assertions.assertEquals("dnrujqguhmuouqfp", model.connectionString());
        Assertions.assertEquals("wzwbnguitn", model.location());
    }
}
