// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.fluent.models.BackupProperties;
import org.junit.jupiter.api.Assertions;

public final class BackupPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BackupProperties model = BinaryData.fromString(
            "{\"backupId\":\"iopid\",\"creationDate\":\"2021-07-26T10:21:10Z\",\"provisioningState\":\"kuvscxkdm\",\"size\":7887453097536877840,\"label\":\"ibrxkp\",\"backupType\":\"Manual\",\"failureReason\":\"zuruocbgo\",\"volumeResourceId\":\"rb\",\"useExistingSnapshot\":true,\"snapshotName\":\"bfhjxakvvjgsl\",\"backupPolicyResourceId\":\"dilmyww\",\"isLargeVolume\":true}")
            .toObject(BackupProperties.class);
        Assertions.assertEquals("ibrxkp", model.label());
        Assertions.assertEquals("rb", model.volumeResourceId());
        Assertions.assertEquals(true, model.useExistingSnapshot());
        Assertions.assertEquals("bfhjxakvvjgsl", model.snapshotName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BackupProperties model = new BackupProperties().withLabel("ibrxkp")
            .withVolumeResourceId("rb")
            .withUseExistingSnapshot(true)
            .withSnapshotName("bfhjxakvvjgsl");
        model = BinaryData.fromObject(model).toObject(BackupProperties.class);
        Assertions.assertEquals("ibrxkp", model.label());
        Assertions.assertEquals("rb", model.volumeResourceId());
        Assertions.assertEquals(true, model.useExistingSnapshot());
        Assertions.assertEquals("bfhjxakvvjgsl", model.snapshotName());
    }
}
