package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.packets;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ClientboundPackets1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.Protocol1_14To1_13_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.ServerboundPackets1_14;
import java.util.Collections;

public class PlayerPackets {
   public static void register(Protocol1_14To1_13_2 protocol) {
      protocol.registerClientbound(ClientboundPackets1_13.OPEN_SIGN_EDITOR, new PacketHandlers() {
         public void register() {
            this.map(Type.POSITION, Type.POSITION1_14);
         }
      });
      protocol.registerServerbound(ServerboundPackets1_14.QUERY_BLOCK_NBT, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.POSITION1_14, Type.POSITION);
         }
      });
      protocol.registerServerbound(ServerboundPackets1_14.EDIT_BOOK, (wrapper) -> {
         Item item = (Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM);
         protocol.getItemRewriter().handleItemToServer(item);
         if (item != null) {
            CompoundTag tag = item.tag();
            if (tag != null) {
               Tag pages = tag.get("pages");
               if (pages == null) {
                  tag.put("pages", new ListTag(Collections.singletonList(new StringTag())));
               }

               if (Via.getConfig().isTruncate1_14Books() && pages instanceof ListTag) {
                  ListTag listTag = (ListTag)pages;
                  if (listTag.size() > 50) {
                     listTag.setValue(listTag.getValue().subList(0, 50));
                  }
               }

            }
         }
      });
      protocol.registerServerbound(ServerboundPackets1_14.PLAYER_DIGGING, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.POSITION1_14, Type.POSITION);
         }
      });
      protocol.registerServerbound(ServerboundPackets1_14.RECIPE_BOOK_DATA, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               int type = (Integer)wrapper.get(Type.VAR_INT, 0);
               if (type == 0) {
                  wrapper.passthrough(Type.STRING);
               } else if (type == 1) {
                  wrapper.passthrough(Type.BOOLEAN);
                  wrapper.passthrough(Type.BOOLEAN);
                  wrapper.passthrough(Type.BOOLEAN);
                  wrapper.passthrough(Type.BOOLEAN);
                  wrapper.read(Type.BOOLEAN);
                  wrapper.read(Type.BOOLEAN);
                  wrapper.read(Type.BOOLEAN);
                  wrapper.read(Type.BOOLEAN);
               }

            });
         }
      });
      protocol.registerServerbound(ServerboundPackets1_14.UPDATE_COMMAND_BLOCK, new PacketHandlers() {
         public void register() {
            this.map(Type.POSITION1_14, Type.POSITION);
         }
      });
      protocol.registerServerbound(ServerboundPackets1_14.UPDATE_STRUCTURE_BLOCK, new PacketHandlers() {
         public void register() {
            this.map(Type.POSITION1_14, Type.POSITION);
         }
      });
      protocol.registerServerbound(ServerboundPackets1_14.UPDATE_SIGN, new PacketHandlers() {
         public void register() {
            this.map(Type.POSITION1_14, Type.POSITION);
         }
      });
      protocol.registerServerbound(ServerboundPackets1_14.PLAYER_BLOCK_PLACEMENT, (wrapper) -> {
         int hand = (Integer)wrapper.read(Type.VAR_INT);
         Position position = (Position)wrapper.read(Type.POSITION1_14);
         int face = (Integer)wrapper.read(Type.VAR_INT);
         float x = (Float)wrapper.read(Type.FLOAT);
         float y = (Float)wrapper.read(Type.FLOAT);
         float z = (Float)wrapper.read(Type.FLOAT);
         wrapper.read(Type.BOOLEAN);
         wrapper.write(Type.POSITION, position);
         wrapper.write(Type.VAR_INT, face);
         wrapper.write(Type.VAR_INT, hand);
         wrapper.write(Type.FLOAT, x);
         wrapper.write(Type.FLOAT, y);
         wrapper.write(Type.FLOAT, z);
      });
   }
}
