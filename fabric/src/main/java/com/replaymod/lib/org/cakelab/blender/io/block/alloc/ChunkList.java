package com.replaymod.lib.org.cakelab.blender.io.block.alloc;

import com.replaymod.lib.org.cakelab.blender.nio.UnsignedLong;
import java.util.Iterator;

public class ChunkList implements Iterable<Chunk> {
   Chunk head;
   Chunk tail;

   public ChunkList(Chunk head) {
      this.head = this.tail = head;
   }

   public Chunk find(long address) {
      Iterator var3 = this.iterator();

      Chunk partition;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         partition = (Chunk)var3.next();
      } while(!partition.contains(address));

      return partition;
   }

   public Iterator<Chunk> iterator() {
      return new ChunkIterator(this);
   }

   public Chunk split(Chunk chunk, long address, long size) {
      long sizeDiff;
      Chunk newChunk;
      if (chunk.address < address) {
         sizeDiff = UnsignedLong.minus(address, chunk.address);
         newChunk = new Chunk(address, UnsignedLong.minus(chunk.size, sizeDiff), chunk.state);
         this.insertAfter(chunk, newChunk);
         chunk.size = sizeDiff;
         chunk = newChunk;
      }

      if (UnsignedLong.lt(size, chunk.size)) {
         sizeDiff = UnsignedLong.minus(chunk.size, size);
         newChunk = new Chunk(UnsignedLong.plus(address, size), sizeDiff, chunk.state);
         this.insertAfter(chunk, newChunk);
         chunk.size = size;
      }

      return chunk;
   }

   private void insertAfter(Chunk prev, Chunk next) {
      if (prev == this.tail) {
         this.tail = next;
      }

      next.next = prev.next;
      if (next.next != null) {
         next.next.prev = next;
      }

      this.link(prev, next);
   }

   private void link(Chunk prev, Chunk next) {
      next.prev = prev;
      prev.next = next;
   }

   public Chunk merge(Chunk prev, Chunk next) {
      assert prev.next == next && next.prev == prev;

      if (prev == this.head) {
         this.head = next;
      }

      next.size = UnsignedLong.plus(prev.size, next.size);
      next.address = prev.address;
      next.prev = prev.prev;
      if (next.prev != null) {
         next.prev.next = next;
      }

      return next;
   }

   public void remove(Chunk current) {
      assert this.head != this.tail;

      if (current.prev == null) {
         this.head = current.next;
         this.head.prev = null;
      } else if (current.next == null) {
         this.tail = current.prev;
         this.tail.next = null;
      } else {
         this.link(current.prev, current.next);
      }

   }
}
