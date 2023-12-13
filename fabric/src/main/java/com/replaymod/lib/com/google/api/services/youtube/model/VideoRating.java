package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class VideoRating extends GenericJson {
   @Key
   private String rating;
   @Key
   private String videoId;

   public String getRating() {
      return this.rating;
   }

   public VideoRating setRating(String var1) {
      this.rating = var1;
      return this;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public VideoRating setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }

   public VideoRating set(String var1, Object var2) {
      return (VideoRating)super.set(var1, var2);
   }

   public VideoRating clone() {
      return (VideoRating)super.clone();
   }
}
