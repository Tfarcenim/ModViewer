package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class SubscriptionSubscriberSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String description;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;

   public String getChannelId() {
      return this.channelId;
   }

   public SubscriptionSubscriberSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getDescription() {
      return this.description;
   }

   public SubscriptionSubscriberSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public ThumbnailDetails getThumbnails() {
      return this.thumbnails;
   }

   public SubscriptionSubscriberSnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public SubscriptionSubscriberSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public SubscriptionSubscriberSnippet set(String var1, Object var2) {
      return (SubscriptionSubscriberSnippet)super.set(var1, var2);
   }

   public SubscriptionSubscriberSnippet clone() {
      return (SubscriptionSubscriberSnippet)super.clone();
   }
}
