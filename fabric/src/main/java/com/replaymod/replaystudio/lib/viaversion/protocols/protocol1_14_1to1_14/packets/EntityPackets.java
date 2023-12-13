package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_1to1_14.packets;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_14Types;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_1to1_14.Protocol1_14_1To1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_1to1_14.metadata.MetadataRewriter1_14_1To1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.ClientboundPackets1_14;

public class EntityPackets {
   public static void register(Protocol1_14_1To1_14 protocol) {
      final MetadataRewriter1_14_1To1_14 metadataRewriter = (MetadataRewriter1_14_1To1_14)protocol.get(MetadataRewriter1_14_1To1_14.class);
      protocol.registerClientbound(ClientboundPackets1_14.SPAWN_MOB, new PacketHandlers() {
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
            this.map(Type.SHORT);
            this.map(Type.SHORT);
            this.map(Type.SHORT);
            this.map(Types1_14.METADATA_LIST);
            this.handler(metadataRewriter.trackerAndRewriterHandler(Types1_14.METADATA_LIST));
         }
      });
      metadataRewriter.registerRemoveEntities(ClientboundPackets1_14.DESTROY_ENTITIES);
      protocol.registerClientbound(ClientboundPackets1_14.SPAWN_PLAYER, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.UUID);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Types1_14.METADATA_LIST);
            this.handler(metadataRewriter.trackerAndRewriterHandler(Types1_14.METADATA_LIST, Entity1_14Types.PLAYER));
         }
      });
      metadataRewriter.registerMetadataRewriter(ClientboundPackets1_14.ENTITY_METADATA, Types1_14.METADATA_LIST);
   }
}
