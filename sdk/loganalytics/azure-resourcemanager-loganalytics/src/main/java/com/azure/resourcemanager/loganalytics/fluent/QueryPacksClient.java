// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.loganalytics.fluent.models.LogAnalyticsQueryPackInner;
import com.azure.resourcemanager.loganalytics.models.TagsResource;

/**
 * An instance of this class provides access to all the operations defined in QueryPacksClient.
 */
public interface QueryPacksClient {
    /**
     * Gets a list of all Log Analytics QueryPacks within a subscription.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of all Log Analytics QueryPacks within a subscription as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LogAnalyticsQueryPackInner> list();

    /**
     * Gets a list of all Log Analytics QueryPacks within a subscription.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of all Log Analytics QueryPacks within a subscription as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LogAnalyticsQueryPackInner> list(Context context);

    /**
     * Gets a list of Log Analytics QueryPacks within a resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Log Analytics QueryPacks within a resource group as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LogAnalyticsQueryPackInner> listByResourceGroup(String resourceGroupName);

    /**
     * Gets a list of Log Analytics QueryPacks within a resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Log Analytics QueryPacks within a resource group as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LogAnalyticsQueryPackInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Creates a Log Analytics QueryPack. Note: You cannot specify a different value for InstrumentationKey nor AppId in
     * the Put operation.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param logAnalyticsQueryPackPayload Properties that need to be specified to create or update a Log Analytics
     * QueryPack.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Log Analytics QueryPack definition along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<LogAnalyticsQueryPackInner> createOrUpdateWithoutNameWithResponse(String resourceGroupName,
        LogAnalyticsQueryPackInner logAnalyticsQueryPackPayload, Context context);

    /**
     * Creates a Log Analytics QueryPack. Note: You cannot specify a different value for InstrumentationKey nor AppId in
     * the Put operation.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param logAnalyticsQueryPackPayload Properties that need to be specified to create or update a Log Analytics
     * QueryPack.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Log Analytics QueryPack definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LogAnalyticsQueryPackInner createOrUpdateWithoutName(String resourceGroupName,
        LogAnalyticsQueryPackInner logAnalyticsQueryPackPayload);

    /**
     * Deletes a Log Analytics QueryPack.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param queryPackName The name of the Log Analytics QueryPack resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String queryPackName, Context context);

    /**
     * Deletes a Log Analytics QueryPack.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param queryPackName The name of the Log Analytics QueryPack resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String queryPackName);

    /**
     * Returns a Log Analytics QueryPack.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param queryPackName The name of the Log Analytics QueryPack resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Log Analytics QueryPack definition along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<LogAnalyticsQueryPackInner> getByResourceGroupWithResponse(String resourceGroupName, String queryPackName,
        Context context);

    /**
     * Returns a Log Analytics QueryPack.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param queryPackName The name of the Log Analytics QueryPack resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Log Analytics QueryPack definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LogAnalyticsQueryPackInner getByResourceGroup(String resourceGroupName, String queryPackName);

    /**
     * Creates (or updates) a Log Analytics QueryPack. Note: You cannot specify a different value for InstrumentationKey
     * nor AppId in the Put operation.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param queryPackName The name of the Log Analytics QueryPack resource.
     * @param logAnalyticsQueryPackPayload Properties that need to be specified to create or update a Log Analytics
     * QueryPack.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Log Analytics QueryPack definition along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<LogAnalyticsQueryPackInner> createOrUpdateWithResponse(String resourceGroupName, String queryPackName,
        LogAnalyticsQueryPackInner logAnalyticsQueryPackPayload, Context context);

    /**
     * Creates (or updates) a Log Analytics QueryPack. Note: You cannot specify a different value for InstrumentationKey
     * nor AppId in the Put operation.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param queryPackName The name of the Log Analytics QueryPack resource.
     * @param logAnalyticsQueryPackPayload Properties that need to be specified to create or update a Log Analytics
     * QueryPack.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Log Analytics QueryPack definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LogAnalyticsQueryPackInner createOrUpdate(String resourceGroupName, String queryPackName,
        LogAnalyticsQueryPackInner logAnalyticsQueryPackPayload);

    /**
     * Updates an existing QueryPack's tags. To update other fields use the CreateOrUpdate method.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param queryPackName The name of the Log Analytics QueryPack resource.
     * @param queryPackTags Updated tag information to set into the QueryPack instance.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Log Analytics QueryPack definition along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<LogAnalyticsQueryPackInner> updateTagsWithResponse(String resourceGroupName, String queryPackName,
        TagsResource queryPackTags, Context context);

    /**
     * Updates an existing QueryPack's tags. To update other fields use the CreateOrUpdate method.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param queryPackName The name of the Log Analytics QueryPack resource.
     * @param queryPackTags Updated tag information to set into the QueryPack instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Log Analytics QueryPack definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LogAnalyticsQueryPackInner updateTags(String resourceGroupName, String queryPackName, TagsResource queryPackTags);
}
