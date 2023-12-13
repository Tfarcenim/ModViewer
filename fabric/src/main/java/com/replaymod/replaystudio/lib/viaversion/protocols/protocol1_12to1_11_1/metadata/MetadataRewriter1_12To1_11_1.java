package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12to1_11_1.metadata;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_12Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12to1_11_1.Protocol1_12To1_11_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ClientboundPackets1_9_3;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.List;

public class MetadataRewriter1_12To1_11_1 extends EntityRewriter<ClientboundPackets1_9_3, Protocol1_12To1_11_1> {
   public MetadataRewriter1_12To1_11_1(Protocol1_12To1_11_1 protocol) {
      super(protocol);
   }

   protected void handleMetadata(int entityId, EntityType type, Metadata metadata, List<Metadata> metadatas, UserConnection connection) {
      if (metadata.getValue() instanceof Item) {
         metadata.setValue(((Protocol1_12To1_11_1)this.protocol).getItemRewriter().handleItemToClient((Item)metadata.getValue()));
      }

      if (type != null) {
         if (type == Entity1_12Types.EntityType.EVOCATION_ILLAGER && metadata.id() == 12) {
            metadata.setId(13);
         }

      }
   }

   public EntityType typeFromId(int type) {
      return Entity1_12Types.getTypeFromId(type, false);
   }

   public EntityType objectTypeFromId(int type) {
      return Entity1_12Types.getTypeFromId(type, true);
   }
}
