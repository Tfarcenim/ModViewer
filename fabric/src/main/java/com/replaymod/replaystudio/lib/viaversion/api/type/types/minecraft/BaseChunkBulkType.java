package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;

public abstract class BaseChunkBulkType extends Type<Chunk[]> {
   protected BaseChunkBulkType() {
      super(Chunk[].class);
   }

   protected BaseChunkBulkType(String typeName) {
      super(typeName, Chunk[].class);
   }

   public Class<? extends Type> getBaseClass() {
      return BaseChunkBulkType.class;
   }
}
