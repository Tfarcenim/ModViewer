package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class LiveChatUserBannedMessageDetails extends GenericJson {
   @Key
   @JsonString
   private BigInteger banDurationSeconds;
   @Key
   private String banType;
   @Key
   private ChannelProfileDetails bannedUserDetails;

   public BigInteger getBanDurationSeconds() {
      return this.banDurationSeconds;
   }

   public LiveChatUserBannedMessageDetails setBanDurationSeconds(BigInteger var1) {
      this.banDurationSeconds = var1;
      return this;
   }

   public String getBanType() {
      return this.banType;
   }

   public LiveChatUserBannedMessageDetails setBanType(String var1) {
      this.banType = var1;
      return this;
   }

   public ChannelProfileDetails getBannedUserDetails() {
      return this.bannedUserDetails;
   }

   public LiveChatUserBannedMessageDetails setBannedUserDetails(ChannelProfileDetails var1) {
      this.bannedUserDetails = var1;
      return this;
   }

   public LiveChatUserBannedMessageDetails set(String var1, Object var2) {
      return (LiveChatUserBannedMessageDetails)super.set(var1, var2);
   }

   public LiveChatUserBannedMessageDetails clone() {
      return (LiveChatUserBannedMessageDetails)super.clone();
   }
}
