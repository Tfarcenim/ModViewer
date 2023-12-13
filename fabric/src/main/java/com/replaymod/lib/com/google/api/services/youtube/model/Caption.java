package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class Caption extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private CaptionSnippet snippet;

   public String getEtag() {
      return this.etag;
   }

   public Caption setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public Caption setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public Caption setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public CaptionSnippet getSnippet() {
      return this.snippet;
   }

   public Caption setSnippet(CaptionSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public Caption set(String var1, Object var2) {
      return (Caption)super.set(var1, var2);
   }

   public Caption clone() {
      return (Caption)super.clone();
   }
}
