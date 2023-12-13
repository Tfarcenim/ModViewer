package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ChannelSnippet extends GenericJson {
   @Key
   private String country;
   @Key
   private String customUrl;
   @Key
   private String defaultLanguage;
   @Key
   private String description;
   @Key
   private ChannelLocalization localized;
   @Key
   private DateTime publishedAt;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;

   public String getCountry() {
      return this.country;
   }

   public ChannelSnippet setCountry(String var1) {
      this.country = var1;
      return this;
   }

   public String getCustomUrl() {
      return this.customUrl;
   }

   public ChannelSnippet setCustomUrl(String var1) {
      this.customUrl = var1;
      return this;
   }

   public String getDefaultLanguage() {
      return this.defaultLanguage;
   }

   public ChannelSnippet setDefaultLanguage(String var1) {
      this.defaultLanguage = var1;
      return this;
   }

   public String getDescription() {
      return this.description;
   }

   public ChannelSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public ChannelLocalization getLocalized() {
      return this.localized;
   }

   public ChannelSnippet setLocalized(ChannelLocalization var1) {
      this.localized = var1;
      return this;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public ChannelSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public ThumbnailDetails getThumbnails() {
      return this.thumbnails;
   }

   public ChannelSnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public ChannelSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public ChannelSnippet set(String var1, Object var2) {
      return (ChannelSnippet)super.set(var1, var2);
   }

   public ChannelSnippet clone() {
      return (ChannelSnippet)super.clone();
   }
}
