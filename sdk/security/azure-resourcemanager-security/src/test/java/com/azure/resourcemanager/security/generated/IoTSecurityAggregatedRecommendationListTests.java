// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.IoTSecurityAggregatedRecommendationInner;
import com.azure.resourcemanager.security.models.IoTSecurityAggregatedRecommendationList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class IoTSecurityAggregatedRecommendationListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IoTSecurityAggregatedRecommendationList model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"recommendationName\":\"wxqcsehchkhufmpq\",\"recommendationDisplayName\":\"q\",\"description\":\"gy\",\"recommendationTypeId\":\"ulodsaeuzanhsfnh\",\"detectedBy\":\"nwph\",\"remediationSteps\":\"fngq\",\"reportedSeverity\":\"Medium\",\"healthyDevices\":7773682996219179615,\"unhealthyDeviceCount\":1042823858711156853,\"logAnalyticsQuery\":\"jj\"},\"tags\":{\"ssruqnmdvhazcvj\":\"beqrkuorh\",\"wbqerzwxiytxtd\":\"tiq\",\"ktg\":\"ukvlb\"},\"id\":\"styoua\",\"name\":\"bewreswmowegmmut\",\"type\":\"yxey\"}],\"nextLink\":\"qigijiitnspxlzde\"}")
            .toObject(IoTSecurityAggregatedRecommendationList.class);
        Assertions.assertEquals("beqrkuorh", model.value().get(0).tags().get("ssruqnmdvhazcvj"));
        Assertions.assertEquals("wxqcsehchkhufmpq", model.value().get(0).recommendationName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IoTSecurityAggregatedRecommendationList model = new IoTSecurityAggregatedRecommendationList()
            .withValue(Arrays.asList(new IoTSecurityAggregatedRecommendationInner()
                .withTags(mapOf("ssruqnmdvhazcvj", "beqrkuorh", "wbqerzwxiytxtd", "tiq", "ktg", "ukvlb"))
                .withRecommendationName("wxqcsehchkhufmpq")));
        model = BinaryData.fromObject(model).toObject(IoTSecurityAggregatedRecommendationList.class);
        Assertions.assertEquals("beqrkuorh", model.value().get(0).tags().get("ssruqnmdvhazcvj"));
        Assertions.assertEquals("wxqcsehchkhufmpq", model.value().get(0).recommendationName());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
