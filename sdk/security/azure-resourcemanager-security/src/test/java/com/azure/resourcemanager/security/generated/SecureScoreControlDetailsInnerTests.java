// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.SecureScoreControlDefinitionItemInner;
import com.azure.resourcemanager.security.fluent.models.SecureScoreControlDetailsInner;

public final class SecureScoreControlDetailsInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SecureScoreControlDetailsInner model = BinaryData.fromString(
            "{\"properties\":{\"displayName\":\"yvaifpp\",\"score\":{\"max\":838955449,\"current\":86.92464230297385,\"percentage\":2.5163057832325975},\"healthyResourceCount\":422013708,\"unhealthyResourceCount\":1385356359,\"notApplicableResourceCount\":149702899,\"weight\":3347151280629685856,\"definition\":{\"properties\":{\"displayName\":\"pvtyqfttehdpbouj\",\"description\":\"kfvvdshxcde\",\"maxScore\":217091641,\"source\":{\"sourceType\":\"Custom\"},\"assessmentDefinitions\":[{\"id\":\"cgjtfrnquktrfn\"},{\"id\":\"nlrxsmyltrwntfmt\"},{\"id\":\"wjdxw\"}]},\"id\":\"az\",\"name\":\"urrdreyzjwhsetww\",\"type\":\"wzzqseuzuukykcy\"}},\"id\":\"hyqqzzdcy\",\"name\":\"ey\",\"type\":\"tewfopazdazgbsq\"}")
            .toObject(SecureScoreControlDetailsInner.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SecureScoreControlDetailsInner model
            = new SecureScoreControlDetailsInner().withDefinition(new SecureScoreControlDefinitionItemInner());
        model = BinaryData.fromObject(model).toObject(SecureScoreControlDetailsInner.class);
    }
}
