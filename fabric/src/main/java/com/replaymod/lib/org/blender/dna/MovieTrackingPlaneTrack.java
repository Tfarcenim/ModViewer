package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 108L,
   size64 = 128L
)
public class MovieTrackingPlaneTrack extends CFacade {
   public static final int __DNA__SDNA_INDEX = 552;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__name = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__point_tracks = new long[]{72L, 80L};
   public static final long[] __DNA__FIELD__point_tracksnr = new long[]{76L, 88L};
   public static final long[] __DNA__FIELD__pad = new long[]{80L, 92L};
   public static final long[] __DNA__FIELD__markers = new long[]{84L, 96L};
   public static final long[] __DNA__FIELD__markersnr = new long[]{88L, 104L};
   public static final long[] __DNA__FIELD__flag = new long[]{92L, 108L};
   public static final long[] __DNA__FIELD__image = new long[]{96L, 112L};
   public static final long[] __DNA__FIELD__image_opacity = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__last_marker = new long[]{104L, 124L};

   public MovieTrackingPlaneTrack(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTrackingPlaneTrack(MovieTrackingPlaneTrack that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<MovieTrackingPlaneTrack> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingPlaneTrack.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 552), this.__io__blockTable);
   }

   public void setNext(CPointer<MovieTrackingPlaneTrack> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<MovieTrackingPlaneTrack> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingPlaneTrack.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 552), this.__io__blockTable);
   }

   public void setPrev(CPointer<MovieTrackingPlaneTrack> prev) throws IOException {
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

   public CPointer<CPointer<MovieTrackingTrack>> getPoint_tracks() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 80L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 72L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, MovieTrackingTrack.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setPoint_tracks(CPointer<CPointer<MovieTrackingTrack>> point_tracks) throws IOException {
      long __address = point_tracks == null ? 0L : point_tracks.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 80L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 72L, __address);
      }

   }

   public int getPoint_tracksnr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 88L) : this.__io__block.readInt(this.__io__address + 76L);
   }

   public void setPoint_tracksnr(int point_tracksnr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 88L, point_tracksnr);
      } else {
         this.__io__block.writeInt(this.__io__address + 76L, point_tracksnr);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 92L) : this.__io__block.readInt(this.__io__address + 80L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 92L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 80L, pad);
      }

   }

   public CPointer<MovieTrackingPlaneMarker> getMarkers() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 84L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingPlaneMarker.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 551), this.__io__blockTable);
   }

   public void setMarkers(CPointer<MovieTrackingPlaneMarker> markers) throws IOException {
      long __address = markers == null ? 0L : markers.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 84L, __address);
      }

   }

   public int getMarkersnr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 104L) : this.__io__block.readInt(this.__io__address + 88L);
   }

   public void setMarkersnr(int markersnr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 104L, markersnr);
      } else {
         this.__io__block.writeInt(this.__io__address + 88L, markersnr);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 108L) : this.__io__block.readInt(this.__io__address + 92L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 108L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 92L, flag);
      }

   }

   public CPointer<Image> getImage() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 112L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setImage(CPointer<Image> image) throws IOException {
      long __address = image == null ? 0L : image.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 112L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      }

   }

   public float getImage_opacity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 120L) : this.__io__block.readFloat(this.__io__address + 100L);
   }

   public void setImage_opacity(float image_opacity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 120L, image_opacity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 100L, image_opacity);
      }

   }

   public int getLast_marker() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 124L) : this.__io__block.readInt(this.__io__address + 104L);
   }

   public void setLast_marker(int last_marker) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 124L, last_marker);
      } else {
         this.__io__block.writeInt(this.__io__address + 104L, last_marker);
      }

   }

   public CPointer<MovieTrackingPlaneTrack> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTrackingPlaneTrack.class}, this.__io__block, this.__io__blockTable);
   }
}
