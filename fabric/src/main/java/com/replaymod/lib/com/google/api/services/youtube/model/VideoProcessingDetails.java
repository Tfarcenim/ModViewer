package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class VideoProcessingDetails extends GenericJson {
   @Key
   private String editorSuggestionsAvailability;
   @Key
   private String fileDetailsAvailability;
   @Key
   private String processingFailureReason;
   @Key
   private String processingIssuesAvailability;
   @Key
   private VideoProcessingDetailsProcessingProgress processingProgress;
   @Key
   private String processingStatus;
   @Key
   private String tagSuggestionsAvailability;
   @Key
   private String thumbnailsAvailability;

   public String getEditorSuggestionsAvailability() {
      return this.editorSuggestionsAvailability;
   }

   public VideoProcessingDetails setEditorSuggestionsAvailability(String var1) {
      this.editorSuggestionsAvailability = var1;
      return this;
   }

   public String getFileDetailsAvailability() {
      return this.fileDetailsAvailability;
   }

   public VideoProcessingDetails setFileDetailsAvailability(String var1) {
      this.fileDetailsAvailability = var1;
      return this;
   }

   public String getProcessingFailureReason() {
      return this.processingFailureReason;
   }

   public VideoProcessingDetails setProcessingFailureReason(String var1) {
      this.processingFailureReason = var1;
      return this;
   }

   public String getProcessingIssuesAvailability() {
      return this.processingIssuesAvailability;
   }

   public VideoProcessingDetails setProcessingIssuesAvailability(String var1) {
      this.processingIssuesAvailability = var1;
      return this;
   }

   public VideoProcessingDetailsProcessingProgress getProcessingProgress() {
      return this.processingProgress;
   }

   public VideoProcessingDetails setProcessingProgress(VideoProcessingDetailsProcessingProgress var1) {
      this.processingProgress = var1;
      return this;
   }

   public String getProcessingStatus() {
      return this.processingStatus;
   }

   public VideoProcessingDetails setProcessingStatus(String var1) {
      this.processingStatus = var1;
      return this;
   }

   public String getTagSuggestionsAvailability() {
      return this.tagSuggestionsAvailability;
   }

   public VideoProcessingDetails setTagSuggestionsAvailability(String var1) {
      this.tagSuggestionsAvailability = var1;
      return this;
   }

   public String getThumbnailsAvailability() {
      return this.thumbnailsAvailability;
   }

   public VideoProcessingDetails setThumbnailsAvailability(String var1) {
      this.thumbnailsAvailability = var1;
      return this;
   }

   public VideoProcessingDetails set(String var1, Object var2) {
      return (VideoProcessingDetails)super.set(var1, var2);
   }

   public VideoProcessingDetails clone() {
      return (VideoProcessingDetails)super.clone();
   }
}
