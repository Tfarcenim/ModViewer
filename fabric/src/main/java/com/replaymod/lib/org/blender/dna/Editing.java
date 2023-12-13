package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 3128L,
   size64 = 3152L
)
public class Editing extends CFacade {
   public static final int __DNA__SDNA_INDEX = 274;
   public static final long[] __DNA__FIELD__seqbasep = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__seqbase = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__metastack = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__act_seq = new long[]{20L, 40L};
   public static final long[] __DNA__FIELD__act_imagedir = new long[]{24L, 48L};
   public static final long[] __DNA__FIELD__act_sounddir = new long[]{1048L, 1072L};
   public static final long[] __DNA__FIELD__proxy_dir = new long[]{2072L, 2096L};
   public static final long[] __DNA__FIELD__over_ofs = new long[]{3096L, 3120L};
   public static final long[] __DNA__FIELD__over_cfra = new long[]{3100L, 3124L};
   public static final long[] __DNA__FIELD__over_flag = new long[]{3104L, 3128L};
   public static final long[] __DNA__FIELD__proxy_storage = new long[]{3108L, 3132L};
   public static final long[] __DNA__FIELD__over_border = new long[]{3112L, 3136L};

   public Editing(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Editing(Editing that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<ListBase> getSeqbasep() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ListBase.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 2), this.__io__blockTable);
   }

   public void setSeqbasep(CPointer<ListBase> seqbasep) throws IOException {
      long __address = seqbasep == null ? 0L : seqbasep.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public ListBase getSeqbase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 8L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 4L, this.__io__block, this.__io__blockTable);
   }

   public void setSeqbase(ListBase seqbase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 4L;
      }

      if (!this.__io__equals(seqbase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, seqbase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, seqbase);
         } else {
            __io__generic__copy(this.getSeqbase(), seqbase);
         }

      }
   }

   public ListBase getMetastack() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 24L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 12L, this.__io__block, this.__io__blockTable);
   }

   public void setMetastack(ListBase metastack) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 12L;
      }

      if (!this.__io__equals(metastack, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, metastack)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, metastack);
         } else {
            __io__generic__copy(this.getMetastack(), metastack);
         }

      }
   }

   public CPointer<Sequence> getAct_seq() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 40L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 20L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Sequence.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 272), this.__io__blockTable);
   }

   public void setAct_seq(CPointer<Sequence> act_seq) throws IOException {
      long __address = act_seq == null ? 0L : act_seq.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 40L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 20L, __address);
      }

   }

   public CArrayFacade<Byte> getAct_imagedir() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAct_imagedir(CArrayFacade<Byte> act_imagedir) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(act_imagedir, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, act_imagedir)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, act_imagedir);
         } else {
            __io__generic__copy(this.getAct_imagedir(), act_imagedir);
         }

      }
   }

   public CArrayFacade<Byte> getAct_sounddir() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1072L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1048L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAct_sounddir(CArrayFacade<Byte> act_sounddir) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1072L;
      } else {
         __dna__offset = 1048L;
      }

      if (!this.__io__equals(act_sounddir, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, act_sounddir)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, act_sounddir);
         } else {
            __io__generic__copy(this.getAct_sounddir(), act_sounddir);
         }

      }
   }

   public CArrayFacade<Byte> getProxy_dir() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2096L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 2072L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setProxy_dir(CArrayFacade<Byte> proxy_dir) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2096L;
      } else {
         __dna__offset = 2072L;
      }

      if (!this.__io__equals(proxy_dir, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, proxy_dir)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, proxy_dir);
         } else {
            __io__generic__copy(this.getProxy_dir(), proxy_dir);
         }

      }
   }

   public int getOver_ofs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 3120L) : this.__io__block.readInt(this.__io__address + 3096L);
   }

   public void setOver_ofs(int over_ofs) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 3120L, over_ofs);
      } else {
         this.__io__block.writeInt(this.__io__address + 3096L, over_ofs);
      }

   }

   public int getOver_cfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 3124L) : this.__io__block.readInt(this.__io__address + 3100L);
   }

   public void setOver_cfra(int over_cfra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 3124L, over_cfra);
      } else {
         this.__io__block.writeInt(this.__io__address + 3100L, over_cfra);
      }

   }

   public int getOver_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 3128L) : this.__io__block.readInt(this.__io__address + 3104L);
   }

   public void setOver_flag(int over_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 3128L, over_flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 3104L, over_flag);
      }

   }

   public int getProxy_storage() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 3132L) : this.__io__block.readInt(this.__io__address + 3108L);
   }

   public void setProxy_storage(int proxy_storage) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 3132L, proxy_storage);
      } else {
         this.__io__block.writeInt(this.__io__address + 3108L, proxy_storage);
      }

   }

   public rctf getOver_border() throws IOException {
      return this.__io__pointersize == 8 ? new rctf(this.__io__address + 3136L, this.__io__block, this.__io__blockTable) : new rctf(this.__io__address + 3112L, this.__io__block, this.__io__blockTable);
   }

   public void setOver_border(rctf over_border) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 3136L;
      } else {
         __dna__offset = 3112L;
      }

      if (!this.__io__equals(over_border, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, over_border)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, over_border);
         } else {
            __io__generic__copy(this.getOver_border(), over_border);
         }

      }
   }

   public CPointer<Editing> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Editing.class}, this.__io__block, this.__io__blockTable);
   }
}
