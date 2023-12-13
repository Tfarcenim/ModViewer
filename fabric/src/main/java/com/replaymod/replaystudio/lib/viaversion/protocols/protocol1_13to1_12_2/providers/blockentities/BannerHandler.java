package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.NumberTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.BlockEntityProvider;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.storage.BlockStorage;
import java.util.Iterator;

public class BannerHandler implements BlockEntityProvider.BlockEntityHandler {
   private static final int WALL_BANNER_START = 7110;
   private static final int WALL_BANNER_STOP = 7173;
   private static final int BANNER_START = 6854;
   private static final int BANNER_STOP = 7109;

   public int transform(UserConnection user, CompoundTag tag) {
      BlockStorage storage = (BlockStorage)user.get(BlockStorage.class);
      Position position = new Position((int)this.getLong((NumberTag)tag.get("x")), (short)((int)this.getLong((NumberTag)tag.get("y"))), (int)this.getLong((NumberTag)tag.get("z")));
      if (!storage.contains(position)) {
         Via.getPlatform().getLogger().warning("Received an banner color update packet, but there is no banner! O_o " + tag);
         return -1;
      } else {
         int blockId = storage.get(position).getOriginal();
         Tag base = tag.get("Base");
         int color = 0;
         if (base instanceof NumberTag) {
            color = ((NumberTag)base).asInt();
         }

         if (blockId >= 6854 && blockId <= 7109) {
            blockId += (15 - color) * 16;
         } else if (blockId >= 7110 && blockId <= 7173) {
            blockId += (15 - color) * 4;
         } else {
            Via.getPlatform().getLogger().warning("Why does this block have the banner block entity? :(" + tag);
         }

         Tag patterns = tag.get("Patterns");
         if (patterns instanceof ListTag) {
            Iterator var9 = ((ListTag)patterns).iterator();

            while(var9.hasNext()) {
               Tag pattern = (Tag)var9.next();
               if (pattern instanceof CompoundTag) {
                  Tag c = ((CompoundTag)pattern).get("Color");
                  if (c instanceof IntTag) {
                     ((IntTag)c).setValue(15 - (Integer)c.getValue());
                  }
               }
            }
         }

         Tag name = tag.get("CustomName");
         if (name instanceof StringTag) {
            ((StringTag)name).setValue(ChatRewriter.legacyTextToJsonString(((StringTag)name).getValue()));
         }

         return blockId;
      }
   }

   private long getLong(NumberTag tag) {
      return tag.asLong();
   }
}
