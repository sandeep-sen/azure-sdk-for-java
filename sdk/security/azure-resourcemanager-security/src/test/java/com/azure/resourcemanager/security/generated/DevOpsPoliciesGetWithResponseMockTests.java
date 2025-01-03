// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.security.SecurityManager;
import com.azure.resourcemanager.security.models.DevOpsPolicy;
import com.azure.resourcemanager.security.models.DevOpsPolicySource;
import com.azure.resourcemanager.security.models.DevOpsPolicyType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class DevOpsPoliciesGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningStatusMessage\":\"kjthl\",\"provisioningStatusUpdateTimeUtc\":\"2021-04-20T14:35:48Z\",\"provisioningState\":\"Succeeded\",\"source\":\"Unknown\",\"policyId\":\"abf0336c-1e45-482b-9df9-6a788cfd124a\",\"webUrl\":\"bknge\",\"version\":\"x\",\"type\":\"Unknown\",\"content\":\"ynjmoozmxuk\"},\"id\":\"drsjtmn\",\"name\":\"xjouwfzcfd\",\"type\":\"stiaxtyrnuhc\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityManager manager = SecurityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        DevOpsPolicy response = manager.devOpsPolicies()
            .getWithResponse("jt", "hqsznsyov", "mqcudptoqw", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals(DevOpsPolicySource.UNKNOWN, response.properties().source());
        Assertions.assertEquals("x", response.properties().version());
        Assertions.assertEquals(DevOpsPolicyType.UNKNOWN, response.properties().type());
        Assertions.assertEquals("ynjmoozmxuk", response.properties().content());
    }
}
