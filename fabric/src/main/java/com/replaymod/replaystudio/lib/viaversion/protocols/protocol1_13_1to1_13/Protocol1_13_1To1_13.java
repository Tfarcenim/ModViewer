package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_1to1_13;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingData;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.RegistryType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_13Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.ValueTransformer;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.data.entity.EntityTrackerBase;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_1to1_13.metadata.MetadataRewriter1_13_1To1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_1to1_13.packets.EntityPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_1to1_13.packets.InventoryPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13_1to1_13.packets.WorldPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ClientboundPackets1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ServerboundPackets1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.ClientWorld;
import com.replaymod.replaystudio.lib.viaversion.rewriter.StatisticsRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.TagRewriter;

public class Protocol1_13_1To1_13 extends AbstractProtocol<ClientboundPackets1_13, ClientboundPackets1_13, ServerboundPackets1_13, ServerboundPackets1_13> {
   public static final MappingData MAPPINGS = new MappingDataBase("1.13", "1.13.2");
   private final MetadataRewriter1_13_1To1_13 entityRewriter = new MetadataRewriter1_13_1To1_13(this);
   private final InventoryPackets itemRewriter = new InventoryPackets(this);

   public Protocol1_13_1To1_13() {
      super(ClientboundPackets1_13.class, ClientboundPackets1_13.class, ServerboundPackets1_13.class, ServerboundPackets1_13.class);
   }

   protected void registerPackets() {
      this.entityRewriter.register();
      this.itemRewriter.register();
      EntityPackets.register(this);
      WorldPackets.register(this);
      this.registerServerbound(ServerboundPackets1_13.TAB_COMPLETE, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.STRING, new ValueTransformer<String, String>(Type.STRING) {
               public String transform(PacketWrapper wrapper, String inputValue) {
                  return inputValue.startsWith("/") ? inputValue.substring(1) : inputValue;
               }
            });
         }
      });
      this.registerServerbound(ServerboundPackets1_13.EDIT_BOOK, new PacketHandlers() {
         public void register() {
            this.map(Type.FLAT_ITEM);
            this.map(Type.BOOLEAN);
            this.handler((wrapper) -> {
               Item item = (Item)wrapper.get(Type.FLAT_ITEM, 0);
               Protocol1_13_1To1_13.this.itemRewriter.handleItemToServer(item);
            });
            this.handler((wrapper) -> {
               int hand = (Integer)wrapper.read(Type.VAR_INT);
               if (hand == 1) {
                  wrapper.cancel();
               }

            });
         }
      });
      this.registerClientbound(ClientboundPackets1_13.TAB_COMPLETE, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               int start = (Integer)wrapper.get(Type.VAR_INT, 1);
               wrapper.set(Type.VAR_INT, 1, start + 1);
               int count = (Integer)wrapper.get(Type.VAR_INT, 3);

               for(int i = 0; i < count; ++i) {
                  wrapper.passthrough(Type.STRING);
                  boolean hasTooltip = (Boolean)wrapper.passthrough(Type.BOOLEAN);
                  if (hasTooltip) {
                     wrapper.passthrough(Type.STRING);
                  }
               }

            });
         }
      });
      this.registerClientbound(ClientboundPackets1_13.BOSSBAR, new PacketHandlers() {
         public void register() {
            this.map(Type.UUID);
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               int action = (Integer)wrapper.get(Type.VAR_INT, 0);
               if (action == 0) {
                  wrapper.passthrough(Type.COMPONENT);
                  wrapper.passthrough(Type.FLOAT);
                  wrapper.passthrough(Type.VAR_INT);
                  wrapper.passthrough(Type.VAR_INT);
                  short flags = (short)(Byte)wrapper.read(Type.BYTE);
                  if ((flags & 2) != 0) {
                     flags = (short)(flags | 4);
                  }

                  wrapper.write(Type.UNSIGNED_BYTE, flags);
               }

            });
         }
      });
      (new TagRewriter(this)).register(ClientboundPackets1_13.TAGS, RegistryType.ITEM);
      (new StatisticsRewriter(this)).register(ClientboundPackets1_13.STATISTICS);
   }

   public void init(UserConnection userConnection) {
      userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, Entity1_13Types.EntityType.PLAYER));
      if (!userConnection.has(ClientWorld.class)) {
         userConnection.put(new ClientWorld(userConnection));
      }

   }

   public MappingData getMappingData() {
      return MAPPINGS;
   }

   public MetadataRewriter1_13_1To1_13 getEntityRewriter() {
      return this.entityRewriter;
   }

   public InventoryPackets getItemRewriter() {
      return this.itemRewriter;
   }
}
