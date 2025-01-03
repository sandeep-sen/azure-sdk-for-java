// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.SoftwareInner;
import com.azure.resourcemanager.security.models.EndOfSupportStatus;
import org.junit.jupiter.api.Assertions;

public final class SoftwareInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SoftwareInner model = BinaryData.fromString(
            "{\"properties\":{\"deviceId\":\"cqibycnojv\",\"osPlatform\":\"mefqsgzvahapjyzh\",\"vendor\":\"gqzcjr\",\"softwareName\":\"djzlmwlx\",\"version\":\"ug\",\"endOfSupportStatus\":\"versionNoLongerSupported\",\"endOfSupportDate\":\"vawjvzunlu\",\"numberOfKnownVulnerabilities\":1146860274,\"firstSeenAt\":\"prnxipeil\"},\"id\":\"jzuaejxdultskzbb\",\"name\":\"dzumveekg\",\"type\":\"wozuhkf\"}")
            .toObject(SoftwareInner.class);
        Assertions.assertEquals("cqibycnojv", model.deviceId());
        Assertions.assertEquals("mefqsgzvahapjyzh", model.osPlatform());
        Assertions.assertEquals("gqzcjr", model.vendor());
        Assertions.assertEquals("djzlmwlx", model.softwareName());
        Assertions.assertEquals("ug", model.version());
        Assertions.assertEquals(EndOfSupportStatus.VERSION_NO_LONGER_SUPPORTED, model.endOfSupportStatus());
        Assertions.assertEquals("vawjvzunlu", model.endOfSupportDate());
        Assertions.assertEquals(1146860274, model.numberOfKnownVulnerabilities());
        Assertions.assertEquals("prnxipeil", model.firstSeenAt());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SoftwareInner model = new SoftwareInner().withDeviceId("cqibycnojv")
            .withOsPlatform("mefqsgzvahapjyzh")
            .withVendor("gqzcjr")
            .withSoftwareName("djzlmwlx")
            .withVersion("ug")
            .withEndOfSupportStatus(EndOfSupportStatus.VERSION_NO_LONGER_SUPPORTED)
            .withEndOfSupportDate("vawjvzunlu")
            .withNumberOfKnownVulnerabilities(1146860274)
            .withFirstSeenAt("prnxipeil");
        model = BinaryData.fromObject(model).toObject(SoftwareInner.class);
        Assertions.assertEquals("cqibycnojv", model.deviceId());
        Assertions.assertEquals("mefqsgzvahapjyzh", model.osPlatform());
        Assertions.assertEquals("gqzcjr", model.vendor());
        Assertions.assertEquals("djzlmwlx", model.softwareName());
        Assertions.assertEquals("ug", model.version());
        Assertions.assertEquals(EndOfSupportStatus.VERSION_NO_LONGER_SUPPORTED, model.endOfSupportStatus());
        Assertions.assertEquals("vawjvzunlu", model.endOfSupportDate());
        Assertions.assertEquals(1146860274, model.numberOfKnownVulnerabilities());
        Assertions.assertEquals("prnxipeil", model.firstSeenAt());
    }
}
