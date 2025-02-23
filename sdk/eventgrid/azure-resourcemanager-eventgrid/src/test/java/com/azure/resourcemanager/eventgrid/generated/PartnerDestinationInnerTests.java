// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.fluent.models.PartnerDestinationInner;
import com.azure.resourcemanager.eventgrid.models.PartnerDestinationActivationState;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;

public final class PartnerDestinationInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PartnerDestinationInner model = BinaryData.fromString(
            "{\"properties\":{\"partnerRegistrationImmutableId\":\"23b1eb9b-a112-4ef8-9a1a-4d2c04f29020\",\"endpointServiceContext\":\"vyklxuby\",\"expirationTimeIfNotActivatedUtc\":\"2021-11-29T09:18:30Z\",\"provisioningState\":\"Canceled\",\"activationState\":\"NeverActivated\",\"endpointBaseUrl\":\"lcqcuubgqibrt\",\"messageForActivation\":\"metttwgd\"},\"location\":\"qxihhrmooi\",\"tags\":{\"etoge\":\"eypxiutcxapzhyr\",\"rqnkkzjcjbtr\":\"joxslhvnhla\",\"eitpkxztmo\":\"aehvvibrxjjstoq\",\"qxzhem\":\"bklftidgfcwqmpim\"},\"id\":\"yhohujswtwkozzwc\",\"name\":\"lkb\",\"type\":\"wpfaj\"}")
            .toObject(PartnerDestinationInner.class);
        Assertions.assertEquals("qxihhrmooi", model.location());
        Assertions.assertEquals("eypxiutcxapzhyr", model.tags().get("etoge"));
        Assertions.assertEquals(UUID.fromString("23b1eb9b-a112-4ef8-9a1a-4d2c04f29020"),
            model.partnerRegistrationImmutableId());
        Assertions.assertEquals("vyklxuby", model.endpointServiceContext());
        Assertions.assertEquals(OffsetDateTime.parse("2021-11-29T09:18:30Z"), model.expirationTimeIfNotActivatedUtc());
        Assertions.assertEquals(PartnerDestinationActivationState.NEVER_ACTIVATED, model.activationState());
        Assertions.assertEquals("lcqcuubgqibrt", model.endpointBaseUrl());
        Assertions.assertEquals("metttwgd", model.messageForActivation());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PartnerDestinationInner model = new PartnerDestinationInner().withLocation("qxihhrmooi")
            .withTags(mapOf("etoge", "eypxiutcxapzhyr", "rqnkkzjcjbtr", "joxslhvnhla", "eitpkxztmo", "aehvvibrxjjstoq",
                "qxzhem", "bklftidgfcwqmpim"))
            .withPartnerRegistrationImmutableId(UUID.fromString("23b1eb9b-a112-4ef8-9a1a-4d2c04f29020"))
            .withEndpointServiceContext("vyklxuby")
            .withExpirationTimeIfNotActivatedUtc(OffsetDateTime.parse("2021-11-29T09:18:30Z"))
            .withActivationState(PartnerDestinationActivationState.NEVER_ACTIVATED)
            .withEndpointBaseUrl("lcqcuubgqibrt")
            .withMessageForActivation("metttwgd");
        model = BinaryData.fromObject(model).toObject(PartnerDestinationInner.class);
        Assertions.assertEquals("qxihhrmooi", model.location());
        Assertions.assertEquals("eypxiutcxapzhyr", model.tags().get("etoge"));
        Assertions.assertEquals(UUID.fromString("23b1eb9b-a112-4ef8-9a1a-4d2c04f29020"),
            model.partnerRegistrationImmutableId());
        Assertions.assertEquals("vyklxuby", model.endpointServiceContext());
        Assertions.assertEquals(OffsetDateTime.parse("2021-11-29T09:18:30Z"), model.expirationTimeIfNotActivatedUtc());
        Assertions.assertEquals(PartnerDestinationActivationState.NEVER_ACTIVATED, model.activationState());
        Assertions.assertEquals("lcqcuubgqibrt", model.endpointBaseUrl());
        Assertions.assertEquals("metttwgd", model.messageForActivation());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
