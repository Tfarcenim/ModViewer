package com.replaymod.replaystudio.lib.viaversion.protocols.base;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ServerboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;

public enum ServerboundHandshakePackets implements ServerboundPacketType {
   CLIENT_INTENTION;

   public final int getId() {
      return this.ordinal();
   }

   public final String getName() {
      return this.name();
   }

   public final State state() {
      return State.HANDSHAKE;
   }
}
