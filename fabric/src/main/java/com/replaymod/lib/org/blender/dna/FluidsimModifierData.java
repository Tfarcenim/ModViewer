package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 104L,
   size64 = 128L
)
public class FluidsimModifierData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 121;
   public static final long[] __DNA__FIELD__modifier = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__fss = new long[]{96L, 112L};
   public static final long[] __DNA__FIELD__point_cache = new long[]{100L, 120L};

   public FluidsimModifierData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected FluidsimModifierData(FluidsimModifierData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ModifierData getModifier() throws IOException {
      return this.__io__pointersize == 8 ? new ModifierData(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ModifierData(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setModifier(ModifierData modifier) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(modifier, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, modifier)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, modifier);
         } else {
            __io__generic__copy(this.getModifier(), modifier);
         }

      }
   }

   public CPointer<FluidsimSettings> getFss() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 112L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{FluidsimSettings.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 165), this.__io__blockTable);
   }

   public void setFss(CPointer<FluidsimSettings> fss) throws IOException {
      long __address = fss == null ? 0L : fss.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 112L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      }

   }

   public CPointer<PointCache> getPoint_cache() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PointCache.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 160), this.__io__blockTable);
   }

   public void setPoint_cache(CPointer<PointCache> point_cache) throws IOException {
      long __address = point_cache == null ? 0L : point_cache.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public CPointer<FluidsimModifierData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{FluidsimModifierData.class}, this.__io__block, this.__io__blockTable);
   }
}
