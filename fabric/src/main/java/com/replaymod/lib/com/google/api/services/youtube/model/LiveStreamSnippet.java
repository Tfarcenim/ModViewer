package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveStreamSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String description;
   @Key
   private Boolean isDefaultStream;
   @Key
   private DateTime publishedAt;
   @Key
   private String title;

   public String getChannelId() {
      return this.channelId;
   }

   public LiveStreamSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getDescription() {
      return this.description;
   }

   public LiveStreamSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public Boolean getIsDefaultStream() {
      return this.isDefaultStream;
   }

   public LiveStreamSnippet setIsDefaultStream(Boolean var1) {
      this.isDefaultStream = var1;
      return this;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public LiveStreamSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public LiveStreamSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public LiveStreamSnippet set(String var1, Object var2) {
      return (LiveStreamSnippet)super.set(var1, var2);
   }

   public LiveStreamSnippet clone() {
      return (LiveStreamSnippet)super.clone();
   }
}
