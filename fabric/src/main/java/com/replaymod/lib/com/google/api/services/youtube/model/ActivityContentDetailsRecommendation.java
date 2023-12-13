package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetailsRecommendation extends GenericJson {
   @Key
   private String reason;
   @Key
   private ResourceId resourceId;
   @Key
   private ResourceId seedResourceId;

   public String getReason() {
      return this.reason;
   }

   public ActivityContentDetailsRecommendation setReason(String var1) {
      this.reason = var1;
      return this;
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsRecommendation setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ResourceId getSeedResourceId() {
      return this.seedResourceId;
   }

   public ActivityContentDetailsRecommendation setSeedResourceId(ResourceId var1) {
      this.seedResourceId = var1;
      return this;
   }

   public ActivityContentDetailsRecommendation set(String var1, Object var2) {
      return (ActivityContentDetailsRecommendation)super.set(var1, var2);
   }

   public ActivityContentDetailsRecommendation clone() {
      return (ActivityContentDetailsRecommendation)super.clone();
   }
}
