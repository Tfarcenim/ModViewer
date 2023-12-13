package com.replaymod.replaystudio.pathing.serialize;

import com.google.gson.GsonBuilder;
import com.replaymod.lib.org.apache.commons.lang3.tuple.Triple;
import com.replaymod.replaystudio.lib.guava.base.Optional;
import com.replaymod.replaystudio.pathing.PathingRegistry;
import com.replaymod.replaystudio.pathing.interpolation.CubicSplineInterpolator;
import com.replaymod.replaystudio.pathing.interpolation.Interpolator;
import com.replaymod.replaystudio.pathing.interpolation.LinearInterpolator;
import com.replaymod.replaystudio.pathing.path.Path;
import com.replaymod.replaystudio.pathing.path.Timeline;
import com.replaymod.replaystudio.pathing.property.Property;
import com.replaymod.replaystudio.replay.ReplayFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LegacyTimelineConverter {
   public static Map<String, Timeline> convert(PathingRegistry registry, ReplayFile replayFile) throws IOException {
      LegacyTimelineConverter.KeyframeSet[] keyframeSets = readAndParse(replayFile);
      if (keyframeSets == null) {
         return Collections.emptyMap();
      } else {
         Map<String, Timeline> timelines = new LinkedHashMap();
         LegacyTimelineConverter.KeyframeSet[] var4 = keyframeSets;
         int var5 = keyframeSets.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            LegacyTimelineConverter.KeyframeSet keyframeSet = var4[var6];
            timelines.put(keyframeSet.name, convert(registry, keyframeSet));
         }

         return timelines;
      }
   }

   private static Optional<InputStream> read(ReplayFile replayFile) throws IOException {
      Optional<InputStream> in = replayFile.get("paths.json");
      if (!in.isPresent()) {
         in = replayFile.get("paths");
      }

      return in;
   }

   private static LegacyTimelineConverter.KeyframeSet[] parse(InputStream in) {
      return (LegacyTimelineConverter.KeyframeSet[])(new GsonBuilder()).registerTypeAdapter(LegacyTimelineConverter.KeyframeSet[].class, new LegacyKeyframeSetAdapter()).create().fromJson(new InputStreamReader(in), LegacyTimelineConverter.KeyframeSet[].class);
   }

   private static LegacyTimelineConverter.KeyframeSet[] readAndParse(ReplayFile replayFile) throws IOException {
      Optional<InputStream> optIn = read(replayFile);
      if (!optIn.isPresent()) {
         return null;
      } else {
         InputStream in = (InputStream)optIn.get();
         Throwable var4 = null;

         LegacyTimelineConverter.KeyframeSet[] keyframeSets;
         try {
            keyframeSets = parse(in);
         } catch (Throwable var13) {
            var4 = var13;
            throw var13;
         } finally {
            if (in != null) {
               if (var4 != null) {
                  try {
                     in.close();
                  } catch (Throwable var12) {
                     var4.addSuppressed(var12);
                  }
               } else {
                  in.close();
               }
            }

         }

         return keyframeSets;
      }
   }

   private static Timeline convert(PathingRegistry registry, LegacyTimelineConverter.KeyframeSet keyframeSet) {
      Timeline timeline = registry.createTimeline();
      Property timestamp = timeline.getProperty("timestamp");
      Property cameraPosition = timeline.getProperty("camera:position");
      Property cameraRotation = timeline.getProperty("camera:rotation");
      Path timePath = timeline.createPath();
      Path positionPath = timeline.createPath();
      LegacyTimelineConverter.Keyframe[] var8 = keyframeSet.positionKeyframes;
      int var9 = var8.length;

      int var10;
      LegacyTimelineConverter.Keyframe timeKeyframe;
      com.replaymod.replaystudio.pathing.path.Keyframe keyframe;
      for(var10 = 0; var10 < var9; ++var10) {
         timeKeyframe = var8[var10];
         LegacyTimelineConverter.AdvancedPosition value = (LegacyTimelineConverter.AdvancedPosition)timeKeyframe.value;
         keyframe = getKeyframe(positionPath, (long)timeKeyframe.realTimestamp);
         keyframe.setValue(cameraPosition, Triple.of(value.x, value.y, value.z));
         keyframe.setValue(cameraRotation, Triple.of(value.yaw, value.pitch, value.roll));
         if (value instanceof LegacyTimelineConverter.SpectatorData) {
         }
      }

      var8 = keyframeSet.timeKeyframes;
      var9 = var8.length;

      for(var10 = 0; var10 < var9; ++var10) {
         timeKeyframe = var8[var10];
         LegacyTimelineConverter.TimestampValue value = (LegacyTimelineConverter.TimestampValue)timeKeyframe.value;
         keyframe = getKeyframe(timePath, (long)timeKeyframe.realTimestamp);
         keyframe.setValue(timestamp, (int)value.value);
      }

      Interpolator timeInterpolator = new LinearInterpolator();
      timeInterpolator.registerProperty(timestamp);
      timePath.getSegments().forEach((s) -> {
         s.setInterpolator(timeInterpolator);
      });
      Interpolator positionInterpolator = new CubicSplineInterpolator();
      positionInterpolator.registerProperty(cameraPosition);
      positionInterpolator.registerProperty(cameraRotation);
      positionPath.getSegments().forEach((s) -> {
         s.setInterpolator(positionInterpolator);
      });
      return timeline;
   }

   private static com.replaymod.replaystudio.pathing.path.Keyframe getKeyframe(Path path, long time) {
      com.replaymod.replaystudio.pathing.path.Keyframe keyframe = path.getKeyframe(time);
      if (keyframe == null) {
         keyframe = path.insert(time);
      }

      return keyframe;
   }

   static class NumberValue {
      double value;
   }

   static class Transformations {
      LegacyTimelineConverter.Position defaultAnchor;
      LegacyTimelineConverter.Position defaultPosition;
      LegacyTimelineConverter.Position defaultOrientation;
      LegacyTimelineConverter.Position defaultScale;
      LegacyTimelineConverter.NumberValue defaultOpacity;
      List<LegacyTimelineConverter.Position> anchorKeyframes;
      List<LegacyTimelineConverter.Position> positionKeyframes;
      List<LegacyTimelineConverter.Position> orientationKeyframes;
      List<LegacyTimelineConverter.Position> scaleKeyframes;
      List<LegacyTimelineConverter.NumberValue> opacityKeyframes;
   }

   static class CustomImageObject {
      String name;
      UUID linkedAsset;
      float width;
      float height;
      float textureWidth;
      float textureHeight;
      LegacyTimelineConverter.Transformations transformations = new LegacyTimelineConverter.Transformations();
   }

   static class TimestampValue {
      double value;
   }

   static class SpectatorDataThirdPersonInfo {
      double shoulderCamDistance;
      double shoulderCamPitchOffset;
      double shoulderCamYawOffset;
      double shoulderCamSmoothness;
   }

   static class SpectatorData extends LegacyTimelineConverter.AdvancedPosition {
      Integer spectatedEntityID;
      LegacyTimelineConverter.SpectatorData.SpectatingMethod spectatingMethod;
      LegacyTimelineConverter.SpectatorDataThirdPersonInfo thirdPersonInfo;

      static enum SpectatingMethod {
         FIRST_PERSON,
         SHOULDER_CAM;
      }
   }

   static class AdvancedPosition extends LegacyTimelineConverter.Position {
      float pitch;
      float yaw;
      float roll;
   }

   static class Position {
      double x;
      double y;
      double z;
   }

   static class Keyframe<T> {
      int realTimestamp;
      T value;
   }

   static class KeyframeSet {
      String name;
      LegacyTimelineConverter.Keyframe<LegacyTimelineConverter.AdvancedPosition>[] positionKeyframes;
      LegacyTimelineConverter.Keyframe<LegacyTimelineConverter.TimestampValue>[] timeKeyframes;
      LegacyTimelineConverter.CustomImageObject[] customObjects;
   }
}
