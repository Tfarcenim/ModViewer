package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import java.io.IOException;

interface BinaryTagScope extends AutoCloseable {
   void close() throws IOException;

   public static final class NoOp implements BinaryTagScope {
      static final BinaryTagScope.NoOp INSTANCE = new BinaryTagScope.NoOp();

      private NoOp() {
      }

      public void close() {
      }
   }
}
