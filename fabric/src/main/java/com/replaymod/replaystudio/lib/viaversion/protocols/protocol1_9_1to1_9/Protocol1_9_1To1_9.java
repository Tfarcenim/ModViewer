package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_1to1_9;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.ClientboundPackets1_9;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.ServerboundPackets1_9;

public class Protocol1_9_1To1_9 extends AbstractProtocol<ClientboundPackets1_9, ClientboundPackets1_9, ServerboundPackets1_9, ServerboundPackets1_9> {
   public Protocol1_9_1To1_9() {
      super(ClientboundPackets1_9.class, ClientboundPackets1_9.class, ServerboundPackets1_9.class, ServerboundPackets1_9.class);
   }

   protected void registerPackets() {
      this.registerClientbound(ClientboundPackets1_9.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.BYTE, Type.INT);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.STRING);
            this.map(Type.BOOLEAN);
         }
      });
      this.registerClientbound(ClientboundPackets1_9.SOUND, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               int sound = (Integer)wrapper.get(Type.VAR_INT, 0);
               if (sound >= 415) {
                  wrapper.set(Type.VAR_INT, 0, sound + 1);
               }

            });
         }
      });
   }
}
