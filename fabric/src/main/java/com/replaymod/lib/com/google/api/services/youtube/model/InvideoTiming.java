package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class InvideoTiming extends GenericJson {
   @Key
   @JsonString
   private BigInteger durationMs;
   @Key
   @JsonString
   private BigInteger offsetMs;
   @Key
   private String type;

   public BigInteger getDurationMs() {
      return this.durationMs;
   }

   public InvideoTiming setDurationMs(BigInteger var1) {
      this.durationMs = var1;
      return this;
   }

   public BigInteger getOffsetMs() {
      return this.offsetMs;
   }

   public InvideoTiming setOffsetMs(BigInteger var1) {
      this.offsetMs = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public InvideoTiming setType(String var1) {
      this.type = var1;
      return this;
   }

   public InvideoTiming set(String var1, Object var2) {
      return (InvideoTiming)super.set(var1, var2);
   }

   public InvideoTiming clone() {
      return (InvideoTiming)super.clone();
   }
}
