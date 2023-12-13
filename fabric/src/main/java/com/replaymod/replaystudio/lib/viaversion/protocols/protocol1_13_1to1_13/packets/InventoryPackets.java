package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_1to1_13.packets;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_1to1_13.Protocol1_13_1To1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ClientboundPackets1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ServerboundPackets1_13;
import com.replaymod.replaystudio.lib.viaversion.rewriter.ItemRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.RecipeRewriter;

public class InventoryPackets extends ItemRewriter<ClientboundPackets1_13, ServerboundPackets1_13, Protocol1_13_1To1_13> {
   public InventoryPackets(Protocol1_13_1To1_13 protocol) {
      super(protocol);
   }

   public void registerPackets() {
      this.registerSetSlot(ClientboundPackets1_13.SET_SLOT, Type.FLAT_ITEM);
      this.registerWindowItems(ClientboundPackets1_13.WINDOW_ITEMS, Type.FLAT_ITEM_ARRAY);
      this.registerAdvancements(ClientboundPackets1_13.ADVANCEMENTS, Type.FLAT_ITEM);
      this.registerSetCooldown(ClientboundPackets1_13.COOLDOWN);
      ((Protocol1_13_1To1_13)this.protocol).registerClientbound(ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.handler((wrapper) -> {
               String channel = (String)wrapper.get(Type.STRING, 0);
               if (channel.equals("minecraft:trader_list") || channel.equals("trader_list")) {
                  wrapper.passthrough(Type.INT);
                  int size = (Short)wrapper.passthrough(Type.UNSIGNED_BYTE);

                  for(int i = 0; i < size; ++i) {
                     InventoryPackets.this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_ITEM));
                     InventoryPackets.this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_ITEM));
                     boolean secondItem = (Boolean)wrapper.passthrough(Type.BOOLEAN);
                     if (secondItem) {
                        InventoryPackets.this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_ITEM));
                     }

                     wrapper.passthrough(Type.BOOLEAN);
                     wrapper.passthrough(Type.INT);
                     wrapper.passthrough(Type.INT);
                  }
               }

            });
         }
      });
      this.registerEntityEquipment(ClientboundPackets1_13.ENTITY_EQUIPMENT, Type.FLAT_ITEM);
      RecipeRewriter<ClientboundPackets1_13> recipeRewriter = new RecipeRewriter(this.protocol);
      ((Protocol1_13_1To1_13)this.protocol).registerClientbound(ClientboundPackets1_13.DECLARE_RECIPES, (wrapper) -> {
         int size = (Integer)wrapper.passthrough(Type.VAR_INT);

         for(int i = 0; i < size; ++i) {
            wrapper.passthrough(Type.STRING);
            String type = ((String)wrapper.passthrough(Type.STRING)).replace("minecraft:", "");
            recipeRewriter.handleRecipeType(wrapper, type);
         }

      });
      this.registerClickWindow(ServerboundPackets1_13.CLICK_WINDOW, Type.FLAT_ITEM);
      this.registerCreativeInvAction(ServerboundPackets1_13.CREATIVE_INVENTORY_ACTION, Type.FLAT_ITEM);
      this.registerSpawnParticle(ClientboundPackets1_13.SPAWN_PARTICLE, Type.FLAT_ITEM, Type.FLOAT);
   }
}
