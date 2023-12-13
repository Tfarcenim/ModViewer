package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 60L,
   size64 = 104L
)
public class AnimData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 528;
   public static final long[] __DNA__FIELD__action = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__tmpact = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__remap = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__nla_tracks = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__act_track = new long[]{20L, 40L};
   public static final long[] __DNA__FIELD__actstrip = new long[]{24L, 48L};
   public static final long[] __DNA__FIELD__drivers = new long[]{28L, 56L};
   public static final long[] __DNA__FIELD__overrides = new long[]{36L, 72L};
   public static final long[] __DNA__FIELD__flag = new long[]{44L, 88L};
   public static final long[] __DNA__FIELD__recalc = new long[]{48L, 92L};
   public static final long[] __DNA__FIELD__act_blendmode = new long[]{52L, 96L};
   public static final long[] __DNA__FIELD__act_extendmode = new long[]{54L, 98L};
   public static final long[] __DNA__FIELD__act_influence = new long[]{56L, 100L};

   public AnimData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected AnimData(AnimData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<bAction> getAction() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bAction.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 352), this.__io__blockTable);
   }

   public void setAction(CPointer<bAction> action) throws IOException {
      long __address = action == null ? 0L : action.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<bAction> getTmpact() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bAction.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 352), this.__io__blockTable);
   }

   public void setTmpact(CPointer<bAction> tmpact) throws IOException {
      long __address = tmpact == null ? 0L : tmpact.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<AnimMapper> getRemap() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AnimMapper.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 522), this.__io__blockTable);
   }

   public void setRemap(CPointer<AnimMapper> remap) throws IOException {
      long __address = remap == null ? 0L : remap.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public ListBase getNla_tracks() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 24L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 12L, this.__io__block, this.__io__blockTable);
   }

   public void setNla_tracks(ListBase nla_tracks) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 12L;
      }

      if (!this.__io__equals(nla_tracks, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, nla_tracks)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, nla_tracks);
         } else {
            __io__generic__copy(this.getNla_tracks(), nla_tracks);
         }

      }
   }

   public CPointer<NlaTrack> getAct_track() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 40L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 20L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{NlaTrack.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 524), this.__io__blockTable);
   }

   public void setAct_track(CPointer<NlaTrack> act_track) throws IOException {
      long __address = act_track == null ? 0L : act_track.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 40L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 20L, __address);
      }

   }

   public CPointer<NlaStrip> getActstrip() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 48L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{NlaStrip.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 523), this.__io__blockTable);
   }

   public void setActstrip(CPointer<NlaStrip> actstrip) throws IOException {
      long __address = actstrip == null ? 0L : actstrip.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 48L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      }

   }

   public ListBase getDrivers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 56L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 28L, this.__io__block, this.__io__blockTable);
   }

   public void setDrivers(ListBase drivers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 56L;
      } else {
         __dna__offset = 28L;
      }

      if (!this.__io__equals(drivers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, drivers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, drivers);
         } else {
            __io__generic__copy(this.getDrivers(), drivers);
         }

      }
   }

   public ListBase getOverrides() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 72L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 36L, this.__io__block, this.__io__blockTable);
   }

   public void setOverrides(ListBase overrides) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 72L;
      } else {
         __dna__offset = 36L;
      }

      if (!this.__io__equals(overrides, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, overrides)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, overrides);
         } else {
            __io__generic__copy(this.getOverrides(), overrides);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 88L) : this.__io__block.readInt(this.__io__address + 44L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 88L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 44L, flag);
      }

   }

   public int getRecalc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 92L) : this.__io__block.readInt(this.__io__address + 48L);
   }

   public void setRecalc(int recalc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 92L, recalc);
      } else {
         this.__io__block.writeInt(this.__io__address + 48L, recalc);
      }

   }

   public short getAct_blendmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 96L) : this.__io__block.readShort(this.__io__address + 52L);
   }

   public void setAct_blendmode(short act_blendmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 96L, act_blendmode);
      } else {
         this.__io__block.writeShort(this.__io__address + 52L, act_blendmode);
      }

   }

   public short getAct_extendmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 98L) : this.__io__block.readShort(this.__io__address + 54L);
   }

   public void setAct_extendmode(short act_extendmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 98L, act_extendmode);
      } else {
         this.__io__block.writeShort(this.__io__address + 54L, act_extendmode);
      }

   }

   public float getAct_influence() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 100L) : this.__io__block.readFloat(this.__io__address + 56L);
   }

   public void setAct_influence(float act_influence) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 100L, act_influence);
      } else {
         this.__io__block.writeFloat(this.__io__address + 56L, act_influence);
      }

   }

   public CPointer<AnimData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{AnimData.class}, this.__io__block, this.__io__blockTable);
   }
}
