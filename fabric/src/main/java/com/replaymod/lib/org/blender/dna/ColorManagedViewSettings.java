package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 152L,
   size64 = 160L
)
public class ColorManagedViewSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 464;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__pad = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__look = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__view_transform = new long[]{72L, 72L};
   public static final long[] __DNA__FIELD__exposure = new long[]{136L, 136L};
   public static final long[] __DNA__FIELD__gamma = new long[]{140L, 140L};
   public static final long[] __DNA__FIELD__curve_mapping = new long[]{144L, 144L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{148L, 152L};

   public ColorManagedViewSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ColorManagedViewSettings(ColorManagedViewSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, flag);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, pad);
      }

   }

   public CArrayFacade<Byte> getLook() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLook(CArrayFacade<Byte> look) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(look, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, look)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, look);
         } else {
            __io__generic__copy(this.getLook(), look);
         }

      }
   }

   public CArrayFacade<Byte> getView_transform() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 72L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 72L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setView_transform(CArrayFacade<Byte> view_transform) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 72L;
      } else {
         __dna__offset = 72L;
      }

      if (!this.__io__equals(view_transform, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, view_transform)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, view_transform);
         } else {
            __io__generic__copy(this.getView_transform(), view_transform);
         }

      }
   }

   public float getExposure() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 136L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setExposure(float exposure) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 136L, exposure);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, exposure);
      }

   }

   public float getGamma() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setGamma(float gamma) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, gamma);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, gamma);
      }

   }

   public CPointer<CurveMapping> getCurve_mapping() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapping.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 461), this.__io__blockTable);
   }

   public void setCurve_mapping(CPointer<CurveMapping> curve_mapping) throws IOException {
      long __address = curve_mapping == null ? 0L : curve_mapping.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      }

   }

   public CPointer<Object> getPad2() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 148L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPad2(CPointer<Object> pad2) throws IOException {
      long __address = pad2 == null ? 0L : pad2.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 148L, __address);
      }

   }

   public CPointer<ColorManagedViewSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ColorManagedViewSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
