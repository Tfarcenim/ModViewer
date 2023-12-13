package com.replaymod.replaystudio.lib.viaversion.protocols.base;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;

public enum ClientboundStatusPackets implements ClientboundPacketType {
   STATUS_RESPONSE,
   PONG_RESPONSE;

   public final int getId() {
      return this.ordinal();
   }

   public final String getName() {
      return this.name();
   }

   public final State state() {
      return State.STATUS;
   }
}
