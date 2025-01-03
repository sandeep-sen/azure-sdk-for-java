// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.costmanagement.fluent.models.GenerateDetailedCostReportOperationResultInner;
import com.azure.resourcemanager.costmanagement.models.GenerateDetailedCostReportDefinition;

/**
 * An instance of this class provides access to all the operations defined in GenerateDetailedCostReportsClient.
 */
public interface GenerateDetailedCostReportsClient {
    /**
     * Generates the detailed cost report for provided date range, billing period(only enterprise customers) or Invoice
     * ID asynchronously at a certain scope. Call returns a 202 with header Azure-Consumption-AsyncOperation providing a
     * link to the operation created. A call on the operation will provide the status and if the operation is completed
     * the blob file where generated detailed cost report is being stored.
     * 
     * @param scope The ARM Resource ID for subscription, resource group, billing account, or other billing scopes. For
     * details, see https://aka.ms/costmgmt/scopes.
     * @param parameters Parameters supplied to the Create detailed cost report operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the result of the long running operation for cost detailed report.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<GenerateDetailedCostReportOperationResultInner>, GenerateDetailedCostReportOperationResultInner>
        beginCreateOperation(String scope, GenerateDetailedCostReportDefinition parameters);

    /**
     * Generates the detailed cost report for provided date range, billing period(only enterprise customers) or Invoice
     * ID asynchronously at a certain scope. Call returns a 202 with header Azure-Consumption-AsyncOperation providing a
     * link to the operation created. A call on the operation will provide the status and if the operation is completed
     * the blob file where generated detailed cost report is being stored.
     * 
     * @param scope The ARM Resource ID for subscription, resource group, billing account, or other billing scopes. For
     * details, see https://aka.ms/costmgmt/scopes.
     * @param parameters Parameters supplied to the Create detailed cost report operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the result of the long running operation for cost detailed report.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<GenerateDetailedCostReportOperationResultInner>, GenerateDetailedCostReportOperationResultInner>
        beginCreateOperation(String scope, GenerateDetailedCostReportDefinition parameters, Context context);

    /**
     * Generates the detailed cost report for provided date range, billing period(only enterprise customers) or Invoice
     * ID asynchronously at a certain scope. Call returns a 202 with header Azure-Consumption-AsyncOperation providing a
     * link to the operation created. A call on the operation will provide the status and if the operation is completed
     * the blob file where generated detailed cost report is being stored.
     * 
     * @param scope The ARM Resource ID for subscription, resource group, billing account, or other billing scopes. For
     * details, see https://aka.ms/costmgmt/scopes.
     * @param parameters Parameters supplied to the Create detailed cost report operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the result of the long running operation for cost detailed report.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    GenerateDetailedCostReportOperationResultInner createOperation(String scope,
        GenerateDetailedCostReportDefinition parameters);

    /**
     * Generates the detailed cost report for provided date range, billing period(only enterprise customers) or Invoice
     * ID asynchronously at a certain scope. Call returns a 202 with header Azure-Consumption-AsyncOperation providing a
     * link to the operation created. A call on the operation will provide the status and if the operation is completed
     * the blob file where generated detailed cost report is being stored.
     * 
     * @param scope The ARM Resource ID for subscription, resource group, billing account, or other billing scopes. For
     * details, see https://aka.ms/costmgmt/scopes.
     * @param parameters Parameters supplied to the Create detailed cost report operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the result of the long running operation for cost detailed report.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    GenerateDetailedCostReportOperationResultInner createOperation(String scope,
        GenerateDetailedCostReportDefinition parameters, Context context);
}
