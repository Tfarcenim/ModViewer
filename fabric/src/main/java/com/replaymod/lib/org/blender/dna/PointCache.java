package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1292L,
   size64 = 1320L
)
public class PointCache extends CFacade {
   public static final int __DNA__SDNA_INDEX = 160;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__flag = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__step = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__simframe = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__startframe = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__endframe = new long[]{24L, 32L};
   public static final long[] __DNA__FIELD__editframe = new long[]{28L, 36L};
   public static final long[] __DNA__FIELD__last_exact = new long[]{32L, 40L};
   public static final long[] __DNA__FIELD__last_valid = new long[]{36L, 44L};
   public static final long[] __DNA__FIELD__pad = new long[]{40L, 48L};
   public static final long[] __DNA__FIELD__totpoint = new long[]{44L, 52L};
   public static final long[] __DNA__FIELD__index = new long[]{48L, 56L};
   public static final long[] __DNA__FIELD__compression = new long[]{52L, 60L};
   public static final long[] __DNA__FIELD__rt = new long[]{54L, 62L};
   public static final long[] __DNA__FIELD__name = new long[]{56L, 64L};
   public static final long[] __DNA__FIELD__prev_name = new long[]{120L, 128L};
   public static final long[] __DNA__FIELD__info = new long[]{184L, 192L};
   public static final long[] __DNA__FIELD__path = new long[]{248L, 256L};
   public static final long[] __DNA__FIELD__cached_frames = new long[]{1272L, 1280L};
   public static final long[] __DNA__FIELD__mem_cache = new long[]{1276L, 1288L};
   public static final long[] __DNA__FIELD__edit = new long[]{1284L, 1304L};

   public PointCache(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected PointCache(PointCache that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<PointCache> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PointCache.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 160), this.__io__blockTable);
   }

   public void setNext(CPointer<PointCache> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<PointCache> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PointCache.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 160), this.__io__blockTable);
   }

   public void setPrev(CPointer<PointCache> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, flag);
      }

   }

   public int getStep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setStep(int step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, step);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, step);
      }

   }

   public int getSimframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setSimframe(int simframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, simframe);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, simframe);
      }

   }

   public int getStartframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setStartframe(int startframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, startframe);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, startframe);
      }

   }

   public int getEndframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setEndframe(int endframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, endframe);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, endframe);
      }

   }

   public int getEditframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setEditframe(int editframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, editframe);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, editframe);
      }

   }

   public int getLast_exact() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 32L);
   }

   public void setLast_exact(int last_exact) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, last_exact);
      } else {
         this.__io__block.writeInt(this.__io__address + 32L, last_exact);
      }

   }

   public int getLast_valid() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 44L) : this.__io__block.readInt(this.__io__address + 36L);
   }

   public void setLast_valid(int last_valid) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 44L, last_valid);
      } else {
         this.__io__block.writeInt(this.__io__address + 36L, last_valid);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 48L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 48L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, pad);
      }

   }

   public int getTotpoint() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 52L) : this.__io__block.readInt(this.__io__address + 44L);
   }

   public void setTotpoint(int totpoint) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 52L, totpoint);
      } else {
         this.__io__block.writeInt(this.__io__address + 44L, totpoint);
      }

   }

   public int getIndex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 56L) : this.__io__block.readInt(this.__io__address + 48L);
   }

   public void setIndex(int index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 56L, index);
      } else {
         this.__io__block.writeInt(this.__io__address + 48L, index);
      }

   }

   public short getCompression() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 60L) : this.__io__block.readShort(this.__io__address + 52L);
   }

   public void setCompression(short compression) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 60L, compression);
      } else {
         this.__io__block.writeShort(this.__io__address + 52L, compression);
      }

   }

   public short getRt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 62L) : this.__io__block.readShort(this.__io__address + 54L);
   }

   public void setRt(short rt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 62L, rt);
      } else {
         this.__io__block.writeShort(this.__io__address + 54L, rt);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 64L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 56L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 64L;
      } else {
         __dna__offset = 56L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public CArrayFacade<Byte> getPrev_name() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 120L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPrev_name(CArrayFacade<Byte> prev_name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 120L;
      }

      if (!this.__io__equals(prev_name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, prev_name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, prev_name);
         } else {
            __io__generic__copy(this.getPrev_name(), prev_name);
         }

      }
   }

   public CArrayFacade<Byte> getInfo() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 192L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 184L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setInfo(CArrayFacade<Byte> info) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 192L;
      } else {
         __dna__offset = 184L;
      }

      if (!this.__io__equals(info, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, info)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, info);
         } else {
            __io__generic__copy(this.getInfo(), info);
         }

      }
   }

   public CArrayFacade<Byte> getPath() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 256L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 248L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPath(CArrayFacade<Byte> path) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 256L;
      } else {
         __dna__offset = 248L;
      }

      if (!this.__io__equals(path, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, path)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, path);
         } else {
            __io__generic__copy(this.getPath(), path);
         }

      }
   }

   public CPointer<Byte> getCached_frames() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1280L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1272L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setCached_frames(CPointer<Byte> cached_frames) throws IOException {
      long __address = cached_frames == null ? 0L : cached_frames.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1280L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1272L, __address);
      }

   }

   public ListBase getMem_cache() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1288L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1276L, this.__io__block, this.__io__blockTable);
   }

   public void setMem_cache(ListBase mem_cache) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1288L;
      } else {
         __dna__offset = 1276L;
      }

      if (!this.__io__equals(mem_cache, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mem_cache)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mem_cache);
         } else {
            __io__generic__copy(this.getMem_cache(), mem_cache);
         }

      }
   }

   public CPointer<Object> getEdit() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1304L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1284L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setEdit(CPointer<Object> edit) throws IOException {
      long __address = edit == null ? 0L : edit.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1304L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1284L, __address);
      }

   }

   public CPointer<PointCache> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{PointCache.class}, this.__io__block, this.__io__blockTable);
   }
}
