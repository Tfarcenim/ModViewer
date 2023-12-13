package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;
import java.util.List;

public final class LiveStreamHealthStatus extends GenericJson {
   @Key
   private List<LiveStreamConfigurationIssue> configurationIssues;
   @Key
   @JsonString
   private BigInteger lastUpdateTimeSeconds;
   @Key
   private String status;

   public List<LiveStreamConfigurationIssue> getConfigurationIssues() {
      return this.configurationIssues;
   }

   public LiveStreamHealthStatus setConfigurationIssues(List<LiveStreamConfigurationIssue> var1) {
      this.configurationIssues = var1;
      return this;
   }

   public BigInteger getLastUpdateTimeSeconds() {
      return this.lastUpdateTimeSeconds;
   }

   public LiveStreamHealthStatus setLastUpdateTimeSeconds(BigInteger var1) {
      this.lastUpdateTimeSeconds = var1;
      return this;
   }

   public String getStatus() {
      return this.status;
   }

   public LiveStreamHealthStatus setStatus(String var1) {
      this.status = var1;
      return this;
   }

   public LiveStreamHealthStatus set(String var1, Object var2) {
      return (LiveStreamHealthStatus)super.set(var1, var2);
   }

   public LiveStreamHealthStatus clone() {
      return (LiveStreamHealthStatus)super.clone();
   }

   static {
      Data.nullOf(LiveStreamConfigurationIssue.class);
   }
}
