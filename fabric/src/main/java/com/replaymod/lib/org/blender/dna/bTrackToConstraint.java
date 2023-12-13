package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 84L,
   size64 = 88L
)
public class bTrackToConstraint extends CFacade {
   public static final int __DNA__SDNA_INDEX = 362;
   public static final long[] __DNA__FIELD__tar = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__reserved1 = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__reserved2 = new long[]{8L, 12L};
   public static final long[] __DNA__FIELD__flags = new long[]{12L, 16L};
   public static final long[] __DNA__FIELD__pad = new long[]{16L, 20L};
   public static final long[] __DNA__FIELD__subtarget = new long[]{20L, 24L};

   public bTrackToConstraint(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bTrackToConstraint(bTrackToConstraint that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<BlenderObject> getTar() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setTar(CPointer<BlenderObject> tar) throws IOException {
      long __address = tar == null ? 0L : tar.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public int getReserved1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setReserved1(int reserved1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, reserved1);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, reserved1);
      }

   }

   public int getReserved2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setReserved2(int reserved2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, reserved2);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, reserved2);
      }

   }

   public int getFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setFlags(int flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, flags);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, pad);
      }

   }

   public CArrayFacade<Byte> getSubtarget() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 20L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSubtarget(CArrayFacade<Byte> subtarget) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 20L;
      }

      if (!this.__io__equals(subtarget, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, subtarget)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, subtarget);
         } else {
            __io__generic__copy(this.getSubtarget(), subtarget);
         }

      }
   }

   public CPointer<bTrackToConstraint> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bTrackToConstraint.class}, this.__io__block, this.__io__blockTable);
   }
}
