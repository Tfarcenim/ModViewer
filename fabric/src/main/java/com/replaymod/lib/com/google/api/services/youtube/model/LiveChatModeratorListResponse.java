package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class LiveChatModeratorListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<LiveChatModerator> items;
   @Key
   private String kind;
   @Key
   private String nextPageToken;
   @Key
   private PageInfo pageInfo;
   @Key
   private String prevPageToken;
   @Key
   private TokenPagination tokenPagination;
   @Key
   private String visitorId;

   public String getEtag() {
      return this.etag;
   }

   public LiveChatModeratorListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public LiveChatModeratorListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<LiveChatModerator> getItems() {
      return this.items;
   }

   public LiveChatModeratorListResponse setItems(List<LiveChatModerator> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public LiveChatModeratorListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getNextPageToken() {
      return this.nextPageToken;
   }

   public LiveChatModeratorListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public PageInfo getPageInfo() {
      return this.pageInfo;
   }

   public LiveChatModeratorListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public String getPrevPageToken() {
      return this.prevPageToken;
   }

   public LiveChatModeratorListResponse setPrevPageToken(String var1) {
      this.prevPageToken = var1;
      return this;
   }

   public TokenPagination getTokenPagination() {
      return this.tokenPagination;
   }

   public LiveChatModeratorListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public LiveChatModeratorListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public LiveChatModeratorListResponse set(String var1, Object var2) {
      return (LiveChatModeratorListResponse)super.set(var1, var2);
   }

   public LiveChatModeratorListResponse clone() {
      return (LiveChatModeratorListResponse)super.clone();
   }

   static {
      Data.nullOf(LiveChatModerator.class);
   }
}
