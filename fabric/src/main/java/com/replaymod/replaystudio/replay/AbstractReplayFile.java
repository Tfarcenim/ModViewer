package com.replaymod.replaystudio.replay;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.replaymod.replaystudio.Studio;
import com.replaymod.replaystudio.data.Marker;
import com.replaymod.replaystudio.data.ModInfo;
import com.replaymod.replaystudio.data.ReplayAssetEntry;
import com.replaymod.replaystudio.io.ReplayInputStream;
import com.replaymod.replaystudio.io.ReplayOutputStream;
import com.replaymod.replaystudio.lib.guava.base.Optional;
import com.replaymod.replaystudio.lib.guava.io.Closeables;
import com.replaymod.replaystudio.pathing.PathingRegistry;
import com.replaymod.replaystudio.pathing.path.Timeline;
import com.replaymod.replaystudio.pathing.serialize.TimelineSerialization;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public abstract class AbstractReplayFile implements ReplayFile {
   private static final String ENTRY_META_DATA = "metaData.json";
   protected static final String ENTRY_RECORDING = "recording.tmcpr";
   private static final String ENTRY_RESOURCE_PACK = "resourcepack/%s.zip";
   private static final String ENTRY_RESOURCE_PACK_INDEX = "resourcepack/index.json";
   private static final String ENTRY_THUMB_OLD = "thumb";
   private static final String ENTRY_THUMB = "thumb.jpg";
   private static final String ENTRY_VISIBILITY_OLD = "visibility";
   private static final String ENTRY_VISIBILITY = "visibility.json";
   private static final String ENTRY_MARKERS = "markers.json";
   private static final String ENTRY_ASSET = "asset/%s_%s.%s";
   private static final Pattern PATTERN_ASSETS = Pattern.compile("asset/.*");
   private static final String ENTRY_MODS = "mods.json";
   private static final byte[] THUMB_MAGIC_NUMBERS = new byte[]{0, 1, 1, 2, 3, 5, 8};
   protected final Studio studio;

   public AbstractReplayFile(Studio studio) throws IOException {
      this.studio = studio;
   }

   public ReplayMetaData getMetaData() throws IOException {
      Optional<InputStream> in = this.get("metaData.json");
      if (!in.isPresent()) {
         return null;
      } else {
         Reader is = new InputStreamReader((InputStream)in.get());
         Throwable var3 = null;

         ReplayMetaData var4;
         try {
            var4 = (ReplayMetaData)(new Gson()).fromJson(is, ReplayMetaData.class);
         } catch (Throwable var13) {
            var3 = var13;
            throw var13;
         } finally {
            if (is != null) {
               if (var3 != null) {
                  try {
                     is.close();
                  } catch (Throwable var12) {
                     var3.addSuppressed(var12);
                  }
               } else {
                  is.close();
               }
            }

         }

         return var4;
      }
   }

   public void writeMetaData(PacketTypeRegistry registry, ReplayMetaData metaData) throws IOException {
      metaData.setFileFormat("MCPR");
      if (registry != null) {
         metaData.setFileFormatVersion(14);
         metaData.setProtocolVersion(registry.getVersion().getOriginalVersion());
      }

      if (metaData.getGenerator() == null) {
         metaData.setGenerator("ReplayStudio v" + this.studio.getVersion());
      }

      OutputStream out = this.write("metaData.json");
      Throwable var4 = null;

      try {
         String json = (new Gson()).toJson(metaData);
         out.write(json.getBytes());
      } catch (Throwable var13) {
         var4 = var13;
         throw var13;
      } finally {
         if (out != null) {
            if (var4 != null) {
               try {
                  out.close();
               } catch (Throwable var12) {
                  var4.addSuppressed(var12);
               }
            } else {
               out.close();
            }
         }

      }

   }

   public ReplayInputStream getPacketData(PacketTypeRegistry registry) throws IOException {
      Optional<InputStream> in = this.get("recording.tmcpr");
      if (!in.isPresent()) {
         return null;
      } else {
         ReplayMetaData metaData = this.getMetaData();
         return new ReplayInputStream(registry, (InputStream)in.get(), metaData.getFileFormatVersion(), metaData.getRawProtocolVersionOr0());
      }
   }

   public ReplayOutputStream writePacketData() throws IOException {
      return new ReplayOutputStream(this.write("recording.tmcpr"));
   }

   public Map<Integer, String> getResourcePackIndex() throws IOException {
      Optional<InputStream> in = this.get("resourcepack/index.json");
      if (!in.isPresent()) {
         return null;
      } else {
         Map<Integer, String> index = new HashMap();
         Reader is = new InputStreamReader((InputStream)in.get());
         Throwable var4 = null;

         try {
            JsonObject array = (JsonObject)(new Gson()).fromJson(is, JsonObject.class);
            Iterator var6 = array.entrySet().iterator();

            while(var6.hasNext()) {
               Entry e = (Entry)var6.next();

               try {
                  index.put(Integer.parseInt((String)e.getKey()), ((JsonElement)e.getValue()).getAsString());
               } catch (NumberFormatException var17) {
               }
            }
         } catch (Throwable var18) {
            var4 = var18;
            throw var18;
         } finally {
            if (is != null) {
               if (var4 != null) {
                  try {
                     is.close();
                  } catch (Throwable var16) {
                     var4.addSuppressed(var16);
                  }
               } else {
                  is.close();
               }
            }

         }

         return index;
      }
   }

   public void writeResourcePackIndex(Map<Integer, String> index) throws IOException {
      OutputStream out = this.write("resourcepack/index.json");
      Throwable var3 = null;

      try {
         String json = (new Gson()).toJson(index);
         out.write(json.getBytes());
      } catch (Throwable var12) {
         var3 = var12;
         throw var12;
      } finally {
         if (out != null) {
            if (var3 != null) {
               try {
                  out.close();
               } catch (Throwable var11) {
                  var3.addSuppressed(var11);
               }
            } else {
               out.close();
            }
         }

      }

   }

   public Optional<InputStream> getResourcePack(String hash) throws IOException {
      return this.get(String.format("resourcepack/%s.zip", hash));
   }

   public OutputStream writeResourcePack(String hash) throws IOException {
      return this.write(String.format("resourcepack/%s.zip", hash));
   }

   public Map<String, Timeline> getTimelines(PathingRegistry pathingRegistry) throws IOException {
      return (new TimelineSerialization(pathingRegistry, this)).load();
   }

   public void writeTimelines(PathingRegistry pathingRegistry, Map<String, Timeline> timelines) throws IOException {
      (new TimelineSerialization(pathingRegistry, this)).save(timelines);
   }

   public Optional<InputStream> getThumbBytes() throws IOException {
      Optional<InputStream> maybeThumb = this.get("thumb.jpg");
      if (maybeThumb.isPresent()) {
         return Optional.of(maybeThumb.get());
      } else {
         maybeThumb = this.get("thumb");
         if (maybeThumb.isPresent()) {
            PushbackInputStream in = new PushbackInputStream((InputStream)maybeThumb.get(), THUMB_MAGIC_NUMBERS.length);
            byte[] buf = new byte[THUMB_MAGIC_NUMBERS.length];
            (new DataInputStream(in)).readFully(buf);
            if (!Arrays.equals(buf, THUMB_MAGIC_NUMBERS)) {
               in.unread(buf);
            }

            return Optional.of(in);
         } else {
            return Optional.absent();
         }
      }
   }

   public void writeThumbBytes(byte[] image) throws IOException {
      OutputStream out = this.write("thumb.jpg");
      Throwable var3 = null;

      try {
         out.write(image);
      } catch (Throwable var12) {
         var3 = var12;
         throw var12;
      } finally {
         if (out != null) {
            if (var3 != null) {
               try {
                  out.close();
               } catch (Throwable var11) {
                  var3.addSuppressed(var11);
               }
            } else {
               out.close();
            }
         }

      }

   }

   public Optional<Set<UUID>> getInvisiblePlayers() throws IOException {
      Optional<InputStream> in = this.get("visibility.json");
      if (!in.isPresent()) {
         in = this.get("visibility");
         if (!in.isPresent()) {
            return Optional.absent();
         }
      }

      Set<UUID> uuids = new HashSet();
      Reader is = new InputStreamReader((InputStream)in.get());
      Throwable var4 = null;

      try {
         JsonObject json = (JsonObject)(new Gson()).fromJson(is, JsonObject.class);
         Iterator var6 = json.getAsJsonArray("hidden").iterator();

         while(var6.hasNext()) {
            JsonElement e = (JsonElement)var6.next();
            uuids.add(UUID.fromString(e.getAsString()));
         }
      } catch (Throwable var15) {
         var4 = var15;
         throw var15;
      } finally {
         if (is != null) {
            if (var4 != null) {
               try {
                  is.close();
               } catch (Throwable var14) {
                  var4.addSuppressed(var14);
               }
            } else {
               is.close();
            }
         }

      }

      return Optional.of(uuids);
   }

   public void writeInvisiblePlayers(Set<UUID> uuids) throws IOException {
      OutputStream out = this.write("visibility.json");
      Throwable var3 = null;

      try {
         JsonObject root = new JsonObject();
         JsonArray array = new JsonArray();
         root.add("hidden", array);
         Iterator var6 = uuids.iterator();

         while(var6.hasNext()) {
            UUID uuid = (UUID)var6.next();
            array.add(new JsonPrimitive(uuid.toString()));
         }

         String json = (new Gson()).toJson(root);
         out.write(json.getBytes());
      } catch (Throwable var15) {
         var3 = var15;
         throw var15;
      } finally {
         if (out != null) {
            if (var3 != null) {
               try {
                  out.close();
               } catch (Throwable var14) {
                  var3.addSuppressed(var14);
               }
            } else {
               out.close();
            }
         }

      }
   }

   public Optional<Set<Marker>> getMarkers() throws IOException {
      Optional<InputStream> in = this.get("markers.json");
      if (in.isPresent()) {
         Reader is = new InputStreamReader((InputStream)in.get());
         Throwable var3 = null;

         try {
            JsonArray json = (JsonArray)(new Gson()).fromJson(is, JsonArray.class);
            Set<Marker> markers = new HashSet();

            Marker marker;
            for(Iterator var6 = json.iterator(); var6.hasNext(); markers.add(marker)) {
               JsonElement element = (JsonElement)var6.next();
               JsonObject obj = element.getAsJsonObject();
               JsonObject value = obj.getAsJsonObject("value");
               JsonObject position = value.getAsJsonObject("position");
               marker = new Marker();
               marker.setTime(obj.get("realTimestamp").getAsInt());
               marker.setX(position.get("x").getAsDouble());
               marker.setY(position.get("y").getAsDouble());
               marker.setZ(position.get("z").getAsDouble());
               marker.setYaw(position.get("yaw").getAsFloat());
               marker.setPitch(position.get("pitch").getAsFloat());
               marker.setRoll(position.get("roll").getAsFloat());
               if (value.has("name")) {
                  marker.setName(value.get("name").getAsString());
               }
            }

            Optional var21 = Optional.of(markers);
            return var21;
         } catch (Throwable var19) {
            var3 = var19;
            throw var19;
         } finally {
            if (is != null) {
               if (var3 != null) {
                  try {
                     is.close();
                  } catch (Throwable var18) {
                     var3.addSuppressed(var18);
                  }
               } else {
                  is.close();
               }
            }

         }
      } else {
         return Optional.absent();
      }
   }

   public void writeMarkers(Set<Marker> markers) throws IOException {
      OutputStream out = this.write("markers.json");
      Throwable var3 = null;

      try {
         JsonArray root = new JsonArray();
         Iterator var5 = markers.iterator();

         while(var5.hasNext()) {
            Marker marker = (Marker)var5.next();
            JsonObject entry = new JsonObject();
            JsonObject value = new JsonObject();
            JsonObject position = new JsonObject();
            entry.add("realTimestamp", new JsonPrimitive(marker.getTime()));
            value.add("name", marker.getName() == null ? null : new JsonPrimitive(marker.getName()));
            position.add("x", new JsonPrimitive(marker.getX()));
            position.add("y", new JsonPrimitive(marker.getY()));
            position.add("z", new JsonPrimitive(marker.getZ()));
            position.add("yaw", new JsonPrimitive(marker.getYaw()));
            position.add("pitch", new JsonPrimitive(marker.getPitch()));
            position.add("roll", new JsonPrimitive(marker.getRoll()));
            value.add("position", position);
            entry.add("value", value);
            root.add(entry);
         }

         out.write((new Gson()).toJson(root).getBytes());
      } catch (Throwable var17) {
         var3 = var17;
         throw var17;
      } finally {
         if (out != null) {
            if (var3 != null) {
               try {
                  out.close();
               } catch (Throwable var16) {
                  var3.addSuppressed(var16);
               }
            } else {
               out.close();
            }
         }

      }
   }

   public Collection<ReplayAssetEntry> getAssets() throws IOException {
      Map<String, InputStream> entries = this.getAll(PATTERN_ASSETS);
      entries.values().forEach(Closeables::closeQuietly);
      List<ReplayAssetEntry> list = new ArrayList();
      Iterator var3 = entries.keySet().iterator();

      while(var3.hasNext()) {
         String key = (String)var3.next();
         int delim = key.indexOf(95);
         UUID uuid = UUID.fromString(key.substring(0, delim));
         String name = key.substring(delim + 1, key.lastIndexOf(46));
         String extension = key.substring(key.lastIndexOf(46));
         list.add(new ReplayAssetEntry(uuid, extension, name));
      }

      return list;
   }

   public Optional<InputStream> getAsset(UUID uuid) throws IOException {
      Map<String, InputStream> entries = this.getAll(Pattern.compile("asset/" + Pattern.quote(uuid.toString()) + "_.*"));
      return entries.isEmpty() ? Optional.absent() : Optional.of(entries.values().iterator().next());
   }

   public OutputStream writeAsset(ReplayAssetEntry asset) throws IOException {
      return this.write(String.format("asset/%s_%s.%s", asset.getUuid().toString(), asset.getName(), asset.getFileExtension()));
   }

   public void removeAsset(UUID uuid) throws IOException {
      Collection<ReplayAssetEntry> assets = this.getAssets();
      Iterator var3 = assets.iterator();

      while(var3.hasNext()) {
         ReplayAssetEntry asset = (ReplayAssetEntry)var3.next();
         if (asset.getUuid().equals(uuid)) {
            this.remove(String.format("asset/%s_%s.%s", asset.getUuid().toString(), asset.getName(), asset.getFileExtension()));
         }
      }

   }

   public Collection<ModInfo> getModInfo() throws IOException {
      Optional<InputStream> in = this.get("mods.json");
      if (in.isPresent()) {
         Reader is = new InputStreamReader((InputStream)in.get());
         Throwable var3 = null;

         try {
            JsonArray json = ((JsonObject)(new Gson()).fromJson(is, JsonObject.class)).getAsJsonArray("requiredMods");
            List<ModInfo> modInfoList = new ArrayList();
            Iterator var6 = json.iterator();

            while(var6.hasNext()) {
               JsonElement element = (JsonElement)var6.next();
               JsonObject obj = element.getAsJsonObject();
               modInfoList.add(new ModInfo(obj.get("modID").getAsString(), obj.get("modName").getAsString(), obj.get("modVersion").getAsString()));
            }

            ArrayList var18 = modInfoList;
            return var18;
         } catch (Throwable var16) {
            var3 = var16;
            throw var16;
         } finally {
            if (is != null) {
               if (var3 != null) {
                  try {
                     is.close();
                  } catch (Throwable var15) {
                     var3.addSuppressed(var15);
                  }
               } else {
                  is.close();
               }
            }

         }
      } else {
         return Collections.emptyList();
      }
   }

   public void writeModInfo(Collection<ModInfo> modInfo) throws IOException {
      OutputStream out = this.write("mods.json");
      Throwable var3 = null;

      try {
         JsonObject root = new JsonObject();
         JsonArray array = new JsonArray();
         Iterator var6 = modInfo.iterator();

         while(var6.hasNext()) {
            ModInfo mod = (ModInfo)var6.next();
            JsonObject entry = new JsonObject();
            entry.addProperty("modID", mod.getId());
            entry.addProperty("modName", mod.getName());
            entry.addProperty("modVersion", mod.getVersion());
            array.add(entry);
         }

         root.add("requiredMods", array);
         out.write((new Gson()).toJson(root).getBytes());
      } catch (Throwable var16) {
         var3 = var16;
         throw var16;
      } finally {
         if (out != null) {
            if (var3 != null) {
               try {
                  out.close();
               } catch (Throwable var15) {
                  var3.addSuppressed(var15);
               }
            } else {
               out.close();
            }
         }

      }
   }
}
