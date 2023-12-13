package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class PlaylistItemSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String channelTitle;
   @Key
   private String description;
   @Key
   private String playlistId;
   @Key
   private Long position;
   @Key
   private DateTime publishedAt;
   @Key
   private ResourceId resourceId;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;

   public String getChannelId() {
      return this.channelId;
   }

   public PlaylistItemSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getChannelTitle() {
      return this.channelTitle;
   }

   public PlaylistItemSnippet setChannelTitle(String var1) {
      this.channelTitle = var1;
      return this;
   }

   public String getDescription() {
      return this.description;
   }

   public PlaylistItemSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public String getPlaylistId() {
      return this.playlistId;
   }

   public PlaylistItemSnippet setPlaylistId(String var1) {
      this.playlistId = var1;
      return this;
   }

   public Long getPosition() {
      return this.position;
   }

   public PlaylistItemSnippet setPosition(Long var1) {
      this.position = var1;
      return this;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public PlaylistItemSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public PlaylistItemSnippet setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ThumbnailDetails getThumbnails() {
      return this.thumbnails;
   }

   public PlaylistItemSnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public PlaylistItemSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public PlaylistItemSnippet set(String var1, Object var2) {
      return (PlaylistItemSnippet)super.set(var1, var2);
   }

   public PlaylistItemSnippet clone() {
      return (PlaylistItemSnippet)super.clone();
   }
}
