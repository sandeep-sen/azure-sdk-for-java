// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.deviceupdate.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.deviceupdate.DeviceUpdateManager;
import com.azure.resourcemanager.deviceupdate.models.PrivateEndpointUpdate;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PrivateEndpointConnectionProxiesUpdatePrivateEndpointPropertiesWithResponseMockTests {
    @Test
    public void testUpdatePrivateEndpointPropertiesWithResponse() throws Exception {
        String responseStr = "{}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DeviceUpdateManager manager = DeviceUpdateManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        manager.privateEndpointConnectionProxies()
            .updatePrivateEndpointPropertiesWithResponse("ipwoqonmacjek", "izsh", "vcimpev",
                new PrivateEndpointUpdate().withId("mblrrilbywd")
                    .withLocation("miccwrwfscjfnyn")
                    .withImmutableSubscriptionId("qujizdvo")
                    .withImmutableResourceId("tiby")
                    .withVnetTrafficTag("bblgyavut"),
                com.azure.core.util.Context.NONE);

    }
}
