package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.data;

import com.replaymod.replaystudio.lib.guava.collect.BiMap;
import com.replaymod.replaystudio.lib.guava.collect.HashBiMap;
import com.replaymod.replaystudio.lib.guava.io.CharStreams;
import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.data.BiMappings;
import com.replaymod.replaystudio.lib.viaversion.api.data.Int2IntMapBiMappings;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataLoader;
import com.replaymod.replaystudio.lib.viaversion.api.data.Mappings;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.reflect.TypeToken;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntArrayTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import com.replaymod.replaystudio.lib.viaversion.util.GsonUtil;
import com.replaymod.replaystudio.lib.viaversion.util.Int2IntBiHashMap;
import com.replaymod.replaystudio.lib.viaversion.util.Key;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MappingData extends MappingDataBase {
   private final Map<String, int[]> blockTags = new HashMap();
   private final Map<String, int[]> itemTags = new HashMap();
   private final Map<String, int[]> fluidTags = new HashMap();
   private final BiMap<Short, String> oldEnchantmentsIds = HashBiMap.create();
   private final Map<String, String> translateMapping = new HashMap();
   private final Map<String, String> mojangTranslation = new HashMap();
   private final BiMap<String, String> channelMappings = HashBiMap.create();

   public MappingData() {
      super("1.12", "1.13");
   }

   protected void loadExtras(CompoundTag data) {
      this.loadTags(this.blockTags, (CompoundTag)data.get("block_tags"));
      this.loadTags(this.itemTags, (CompoundTag)data.get("item_tags"));
      this.loadTags(this.fluidTags, (CompoundTag)data.get("fluid_tags"));
      CompoundTag legacyEnchantments = (CompoundTag)data.get("legacy_enchantments");
      this.loadEnchantments(this.oldEnchantmentsIds, legacyEnchantments);
      if (Via.getConfig().isSnowCollisionFix()) {
         this.blockMappings.setNewId(1248, 3416);
      }

      if (Via.getConfig().isInfestedBlocksFix()) {
         this.blockMappings.setNewId(1552, 1);
         this.blockMappings.setNewId(1553, 14);
         this.blockMappings.setNewId(1554, 3983);
         this.blockMappings.setNewId(1555, 3984);
         this.blockMappings.setNewId(1556, 3985);
         this.blockMappings.setNewId(1557, 3986);
      }

      JsonObject object = MappingDataLoader.loadFromDataDir("channelmappings-1.13.json");
      if (object != null) {
         Iterator var4 = object.entrySet().iterator();

         while(var4.hasNext()) {
            Entry<String, JsonElement> entry = (Entry)var4.next();
            String oldChannel = (String)entry.getKey();
            String newChannel = ((JsonElement)entry.getValue()).getAsString();
            if (!isValid1_13Channel(newChannel)) {
               Via.getPlatform().getLogger().warning("Channel '" + newChannel + "' is not a valid 1.13 plugin channel, please check your configuration!");
            } else {
               this.channelMappings.put(oldChannel, newChannel);
            }
         }
      }

      Map translationMappingData = (Map)GsonUtil.getGson().fromJson((Reader)(new InputStreamReader(MappingData.class.getClassLoader().getResourceAsStream("assets/viaversion/data/mapping-lang-1.12-1.13.json"))), (Type)(new TypeToken<Map<String, String>>() {
      }).getType());

      String[] unmappedTranslationLines;
      try {
         Reader reader = new InputStreamReader(MappingData.class.getClassLoader().getResourceAsStream("assets/viaversion/data/en_US.properties"), StandardCharsets.UTF_8);
         Throwable var27 = null;

         try {
            unmappedTranslationLines = CharStreams.toString((Readable)reader).split("\n");
         } catch (Throwable var20) {
            var27 = var20;
            throw var20;
         } finally {
            if (reader != null) {
               if (var27 != null) {
                  try {
                     reader.close();
                  } catch (Throwable var19) {
                     var27.addSuppressed(var19);
                  }
               } else {
                  reader.close();
               }
            }

         }
      } catch (IOException var22) {
         throw new RuntimeException(var22);
      }

      String[] var26 = unmappedTranslationLines;
      int var28 = unmappedTranslationLines.length;

      for(int var8 = 0; var8 < var28; ++var8) {
         String line = var26[var8];
         if (!line.isEmpty()) {
            String[] keyAndTranslation = line.split("=", 2);
            if (keyAndTranslation.length == 2) {
               String key = keyAndTranslation[0];
               String translation = keyAndTranslation[1].replaceAll("%(\\d\\$)?d", "%$1s").trim();
               this.mojangTranslation.put(key, translation);
               if (translationMappingData.containsKey(key)) {
                  String mappedKey = (String)translationMappingData.get(key);
                  this.translateMapping.put(key, mappedKey != null ? mappedKey : key);
               }
            }
         }
      }

   }

   @Nullable
   protected Mappings loadMappings(CompoundTag data, String key) {
      if (key.equals("blocks")) {
         return super.loadMappings(data, "blockstates");
      } else {
         return key.equals("blockstates") ? null : super.loadMappings(data, key);
      }
   }

   @Nullable
   protected BiMappings loadBiMappings(CompoundTag data, String key) {
      return key.equals("items") ? (BiMappings)MappingDataLoader.loadMappings(data, "items", (size) -> {
         Int2IntBiHashMap map = new Int2IntBiHashMap(size);
         map.defaultReturnValue(-1);
         return map;
      }, Int2IntBiHashMap::put, (v, mappedSize) -> {
         return Int2IntMapBiMappings.of(v);
      }) : super.loadBiMappings(data, key);
   }

   public static String validateNewChannel(String newId) {
      if (!isValid1_13Channel(newId)) {
         return null;
      } else {
         int separatorIndex = newId.indexOf(58);
         if (separatorIndex == -1) {
            return "minecraft:" + newId;
         } else {
            return separatorIndex == 0 ? "minecraft" + newId : newId;
         }
      }
   }

   public static boolean isValid1_13Channel(String channelId) {
      return channelId.matches("([0-9a-z_.-]+:)?[0-9a-z_/.-]+");
   }

   private void loadTags(Map<String, int[]> output, CompoundTag newTags) {
      Iterator var3 = newTags.entrySet().iterator();

      while(var3.hasNext()) {
         Entry<String, Tag> entry = (Entry)var3.next();
         IntArrayTag ids = (IntArrayTag)entry.getValue();
         output.put(Key.namespaced((String)entry.getKey()), ids.getValue());
      }

   }

   private void loadEnchantments(Map<Short, String> output, CompoundTag enchantments) {
      Iterator var3 = enchantments.entrySet().iterator();

      while(var3.hasNext()) {
         Entry<String, Tag> enty = (Entry)var3.next();
         output.put(Short.parseShort((String)enty.getKey()), ((StringTag)enty.getValue()).getValue());
      }

   }

   public Map<String, int[]> getBlockTags() {
      return this.blockTags;
   }

   public Map<String, int[]> getItemTags() {
      return this.itemTags;
   }

   public Map<String, int[]> getFluidTags() {
      return this.fluidTags;
   }

   public BiMap<Short, String> getOldEnchantmentsIds() {
      return this.oldEnchantmentsIds;
   }

   public Map<String, String> getTranslateMapping() {
      return this.translateMapping;
   }

   public Map<String, String> getMojangTranslation() {
      return this.mojangTranslation;
   }

   public BiMap<String, String> getChannelMappings() {
      return this.channelMappings;
   }
}
