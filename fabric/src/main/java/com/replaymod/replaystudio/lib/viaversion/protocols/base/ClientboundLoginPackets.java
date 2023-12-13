package com.replaymod.replaystudio.lib.viaversion.protocols.base;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;

public enum ClientboundLoginPackets implements ClientboundPacketType {
   LOGIN_DISCONNECT,
   HELLO,
   GAME_PROFILE,
   LOGIN_COMPRESSION,
   CUSTOM_QUERY;

   public final int getId() {
      return this.ordinal();
   }

   public final String getName() {
      return this.name();
   }

   public final State state() {
      return State.LOGIN;
   }
}
