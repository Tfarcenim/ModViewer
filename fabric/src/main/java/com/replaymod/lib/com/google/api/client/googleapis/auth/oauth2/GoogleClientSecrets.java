package com.replaymod.lib.com.google.api.client.googleapis.auth.oauth2;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.util.Key;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public final class GoogleClientSecrets extends GenericJson {
   @Key
   private GoogleClientSecrets.Details installed;
   @Key
   private GoogleClientSecrets.Details web;

   public GoogleClientSecrets.Details getInstalled() {
      return this.installed;
   }

   public GoogleClientSecrets setInstalled(GoogleClientSecrets.Details installed) {
      this.installed = installed;
      return this;
   }

   public GoogleClientSecrets.Details getWeb() {
      return this.web;
   }

   public GoogleClientSecrets setWeb(GoogleClientSecrets.Details web) {
      this.web = web;
      return this;
   }

   public GoogleClientSecrets.Details getDetails() {
      Preconditions.checkArgument(this.web == null != (this.installed == null));
      return this.web == null ? this.installed : this.web;
   }

   public GoogleClientSecrets set(String fieldName, Object value) {
      return (GoogleClientSecrets)super.set(fieldName, value);
   }

   public GoogleClientSecrets clone() {
      return (GoogleClientSecrets)super.clone();
   }

   public static GoogleClientSecrets load(JsonFactory jsonFactory, Reader reader) throws IOException {
      return (GoogleClientSecrets)jsonFactory.fromReader(reader, GoogleClientSecrets.class);
   }

   public static final class Details extends GenericJson {
      @Key("client_id")
      private String clientId;
      @Key("client_secret")
      private String clientSecret;
      @Key("redirect_uris")
      private List<String> redirectUris;
      @Key("auth_uri")
      private String authUri;
      @Key("token_uri")
      private String tokenUri;

      public String getClientId() {
         return this.clientId;
      }

      public GoogleClientSecrets.Details setClientId(String clientId) {
         this.clientId = clientId;
         return this;
      }

      public String getClientSecret() {
         return this.clientSecret;
      }

      public GoogleClientSecrets.Details setClientSecret(String clientSecret) {
         this.clientSecret = clientSecret;
         return this;
      }

      public List<String> getRedirectUris() {
         return this.redirectUris;
      }

      public GoogleClientSecrets.Details setRedirectUris(List<String> redirectUris) {
         this.redirectUris = redirectUris;
         return this;
      }

      public String getAuthUri() {
         return this.authUri;
      }

      public GoogleClientSecrets.Details setAuthUri(String authUri) {
         this.authUri = authUri;
         return this;
      }

      public String getTokenUri() {
         return this.tokenUri;
      }

      public GoogleClientSecrets.Details setTokenUri(String tokenUri) {
         this.tokenUri = tokenUri;
         return this;
      }

      public GoogleClientSecrets.Details set(String fieldName, Object value) {
         return (GoogleClientSecrets.Details)super.set(fieldName, value);
      }

      public GoogleClientSecrets.Details clone() {
         return (GoogleClientSecrets.Details)super.clone();
      }
   }
}
