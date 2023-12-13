package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ChannelSectionSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String defaultLanguage;
   @Key
   private ChannelSectionLocalization localized;
   @Key
   private Long position;
   @Key
   private String style;
   @Key
   private String title;
   @Key
   private String type;

   public String getChannelId() {
      return this.channelId;
   }

   public ChannelSectionSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getDefaultLanguage() {
      return this.defaultLanguage;
   }

   public ChannelSectionSnippet setDefaultLanguage(String var1) {
      this.defaultLanguage = var1;
      return this;
   }

   public ChannelSectionLocalization getLocalized() {
      return this.localized;
   }

   public ChannelSectionSnippet setLocalized(ChannelSectionLocalization var1) {
      this.localized = var1;
      return this;
   }

   public Long getPosition() {
      return this.position;
   }

   public ChannelSectionSnippet setPosition(Long var1) {
      this.position = var1;
      return this;
   }

   public String getStyle() {
      return this.style;
   }

   public ChannelSectionSnippet setStyle(String var1) {
      this.style = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public ChannelSectionSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public ChannelSectionSnippet setType(String var1) {
      this.type = var1;
      return this;
   }

   public ChannelSectionSnippet set(String var1, Object var2) {
      return (ChannelSectionSnippet)super.set(var1, var2);
   }

   public ChannelSectionSnippet clone() {
      return (ChannelSectionSnippet)super.clone();
   }
}
