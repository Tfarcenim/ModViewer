package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.packets;

import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_4to1_14_3.ClientboundPackets1_14_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.ServerboundPackets1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.Protocol1_15To1_14_4;
import com.replaymod.replaystudio.lib.viaversion.rewriter.ItemRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.RecipeRewriter;

public class InventoryPackets extends ItemRewriter<ClientboundPackets1_14_4, ServerboundPackets1_14, Protocol1_15To1_14_4> {
   public InventoryPackets(Protocol1_15To1_14_4 protocol) {
      super(protocol);
   }

   public void registerPackets() {
      this.registerSetCooldown(ClientboundPackets1_14_4.COOLDOWN);
      this.registerWindowItems(ClientboundPackets1_14_4.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
      this.registerTradeList(ClientboundPackets1_14_4.TRADE_LIST);
      this.registerSetSlot(ClientboundPackets1_14_4.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
      this.registerEntityEquipment(ClientboundPackets1_14_4.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
      this.registerAdvancements(ClientboundPackets1_14_4.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
      (new RecipeRewriter(this.protocol)).register(ClientboundPackets1_14_4.DECLARE_RECIPES);
      this.registerClickWindow(ServerboundPackets1_14.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
      this.registerCreativeInvAction(ServerboundPackets1_14.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
   }
}
