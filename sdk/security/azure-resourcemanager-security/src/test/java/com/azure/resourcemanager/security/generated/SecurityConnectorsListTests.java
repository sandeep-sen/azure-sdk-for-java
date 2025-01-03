// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.SecurityConnectorInner;
import com.azure.resourcemanager.security.models.CloudName;
import com.azure.resourcemanager.security.models.CloudOffering;
import com.azure.resourcemanager.security.models.EnvironmentData;
import com.azure.resourcemanager.security.models.SecurityConnectorsList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class SecurityConnectorsListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SecurityConnectorsList model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"hierarchyIdentifier\":\"hm\",\"hierarchyIdentifierTrialEndDate\":\"2021-02-15T15:31:31Z\",\"environmentName\":\"GCP\",\"offerings\":[{\"offeringType\":\"CloudOffering\",\"description\":\"qnzrd\"}],\"environmentData\":{\"environmentType\":\"EnvironmentData\"}},\"location\":\"ovw\",\"tags\":{\"hv\":\"ptgoeiybbabp\",\"igjkskyrio\":\"slkvntjl\",\"mifrygznmma\":\"vzidsxwaab\"},\"id\":\"ri\",\"name\":\"kzobgopxlhsln\",\"type\":\"lxieixynllxecwcr\"},{\"properties\":{\"hierarchyIdentifier\":\"slhcawjutifd\",\"hierarchyIdentifierTrialEndDate\":\"2021-04-21T19:57:43Z\",\"environmentName\":\"JFrog\",\"offerings\":[{\"offeringType\":\"CloudOffering\",\"description\":\"qj\"}],\"environmentData\":{\"environmentType\":\"EnvironmentData\"}},\"location\":\"tzh\",\"tags\":{\"ckpzvcpopmxeln\":\"lkafhonqjuje\"},\"id\":\"clt\",\"name\":\"jedexxmlf\",\"type\":\"kqscazuawxtzx\"},{\"properties\":{\"hierarchyIdentifier\":\"wabzxrvxcushsp\",\"hierarchyIdentifierTrialEndDate\":\"2021-06-11T01:35Z\",\"environmentName\":\"DockerHub\",\"offerings\":[{\"offeringType\":\"CloudOffering\",\"description\":\"sflvgsgzwywakoih\"},{\"offeringType\":\"CloudOffering\",\"description\":\"smjblmljhlnym\"},{\"offeringType\":\"CloudOffering\",\"description\":\"tqyryuzcbmqqv\"}],\"environmentData\":{\"environmentType\":\"EnvironmentData\"}},\"location\":\"vwf\",\"tags\":{\"jlzqnhc\":\"yxonsupe\",\"bgsxgnxfyqonmpq\":\"sqltnzo\",\"iqxeiiqbimht\":\"xwdofdb\"},\"id\":\"wwinhehf\",\"name\":\"pofvwb\",\"type\":\"blembnkbwvqvxkd\"},{\"properties\":{\"hierarchyIdentifier\":\"heb\",\"hierarchyIdentifierTrialEndDate\":\"2021-01-20T17:03:29Z\",\"environmentName\":\"GitLab\",\"offerings\":[{\"offeringType\":\"CloudOffering\",\"description\":\"fmd\"},{\"offeringType\":\"CloudOffering\",\"description\":\"agegiz\"},{\"offeringType\":\"CloudOffering\",\"description\":\"jfelisdjubggbqig\"},{\"offeringType\":\"CloudOffering\",\"description\":\"kbsazgak\"}],\"environmentData\":{\"environmentType\":\"EnvironmentData\"}},\"location\":\"cyrcmjdmspo\",\"tags\":{\"frzgbzjed\":\"vuhrylni\"},\"id\":\"st\",\"name\":\"vnlvxbcuiiznktwf\",\"type\":\"nsnvpd\"}],\"nextLink\":\"mik\"}")
            .toObject(SecurityConnectorsList.class);
        Assertions.assertEquals("ovw", model.value().get(0).location());
        Assertions.assertEquals("ptgoeiybbabp", model.value().get(0).tags().get("hv"));
        Assertions.assertEquals("hm", model.value().get(0).hierarchyIdentifier());
        Assertions.assertEquals(CloudName.GCP, model.value().get(0).environmentName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SecurityConnectorsList model
            = new SecurityConnectorsList()
                .withValue(
                    Arrays.asList(
                        new SecurityConnectorInner().withLocation("ovw")
                            .withTags(
                                mapOf("hv", "ptgoeiybbabp", "igjkskyrio", "slkvntjl", "mifrygznmma", "vzidsxwaab"))
                            .withHierarchyIdentifier("hm")
                            .withEnvironmentName(CloudName.GCP)
                            .withOfferings(Arrays.asList(new CloudOffering()))
                            .withEnvironmentData(new EnvironmentData()),
                        new SecurityConnectorInner().withLocation("tzh")
                            .withTags(mapOf("ckpzvcpopmxeln", "lkafhonqjuje"))
                            .withHierarchyIdentifier("slhcawjutifd")
                            .withEnvironmentName(CloudName.JFROG)
                            .withOfferings(Arrays.asList(new CloudOffering()))
                            .withEnvironmentData(new EnvironmentData()),
                        new SecurityConnectorInner().withLocation("vwf")
                            .withTags(
                                mapOf("jlzqnhc", "yxonsupe", "bgsxgnxfyqonmpq", "sqltnzo", "iqxeiiqbimht", "xwdofdb"))
                            .withHierarchyIdentifier("wabzxrvxcushsp")
                            .withEnvironmentName(CloudName.DOCKER_HUB)
                            .withOfferings(Arrays.asList(new CloudOffering(), new CloudOffering(), new CloudOffering()))
                            .withEnvironmentData(new EnvironmentData()),
                        new SecurityConnectorInner().withLocation("cyrcmjdmspo")
                            .withTags(mapOf("frzgbzjed", "vuhrylni"))
                            .withHierarchyIdentifier("heb")
                            .withEnvironmentName(CloudName.GIT_LAB)
                            .withOfferings(Arrays.asList(new CloudOffering(), new CloudOffering(), new CloudOffering(),
                                new CloudOffering()))
                            .withEnvironmentData(new EnvironmentData())));
        model = BinaryData.fromObject(model).toObject(SecurityConnectorsList.class);
        Assertions.assertEquals("ovw", model.value().get(0).location());
        Assertions.assertEquals("ptgoeiybbabp", model.value().get(0).tags().get("hv"));
        Assertions.assertEquals("hm", model.value().get(0).hierarchyIdentifier());
        Assertions.assertEquals(CloudName.GCP, model.value().get(0).environmentName());
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
