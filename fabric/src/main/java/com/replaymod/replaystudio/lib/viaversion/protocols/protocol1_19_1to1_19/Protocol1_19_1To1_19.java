package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_1to1_19;

import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.ProfileKey;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.nbt.BinaryTagIO;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.TranslatableComponent;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.NamedTextColor;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.Style;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.TextColor;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.TextDecoration;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ByteTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.NumberTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.protocols.base.ClientboundLoginPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.base.ServerboundLoginPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_1to1_19.storage.ChatTypeStorage;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_1to1_19.storage.NonceStorage;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.ClientboundPackets1_19;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.ServerboundPackets1_19;
import com.replaymod.replaystudio.lib.viaversion.util.CipherUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class Protocol1_19_1To1_19 extends AbstractProtocol<ClientboundPackets1_19, ClientboundPackets1_19_1, ServerboundPackets1_19, ServerboundPackets1_19_1> {
   private static final String CHAT_REGISTRY_SNBT = "{\n  \"minecraft:chat_type\": {\n    \"type\": \"minecraft:chat_type\",\n    \"value\": [\n         {\n            \"name\":\"minecraft:chat\",\n            \"id\":1,\n            \"element\":{\n               \"chat\":{\n                  \"translation_key\":\"chat.type.text\",\n                  \"parameters\":[\n                     \"sender\",\n                     \"content\"\n                  ]\n               },\n               \"narration\":{\n                  \"translation_key\":\"chat.type.text.narrate\",\n                  \"parameters\":[\n                     \"sender\",\n                     \"content\"\n                  ]\n               }\n            }\n         }    ]\n  }\n}";
   private static final CompoundTag CHAT_REGISTRY;

   public Protocol1_19_1To1_19() {
      super(ClientboundPackets1_19.class, ClientboundPackets1_19_1.class, ServerboundPackets1_19.class, ServerboundPackets1_19_1.class);
   }

   protected void registerPackets() {
      this.registerClientbound(ClientboundPackets1_19.SYSTEM_CHAT, new PacketHandlers() {
         public void register() {
            this.map(Type.COMPONENT);
            this.handler((wrapper) -> {
               int type = (Integer)wrapper.read(Type.VAR_INT);
               boolean overlay = type == 2;
               wrapper.write(Type.BOOLEAN, overlay);
            });
         }
      });
      this.registerClientbound(ClientboundPackets1_19.PLAYER_CHAT, ClientboundPackets1_19_1.SYSTEM_CHAT, new PacketHandlers() {
         public void register() {
            this.handler((wrapper) -> {
               JsonElement signedContent = (JsonElement)wrapper.read(Type.COMPONENT);
               JsonElement unsignedContent = (JsonElement)wrapper.read(Type.OPTIONAL_COMPONENT);
               int chatTypeId = (Integer)wrapper.read(Type.VAR_INT);
               wrapper.read(Type.UUID);
               JsonElement senderName = (JsonElement)wrapper.read(Type.COMPONENT);
               JsonElement teamName = (JsonElement)wrapper.read(Type.OPTIONAL_COMPONENT);
               CompoundTag chatType = ((ChatTypeStorage)wrapper.user().get(ChatTypeStorage.class)).chatType(chatTypeId);
               ChatDecorationResult decorationResult = Protocol1_19_1To1_19.decorateChatMessage(chatType, chatTypeId, senderName, teamName, unsignedContent != null ? unsignedContent : signedContent);
               if (decorationResult == null) {
                  wrapper.cancel();
               } else {
                  wrapper.write(Type.COMPONENT, decorationResult.content());
                  wrapper.write(Type.BOOLEAN, decorationResult.overlay());
               }
            });
            this.read(Type.LONG);
            this.read(Type.LONG);
            this.read(Type.BYTE_ARRAY_PRIMITIVE);
         }
      });
      this.registerServerbound(ServerboundPackets1_19_1.CHAT_MESSAGE, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.map(Type.LONG);
            this.map(Type.LONG);
            this.map(Type.BYTE_ARRAY_PRIMITIVE);
            this.map(Type.BOOLEAN);
            this.read(Type.PLAYER_MESSAGE_SIGNATURE_ARRAY);
            this.read(Type.OPTIONAL_PLAYER_MESSAGE_SIGNATURE);
         }
      });
      this.registerServerbound(ServerboundPackets1_19_1.CHAT_COMMAND, new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.map(Type.LONG);
            this.map(Type.LONG);
            this.handler((wrapper) -> {
               int signatures = (Integer)wrapper.passthrough(Type.VAR_INT);

               for(int i = 0; i < signatures; ++i) {
                  wrapper.passthrough(Type.STRING);
                  wrapper.passthrough(Type.BYTE_ARRAY_PRIMITIVE);
               }

            });
            this.map(Type.BOOLEAN);
            this.read(Type.PLAYER_MESSAGE_SIGNATURE_ARRAY);
            this.read(Type.OPTIONAL_PLAYER_MESSAGE_SIGNATURE);
         }
      });
      this.cancelServerbound(ServerboundPackets1_19_1.CHAT_ACK);
      this.registerClientbound(ClientboundPackets1_19.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.BOOLEAN);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.BYTE);
            this.map(Type.STRING_ARRAY);
            this.handler((wrapper) -> {
               ChatTypeStorage chatTypeStorage = (ChatTypeStorage)wrapper.user().get(ChatTypeStorage.class);
               chatTypeStorage.clear();
               CompoundTag registry = (CompoundTag)wrapper.passthrough(Type.NBT);
               ListTag chatTypes = (ListTag)((CompoundTag)registry.get("minecraft:chat_type")).get("value");
               Iterator var4 = chatTypes.iterator();

               while(var4.hasNext()) {
                  Tag chatType = (Tag)var4.next();
                  CompoundTag chatTypeCompound = (CompoundTag)chatType;
                  NumberTag idTag = (NumberTag)chatTypeCompound.get("id");
                  chatTypeStorage.addChatType(idTag.asInt(), chatTypeCompound);
               }

               registry.put("minecraft:chat_type", Protocol1_19_1To1_19.CHAT_REGISTRY.clone());
            });
         }
      });
      this.registerClientbound(ClientboundPackets1_19.SERVER_DATA, new PacketHandlers() {
         public void register() {
            this.map(Type.OPTIONAL_COMPONENT);
            this.map(Type.OPTIONAL_STRING);
            this.map(Type.BOOLEAN);
            this.create(Type.BOOLEAN, false);
         }
      });
      this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO.getId(), ServerboundLoginPackets.HELLO.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.handler((wrapper) -> {
               ProfileKey profileKey = (ProfileKey)wrapper.read(Type.OPTIONAL_PROFILE_KEY);
               wrapper.write(Type.OPTIONAL_PROFILE_KEY, (Object)null);
               if (profileKey == null) {
                  wrapper.user().put(new NonceStorage((byte[])null));
               }

            });
            this.read(Type.OPTIONAL_UUID);
         }
      });
      this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO.getId(), ClientboundLoginPackets.HELLO.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.STRING);
            this.handler((wrapper) -> {
               if (!wrapper.user().has(NonceStorage.class)) {
                  byte[] publicKey = (byte[])wrapper.passthrough(Type.BYTE_ARRAY_PRIMITIVE);
                  byte[] nonce = (byte[])wrapper.passthrough(Type.BYTE_ARRAY_PRIMITIVE);
                  wrapper.user().put(new NonceStorage(CipherUtil.encryptNonce(publicKey, nonce)));
               }
            });
         }
      });
      this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY.getId(), ServerboundLoginPackets.ENCRYPTION_KEY.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.BYTE_ARRAY_PRIMITIVE);
            this.handler((wrapper) -> {
               NonceStorage nonceStorage = (NonceStorage)wrapper.user().remove(NonceStorage.class);
               if (nonceStorage.nonce() != null) {
                  boolean isNonce = (Boolean)wrapper.read(Type.BOOLEAN);
                  wrapper.write(Type.BOOLEAN, true);
                  if (!isNonce) {
                     wrapper.read(Type.LONG);
                     wrapper.read(Type.BYTE_ARRAY_PRIMITIVE);
                     wrapper.write(Type.BYTE_ARRAY_PRIMITIVE, nonceStorage.nonce());
                  }

               }
            });
         }
      });
      this.registerClientbound(State.LOGIN, ClientboundLoginPackets.CUSTOM_QUERY.getId(), ClientboundLoginPackets.CUSTOM_QUERY.getId(), new PacketHandlers() {
         public void register() {
            this.map(Type.VAR_INT);
            this.map(Type.STRING);
            this.handler((wrapper) -> {
               String identifier = (String)wrapper.get(Type.STRING, 0);
               if (identifier.equals("velocity:player_info")) {
                  byte[] data = (byte[])wrapper.passthrough(Type.REMAINING_BYTES);
                  if (data.length == 1 && data[0] > 1) {
                     data[0] = 1;
                  } else if (data.length == 0) {
                     data = new byte[]{1};
                     wrapper.set(Type.REMAINING_BYTES, 0, data);
                  } else {
                     Via.getPlatform().getLogger().warning("Received unexpected data in velocity:player_info (length=" + data.length + ")");
                  }
               }

            });
         }
      });
   }

   public void init(UserConnection connection) {
      connection.put(new ChatTypeStorage());
   }

   @Nullable
   public static ChatDecorationResult decorateChatMessage(CompoundTag chatType, int chatTypeId, JsonElement senderName, @Nullable JsonElement teamName, JsonElement message) {
      if (chatType == null) {
         Via.getPlatform().getLogger().warning("Chat message has unknown chat type id " + chatTypeId + ". Message: " + message);
         return null;
      } else {
         CompoundTag chatData = (CompoundTag)((CompoundTag)chatType.get("element")).get("chat");
         boolean overlay = false;
         if (chatData == null) {
            chatData = (CompoundTag)((CompoundTag)chatType.get("element")).get("overlay");
            if (chatData == null) {
               return null;
            }

            overlay = true;
         }

         CompoundTag decoaration = (CompoundTag)chatData.get("decoration");
         if (decoaration == null) {
            return new ChatDecorationResult(message, overlay);
         } else {
            String translationKey = (String)decoaration.get("translation_key").getValue();
            TranslatableComponent.Builder componentBuilder = Component.translatable().key(translationKey);
            CompoundTag style = (CompoundTag)decoaration.get("style");
            Iterator var20;
            if (style != null) {
               Style.Builder styleBuilder = Style.style();
               StringTag color = (StringTag)style.get("color");
               if (color != null) {
                  NamedTextColor textColor = (NamedTextColor)NamedTextColor.NAMES.value(color.getValue());
                  if (textColor != null) {
                     styleBuilder.color((TextColor)NamedTextColor.NAMES.value(color.getValue()));
                  }
               }

               var20 = TextDecoration.NAMES.keys().iterator();

               while(var20.hasNext()) {
                  String key = (String)var20.next();
                  if (style.contains(key)) {
                     styleBuilder.decoration((TextDecoration)TextDecoration.NAMES.value(key), ((ByteTag)style.get(key)).asByte() == 1);
                  }
               }

               componentBuilder.style(styleBuilder.build());
            }

            ListTag parameters = (ListTag)decoaration.get("parameters");
            if (parameters != null) {
               List<Component> arguments = new ArrayList();
               var20 = parameters.iterator();

               while(var20.hasNext()) {
                  Tag element = (Tag)var20.next();
                  JsonElement argument = null;
                  String var16 = (String)element.getValue();
                  byte var17 = -1;
                  switch(var16.hashCode()) {
                  case -905962955:
                     if (var16.equals("sender")) {
                        var17 = 0;
                     }
                     break;
                  case -175906003:
                     if (var16.equals("team_name")) {
                        var17 = 2;
                     }
                     break;
                  case 951530617:
                     if (var16.equals("content")) {
                        var17 = 1;
                     }
                  }

                  switch(var17) {
                  case 0:
                     argument = senderName;
                     break;
                  case 1:
                     argument = message;
                     break;
                  case 2:
                     Preconditions.checkNotNull(teamName, "Team name is null");
                     argument = teamName;
                     break;
                  default:
                     Via.getPlatform().getLogger().warning("Unknown parameter for chat decoration: " + element.getValue());
                  }

                  if (argument != null) {
                     arguments.add(GsonComponentSerializer.gson().deserializeFromTree(argument));
                  }
               }

               componentBuilder.args((List)arguments);
            }

            return new ChatDecorationResult(GsonComponentSerializer.gson().serializeToTree(componentBuilder.build()), overlay);
         }
      }
   }

   static {
      try {
         CHAT_REGISTRY = (CompoundTag)BinaryTagIO.readString("{\n  \"minecraft:chat_type\": {\n    \"type\": \"minecraft:chat_type\",\n    \"value\": [\n         {\n            \"name\":\"minecraft:chat\",\n            \"id\":1,\n            \"element\":{\n               \"chat\":{\n                  \"translation_key\":\"chat.type.text\",\n                  \"parameters\":[\n                     \"sender\",\n                     \"content\"\n                  ]\n               },\n               \"narration\":{\n                  \"translation_key\":\"chat.type.text.narrate\",\n                  \"parameters\":[\n                     \"sender\",\n                     \"content\"\n                  ]\n               }\n            }\n         }    ]\n  }\n}").get("minecraft:chat_type");
      } catch (IOException var1) {
         throw new RuntimeException(var1);
      }
   }
}
