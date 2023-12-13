package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_2to1_13_1.packets;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandler;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_13;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_13_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ClientboundPackets1_13;
import java.util.Iterator;
import java.util.List;

public class EntityPackets {
   public static void register(Protocol protocol) {
      final PacketHandler metaTypeHandler = (wrapper) -> {
         Iterator var1 = ((List)wrapper.get(Types1_13_2.METADATA_LIST, 0)).iterator();

         while(var1.hasNext()) {
            Metadata metadata = (Metadata)var1.next();
            metadata.setMetaType(Types1_13_2.META_TYPES.byId(metadata.metaType().typeId()));
         }

      };
      protocol.registerClientbound(ClientboundPackets1_13.SPAWN_MOB, (PacketHandler)(new PacketHandlers() {
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
            this.map(Types1_13.METADATA_LIST, Types1_13_2.METADATA_LIST);
            this.handler(metaTypeHandler);
         }
      }));
      protocol.registerClientbound(ClientboundPackets1_13.SPAWN_PLAYER, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.UUID);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Types1_13.METADATA_LIST, Types1_13_2.METADATA_LIST);
            this.handler(metaTypeHandler);
         }
      }));
      protocol.registerClientbound(ClientboundPackets1_13.ENTITY_METADATA, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Types1_13.METADATA_LIST, Types1_13_2.METADATA_LIST);
            this.handler(metaTypeHandler);
         }
      }));
   }
}
