package com.replaymod.replaystudio.lib.viaversion.api.type.types.version;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.MetaListType;
import java.util.List;

public class Types1_8 {
   public static final Type<Metadata> METADATA = new Metadata1_8Type();
   public static final Type<List<Metadata>> METADATA_LIST;
   public static final Type<ChunkSection> CHUNK_SECTION;

   static {
      METADATA_LIST = new MetaListType(METADATA);
      CHUNK_SECTION = new ChunkSectionType1_8();
   }
}
