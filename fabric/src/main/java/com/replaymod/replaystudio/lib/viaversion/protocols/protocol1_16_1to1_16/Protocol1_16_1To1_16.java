package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_1to1_16;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.ClientboundPackets1_16;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.ServerboundPackets1_16;

public class Protocol1_16_1To1_16 extends AbstractProtocol<ClientboundPackets1_16, ClientboundPackets1_16, ServerboundPackets1_16, ServerboundPackets1_16> {
   public Protocol1_16_1To1_16() {
      super(ClientboundPackets1_16.class, ClientboundPackets1_16.class, ServerboundPackets1_16.class, ServerboundPackets1_16.class);
   }
}
