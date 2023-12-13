package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveChatMessageDeletedDetails extends GenericJson {
   @Key
   private String deletedMessageId;

   public String getDeletedMessageId() {
      return this.deletedMessageId;
   }

   public LiveChatMessageDeletedDetails setDeletedMessageId(String var1) {
      this.deletedMessageId = var1;
      return this;
   }

   public LiveChatMessageDeletedDetails set(String var1, Object var2) {
      return (LiveChatMessageDeletedDetails)super.set(var1, var2);
   }

   public LiveChatMessageDeletedDetails clone() {
      return (LiveChatMessageDeletedDetails)super.clone();
   }
}
