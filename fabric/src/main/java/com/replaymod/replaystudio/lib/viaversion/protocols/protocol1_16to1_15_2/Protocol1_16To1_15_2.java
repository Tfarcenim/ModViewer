package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2;

import com.replaymod.replaystudio.lib.guava.base.Joiner;
import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.RegistryType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_16Types;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.ViaProviders;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ParticleType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_16;
import com.replaymod.replaystudio.lib.viaversion.data.entity.EntityTrackerBase;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonArray;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.ServerboundPackets1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.ClientboundPackets1_15;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.data.MappingData;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.data.TranslationMappings;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.metadata.MetadataRewriter1_16To1_15_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.packets.EntityPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.packets.InventoryPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.packets.WorldPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.provider.PlayerAbilitiesProvider;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.storage.InventoryTracker1_16;
import com.replaymod.replaystudio.lib.viaversion.rewriter.SoundRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.StatisticsRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.TagRewriter;
import com.replaymod.replaystudio.lib.viaversion.util.GsonUtil;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Protocol1_16To1_15_2 extends AbstractProtocol<ClientboundPackets1_15, ClientboundPackets1_16, ServerboundPackets1_14, ServerboundPackets1_16> {
   private static final UUID ZERO_UUID = new UUID(0L, 0L);
   public static final MappingData MAPPINGS = new MappingData();
   private final MetadataRewriter1_16To1_15_2 metadataRewriter = new MetadataRewriter1_16To1_15_2(this);
   private final InventoryPackets itemRewriter = new InventoryPackets(this);
   private final TranslationMappings componentRewriter = new TranslationMappings(this);
   private TagRewriter<ClientboundPackets1_15> tagRewriter;

   public Protocol1_16To1_15_2() {
      super(ClientboundPackets1_15.class, ClientboundPackets1_16.class, ServerboundPackets1_14.class, ServerboundPackets1_16.class);
   }

   protected void registerPackets() {
      this.metadataRewriter.register();
      this.itemRewriter.register();
      EntityPackets.register(this);
      WorldPackets.register(this);
      this.tagRewriter = new TagRewriter(this);
      this.tagRewriter.register(ClientboundPackets1_15.TAGS, RegistryType.ENTITY);
      (new StatisticsRewriter(this)).register(ClientboundPackets1_15.STATISTICS);
      this.registerClientbound(State.LOGIN, 2, 2, (wrapper) -> {
         UUID uuid = UUID.fromString((String)wrapper.read(Type.STRING));
         wrapper.write(Type.UUID, uuid);
      });
      this.registerClientbound(State.STATUS, 0, 0, (wrapper) -> {
         String original = (String)wrapper.passthrough(Type.STRING);
         JsonObject object = (JsonObject)GsonUtil.getGson().fromJson(original, JsonObject.class);
         JsonObject players = object.getAsJsonObject("players");
         if (players != null) {
            JsonArray sample = players.getAsJsonArray("sample");
            if (sample != null) {
               JsonArray splitSamples = new JsonArray();
               Iterator var6 = sample.iterator();

               while(true) {
                  while(var6.hasNext()) {
                     JsonElement element = (JsonElement)var6.next();
                     JsonObject playerInfo = element.getAsJsonObject();
                     String name = playerInfo.getAsJsonPrimitive("name").getAsString();
                     if (name.indexOf(10) == -1) {
                        splitSamples.add((JsonElement)playerInfo);
                     } else {
                        String id = playerInfo.getAsJsonPrimitive("id").getAsString();
                        String[] var11 = name.split("\n");
                        int var12 = var11.length;

                        for(int var13 = 0; var13 < var12; ++var13) {
                           String s = var11[var13];
                           JsonObject newSample = new JsonObject();
                           newSample.addProperty("name", s);
                           newSample.addProperty("id", id);
                           splitSamples.add((JsonElement)newSample);
                        }
                     }
                  }

                  if (splitSamples.size() != sample.size()) {
                     players.add("sample", splitSamples);
                     wrapper.set(Type.STRING, 0, object.toString());
                  }

                  return;
               }
            }
         }
      });
      this.registerClientbound(ClientboundPackets1_15.CHAT_MESSAGE, new PacketHandlers() {
         public void register() {
            this.map(Type.COMPONENT);
            this.map(Type.BYTE);
            this.handler((wrapper) -> {
               Protocol1_16To1_15_2.this.componentRewriter.processText((JsonElement)wrapper.get(Type.COMPONENT, 0));
               wrapper.write(Type.UUID, Protocol1_16To1_15_2.ZERO_UUID);
            });
         }
      });
      this.componentRewriter.registerBossBar(ClientboundPackets1_15.BOSSBAR);
      this.componentRewriter.registerTitle(ClientboundPackets1_15.TITLE);
      this.componentRewriter.registerCombatEvent(ClientboundPackets1_15.COMBAT_EVENT);
      SoundRewriter<ClientboundPackets1_15> soundRewriter = new SoundRewriter(this);
      soundRewriter.registerSound(ClientboundPackets1_15.SOUND);
      soundRewriter.registerSound(ClientboundPackets1_15.ENTITY_SOUND);
      this.registerServerbound(ServerboundPackets1_16.INTERACT_ENTITY, (wrapper) -> {
         wrapper.passthrough(Type.VAR_INT);
         int action = (Integer)wrapper.passthrough(Type.VAR_INT);
         if (action == 0 || action == 2) {
            if (action == 2) {
               wrapper.passthrough(Type.FLOAT);
               wrapper.passthrough(Type.FLOAT);
               wrapper.passthrough(Type.FLOAT);
            }

            wrapper.passthrough(Type.VAR_INT);
         }

         wrapper.read(Type.BOOLEAN);
      });
      if (Via.getConfig().isIgnoreLong1_16ChannelNames()) {
         this.registerServerbound(ServerboundPackets1_16.PLUGIN_MESSAGE, new PacketHandlers() {
            public void register() {
               this.handler((wrapper) -> {
                  String channel = (String)wrapper.passthrough(Type.STRING);
                  if (channel.length() > 32) {
                     if (!Via.getConfig().isSuppressConversionWarnings()) {
                        Via.getPlatform().getLogger().warning("Ignoring incoming plugin channel, as it is longer than 32 characters: " + channel);
                     }

                     wrapper.cancel();
                  } else if (channel.equals("minecraft:register") || channel.equals("minecraft:unregister")) {
                     String[] channels = (new String((byte[])wrapper.read(Type.REMAINING_BYTES), StandardCharsets.UTF_8)).split("\u0000");
                     List<String> checkedChannels = new ArrayList(channels.length);
                     String[] var4 = channels;
                     int var5 = channels.length;

                     for(int var6 = 0; var6 < var5; ++var6) {
                        String registeredChannel = var4[var6];
                        if (registeredChannel.length() > 32) {
                           if (!Via.getConfig().isSuppressConversionWarnings()) {
                              Via.getPlatform().getLogger().warning("Ignoring incoming plugin channel register of '" + registeredChannel + "', as it is longer than 32 characters");
                           }
                        } else {
                           checkedChannels.add(registeredChannel);
                        }
                     }

                     if (checkedChannels.isEmpty()) {
                        wrapper.cancel();
                        return;
                     }

                     wrapper.write(Type.REMAINING_BYTES, Joiner.on('\u0000').join((Iterable)checkedChannels).getBytes(StandardCharsets.UTF_8));
                  }

               });
            }
         });
      }

      this.registerServerbound(ServerboundPackets1_16.PLAYER_ABILITIES, (wrapper) -> {
         wrapper.passthrough(Type.BYTE);
         PlayerAbilitiesProvider playerAbilities = (PlayerAbilitiesProvider)Via.getManager().getProviders().get(PlayerAbilitiesProvider.class);
         wrapper.write(Type.FLOAT, playerAbilities.getFlyingSpeed(wrapper.user()));
         wrapper.write(Type.FLOAT, playerAbilities.getWalkingSpeed(wrapper.user()));
      });
      this.cancelServerbound(ServerboundPackets1_16.GENERATE_JIGSAW);
      this.cancelServerbound(ServerboundPackets1_16.UPDATE_JIGSAW_BLOCK);
   }

   protected void onMappingDataLoaded() {
      int[] wallPostOverrideTag = new int[47];
      int arrayIndex = 0;
      int var4 = arrayIndex + 1;
      wallPostOverrideTag[arrayIndex] = 140;
      wallPostOverrideTag[var4++] = 179;
      wallPostOverrideTag[var4++] = 264;

      int i;
      for(i = 153; i <= 158; wallPostOverrideTag[var4++] = i++) {
      }

      for(i = 163; i <= 168; wallPostOverrideTag[var4++] = i++) {
      }

      for(i = 408; i <= 439; wallPostOverrideTag[var4++] = i++) {
      }

      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:wall_post_override", wallPostOverrideTag);
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:beacon_base_blocks", 133, 134, 148, 265);
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:climbable", 160, 241, 658);
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:fire", 142);
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:campfires", 679);
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:fence_gates", 242, 467, 468, 469, 470, 471);
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:unstable_bottom_center", 242, 467, 468, 469, 470, 471);
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:wooden_trapdoors", 193, 194, 195, 196, 197, 198);
      this.tagRewriter.addTag(RegistryType.ITEM, "minecraft:wooden_trapdoors", 215, 216, 217, 218, 219, 220);
      this.tagRewriter.addTag(RegistryType.ITEM, "minecraft:beacon_payment_items", 529, 530, 531, 760);
      this.tagRewriter.addTag(RegistryType.ENTITY, "minecraft:impact_projectiles", 2, 72, 71, 37, 69, 79, 83, 15, 93);
      this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:guarded_by_piglins");
      this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:soul_speed_blocks");
      this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:soul_fire_base_blocks");
      this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:non_flammable_wood");
      this.tagRewriter.addEmptyTag(RegistryType.ITEM, "minecraft:non_flammable_wood");
      this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:bamboo_plantable_on", "minecraft:beds", "minecraft:bee_growables", "minecraft:beehives", "minecraft:coral_plants", "minecraft:crops", "minecraft:dragon_immune", "minecraft:flowers", "minecraft:portals", "minecraft:shulker_boxes", "minecraft:small_flowers", "minecraft:tall_flowers", "minecraft:trapdoors", "minecraft:underwater_bonemeals", "minecraft:wither_immune", "minecraft:wooden_fences", "minecraft:wooden_trapdoors");
      this.tagRewriter.addEmptyTags(RegistryType.ENTITY, "minecraft:arrows", "minecraft:beehive_inhabitors", "minecraft:raiders", "minecraft:skeletons");
      this.tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:beds", "minecraft:coals", "minecraft:fences", "minecraft:flowers", "minecraft:lectern_books", "minecraft:music_discs", "minecraft:small_flowers", "minecraft:tall_flowers", "minecraft:trapdoors", "minecraft:walls", "minecraft:wooden_fences");
      Types1_16.PARTICLE.filler(this).reader("block", ParticleType.Readers.BLOCK).reader("dust", ParticleType.Readers.DUST).reader("falling_dust", ParticleType.Readers.BLOCK).reader("item", ParticleType.Readers.VAR_INT_ITEM);
   }

   public void register(ViaProviders providers) {
      providers.register(PlayerAbilitiesProvider.class, new PlayerAbilitiesProvider());
   }

   public void init(UserConnection userConnection) {
      userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, Entity1_16Types.PLAYER));
      userConnection.put(new InventoryTracker1_16());
   }

   public MappingData getMappingData() {
      return MAPPINGS;
   }

   public MetadataRewriter1_16To1_15_2 getEntityRewriter() {
      return this.metadataRewriter;
   }

   public InventoryPackets getItemRewriter() {
      return this.itemRewriter;
   }

   public TranslationMappings getComponentRewriter() {
      return this.componentRewriter;
   }
}
