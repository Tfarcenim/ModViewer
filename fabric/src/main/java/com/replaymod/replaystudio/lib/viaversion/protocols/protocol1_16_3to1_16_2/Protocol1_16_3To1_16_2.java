package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_3to1_16_2;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_2to1_16_1.ClientboundPackets1_16_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_2to1_16_1.ServerboundPackets1_16_2;

public class Protocol1_16_3To1_16_2 extends AbstractProtocol<ClientboundPackets1_16_2, ClientboundPackets1_16_2, ServerboundPackets1_16_2, ServerboundPackets1_16_2> {
   public Protocol1_16_3To1_16_2() {
      super(ClientboundPackets1_16_2.class, ClientboundPackets1_16_2.class, ServerboundPackets1_16_2.class, ServerboundPackets1_16_2.class);
   }
}
