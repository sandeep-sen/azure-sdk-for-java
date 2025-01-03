// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.GovernanceAssignmentProperties;
import com.azure.resourcemanager.security.models.GovernanceAssignmentAdditionalData;
import com.azure.resourcemanager.security.models.GovernanceEmailNotification;
import com.azure.resourcemanager.security.models.RemediationEta;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;

public final class GovernanceAssignmentPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        GovernanceAssignmentProperties model = BinaryData.fromString(
            "{\"owner\":\"dlxyjrxs\",\"remediationDueDate\":\"2021-10-04T04:25:34Z\",\"remediationEta\":{\"eta\":\"2021-06-03T10:11:42Z\",\"justification\":\"cnihgwqapnedgfbc\"},\"isGracePeriod\":true,\"governanceEmailNotification\":{\"disableManagerEmailNotification\":false,\"disableOwnerEmailNotification\":true},\"additionalData\":{\"ticketNumber\":1022685385,\"ticketLink\":\"vdrhvoo\",\"ticketStatus\":\"otbobzdopcj\"}}")
            .toObject(GovernanceAssignmentProperties.class);
        Assertions.assertEquals("dlxyjrxs", model.owner());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-04T04:25:34Z"), model.remediationDueDate());
        Assertions.assertEquals(OffsetDateTime.parse("2021-06-03T10:11:42Z"), model.remediationEta().eta());
        Assertions.assertEquals("cnihgwqapnedgfbc", model.remediationEta().justification());
        Assertions.assertEquals(true, model.isGracePeriod());
        Assertions.assertEquals(false, model.governanceEmailNotification().disableManagerEmailNotification());
        Assertions.assertEquals(true, model.governanceEmailNotification().disableOwnerEmailNotification());
        Assertions.assertEquals(1022685385, model.additionalData().ticketNumber());
        Assertions.assertEquals("vdrhvoo", model.additionalData().ticketLink());
        Assertions.assertEquals("otbobzdopcj", model.additionalData().ticketStatus());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        GovernanceAssignmentProperties model = new GovernanceAssignmentProperties().withOwner("dlxyjrxs")
            .withRemediationDueDate(OffsetDateTime.parse("2021-10-04T04:25:34Z"))
            .withRemediationEta(new RemediationEta().withEta(OffsetDateTime.parse("2021-06-03T10:11:42Z"))
                .withJustification("cnihgwqapnedgfbc"))
            .withIsGracePeriod(true)
            .withGovernanceEmailNotification(
                new GovernanceEmailNotification().withDisableManagerEmailNotification(false)
                    .withDisableOwnerEmailNotification(true))
            .withAdditionalData(new GovernanceAssignmentAdditionalData().withTicketNumber(1022685385)
                .withTicketLink("vdrhvoo")
                .withTicketStatus("otbobzdopcj"));
        model = BinaryData.fromObject(model).toObject(GovernanceAssignmentProperties.class);
        Assertions.assertEquals("dlxyjrxs", model.owner());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-04T04:25:34Z"), model.remediationDueDate());
        Assertions.assertEquals(OffsetDateTime.parse("2021-06-03T10:11:42Z"), model.remediationEta().eta());
        Assertions.assertEquals("cnihgwqapnedgfbc", model.remediationEta().justification());
        Assertions.assertEquals(true, model.isGracePeriod());
        Assertions.assertEquals(false, model.governanceEmailNotification().disableManagerEmailNotification());
        Assertions.assertEquals(true, model.governanceEmailNotification().disableOwnerEmailNotification());
        Assertions.assertEquals(1022685385, model.additionalData().ticketNumber());
        Assertions.assertEquals("vdrhvoo", model.additionalData().ticketLink());
        Assertions.assertEquals("otbobzdopcj", model.additionalData().ticketStatus());
    }
}
