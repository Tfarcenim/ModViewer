package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class MonitorStreamInfo extends GenericJson {
   @Key
   private Long broadcastStreamDelayMs;
   @Key
   private String embedHtml;
   @Key
   private Boolean enableMonitorStream;

   public Long getBroadcastStreamDelayMs() {
      return this.broadcastStreamDelayMs;
   }

   public MonitorStreamInfo setBroadcastStreamDelayMs(Long var1) {
      this.broadcastStreamDelayMs = var1;
      return this;
   }

   public String getEmbedHtml() {
      return this.embedHtml;
   }

   public MonitorStreamInfo setEmbedHtml(String var1) {
      this.embedHtml = var1;
      return this;
   }

   public Boolean getEnableMonitorStream() {
      return this.enableMonitorStream;
   }

   public MonitorStreamInfo setEnableMonitorStream(Boolean var1) {
      this.enableMonitorStream = var1;
      return this;
   }

   public MonitorStreamInfo set(String var1, Object var2) {
      return (MonitorStreamInfo)super.set(var1, var2);
   }

   public MonitorStreamInfo clone() {
      return (MonitorStreamInfo)super.clone();
   }
}
