package com.replaymod.lib.org.cakelab.blender.io.block.alloc;

import java.util.Iterator;

public class ChunkIterator implements Iterator<Chunk> {
   private Chunk virtualHead;
   private Chunk current;
   private ChunkList list;

   public ChunkIterator(ChunkList list) {
      this.list = list;
      this.virtualHead = this.current = new Chunk((Chunk)null, list.head);
   }

   public boolean hasNext() {
      return this.current.next != null;
   }

   public Chunk next() {
      return this.current = this.current.next;
   }

   public void remove() {
      if (this.current == this.virtualHead) {
         throw new UnsupportedOperationException("remove() removes the _last_ element returned by next(): You have to call next at least once.");
      } else {
         this.list.remove(this.current);
      }
   }
}
