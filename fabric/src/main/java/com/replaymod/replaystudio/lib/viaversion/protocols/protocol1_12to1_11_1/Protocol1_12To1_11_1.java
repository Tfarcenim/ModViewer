package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12to1_11_1;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.DataPalette;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.PaletteType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_12Types;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.ViaProviders;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandler;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_12;
import com.replaymod.replaystudio.lib.viaversion.data.entity.EntityTrackerBase;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12to1_11_1.metadata.MetadataRewriter1_12To1_11_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12to1_11_1.packets.InventoryPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12to1_11_1.providers.InventoryQuickMoveProvider;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ClientboundPackets1_13;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.Chunk1_9_3_4Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ClientboundPackets1_9_3;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ServerboundPackets1_9_3;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.ClientWorld;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.Protocol1_9To1_8;
import com.replaymod.replaystudio.lib.viaversion.rewriter.SoundRewriter;

public class Protocol1_12To1_11_1 extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_12, ServerboundPackets1_9_3, ServerboundPackets1_12> {
   private final MetadataRewriter1_12To1_11_1 metadataRewriter = new MetadataRewriter1_12To1_11_1(this);
   private final InventoryPackets itemRewriter = new InventoryPackets(this);

   public Protocol1_12To1_11_1() {
      super(ClientboundPackets1_9_3.class, ClientboundPackets1_12.class, ServerboundPackets1_9_3.class, ServerboundPackets1_12.class);
   }

   protected void registerPackets() {
      this.metadataRewriter.register();
      this.itemRewriter.register();
      this.registerClientbound(ClientboundPackets1_9_3.SPAWN_ENTITY, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.UUID);
            this.map(Type.BYTE);
            this.handler(Protocol1_12To1_11_1.this.metadataRewriter.objectTrackerHandler());
         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.SPAWN_MOB, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.UUID);
            this.map(Type.VAR_INT);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Type.SHORT);
            this.map(Type.SHORT);
            this.map(Type.SHORT);
            this.map(Types1_12.METADATA_LIST);
            this.handler(Protocol1_12To1_11_1.this.metadataRewriter.trackerAndRewriterHandler(Types1_12.METADATA_LIST));
         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.STATISTICS, (wrapper) -> {
         int count = (Integer)wrapper.passthrough(Type.VAR_INT);
         int removed = 0;

         for(int i = 0; i < count; ++i) {
            String name = (String)wrapper.read(Type.STRING);
            int value = (Integer)wrapper.read(Type.VAR_INT);
            if (name.startsWith("achievement.")) {
               ++removed;
            } else {
               wrapper.write(Type.STRING, name);
               wrapper.write(Type.VAR_INT, value);
            }
         }

         wrapper.set(Type.VAR_INT, 0, count - removed);
         if (count == removed) {
            wrapper.cancel();
         }

      });
      this.registerClientbound(ClientboundPackets1_9_3.CHAT_MESSAGE, (wrapper) -> {
         if (Via.getConfig().is1_12NBTArrayFix()) {
            try {
               JsonElement obj = (JsonElement)Protocol1_9To1_8.FIX_JSON.transform((PacketWrapper)null, ((JsonElement)wrapper.passthrough(Type.COMPONENT)).toString());
               TranslateRewriter.toClient(obj, wrapper.user());
               ChatItemRewriter.toClient(obj, wrapper.user());
               wrapper.set(Type.COMPONENT, 0, obj);
            } catch (Exception var2) {
               var2.printStackTrace();
            }

         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.CHUNK_DATA, (wrapper) -> {
         ClientWorld clientWorld = (ClientWorld)wrapper.user().get(ClientWorld.class);
         Chunk1_9_3_4Type type = new Chunk1_9_3_4Type(clientWorld);
         Chunk chunk = (Chunk)wrapper.passthrough(type);

         for(int s = 0; s < chunk.getSections().length; ++s) {
            ChunkSection section = chunk.getSections()[s];
            if (section != null) {
               DataPalette blocks = section.palette(PaletteType.BLOCKS);

               for(int idx = 0; idx < 4096; ++idx) {
                  int id = blocks.idAt(idx) >> 4;
                  if (id == 26) {
                     CompoundTag tag = new CompoundTag();
                     tag.put("color", new IntTag(14));
                     tag.put("x", new IntTag(ChunkSection.xFromIndex(idx) + (chunk.getX() << 4)));
                     tag.put("y", new IntTag(ChunkSection.yFromIndex(idx) + (s << 4)));
                     tag.put("z", new IntTag(ChunkSection.zFromIndex(idx) + (chunk.getZ() << 4)));
                     tag.put("id", new StringTag("minecraft:bed"));
                     chunk.getBlockEntities().add(tag);
                  }
               }
            }
         }

      });
      this.metadataRewriter.registerRemoveEntities(ClientboundPackets1_9_3.DESTROY_ENTITIES);
      this.metadataRewriter.registerMetadataRewriter(ClientboundPackets1_9_3.ENTITY_METADATA, Types1_12.METADATA_LIST);
      this.registerClientbound(ClientboundPackets1_9_3.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.INT);
            this.handler((wrapper) -> {
               UserConnection user = wrapper.user();
               ClientWorld clientChunks = (ClientWorld)user.get(ClientWorld.class);
               int dimensionId = (Integer)wrapper.get(Type.INT, 1);
               clientChunks.setEnvironment(dimensionId);
               if (user.getProtocolInfo().getProtocolVersion() >= ProtocolVersion.v1_13.getVersion()) {
                  wrapper.create(ClientboundPackets1_13.DECLARE_RECIPES, (PacketHandler)((packetWrapper) -> {
                     packetWrapper.write(Type.VAR_INT, 0);
                  })).scheduleSend(Protocol1_13To1_12_2.class);
               }

            });
         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.RESPAWN, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.handler((wrapper) -> {
               ClientWorld clientWorld = (ClientWorld)wrapper.user().get(ClientWorld.class);
               int dimensionId = (Integer)wrapper.get(Type.INT, 0);
               clientWorld.setEnvironment(dimensionId);
            });
         }
      });
      (new SoundRewriter(this, this::getNewSoundId)).registerSound(ClientboundPackets1_9_3.SOUND);
      this.cancelServerbound(ServerboundPackets1_12.PREPARE_CRAFTING_GRID);
      this.registerServerbound(ServerboundPackets1_12.CLIENT_SETTINGS, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.map(Type.BYTE);
            this.map(Type.VAR_INT);
            this.map(Type.BOOLEAN);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               String locale = (String)wrapper.get(Type.STRING, 0);
               if (locale.length() > 7) {
                  wrapper.set(Type.STRING, 0, locale.substring(0, 7));
               }

            });
         }
      });
      this.cancelServerbound(ServerboundPackets1_12.RECIPE_BOOK_DATA);
      this.cancelServerbound(ServerboundPackets1_12.ADVANCEMENT_TAB);
   }

   private int getNewSoundId(int id) {
      int newId = id;
      if (id >= 26) {
         newId = id + 2;
      }

      if (id >= 70) {
         newId += 4;
      }

      if (id >= 74) {
         ++newId;
      }

      if (id >= 143) {
         newId += 3;
      }

      if (id >= 185) {
         ++newId;
      }

      if (id >= 263) {
         newId += 7;
      }

      if (id >= 301) {
         newId += 33;
      }

      if (id >= 317) {
         newId += 2;
      }

      if (id >= 491) {
         newId += 3;
      }

      return newId;
   }

   public void register(ViaProviders providers) {
      providers.register(InventoryQuickMoveProvider.class, new InventoryQuickMoveProvider());
   }

   public void init(UserConnection userConnection) {
      userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, Entity1_12Types.EntityType.PLAYER));
      if (!userConnection.has(ClientWorld.class)) {
         userConnection.put(new ClientWorld(userConnection));
      }

   }

   public MetadataRewriter1_12To1_11_1 getEntityRewriter() {
      return this.metadataRewriter;
   }

   public InventoryPackets getItemRewriter() {
      return this.itemRewriter;
   }
}
