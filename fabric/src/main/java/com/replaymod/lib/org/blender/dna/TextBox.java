package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 16L,
   size64 = 16L
)
public class TextBox extends CFacade {
   public static final int __DNA__SDNA_INDEX = 54;
   public static final long[] __DNA__FIELD__x = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__y = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__w = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__h = new long[]{12L, 12L};

   public TextBox(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected TextBox(TextBox that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getX() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setX(float x) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, x);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, x);
      }

   }

   public float getY() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setY(float y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, y);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, y);
      }

   }

   public float getW() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setW(float w) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, w);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, w);
      }

   }

   public float getH() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setH(float h) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, h);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, h);
      }

   }

   public CPointer<TextBox> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{TextBox.class}, this.__io__block, this.__io__blockTable);
   }
}
