package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class InvideoPromotion extends GenericJson {
   @Key
   private InvideoTiming defaultTiming;
   @Key
   private List<PromotedItem> items;
   @Key
   private InvideoPosition position;
   @Key
   private Boolean useSmartTiming;

   public InvideoTiming getDefaultTiming() {
      return this.defaultTiming;
   }

   public InvideoPromotion setDefaultTiming(InvideoTiming var1) {
      this.defaultTiming = var1;
      return this;
   }

   public List<PromotedItem> getItems() {
      return this.items;
   }

   public InvideoPromotion setItems(List<PromotedItem> var1) {
      this.items = var1;
      return this;
   }

   public InvideoPosition getPosition() {
      return this.position;
   }

   public InvideoPromotion setPosition(InvideoPosition var1) {
      this.position = var1;
      return this;
   }

   public Boolean getUseSmartTiming() {
      return this.useSmartTiming;
   }

   public InvideoPromotion setUseSmartTiming(Boolean var1) {
      this.useSmartTiming = var1;
      return this;
   }

   public InvideoPromotion set(String var1, Object var2) {
      return (InvideoPromotion)super.set(var1, var2);
   }

   public InvideoPromotion clone() {
      return (InvideoPromotion)super.clone();
   }
}
