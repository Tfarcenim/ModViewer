package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class VideoGetRatingResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<VideoRating> items;
   @Key
   private String kind;
   @Key
   private String visitorId;

   public String getEtag() {
      return this.etag;
   }

   public VideoGetRatingResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public VideoGetRatingResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<VideoRating> getItems() {
      return this.items;
   }

   public VideoGetRatingResponse setItems(List<VideoRating> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public VideoGetRatingResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public VideoGetRatingResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public VideoGetRatingResponse set(String var1, Object var2) {
      return (VideoGetRatingResponse)super.set(var1, var2);
   }

   public VideoGetRatingResponse clone() {
      return (VideoGetRatingResponse)super.clone();
   }
}
