package com.replaymod.lib.org.cakelab.blender.io.block.alloc;

import com.replaymod.lib.org.cakelab.blender.nio.UnsignedLong;

public class Allocator {
   ChunkList chunks;
   ChunkIterator cursor;

   public Allocator(long heapBase, long heapSize) {
      this.chunks = new ChunkList(new Chunk(heapBase, heapSize, Chunk.State.FREE));
      this.cursor = (ChunkIterator)this.chunks.iterator();
   }

   public void declareAllocated(long address, long size) {
      assert address != 0L;

      Chunk chunk = this.chunks.find(address);

      assert chunk.contains(UnsignedLong.plus(address, size - 1L));

      assert chunk.state == Chunk.State.FREE;

      chunk = this.chunks.split(chunk, address, size);
      chunk.state = Chunk.State.ALLOCATED;
   }

   public long alloc(long size) {
      long address = 0L;

      do {
         if (!this.cursor.hasNext()) {
            this.cursor = (ChunkIterator)this.chunks.iterator();
         }

         Chunk chunk = this.cursor.next();
         if (chunk.state == Chunk.State.FREE && UnsignedLong.ge(chunk.size, size)) {
            address = chunk.address;
            chunk = this.chunks.split(chunk, chunk.address, size);
            chunk.state = Chunk.State.ALLOCATED;
            this.tryMerge(chunk);
         }
      } while(address == 0L);

      return address;
   }

   public void free(long address, long size) {
      assert address != 0L;

      Chunk chunk = this.chunks.find(address);

      assert chunk.contains(UnsignedLong.plus(address, size - 1L));

      assert chunk.state == Chunk.State.ALLOCATED;

      chunk = this.chunks.split(chunk, address, size);
      chunk.state = Chunk.State.FREE;
   }

   private void tryMerge(Chunk chunk) {
      if (chunk.prev != null && chunk.prev.state == chunk.state) {
         chunk = this.chunks.merge(chunk.prev, chunk);
      }

      if (chunk.next != null && chunk.next.state == chunk.state) {
         this.chunks.merge(chunk, chunk.next);
      }

   }
}
