package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class LiveChatFanFundingEventDetails extends GenericJson {
   @Key
   private String amountDisplayString;
   @Key
   @JsonString
   private BigInteger amountMicros;
   @Key
   private String currency;
   @Key
   private String userComment;

   public String getAmountDisplayString() {
      return this.amountDisplayString;
   }

   public LiveChatFanFundingEventDetails setAmountDisplayString(String var1) {
      this.amountDisplayString = var1;
      return this;
   }

   public BigInteger getAmountMicros() {
      return this.amountMicros;
   }

   public LiveChatFanFundingEventDetails setAmountMicros(BigInteger var1) {
      this.amountMicros = var1;
      return this;
   }

   public String getCurrency() {
      return this.currency;
   }

   public LiveChatFanFundingEventDetails setCurrency(String var1) {
      this.currency = var1;
      return this;
   }

   public String getUserComment() {
      return this.userComment;
   }

   public LiveChatFanFundingEventDetails setUserComment(String var1) {
      this.userComment = var1;
      return this;
   }

   public LiveChatFanFundingEventDetails set(String var1, Object var2) {
      return (LiveChatFanFundingEventDetails)super.set(var1, var2);
   }

   public LiveChatFanFundingEventDetails clone() {
      return (LiveChatFanFundingEventDetails)super.clone();
   }
}
