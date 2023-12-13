package com.replaymod.core.versions;

import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.AbstractPackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PackResources.ResourceOutput;
import net.minecraft.server.packs.resources.IoSupplier;
import org.apache.commons.io.IOUtils;

public class LangResourcePack extends AbstractPackResources {
   private static final Gson GSON = new Gson();
   public static final String NAME = "replaymod_lang";
   private static final Pattern JSON_FILE_PATTERN = Pattern.compile("^assets/replaymod/lang/([a-z][a-z])_([a-z][a-z]).json$");
   private static final Pattern LANG_FILE_NAME_PATTERN = Pattern.compile("^([a-z][a-z])_([a-z][a-z]).lang$");
   public static final String LEGACY_KEY_PREFIX = "replaymod.input.";
   private static final String FABRIC_KEY_FORMAT = "key.replaymod.%s";
   private final Path basePath;

   public LangResourcePack() {
      super("replaymod_lang", true);
      ModContainer container = (ModContainer)FabricLoader.getInstance().getModContainer("replaymod").orElseThrow(IllegalAccessError::new);
      this.basePath = container.getRootPath();
   }

   private String langName(String path) {
      Matcher matcher = JSON_FILE_PATTERN.matcher(path);
      return !matcher.matches() ? null : String.format("%s_%s.lang", matcher.group(1), matcher.group(2).toUpperCase());
   }

   private Path baseLangPath() {
      return this.basePath.resolve("assets").resolve("replaymod").resolve("lang");
   }

   private Path langPath(String path) {
      String langName = this.langName(path);
      if (langName == null) {
         return null;
      } else {
         Path basePath = this.baseLangPath();
         return basePath.resolve(langName);
      }
   }

   private String convertValue(String value) {
      return value;
   }

   public IoSupplier<InputStream> getRootResource(String... segments) {
      byte[] bytes;
      try {
         bytes = this.readFile(String.join("/", segments));
      } catch (IOException var4) {
         throw new RuntimeException(var4);
      }

      return bytes == null ? null : () -> {
         return new ByteArrayInputStream(bytes);
      };
   }

   public IoSupplier<InputStream> getResource(PackType type, ResourceLocation id) {
      return this.getRootResource(type.getDirectory(), id.getNamespace(), id.getPath());
   }

   private byte[] readFile(String path) throws IOException {
      if ("pack.mcmeta".equals(path)) {
         return "{\"pack\": {\"description\": \"ReplayMod language files\", \"pack_format\": 4}}".getBytes(StandardCharsets.UTF_8);
      } else {
         Path langPath = this.langPath(path);
         if (langPath == null) {
            return null;
         } else {
            InputStream in = Files.newInputStream(langPath);

            List langFile;
            try {
               langFile = IOUtils.readLines(in, StandardCharsets.UTF_8);
            } catch (Throwable var11) {
               if (in != null) {
                  try {
                     in.close();
                  } catch (Throwable var10) {
                     var11.addSuppressed(var10);
                  }
               }

               throw var11;
            }

            if (in != null) {
               in.close();
            }

            Map<String, String> properties = new HashMap();
            Iterator var5 = langFile.iterator();

            while(var5.hasNext()) {
               String line = (String)var5.next();
               if (!line.trim().isEmpty() && !line.trim().startsWith("#")) {
                  int i = line.indexOf(61);
                  String key = line.substring(0, i);
                  String value = line.substring(i + 1);
                  value = this.convertValue(value);
                  if (key.startsWith("replaymod.input.")) {
                     properties.put(key, value);
                     key = String.format("key.replaymod.%s", key.substring("replaymod.input.".length()));
                  }

                  properties.put(key, value);
               }
            }

            return GSON.toJson(properties).getBytes(StandardCharsets.UTF_8);
         }
      }
   }

   public void listResources(PackType type, String namespace, String prefix, ResourceOutput consumer) {
      this.findResources(type, prefix, (id) -> {
         consumer.accept(id, () -> {
            return new ByteArrayInputStream((byte[])Objects.requireNonNull(this.readFile(id.getPath())));
         });
      });
   }

   private void findResources(PackType type, String path, Consumer<ResourceLocation> consumer) {
      if (type == PackType.CLIENT_RESOURCES) {
         if ("lang".equals(path)) {
            Path base = this.baseLangPath();

            try {
               Stream stream = Files.walk(base, 1, new FileVisitOption[0]);

               try {
                  Stream var10000 = stream.skip(1L).filter((x$0) -> {
                     return Files.isRegularFile(x$0, new LinkOption[0]);
                  }).map(Path::getFileName).map(Path::toString);
                  Pattern var10001 = LANG_FILE_NAME_PATTERN;
                  Objects.requireNonNull(var10001);
                  var10000.map(var10001::matcher).filter(Matcher::matches).map((matcher) -> {
                     return String.format("%s_%s.json", matcher.group(1), matcher.group(1));
                  }).map((name) -> {
                     return new ResourceLocation("replaymod", "lang/" + name);
                  }).forEach(consumer);
               } catch (Throwable var9) {
                  if (stream != null) {
                     try {
                        stream.close();
                     } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                     }
                  }

                  throw var9;
               }

               if (stream != null) {
                  stream.close();
               }
            } catch (IOException var10) {
               var10.printStackTrace();
            }

         }
      }
   }

   public Set<String> getNamespaces(PackType resourcePackType) {
      return resourcePackType == PackType.CLIENT_RESOURCES ? Collections.singleton("replaymod") : Collections.emptySet();
   }

   public void close() {
   }
}
