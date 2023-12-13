package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class VideoProjectDetails extends GenericJson {
   @Key
   private List<String> tags;

   public List<String> getTags() {
      return this.tags;
   }

   public VideoProjectDetails setTags(List<String> var1) {
      this.tags = var1;
      return this;
   }

   public VideoProjectDetails set(String var1, Object var2) {
      return (VideoProjectDetails)super.set(var1, var2);
   }

   public VideoProjectDetails clone() {
      return (VideoProjectDetails)super.clone();
   }
}
