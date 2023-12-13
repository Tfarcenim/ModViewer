package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;

@GwtCompatible
public abstract class ForwardingObject {
   protected ForwardingObject() {
   }

   protected abstract Object delegate();

   public String toString() {
      return this.delegate().toString();
   }
}
