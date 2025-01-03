// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.TimeWindowCustomAlertRule;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;

public final class TimeWindowCustomAlertRuleTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TimeWindowCustomAlertRule model = BinaryData.fromString(
            "{\"ruleType\":\"TimeWindowCustomAlertRule\",\"timeWindowSize\":\"PT12H28M39S\",\"minThreshold\":943745189,\"maxThreshold\":1871925709,\"displayName\":\"eoiojfizfavkjzw\",\"description\":\"cyayk\",\"isEnabled\":false}")
            .toObject(TimeWindowCustomAlertRule.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(943745189, model.minThreshold());
        Assertions.assertEquals(1871925709, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT12H28M39S"), model.timeWindowSize());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TimeWindowCustomAlertRule model = new TimeWindowCustomAlertRule().withIsEnabled(false)
            .withMinThreshold(943745189)
            .withMaxThreshold(1871925709)
            .withTimeWindowSize(Duration.parse("PT12H28M39S"));
        model = BinaryData.fromObject(model).toObject(TimeWindowCustomAlertRule.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(943745189, model.minThreshold());
        Assertions.assertEquals(1871925709, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT12H28M39S"), model.timeWindowSize());
    }
}
