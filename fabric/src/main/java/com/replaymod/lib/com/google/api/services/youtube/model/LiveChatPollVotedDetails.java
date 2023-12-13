package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveChatPollVotedDetails extends GenericJson {
   @Key
   private String itemId;
   @Key
   private String pollId;

   public String getItemId() {
      return this.itemId;
   }

   public LiveChatPollVotedDetails setItemId(String var1) {
      this.itemId = var1;
      return this;
   }

   public String getPollId() {
      return this.pollId;
   }

   public LiveChatPollVotedDetails setPollId(String var1) {
      this.pollId = var1;
      return this;
   }

   public LiveChatPollVotedDetails set(String var1, Object var2) {
      return (LiveChatPollVotedDetails)super.set(var1, var2);
   }

   public LiveChatPollVotedDetails clone() {
      return (LiveChatPollVotedDetails)super.clone();
   }
}
