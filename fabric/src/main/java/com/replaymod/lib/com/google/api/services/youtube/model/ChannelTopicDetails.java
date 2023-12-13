package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ChannelTopicDetails extends GenericJson {
   @Key
   private List<String> topicIds;

   public List<String> getTopicIds() {
      return this.topicIds;
   }

   public ChannelTopicDetails setTopicIds(List<String> var1) {
      this.topicIds = var1;
      return this;
   }

   public ChannelTopicDetails set(String var1, Object var2) {
      return (ChannelTopicDetails)super.set(var1, var2);
   }

   public ChannelTopicDetails clone() {
      return (ChannelTopicDetails)super.clone();
   }
}
