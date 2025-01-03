// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automanage.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.automanage.fluent.BestPracticesClient;
import com.azure.resourcemanager.automanage.fluent.models.BestPracticeInner;
import com.azure.resourcemanager.automanage.models.BestPractice;
import com.azure.resourcemanager.automanage.models.BestPractices;

public final class BestPracticesImpl implements BestPractices {
    private static final ClientLogger LOGGER = new ClientLogger(BestPracticesImpl.class);

    private final BestPracticesClient innerClient;

    private final com.azure.resourcemanager.automanage.AutomanageManager serviceManager;

    public BestPracticesImpl(BestPracticesClient innerClient,
        com.azure.resourcemanager.automanage.AutomanageManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<BestPractice> getWithResponse(String bestPracticeName, Context context) {
        Response<BestPracticeInner> inner = this.serviceClient().getWithResponse(bestPracticeName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new BestPracticeImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public BestPractice get(String bestPracticeName) {
        BestPracticeInner inner = this.serviceClient().get(bestPracticeName);
        if (inner != null) {
            return new BestPracticeImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<BestPractice> listByTenant() {
        PagedIterable<BestPracticeInner> inner = this.serviceClient().listByTenant();
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BestPracticeImpl(inner1, this.manager()));
    }

    public PagedIterable<BestPractice> listByTenant(Context context) {
        PagedIterable<BestPracticeInner> inner = this.serviceClient().listByTenant(context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BestPracticeImpl(inner1, this.manager()));
    }

    private BestPracticesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.automanage.AutomanageManager manager() {
        return this.serviceManager;
    }
}
