package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.Provider;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ClientboundPackets1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities.BannerHandler;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities.BedHandler;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities.CommandBlockHandler;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities.FlowerPotHandler;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities.SkullHandler;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities.SpawnerHandler;
import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Map;

public class BlockEntityProvider implements Provider {
   private final Map<String, BlockEntityProvider.BlockEntityHandler> handlers = new HashMap();

   public BlockEntityProvider() {
      this.handlers.put("minecraft:flower_pot", new FlowerPotHandler());
      this.handlers.put("minecraft:bed", new BedHandler());
      this.handlers.put("minecraft:banner", new BannerHandler());
      this.handlers.put("minecraft:skull", new SkullHandler());
      this.handlers.put("minecraft:mob_spawner", new SpawnerHandler());
      this.handlers.put("minecraft:command_block", new CommandBlockHandler());
   }

   public int transform(UserConnection user, Position position, CompoundTag tag, boolean sendUpdate) throws Exception {
      Tag idTag = tag.get("id");
      if (idTag == null) {
         return -1;
      } else {
         String id = (String)idTag.getValue();
         BlockEntityProvider.BlockEntityHandler handler = (BlockEntityProvider.BlockEntityHandler)this.handlers.get(id);
         if (handler == null) {
            if (Via.getManager().isDebug()) {
               Via.getPlatform().getLogger().warning("Unhandled BlockEntity " + id + " full tag: " + tag);
            }

            return -1;
         } else {
            int newBlock = handler.transform(user, tag);
            if (sendUpdate && newBlock != -1) {
               this.sendBlockChange(user, position, newBlock);
            }

            return newBlock;
         }
      }
   }

   private void sendBlockChange(UserConnection user, Position position, int blockId) throws Exception {
      PacketWrapper wrapper = PacketWrapper.create(ClientboundPackets1_13.BLOCK_CHANGE, (ByteBuf)null, user);
      wrapper.write(Type.POSITION, position);
      wrapper.write(Type.VAR_INT, blockId);
      wrapper.send(Protocol1_13To1_12_2.class);
   }

   public interface BlockEntityHandler {
      int transform(UserConnection var1, CompoundTag var2);
   }
}
