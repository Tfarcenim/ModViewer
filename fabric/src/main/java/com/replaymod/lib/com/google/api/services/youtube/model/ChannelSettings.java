package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ChannelSettings extends GenericJson {
   @Key
   private String country;
   @Key
   private String defaultLanguage;
   @Key
   private String defaultTab;
   @Key
   private String description;
   @Key
   private String featuredChannelsTitle;
   @Key
   private List<String> featuredChannelsUrls;
   @Key
   private String keywords;
   @Key
   private Boolean moderateComments;
   @Key
   private String profileColor;
   @Key
   private Boolean showBrowseView;
   @Key
   private Boolean showRelatedChannels;
   @Key
   private String title;
   @Key
   private String trackingAnalyticsAccountId;
   @Key
   private String unsubscribedTrailer;

   public String getCountry() {
      return this.country;
   }

   public ChannelSettings setCountry(String var1) {
      this.country = var1;
      return this;
   }

   public String getDefaultLanguage() {
      return this.defaultLanguage;
   }

   public ChannelSettings setDefaultLanguage(String var1) {
      this.defaultLanguage = var1;
      return this;
   }

   public String getDefaultTab() {
      return this.defaultTab;
   }

   public ChannelSettings setDefaultTab(String var1) {
      this.defaultTab = var1;
      return this;
   }

   public String getDescription() {
      return this.description;
   }

   public ChannelSettings setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public String getFeaturedChannelsTitle() {
      return this.featuredChannelsTitle;
   }

   public ChannelSettings setFeaturedChannelsTitle(String var1) {
      this.featuredChannelsTitle = var1;
      return this;
   }

   public List<String> getFeaturedChannelsUrls() {
      return this.featuredChannelsUrls;
   }

   public ChannelSettings setFeaturedChannelsUrls(List<String> var1) {
      this.featuredChannelsUrls = var1;
      return this;
   }

   public String getKeywords() {
      return this.keywords;
   }

   public ChannelSettings setKeywords(String var1) {
      this.keywords = var1;
      return this;
   }

   public Boolean getModerateComments() {
      return this.moderateComments;
   }

   public ChannelSettings setModerateComments(Boolean var1) {
      this.moderateComments = var1;
      return this;
   }

   public String getProfileColor() {
      return this.profileColor;
   }

   public ChannelSettings setProfileColor(String var1) {
      this.profileColor = var1;
      return this;
   }

   public Boolean getShowBrowseView() {
      return this.showBrowseView;
   }

   public ChannelSettings setShowBrowseView(Boolean var1) {
      this.showBrowseView = var1;
      return this;
   }

   public Boolean getShowRelatedChannels() {
      return this.showRelatedChannels;
   }

   public ChannelSettings setShowRelatedChannels(Boolean var1) {
      this.showRelatedChannels = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public ChannelSettings setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public String getTrackingAnalyticsAccountId() {
      return this.trackingAnalyticsAccountId;
   }

   public ChannelSettings setTrackingAnalyticsAccountId(String var1) {
      this.trackingAnalyticsAccountId = var1;
      return this;
   }

   public String getUnsubscribedTrailer() {
      return this.unsubscribedTrailer;
   }

   public ChannelSettings setUnsubscribedTrailer(String var1) {
      this.unsubscribedTrailer = var1;
      return this;
   }

   public ChannelSettings set(String var1, Object var2) {
      return (ChannelSettings)super.set(var1, var2);
   }

   public ChannelSettings clone() {
      return (ChannelSettings)super.clone();
   }
}
