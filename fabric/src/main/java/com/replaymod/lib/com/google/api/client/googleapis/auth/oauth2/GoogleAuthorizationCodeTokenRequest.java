package com.replaymod.lib.com.google.api.client.googleapis.auth.oauth2;

import com.replaymod.lib.com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.replaymod.lib.com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.replaymod.lib.com.google.api.client.http.GenericUrl;
import com.replaymod.lib.com.google.api.client.http.HttpExecuteInterceptor;
import com.replaymod.lib.com.google.api.client.http.HttpRequestInitializer;
import com.replaymod.lib.com.google.api.client.http.HttpTransport;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;

public class GoogleAuthorizationCodeTokenRequest extends AuthorizationCodeTokenRequest {
   public GoogleAuthorizationCodeTokenRequest(HttpTransport transport, JsonFactory jsonFactory, String clientId, String clientSecret, String code, String redirectUri) {
      this(transport, jsonFactory, "https://accounts.google.com/o/oauth2/token", clientId, clientSecret, code, redirectUri);
   }

   public GoogleAuthorizationCodeTokenRequest(HttpTransport transport, JsonFactory jsonFactory, String tokenServerEncodedUrl, String clientId, String clientSecret, String code, String redirectUri) {
      super(transport, jsonFactory, new GenericUrl(tokenServerEncodedUrl), code);
      this.setClientAuthentication(new ClientParametersAuthentication(clientId, clientSecret));
      this.setRedirectUri(redirectUri);
   }

   public GoogleAuthorizationCodeTokenRequest setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (GoogleAuthorizationCodeTokenRequest)super.setRequestInitializer(requestInitializer);
   }

   public GoogleAuthorizationCodeTokenRequest setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (GoogleAuthorizationCodeTokenRequest)super.setTokenServerUrl(tokenServerUrl);
   }

   public GoogleAuthorizationCodeTokenRequest setScopes(Collection<String> scopes) {
      return (GoogleAuthorizationCodeTokenRequest)super.setScopes(scopes);
   }

   public GoogleAuthorizationCodeTokenRequest setGrantType(String grantType) {
      return (GoogleAuthorizationCodeTokenRequest)super.setGrantType(grantType);
   }

   public GoogleAuthorizationCodeTokenRequest setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      Preconditions.checkNotNull(clientAuthentication);
      return (GoogleAuthorizationCodeTokenRequest)super.setClientAuthentication(clientAuthentication);
   }

   public GoogleAuthorizationCodeTokenRequest setCode(String code) {
      return (GoogleAuthorizationCodeTokenRequest)super.setCode(code);
   }

   public GoogleAuthorizationCodeTokenRequest setRedirectUri(String redirectUri) {
      Preconditions.checkNotNull(redirectUri);
      return (GoogleAuthorizationCodeTokenRequest)super.setRedirectUri(redirectUri);
   }

   public GoogleTokenResponse execute() throws IOException {
      return (GoogleTokenResponse)this.executeUnparsed().parseAs(GoogleTokenResponse.class);
   }

   public GoogleAuthorizationCodeTokenRequest set(String fieldName, Object value) {
      return (GoogleAuthorizationCodeTokenRequest)super.set(fieldName, value);
   }
}
