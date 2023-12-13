package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 68L,
   size64 = 96L
)
public class VPaint extends CFacade {
   public static final int __DNA__SDNA_INDEX = 191;
   public static final long[] __DNA__FIELD__paint = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flag = new long[]{48L, 64L};
   public static final long[] __DNA__FIELD__pad = new long[]{50L, 66L};
   public static final long[] __DNA__FIELD__tot = new long[]{52L, 68L};
   public static final long[] __DNA__FIELD__vpaint_prev = new long[]{56L, 72L};
   public static final long[] __DNA__FIELD__wpaint_prev = new long[]{60L, 80L};
   public static final long[] __DNA__FIELD__paintcursor = new long[]{64L, 88L};

   public VPaint(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected VPaint(VPaint that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public Paint getPaint() throws IOException {
      return this.__io__pointersize == 8 ? new Paint(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new Paint(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setPaint(Paint paint) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(paint, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, paint)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, paint);
         } else {
            __io__generic__copy(this.getPaint(), paint);
         }

      }
   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 64L) : this.__io__block.readShort(this.__io__address + 48L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 64L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 48L, flag);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 66L) : this.__io__block.readShort(this.__io__address + 50L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 66L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 50L, pad);
      }

   }

   public int getTot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 68L) : this.__io__block.readInt(this.__io__address + 52L);
   }

   public void setTot(int tot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 68L, tot);
      } else {
         this.__io__block.writeInt(this.__io__address + 52L, tot);
      }

   }

   public CPointer<Integer> getVpaint_prev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 72L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 56L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setVpaint_prev(CPointer<Integer> vpaint_prev) throws IOException {
      long __address = vpaint_prev == null ? 0L : vpaint_prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 72L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 56L, __address);
      }

   }

   public CPointer<MDeformVert> getWpaint_prev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 80L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 60L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MDeformVert.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 62), this.__io__blockTable);
   }

   public void setWpaint_prev(CPointer<MDeformVert> wpaint_prev) throws IOException {
      long __address = wpaint_prev == null ? 0L : wpaint_prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 80L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 60L, __address);
      }

   }

   public CPointer<Object> getPaintcursor() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 88L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 64L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPaintcursor(CPointer<Object> paintcursor) throws IOException {
      long __address = paintcursor == null ? 0L : paintcursor.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 88L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 64L, __address);
      }

   }

   public CPointer<VPaint> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{VPaint.class}, this.__io__block, this.__io__blockTable);
   }
}
