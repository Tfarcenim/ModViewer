package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1160L,
   size64 = 1200L
)
public class CacheFile extends CFacade {
   public static final int __DNA__SDNA_INDEX = 620;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__handle = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__handle_mutex = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__object_paths = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__filepath = new long[]{120L, 160L};
   public static final long[] __DNA__FIELD__is_sequence = new long[]{1144L, 1184L};
   public static final long[] __DNA__FIELD__forward_axis = new long[]{1145L, 1185L};
   public static final long[] __DNA__FIELD__up_axis = new long[]{1146L, 1186L};
   public static final long[] __DNA__FIELD__override_frame = new long[]{1147L, 1187L};
   public static final long[] __DNA__FIELD__scale = new long[]{1148L, 1188L};
   public static final long[] __DNA__FIELD__frame = new long[]{1152L, 1192L};
   public static final long[] __DNA__FIELD__flag = new long[]{1156L, 1196L};
   public static final long[] __DNA__FIELD__draw_flag = new long[]{1158L, 1198L};

   public CacheFile(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CacheFile(CacheFile that) {
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

   public CPointer<AnimData> getAdt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AnimData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 528), this.__io__blockTable);
   }

   public void setAdt(CPointer<AnimData> adt) throws IOException {
      long __address = adt == null ? 0L : adt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public CPointer<Object> getHandle() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setHandle(CPointer<Object> handle) throws IOException {
      long __address = handle == null ? 0L : handle.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public CPointer<Object> getHandle_mutex() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 108L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setHandle_mutex(CPointer<Object> handle_mutex) throws IOException {
      long __address = handle_mutex == null ? 0L : handle_mutex.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 108L, __address);
      }

   }

   public ListBase getObject_paths() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 144L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 112L, this.__io__block, this.__io__blockTable);
   }

   public void setObject_paths(ListBase object_paths) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 144L;
      } else {
         __dna__offset = 112L;
      }

      if (!this.__io__equals(object_paths, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, object_paths)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, object_paths);
         } else {
            __io__generic__copy(this.getObject_paths(), object_paths);
         }

      }
   }

   public CArrayFacade<Byte> getFilepath() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 160L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 120L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setFilepath(CArrayFacade<Byte> filepath) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 160L;
      } else {
         __dna__offset = 120L;
      }

      if (!this.__io__equals(filepath, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, filepath)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, filepath);
         } else {
            __io__generic__copy(this.getFilepath(), filepath);
         }

      }
   }

   public byte getIs_sequence() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1184L) : this.__io__block.readByte(this.__io__address + 1144L);
   }

   public void setIs_sequence(byte is_sequence) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1184L, is_sequence);
      } else {
         this.__io__block.writeByte(this.__io__address + 1144L, is_sequence);
      }

   }

   public byte getForward_axis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1185L) : this.__io__block.readByte(this.__io__address + 1145L);
   }

   public void setForward_axis(byte forward_axis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1185L, forward_axis);
      } else {
         this.__io__block.writeByte(this.__io__address + 1145L, forward_axis);
      }

   }

   public byte getUp_axis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1186L) : this.__io__block.readByte(this.__io__address + 1146L);
   }

   public void setUp_axis(byte up_axis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1186L, up_axis);
      } else {
         this.__io__block.writeByte(this.__io__address + 1146L, up_axis);
      }

   }

   public byte getOverride_frame() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1187L) : this.__io__block.readByte(this.__io__address + 1147L);
   }

   public void setOverride_frame(byte override_frame) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1187L, override_frame);
      } else {
         this.__io__block.writeByte(this.__io__address + 1147L, override_frame);
      }

   }

   public float getScale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1188L) : this.__io__block.readFloat(this.__io__address + 1148L);
   }

   public void setScale(float scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1188L, scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1148L, scale);
      }

   }

   public float getFrame() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1192L) : this.__io__block.readFloat(this.__io__address + 1152L);
   }

   public void setFrame(float frame) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1192L, frame);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1152L, frame);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1196L) : this.__io__block.readShort(this.__io__address + 1156L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1196L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 1156L, flag);
      }

   }

   public short getDraw_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1198L) : this.__io__block.readShort(this.__io__address + 1158L);
   }

   public void setDraw_flag(short draw_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1198L, draw_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 1158L, draw_flag);
      }

   }

   public CPointer<CacheFile> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CacheFile.class}, this.__io__block, this.__io__blockTable);
   }
}
