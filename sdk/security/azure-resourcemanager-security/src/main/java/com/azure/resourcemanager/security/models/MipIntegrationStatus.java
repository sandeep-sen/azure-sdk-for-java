// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Microsoft information protection integration status.
 */
public final class MipIntegrationStatus extends ExpandableStringEnum<MipIntegrationStatus> {
    /**
     * Static value Ok for MipIntegrationStatus.
     */
    public static final MipIntegrationStatus OK = fromString("Ok");

    /**
     * Static value noConsent for MipIntegrationStatus.
     */
    public static final MipIntegrationStatus NO_CONSENT = fromString("noConsent");

    /**
     * Static value noAutoLabelingRules for MipIntegrationStatus.
     */
    public static final MipIntegrationStatus NO_AUTO_LABELING_RULES = fromString("noAutoLabelingRules");

    /**
     * Static value noMipLabels for MipIntegrationStatus.
     */
    public static final MipIntegrationStatus NO_MIP_LABELS = fromString("noMipLabels");

    /**
     * Creates a new instance of MipIntegrationStatus value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public MipIntegrationStatus() {
    }

    /**
     * Creates or finds a MipIntegrationStatus from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding MipIntegrationStatus.
     */
    public static MipIntegrationStatus fromString(String name) {
        return fromString(name, MipIntegrationStatus.class);
    }

    /**
     * Gets known MipIntegrationStatus values.
     * 
     * @return known MipIntegrationStatus values.
     */
    public static Collection<MipIntegrationStatus> values() {
        return values(MipIntegrationStatus.class);
    }
}
