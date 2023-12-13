package com.replaymod.replaystudio.lib.viaversion.api.protocol.packet;

public interface ClientboundPacketType extends PacketType {
   default Direction direction() {
      return Direction.CLIENTBOUND;
   }
}
