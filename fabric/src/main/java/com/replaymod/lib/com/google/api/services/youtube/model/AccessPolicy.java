package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class AccessPolicy extends GenericJson {
   @Key
   private Boolean allowed;
   @Key
   private List<String> exception;

   public Boolean getAllowed() {
      return this.allowed;
   }

   public AccessPolicy setAllowed(Boolean var1) {
      this.allowed = var1;
      return this;
   }

   public List<String> getException() {
      return this.exception;
   }

   public AccessPolicy setException(List<String> var1) {
      this.exception = var1;
      return this;
   }

   public AccessPolicy set(String var1, Object var2) {
      return (AccessPolicy)super.set(var1, var2);
   }

   public AccessPolicy clone() {
      return (AccessPolicy)super.clone();
   }
}
