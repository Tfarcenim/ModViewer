package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import java.util.List;

public abstract class MetaListTypeTemplate extends Type<List<Metadata>> {
   protected MetaListTypeTemplate() {
      super("MetaData List", List.class);
   }

   public Class<? extends Type> getBaseClass() {
      return MetaListTypeTemplate.class;
   }
}
