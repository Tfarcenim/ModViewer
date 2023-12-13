package com.replaymod.lib.org.cakelab.blender.io.block;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BlockList implements List<Block> {
   private Block first;
   private int size = 0;
   private Block last;

   public BlockList() {
      this.first = this.last = null;
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public boolean contains(Object o) {
      if (o instanceof Block) {
         Iterator var2 = this.iterator();

         while(var2.hasNext()) {
            Block block = (Block)var2.next();
            if ((Block)o == block) {
               return true;
            }
         }
      }

      return false;
   }

   public Iterator<Block> iterator() {
      return new BlockList.BlockListIterator(this);
   }

   public Object[] toArray() {
      Block[] array = new Block[this.size];
      int i = 0;

      Block block;
      for(Iterator var3 = this.iterator(); var3.hasNext(); array[i++] = block) {
         block = (Block)var3.next();
      }

      return array;
   }

   public <T> T[] toArray(T[] array) {
      if (array.getClass().getComponentType() != Block.class) {
         throw new ArrayStoreException("has to be Block[]");
      } else {
         if (array.length < this.size) {
            array = (Object[])((Object[])Array.newInstance(Block.class, this.size));
         }

         int i = 0;

         Block block;
         for(Iterator var3 = this.iterator(); var3.hasNext(); array[i++] = block) {
            block = (Block)var3.next();
         }

         return array;
      }
   }

   public boolean add(Block e) {
      ++this.size;
      if (this.last == null) {
         this.first = e;
      } else {
         this.last.next = e;
         e.prev = this.last;
      }

      this.last = e;
      return true;
   }

   public void insert(Block newBlock, Block nextBlock) {
      if (nextBlock.prev != null) {
         nextBlock.prev.next = newBlock;
         newBlock.prev = nextBlock.prev;
      }

      newBlock.next = nextBlock;
      nextBlock.prev = newBlock;
   }

   public void replace(Block oldBlock, Block newBlock) {
      if (this.first == oldBlock) {
         this.first = newBlock;
      }

      if (this.last == oldBlock) {
         this.last = newBlock;
      }

      newBlock.prev = oldBlock.prev;
      newBlock.next = oldBlock.next;
      if (newBlock.prev != null) {
         newBlock.prev.next = newBlock;
      }

      if (newBlock.next != null) {
         newBlock.next.prev = newBlock;
      }

   }

   public boolean remove(Object o) {
      Block current = (Block)o;
      if (current.next != null) {
         if (current.next.prev != current) {
            return false;
         }

         current.next.prev = current.prev;
      }

      if (current.prev != null) {
         if (current.prev.next != current) {
            return false;
         }

         current.prev.next = current.next;
      }

      if (current == this.first) {
         this.first = current.next;
      }

      if (current == this.last) {
         this.last = current.prev;
      }

      --this.size;
      return true;
   }

   public boolean containsAll(Collection<?> c) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection<? extends Block> c) {
      Iterator var2 = c.iterator();

      while(var2.hasNext()) {
         Block block = (Block)var2.next();
         this.add(block);
      }

      return true;
   }

   public boolean addAll(int index, Collection<? extends Block> c) {
      Block next = this.get(index);
      Iterator var4 = c.iterator();

      while(var4.hasNext()) {
         Block b = (Block)var4.next();
         this.insert(b, next);
      }

      return true;
   }

   public boolean removeAll(Collection<?> c) {
      boolean result = false;

      Object b;
      for(Iterator var3 = c.iterator(); var3.hasNext(); result |= this.remove(b)) {
         b = var3.next();
      }

      return result;
   }

   public boolean retainAll(Collection<?> c) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      this.size = 0;
      this.first = null;
      this.last = null;
   }

   public Block get(int index) {
      Iterator<Block> it = this.iterator();

      for(int i = 0; i < index; ++i) {
         if (!it.hasNext()) {
            throw new IndexOutOfBoundsException();
         }

         it.next();
      }

      if (!it.hasNext()) {
         throw new IndexOutOfBoundsException();
      } else {
         return (Block)it.next();
      }
   }

   public Block set(int index, Block element) {
      Block old = null;
      if (this.size == 0) {
         this.first = this.last = element;
      } else {
         old = this.get(index);
         this.replace(old, element);
      }

      return old;
   }

   public void add(int index, Block element) {
      Block pos = this.get(index);
      this.insert(element, pos);
   }

   public Block remove(int index) {
      Block result = this.get(index);
      this.remove(result);
      return result;
   }

   public int indexOf(Object o) {
      Iterator<Block> it = this.iterator();

      for(int index = 0; index < this.size; ++index) {
         if (o == it.next()) {
            return index;
         }
      }

      return 0;
   }

   public int lastIndexOf(Object o) {
      throw new UnsupportedOperationException();
   }

   public ListIterator<Block> listIterator() {
      return new BlockList.BlockListIterator(this);
   }

   public ListIterator<Block> listIterator(int index) {
      BlockList.BlockListIterator it = new BlockList.BlockListIterator(this);

      for(int i = 0; i <= index; ++i) {
         if (!it.hasNext()) {
            throw new IndexOutOfBoundsException();
         }

         it.next();
      }

      return it;
   }

   public List<Block> subList(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
   }

   public class BlockListIterator implements ListIterator<Block> {
      private Block current;
      private BlockList list;

      public BlockListIterator(BlockList list) {
         this.list = list;
         this.current = new Block();
         this.current.next = list.first;
      }

      public boolean hasNext() {
         return this.current.next != null;
      }

      public Block next() {
         this.current = this.current.next;
         return this.current;
      }

      public void remove() {
         this.list.remove(this);
      }

      public boolean hasPrevious() {
         return this.current.prev != null;
      }

      public Block previous() {
         this.current = this.current.prev;
         return this.current;
      }

      public int nextIndex() {
         throw new UnsupportedOperationException();
      }

      public int previousIndex() {
         throw new UnsupportedOperationException();
      }

      public void set(Block e) {
         this.list.replace(this.current, e);
      }

      public void add(Block e) {
         this.list.insert(e, this.current);
      }
   }
}
