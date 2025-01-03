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
import com.azure.resourcemanager.security.models.DeviceSecurityGroup;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class DeviceSecurityGroupsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"thresholdRules\":[{\"ruleType\":\"ThresholdCustomAlertRule\",\"minThreshold\":815686485,\"maxThreshold\":20355913,\"displayName\":\"rtgqrqkk\",\"description\":\"ygkuo\",\"isEnabled\":true}],\"timeWindowRules\":[{\"ruleType\":\"TimeWindowCustomAlertRule\",\"timeWindowSize\":\"PT151H47M\",\"minThreshold\":938422048,\"maxThreshold\":1941543319,\"displayName\":\"obothx\",\"description\":\"whpnyjtu\",\"isEnabled\":false},{\"ruleType\":\"TimeWindowCustomAlertRule\",\"timeWindowSize\":\"PT76H6M34S\",\"minThreshold\":1845272311,\"maxThreshold\":137974665,\"displayName\":\"xtchslroldowuw\",\"description\":\"lrifiozttcbiich\",\"isEnabled\":true},{\"ruleType\":\"TimeWindowCustomAlertRule\",\"timeWindowSize\":\"PT25H59M22S\",\"minThreshold\":2144896016,\"maxThreshold\":520998590,\"displayName\":\"zo\",\"description\":\"j\",\"isEnabled\":true}],\"allowlistRules\":[{\"ruleType\":\"AllowlistCustomAlertRule\",\"allowlistValues\":[\"xryqycymzr\",\"cfgdwzauz\"],\"valueType\":\"IpCidr\",\"displayName\":\"adnyciwzki\",\"description\":\"kqadfgesvzohabb\",\"isEnabled\":true},{\"ruleType\":\"AllowlistCustomAlertRule\",\"allowlistValues\":[\"madjrsbga\",\"ljqovqmxqsxo\",\"xqnkiuokg\"],\"valueType\":\"String\",\"displayName\":\"ooiobhiebruptl\",\"description\":\"vqzgaqsosrnj\",\"isEnabled\":false}],\"denylistRules\":[{\"ruleType\":\"DenylistCustomAlertRule\",\"denylistValues\":[\"hnhuoxrqhjni\",\"pesw\"],\"valueType\":\"IpCidr\",\"displayName\":\"kge\",\"description\":\"qzmcsviuj\",\"isEnabled\":false}]},\"id\":\"zdvmsnao\",\"name\":\"xsxoxvimdvet\",\"type\":\"hdbitq\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityManager manager = SecurityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<DeviceSecurityGroup> response
            = manager.deviceSecurityGroups().list("ylnkmmxzifbqg", com.azure.core.util.Context.NONE);

        Assertions.assertEquals(true, response.iterator().next().thresholdRules().get(0).isEnabled());
        Assertions.assertEquals(815686485, response.iterator().next().thresholdRules().get(0).minThreshold());
        Assertions.assertEquals(20355913, response.iterator().next().thresholdRules().get(0).maxThreshold());
        Assertions.assertEquals(false, response.iterator().next().timeWindowRules().get(0).isEnabled());
        Assertions.assertEquals(938422048, response.iterator().next().timeWindowRules().get(0).minThreshold());
        Assertions.assertEquals(1941543319, response.iterator().next().timeWindowRules().get(0).maxThreshold());
        Assertions.assertEquals(Duration.parse("PT151H47M"),
            response.iterator().next().timeWindowRules().get(0).timeWindowSize());
        Assertions.assertEquals(true, response.iterator().next().allowlistRules().get(0).isEnabled());
        Assertions.assertEquals("xryqycymzr",
            response.iterator().next().allowlistRules().get(0).allowlistValues().get(0));
        Assertions.assertEquals(false, response.iterator().next().denylistRules().get(0).isEnabled());
        Assertions.assertEquals("hnhuoxrqhjni",
            response.iterator().next().denylistRules().get(0).denylistValues().get(0));
    }
}
