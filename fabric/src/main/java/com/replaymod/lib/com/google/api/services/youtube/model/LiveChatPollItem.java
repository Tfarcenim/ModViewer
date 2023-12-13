package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveChatPollItem extends GenericJson {
   @Key
   private String description;
   @Key
   private String itemId;

   public String getDescription() {
      return this.description;
   }

   public LiveChatPollItem setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public String getItemId() {
      return this.itemId;
   }

   public LiveChatPollItem setItemId(String var1) {
      this.itemId = var1;
      return this;
   }

   public LiveChatPollItem set(String var1, Object var2) {
      return (LiveChatPollItem)super.set(var1, var2);
   }

   public LiveChatPollItem clone() {
      return (LiveChatPollItem)super.clone();
   }
}
