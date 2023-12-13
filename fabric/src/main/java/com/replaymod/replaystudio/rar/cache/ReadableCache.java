package com.replaymod.replaystudio.rar.cache;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.replaystudio.util.ByteBufExtNetInput;
import io.netty.buffer.ByteBuf;

public class ReadableCache {
   private final ByteBuf buf;
   private final NetInput in;

   public ReadableCache(ByteBuf buf) {
      this.buf = buf;
      this.in = new ByteBufExtNetInput(buf);
   }

   public NetInput seek(int index) {
      this.buf.readerIndex(index);
      return this.in;
   }

   public void release() {
      this.buf.release();
   }
}
