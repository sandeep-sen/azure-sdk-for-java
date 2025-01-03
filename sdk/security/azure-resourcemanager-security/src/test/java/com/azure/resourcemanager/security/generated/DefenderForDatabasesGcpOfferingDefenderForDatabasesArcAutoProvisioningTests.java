// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.DefenderForDatabasesGcpOfferingDefenderForDatabasesArcAutoProvisioning;
import org.junit.jupiter.api.Assertions;

public final class DefenderForDatabasesGcpOfferingDefenderForDatabasesArcAutoProvisioningTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DefenderForDatabasesGcpOfferingDefenderForDatabasesArcAutoProvisioning model = BinaryData
            .fromString("{\"serviceAccountEmailAddress\":\"doxzn\",\"workloadIdentityProviderId\":\"vdtmuuvd\"}")
            .toObject(DefenderForDatabasesGcpOfferingDefenderForDatabasesArcAutoProvisioning.class);
        Assertions.assertEquals("doxzn", model.serviceAccountEmailAddress());
        Assertions.assertEquals("vdtmuuvd", model.workloadIdentityProviderId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DefenderForDatabasesGcpOfferingDefenderForDatabasesArcAutoProvisioning model
            = new DefenderForDatabasesGcpOfferingDefenderForDatabasesArcAutoProvisioning()
                .withServiceAccountEmailAddress("doxzn")
                .withWorkloadIdentityProviderId("vdtmuuvd");
        model = BinaryData.fromObject(model)
            .toObject(DefenderForDatabasesGcpOfferingDefenderForDatabasesArcAutoProvisioning.class);
        Assertions.assertEquals("doxzn", model.serviceAccountEmailAddress());
        Assertions.assertEquals("vdtmuuvd", model.workloadIdentityProviderId());
    }
}
