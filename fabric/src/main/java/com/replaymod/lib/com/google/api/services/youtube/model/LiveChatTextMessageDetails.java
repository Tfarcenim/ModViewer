package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveChatTextMessageDetails extends GenericJson {
   @Key
   private String messageText;

   public String getMessageText() {
      return this.messageText;
   }

   public LiveChatTextMessageDetails setMessageText(String var1) {
      this.messageText = var1;
      return this;
   }

   public LiveChatTextMessageDetails set(String var1, Object var2) {
      return (LiveChatTextMessageDetails)super.set(var1, var2);
   }

   public LiveChatTextMessageDetails clone() {
      return (LiveChatTextMessageDetails)super.clone();
   }
}
