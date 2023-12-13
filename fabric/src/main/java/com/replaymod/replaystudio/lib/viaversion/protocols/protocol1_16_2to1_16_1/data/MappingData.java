package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_2to1_16_1.data;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataLoader;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.nbt.BinaryTagIO;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MappingData extends MappingDataBase {
   private final Map<String, CompoundTag> dimensionDataMap = new HashMap();
   private CompoundTag dimensionRegistry;

   public MappingData() {
      super("1.16", "1.16.2");
   }

   public void loadExtras(CompoundTag data) {
      try {
         this.dimensionRegistry = BinaryTagIO.readInputStream(MappingDataLoader.getResource("dimension-registry-1.16.2.nbt"));
      } catch (IOException var7) {
         Via.getPlatform().getLogger().severe("Error loading dimension registry:");
         var7.printStackTrace();
      }

      ListTag dimensions = (ListTag)((CompoundTag)this.dimensionRegistry.get("minecraft:dimension_type")).get("value");
      Iterator var3 = dimensions.iterator();

      while(var3.hasNext()) {
         Tag dimension = (Tag)var3.next();
         CompoundTag dimensionCompound = (CompoundTag)dimension;
         CompoundTag dimensionData = new CompoundTag(((CompoundTag)dimensionCompound.get("element")).getValue());
         this.dimensionDataMap.put(((StringTag)dimensionCompound.get("name")).getValue(), dimensionData);
      }

   }

   public Map<String, CompoundTag> getDimensionDataMap() {
      return this.dimensionDataMap;
   }

   public CompoundTag getDimensionRegistry() {
      return this.dimensionRegistry.clone();
   }
}
