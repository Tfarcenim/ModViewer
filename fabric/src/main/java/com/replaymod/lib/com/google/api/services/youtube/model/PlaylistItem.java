package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class PlaylistItem extends GenericJson {
   @Key
   private PlaylistItemContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private PlaylistItemSnippet snippet;
   @Key
   private PlaylistItemStatus status;

   public PlaylistItemContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public PlaylistItem setContentDetails(PlaylistItemContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public String getEtag() {
      return this.etag;
   }

   public PlaylistItem setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public PlaylistItem setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public PlaylistItem setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public PlaylistItemSnippet getSnippet() {
      return this.snippet;
   }

   public PlaylistItem setSnippet(PlaylistItemSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public PlaylistItemStatus getStatus() {
      return this.status;
   }

   public PlaylistItem setStatus(PlaylistItemStatus var1) {
      this.status = var1;
      return this;
   }

   public PlaylistItem set(String var1, Object var2) {
      return (PlaylistItem)super.set(var1, var2);
   }

   public PlaylistItem clone() {
      return (PlaylistItem)super.clone();
   }
}
