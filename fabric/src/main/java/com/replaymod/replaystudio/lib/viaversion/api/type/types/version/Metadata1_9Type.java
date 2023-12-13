package com.replaymod.replaystudio.lib.viaversion.api.type.types.version;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.MetaType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.types.MetaType1_9;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ModernMetaType;

public class Metadata1_9Type extends ModernMetaType {
   protected MetaType getType(int index) {
      return MetaType1_9.byId(index);
   }
}
