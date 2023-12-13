package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ActivityContentDetailsChannelItem extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsChannelItem setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ActivityContentDetailsChannelItem set(String var1, Object var2) {
      return (ActivityContentDetailsChannelItem)super.set(var1, var2);
   }

   public ActivityContentDetailsChannelItem clone() {
      return (ActivityContentDetailsChannelItem)super.clone();
   }
}
