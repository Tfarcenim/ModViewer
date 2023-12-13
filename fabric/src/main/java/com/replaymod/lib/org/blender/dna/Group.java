package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 128L,
   size64 = 160L
)
public class Group extends CFacade {
   public static final int __DNA__SDNA_INDEX = 341;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__gobject = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__preview = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__layer = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__dupli_ofs = new long[]{116L, 148L};

   public Group(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Group(Group that) {
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

   public ListBase getGobject() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 120L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 100L, this.__io__block, this.__io__blockTable);
   }

   public void setGobject(ListBase gobject) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 120L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(gobject, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gobject)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gobject);
         } else {
            __io__generic__copy(this.getGobject(), gobject);
         }

      }
   }

   public CPointer<PreviewImage> getPreview() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 108L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PreviewImage.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 12), this.__io__blockTable);
   }

   public void setPreview(CPointer<PreviewImage> preview) throws IOException {
      long __address = preview == null ? 0L : preview.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 108L, __address);
      }

   }

   public int getLayer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 144L) : this.__io__block.readInt(this.__io__address + 112L);
   }

   public void setLayer(int layer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 144L, layer);
      } else {
         this.__io__block.writeInt(this.__io__address + 112L, layer);
      }

   }

   public CArrayFacade<Float> getDupli_ofs() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 148L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 116L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDupli_ofs(CArrayFacade<Float> dupli_ofs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 148L;
      } else {
         __dna__offset = 116L;
      }

      if (!this.__io__equals(dupli_ofs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dupli_ofs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dupli_ofs);
         } else {
            __io__generic__copy(this.getDupli_ofs(), dupli_ofs);
         }

      }
   }

   public CPointer<Group> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Group.class}, this.__io__block, this.__io__blockTable);
   }
}
