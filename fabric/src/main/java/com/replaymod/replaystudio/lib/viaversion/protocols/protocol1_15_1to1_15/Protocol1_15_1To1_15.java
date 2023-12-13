package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15_1to1_15;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.ServerboundPackets1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.ClientboundPackets1_15;

public class Protocol1_15_1To1_15 extends AbstractProtocol<ClientboundPackets1_15, ClientboundPackets1_15, ServerboundPackets1_14, ServerboundPackets1_14> {
   public Protocol1_15_1To1_15() {
      super(ClientboundPackets1_15.class, ClientboundPackets1_15.class, ServerboundPackets1_14.class, ServerboundPackets1_14.class);
   }
}
