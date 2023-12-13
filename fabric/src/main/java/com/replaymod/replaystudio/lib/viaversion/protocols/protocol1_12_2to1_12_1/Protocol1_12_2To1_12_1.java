package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12_2to1_12_1;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12_1to1_12.ClientboundPackets1_12_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12_1to1_12.ServerboundPackets1_12_1;

public class Protocol1_12_2To1_12_1 extends AbstractProtocol<ClientboundPackets1_12_1, ClientboundPackets1_12_1, ServerboundPackets1_12_1, ServerboundPackets1_12_1> {
   public Protocol1_12_2To1_12_1() {
      super(ClientboundPackets1_12_1.class, ClientboundPackets1_12_1.class, ServerboundPackets1_12_1.class, ServerboundPackets1_12_1.class);
   }

   protected void registerPackets() {
      this.registerClientbound(ClientboundPackets1_12_1.KEEP_ALIVE, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT, Type.LONG);
         }
      });
      this.registerServerbound(ServerboundPackets1_12_1.KEEP_ALIVE, new PacketHandlers() {
         public void register() {
            this.map(Type.LONG, Type.VAR_INT);
         }
      });
   }
}
