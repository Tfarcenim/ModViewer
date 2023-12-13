package com.replaymod.lib.com.google.api.client.googleapis.services.json;

import com.replaymod.lib.com.google.api.client.googleapis.batch.BatchRequest;
import com.replaymod.lib.com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.replaymod.lib.com.google.api.client.googleapis.json.GoogleJsonErrorContainer;
import com.replaymod.lib.com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.replaymod.lib.com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.replaymod.lib.com.google.api.client.http.HttpHeaders;
import com.replaymod.lib.com.google.api.client.http.HttpResponse;
import com.replaymod.lib.com.google.api.client.http.json.JsonHttpContent;
import java.io.IOException;

public abstract class AbstractGoogleJsonClientRequest<T> extends AbstractGoogleClientRequest<T> {
   private final Object jsonContent;

   protected AbstractGoogleJsonClientRequest(AbstractGoogleJsonClient abstractGoogleJsonClient, String requestMethod, String uriTemplate, Object jsonContent, Class<T> responseClass) {
      super(abstractGoogleJsonClient, requestMethod, uriTemplate, jsonContent == null ? null : (new JsonHttpContent(abstractGoogleJsonClient.getJsonFactory(), jsonContent)).setWrapperKey(abstractGoogleJsonClient.getObjectParser().getWrapperKeys().isEmpty() ? null : "data"), responseClass);
      this.jsonContent = jsonContent;
   }

   public AbstractGoogleJsonClient getAbstractGoogleClient() {
      return (AbstractGoogleJsonClient)super.getAbstractGoogleClient();
   }

   public AbstractGoogleJsonClientRequest<T> setDisableGZipContent(boolean disableGZipContent) {
      return (AbstractGoogleJsonClientRequest)super.setDisableGZipContent(disableGZipContent);
   }

   public AbstractGoogleJsonClientRequest<T> setRequestHeaders(HttpHeaders headers) {
      return (AbstractGoogleJsonClientRequest)super.setRequestHeaders(headers);
   }

   public final void queue(BatchRequest batchRequest, JsonBatchCallback<T> callback) throws IOException {
      super.queue(batchRequest, GoogleJsonErrorContainer.class, callback);
   }

   protected GoogleJsonResponseException newExceptionOnError(HttpResponse response) {
      return GoogleJsonResponseException.from(this.getAbstractGoogleClient().getJsonFactory(), response);
   }

   public Object getJsonContent() {
      return this.jsonContent;
   }

   public AbstractGoogleJsonClientRequest<T> set(String fieldName, Object value) {
      return (AbstractGoogleJsonClientRequest)super.set(fieldName, value);
   }
}
