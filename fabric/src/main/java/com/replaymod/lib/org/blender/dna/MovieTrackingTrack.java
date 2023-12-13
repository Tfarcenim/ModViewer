package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 192L,
   size64 = 208L
)
public class MovieTrackingTrack extends CFacade {
   public static final int __DNA__SDNA_INDEX = 550;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__name = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__pat_min = new long[]{72L, 80L};
   public static final long[] __DNA__FIELD__pat_max = new long[]{80L, 88L};
   public static final long[] __DNA__FIELD__search_min = new long[]{88L, 96L};
   public static final long[] __DNA__FIELD__search_max = new long[]{96L, 104L};
   public static final long[] __DNA__FIELD__offset = new long[]{104L, 112L};
   public static final long[] __DNA__FIELD__markersnr = new long[]{112L, 120L};
   public static final long[] __DNA__FIELD__last_marker = new long[]{116L, 124L};
   public static final long[] __DNA__FIELD__markers = new long[]{120L, 128L};
   public static final long[] __DNA__FIELD__bundle_pos = new long[]{124L, 136L};
   public static final long[] __DNA__FIELD__error = new long[]{136L, 148L};
   public static final long[] __DNA__FIELD__flag = new long[]{140L, 152L};
   public static final long[] __DNA__FIELD__pat_flag = new long[]{144L, 156L};
   public static final long[] __DNA__FIELD__search_flag = new long[]{148L, 160L};
   public static final long[] __DNA__FIELD__color = new long[]{152L, 164L};
   public static final long[] __DNA__FIELD__frames_limit = new long[]{164L, 176L};
   public static final long[] __DNA__FIELD__margin = new long[]{166L, 178L};
   public static final long[] __DNA__FIELD__pattern_match = new long[]{168L, 180L};
   public static final long[] __DNA__FIELD__motion_model = new long[]{170L, 182L};
   public static final long[] __DNA__FIELD__algorithm_flag = new long[]{172L, 184L};
   public static final long[] __DNA__FIELD__minimum_correlation = new long[]{176L, 188L};
   public static final long[] __DNA__FIELD__gpd = new long[]{180L, 192L};
   public static final long[] __DNA__FIELD__weight = new long[]{184L, 200L};
   public static final long[] __DNA__FIELD__weight_stab = new long[]{188L, 204L};

   public MovieTrackingTrack(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTrackingTrack(MovieTrackingTrack that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<MovieTrackingTrack> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingTrack.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 550), this.__io__blockTable);
   }

   public void setNext(CPointer<MovieTrackingTrack> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<MovieTrackingTrack> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingTrack.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 550), this.__io__blockTable);
   }

   public void setPrev(CPointer<MovieTrackingTrack> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public CArrayFacade<Float> getPat_min() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 80L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 72L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPat_min(CArrayFacade<Float> pat_min) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 80L;
      } else {
         __dna__offset = 72L;
      }

      if (!this.__io__equals(pat_min, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pat_min)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pat_min);
         } else {
            __io__generic__copy(this.getPat_min(), pat_min);
         }

      }
   }

   public CArrayFacade<Float> getPat_max() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 88L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 80L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPat_max(CArrayFacade<Float> pat_max) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 88L;
      } else {
         __dna__offset = 80L;
      }

      if (!this.__io__equals(pat_max, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pat_max)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pat_max);
         } else {
            __io__generic__copy(this.getPat_max(), pat_max);
         }

      }
   }

   public CArrayFacade<Float> getSearch_min() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 96L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 88L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSearch_min(CArrayFacade<Float> search_min) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 96L;
      } else {
         __dna__offset = 88L;
      }

      if (!this.__io__equals(search_min, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, search_min)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, search_min);
         } else {
            __io__generic__copy(this.getSearch_min(), search_min);
         }

      }
   }

   public CArrayFacade<Float> getSearch_max() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 104L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 96L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSearch_max(CArrayFacade<Float> search_max) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 104L;
      } else {
         __dna__offset = 96L;
      }

      if (!this.__io__equals(search_max, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, search_max)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, search_max);
         } else {
            __io__generic__copy(this.getSearch_max(), search_max);
         }

      }
   }

   public CArrayFacade<Float> getOffset() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 112L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 104L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setOffset(CArrayFacade<Float> offset) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 112L;
      } else {
         __dna__offset = 104L;
      }

      if (!this.__io__equals(offset, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, offset)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, offset);
         } else {
            __io__generic__copy(this.getOffset(), offset);
         }

      }
   }

   public int getMarkersnr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 120L) : this.__io__block.readInt(this.__io__address + 112L);
   }

   public void setMarkersnr(int markersnr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 120L, markersnr);
      } else {
         this.__io__block.writeInt(this.__io__address + 112L, markersnr);
      }

   }

   public int getLast_marker() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 124L) : this.__io__block.readInt(this.__io__address + 116L);
   }

   public void setLast_marker(int last_marker) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 124L, last_marker);
      } else {
         this.__io__block.writeInt(this.__io__address + 116L, last_marker);
      }

   }

   public CPointer<MovieTrackingMarker> getMarkers() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingMarker.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 549), this.__io__blockTable);
   }

   public void setMarkers(CPointer<MovieTrackingMarker> markers) throws IOException {
      long __address = markers == null ? 0L : markers.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      }

   }

   public CArrayFacade<Float> getBundle_pos() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 136L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 124L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBundle_pos(CArrayFacade<Float> bundle_pos) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 124L;
      }

      if (!this.__io__equals(bundle_pos, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bundle_pos)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bundle_pos);
         } else {
            __io__generic__copy(this.getBundle_pos(), bundle_pos);
         }

      }
   }

   public float getError() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setError(float error) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, error);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, error);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 152L) : this.__io__block.readInt(this.__io__address + 140L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 152L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 140L, flag);
      }

   }

   public int getPat_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 156L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setPat_flag(int pat_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 156L, pat_flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, pat_flag);
      }

   }

   public int getSearch_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 160L) : this.__io__block.readInt(this.__io__address + 148L);
   }

   public void setSearch_flag(int search_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 160L, search_flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 148L, search_flag);
      }

   }

   public CArrayFacade<Float> getColor() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 164L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 152L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setColor(CArrayFacade<Float> color) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 164L;
      } else {
         __dna__offset = 152L;
      }

      if (!this.__io__equals(color, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, color)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, color);
         } else {
            __io__generic__copy(this.getColor(), color);
         }

      }
   }

   public short getFrames_limit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 176L) : this.__io__block.readShort(this.__io__address + 164L);
   }

   public void setFrames_limit(short frames_limit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 176L, frames_limit);
      } else {
         this.__io__block.writeShort(this.__io__address + 164L, frames_limit);
      }

   }

   public short getMargin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 178L) : this.__io__block.readShort(this.__io__address + 166L);
   }

   public void setMargin(short margin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 178L, margin);
      } else {
         this.__io__block.writeShort(this.__io__address + 166L, margin);
      }

   }

   public short getPattern_match() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 180L) : this.__io__block.readShort(this.__io__address + 168L);
   }

   public void setPattern_match(short pattern_match) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 180L, pattern_match);
      } else {
         this.__io__block.writeShort(this.__io__address + 168L, pattern_match);
      }

   }

   public short getMotion_model() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 182L) : this.__io__block.readShort(this.__io__address + 170L);
   }

   public void setMotion_model(short motion_model) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 182L, motion_model);
      } else {
         this.__io__block.writeShort(this.__io__address + 170L, motion_model);
      }

   }

   public int getAlgorithm_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 184L) : this.__io__block.readInt(this.__io__address + 172L);
   }

   public void setAlgorithm_flag(int algorithm_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 184L, algorithm_flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 172L, algorithm_flag);
      }

   }

   public float getMinimum_correlation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 188L) : this.__io__block.readFloat(this.__io__address + 176L);
   }

   public void setMinimum_correlation(float minimum_correlation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 188L, minimum_correlation);
      } else {
         this.__io__block.writeFloat(this.__io__address + 176L, minimum_correlation);
      }

   }

   public CPointer<bGPdata> getGpd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 180L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bGPdata.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 497), this.__io__blockTable);
   }

   public void setGpd(CPointer<bGPdata> gpd) throws IOException {
      long __address = gpd == null ? 0L : gpd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 180L, __address);
      }

   }

   public float getWeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 200L) : this.__io__block.readFloat(this.__io__address + 184L);
   }

   public void setWeight(float weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 200L, weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 184L, weight);
      }

   }

   public float getWeight_stab() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 204L) : this.__io__block.readFloat(this.__io__address + 188L);
   }

   public void setWeight_stab(float weight_stab) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 204L, weight_stab);
      } else {
         this.__io__block.writeFloat(this.__io__address + 188L, weight_stab);
      }

   }

   public CPointer<MovieTrackingTrack> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTrackingTrack.class}, this.__io__block, this.__io__blockTable);
   }
}
