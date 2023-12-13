package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.packets;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.DataPalette;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.PaletteType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_4to1_14_3.ClientboundPackets1_14_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.types.Chunk1_14Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.Protocol1_15To1_14_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.types.Chunk1_15Type;
import com.replaymod.replaystudio.lib.viaversion.rewriter.BlockRewriter;

public final class WorldPackets {
   public static void register(Protocol1_15To1_14_4 protocol) {
      BlockRewriter<ClientboundPackets1_14_4> blockRewriter = new BlockRewriter(protocol, Type.POSITION1_14);
      blockRewriter.registerBlockAction(ClientboundPackets1_14_4.BLOCK_ACTION);
      blockRewriter.registerBlockChange(ClientboundPackets1_14_4.BLOCK_CHANGE);
      blockRewriter.registerMultiBlockChange(ClientboundPackets1_14_4.MULTI_BLOCK_CHANGE);
      blockRewriter.registerAcknowledgePlayerDigging(ClientboundPackets1_14_4.ACKNOWLEDGE_PLAYER_DIGGING);
      protocol.registerClientbound(ClientboundPackets1_14_4.CHUNK_DATA, (wrapper) -> {
         Chunk chunk = (Chunk)wrapper.read(new Chunk1_14Type());
         wrapper.write(new Chunk1_15Type(), chunk);
         int ix;
         int mappedBlockStateId;
         if (chunk.isFullChunk()) {
            int[] biomeData = chunk.getBiomeData();
            int[] newBiomeData = new int[1024];
            if (biomeData != null) {
               int i = 0;

               label52:
               while(true) {
                  if (i >= 4) {
                     i = 1;

                     while(true) {
                        if (i >= 64) {
                           break label52;
                        }

                        System.arraycopy(newBiomeData, 0, newBiomeData, i * 16, 16);
                        ++i;
                     }
                  }

                  for(ix = 0; ix < 4; ++ix) {
                     mappedBlockStateId = (ix << 2) + 2;
                     int z = (i << 2) + 2;
                     int oldIndex = z << 4 | mappedBlockStateId;
                     newBiomeData[i << 2 | ix] = biomeData[oldIndex];
                  }

                  ++i;
               }
            }

            chunk.setBiomeData(newBiomeData);
         }

         for(int s = 0; s < chunk.getSections().length; ++s) {
            ChunkSection section = chunk.getSections()[s];
            if (section != null) {
               DataPalette palette = section.palette(PaletteType.BLOCKS);

               for(ix = 0; ix < palette.size(); ++ix) {
                  mappedBlockStateId = protocol.getMappingData().getNewBlockStateId(palette.idByIndex(ix));
                  palette.setIdByIndex(ix, mappedBlockStateId);
               }
            }
         }

      });
      blockRewriter.registerEffect(ClientboundPackets1_14_4.EFFECT, 1010, 2001);
      protocol.registerClientbound(ClientboundPackets1_14_4.SPAWN_PARTICLE, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.BOOLEAN);
            this.map(Type.FLOAT, Type.DOUBLE);
            this.map(Type.FLOAT, Type.DOUBLE);
            this.map(Type.FLOAT, Type.DOUBLE);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.INT);
            this.handler((wrapper) -> {
               int id = (Integer)wrapper.get(Type.INT, 0);
               if (id != 3 && id != 23) {
                  if (id == 32) {
                     protocol.getItemRewriter().handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
                  }
               } else {
                  int data = (Integer)wrapper.passthrough(Type.VAR_INT);
                  wrapper.set(Type.VAR_INT, 0, protocol.getMappingData().getNewBlockStateId(data));
               }

            });
         }
      });
   }
}
