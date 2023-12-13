package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class SubscriptionContentDetails extends GenericJson {
   @Key
   private String activityType;
   @Key
   private Long newItemCount;
   @Key
   private Long totalItemCount;

   public String getActivityType() {
      return this.activityType;
   }

   public SubscriptionContentDetails setActivityType(String var1) {
      this.activityType = var1;
      return this;
   }

   public Long getNewItemCount() {
      return this.newItemCount;
   }

   public SubscriptionContentDetails setNewItemCount(Long var1) {
      this.newItemCount = var1;
      return this;
   }

   public Long getTotalItemCount() {
      return this.totalItemCount;
   }

   public SubscriptionContentDetails setTotalItemCount(Long var1) {
      this.totalItemCount = var1;
      return this;
   }

   public SubscriptionContentDetails set(String var1, Object var2) {
      return (SubscriptionContentDetails)super.set(var1, var2);
   }

   public SubscriptionContentDetails clone() {
      return (SubscriptionContentDetails)super.clone();
   }
}
