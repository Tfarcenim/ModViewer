package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1188L,
   size64 = 1240L
)
public class bSound extends CFacade {
   public static final int __DNA__SDNA_INDEX = 339;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__name = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__packedfile = new long[]{1124L, 1144L};
   public static final long[] __DNA__FIELD__handle = new long[]{1128L, 1152L};
   public static final long[] __DNA__FIELD__newpackedfile = new long[]{1132L, 1160L};
   public static final long[] __DNA__FIELD__ipo = new long[]{1136L, 1168L};
   public static final long[] __DNA__FIELD__volume = new long[]{1140L, 1176L};
   public static final long[] __DNA__FIELD__attenuation = new long[]{1144L, 1180L};
   public static final long[] __DNA__FIELD__pitch = new long[]{1148L, 1184L};
   public static final long[] __DNA__FIELD__min_gain = new long[]{1152L, 1188L};
   public static final long[] __DNA__FIELD__max_gain = new long[]{1156L, 1192L};
   public static final long[] __DNA__FIELD__distance = new long[]{1160L, 1196L};
   public static final long[] __DNA__FIELD__flags = new long[]{1164L, 1200L};
   public static final long[] __DNA__FIELD__pad = new long[]{1168L, 1204L};
   public static final long[] __DNA__FIELD__cache = new long[]{1172L, 1208L};
   public static final long[] __DNA__FIELD__waveform = new long[]{1176L, 1216L};
   public static final long[] __DNA__FIELD__playback_handle = new long[]{1180L, 1224L};
   public static final long[] __DNA__FIELD__spinlock = new long[]{1184L, 1232L};

   public bSound(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bSound(bSound that) {
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

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 120L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 100L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 120L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public CPointer<PackedFile> getPackedfile() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PackedFile.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 20), this.__io__blockTable);
   }

   public void setPackedfile(CPointer<PackedFile> packedfile) throws IOException {
      long __address = packedfile == null ? 0L : packedfile.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1124L, __address);
      }

   }

   public CPointer<Object> getHandle() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1128L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setHandle(CPointer<Object> handle) throws IOException {
      long __address = handle == null ? 0L : handle.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1128L, __address);
      }

   }

   public CPointer<PackedFile> getNewpackedfile() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1132L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PackedFile.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 20), this.__io__blockTable);
   }

   public void setNewpackedfile(CPointer<PackedFile> newpackedfile) throws IOException {
      long __address = newpackedfile == null ? 0L : newpackedfile.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1132L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1168L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1136L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1168L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1136L, __address);
      }

   }

   public float getVolume() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1176L) : this.__io__block.readFloat(this.__io__address + 1140L);
   }

   public void setVolume(float volume) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1176L, volume);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1140L, volume);
      }

   }

   public float getAttenuation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1180L) : this.__io__block.readFloat(this.__io__address + 1144L);
   }

   public void setAttenuation(float attenuation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1180L, attenuation);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1144L, attenuation);
      }

   }

   public float getPitch() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1184L) : this.__io__block.readFloat(this.__io__address + 1148L);
   }

   public void setPitch(float pitch) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1184L, pitch);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1148L, pitch);
      }

   }

   public float getMin_gain() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1188L) : this.__io__block.readFloat(this.__io__address + 1152L);
   }

   public void setMin_gain(float min_gain) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1188L, min_gain);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1152L, min_gain);
      }

   }

   public float getMax_gain() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1192L) : this.__io__block.readFloat(this.__io__address + 1156L);
   }

   public void setMax_gain(float max_gain) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1192L, max_gain);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1156L, max_gain);
      }

   }

   public float getDistance() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1196L) : this.__io__block.readFloat(this.__io__address + 1160L);
   }

   public void setDistance(float distance) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1196L, distance);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1160L, distance);
      }

   }

   public int getFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1200L) : this.__io__block.readInt(this.__io__address + 1164L);
   }

   public void setFlags(int flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1200L, flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 1164L, flags);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1204L) : this.__io__block.readInt(this.__io__address + 1168L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1204L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 1168L, pad);
      }

   }

   public CPointer<Object> getCache() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1208L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1172L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setCache(CPointer<Object> cache) throws IOException {
      long __address = cache == null ? 0L : cache.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1208L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1172L, __address);
      }

   }

   public CPointer<Object> getWaveform() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1216L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1176L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setWaveform(CPointer<Object> waveform) throws IOException {
      long __address = waveform == null ? 0L : waveform.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1216L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1176L, __address);
      }

   }

   public CPointer<Object> getPlayback_handle() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1224L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1180L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPlayback_handle(CPointer<Object> playback_handle) throws IOException {
      long __address = playback_handle == null ? 0L : playback_handle.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1224L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1180L, __address);
      }

   }

   public CPointer<Object> getSpinlock() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1232L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1184L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setSpinlock(CPointer<Object> spinlock) throws IOException {
      long __address = spinlock == null ? 0L : spinlock.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1232L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1184L, __address);
      }

   }

   public CPointer<bSound> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bSound.class}, this.__io__block, this.__io__blockTable);
   }
}
