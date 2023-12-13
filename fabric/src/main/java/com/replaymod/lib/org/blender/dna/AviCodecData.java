package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 176L,
   size64 = 184L
)
public class AviCodecData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 168;
   public static final long[] __DNA__FIELD__lpFormat = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__lpParms = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__cbFormat = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__cbParms = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__fccType = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__fccHandler = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__dwKeyFrameEvery = new long[]{24L, 32L};
   public static final long[] __DNA__FIELD__dwQuality = new long[]{28L, 36L};
   public static final long[] __DNA__FIELD__dwBytesPerSecond = new long[]{32L, 40L};
   public static final long[] __DNA__FIELD__dwFlags = new long[]{36L, 44L};
   public static final long[] __DNA__FIELD__dwInterleaveEvery = new long[]{40L, 48L};
   public static final long[] __DNA__FIELD__pad = new long[]{44L, 52L};
   public static final long[] __DNA__FIELD__avicodecname = new long[]{48L, 56L};

   public AviCodecData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected AviCodecData(AviCodecData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Object> getLpFormat() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setLpFormat(CPointer<Object> lpFormat) throws IOException {
      long __address = lpFormat == null ? 0L : lpFormat.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Object> getLpParms() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setLpParms(CPointer<Object> lpParms) throws IOException {
      long __address = lpParms == null ? 0L : lpParms.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public int getCbFormat() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setCbFormat(int cbFormat) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, cbFormat);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, cbFormat);
      }

   }

   public int getCbParms() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setCbParms(int cbParms) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, cbParms);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, cbParms);
      }

   }

   public int getFccType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setFccType(int fccType) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, fccType);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, fccType);
      }

   }

   public int getFccHandler() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setFccHandler(int fccHandler) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, fccHandler);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, fccHandler);
      }

   }

   public int getDwKeyFrameEvery() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setDwKeyFrameEvery(int dwKeyFrameEvery) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, dwKeyFrameEvery);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, dwKeyFrameEvery);
      }

   }

   public int getDwQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setDwQuality(int dwQuality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, dwQuality);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, dwQuality);
      }

   }

   public int getDwBytesPerSecond() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 32L);
   }

   public void setDwBytesPerSecond(int dwBytesPerSecond) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, dwBytesPerSecond);
      } else {
         this.__io__block.writeInt(this.__io__address + 32L, dwBytesPerSecond);
      }

   }

   public int getDwFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 44L) : this.__io__block.readInt(this.__io__address + 36L);
   }

   public void setDwFlags(int dwFlags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 44L, dwFlags);
      } else {
         this.__io__block.writeInt(this.__io__address + 36L, dwFlags);
      }

   }

   public int getDwInterleaveEvery() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 48L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setDwInterleaveEvery(int dwInterleaveEvery) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 48L, dwInterleaveEvery);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, dwInterleaveEvery);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 52L) : this.__io__block.readInt(this.__io__address + 44L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 52L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 44L, pad);
      }

   }

   public CArrayFacade<Byte> getAvicodecname() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{128};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 56L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAvicodecname(CArrayFacade<Byte> avicodecname) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 56L;
      } else {
         __dna__offset = 48L;
      }

      if (!this.__io__equals(avicodecname, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, avicodecname)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, avicodecname);
         } else {
            __io__generic__copy(this.getAvicodecname(), avicodecname);
         }

      }
   }

   public CPointer<AviCodecData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{AviCodecData.class}, this.__io__block, this.__io__blockTable);
   }
}
