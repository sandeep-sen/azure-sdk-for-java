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
import com.azure.resourcemanager.security.models.SecurityTask;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class TasksGetResourceGroupLevelTaskWithResponseMockTests {
    @Test
    public void testGetResourceGroupLevelTaskWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"state\":\"millxgjs\",\"creationTimeUtc\":\"2021-01-05T15:30:02Z\",\"securityTaskParameters\":{\"name\":\"soriobijeiydyeu\",\"\":{\"yrgwy\":\"databok\"}},\"lastStateChangeTimeUtc\":\"2021-09-12T11:18:01Z\",\"subState\":\"pdweoft\"},\"id\":\"or\",\"name\":\"a\",\"type\":\"gsioc\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityManager manager = SecurityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        SecurityTask response = manager.tasks()
            .getResourceGroupLevelTaskWithResponse("paslavxjfiuofpi", "idzlvssqywjopa", "kyhydvikmf",
                com.azure.core.util.Context.NONE)
            .getValue();

    }
}
