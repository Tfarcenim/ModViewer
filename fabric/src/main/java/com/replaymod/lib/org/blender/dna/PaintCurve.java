package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 112L,
   size64 = 136L
)
public class PaintCurve extends CFacade {
   public static final int __DNA__SDNA_INDEX = 472;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__points = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__tot_points = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__add_index = new long[]{108L, 132L};

   public PaintCurve(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected PaintCurve(PaintCurve that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ID getId() throws IOException {
      return this.__io__pointersize == 8 ? new ID(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ID(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setId(ID id) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(id, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, id)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, id);
         } else {
            __io__generic__copy(this.getId(), id);
         }

      }
   }

   public CPointer<PaintCurvePoint> getPoints() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PaintCurvePoint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 471), this.__io__blockTable);
   }

   public void setPoints(CPointer<PaintCurvePoint> points) throws IOException {
      long __address = points == null ? 0L : points.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public int getTot_points() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 128L) : this.__io__block.readInt(this.__io__address + 104L);
   }

   public void setTot_points(int tot_points) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 128L, tot_points);
      } else {
         this.__io__block.writeInt(this.__io__address + 104L, tot_points);
      }

   }

   public int getAdd_index() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 132L) : this.__io__block.readInt(this.__io__address + 108L);
   }

   public void setAdd_index(int add_index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 132L, add_index);
      } else {
         this.__io__block.writeInt(this.__io__address + 108L, add_index);
      }

   }

   public CPointer<PaintCurve> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{PaintCurve.class}, this.__io__block, this.__io__blockTable);
   }
}
