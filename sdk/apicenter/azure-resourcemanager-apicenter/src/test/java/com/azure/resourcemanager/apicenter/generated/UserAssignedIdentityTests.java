// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apicenter.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apicenter.models.UserAssignedIdentity;

public final class UserAssignedIdentityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UserAssignedIdentity model = BinaryData.fromString(
            "{\"principalId\":\"0ed8fb1e-6f3d-41c6-8490-13ece48b03cd\",\"clientId\":\"e542e92f-b14b-44ec-8210-31085ecc3c92\"}")
            .toObject(UserAssignedIdentity.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UserAssignedIdentity model = new UserAssignedIdentity();
        model = BinaryData.fromObject(model).toObject(UserAssignedIdentity.class);
    }
}
