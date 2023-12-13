package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.Map;

public final class Playlist extends GenericJson {
   @Key
   private PlaylistContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private Map<String, PlaylistLocalization> localizations;
   @Key
   private PlaylistPlayer player;
   @Key
   private PlaylistSnippet snippet;
   @Key
   private PlaylistStatus status;

   public PlaylistContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public Playlist setContentDetails(PlaylistContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public String getEtag() {
      return this.etag;
   }

   public Playlist setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public Playlist setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public Playlist setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Map<String, PlaylistLocalization> getLocalizations() {
      return this.localizations;
   }

   public Playlist setLocalizations(Map<String, PlaylistLocalization> var1) {
      this.localizations = var1;
      return this;
   }

   public PlaylistPlayer getPlayer() {
      return this.player;
   }

   public Playlist setPlayer(PlaylistPlayer var1) {
      this.player = var1;
      return this;
   }

   public PlaylistSnippet getSnippet() {
      return this.snippet;
   }

   public Playlist setSnippet(PlaylistSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public PlaylistStatus getStatus() {
      return this.status;
   }

   public Playlist setStatus(PlaylistStatus var1) {
      this.status = var1;
      return this;
   }

   public Playlist set(String var1, Object var2) {
      return (Playlist)super.set(var1, var2);
   }

   public Playlist clone() {
      return (Playlist)super.clone();
   }
}
