package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LiveChatMessageSnippet extends GenericJson {
   @Key
   private String authorChannelId;
   @Key
   private String displayMessage;
   @Key
   private LiveChatFanFundingEventDetails fanFundingEventDetails;
   @Key
   private Boolean hasDisplayContent;
   @Key
   private String liveChatId;
   @Key
   private LiveChatMessageDeletedDetails messageDeletedDetails;
   @Key
   private LiveChatMessageRetractedDetails messageRetractedDetails;
   @Key
   private LiveChatPollClosedDetails pollClosedDetails;
   @Key
   private LiveChatPollEditedDetails pollEditedDetails;
   @Key
   private LiveChatPollOpenedDetails pollOpenedDetails;
   @Key
   private LiveChatPollVotedDetails pollVotedDetails;
   @Key
   private DateTime publishedAt;
   @Key
   private LiveChatTextMessageDetails textMessageDetails;
   @Key
   private String type;
   @Key
   private LiveChatUserBannedMessageDetails userBannedDetails;

   public String getAuthorChannelId() {
      return this.authorChannelId;
   }

   public LiveChatMessageSnippet setAuthorChannelId(String var1) {
      this.authorChannelId = var1;
      return this;
   }

   public String getDisplayMessage() {
      return this.displayMessage;
   }

   public LiveChatMessageSnippet setDisplayMessage(String var1) {
      this.displayMessage = var1;
      return this;
   }

   public LiveChatFanFundingEventDetails getFanFundingEventDetails() {
      return this.fanFundingEventDetails;
   }

   public LiveChatMessageSnippet setFanFundingEventDetails(LiveChatFanFundingEventDetails var1) {
      this.fanFundingEventDetails = var1;
      return this;
   }

   public Boolean getHasDisplayContent() {
      return this.hasDisplayContent;
   }

   public LiveChatMessageSnippet setHasDisplayContent(Boolean var1) {
      this.hasDisplayContent = var1;
      return this;
   }

   public String getLiveChatId() {
      return this.liveChatId;
   }

   public LiveChatMessageSnippet setLiveChatId(String var1) {
      this.liveChatId = var1;
      return this;
   }

   public LiveChatMessageDeletedDetails getMessageDeletedDetails() {
      return this.messageDeletedDetails;
   }

   public LiveChatMessageSnippet setMessageDeletedDetails(LiveChatMessageDeletedDetails var1) {
      this.messageDeletedDetails = var1;
      return this;
   }

   public LiveChatMessageRetractedDetails getMessageRetractedDetails() {
      return this.messageRetractedDetails;
   }

   public LiveChatMessageSnippet setMessageRetractedDetails(LiveChatMessageRetractedDetails var1) {
      this.messageRetractedDetails = var1;
      return this;
   }

   public LiveChatPollClosedDetails getPollClosedDetails() {
      return this.pollClosedDetails;
   }

   public LiveChatMessageSnippet setPollClosedDetails(LiveChatPollClosedDetails var1) {
      this.pollClosedDetails = var1;
      return this;
   }

   public LiveChatPollEditedDetails getPollEditedDetails() {
      return this.pollEditedDetails;
   }

   public LiveChatMessageSnippet setPollEditedDetails(LiveChatPollEditedDetails var1) {
      this.pollEditedDetails = var1;
      return this;
   }

   public LiveChatPollOpenedDetails getPollOpenedDetails() {
      return this.pollOpenedDetails;
   }

   public LiveChatMessageSnippet setPollOpenedDetails(LiveChatPollOpenedDetails var1) {
      this.pollOpenedDetails = var1;
      return this;
   }

   public LiveChatPollVotedDetails getPollVotedDetails() {
      return this.pollVotedDetails;
   }

   public LiveChatMessageSnippet setPollVotedDetails(LiveChatPollVotedDetails var1) {
      this.pollVotedDetails = var1;
      return this;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public LiveChatMessageSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public LiveChatTextMessageDetails getTextMessageDetails() {
      return this.textMessageDetails;
   }

   public LiveChatMessageSnippet setTextMessageDetails(LiveChatTextMessageDetails var1) {
      this.textMessageDetails = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public LiveChatMessageSnippet setType(String var1) {
      this.type = var1;
      return this;
   }

   public LiveChatUserBannedMessageDetails getUserBannedDetails() {
      return this.userBannedDetails;
   }

   public LiveChatMessageSnippet setUserBannedDetails(LiveChatUserBannedMessageDetails var1) {
      this.userBannedDetails = var1;
      return this;
   }

   public LiveChatMessageSnippet set(String var1, Object var2) {
      return (LiveChatMessageSnippet)super.set(var1, var2);
   }

   public LiveChatMessageSnippet clone() {
      return (LiveChatMessageSnippet)super.clone();
   }
}
