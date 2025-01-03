// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.securityinsights.SecurityInsightsManager;
import com.azure.resourcemanager.securityinsights.models.IncidentComment;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class IncidentCommentsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"createdTimeUtc\":\"2021-09-10T00:27:10Z\",\"lastModifiedTimeUtc\":\"2021-08-11T02:24:35Z\",\"message\":\"cc\",\"author\":{\"email\":\"fpjmspau\",\"name\":\"qom\",\"objectId\":\"f29f7b24-525d-47a4-9f8f-c651ad352925\",\"userPrincipalName\":\"lknuyapvibzicyvi\"}},\"etag\":\"captkhjxnrkbnvf\",\"id\":\"k\",\"name\":\"z\",\"type\":\"znfgvlx\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityInsightsManager manager = SecurityInsightsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<IncidentComment> response = manager.incidentComments()
            .list("xayzqbyeyw", "mohnrtl", "kffydztkqrfbgy", "zfwvzdteqjmy", "xuhgkaxnypri", 284597579, "oxxjxb",
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals("captkhjxnrkbnvf", response.iterator().next().etag());
        Assertions.assertEquals("cc", response.iterator().next().message());
    }
}
