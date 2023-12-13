package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.Map;

public final class Video extends GenericJson {
   @Key
   private VideoAgeGating ageGating;
   @Key
   private VideoContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private VideoFileDetails fileDetails;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private VideoLiveStreamingDetails liveStreamingDetails;
   @Key
   private Map<String, VideoLocalization> localizations;
   @Key
   private VideoMonetizationDetails monetizationDetails;
   @Key
   private VideoPlayer player;
   @Key
   private VideoProcessingDetails processingDetails;
   @Key
   private VideoProjectDetails projectDetails;
   @Key
   private VideoRecordingDetails recordingDetails;
   @Key
   private VideoSnippet snippet;
   @Key
   private VideoStatistics statistics;
   @Key
   private VideoStatus status;
   @Key
   private VideoSuggestions suggestions;
   @Key
   private VideoTopicDetails topicDetails;

   public VideoAgeGating getAgeGating() {
      return this.ageGating;
   }

   public Video setAgeGating(VideoAgeGating var1) {
      this.ageGating = var1;
      return this;
   }

   public VideoContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public Video setContentDetails(VideoContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public String getEtag() {
      return this.etag;
   }

   public Video setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public VideoFileDetails getFileDetails() {
      return this.fileDetails;
   }

   public Video setFileDetails(VideoFileDetails var1) {
      this.fileDetails = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public Video setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public Video setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public VideoLiveStreamingDetails getLiveStreamingDetails() {
      return this.liveStreamingDetails;
   }

   public Video setLiveStreamingDetails(VideoLiveStreamingDetails var1) {
      this.liveStreamingDetails = var1;
      return this;
   }

   public Map<String, VideoLocalization> getLocalizations() {
      return this.localizations;
   }

   public Video setLocalizations(Map<String, VideoLocalization> var1) {
      this.localizations = var1;
      return this;
   }

   public VideoMonetizationDetails getMonetizationDetails() {
      return this.monetizationDetails;
   }

   public Video setMonetizationDetails(VideoMonetizationDetails var1) {
      this.monetizationDetails = var1;
      return this;
   }

   public VideoPlayer getPlayer() {
      return this.player;
   }

   public Video setPlayer(VideoPlayer var1) {
      this.player = var1;
      return this;
   }

   public VideoProcessingDetails getProcessingDetails() {
      return this.processingDetails;
   }

   public Video setProcessingDetails(VideoProcessingDetails var1) {
      this.processingDetails = var1;
      return this;
   }

   public VideoProjectDetails getProjectDetails() {
      return this.projectDetails;
   }

   public Video setProjectDetails(VideoProjectDetails var1) {
      this.projectDetails = var1;
      return this;
   }

   public VideoRecordingDetails getRecordingDetails() {
      return this.recordingDetails;
   }

   public Video setRecordingDetails(VideoRecordingDetails var1) {
      this.recordingDetails = var1;
      return this;
   }

   public VideoSnippet getSnippet() {
      return this.snippet;
   }

   public Video setSnippet(VideoSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public VideoStatistics getStatistics() {
      return this.statistics;
   }

   public Video setStatistics(VideoStatistics var1) {
      this.statistics = var1;
      return this;
   }

   public VideoStatus getStatus() {
      return this.status;
   }

   public Video setStatus(VideoStatus var1) {
      this.status = var1;
      return this;
   }

   public VideoSuggestions getSuggestions() {
      return this.suggestions;
   }

   public Video setSuggestions(VideoSuggestions var1) {
      this.suggestions = var1;
      return this;
   }

   public VideoTopicDetails getTopicDetails() {
      return this.topicDetails;
   }

   public Video setTopicDetails(VideoTopicDetails var1) {
      this.topicDetails = var1;
      return this;
   }

   public Video set(String var1, Object var2) {
      return (Video)super.set(var1, var2);
   }

   public Video clone() {
      return (Video)super.clone();
   }
}
