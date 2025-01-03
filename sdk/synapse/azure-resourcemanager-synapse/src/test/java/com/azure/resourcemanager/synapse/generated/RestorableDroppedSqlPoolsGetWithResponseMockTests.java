// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.synapse.SynapseManager;
import com.azure.resourcemanager.synapse.models.RestorableDroppedSqlPool;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class RestorableDroppedSqlPoolsGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"location\":\"azbkocbygvthrmxk\",\"properties\":{\"databaseName\":\"wwdxomrawp\",\"edition\":\"eboozflyacagaed\",\"maxSizeBytes\":\"i\",\"serviceLevelObjective\":\"lm\",\"elasticPoolName\":\"twgabdx\",\"creationDate\":\"2021-02-21T09:11:08Z\",\"deletionDate\":\"2021-10-20T15:04:31Z\",\"earliestRestoreDate\":\"2021-06-04T19:53:38Z\"},\"id\":\"ecooyvhtuqbp\",\"name\":\"lniibncg\",\"type\":\"gdvcdqhftz\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SynapseManager manager = SynapseManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        RestorableDroppedSqlPool response = manager.restorableDroppedSqlPools()
            .getWithResponse("wawonoehrguql", "fwafbjz", "pyrgu", com.azure.core.util.Context.NONE)
            .getValue();

    }
}
