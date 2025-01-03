// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kusto.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.kusto.KustoManager;
import com.azure.resourcemanager.kusto.models.Language;
import com.azure.resourcemanager.kusto.models.SandboxCustomImage;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SandboxCustomImagesCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"language\":\"Python\",\"languageVersion\":\"tqpbrlcy\",\"requirementsFileContent\":\"uczkgofxyfsruc\",\"provisioningState\":\"Succeeded\"},\"id\":\"rpcjttbstvjeaqnr\",\"name\":\"vvf\",\"type\":\"oxmlghktuidv\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        KustoManager manager = KustoManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        SandboxCustomImage response = manager.sandboxCustomImages()
            .define("aq")
            .withExistingCluster("gvvpasek", "gbuxantuygdh")
            .withLanguage(Language.PYTHON)
            .withLanguageVersion("rpiwrqofulo")
            .withRequirementsFileContent("jnlex")
            .create();

        Assertions.assertEquals(Language.PYTHON, response.language());
        Assertions.assertEquals("tqpbrlcy", response.languageVersion());
        Assertions.assertEquals("uczkgofxyfsruc", response.requirementsFileContent());
    }
}
