package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ChannelSectionTargeting extends GenericJson {
   @Key
   private List<String> countries;
   @Key
   private List<String> languages;
   @Key
   private List<String> regions;

   public List<String> getCountries() {
      return this.countries;
   }

   public ChannelSectionTargeting setCountries(List<String> var1) {
      this.countries = var1;
      return this;
   }

   public List<String> getLanguages() {
      return this.languages;
   }

   public ChannelSectionTargeting setLanguages(List<String> var1) {
      this.languages = var1;
      return this;
   }

   public List<String> getRegions() {
      return this.regions;
   }

   public ChannelSectionTargeting setRegions(List<String> var1) {
      this.regions = var1;
      return this;
   }

   public ChannelSectionTargeting set(String var1, Object var2) {
      return (ChannelSectionTargeting)super.set(var1, var2);
   }

   public ChannelSectionTargeting clone() {
      return (ChannelSectionTargeting)super.clone();
   }
}
