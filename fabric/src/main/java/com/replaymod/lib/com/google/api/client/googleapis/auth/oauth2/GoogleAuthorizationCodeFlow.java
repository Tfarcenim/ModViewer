package com.replaymod.lib.com.google.api.client.googleapis.auth.oauth2;

import com.replaymod.lib.com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.replaymod.lib.com.google.api.client.auth.oauth2.BearerToken;
import com.replaymod.lib.com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.replaymod.lib.com.google.api.client.auth.oauth2.Credential;
import com.replaymod.lib.com.google.api.client.auth.oauth2.CredentialRefreshListener;
import com.replaymod.lib.com.google.api.client.auth.oauth2.CredentialStore;
import com.replaymod.lib.com.google.api.client.auth.oauth2.StoredCredential;
import com.replaymod.lib.com.google.api.client.http.GenericUrl;
import com.replaymod.lib.com.google.api.client.http.HttpExecuteInterceptor;
import com.replaymod.lib.com.google.api.client.http.HttpRequestInitializer;
import com.replaymod.lib.com.google.api.client.http.HttpTransport;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.util.Beta;
import com.replaymod.lib.com.google.api.client.util.Clock;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import com.replaymod.lib.com.google.api.client.util.store.DataStore;
import com.replaymod.lib.com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.util.Collection;

public class GoogleAuthorizationCodeFlow extends AuthorizationCodeFlow {
   private final String approvalPrompt;
   private final String accessType;

   public GoogleAuthorizationCodeFlow(HttpTransport transport, JsonFactory jsonFactory, String clientId, String clientSecret, Collection<String> scopes) {
      this(new GoogleAuthorizationCodeFlow.Builder(transport, jsonFactory, clientId, clientSecret, scopes));
   }

   protected GoogleAuthorizationCodeFlow(GoogleAuthorizationCodeFlow.Builder builder) {
      super(builder);
      this.accessType = builder.accessType;
      this.approvalPrompt = builder.approvalPrompt;
   }

   public GoogleAuthorizationCodeTokenRequest newTokenRequest(String authorizationCode) {
      return (new GoogleAuthorizationCodeTokenRequest(this.getTransport(), this.getJsonFactory(), this.getTokenServerEncodedUrl(), "", "", authorizationCode, "")).setClientAuthentication(this.getClientAuthentication()).setRequestInitializer(this.getRequestInitializer()).setScopes(this.getScopes());
   }

   public GoogleAuthorizationCodeRequestUrl newAuthorizationUrl() {
      return (new GoogleAuthorizationCodeRequestUrl(this.getAuthorizationServerEncodedUrl(), this.getClientId(), "", this.getScopes())).setAccessType(this.accessType).setApprovalPrompt(this.approvalPrompt);
   }

   public final String getApprovalPrompt() {
      return this.approvalPrompt;
   }

   public final String getAccessType() {
      return this.accessType;
   }

   public static class Builder extends AuthorizationCodeFlow.Builder {
      String approvalPrompt;
      String accessType;

      public Builder(HttpTransport transport, JsonFactory jsonFactory, String clientId, String clientSecret, Collection<String> scopes) {
         super(BearerToken.authorizationHeaderAccessMethod(), transport, jsonFactory, new GenericUrl("https://accounts.google.com/o/oauth2/token"), new ClientParametersAuthentication(clientId, clientSecret), clientId, "https://accounts.google.com/o/oauth2/auth");
         this.setScopes(scopes);
      }

      public Builder(HttpTransport transport, JsonFactory jsonFactory, GoogleClientSecrets clientSecrets, Collection<String> scopes) {
         super(BearerToken.authorizationHeaderAccessMethod(), transport, jsonFactory, new GenericUrl("https://accounts.google.com/o/oauth2/token"), new ClientParametersAuthentication(clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret()), clientSecrets.getDetails().getClientId(), "https://accounts.google.com/o/oauth2/auth");
         this.setScopes(scopes);
      }

      public GoogleAuthorizationCodeFlow build() {
         return new GoogleAuthorizationCodeFlow(this);
      }

      public GoogleAuthorizationCodeFlow.Builder setDataStoreFactory(DataStoreFactory dataStore) throws IOException {
         return (GoogleAuthorizationCodeFlow.Builder)super.setDataStoreFactory(dataStore);
      }

      public GoogleAuthorizationCodeFlow.Builder setCredentialDataStore(DataStore<StoredCredential> typedDataStore) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setCredentialDataStore(typedDataStore);
      }

      public GoogleAuthorizationCodeFlow.Builder setCredentialCreatedListener(AuthorizationCodeFlow.CredentialCreatedListener credentialCreatedListener) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setCredentialCreatedListener(credentialCreatedListener);
      }

      /** @deprecated */
      @Deprecated
      @Beta
      public GoogleAuthorizationCodeFlow.Builder setCredentialStore(CredentialStore credentialStore) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setCredentialStore(credentialStore);
      }

      public GoogleAuthorizationCodeFlow.Builder setRequestInitializer(HttpRequestInitializer requestInitializer) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setRequestInitializer(requestInitializer);
      }

      public GoogleAuthorizationCodeFlow.Builder setScopes(Collection<String> scopes) {
         Preconditions.checkState(!scopes.isEmpty());
         return (GoogleAuthorizationCodeFlow.Builder)super.setScopes(scopes);
      }

      public GoogleAuthorizationCodeFlow.Builder setMethod(Credential.AccessMethod method) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setMethod(method);
      }

      public GoogleAuthorizationCodeFlow.Builder setTransport(HttpTransport transport) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setTransport(transport);
      }

      public GoogleAuthorizationCodeFlow.Builder setJsonFactory(JsonFactory jsonFactory) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setJsonFactory(jsonFactory);
      }

      public GoogleAuthorizationCodeFlow.Builder setTokenServerUrl(GenericUrl tokenServerUrl) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setTokenServerUrl(tokenServerUrl);
      }

      public GoogleAuthorizationCodeFlow.Builder setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setClientAuthentication(clientAuthentication);
      }

      public GoogleAuthorizationCodeFlow.Builder setClientId(String clientId) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setClientId(clientId);
      }

      public GoogleAuthorizationCodeFlow.Builder setAuthorizationServerEncodedUrl(String authorizationServerEncodedUrl) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setAuthorizationServerEncodedUrl(authorizationServerEncodedUrl);
      }

      public GoogleAuthorizationCodeFlow.Builder setClock(Clock clock) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setClock(clock);
      }

      public GoogleAuthorizationCodeFlow.Builder addRefreshListener(CredentialRefreshListener refreshListener) {
         return (GoogleAuthorizationCodeFlow.Builder)super.addRefreshListener(refreshListener);
      }

      public GoogleAuthorizationCodeFlow.Builder setRefreshListeners(Collection<CredentialRefreshListener> refreshListeners) {
         return (GoogleAuthorizationCodeFlow.Builder)super.setRefreshListeners(refreshListeners);
      }

      public GoogleAuthorizationCodeFlow.Builder setApprovalPrompt(String approvalPrompt) {
         this.approvalPrompt = approvalPrompt;
         return this;
      }

      public final String getApprovalPrompt() {
         return this.approvalPrompt;
      }

      public GoogleAuthorizationCodeFlow.Builder setAccessType(String accessType) {
         this.accessType = accessType;
         return this;
      }

      public final String getAccessType() {
         return this.accessType;
      }
   }
}
