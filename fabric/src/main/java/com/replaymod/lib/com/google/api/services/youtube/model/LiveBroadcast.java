package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveBroadcast extends GenericJson {
   @Key
   private LiveBroadcastContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private LiveBroadcastSnippet snippet;
   @Key
   private LiveBroadcastStatistics statistics;
   @Key
   private LiveBroadcastStatus status;
   @Key
   private LiveBroadcastTopicDetails topicDetails;

   public LiveBroadcastContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public LiveBroadcast setContentDetails(LiveBroadcastContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public String getEtag() {
      return this.etag;
   }

   public LiveBroadcast setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public LiveBroadcast setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public LiveBroadcast setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public LiveBroadcastSnippet getSnippet() {
      return this.snippet;
   }

   public LiveBroadcast setSnippet(LiveBroadcastSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public LiveBroadcastStatistics getStatistics() {
      return this.statistics;
   }

   public LiveBroadcast setStatistics(LiveBroadcastStatistics var1) {
      this.statistics = var1;
      return this;
   }

   public LiveBroadcastStatus getStatus() {
      return this.status;
   }

   public LiveBroadcast setStatus(LiveBroadcastStatus var1) {
      this.status = var1;
      return this;
   }

   public LiveBroadcastTopicDetails getTopicDetails() {
      return this.topicDetails;
   }

   public LiveBroadcast setTopicDetails(LiveBroadcastTopicDetails var1) {
      this.topicDetails = var1;
      return this;
   }

   public LiveBroadcast set(String var1, Object var2) {
      return (LiveBroadcast)super.set(var1, var2);
   }

   public LiveBroadcast clone() {
      return (LiveBroadcast)super.clone();
   }
}
