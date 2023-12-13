package com.replaymod.replaystudio.lib.viaversion.api.type.types.version;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.MetaListType;
import java.util.List;

public class Types1_12 {
   public static final Type<Metadata> METADATA = new Metadata1_12Type();
   public static final Type<List<Metadata>> METADATA_LIST;

   static {
      METADATA_LIST = new MetaListType(METADATA);
   }
}
