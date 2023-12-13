package com.replaymod.replaystudio.lib.viaversion.libs.fastutil;

public interface Stack<K> {
   void push(K var1);

   K pop();

   boolean isEmpty();

   default K top() {
      return this.peek(0);
   }

   default K peek(int i) {
      throw new UnsupportedOperationException();
   }
}
