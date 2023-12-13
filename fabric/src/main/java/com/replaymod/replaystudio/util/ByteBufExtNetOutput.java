package com.replaymod.replaystudio.util;

import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetOutput;
import io.netty.buffer.ByteBuf;

public class ByteBufExtNetOutput extends ByteBufNetOutput {
   private final ByteBuf buf;

   public ByteBufExtNetOutput(ByteBuf buf) {
      super(buf);
      this.buf = buf;
   }

   public ByteBuf getBuf() {
      return this.buf;
   }
}
