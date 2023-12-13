package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class SearchResultSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String channelTitle;
   @Key
   private String description;
   @Key
   private String liveBroadcastContent;
   @Key
   private DateTime publishedAt;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;

   public String getChannelId() {
      return this.channelId;
   }

   public SearchResultSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getChannelTitle() {
      return this.channelTitle;
   }

   public SearchResultSnippet setChannelTitle(String var1) {
      this.channelTitle = var1;
      return this;
   }

   public String getDescription() {
      return this.description;
   }

   public SearchResultSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public String getLiveBroadcastContent() {
      return this.liveBroadcastContent;
   }

   public SearchResultSnippet setLiveBroadcastContent(String var1) {
      this.liveBroadcastContent = var1;
      return this;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public SearchResultSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public ThumbnailDetails getThumbnails() {
      return this.thumbnails;
   }

   public SearchResultSnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public SearchResultSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public SearchResultSnippet set(String var1, Object var2) {
      return (SearchResultSnippet)super.set(var1, var2);
   }

   public SearchResultSnippet clone() {
      return (SearchResultSnippet)super.clone();
   }
}
