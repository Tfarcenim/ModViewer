package com.replaymod.lib.com.google.api.client.googleapis.batch;

import com.replaymod.lib.com.google.api.client.http.BackOffPolicy;
import com.replaymod.lib.com.google.api.client.http.GenericUrl;
import com.replaymod.lib.com.google.api.client.http.HttpContent;
import com.replaymod.lib.com.google.api.client.http.HttpHeaders;
import com.replaymod.lib.com.google.api.client.http.HttpRequest;
import com.replaymod.lib.com.google.api.client.http.HttpResponse;
import com.replaymod.lib.com.google.api.client.http.HttpStatusCodes;
import com.replaymod.lib.com.google.api.client.http.HttpTransport;
import com.replaymod.lib.com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.replaymod.lib.com.google.api.client.http.LowLevelHttpRequest;
import com.replaymod.lib.com.google.api.client.http.LowLevelHttpResponse;
import com.replaymod.lib.com.google.api.client.util.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class BatchUnparsedResponse {
   private final String boundary;
   private final List<BatchRequest.RequestInfo<?, ?>> requestInfos;
   private final InputStream inputStream;
   boolean hasNext = true;
   List<BatchRequest.RequestInfo<?, ?>> unsuccessfulRequestInfos = new ArrayList();
   boolean backOffRequired;
   private int contentId = 0;
   private final boolean retryAllowed;

   BatchUnparsedResponse(InputStream inputStream, String boundary, List<BatchRequest.RequestInfo<?, ?>> requestInfos, boolean retryAllowed) throws IOException {
      this.boundary = boundary;
      this.requestInfos = requestInfos;
      this.retryAllowed = retryAllowed;
      this.inputStream = inputStream;
      this.checkForFinalBoundary(this.readLine());
   }

   void parseNextResponse() throws IOException {
      ++this.contentId;

      String line;
      while((line = this.readLine()) != null && !line.equals("")) {
      }

      String statusLine = this.readLine();
      String[] statusParts = statusLine.split(" ");
      int statusCode = Integer.parseInt(statusParts[1]);
      List<String> headerNames = new ArrayList();
      List<String> headerValues = new ArrayList();
      long contentLength = -1L;

      while((line = this.readLine()) != null && !line.equals("")) {
         String[] headerParts = line.split(": ", 2);
         String headerName = headerParts[0];
         String headerValue = headerParts[1];
         headerNames.add(headerName);
         headerValues.add(headerValue);
         if ("Content-Length".equalsIgnoreCase(headerName.trim())) {
            contentLength = Long.parseLong(headerValue);
         }
      }

      Object body;
      if (contentLength == -1L) {
         ByteArrayOutputStream buffer = new ByteArrayOutputStream();

         while((line = this.readRawLine()) != null && !line.startsWith(this.boundary)) {
            buffer.write(line.getBytes("ISO-8859-1"));
         }

         body = trimCrlf(buffer.toByteArray());
         line = trimCrlf(line);
      } else {
         body = new FilterInputStream(ByteStreams.limit(this.inputStream, contentLength)) {
            public void close() {
            }
         };
      }

      HttpResponse response = this.getFakeResponse(statusCode, (InputStream)body, headerNames, headerValues);
      this.parseAndCallback((BatchRequest.RequestInfo)this.requestInfos.get(this.contentId - 1), statusCode, response);

      do {
         while(((InputStream)body).skip(contentLength) > 0L) {
         }
      } while(((InputStream)body).read() != -1);

      if (contentLength != -1L) {
         line = this.readLine();
      }

      while(line != null && line.length() == 0) {
         line = this.readLine();
      }

      this.checkForFinalBoundary(line);
   }

   private <T, E> void parseAndCallback(BatchRequest.RequestInfo<T, E> requestInfo, int statusCode, HttpResponse response) throws IOException {
      BatchCallback<T, E> callback = requestInfo.callback;
      HttpHeaders responseHeaders = response.getHeaders();
      HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler = requestInfo.request.getUnsuccessfulResponseHandler();
      BackOffPolicy backOffPolicy = requestInfo.request.getBackOffPolicy();
      this.backOffRequired = false;
      if (HttpStatusCodes.isSuccess(statusCode)) {
         if (callback == null) {
            return;
         }

         T parsed = this.getParsedDataClass(requestInfo.dataClass, response, requestInfo);
         callback.onSuccess(parsed, responseHeaders);
      } else {
         HttpContent content = requestInfo.request.getContent();
         boolean retrySupported = this.retryAllowed && (content == null || content.retrySupported());
         boolean errorHandled = false;
         boolean redirectRequest = false;
         if (unsuccessfulResponseHandler != null) {
            errorHandled = unsuccessfulResponseHandler.handleResponse(requestInfo.request, response, retrySupported);
         }

         if (!errorHandled) {
            if (requestInfo.request.handleRedirect(response.getStatusCode(), response.getHeaders())) {
               redirectRequest = true;
            } else if (retrySupported && backOffPolicy != null && backOffPolicy.isBackOffRequired(response.getStatusCode())) {
               this.backOffRequired = true;
            }
         }

         if (retrySupported && (errorHandled || this.backOffRequired || redirectRequest)) {
            this.unsuccessfulRequestInfos.add(requestInfo);
         } else {
            if (callback == null) {
               return;
            }

            E parsed = this.getParsedDataClass(requestInfo.errorClass, response, requestInfo);
            callback.onFailure(parsed, responseHeaders);
         }
      }

   }

   private <A, T, E> A getParsedDataClass(Class<A> dataClass, HttpResponse response, BatchRequest.RequestInfo<T, E> requestInfo) throws IOException {
      return dataClass == Void.class ? null : requestInfo.request.getParser().parseAndClose(response.getContent(), response.getContentCharset(), dataClass);
   }

   private HttpResponse getFakeResponse(int statusCode, InputStream partContent, List<String> headerNames, List<String> headerValues) throws IOException {
      HttpRequest request = (new BatchUnparsedResponse.FakeResponseHttpTransport(statusCode, partContent, headerNames, headerValues)).createRequestFactory().buildPostRequest(new GenericUrl("http://google.com/"), (HttpContent)null);
      request.setLoggingEnabled(false);
      request.setThrowExceptionOnExecuteError(false);
      return request.execute();
   }

   private String readRawLine() throws IOException {
      int b = this.inputStream.read();
      if (b == -1) {
         return null;
      } else {
         StringBuilder buffer;
         for(buffer = new StringBuilder(); b != -1; b = this.inputStream.read()) {
            buffer.append((char)b);
            if (b == 10) {
               break;
            }
         }

         return buffer.toString();
      }
   }

   private String readLine() throws IOException {
      return trimCrlf(this.readRawLine());
   }

   private static String trimCrlf(String input) {
      if (input.endsWith("\r\n")) {
         return input.substring(0, input.length() - 2);
      } else {
         return input.endsWith("\n") ? input.substring(0, input.length() - 1) : input;
      }
   }

   private static InputStream trimCrlf(byte[] bytes) {
      int length = bytes.length;
      if (length > 0 && bytes[length - 1] == 10) {
         --length;
      }

      if (length > 0 && bytes[length - 1] == 13) {
         --length;
      }

      return new ByteArrayInputStream(bytes, 0, length);
   }

   private void checkForFinalBoundary(String boundaryLine) throws IOException {
      if (boundaryLine.equals(this.boundary + "--")) {
         this.hasNext = false;
         this.inputStream.close();
      }

   }

   private static class FakeLowLevelHttpResponse extends LowLevelHttpResponse {
      private InputStream partContent;
      private int statusCode;
      private List<String> headerNames = new ArrayList();
      private List<String> headerValues = new ArrayList();

      FakeLowLevelHttpResponse(InputStream partContent, int statusCode, List<String> headerNames, List<String> headerValues) {
         this.partContent = partContent;
         this.statusCode = statusCode;
         this.headerNames = headerNames;
         this.headerValues = headerValues;
      }

      public InputStream getContent() {
         return this.partContent;
      }

      public int getStatusCode() {
         return this.statusCode;
      }

      public String getContentEncoding() {
         return null;
      }

      public long getContentLength() {
         return 0L;
      }

      public String getContentType() {
         return null;
      }

      public String getStatusLine() {
         return null;
      }

      public String getReasonPhrase() {
         return null;
      }

      public int getHeaderCount() {
         return this.headerNames.size();
      }

      public String getHeaderName(int index) {
         return (String)this.headerNames.get(index);
      }

      public String getHeaderValue(int index) {
         return (String)this.headerValues.get(index);
      }
   }

   private static class FakeLowLevelHttpRequest extends LowLevelHttpRequest {
      private InputStream partContent;
      private int statusCode;
      private List<String> headerNames;
      private List<String> headerValues;

      FakeLowLevelHttpRequest(InputStream partContent, int statusCode, List<String> headerNames, List<String> headerValues) {
         this.partContent = partContent;
         this.statusCode = statusCode;
         this.headerNames = headerNames;
         this.headerValues = headerValues;
      }

      public void addHeader(String name, String value) {
      }

      public LowLevelHttpResponse execute() {
         BatchUnparsedResponse.FakeLowLevelHttpResponse response = new BatchUnparsedResponse.FakeLowLevelHttpResponse(this.partContent, this.statusCode, this.headerNames, this.headerValues);
         return response;
      }
   }

   private static class FakeResponseHttpTransport extends HttpTransport {
      private int statusCode;
      private InputStream partContent;
      private List<String> headerNames;
      private List<String> headerValues;

      FakeResponseHttpTransport(int statusCode, InputStream partContent, List<String> headerNames, List<String> headerValues) {
         this.statusCode = statusCode;
         this.partContent = partContent;
         this.headerNames = headerNames;
         this.headerValues = headerValues;
      }

      protected LowLevelHttpRequest buildRequest(String method, String url) {
         return new BatchUnparsedResponse.FakeLowLevelHttpRequest(this.partContent, this.statusCode, this.headerNames, this.headerValues);
      }
   }
}
