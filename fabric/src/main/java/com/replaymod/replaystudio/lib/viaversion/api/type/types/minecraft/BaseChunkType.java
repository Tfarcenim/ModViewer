package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;

public abstract class BaseChunkType extends Type<Chunk> {
   protected BaseChunkType() {
      super(Chunk.class);
   }

   protected BaseChunkType(String typeName) {
      super(typeName, Chunk.class);
   }

   public Class<? extends Type> getBaseClass() {
      return BaseChunkType.class;
   }
}
