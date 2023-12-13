package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.Map;

public final class Channel extends GenericJson {
   @Key
   private ChannelAuditDetails auditDetails;
   @Key
   private ChannelBrandingSettings brandingSettings;
   @Key
   private ChannelContentDetails contentDetails;
   @Key
   private ChannelContentOwnerDetails contentOwnerDetails;
   @Key
   private ChannelConversionPings conversionPings;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private InvideoPromotion invideoPromotion;
   @Key
   private String kind;
   @Key
   private Map<String, ChannelLocalization> localizations;
   @Key
   private ChannelSnippet snippet;
   @Key
   private ChannelStatistics statistics;
   @Key
   private ChannelStatus status;
   @Key
   private ChannelTopicDetails topicDetails;

   public ChannelAuditDetails getAuditDetails() {
      return this.auditDetails;
   }

   public Channel setAuditDetails(ChannelAuditDetails var1) {
      this.auditDetails = var1;
      return this;
   }

   public ChannelBrandingSettings getBrandingSettings() {
      return this.brandingSettings;
   }

   public Channel setBrandingSettings(ChannelBrandingSettings var1) {
      this.brandingSettings = var1;
      return this;
   }

   public ChannelContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public Channel setContentDetails(ChannelContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public ChannelContentOwnerDetails getContentOwnerDetails() {
      return this.contentOwnerDetails;
   }

   public Channel setContentOwnerDetails(ChannelContentOwnerDetails var1) {
      this.contentOwnerDetails = var1;
      return this;
   }

   public ChannelConversionPings getConversionPings() {
      return this.conversionPings;
   }

   public Channel setConversionPings(ChannelConversionPings var1) {
      this.conversionPings = var1;
      return this;
   }

   public String getEtag() {
      return this.etag;
   }

   public Channel setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public Channel setId(String var1) {
      this.id = var1;
      return this;
   }

   public InvideoPromotion getInvideoPromotion() {
      return this.invideoPromotion;
   }

   public Channel setInvideoPromotion(InvideoPromotion var1) {
      this.invideoPromotion = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public Channel setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Map<String, ChannelLocalization> getLocalizations() {
      return this.localizations;
   }

   public Channel setLocalizations(Map<String, ChannelLocalization> var1) {
      this.localizations = var1;
      return this;
   }

   public ChannelSnippet getSnippet() {
      return this.snippet;
   }

   public Channel setSnippet(ChannelSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public ChannelStatistics getStatistics() {
      return this.statistics;
   }

   public Channel setStatistics(ChannelStatistics var1) {
      this.statistics = var1;
      return this;
   }

   public ChannelStatus getStatus() {
      return this.status;
   }

   public Channel setStatus(ChannelStatus var1) {
      this.status = var1;
      return this;
   }

   public ChannelTopicDetails getTopicDetails() {
      return this.topicDetails;
   }

   public Channel setTopicDetails(ChannelTopicDetails var1) {
      this.topicDetails = var1;
      return this;
   }

   public Channel set(String var1, Object var2) {
      return (Channel)super.set(var1, var2);
   }

   public Channel clone() {
      return (Channel)super.clone();
   }
}
