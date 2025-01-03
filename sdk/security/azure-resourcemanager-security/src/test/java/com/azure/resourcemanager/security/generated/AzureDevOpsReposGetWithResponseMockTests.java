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
import com.azure.resourcemanager.security.models.ActionableRemediationState;
import com.azure.resourcemanager.security.models.AnnotateDefaultBranchState;
import com.azure.resourcemanager.security.models.AzureDevOpsRepository;
import com.azure.resourcemanager.security.models.InheritFromParentState;
import com.azure.resourcemanager.security.models.OnboardingState;
import com.azure.resourcemanager.security.models.RuleCategory;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class AzureDevOpsReposGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningStatusMessage\":\"jzdebhsermcly\",\"provisioningStatusUpdateTimeUtc\":\"2021-12-10T17:53:44Z\",\"provisioningState\":\"Succeeded\",\"parentOrgName\":\"qkaaptbssvkbcbpt\",\"parentProjectName\":\"bloccu\",\"repoId\":\"lxzbnsshvqn\",\"repoUrl\":\"zbeuybutcdzjf\",\"visibility\":\"vpeyxdyuxurxr\",\"onboardingState\":\"OnboardedByOtherConnector\",\"actionableRemediation\":{\"state\":\"Disabled\",\"categoryConfigurations\":[{\"minimumSeverityLevel\":\"qfkwnaeikczscymq\",\"category\":\"Containers\"}],\"branchConfiguration\":{\"branchNames\":[\"qnyumz\",\"pd\",\"kezvpe\"],\"annotateDefaultBranch\":\"Enabled\"},\"inheritFromParentState\":\"Enabled\"}},\"id\":\"qnzbflbqmhbiy\",\"name\":\"xvwedhag\",\"type\":\"bbsesea\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityManager manager = SecurityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        AzureDevOpsRepository response = manager.azureDevOpsRepos()
            .getWithResponse("urnowobwxrxmyo", "ohlsfjf", "uqjpzh", "ahuvkqxqkvadmjh", "mud",
                com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("qkaaptbssvkbcbpt", response.properties().parentOrgName());
        Assertions.assertEquals("bloccu", response.properties().parentProjectName());
        Assertions.assertEquals(OnboardingState.ONBOARDED_BY_OTHER_CONNECTOR, response.properties().onboardingState());
        Assertions.assertEquals(ActionableRemediationState.DISABLED,
            response.properties().actionableRemediation().state());
        Assertions.assertEquals("qfkwnaeikczscymq",
            response.properties().actionableRemediation().categoryConfigurations().get(0).minimumSeverityLevel());
        Assertions.assertEquals(RuleCategory.CONTAINERS,
            response.properties().actionableRemediation().categoryConfigurations().get(0).category());
        Assertions.assertEquals("qnyumz",
            response.properties().actionableRemediation().branchConfiguration().branchNames().get(0));
        Assertions.assertEquals(AnnotateDefaultBranchState.ENABLED,
            response.properties().actionableRemediation().branchConfiguration().annotateDefaultBranch());
        Assertions.assertEquals(InheritFromParentState.ENABLED,
            response.properties().actionableRemediation().inheritFromParentState());
    }
}
