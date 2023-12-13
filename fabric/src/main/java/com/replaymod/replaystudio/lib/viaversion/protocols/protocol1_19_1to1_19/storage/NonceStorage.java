package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_1to1_19.storage;

import com.replaymod.replaystudio.lib.viaversion.api.connection.StorableObject;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class NonceStorage implements StorableObject {
   private final byte[] nonce;

   public NonceStorage(@Nullable byte[] nonce) {
      this.nonce = nonce;
   }

   @Nullable
   public byte[] nonce() {
      return this.nonce;
   }
}
