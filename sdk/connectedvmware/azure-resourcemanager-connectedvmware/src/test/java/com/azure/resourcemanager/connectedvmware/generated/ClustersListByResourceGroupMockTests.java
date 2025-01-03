// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.connectedvmware.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager;
import com.azure.resourcemanager.connectedvmware.models.Cluster;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ClustersListByResourceGroupMockTests {
    @Test
    public void testListByResourceGroup() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"uuid\":\"fabuiyjibu\",\"vCenterId\":\"hdugneiknpg\",\"moRefId\":\"gjiuqhibto\",\"inventoryItemId\":\"pqwjedm\",\"moName\":\"r\",\"statuses\":[{\"type\":\"wpktvqylkmqpzoyh\",\"status\":\"bcg\",\"reason\":\"cloxo\",\"message\":\"qinjipnwjf\",\"severity\":\"qlafcbahhpzpofoi\",\"lastUpdatedAt\":\"2021-05-13T07:58:47Z\"}],\"customResourceName\":\"filkmkkholv\",\"usedMemoryGB\":8388081220495319367,\"totalMemoryGB\":3318034223517911241,\"usedCpuMHz\":3026958489306582785,\"totalCpuMHz\":6998870719021995460,\"datastoreIds\":[\"vtiukyef\"],\"networkIds\":[\"mnahmnxh\",\"xjqirwrweoox\"],\"provisioningState\":\"Succeeded\"},\"extendedLocation\":{\"type\":\"xwrsnew\",\"name\":\"zqvbubqm\"},\"kind\":\"sycxhxzgaz\",\"location\":\"taboidvmf\",\"tags\":{\"mtdherngb\":\"pubowsepdfg\"},\"id\":\"c\",\"name\":\"uahokq\",\"type\":\"obkauxofsh\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ConnectedVMwareManager manager = ConnectedVMwareManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<Cluster> response
            = manager.clusters().listByResourceGroup("cvclxynpdk", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("taboidvmf", response.iterator().next().location());
        Assertions.assertEquals("pubowsepdfg", response.iterator().next().tags().get("mtdherngb"));
        Assertions.assertEquals("xwrsnew", response.iterator().next().extendedLocation().type());
        Assertions.assertEquals("zqvbubqm", response.iterator().next().extendedLocation().name());
        Assertions.assertEquals("sycxhxzgaz", response.iterator().next().kind());
        Assertions.assertEquals("hdugneiknpg", response.iterator().next().vCenterId());
        Assertions.assertEquals("gjiuqhibto", response.iterator().next().moRefId());
        Assertions.assertEquals("pqwjedm", response.iterator().next().inventoryItemId());
    }
}
