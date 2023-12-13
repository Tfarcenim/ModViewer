package com.replaymod.lib.com.google.api.client.googleapis;

import com.replaymod.lib.com.google.api.client.http.EmptyContent;
import com.replaymod.lib.com.google.api.client.http.HttpExecuteInterceptor;
import com.replaymod.lib.com.google.api.client.http.HttpRequest;
import com.replaymod.lib.com.google.api.client.http.HttpRequestInitializer;
import com.replaymod.lib.com.google.api.client.http.UrlEncodedContent;
import java.io.IOException;

public final class MethodOverride implements HttpExecuteInterceptor, HttpRequestInitializer {
   public static final String HEADER = "X-HTTP-Method-Override";
   static final int MAX_URL_LENGTH = 2048;
   private final boolean overrideAllMethods;

   public MethodOverride() {
      this(false);
   }

   MethodOverride(boolean overrideAllMethods) {
      this.overrideAllMethods = overrideAllMethods;
   }

   public void initialize(HttpRequest request) {
      request.setInterceptor(this);
   }

   public void intercept(HttpRequest request) throws IOException {
      if (this.overrideThisMethod(request)) {
         String requestMethod = request.getRequestMethod();
         request.setRequestMethod("POST");
         request.getHeaders().set("X-HTTP-Method-Override", requestMethod);
         if (requestMethod.equals("GET")) {
            request.setContent(new UrlEncodedContent(request.getUrl().clone()));
            request.getUrl().clear();
         } else if (request.getContent() == null) {
            request.setContent(new EmptyContent());
         }
      }

   }

   private boolean overrideThisMethod(HttpRequest request) throws IOException {
      String requestMethod = request.getRequestMethod();
      if (requestMethod.equals("POST")) {
         return false;
      } else {
         if (requestMethod.equals("GET")) {
            if (request.getUrl().build().length() <= 2048) {
               return !request.getTransport().supportsMethod(requestMethod);
            }
         } else if (!this.overrideAllMethods) {
            return !request.getTransport().supportsMethod(requestMethod);
         }

         return true;
      }
   }

   public static final class Builder {
      private boolean overrideAllMethods;

      public MethodOverride build() {
         return new MethodOverride(this.overrideAllMethods);
      }

      public boolean getOverrideAllMethods() {
         return this.overrideAllMethods;
      }

      public MethodOverride.Builder setOverrideAllMethods(boolean overrideAllMethods) {
         this.overrideAllMethods = overrideAllMethods;
         return this;
      }
   }
}
