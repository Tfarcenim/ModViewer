package com.replaymod.replaystudio.lib.viaversion.rewriter.meta;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;

@FunctionalInterface
public interface MetaHandler {
   void handle(MetaHandlerEvent var1, Metadata var2);
}
