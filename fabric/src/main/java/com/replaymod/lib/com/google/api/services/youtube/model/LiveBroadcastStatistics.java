package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class LiveBroadcastStatistics extends GenericJson {
   @Key
   @JsonString
   private BigInteger concurrentViewers;
   @Key
   @JsonString
   private BigInteger totalChatCount;

   public BigInteger getConcurrentViewers() {
      return this.concurrentViewers;
   }

   public LiveBroadcastStatistics setConcurrentViewers(BigInteger var1) {
      this.concurrentViewers = var1;
      return this;
   }

   public BigInteger getTotalChatCount() {
      return this.totalChatCount;
   }

   public LiveBroadcastStatistics setTotalChatCount(BigInteger var1) {
      this.totalChatCount = var1;
      return this;
   }

   public LiveBroadcastStatistics set(String var1, Object var2) {
      return (LiveBroadcastStatistics)super.set(var1, var2);
   }

   public LiveBroadcastStatistics clone() {
      return (LiveBroadcastStatistics)super.clone();
   }
}
