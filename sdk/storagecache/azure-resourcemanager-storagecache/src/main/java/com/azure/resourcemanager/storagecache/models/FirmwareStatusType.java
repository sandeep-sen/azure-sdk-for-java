// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * True if there is a firmware update ready to install on this cache. The firmware will automatically be installed after
 * firmwareUpdateDeadline if not triggered earlier via the upgrade operation.
 */
public final class FirmwareStatusType extends ExpandableStringEnum<FirmwareStatusType> {
    /**
     * Static value available for FirmwareStatusType.
     */
    public static final FirmwareStatusType AVAILABLE = fromString("available");

    /**
     * Static value unavailable for FirmwareStatusType.
     */
    public static final FirmwareStatusType UNAVAILABLE = fromString("unavailable");

    /**
     * Creates a new instance of FirmwareStatusType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public FirmwareStatusType() {
    }

    /**
     * Creates or finds a FirmwareStatusType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding FirmwareStatusType.
     */
    public static FirmwareStatusType fromString(String name) {
        return fromString(name, FirmwareStatusType.class);
    }

    /**
     * Gets known FirmwareStatusType values.
     * 
     * @return known FirmwareStatusType values.
     */
    public static Collection<FirmwareStatusType> values() {
        return values(FirmwareStatusType.class);
    }
}
