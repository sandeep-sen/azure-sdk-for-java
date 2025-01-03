// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.defendereasm.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.defendereasm.EasmManager;
import com.azure.resourcemanager.defendereasm.fluent.models.LabelResourceInner;
import com.azure.resourcemanager.defendereasm.models.LabelResource;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class LabelsCreateAndUpdateMockTests {
    @Test
    public void testCreateAndUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"displayName\":\"hrdxwzywqsmbs\",\"color\":\"exim\",\"provisioningState\":\"Succeeded\"},\"id\":\"cfsf\",\"name\":\"s\",\"type\":\"mddystkiiux\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        EasmManager manager = EasmManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        LabelResource response = manager.labels()
            .createAndUpdate("v", "ysou", "q",
                new LabelResourceInner().withDisplayName("noae").withColor("fhyhltrpmopjmcma"),
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals("hrdxwzywqsmbs", response.displayName());
        Assertions.assertEquals("exim", response.color());
    }
}
