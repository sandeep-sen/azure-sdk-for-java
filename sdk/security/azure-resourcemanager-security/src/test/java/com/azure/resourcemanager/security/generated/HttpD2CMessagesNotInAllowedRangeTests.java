// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.HttpD2CMessagesNotInAllowedRange;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;

public final class HttpD2CMessagesNotInAllowedRangeTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        HttpD2CMessagesNotInAllowedRange model = BinaryData.fromString(
            "{\"ruleType\":\"HttpD2CMessagesNotInAllowedRange\",\"timeWindowSize\":\"PT213H40M22S\",\"minThreshold\":84412621,\"maxThreshold\":347247295,\"displayName\":\"adeghztldsvc\",\"description\":\"jiahuqy\",\"isEnabled\":false}")
            .toObject(HttpD2CMessagesNotInAllowedRange.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(84412621, model.minThreshold());
        Assertions.assertEquals(347247295, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT213H40M22S"), model.timeWindowSize());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        HttpD2CMessagesNotInAllowedRange model = new HttpD2CMessagesNotInAllowedRange().withIsEnabled(false)
            .withMinThreshold(84412621)
            .withMaxThreshold(347247295)
            .withTimeWindowSize(Duration.parse("PT213H40M22S"));
        model = BinaryData.fromObject(model).toObject(HttpD2CMessagesNotInAllowedRange.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(84412621, model.minThreshold());
        Assertions.assertEquals(347247295, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT213H40M22S"), model.timeWindowSize());
    }
}
