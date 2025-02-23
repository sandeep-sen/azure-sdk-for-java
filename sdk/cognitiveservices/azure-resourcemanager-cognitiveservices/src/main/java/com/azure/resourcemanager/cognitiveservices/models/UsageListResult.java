// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.models;

import com.azure.resourcemanager.cognitiveservices.fluent.models.UsageListResultInner;
import java.util.List;

/**
 * An immutable client-side representation of UsageListResult.
 */
public interface UsageListResult {
    /**
     * Gets the nextLink property: The link used to get the next page of Usages.
     * 
     * @return the nextLink value.
     */
    String nextLink();

    /**
     * Gets the value property: The list of usages for Cognitive Service account.
     * 
     * @return the value value.
     */
    List<Usage> value();

    /**
     * Gets the inner com.azure.resourcemanager.cognitiveservices.fluent.models.UsageListResultInner object.
     * 
     * @return the inner object.
     */
    UsageListResultInner innerModel();
}
