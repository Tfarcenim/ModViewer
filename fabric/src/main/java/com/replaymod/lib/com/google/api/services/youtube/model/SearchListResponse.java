package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class SearchListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<SearchResult> items;
   @Key
   private String kind;
   @Key
   private String nextPageToken;
   @Key
   private PageInfo pageInfo;
   @Key
   private String prevPageToken;
   @Key
   private String regionCode;
   @Key
   private TokenPagination tokenPagination;
   @Key
   private String visitorId;

   public String getEtag() {
      return this.etag;
   }

   public SearchListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public SearchListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<SearchResult> getItems() {
      return this.items;
   }

   public SearchListResponse setItems(List<SearchResult> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public SearchListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getNextPageToken() {
      return this.nextPageToken;
   }

   public SearchListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public PageInfo getPageInfo() {
      return this.pageInfo;
   }

   public SearchListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public String getPrevPageToken() {
      return this.prevPageToken;
   }

   public SearchListResponse setPrevPageToken(String var1) {
      this.prevPageToken = var1;
      return this;
   }

   public String getRegionCode() {
      return this.regionCode;
   }

   public SearchListResponse setRegionCode(String var1) {
      this.regionCode = var1;
      return this;
   }

   public TokenPagination getTokenPagination() {
      return this.tokenPagination;
   }

   public SearchListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public SearchListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public SearchListResponse set(String var1, Object var2) {
      return (SearchListResponse)super.set(var1, var2);
   }

   public SearchListResponse clone() {
      return (SearchListResponse)super.clone();
   }
}
