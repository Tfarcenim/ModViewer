package com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;

@FunctionalInterface
public interface ValueWriter<T> {
   void write(PacketWrapper var1, T var2) throws Exception;
}
