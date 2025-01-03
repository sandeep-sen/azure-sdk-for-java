// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.RegulatoryComplianceStandardProperties;
import com.azure.resourcemanager.security.models.State;
import org.junit.jupiter.api.Assertions;

public final class RegulatoryComplianceStandardPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RegulatoryComplianceStandardProperties model = BinaryData.fromString(
            "{\"state\":\"Unsupported\",\"passedControls\":1039817033,\"failedControls\":1511983432,\"skippedControls\":518689832,\"unsupportedControls\":564919751}")
            .toObject(RegulatoryComplianceStandardProperties.class);
        Assertions.assertEquals(State.UNSUPPORTED, model.state());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RegulatoryComplianceStandardProperties model
            = new RegulatoryComplianceStandardProperties().withState(State.UNSUPPORTED);
        model = BinaryData.fromObject(model).toObject(RegulatoryComplianceStandardProperties.class);
        Assertions.assertEquals(State.UNSUPPORTED, model.state());
    }
}
