package com.replaymod.lib.com.google.api.client.auth.oauth2;

import com.replaymod.lib.com.google.api.client.http.GenericUrl;
import com.replaymod.lib.com.google.api.client.http.HttpExecuteInterceptor;
import com.replaymod.lib.com.google.api.client.http.HttpRequest;
import com.replaymod.lib.com.google.api.client.http.HttpRequestFactory;
import com.replaymod.lib.com.google.api.client.http.HttpRequestInitializer;
import com.replaymod.lib.com.google.api.client.http.HttpResponse;
import com.replaymod.lib.com.google.api.client.http.HttpTransport;
import com.replaymod.lib.com.google.api.client.http.UrlEncodedContent;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.json.JsonObjectParser;
import com.replaymod.lib.com.google.api.client.util.GenericData;
import com.replaymod.lib.com.google.api.client.util.Joiner;
import com.replaymod.lib.com.google.api.client.util.Key;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;

public class TokenRequest extends GenericData {
   HttpRequestInitializer requestInitializer;
   HttpExecuteInterceptor clientAuthentication;
   private final HttpTransport transport;
   private final JsonFactory jsonFactory;
   private GenericUrl tokenServerUrl;
   @Key("scope")
   private String scopes;
   @Key("grant_type")
   private String grantType;

   public TokenRequest(HttpTransport transport, JsonFactory jsonFactory, GenericUrl tokenServerUrl, String grantType) {
      this.transport = (HttpTransport)Preconditions.checkNotNull(transport);
      this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(jsonFactory);
      this.setTokenServerUrl(tokenServerUrl);
      this.setGrantType(grantType);
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final HttpRequestInitializer getRequestInitializer() {
      return this.requestInitializer;
   }

   public TokenRequest setRequestInitializer(HttpRequestInitializer requestInitializer) {
      this.requestInitializer = requestInitializer;
      return this;
   }

   public final HttpExecuteInterceptor getClientAuthentication() {
      return this.clientAuthentication;
   }

   public TokenRequest setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      this.clientAuthentication = clientAuthentication;
      return this;
   }

   public final GenericUrl getTokenServerUrl() {
      return this.tokenServerUrl;
   }

   public TokenRequest setTokenServerUrl(GenericUrl tokenServerUrl) {
      this.tokenServerUrl = tokenServerUrl;
      Preconditions.checkArgument(tokenServerUrl.getFragment() == null);
      return this;
   }

   public final String getScopes() {
      return this.scopes;
   }

   public TokenRequest setScopes(Collection<String> scopes) {
      this.scopes = scopes == null ? null : Joiner.on(' ').join(scopes);
      return this;
   }

   public final String getGrantType() {
      return this.grantType;
   }

   public TokenRequest setGrantType(String grantType) {
      this.grantType = (String)Preconditions.checkNotNull(grantType);
      return this;
   }

   public final HttpResponse executeUnparsed() throws IOException {
      HttpRequestFactory requestFactory = this.transport.createRequestFactory(new HttpRequestInitializer() {
         public void initialize(HttpRequest request) throws IOException {
            if (TokenRequest.this.requestInitializer != null) {
               TokenRequest.this.requestInitializer.initialize(request);
            }

            final HttpExecuteInterceptor interceptor = request.getInterceptor();
            request.setInterceptor(new HttpExecuteInterceptor() {
               public void intercept(HttpRequest request) throws IOException {
                  if (interceptor != null) {
                     interceptor.intercept(request);
                  }

                  if (TokenRequest.this.clientAuthentication != null) {
                     TokenRequest.this.clientAuthentication.intercept(request);
                  }

               }
            });
         }
      });
      HttpRequest request = requestFactory.buildPostRequest(this.tokenServerUrl, new UrlEncodedContent(this));
      request.setParser(new JsonObjectParser(this.jsonFactory));
      request.setThrowExceptionOnExecuteError(false);
      HttpResponse response = request.execute();
      if (response.isSuccessStatusCode()) {
         return response;
      } else {
         throw TokenResponseException.from(this.jsonFactory, response);
      }
   }

   public TokenResponse execute() throws IOException {
      return (TokenResponse)this.executeUnparsed().parseAs(TokenResponse.class);
   }

   public TokenRequest set(String fieldName, Object value) {
      return (TokenRequest)super.set(fieldName, value);
   }
}
