package com.replaymod.lib.com.google.api.client.googleapis.services.json;

import com.replaymod.lib.com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.replaymod.lib.com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.replaymod.lib.com.google.api.client.http.HttpRequestInitializer;
import com.replaymod.lib.com.google.api.client.http.HttpTransport;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.json.JsonObjectParser;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractGoogleJsonClient extends AbstractGoogleClient {
   protected AbstractGoogleJsonClient(AbstractGoogleJsonClient.Builder builder) {
      super(builder);
   }

   public JsonObjectParser getObjectParser() {
      return (JsonObjectParser)super.getObjectParser();
   }

   public final JsonFactory getJsonFactory() {
      return this.getObjectParser().getJsonFactory();
   }

   public abstract static class Builder extends AbstractGoogleClient.Builder {
      protected Builder(HttpTransport transport, JsonFactory jsonFactory, String rootUrl, String servicePath, HttpRequestInitializer httpRequestInitializer, boolean legacyDataWrapper) {
         super(transport, rootUrl, servicePath, (new JsonObjectParser.Builder(jsonFactory)).setWrapperKeys((Collection)(legacyDataWrapper ? Arrays.asList("data", "error") : Collections.emptySet())).build(), httpRequestInitializer);
      }

      public final JsonObjectParser getObjectParser() {
         return (JsonObjectParser)super.getObjectParser();
      }

      public final JsonFactory getJsonFactory() {
         return this.getObjectParser().getJsonFactory();
      }

      public abstract AbstractGoogleJsonClient build();

      public AbstractGoogleJsonClient.Builder setRootUrl(String rootUrl) {
         return (AbstractGoogleJsonClient.Builder)super.setRootUrl(rootUrl);
      }

      public AbstractGoogleJsonClient.Builder setServicePath(String servicePath) {
         return (AbstractGoogleJsonClient.Builder)super.setServicePath(servicePath);
      }

      public AbstractGoogleJsonClient.Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
         return (AbstractGoogleJsonClient.Builder)super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
      }

      public AbstractGoogleJsonClient.Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
         return (AbstractGoogleJsonClient.Builder)super.setHttpRequestInitializer(httpRequestInitializer);
      }

      public AbstractGoogleJsonClient.Builder setApplicationName(String applicationName) {
         return (AbstractGoogleJsonClient.Builder)super.setApplicationName(applicationName);
      }

      public AbstractGoogleJsonClient.Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
         return (AbstractGoogleJsonClient.Builder)super.setSuppressPatternChecks(suppressPatternChecks);
      }

      public AbstractGoogleJsonClient.Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
         return (AbstractGoogleJsonClient.Builder)super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
      }

      public AbstractGoogleJsonClient.Builder setSuppressAllChecks(boolean suppressAllChecks) {
         return (AbstractGoogleJsonClient.Builder)super.setSuppressAllChecks(suppressAllChecks);
      }
   }
}
