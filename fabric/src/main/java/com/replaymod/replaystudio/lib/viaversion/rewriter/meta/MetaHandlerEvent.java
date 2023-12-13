package com.replaymod.replaystudio.lib.viaversion.rewriter.meta;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface MetaHandlerEvent {
   UserConnection user();

   int entityId();

   @Nullable
   EntityType entityType();

   default int index() {
      return this.meta().id();
   }

   default void setIndex(int index) {
      this.meta().setId(index);
   }

   Metadata meta();

   void cancel();

   boolean cancelled();

   @Nullable
   Metadata metaAtIndex(int var1);

   List<Metadata> metadataList();

   @Nullable
   List<Metadata> extraMeta();

   void createExtraMeta(Metadata var1);
}
