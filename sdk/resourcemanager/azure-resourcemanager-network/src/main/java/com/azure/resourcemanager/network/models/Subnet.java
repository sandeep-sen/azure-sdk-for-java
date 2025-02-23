// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.network.fluent.models.SubnetInner;
import com.azure.core.management.Region;
import com.azure.resourcemanager.resources.fluentcore.arm.models.ChildResource;
import com.azure.resourcemanager.resources.fluentcore.model.Attachable;
import com.azure.resourcemanager.resources.fluentcore.model.HasInnerModel;
import com.azure.resourcemanager.resources.fluentcore.model.Settable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** A client-side representation of a subnet of a virtual network. */
@Fluent()
public interface Subnet extends HasInnerModel<SubnetInner>, ChildResource<Network> {

    /**
     * Gets network interface IP configurations that are associated with this subnet.
     *
     * @return network interface IP configurations that are associated with this subnet
     *     <p>Note that this call may result in multiple calls to Azure to fetch all the referenced interfaces each time
     *     it is invoked.
     */
    Collection<NicIpConfiguration> listNetworkInterfaceIPConfigurations();

    /**
     * List available private IP addresses within this subnet.
     * <pre>Starting IPs of the address prefixes are not returned, due to:
     * 1. They are usually reserved by platform(e.g. for gateway usage).
     * 2. For backward-compatibility.</pre>
     *
     * @return available private IP addresses within this network
     */
    Set<String> listAvailablePrivateIPAddresses();

    /**
     * Gets number of network interface IP configurations associated with this subnet.
     *
     * @return number of network interface IP configurations associated with this subnet
     */
    int networkInterfaceIPConfigurationCount();

    /**
     * Gets the address space prefix, in CIDR notation, assigned to this subnet.
     * <p>Use {@link Subnet#addressPrefixes} if this subnet has multiple prefixes.</p>
     *
     * @return the address space prefix, in CIDR notation, assigned to this subnet
     * @see Subnet#addressPrefixes
     */
    String addressPrefix();

    /**
     * Gets address space prefixes, in CIDR notation, assigned to this subnet.
     * <p>Use {@link Subnet#addressPrefix} if this subnet is created/updated using that property.</p>
     *
     * @return address space prefixes, in CIDR notation, assigned to this subnet
     * @see Subnet#addressPrefix
     */
    List<String> addressPrefixes();

    /**
     * Gets the network security group associated with this subnet.
     *
     * @return the network security group associated with this subnet, if any
     *     <p>Note that this method will result in a call to Azure each time it is invoked.
     */
    NetworkSecurityGroup getNetworkSecurityGroup();

    /**
     * Gets the resource ID of the network security group associated with this subnet.
     *
     * @return the resource ID of the network security group associated with this subnet, if any
     */
    String networkSecurityGroupId();

    /**
     * Gets the route table associated with this subnet.
     *
     * @return the route table associated with this subnet, if any
     *     <p>Note that this method will result in a call to Azure each time it is invoked.
     */
    RouteTable getRouteTable();

    /**
     * Gets the resource ID of the route table associated with this subnet.
     *
     * @return the resource ID of the route table associated with this subnet, if any
     */
    String routeTableId();

    /**
     * Gets the services that has access to the subnet.
     *
     * @return the services that has access to the subnet.
     */
    Map<ServiceEndpointType, List<Region>> servicesWithAccess();

    /**
     * Gets the ID of the subnet.
     *
     * @return the ID of the subnet.
     */
    String id();

    /**
     * Gets the resource ID of the NAT gateway associated with this subnet.
     *
     * @return the resource ID of the NAT gateway associated with this subnet, if any
     */
    String natGatewayId();

    /** Grouping of subnet definition stages. */
    interface DefinitionStages {
        /**
         * The first stage of the subnet definition.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface Blank<ParentT> extends WithAddressPrefix<ParentT> {
        }

        /**
         * The stage of the subnet definition allowing to specify the address space for the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithAddressPrefix<ParentT> {
            /**
             * Specifies the IP address space of the subnet, within the address space of the network.
             *
             * @param cidr the IP address space prefix using the CIDR notation
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withAddressPrefix(String cidr);

            /**
             * Specifies the IP address spaces of the subnet, within the address space of the network.
             *
             * @param addressPrefixes the IP address space prefixes using the CIDR notation
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withAddressPrefixes(Collection<String> addressPrefixes);
        }

        /**
         * The stage of the subnet definition allowing to specify the network security group to assign to the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithNetworkSecurityGroup<ParentT> {
            /**
             * Assigns an existing network security group to this subnet.
             *
             * @param resourceId the resource ID of the network security group
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingNetworkSecurityGroup(String resourceId);

            /**
             * Assigns an existing network security group to this subnet.
             *
             * @param nsg the network security group to assign
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingNetworkSecurityGroup(NetworkSecurityGroup nsg);
        }

        /**
         * The stage of a subnet definition allowing to specify a route table to associate with the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithRouteTable<ParentT> {
            /**
             * Specifies an existing route table to associate with the subnet.
             *
             * @param routeTable an existing route table to associate
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingRouteTable(RouteTable routeTable);

            /**
             * Specifies an existing route table to associate with the subnet.
             *
             * @param resourceId the resource ID of an existing route table
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingRouteTable(String resourceId);
        }

        /**
         * The stage of the subnet definition allowing to specify the subnet delegation.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithDelegation<ParentT> {

            /**
             * Specifies a subnet delegation.
             *
             * @param serviceName the service name for the delegation
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withDelegation(String serviceName);
        }

        /**
         * The stage of a subnet definition allowing to enable access from a service endpoint to the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithServiceEndpoint<ParentT> {
            /**
             * Specifies a service endpoint to enable access from.
             *
             * @param service the service type
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withAccessFromService(ServiceEndpointType service);
        }

        /**
         * The stage of a subnet definition for applying network policies on private endpoint.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithPrivateEndpointNetworkPolicies<ParentT> {
            /**
             * Disables applying network policies on private endpoint.
             *
             * @return the next stage of the definition
             */
            WithAttach<ParentT> disableNetworkPoliciesOnPrivateEndpoint();
        }

        /**
         * The stage of a subnet definition for applying network policies on private link service.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithPrivateLinkServiceNetworkPolicies<ParentT> {
            /**
             * Disables applying network policies on private link service.
             *
             * @return the next stage of the definition
             */
            WithAttach<ParentT> disableNetworkPoliciesOnPrivateLinkService();
        }

        /**
         * The stage of a subnet definition allowing to specify the network NAT gateway to assign to the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithNatGateway<ParentT> {
            /**
             * Specifies an existing NAT gateway to associate with the subnet.
             *
             * @param resourceId the resource ID of the NAT gateway
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingNatGateway(String resourceId);
        }

        /**
         * The final stage of the subnet definition.
         *
         * <p>At this stage, any remaining optional settings can be specified, or the subnet definition can be attached
         * to the parent virtual network definition.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithAttach<ParentT>
            extends Attachable.InDefinition<ParentT>, WithNetworkSecurityGroup<ParentT>, WithRouteTable<ParentT>,
            WithDelegation<ParentT>, WithServiceEndpoint<ParentT>, WithPrivateEndpointNetworkPolicies<ParentT>,
            WithPrivateLinkServiceNetworkPolicies<ParentT>, WithNatGateway<ParentT> {
        }
    }

    /**
     * The entirety of a Subnet definition.
     *
     * @param <ParentT> the stage of the parent definition to return to after attaching this definition
     */
    interface Definition<ParentT> extends DefinitionStages.Blank<ParentT>, DefinitionStages.WithAddressPrefix<ParentT>,
        DefinitionStages.WithAttach<ParentT> {
    }

    /** Grouping of subnet update stages. */
    interface UpdateStages {
        /** The stage of the subnet update allowing to change the address space for the subnet. */
        interface WithAddressPrefix {
            /**
             * Specifies the IP address space of the subnet, within the address space of the network.
             *
             * @param cidr the IP address space prefix using the CIDR notation
             * @return the next stage
             */
            Update withAddressPrefix(String cidr);

            /**
             * Specifies the IP address spaces of the subnet, within the address space of the network.
             *
             * @param addressPrefixes the IP address space prefixes using the CIDR notation
             * @return the next stage
             */
            Update withAddressPrefixes(Collection<String> addressPrefixes);
        }

        /** The stage of the subnet update allowing to change the network security group to assign to the subnet. */
        interface WithNetworkSecurityGroup {
            /**
             * Assigns an existing network security group to this subnet.
             *
             * @param resourceId the resource ID of the network security group
             * @return the next stage of the update
             */
            Update withExistingNetworkSecurityGroup(String resourceId);

            /**
             * Assigns an existing network security group to this subnet.
             *
             * @param nsg the network security group to assign
             * @return the next stage of the update
             */
            Update withExistingNetworkSecurityGroup(NetworkSecurityGroup nsg);

            /**
             * Removes the association of this subnet with any network security group.
             *
             * @return the next stage of the update
             */
            Update withoutNetworkSecurityGroup();
        }

        /**
         * The stage of a subnet update allowing to specify a route table to associate with the subnet, or remove an
         * existing association.
         */
        interface WithRouteTable {
            /**
             * Specifies an existing route table to associate with the subnet.
             *
             * @param routeTable an existing route table to associate
             * @return the next stage of the update
             */
            Update withExistingRouteTable(RouteTable routeTable);

            /**
             * Specifies an existing route table to associate with the subnet.
             *
             * @param resourceId the resource ID of an existing route table
             * @return the next stage of the update
             */
            Update withExistingRouteTable(String resourceId);

            /**
             * Removes the association with a route table, if any.
             *
             * @return the next stage of the update
             */
            Update withoutRouteTable();
        }

        /** The stage of the subnet definition allowing to specify the subnet delegation. */
        interface WithDelegation {

            /**
             * Specifies a subnet delegation.
             *
             * @param serviceName the service name for the delegation
             * @return the next stage of the definition
             */
            Update withDelegation(String serviceName);

            /**
             * Removes a subnet delegation.
             *
             * @param serviceName the service name for the delegation
             * @return the next stage of the definition
             */
            Update withoutDelegation(String serviceName);
        }

        /**
         * The stage of a subnet definition allowing to enable or disable access from a service endpoint to the subnet.
         */
        interface WithServiceEndpoint {
            /**
             * Specifies a service endpoint to enable access from.
             *
             * @param service the service type
             * @return the next stage of the definition
             */
            Update withAccessFromService(ServiceEndpointType service);

            /**
             * Specifies that existing access from a service endpoint should be removed.
             *
             * @param service the service type
             * @return the next stage of the definition
             */
            Update withoutAccessFromService(ServiceEndpointType service);
        }

        /**
         * The stage of a subnet update for applying network policies on private endpoint.
         */
        interface WithPrivateEndpointNetworkPolicies {
            /**
             * Enables applying network policies on private endpoint.
             *
             * @return the next stage of the update
             */
            Update enableNetworkPoliciesOnPrivateEndpoint();

            /**
             * Disables applying network policies on private endpoint.
             *
             * @return the next stage of the update
             */
            Update disableNetworkPoliciesOnPrivateEndpoint();
        }

        /**
         * The stage of a subnet definition for applying network policies on private link service.
         */
        interface WithPrivateLinkServiceNetworkPolicies {
            /**
             * Enables applying network policies on private link service.
             *
             * @return the next stage of the update
             */
            Update enableNetworkPoliciesOnPrivateLinkService();

            /**
             * Disables applying network policies on private link service.
             *
             * @return the next stage of the definition
             */
            Update disableNetworkPoliciesOnPrivateLinkService();
        }

        /**
         * The stage of a subnet update allowing to specify the network NAT gateway to assign to the subnet.
         *
         */
        interface WithNatGateway {
            /**
             * Specifies an existing NAT gateway to associate with the subnet.
             *
             * @param resourceId the resource ID of the NAT gateway
             * @return the next stage of the definition
             */
            Update withExistingNatGateway(String resourceId);
        }
    }

    /** The entirety of a subnet update as part of a network update. */
    interface Update
        extends UpdateStages.WithAddressPrefix, UpdateStages.WithNetworkSecurityGroup, UpdateStages.WithRouteTable,
        UpdateStages.WithDelegation, UpdateStages.WithServiceEndpoint, UpdateStages.WithPrivateEndpointNetworkPolicies,
        UpdateStages.WithPrivateLinkServiceNetworkPolicies, UpdateStages.WithNatGateway, Settable<Network.Update> {
    }

    /** Grouping of subnet definition stages applicable as part of a virtual network update. */
    interface UpdateDefinitionStages {
        /**
         * The first stage of the subnet definition.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface Blank<ParentT> extends WithAddressPrefix<ParentT> {
        }

        /**
         * The stage of the subnet definition allowing to specify the address space for the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithAddressPrefix<ParentT> {
            /**
             * Specifies the IP address space of the subnet, within the address space of the network.
             *
             * @param cidr the IP address space prefix using the CIDR notation
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withAddressPrefix(String cidr);

            /**
             * Specifies the IP address spaces of the subnet, within the address space of the network.
             *
             * @param addressPrefixes the IP address space prefixes using the CIDR notation
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withAddressPrefixes(Collection<String> addressPrefixes);
        }

        /**
         * The stage of the subnet definition allowing to specify the network security group to assign to the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithNetworkSecurityGroup<ParentT> {
            /**
             * Assigns an existing network security group to this subnet.
             *
             * @param resourceId the resource ID of the network security group
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingNetworkSecurityGroup(String resourceId);

            /**
             * Assigns an existing network security group to this subnet.
             *
             * @param nsg the network security group to assign
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingNetworkSecurityGroup(NetworkSecurityGroup nsg);
        }

        /**
         * The stage of a subnet definition allowing to specify a route table to associate with the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithRouteTable<ParentT> {
            /**
             * Specifies an existing route table to associate with the subnet.
             *
             * @param routeTable an existing route table to associate
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingRouteTable(RouteTable routeTable);

            /**
             * Specifies an existing route table to associate with the subnet.
             *
             * @param resourceId the resource ID of an existing route table
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingRouteTable(String resourceId);
        }

        /**
         * The stage of the subnet definition allowing to specify the subnet delegation.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithDelegation<ParentT> {

            /**
             * Specifies a subnet delegation.
             *
             * @param serviceName the service name for the delegation
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withDelegation(String serviceName);
        }

        /**
         * The stage of a subnet definition allowing to enable access from a service endpoint to the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithServiceEndpoint<ParentT> {
            /**
             * Specifies a service endpoint to enable access from.
             *
             * @param service the service type
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withAccessFromService(ServiceEndpointType service);
        }

        /**
         * The stage of a subnet definition for applying network policies on private endpoint.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithPrivateEndpointNetworkPolicies<ParentT> {
            /**
             * Disables applying network policies on private endpoint.
             *
             * @return the next stage of the definition
             */
            WithAttach<ParentT> disableNetworkPoliciesOnPrivateEndpoint();
        }

        /**
         * The stage of a subnet definition allowing to specify the network NAT gateway to assign to the subnet.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithNatGateway<ParentT> {
            /**
             * Specifies an existing NAT gateway to associate with the subnet.
             *
             * @param resourceId the resource ID of the NAT gateway
             * @return the next stage of the definition
             */
            WithAttach<ParentT> withExistingNatGateway(String resourceId);
        }

        /**
         * The final stage of the subnet definition.
         *
         * <p>At this stage, any remaining optional settings can be specified, or the subnet definition can be attached
         * to the parent virtual network definition.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithAttach<ParentT> extends Attachable.InUpdate<ParentT>, WithNetworkSecurityGroup<ParentT>,
            WithRouteTable<ParentT>, WithDelegation<ParentT>, WithServiceEndpoint<ParentT>,
            WithPrivateEndpointNetworkPolicies<ParentT>, WithNatGateway<ParentT> {
        }
    }

    /**
     * The entirety of a subnet definition as part of a virtual network update.
     *
     * @param <ParentT> the stage of the parent definition to return to after attaching this definition
     */
    interface UpdateDefinition<ParentT>
        extends UpdateDefinitionStages.Blank<ParentT>, UpdateDefinitionStages.WithAddressPrefix<ParentT>,
        UpdateDefinitionStages.WithNetworkSecurityGroup<ParentT>, UpdateDefinitionStages.WithAttach<ParentT> {
    }
}
