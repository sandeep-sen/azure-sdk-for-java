// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.costmanagement.models.ForecastTimePeriod;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;

public final class ForecastTimePeriodTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ForecastTimePeriod model
            = BinaryData.fromString("{\"from\":\"2021-10-12T22:21:14Z\",\"to\":\"2021-04-27T12:27:55Z\"}")
                .toObject(ForecastTimePeriod.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-12T22:21:14Z"), model.from());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-27T12:27:55Z"), model.to());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ForecastTimePeriod model = new ForecastTimePeriod().withFrom(OffsetDateTime.parse("2021-10-12T22:21:14Z"))
            .withTo(OffsetDateTime.parse("2021-04-27T12:27:55Z"));
        model = BinaryData.fromObject(model).toObject(ForecastTimePeriod.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-12T22:21:14Z"), model.from());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-27T12:27:55Z"), model.to());
    }
}
