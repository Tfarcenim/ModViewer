package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetailsPlaylistItem extends GenericJson {
   @Key
   private String playlistId;
   @Key
   private String playlistItemId;
   @Key
   private ResourceId resourceId;

   public String getPlaylistId() {
      return this.playlistId;
   }

   public ActivityContentDetailsPlaylistItem setPlaylistId(String var1) {
      this.playlistId = var1;
      return this;
   }

   public String getPlaylistItemId() {
      return this.playlistItemId;
   }

   public ActivityContentDetailsPlaylistItem setPlaylistItemId(String var1) {
      this.playlistItemId = var1;
      return this;
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsPlaylistItem setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ActivityContentDetailsPlaylistItem set(String var1, Object var2) {
      return (ActivityContentDetailsPlaylistItem)super.set(var1, var2);
   }

   public ActivityContentDetailsPlaylistItem clone() {
      return (ActivityContentDetailsPlaylistItem)super.clone();
   }
}
