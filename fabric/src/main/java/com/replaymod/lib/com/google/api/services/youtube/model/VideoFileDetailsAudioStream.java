package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoFileDetailsAudioStream extends GenericJson {
   @Key
   @JsonString
   private BigInteger bitrateBps;
   @Key
   private Long channelCount;
   @Key
   private String codec;
   @Key
   private String vendor;

   public BigInteger getBitrateBps() {
      return this.bitrateBps;
   }

   public VideoFileDetailsAudioStream setBitrateBps(BigInteger var1) {
      this.bitrateBps = var1;
      return this;
   }

   public Long getChannelCount() {
      return this.channelCount;
   }

   public VideoFileDetailsAudioStream setChannelCount(Long var1) {
      this.channelCount = var1;
      return this;
   }

   public String getCodec() {
      return this.codec;
   }

   public VideoFileDetailsAudioStream setCodec(String var1) {
      this.codec = var1;
      return this;
   }

   public String getVendor() {
      return this.vendor;
   }

   public VideoFileDetailsAudioStream setVendor(String var1) {
      this.vendor = var1;
      return this;
   }

   public VideoFileDetailsAudioStream set(String var1, Object var2) {
      return (VideoFileDetailsAudioStream)super.set(var1, var2);
   }

   public VideoFileDetailsAudioStream clone() {
      return (VideoFileDetailsAudioStream)super.clone();
   }
}
