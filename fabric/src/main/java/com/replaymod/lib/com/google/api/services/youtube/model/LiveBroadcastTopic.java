package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveBroadcastTopic extends GenericJson {
   @Key
   private LiveBroadcastTopicSnippet snippet;
   @Key
   private String type;
   @Key
   private Boolean unmatched;

   public LiveBroadcastTopicSnippet getSnippet() {
      return this.snippet;
   }

   public LiveBroadcastTopic setSnippet(LiveBroadcastTopicSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public LiveBroadcastTopic setType(String var1) {
      this.type = var1;
      return this;
   }

   public Boolean getUnmatched() {
      return this.unmatched;
   }

   public LiveBroadcastTopic setUnmatched(Boolean var1) {
      this.unmatched = var1;
      return this;
   }

   public LiveBroadcastTopic set(String var1, Object var2) {
      return (LiveBroadcastTopic)super.set(var1, var2);
   }

   public LiveBroadcastTopic clone() {
      return (LiveBroadcastTopic)super.clone();
   }
}
