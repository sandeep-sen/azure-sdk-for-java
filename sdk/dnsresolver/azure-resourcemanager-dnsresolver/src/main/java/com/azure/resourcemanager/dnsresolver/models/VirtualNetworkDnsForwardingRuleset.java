// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dnsresolver.models;

import com.azure.core.management.SubResource;
import com.azure.resourcemanager.dnsresolver.fluent.models.VirtualNetworkDnsForwardingRulesetInner;

/**
 * An immutable client-side representation of VirtualNetworkDnsForwardingRuleset.
 */
public interface VirtualNetworkDnsForwardingRuleset {
    /**
     * Gets the id property: DNS Forwarding Ruleset Resource ID.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the virtualNetworkLink property: The reference to the virtual network link.
     * 
     * @return the virtualNetworkLink value.
     */
    SubResource virtualNetworkLink();

    /**
     * Gets the inner com.azure.resourcemanager.dnsresolver.fluent.models.VirtualNetworkDnsForwardingRulesetInner
     * object.
     * 
     * @return the inner object.
     */
    VirtualNetworkDnsForwardingRulesetInner innerModel();
}
