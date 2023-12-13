package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_20to1_19_4.packets;

import com.replaymod.replaystudio.lib.viaversion.api.data.entity.TrackedEntity;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_19_4Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandler;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_19_4;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_20;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.FloatTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_4to1_19_3.ClientboundPackets1_19_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_20to1_19_4.Protocol1_20To1_19_4;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.Iterator;

public final class EntityPackets extends EntityRewriter<ClientboundPackets1_19_4, Protocol1_20To1_19_4> {
   public EntityPackets(Protocol1_20To1_19_4 protocol) {
      super(protocol);
   }

   public void registerPackets() {
      this.registerMetadataRewriter(ClientboundPackets1_19_4.ENTITY_METADATA, Types1_19_4.METADATA_LIST, Types1_20.METADATA_LIST);
      this.registerRemoveEntities(ClientboundPackets1_19_4.REMOVE_ENTITIES);
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.SPAWN_ENTITY, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.UUID);
            this.map(Type.VAR_INT);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Type.VAR_INT);
            this.handler(EntityPackets.this.trackerHandler());
            this.handler((wrapper) -> {
               int entityId = (Integer)wrapper.get(Type.VAR_INT, 0);
               EntityType entityType = EntityPackets.this.tracker(wrapper.user()).entityType(entityId);
               if (entityType == Entity1_19_4Types.FALLING_BLOCK) {
                  wrapper.set(Type.VAR_INT, 2, ((Protocol1_20To1_19_4)EntityPackets.this.protocol).getMappingData().getNewBlockStateId((Integer)wrapper.get(Type.VAR_INT, 2)));
               } else if (entityType == Entity1_19_4Types.ITEM_DISPLAY) {
                  wrapper.set(Type.BYTE, 0, (byte)(-(Byte)wrapper.get(Type.BYTE, 0)));
                  wrapper.set(Type.BYTE, 1, (byte)((Byte)wrapper.get(Type.BYTE, 1) - 128));
               }

            });
         }
      });
      final PacketHandler displayYawPitchHandler = (wrapper) -> {
         TrackedEntity trackedEntity = this.tracker(wrapper.user()).entity((Integer)wrapper.get(Type.VAR_INT, 0));
         if (trackedEntity != null && trackedEntity.entityType() == Entity1_19_4Types.ITEM_DISPLAY) {
            wrapper.set(Type.BYTE, 0, (byte)((Byte)wrapper.get(Type.BYTE, 0) - 128));
            wrapper.set(Type.BYTE, 1, (byte)(-(Byte)wrapper.get(Type.BYTE, 1)));
         }
      };
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.ENTITY_POSITION_AND_ROTATION, new PacketHandlers() {
         protected void register() {
            this.map(Type.VAR_INT);
            this.map(Type.SHORT);
            this.map(Type.SHORT);
            this.map(Type.SHORT);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.handler(displayYawPitchHandler);
         }
      });
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.ENTITY_ROTATION, new PacketHandlers() {
         protected void register() {
            this.map(Type.VAR_INT);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.handler(displayYawPitchHandler);
         }
      });
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.ENTITY_HEAD_LOOK, (wrapper) -> {
         TrackedEntity trackedEntity = this.tracker(wrapper.user()).entity((Integer)wrapper.passthrough(Type.VAR_INT));
         if (trackedEntity != null && trackedEntity.entityType() == Entity1_19_4Types.ITEM_DISPLAY) {
            wrapper.write(Type.BYTE, (byte)((Byte)wrapper.read(Type.BYTE) - 128));
         }
      });
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.ENTITY_TELEPORT, new PacketHandlers() {
         protected void register() {
            this.map(Type.VAR_INT);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Type.BOOLEAN);
            this.handler((wrapper) -> {
               TrackedEntity trackedEntity = EntityPackets.this.tracker(wrapper.user()).entity((Integer)wrapper.get(Type.VAR_INT, 0));
               if (trackedEntity != null) {
                  if (trackedEntity.entityType() == Entity1_19_4Types.ITEM_DISPLAY) {
                     wrapper.set(Type.BYTE, 0, (byte)((Byte)wrapper.get(Type.BYTE, 0) - 128));
                     wrapper.set(Type.BYTE, 1, (byte)(-(Byte)wrapper.get(Type.BYTE, 1)));
                  }
               }
            });
         }
      });
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.BOOLEAN);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.BYTE);
            this.map(Type.STRING_ARRAY);
            this.map(Type.NBT);
            this.map(Type.STRING);
            this.map(Type.STRING);
            this.map(Type.LONG);
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(Type.BOOLEAN);
            this.map(Type.BOOLEAN);
            this.map(Type.BOOLEAN);
            this.map(Type.BOOLEAN);
            this.map(Type.OPTIONAL_GLOBAL_POSITION);
            this.create(Type.VAR_INT, 0);
            this.handler(EntityPackets.this.dimensionDataHandler());
            this.handler(EntityPackets.this.biomeSizeTracker());
            this.handler(EntityPackets.this.worldDataTrackerHandlerByKey());
            this.handler((wrapper) -> {
               CompoundTag registry = (CompoundTag)wrapper.get(Type.NBT, 0);
               CompoundTag damageTypeRegistry = (CompoundTag)registry.get("minecraft:damage_type");
               ListTag damageTypes = (ListTag)damageTypeRegistry.get("value");
               int highestId = -1;

               IntTag id;
               for(Iterator var5 = damageTypes.iterator(); var5.hasNext(); highestId = Math.max(highestId, id.asInt())) {
                  Tag damageType = (Tag)var5.next();
                  id = (IntTag)((CompoundTag)damageType).get("id");
               }

               CompoundTag outsideBorderReason = new CompoundTag();
               CompoundTag outsideBorderElement = new CompoundTag();
               outsideBorderElement.put("scaling", new StringTag("always"));
               outsideBorderElement.put("exhaustion", new FloatTag(0.0F));
               outsideBorderElement.put("message_id", new StringTag("badRespawnPoint"));
               outsideBorderReason.put("id", new IntTag(highestId + 1));
               outsideBorderReason.put("name", new StringTag("minecraft:outside_border"));
               outsideBorderReason.put("element", outsideBorderElement);
               damageTypes.add(outsideBorderReason);
               CompoundTag genericKillReason = new CompoundTag();
               CompoundTag genericKillElement = new CompoundTag();
               genericKillElement.put("scaling", new StringTag("always"));
               genericKillElement.put("exhaustion", new FloatTag(0.0F));
               genericKillElement.put("message_id", new StringTag("badRespawnPoint"));
               genericKillReason.put("id", new IntTag(highestId + 2));
               genericKillReason.put("name", new StringTag("minecraft:generic_kill"));
               genericKillReason.put("element", genericKillElement);
               damageTypes.add(genericKillReason);
            });
         }
      });
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.RESPAWN, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.map(Type.STRING);
            this.map(Type.LONG);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.BYTE);
            this.map(Type.BOOLEAN);
            this.map(Type.BOOLEAN);
            this.map(Type.BYTE);
            this.map(Type.OPTIONAL_GLOBAL_POSITION);
            this.create(Type.VAR_INT, 0);
            this.handler(EntityPackets.this.worldDataTrackerHandlerByKey());
         }
      });
   }

   protected void registerRewrites() {
      this.filter().handler((event, meta) -> {
         meta.setMetaType(Types1_20.META_TYPES.byId(meta.metaType().typeId()));
      });
      this.registerMetaTypeHandler(Types1_20.META_TYPES.itemType, Types1_20.META_TYPES.blockStateType, Types1_20.META_TYPES.optionalBlockStateType, Types1_20.META_TYPES.particleType);
      this.filter().filterFamily(Entity1_19_4Types.MINECART_ABSTRACT).index(11).handler((event, meta) -> {
         int blockState = (Integer)meta.value();
         meta.setValue(((Protocol1_20To1_19_4)this.protocol).getMappingData().getNewBlockStateId(blockState));
      });
   }

   public EntityType typeFromId(int type) {
      return Entity1_19_4Types.getTypeFromId(type);
   }
}
