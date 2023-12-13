package com.replaymod.lib.org.mortbay.io.nio;

import com.replaymod.lib.org.mortbay.io.ByteArrayBuffer;
import java.nio.ByteBuffer;

public class IndirectNIOBuffer extends ByteArrayBuffer implements NIOBuffer {
   protected ByteBuffer _buf;

   public IndirectNIOBuffer(int size) {
      super(2, false);
      this._buf = ByteBuffer.allocate(size);
      this._buf.position(0);
      this._buf.limit(this._buf.capacity());
      this._bytes = this._buf.array();
   }

   public IndirectNIOBuffer(ByteBuffer buffer, boolean immutable) {
      super(immutable ? 0 : 2, false);
      if (buffer.isDirect()) {
         throw new IllegalArgumentException();
      } else {
         this._buf = buffer;
         this.setGetIndex(buffer.position());
         this.setPutIndex(buffer.limit());
         this._bytes = this._buf.array();
      }
   }

   public ByteBuffer getByteBuffer() {
      return this._buf;
   }

   public boolean isDirect() {
      return false;
   }
}
