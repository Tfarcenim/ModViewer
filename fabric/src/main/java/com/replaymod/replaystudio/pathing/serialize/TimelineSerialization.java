package com.replaymod.replaystudio.pathing.serialize;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.replaymod.replaystudio.lib.guava.base.Charsets;
import com.replaymod.replaystudio.lib.guava.base.Optional;
import com.replaymod.replaystudio.lib.guava.io.CharStreams;
import com.replaymod.replaystudio.pathing.PathingRegistry;
import com.replaymod.replaystudio.pathing.interpolation.Interpolator;
import com.replaymod.replaystudio.pathing.path.Keyframe;
import com.replaymod.replaystudio.pathing.path.Path;
import com.replaymod.replaystudio.pathing.path.PathSegment;
import com.replaymod.replaystudio.pathing.path.Timeline;
import com.replaymod.replaystudio.pathing.property.Property;
import com.replaymod.replaystudio.replay.ReplayFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TimelineSerialization {
   private static final String FILE_ENTRY = "timelines.json";
   private final PathingRegistry registry;
   private final ReplayFile replayFile;

   public TimelineSerialization(PathingRegistry registry, ReplayFile replayFile) {
      this.registry = registry;
      this.replayFile = replayFile;
   }

   public void save(Map<String, Timeline> timelines) throws IOException {
      String serialized = this.serialize(timelines);
      OutputStream out = this.replayFile.write("timelines.json");
      Throwable var4 = null;

      try {
         out.write(serialized.getBytes(Charsets.UTF_8));
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

   public Map<String, Timeline> load() throws IOException {
      Map<String, Timeline> timelines = new LinkedHashMap(LegacyTimelineConverter.convert(this.registry, this.replayFile));
      Optional<InputStream> optionalIn = this.replayFile.get("timelines.json");
      if (optionalIn.isPresent()) {
         InputStream in = (InputStream)optionalIn.get();
         Throwable var5 = null;

         String serialized;
         try {
            serialized = CharStreams.toString((Readable)(new InputStreamReader(in, Charsets.UTF_8)));
         } catch (Throwable var14) {
            var5 = var14;
            throw var14;
         } finally {
            if (in != null) {
               if (var5 != null) {
                  try {
                     in.close();
                  } catch (Throwable var13) {
                     var5.addSuppressed(var13);
                  }
               } else {
                  in.close();
               }
            }

         }

         Map<String, Timeline> deserialized = this.deserialize(serialized);
         timelines.putAll(deserialized);
      }

      return timelines;
   }

   public String serialize(Map<String, Timeline> timelines) throws IOException {
      StringWriter stringWriter = new StringWriter();
      JsonWriter writer = new JsonWriter(stringWriter);
      writer.beginObject();
      Iterator var4 = timelines.entrySet().iterator();

      while(var4.hasNext()) {
         Entry<String, Timeline> entry = (Entry)var4.next();
         Timeline timeline = (Timeline)entry.getValue();
         writer.name((String)entry.getKey()).beginArray();
         Iterator var7 = timeline.getPaths().iterator();

         while(var7.hasNext()) {
            Path path = (Path)var7.next();
            writer.beginObject();
            writer.name("keyframes").beginArray();
            Iterator var9 = path.getKeyframes().iterator();

            while(var9.hasNext()) {
               Keyframe keyframe = (Keyframe)var9.next();
               writer.beginObject();
               writer.name("time").value(keyframe.getTime());
               writer.name("properties").beginObject();
               Iterator var11 = keyframe.getProperties().iterator();

               while(var11.hasNext()) {
                  Property<?> property = (Property)var11.next();
                  writer.name((property.getGroup() == null ? "" : property.getGroup().getId() + ":") + property.getId());
                  writeProperty(writer, keyframe, property);
               }

               writer.endObject();
               writer.endObject();
            }

            writer.endArray();
            Map<Interpolator, Integer> interpolators = new LinkedHashMap();
            writer.name("segments").beginArray();
            Iterator var15 = path.getSegments().iterator();

            while(var15.hasNext()) {
               PathSegment segment = (PathSegment)var15.next();
               Interpolator interpolator = segment.getInterpolator();
               if (interpolator == null) {
                  writer.nullValue();
               } else {
                  Integer index = (Integer)interpolators.get(interpolator);
                  if (index == null) {
                     interpolators.put(interpolator, index = interpolators.size());
                  }

                  writer.value(index);
               }
            }

            writer.endArray();
            writer.name("interpolators").beginArray();
            var15 = interpolators.keySet().iterator();

            while(var15.hasNext()) {
               Interpolator interpolator = (Interpolator)var15.next();
               writer.beginObject();
               writer.name("type");
               this.registry.serializeInterpolator(writer, interpolator);
               writer.name("properties").beginArray();
               Iterator var19 = interpolator.getKeyframeProperties().iterator();

               while(var19.hasNext()) {
                  Property<?> property = (Property)var19.next();
                  writer.value((property.getGroup() == null ? "" : property.getGroup().getId() + ":") + property.getId());
               }

               writer.endArray();
               writer.endObject();
            }

            writer.endArray();
            writer.endObject();
         }

         writer.endArray();
      }

      writer.endObject();
      writer.flush();
      return stringWriter.toString();
   }

   private static <T> void writeProperty(JsonWriter writer, Keyframe keyframe, Property<T> property) throws IOException {
      property.toJson(writer, keyframe.getValue(property).get());
   }

   public Map<String, Timeline> deserialize(String serialized) throws IOException {
      JsonReader reader = new JsonReader(new StringReader(serialized));
      Map<String, Timeline> timelines = new LinkedHashMap();
      reader.beginObject();

      while(reader.hasNext()) {
         Timeline timeline = this.registry.createTimeline();
         timelines.put(reader.nextName(), timeline);
         reader.beginArray();

         while(reader.hasNext()) {
            Path path = timeline.createPath();
            reader.beginObject();
            List<Integer> segments = new ArrayList();
            ArrayList interpolators = new ArrayList();

            while(true) {
               while(reader.hasNext()) {
                  String var8 = reader.nextName();
                  byte var9 = -1;
                  switch(var8.hashCode()) {
                  case -1446666299:
                     if (var8.equals("keyframes")) {
                        var9 = 0;
                     }
                     break;
                  case 559337612:
                     if (var8.equals("interpolators")) {
                        var9 = 2;
                     }
                     break;
                  case 1055868832:
                     if (var8.equals("segments")) {
                        var9 = 1;
                     }
                  }

                  String propertyName;
                  switch(var9) {
                  case 0:
                     reader.beginArray();

                     while(reader.hasNext()) {
                        long time = 0L;
                        Map<Property, Object> properties = new HashMap();
                        reader.beginObject();

                        while(true) {
                           while(reader.hasNext()) {
                              propertyName = reader.nextName();
                              byte var25 = -1;
                              switch(propertyName.hashCode()) {
                              case -926053069:
                                 if (propertyName.equals("properties")) {
                                    var25 = 1;
                                 }
                                 break;
                              case 3560141:
                                 if (propertyName.equals("time")) {
                                    var25 = 0;
                                 }
                              }

                              switch(var25) {
                              case 0:
                                 time = reader.nextLong();
                                 break;
                              case 1:
                                 reader.beginObject();

                                 while(reader.hasNext()) {
                                    String id = reader.nextName();
                                    Property property = timeline.getProperty(id);
                                    if (property == null) {
                                       throw new IOException("Unknown property: " + id);
                                    }

                                    Object value = property.fromJson(reader);
                                    properties.put(property, value);
                                 }

                                 reader.endObject();
                              }
                           }

                           reader.endObject();
                           Keyframe keyframe = path.insert(time);
                           Iterator var29 = properties.entrySet().iterator();

                           while(var29.hasNext()) {
                              Entry<Property, Object> entry = (Entry)var29.next();
                              keyframe.setValue((Property)entry.getKey(), entry.getValue());
                           }
                           break;
                        }
                     }

                     reader.endArray();
                     break;
                  case 1:
                     reader.beginArray();

                     while(reader.hasNext()) {
                        if (reader.peek() == JsonToken.NULL) {
                           reader.nextNull();
                           segments.add((Object)null);
                        } else {
                           segments.add(reader.nextInt());
                        }
                     }

                     reader.endArray();
                     break;
                  case 2:
                     reader.beginArray();

                     while(reader.hasNext()) {
                        reader.beginObject();
                        Interpolator interpolator = null;
                        HashSet properties = new HashSet();

                        while(true) {
                           while(reader.hasNext()) {
                              String var12 = reader.nextName();
                              byte var13 = -1;
                              switch(var12.hashCode()) {
                              case -926053069:
                                 if (var12.equals("properties")) {
                                    var13 = 1;
                                 }
                                 break;
                              case 3575610:
                                 if (var12.equals("type")) {
                                    var13 = 0;
                                 }
                              }

                              switch(var13) {
                              case 0:
                                 interpolator = this.registry.deserializeInterpolator(reader);
                                 break;
                              case 1:
                                 reader.beginArray();

                                 while(reader.hasNext()) {
                                    properties.add(reader.nextString());
                                 }

                                 reader.endArray();
                              }
                           }

                           if (interpolator == null) {
                              throw new IOException("Missing interpolator type");
                           }

                           Iterator var23 = properties.iterator();

                           while(var23.hasNext()) {
                              propertyName = (String)var23.next();
                              Property property = timeline.getProperty(propertyName);
                              if (property == null) {
                                 throw new IOException("Timeline does not know property '" + propertyName + "'");
                              }

                              interpolator.registerProperty(property);
                           }

                           interpolators.add(interpolator);
                           reader.endObject();
                           break;
                        }
                     }

                     reader.endArray();
                  }
               }

               Iterator<Integer> iter = segments.iterator();
               Iterator var19 = path.getSegments().iterator();

               while(var19.hasNext()) {
                  PathSegment segment = (PathSegment)var19.next();
                  Integer next = (Integer)iter.next();
                  if (next != null) {
                     segment.setInterpolator((Interpolator)interpolators.get(next));
                  }
               }

               reader.endObject();
               break;
            }
         }

         reader.endArray();
      }

      reader.endObject();
      return timelines;
   }
}
