package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetailsBulletin extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsBulletin setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ActivityContentDetailsBulletin set(String var1, Object var2) {
      return (ActivityContentDetailsBulletin)super.set(var1, var2);
   }

   public ActivityContentDetailsBulletin clone() {
      return (ActivityContentDetailsBulletin)super.clone();
   }
}
