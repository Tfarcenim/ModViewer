package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class SponsorListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<Sponsor> items;
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

   public SponsorListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public SponsorListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<Sponsor> getItems() {
      return this.items;
   }

   public SponsorListResponse setItems(List<Sponsor> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public SponsorListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getNextPageToken() {
      return this.nextPageToken;
   }

   public SponsorListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public PageInfo getPageInfo() {
      return this.pageInfo;
   }

   public SponsorListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public TokenPagination getTokenPagination() {
      return this.tokenPagination;
   }

   public SponsorListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public SponsorListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public SponsorListResponse set(String var1, Object var2) {
      return (SponsorListResponse)super.set(var1, var2);
   }

   public SponsorListResponse clone() {
      return (SponsorListResponse)super.clone();
   }

   static {
      Data.nullOf(Sponsor.class);
   }
}
