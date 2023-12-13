package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class FanFundingEventSnippet extends GenericJson {
   @Key
   @JsonString
   private BigInteger amountMicros;
   @Key
   private String channelId;
   @Key
   private String commentText;
   @Key
   private DateTime createdAt;
   @Key
   private String currency;
   @Key
   private String displayString;
   @Key
   private ChannelProfileDetails supporterDetails;

   public BigInteger getAmountMicros() {
      return this.amountMicros;
   }

   public FanFundingEventSnippet setAmountMicros(BigInteger var1) {
      this.amountMicros = var1;
      return this;
   }

   public String getChannelId() {
      return this.channelId;
   }

   public FanFundingEventSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public String getCommentText() {
      return this.commentText;
   }

   public FanFundingEventSnippet setCommentText(String var1) {
      this.commentText = var1;
      return this;
   }

   public DateTime getCreatedAt() {
      return this.createdAt;
   }

   public FanFundingEventSnippet setCreatedAt(DateTime var1) {
      this.createdAt = var1;
      return this;
   }

   public String getCurrency() {
      return this.currency;
   }

   public FanFundingEventSnippet setCurrency(String var1) {
      this.currency = var1;
      return this;
   }

   public String getDisplayString() {
      return this.displayString;
   }

   public FanFundingEventSnippet setDisplayString(String var1) {
      this.displayString = var1;
      return this;
   }

   public ChannelProfileDetails getSupporterDetails() {
      return this.supporterDetails;
   }

   public FanFundingEventSnippet setSupporterDetails(ChannelProfileDetails var1) {
      this.supporterDetails = var1;
      return this;
   }

   public FanFundingEventSnippet set(String var1, Object var2) {
      return (FanFundingEventSnippet)super.set(var1, var2);
   }

   public FanFundingEventSnippet clone() {
      return (FanFundingEventSnippet)super.clone();
   }
}
