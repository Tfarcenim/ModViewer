package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetails extends GenericJson {
   @Key
   private ActivityContentDetailsBulletin bulletin;
   @Key
   private ActivityContentDetailsChannelItem channelItem;
   @Key
   private ActivityContentDetailsComment comment;
   @Key
   private ActivityContentDetailsFavorite favorite;
   @Key
   private ActivityContentDetailsLike like;
   @Key
   private ActivityContentDetailsPlaylistItem playlistItem;
   @Key
   private ActivityContentDetailsPromotedItem promotedItem;
   @Key
   private ActivityContentDetailsRecommendation recommendation;
   @Key
   private ActivityContentDetailsSocial social;
   @Key
   private ActivityContentDetailsSubscription subscription;
   @Key
   private ActivityContentDetailsUpload upload;

   public ActivityContentDetailsBulletin getBulletin() {
      return this.bulletin;
   }

   public ActivityContentDetails setBulletin(ActivityContentDetailsBulletin var1) {
      this.bulletin = var1;
      return this;
   }

   public ActivityContentDetailsChannelItem getChannelItem() {
      return this.channelItem;
   }

   public ActivityContentDetails setChannelItem(ActivityContentDetailsChannelItem var1) {
      this.channelItem = var1;
      return this;
   }

   public ActivityContentDetailsComment getComment() {
      return this.comment;
   }

   public ActivityContentDetails setComment(ActivityContentDetailsComment var1) {
      this.comment = var1;
      return this;
   }

   public ActivityContentDetailsFavorite getFavorite() {
      return this.favorite;
   }

   public ActivityContentDetails setFavorite(ActivityContentDetailsFavorite var1) {
      this.favorite = var1;
      return this;
   }

   public ActivityContentDetailsLike getLike() {
      return this.like;
   }

   public ActivityContentDetails setLike(ActivityContentDetailsLike var1) {
      this.like = var1;
      return this;
   }

   public ActivityContentDetailsPlaylistItem getPlaylistItem() {
      return this.playlistItem;
   }

   public ActivityContentDetails setPlaylistItem(ActivityContentDetailsPlaylistItem var1) {
      this.playlistItem = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem getPromotedItem() {
      return this.promotedItem;
   }

   public ActivityContentDetails setPromotedItem(ActivityContentDetailsPromotedItem var1) {
      this.promotedItem = var1;
      return this;
   }

   public ActivityContentDetailsRecommendation getRecommendation() {
      return this.recommendation;
   }

   public ActivityContentDetails setRecommendation(ActivityContentDetailsRecommendation var1) {
      this.recommendation = var1;
      return this;
   }

   public ActivityContentDetailsSocial getSocial() {
      return this.social;
   }

   public ActivityContentDetails setSocial(ActivityContentDetailsSocial var1) {
      this.social = var1;
      return this;
   }

   public ActivityContentDetailsSubscription getSubscription() {
      return this.subscription;
   }

   public ActivityContentDetails setSubscription(ActivityContentDetailsSubscription var1) {
      this.subscription = var1;
      return this;
   }

   public ActivityContentDetailsUpload getUpload() {
      return this.upload;
   }

   public ActivityContentDetails setUpload(ActivityContentDetailsUpload var1) {
      this.upload = var1;
      return this;
   }

   public ActivityContentDetails set(String var1, Object var2) {
      return (ActivityContentDetails)super.set(var1, var2);
   }

   public ActivityContentDetails clone() {
      return (ActivityContentDetails)super.clone();
   }
}
