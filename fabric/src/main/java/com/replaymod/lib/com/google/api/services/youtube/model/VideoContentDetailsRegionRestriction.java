package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class VideoContentDetailsRegionRestriction extends GenericJson {
   @Key
   private List<String> allowed;
   @Key
   private List<String> blocked;

   public List<String> getAllowed() {
      return this.allowed;
   }

   public VideoContentDetailsRegionRestriction setAllowed(List<String> var1) {
      this.allowed = var1;
      return this;
   }

   public List<String> getBlocked() {
      return this.blocked;
   }

   public VideoContentDetailsRegionRestriction setBlocked(List<String> var1) {
      this.blocked = var1;
      return this;
   }

   public VideoContentDetailsRegionRestriction set(String var1, Object var2) {
      return (VideoContentDetailsRegionRestriction)super.set(var1, var2);
   }

   public VideoContentDetailsRegionRestriction clone() {
      return (VideoContentDetailsRegionRestriction)super.clone();
   }
}
