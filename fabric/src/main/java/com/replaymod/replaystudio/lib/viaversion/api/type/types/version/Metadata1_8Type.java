package com.replaymod.replaystudio.lib.viaversion.api.type.types.version;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.MetaType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.types.MetaType1_8;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.OldMetaType;

public class Metadata1_8Type extends OldMetaType {
   protected MetaType getType(int index) {
      return MetaType1_8.byId(index);
   }
}
