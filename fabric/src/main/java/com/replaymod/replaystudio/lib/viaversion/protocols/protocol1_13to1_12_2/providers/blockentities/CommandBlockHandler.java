package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonParser;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.BlockEntityProvider;

public class CommandBlockHandler implements BlockEntityProvider.BlockEntityHandler {
   private final Protocol1_13To1_12_2 protocol = (Protocol1_13To1_12_2)Via.getManager().getProtocolManager().getProtocol(Protocol1_13To1_12_2.class);

   public int transform(UserConnection user, CompoundTag tag) {
      Tag name = tag.get("CustomName");
      if (name instanceof StringTag) {
         ((StringTag)name).setValue(ChatRewriter.legacyTextToJsonString(((StringTag)name).getValue()));
      }

      Tag out = tag.get("LastOutput");
      if (out instanceof StringTag) {
         JsonElement value = JsonParser.parseString(((StringTag)out).getValue());
         this.protocol.getComponentRewriter().processText(value);
         ((StringTag)out).setValue(value.toString());
      }

      return -1;
   }
}
