package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class CdnSettings extends GenericJson {
   @Key
   private String format;
   @Key
   private String frameRate;
   @Key
   private IngestionInfo ingestionInfo;
   @Key
   private String ingestionType;
   @Key
   private String resolution;

   public String getFormat() {
      return this.format;
   }

   public CdnSettings setFormat(String var1) {
      this.format = var1;
      return this;
   }

   public String getFrameRate() {
      return this.frameRate;
   }

   public CdnSettings setFrameRate(String var1) {
      this.frameRate = var1;
      return this;
   }

   public IngestionInfo getIngestionInfo() {
      return this.ingestionInfo;
   }

   public CdnSettings setIngestionInfo(IngestionInfo var1) {
      this.ingestionInfo = var1;
      return this;
   }

   public String getIngestionType() {
      return this.ingestionType;
   }

   public CdnSettings setIngestionType(String var1) {
      this.ingestionType = var1;
      return this;
   }

   public String getResolution() {
      return this.resolution;
   }

   public CdnSettings setResolution(String var1) {
      this.resolution = var1;
      return this;
   }

   public CdnSettings set(String var1, Object var2) {
      return (CdnSettings)super.set(var1, var2);
   }

   public CdnSettings clone() {
      return (CdnSettings)super.clone();
   }
}
