package com.replaymod.replaystudio.pathing.serialize;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LegacyKeyframeSetAdapter extends TypeAdapter<LegacyTimelineConverter.KeyframeSet[]> {
   public LegacyTimelineConverter.KeyframeSet[] read(JsonReader in) throws IOException {
      List<LegacyTimelineConverter.KeyframeSet> sets = new ArrayList();
      in.beginArray();

      while(in.hasNext()) {
         LegacyTimelineConverter.KeyframeSet set = new LegacyTimelineConverter.KeyframeSet();
         List<LegacyTimelineConverter.Keyframe> positionKeyframes = new ArrayList();
         List<LegacyTimelineConverter.Keyframe> timeKeyframes = new ArrayList();
         in.beginObject();

         while(true) {
            while(in.hasNext()) {
               String jsonTag = in.nextName();
               if ("name".equals(jsonTag)) {
                  set.name = in.nextString();
               } else {
                  LegacyTimelineConverter.Keyframe newKeyframe;
                  if ("positionKeyframes".equals(jsonTag)) {
                     in.beginArray();

                     while(in.hasNext()) {
                        newKeyframe = new LegacyTimelineConverter.Keyframe();
                        Integer spectatedEntityID = null;
                        in.beginObject();

                        while(true) {
                           LegacyTimelineConverter.SpectatorData spectatorData;
                           while(in.hasNext()) {
                              String jsonKeyframeTag = in.nextName();
                              if (!"value".equals(jsonKeyframeTag) && !"position".equals(jsonKeyframeTag)) {
                                 if ("realTimestamp".equals(jsonKeyframeTag)) {
                                    newKeyframe.realTimestamp = in.nextInt();
                                 } else if ("spectatedEntityID".equals(jsonKeyframeTag)) {
                                    spectatedEntityID = in.nextInt();
                                 }
                              } else {
                                 spectatorData = (LegacyTimelineConverter.SpectatorData)(new Gson()).fromJson(in, LegacyTimelineConverter.SpectatorData.class);
                                 if (spectatorData.spectatedEntityID != null) {
                                    newKeyframe.value = spectatorData;
                                 } else {
                                    newKeyframe.value = new LegacyTimelineConverter.AdvancedPosition();
                                    ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).x = spectatorData.x;
                                    ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).y = spectatorData.y;
                                    ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).z = spectatorData.z;
                                    ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).yaw = spectatorData.yaw;
                                    ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).pitch = spectatorData.pitch;
                                    ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).roll = spectatorData.roll;
                                 }
                              }
                           }

                           if (spectatedEntityID != null) {
                              LegacyTimelineConverter.AdvancedPosition pos = (LegacyTimelineConverter.AdvancedPosition)newKeyframe.value;
                              spectatorData = new LegacyTimelineConverter.SpectatorData();
                              spectatorData.spectatedEntityID = spectatedEntityID;
                              newKeyframe.value = spectatorData;
                              ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).x = pos.x;
                              ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).y = pos.y;
                              ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).z = pos.z;
                              ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).yaw = pos.yaw;
                              ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).pitch = pos.pitch;
                              ((LegacyTimelineConverter.AdvancedPosition)newKeyframe.value).roll = pos.roll;
                           }

                           in.endObject();
                           positionKeyframes.add(newKeyframe);
                           break;
                        }
                     }

                     in.endArray();
                  } else if (!"timeKeyframes".equals(jsonTag)) {
                     if ("customObjects".equals(jsonTag)) {
                        set.customObjects = (LegacyTimelineConverter.CustomImageObject[])(new Gson()).fromJson(in, LegacyTimelineConverter.CustomImageObject[].class);
                     }
                  } else {
                     in.beginArray();

                     while(in.hasNext()) {
                        newKeyframe = new LegacyTimelineConverter.Keyframe();
                        in.beginObject();

                        while(in.hasNext()) {
                           String jsonKeyframeTag = in.nextName();
                           if ("timestamp".equals(jsonKeyframeTag)) {
                              LegacyTimelineConverter.TimestampValue timestampValue = new LegacyTimelineConverter.TimestampValue();
                              timestampValue.value = (double)in.nextInt();
                              newKeyframe.value = timestampValue;
                           } else if ("value".equals(jsonKeyframeTag)) {
                              newKeyframe.value = (new Gson()).fromJson(in, LegacyTimelineConverter.TimestampValue.class);
                           } else if ("realTimestamp".equals(jsonKeyframeTag)) {
                              newKeyframe.realTimestamp = in.nextInt();
                           }
                        }

                        in.endObject();
                        timeKeyframes.add(newKeyframe);
                     }

                     in.endArray();
                  }
               }
            }

            in.endObject();
            set.positionKeyframes = (LegacyTimelineConverter.Keyframe[])positionKeyframes.toArray(new LegacyTimelineConverter.Keyframe[positionKeyframes.size()]);
            set.timeKeyframes = (LegacyTimelineConverter.Keyframe[])timeKeyframes.toArray(new LegacyTimelineConverter.Keyframe[timeKeyframes.size()]);
            sets.add(set);
            break;
         }
      }

      in.endArray();
      return (LegacyTimelineConverter.KeyframeSet[])sets.toArray(new LegacyTimelineConverter.KeyframeSet[sets.size()]);
   }

   public void write(JsonWriter out, LegacyTimelineConverter.KeyframeSet[] value) throws IOException {
   }
}
