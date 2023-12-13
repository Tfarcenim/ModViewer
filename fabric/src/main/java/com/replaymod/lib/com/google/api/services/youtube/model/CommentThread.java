package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class CommentThread extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private CommentThreadReplies replies;
   @Key
   private CommentThreadSnippet snippet;

   public String getEtag() {
      return this.etag;
   }

   public CommentThread setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public CommentThread setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public CommentThread setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public CommentThreadReplies getReplies() {
      return this.replies;
   }

   public CommentThread setReplies(CommentThreadReplies var1) {
      this.replies = var1;
      return this;
   }

   public CommentThreadSnippet getSnippet() {
      return this.snippet;
   }

   public CommentThread setSnippet(CommentThreadSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public CommentThread set(String var1, Object var2) {
      return (CommentThread)super.set(var1, var2);
   }

   public CommentThread clone() {
      return (CommentThread)super.clone();
   }
}
