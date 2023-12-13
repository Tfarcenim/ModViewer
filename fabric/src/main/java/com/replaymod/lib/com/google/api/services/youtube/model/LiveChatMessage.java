package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveChatMessage extends GenericJson {
   @Key
   private LiveChatMessageAuthorDetails authorDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private LiveChatMessageSnippet snippet;

   public LiveChatMessageAuthorDetails getAuthorDetails() {
      return this.authorDetails;
   }

   public LiveChatMessage setAuthorDetails(LiveChatMessageAuthorDetails var1) {
      this.authorDetails = var1;
      return this;
   }

   public String getEtag() {
      return this.etag;
   }

   public LiveChatMessage setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public LiveChatMessage setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public LiveChatMessage setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public LiveChatMessageSnippet getSnippet() {
      return this.snippet;
   }

   public LiveChatMessage setSnippet(LiveChatMessageSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public LiveChatMessage set(String var1, Object var2) {
      return (LiveChatMessage)super.set(var1, var2);
   }

   public LiveChatMessage clone() {
      return (LiveChatMessage)super.clone();
   }
}
