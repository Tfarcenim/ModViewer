package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class VideoSuggestionsTagSuggestion extends GenericJson {
   @Key
   private List<String> categoryRestricts;
   @Key
   private String tag;

   public List<String> getCategoryRestricts() {
      return this.categoryRestricts;
   }

   public VideoSuggestionsTagSuggestion setCategoryRestricts(List<String> var1) {
      this.categoryRestricts = var1;
      return this;
   }

   public String getTag() {
      return this.tag;
   }

   public VideoSuggestionsTagSuggestion setTag(String var1) {
      this.tag = var1;
      return this;
   }

   public VideoSuggestionsTagSuggestion set(String var1, Object var2) {
      return (VideoSuggestionsTagSuggestion)super.set(var1, var2);
   }

   public VideoSuggestionsTagSuggestion clone() {
      return (VideoSuggestionsTagSuggestion)super.clone();
   }
}
