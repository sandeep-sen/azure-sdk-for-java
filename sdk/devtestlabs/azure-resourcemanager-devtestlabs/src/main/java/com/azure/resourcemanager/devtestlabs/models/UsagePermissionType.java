// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The permission policy of the subnet for allowing public IP addresses (i.e. Allow, Deny)).
 */
public final class UsagePermissionType extends ExpandableStringEnum<UsagePermissionType> {
    /**
     * Static value Default for UsagePermissionType.
     */
    public static final UsagePermissionType DEFAULT = fromString("Default");

    /**
     * Static value Deny for UsagePermissionType.
     */
    public static final UsagePermissionType DENY = fromString("Deny");

    /**
     * Static value Allow for UsagePermissionType.
     */
    public static final UsagePermissionType ALLOW = fromString("Allow");

    /**
     * Creates a new instance of UsagePermissionType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public UsagePermissionType() {
    }

    /**
     * Creates or finds a UsagePermissionType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding UsagePermissionType.
     */
    public static UsagePermissionType fromString(String name) {
        return fromString(name, UsagePermissionType.class);
    }

    /**
     * Gets known UsagePermissionType values.
     * 
     * @return known UsagePermissionType values.
     */
    public static Collection<UsagePermissionType> values() {
        return values(UsagePermissionType.class);
    }
}
