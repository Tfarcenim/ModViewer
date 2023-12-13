package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 28L,
   size64 = 40L
)
public class LodLevel extends CFacade {
   public static final int __DNA__SDNA_INDEX = 152;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__source = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__flags = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__distance = new long[]{16L, 28L};
   public static final long[] __DNA__FIELD__pad = new long[]{20L, 32L};
   public static final long[] __DNA__FIELD__obhysteresis = new long[]{24L, 36L};

   public LodLevel(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected LodLevel(LodLevel that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<LodLevel> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{LodLevel.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 152), this.__io__blockTable);
   }

   public void setNext(CPointer<LodLevel> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<LodLevel> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{LodLevel.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 152), this.__io__blockTable);
   }

   public void setPrev(CPointer<LodLevel> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<BlenderObject> getSource() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setSource(CPointer<BlenderObject> source) throws IOException {
      long __address = source == null ? 0L : source.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public int getFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setFlags(int flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, flags);
      }

   }

   public float getDistance() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setDistance(float distance) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, distance);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, distance);
      }

   }

   public float getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setPad(float pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, pad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, pad);
      }

   }

   public int getObhysteresis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setObhysteresis(int obhysteresis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, obhysteresis);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, obhysteresis);
      }

   }

   public CPointer<LodLevel> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{LodLevel.class}, this.__io__block, this.__io__blockTable);
   }
}
