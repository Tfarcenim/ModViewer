package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveChatPollClosedDetails extends GenericJson {
   @Key
   private String pollId;

   public String getPollId() {
      return this.pollId;
   }

   public LiveChatPollClosedDetails setPollId(String var1) {
      this.pollId = var1;
      return this;
   }

   public LiveChatPollClosedDetails set(String var1, Object var2) {
      return (LiveChatPollClosedDetails)super.set(var1, var2);
   }

   public LiveChatPollClosedDetails clone() {
      return (LiveChatPollClosedDetails)super.clone();
   }
}
