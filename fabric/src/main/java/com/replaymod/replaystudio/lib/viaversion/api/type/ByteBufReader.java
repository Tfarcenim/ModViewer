package com.replaymod.replaystudio.lib.viaversion.api.type;

import io.netty.buffer.ByteBuf;

@FunctionalInterface
public interface ByteBufReader<T> {
   T read(ByteBuf var1) throws Exception;
}
