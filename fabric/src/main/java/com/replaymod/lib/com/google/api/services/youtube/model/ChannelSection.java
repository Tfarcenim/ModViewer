package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.Map;

public final class ChannelSection extends GenericJson {
   @Key
   private ChannelSectionContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private Map<String, ChannelSectionLocalization> localizations;
   @Key
   private ChannelSectionSnippet snippet;
   @Key
   private ChannelSectionTargeting targeting;

   public ChannelSectionContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public ChannelSection setContentDetails(ChannelSectionContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public String getEtag() {
      return this.etag;
   }

   public ChannelSection setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public ChannelSection setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public ChannelSection setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Map<String, ChannelSectionLocalization> getLocalizations() {
      return this.localizations;
   }

   public ChannelSection setLocalizations(Map<String, ChannelSectionLocalization> var1) {
      this.localizations = var1;
      return this;
   }

   public ChannelSectionSnippet getSnippet() {
      return this.snippet;
   }

   public ChannelSection setSnippet(ChannelSectionSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public ChannelSectionTargeting getTargeting() {
      return this.targeting;
   }

   public ChannelSection setTargeting(ChannelSectionTargeting var1) {
      this.targeting = var1;
      return this;
   }

   public ChannelSection set(String var1, Object var2) {
      return (ChannelSection)super.set(var1, var2);
   }

   public ChannelSection clone() {
      return (ChannelSection)super.clone();
   }
}
