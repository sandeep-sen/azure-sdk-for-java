// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.managednetworkfabric.models.CommonMatchConditions;
import com.azure.resourcemanager.managednetworkfabric.models.IpMatchCondition;
import com.azure.resourcemanager.managednetworkfabric.models.PrefixType;
import com.azure.resourcemanager.managednetworkfabric.models.SourceDestinationType;
import com.azure.resourcemanager.managednetworkfabric.models.VlanMatchCondition;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class CommonMatchConditionsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CommonMatchConditions model = BinaryData.fromString(
            "{\"protocolTypes\":[\"govibrxkpmloazu\",\"u\"],\"vlanMatchCondition\":{\"vlans\":[\"oorb\",\"eoybfhjxakvvjgs\"],\"innerVlans\":[\"dilmyww\"],\"vlanGroupNames\":[\"kxn\",\"edabgyvudtjue\",\"bcihxuuwhc\"]},\"ipCondition\":{\"type\":\"SourceIP\",\"prefixType\":\"Prefix\",\"ipPrefixValues\":[\"payakkud\",\"px\",\"wjplma\"],\"ipGroupNames\":[\"cyohpfkyrkdbd\",\"iogsjkmnwq\",\"nobaiyhddviacegf\"]}}")
            .toObject(CommonMatchConditions.class);
        Assertions.assertEquals("govibrxkpmloazu", model.protocolTypes().get(0));
        Assertions.assertEquals("oorb", model.vlanMatchCondition().vlans().get(0));
        Assertions.assertEquals("dilmyww", model.vlanMatchCondition().innerVlans().get(0));
        Assertions.assertEquals("kxn", model.vlanMatchCondition().vlanGroupNames().get(0));
        Assertions.assertEquals(SourceDestinationType.SOURCE_IP, model.ipCondition().type());
        Assertions.assertEquals(PrefixType.PREFIX, model.ipCondition().prefixType());
        Assertions.assertEquals("payakkud", model.ipCondition().ipPrefixValues().get(0));
        Assertions.assertEquals("cyohpfkyrkdbd", model.ipCondition().ipGroupNames().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CommonMatchConditions model
            = new CommonMatchConditions().withProtocolTypes(Arrays.asList("govibrxkpmloazu", "u"))
                .withVlanMatchCondition(new VlanMatchCondition().withVlans(Arrays.asList("oorb", "eoybfhjxakvvjgs"))
                    .withInnerVlans(Arrays.asList("dilmyww"))
                    .withVlanGroupNames(Arrays.asList("kxn", "edabgyvudtjue", "bcihxuuwhc")))
                .withIpCondition(new IpMatchCondition().withType(SourceDestinationType.SOURCE_IP)
                    .withPrefixType(PrefixType.PREFIX)
                    .withIpPrefixValues(Arrays.asList("payakkud", "px", "wjplma"))
                    .withIpGroupNames(Arrays.asList("cyohpfkyrkdbd", "iogsjkmnwq", "nobaiyhddviacegf")));
        model = BinaryData.fromObject(model).toObject(CommonMatchConditions.class);
        Assertions.assertEquals("govibrxkpmloazu", model.protocolTypes().get(0));
        Assertions.assertEquals("oorb", model.vlanMatchCondition().vlans().get(0));
        Assertions.assertEquals("dilmyww", model.vlanMatchCondition().innerVlans().get(0));
        Assertions.assertEquals("kxn", model.vlanMatchCondition().vlanGroupNames().get(0));
        Assertions.assertEquals(SourceDestinationType.SOURCE_IP, model.ipCondition().type());
        Assertions.assertEquals(PrefixType.PREFIX, model.ipCondition().prefixType());
        Assertions.assertEquals("payakkud", model.ipCondition().ipPrefixValues().get(0));
        Assertions.assertEquals("cyohpfkyrkdbd", model.ipCondition().ipGroupNames().get(0));
    }
}
