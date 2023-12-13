package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_3to1_19_1.packets;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_19_3Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.MetaType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.BitSetType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_19;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_19_3;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_1to1_19.ClientboundPackets1_19_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_3to1_19_1.ClientboundPackets1_19_3;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_3to1_19_1.Protocol1_19_3To1_19_1;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.BitSet;
import java.util.UUID;

public final class EntityPackets extends EntityRewriter<ClientboundPackets1_19_1, Protocol1_19_3To1_19_1> {
   private static final BitSetType PROFILE_ACTIONS_ENUM_TYPE = new BitSetType(6);

   public EntityPackets(Protocol1_19_3To1_19_1 protocol) {
      super(protocol);
   }

   public void registerPackets() {
      this.registerTrackerWithData1_19(ClientboundPackets1_19_1.SPAWN_ENTITY, Entity1_19_3Types.FALLING_BLOCK);
      this.registerMetadataRewriter(ClientboundPackets1_19_1.ENTITY_METADATA, Types1_19.METADATA_LIST, Types1_19_3.METADATA_LIST);
      this.registerRemoveEntities(ClientboundPackets1_19_1.REMOVE_ENTITIES);
      ((Protocol1_19_3To1_19_1)this.protocol).registerClientbound(ClientboundPackets1_19_1.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.BOOLEAN);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.BYTE);
            this.map(Type.STRING_ARRAY);
            this.map(Type.NBT);
            this.map(Type.STRING);
            this.map(Type.STRING);
            this.handler(EntityPackets.this.dimensionDataHandler());
            this.handler(EntityPackets.this.biomeSizeTracker());
            this.handler(EntityPackets.this.worldDataTrackerHandlerByKey());
            this.handler((wrapper) -> {
               PacketWrapper enableFeaturesPacket = wrapper.create(ClientboundPackets1_19_3.UPDATE_ENABLED_FEATURES);
               enableFeaturesPacket.write(Type.VAR_INT, 1);
               enableFeaturesPacket.write(Type.STRING, "minecraft:vanilla");
               enableFeaturesPacket.scheduleSend(Protocol1_19_3To1_19_1.class);
            });
         }
      });
      ((Protocol1_19_3To1_19_1)this.protocol).registerClientbound(ClientboundPackets1_19_1.RESPAWN, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.map(Type.STRING);
            this.map(Type.LONG);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.BYTE);
            this.map(Type.BOOLEAN);
            this.map(Type.BOOLEAN);
            this.handler(EntityPackets.this.worldDataTrackerHandlerByKey());
            this.handler((wrapper) -> {
               boolean keepAttributes = (Boolean)wrapper.read(Type.BOOLEAN);
               byte keepDataMask = 2;
               if (keepAttributes) {
                  keepDataMask = (byte)(keepDataMask | 1);
               }

               wrapper.write(Type.BYTE, keepDataMask);
            });
         }
      });
      ((Protocol1_19_3To1_19_1)this.protocol).registerClientbound(ClientboundPackets1_19_1.PLAYER_INFO, ClientboundPackets1_19_3.PLAYER_INFO_UPDATE, (wrapper) -> {
         int action = (Integer)wrapper.read(Type.VAR_INT);
         int i;
         if (action == 4) {
            int entriesx = (Integer)wrapper.read(Type.VAR_INT);
            UUID[] uuidsToRemove = new UUID[entriesx];

            for(i = 0; i < entriesx; ++i) {
               uuidsToRemove[i] = (UUID)wrapper.read(Type.UUID);
            }

            wrapper.write(Type.UUID_ARRAY, uuidsToRemove);
            wrapper.setPacketType(ClientboundPackets1_19_3.PLAYER_INFO_REMOVE);
         } else {
            BitSet set = new BitSet(6);
            if (action == 0) {
               set.set(0, 6);
            } else {
               set.set(action == 1 ? action + 1 : action + 2);
            }

            wrapper.write(PROFILE_ACTIONS_ENUM_TYPE, set);
            int entries = (Integer)wrapper.passthrough(Type.VAR_INT);

            for(i = 0; i < entries; ++i) {
               wrapper.passthrough(Type.UUID);
               if (action != 0) {
                  if (action != 1 && action != 2) {
                     if (action == 3) {
                        wrapper.passthrough(Type.OPTIONAL_COMPONENT);
                     }
                  } else {
                     wrapper.passthrough(Type.VAR_INT);
                  }
               } else {
                  wrapper.passthrough(Type.STRING);
                  int properties = (Integer)wrapper.passthrough(Type.VAR_INT);

                  int gamemode;
                  for(gamemode = 0; gamemode < properties; ++gamemode) {
                     wrapper.passthrough(Type.STRING);
                     wrapper.passthrough(Type.STRING);
                     wrapper.passthrough(Type.OPTIONAL_STRING);
                  }

                  gamemode = (Integer)wrapper.read(Type.VAR_INT);
                  int ping = (Integer)wrapper.read(Type.VAR_INT);
                  JsonElement displayName = (JsonElement)wrapper.read(Type.OPTIONAL_COMPONENT);
                  wrapper.read(Type.OPTIONAL_PROFILE_KEY);
                  wrapper.write(Type.BOOLEAN, false);
                  wrapper.write(Type.VAR_INT, gamemode);
                  wrapper.write(Type.BOOLEAN, true);
                  wrapper.write(Type.VAR_INT, ping);
                  wrapper.write(Type.OPTIONAL_COMPONENT, displayName);
               }
            }

         }
      });
   }

   protected void registerRewrites() {
      this.filter().handler((event, meta) -> {
         int id = meta.metaType().typeId();
         meta.setMetaType(Types1_19_3.META_TYPES.byId(id >= 2 ? id + 1 : id));
      });
      this.registerMetaTypeHandler(Types1_19_3.META_TYPES.itemType, Types1_19_3.META_TYPES.blockStateType, (MetaType)null, Types1_19_3.META_TYPES.particleType);
      this.filter().index(6).handler((event, meta) -> {
         int pose = (Integer)meta.value();
         if (pose >= 10) {
            meta.setValue(pose + 1);
         }

      });
      this.filter().filterFamily(Entity1_19_3Types.MINECART_ABSTRACT).index(11).handler((event, meta) -> {
         int data = (Integer)meta.getValue();
         meta.setValue(((Protocol1_19_3To1_19_1)this.protocol).getMappingData().getNewBlockStateId(data));
      });
   }

   public void onMappingDataLoaded() {
      this.mapTypes();
   }

   public EntityType typeFromId(int type) {
      return Entity1_19_3Types.getTypeFromId(type);
   }
}
