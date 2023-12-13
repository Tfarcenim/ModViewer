package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoProcessingDetailsProcessingProgress extends GenericJson {
   @Key
   @JsonString
   private BigInteger partsProcessed;
   @Key
   @JsonString
   private BigInteger partsTotal;
   @Key
   @JsonString
   private BigInteger timeLeftMs;

   public BigInteger getPartsProcessed() {
      return this.partsProcessed;
   }

   public VideoProcessingDetailsProcessingProgress setPartsProcessed(BigInteger var1) {
      this.partsProcessed = var1;
      return this;
   }

   public BigInteger getPartsTotal() {
      return this.partsTotal;
   }

   public VideoProcessingDetailsProcessingProgress setPartsTotal(BigInteger var1) {
      this.partsTotal = var1;
      return this;
   }

   public BigInteger getTimeLeftMs() {
      return this.timeLeftMs;
   }

   public VideoProcessingDetailsProcessingProgress setTimeLeftMs(BigInteger var1) {
      this.timeLeftMs = var1;
      return this;
   }

   public VideoProcessingDetailsProcessingProgress set(String var1, Object var2) {
      return (VideoProcessingDetailsProcessingProgress)super.set(var1, var2);
   }

   public VideoProcessingDetailsProcessingProgress clone() {
      return (VideoProcessingDetailsProcessingProgress)super.clone();
   }
}
