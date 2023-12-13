package com.replaymod.lib.com.google.api.client.auth.oauth2;

import com.replaymod.lib.com.google.api.client.http.GenericUrl;
import com.replaymod.lib.com.google.api.client.util.Joiner;
import com.replaymod.lib.com.google.api.client.util.Key;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.util.Collection;

public class AuthorizationRequestUrl extends GenericUrl {
   @Key("response_type")
   private String responseTypes;
   @Key("redirect_uri")
   private String redirectUri;
   @Key("scope")
   private String scopes;
   @Key("client_id")
   private String clientId;
   @Key
   private String state;

   public AuthorizationRequestUrl(String authorizationServerEncodedUrl, String clientId, Collection<String> responseTypes) {
      super(authorizationServerEncodedUrl);
      Preconditions.checkArgument(this.getFragment() == null);
      this.setClientId(clientId);
      this.setResponseTypes(responseTypes);
   }

   public final String getResponseTypes() {
      return this.responseTypes;
   }

   public AuthorizationRequestUrl setResponseTypes(Collection<String> responseTypes) {
      this.responseTypes = Joiner.on(' ').join(responseTypes);
      return this;
   }

   public final String getRedirectUri() {
      return this.redirectUri;
   }

   public AuthorizationRequestUrl setRedirectUri(String redirectUri) {
      this.redirectUri = redirectUri;
      return this;
   }

   public final String getScopes() {
      return this.scopes;
   }

   public AuthorizationRequestUrl setScopes(Collection<String> scopes) {
      this.scopes = scopes != null && scopes.iterator().hasNext() ? Joiner.on(' ').join(scopes) : null;
      return this;
   }

   public final String getClientId() {
      return this.clientId;
   }

   public AuthorizationRequestUrl setClientId(String clientId) {
      this.clientId = (String)Preconditions.checkNotNull(clientId);
      return this;
   }

   public final String getState() {
      return this.state;
   }

   public AuthorizationRequestUrl setState(String state) {
      this.state = state;
      return this;
   }

   public AuthorizationRequestUrl set(String fieldName, Object value) {
      return (AuthorizationRequestUrl)super.set(fieldName, value);
   }

   public AuthorizationRequestUrl clone() {
      return (AuthorizationRequestUrl)super.clone();
   }
}
