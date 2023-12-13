package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 96L,
   size64 = 112L
)
public class ModifierData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 89;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__type = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__mode = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__stackindex = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__pad = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__name = new long[]{24L, 32L};
   public static final long[] __DNA__FIELD__scene = new long[]{88L, 96L};
   public static final long[] __DNA__FIELD__error = new long[]{92L, 104L};

   public ModifierData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ModifierData(ModifierData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<ModifierData> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ModifierData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 89), this.__io__blockTable);
   }

   public void setNext(CPointer<ModifierData> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<ModifierData> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ModifierData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 89), this.__io__blockTable);
   }

   public void setPrev(CPointer<ModifierData> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public int getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setType(int type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, type);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, type);
      }

   }

   public int getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setMode(int mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, mode);
      }

   }

   public int getStackindex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setStackindex(int stackindex) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, stackindex);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, stackindex);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, pad);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public CPointer<Scene> getScene() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 88L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Scene.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 204), this.__io__blockTable);
   }

   public void setScene(CPointer<Scene> scene) throws IOException {
      long __address = scene == null ? 0L : scene.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 88L, __address);
      }

   }

   public CPointer<Byte> getError() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 92L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setError(CPointer<Byte> error) throws IOException {
      long __address = error == null ? 0L : error.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 92L, __address);
      }

   }

   public CPointer<ModifierData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ModifierData.class}, this.__io__block, this.__io__blockTable);
   }
}
