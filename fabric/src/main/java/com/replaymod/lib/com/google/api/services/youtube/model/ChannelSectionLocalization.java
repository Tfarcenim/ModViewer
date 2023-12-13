package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ChannelSectionLocalization extends GenericJson {
   @Key
   private String title;

   public String getTitle() {
      return this.title;
   }

   public ChannelSectionLocalization setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public ChannelSectionLocalization set(String var1, Object var2) {
      return (ChannelSectionLocalization)super.set(var1, var2);
   }

   public ChannelSectionLocalization clone() {
      return (ChannelSectionLocalization)super.clone();
   }
}
