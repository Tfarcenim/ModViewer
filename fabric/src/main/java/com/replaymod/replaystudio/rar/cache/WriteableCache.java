package com.replaymod.replaystudio.rar.cache;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.stream.StreamNetOutput;
import com.replaymod.replaystudio.util.ByteBufExtNetOutput;
import com.replaymod.replaystudio.util.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import java.io.OutputStream;

public class WriteableCache {
   private final WriteableCache.CountingOutputStream wrapper;
   private final NetOutput out;

   public WriteableCache(OutputStream out) {
      this.wrapper = new WriteableCache.CountingOutputStream(out);
      this.out = new StreamNetOutput(this.wrapper);
   }

   public int index() {
      return this.wrapper.index;
   }

   public NetOutput write() {
      return this.out;
   }

   public WriteableCache.Deferred deferred() {
      return new WriteableCache.Deferred(Unpooled.buffer());
   }

   private static class CountingOutputStream extends OutputStream {
      private final OutputStream inner;
      private int index;

      private CountingOutputStream(OutputStream inner) {
         this.inner = inner;
      }

      public void write(int i) throws IOException {
         this.inner.write(i);
         ++this.index;
      }

      public void write(byte[] b, int off, int len) throws IOException {
         this.inner.write(b, off, len);
         this.index += len;
      }

      // $FF: synthetic method
      CountingOutputStream(OutputStream x0, Object x1) {
         this(x0);
      }
   }

   public class Deferred extends ByteBufExtNetOutput {
      private Deferred(ByteBuf buf) {
         super(buf);
      }

      public int commit() throws IOException {
         int index = WriteableCache.this.index();
         Utils.writeBytes(WriteableCache.this.out, this.getBuf());
         this.getBuf().release();
         return index;
      }

      // $FF: synthetic method
      Deferred(ByteBuf x1, Object x2) {
         this(x1);
      }
   }
}
