package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class LiveChatMessageListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<LiveChatMessage> items;
   @Key
   private String kind;
   @Key
   private String nextPageToken;
   @Key
   private DateTime offlineAt;
   @Key
   private PageInfo pageInfo;
   @Key
   private Long pollingIntervalMillis;
   @Key
   private TokenPagination tokenPagination;
   @Key
   private String visitorId;

   public String getEtag() {
      return this.etag;
   }

   public LiveChatMessageListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public LiveChatMessageListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<LiveChatMessage> getItems() {
      return this.items;
   }

   public LiveChatMessageListResponse setItems(List<LiveChatMessage> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public LiveChatMessageListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getNextPageToken() {
      return this.nextPageToken;
   }

   public LiveChatMessageListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public DateTime getOfflineAt() {
      return this.offlineAt;
   }

   public LiveChatMessageListResponse setOfflineAt(DateTime var1) {
      this.offlineAt = var1;
      return this;
   }

   public PageInfo getPageInfo() {
      return this.pageInfo;
   }

   public LiveChatMessageListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public Long getPollingIntervalMillis() {
      return this.pollingIntervalMillis;
   }

   public LiveChatMessageListResponse setPollingIntervalMillis(Long var1) {
      this.pollingIntervalMillis = var1;
      return this;
   }

   public TokenPagination getTokenPagination() {
      return this.tokenPagination;
   }

   public LiveChatMessageListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public LiveChatMessageListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public LiveChatMessageListResponse set(String var1, Object var2) {
      return (LiveChatMessageListResponse)super.set(var1, var2);
   }

   public LiveChatMessageListResponse clone() {
      return (LiveChatMessageListResponse)super.clone();
   }

   static {
      Data.nullOf(LiveChatMessage.class);
   }
}
