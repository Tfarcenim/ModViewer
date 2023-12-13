package com.replaymod.replaystudio.lib.viaversion.api.protocol.packet;

public interface ServerboundPacketType extends PacketType {
   default Direction direction() {
      return Direction.SERVERBOUND;
   }
}
