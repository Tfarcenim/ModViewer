package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ChannelSectionContentDetails extends GenericJson {
   @Key
   private List<String> channels;
   @Key
   private List<String> playlists;

   public List<String> getChannels() {
      return this.channels;
   }

   public ChannelSectionContentDetails setChannels(List<String> var1) {
      this.channels = var1;
      return this;
   }

   public List<String> getPlaylists() {
      return this.playlists;
   }

   public ChannelSectionContentDetails setPlaylists(List<String> var1) {
      this.playlists = var1;
      return this;
   }

   public ChannelSectionContentDetails set(String var1, Object var2) {
      return (ChannelSectionContentDetails)super.set(var1, var2);
   }

   public ChannelSectionContentDetails clone() {
      return (ChannelSectionContentDetails)super.clone();
   }
}
