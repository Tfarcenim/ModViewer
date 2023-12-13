package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveStreamConfigurationIssue extends GenericJson {
   @Key
   private String description;
   @Key
   private String reason;
   @Key
   private String severity;
   @Key
   private String type;

   public String getDescription() {
      return this.description;
   }

   public LiveStreamConfigurationIssue setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public String getReason() {
      return this.reason;
   }

   public LiveStreamConfigurationIssue setReason(String var1) {
      this.reason = var1;
      return this;
   }

   public String getSeverity() {
      return this.severity;
   }

   public LiveStreamConfigurationIssue setSeverity(String var1) {
      this.severity = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public LiveStreamConfigurationIssue setType(String var1) {
      this.type = var1;
      return this;
   }

   public LiveStreamConfigurationIssue set(String var1, Object var2) {
      return (LiveStreamConfigurationIssue)super.set(var1, var2);
   }

   public LiveStreamConfigurationIssue clone() {
      return (LiveStreamConfigurationIssue)super.clone();
   }
}
