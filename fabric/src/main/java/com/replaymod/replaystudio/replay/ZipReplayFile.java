package com.replaymod.replaystudio.replay;

import com.replaymod.replaystudio.Studio;
import com.replaymod.replaystudio.lib.guava.base.Charsets;
import com.replaymod.replaystudio.lib.guava.base.Optional;
import com.replaymod.replaystudio.lib.guava.collect.FluentIterable;
import com.replaymod.replaystudio.lib.guava.io.Closeables;
import com.replaymod.replaystudio.util.Utils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipReplayFile extends AbstractReplayFile {
   private static final String ENTRY_RECORDING_HASH = "recording.tmcpr.crc32";
   private final File input;
   private final File output;
   private final File cache;
   private final File tmpFiles;
   private final File changedFiles;
   private final File removedFiles;
   private final File sourceFile;
   private CRC32 recordingCrc;
   private boolean shouldSaveInputFile;
   private final Map<String, OutputStream> outputStreams;
   private final Map<String, File> changedEntries;
   private final Set<String> removedEntries;
   private ZipFile zipFile;

   public ZipReplayFile(Studio studio, File file) throws IOException {
      this(studio, file, file);
   }

   public ZipReplayFile(Studio studio, File input, File output) throws IOException {
      this(studio, input, output, new File(output.getParentFile(), output.getName() + ".cache"));
   }

   public ZipReplayFile(Studio studio, File input, File output, File cache) throws IOException {
      super(studio);
      this.outputStreams = new HashMap();
      this.changedEntries = new HashMap();
      this.removedEntries = new HashSet();
      this.tmpFiles = new File(output.getParentFile(), output.getName() + ".tmp");
      this.changedFiles = new File(this.tmpFiles, "changed");
      this.removedFiles = new File(this.tmpFiles, "removed");
      this.sourceFile = new File(this.tmpFiles, "source");
      if (input != null && input.exists()) {
         this.shouldSaveInputFile = true;
      } else if (input == null && this.sourceFile.exists()) {
         input = new File(new String(Files.readAllBytes(this.sourceFile.toPath()), Charsets.UTF_8));
         if (!input.exists()) {
            throw new IOException("Recovered source file no longer exists.");
         }
      }

      this.output = output;
      this.input = input;
      this.cache = cache;
      if (input != null && input.exists()) {
         this.zipFile = new ZipFile(input);
      }

      if (this.changedFiles.exists()) {
         com.replaymod.replaystudio.lib.guava.io.Files.fileTreeTraverser().breadthFirstTraversal(this.changedFiles).filter(com.replaymod.replaystudio.lib.guava.io.Files.isFile()).forEach((f) -> {
            File var10000 = (File)this.changedEntries.put(this.changedFiles.toURI().relativize(f.toURI()).getPath(), f);
         });
      }

      if (this.removedFiles.exists()) {
         FluentIterable var10000 = com.replaymod.replaystudio.lib.guava.io.Files.fileTreeTraverser().breadthFirstTraversal(this.removedFiles).filter(com.replaymod.replaystudio.lib.guava.io.Files.isFile()).transform((f) -> {
            return this.removedFiles.toURI().relativize(f.toURI()).getPath();
         });
         Set var10001 = this.removedEntries;
         var10000.forEach(var10001::add);
      }

      String cacheHash = null;
      String mcprHash = null;
      Optional<InputStream> cacheIn = this.getCache("recording.tmcpr.crc32");
      if (cacheIn.isPresent()) {
         try {
            InputStream in = (InputStream)cacheIn.get();
            Throwable var9 = null;

            try {
               Reader rin = new InputStreamReader(in);
               Throwable var11 = null;

               try {
                  BufferedReader brin = new BufferedReader(rin);
                  Throwable var13 = null;

                  try {
                     cacheHash = brin.readLine();
                  } catch (Throwable var175) {
                     var13 = var175;
                     throw var175;
                  } finally {
                     if (brin != null) {
                        if (var13 != null) {
                           try {
                              brin.close();
                           } catch (Throwable var174) {
                              var13.addSuppressed(var174);
                           }
                        } else {
                           brin.close();
                        }
                     }

                  }
               } catch (Throwable var183) {
                  var11 = var183;
                  throw var183;
               } finally {
                  if (rin != null) {
                     if (var11 != null) {
                        try {
                           rin.close();
                        } catch (Throwable var173) {
                           var11.addSuppressed(var173);
                        }
                     } else {
                        rin.close();
                     }
                  }

               }
            } catch (Throwable var185) {
               var9 = var185;
               throw var185;
            } finally {
               if (in != null) {
                  if (var9 != null) {
                     try {
                        in.close();
                     } catch (Throwable var172) {
                        var9.addSuppressed(var172);
                     }
                  } else {
                     in.close();
                  }
               }

            }
         } catch (IOException var187) {
         }
      }

      Optional<InputStream> mcprIn = this.get("recording.tmcpr.crc32");
      if (mcprIn.isPresent()) {
         try {
            InputStream in = (InputStream)mcprIn.get();
            Throwable var190 = null;

            try {
               Reader rin = new InputStreamReader(in);
               Throwable var192 = null;

               try {
                  BufferedReader brin = new BufferedReader(rin);
                  Throwable var14 = null;

                  try {
                     mcprHash = brin.readLine();
                  } catch (Throwable var171) {
                     var14 = var171;
                     throw var171;
                  } finally {
                     if (brin != null) {
                        if (var14 != null) {
                           try {
                              brin.close();
                           } catch (Throwable var170) {
                              var14.addSuppressed(var170);
                           }
                        } else {
                           brin.close();
                        }
                     }

                  }
               } catch (Throwable var177) {
                  var192 = var177;
                  throw var177;
               } finally {
                  if (rin != null) {
                     if (var192 != null) {
                        try {
                           rin.close();
                        } catch (Throwable var169) {
                           var192.addSuppressed(var169);
                        }
                     } else {
                        rin.close();
                     }
                  }

               }
            } catch (Throwable var179) {
               var190 = var179;
               throw var179;
            } finally {
               if (in != null) {
                  if (var190 != null) {
                     try {
                        in.close();
                     } catch (Throwable var168) {
                        var190.addSuppressed(var168);
                     }
                  } else {
                     in.close();
                  }
               }

            }
         } catch (IOException var181) {
         }
      }

      if (!Objects.equals(cacheHash, mcprHash)) {
         this.delete(cache);
         this.createCache(mcprHash);
      }

   }

   private void createCache(String hash) throws IOException {
      if (hash != null) {
         OutputStream out = this.writeCache("recording.tmcpr.crc32");
         Throwable var3 = null;

         try {
            Writer writer = new OutputStreamWriter(out);
            Throwable var5 = null;

            try {
               writer.write(hash);
            } catch (Throwable var28) {
               var5 = var28;
               throw var28;
            } finally {
               if (writer != null) {
                  if (var5 != null) {
                     try {
                        writer.close();
                     } catch (Throwable var27) {
                        var5.addSuppressed(var27);
                     }
                  } else {
                     writer.close();
                  }
               }

            }
         } catch (Throwable var30) {
            var3 = var30;
            throw var30;
         } finally {
            if (out != null) {
               if (var3 != null) {
                  try {
                     out.close();
                  } catch (Throwable var26) {
                     var3.addSuppressed(var26);
                  }
               } else {
                  out.close();
               }
            }

         }

      }
   }

   private void saveInputFile() throws IOException {
      if (this.shouldSaveInputFile) {
         com.replaymod.replaystudio.lib.guava.io.Files.createParentDirs(this.sourceFile);
         OutputStream out = new BufferedOutputStream(new FileOutputStream(this.sourceFile));
         Throwable var2 = null;

         try {
            out.write(this.input.getCanonicalPath().getBytes(Charsets.UTF_8));
         } catch (Throwable var11) {
            var2 = var11;
            throw var11;
         } finally {
            if (out != null) {
               if (var2 != null) {
                  try {
                     out.close();
                  } catch (Throwable var10) {
                     var2.addSuppressed(var10);
                  }
               } else {
                  out.close();
               }
            }

         }

         this.shouldSaveInputFile = false;
      }

   }

   public Optional<InputStream> get(String entry) throws IOException {
      if (this.changedEntries.containsKey(entry)) {
         return Optional.of(new BufferedInputStream(new FileInputStream((File)this.changedEntries.get(entry))));
      } else if (this.zipFile != null && !this.removedEntries.contains(entry)) {
         ZipEntry zipEntry = this.zipFile.getEntry(entry);
         return zipEntry == null ? Optional.absent() : Optional.of(new BufferedInputStream(this.zipFile.getInputStream(zipEntry)));
      } else {
         return Optional.absent();
      }
   }

   public Optional<InputStream> getCache(String entry) throws IOException {
      Path path = this.cache.toPath().resolve(entry);
      if (!Files.exists(path, new LinkOption[0])) {
         return Optional.absent();
      } else {
         BufferedInputStream rawIn = new BufferedInputStream(Files.newInputStream(path));

         try {
            return Optional.of(new GZIPInputStream(rawIn));
         } catch (IOException var5) {
            Closeables.closeQuietly((InputStream)rawIn);
            return Optional.absent();
         }
      }
   }

   public Map<String, InputStream> getAll(Pattern pattern) throws IOException {
      Map<String, InputStream> streams = new HashMap();
      Iterator var3 = this.changedEntries.entrySet().iterator();

      String name;
      while(var3.hasNext()) {
         Entry<String, File> entry = (Entry)var3.next();
         name = (String)entry.getKey();
         if (pattern.matcher(name).matches()) {
            streams.put(name, new BufferedInputStream(new FileInputStream((File)this.changedEntries.get(name))));
         }
      }

      if (this.zipFile != null) {
         Enumeration entries = this.zipFile.entries();

         while(entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry)entries.nextElement();
            name = entry.getName();
            if (pattern.matcher(name).matches() && !streams.containsKey(name) && !this.removedEntries.contains(name)) {
               streams.put(name, new BufferedInputStream(this.zipFile.getInputStream(entry)));
            }
         }
      }

      return streams;
   }

   public OutputStream write(String entry) throws IOException {
      this.saveInputFile();
      File file = (File)this.changedEntries.get(entry);
      if (file == null) {
         file = new File(this.changedFiles, entry);
         com.replaymod.replaystudio.lib.guava.io.Files.createParentDirs(file);
         this.changedEntries.put(entry, file);
      }

      final OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
      Closeables.close((Closeable)this.outputStreams.put(entry, out), true);
      if (this.removedEntries.remove(entry)) {
         Files.deleteIfExists((new File(this.removedFiles, entry)).toPath());
      }

      if ("recording.tmcpr".equals(entry)) {
         OutputStream os = this.write("recording.tmcpr.crc32");
         Throwable var5 = null;

         try {
            Writer writer = new OutputStreamWriter(os);
            Throwable var7 = null;

            try {
               writer.write("invalid");
            } catch (Throwable var30) {
               var7 = var30;
               throw var30;
            } finally {
               if (writer != null) {
                  if (var7 != null) {
                     try {
                        writer.close();
                     } catch (Throwable var29) {
                        var7.addSuppressed(var29);
                     }
                  } else {
                     writer.close();
                  }
               }

            }
         } catch (Throwable var32) {
            var5 = var32;
            throw var32;
         } finally {
            if (os != null) {
               if (var5 != null) {
                  try {
                     os.close();
                  } catch (Throwable var28) {
                     var5.addSuppressed(var28);
                  }
               } else {
                  os.close();
               }
            }

         }

         this.recordingCrc = new CRC32();
         out = new OutputStream() {
            public void write(int i) throws IOException {
               ZipReplayFile.this.recordingCrc.update(i);
               ((OutputStream)out).write(i);
            }

            public void write(byte[] b, int off, int len) throws IOException {
               ZipReplayFile.this.recordingCrc.update(b, off, len);
               ((OutputStream)out).write(b, off, len);
            }

            public void flush() throws IOException {
               ((OutputStream)out).flush();
            }

            public void close() throws IOException {
               ((OutputStream)out).close();
               String crc = "" + ZipReplayFile.this.recordingCrc.getValue();
               ZipReplayFile.this.recordingCrc = null;
               OutputStream outx = ZipReplayFile.this.write("recording.tmcpr.crc32");
               Throwable var3 = null;

               try {
                  Writer writer = new OutputStreamWriter(outx);
                  Throwable var5 = null;

                  try {
                     writer.write(crc);
                  } catch (Throwable var28) {
                     var5 = var28;
                     throw var28;
                  } finally {
                     if (writer != null) {
                        if (var5 != null) {
                           try {
                              writer.close();
                           } catch (Throwable var27) {
                              var5.addSuppressed(var27);
                           }
                        } else {
                           writer.close();
                        }
                     }

                  }
               } catch (Throwable var30) {
                  var3 = var30;
                  throw var30;
               } finally {
                  if (outx != null) {
                     if (var3 != null) {
                        try {
                           outx.close();
                        } catch (Throwable var26) {
                           var3.addSuppressed(var26);
                        }
                     } else {
                        outx.close();
                     }
                  }

               }

               ZipReplayFile.this.delete(ZipReplayFile.this.cache);
               ZipReplayFile.this.createCache(String.valueOf(crc));
            }
         };
      }

      return (OutputStream)out;
   }

   public OutputStream writeCache(String entry) throws IOException {
      Path path = this.cache.toPath().resolve(entry);
      Files.createDirectories(path.getParent());
      return new GZIPOutputStream(new BufferedOutputStream(Files.newOutputStream(path)));
   }

   public void remove(String entry) throws IOException {
      this.saveInputFile();
      Closeables.close((Closeable)this.outputStreams.remove(entry), true);
      File file = (File)this.changedEntries.remove(entry);
      if (file != null && file.exists()) {
         this.delete(file);
      }

      this.removedEntries.add(entry);
      File removedFile = new File(this.removedFiles, entry);
      com.replaymod.replaystudio.lib.guava.io.Files.createParentDirs(removedFile);
      com.replaymod.replaystudio.lib.guava.io.Files.touch(removedFile);
   }

   public void removeCache(String entry) throws IOException {
      Path path = this.cache.toPath().resolve(entry);
      Files.deleteIfExists(path);
   }

   public void save() throws IOException {
      if (this.zipFile == null || !this.changedEntries.isEmpty() || !this.removedEntries.isEmpty()) {
         File outputFile = Files.createTempFile("replaystudio", "replayfile").toFile();
         this.saveTo(outputFile);
         this.close();
         if (this.output.exists()) {
            this.delete(this.output);
         }

         Files.move(outputFile.toPath(), this.output.toPath());
         this.zipFile = new ZipFile(this.output);
      }
   }

   public void saveTo(File target) throws IOException {
      Iterator var2 = this.outputStreams.values().iterator();

      while(var2.hasNext()) {
         OutputStream out = (OutputStream)var2.next();
         Closeables.close(out, false);
      }

      this.outputStreams.clear();
      ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)));
      Throwable var16 = null;

      try {
         Iterator var4;
         if (this.zipFile != null) {
            var4 = Collections.list(this.zipFile.entries()).iterator();

            while(var4.hasNext()) {
               ZipEntry entry = (ZipEntry)var4.next();
               if (!this.changedEntries.containsKey(entry.getName()) && !this.removedEntries.contains(entry.getName())) {
                  entry = new ZipEntry(entry);
                  entry.setCompressedSize(-1L);
                  out.putNextEntry(entry);
                  Utils.copy(this.zipFile.getInputStream(entry), out);
               }
            }
         }

         var4 = this.changedEntries.entrySet().iterator();

         while(var4.hasNext()) {
            Entry<String, File> e = (Entry)var4.next();
            out.putNextEntry(new ZipEntry((String)e.getKey()));
            Utils.copy(new BufferedInputStream(new FileInputStream((File)e.getValue())), out);
         }
      } catch (Throwable var13) {
         var16 = var13;
         throw var13;
      } finally {
         if (out != null) {
            if (var16 != null) {
               try {
                  out.close();
               } catch (Throwable var12) {
                  var16.addSuppressed(var12);
               }
            } else {
               out.close();
            }
         }

      }

   }

   public void close() throws IOException {
      if (this.zipFile != null) {
         this.zipFile.close();
      }

      Iterator var1 = this.outputStreams.values().iterator();

      while(var1.hasNext()) {
         OutputStream out = (OutputStream)var1.next();
         Closeables.close(out, true);
      }

      this.outputStreams.clear();
      this.changedEntries.clear();
      this.removedEntries.clear();
      this.delete(this.tmpFiles);
   }

   private void delete(File file) throws IOException {
      File[] children = file.listFiles();
      if (children != null) {
         File[] var3 = children;
         int var4 = children.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            File child = var3[var5];
            this.delete(child);
         }
      }

      Files.deleteIfExists(file.toPath());
   }
}
