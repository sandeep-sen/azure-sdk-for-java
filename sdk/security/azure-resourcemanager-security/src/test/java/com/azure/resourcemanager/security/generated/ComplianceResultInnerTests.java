// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.ComplianceResultInner;

public final class ComplianceResultInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ComplianceResultInner model = BinaryData.fromString(
            "{\"properties\":{\"resourceStatus\":\"NotHealthy\"},\"id\":\"akxcptsoqfyiaseq\",\"name\":\"hkrttzrazis\",\"type\":\"ykiue\"}")
            .toObject(ComplianceResultInner.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ComplianceResultInner model = new ComplianceResultInner();
        model = BinaryData.fromObject(model).toObject(ComplianceResultInner.class);
    }
}
