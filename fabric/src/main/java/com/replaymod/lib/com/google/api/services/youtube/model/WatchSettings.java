package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class WatchSettings extends GenericJson {
   @Key
   private String backgroundColor;
   @Key
   private String featuredPlaylistId;
   @Key
   private String textColor;

   public String getBackgroundColor() {
      return this.backgroundColor;
   }

   public WatchSettings setBackgroundColor(String var1) {
      this.backgroundColor = var1;
      return this;
   }

   public String getFeaturedPlaylistId() {
      return this.featuredPlaylistId;
   }

   public WatchSettings setFeaturedPlaylistId(String var1) {
      this.featuredPlaylistId = var1;
      return this;
   }

   public String getTextColor() {
      return this.textColor;
   }

   public WatchSettings setTextColor(String var1) {
      this.textColor = var1;
      return this;
   }

   public WatchSettings set(String var1, Object var2) {
      return (WatchSettings)super.set(var1, var2);
   }

   public WatchSettings clone() {
      return (WatchSettings)super.clone();
   }
}
