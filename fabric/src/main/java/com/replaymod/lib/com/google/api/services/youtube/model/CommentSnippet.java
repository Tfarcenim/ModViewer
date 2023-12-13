package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class CommentSnippet extends GenericJson {
   @Key
   private Object authorChannelId;
   @Key
   private String authorChannelUrl;
   @Key
   private String authorDisplayName;
   @Key
   private String authorGoogleplusProfileUrl;
   @Key
   private String authorProfileImageUrl;
   @Key
   private Boolean canRate;
   @Key
   private String channelId;
   @Key
   private Long likeCount;
   @Key
   private String moderationStatus;
   @Key
   private String parentId;
   @Key
   private DateTime publishedAt;
   @Key
   private String textDisplay;
   @Key
   private String textOriginal;
   @Key
   private DateTime updatedAt;
   @Key
   private String videoId;
   @Key
   private String viewerRating;

   public Object getAuthorChannelId() {
      return this.authorChannelId;
   }

   public CommentSnippet setAuthorChannelId(Object var1) {
      this.authorChannelId = var1;
      return this;
   }

   public String getAuthorChannelUrl() {
      return this.authorChannelUrl;
   }

   public CommentSnippet setAuthorChannelUrl(String var1) {
      this.authorChannelUrl = var1;
      return this;
   }

   public String getAuthorDisplayName() {
      return this.authorDisplayName;
   }

   public CommentSnippet setAuthorDisplayName(String var1) {
      this.authorDisplayName = var1;
      return this;
   }

   public String getAuthorGoogleplusProfileUrl() {
      return this.authorGoogleplusProfileUrl;
   }

   public CommentSnippet setAuthorGoogleplusProfileUrl(String var1) {
      this.authorGoogleplusProfileUrl = var1;
      return this;
   }

   public String getAuthorProfileImageUrl() {
      return this.authorProfileImageUrl;
   }

   public CommentSnippet setAuthorProfileImageUrl(String var1) {
      this.authorProfileImageUrl = var1;
      return this;
   }

   public Boolean getCanRate() {
      return this.canRate;
   }

   public CommentSnippet setCanRate(Boolean var1) {
      this.canRate = var1;
      return this;
   }

   public String getChannelId() {
      return this.channelId;
   }

   public CommentSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public Long getLikeCount() {
      return this.likeCount;
   }

   public CommentSnippet setLikeCount(Long var1) {
      this.likeCount = var1;
      return this;
   }

   public String getModerationStatus() {
      return this.moderationStatus;
   }

   public CommentSnippet setModerationStatus(String var1) {
      this.moderationStatus = var1;
      return this;
   }

   public String getParentId() {
      return this.parentId;
   }

   public CommentSnippet setParentId(String var1) {
      this.parentId = var1;
      return this;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public CommentSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public String getTextDisplay() {
      return this.textDisplay;
   }

   public CommentSnippet setTextDisplay(String var1) {
      this.textDisplay = var1;
      return this;
   }

   public String getTextOriginal() {
      return this.textOriginal;
   }

   public CommentSnippet setTextOriginal(String var1) {
      this.textOriginal = var1;
      return this;
   }

   public DateTime getUpdatedAt() {
      return this.updatedAt;
   }

   public CommentSnippet setUpdatedAt(DateTime var1) {
      this.updatedAt = var1;
      return this;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public CommentSnippet setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }

   public String getViewerRating() {
      return this.viewerRating;
   }

   public CommentSnippet setViewerRating(String var1) {
      this.viewerRating = var1;
      return this;
   }

   public CommentSnippet set(String var1, Object var2) {
      return (CommentSnippet)super.set(var1, var2);
   }

   public CommentSnippet clone() {
      return (CommentSnippet)super.clone();
   }
}
