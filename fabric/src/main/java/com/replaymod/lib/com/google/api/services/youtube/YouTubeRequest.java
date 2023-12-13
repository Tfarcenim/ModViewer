package com.replaymod.lib.com.google.api.services.youtube;

import com.replaymod.lib.com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.replaymod.lib.com.google.api.client.http.HttpHeaders;
import com.replaymod.lib.com.google.api.client.util.Key;

public abstract class YouTubeRequest<T> extends AbstractGoogleJsonClientRequest<T> {
   @Key
   private String alt;
   @Key
   private String fields;
   @Key
   private String key;
   @Key("oauth_token")
   private String oauthToken;
   @Key
   private Boolean prettyPrint;
   @Key
   private String quotaUser;
   @Key
   private String userIp;

   public YouTubeRequest(YouTube var1, String var2, String var3, Object var4, Class<T> var5) {
      super(var1, var2, var3, var4, var5);
   }

   public String getAlt() {
      return this.alt;
   }

   public YouTubeRequest<T> setAlt(String var1) {
      this.alt = var1;
      return this;
   }

   public String getFields() {
      return this.fields;
   }

   public YouTubeRequest<T> setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public String getKey() {
      return this.key;
   }

   public YouTubeRequest<T> setKey(String var1) {
      this.key = var1;
      return this;
   }

   public String getOauthToken() {
      return this.oauthToken;
   }

   public YouTubeRequest<T> setOauthToken(String var1) {
      this.oauthToken = var1;
      return this;
   }

   public Boolean getPrettyPrint() {
      return this.prettyPrint;
   }

   public YouTubeRequest<T> setPrettyPrint(Boolean var1) {
      this.prettyPrint = var1;
      return this;
   }

   public String getQuotaUser() {
      return this.quotaUser;
   }

   public YouTubeRequest<T> setQuotaUser(String var1) {
      this.quotaUser = var1;
      return this;
   }

   public String getUserIp() {
      return this.userIp;
   }

   public YouTubeRequest<T> setUserIp(String var1) {
      this.userIp = var1;
      return this;
   }

   public final YouTube getAbstractGoogleClient() {
      return (YouTube)super.getAbstractGoogleClient();
   }

   public YouTubeRequest<T> setDisableGZipContent(boolean var1) {
      return (YouTubeRequest)super.setDisableGZipContent(var1);
   }

   public YouTubeRequest<T> setRequestHeaders(HttpHeaders var1) {
      return (YouTubeRequest)super.setRequestHeaders(var1);
   }

   public YouTubeRequest<T> set(String var1, Object var2) {
      return (YouTubeRequest)super.set(var1, var2);
   }
}
