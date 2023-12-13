package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class CaptionListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<Caption> items;
   @Key
   private String kind;
   @Key
   private String visitorId;

   public String getEtag() {
      return this.etag;
   }

   public CaptionListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public CaptionListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<Caption> getItems() {
      return this.items;
   }

   public CaptionListResponse setItems(List<Caption> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public CaptionListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public CaptionListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public CaptionListResponse set(String var1, Object var2) {
      return (CaptionListResponse)super.set(var1, var2);
   }

   public CaptionListResponse clone() {
      return (CaptionListResponse)super.clone();
   }

   static {
      Data.nullOf(Caption.class);
   }
}
