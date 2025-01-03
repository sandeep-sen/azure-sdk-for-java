// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sqlvirtualmachine.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Active Directory account details to operate Windows Server Failover Cluster.
 */
@Fluent
public final class WsfcDomainProfile implements JsonSerializable<WsfcDomainProfile> {
    /*
     * Fully qualified name of the domain.
     */
    private String domainFqdn;

    /*
     * Organizational Unit path in which the nodes and cluster will be present.
     */
    private String ouPath;

    /*
     * Account name used for creating cluster (at minimum needs permissions to 'Create Computer Objects' in domain).
     */
    private String clusterBootstrapAccount;

    /*
     * Account name used for operating cluster i.e. will be part of administrators group on all the participating
     * virtual machines in the cluster.
     */
    private String clusterOperatorAccount;

    /*
     * Account name under which SQL service will run on all participating SQL virtual machines in the cluster.
     */
    private String sqlServiceAccount;

    /*
     * Optional path for fileshare witness.
     */
    private String fileShareWitnessPath;

    /*
     * Fully qualified ARM resource id of the witness storage account.
     */
    private String storageAccountUrl;

    /*
     * Primary key of the witness storage account.
     */
    private String storageAccountPrimaryKey;

    /*
     * Cluster subnet type.
     */
    private ClusterSubnetType clusterSubnetType;

    /**
     * Creates an instance of WsfcDomainProfile class.
     */
    public WsfcDomainProfile() {
    }

    /**
     * Get the domainFqdn property: Fully qualified name of the domain.
     * 
     * @return the domainFqdn value.
     */
    public String domainFqdn() {
        return this.domainFqdn;
    }

    /**
     * Set the domainFqdn property: Fully qualified name of the domain.
     * 
     * @param domainFqdn the domainFqdn value to set.
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withDomainFqdn(String domainFqdn) {
        this.domainFqdn = domainFqdn;
        return this;
    }

    /**
     * Get the ouPath property: Organizational Unit path in which the nodes and cluster will be present.
     * 
     * @return the ouPath value.
     */
    public String ouPath() {
        return this.ouPath;
    }

    /**
     * Set the ouPath property: Organizational Unit path in which the nodes and cluster will be present.
     * 
     * @param ouPath the ouPath value to set.
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withOuPath(String ouPath) {
        this.ouPath = ouPath;
        return this;
    }

    /**
     * Get the clusterBootstrapAccount property: Account name used for creating cluster (at minimum needs permissions to
     * 'Create Computer Objects' in domain).
     * 
     * @return the clusterBootstrapAccount value.
     */
    public String clusterBootstrapAccount() {
        return this.clusterBootstrapAccount;
    }

    /**
     * Set the clusterBootstrapAccount property: Account name used for creating cluster (at minimum needs permissions to
     * 'Create Computer Objects' in domain).
     * 
     * @param clusterBootstrapAccount the clusterBootstrapAccount value to set.
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withClusterBootstrapAccount(String clusterBootstrapAccount) {
        this.clusterBootstrapAccount = clusterBootstrapAccount;
        return this;
    }

    /**
     * Get the clusterOperatorAccount property: Account name used for operating cluster i.e. will be part of
     * administrators group on all the participating virtual machines in the cluster.
     * 
     * @return the clusterOperatorAccount value.
     */
    public String clusterOperatorAccount() {
        return this.clusterOperatorAccount;
    }

    /**
     * Set the clusterOperatorAccount property: Account name used for operating cluster i.e. will be part of
     * administrators group on all the participating virtual machines in the cluster.
     * 
     * @param clusterOperatorAccount the clusterOperatorAccount value to set.
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withClusterOperatorAccount(String clusterOperatorAccount) {
        this.clusterOperatorAccount = clusterOperatorAccount;
        return this;
    }

    /**
     * Get the sqlServiceAccount property: Account name under which SQL service will run on all participating SQL
     * virtual machines in the cluster.
     * 
     * @return the sqlServiceAccount value.
     */
    public String sqlServiceAccount() {
        return this.sqlServiceAccount;
    }

    /**
     * Set the sqlServiceAccount property: Account name under which SQL service will run on all participating SQL
     * virtual machines in the cluster.
     * 
     * @param sqlServiceAccount the sqlServiceAccount value to set.
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withSqlServiceAccount(String sqlServiceAccount) {
        this.sqlServiceAccount = sqlServiceAccount;
        return this;
    }

    /**
     * Get the fileShareWitnessPath property: Optional path for fileshare witness.
     * 
     * @return the fileShareWitnessPath value.
     */
    public String fileShareWitnessPath() {
        return this.fileShareWitnessPath;
    }

    /**
     * Set the fileShareWitnessPath property: Optional path for fileshare witness.
     * 
     * @param fileShareWitnessPath the fileShareWitnessPath value to set.
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withFileShareWitnessPath(String fileShareWitnessPath) {
        this.fileShareWitnessPath = fileShareWitnessPath;
        return this;
    }

    /**
     * Get the storageAccountUrl property: Fully qualified ARM resource id of the witness storage account.
     * 
     * @return the storageAccountUrl value.
     */
    public String storageAccountUrl() {
        return this.storageAccountUrl;
    }

    /**
     * Set the storageAccountUrl property: Fully qualified ARM resource id of the witness storage account.
     * 
     * @param storageAccountUrl the storageAccountUrl value to set.
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withStorageAccountUrl(String storageAccountUrl) {
        this.storageAccountUrl = storageAccountUrl;
        return this;
    }

    /**
     * Get the storageAccountPrimaryKey property: Primary key of the witness storage account.
     * 
     * @return the storageAccountPrimaryKey value.
     */
    public String storageAccountPrimaryKey() {
        return this.storageAccountPrimaryKey;
    }

    /**
     * Set the storageAccountPrimaryKey property: Primary key of the witness storage account.
     * 
     * @param storageAccountPrimaryKey the storageAccountPrimaryKey value to set.
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withStorageAccountPrimaryKey(String storageAccountPrimaryKey) {
        this.storageAccountPrimaryKey = storageAccountPrimaryKey;
        return this;
    }

    /**
     * Get the clusterSubnetType property: Cluster subnet type.
     * 
     * @return the clusterSubnetType value.
     */
    public ClusterSubnetType clusterSubnetType() {
        return this.clusterSubnetType;
    }

    /**
     * Set the clusterSubnetType property: Cluster subnet type.
     * 
     * @param clusterSubnetType the clusterSubnetType value to set.
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withClusterSubnetType(ClusterSubnetType clusterSubnetType) {
        this.clusterSubnetType = clusterSubnetType;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("domainFqdn", this.domainFqdn);
        jsonWriter.writeStringField("ouPath", this.ouPath);
        jsonWriter.writeStringField("clusterBootstrapAccount", this.clusterBootstrapAccount);
        jsonWriter.writeStringField("clusterOperatorAccount", this.clusterOperatorAccount);
        jsonWriter.writeStringField("sqlServiceAccount", this.sqlServiceAccount);
        jsonWriter.writeStringField("fileShareWitnessPath", this.fileShareWitnessPath);
        jsonWriter.writeStringField("storageAccountUrl", this.storageAccountUrl);
        jsonWriter.writeStringField("storageAccountPrimaryKey", this.storageAccountPrimaryKey);
        jsonWriter.writeStringField("clusterSubnetType",
            this.clusterSubnetType == null ? null : this.clusterSubnetType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of WsfcDomainProfile from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of WsfcDomainProfile if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the WsfcDomainProfile.
     */
    public static WsfcDomainProfile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            WsfcDomainProfile deserializedWsfcDomainProfile = new WsfcDomainProfile();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("domainFqdn".equals(fieldName)) {
                    deserializedWsfcDomainProfile.domainFqdn = reader.getString();
                } else if ("ouPath".equals(fieldName)) {
                    deserializedWsfcDomainProfile.ouPath = reader.getString();
                } else if ("clusterBootstrapAccount".equals(fieldName)) {
                    deserializedWsfcDomainProfile.clusterBootstrapAccount = reader.getString();
                } else if ("clusterOperatorAccount".equals(fieldName)) {
                    deserializedWsfcDomainProfile.clusterOperatorAccount = reader.getString();
                } else if ("sqlServiceAccount".equals(fieldName)) {
                    deserializedWsfcDomainProfile.sqlServiceAccount = reader.getString();
                } else if ("fileShareWitnessPath".equals(fieldName)) {
                    deserializedWsfcDomainProfile.fileShareWitnessPath = reader.getString();
                } else if ("storageAccountUrl".equals(fieldName)) {
                    deserializedWsfcDomainProfile.storageAccountUrl = reader.getString();
                } else if ("storageAccountPrimaryKey".equals(fieldName)) {
                    deserializedWsfcDomainProfile.storageAccountPrimaryKey = reader.getString();
                } else if ("clusterSubnetType".equals(fieldName)) {
                    deserializedWsfcDomainProfile.clusterSubnetType = ClusterSubnetType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedWsfcDomainProfile;
        });
    }
}
