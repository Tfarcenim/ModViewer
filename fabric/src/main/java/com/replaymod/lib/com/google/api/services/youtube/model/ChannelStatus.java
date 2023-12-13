package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ChannelStatus extends GenericJson {
   @Key
   private Boolean isLinked;
   @Key
   private String longUploadsStatus;
   @Key
   private String privacyStatus;

   public Boolean getIsLinked() {
      return this.isLinked;
   }

   public ChannelStatus setIsLinked(Boolean var1) {
      this.isLinked = var1;
      return this;
   }

   public String getLongUploadsStatus() {
      return this.longUploadsStatus;
   }

   public ChannelStatus setLongUploadsStatus(String var1) {
      this.longUploadsStatus = var1;
      return this;
   }

   public String getPrivacyStatus() {
      return this.privacyStatus;
   }

   public ChannelStatus setPrivacyStatus(String var1) {
      this.privacyStatus = var1;
      return this;
   }

   public ChannelStatus set(String var1, Object var2) {
      return (ChannelStatus)super.set(var1, var2);
   }

   public ChannelStatus clone() {
      return (ChannelStatus)super.clone();
   }
}
