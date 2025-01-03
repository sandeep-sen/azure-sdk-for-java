// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.DefenderCspmDockerHubOffering;

public final class DefenderCspmDockerHubOfferingTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DefenderCspmDockerHubOffering model
            = BinaryData.fromString("{\"offeringType\":\"DefenderCspmDockerHub\",\"description\":\"rjwayhicqq\"}")
                .toObject(DefenderCspmDockerHubOffering.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DefenderCspmDockerHubOffering model = new DefenderCspmDockerHubOffering();
        model = BinaryData.fromObject(model).toObject(DefenderCspmDockerHubOffering.class);
    }
}
