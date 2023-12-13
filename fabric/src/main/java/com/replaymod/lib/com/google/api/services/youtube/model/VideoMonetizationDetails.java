package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class VideoMonetizationDetails extends GenericJson {
   @Key
   private AccessPolicy access;

   public AccessPolicy getAccess() {
      return this.access;
   }

   public VideoMonetizationDetails setAccess(AccessPolicy var1) {
      this.access = var1;
      return this;
   }

   public VideoMonetizationDetails set(String var1, Object var2) {
      return (VideoMonetizationDetails)super.set(var1, var2);
   }

   public VideoMonetizationDetails clone() {
      return (VideoMonetizationDetails)super.clone();
   }
}
