package com.replaymod.replaystudio.lib.viaversion.api.type.types.version;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.types.MetaTypes1_13;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.MetaListType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ParticleType;
import java.util.List;

public final class Types1_13 {
   public static final Type<ChunkSection> CHUNK_SECTION = new ChunkSectionType1_13();
   public static final ParticleType PARTICLE = new ParticleType();
   public static final MetaTypes1_13 META_TYPES;
   public static final Type<Metadata> METADATA;
   public static final Type<List<Metadata>> METADATA_LIST;

   static {
      META_TYPES = new MetaTypes1_13(PARTICLE);
      METADATA = new MetadataType(META_TYPES);
      METADATA_LIST = new MetaListType(METADATA);
   }
}
