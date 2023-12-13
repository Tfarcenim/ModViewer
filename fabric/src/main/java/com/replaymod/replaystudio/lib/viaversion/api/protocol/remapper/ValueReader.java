package com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;

@FunctionalInterface
public interface ValueReader<T> {
   T read(PacketWrapper var1) throws Exception;
}
