package com.replaymod.lib.org.cakelab.blender.io.block;

import com.replaymod.lib.org.cakelab.blender.io.Encoding;
import com.replaymod.lib.org.cakelab.blender.io.block.alloc.Allocator;
import com.replaymod.lib.org.cakelab.blender.io.util.CDataReadWriteAccess;
import com.replaymod.lib.org.cakelab.blender.io.util.Identifier;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import com.replaymod.lib.org.cakelab.blender.nio.UnsignedLong;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BlockTable {
   private static final long HEAPBASE = UnsignedLong.plus(0L, 4096L);
   private static final long HEAPSIZE;
   public static final Comparator<? super Block> BLOCKS_ASCENDING_ADDRESS;
   private List<Block> sorted;
   private Encoding encoding;
   private Allocator allocator;
   private boolean allocatorInitialised;
   private HashMap<Integer, BlockTable> offheapAreas;

   public BlockTable(Encoding encoding) {
      this.sorted = new ArrayList();
      this.allocator = new Allocator(HEAPBASE, HEAPSIZE);
      this.allocatorInitialised = false;
      this.encoding = encoding;
   }

   public BlockTable(Encoding encoding, List<Block> blocks, int[] offheapStructs) {
      this(encoding);
      this.sorted.addAll(blocks);
      Collections.sort(this.sorted, BLOCKS_ASCENDING_ADDRESS);
      this.initOffheapAreas(offheapStructs);
      if (!this.sorted.isEmpty()) {
         Block first = (Block)this.sorted.get(0);

         assert UnsignedLong.ge(first.header.address, HEAPBASE);
      }

   }

   private void initOffheapAreas(int[] offheap) {
      if (offheap != null) {
         this.offheapAreas = new HashMap(offheap.length);
         int[] var2 = offheap;
         int var3 = offheap.length;

         int sdna;
         for(int var4 = 0; var4 < var3; ++var4) {
            sdna = var2[var4];
            this.offheapAreas.put(sdna, new BlockTable(this.encoding));
         }

         Iterator it = this.sorted.iterator();

         while(true) {
            while(it.hasNext()) {
               Block b = (Block)it.next();
               int[] var10 = offheap;
               sdna = offheap.length;

               for(int var6 = 0; var6 < sdna; ++var6) {
                  int sdna = var10[var6];
                  if (b.header.sdnaIndex == sdna) {
                     ((BlockTable)this.offheapAreas.get(sdna)).add(b);
                     it.remove();
                     break;
                  }
               }
            }

            if (null == System.getProperty("com.replaymod.lib.org.cakelab.blender.NoChecks")) {
               this.checkBlockOverlaps();
            }

            return;
         }
      }
   }

   private void checkBlockOverlaps() {
      boolean valid = true;
      OverlappingBlocksException overlapping = new OverlappingBlocksException();

      for(int i = 0; i < this.sorted.size(); ++i) {
         Block cur = (Block)this.sorted.get(i);

         for(int j = i + 1; j < this.sorted.size(); ++j) {
            Block b = (Block)this.sorted.get(j);
            if (!cur.contains(b.header.address)) {
               break;
            }

            overlapping.add(cur, b);
            valid = false;
         }
      }

      if (!valid) {
         throw overlapping;
      }
   }

   public Block getBlock(long address, Class<?>[] type) {
      return !type[0].equals(CPointer.class) && !type[0].equals(CArrayFacade.class) ? this.getBlock(address, type[0]) : this.getBlock(address, type[1]);
   }

   public Block getBlock(long address, Class<?> type) {
      int sdnaIndex = -1;
      Class<?> superClass = type.getSuperclass();
      if (superClass != null && superClass.equals(CFacade.class)) {
         try {
            Field f = type.getDeclaredField("__DNA__SDNA_INDEX");
            sdnaIndex = f.getInt((Object)null);
         } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var7) {
            throw new RuntimeException("internal error", var7);
         }
      }

      return this.getBlock(address, sdnaIndex);
   }

   public Block getBlock(long address, int sdnaIndex) {
      if (this.offheapAreas != null && sdnaIndex >= 0) {
         BlockTable t = (BlockTable)this.offheapAreas.get(sdnaIndex);
         if (t != null) {
            return t.findBlock((long)sdnaIndex);
         }
      }

      return this.getBlock(address);
   }

   protected Block getBlock(long address) {
      if (address == 0L) {
         return null;
      } else {
         Block block = null;
         int i = Collections.binarySearch(this.sorted, address);
         if (i >= 0) {
            block = (Block)this.sorted.get(i);
         } else {
            i = -i - 2;
            if (i >= 0) {
               Block b = (Block)this.sorted.get(i);
               if (address < b.header.getAddress() + (long)b.header.getSize()) {
                  block = b;
               }
            }
         }

         return block;
      }
   }

   public Block findBlock(long startAddress) {
      int i = Collections.binarySearch(this.sorted, startAddress);
      Block block = null;
      if (i >= 0) {
         block = (Block)this.sorted.get(i);
      }

      return block;
   }

   public Block allocate(Identifier blockCode, int size) {
      this.checkAllocator();
      long address = this.allocator.alloc((long)size);
      CDataReadWriteAccess rwAccess = CDataReadWriteAccess.create(new byte[size], address, this.encoding);
      Block block = new Block(new BlockHeader(blockCode, size, address), rwAccess);
      this.add(block);
      return block;
   }

   protected void add(Block block) {
      int i = Collections.binarySearch(this.sorted, block.header.address);

      assert i < 0;

      i = -i - 1;
      this.sorted.add(i, block);
   }

   public Block allocate(Identifier blockCode, long size, int sdnaIndex, int count) {
      Block block = this.allocate(blockCode, size * (long)count);
      block.header.sdnaIndex = sdnaIndex;
      block.header.count = count;
      return block;
   }

   public Block allocate(Identifier code, long size) {
      return this.allocate(code, (int)size);
   }

   public void free(Block block) {
      BlockTable offheapArea = (BlockTable)this.offheapAreas.get(block.header.sdnaIndex);
      if (offheapArea != null) {
         offheapArea.free(block);
      } else {
         if (this.allocatorInitialised) {
            this.allocator.free(block.header.address, (long)block.header.size);
         }

         int i = Collections.binarySearch(this.sorted, block.header.address);

         assert i >= 0;

         this.sorted.remove(i);
      }

   }

   private void checkAllocator() {
      if (!this.allocatorInitialised) {
         Iterator var1 = this.sorted.iterator();

         while(var1.hasNext()) {
            Block block = (Block)var1.next();
            this.allocator.declareAllocated(block.header.address, (long)block.header.size);
         }

         this.allocatorInitialised = true;
      }

   }

   public boolean exists(long address) {
      return this.getBlock(address) != null;
   }

   public boolean exists(long startAddress, int sdnaIndex) {
      BlockTable offheapArea = null;
      if (this.offheapAreas != null) {
         offheapArea = (BlockTable)this.offheapAreas.get(sdnaIndex);
      }

      if (offheapArea != null) {
         return offheapArea.findBlock(startAddress) != null;
      } else {
         return this.findBlock(startAddress) != null;
      }
   }

   public Encoding getEncoding() {
      return this.encoding;
   }

   public List<Block> getBlocks(Identifier blockCode) {
      List<Block> result = new ArrayList();
      this.getBlocks(blockCode, result);
      if (this.offheapAreas != null) {
         Iterator var3 = this.offheapAreas.values().iterator();

         while(var3.hasNext()) {
            BlockTable offheapArea = (BlockTable)var3.next();
            offheapArea.getBlocks(blockCode, result);
         }
      }

      return result;
   }

   public void getBlocks(Identifier blockCode, List<Block> list) {
      Iterator var3 = this.sorted.iterator();

      while(var3.hasNext()) {
         Block block = (Block)var3.next();
         if (block.header.code.equals(blockCode)) {
            list.add(block);
         }
      }

   }

   public Allocator getAllocator() {
      this.checkAllocator();
      return this.allocator;
   }

   public List<Block> getBlocksSorted() {
      return this.sorted;
   }

   static {
      HEAPSIZE = UnsignedLong.minus(-1L, HEAPBASE);
      BLOCKS_ASCENDING_ADDRESS = new Comparator<Block>() {
         public int compare(Block b1, Block b2) {
            return b1.compareTo(b2.header.getAddress());
         }
      };
   }
}
