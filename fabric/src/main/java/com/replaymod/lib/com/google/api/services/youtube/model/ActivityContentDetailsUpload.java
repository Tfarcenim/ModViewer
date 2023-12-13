package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetailsUpload extends GenericJson {
   @Key
   private String videoId;

   public String getVideoId() {
      return this.videoId;
   }

   public ActivityContentDetailsUpload setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }

   public ActivityContentDetailsUpload set(String var1, Object var2) {
      return (ActivityContentDetailsUpload)super.set(var1, var2);
   }

   public ActivityContentDetailsUpload clone() {
      return (ActivityContentDetailsUpload)super.clone();
   }
}
