package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_10to1_9_3.packets;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ClientboundPackets1_9_3;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ServerboundPackets1_9_3;
import com.replaymod.replaystudio.lib.viaversion.rewriter.ItemRewriter;

public class InventoryPackets extends ItemRewriter<ClientboundPackets1_9_3, ServerboundPackets1_9_3, Protocol1_10To1_9_3_4> {
   public InventoryPackets(Protocol1_10To1_9_3_4 protocol) {
      super(protocol);
   }

   public void registerPackets() {
      this.registerCreativeInvAction(ServerboundPackets1_9_3.CREATIVE_INVENTORY_ACTION, Type.ITEM);
   }

   public Item handleItemToServer(Item item) {
      if (item == null) {
         return null;
      } else {
         boolean newItem = item.identifier() >= 213 && item.identifier() <= 217;
         if (newItem) {
            item.setIdentifier(1);
            item.setData((short)0);
         }

         return item;
      }
   }
}
