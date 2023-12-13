package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class I18nRegion extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private I18nRegionSnippet snippet;

   public String getEtag() {
      return this.etag;
   }

   public I18nRegion setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public I18nRegion setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public I18nRegion setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public I18nRegionSnippet getSnippet() {
      return this.snippet;
   }

   public I18nRegion setSnippet(I18nRegionSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public I18nRegion set(String var1, Object var2) {
      return (I18nRegion)super.set(var1, var2);
   }

   public I18nRegion clone() {
      return (I18nRegion)super.clone();
   }
}
