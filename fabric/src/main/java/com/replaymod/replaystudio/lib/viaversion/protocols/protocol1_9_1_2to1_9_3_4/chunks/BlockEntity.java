package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_1_2to1_9_3_4.chunks;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.NumberTag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_1_2to1_9_3_4.Protocol1_9_1_2To1_9_3_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ClientboundPackets1_9_3;
import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BlockEntity {
   private static final Map<String, Integer> types = new HashMap();

   public static void handle(List<CompoundTag> tags, UserConnection connection) {
      Iterator var2 = tags.iterator();

      while(var2.hasNext()) {
         CompoundTag tag = (CompoundTag)var2.next();

         try {
            if (!tag.contains("id")) {
               throw new Exception("NBT tag not handled because the id key is missing");
            }

            String id = (String)tag.get("id").getValue();
            if (!types.containsKey(id)) {
               throw new Exception("Not handled id: " + id);
            }

            int newId = (Integer)types.get(id);
            if (newId != -1) {
               int x = ((NumberTag)tag.get("x")).asInt();
               int y = ((NumberTag)tag.get("y")).asInt();
               int z = ((NumberTag)tag.get("z")).asInt();
               Position pos = new Position(x, (short)y, z);
               updateBlockEntity(pos, (short)newId, tag, connection);
            }
         } catch (Exception var10) {
            if (Via.getManager().isDebug()) {
               Via.getPlatform().getLogger().warning("Block Entity: " + var10.getMessage() + ": " + tag);
            }
         }
      }

   }

   private static void updateBlockEntity(Position pos, short id, CompoundTag tag, UserConnection connection) throws Exception {
      PacketWrapper wrapper = PacketWrapper.create(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, (ByteBuf)null, connection);
      wrapper.write(Type.POSITION, pos);
      wrapper.write(Type.UNSIGNED_BYTE, id);
      wrapper.write(Type.NBT, tag);
      wrapper.scheduleSend(Protocol1_9_1_2To1_9_3_4.class, false);
   }

   static {
      types.put("MobSpawner", 1);
      types.put("Control", 2);
      types.put("Beacon", 3);
      types.put("Skull", 4);
      types.put("FlowerPot", 5);
      types.put("Banner", 6);
      types.put("UNKNOWN", 7);
      types.put("EndGateway", 8);
      types.put("Sign", 9);
   }
}
