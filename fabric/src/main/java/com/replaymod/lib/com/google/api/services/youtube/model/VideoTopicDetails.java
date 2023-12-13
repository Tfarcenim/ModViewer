package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class VideoTopicDetails extends GenericJson {
   @Key
   private List<String> relevantTopicIds;
   @Key
   private List<String> topicIds;

   public List<String> getRelevantTopicIds() {
      return this.relevantTopicIds;
   }

   public VideoTopicDetails setRelevantTopicIds(List<String> var1) {
      this.relevantTopicIds = var1;
      return this;
   }

   public List<String> getTopicIds() {
      return this.topicIds;
   }

   public VideoTopicDetails setTopicIds(List<String> var1) {
      this.topicIds = var1;
      return this;
   }

   public VideoTopicDetails set(String var1, Object var2) {
      return (VideoTopicDetails)super.set(var1, var2);
   }

   public VideoTopicDetails clone() {
      return (VideoTopicDetails)super.clone();
   }
}
