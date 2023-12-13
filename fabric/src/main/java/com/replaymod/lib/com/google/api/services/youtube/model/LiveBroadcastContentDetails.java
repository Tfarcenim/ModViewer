package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveBroadcastContentDetails extends GenericJson {
   @Key
   private String boundStreamId;
   @Key
   private DateTime boundStreamLastUpdateTimeMs;
   @Key
   private String closedCaptionsType;
   @Key
   private Boolean enableClosedCaptions;
   @Key
   private Boolean enableContentEncryption;
   @Key
   private Boolean enableDvr;
   @Key
   private Boolean enableEmbed;
   @Key
   private Boolean enableLowLatency;
   @Key
   private MonitorStreamInfo monitorStream;
   @Key
   private String projection;
   @Key
   private Boolean recordFromStart;
   @Key
   private Boolean startWithSlate;

   public String getBoundStreamId() {
      return this.boundStreamId;
   }

   public LiveBroadcastContentDetails setBoundStreamId(String var1) {
      this.boundStreamId = var1;
      return this;
   }

   public DateTime getBoundStreamLastUpdateTimeMs() {
      return this.boundStreamLastUpdateTimeMs;
   }

   public LiveBroadcastContentDetails setBoundStreamLastUpdateTimeMs(DateTime var1) {
      this.boundStreamLastUpdateTimeMs = var1;
      return this;
   }

   public String getClosedCaptionsType() {
      return this.closedCaptionsType;
   }

   public LiveBroadcastContentDetails setClosedCaptionsType(String var1) {
      this.closedCaptionsType = var1;
      return this;
   }

   public Boolean getEnableClosedCaptions() {
      return this.enableClosedCaptions;
   }

   public LiveBroadcastContentDetails setEnableClosedCaptions(Boolean var1) {
      this.enableClosedCaptions = var1;
      return this;
   }

   public Boolean getEnableContentEncryption() {
      return this.enableContentEncryption;
   }

   public LiveBroadcastContentDetails setEnableContentEncryption(Boolean var1) {
      this.enableContentEncryption = var1;
      return this;
   }

   public Boolean getEnableDvr() {
      return this.enableDvr;
   }

   public LiveBroadcastContentDetails setEnableDvr(Boolean var1) {
      this.enableDvr = var1;
      return this;
   }

   public Boolean getEnableEmbed() {
      return this.enableEmbed;
   }

   public LiveBroadcastContentDetails setEnableEmbed(Boolean var1) {
      this.enableEmbed = var1;
      return this;
   }

   public Boolean getEnableLowLatency() {
      return this.enableLowLatency;
   }

   public LiveBroadcastContentDetails setEnableLowLatency(Boolean var1) {
      this.enableLowLatency = var1;
      return this;
   }

   public MonitorStreamInfo getMonitorStream() {
      return this.monitorStream;
   }

   public LiveBroadcastContentDetails setMonitorStream(MonitorStreamInfo var1) {
      this.monitorStream = var1;
      return this;
   }

   public String getProjection() {
      return this.projection;
   }

   public LiveBroadcastContentDetails setProjection(String var1) {
      this.projection = var1;
      return this;
   }

   public Boolean getRecordFromStart() {
      return this.recordFromStart;
   }

   public LiveBroadcastContentDetails setRecordFromStart(Boolean var1) {
      this.recordFromStart = var1;
      return this;
   }

   public Boolean getStartWithSlate() {
      return this.startWithSlate;
   }

   public LiveBroadcastContentDetails setStartWithSlate(Boolean var1) {
      this.startWithSlate = var1;
      return this;
   }

   public LiveBroadcastContentDetails set(String var1, Object var2) {
      return (LiveBroadcastContentDetails)super.set(var1, var2);
   }

   public LiveBroadcastContentDetails clone() {
      return (LiveBroadcastContentDetails)super.clone();
   }
}
