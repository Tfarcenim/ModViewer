package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_1_2to1_9_3_4;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_1_2to1_9_3_4.chunks.BlockEntity;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.Chunk1_9_3_4Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ClientboundPackets1_9_3;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ServerboundPackets1_9_3;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.ClientWorld;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.types.Chunk1_9_1_2Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.ClientboundPackets1_9;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.ServerboundPackets1_9;

public class Protocol1_9_1_2To1_9_3_4 extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9, ServerboundPackets1_9_3, ServerboundPackets1_9> {
   public Protocol1_9_1_2To1_9_3_4() {
      super(ClientboundPackets1_9_3.class, ClientboundPackets1_9.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9.class);
   }

   protected void registerPackets() {
      this.registerClientbound(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, new PacketHandlers() {
         public void register() {
            this.map(Type.POSITION);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.NBT);
            this.handler((wrapper) -> {
               if ((Short)wrapper.get(Type.UNSIGNED_BYTE, 0) == 9) {
                  Position position = (Position)wrapper.get(Type.POSITION, 0);
                  CompoundTag tag = (CompoundTag)wrapper.get(Type.NBT, 0);
                  wrapper.clearPacket();
                  wrapper.setPacketType(ClientboundPackets1_9.UPDATE_SIGN);
                  wrapper.write(Type.POSITION, position);

                  for(int i = 1; i < 5; ++i) {
                     Tag textTag = tag.get("Text" + i);
                     String line = textTag instanceof StringTag ? ((StringTag)textTag).getValue() : "";
                     wrapper.write(Type.STRING, line);
                  }
               }

            });
         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.CHUNK_DATA, (wrapper) -> {
         ClientWorld clientWorld = (ClientWorld)wrapper.user().get(ClientWorld.class);
         Chunk1_9_3_4Type newType = new Chunk1_9_3_4Type(clientWorld);
         Chunk1_9_1_2Type oldType = new Chunk1_9_1_2Type(clientWorld);
         Chunk chunk = (Chunk)wrapper.read(newType);
         wrapper.write(oldType, chunk);
         BlockEntity.handle(chunk.getBlockEntities(), wrapper.user());
      });
      this.registerClientbound(ClientboundPackets1_9_3.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.INT);
            this.handler((wrapper) -> {
               ClientWorld clientChunks = (ClientWorld)wrapper.user().get(ClientWorld.class);
               int dimensionId = (Integer)wrapper.get(Type.INT, 1);
               clientChunks.setEnvironment(dimensionId);
            });
         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.RESPAWN, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.handler((wrapper) -> {
               ClientWorld clientWorld = (ClientWorld)wrapper.user().get(ClientWorld.class);
               int dimensionId = (Integer)wrapper.get(Type.INT, 0);
               clientWorld.setEnvironment(dimensionId);
            });
         }
      });
   }

   public void init(UserConnection userConnection) {
      if (!userConnection.has(ClientWorld.class)) {
         userConnection.put(new ClientWorld(userConnection));
      }

   }
}
