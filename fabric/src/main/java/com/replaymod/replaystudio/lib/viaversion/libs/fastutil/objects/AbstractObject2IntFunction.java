package com.replaymod.replaystudio.lib.viaversion.libs.fastutil.objects;

import java.io.Serializable;

public abstract class AbstractObject2IntFunction<K> implements Object2IntFunction<K>, Serializable {
   private static final long serialVersionUID = -4940583368468432370L;
   protected int defRetValue;

   protected AbstractObject2IntFunction() {
   }

   public void defaultReturnValue(int rv) {
      this.defRetValue = rv;
   }

   public int defaultReturnValue() {
      return this.defRetValue;
   }
}
