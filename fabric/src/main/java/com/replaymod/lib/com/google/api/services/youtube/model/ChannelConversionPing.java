package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ChannelConversionPing extends GenericJson {
   @Key
   private String context;
   @Key
   private String conversionUrl;

   public String getContext() {
      return this.context;
   }

   public ChannelConversionPing setContext(String var1) {
      this.context = var1;
      return this;
   }

   public String getConversionUrl() {
      return this.conversionUrl;
   }

   public ChannelConversionPing setConversionUrl(String var1) {
      this.conversionUrl = var1;
      return this;
   }

   public ChannelConversionPing set(String var1, Object var2) {
      return (ChannelConversionPing)super.set(var1, var2);
   }

   public ChannelConversionPing clone() {
      return (ChannelConversionPing)super.clone();
   }
}
