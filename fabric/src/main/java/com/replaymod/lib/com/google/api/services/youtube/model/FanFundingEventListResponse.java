package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class FanFundingEventListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<FanFundingEvent> items;
   @Key
   private String kind;
   @Key
   private String nextPageToken;
   @Key
   private PageInfo pageInfo;
   @Key
   private TokenPagination tokenPagination;
   @Key
   private String visitorId;

   public String getEtag() {
      return this.etag;
   }

   public FanFundingEventListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public FanFundingEventListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<FanFundingEvent> getItems() {
      return this.items;
   }

   public FanFundingEventListResponse setItems(List<FanFundingEvent> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public FanFundingEventListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getNextPageToken() {
      return this.nextPageToken;
   }

   public FanFundingEventListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public PageInfo getPageInfo() {
      return this.pageInfo;
   }

   public FanFundingEventListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public TokenPagination getTokenPagination() {
      return this.tokenPagination;
   }

   public FanFundingEventListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public FanFundingEventListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public FanFundingEventListResponse set(String var1, Object var2) {
      return (FanFundingEventListResponse)super.set(var1, var2);
   }

   public FanFundingEventListResponse clone() {
      return (FanFundingEventListResponse)super.clone();
   }

   static {
      Data.nullOf(FanFundingEvent.class);
   }
}
