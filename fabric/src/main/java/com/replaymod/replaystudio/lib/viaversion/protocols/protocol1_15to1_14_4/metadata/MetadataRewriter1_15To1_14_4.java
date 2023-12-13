package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.metadata;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_15Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.Particle;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_4to1_14_3.ClientboundPackets1_14_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.Protocol1_15To1_14_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.packets.EntityPackets;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.List;

public class MetadataRewriter1_15To1_14_4 extends EntityRewriter<ClientboundPackets1_14_4, Protocol1_15To1_14_4> {
   public MetadataRewriter1_15To1_14_4(Protocol1_15To1_14_4 protocol) {
      super(protocol);
   }

   public void handleMetadata(int entityId, EntityType type, Metadata metadata, List<Metadata> metadatas, UserConnection connection) throws Exception {
      int data;
      if (metadata.metaType() == Types1_14.META_TYPES.itemType) {
         ((Protocol1_15To1_14_4)this.protocol).getItemRewriter().handleItemToClient((Item)metadata.getValue());
      } else if (metadata.metaType() == Types1_14.META_TYPES.blockStateType) {
         data = (Integer)metadata.getValue();
         metadata.setValue(((Protocol1_15To1_14_4)this.protocol).getMappingData().getNewBlockStateId(data));
      } else if (metadata.metaType() == Types1_14.META_TYPES.particleType) {
         this.rewriteParticle((Particle)metadata.getValue());
      }

      if (type != null) {
         if (type.isOrHasParent(Entity1_15Types.MINECART_ABSTRACT) && metadata.id() == 10) {
            data = (Integer)metadata.getValue();
            metadata.setValue(((Protocol1_15To1_14_4)this.protocol).getMappingData().getNewBlockStateId(data));
         }

         if (metadata.id() > 11 && type.isOrHasParent(Entity1_15Types.LIVINGENTITY)) {
            metadata.setId(metadata.id() + 1);
         }

         if (type.isOrHasParent(Entity1_15Types.WOLF)) {
            if (metadata.id() == 18) {
               metadatas.remove(metadata);
            } else if (metadata.id() > 18) {
               metadata.setId(metadata.id() - 1);
            }
         }

      }
   }

   public int newEntityId(int id) {
      return EntityPackets.getNewEntityId(id);
   }

   public EntityType typeFromId(int type) {
      return Entity1_15Types.getTypeFromId(type);
   }
}
