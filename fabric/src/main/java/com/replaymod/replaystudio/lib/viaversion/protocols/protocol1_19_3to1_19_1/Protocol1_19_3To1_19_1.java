package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_3to1_19_1;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingData;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.PlayerMessageSignature;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.RegistryType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_19_3Types;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.BitSetType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.ByteArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ParticleType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_19_3;
import com.replaymod.replaystudio.lib.viaversion.data.entity.EntityTrackerBase;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import com.replaymod.replaystudio.lib.viaversion.protocols.base.ServerboundLoginPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_1to1_19.ClientboundPackets1_19_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_1to1_19.ServerboundPackets1_19_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_3to1_19_1.packets.EntityPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_3to1_19_1.packets.InventoryPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_3to1_19_1.storage.ReceivedMessagesStorage;
import com.replaymod.replaystudio.lib.viaversion.rewriter.CommandRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.SoundRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.StatisticsRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.TagRewriter;
import java.util.UUID;

public final class Protocol1_19_3To1_19_1 extends AbstractProtocol<ClientboundPackets1_19_1, ClientboundPackets1_19_3, ServerboundPackets1_19_1, ServerboundPackets1_19_3> {
   public static final MappingData MAPPINGS = new MappingDataBase("1.19", "1.19.3");
   private static final ByteArrayType.OptionalByteArrayType OPTIONAL_MESSAGE_SIGNATURE_BYTES_TYPE = new ByteArrayType.OptionalByteArrayType(256);
   private static final ByteArrayType MESSAGE_SIGNATURE_BYTES_TYPE = new ByteArrayType(256);
   private static final BitSetType ACKNOWLEDGED_BIT_SET_TYPE = new BitSetType(20);
   private static final UUID ZERO_UUID = new UUID(0L, 0L);
   private static final byte[] EMPTY_BYTES = new byte[0];
   private final EntityPackets entityRewriter = new EntityPackets(this);
   private final InventoryPackets itemRewriter = new InventoryPackets(this);

   public Protocol1_19_3To1_19_1() {
      super(ClientboundPackets1_19_1.class, ClientboundPackets1_19_3.class, ServerboundPackets1_19_1.class, ServerboundPackets1_19_3.class);
   }

   protected void registerPackets() {
      TagRewriter<ClientboundPackets1_19_1> tagRewriter = new TagRewriter(this);
      tagRewriter.addTagRaw(RegistryType.ITEM, "minecraft:creeper_igniters", 733);
      tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:bookshelf_books", "minecraft:hanging_signs", "minecraft:stripped_logs");
      tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:all_hanging_signs", "minecraft:ceiling_hanging_signs", "minecraft:invalid_spawn_inside", "minecraft:stripped_logs", "minecraft:wall_hanging_signs");
      tagRewriter.registerGeneric(ClientboundPackets1_19_1.TAGS);
      this.entityRewriter.register();
      this.itemRewriter.register();
      final SoundRewriter<ClientboundPackets1_19_1> soundRewriter = new SoundRewriter(this);
      this.registerClientbound(ClientboundPackets1_19_1.ENTITY_SOUND, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.handler(soundRewriter.getSoundHandler());
            this.handler((wrapper) -> {
               int soundId = (Integer)wrapper.get(Type.VAR_INT, 0);
               wrapper.set(Type.VAR_INT, 0, soundId + 1);
            });
         }
      });
      this.registerClientbound(ClientboundPackets1_19_1.SOUND, new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.handler(soundRewriter.getSoundHandler());
            this.handler((wrapper) -> {
               int soundId = (Integer)wrapper.get(Type.VAR_INT, 0);
               wrapper.set(Type.VAR_INT, 0, soundId + 1);
            });
         }
      });
      this.registerClientbound(ClientboundPackets1_19_1.NAMED_SOUND, ClientboundPackets1_19_3.SOUND, (wrapper) -> {
         wrapper.write(Type.VAR_INT, 0);
         wrapper.passthrough(Type.STRING);
         wrapper.write(Type.OPTIONAL_FLOAT, (Object)null);
      });
      (new StatisticsRewriter(this)).register(ClientboundPackets1_19_1.STATISTICS);
      CommandRewriter<ClientboundPackets1_19_1> commandRewriter = new CommandRewriter<ClientboundPackets1_19_1>(this) {
         public void handleArgument(PacketWrapper wrapper, String argumentType) throws Exception {
            byte var4 = -1;
            switch(argumentType.hashCode()) {
            case -1122666064:
               if (argumentType.equals("minecraft:entity_summon")) {
                  var4 = 2;
               }
               break;
            case -1109076067:
               if (argumentType.equals("minecraft:mob_effect")) {
                  var4 = 1;
               }
               break;
            case 250455096:
               if (argumentType.equals("minecraft:item_enchantment")) {
                  var4 = 0;
               }
            }

            switch(var4) {
            case 0:
               wrapper.write(Type.STRING, "minecraft:enchantment");
               break;
            case 1:
               wrapper.write(Type.STRING, "minecraft:mob_effect");
               break;
            case 2:
               wrapper.write(Type.STRING, "minecraft:entity_type");
               break;
            default:
               super.handleArgument(wrapper, argumentType);
            }

         }

         public String handleArgumentType(String argumentType) {
            byte var3 = -1;
            switch(argumentType.hashCode()) {
            case -1373584190:
               if (argumentType.equals("minecraft:resource_or_tag")) {
                  var3 = 1;
               }
               break;
            case -1122666064:
               if (argumentType.equals("minecraft:entity_summon")) {
                  var3 = 2;
               }
               break;
            case -1109076067:
               if (argumentType.equals("minecraft:mob_effect")) {
                  var3 = 4;
               }
               break;
            case 250455096:
               if (argumentType.equals("minecraft:item_enchantment")) {
                  var3 = 3;
               }
               break;
            case 688423739:
               if (argumentType.equals("minecraft:resource")) {
                  var3 = 0;
               }
            }

            switch(var3) {
            case 0:
               return "minecraft:resource_key";
            case 1:
               return "minecraft:resource_or_tag_key";
            case 2:
            case 3:
            case 4:
               return "minecraft:resource";
            default:
               return argumentType;
            }
         }
      };
      commandRewriter.registerDeclareCommands1_19(ClientboundPackets1_19_1.DECLARE_COMMANDS);
      this.registerClientbound(ClientboundPackets1_19_1.SERVER_DATA, new PacketHandlers() {
         public void register() {
            this.map(Type.OPTIONAL_COMPONENT);
            this.map(Type.OPTIONAL_STRING);
            this.read(Type.BOOLEAN);
         }
      });
      this.registerClientbound(ClientboundPackets1_19_1.PLAYER_CHAT, ClientboundPackets1_19_3.DISGUISED_CHAT, new PacketHandlers() {
         public void register() {
            this.read(Type.OPTIONAL_BYTE_ARRAY_PRIMITIVE);
            this.handler((wrapper) -> {
               PlayerMessageSignature signature = (PlayerMessageSignature)wrapper.read(Type.PLAYER_MESSAGE_SIGNATURE);
               if (!signature.uuid().equals(Protocol1_19_3To1_19_1.ZERO_UUID) && signature.signatureBytes().length != 0) {
                  ReceivedMessagesStorage messagesStorage = (ReceivedMessagesStorage)wrapper.user().get(ReceivedMessagesStorage.class);
                  messagesStorage.add(signature);
                  if (messagesStorage.tickUnacknowledged() > 64) {
                     messagesStorage.resetUnacknowledgedCount();
                     PacketWrapper chatAckPacket = wrapper.create(ServerboundPackets1_19_1.CHAT_ACK);
                     chatAckPacket.write(Type.PLAYER_MESSAGE_SIGNATURE_ARRAY, messagesStorage.lastSignatures());
                     chatAckPacket.write(Type.OPTIONAL_PLAYER_MESSAGE_SIGNATURE, (Object)null);
                     chatAckPacket.sendToServer(Protocol1_19_3To1_19_1.class);
                  }
               }

               String plainMessage = (String)wrapper.read(Type.STRING);
               JsonElement decoratedMessage = (JsonElement)wrapper.read(Type.OPTIONAL_COMPONENT);
               wrapper.read(Type.LONG);
               wrapper.read(Type.LONG);
               wrapper.read(Type.PLAYER_MESSAGE_SIGNATURE_ARRAY);
               JsonElement unsignedMessage = (JsonElement)wrapper.read(Type.OPTIONAL_COMPONENT);
               if (unsignedMessage != null) {
                  decoratedMessage = unsignedMessage;
               }

               if (decoratedMessage == null) {
                  decoratedMessage = GsonComponentSerializer.gson().serializeToTree(Component.text(plainMessage));
               }

               int filterMaskType = (Integer)wrapper.read(Type.VAR_INT);
               if (filterMaskType == 2) {
                  wrapper.read(Type.LONG_ARRAY_PRIMITIVE);
               }

               wrapper.write(Type.COMPONENT, decoratedMessage);
            });
         }
      });
      this.registerServerbound(ServerboundPackets1_19_3.CHAT_COMMAND, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.map(Type.LONG);
            this.map(Type.LONG);
            this.handler((wrapper) -> {
               int signatures = (Integer)wrapper.read(Type.VAR_INT);
               wrapper.write(Type.VAR_INT, 0);

               for(int i = 0; i < signatures; ++i) {
                  wrapper.read(Type.STRING);
                  wrapper.read(Protocol1_19_3To1_19_1.MESSAGE_SIGNATURE_BYTES_TYPE);
               }

               wrapper.write(Type.BOOLEAN, false);
               ReceivedMessagesStorage messagesStorage = (ReceivedMessagesStorage)wrapper.user().get(ReceivedMessagesStorage.class);
               messagesStorage.resetUnacknowledgedCount();
               wrapper.write(Type.PLAYER_MESSAGE_SIGNATURE_ARRAY, messagesStorage.lastSignatures());
               wrapper.write(Type.OPTIONAL_PLAYER_MESSAGE_SIGNATURE, (Object)null);
            });
            this.read(Type.VAR_INT);
            this.read(Protocol1_19_3To1_19_1.ACKNOWLEDGED_BIT_SET_TYPE);
         }
      });
      this.registerServerbound(ServerboundPackets1_19_3.CHAT_MESSAGE, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.map(Type.LONG);
            this.read(Type.LONG);
            this.create(Type.LONG, 0L);
            this.handler((wrapper) -> {
               wrapper.read(Protocol1_19_3To1_19_1.OPTIONAL_MESSAGE_SIGNATURE_BYTES_TYPE);
               wrapper.write(Type.BYTE_ARRAY_PRIMITIVE, Protocol1_19_3To1_19_1.EMPTY_BYTES);
               wrapper.write(Type.BOOLEAN, false);
               ReceivedMessagesStorage messagesStorage = (ReceivedMessagesStorage)wrapper.user().get(ReceivedMessagesStorage.class);
               messagesStorage.resetUnacknowledgedCount();
               wrapper.write(Type.PLAYER_MESSAGE_SIGNATURE_ARRAY, messagesStorage.lastSignatures());
               wrapper.write(Type.OPTIONAL_PLAYER_MESSAGE_SIGNATURE, (Object)null);
            });
            this.read(Type.VAR_INT);
            this.read(Protocol1_19_3To1_19_1.ACKNOWLEDGED_BIT_SET_TYPE);
         }
      });
      this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO.getId(), ServerboundLoginPackets.HELLO.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.create(Type.OPTIONAL_PROFILE_KEY, (Object)null);
         }
      });
      this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY.getId(), ServerboundLoginPackets.ENCRYPTION_KEY.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.BYTE_ARRAY_PRIMITIVE);
            this.create(Type.BOOLEAN, true);
            this.map(Type.BYTE_ARRAY_PRIMITIVE);
         }
      });
      this.cancelServerbound(ServerboundPackets1_19_3.CHAT_SESSION_UPDATE);
      this.cancelClientbound(ClientboundPackets1_19_1.DELETE_CHAT_MESSAGE);
      this.cancelClientbound(ClientboundPackets1_19_1.PLAYER_CHAT_HEADER);
      this.cancelClientbound(ClientboundPackets1_19_1.CHAT_PREVIEW);
      this.cancelClientbound(ClientboundPackets1_19_1.SET_DISPLAY_CHAT_PREVIEW);
      this.cancelServerbound(ServerboundPackets1_19_3.CHAT_ACK);
   }

   protected void onMappingDataLoaded() {
      super.onMappingDataLoaded();
      Types1_19_3.PARTICLE.filler(this).reader("block", ParticleType.Readers.BLOCK).reader("block_marker", ParticleType.Readers.BLOCK).reader("dust", ParticleType.Readers.DUST).reader("falling_dust", ParticleType.Readers.BLOCK).reader("dust_color_transition", ParticleType.Readers.DUST_TRANSITION).reader("item", ParticleType.Readers.VAR_INT_ITEM).reader("vibration", ParticleType.Readers.VIBRATION1_19).reader("sculk_charge", ParticleType.Readers.SCULK_CHARGE).reader("shriek", ParticleType.Readers.SHRIEK);
      Entity1_19_3Types.initialize(this);
   }

   public void init(UserConnection user) {
      user.put(new ReceivedMessagesStorage());
      this.addEntityTracker(user, new EntityTrackerBase(user, Entity1_19_3Types.PLAYER));
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
