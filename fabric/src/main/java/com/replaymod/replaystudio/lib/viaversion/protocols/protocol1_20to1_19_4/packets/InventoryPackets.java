package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_20to1_19_4.packets;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.BlockChangeRecord;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.blockentity.BlockEntity;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_18to1_17_1.types.Chunk1_18Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_4to1_19_3.ClientboundPackets1_19_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_4to1_19_3.ServerboundPackets1_19_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_4to1_19_3.rewriter.RecipeRewriter1_19_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_20to1_19_4.Protocol1_20To1_19_4;
import com.replaymod.replaystudio.lib.viaversion.rewriter.BlockRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.ItemRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.RecipeRewriter;
import com.replaymod.replaystudio.lib.viaversion.util.Key;

public final class InventoryPackets extends ItemRewriter<ClientboundPackets1_19_4, ServerboundPackets1_19_4, Protocol1_20To1_19_4> {
   public InventoryPackets(Protocol1_20To1_19_4 protocol) {
      super(protocol);
   }

   public void registerPackets() {
      final BlockRewriter<ClientboundPackets1_19_4> blockRewriter = new BlockRewriter(this.protocol, Type.POSITION1_14);
      blockRewriter.registerBlockAction(ClientboundPackets1_19_4.BLOCK_ACTION);
      blockRewriter.registerBlockChange(ClientboundPackets1_19_4.BLOCK_CHANGE);
      blockRewriter.registerEffect(ClientboundPackets1_19_4.EFFECT, 1010, 2001);
      blockRewriter.registerBlockEntityData(ClientboundPackets1_19_4.BLOCK_ENTITY_DATA, this::handleBlockEntity);
      this.registerOpenWindow(ClientboundPackets1_19_4.OPEN_WINDOW);
      this.registerSetCooldown(ClientboundPackets1_19_4.COOLDOWN);
      this.registerWindowItems1_17_1(ClientboundPackets1_19_4.WINDOW_ITEMS);
      this.registerSetSlot1_17_1(ClientboundPackets1_19_4.SET_SLOT);
      this.registerEntityEquipmentArray(ClientboundPackets1_19_4.ENTITY_EQUIPMENT);
      this.registerClickWindow1_17_1(ServerboundPackets1_19_4.CLICK_WINDOW);
      this.registerTradeList1_19(ClientboundPackets1_19_4.TRADE_LIST);
      this.registerCreativeInvAction(ServerboundPackets1_19_4.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
      this.registerWindowPropertyEnchantmentHandler(ClientboundPackets1_19_4.WINDOW_PROPERTY);
      this.registerSpawnParticle1_19(ClientboundPackets1_19_4.SPAWN_PARTICLE);
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.ADVANCEMENTS, (wrapper) -> {
         wrapper.passthrough(Type.BOOLEAN);
         int size = (Integer)wrapper.passthrough(Type.VAR_INT);

         for(int i = 0; i < size; ++i) {
            wrapper.passthrough(Type.STRING);
            if ((Boolean)wrapper.passthrough(Type.BOOLEAN)) {
               wrapper.passthrough(Type.STRING);
            }

            int arrayLength;
            if ((Boolean)wrapper.passthrough(Type.BOOLEAN)) {
               wrapper.passthrough(Type.COMPONENT);
               wrapper.passthrough(Type.COMPONENT);
               this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
               wrapper.passthrough(Type.VAR_INT);
               arrayLength = (Integer)wrapper.passthrough(Type.INT);
               if ((arrayLength & 1) != 0) {
                  wrapper.passthrough(Type.STRING);
               }

               wrapper.passthrough(Type.FLOAT);
               wrapper.passthrough(Type.FLOAT);
            }

            wrapper.passthrough(Type.STRING_ARRAY);
            arrayLength = (Integer)wrapper.passthrough(Type.VAR_INT);

            for(int array = 0; array < arrayLength; ++array) {
               wrapper.passthrough(Type.STRING_ARRAY);
            }

            wrapper.write(Type.BOOLEAN, false);
         }

      });
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.OPEN_SIGN_EDITOR, (wrapper) -> {
         wrapper.passthrough(Type.POSITION1_14);
         wrapper.write(Type.BOOLEAN, true);
      });
      ((Protocol1_20To1_19_4)this.protocol).registerServerbound(ServerboundPackets1_19_4.UPDATE_SIGN, (wrapper) -> {
         wrapper.passthrough(Type.POSITION1_14);
         boolean frontText = (Boolean)wrapper.read(Type.BOOLEAN);
         if (!frontText) {
            wrapper.cancel();
         }

      });
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.CHUNK_DATA, new PacketHandlers() {
         protected void register() {
            this.handler(blockRewriter.chunkDataHandler1_19(Chunk1_18Type::new, (x$0) -> {
               InventoryPackets.this.handleBlockEntity(x$0);
            }));
            this.read(Type.BOOLEAN);
         }
      });
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.UPDATE_LIGHT, (wrapper) -> {
         wrapper.passthrough(Type.VAR_INT);
         wrapper.passthrough(Type.VAR_INT);
         wrapper.read(Type.BOOLEAN);
      });
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.MULTI_BLOCK_CHANGE, new PacketHandlers() {
         public void register() {
            this.map(Type.LONG);
            this.read(Type.BOOLEAN);
            this.handler((wrapper) -> {
               BlockChangeRecord[] var2 = (BlockChangeRecord[])wrapper.passthrough(Type.VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY);
               int var3 = var2.length;

               for(int var4 = 0; var4 < var3; ++var4) {
                  BlockChangeRecord record = var2[var4];
                  record.setBlockId(((Protocol1_20To1_19_4)InventoryPackets.this.protocol).getMappingData().getNewBlockStateId(record.getBlockId()));
               }

            });
         }
      });
      RecipeRewriter<ClientboundPackets1_19_4> recipeRewriter = new RecipeRewriter1_19_4(this.protocol);
      ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.DECLARE_RECIPES, (wrapper) -> {
         int size = (Integer)wrapper.passthrough(Type.VAR_INT);
         int newSize = size;

         for(int i = 0; i < size; ++i) {
            String type = (String)wrapper.read(Type.STRING);
            String cutType = Key.stripMinecraftNamespace(type);
            if (cutType.equals("smithing")) {
               --newSize;
               wrapper.read(Type.STRING);
               wrapper.read(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT);
               wrapper.read(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT);
               wrapper.read(Type.FLAT_VAR_INT_ITEM);
            } else {
               wrapper.write(Type.STRING, type);
               wrapper.passthrough(Type.STRING);
               recipeRewriter.handleRecipeType(wrapper, cutType);
            }
         }

         wrapper.set(Type.VAR_INT, 0, newSize);
      });
   }

   private void handleBlockEntity(BlockEntity blockEntity) {
      if (blockEntity.typeId() == 7 || blockEntity.typeId() == 8) {
         CompoundTag tag = blockEntity.tag();
         CompoundTag frontText = new CompoundTag();
         tag.put("front_text", frontText);
         ListTag messages = new ListTag(StringTag.class);

         Tag color;
         for(int i = 1; i < 5; ++i) {
            color = tag.get("Text" + i);
            messages.add((Tag)(color != null ? color : new StringTag(ChatRewriter.emptyComponentString())));
         }

         frontText.put("messages", messages);
         ListTag filteredMessages = new ListTag(StringTag.class);

         Tag glowing;
         for(int i = 1; i < 5; ++i) {
            glowing = tag.get("FilteredText" + i);
            filteredMessages.add((Tag)(glowing != null ? glowing : new StringTag(ChatRewriter.emptyComponentString())));
         }

         frontText.put("filtered_messages", filteredMessages);
         color = tag.remove("Color");
         if (color != null) {
            frontText.put("color", color);
         }

         glowing = tag.remove("GlowingText");
         if (glowing != null) {
            frontText.put("has_glowing_text", glowing);
         }

      }
   }
}
