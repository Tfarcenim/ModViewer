package com.replaymod.replaystudio.replay;

import com.replaymod.replaystudio.data.Marker;
import com.replaymod.replaystudio.data.ModInfo;
import com.replaymod.replaystudio.data.ReplayAssetEntry;
import com.replaymod.replaystudio.io.ReplayInputStream;
import com.replaymod.replaystudio.io.ReplayOutputStream;
import com.replaymod.replaystudio.lib.guava.base.Optional;
import com.replaymod.replaystudio.pathing.PathingRegistry;
import com.replaymod.replaystudio.pathing.path.Timeline;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

public interface ReplayFile extends Closeable {
   Optional<InputStream> get(String var1) throws IOException;

   Optional<InputStream> getCache(String var1) throws IOException;

   Map<String, InputStream> getAll(Pattern var1) throws IOException;

   OutputStream write(String var1) throws IOException;

   OutputStream writeCache(String var1) throws IOException;

   void remove(String var1) throws IOException;

   void removeCache(String var1) throws IOException;

   void save() throws IOException;

   void saveTo(File var1) throws IOException;

   ReplayMetaData getMetaData() throws IOException;

   void writeMetaData(PacketTypeRegistry var1, ReplayMetaData var2) throws IOException;

   ReplayInputStream getPacketData(PacketTypeRegistry var1) throws IOException;

   ReplayOutputStream writePacketData() throws IOException;

   Map<Integer, String> getResourcePackIndex() throws IOException;

   void writeResourcePackIndex(Map<Integer, String> var1) throws IOException;

   Optional<InputStream> getResourcePack(String var1) throws IOException;

   OutputStream writeResourcePack(String var1) throws IOException;

   Map<String, Timeline> getTimelines(PathingRegistry var1) throws IOException;

   void writeTimelines(PathingRegistry var1, Map<String, Timeline> var2) throws IOException;

   default Optional<BufferedImage> getThumb() throws IOException {
      Optional<InputStream> maybeThumb = this.getThumbBytes();
      return maybeThumb.isPresent() ? Optional.of(ImageIO.read((InputStream)maybeThumb.get())) : Optional.absent();
   }

   default void writeThumb(BufferedImage image) throws IOException {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ImageIO.write(image, "jpg", out);
      this.writeThumbBytes(out.toByteArray());
   }

   Optional<InputStream> getThumbBytes() throws IOException;

   void writeThumbBytes(byte[] var1) throws IOException;

   Optional<Set<UUID>> getInvisiblePlayers() throws IOException;

   void writeInvisiblePlayers(Set<UUID> var1) throws IOException;

   Optional<Set<Marker>> getMarkers() throws IOException;

   void writeMarkers(Set<Marker> var1) throws IOException;

   Collection<ReplayAssetEntry> getAssets() throws IOException;

   Optional<InputStream> getAsset(UUID var1) throws IOException;

   OutputStream writeAsset(ReplayAssetEntry var1) throws IOException;

   void removeAsset(UUID var1) throws IOException;

   Collection<ModInfo> getModInfo() throws IOException;

   void writeModInfo(Collection<ModInfo> var1) throws IOException;
}
