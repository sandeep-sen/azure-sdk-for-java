// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.TopologyResourceProperties;

public final class TopologyResourcePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TopologyResourceProperties model = BinaryData.fromString(
            "{\"calculatedDateTime\":\"2021-01-01T00:58:20Z\",\"topologyResources\":[{\"resourceId\":\"qjbedpfix\",\"severity\":\"upmomihzbd\",\"recommendationsExist\":false,\"networkZones\":\"kcdpreyxelyi\",\"topologyScore\":1757022788,\"location\":\"lrufssjygh\",\"parents\":[{\"resourceId\":\"kb\"},{\"resourceId\":\"mmgmqf\"},{\"resourceId\":\"fgvqcpdw\"},{\"resourceId\":\"quxweyslandkd\"}],\"children\":[{\"resourceId\":\"unhghcgawnr\"},{\"resourceId\":\"quox\"},{\"resourceId\":\"tireimse\"}]},{\"resourceId\":\"fsxstcyil\",\"severity\":\"zmmx\",\"recommendationsExist\":false,\"networkZones\":\"quzexokjxebjvbz\",\"topologyScore\":1936982399,\"location\":\"bwmvogljsvl\",\"parents\":[{\"resourceId\":\"nwcehaqidoyzl\"},{\"resourceId\":\"iomqoqpepiaea\"}],\"children\":[{\"resourceId\":\"rgdtpeqnacyheqw\"},{\"resourceId\":\"qq\"}]},{\"resourceId\":\"jubkhjozfymcwmb\",\"severity\":\"yvqyvliqiips\",\"recommendationsExist\":false,\"networkZones\":\"vsi\",\"topologyScore\":1281721808,\"location\":\"whddzydisnuepyw\",\"parents\":[{\"resourceId\":\"ldpxott\"},{\"resourceId\":\"i\"}],\"children\":[{\"resourceId\":\"ibz\"},{\"resourceId\":\"hweebiph\"}]},{\"resourceId\":\"vcjwqwoqsratj\",\"severity\":\"hzybspijhfrz\",\"recommendationsExist\":true,\"networkZones\":\"agvwukhs\",\"topologyScore\":313271072,\"location\":\"orfmzhwilzz\",\"parents\":[{\"resourceId\":\"mriprlk\"},{\"resourceId\":\"eyttlrcxiv\"}],\"children\":[{\"resourceId\":\"tpumltwjfluxynb\"},{\"resourceId\":\"zlqywauyqn\"}]}]}")
            .toObject(TopologyResourceProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TopologyResourceProperties model = new TopologyResourceProperties();
        model = BinaryData.fromObject(model).toObject(TopologyResourceProperties.class);
    }
}
