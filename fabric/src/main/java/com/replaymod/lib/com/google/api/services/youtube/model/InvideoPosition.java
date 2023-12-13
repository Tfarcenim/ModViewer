package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class InvideoPosition extends GenericJson {
   @Key
   private String cornerPosition;
   @Key
   private String type;

   public String getCornerPosition() {
      return this.cornerPosition;
   }

   public InvideoPosition setCornerPosition(String var1) {
      this.cornerPosition = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public InvideoPosition setType(String var1) {
      this.type = var1;
      return this;
   }

   public InvideoPosition set(String var1, Object var2) {
      return (InvideoPosition)super.set(var1, var2);
   }

   public InvideoPosition clone() {
      return (InvideoPosition)super.clone();
   }
}
