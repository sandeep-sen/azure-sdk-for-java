// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicenetworking;

import com.azure.core.credential.TokenCredential;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.HttpPipelinePosition;
import com.azure.core.http.policy.AddDatePolicy;
import com.azure.core.http.policy.AddHeadersFromContextPolicy;
import com.azure.core.http.policy.BearerTokenAuthenticationPolicy;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.HttpPolicyProviders;
import com.azure.core.http.policy.RequestIdPolicy;
import com.azure.core.http.policy.RetryOptions;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.util.Configuration;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.servicenetworking.fluent.TrafficControllerManagementClient;
import com.azure.resourcemanager.servicenetworking.implementation.AssociationsInterfacesImpl;
import com.azure.resourcemanager.servicenetworking.implementation.FrontendsInterfacesImpl;
import com.azure.resourcemanager.servicenetworking.implementation.OperationsImpl;
import com.azure.resourcemanager.servicenetworking.implementation.SecurityPoliciesInterfacesImpl;
import com.azure.resourcemanager.servicenetworking.implementation.TrafficControllerInterfacesImpl;
import com.azure.resourcemanager.servicenetworking.implementation.TrafficControllerManagementClientBuilder;
import com.azure.resourcemanager.servicenetworking.models.AssociationsInterfaces;
import com.azure.resourcemanager.servicenetworking.models.FrontendsInterfaces;
import com.azure.resourcemanager.servicenetworking.models.Operations;
import com.azure.resourcemanager.servicenetworking.models.SecurityPoliciesInterfaces;
import com.azure.resourcemanager.servicenetworking.models.TrafficControllerInterfaces;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Entry point to TrafficControllerManager.
 * Traffic Controller Provider management API.
 */
public final class TrafficControllerManager {
    private AssociationsInterfaces associationsInterfaces;

    private FrontendsInterfaces frontendsInterfaces;

    private SecurityPoliciesInterfaces securityPoliciesInterfaces;

    private TrafficControllerInterfaces trafficControllerInterfaces;

    private Operations operations;

    private final TrafficControllerManagementClient clientObject;

    private TrafficControllerManager(HttpPipeline httpPipeline, AzureProfile profile, Duration defaultPollInterval) {
        Objects.requireNonNull(httpPipeline, "'httpPipeline' cannot be null.");
        Objects.requireNonNull(profile, "'profile' cannot be null.");
        this.clientObject = new TrafficControllerManagementClientBuilder().pipeline(httpPipeline)
            .endpoint(profile.getEnvironment().getResourceManagerEndpoint())
            .subscriptionId(profile.getSubscriptionId())
            .defaultPollInterval(defaultPollInterval)
            .buildClient();
    }

    /**
     * Creates an instance of Traffic Controller service API entry point.
     * 
     * @param credential the credential to use.
     * @param profile the Azure profile for client.
     * @return the Traffic Controller service API instance.
     */
    public static TrafficControllerManager authenticate(TokenCredential credential, AzureProfile profile) {
        Objects.requireNonNull(credential, "'credential' cannot be null.");
        Objects.requireNonNull(profile, "'profile' cannot be null.");
        return configure().authenticate(credential, profile);
    }

    /**
     * Creates an instance of Traffic Controller service API entry point.
     * 
     * @param httpPipeline the {@link HttpPipeline} configured with Azure authentication credential.
     * @param profile the Azure profile for client.
     * @return the Traffic Controller service API instance.
     */
    public static TrafficControllerManager authenticate(HttpPipeline httpPipeline, AzureProfile profile) {
        Objects.requireNonNull(httpPipeline, "'httpPipeline' cannot be null.");
        Objects.requireNonNull(profile, "'profile' cannot be null.");
        return new TrafficControllerManager(httpPipeline, profile, null);
    }

    /**
     * Gets a Configurable instance that can be used to create TrafficControllerManager with optional configuration.
     * 
     * @return the Configurable instance allowing configurations.
     */
    public static Configurable configure() {
        return new TrafficControllerManager.Configurable();
    }

    /**
     * The Configurable allowing configurations to be set.
     */
    public static final class Configurable {
        private static final ClientLogger LOGGER = new ClientLogger(Configurable.class);

        private HttpClient httpClient;
        private HttpLogOptions httpLogOptions;
        private final List<HttpPipelinePolicy> policies = new ArrayList<>();
        private final List<String> scopes = new ArrayList<>();
        private RetryPolicy retryPolicy;
        private RetryOptions retryOptions;
        private Duration defaultPollInterval;

        private Configurable() {
        }

        /**
         * Sets the http client.
         *
         * @param httpClient the HTTP client.
         * @return the configurable object itself.
         */
        public Configurable withHttpClient(HttpClient httpClient) {
            this.httpClient = Objects.requireNonNull(httpClient, "'httpClient' cannot be null.");
            return this;
        }

        /**
         * Sets the logging options to the HTTP pipeline.
         *
         * @param httpLogOptions the HTTP log options.
         * @return the configurable object itself.
         */
        public Configurable withLogOptions(HttpLogOptions httpLogOptions) {
            this.httpLogOptions = Objects.requireNonNull(httpLogOptions, "'httpLogOptions' cannot be null.");
            return this;
        }

        /**
         * Adds the pipeline policy to the HTTP pipeline.
         *
         * @param policy the HTTP pipeline policy.
         * @return the configurable object itself.
         */
        public Configurable withPolicy(HttpPipelinePolicy policy) {
            this.policies.add(Objects.requireNonNull(policy, "'policy' cannot be null."));
            return this;
        }

        /**
         * Adds the scope to permission sets.
         *
         * @param scope the scope.
         * @return the configurable object itself.
         */
        public Configurable withScope(String scope) {
            this.scopes.add(Objects.requireNonNull(scope, "'scope' cannot be null."));
            return this;
        }

        /**
         * Sets the retry policy to the HTTP pipeline.
         *
         * @param retryPolicy the HTTP pipeline retry policy.
         * @return the configurable object itself.
         */
        public Configurable withRetryPolicy(RetryPolicy retryPolicy) {
            this.retryPolicy = Objects.requireNonNull(retryPolicy, "'retryPolicy' cannot be null.");
            return this;
        }

        /**
         * Sets the retry options for the HTTP pipeline retry policy.
         * <p>
         * This setting has no effect, if retry policy is set via {@link #withRetryPolicy(RetryPolicy)}.
         *
         * @param retryOptions the retry options for the HTTP pipeline retry policy.
         * @return the configurable object itself.
         */
        public Configurable withRetryOptions(RetryOptions retryOptions) {
            this.retryOptions = Objects.requireNonNull(retryOptions, "'retryOptions' cannot be null.");
            return this;
        }

        /**
         * Sets the default poll interval, used when service does not provide "Retry-After" header.
         *
         * @param defaultPollInterval the default poll interval.
         * @return the configurable object itself.
         */
        public Configurable withDefaultPollInterval(Duration defaultPollInterval) {
            this.defaultPollInterval
                = Objects.requireNonNull(defaultPollInterval, "'defaultPollInterval' cannot be null.");
            if (this.defaultPollInterval.isNegative()) {
                throw LOGGER
                    .logExceptionAsError(new IllegalArgumentException("'defaultPollInterval' cannot be negative"));
            }
            return this;
        }

        /**
         * Creates an instance of Traffic Controller service API entry point.
         *
         * @param credential the credential to use.
         * @param profile the Azure profile for client.
         * @return the Traffic Controller service API instance.
         */
        public TrafficControllerManager authenticate(TokenCredential credential, AzureProfile profile) {
            Objects.requireNonNull(credential, "'credential' cannot be null.");
            Objects.requireNonNull(profile, "'profile' cannot be null.");

            StringBuilder userAgentBuilder = new StringBuilder();
            userAgentBuilder.append("azsdk-java")
                .append("-")
                .append("com.azure.resourcemanager.servicenetworking")
                .append("/")
                .append("1.1.0");
            if (!Configuration.getGlobalConfiguration().get("AZURE_TELEMETRY_DISABLED", false)) {
                userAgentBuilder.append(" (")
                    .append(Configuration.getGlobalConfiguration().get("java.version"))
                    .append("; ")
                    .append(Configuration.getGlobalConfiguration().get("os.name"))
                    .append("; ")
                    .append(Configuration.getGlobalConfiguration().get("os.version"))
                    .append("; auto-generated)");
            } else {
                userAgentBuilder.append(" (auto-generated)");
            }

            if (scopes.isEmpty()) {
                scopes.add(profile.getEnvironment().getManagementEndpoint() + "/.default");
            }
            if (retryPolicy == null) {
                if (retryOptions != null) {
                    retryPolicy = new RetryPolicy(retryOptions);
                } else {
                    retryPolicy = new RetryPolicy("Retry-After", ChronoUnit.SECONDS);
                }
            }
            List<HttpPipelinePolicy> policies = new ArrayList<>();
            policies.add(new UserAgentPolicy(userAgentBuilder.toString()));
            policies.add(new AddHeadersFromContextPolicy());
            policies.add(new RequestIdPolicy());
            policies.addAll(this.policies.stream()
                .filter(p -> p.getPipelinePosition() == HttpPipelinePosition.PER_CALL)
                .collect(Collectors.toList()));
            HttpPolicyProviders.addBeforeRetryPolicies(policies);
            policies.add(retryPolicy);
            policies.add(new AddDatePolicy());
            policies.add(new BearerTokenAuthenticationPolicy(credential, scopes.toArray(new String[0])));
            policies.addAll(this.policies.stream()
                .filter(p -> p.getPipelinePosition() == HttpPipelinePosition.PER_RETRY)
                .collect(Collectors.toList()));
            HttpPolicyProviders.addAfterRetryPolicies(policies);
            policies.add(new HttpLoggingPolicy(httpLogOptions));
            HttpPipeline httpPipeline = new HttpPipelineBuilder().httpClient(httpClient)
                .policies(policies.toArray(new HttpPipelinePolicy[0]))
                .build();
            return new TrafficControllerManager(httpPipeline, profile, defaultPollInterval);
        }
    }

    /**
     * Gets the resource collection API of AssociationsInterfaces. It manages Association.
     * 
     * @return Resource collection API of AssociationsInterfaces.
     */
    public AssociationsInterfaces associationsInterfaces() {
        if (this.associationsInterfaces == null) {
            this.associationsInterfaces
                = new AssociationsInterfacesImpl(clientObject.getAssociationsInterfaces(), this);
        }
        return associationsInterfaces;
    }

    /**
     * Gets the resource collection API of FrontendsInterfaces. It manages Frontend.
     * 
     * @return Resource collection API of FrontendsInterfaces.
     */
    public FrontendsInterfaces frontendsInterfaces() {
        if (this.frontendsInterfaces == null) {
            this.frontendsInterfaces = new FrontendsInterfacesImpl(clientObject.getFrontendsInterfaces(), this);
        }
        return frontendsInterfaces;
    }

    /**
     * Gets the resource collection API of SecurityPoliciesInterfaces. It manages SecurityPolicy.
     * 
     * @return Resource collection API of SecurityPoliciesInterfaces.
     */
    public SecurityPoliciesInterfaces securityPoliciesInterfaces() {
        if (this.securityPoliciesInterfaces == null) {
            this.securityPoliciesInterfaces
                = new SecurityPoliciesInterfacesImpl(clientObject.getSecurityPoliciesInterfaces(), this);
        }
        return securityPoliciesInterfaces;
    }

    /**
     * Gets the resource collection API of TrafficControllerInterfaces. It manages TrafficController.
     * 
     * @return Resource collection API of TrafficControllerInterfaces.
     */
    public TrafficControllerInterfaces trafficControllerInterfaces() {
        if (this.trafficControllerInterfaces == null) {
            this.trafficControllerInterfaces
                = new TrafficControllerInterfacesImpl(clientObject.getTrafficControllerInterfaces(), this);
        }
        return trafficControllerInterfaces;
    }

    /**
     * Gets the resource collection API of Operations.
     * 
     * @return Resource collection API of Operations.
     */
    public Operations operations() {
        if (this.operations == null) {
            this.operations = new OperationsImpl(clientObject.getOperations(), this);
        }
        return operations;
    }

    /**
     * Gets wrapped service client TrafficControllerManagementClient providing direct access to the underlying
     * auto-generated API implementation, based on Azure REST API.
     * 
     * @return Wrapped service client TrafficControllerManagementClient.
     */
    public TrafficControllerManagementClient serviceClient() {
        return this.clientObject;
    }
}
