package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 288L,
   size64 = 352L
)
public class MovieTracking extends CFacade {
   public static final int __DNA__SDNA_INDEX = 561;
   public static final long[] __DNA__FIELD__settings = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__camera = new long[]{72L, 72L};
   public static final long[] __DNA__FIELD__tracks = new long[]{124L, 128L};
   public static final long[] __DNA__FIELD__plane_tracks = new long[]{132L, 144L};
   public static final long[] __DNA__FIELD__reconstruction = new long[]{140L, 160L};
   public static final long[] __DNA__FIELD__stabilization = new long[]{160L, 184L};
   public static final long[] __DNA__FIELD__act_track = new long[]{228L, 256L};
   public static final long[] __DNA__FIELD__act_plane_track = new long[]{232L, 264L};
   public static final long[] __DNA__FIELD__objects = new long[]{236L, 272L};
   public static final long[] __DNA__FIELD__objectnr = new long[]{244L, 288L};
   public static final long[] __DNA__FIELD__tot_object = new long[]{248L, 292L};
   public static final long[] __DNA__FIELD__stats = new long[]{252L, 296L};
   public static final long[] __DNA__FIELD__dopesheet = new long[]{256L, 304L};

   public MovieTracking(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTracking(MovieTracking that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public MovieTrackingSettings getSettings() throws IOException {
      return this.__io__pointersize == 8 ? new MovieTrackingSettings(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new MovieTrackingSettings(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setSettings(MovieTrackingSettings settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, settings);
         } else {
            __io__generic__copy(this.getSettings(), settings);
         }

      }
   }

   public MovieTrackingCamera getCamera() throws IOException {
      return this.__io__pointersize == 8 ? new MovieTrackingCamera(this.__io__address + 72L, this.__io__block, this.__io__blockTable) : new MovieTrackingCamera(this.__io__address + 72L, this.__io__block, this.__io__blockTable);
   }

   public void setCamera(MovieTrackingCamera camera) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 72L;
      } else {
         __dna__offset = 72L;
      }

      if (!this.__io__equals(camera, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, camera)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, camera);
         } else {
            __io__generic__copy(this.getCamera(), camera);
         }

      }
   }

   public ListBase getTracks() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 128L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 124L, this.__io__block, this.__io__blockTable);
   }

   public void setTracks(ListBase tracks) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 124L;
      }

      if (!this.__io__equals(tracks, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, tracks)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, tracks);
         } else {
            __io__generic__copy(this.getTracks(), tracks);
         }

      }
   }

   public ListBase getPlane_tracks() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 144L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 132L, this.__io__block, this.__io__blockTable);
   }

   public void setPlane_tracks(ListBase plane_tracks) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 144L;
      } else {
         __dna__offset = 132L;
      }

      if (!this.__io__equals(plane_tracks, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, plane_tracks)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, plane_tracks);
         } else {
            __io__generic__copy(this.getPlane_tracks(), plane_tracks);
         }

      }
   }

   public MovieTrackingReconstruction getReconstruction() throws IOException {
      return this.__io__pointersize == 8 ? new MovieTrackingReconstruction(this.__io__address + 160L, this.__io__block, this.__io__blockTable) : new MovieTrackingReconstruction(this.__io__address + 140L, this.__io__block, this.__io__blockTable);
   }

   public void setReconstruction(MovieTrackingReconstruction reconstruction) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 160L;
      } else {
         __dna__offset = 140L;
      }

      if (!this.__io__equals(reconstruction, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, reconstruction)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, reconstruction);
         } else {
            __io__generic__copy(this.getReconstruction(), reconstruction);
         }

      }
   }

   public MovieTrackingStabilization getStabilization() throws IOException {
      return this.__io__pointersize == 8 ? new MovieTrackingStabilization(this.__io__address + 184L, this.__io__block, this.__io__blockTable) : new MovieTrackingStabilization(this.__io__address + 160L, this.__io__block, this.__io__blockTable);
   }

   public void setStabilization(MovieTrackingStabilization stabilization) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 184L;
      } else {
         __dna__offset = 160L;
      }

      if (!this.__io__equals(stabilization, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, stabilization)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, stabilization);
         } else {
            __io__generic__copy(this.getStabilization(), stabilization);
         }

      }
   }

   public CPointer<MovieTrackingTrack> getAct_track() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 256L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 228L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingTrack.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 550), this.__io__blockTable);
   }

   public void setAct_track(CPointer<MovieTrackingTrack> act_track) throws IOException {
      long __address = act_track == null ? 0L : act_track.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 256L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 228L, __address);
      }

   }

   public CPointer<MovieTrackingPlaneTrack> getAct_plane_track() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 264L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 232L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingPlaneTrack.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 552), this.__io__blockTable);
   }

   public void setAct_plane_track(CPointer<MovieTrackingPlaneTrack> act_plane_track) throws IOException {
      long __address = act_plane_track == null ? 0L : act_plane_track.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 264L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 232L, __address);
      }

   }

   public ListBase getObjects() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 272L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 236L, this.__io__block, this.__io__blockTable);
   }

   public void setObjects(ListBase objects) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 272L;
      } else {
         __dna__offset = 236L;
      }

      if (!this.__io__equals(objects, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, objects)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, objects);
         } else {
            __io__generic__copy(this.getObjects(), objects);
         }

      }
   }

   public int getObjectnr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 288L) : this.__io__block.readInt(this.__io__address + 244L);
   }

   public void setObjectnr(int objectnr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 288L, objectnr);
      } else {
         this.__io__block.writeInt(this.__io__address + 244L, objectnr);
      }

   }

   public int getTot_object() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 292L) : this.__io__block.readInt(this.__io__address + 248L);
   }

   public void setTot_object(int tot_object) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 292L, tot_object);
      } else {
         this.__io__block.writeInt(this.__io__address + 248L, tot_object);
      }

   }

   public CPointer<MovieTrackingStats> getStats() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 296L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 252L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingStats.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 557), this.__io__blockTable);
   }

   public void setStats(CPointer<MovieTrackingStats> stats) throws IOException {
      long __address = stats == null ? 0L : stats.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 296L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 252L, __address);
      }

   }

   public MovieTrackingDopesheet getDopesheet() throws IOException {
      return this.__io__pointersize == 8 ? new MovieTrackingDopesheet(this.__io__address + 304L, this.__io__block, this.__io__blockTable) : new MovieTrackingDopesheet(this.__io__address + 256L, this.__io__block, this.__io__blockTable);
   }

   public void setDopesheet(MovieTrackingDopesheet dopesheet) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 304L;
      } else {
         __dna__offset = 256L;
      }

      if (!this.__io__equals(dopesheet, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dopesheet)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dopesheet);
         } else {
            __io__generic__copy(this.getDopesheet(), dopesheet);
         }

      }
   }

   public CPointer<MovieTracking> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTracking.class}, this.__io__block, this.__io__blockTable);
   }
}
