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
import com.azure.resourcemanager.security.models.ApiCollection;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ApiCollectionsListByAzureApiManagementServiceMockTests {
    @Test
    public void testListByAzureApiManagementService() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Updating\",\"displayName\":\"mxiurpf\",\"discoveredVia\":\"ypmw\",\"baseUrl\":\"ajpcroxpp\",\"numberOfApiEndpoints\":7252009694458903125,\"numberOfInactiveApiEndpoints\":8026258753683360614,\"numberOfUnauthenticatedApiEndpoints\":5559718745875302507,\"numberOfExternalApiEndpoints\":8643034012334766573,\"numberOfApiEndpointsWithSensitiveDataExposed\":1557236881893469468,\"sensitivityLabel\":\"yufdmzucxvzvwlx\"},\"id\":\"jnstz\",\"name\":\"ur\",\"type\":\"oxklrzats\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityManager manager = SecurityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<ApiCollection> response = manager.apiCollections()
            .listByAzureApiManagementService("bxrgrztkyqgu", "uuihkybgkyncyzj", com.azure.core.util.Context.NONE);

    }
}
