package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_2to1_13_1.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_2to1_13_1.Protocol1_13_2To1_13_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ClientboundPackets1_13;

public class WorldPackets {
   public static void register(Protocol1_13_2To1_13_1 protocol) {
      protocol.registerClientbound(ClientboundPackets1_13.SPAWN_PARTICLE, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.BOOLEAN);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.INT);
            this.handler((wrapper) -> {
               int id = (Integer)wrapper.get(Type.INT, 0);
               if (id == 27) {
                  wrapper.write(Type.FLAT_VAR_INT_ITEM, wrapper.read(Type.FLAT_ITEM));
               }

            });
         }
      });
   }
}
