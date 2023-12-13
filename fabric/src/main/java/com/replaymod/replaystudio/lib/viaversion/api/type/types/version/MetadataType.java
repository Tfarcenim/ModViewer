package com.replaymod.replaystudio.lib.viaversion.api.type.types.version;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.MetaType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.types.MetaTypes;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ModernMetaType;

public final class MetadataType extends ModernMetaType {
   private final MetaTypes metaTypes;

   public MetadataType(MetaTypes metaTypes) {
      this.metaTypes = metaTypes;
   }

   protected MetaType getType(int index) {
      return this.metaTypes.byId(index);
   }
}
