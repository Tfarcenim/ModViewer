package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class LiveBroadcastTopicDetails extends GenericJson {
   @Key
   private List<LiveBroadcastTopic> topics;

   public List<LiveBroadcastTopic> getTopics() {
      return this.topics;
   }

   public LiveBroadcastTopicDetails setTopics(List<LiveBroadcastTopic> var1) {
      this.topics = var1;
      return this;
   }

   public LiveBroadcastTopicDetails set(String var1, Object var2) {
      return (LiveBroadcastTopicDetails)super.set(var1, var2);
   }

   public LiveBroadcastTopicDetails clone() {
      return (LiveBroadcastTopicDetails)super.clone();
   }

   static {
      Data.nullOf(LiveBroadcastTopic.class);
   }
}
