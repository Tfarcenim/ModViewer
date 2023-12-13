package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveBroadcastTopicSnippet extends GenericJson {
   @Key
   private String name;
   @Key
   private String releaseDate;

   public String getName() {
      return this.name;
   }

   public LiveBroadcastTopicSnippet setName(String var1) {
      this.name = var1;
      return this;
   }

   public String getReleaseDate() {
      return this.releaseDate;
   }

   public LiveBroadcastTopicSnippet setReleaseDate(String var1) {
      this.releaseDate = var1;
      return this;
   }

   public LiveBroadcastTopicSnippet set(String var1, Object var2) {
      return (LiveBroadcastTopicSnippet)super.set(var1, var2);
   }

   public LiveBroadcastTopicSnippet clone() {
      return (LiveBroadcastTopicSnippet)super.clone();
   }
}
