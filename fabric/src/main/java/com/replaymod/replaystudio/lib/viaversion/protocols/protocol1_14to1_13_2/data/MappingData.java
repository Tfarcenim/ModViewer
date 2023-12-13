package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.data;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataLoader;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntSet;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntArrayTag;

public class MappingData extends MappingDataBase {
   private IntSet motionBlocking;
   private IntSet nonFullBlocks;

   public MappingData() {
      super("1.13.2", "1.14");
   }

   public void loadExtras(CompoundTag data) {
      CompoundTag heightmap = MappingDataLoader.loadNBT("heightmap-1.14.nbt");
      IntArrayTag motionBlocking = (IntArrayTag)heightmap.get("motionBlocking");
      this.motionBlocking = new IntOpenHashSet(motionBlocking.getValue());
      if (Via.getConfig().isNonFullBlockLightFix()) {
         IntArrayTag nonFullBlocks = (IntArrayTag)heightmap.get("nonFullBlocks");
         this.nonFullBlocks = new IntOpenHashSet(nonFullBlocks.getValue());
      }

   }

   public IntSet getMotionBlocking() {
      return this.motionBlocking;
   }

   public IntSet getNonFullBlocks() {
      return this.nonFullBlocks;
   }
}
