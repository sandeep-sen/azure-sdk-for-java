// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of ContentItems.
 */
public interface ContentItems {
    /**
     * Lists developer portal's content items specified by the provided content type.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param contentTypeId Content type identifier.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged list of content items as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ContentItemContract> listByService(String resourceGroupName, String serviceName,
        String contentTypeId);

    /**
     * Lists developer portal's content items specified by the provided content type.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param contentTypeId Content type identifier.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged list of content items as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ContentItemContract> listByService(String resourceGroupName, String serviceName, String contentTypeId,
        Context context);

    /**
     * Returns the entity state (ETag) version of the developer portal's content item specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param contentTypeId Content type identifier.
     * @param contentItemId Content item identifier.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    ContentItemsGetEntityTagResponse getEntityTagWithResponse(String resourceGroupName, String serviceName,
        String contentTypeId, String contentItemId, Context context);

    /**
     * Returns the entity state (ETag) version of the developer portal's content item specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param contentTypeId Content type identifier.
     * @param contentItemId Content item identifier.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void getEntityTag(String resourceGroupName, String serviceName, String contentTypeId, String contentItemId);

    /**
     * Returns the developer portal's content item specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param contentTypeId Content type identifier.
     * @param contentItemId Content item identifier.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return content type contract details.
     */
    Response<ContentItemContract> getWithResponse(String resourceGroupName, String serviceName, String contentTypeId,
        String contentItemId, Context context);

    /**
     * Returns the developer portal's content item specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param contentTypeId Content type identifier.
     * @param contentItemId Content item identifier.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return content type contract details.
     */
    ContentItemContract get(String resourceGroupName, String serviceName, String contentTypeId, String contentItemId);

    /**
     * Removes the specified developer portal's content item.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param contentTypeId Content type identifier.
     * @param contentItemId Content item identifier.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteWithResponse(String resourceGroupName, String serviceName, String contentTypeId,
        String contentItemId, String ifMatch, Context context);

    /**
     * Removes the specified developer portal's content item.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param contentTypeId Content type identifier.
     * @param contentItemId Content item identifier.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String serviceName, String contentTypeId, String contentItemId,
        String ifMatch);

    /**
     * Returns the developer portal's content item specified by its identifier.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return content type contract details.
     */
    ContentItemContract getById(String id);

    /**
     * Returns the developer portal's content item specified by its identifier.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return content type contract details.
     */
    Response<ContentItemContract> getByIdWithResponse(String id, Context context);

    /**
     * Removes the specified developer portal's content item.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Removes the specified developer portal's content item.
     * 
     * @param id the resource ID.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteByIdWithResponse(String id, String ifMatch, Context context);

    /**
     * Begins definition for a new ContentItemContract resource.
     * 
     * @param name resource name.
     * @return the first stage of the new ContentItemContract definition.
     */
    ContentItemContract.DefinitionStages.Blank define(String name);
}
