package com.replaymod.lib.com.google.api.client.auth.oauth2;

import com.replaymod.lib.com.google.api.client.http.GenericUrl;
import com.replaymod.lib.com.google.api.client.http.HttpExecuteInterceptor;
import com.replaymod.lib.com.google.api.client.http.HttpRequestInitializer;
import com.replaymod.lib.com.google.api.client.http.HttpTransport;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.util.Key;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.util.Collection;

public class RefreshTokenRequest extends TokenRequest {
   @Key("refresh_token")
   private String refreshToken;

   public RefreshTokenRequest(HttpTransport transport, JsonFactory jsonFactory, GenericUrl tokenServerUrl, String refreshToken) {
      super(transport, jsonFactory, tokenServerUrl, "refresh_token");
      this.setRefreshToken(refreshToken);
   }

   public RefreshTokenRequest setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (RefreshTokenRequest)super.setRequestInitializer(requestInitializer);
   }

   public RefreshTokenRequest setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (RefreshTokenRequest)super.setTokenServerUrl(tokenServerUrl);
   }

   public RefreshTokenRequest setScopes(Collection<String> scopes) {
      return (RefreshTokenRequest)super.setScopes(scopes);
   }

   public RefreshTokenRequest setGrantType(String grantType) {
      return (RefreshTokenRequest)super.setGrantType(grantType);
   }

   public RefreshTokenRequest setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      return (RefreshTokenRequest)super.setClientAuthentication(clientAuthentication);
   }

   public final String getRefreshToken() {
      return this.refreshToken;
   }

   public RefreshTokenRequest setRefreshToken(String refreshToken) {
      this.refreshToken = (String)Preconditions.checkNotNull(refreshToken);
      return this;
   }

   public RefreshTokenRequest set(String fieldName, Object value) {
      return (RefreshTokenRequest)super.set(fieldName, value);
   }
}
