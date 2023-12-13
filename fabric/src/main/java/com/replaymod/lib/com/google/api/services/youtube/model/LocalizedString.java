package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class LocalizedString extends GenericJson {
   @Key
   private String language;
   @Key
   private String value;

   public String getLanguage() {
      return this.language;
   }

   public LocalizedString setLanguage(String var1) {
      this.language = var1;
      return this;
   }

   public String getValue() {
      return this.value;
   }

   public LocalizedString setValue(String var1) {
      this.value = var1;
      return this;
   }

   public LocalizedString set(String var1, Object var2) {
      return (LocalizedString)super.set(var1, var2);
   }

   public LocalizedString clone() {
      return (LocalizedString)super.clone();
   }
}
