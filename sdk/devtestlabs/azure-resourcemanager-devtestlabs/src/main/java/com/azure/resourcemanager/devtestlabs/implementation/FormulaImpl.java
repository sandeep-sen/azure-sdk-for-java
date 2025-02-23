// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.implementation;

import com.azure.core.management.Region;
import com.azure.core.util.Context;
import com.azure.resourcemanager.devtestlabs.fluent.models.FormulaInner;
import com.azure.resourcemanager.devtestlabs.models.Formula;
import com.azure.resourcemanager.devtestlabs.models.FormulaFragment;
import com.azure.resourcemanager.devtestlabs.models.FormulaPropertiesFromVm;
import com.azure.resourcemanager.devtestlabs.models.LabVirtualMachineCreationParameter;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;

public final class FormulaImpl implements Formula, Formula.Definition, Formula.Update {
    private FormulaInner innerObject;

    private final com.azure.resourcemanager.devtestlabs.DevTestLabsManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public String description() {
        return this.innerModel().description();
    }

    public String author() {
        return this.innerModel().author();
    }

    public String osType() {
        return this.innerModel().osType();
    }

    public OffsetDateTime creationDate() {
        return this.innerModel().creationDate();
    }

    public LabVirtualMachineCreationParameter formulaContent() {
        return this.innerModel().formulaContent();
    }

    public FormulaPropertiesFromVm vm() {
        return this.innerModel().vm();
    }

    public String provisioningState() {
        return this.innerModel().provisioningState();
    }

    public String uniqueIdentifier() {
        return this.innerModel().uniqueIdentifier();
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroupName;
    }

    public FormulaInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.devtestlabs.DevTestLabsManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String labName;

    private String name;

    private FormulaFragment updateFormula;

    public FormulaImpl withExistingLab(String resourceGroupName, String labName) {
        this.resourceGroupName = resourceGroupName;
        this.labName = labName;
        return this;
    }

    public Formula create() {
        this.innerObject = serviceManager.serviceClient()
            .getFormulas()
            .createOrUpdate(resourceGroupName, labName, name, this.innerModel(), Context.NONE);
        return this;
    }

    public Formula create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getFormulas()
            .createOrUpdate(resourceGroupName, labName, name, this.innerModel(), context);
        return this;
    }

    FormulaImpl(String name, com.azure.resourcemanager.devtestlabs.DevTestLabsManager serviceManager) {
        this.innerObject = new FormulaInner();
        this.serviceManager = serviceManager;
        this.name = name;
    }

    public FormulaImpl update() {
        this.updateFormula = new FormulaFragment();
        return this;
    }

    public Formula apply() {
        this.innerObject = serviceManager.serviceClient()
            .getFormulas()
            .updateWithResponse(resourceGroupName, labName, name, updateFormula, Context.NONE)
            .getValue();
        return this;
    }

    public Formula apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getFormulas()
            .updateWithResponse(resourceGroupName, labName, name, updateFormula, context)
            .getValue();
        return this;
    }

    FormulaImpl(FormulaInner innerObject, com.azure.resourcemanager.devtestlabs.DevTestLabsManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.labName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "labs");
        this.name = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "formulas");
    }

    public Formula refresh() {
        String localExpand = null;
        this.innerObject = serviceManager.serviceClient()
            .getFormulas()
            .getWithResponse(resourceGroupName, labName, name, localExpand, Context.NONE)
            .getValue();
        return this;
    }

    public Formula refresh(Context context) {
        String localExpand = null;
        this.innerObject = serviceManager.serviceClient()
            .getFormulas()
            .getWithResponse(resourceGroupName, labName, name, localExpand, context)
            .getValue();
        return this;
    }

    public FormulaImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public FormulaImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public FormulaImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateFormula.withTags(tags);
            return this;
        }
    }

    public FormulaImpl withDescription(String description) {
        this.innerModel().withDescription(description);
        return this;
    }

    public FormulaImpl withOsType(String osType) {
        this.innerModel().withOsType(osType);
        return this;
    }

    public FormulaImpl withFormulaContent(LabVirtualMachineCreationParameter formulaContent) {
        this.innerModel().withFormulaContent(formulaContent);
        return this;
    }

    public FormulaImpl withVm(FormulaPropertiesFromVm vm) {
        this.innerModel().withVm(vm);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
