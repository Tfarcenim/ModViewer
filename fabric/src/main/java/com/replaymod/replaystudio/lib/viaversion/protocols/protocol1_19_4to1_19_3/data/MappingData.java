package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_4to1_19_3.data;

import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataLoader;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.nbt.BinaryTagIO;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import java.io.IOException;

public final class MappingData extends MappingDataBase {
   private CompoundTag damageTypesRegistry;

   public MappingData() {
      super("1.19.3", "1.19.4");
   }

   protected void loadExtras(CompoundTag data) {
      try {
         this.damageTypesRegistry = BinaryTagIO.readInputStream(MappingDataLoader.getResource("damage-types-1.19.4.nbt"));
      } catch (IOException var3) {
         throw new RuntimeException(var3);
      }
   }

   public CompoundTag damageTypesRegistry() {
      return this.damageTypesRegistry.clone();
   }
}
