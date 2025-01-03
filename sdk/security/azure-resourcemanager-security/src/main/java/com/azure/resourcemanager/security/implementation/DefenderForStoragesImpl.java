// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.security.fluent.DefenderForStoragesClient;
import com.azure.resourcemanager.security.fluent.models.DefenderForStorageSettingInner;
import com.azure.resourcemanager.security.fluent.models.MalwareScanInner;
import com.azure.resourcemanager.security.models.DefenderForStorageSetting;
import com.azure.resourcemanager.security.models.DefenderForStorages;
import com.azure.resourcemanager.security.models.MalwareScan;
import com.azure.resourcemanager.security.models.SettingName;

public final class DefenderForStoragesImpl implements DefenderForStorages {
    private static final ClientLogger LOGGER = new ClientLogger(DefenderForStoragesImpl.class);

    private final DefenderForStoragesClient innerClient;

    private final com.azure.resourcemanager.security.SecurityManager serviceManager;

    public DefenderForStoragesImpl(DefenderForStoragesClient innerClient,
        com.azure.resourcemanager.security.SecurityManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<DefenderForStorageSetting> getWithResponse(String resourceId, SettingName settingName,
        Context context) {
        Response<DefenderForStorageSettingInner> inner
            = this.serviceClient().getWithResponse(resourceId, settingName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new DefenderForStorageSettingImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public DefenderForStorageSetting get(String resourceId, SettingName settingName) {
        DefenderForStorageSettingInner inner = this.serviceClient().get(resourceId, settingName);
        if (inner != null) {
            return new DefenderForStorageSettingImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<MalwareScan> startMalwareScanWithResponse(String resourceId, SettingName settingName,
        Context context) {
        Response<MalwareScanInner> inner
            = this.serviceClient().startMalwareScanWithResponse(resourceId, settingName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new MalwareScanImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public MalwareScan startMalwareScan(String resourceId, SettingName settingName) {
        MalwareScanInner inner = this.serviceClient().startMalwareScan(resourceId, settingName);
        if (inner != null) {
            return new MalwareScanImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<MalwareScan> cancelMalwareScanWithResponse(String resourceId, SettingName settingName,
        String scanId, Context context) {
        Response<MalwareScanInner> inner
            = this.serviceClient().cancelMalwareScanWithResponse(resourceId, settingName, scanId, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new MalwareScanImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public MalwareScan cancelMalwareScan(String resourceId, SettingName settingName, String scanId) {
        MalwareScanInner inner = this.serviceClient().cancelMalwareScan(resourceId, settingName, scanId);
        if (inner != null) {
            return new MalwareScanImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<MalwareScan> getMalwareScanWithResponse(String resourceId, SettingName settingName, String scanId,
        Context context) {
        Response<MalwareScanInner> inner
            = this.serviceClient().getMalwareScanWithResponse(resourceId, settingName, scanId, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new MalwareScanImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public MalwareScan getMalwareScan(String resourceId, SettingName settingName, String scanId) {
        MalwareScanInner inner = this.serviceClient().getMalwareScan(resourceId, settingName, scanId);
        if (inner != null) {
            return new MalwareScanImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public DefenderForStorageSetting getById(String id) {
        String resourceId = ResourceManagerUtils.getValueFromIdByParameterName(id,
            "/{resourceId}/providers/Microsoft.Security/defenderForStorageSettings/{settingName}", "resourceId");
        if (resourceId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceId'.", id)));
        }
        String settingNameLocal = ResourceManagerUtils.getValueFromIdByParameterName(id,
            "/{resourceId}/providers/Microsoft.Security/defenderForStorageSettings/{settingName}", "settingName");
        if (settingNameLocal == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(String
                .format("The resource ID '%s' is not valid. Missing path segment 'defenderForStorageSettings'.", id)));
        }
        SettingName settingName = SettingName.fromString(settingNameLocal);
        return this.getWithResponse(resourceId, settingName, Context.NONE).getValue();
    }

    public Response<DefenderForStorageSetting> getByIdWithResponse(String id, Context context) {
        String resourceId = ResourceManagerUtils.getValueFromIdByParameterName(id,
            "/{resourceId}/providers/Microsoft.Security/defenderForStorageSettings/{settingName}", "resourceId");
        if (resourceId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceId'.", id)));
        }
        String settingNameLocal = ResourceManagerUtils.getValueFromIdByParameterName(id,
            "/{resourceId}/providers/Microsoft.Security/defenderForStorageSettings/{settingName}", "settingName");
        if (settingNameLocal == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(String
                .format("The resource ID '%s' is not valid. Missing path segment 'defenderForStorageSettings'.", id)));
        }
        SettingName settingName = SettingName.fromString(settingNameLocal);
        return this.getWithResponse(resourceId, settingName, context);
    }

    private DefenderForStoragesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.security.SecurityManager manager() {
        return this.serviceManager;
    }

    public DefenderForStorageSettingImpl define(SettingName name) {
        return new DefenderForStorageSettingImpl(name, this.manager());
    }
}
