package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_2to1_16_1.packets;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_16_2Types;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_16;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_2to1_16_1.Protocol1_16_2To1_16_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16_2to1_16_1.metadata.MetadataRewriter1_16_2To1_16_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.ClientboundPackets1_16;

public class EntityPackets {
   public static void register(Protocol1_16_2To1_16_1 protocol) {
      final MetadataRewriter1_16_2To1_16_1 metadataRewriter = (MetadataRewriter1_16_2To1_16_1)protocol.get(MetadataRewriter1_16_2To1_16_1.class);
      metadataRewriter.registerTrackerWithData(ClientboundPackets1_16.SPAWN_ENTITY, Entity1_16_2Types.FALLING_BLOCK);
      metadataRewriter.registerTracker(ClientboundPackets1_16.SPAWN_MOB);
      metadataRewriter.registerTracker(ClientboundPackets1_16.SPAWN_PLAYER, Entity1_16_2Types.PLAYER);
      metadataRewriter.registerMetadataRewriter(ClientboundPackets1_16.ENTITY_METADATA, Types1_16.METADATA_LIST);
      metadataRewriter.registerRemoveEntities(ClientboundPackets1_16.DESTROY_ENTITIES);
      protocol.registerClientbound(ClientboundPackets1_16.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.handler((wrapper) -> {
               short gamemode = (Short)wrapper.read(Type.UNSIGNED_BYTE);
               wrapper.write(Type.BOOLEAN, (gamemode & 8) != 0);
               gamemode = (short)(gamemode & -9);
               wrapper.write(Type.UNSIGNED_BYTE, gamemode);
            });
            this.map(Type.BYTE);
            this.map(Type.STRING_ARRAY);
            this.handler((wrapper) -> {
               wrapper.read(Type.NBT);
               wrapper.write(Type.NBT, protocol.getMappingData().getDimensionRegistry());
               String dimensionType = (String)wrapper.read(Type.STRING);
               wrapper.write(Type.NBT, EntityPackets.getDimensionData(dimensionType));
            });
            this.map(Type.STRING);
            this.map(Type.LONG);
            this.map(Type.UNSIGNED_BYTE, Type.VAR_INT);
            this.handler(metadataRewriter.playerTrackerHandler());
         }
      });
      protocol.registerClientbound(ClientboundPackets1_16.RESPAWN, (wrapper) -> {
         String dimensionType = (String)wrapper.read(Type.STRING);
         wrapper.write(Type.NBT, getDimensionData(dimensionType));
      });
   }

   public static CompoundTag getDimensionData(String dimensionType) {
      CompoundTag tag = (CompoundTag)Protocol1_16_2To1_16_1.MAPPINGS.getDimensionDataMap().get(dimensionType);
      if (tag == null) {
         Via.getPlatform().getLogger().severe("Could not get dimension data of " + dimensionType);
         throw new NullPointerException("Dimension data for " + dimensionType + " is null!");
      } else {
         return tag.clone();
      }
   }
}
