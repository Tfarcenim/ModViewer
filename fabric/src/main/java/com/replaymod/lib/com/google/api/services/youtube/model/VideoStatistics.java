package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoStatistics extends GenericJson {
   @Key
   @JsonString
   private BigInteger commentCount;
   @Key
   @JsonString
   private BigInteger dislikeCount;
   @Key
   @JsonString
   private BigInteger favoriteCount;
   @Key
   @JsonString
   private BigInteger likeCount;
   @Key
   @JsonString
   private BigInteger viewCount;

   public BigInteger getCommentCount() {
      return this.commentCount;
   }

   public VideoStatistics setCommentCount(BigInteger var1) {
      this.commentCount = var1;
      return this;
   }

   public BigInteger getDislikeCount() {
      return this.dislikeCount;
   }

   public VideoStatistics setDislikeCount(BigInteger var1) {
      this.dislikeCount = var1;
      return this;
   }

   public BigInteger getFavoriteCount() {
      return this.favoriteCount;
   }

   public VideoStatistics setFavoriteCount(BigInteger var1) {
      this.favoriteCount = var1;
      return this;
   }

   public BigInteger getLikeCount() {
      return this.likeCount;
   }

   public VideoStatistics setLikeCount(BigInteger var1) {
      this.likeCount = var1;
      return this;
   }

   public BigInteger getViewCount() {
      return this.viewCount;
   }

   public VideoStatistics setViewCount(BigInteger var1) {
      this.viewCount = var1;
      return this;
   }

   public VideoStatistics set(String var1, Object var2) {
      return (VideoStatistics)super.set(var1, var2);
   }

   public VideoStatistics clone() {
      return (VideoStatistics)super.clone();
   }
}
