package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 48L,
   size64 = 48L
)
public class bAnimVizSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 346;
   public static final long[] __DNA__FIELD__ghost_sf = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__ghost_ef = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__ghost_bc = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__ghost_ac = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__ghost_type = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__ghost_step = new long[]{18L, 18L};
   public static final long[] __DNA__FIELD__ghost_flag = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__recalc = new long[]{22L, 22L};
   public static final long[] __DNA__FIELD__path_type = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__path_step = new long[]{26L, 26L};
   public static final long[] __DNA__FIELD__path_viewflag = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__path_bakeflag = new long[]{30L, 30L};
   public static final long[] __DNA__FIELD__path_sf = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__path_ef = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__path_bc = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__path_ac = new long[]{44L, 44L};

   public bAnimVizSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bAnimVizSettings(bAnimVizSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getGhost_sf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setGhost_sf(int ghost_sf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, ghost_sf);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, ghost_sf);
      }

   }

   public int getGhost_ef() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setGhost_ef(int ghost_ef) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, ghost_ef);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, ghost_ef);
      }

   }

   public int getGhost_bc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setGhost_bc(int ghost_bc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, ghost_bc);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, ghost_bc);
      }

   }

   public int getGhost_ac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setGhost_ac(int ghost_ac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, ghost_ac);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, ghost_ac);
      }

   }

   public short getGhost_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 16L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setGhost_type(short ghost_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 16L, ghost_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, ghost_type);
      }

   }

   public short getGhost_step() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setGhost_step(short ghost_step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, ghost_step);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, ghost_step);
      }

   }

   public short getGhost_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 20L) : this.__io__block.readShort(this.__io__address + 20L);
   }

   public void setGhost_flag(short ghost_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 20L, ghost_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 20L, ghost_flag);
      }

   }

   public short getRecalc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 22L) : this.__io__block.readShort(this.__io__address + 22L);
   }

   public void setRecalc(short recalc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 22L, recalc);
      } else {
         this.__io__block.writeShort(this.__io__address + 22L, recalc);
      }

   }

   public short getPath_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 24L) : this.__io__block.readShort(this.__io__address + 24L);
   }

   public void setPath_type(short path_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 24L, path_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 24L, path_type);
      }

   }

   public short getPath_step() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 26L) : this.__io__block.readShort(this.__io__address + 26L);
   }

   public void setPath_step(short path_step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 26L, path_step);
      } else {
         this.__io__block.writeShort(this.__io__address + 26L, path_step);
      }

   }

   public short getPath_viewflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 28L) : this.__io__block.readShort(this.__io__address + 28L);
   }

   public void setPath_viewflag(short path_viewflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 28L, path_viewflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 28L, path_viewflag);
      }

   }

   public short getPath_bakeflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 30L) : this.__io__block.readShort(this.__io__address + 30L);
   }

   public void setPath_bakeflag(short path_bakeflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 30L, path_bakeflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 30L, path_bakeflag);
      }

   }

   public int getPath_sf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 32L);
   }

   public void setPath_sf(int path_sf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, path_sf);
      } else {
         this.__io__block.writeInt(this.__io__address + 32L, path_sf);
      }

   }

   public int getPath_ef() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 36L);
   }

   public void setPath_ef(int path_ef) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, path_ef);
      } else {
         this.__io__block.writeInt(this.__io__address + 36L, path_ef);
      }

   }

   public int getPath_bc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setPath_bc(int path_bc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, path_bc);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, path_bc);
      }

   }

   public int getPath_ac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 44L) : this.__io__block.readInt(this.__io__address + 44L);
   }

   public void setPath_ac(int path_ac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 44L, path_ac);
      } else {
         this.__io__block.writeInt(this.__io__address + 44L, path_ac);
      }

   }

   public CPointer<bAnimVizSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bAnimVizSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
