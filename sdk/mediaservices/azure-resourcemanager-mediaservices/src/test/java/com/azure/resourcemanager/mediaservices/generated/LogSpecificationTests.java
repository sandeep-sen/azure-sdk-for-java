// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mediaservices.models.LogSpecification;

public final class LogSpecificationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        LogSpecification model
            = BinaryData.fromString("{\"name\":\"xc\",\"displayName\":\"npc\",\"blobDuration\":\"ocohslkevleg\"}")
                .toObject(LogSpecification.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        LogSpecification model = new LogSpecification();
        model = BinaryData.fromObject(model).toObject(LogSpecification.class);
    }
}
