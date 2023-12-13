package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class LiveChatBanSnippet extends GenericJson {
   @Key
   @JsonString
   private BigInteger banDurationSeconds;
   @Key
   private ChannelProfileDetails bannedUserDetails;
   @Key
   private String liveChatId;
   @Key
   private String type;

   public BigInteger getBanDurationSeconds() {
      return this.banDurationSeconds;
   }

   public LiveChatBanSnippet setBanDurationSeconds(BigInteger var1) {
      this.banDurationSeconds = var1;
      return this;
   }

   public ChannelProfileDetails getBannedUserDetails() {
      return this.bannedUserDetails;
   }

   public LiveChatBanSnippet setBannedUserDetails(ChannelProfileDetails var1) {
      this.bannedUserDetails = var1;
      return this;
   }

   public String getLiveChatId() {
      return this.liveChatId;
   }

   public LiveChatBanSnippet setLiveChatId(String var1) {
      this.liveChatId = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public LiveChatBanSnippet setType(String var1) {
      this.type = var1;
      return this;
   }

   public LiveChatBanSnippet set(String var1, Object var2) {
      return (LiveChatBanSnippet)super.set(var1, var2);
   }

   public LiveChatBanSnippet clone() {
      return (LiveChatBanSnippet)super.clone();
   }
}
