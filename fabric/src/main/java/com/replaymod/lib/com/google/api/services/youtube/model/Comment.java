package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class Comment extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private CommentSnippet snippet;

   public String getEtag() {
      return this.etag;
   }

   public Comment setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public Comment setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public Comment setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public CommentSnippet getSnippet() {
      return this.snippet;
   }

   public Comment setSnippet(CommentSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public Comment set(String var1, Object var2) {
      return (Comment)super.set(var1, var2);
   }

   public Comment clone() {
      return (Comment)super.clone();
   }
}
