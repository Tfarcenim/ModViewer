package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetailsComment extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsComment setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ActivityContentDetailsComment set(String var1, Object var2) {
      return (ActivityContentDetailsComment)super.set(var1, var2);
   }

   public ActivityContentDetailsComment clone() {
      return (ActivityContentDetailsComment)super.clone();
   }
}
