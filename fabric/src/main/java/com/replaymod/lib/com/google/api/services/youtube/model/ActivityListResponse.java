package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ActivityListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<Activity> items;
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

   public ActivityListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public ActivityListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<Activity> getItems() {
      return this.items;
   }

   public ActivityListResponse setItems(List<Activity> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public ActivityListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getNextPageToken() {
      return this.nextPageToken;
   }

   public ActivityListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public PageInfo getPageInfo() {
      return this.pageInfo;
   }

   public ActivityListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public String getPrevPageToken() {
      return this.prevPageToken;
   }

   public ActivityListResponse setPrevPageToken(String var1) {
      this.prevPageToken = var1;
      return this;
   }

   public TokenPagination getTokenPagination() {
      return this.tokenPagination;
   }

   public ActivityListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public ActivityListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public ActivityListResponse set(String var1, Object var2) {
      return (ActivityListResponse)super.set(var1, var2);
   }

   public ActivityListResponse clone() {
      return (ActivityListResponse)super.clone();
   }

   static {
      Data.nullOf(Activity.class);
   }
}
