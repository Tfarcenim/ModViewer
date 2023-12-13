package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveChatModeratorSnippet extends GenericJson {
   @Key
   private String liveChatId;
   @Key
   private ChannelProfileDetails moderatorDetails;

   public String getLiveChatId() {
      return this.liveChatId;
   }

   public LiveChatModeratorSnippet setLiveChatId(String var1) {
      this.liveChatId = var1;
      return this;
   }

   public ChannelProfileDetails getModeratorDetails() {
      return this.moderatorDetails;
   }

   public LiveChatModeratorSnippet setModeratorDetails(ChannelProfileDetails var1) {
      this.moderatorDetails = var1;
      return this;
   }

   public LiveChatModeratorSnippet set(String var1, Object var2) {
      return (LiveChatModeratorSnippet)super.set(var1, var2);
   }

   public LiveChatModeratorSnippet clone() {
      return (LiveChatModeratorSnippet)super.clone();
   }
}
