package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.metadata;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_15Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_16Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.Particle;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_16;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.ClientboundPackets1_15;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.List;

public class MetadataRewriter1_16To1_15_2 extends EntityRewriter<ClientboundPackets1_15, Protocol1_16To1_15_2> {
   public MetadataRewriter1_16To1_15_2(Protocol1_16To1_15_2 protocol) {
      super(protocol);
      this.mapEntityType(Entity1_15Types.ZOMBIE_PIGMAN, Entity1_16Types.ZOMBIFIED_PIGLIN);
      this.mapTypes(Entity1_15Types.values(), Entity1_16Types.class);
   }

   public void handleMetadata(int entityId, EntityType type, Metadata metadata, List<Metadata> metadatas, UserConnection connection) throws Exception {
      metadata.setMetaType(Types1_16.META_TYPES.byId(metadata.metaType().typeId()));
      int data;
      if (metadata.metaType() == Types1_16.META_TYPES.itemType) {
         ((Protocol1_16To1_15_2)this.protocol).getItemRewriter().handleItemToClient((Item)metadata.getValue());
      } else if (metadata.metaType() == Types1_16.META_TYPES.blockStateType) {
         data = (Integer)metadata.getValue();
         metadata.setValue(((Protocol1_16To1_15_2)this.protocol).getMappingData().getNewBlockStateId(data));
      } else if (metadata.metaType() == Types1_16.META_TYPES.particleType) {
         this.rewriteParticle((Particle)metadata.getValue());
      }

      if (type != null) {
         if (type.isOrHasParent(Entity1_16Types.MINECART_ABSTRACT) && metadata.id() == 10) {
            data = (Integer)metadata.getValue();
            metadata.setValue(((Protocol1_16To1_15_2)this.protocol).getMappingData().getNewBlockStateId(data));
         }

         if (type.isOrHasParent(Entity1_16Types.ABSTRACT_ARROW)) {
            if (metadata.id() == 8) {
               metadatas.remove(metadata);
            } else if (metadata.id() > 8) {
               metadata.setId(metadata.id() - 1);
            }
         }

         if (type == Entity1_16Types.WOLF && metadata.id() == 16) {
            byte mask = (Byte)metadata.value();
            int angerTime = (mask & 2) != 0 ? Integer.MAX_VALUE : 0;
            metadatas.add(new Metadata(20, Types1_16.META_TYPES.varIntType, angerTime));
         }

      }
   }

   public EntityType typeFromId(int type) {
      return Entity1_16Types.getTypeFromId(type);
   }
}
