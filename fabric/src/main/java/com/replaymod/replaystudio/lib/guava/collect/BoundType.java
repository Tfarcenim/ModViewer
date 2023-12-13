package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;

@GwtCompatible
public enum BoundType {
   OPEN {
      BoundType flip() {
         return CLOSED;
      }
   },
   CLOSED {
      BoundType flip() {
         return OPEN;
      }
   };

   private BoundType() {
   }

   static BoundType forBoolean(boolean inclusive) {
      return inclusive ? CLOSED : OPEN;
   }

   abstract BoundType flip();

   // $FF: synthetic method
   BoundType(Object x2) {
      this();
   }
}
