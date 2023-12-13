package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_2to1_16_1.metadata;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_16Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_16_2Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.Particle;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_16;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_2to1_16_1.Protocol1_16_2To1_16_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.ClientboundPackets1_16;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.List;

public class MetadataRewriter1_16_2To1_16_1 extends EntityRewriter<ClientboundPackets1_16, Protocol1_16_2To1_16_1> {
   public MetadataRewriter1_16_2To1_16_1(Protocol1_16_2To1_16_1 protocol) {
      super(protocol);
      this.mapTypes(Entity1_16Types.values(), Entity1_16_2Types.class);
   }

   public void handleMetadata(int entityId, EntityType type, Metadata metadata, List<Metadata> metadatas, UserConnection connection) throws Exception {
      int data;
      if (metadata.metaType() == Types1_16.META_TYPES.itemType) {
         ((Protocol1_16_2To1_16_1)this.protocol).getItemRewriter().handleItemToClient((Item)metadata.getValue());
      } else if (metadata.metaType() == Types1_16.META_TYPES.blockStateType) {
         data = (Integer)metadata.getValue();
         metadata.setValue(((Protocol1_16_2To1_16_1)this.protocol).getMappingData().getNewBlockStateId(data));
      } else if (metadata.metaType() == Types1_16.META_TYPES.particleType) {
         this.rewriteParticle((Particle)metadata.getValue());
      }

      if (type != null) {
         if (type.isOrHasParent(Entity1_16_2Types.MINECART_ABSTRACT) && metadata.id() == 10) {
            data = (Integer)metadata.getValue();
            metadata.setValue(((Protocol1_16_2To1_16_1)this.protocol).getMappingData().getNewBlockStateId(data));
         }

         if (type.isOrHasParent(Entity1_16_2Types.ABSTRACT_PIGLIN)) {
            if (metadata.id() == 15) {
               metadata.setId(16);
            } else if (metadata.id() == 16) {
               metadata.setId(15);
            }
         }

      }
   }

   public EntityType typeFromId(int type) {
      return Entity1_16_2Types.getTypeFromId(type);
   }
}
