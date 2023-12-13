package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 196L,
   size64 = 208L
)
public class CustomData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 475;
   public static final long[] __DNA__FIELD__layers = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__typemap = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__pad_i1 = new long[]{172L, 176L};
   public static final long[] __DNA__FIELD__totlayer = new long[]{176L, 180L};
   public static final long[] __DNA__FIELD__maxlayer = new long[]{180L, 184L};
   public static final long[] __DNA__FIELD__totsize = new long[]{184L, 188L};
   public static final long[] __DNA__FIELD__pool = new long[]{188L, 192L};
   public static final long[] __DNA__FIELD__external = new long[]{192L, 200L};

   public CustomData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CustomData(CustomData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<CustomDataLayer> getLayers() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CustomDataLayer.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 473), this.__io__blockTable);
   }

   public void setLayers(CPointer<CustomDataLayer> layers) throws IOException {
      long __address = layers == null ? 0L : layers.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CArrayFacade<Integer> getTypemap() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      int[] __dna__dimensions = new int[]{42};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 4L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTypemap(CArrayFacade<Integer> typemap) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 4L;
      }

      if (!this.__io__equals(typemap, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, typemap)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, typemap);
         } else {
            __io__generic__copy(this.getTypemap(), typemap);
         }

      }
   }

   public int getPad_i1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 176L) : this.__io__block.readInt(this.__io__address + 172L);
   }

   public void setPad_i1(int pad_i1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 176L, pad_i1);
      } else {
         this.__io__block.writeInt(this.__io__address + 172L, pad_i1);
      }

   }

   public int getTotlayer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 180L) : this.__io__block.readInt(this.__io__address + 176L);
   }

   public void setTotlayer(int totlayer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 180L, totlayer);
      } else {
         this.__io__block.writeInt(this.__io__address + 176L, totlayer);
      }

   }

   public int getMaxlayer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 184L) : this.__io__block.readInt(this.__io__address + 180L);
   }

   public void setMaxlayer(int maxlayer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 184L, maxlayer);
      } else {
         this.__io__block.writeInt(this.__io__address + 180L, maxlayer);
      }

   }

   public int getTotsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 188L) : this.__io__block.readInt(this.__io__address + 184L);
   }

   public void setTotsize(int totsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 188L, totsize);
      } else {
         this.__io__block.writeInt(this.__io__address + 184L, totsize);
      }

   }

   public CPointer<Object> getPool() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 188L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPool(CPointer<Object> pool) throws IOException {
      long __address = pool == null ? 0L : pool.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 188L, __address);
      }

   }

   public CPointer<CustomDataExternal> getExternal() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CustomDataExternal.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 474), this.__io__blockTable);
   }

   public void setExternal(CPointer<CustomDataExternal> external) throws IOException {
      long __address = external == null ? 0L : external.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      }

   }

   public CPointer<CustomData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CustomData.class}, this.__io__block, this.__io__blockTable);
   }
}
