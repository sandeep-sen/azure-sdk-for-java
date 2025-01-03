// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callingserver.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;

import java.io.IOException;
import java.util.Objects;

/** The locator used for joining or taking action on a call. */
@Fluent
public final class CallLocatorInternal implements JsonSerializable<CallLocatorInternal> {
    /*
     * The group call id
     */
    private String groupCallId;

    /*
     * The server call id.
     */
    private String serverCallId;

    /*
     * The call locator kind.
     */
    private CallLocatorKindInternal kind;

    /**
     * Get the groupCallId property: The group call id.
     *
     * @return the groupCallId value.
     */
    public String getGroupCallId() {
        return this.groupCallId;
    }

    /**
     * Set the groupCallId property: The group call id.
     *
     * @param groupCallId the groupCallId value to set.
     * @return the CallLocatorInternal object itself.
     */
    public CallLocatorInternal setGroupCallId(String groupCallId) {
        this.groupCallId = groupCallId;
        return this;
    }

    /**
     * Get the serverCallId property: The server call id.
     *
     * @return the serverCallId value.
     */
    public String getServerCallId() {
        return this.serverCallId;
    }

    /**
     * Set the serverCallId property: The server call id.
     *
     * @param serverCallId the serverCallId value to set.
     * @return the CallLocatorInternal object itself.
     */
    public CallLocatorInternal setServerCallId(String serverCallId) {
        this.serverCallId = serverCallId;
        return this;
    }

    /**
     * Get the kind property: The call locator kind.
     *
     * @return the kind value.
     */
    public CallLocatorKindInternal getKind() {
        return this.kind;
    }

    /**
     * Set the kind property: The call locator kind.
     *
     * @param kind the kind value to set.
     * @return the CallLocatorInternal object itself.
     */
    public CallLocatorInternal setKind(CallLocatorKindInternal kind) {
        this.kind = kind;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeStartObject()
            .writeStringField("groupCallId", groupCallId)
            .writeStringField("serverCallId", serverCallId)
            .writeStringField("kind", Objects.toString(kind, null))
            .writeEndObject();
    }

    /**
     * Reads an instance of {@link CallLocatorInternal} from the {@link JsonReader}.
     *
     * @param jsonReader The {@link JsonReader} to read.
     * @return An instance of {@link CallLocatorInternal}, or null if the {@link JsonReader} was pointing to
     * {@link JsonToken#NULL}.
     * @throws IOException If an error occurs while reading the {@link JsonReader}.
     */
    public static CallLocatorInternal fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CallLocatorInternal callLocatorInternal = new CallLocatorInternal();

            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("groupCallId".equals(fieldName)) {
                    callLocatorInternal.groupCallId = reader.getString();
                } else if ("serverCallId".equals(fieldName)) {
                    callLocatorInternal.serverCallId = reader.getString();
                } else if ("kind".equals(fieldName)) {
                    callLocatorInternal.kind = CallLocatorKindInternal.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return callLocatorInternal;
        });
    }
}
