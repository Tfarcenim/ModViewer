package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetailsLike extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsLike setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ActivityContentDetailsLike set(String var1, Object var2) {
      return (ActivityContentDetailsLike)super.set(var1, var2);
   }

   public ActivityContentDetailsLike clone() {
      return (ActivityContentDetailsLike)super.clone();
   }
}
