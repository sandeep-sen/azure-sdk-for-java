// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The name of the embedding model from the Azure AI Foundry Catalog that will be called.
 */
public final class AIStudioModelCatalogName extends ExpandableStringEnum<AIStudioModelCatalogName> {
    /**
     * Static value OpenAI-CLIP-Image-Text-Embeddings-vit-base-patch32 for AIStudioModelCatalogName.
     */
    public static final AIStudioModelCatalogName OPEN_AICLIP_IMAGE_TEXT_EMBEDDINGS_VIT_BASE_PATCH32
        = fromString("OpenAI-CLIP-Image-Text-Embeddings-vit-base-patch32");

    /**
     * Static value OpenAI-CLIP-Image-Text-Embeddings-ViT-Large-Patch14-336 for AIStudioModelCatalogName.
     */
    public static final AIStudioModelCatalogName OPEN_AICLIP_IMAGE_TEXT_EMBEDDINGS_VI_TLARGE_PATCH14336
        = fromString("OpenAI-CLIP-Image-Text-Embeddings-ViT-Large-Patch14-336");

    /**
     * Static value Facebook-DinoV2-Image-Embeddings-ViT-Base for AIStudioModelCatalogName.
     */
    public static final AIStudioModelCatalogName FACEBOOK_DINO_V2IMAGE_EMBEDDINGS_VI_TBASE
        = fromString("Facebook-DinoV2-Image-Embeddings-ViT-Base");

    /**
     * Static value Facebook-DinoV2-Image-Embeddings-ViT-Giant for AIStudioModelCatalogName.
     */
    public static final AIStudioModelCatalogName FACEBOOK_DINO_V2IMAGE_EMBEDDINGS_VI_TGIANT
        = fromString("Facebook-DinoV2-Image-Embeddings-ViT-Giant");

    /**
     * Static value Cohere-embed-v3-english for AIStudioModelCatalogName.
     */
    public static final AIStudioModelCatalogName COHERE_EMBED_V3ENGLISH = fromString("Cohere-embed-v3-english");

    /**
     * Static value Cohere-embed-v3-multilingual for AIStudioModelCatalogName.
     */
    public static final AIStudioModelCatalogName COHERE_EMBED_V3MULTILINGUAL
        = fromString("Cohere-embed-v3-multilingual");

    /**
     * Creates a new instance of AIStudioModelCatalogName value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AIStudioModelCatalogName() {
    }

    /**
     * Creates or finds a AIStudioModelCatalogName from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AIStudioModelCatalogName.
     */
    public static AIStudioModelCatalogName fromString(String name) {
        return fromString(name, AIStudioModelCatalogName.class);
    }

    /**
     * Gets known AIStudioModelCatalogName values.
     *
     * @return known AIStudioModelCatalogName values.
     */
    public static Collection<AIStudioModelCatalogName> values() {
        return values(AIStudioModelCatalogName.class);
    }
}
