package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_1to1_19.storage;

import com.replaymod.replaystudio.lib.viaversion.api.connection.StorableObject;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.Protocol1_19To1_18_2;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ChatTypeStorage implements StorableObject {
   private final Int2ObjectMap<CompoundTag> chatTypes = new Int2ObjectOpenHashMap();

   @Nullable
   public CompoundTag chatType(int id) {
      return this.chatTypes.isEmpty() ? Protocol1_19To1_18_2.MAPPINGS.chatType(id) : (CompoundTag)this.chatTypes.get(id);
   }

   public void addChatType(int id, CompoundTag chatType) {
      this.chatTypes.put(id, chatType);
   }

   public void clear() {
      this.chatTypes.clear();
   }

   public boolean clearOnServerSwitch() {
      return false;
   }
}
