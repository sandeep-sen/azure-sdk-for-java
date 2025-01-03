// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.DefenderForContainersAwsOfferingKubernetesService;
import org.junit.jupiter.api.Assertions;

public final class DefenderForContainersAwsOfferingKubernetesServiceTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DefenderForContainersAwsOfferingKubernetesService model = BinaryData.fromString("{\"cloudRoleArn\":\"wi\"}")
            .toObject(DefenderForContainersAwsOfferingKubernetesService.class);
        Assertions.assertEquals("wi", model.cloudRoleArn());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DefenderForContainersAwsOfferingKubernetesService model
            = new DefenderForContainersAwsOfferingKubernetesService().withCloudRoleArn("wi");
        model = BinaryData.fromObject(model).toObject(DefenderForContainersAwsOfferingKubernetesService.class);
        Assertions.assertEquals("wi", model.cloudRoleArn());
    }
}
