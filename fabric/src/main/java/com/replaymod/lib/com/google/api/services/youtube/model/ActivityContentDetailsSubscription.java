package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetailsSubscription extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsSubscription setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ActivityContentDetailsSubscription set(String var1, Object var2) {
      return (ActivityContentDetailsSubscription)super.set(var1, var2);
   }

   public ActivityContentDetailsSubscription clone() {
      return (ActivityContentDetailsSubscription)super.clone();
   }
}
