package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class CommentThreadSnippet extends GenericJson {
   @Key
   private Boolean canReply;
   @Key
   private String channelId;
   @Key
   private Boolean isPublic;
   @Key
   private Comment topLevelComment;
   @Key
   private Long totalReplyCount;
   @Key
   private String videoId;

   public Boolean getCanReply() {
      return this.canReply;
   }

   public CommentThreadSnippet setCanReply(Boolean var1) {
      this.canReply = var1;
      return this;
   }

   public String getChannelId() {
      return this.channelId;
   }

   public CommentThreadSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public Boolean getIsPublic() {
      return this.isPublic;
   }

   public CommentThreadSnippet setIsPublic(Boolean var1) {
      this.isPublic = var1;
      return this;
   }

   public Comment getTopLevelComment() {
      return this.topLevelComment;
   }

   public CommentThreadSnippet setTopLevelComment(Comment var1) {
      this.topLevelComment = var1;
      return this;
   }

   public Long getTotalReplyCount() {
      return this.totalReplyCount;
   }

   public CommentThreadSnippet setTotalReplyCount(Long var1) {
      this.totalReplyCount = var1;
      return this;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public CommentThreadSnippet setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }

   public CommentThreadSnippet set(String var1, Object var2) {
      return (CommentThreadSnippet)super.set(var1, var2);
   }

   public CommentThreadSnippet clone() {
      return (CommentThreadSnippet)super.clone();
   }
}
