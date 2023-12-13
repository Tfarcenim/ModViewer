package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_1to1_14.metadata;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_14Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_1to1_14.Protocol1_14_1To1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.ClientboundPackets1_14;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.List;

public class MetadataRewriter1_14_1To1_14 extends EntityRewriter<ClientboundPackets1_14, Protocol1_14_1To1_14> {
   public MetadataRewriter1_14_1To1_14(Protocol1_14_1To1_14 protocol) {
      super(protocol);
   }

   public void handleMetadata(int entityId, EntityType type, Metadata metadata, List<Metadata> metadatas, UserConnection connection) {
      if (type != null) {
         if ((type == Entity1_14Types.VILLAGER || type == Entity1_14Types.WANDERING_TRADER) && metadata.id() >= 15) {
            metadata.setId(metadata.id() + 1);
         }

      }
   }

   public EntityType typeFromId(int type) {
      return Entity1_14Types.getTypeFromId(type);
   }
}
