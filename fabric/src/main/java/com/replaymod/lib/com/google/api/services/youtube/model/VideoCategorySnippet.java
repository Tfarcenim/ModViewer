package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class VideoCategorySnippet extends GenericJson {
   @Key
   private Boolean assignable;
   @Key
   private String channelId;
   @Key
   private String title;

   public Boolean getAssignable() {
      return this.assignable;
   }

   public VideoCategorySnippet setAssignable(Boolean var1) {
      this.assignable = var1;
      return this;
   }

   public String getChannelId() {
      return this.channelId;
   }

   public VideoCategorySnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public VideoCategorySnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public VideoCategorySnippet set(String var1, Object var2) {
      return (VideoCategorySnippet)super.set(var1, var2);
   }

   public VideoCategorySnippet clone() {
      return (VideoCategorySnippet)super.clone();
   }
}
