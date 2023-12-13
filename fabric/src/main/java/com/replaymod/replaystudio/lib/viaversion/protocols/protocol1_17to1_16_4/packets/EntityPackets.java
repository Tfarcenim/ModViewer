package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_17to1_16_4.packets;

import com.replaymod.replaystudio.lib.viaversion.api.data.entity.EntityTracker;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_16_2Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_17Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.MetaType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_16;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_17;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_2to1_16_1.ClientboundPackets1_16_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_17to1_16_4.ClientboundPackets1_17;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_17to1_16_4.Protocol1_17To1_16_4;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.Iterator;

public final class EntityPackets extends EntityRewriter<ClientboundPackets1_16_2, Protocol1_17To1_16_4> {
   public EntityPackets(Protocol1_17To1_16_4 protocol) {
      super(protocol);
      this.mapTypes(Entity1_16_2Types.values(), Entity1_17Types.class);
   }

   public void registerPackets() {
      this.registerTrackerWithData(ClientboundPackets1_16_2.SPAWN_ENTITY, Entity1_17Types.FALLING_BLOCK);
      this.registerTracker(ClientboundPackets1_16_2.SPAWN_MOB);
      this.registerTracker(ClientboundPackets1_16_2.SPAWN_PLAYER, Entity1_17Types.PLAYER);
      this.registerMetadataRewriter(ClientboundPackets1_16_2.ENTITY_METADATA, Types1_16.METADATA_LIST, Types1_17.METADATA_LIST);
      ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_16_2.DESTROY_ENTITIES, (ClientboundPacketType)null, (wrapper) -> {
         int[] entityIds = (int[])wrapper.read(Type.VAR_INT_ARRAY_PRIMITIVE);
         wrapper.cancel();
         EntityTracker entityTracker = wrapper.user().getEntityTracker(Protocol1_17To1_16_4.class);
         int[] var3 = entityIds;
         int var4 = entityIds.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            int entityId = var3[var5];
            entityTracker.removeEntity(entityId);
            PacketWrapper newPacket = wrapper.create(ClientboundPackets1_17.REMOVE_ENTITY);
            newPacket.write(Type.VAR_INT, entityId);
            newPacket.send(Protocol1_17To1_16_4.class);
         }

      });
      ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_16_2.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.BOOLEAN);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.BYTE);
            this.map(Type.STRING_ARRAY);
            this.map(Type.NBT);
            this.map(Type.NBT);
            this.handler((wrapper) -> {
               CompoundTag dimensionRegistry = (CompoundTag)((CompoundTag)wrapper.get(Type.NBT, 0)).get("minecraft:dimension_type");
               ListTag dimensions = (ListTag)dimensionRegistry.get("value");
               Iterator var3 = dimensions.iterator();

               while(var3.hasNext()) {
                  Tag dimension = (Tag)var3.next();
                  CompoundTag dimensionCompound = (CompoundTag)((CompoundTag)dimension).get("element");
                  EntityPackets.addNewDimensionData(dimensionCompound);
               }

               CompoundTag currentDimensionTag = (CompoundTag)wrapper.get(Type.NBT, 1);
               EntityPackets.addNewDimensionData(currentDimensionTag);
            });
            this.handler(EntityPackets.this.playerTrackerHandler());
         }
      });
      ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_16_2.RESPAWN, (wrapper) -> {
         CompoundTag dimensionData = (CompoundTag)wrapper.passthrough(Type.NBT);
         addNewDimensionData(dimensionData);
      });
      ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_16_2.ENTITY_PROPERTIES, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               wrapper.write(Type.VAR_INT, wrapper.read(Type.INT));
            });
         }
      });
      ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_16_2.PLAYER_POSITION, new PacketHandlers() {
         public void register() {
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.BYTE);
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               wrapper.write(Type.BOOLEAN, false);
            });
         }
      });
      ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_16_2.COMBAT_EVENT, (ClientboundPacketType)null, (wrapper) -> {
         int type = (Integer)wrapper.read(Type.VAR_INT);
         ClientboundPackets1_17 packetType;
         switch(type) {
         case 0:
            packetType = ClientboundPackets1_17.COMBAT_ENTER;
            break;
         case 1:
            packetType = ClientboundPackets1_17.COMBAT_END;
            break;
         case 2:
            packetType = ClientboundPackets1_17.COMBAT_KILL;
            break;
         default:
            throw new IllegalArgumentException("Invalid combat type received: " + type);
         }

         wrapper.setPacketType(packetType);
      });
      ((Protocol1_17To1_16_4)this.protocol).cancelClientbound(ClientboundPackets1_16_2.ENTITY_MOVEMENT);
   }

   protected void registerRewrites() {
      this.filter().handler((event, meta) -> {
         meta.setMetaType(Types1_17.META_TYPES.byId(meta.metaType().typeId()));
         if (meta.metaType() == Types1_17.META_TYPES.poseType) {
            int pose = (Integer)meta.value();
            if (pose > 5) {
               meta.setValue(pose + 1);
            }
         }

      });
      this.registerMetaTypeHandler(Types1_17.META_TYPES.itemType, Types1_17.META_TYPES.blockStateType, (MetaType)null, Types1_17.META_TYPES.particleType);
      this.filter().filterFamily(Entity1_17Types.ENTITY).addIndex(7);
      this.filter().filterFamily(Entity1_17Types.MINECART_ABSTRACT).index(11).handler((event, meta) -> {
         int data = (Integer)meta.getValue();
         meta.setValue(((Protocol1_17To1_16_4)this.protocol).getMappingData().getNewBlockStateId(data));
      });
      this.filter().type(Entity1_17Types.SHULKER).removeIndex(17);
   }

   public EntityType typeFromId(int type) {
      return Entity1_17Types.getTypeFromId(type);
   }

   private static void addNewDimensionData(CompoundTag tag) {
      tag.put("min_y", new IntTag(0));
      tag.put("height", new IntTag(256));
   }
}
