package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.metadata;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_13Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.Particle;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12_1to1_12.ClientboundPackets1_12_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.data.EntityTypeRewriter;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.data.ParticleRewriter;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.packets.WorldPackets;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.List;

public class MetadataRewriter1_13To1_12_2 extends EntityRewriter<ClientboundPackets1_12_1, Protocol1_13To1_12_2> {
   public MetadataRewriter1_13To1_12_2(Protocol1_13To1_12_2 protocol) {
      super(protocol);
   }

   protected void handleMetadata(int entityId, EntityType type, Metadata metadata, List<Metadata> metadatas, UserConnection connection) throws Exception {
      if (metadata.metaType().typeId() > 4) {
         metadata.setMetaType(Types1_13.META_TYPES.byId(metadata.metaType().typeId() + 1));
      } else {
         metadata.setMetaType(Types1_13.META_TYPES.byId(metadata.metaType().typeId()));
      }

      if (metadata.id() == 2) {
         if (metadata.getValue() != null && !((String)metadata.getValue()).isEmpty()) {
            metadata.setTypeAndValue(Types1_13.META_TYPES.optionalComponentType, ChatRewriter.legacyTextToJson((String)metadata.getValue()));
         } else {
            metadata.setTypeAndValue(Types1_13.META_TYPES.optionalComponentType, (Object)null);
         }
      }

      int particleId;
      int combined;
      int newId;
      if (type == Entity1_13Types.EntityType.ENDERMAN && metadata.id() == 12) {
         particleId = (Integer)metadata.getValue();
         combined = particleId & 4095;
         newId = particleId >> 12 & 15;
         metadata.setValue(combined << 4 | newId & 15);
      }

      if (metadata.metaType() == Types1_13.META_TYPES.itemType) {
         metadata.setMetaType(Types1_13.META_TYPES.itemType);
         ((Protocol1_13To1_12_2)this.protocol).getItemRewriter().handleItemToClient((Item)metadata.getValue());
      } else if (metadata.metaType() == Types1_13.META_TYPES.blockStateType) {
         metadata.setValue(WorldPackets.toNewId((Integer)metadata.getValue()));
      }

      if (type != null) {
         if (type == Entity1_13Types.EntityType.WOLF && metadata.id() == 17) {
            metadata.setValue(15 - (Integer)metadata.getValue());
         }

         if (type.isOrHasParent(Entity1_13Types.EntityType.ZOMBIE) && metadata.id() > 14) {
            metadata.setId(metadata.id() + 1);
         }

         if (type.isOrHasParent(Entity1_13Types.EntityType.MINECART_ABSTRACT) && metadata.id() == 9) {
            particleId = (Integer)metadata.getValue();
            combined = (particleId & 4095) << 4 | particleId >> 12 & 15;
            newId = WorldPackets.toNewId(combined);
            metadata.setValue(newId);
         }

         if (type == Entity1_13Types.EntityType.AREA_EFFECT_CLOUD) {
            if (metadata.id() == 9) {
               particleId = (Integer)metadata.getValue();
               Metadata parameter1Meta = this.metaByIndex(10, metadatas);
               Metadata parameter2Meta = this.metaByIndex(11, metadatas);
               int parameter1 = parameter1Meta != null ? (Integer)parameter1Meta.getValue() : 0;
               int parameter2 = parameter2Meta != null ? (Integer)parameter2Meta.getValue() : 0;
               Particle particle = ParticleRewriter.rewriteParticle(particleId, new Integer[]{parameter1, parameter2});
               if (particle != null && particle.getId() != -1) {
                  metadatas.add(new Metadata(9, Types1_13.META_TYPES.particleType, particle));
               }
            }

            if (metadata.id() >= 9) {
               metadatas.remove(metadata);
            }
         }

         if (metadata.id() == 0) {
            metadata.setValue((byte)((Byte)metadata.getValue() & -17));
         }

      }
   }

   public int newEntityId(int id) {
      return EntityTypeRewriter.getNewId(id);
   }

   public EntityType typeFromId(int type) {
      return Entity1_13Types.getTypeFromId(type, false);
   }

   public EntityType objectTypeFromId(int type) {
      return Entity1_13Types.getTypeFromId(type, true);
   }
}
