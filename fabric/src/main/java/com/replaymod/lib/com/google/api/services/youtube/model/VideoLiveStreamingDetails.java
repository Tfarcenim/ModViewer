package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoLiveStreamingDetails extends GenericJson {
   @Key
   private String activeLiveChatId;
   @Key
   private DateTime actualEndTime;
   @Key
   private DateTime actualStartTime;
   @Key
   @JsonString
   private BigInteger concurrentViewers;
   @Key
   private DateTime scheduledEndTime;
   @Key
   private DateTime scheduledStartTime;

   public String getActiveLiveChatId() {
      return this.activeLiveChatId;
   }

   public VideoLiveStreamingDetails setActiveLiveChatId(String var1) {
      this.activeLiveChatId = var1;
      return this;
   }

   public DateTime getActualEndTime() {
      return this.actualEndTime;
   }

   public VideoLiveStreamingDetails setActualEndTime(DateTime var1) {
      this.actualEndTime = var1;
      return this;
   }

   public DateTime getActualStartTime() {
      return this.actualStartTime;
   }

   public VideoLiveStreamingDetails setActualStartTime(DateTime var1) {
      this.actualStartTime = var1;
      return this;
   }

   public BigInteger getConcurrentViewers() {
      return this.concurrentViewers;
   }

   public VideoLiveStreamingDetails setConcurrentViewers(BigInteger var1) {
      this.concurrentViewers = var1;
      return this;
   }

   public DateTime getScheduledEndTime() {
      return this.scheduledEndTime;
   }

   public VideoLiveStreamingDetails setScheduledEndTime(DateTime var1) {
      this.scheduledEndTime = var1;
      return this;
   }

   public DateTime getScheduledStartTime() {
      return this.scheduledStartTime;
   }

   public VideoLiveStreamingDetails setScheduledStartTime(DateTime var1) {
      this.scheduledStartTime = var1;
      return this;
   }

   public VideoLiveStreamingDetails set(String var1, Object var2) {
      return (VideoLiveStreamingDetails)super.set(var1, var2);
   }

   public VideoLiveStreamingDetails clone() {
      return (VideoLiveStreamingDetails)super.clone();
   }
}
