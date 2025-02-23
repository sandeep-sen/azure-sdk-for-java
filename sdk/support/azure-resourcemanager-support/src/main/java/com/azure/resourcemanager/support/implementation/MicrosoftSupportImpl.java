// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.support.implementation;

import com.azure.core.annotation.ServiceClient;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.Response;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.exception.ManagementError;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.management.polling.PollResult;
import com.azure.core.management.polling.PollerFactory;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.AsyncPollResponse;
import com.azure.core.util.polling.LongRunningOperationStatus;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.azure.resourcemanager.support.fluent.ChatTranscriptsClient;
import com.azure.resourcemanager.support.fluent.ChatTranscriptsNoSubscriptionsClient;
import com.azure.resourcemanager.support.fluent.CommunicationsClient;
import com.azure.resourcemanager.support.fluent.CommunicationsNoSubscriptionsClient;
import com.azure.resourcemanager.support.fluent.FileWorkspacesClient;
import com.azure.resourcemanager.support.fluent.FileWorkspacesNoSubscriptionsClient;
import com.azure.resourcemanager.support.fluent.FilesClient;
import com.azure.resourcemanager.support.fluent.FilesNoSubscriptionsClient;
import com.azure.resourcemanager.support.fluent.MicrosoftSupport;
import com.azure.resourcemanager.support.fluent.OperationsClient;
import com.azure.resourcemanager.support.fluent.ProblemClassificationsClient;
import com.azure.resourcemanager.support.fluent.ServicesClient;
import com.azure.resourcemanager.support.fluent.SupportTicketsClient;
import com.azure.resourcemanager.support.fluent.SupportTicketsNoSubscriptionsClient;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Initializes a new instance of the MicrosoftSupportImpl type.
 */
@ServiceClient(builder = MicrosoftSupportBuilder.class)
public final class MicrosoftSupportImpl implements MicrosoftSupport {
    /**
     * The ID of the target subscription. The value must be an UUID.
     */
    private final String subscriptionId;

    /**
     * Gets The ID of the target subscription. The value must be an UUID.
     * 
     * @return the subscriptionId value.
     */
    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    /**
     * server parameter.
     */
    private final String endpoint;

    /**
     * Gets server parameter.
     * 
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /**
     * Api Version.
     */
    private final String apiVersion;

    /**
     * Gets Api Version.
     * 
     * @return the apiVersion value.
     */
    public String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * The HTTP pipeline to send requests through.
     */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     * 
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /**
     * The serializer to serialize an object into a string.
     */
    private final SerializerAdapter serializerAdapter;

    /**
     * Gets The serializer to serialize an object into a string.
     * 
     * @return the serializerAdapter value.
     */
    SerializerAdapter getSerializerAdapter() {
        return this.serializerAdapter;
    }

    /**
     * The default poll interval for long-running operation.
     */
    private final Duration defaultPollInterval;

    /**
     * Gets The default poll interval for long-running operation.
     * 
     * @return the defaultPollInterval value.
     */
    public Duration getDefaultPollInterval() {
        return this.defaultPollInterval;
    }

    /**
     * The OperationsClient object to access its operations.
     */
    private final OperationsClient operations;

    /**
     * Gets the OperationsClient object to access its operations.
     * 
     * @return the OperationsClient object.
     */
    public OperationsClient getOperations() {
        return this.operations;
    }

    /**
     * The ServicesClient object to access its operations.
     */
    private final ServicesClient services;

    /**
     * Gets the ServicesClient object to access its operations.
     * 
     * @return the ServicesClient object.
     */
    public ServicesClient getServices() {
        return this.services;
    }

    /**
     * The ProblemClassificationsClient object to access its operations.
     */
    private final ProblemClassificationsClient problemClassifications;

    /**
     * Gets the ProblemClassificationsClient object to access its operations.
     * 
     * @return the ProblemClassificationsClient object.
     */
    public ProblemClassificationsClient getProblemClassifications() {
        return this.problemClassifications;
    }

    /**
     * The SupportTicketsClient object to access its operations.
     */
    private final SupportTicketsClient supportTickets;

    /**
     * Gets the SupportTicketsClient object to access its operations.
     * 
     * @return the SupportTicketsClient object.
     */
    public SupportTicketsClient getSupportTickets() {
        return this.supportTickets;
    }

    /**
     * The SupportTicketsNoSubscriptionsClient object to access its operations.
     */
    private final SupportTicketsNoSubscriptionsClient supportTicketsNoSubscriptions;

    /**
     * Gets the SupportTicketsNoSubscriptionsClient object to access its operations.
     * 
     * @return the SupportTicketsNoSubscriptionsClient object.
     */
    public SupportTicketsNoSubscriptionsClient getSupportTicketsNoSubscriptions() {
        return this.supportTicketsNoSubscriptions;
    }

    /**
     * The CommunicationsClient object to access its operations.
     */
    private final CommunicationsClient communications;

    /**
     * Gets the CommunicationsClient object to access its operations.
     * 
     * @return the CommunicationsClient object.
     */
    public CommunicationsClient getCommunications() {
        return this.communications;
    }

    /**
     * The CommunicationsNoSubscriptionsClient object to access its operations.
     */
    private final CommunicationsNoSubscriptionsClient communicationsNoSubscriptions;

    /**
     * Gets the CommunicationsNoSubscriptionsClient object to access its operations.
     * 
     * @return the CommunicationsNoSubscriptionsClient object.
     */
    public CommunicationsNoSubscriptionsClient getCommunicationsNoSubscriptions() {
        return this.communicationsNoSubscriptions;
    }

    /**
     * The ChatTranscriptsClient object to access its operations.
     */
    private final ChatTranscriptsClient chatTranscripts;

    /**
     * Gets the ChatTranscriptsClient object to access its operations.
     * 
     * @return the ChatTranscriptsClient object.
     */
    public ChatTranscriptsClient getChatTranscripts() {
        return this.chatTranscripts;
    }

    /**
     * The ChatTranscriptsNoSubscriptionsClient object to access its operations.
     */
    private final ChatTranscriptsNoSubscriptionsClient chatTranscriptsNoSubscriptions;

    /**
     * Gets the ChatTranscriptsNoSubscriptionsClient object to access its operations.
     * 
     * @return the ChatTranscriptsNoSubscriptionsClient object.
     */
    public ChatTranscriptsNoSubscriptionsClient getChatTranscriptsNoSubscriptions() {
        return this.chatTranscriptsNoSubscriptions;
    }

    /**
     * The FileWorkspacesClient object to access its operations.
     */
    private final FileWorkspacesClient fileWorkspaces;

    /**
     * Gets the FileWorkspacesClient object to access its operations.
     * 
     * @return the FileWorkspacesClient object.
     */
    public FileWorkspacesClient getFileWorkspaces() {
        return this.fileWorkspaces;
    }

    /**
     * The FileWorkspacesNoSubscriptionsClient object to access its operations.
     */
    private final FileWorkspacesNoSubscriptionsClient fileWorkspacesNoSubscriptions;

    /**
     * Gets the FileWorkspacesNoSubscriptionsClient object to access its operations.
     * 
     * @return the FileWorkspacesNoSubscriptionsClient object.
     */
    public FileWorkspacesNoSubscriptionsClient getFileWorkspacesNoSubscriptions() {
        return this.fileWorkspacesNoSubscriptions;
    }

    /**
     * The FilesClient object to access its operations.
     */
    private final FilesClient files;

    /**
     * Gets the FilesClient object to access its operations.
     * 
     * @return the FilesClient object.
     */
    public FilesClient getFiles() {
        return this.files;
    }

    /**
     * The FilesNoSubscriptionsClient object to access its operations.
     */
    private final FilesNoSubscriptionsClient filesNoSubscriptions;

    /**
     * Gets the FilesNoSubscriptionsClient object to access its operations.
     * 
     * @return the FilesNoSubscriptionsClient object.
     */
    public FilesNoSubscriptionsClient getFilesNoSubscriptions() {
        return this.filesNoSubscriptions;
    }

    /**
     * Initializes an instance of MicrosoftSupport client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param serializerAdapter The serializer to serialize an object into a string.
     * @param defaultPollInterval The default poll interval for long-running operation.
     * @param environment The Azure environment.
     * @param subscriptionId The ID of the target subscription. The value must be an UUID.
     * @param endpoint server parameter.
     */
    MicrosoftSupportImpl(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, Duration defaultPollInterval,
        AzureEnvironment environment, String subscriptionId, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.serializerAdapter = serializerAdapter;
        this.defaultPollInterval = defaultPollInterval;
        this.subscriptionId = subscriptionId;
        this.endpoint = endpoint;
        this.apiVersion = "2024-04-01";
        this.operations = new OperationsClientImpl(this);
        this.services = new ServicesClientImpl(this);
        this.problemClassifications = new ProblemClassificationsClientImpl(this);
        this.supportTickets = new SupportTicketsClientImpl(this);
        this.supportTicketsNoSubscriptions = new SupportTicketsNoSubscriptionsClientImpl(this);
        this.communications = new CommunicationsClientImpl(this);
        this.communicationsNoSubscriptions = new CommunicationsNoSubscriptionsClientImpl(this);
        this.chatTranscripts = new ChatTranscriptsClientImpl(this);
        this.chatTranscriptsNoSubscriptions = new ChatTranscriptsNoSubscriptionsClientImpl(this);
        this.fileWorkspaces = new FileWorkspacesClientImpl(this);
        this.fileWorkspacesNoSubscriptions = new FileWorkspacesNoSubscriptionsClientImpl(this);
        this.files = new FilesClientImpl(this);
        this.filesNoSubscriptions = new FilesNoSubscriptionsClientImpl(this);
    }

    /**
     * Gets default client context.
     * 
     * @return the default client context.
     */
    public Context getContext() {
        return Context.NONE;
    }

    /**
     * Merges default client context with provided context.
     * 
     * @param context the context to be merged with default client context.
     * @return the merged context.
     */
    public Context mergeContext(Context context) {
        return CoreUtils.mergeContexts(this.getContext(), context);
    }

    /**
     * Gets long running operation result.
     * 
     * @param activationResponse the response of activation operation.
     * @param httpPipeline the http pipeline.
     * @param pollResultType type of poll result.
     * @param finalResultType type of final result.
     * @param context the context shared by all requests.
     * @param <T> type of poll result.
     * @param <U> type of final result.
     * @return poller flux for poll result and final result.
     */
    public <T, U> PollerFlux<PollResult<T>, U> getLroResult(Mono<Response<Flux<ByteBuffer>>> activationResponse,
        HttpPipeline httpPipeline, Type pollResultType, Type finalResultType, Context context) {
        return PollerFactory.create(serializerAdapter, httpPipeline, pollResultType, finalResultType,
            defaultPollInterval, activationResponse, context);
    }

    /**
     * Gets the final result, or an error, based on last async poll response.
     * 
     * @param response the last async poll response.
     * @param <T> type of poll result.
     * @param <U> type of final result.
     * @return the final result, or an error.
     */
    public <T, U> Mono<U> getLroFinalResultOrError(AsyncPollResponse<PollResult<T>, U> response) {
        if (response.getStatus() != LongRunningOperationStatus.SUCCESSFULLY_COMPLETED) {
            String errorMessage;
            ManagementError managementError = null;
            HttpResponse errorResponse = null;
            PollResult.Error lroError = response.getValue().getError();
            if (lroError != null) {
                errorResponse = new HttpResponseImpl(lroError.getResponseStatusCode(), lroError.getResponseHeaders(),
                    lroError.getResponseBody());

                errorMessage = response.getValue().getError().getMessage();
                String errorBody = response.getValue().getError().getResponseBody();
                if (errorBody != null) {
                    // try to deserialize error body to ManagementError
                    try {
                        managementError = this.getSerializerAdapter()
                            .deserialize(errorBody, ManagementError.class, SerializerEncoding.JSON);
                        if (managementError.getCode() == null || managementError.getMessage() == null) {
                            managementError = null;
                        }
                    } catch (IOException | RuntimeException ioe) {
                        LOGGER.logThrowableAsWarning(ioe);
                    }
                }
            } else {
                // fallback to default error message
                errorMessage = "Long running operation failed.";
            }
            if (managementError == null) {
                // fallback to default ManagementError
                managementError = new ManagementError(response.getStatus().toString(), errorMessage);
            }
            return Mono.error(new ManagementException(errorMessage, errorResponse, managementError));
        } else {
            return response.getFinalResult();
        }
    }

    private static final class HttpResponseImpl extends HttpResponse {
        private final int statusCode;

        private final byte[] responseBody;

        private final HttpHeaders httpHeaders;

        HttpResponseImpl(int statusCode, HttpHeaders httpHeaders, String responseBody) {
            super(null);
            this.statusCode = statusCode;
            this.httpHeaders = httpHeaders;
            this.responseBody = responseBody == null ? null : responseBody.getBytes(StandardCharsets.UTF_8);
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getHeaderValue(String s) {
            return httpHeaders.getValue(HttpHeaderName.fromString(s));
        }

        public HttpHeaders getHeaders() {
            return httpHeaders;
        }

        public Flux<ByteBuffer> getBody() {
            return Flux.just(ByteBuffer.wrap(responseBody));
        }

        public Mono<byte[]> getBodyAsByteArray() {
            return Mono.just(responseBody);
        }

        public Mono<String> getBodyAsString() {
            return Mono.just(new String(responseBody, StandardCharsets.UTF_8));
        }

        public Mono<String> getBodyAsString(Charset charset) {
            return Mono.just(new String(responseBody, charset));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(MicrosoftSupportImpl.class);
}
