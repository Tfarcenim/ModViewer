package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class I18nLanguageListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<I18nLanguage> items;
   @Key
   private String kind;
   @Key
   private String visitorId;

   public String getEtag() {
      return this.etag;
   }

   public I18nLanguageListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public I18nLanguageListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public List<I18nLanguage> getItems() {
      return this.items;
   }

   public I18nLanguageListResponse setItems(List<I18nLanguage> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public I18nLanguageListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public I18nLanguageListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public I18nLanguageListResponse set(String var1, Object var2) {
      return (I18nLanguageListResponse)super.set(var1, var2);
   }

   public I18nLanguageListResponse clone() {
      return (I18nLanguageListResponse)super.clone();
   }

   static {
      Data.nullOf(I18nLanguage.class);
   }
}
