// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appcontainers.models.DiagnosticSupportTopic;
import com.azure.resourcemanager.appcontainers.models.DiagnosticsDefinition;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class DiagnosticsDefinitionTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DiagnosticsDefinition model = BinaryData.fromString(
            "{\"id\":\"ddm\",\"name\":\"huytxzvtzn\",\"description\":\"xbannovvoxc\",\"author\":\"tprwnw\",\"category\":\"oevytlyokr\",\"supportTopicList\":[{\"id\":\"uxvnsasbcrymodi\",\"pesId\":\"xkl\"}],\"analysisTypes\":[\"xnazpmkml\"],\"type\":\"evfxzopjhbzxlioh\",\"score\":9.690398}")
            .toObject(DiagnosticsDefinition.class);
        Assertions.assertEquals("xnazpmkml", model.analysisTypes().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DiagnosticsDefinition model
            = new DiagnosticsDefinition().withSupportTopicList(Arrays.asList(new DiagnosticSupportTopic()))
                .withAnalysisTypes(Arrays.asList("xnazpmkml"));
        model = BinaryData.fromObject(model).toObject(DiagnosticsDefinition.class);
        Assertions.assertEquals("xnazpmkml", model.analysisTypes().get(0));
    }
}
