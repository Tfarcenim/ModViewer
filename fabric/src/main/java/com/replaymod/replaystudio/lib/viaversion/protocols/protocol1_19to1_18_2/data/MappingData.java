package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.data;

import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataLoader;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.nbt.BinaryTagIO;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.NumberTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import java.io.IOException;
import java.util.Iterator;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class MappingData extends MappingDataBase {
   private final Int2ObjectMap<CompoundTag> defaultChatTypes = new Int2ObjectOpenHashMap();

   public MappingData() {
      super("1.18", "1.19");
   }

   protected void loadExtras(CompoundTag daata) {
      try {
         ListTag chatTypes = (ListTag)BinaryTagIO.readInputStream(MappingDataLoader.getResource("chat-types-1.19.nbt")).get("values");
         Iterator var3 = chatTypes.iterator();

         while(var3.hasNext()) {
            Tag chatType = (Tag)var3.next();
            CompoundTag chatTypeCompound = (CompoundTag)chatType;
            NumberTag idTag = (NumberTag)chatTypeCompound.get("id");
            this.defaultChatTypes.put(idTag.asInt(), chatTypeCompound);
         }

      } catch (IOException var7) {
         throw new RuntimeException(var7);
      }
   }

   @Nullable
   public CompoundTag chatType(int id) {
      return (CompoundTag)this.defaultChatTypes.get(id);
   }
}
