// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.DiscoveredSecuritySolutionInner;
import com.azure.resourcemanager.security.models.SecurityFamily;
import org.junit.jupiter.api.Assertions;

public final class DiscoveredSecuritySolutionInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DiscoveredSecuritySolutionInner model = BinaryData.fromString(
            "{\"properties\":{\"securityFamily\":\"Ngfw\",\"offer\":\"geumil\",\"publisher\":\"wuit\",\"sku\":\"dexyionofninbdb\"},\"location\":\"xcwqqrsmpc\",\"id\":\"bprt\",\"name\":\"gavbzbcyk\",\"type\":\"ivmfogdrtbf\"}")
            .toObject(DiscoveredSecuritySolutionInner.class);
        Assertions.assertEquals(SecurityFamily.NGFW, model.securityFamily());
        Assertions.assertEquals("geumil", model.offer());
        Assertions.assertEquals("wuit", model.publisher());
        Assertions.assertEquals("dexyionofninbdb", model.sku());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DiscoveredSecuritySolutionInner model
            = new DiscoveredSecuritySolutionInner().withSecurityFamily(SecurityFamily.NGFW)
                .withOffer("geumil")
                .withPublisher("wuit")
                .withSku("dexyionofninbdb");
        model = BinaryData.fromObject(model).toObject(DiscoveredSecuritySolutionInner.class);
        Assertions.assertEquals(SecurityFamily.NGFW, model.securityFamily());
        Assertions.assertEquals("geumil", model.offer());
        Assertions.assertEquals("wuit", model.publisher());
        Assertions.assertEquals("dexyionofninbdb", model.sku());
    }
}
