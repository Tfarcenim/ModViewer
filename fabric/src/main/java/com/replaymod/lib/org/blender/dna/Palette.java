package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 116L,
   size64 = 144L
)
public class Palette extends CFacade {
   public static final int __DNA__SDNA_INDEX = 470;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__colors = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__active_color = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__pad = new long[]{112L, 140L};

   public Palette(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Palette(Palette that) {
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

   public ListBase getColors() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 120L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 100L, this.__io__block, this.__io__blockTable);
   }

   public void setColors(ListBase colors) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 120L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(colors, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, colors)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, colors);
         } else {
            __io__generic__copy(this.getColors(), colors);
         }

      }
   }

   public int getActive_color() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 136L) : this.__io__block.readInt(this.__io__address + 108L);
   }

   public void setActive_color(int active_color) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 136L, active_color);
      } else {
         this.__io__block.writeInt(this.__io__address + 108L, active_color);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 140L) : this.__io__block.readInt(this.__io__address + 112L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 140L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 112L, pad);
      }

   }

   public CPointer<Palette> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Palette.class}, this.__io__block, this.__io__blockTable);
   }
}
