// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

module com.azure.resourcemanager.databricks {
    requires transitive com.azure.core.management;

    exports com.azure.resourcemanager.databricks;
    exports com.azure.resourcemanager.databricks.fluent;
    exports com.azure.resourcemanager.databricks.fluent.models;
    exports com.azure.resourcemanager.databricks.models;

    opens com.azure.resourcemanager.databricks.fluent.models to com.azure.core;
    opens com.azure.resourcemanager.databricks.models to com.azure.core;
}
