// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.GitHubOwnerProperties;
import com.azure.resourcemanager.security.models.OnboardingState;
import org.junit.jupiter.api.Assertions;

public final class GitHubOwnerPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        GitHubOwnerProperties model = BinaryData.fromString(
            "{\"provisioningStatusMessage\":\"o\",\"provisioningStatusUpdateTimeUtc\":\"2021-05-15T23:12:25Z\",\"provisioningState\":\"Pending\",\"ownerUrl\":\"qjwt\",\"gitHubInternalId\":\"tgvgzp\",\"onboardingState\":\"OnboardedByOtherConnector\"}")
            .toObject(GitHubOwnerProperties.class);
        Assertions.assertEquals(OnboardingState.ONBOARDED_BY_OTHER_CONNECTOR, model.onboardingState());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        GitHubOwnerProperties model
            = new GitHubOwnerProperties().withOnboardingState(OnboardingState.ONBOARDED_BY_OTHER_CONNECTOR);
        model = BinaryData.fromObject(model).toObject(GitHubOwnerProperties.class);
        Assertions.assertEquals(OnboardingState.ONBOARDED_BY_OTHER_CONNECTOR, model.onboardingState());
    }
}
