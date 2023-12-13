package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ChannelSectionListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<ChannelSection> items;
   @Key
   private String kind;
   @Key
   private String visitorId;

   public String getEtag() {
      return this.etag;
   }

   public ChannelSectionListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public ChannelSectionListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<ChannelSection> getItems() {
      return this.items;
   }

   public ChannelSectionListResponse setItems(List<ChannelSection> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public ChannelSectionListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public ChannelSectionListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public ChannelSectionListResponse set(String var1, Object var2) {
      return (ChannelSectionListResponse)super.set(var1, var2);
   }

   public ChannelSectionListResponse clone() {
      return (ChannelSectionListResponse)super.clone();
   }

   static {
      Data.nullOf(ChannelSection.class);
   }
}
