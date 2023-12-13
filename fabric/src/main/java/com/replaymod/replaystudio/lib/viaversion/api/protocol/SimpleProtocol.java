package com.replaymod.replaystudio.lib.viaversion.api.protocol;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.Direction;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ServerboundPacketType;

public interface SimpleProtocol extends Protocol<SimpleProtocol.DummyPacketTypes, SimpleProtocol.DummyPacketTypes, SimpleProtocol.DummyPacketTypes, SimpleProtocol.DummyPacketTypes> {
   public static enum DummyPacketTypes implements ClientboundPacketType, ServerboundPacketType {
      public int getId() {
         return 0;
      }

      public String getName() {
         return this.name();
      }

      public Direction direction() {
         throw new UnsupportedOperationException();
      }
   }
}
