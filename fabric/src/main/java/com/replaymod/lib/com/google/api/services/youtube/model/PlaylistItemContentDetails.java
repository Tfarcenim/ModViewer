package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class PlaylistItemContentDetails extends GenericJson {
   @Key
   private String endAt;
   @Key
   private String note;
   @Key
   private String startAt;
   @Key
   private String videoId;

   public String getEndAt() {
      return this.endAt;
   }

   public PlaylistItemContentDetails setEndAt(String var1) {
      this.endAt = var1;
      return this;
   }

   public String getNote() {
      return this.note;
   }

   public PlaylistItemContentDetails setNote(String var1) {
      this.note = var1;
      return this;
   }

   public String getStartAt() {
      return this.startAt;
   }

   public PlaylistItemContentDetails setStartAt(String var1) {
      this.startAt = var1;
      return this;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public PlaylistItemContentDetails setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }

   public PlaylistItemContentDetails set(String var1, Object var2) {
      return (PlaylistItemContentDetails)super.set(var1, var2);
   }

   public PlaylistItemContentDetails clone() {
      return (PlaylistItemContentDetails)super.clone();
   }
}
