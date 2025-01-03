// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.security.SecurityManager;
import com.azure.resourcemanager.security.models.EndOfSupportStatus;
import com.azure.resourcemanager.security.models.Software;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SoftwareInventoriesListByExtendedResourceMockTests {
    @Test
    public void testListByExtendedResource() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"deviceId\":\"bsupu\",\"osPlatform\":\"x\",\"vendor\":\"dlhzwhcu\",\"softwareName\":\"bosjjfd\",\"version\":\"hrjqfyaytvslyek\",\"endOfSupportStatus\":\"upcomingNoLongerSupported\",\"endOfSupportDate\":\"uarlcjiwgsxfaioc\",\"numberOfKnownVulnerabilities\":1446003838,\"firstSeenAt\":\"jjgnfgr\"},\"id\":\"xb\",\"name\":\"rcb\",\"type\":\"aefzqsy\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityManager manager = SecurityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<Software> response = manager.softwareInventories()
            .listByExtendedResource("ssf", "pg", "kncjmgvsnvbtqdxf", "jymjnhjluq", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("bsupu", response.iterator().next().deviceId());
        Assertions.assertEquals("x", response.iterator().next().osPlatform());
        Assertions.assertEquals("dlhzwhcu", response.iterator().next().vendor());
        Assertions.assertEquals("bosjjfd", response.iterator().next().softwareName());
        Assertions.assertEquals("hrjqfyaytvslyek", response.iterator().next().version());
        Assertions.assertEquals(EndOfSupportStatus.UPCOMING_NO_LONGER_SUPPORTED,
            response.iterator().next().endOfSupportStatus());
        Assertions.assertEquals("uarlcjiwgsxfaioc", response.iterator().next().endOfSupportDate());
        Assertions.assertEquals(1446003838, response.iterator().next().numberOfKnownVulnerabilities());
        Assertions.assertEquals("jjgnfgr", response.iterator().next().firstSeenAt());
    }
}
