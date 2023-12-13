package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class Sponsor extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private SponsorSnippet snippet;

   public String getEtag() {
      return this.etag;
   }

   public Sponsor setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public Sponsor setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public Sponsor setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public SponsorSnippet getSnippet() {
      return this.snippet;
   }

   public Sponsor setSnippet(SponsorSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public Sponsor set(String var1, Object var2) {
      return (Sponsor)super.set(var1, var2);
   }

   public Sponsor clone() {
      return (Sponsor)super.clone();
   }
}
