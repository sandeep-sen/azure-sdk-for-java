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
import com.azure.resourcemanager.security.models.IoTSecurityAggregatedAlert;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class IotSecuritySolutionsAnalyticsAggregatedAlertsGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"alertType\":\"qhhvvwz\",\"alertDisplayName\":\"jaaaiaibtvavly\",\"vendorName\":\"locnwmefzvzuzq\",\"reportedSeverity\":\"Informational\",\"remediationSteps\":\"o\",\"description\":\"bzgy\",\"count\":3065481458320555134,\"effectedResourceType\":\"fyqncow\",\"systemSource\":\"nozf\",\"actionTaken\":\"wjiaaosl\",\"logAnalyticsQuery\":\"agwaakktbjort\",\"topDevicesList\":[{\"deviceId\":\"jqhsns\",\"alertsCount\":4177684236322765278,\"lastOccurrence\":\"slxy\"},{\"deviceId\":\"zbkd\",\"alertsCount\":8228634751471460635,\"lastOccurrence\":\"xgvt\"},{\"deviceId\":\"ctvrpeawzzkvf\",\"alertsCount\":6146958017417675128,\"lastOccurrence\":\"qxsphtraitrmsuk\"},{\"deviceId\":\"uytgcptctxpo\",\"alertsCount\":369162081987363121,\"lastOccurrence\":\"memfvrcclclfkfvy\"}]},\"tags\":{\"oipjy\":\"mwrv\"},\"id\":\"x\",\"name\":\"ebvsewfzvvpay\",\"type\":\"qwh\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityManager manager = SecurityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        IoTSecurityAggregatedAlert response = manager.iotSecuritySolutionsAnalyticsAggregatedAlerts()
            .getWithResponse("khuvnl", "dcnutiexmizun", "bqvioyn", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("mwrv", response.tags().get("oipjy"));
    }
}
