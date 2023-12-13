package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;

public abstract class MetaTypeTemplate extends Type<Metadata> {
   protected MetaTypeTemplate() {
      super("Metadata type", Metadata.class);
   }

   public Class<? extends Type> getBaseClass() {
      return MetaTypeTemplate.class;
   }
}
