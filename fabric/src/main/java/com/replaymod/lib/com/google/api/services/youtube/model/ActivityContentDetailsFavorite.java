package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetailsFavorite extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsFavorite setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ActivityContentDetailsFavorite set(String var1, Object var2) {
      return (ActivityContentDetailsFavorite)super.set(var1, var2);
   }

   public ActivityContentDetailsFavorite clone() {
      return (ActivityContentDetailsFavorite)super.clone();
   }
}
