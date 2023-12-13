package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1080L,
   size64 = 1088L
)
public class VoxelData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 37;
   public static final long[] __DNA__FIELD__resol = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__interp_type = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__file_format = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__flag = new long[]{18L, 18L};
   public static final long[] __DNA__FIELD__extend = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__smoked_type = new long[]{22L, 22L};
   public static final long[] __DNA__FIELD__hair_type = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__data_type = new long[]{26L, 26L};
   public static final long[] __DNA__FIELD___pad = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__object = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__int_multiplier = new long[]{36L, 40L};
   public static final long[] __DNA__FIELD__still_frame = new long[]{40L, 44L};
   public static final long[] __DNA__FIELD__source_path = new long[]{44L, 48L};
   public static final long[] __DNA__FIELD__dataset = new long[]{1068L, 1072L};
   public static final long[] __DNA__FIELD__cachedframe = new long[]{1072L, 1080L};
   public static final long[] __DNA__FIELD__ok = new long[]{1076L, 1084L};

   public VoxelData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected VoxelData(VoxelData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Integer> getResol() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setResol(CArrayFacade<Integer> resol) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(resol, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, resol)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, resol);
         } else {
            __io__generic__copy(this.getResol(), resol);
         }

      }
   }

   public int getInterp_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setInterp_type(int interp_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, interp_type);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, interp_type);
      }

   }

   public short getFile_format() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 16L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setFile_format(short file_format) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 16L, file_format);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, file_format);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, flag);
      }

   }

   public short getExtend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 20L) : this.__io__block.readShort(this.__io__address + 20L);
   }

   public void setExtend(short extend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 20L, extend);
      } else {
         this.__io__block.writeShort(this.__io__address + 20L, extend);
      }

   }

   public short getSmoked_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 22L) : this.__io__block.readShort(this.__io__address + 22L);
   }

   public void setSmoked_type(short smoked_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 22L, smoked_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 22L, smoked_type);
      }

   }

   public short getHair_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 24L) : this.__io__block.readShort(this.__io__address + 24L);
   }

   public void setHair_type(short hair_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 24L, hair_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 24L, hair_type);
      }

   }

   public short getData_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 26L) : this.__io__block.readShort(this.__io__address + 26L);
   }

   public void setData_type(short data_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 26L, data_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 26L, data_type);
      }

   }

   public int get_pad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void set_pad(int _pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, _pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, _pad);
      }

   }

   public CPointer<BlenderObject> getObject() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setObject(CPointer<BlenderObject> object) throws IOException {
      long __address = object == null ? 0L : object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      }

   }

   public float getInt_multiplier() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setInt_multiplier(float int_multiplier) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, int_multiplier);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, int_multiplier);
      }

   }

   public int getStill_frame() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 44L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setStill_frame(int still_frame) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 44L, still_frame);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, still_frame);
      }

   }

   public CArrayFacade<Byte> getSource_path() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 44L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSource_path(CArrayFacade<Byte> source_path) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 44L;
      }

      if (!this.__io__equals(source_path, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, source_path)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, source_path);
         } else {
            __io__generic__copy(this.getSource_path(), source_path);
         }

      }
   }

   public CPointer<Float> getDataset() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1072L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1068L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setDataset(CPointer<Float> dataset) throws IOException {
      long __address = dataset == null ? 0L : dataset.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1072L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1068L, __address);
      }

   }

   public int getCachedframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1080L) : this.__io__block.readInt(this.__io__address + 1072L);
   }

   public void setCachedframe(int cachedframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1080L, cachedframe);
      } else {
         this.__io__block.writeInt(this.__io__address + 1072L, cachedframe);
      }

   }

   public int getOk() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1084L) : this.__io__block.readInt(this.__io__address + 1076L);
   }

   public void setOk(int ok) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1084L, ok);
      } else {
         this.__io__block.writeInt(this.__io__address + 1076L, ok);
      }

   }

   public CPointer<VoxelData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{VoxelData.class}, this.__io__block, this.__io__blockTable);
   }
}
