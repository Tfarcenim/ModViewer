package com.replaymod.replaystudio.lib.viaversion.api.rewriter;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.data.entity.EntityTracker;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import java.util.List;

public interface EntityRewriter<T extends Protocol> extends Rewriter<T> {
   EntityType typeFromId(int var1);

   default EntityType objectTypeFromId(int type) {
      return this.typeFromId(type);
   }

   int newEntityId(int var1);

   void handleMetadata(int var1, List<Metadata> var2, UserConnection var3);

   default <E extends EntityTracker> E tracker(UserConnection connection) {
      return connection.getEntityTracker(this.protocol().getClass());
   }
}
