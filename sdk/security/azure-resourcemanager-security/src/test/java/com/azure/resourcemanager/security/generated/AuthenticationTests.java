// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.Authentication;

public final class AuthenticationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        Authentication model
            = BinaryData.fromString("{\"authenticationType\":\"Authentication\"}").toObject(Authentication.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        Authentication model = new Authentication();
        model = BinaryData.fromObject(model).toObject(Authentication.class);
    }
}
