package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ActivityContentDetailsPromotedItem extends GenericJson {
   @Key
   private String adTag;
   @Key
   private String clickTrackingUrl;
   @Key
   private String creativeViewUrl;
   @Key
   private String ctaType;
   @Key
   private String customCtaButtonText;
   @Key
   private String descriptionText;
   @Key
   private String destinationUrl;
   @Key
   private List<String> forecastingUrl;
   @Key
   private List<String> impressionUrl;
   @Key
   private String videoId;

   public String getAdTag() {
      return this.adTag;
   }

   public ActivityContentDetailsPromotedItem setAdTag(String var1) {
      this.adTag = var1;
      return this;
   }

   public String getClickTrackingUrl() {
      return this.clickTrackingUrl;
   }

   public ActivityContentDetailsPromotedItem setClickTrackingUrl(String var1) {
      this.clickTrackingUrl = var1;
      return this;
   }

   public String getCreativeViewUrl() {
      return this.creativeViewUrl;
   }

   public ActivityContentDetailsPromotedItem setCreativeViewUrl(String var1) {
      this.creativeViewUrl = var1;
      return this;
   }

   public String getCtaType() {
      return this.ctaType;
   }

   public ActivityContentDetailsPromotedItem setCtaType(String var1) {
      this.ctaType = var1;
      return this;
   }

   public String getCustomCtaButtonText() {
      return this.customCtaButtonText;
   }

   public ActivityContentDetailsPromotedItem setCustomCtaButtonText(String var1) {
      this.customCtaButtonText = var1;
      return this;
   }

   public String getDescriptionText() {
      return this.descriptionText;
   }

   public ActivityContentDetailsPromotedItem setDescriptionText(String var1) {
      this.descriptionText = var1;
      return this;
   }

   public String getDestinationUrl() {
      return this.destinationUrl;
   }

   public ActivityContentDetailsPromotedItem setDestinationUrl(String var1) {
      this.destinationUrl = var1;
      return this;
   }

   public List<String> getForecastingUrl() {
      return this.forecastingUrl;
   }

   public ActivityContentDetailsPromotedItem setForecastingUrl(List<String> var1) {
      this.forecastingUrl = var1;
      return this;
   }

   public List<String> getImpressionUrl() {
      return this.impressionUrl;
   }

   public ActivityContentDetailsPromotedItem setImpressionUrl(List<String> var1) {
      this.impressionUrl = var1;
      return this;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public ActivityContentDetailsPromotedItem setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem set(String var1, Object var2) {
      return (ActivityContentDetailsPromotedItem)super.set(var1, var2);
   }

   public ActivityContentDetailsPromotedItem clone() {
      return (ActivityContentDetailsPromotedItem)super.clone();
   }
}
