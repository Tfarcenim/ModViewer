package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class SearchResult extends GenericJson {
   @Key
   private String etag;
   @Key
   private ResourceId id;
   @Key
   private String kind;
   @Key
   private SearchResultSnippet snippet;

   public String getEtag() {
      return this.etag;
   }

   public SearchResult setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public ResourceId getId() {
      return this.id;
   }

   public SearchResult setId(ResourceId var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public SearchResult setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public SearchResultSnippet getSnippet() {
      return this.snippet;
   }

   public SearchResult setSnippet(SearchResultSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public SearchResult set(String var1, Object var2) {
      return (SearchResult)super.set(var1, var2);
   }

   public SearchResult clone() {
      return (SearchResult)super.clone();
   }
}
