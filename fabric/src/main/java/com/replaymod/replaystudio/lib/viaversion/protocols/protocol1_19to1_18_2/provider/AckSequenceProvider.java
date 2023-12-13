package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.provider;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.Provider;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.ClientboundPackets1_19;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.Protocol1_19To1_18_2;

public class AckSequenceProvider implements Provider {
   public void handleSequence(UserConnection connection, int sequence) throws Exception {
      PacketWrapper ackPacket = PacketWrapper.create(ClientboundPackets1_19.BLOCK_CHANGED_ACK, (UserConnection)connection);
      ackPacket.write(Type.VAR_INT, sequence);
      ackPacket.scheduleSend(Protocol1_19To1_18_2.class);
   }
}
