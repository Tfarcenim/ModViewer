package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.packets;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_15Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_4to1_14_3.ClientboundPackets1_14_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.ClientboundPackets1_15;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.Protocol1_15To1_14_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.metadata.MetadataRewriter1_15To1_14_4;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;
import java.util.List;

public final class EntityPackets {
   public static void register(Protocol1_15To1_14_4 protocol) {
      final MetadataRewriter1_15To1_14_4 metadataRewriter = (MetadataRewriter1_15To1_14_4)protocol.get(MetadataRewriter1_15To1_14_4.class);
      metadataRewriter.registerTrackerWithData(ClientboundPackets1_14_4.SPAWN_ENTITY, Entity1_15Types.FALLING_BLOCK);
      protocol.registerClientbound(ClientboundPackets1_14_4.SPAWN_MOB, new PacketHandlers() {
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
            this.handler(metadataRewriter.trackerHandler());
            this.handler((wrapper) -> {
               EntityPackets.sendMetadataPacket(wrapper, (Integer)wrapper.get(Type.VAR_INT, 0), metadataRewriter);
            });
         }
      });
      protocol.registerClientbound(ClientboundPackets1_14_4.SPAWN_PLAYER, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.UUID);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.handler((wrapper) -> {
               int entityId = (Integer)wrapper.get(Type.VAR_INT, 0);
               wrapper.user().getEntityTracker(Protocol1_15To1_14_4.class).addEntity(entityId, Entity1_15Types.PLAYER);
               EntityPackets.sendMetadataPacket(wrapper, entityId, metadataRewriter);
            });
         }
      });
      protocol.registerClientbound(ClientboundPackets1_14_4.RESPAWN, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.handler((wrapper) -> {
               wrapper.write(Type.LONG, 0L);
            });
         }
      });
      protocol.registerClientbound(ClientboundPackets1_14_4.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.INT);
            this.handler(metadataRewriter.playerTrackerHandler());
            this.handler((wrapper) -> {
               wrapper.write(Type.LONG, 0L);
            });
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.STRING);
            this.map(Type.VAR_INT);
            this.map(Type.BOOLEAN);
            this.handler((wrapper) -> {
               wrapper.write(Type.BOOLEAN, !Via.getConfig().is1_15InstantRespawn());
            });
         }
      });
      metadataRewriter.registerMetadataRewriter(ClientboundPackets1_14_4.ENTITY_METADATA, Types1_14.METADATA_LIST);
      metadataRewriter.registerRemoveEntities(ClientboundPackets1_14_4.DESTROY_ENTITIES);
   }

   private static void sendMetadataPacket(PacketWrapper wrapper, int entityId, EntityRewriter<?, ?> rewriter) throws Exception {
      List<Metadata> metadata = (List)wrapper.read(Types1_14.METADATA_LIST);
      if (!metadata.isEmpty()) {
         wrapper.send(Protocol1_15To1_14_4.class);
         wrapper.cancel();
         rewriter.handleMetadata(entityId, metadata, wrapper.user());
         PacketWrapper metadataPacket = PacketWrapper.create(ClientboundPackets1_15.ENTITY_METADATA, (UserConnection)wrapper.user());
         metadataPacket.write(Type.VAR_INT, entityId);
         metadataPacket.write(Types1_14.METADATA_LIST, metadata);
         metadataPacket.send(Protocol1_15To1_14_4.class);
      }
   }

   public static int getNewEntityId(int oldId) {
      return oldId >= 4 ? oldId + 1 : oldId;
   }
}
