// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.AutomationScope;
import org.junit.jupiter.api.Assertions;

public final class AutomationScopeTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AutomationScope model
            = BinaryData.fromString("{\"description\":\"uurutlwexxwlalni\",\"scopePath\":\"zsrzpgepq\"}")
                .toObject(AutomationScope.class);
        Assertions.assertEquals("uurutlwexxwlalni", model.description());
        Assertions.assertEquals("zsrzpgepq", model.scopePath());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AutomationScope model = new AutomationScope().withDescription("uurutlwexxwlalni").withScopePath("zsrzpgepq");
        model = BinaryData.fromObject(model).toObject(AutomationScope.class);
        Assertions.assertEquals("uurutlwexxwlalni", model.description());
        Assertions.assertEquals("zsrzpgepq", model.scopePath());
    }
}
