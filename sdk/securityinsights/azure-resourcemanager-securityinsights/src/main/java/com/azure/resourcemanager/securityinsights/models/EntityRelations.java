// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of EntityRelations.
 */
public interface EntityRelations {
    /**
     * Gets an entity relation.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param entityId entity ID.
     * @param relationName Relation Name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an entity relation along with {@link Response}.
     */
    Response<Relation> getRelationWithResponse(String resourceGroupName, String workspaceName, String entityId,
        String relationName, Context context);

    /**
     * Gets an entity relation.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param entityId entity ID.
     * @param relationName Relation Name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an entity relation.
     */
    Relation getRelation(String resourceGroupName, String workspaceName, String entityId, String relationName);
}
