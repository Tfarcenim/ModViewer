package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveBroadcastStatus extends GenericJson {
   @Key
   private String lifeCycleStatus;
   @Key
   private String liveBroadcastPriority;
   @Key
   private String privacyStatus;
   @Key
   private String recordingStatus;

   public String getLifeCycleStatus() {
      return this.lifeCycleStatus;
   }

   public LiveBroadcastStatus setLifeCycleStatus(String var1) {
      this.lifeCycleStatus = var1;
      return this;
   }

   public String getLiveBroadcastPriority() {
      return this.liveBroadcastPriority;
   }

   public LiveBroadcastStatus setLiveBroadcastPriority(String var1) {
      this.liveBroadcastPriority = var1;
      return this;
   }

   public String getPrivacyStatus() {
      return this.privacyStatus;
   }

   public LiveBroadcastStatus setPrivacyStatus(String var1) {
      this.privacyStatus = var1;
      return this;
   }

   public String getRecordingStatus() {
      return this.recordingStatus;
   }

   public LiveBroadcastStatus setRecordingStatus(String var1) {
      this.recordingStatus = var1;
      return this;
   }

   public LiveBroadcastStatus set(String var1, Object var2) {
      return (LiveBroadcastStatus)super.set(var1, var2);
   }

   public LiveBroadcastStatus clone() {
      return (LiveBroadcastStatus)super.clone();
   }
}
