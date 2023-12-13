package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class VideoContentDetails extends GenericJson {
   @Key
   private String caption;
   @Key
   private ContentRating contentRating;
   @Key
   private AccessPolicy countryRestriction;
   @Key
   private String definition;
   @Key
   private String dimension;
   @Key
   private String duration;
   @Key
   private Boolean licensedContent;
   @Key
   private String projection;
   @Key
   private VideoContentDetailsRegionRestriction regionRestriction;

   public String getCaption() {
      return this.caption;
   }

   public VideoContentDetails setCaption(String var1) {
      this.caption = var1;
      return this;
   }

   public ContentRating getContentRating() {
      return this.contentRating;
   }

   public VideoContentDetails setContentRating(ContentRating var1) {
      this.contentRating = var1;
      return this;
   }

   public AccessPolicy getCountryRestriction() {
      return this.countryRestriction;
   }

   public VideoContentDetails setCountryRestriction(AccessPolicy var1) {
      this.countryRestriction = var1;
      return this;
   }

   public String getDefinition() {
      return this.definition;
   }

   public VideoContentDetails setDefinition(String var1) {
      this.definition = var1;
      return this;
   }

   public String getDimension() {
      return this.dimension;
   }

   public VideoContentDetails setDimension(String var1) {
      this.dimension = var1;
      return this;
   }

   public String getDuration() {
      return this.duration;
   }

   public VideoContentDetails setDuration(String var1) {
      this.duration = var1;
      return this;
   }

   public Boolean getLicensedContent() {
      return this.licensedContent;
   }

   public VideoContentDetails setLicensedContent(Boolean var1) {
      this.licensedContent = var1;
      return this;
   }

   public String getProjection() {
      return this.projection;
   }

   public VideoContentDetails setProjection(String var1) {
      this.projection = var1;
      return this;
   }

   public VideoContentDetailsRegionRestriction getRegionRestriction() {
      return this.regionRestriction;
   }

   public VideoContentDetails setRegionRestriction(VideoContentDetailsRegionRestriction var1) {
      this.regionRestriction = var1;
      return this;
   }

   public VideoContentDetails set(String var1, Object var2) {
      return (VideoContentDetails)super.set(var1, var2);
   }

   public VideoContentDetails clone() {
      return (VideoContentDetails)super.clone();
   }
}
