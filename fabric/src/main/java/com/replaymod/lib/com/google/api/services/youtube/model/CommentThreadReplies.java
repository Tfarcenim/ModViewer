package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class CommentThreadReplies extends GenericJson {
   @Key
   private List<Comment> comments;

   public List<Comment> getComments() {
      return this.comments;
   }

   public CommentThreadReplies setComments(List<Comment> var1) {
      this.comments = var1;
      return this;
   }

   public CommentThreadReplies set(String var1, Object var2) {
      return (CommentThreadReplies)super.set(var1, var2);
   }

   public CommentThreadReplies clone() {
      return (CommentThreadReplies)super.clone();
   }

   static {
      Data.nullOf(Comment.class);
   }
}
