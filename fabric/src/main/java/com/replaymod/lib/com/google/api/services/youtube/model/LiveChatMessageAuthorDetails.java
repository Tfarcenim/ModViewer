package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveChatMessageAuthorDetails extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String channelUrl;
   @Key
   private String displayName;
   @Key
   private Boolean isChatModerator;
   @Key
   private Boolean isChatOwner;
   @Key
   private Boolean isChatSponsor;
   @Key
   private Boolean isVerified;
   @Key
   private String profileImageUrl;

   public String getChannelId() {
      return this.channelId;
   }

   public LiveChatMessageAuthorDetails setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getChannelUrl() {
      return this.channelUrl;
   }

   public LiveChatMessageAuthorDetails setChannelUrl(String var1) {
      this.channelUrl = var1;
      return this;
   }

   public String getDisplayName() {
      return this.displayName;
   }

   public LiveChatMessageAuthorDetails setDisplayName(String var1) {
      this.displayName = var1;
      return this;
   }

   public Boolean getIsChatModerator() {
      return this.isChatModerator;
   }

   public LiveChatMessageAuthorDetails setIsChatModerator(Boolean var1) {
      this.isChatModerator = var1;
      return this;
   }

   public Boolean getIsChatOwner() {
      return this.isChatOwner;
   }

   public LiveChatMessageAuthorDetails setIsChatOwner(Boolean var1) {
      this.isChatOwner = var1;
      return this;
   }

   public Boolean getIsChatSponsor() {
      return this.isChatSponsor;
   }

   public LiveChatMessageAuthorDetails setIsChatSponsor(Boolean var1) {
      this.isChatSponsor = var1;
      return this;
   }

   public Boolean getIsVerified() {
      return this.isVerified;
   }

   public LiveChatMessageAuthorDetails setIsVerified(Boolean var1) {
      this.isVerified = var1;
      return this;
   }

   public String getProfileImageUrl() {
      return this.profileImageUrl;
   }

   public LiveChatMessageAuthorDetails setProfileImageUrl(String var1) {
      this.profileImageUrl = var1;
      return this;
   }

   public LiveChatMessageAuthorDetails set(String var1, Object var2) {
      return (LiveChatMessageAuthorDetails)super.set(var1, var2);
   }

   public LiveChatMessageAuthorDetails clone() {
      return (LiveChatMessageAuthorDetails)super.clone();
   }
}
