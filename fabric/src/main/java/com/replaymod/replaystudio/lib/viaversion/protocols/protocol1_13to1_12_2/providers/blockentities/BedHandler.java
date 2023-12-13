package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.NumberTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.BlockEntityProvider;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.storage.BlockStorage;

public class BedHandler implements BlockEntityProvider.BlockEntityHandler {
   public int transform(UserConnection user, CompoundTag tag) {
      BlockStorage storage = (BlockStorage)user.get(BlockStorage.class);
      Position position = new Position((int)this.getLong((NumberTag)tag.get("x")), (short)((int)this.getLong((NumberTag)tag.get("y"))), (int)this.getLong((NumberTag)tag.get("z")));
      if (!storage.contains(position)) {
         Via.getPlatform().getLogger().warning("Received an bed color update packet, but there is no bed! O_o " + tag);
         return -1;
      } else {
         int blockId = storage.get(position).getOriginal() - 972 + 748;
         Tag color = tag.get("color");
         if (color instanceof NumberTag) {
            blockId += ((NumberTag)color).asInt() * 16;
         }

         return blockId;
      }
   }

   private long getLong(NumberTag tag) {
      return tag.asLong();
   }
}
