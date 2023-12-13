package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_2to1_13_1.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_2to1_13_1.Protocol1_13_2To1_13_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ClientboundPackets1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ServerboundPackets1_13;

public class InventoryPackets {
   public static void register(Protocol1_13_2To1_13_1 protocol) {
      protocol.registerClientbound(ClientboundPackets1_13.SET_SLOT, new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.SHORT);
            this.map(Type.FLAT_ITEM, Type.FLAT_VAR_INT_ITEM);
         }
      });
      protocol.registerClientbound(ClientboundPackets1_13.WINDOW_ITEMS, new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.FLAT_ITEM_ARRAY, Type.FLAT_VAR_INT_ITEM_ARRAY);
         }
      });
      protocol.registerClientbound(ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.handler((wrapper) -> {
               String channel = (String)wrapper.get(Type.STRING, 0);
               if (channel.equals("minecraft:trader_list") || channel.equals("trader_list")) {
                  wrapper.passthrough(Type.INT);
                  int size = (Short)wrapper.passthrough(Type.UNSIGNED_BYTE);

                  for(int i = 0; i < size; ++i) {
                     wrapper.write(Type.FLAT_VAR_INT_ITEM, wrapper.read(Type.FLAT_ITEM));
                     wrapper.write(Type.FLAT_VAR_INT_ITEM, wrapper.read(Type.FLAT_ITEM));
                     boolean secondItem = (Boolean)wrapper.passthrough(Type.BOOLEAN);
                     if (secondItem) {
                        wrapper.write(Type.FLAT_VAR_INT_ITEM, wrapper.read(Type.FLAT_ITEM));
                     }

                     wrapper.passthrough(Type.BOOLEAN);
                     wrapper.passthrough(Type.INT);
                     wrapper.passthrough(Type.INT);
                  }
               }

            });
         }
      });
      protocol.registerClientbound(ClientboundPackets1_13.ENTITY_EQUIPMENT, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(Type.FLAT_ITEM, Type.FLAT_VAR_INT_ITEM);
         }
      });
      protocol.registerClientbound(ClientboundPackets1_13.DECLARE_RECIPES, (wrapper) -> {
         int recipesNo = (Integer)wrapper.passthrough(Type.VAR_INT);

         for(int i = 0; i < recipesNo; ++i) {
            wrapper.passthrough(Type.STRING);
            String type = (String)wrapper.passthrough(Type.STRING);
            int ingredientsNo;
            int i1;
            if (type.equals("crafting_shapeless")) {
               wrapper.passthrough(Type.STRING);
               ingredientsNo = (Integer)wrapper.passthrough(Type.VAR_INT);

               for(i1 = 0; i1 < ingredientsNo; ++i1) {
                  wrapper.write(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT, wrapper.read(Type.FLAT_ITEM_ARRAY_VAR_INT));
               }

               wrapper.write(Type.FLAT_VAR_INT_ITEM, wrapper.read(Type.FLAT_ITEM));
            } else if (!type.equals("crafting_shaped")) {
               if (type.equals("smelting")) {
                  wrapper.passthrough(Type.STRING);
                  wrapper.write(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT, wrapper.read(Type.FLAT_ITEM_ARRAY_VAR_INT));
                  wrapper.write(Type.FLAT_VAR_INT_ITEM, wrapper.read(Type.FLAT_ITEM));
                  wrapper.passthrough(Type.FLOAT);
                  wrapper.passthrough(Type.VAR_INT);
               }
            } else {
               ingredientsNo = (Integer)wrapper.passthrough(Type.VAR_INT) * (Integer)wrapper.passthrough(Type.VAR_INT);
               wrapper.passthrough(Type.STRING);

               for(i1 = 0; i1 < ingredientsNo; ++i1) {
                  wrapper.write(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT, wrapper.read(Type.FLAT_ITEM_ARRAY_VAR_INT));
               }

               wrapper.write(Type.FLAT_VAR_INT_ITEM, wrapper.read(Type.FLAT_ITEM));
            }
         }

      });
      protocol.registerServerbound(ServerboundPackets1_13.CLICK_WINDOW, new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.SHORT);
            this.map(Type.BYTE);
            this.map(Type.SHORT);
            this.map(Type.VAR_INT);
            this.map(Type.FLAT_VAR_INT_ITEM, Type.FLAT_ITEM);
         }
      });
      protocol.registerServerbound(ServerboundPackets1_13.CREATIVE_INVENTORY_ACTION, new PacketHandlers() {
         public void register() {
            this.map(Type.SHORT);
            this.map(Type.FLAT_VAR_INT_ITEM, Type.FLAT_ITEM);
         }
      });
   }
}
