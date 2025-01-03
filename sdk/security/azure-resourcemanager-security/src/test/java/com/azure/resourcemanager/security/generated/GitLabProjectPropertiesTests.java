// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.GitLabProjectProperties;
import com.azure.resourcemanager.security.models.OnboardingState;
import org.junit.jupiter.api.Assertions;

public final class GitLabProjectPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        GitLabProjectProperties model = BinaryData.fromString(
            "{\"provisioningStatusMessage\":\"hkgmnsg\",\"provisioningStatusUpdateTimeUtc\":\"2021-11-23T07:57:41Z\",\"provisioningState\":\"Canceled\",\"fullyQualifiedName\":\"hdrwjjkh\",\"fullyQualifiedFriendlyName\":\"omacluzvxnqmhr\",\"fullyQualifiedParentGroupName\":\"pd\",\"url\":\"mkoisqcssf\",\"onboardingState\":\"OnboardedByOtherConnector\"}")
            .toObject(GitLabProjectProperties.class);
        Assertions.assertEquals(OnboardingState.ONBOARDED_BY_OTHER_CONNECTOR, model.onboardingState());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        GitLabProjectProperties model
            = new GitLabProjectProperties().withOnboardingState(OnboardingState.ONBOARDED_BY_OTHER_CONNECTOR);
        model = BinaryData.fromObject(model).toObject(GitLabProjectProperties.class);
        Assertions.assertEquals(OnboardingState.ONBOARDED_BY_OTHER_CONNECTOR, model.onboardingState());
    }
}
