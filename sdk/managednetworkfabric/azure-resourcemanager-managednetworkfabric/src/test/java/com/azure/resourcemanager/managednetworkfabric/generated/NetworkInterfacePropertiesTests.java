// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.managednetworkfabric.fluent.models.NetworkInterfaceProperties;
import org.junit.jupiter.api.Assertions;

public final class NetworkInterfacePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NetworkInterfaceProperties model = BinaryData.fromString(
            "{\"physicalIdentifier\":\"goljtzxnmxs\",\"connectedTo\":\"bygoo\",\"interfaceType\":\"Management\",\"ipv4Address\":\"pjxvazyjf\",\"ipv6Address\":\"saodj\",\"provisioningState\":\"Accepted\",\"administrativeState\":\"Disabled\",\"annotation\":\"ibfasgmatr\"}")
            .toObject(NetworkInterfaceProperties.class);
        Assertions.assertEquals("ibfasgmatr", model.annotation());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NetworkInterfaceProperties model = new NetworkInterfaceProperties().withAnnotation("ibfasgmatr");
        model = BinaryData.fromObject(model).toObject(NetworkInterfaceProperties.class);
        Assertions.assertEquals("ibfasgmatr", model.annotation());
    }
}
