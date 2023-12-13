package com.replaymod.lib.com.google.api.client.googleapis.services;

import com.replaymod.lib.com.google.api.client.googleapis.MethodOverride;
import com.replaymod.lib.com.google.api.client.googleapis.batch.BatchCallback;
import com.replaymod.lib.com.google.api.client.googleapis.batch.BatchRequest;
import com.replaymod.lib.com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.replaymod.lib.com.google.api.client.googleapis.media.MediaHttpUploader;
import com.replaymod.lib.com.google.api.client.http.AbstractInputStreamContent;
import com.replaymod.lib.com.google.api.client.http.EmptyContent;
import com.replaymod.lib.com.google.api.client.http.GZipEncoding;
import com.replaymod.lib.com.google.api.client.http.GenericUrl;
import com.replaymod.lib.com.google.api.client.http.HttpContent;
import com.replaymod.lib.com.google.api.client.http.HttpHeaders;
import com.replaymod.lib.com.google.api.client.http.HttpRequest;
import com.replaymod.lib.com.google.api.client.http.HttpRequestFactory;
import com.replaymod.lib.com.google.api.client.http.HttpResponse;
import com.replaymod.lib.com.google.api.client.http.HttpResponseException;
import com.replaymod.lib.com.google.api.client.http.HttpResponseInterceptor;
import com.replaymod.lib.com.google.api.client.http.UriTemplate;
import com.replaymod.lib.com.google.api.client.util.GenericData;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractGoogleClientRequest<T> extends GenericData {
   public static final String USER_AGENT_SUFFIX = "Google-API-Java-Client";
   private final AbstractGoogleClient abstractGoogleClient;
   private final String requestMethod;
   private final String uriTemplate;
   private final HttpContent httpContent;
   private HttpHeaders requestHeaders = new HttpHeaders();
   private HttpHeaders lastResponseHeaders;
   private int lastStatusCode = -1;
   private String lastStatusMessage;
   private boolean disableGZipContent;
   private Class<T> responseClass;
   private MediaHttpUploader uploader;
   private MediaHttpDownloader downloader;

   protected AbstractGoogleClientRequest(AbstractGoogleClient abstractGoogleClient, String requestMethod, String uriTemplate, HttpContent httpContent, Class<T> responseClass) {
      this.responseClass = (Class)Preconditions.checkNotNull(responseClass);
      this.abstractGoogleClient = (AbstractGoogleClient)Preconditions.checkNotNull(abstractGoogleClient);
      this.requestMethod = (String)Preconditions.checkNotNull(requestMethod);
      this.uriTemplate = (String)Preconditions.checkNotNull(uriTemplate);
      this.httpContent = httpContent;
      String applicationName = abstractGoogleClient.getApplicationName();
      if (applicationName != null) {
         this.requestHeaders.setUserAgent(applicationName + " " + "Google-API-Java-Client");
      } else {
         this.requestHeaders.setUserAgent("Google-API-Java-Client");
      }

   }

   public final boolean getDisableGZipContent() {
      return this.disableGZipContent;
   }

   public AbstractGoogleClientRequest<T> setDisableGZipContent(boolean disableGZipContent) {
      this.disableGZipContent = disableGZipContent;
      return this;
   }

   public final String getRequestMethod() {
      return this.requestMethod;
   }

   public final String getUriTemplate() {
      return this.uriTemplate;
   }

   public final HttpContent getHttpContent() {
      return this.httpContent;
   }

   public AbstractGoogleClient getAbstractGoogleClient() {
      return this.abstractGoogleClient;
   }

   public final HttpHeaders getRequestHeaders() {
      return this.requestHeaders;
   }

   public AbstractGoogleClientRequest<T> setRequestHeaders(HttpHeaders headers) {
      this.requestHeaders = headers;
      return this;
   }

   public final HttpHeaders getLastResponseHeaders() {
      return this.lastResponseHeaders;
   }

   public final int getLastStatusCode() {
      return this.lastStatusCode;
   }

   public final String getLastStatusMessage() {
      return this.lastStatusMessage;
   }

   public final Class<T> getResponseClass() {
      return this.responseClass;
   }

   public final MediaHttpUploader getMediaHttpUploader() {
      return this.uploader;
   }

   protected final void initializeMediaUpload(AbstractInputStreamContent mediaContent) {
      HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
      this.uploader = new MediaHttpUploader(mediaContent, requestFactory.getTransport(), requestFactory.getInitializer());
      this.uploader.setInitiationRequestMethod(this.requestMethod);
      if (this.httpContent != null) {
         this.uploader.setMetadata(this.httpContent);
      }

   }

   public final MediaHttpDownloader getMediaHttpDownloader() {
      return this.downloader;
   }

   protected final void initializeMediaDownload() {
      HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
      this.downloader = new MediaHttpDownloader(requestFactory.getTransport(), requestFactory.getInitializer());
   }

   public GenericUrl buildHttpRequestUrl() {
      return new GenericUrl(UriTemplate.expand(this.abstractGoogleClient.getBaseUrl(), this.uriTemplate, this, true));
   }

   public HttpRequest buildHttpRequest() throws IOException {
      return this.buildHttpRequest(false);
   }

   protected HttpRequest buildHttpRequestUsingHead() throws IOException {
      return this.buildHttpRequest(true);
   }

   private HttpRequest buildHttpRequest(boolean usingHead) throws IOException {
      Preconditions.checkArgument(this.uploader == null);
      Preconditions.checkArgument(!usingHead || this.requestMethod.equals("GET"));
      String requestMethodToUse = usingHead ? "HEAD" : this.requestMethod;
      final HttpRequest httpRequest = this.getAbstractGoogleClient().getRequestFactory().buildRequest(requestMethodToUse, this.buildHttpRequestUrl(), this.httpContent);
      (new MethodOverride()).intercept(httpRequest);
      httpRequest.setParser(this.getAbstractGoogleClient().getObjectParser());
      if (this.httpContent == null && (this.requestMethod.equals("POST") || this.requestMethod.equals("PUT") || this.requestMethod.equals("PATCH"))) {
         httpRequest.setContent(new EmptyContent());
      }

      httpRequest.getHeaders().putAll(this.requestHeaders);
      if (!this.disableGZipContent) {
         httpRequest.setEncoding(new GZipEncoding());
      }

      final HttpResponseInterceptor responseInterceptor = httpRequest.getResponseInterceptor();
      httpRequest.setResponseInterceptor(new HttpResponseInterceptor() {
         public void interceptResponse(HttpResponse response) throws IOException {
            if (responseInterceptor != null) {
               responseInterceptor.interceptResponse(response);
            }

            if (!response.isSuccessStatusCode() && httpRequest.getThrowExceptionOnExecuteError()) {
               throw AbstractGoogleClientRequest.this.newExceptionOnError(response);
            }
         }
      });
      return httpRequest;
   }

   public HttpResponse executeUnparsed() throws IOException {
      return this.executeUnparsed(false);
   }

   protected HttpResponse executeMedia() throws IOException {
      this.set("alt", "media");
      return this.executeUnparsed();
   }

   protected HttpResponse executeUsingHead() throws IOException {
      Preconditions.checkArgument(this.uploader == null);
      HttpResponse response = this.executeUnparsed(true);
      response.ignore();
      return response;
   }

   private HttpResponse executeUnparsed(boolean usingHead) throws IOException {
      HttpResponse response;
      if (this.uploader == null) {
         response = this.buildHttpRequest(usingHead).execute();
      } else {
         GenericUrl httpRequestUrl = this.buildHttpRequestUrl();
         HttpRequest httpRequest = this.getAbstractGoogleClient().getRequestFactory().buildRequest(this.requestMethod, httpRequestUrl, this.httpContent);
         boolean throwExceptionOnExecuteError = httpRequest.getThrowExceptionOnExecuteError();
         response = this.uploader.setInitiationHeaders(this.requestHeaders).setDisableGZipContent(this.disableGZipContent).upload(httpRequestUrl);
         response.getRequest().setParser(this.getAbstractGoogleClient().getObjectParser());
         if (throwExceptionOnExecuteError && !response.isSuccessStatusCode()) {
            throw this.newExceptionOnError(response);
         }
      }

      this.lastResponseHeaders = response.getHeaders();
      this.lastStatusCode = response.getStatusCode();
      this.lastStatusMessage = response.getStatusMessage();
      return response;
   }

   protected IOException newExceptionOnError(HttpResponse response) {
      return new HttpResponseException(response);
   }

   public T execute() throws IOException {
      return this.executeUnparsed().parseAs(this.responseClass);
   }

   public InputStream executeAsInputStream() throws IOException {
      return this.executeUnparsed().getContent();
   }

   protected InputStream executeMediaAsInputStream() throws IOException {
      return this.executeMedia().getContent();
   }

   public void executeAndDownloadTo(OutputStream outputStream) throws IOException {
      this.executeUnparsed().download(outputStream);
   }

   protected void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
      if (this.downloader == null) {
         this.executeMedia().download(outputStream);
      } else {
         this.downloader.download(this.buildHttpRequestUrl(), this.requestHeaders, outputStream);
      }

   }

   public final <E> void queue(BatchRequest batchRequest, Class<E> errorClass, BatchCallback<T, E> callback) throws IOException {
      Preconditions.checkArgument(this.uploader == null, "Batching media requests is not supported");
      batchRequest.queue(this.buildHttpRequest(), this.getResponseClass(), errorClass, callback);
   }

   public AbstractGoogleClientRequest<T> set(String fieldName, Object value) {
      return (AbstractGoogleClientRequest)super.set(fieldName, value);
   }

   protected final void checkRequiredParameter(Object value, String name) {
      Preconditions.checkArgument(this.abstractGoogleClient.getSuppressRequiredParameterChecks() || value != null, "Required parameter %s must be specified", name);
   }
}
