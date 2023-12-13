package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 48L,
   size64 = 64L
)
public class PreviewImage extends CFacade {
   public static final int __DNA__SDNA_INDEX = 12;
   public static final long[] __DNA__FIELD__w = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__h = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__flag = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__changed_timestamp = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__rect = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__gputexture = new long[]{32L, 40L};
   public static final long[] __DNA__FIELD__icon_id = new long[]{40L, 56L};
   public static final long[] __DNA__FIELD__tag = new long[]{44L, 60L};
   public static final long[] __DNA__FIELD__pad = new long[]{46L, 62L};

   public PreviewImage(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected PreviewImage(PreviewImage that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Integer> getW() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setW(CArrayFacade<Integer> w) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(w, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, w)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, w);
         } else {
            __io__generic__copy(this.getW(), w);
         }

      }
   }

   public CArrayFacade<Integer> getH() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setH(CArrayFacade<Integer> h) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(h, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, h)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, h);
         } else {
            __io__generic__copy(this.getH(), h);
         }

      }
   }

   public CArrayFacade<Short> getFlag() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setFlag(CArrayFacade<Short> flag) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(flag, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, flag)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, flag);
         } else {
            __io__generic__copy(this.getFlag(), flag);
         }

      }
   }

   public CArrayFacade<Short> getChanged_timestamp() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 20L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 20L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setChanged_timestamp(CArrayFacade<Short> changed_timestamp) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 20L;
      } else {
         __dna__offset = 20L;
      }

      if (!this.__io__equals(changed_timestamp, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, changed_timestamp)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, changed_timestamp);
         } else {
            __io__generic__copy(this.getChanged_timestamp(), changed_timestamp);
         }

      }
   }

   public CArrayFacade<CPointer<Integer>> getRect() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, Integer.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRect(CArrayFacade<CPointer<Integer>> rect) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(rect, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, rect)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, rect);
         } else {
            __io__generic__copy(this.getRect(), rect);
         }

      }
   }

   public CArrayFacade<CPointer<Object>> getGputexture() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, Object.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setGputexture(CArrayFacade<CPointer<Object>> gputexture) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 32L;
      }

      if (!this.__io__equals(gputexture, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gputexture)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gputexture);
         } else {
            __io__generic__copy(this.getGputexture(), gputexture);
         }

      }
   }

   public int getIcon_id() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 56L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setIcon_id(int icon_id) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 56L, icon_id);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, icon_id);
      }

   }

   public short getTag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 60L) : this.__io__block.readShort(this.__io__address + 44L);
   }

   public void setTag(short tag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 60L, tag);
      } else {
         this.__io__block.writeShort(this.__io__address + 44L, tag);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 62L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 46L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 62L;
      } else {
         __dna__offset = 46L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<PreviewImage> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{PreviewImage.class}, this.__io__block, this.__io__blockTable);
   }
}
