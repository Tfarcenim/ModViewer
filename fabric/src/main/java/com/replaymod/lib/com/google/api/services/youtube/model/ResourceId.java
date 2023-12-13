package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ResourceId extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String kind;
   @Key
   private String playlistId;
   @Key
   private String videoId;

   public String getChannelId() {
      return this.channelId;
   }

   public ResourceId setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public ResourceId setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getPlaylistId() {
      return this.playlistId;
   }

   public ResourceId setPlaylistId(String var1) {
      this.playlistId = var1;
      return this;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public ResourceId setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }

   public ResourceId set(String var1, Object var2) {
      return (ResourceId)super.set(var1, var2);
   }

   public ResourceId clone() {
      return (ResourceId)super.clone();
   }
}
