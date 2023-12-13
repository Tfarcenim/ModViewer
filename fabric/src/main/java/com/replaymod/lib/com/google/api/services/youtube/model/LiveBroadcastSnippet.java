package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveBroadcastSnippet extends GenericJson {
   @Key
   private DateTime actualEndTime;
   @Key
   private DateTime actualStartTime;
   @Key
   private String channelId;
   @Key
   private String description;
   @Key
   private Boolean isDefaultBroadcast;
   @Key
   private String liveChatId;
   @Key
   private DateTime publishedAt;
   @Key
   private DateTime scheduledEndTime;
   @Key
   private DateTime scheduledStartTime;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;

   public DateTime getActualEndTime() {
      return this.actualEndTime;
   }

   public LiveBroadcastSnippet setActualEndTime(DateTime var1) {
      this.actualEndTime = var1;
      return this;
   }

   public DateTime getActualStartTime() {
      return this.actualStartTime;
   }

   public LiveBroadcastSnippet setActualStartTime(DateTime var1) {
      this.actualStartTime = var1;
      return this;
   }

   public String getChannelId() {
      return this.channelId;
   }

   public LiveBroadcastSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getDescription() {
      return this.description;
   }

   public LiveBroadcastSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public Boolean getIsDefaultBroadcast() {
      return this.isDefaultBroadcast;
   }

   public LiveBroadcastSnippet setIsDefaultBroadcast(Boolean var1) {
      this.isDefaultBroadcast = var1;
      return this;
   }

   public String getLiveChatId() {
      return this.liveChatId;
   }

   public LiveBroadcastSnippet setLiveChatId(String var1) {
      this.liveChatId = var1;
      return this;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public LiveBroadcastSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public DateTime getScheduledEndTime() {
      return this.scheduledEndTime;
   }

   public LiveBroadcastSnippet setScheduledEndTime(DateTime var1) {
      this.scheduledEndTime = var1;
      return this;
   }

   public DateTime getScheduledStartTime() {
      return this.scheduledStartTime;
   }

   public LiveBroadcastSnippet setScheduledStartTime(DateTime var1) {
      this.scheduledStartTime = var1;
      return this;
   }

   public ThumbnailDetails getThumbnails() {
      return this.thumbnails;
   }

   public LiveBroadcastSnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public LiveBroadcastSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public LiveBroadcastSnippet set(String var1, Object var2) {
      return (LiveBroadcastSnippet)super.set(var1, var2);
   }

   public LiveBroadcastSnippet clone() {
      return (LiveBroadcastSnippet)super.clone();
   }
}
