// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.AssignedStandardItem;
import org.junit.jupiter.api.Assertions;

public final class AssignedStandardItemTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AssignedStandardItem model
            = BinaryData.fromString("{\"id\":\"lhzqpxzbawkikcdg\"}").toObject(AssignedStandardItem.class);
        Assertions.assertEquals("lhzqpxzbawkikcdg", model.id());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AssignedStandardItem model = new AssignedStandardItem().withId("lhzqpxzbawkikcdg");
        model = BinaryData.fromObject(model).toObject(AssignedStandardItem.class);
        Assertions.assertEquals("lhzqpxzbawkikcdg", model.id());
    }
}
