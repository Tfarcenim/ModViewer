package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class PlaylistPlayer extends GenericJson {
   @Key
   private String embedHtml;

   public String getEmbedHtml() {
      return this.embedHtml;
   }

   public PlaylistPlayer setEmbedHtml(String var1) {
      this.embedHtml = var1;
      return this;
   }

   public PlaylistPlayer set(String var1, Object var2) {
      return (PlaylistPlayer)super.set(var1, var2);
   }

   public PlaylistPlayer clone() {
      return (PlaylistPlayer)super.clone();
   }
}
