// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.DevOpsPolicyInner;
import com.azure.resourcemanager.security.models.DevOpsPolicyProperties;
import com.azure.resourcemanager.security.models.DevOpsPolicySource;
import com.azure.resourcemanager.security.models.DevOpsPolicyType;
import org.junit.jupiter.api.Assertions;

public final class DevOpsPolicyInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DevOpsPolicyInner model = BinaryData.fromString(
            "{\"properties\":{\"provisioningStatusMessage\":\"bsre\",\"provisioningStatusUpdateTimeUtc\":\"2020-12-27T06:02:05Z\",\"provisioningState\":\"Failed\",\"source\":\"BuiltIn\",\"policyId\":\"f0028ffe-c25d-4884-97f7-bfab6571f10a\",\"webUrl\":\"enl\",\"version\":\"htkln\",\"type\":\"Unknown\",\"content\":\"vvkyfedevjboslcq\"},\"id\":\"y\",\"name\":\"okkhminq\",\"type\":\"ymc\"}")
            .toObject(DevOpsPolicyInner.class);
        Assertions.assertEquals(DevOpsPolicySource.BUILT_IN, model.properties().source());
        Assertions.assertEquals("htkln", model.properties().version());
        Assertions.assertEquals(DevOpsPolicyType.UNKNOWN, model.properties().type());
        Assertions.assertEquals("vvkyfedevjboslcq", model.properties().content());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DevOpsPolicyInner model = new DevOpsPolicyInner()
            .withProperties(new DevOpsPolicyProperties().withSource(DevOpsPolicySource.BUILT_IN)
                .withVersion("htkln")
                .withType(DevOpsPolicyType.UNKNOWN)
                .withContent("vvkyfedevjboslcq"));
        model = BinaryData.fromObject(model).toObject(DevOpsPolicyInner.class);
        Assertions.assertEquals(DevOpsPolicySource.BUILT_IN, model.properties().source());
        Assertions.assertEquals("htkln", model.properties().version());
        Assertions.assertEquals(DevOpsPolicyType.UNKNOWN, model.properties().type());
        Assertions.assertEquals("vvkyfedevjboslcq", model.properties().content());
    }
}
