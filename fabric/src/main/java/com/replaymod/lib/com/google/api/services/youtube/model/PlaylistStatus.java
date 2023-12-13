package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class PlaylistStatus extends GenericJson {
   @Key
   private String privacyStatus;

   public String getPrivacyStatus() {
      return this.privacyStatus;
   }

   public PlaylistStatus setPrivacyStatus(String var1) {
      this.privacyStatus = var1;
      return this;
   }

   public PlaylistStatus set(String var1, Object var2) {
      return (PlaylistStatus)super.set(var1, var2);
   }

   public PlaylistStatus clone() {
      return (PlaylistStatus)super.clone();
   }
}
