package com.replaymod.replaystudio.lib.viaversion.rewriter;

import com.replaymod.replaystudio.lib.viaversion.api.data.Mappings;
import com.replaymod.replaystudio.lib.viaversion.api.data.ParticleMappings;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ServerboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandler;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.rewriter.RewriterBase;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class ItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends Protocol<C, ?, ?, S>> extends RewriterBase<T> implements com.replaymod.replaystudio.lib.viaversion.api.rewriter.ItemRewriter<T> {
   protected ItemRewriter(T protocol) {
      super(protocol);
   }

   @Nullable
   public Item handleItemToClient(@Nullable Item item) {
      if (item == null) {
         return null;
      } else {
         if (this.protocol.getMappingData() != null && this.protocol.getMappingData().getItemMappings() != null) {
            item.setIdentifier(this.protocol.getMappingData().getNewItemId(item.identifier()));
         }

         return item;
      }
   }

   @Nullable
   public Item handleItemToServer(@Nullable Item item) {
      if (item == null) {
         return null;
      } else {
         if (this.protocol.getMappingData() != null && this.protocol.getMappingData().getItemMappings() != null) {
            item.setIdentifier(this.protocol.getMappingData().getOldItemId(item.identifier()));
         }

         return item;
      }
   }

   public void registerWindowItems(C packetType, Type<Item[]> type) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.map(type);
            this.handler(ItemRewriter.this.itemArrayHandler(type));
         }
      }));
   }

   public void registerWindowItems1_17_1(C packetType) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               Item[] items = (Item[])wrapper.passthrough(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT);
               Item[] var3 = items;
               int var4 = items.length;

               for(int var5 = 0; var5 < var4; ++var5) {
                  Item item = var3[var5];
                  ItemRewriter.this.handleItemToClient(item);
               }

               ItemRewriter.this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
            });
         }
      }));
   }

   public void registerOpenWindow(C packetType) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               int windowType = (Integer)wrapper.read(Type.VAR_INT);
               int mappedId = ItemRewriter.this.protocol.getMappingData().getMenuMappings().getNewId(windowType);
               if (mappedId == -1) {
                  wrapper.cancel();
               } else {
                  wrapper.write(Type.VAR_INT, mappedId);
               }
            });
         }
      }));
   }

   public void registerSetSlot(C packetType, Type<Item> type) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.SHORT);
            this.map(type);
            this.handler(ItemRewriter.this.itemToClientHandler(type));
         }
      }));
   }

   public void registerSetSlot1_17_1(C packetType) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.VAR_INT);
            this.map(Type.SHORT);
            this.map(Type.FLAT_VAR_INT_ITEM);
            this.handler(ItemRewriter.this.itemToClientHandler(Type.FLAT_VAR_INT_ITEM));
         }
      }));
   }

   public void registerEntityEquipment(C packetType, Type<Item> type) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(type);
            this.handler(ItemRewriter.this.itemToClientHandler(type));
         }
      }));
   }

   public void registerEntityEquipmentArray(C packetType) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               byte slot;
               do {
                  slot = (Byte)wrapper.passthrough(Type.BYTE);
                  ItemRewriter.this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
               } while((slot & -128) != 0);

            });
         }
      }));
   }

   public void registerCreativeInvAction(S packetType, Type<Item> type) {
      this.protocol.registerServerbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.SHORT);
            this.map(type);
            this.handler(ItemRewriter.this.itemToServerHandler(type));
         }
      }));
   }

   public void registerClickWindow(S packetType, Type<Item> type) {
      this.protocol.registerServerbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.SHORT);
            this.map(Type.BYTE);
            this.map(Type.SHORT);
            this.map(Type.VAR_INT);
            this.map(type);
            this.handler(ItemRewriter.this.itemToServerHandler(type));
         }
      }));
   }

   public void registerClickWindow1_17_1(S packetType) {
      this.protocol.registerServerbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.VAR_INT);
            this.map(Type.SHORT);
            this.map(Type.BYTE);
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               int length = (Integer)wrapper.passthrough(Type.VAR_INT);

               for(int i = 0; i < length; ++i) {
                  wrapper.passthrough(Type.SHORT);
                  ItemRewriter.this.handleItemToServer((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
               }

               ItemRewriter.this.handleItemToServer((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
            });
         }
      }));
   }

   public void registerSetCooldown(C packetType) {
      this.protocol.registerClientbound(packetType, (wrapper) -> {
         int itemId = (Integer)wrapper.read(Type.VAR_INT);
         wrapper.write(Type.VAR_INT, this.protocol.getMappingData().getNewItemId(itemId));
      });
   }

   public void registerTradeList(C packetType) {
      this.protocol.registerClientbound(packetType, (wrapper) -> {
         wrapper.passthrough(Type.VAR_INT);
         int size = (Short)wrapper.passthrough(Type.UNSIGNED_BYTE);

         for(int i = 0; i < size; ++i) {
            this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
            this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
            if ((Boolean)wrapper.passthrough(Type.BOOLEAN)) {
               this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
            }

            wrapper.passthrough(Type.BOOLEAN);
            wrapper.passthrough(Type.INT);
            wrapper.passthrough(Type.INT);
            wrapper.passthrough(Type.INT);
            wrapper.passthrough(Type.INT);
            wrapper.passthrough(Type.FLOAT);
            wrapper.passthrough(Type.INT);
         }

      });
   }

   public void registerTradeList1_19(C packetType) {
      this.protocol.registerClientbound(packetType, (wrapper) -> {
         wrapper.passthrough(Type.VAR_INT);
         int size = (Integer)wrapper.passthrough(Type.VAR_INT);

         for(int i = 0; i < size; ++i) {
            this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
            this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
            this.handleItemToClient((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
            wrapper.passthrough(Type.BOOLEAN);
            wrapper.passthrough(Type.INT);
            wrapper.passthrough(Type.INT);
            wrapper.passthrough(Type.INT);
            wrapper.passthrough(Type.INT);
            wrapper.passthrough(Type.FLOAT);
            wrapper.passthrough(Type.INT);
         }

      });
   }

   public void registerAdvancements(C packetType, Type<Item> type) {
      this.protocol.registerClientbound(packetType, (wrapper) -> {
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
               this.handleItemToClient((Item)wrapper.passthrough(type));
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
         }

      });
   }

   public void registerWindowPropertyEnchantmentHandler(C packetType) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.UNSIGNED_BYTE);
            this.handler((wrapper) -> {
               Mappings mappings = ItemRewriter.this.protocol.getMappingData().getEnchantmentMappings();
               if (mappings != null) {
                  short property = (Short)wrapper.passthrough(Type.SHORT);
                  if (property >= 4 && property <= 6) {
                     short enchantmentId = (short)mappings.getNewId((Short)wrapper.read(Type.SHORT));
                     wrapper.write(Type.SHORT, enchantmentId);
                  }

               }
            });
         }
      }));
   }

   public void registerSpawnParticle(C packetType, Type<Item> itemType, Type<?> coordType) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.BOOLEAN);
            this.map(coordType);
            this.map(coordType);
            this.map(coordType);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.INT);
            this.handler(ItemRewriter.this.getSpawnParticleHandler(itemType));
         }
      }));
   }

   public void registerSpawnParticle1_19(C packetType) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.BOOLEAN);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.map(Type.INT);
            this.handler(ItemRewriter.this.getSpawnParticleHandler(Type.VAR_INT, Type.FLAT_VAR_INT_ITEM));
         }
      }));
   }

   public PacketHandler getSpawnParticleHandler(Type<Item> itemType) {
      return this.getSpawnParticleHandler(Type.INT, itemType);
   }

   public PacketHandler getSpawnParticleHandler(Type<Integer> idType, Type<Item> itemType) {
      return (wrapper) -> {
         int id = (Integer)wrapper.get(idType, 0);
         if (id != -1) {
            ParticleMappings mappings = this.protocol.getMappingData().getParticleMappings();
            int mappedId;
            if (mappings.isBlockParticle(id)) {
               mappedId = (Integer)wrapper.read(Type.VAR_INT);
               wrapper.write(Type.VAR_INT, this.protocol.getMappingData().getNewBlockStateId(mappedId));
            } else if (mappings.isItemParticle(id)) {
               this.handleItemToClient((Item)wrapper.passthrough(itemType));
            }

            mappedId = this.protocol.getMappingData().getNewParticleId(id);
            if (mappedId != id) {
               wrapper.set(idType, 0, mappedId);
            }

         }
      };
   }

   public PacketHandler itemArrayHandler(Type<Item[]> type) {
      return (wrapper) -> {
         Item[] items = (Item[])wrapper.get(type, 0);
         Item[] var4 = items;
         int var5 = items.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Item item = var4[var6];
            this.handleItemToClient(item);
         }

      };
   }

   public PacketHandler itemToClientHandler(Type<Item> type) {
      return (wrapper) -> {
         this.handleItemToClient((Item)wrapper.get(type, 0));
      };
   }

   public PacketHandler itemToServerHandler(Type<Item> type) {
      return (wrapper) -> {
         this.handleItemToServer((Item)wrapper.get(type, 0));
      };
   }
}
