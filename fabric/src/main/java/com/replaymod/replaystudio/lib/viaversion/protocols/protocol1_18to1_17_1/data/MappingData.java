package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_18to1_17_1.data;

import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.objects.Object2IntMap;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;

public final class MappingData extends MappingDataBase {
   private final Object2IntMap<String> blockEntityIds = new Object2IntOpenHashMap();

   public MappingData() {
      super("1.17", "1.18");
      this.blockEntityIds.defaultReturnValue(-1);
   }

   protected void loadExtras(CompoundTag data) {
      String[] blockEntities = this.blockEntities();

      for(int id = 0; id < blockEntities.length; ++id) {
         this.blockEntityIds.put(blockEntities[id], id);
      }

   }

   public Object2IntMap<String> blockEntityIds() {
      return this.blockEntityIds;
   }

   private String[] blockEntities() {
      return new String[]{"furnace", "chest", "trapped_chest", "ender_chest", "jukebox", "dispenser", "dropper", "sign", "mob_spawner", "piston", "brewing_stand", "enchanting_table", "end_portal", "beacon", "skull", "daylight_detector", "hopper", "comparator", "banner", "structure_block", "end_gateway", "command_block", "shulker_box", "bed", "conduit", "barrel", "smoker", "blast_furnace", "lectern", "bell", "jigsaw", "campfire", "beehive", "sculk_sensor"};
   }
}
