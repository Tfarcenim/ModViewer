package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class SponsorSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private ChannelProfileDetails sponsorDetails;
   @Key
   private DateTime sponsorSince;

   public String getChannelId() {
      return this.channelId;
   }

   public SponsorSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public ChannelProfileDetails getSponsorDetails() {
      return this.sponsorDetails;
   }

   public SponsorSnippet setSponsorDetails(ChannelProfileDetails var1) {
      this.sponsorDetails = var1;
      return this;
   }

   public DateTime getSponsorSince() {
      return this.sponsorSince;
   }

   public SponsorSnippet setSponsorSince(DateTime var1) {
      this.sponsorSince = var1;
      return this;
   }

   public SponsorSnippet set(String var1, Object var2) {
      return (SponsorSnippet)super.set(var1, var2);
   }

   public SponsorSnippet clone() {
      return (SponsorSnippet)super.clone();
   }
}
