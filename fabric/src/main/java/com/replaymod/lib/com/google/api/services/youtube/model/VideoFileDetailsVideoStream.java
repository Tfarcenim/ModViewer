package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoFileDetailsVideoStream extends GenericJson {
   @Key
   private Double aspectRatio;
   @Key
   @JsonString
   private BigInteger bitrateBps;
   @Key
   private String codec;
   @Key
   private Double frameRateFps;
   @Key
   private Long heightPixels;
   @Key
   private String rotation;
   @Key
   private String vendor;
   @Key
   private Long widthPixels;

   public Double getAspectRatio() {
      return this.aspectRatio;
   }

   public VideoFileDetailsVideoStream setAspectRatio(Double var1) {
      this.aspectRatio = var1;
      return this;
   }

   public BigInteger getBitrateBps() {
      return this.bitrateBps;
   }

   public VideoFileDetailsVideoStream setBitrateBps(BigInteger var1) {
      this.bitrateBps = var1;
      return this;
   }

   public String getCodec() {
      return this.codec;
   }

   public VideoFileDetailsVideoStream setCodec(String var1) {
      this.codec = var1;
      return this;
   }

   public Double getFrameRateFps() {
      return this.frameRateFps;
   }

   public VideoFileDetailsVideoStream setFrameRateFps(Double var1) {
      this.frameRateFps = var1;
      return this;
   }

   public Long getHeightPixels() {
      return this.heightPixels;
   }

   public VideoFileDetailsVideoStream setHeightPixels(Long var1) {
      this.heightPixels = var1;
      return this;
   }

   public String getRotation() {
      return this.rotation;
   }

   public VideoFileDetailsVideoStream setRotation(String var1) {
      this.rotation = var1;
      return this;
   }

   public String getVendor() {
      return this.vendor;
   }

   public VideoFileDetailsVideoStream setVendor(String var1) {
      this.vendor = var1;
      return this;
   }

   public Long getWidthPixels() {
      return this.widthPixels;
   }

   public VideoFileDetailsVideoStream setWidthPixels(Long var1) {
      this.widthPixels = var1;
      return this;
   }

   public VideoFileDetailsVideoStream set(String var1, Object var2) {
      return (VideoFileDetailsVideoStream)super.set(var1, var2);
   }

   public VideoFileDetailsVideoStream clone() {
      return (VideoFileDetailsVideoStream)super.clone();
   }
}
