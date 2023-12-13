package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class I18nLanguage extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private I18nLanguageSnippet snippet;

   public String getEtag() {
      return this.etag;
   }

   public I18nLanguage setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public I18nLanguage setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public I18nLanguage setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public I18nLanguageSnippet getSnippet() {
      return this.snippet;
   }

   public I18nLanguage setSnippet(I18nLanguageSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public I18nLanguage set(String var1, Object var2) {
      return (I18nLanguage)super.set(var1, var2);
   }

   public I18nLanguage clone() {
      return (I18nLanguage)super.clone();
   }
}
