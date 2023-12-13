package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveStreamContentDetails extends GenericJson {
   @Key
   private String closedCaptionsIngestionUrl;
   @Key
   private Boolean isReusable;

   public String getClosedCaptionsIngestionUrl() {
      return this.closedCaptionsIngestionUrl;
   }

   public LiveStreamContentDetails setClosedCaptionsIngestionUrl(String var1) {
      this.closedCaptionsIngestionUrl = var1;
      return this;
   }

   public Boolean getIsReusable() {
      return this.isReusable;
   }

   public LiveStreamContentDetails setIsReusable(Boolean var1) {
      this.isReusable = var1;
      return this;
   }

   public LiveStreamContentDetails set(String var1, Object var2) {
      return (LiveStreamContentDetails)super.set(var1, var2);
   }

   public LiveStreamContentDetails clone() {
      return (LiveStreamContentDetails)super.clone();
   }
}
