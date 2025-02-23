// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.FileShareDatasetTypeProperties;
import com.azure.resourcemanager.datafactory.models.DatasetCompression;
import com.azure.resourcemanager.datafactory.models.DatasetStorageFormat;
import java.util.HashMap;
import java.util.Map;

public final class FileShareDatasetTypePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FileShareDatasetTypeProperties model = BinaryData.fromString(
            "{\"folderPath\":\"datadzauiunyev\",\"fileName\":\"datazdsytciks\",\"modifiedDatetimeStart\":\"datacamwuynfxkcgs\",\"modifiedDatetimeEnd\":\"datamvhadrpbatvy\",\"format\":{\"type\":\"DatasetStorageFormat\",\"serializer\":\"datajqkqws\",\"deserializer\":\"datatvjkowggxawwdm\",\"\":{\"g\":\"datankteiidlbovwbclp\",\"kjcnerek\":\"datagani\",\"gpwxtvce\":\"datajulskwwnqhql\",\"vxwve\":\"dataavv\"}},\"fileFilter\":\"datanlrjcsmwevguyfln\",\"compression\":{\"type\":\"datalr\",\"level\":\"datafzcde\",\"\":{\"csfqbirtybce\":\"datawezhyfkdilbwqlq\",\"dvuelumodpegqxso\":\"datafjnxodnjyhzfaxs\",\"hlbeqvhs\":\"datachazrqoxz\"}}}")
            .toObject(FileShareDatasetTypeProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        FileShareDatasetTypeProperties model = new FileShareDatasetTypeProperties().withFolderPath("datadzauiunyev")
            .withFileName("datazdsytciks")
            .withModifiedDatetimeStart("datacamwuynfxkcgs")
            .withModifiedDatetimeEnd("datamvhadrpbatvy")
            .withFormat(new DatasetStorageFormat().withSerializer("datajqkqws")
                .withDeserializer("datatvjkowggxawwdm")
                .withAdditionalProperties(mapOf("type", "DatasetStorageFormat")))
            .withFileFilter("datanlrjcsmwevguyfln")
            .withCompression(
                new DatasetCompression().withType("datalr").withLevel("datafzcde").withAdditionalProperties(mapOf()));
        model = BinaryData.fromObject(model).toObject(FileShareDatasetTypeProperties.class);
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
