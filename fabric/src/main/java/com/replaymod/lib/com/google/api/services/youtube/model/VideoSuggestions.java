package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class VideoSuggestions extends GenericJson {
   @Key
   private List<String> editorSuggestions;
   @Key
   private List<String> processingErrors;
   @Key
   private List<String> processingHints;
   @Key
   private List<String> processingWarnings;
   @Key
   private List<VideoSuggestionsTagSuggestion> tagSuggestions;

   public List<String> getEditorSuggestions() {
      return this.editorSuggestions;
   }

   public VideoSuggestions setEditorSuggestions(List<String> var1) {
      this.editorSuggestions = var1;
      return this;
   }

   public List<String> getProcessingErrors() {
      return this.processingErrors;
   }

   public VideoSuggestions setProcessingErrors(List<String> var1) {
      this.processingErrors = var1;
      return this;
   }

   public List<String> getProcessingHints() {
      return this.processingHints;
   }

   public VideoSuggestions setProcessingHints(List<String> var1) {
      this.processingHints = var1;
      return this;
   }

   public List<String> getProcessingWarnings() {
      return this.processingWarnings;
   }

   public VideoSuggestions setProcessingWarnings(List<String> var1) {
      this.processingWarnings = var1;
      return this;
   }

   public List<VideoSuggestionsTagSuggestion> getTagSuggestions() {
      return this.tagSuggestions;
   }

   public VideoSuggestions setTagSuggestions(List<VideoSuggestionsTagSuggestion> var1) {
      this.tagSuggestions = var1;
      return this;
   }

   public VideoSuggestions set(String var1, Object var2) {
      return (VideoSuggestions)super.set(var1, var2);
   }

   public VideoSuggestions clone() {
      return (VideoSuggestions)super.clone();
   }
}
