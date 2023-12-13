package com.replaymod.lib.org.cakelab.blender.io.block.alloc;

import com.replaymod.lib.org.cakelab.blender.nio.UnsignedLong;

public class Chunk {
   Chunk.State state;
   long address;
   long size;
   Chunk prev;
   Chunk next;

   Chunk(Chunk prev, Chunk next) {
      this.prev = prev;
      this.next = next;
   }

   public Chunk(long address, long size, Chunk.State state) {
      this((Chunk)null, (Chunk)null);
      this.address = address;
      this.size = size;
      this.state = state;
   }

   public long end() {
      return UnsignedLong.plus(this.address, this.size);
   }

   public boolean contains(long address) {
      return UnsignedLong.le(this.address, address) && UnsignedLong.gt(UnsignedLong.plus(this.address, this.size), address);
   }

   public static enum State {
      FREE,
      ALLOCATED;
   }
}
