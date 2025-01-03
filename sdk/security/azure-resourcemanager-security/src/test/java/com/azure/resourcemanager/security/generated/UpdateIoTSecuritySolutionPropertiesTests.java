// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.UpdateIoTSecuritySolutionProperties;
import com.azure.resourcemanager.security.models.RecommendationConfigStatus;
import com.azure.resourcemanager.security.models.RecommendationConfigurationProperties;
import com.azure.resourcemanager.security.models.RecommendationType;
import com.azure.resourcemanager.security.models.UserDefinedResourcesProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class UpdateIoTSecuritySolutionPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UpdateIoTSecuritySolutionProperties model = BinaryData.fromString(
            "{\"userDefinedResources\":{\"query\":\"osbz\",\"querySubscriptions\":[\"hg\",\"vkbcknjolgjyyxp\",\"els\"]},\"recommendationsConfiguration\":[{\"recommendationType\":\"IoT_PermissiveFirewallPolicy\",\"name\":\"evxoqei\",\"status\":\"Enabled\"}]}")
            .toObject(UpdateIoTSecuritySolutionProperties.class);
        Assertions.assertEquals("osbz", model.userDefinedResources().query());
        Assertions.assertEquals("hg", model.userDefinedResources().querySubscriptions().get(0));
        Assertions.assertEquals(RecommendationType.IO_T_PERMISSIVE_FIREWALL_POLICY,
            model.recommendationsConfiguration().get(0).recommendationType());
        Assertions.assertEquals(RecommendationConfigStatus.ENABLED,
            model.recommendationsConfiguration().get(0).status());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UpdateIoTSecuritySolutionProperties model = new UpdateIoTSecuritySolutionProperties()
            .withUserDefinedResources(new UserDefinedResourcesProperties().withQuery("osbz")
                .withQuerySubscriptions(Arrays.asList("hg", "vkbcknjolgjyyxp", "els")))
            .withRecommendationsConfiguration(Arrays.asList(new RecommendationConfigurationProperties()
                .withRecommendationType(RecommendationType.IO_T_PERMISSIVE_FIREWALL_POLICY)
                .withStatus(RecommendationConfigStatus.ENABLED)));
        model = BinaryData.fromObject(model).toObject(UpdateIoTSecuritySolutionProperties.class);
        Assertions.assertEquals("osbz", model.userDefinedResources().query());
        Assertions.assertEquals("hg", model.userDefinedResources().querySubscriptions().get(0));
        Assertions.assertEquals(RecommendationType.IO_T_PERMISSIVE_FIREWALL_POLICY,
            model.recommendationsConfiguration().get(0).recommendationType());
        Assertions.assertEquals(RecommendationConfigStatus.ENABLED,
            model.recommendationsConfiguration().get(0).status());
    }
}
