package com.replaymod.replaystudio.util;

import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetInput;
import io.netty.buffer.ByteBuf;

public class ByteBufExtNetInput extends ByteBufNetInput {
   private final ByteBuf buf;

   public ByteBufExtNetInput(ByteBuf buf) {
      super(buf);
      this.buf = buf;
   }

   public ByteBuf getBuf() {
      return this.buf;
   }
}
