package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class PlaylistSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String channelTitle;
   @Key
   private String defaultLanguage;
   @Key
   private String description;
   @Key
   private PlaylistLocalization localized;
   @Key
   private DateTime publishedAt;
   @Key
   private List<String> tags;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;

   public String getChannelId() {
      return this.channelId;
   }

   public PlaylistSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getChannelTitle() {
      return this.channelTitle;
   }

   public PlaylistSnippet setChannelTitle(String var1) {
      this.channelTitle = var1;
      return this;
   }

   public String getDefaultLanguage() {
      return this.defaultLanguage;
   }

   public PlaylistSnippet setDefaultLanguage(String var1) {
      this.defaultLanguage = var1;
      return this;
   }

   public String getDescription() {
      return this.description;
   }

   public PlaylistSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public PlaylistLocalization getLocalized() {
      return this.localized;
   }

   public PlaylistSnippet setLocalized(PlaylistLocalization var1) {
      this.localized = var1;
      return this;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public PlaylistSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public List<String> getTags() {
      return this.tags;
   }

   public PlaylistSnippet setTags(List<String> var1) {
      this.tags = var1;
      return this;
   }

   public ThumbnailDetails getThumbnails() {
      return this.thumbnails;
   }

   public PlaylistSnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public PlaylistSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public PlaylistSnippet set(String var1, Object var2) {
      return (PlaylistSnippet)super.set(var1, var2);
   }

   public PlaylistSnippet clone() {
      return (PlaylistSnippet)super.clone();
   }
}
