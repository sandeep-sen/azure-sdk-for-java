// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Health status of last 20 seconds.
 */
public final class LiveEventHealthStatus extends ExpandableStringEnum<LiveEventHealthStatus> {
    /**
     * Static value Excellent for LiveEventHealthStatus.
     */
    public static final LiveEventHealthStatus EXCELLENT = fromString("Excellent");

    /**
     * Static value Good for LiveEventHealthStatus.
     */
    public static final LiveEventHealthStatus GOOD = fromString("Good");

    /**
     * Static value Poor for LiveEventHealthStatus.
     */
    public static final LiveEventHealthStatus POOR = fromString("Poor");

    /**
     * Creates a new instance of LiveEventHealthStatus value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public LiveEventHealthStatus() {
    }

    /**
     * Creates or finds a LiveEventHealthStatus from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding LiveEventHealthStatus.
     */
    public static LiveEventHealthStatus fromString(String name) {
        return fromString(name, LiveEventHealthStatus.class);
    }

    /**
     * Gets known LiveEventHealthStatus values.
     * 
     * @return known LiveEventHealthStatus values.
     */
    public static Collection<LiveEventHealthStatus> values() {
        return values(LiveEventHealthStatus.class);
    }
}
