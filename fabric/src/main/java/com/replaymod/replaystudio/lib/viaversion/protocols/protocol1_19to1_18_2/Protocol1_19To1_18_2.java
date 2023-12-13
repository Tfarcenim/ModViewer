package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_19Types;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.ViaProviders;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandler;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ParticleType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_19;
import com.replaymod.replaystudio.lib.viaversion.data.entity.EntityTrackerBase;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.protocols.base.ClientboundLoginPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.base.ServerboundLoginPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_17to1_16_4.ServerboundPackets1_17;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_18to1_17_1.ClientboundPackets1_18;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.data.MappingData;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.packets.EntityPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.packets.InventoryPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.packets.WorldPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.provider.AckSequenceProvider;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.storage.DimensionRegistryStorage;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.storage.NonceStorage;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.storage.SequenceStorage;
import com.replaymod.replaystudio.lib.viaversion.rewriter.CommandRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.SoundRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.StatisticsRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.TagRewriter;
import com.replaymod.replaystudio.lib.viaversion.util.CipherUtil;
import java.util.concurrent.ThreadLocalRandom;

public final class Protocol1_19To1_18_2 extends AbstractProtocol<ClientboundPackets1_18, ClientboundPackets1_19, ServerboundPackets1_17, ServerboundPackets1_19> {
   public static final MappingData MAPPINGS = new MappingData();
   private final EntityPackets entityRewriter = new EntityPackets(this);
   private final InventoryPackets itemRewriter = new InventoryPackets(this);

   public Protocol1_19To1_18_2() {
      super(ClientboundPackets1_18.class, ClientboundPackets1_19.class, ServerboundPackets1_17.class, ServerboundPackets1_19.class);
   }

   public static boolean isTextComponentNull(JsonElement element) {
      return element == null || element.isJsonNull() || element.isJsonArray() && element.getAsJsonArray().size() == 0;
   }

   protected void registerPackets() {
      TagRewriter<ClientboundPackets1_18> tagRewriter = new TagRewriter(this);
      tagRewriter.registerGeneric(ClientboundPackets1_18.TAGS);
      this.entityRewriter.register();
      this.itemRewriter.register();
      WorldPackets.register(this);
      this.cancelClientbound(ClientboundPackets1_18.ADD_VIBRATION_SIGNAL);
      final SoundRewriter<ClientboundPackets1_18> soundRewriter = new SoundRewriter(this);
      this.registerClientbound(ClientboundPackets1_18.SOUND, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(Type.INT);
            this.map(Type.INT);
            this.map(Type.INT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.handler((wrapper) -> {
               wrapper.write(Type.LONG, Protocol1_19To1_18_2.randomLong());
            });
            this.handler(soundRewriter.getSoundHandler());
         }
      });
      this.registerClientbound(ClientboundPackets1_18.ENTITY_SOUND, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(Type.VAR_INT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.handler((wrapper) -> {
               wrapper.write(Type.LONG, Protocol1_19To1_18_2.randomLong());
            });
            this.handler(soundRewriter.getSoundHandler());
         }
      });
      this.registerClientbound(ClientboundPackets1_18.NAMED_SOUND, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.map(Type.VAR_INT);
            this.map(Type.INT);
            this.map(Type.INT);
            this.map(Type.INT);
            this.map(Type.FLOAT);
            this.map(Type.FLOAT);
            this.handler((wrapper) -> {
               wrapper.write(Type.LONG, Protocol1_19To1_18_2.randomLong());
            });
         }
      });
      (new StatisticsRewriter(this)).register(ClientboundPackets1_18.STATISTICS);
      PacketHandler titleHandler = (wrapper) -> {
         JsonElement component = (JsonElement)wrapper.read(Type.COMPONENT);
         if (!isTextComponentNull(component)) {
            wrapper.write(Type.COMPONENT, component);
         } else {
            wrapper.write(Type.COMPONENT, ChatRewriter.emptyComponent());
         }

      };
      this.registerClientbound(ClientboundPackets1_18.TITLE_TEXT, titleHandler);
      this.registerClientbound(ClientboundPackets1_18.TITLE_SUBTITLE, titleHandler);
      CommandRewriter<ClientboundPackets1_18> commandRewriter = new CommandRewriter(this);
      this.registerClientbound(ClientboundPackets1_18.DECLARE_COMMANDS, (wrapper) -> {
         int size = (Integer)wrapper.passthrough(Type.VAR_INT);

         for(int i = 0; i < size; ++i) {
            byte flags = (Byte)wrapper.passthrough(Type.BYTE);
            wrapper.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
            if ((flags & 8) != 0) {
               wrapper.passthrough(Type.VAR_INT);
            }

            int nodeType = flags & 3;
            if (nodeType == 1 || nodeType == 2) {
               wrapper.passthrough(Type.STRING);
            }

            if (nodeType == 2) {
               String argumentType = (String)wrapper.read(Type.STRING);
               int argumentTypeId = MAPPINGS.getArgumentTypeMappings().mappedId(argumentType);
               if (argumentTypeId == -1) {
                  Via.getPlatform().getLogger().warning("Unknown command argument type: " + argumentType);
               }

               wrapper.write(Type.VAR_INT, argumentTypeId);
               commandRewriter.handleArgument(wrapper, argumentType);
               if ((flags & 16) != 0) {
                  wrapper.passthrough(Type.STRING);
               }
            }
         }

         wrapper.passthrough(Type.VAR_INT);
      });
      this.registerClientbound(ClientboundPackets1_18.CHAT_MESSAGE, ClientboundPackets1_19.SYSTEM_CHAT, new PacketHandlers() {
         public void register() {
            this.map(Type.COMPONENT);
            this.handler((wrapper) -> {
               int type = (Byte)wrapper.read(Type.BYTE);
               wrapper.write(Type.VAR_INT, Integer.valueOf(type == 0 ? 1 : type));
            });
            this.read(Type.UUID);
         }
      });
      this.registerServerbound(ServerboundPackets1_19.CHAT_MESSAGE, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.read(Type.LONG);
            this.read(Type.LONG);
            this.read(Type.BYTE_ARRAY_PRIMITIVE);
            this.read(Type.BOOLEAN);
         }
      });
      this.registerServerbound(ServerboundPackets1_19.CHAT_COMMAND, ServerboundPackets1_17.CHAT_MESSAGE, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.read(Type.LONG);
            this.read(Type.LONG);
            this.handler((wrapper) -> {
               String command = (String)wrapper.get(Type.STRING, 0);
               wrapper.set(Type.STRING, 0, "/" + command);
               int signatures = (Integer)wrapper.read(Type.VAR_INT);

               for(int i = 0; i < signatures; ++i) {
                  wrapper.read(Type.STRING);
                  wrapper.read(Type.BYTE_ARRAY_PRIMITIVE);
               }

            });
            this.read(Type.BOOLEAN);
         }
      });
      this.cancelServerbound(ServerboundPackets1_19.CHAT_PREVIEW);
      this.registerClientbound(State.LOGIN, ClientboundLoginPackets.GAME_PROFILE.getId(), ClientboundLoginPackets.GAME_PROFILE.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.UUID);
            this.map(Type.STRING);
            this.create(Type.VAR_INT, 0);
         }
      });
      this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO.getId(), ClientboundLoginPackets.HELLO.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.handler((wrapper) -> {
               byte[] publicKey = (byte[])wrapper.passthrough(Type.BYTE_ARRAY_PRIMITIVE);
               byte[] nonce = (byte[])wrapper.passthrough(Type.BYTE_ARRAY_PRIMITIVE);
               wrapper.user().put(new NonceStorage(CipherUtil.encryptNonce(publicKey, nonce)));
            });
         }
      });
      this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO.getId(), ServerboundLoginPackets.HELLO.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.read(Type.OPTIONAL_PROFILE_KEY);
         }
      });
      this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY.getId(), ServerboundLoginPackets.ENCRYPTION_KEY.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.BYTE_ARRAY_PRIMITIVE);
            this.handler((wrapper) -> {
               if ((Boolean)wrapper.read(Type.BOOLEAN)) {
                  wrapper.passthrough(Type.BYTE_ARRAY_PRIMITIVE);
               } else {
                  NonceStorage nonceStorage = (NonceStorage)wrapper.user().remove(NonceStorage.class);
                  if (nonceStorage == null) {
                     throw new IllegalArgumentException("Server sent nonce is missing");
                  }

                  wrapper.read(Type.LONG);
                  wrapper.read(Type.BYTE_ARRAY_PRIMITIVE);
                  wrapper.write(Type.BYTE_ARRAY_PRIMITIVE, nonceStorage.nonce());
               }

            });
         }
      });
   }

   private static long randomLong() {
      return ThreadLocalRandom.current().nextLong();
   }

   protected void onMappingDataLoaded() {
      super.onMappingDataLoaded();
      Types1_19.PARTICLE.filler(this).reader("block", ParticleType.Readers.BLOCK).reader("block_marker", ParticleType.Readers.BLOCK).reader("dust", ParticleType.Readers.DUST).reader("falling_dust", ParticleType.Readers.BLOCK).reader("dust_color_transition", ParticleType.Readers.DUST_TRANSITION).reader("item", ParticleType.Readers.VAR_INT_ITEM).reader("vibration", ParticleType.Readers.VIBRATION1_19).reader("sculk_charge", ParticleType.Readers.SCULK_CHARGE).reader("shriek", ParticleType.Readers.SHRIEK);
      Entity1_19Types.initialize(this);
   }

   public void register(ViaProviders providers) {
      providers.register(AckSequenceProvider.class, new AckSequenceProvider());
   }

   public void init(UserConnection user) {
      if (!user.has(DimensionRegistryStorage.class)) {
         user.put(new DimensionRegistryStorage());
      }

      user.put(new SequenceStorage());
      this.addEntityTracker(user, new EntityTrackerBase(user, Entity1_19Types.PLAYER));
   }

   public MappingData getMappingData() {
      return MAPPINGS;
   }

   public EntityPackets getEntityRewriter() {
      return this.entityRewriter;
   }

   public InventoryPackets getItemRewriter() {
      return this.itemRewriter;
   }
}
