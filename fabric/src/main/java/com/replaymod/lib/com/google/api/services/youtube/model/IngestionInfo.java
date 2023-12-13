package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class IngestionInfo extends GenericJson {
   @Key
   private String backupIngestionAddress;
   @Key
   private String ingestionAddress;
   @Key
   private String streamName;

   public String getBackupIngestionAddress() {
      return this.backupIngestionAddress;
   }

   public IngestionInfo setBackupIngestionAddress(String var1) {
      this.backupIngestionAddress = var1;
      return this;
   }

   public String getIngestionAddress() {
      return this.ingestionAddress;
   }

   public IngestionInfo setIngestionAddress(String var1) {
      this.ingestionAddress = var1;
      return this;
   }

   public String getStreamName() {
      return this.streamName;
   }

   public IngestionInfo setStreamName(String var1) {
      this.streamName = var1;
      return this;
   }

   public IngestionInfo set(String var1, Object var2) {
      return (IngestionInfo)super.set(var1, var2);
   }

   public IngestionInfo clone() {
      return (IngestionInfo)super.clone();
   }
}
