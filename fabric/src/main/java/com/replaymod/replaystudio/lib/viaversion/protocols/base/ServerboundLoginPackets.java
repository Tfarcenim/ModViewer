package com.replaymod.replaystudio.lib.viaversion.protocols.base;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ServerboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;

public enum ServerboundLoginPackets implements ServerboundPacketType {
   HELLO,
   ENCRYPTION_KEY,
   CUSTOM_QUERY;

   public final int getId() {
      return this.ordinal();
   }

   public final String getName() {
      return this.name();
   }

   public final State state() {
      return State.LOGIN;
   }
}
