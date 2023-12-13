package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 144L,
   size64 = 152L
)
public class QuicktimeCodecData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 169;
   public static final long[] __DNA__FIELD__cdParms = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__pad = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__cdSize = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__qtcodecname = new long[]{16L, 24L};

   public QuicktimeCodecData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected QuicktimeCodecData(QuicktimeCodecData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Object> getCdParms() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setCdParms(CPointer<Object> cdParms) throws IOException {
      long __address = cdParms == null ? 0L : cdParms.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Object> getPad() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPad(CPointer<Object> pad) throws IOException {
      long __address = pad == null ? 0L : pad.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public int getCdSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setCdSize(int cdSize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, cdSize);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, cdSize);
      }

   }

   public int getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setPad2(int pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, pad2);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, pad2);
      }

   }

   public CArrayFacade<Byte> getQtcodecname() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{128};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setQtcodecname(CArrayFacade<Byte> qtcodecname) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(qtcodecname, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, qtcodecname)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, qtcodecname);
         } else {
            __io__generic__copy(this.getQtcodecname(), qtcodecname);
         }

      }
   }

   public CPointer<QuicktimeCodecData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{QuicktimeCodecData.class}, this.__io__block, this.__io__blockTable);
   }
}
