package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class LocalizedProperty extends GenericJson {
   @Key("default")
   private String default__;
   @Key
   private LanguageTag defaultLanguage;
   @Key
   private List<LocalizedString> localized;

   public String getDefault() {
      return this.default__;
   }

   public LocalizedProperty setDefault(String var1) {
      this.default__ = var1;
      return this;
   }

   public LanguageTag getDefaultLanguage() {
      return this.defaultLanguage;
   }

   public LocalizedProperty setDefaultLanguage(LanguageTag var1) {
      this.defaultLanguage = var1;
      return this;
   }

   public List<LocalizedString> getLocalized() {
      return this.localized;
   }

   public LocalizedProperty setLocalized(List<LocalizedString> var1) {
      this.localized = var1;
      return this;
   }

   public LocalizedProperty set(String var1, Object var2) {
      return (LocalizedProperty)super.set(var1, var2);
   }

   public LocalizedProperty clone() {
      return (LocalizedProperty)super.clone();
   }
}
