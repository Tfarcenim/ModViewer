package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Base64;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class InvideoBranding extends GenericJson {
   @Key
   private String imageBytes;
   @Key
   private String imageUrl;
   @Key
   private InvideoPosition position;
   @Key
   private String targetChannelId;
   @Key
   private InvideoTiming timing;

   public String getImageBytes() {
      return this.imageBytes;
   }

   public byte[] decodeImageBytes() {
      return Base64.decodeBase64(this.imageBytes);
   }

   public InvideoBranding setImageBytes(String var1) {
      this.imageBytes = var1;
      return this;
   }

   public InvideoBranding encodeImageBytes(byte[] var1) {
      this.imageBytes = Base64.encodeBase64URLSafeString(var1);
      return this;
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public InvideoBranding setImageUrl(String var1) {
      this.imageUrl = var1;
      return this;
   }

   public InvideoPosition getPosition() {
      return this.position;
   }

   public InvideoBranding setPosition(InvideoPosition var1) {
      this.position = var1;
      return this;
   }

   public String getTargetChannelId() {
      return this.targetChannelId;
   }

   public InvideoBranding setTargetChannelId(String var1) {
      this.targetChannelId = var1;
      return this;
   }

   public InvideoTiming getTiming() {
      return this.timing;
   }

   public InvideoBranding setTiming(InvideoTiming var1) {
      this.timing = var1;
      return this;
   }

   public InvideoBranding set(String var1, Object var2) {
      return (InvideoBranding)super.set(var1, var2);
   }

   public InvideoBranding clone() {
      return (InvideoBranding)super.clone();
   }
}
