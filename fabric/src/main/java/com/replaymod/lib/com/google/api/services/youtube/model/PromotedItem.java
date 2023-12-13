package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class PromotedItem extends GenericJson {
   @Key
   private String customMessage;
   @Key
   private PromotedItemId id;
   @Key
   private Boolean promotedByContentOwner;
   @Key
   private InvideoTiming timing;

   public String getCustomMessage() {
      return this.customMessage;
   }

   public PromotedItem setCustomMessage(String var1) {
      this.customMessage = var1;
      return this;
   }

   public PromotedItemId getId() {
      return this.id;
   }

   public PromotedItem setId(PromotedItemId var1) {
      this.id = var1;
      return this;
   }

   public Boolean getPromotedByContentOwner() {
      return this.promotedByContentOwner;
   }

   public PromotedItem setPromotedByContentOwner(Boolean var1) {
      this.promotedByContentOwner = var1;
      return this;
   }

   public InvideoTiming getTiming() {
      return this.timing;
   }

   public PromotedItem setTiming(InvideoTiming var1) {
      this.timing = var1;
      return this;
   }

   public PromotedItem set(String var1, Object var2) {
      return (PromotedItem)super.set(var1, var2);
   }

   public PromotedItem clone() {
      return (PromotedItem)super.clone();
   }
}
