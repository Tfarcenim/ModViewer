package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_11to1_10;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_11Types;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.ValueTransformer;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_9;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_11to1_10.data.PotionColorMapping;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_11to1_10.metadata.MetadataRewriter1_11To1_10;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_11to1_10.packets.InventoryPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_11to1_10.storage.EntityTracker1_11;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.Chunk1_9_3_4Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ClientboundPackets1_9_3;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.ServerboundPackets1_9_3;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.ClientWorld;
import com.replaymod.replaystudio.lib.viaversion.rewriter.SoundRewriter;
import com.replaymod.replaystudio.lib.viaversion.util.Pair;
import java.util.Iterator;
import java.util.List;

public class Protocol1_11To1_10 extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9_3, ServerboundPackets1_9_3, ServerboundPackets1_9_3> {
   private static final ValueTransformer<Float, Short> toOldByte;
   private final MetadataRewriter1_11To1_10 entityRewriter = new MetadataRewriter1_11To1_10(this);
   private final InventoryPackets itemRewriter = new InventoryPackets(this);

   public Protocol1_11To1_10() {
      super(ClientboundPackets1_9_3.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9_3.class);
   }

   protected void registerPackets() {
      this.entityRewriter.register();
      this.itemRewriter.register();
      this.registerClientbound(ClientboundPackets1_9_3.SPAWN_ENTITY, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.UUID);
            this.map(Type.BYTE);
            this.handler(Protocol1_11To1_10.this.entityRewriter.objectTrackerHandler());
         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.SPAWN_MOB, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.UUID);
            this.map(Type.UNSIGNED_BYTE, Type.VAR_INT);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Type.SHORT);
            this.map(Type.SHORT);
            this.map(Type.SHORT);
            this.map(Types1_9.METADATA_LIST);
            this.handler((wrapper) -> {
               int entityId = (Integer)wrapper.get(Type.VAR_INT, 0);
               int type = (Integer)wrapper.get(Type.VAR_INT, 1);
               Entity1_11Types.EntityType entType = MetadataRewriter1_11To1_10.rewriteEntityType(type, (List)wrapper.get(Types1_9.METADATA_LIST, 0));
               if (entType != null) {
                  wrapper.set(Type.VAR_INT, 1, entType.getId());
                  wrapper.user().getEntityTracker(Protocol1_11To1_10.class).addEntity(entityId, entType);
                  Protocol1_11To1_10.this.entityRewriter.handleMetadata(entityId, (List)wrapper.get(Types1_9.METADATA_LIST, 0), wrapper.user());
               }

            });
         }
      });
      (new SoundRewriter(this, this::getNewSoundId)).registerSound(ClientboundPackets1_9_3.SOUND);
      this.registerClientbound(ClientboundPackets1_9_3.COLLECT_ITEM, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               wrapper.write(Type.VAR_INT, 1);
            });
         }
      });
      this.entityRewriter.registerMetadataRewriter(ClientboundPackets1_9_3.ENTITY_METADATA, Types1_9.METADATA_LIST);
      this.registerClientbound(ClientboundPackets1_9_3.ENTITY_TELEPORT, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.DOUBLE);
            this.map(Type.BYTE);
            this.map(Type.BYTE);
            this.map(Type.BOOLEAN);
            this.handler((wrapper) -> {
               int entityID = (Integer)wrapper.get(Type.VAR_INT, 0);
               if (Via.getConfig().isHologramPatch()) {
                  EntityTracker1_11 tracker = (EntityTracker1_11)wrapper.user().getEntityTracker(Protocol1_11To1_10.class);
                  if (tracker.isHologram(entityID)) {
                     Double newValue = (Double)wrapper.get(Type.DOUBLE, 1);
                     newValue = newValue - Via.getConfig().getHologramYOffset();
                     wrapper.set(Type.DOUBLE, 1, newValue);
                  }
               }

            });
         }
      });
      this.entityRewriter.registerRemoveEntities(ClientboundPackets1_9_3.DESTROY_ENTITIES);
      this.registerClientbound(ClientboundPackets1_9_3.TITLE, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               int action = (Integer)wrapper.get(Type.VAR_INT, 0);
               if (action >= 2) {
                  wrapper.set(Type.VAR_INT, 0, action + 1);
               }

            });
         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.BLOCK_ACTION, new PacketHandlers() {
         public void register() {
            this.map(Type.POSITION);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.VAR_INT);
            this.handler((actionWrapper) -> {
               if (Via.getConfig().isPistonAnimationPatch()) {
                  int id = (Integer)actionWrapper.get(Type.VAR_INT, 0);
                  if (id == 33 || id == 29) {
                     actionWrapper.cancel();
                  }
               }

            });
         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, new PacketHandlers() {
         public void register() {
            this.map(Type.POSITION);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.NBT);
            this.handler((wrapper) -> {
               CompoundTag tag = (CompoundTag)wrapper.get(Type.NBT, 0);
               if ((Short)wrapper.get(Type.UNSIGNED_BYTE, 0) == 1) {
                  EntityIdRewriter.toClientSpawner(tag);
               }

               if (tag.contains("id")) {
                  ((StringTag)tag.get("id")).setValue(BlockEntityRewriter.toNewIdentifier((String)tag.get("id").getValue()));
               }

            });
         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.CHUNK_DATA, (wrapper) -> {
         ClientWorld clientWorld = (ClientWorld)wrapper.user().get(ClientWorld.class);
         Chunk chunk = (Chunk)wrapper.passthrough(new Chunk1_9_3_4Type(clientWorld));
         if (chunk.getBlockEntities() != null) {
            Iterator var3 = chunk.getBlockEntities().iterator();

            while(var3.hasNext()) {
               CompoundTag tag = (CompoundTag)var3.next();
               if (tag.contains("id")) {
                  String identifier = ((StringTag)tag.get("id")).getValue();
                  if (identifier.equals("MobSpawner")) {
                     EntityIdRewriter.toClientSpawner(tag);
                  }

                  ((StringTag)tag.get("id")).setValue(BlockEntityRewriter.toNewIdentifier(identifier));
               }
            }

         }
      });
      this.registerClientbound(ClientboundPackets1_9_3.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.INT);
            this.handler((wrapper) -> {
               ClientWorld clientChunks = (ClientWorld)wrapper.user().get(ClientWorld.class);
               int dimensionId = (Integer)wrapper.get(Type.INT, 1);
               clientChunks.setEnvironment(dimensionId);
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
      this.registerClientbound(ClientboundPackets1_9_3.EFFECT, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.POSITION);
            this.map(Type.INT);
            this.map(Type.BOOLEAN);
            this.handler((packetWrapper) -> {
               int effectID = (Integer)packetWrapper.get(Type.INT, 0);
               if (effectID == 2002) {
                  int data = (Integer)packetWrapper.get(Type.INT, 1);
                  boolean isInstant = false;
                  Pair<Integer, Boolean> newData = PotionColorMapping.getNewData(data);
                  if (newData == null) {
                     Via.getPlatform().getLogger().warning("Received unknown 1.11 -> 1.10.2 potion data (" + data + ")");
                     data = 0;
                  } else {
                     data = (Integer)newData.key();
                     isInstant = (Boolean)newData.value();
                  }

                  if (isInstant) {
                     packetWrapper.set(Type.INT, 0, 2007);
                  }

                  packetWrapper.set(Type.INT, 1, data);
               }

            });
         }
      });
      this.registerServerbound(ServerboundPackets1_9_3.PLAYER_BLOCK_PLACEMENT, new PacketHandlers() {
         public void register() {
            this.map(Type.POSITION);
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(Type.FLOAT, Protocol1_11To1_10.toOldByte);
            this.map(Type.FLOAT, Protocol1_11To1_10.toOldByte);
            this.map(Type.FLOAT, Protocol1_11To1_10.toOldByte);
         }
      });
      this.registerServerbound(ServerboundPackets1_9_3.CHAT_MESSAGE, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.handler((wrapper) -> {
               String msg = (String)wrapper.get(Type.STRING, 0);
               if (msg.length() > 100) {
                  wrapper.set(Type.STRING, 0, msg.substring(0, 100));
               }

            });
         }
      });
   }

   private int getNewSoundId(int id) {
      if (id == 196) {
         return -1;
      } else {
         if (id >= 85) {
            id += 2;
         }

         if (id >= 176) {
            ++id;
         }

         if (id >= 197) {
            id += 8;
         }

         if (id >= 207) {
            --id;
         }

         if (id >= 279) {
            id += 9;
         }

         if (id >= 296) {
            ++id;
         }

         if (id >= 390) {
            id += 4;
         }

         if (id >= 400) {
            id += 3;
         }

         if (id >= 450) {
            ++id;
         }

         if (id >= 455) {
            ++id;
         }

         if (id >= 470) {
            ++id;
         }

         return id;
      }
   }

   public void init(UserConnection userConnection) {
      userConnection.addEntityTracker(this.getClass(), new EntityTracker1_11(userConnection));
      if (!userConnection.has(ClientWorld.class)) {
         userConnection.put(new ClientWorld(userConnection));
      }

   }

   public MetadataRewriter1_11To1_10 getEntityRewriter() {
      return this.entityRewriter;
   }

   public InventoryPackets getItemRewriter() {
      return this.itemRewriter;
   }

   static {
      toOldByte = new ValueTransformer<Float, Short>(Type.UNSIGNED_BYTE) {
         public Short transform(PacketWrapper wrapper, Float inputValue) throws Exception {
            return (short)((int)(inputValue * 16.0F));
         }
      };
   }
}
