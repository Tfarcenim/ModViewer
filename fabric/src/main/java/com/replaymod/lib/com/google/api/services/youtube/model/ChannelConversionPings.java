package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ChannelConversionPings extends GenericJson {
   @Key
   private List<ChannelConversionPing> pings;

   public List<ChannelConversionPing> getPings() {
      return this.pings;
   }

   public ChannelConversionPings setPings(List<ChannelConversionPing> var1) {
      this.pings = var1;
      return this;
   }

   public ChannelConversionPings set(String var1, Object var2) {
      return (ChannelConversionPings)super.set(var1, var2);
   }

   public ChannelConversionPings clone() {
      return (ChannelConversionPings)super.clone();
   }

   static {
      Data.nullOf(ChannelConversionPing.class);
   }
}
