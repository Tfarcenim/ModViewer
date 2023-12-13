package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ThumbnailSetResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<ThumbnailDetails> items;
   @Key
   private String kind;
   @Key
   private String visitorId;

   public String getEtag() {
      return this.etag;
   }

   public ThumbnailSetResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public ThumbnailSetResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<ThumbnailDetails> getItems() {
      return this.items;
   }

   public ThumbnailSetResponse setItems(List<ThumbnailDetails> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public ThumbnailSetResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public ThumbnailSetResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public ThumbnailSetResponse set(String var1, Object var2) {
      return (ThumbnailSetResponse)super.set(var1, var2);
   }

   public ThumbnailSetResponse clone() {
      return (ThumbnailSetResponse)super.clone();
   }

   static {
      Data.nullOf(ThumbnailDetails.class);
   }
}
