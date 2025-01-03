// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.managednetworkfabric.fluent.models.NetworkTapRuleInner;
import com.azure.resourcemanager.managednetworkfabric.models.CommonDynamicMatchConfiguration;
import com.azure.resourcemanager.managednetworkfabric.models.ConfigurationType;
import com.azure.resourcemanager.managednetworkfabric.models.IpAddressType;
import com.azure.resourcemanager.managednetworkfabric.models.IpGroupProperties;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkTapRuleAction;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkTapRuleMatchCondition;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkTapRuleMatchConfiguration;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkTapRulesListResult;
import com.azure.resourcemanager.managednetworkfabric.models.PollingIntervalInSeconds;
import com.azure.resourcemanager.managednetworkfabric.models.PortGroupProperties;
import com.azure.resourcemanager.managednetworkfabric.models.VlanGroupProperties;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class NetworkTapRulesListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NetworkTapRulesListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"networkTapId\":\"qh\",\"pollingIntervalInSeconds\":60,\"lastSyncedTime\":\"2021-05-19T12:21:06Z\",\"configurationState\":\"Succeeded\",\"provisioningState\":\"Succeeded\",\"administrativeState\":\"Enabled\",\"configurationType\":\"File\",\"tapRulesUrl\":\"vbvx\",\"matchConfigurations\":[{\"matchConfigurationName\":\"enlrjcsmwevgu\",\"sequenceNumber\":3641911805209378415,\"ipAddressType\":\"IPv6\",\"matchConditions\":[{}],\"actions\":[{},{},{},{}]},{\"matchConfigurationName\":\"zcdeto\",\"sequenceNumber\":5633343192239688625,\"ipAddressType\":\"IPv4\",\"matchConditions\":[{}],\"actions\":[{},{}]}],\"dynamicMatchConfigurations\":[{\"ipGroups\":[{},{}],\"vlanGroups\":[{},{}],\"portGroups\":[{},{},{}]},{\"ipGroups\":[{},{}],\"vlanGroups\":[{},{},{}],\"portGroups\":[{},{}]},{\"ipGroups\":[{},{},{},{}],\"vlanGroups\":[{}],\"portGroups\":[{}]},{\"ipGroups\":[{},{},{},{}],\"vlanGroups\":[{},{},{},{}],\"portGroups\":[{},{},{}]}],\"annotation\":\"jyhzfaxskdvu\"},\"location\":\"umo\",\"tags\":{\"sorch\":\"gq\",\"kbmpw\":\"zrqoxzyhlbeqvh\",\"zgaefhawkmib\":\"slajgg\",\"wi\":\"y\"},\"id\":\"rnicupdyttqmi\",\"name\":\"vj\",\"type\":\"l\"},{\"properties\":{\"networkTapId\":\"ebmhhtuq\",\"pollingIntervalInSeconds\":60,\"lastSyncedTime\":\"2021-11-29T08:34:34Z\",\"configurationState\":\"Provisioning\",\"provisioningState\":\"Succeeded\",\"administrativeState\":\"Enabled\",\"configurationType\":\"Inline\",\"tapRulesUrl\":\"ngxebihexhnk\",\"matchConfigurations\":[{\"matchConfigurationName\":\"qcdol\",\"sequenceNumber\":1306450790437008316,\"ipAddressType\":\"IPv6\",\"matchConditions\":[{}],\"actions\":[{},{}]},{\"matchConfigurationName\":\"ndaf\",\"sequenceNumber\":8346440145061268112,\"ipAddressType\":\"IPv6\",\"matchConditions\":[{},{},{}],\"actions\":[{},{},{},{}]},{\"matchConfigurationName\":\"hpplz\",\"sequenceNumber\":6540366081194941470,\"ipAddressType\":\"IPv6\",\"matchConditions\":[{}],\"actions\":[{},{}]}],\"dynamicMatchConfigurations\":[{\"ipGroups\":[{},{}],\"vlanGroups\":[{},{},{}],\"portGroups\":[{},{},{},{}]},{\"ipGroups\":[{},{},{},{}],\"vlanGroups\":[{},{}],\"portGroups\":[{},{}]},{\"ipGroups\":[{},{},{}],\"vlanGroups\":[{},{},{},{}],\"portGroups\":[{},{},{}]},{\"ipGroups\":[{}],\"vlanGroups\":[{},{},{}],\"portGroups\":[{},{},{},{}]}],\"annotation\":\"wjvrlgqpwwlzpd\"},\"location\":\"rcbcdwhslxe\",\"tags\":{\"oprwkampyh\":\"adknmstb\"},\"id\":\"pbldz\",\"name\":\"iudrcycmwhuzym\",\"type\":\"lhihqkn\"},{\"properties\":{\"networkTapId\":\"kmnbzko\",\"pollingIntervalInSeconds\":60,\"lastSyncedTime\":\"2021-11-04T18:07:20Z\",\"configurationState\":\"Deprovisioned\",\"provisioningState\":\"Deleting\",\"administrativeState\":\"Disabled\",\"configurationType\":\"Inline\",\"tapRulesUrl\":\"xsyjofpgved\",\"matchConfigurations\":[{\"matchConfigurationName\":\"jnjgyb\",\"sequenceNumber\":3081568456009405224,\"ipAddressType\":\"IPv4\",\"matchConditions\":[{},{},{},{}],\"actions\":[{},{},{},{}]},{\"matchConfigurationName\":\"l\",\"sequenceNumber\":4032761014302250041,\"ipAddressType\":\"IPv4\",\"matchConditions\":[{}],\"actions\":[{},{}]},{\"matchConfigurationName\":\"ytslg\",\"sequenceNumber\":4807067230273446470,\"ipAddressType\":\"IPv4\",\"matchConditions\":[{},{},{},{}],\"actions\":[{},{},{}]},{\"matchConfigurationName\":\"kyqzjsdkpvnr\",\"sequenceNumber\":1950278585844333204,\"ipAddressType\":\"IPv6\",\"matchConditions\":[{},{},{},{}],\"actions\":[{}]}],\"dynamicMatchConfigurations\":[{\"ipGroups\":[{}],\"vlanGroups\":[{},{},{}],\"portGroups\":[{}]}],\"annotation\":\"flyuvbgtz\"},\"location\":\"qweuydyb\",\"tags\":{\"zeogeatr\":\"rvhpqsv\",\"rfcs\":\"nqnvnc\",\"zsqbibaaugicovj\":\"vjnkoiz\"},\"id\":\"mvwrmjxyvuodnx\",\"name\":\"zbassqfyy\",\"type\":\"wppeygk\"},{\"properties\":{\"networkTapId\":\"bloasyb\",\"pollingIntervalInSeconds\":90,\"lastSyncedTime\":\"2021-11-03T20:44:03Z\",\"configurationState\":\"Accepted\",\"provisioningState\":\"Succeeded\",\"administrativeState\":\"Disabled\",\"configurationType\":\"File\",\"tapRulesUrl\":\"sqjsrvjnqtaqgxqb\",\"matchConfigurations\":[{\"matchConfigurationName\":\"incnrecjbiywev\",\"sequenceNumber\":8939098849713135757,\"ipAddressType\":\"IPv6\",\"matchConditions\":[{}],\"actions\":[{}]}],\"dynamicMatchConfigurations\":[{\"ipGroups\":[{}],\"vlanGroups\":[{},{},{}],\"portGroups\":[{},{},{},{}]},{\"ipGroups\":[{}],\"vlanGroups\":[{},{}],\"portGroups\":[{},{},{},{}]},{\"ipGroups\":[{},{}],\"vlanGroups\":[{},{},{},{}],\"portGroups\":[{},{},{}]}],\"annotation\":\"vhgsulwvgseuf\"},\"location\":\"v\",\"tags\":{\"ilmciwu\":\"uz\",\"lbzdlbybpaxh\":\"yzekypyovl\"},\"id\":\"zyso\",\"name\":\"snwbhanzgesfhsha\",\"type\":\"pahnezp\"}],\"nextLink\":\"fyvynpmgg\"}")
            .toObject(NetworkTapRulesListResult.class);
        Assertions.assertEquals("umo", model.value().get(0).location());
        Assertions.assertEquals("gq", model.value().get(0).tags().get("sorch"));
        Assertions.assertEquals(PollingIntervalInSeconds.SIX_ZERO, model.value().get(0).pollingIntervalInSeconds());
        Assertions.assertEquals(ConfigurationType.FILE, model.value().get(0).configurationType());
        Assertions.assertEquals("vbvx", model.value().get(0).tapRulesUrl());
        Assertions.assertEquals("enlrjcsmwevgu",
            model.value().get(0).matchConfigurations().get(0).matchConfigurationName());
        Assertions.assertEquals(3641911805209378415L,
            model.value().get(0).matchConfigurations().get(0).sequenceNumber());
        Assertions.assertEquals(IpAddressType.IPV6, model.value().get(0).matchConfigurations().get(0).ipAddressType());
        Assertions.assertEquals("jyhzfaxskdvu", model.value().get(0).annotation());
        Assertions.assertEquals("fyvynpmgg", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NetworkTapRulesListResult model
            = new NetworkTapRulesListResult()
                .withValue(
                    Arrays
                        .asList(
                            new NetworkTapRuleInner().withLocation("umo")
                                .withTags(mapOf("sorch", "gq", "kbmpw", "zrqoxzyhlbeqvh", "zgaefhawkmib", "slajgg",
                                    "wi", "y"))
                                .withPollingIntervalInSeconds(PollingIntervalInSeconds.SIX_ZERO)
                                .withConfigurationType(ConfigurationType.FILE)
                                .withTapRulesUrl("vbvx")
                                .withMatchConfigurations(Arrays.asList(
                                    new NetworkTapRuleMatchConfiguration().withMatchConfigurationName("enlrjcsmwevgu")
                                        .withSequenceNumber(3641911805209378415L)
                                        .withIpAddressType(IpAddressType.IPV6)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition()))
                                        .withActions(
                                            Arrays.asList(new NetworkTapRuleAction(), new NetworkTapRuleAction(),
                                                new NetworkTapRuleAction(), new NetworkTapRuleAction())),
                                    new NetworkTapRuleMatchConfiguration()
                                        .withMatchConfigurationName("zcdeto")
                                        .withSequenceNumber(5633343192239688625L)
                                        .withIpAddressType(IpAddressType.IPV4)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition()))
                                        .withActions(
                                            Arrays.asList(new NetworkTapRuleAction(), new NetworkTapRuleAction()))))
                                .withDynamicMatchConfigurations(Arrays.asList(new CommonDynamicMatchConfiguration()
                                    .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties()))
                                    .withVlanGroups(Arrays.asList(new VlanGroupProperties(), new VlanGroupProperties()))
                                    .withPortGroups(Arrays.asList(new PortGroupProperties(), new PortGroupProperties(),
                                        new PortGroupProperties())),
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties()))
                                        .withVlanGroups(
                                            Arrays.asList(new VlanGroupProperties(), new VlanGroupProperties(),
                                                new VlanGroupProperties()))
                                        .withPortGroups(
                                            Arrays.asList(new PortGroupProperties(), new PortGroupProperties())),
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties(),
                                            new IpGroupProperties(), new IpGroupProperties()))
                                        .withVlanGroups(Arrays.asList(new VlanGroupProperties()))
                                        .withPortGroups(Arrays.asList(new PortGroupProperties())),
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties(),
                                            new IpGroupProperties(), new IpGroupProperties()))
                                        .withVlanGroups(
                                            Arrays.asList(new VlanGroupProperties(), new VlanGroupProperties(),
                                                new VlanGroupProperties(), new VlanGroupProperties()))
                                        .withPortGroups(
                                            Arrays.asList(new PortGroupProperties(), new PortGroupProperties(),
                                                new PortGroupProperties()))))
                                .withAnnotation("jyhzfaxskdvu"),
                            new NetworkTapRuleInner().withLocation("rcbcdwhslxe")
                                .withTags(mapOf("oprwkampyh", "adknmstb"))
                                .withPollingIntervalInSeconds(PollingIntervalInSeconds.SIX_ZERO)
                                .withConfigurationType(ConfigurationType.INLINE)
                                .withTapRulesUrl("ngxebihexhnk")
                                .withMatchConfigurations(Arrays.asList(
                                    new NetworkTapRuleMatchConfiguration().withMatchConfigurationName("qcdol")
                                        .withSequenceNumber(1306450790437008316L)
                                        .withIpAddressType(IpAddressType.IPV6)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition()))
                                        .withActions(
                                            Arrays.asList(new NetworkTapRuleAction(), new NetworkTapRuleAction())),
                                    new NetworkTapRuleMatchConfiguration().withMatchConfigurationName("ndaf")
                                        .withSequenceNumber(8346440145061268112L)
                                        .withIpAddressType(IpAddressType.IPV6)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition(),
                                            new NetworkTapRuleMatchCondition(), new NetworkTapRuleMatchCondition()))
                                        .withActions(
                                            Arrays.asList(new NetworkTapRuleAction(), new NetworkTapRuleAction(),
                                                new NetworkTapRuleAction(), new NetworkTapRuleAction())),
                                    new NetworkTapRuleMatchConfiguration()
                                        .withMatchConfigurationName("hpplz")
                                        .withSequenceNumber(6540366081194941470L)
                                        .withIpAddressType(IpAddressType.IPV6)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition()))
                                        .withActions(
                                            Arrays.asList(new NetworkTapRuleAction(), new NetworkTapRuleAction()))))
                                .withDynamicMatchConfigurations(Arrays.asList(
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties()))
                                        .withVlanGroups(Arrays.asList(new VlanGroupProperties(),
                                            new VlanGroupProperties(), new VlanGroupProperties()))
                                        .withPortGroups(
                                            Arrays.asList(new PortGroupProperties(), new PortGroupProperties(),
                                                new PortGroupProperties(), new PortGroupProperties())),
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties(),
                                            new IpGroupProperties(), new IpGroupProperties()))
                                        .withVlanGroups(
                                            Arrays.asList(new VlanGroupProperties(), new VlanGroupProperties()))
                                        .withPortGroups(
                                            Arrays.asList(new PortGroupProperties(), new PortGroupProperties())),
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties(),
                                            new IpGroupProperties()))
                                        .withVlanGroups(
                                            Arrays.asList(new VlanGroupProperties(), new VlanGroupProperties(),
                                                new VlanGroupProperties(), new VlanGroupProperties()))
                                        .withPortGroups(Arrays.asList(new PortGroupProperties(),
                                            new PortGroupProperties(), new PortGroupProperties())),
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties()))
                                        .withVlanGroups(Arrays.asList(new VlanGroupProperties(),
                                            new VlanGroupProperties(), new VlanGroupProperties()))
                                        .withPortGroups(
                                            Arrays.asList(new PortGroupProperties(), new PortGroupProperties(),
                                                new PortGroupProperties(), new PortGroupProperties()))))
                                .withAnnotation("wjvrlgqpwwlzpd"),
                            new NetworkTapRuleInner().withLocation("qweuydyb")
                                .withTags(mapOf("zeogeatr", "rvhpqsv", "rfcs", "nqnvnc", "zsqbibaaugicovj", "vjnkoiz"))
                                .withPollingIntervalInSeconds(PollingIntervalInSeconds.SIX_ZERO)
                                .withConfigurationType(ConfigurationType.INLINE)
                                .withTapRulesUrl("xsyjofpgved")
                                .withMatchConfigurations(Arrays.asList(
                                    new NetworkTapRuleMatchConfiguration().withMatchConfigurationName("jnjgyb")
                                        .withSequenceNumber(3081568456009405224L)
                                        .withIpAddressType(IpAddressType.IPV4)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition(),
                                            new NetworkTapRuleMatchCondition(), new NetworkTapRuleMatchCondition(),
                                            new NetworkTapRuleMatchCondition()))
                                        .withActions(
                                            Arrays.asList(new NetworkTapRuleAction(), new NetworkTapRuleAction(),
                                                new NetworkTapRuleAction(), new NetworkTapRuleAction())),
                                    new NetworkTapRuleMatchConfiguration().withMatchConfigurationName("l")
                                        .withSequenceNumber(4032761014302250041L)
                                        .withIpAddressType(IpAddressType.IPV4)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition()))
                                        .withActions(
                                            Arrays.asList(new NetworkTapRuleAction(), new NetworkTapRuleAction())),
                                    new NetworkTapRuleMatchConfiguration().withMatchConfigurationName("ytslg")
                                        .withSequenceNumber(4807067230273446470L)
                                        .withIpAddressType(IpAddressType.IPV4)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition(),
                                            new NetworkTapRuleMatchCondition(), new NetworkTapRuleMatchCondition(),
                                            new NetworkTapRuleMatchCondition()))
                                        .withActions(Arrays.asList(new NetworkTapRuleAction(),
                                            new NetworkTapRuleAction(), new NetworkTapRuleAction())),
                                    new NetworkTapRuleMatchConfiguration().withMatchConfigurationName("kyqzjsdkpvnr")
                                        .withSequenceNumber(1950278585844333204L)
                                        .withIpAddressType(IpAddressType.IPV6)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition(),
                                            new NetworkTapRuleMatchCondition(), new NetworkTapRuleMatchCondition(),
                                            new NetworkTapRuleMatchCondition()))
                                        .withActions(Arrays.asList(new NetworkTapRuleAction()))))
                                .withDynamicMatchConfigurations(
                                    Arrays.asList(new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties()))
                                        .withVlanGroups(Arrays.asList(new VlanGroupProperties(),
                                            new VlanGroupProperties(), new VlanGroupProperties()))
                                        .withPortGroups(Arrays.asList(new PortGroupProperties()))))
                                .withAnnotation("flyuvbgtz"),
                            new NetworkTapRuleInner().withLocation("v")
                                .withTags(mapOf("ilmciwu", "uz", "lbzdlbybpaxh", "yzekypyovl"))
                                .withPollingIntervalInSeconds(PollingIntervalInSeconds.NINE_ZERO)
                                .withConfigurationType(ConfigurationType.FILE)
                                .withTapRulesUrl("sqjsrvjnqtaqgxqb")
                                .withMatchConfigurations(
                                    Arrays.asList(new NetworkTapRuleMatchConfiguration()
                                        .withMatchConfigurationName("incnrecjbiywev")
                                        .withSequenceNumber(8939098849713135757L)
                                        .withIpAddressType(IpAddressType.IPV6)
                                        .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition()))
                                        .withActions(Arrays.asList(new NetworkTapRuleAction()))))
                                .withDynamicMatchConfigurations(Arrays.asList(
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties()))
                                        .withVlanGroups(Arrays.asList(new VlanGroupProperties(),
                                            new VlanGroupProperties(), new VlanGroupProperties()))
                                        .withPortGroups(
                                            Arrays.asList(
                                                new PortGroupProperties(), new PortGroupProperties(),
                                                new PortGroupProperties(), new PortGroupProperties())),
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties()))
                                        .withVlanGroups(
                                            Arrays.asList(new VlanGroupProperties(), new VlanGroupProperties()))
                                        .withPortGroups(
                                            Arrays.asList(new PortGroupProperties(), new PortGroupProperties(),
                                                new PortGroupProperties(), new PortGroupProperties())),
                                    new CommonDynamicMatchConfiguration()
                                        .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties()))
                                        .withVlanGroups(
                                            Arrays.asList(new VlanGroupProperties(), new VlanGroupProperties(),
                                                new VlanGroupProperties(), new VlanGroupProperties()))
                                        .withPortGroups(Arrays.asList(new PortGroupProperties(),
                                            new PortGroupProperties(), new PortGroupProperties()))))
                                .withAnnotation("vhgsulwvgseuf")))
                .withNextLink("fyvynpmgg");
        model = BinaryData.fromObject(model).toObject(NetworkTapRulesListResult.class);
        Assertions.assertEquals("umo", model.value().get(0).location());
        Assertions.assertEquals("gq", model.value().get(0).tags().get("sorch"));
        Assertions.assertEquals(PollingIntervalInSeconds.SIX_ZERO, model.value().get(0).pollingIntervalInSeconds());
        Assertions.assertEquals(ConfigurationType.FILE, model.value().get(0).configurationType());
        Assertions.assertEquals("vbvx", model.value().get(0).tapRulesUrl());
        Assertions.assertEquals("enlrjcsmwevgu",
            model.value().get(0).matchConfigurations().get(0).matchConfigurationName());
        Assertions.assertEquals(3641911805209378415L,
            model.value().get(0).matchConfigurations().get(0).sequenceNumber());
        Assertions.assertEquals(IpAddressType.IPV6, model.value().get(0).matchConfigurations().get(0).ipAddressType());
        Assertions.assertEquals("jyhzfaxskdvu", model.value().get(0).annotation());
        Assertions.assertEquals("fyvynpmgg", model.nextLink());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
