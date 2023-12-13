package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class ChannelStatistics extends GenericJson {
   @Key
   @JsonString
   private BigInteger commentCount;
   @Key
   private Boolean hiddenSubscriberCount;
   @Key
   @JsonString
   private BigInteger subscriberCount;
   @Key
   @JsonString
   private BigInteger videoCount;
   @Key
   @JsonString
   private BigInteger viewCount;

   public BigInteger getCommentCount() {
      return this.commentCount;
   }

   public ChannelStatistics setCommentCount(BigInteger var1) {
      this.commentCount = var1;
      return this;
   }

   public Boolean getHiddenSubscriberCount() {
      return this.hiddenSubscriberCount;
   }

   public ChannelStatistics setHiddenSubscriberCount(Boolean var1) {
      this.hiddenSubscriberCount = var1;
      return this;
   }

   public BigInteger getSubscriberCount() {
      return this.subscriberCount;
   }

   public ChannelStatistics setSubscriberCount(BigInteger var1) {
      this.subscriberCount = var1;
      return this;
   }

   public BigInteger getVideoCount() {
      return this.videoCount;
   }

   public ChannelStatistics setVideoCount(BigInteger var1) {
      this.videoCount = var1;
      return this;
   }

   public BigInteger getViewCount() {
      return this.viewCount;
   }

   public ChannelStatistics setViewCount(BigInteger var1) {
      this.viewCount = var1;
      return this;
   }

   public ChannelStatistics set(String var1, Object var2) {
      return (ChannelStatistics)super.set(var1, var2);
   }

   public ChannelStatistics clone() {
      return (ChannelStatistics)super.clone();
   }
}
