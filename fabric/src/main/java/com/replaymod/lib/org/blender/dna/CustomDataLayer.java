package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 100L,
   size64 = 104L
)
public class CustomDataLayer extends CFacade {
   public static final int __DNA__SDNA_INDEX = 473;
   public static final long[] __DNA__FIELD__type = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__offset = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__flag = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__active = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__active_rnd = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__active_clone = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__active_mask = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__uid = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__name = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__data = new long[]{96L, 96L};

   public CustomDataLayer(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CustomDataLayer(CustomDataLayer that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setType(int type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, type);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, type);
      }

   }

   public int getOffset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setOffset(int offset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, offset);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, offset);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, flag);
      }

   }

   public int getActive() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setActive(int active) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, active);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, active);
      }

   }

   public int getActive_rnd() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setActive_rnd(int active_rnd) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, active_rnd);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, active_rnd);
      }

   }

   public int getActive_clone() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setActive_clone(int active_clone) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, active_clone);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, active_clone);
      }

   }

   public int getActive_mask() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setActive_mask(int active_mask) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, active_mask);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, active_mask);
      }

   }

   public int getUid() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setUid(int uid) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, uid);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, uid);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 32L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public CPointer<Object> getData() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setData(CPointer<Object> data) throws IOException {
      long __address = data == null ? 0L : data.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      }

   }

   public CPointer<CustomDataLayer> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CustomDataLayer.class}, this.__io__block, this.__io__blockTable);
   }
}
