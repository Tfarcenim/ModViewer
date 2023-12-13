package com.replaymod.replaystudio.pathing.change;

import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.lib.guava.base.Predicates;
import com.replaymod.replaystudio.lib.guava.collect.Iterables;
import com.replaymod.replaystudio.pathing.path.Keyframe;
import com.replaymod.replaystudio.pathing.path.Path;
import com.replaymod.replaystudio.pathing.path.Timeline;
import com.replaymod.replaystudio.pathing.property.Property;
import com.replaymod.replaystudio.pathing.property.PropertyGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import lombok.NonNull;

public final class UpdateKeyframeProperties implements Change {
   private final int path;
   private final int index;
   private final Map<String, Optional<Object>> newValues;
   private final Map<String, Optional<Object>> oldValues = new HashMap();
   private boolean applied;

   private static String toId(Property property) {
      assert property != null;

      PropertyGroup group = property.getGroup();
      return (group != null ? group.getId() + ":" : "") + property.getId();
   }

   @NonNull
   public static UpdateKeyframeProperties.Builder create(@NonNull Path path, @NonNull Keyframe keyframe) {
      if (path == null) {
         throw new NullPointerException("path");
      } else if (keyframe == null) {
         throw new NullPointerException("keyframe");
      } else {
         return new UpdateKeyframeProperties.Builder(path.getTimeline().getPaths().indexOf(path), Iterables.indexOf(path.getKeyframes(), Predicates.equalTo(keyframe)));
      }
   }

   UpdateKeyframeProperties(int path, int index, Map<String, Optional<Object>> newValues) {
      this.path = path;
      this.index = index;
      this.newValues = newValues;
   }

   public void apply(Timeline timeline) {
      Preconditions.checkState(!this.applied, "Already applied!");
      Path path = (Path)timeline.getPaths().get(this.path);
      Keyframe keyframe = (Keyframe)Iterables.get(path.getKeyframes(), this.index);
      Iterator var4 = this.newValues.entrySet().iterator();

      while(var4.hasNext()) {
         Entry<String, Optional<Object>> entry = (Entry)var4.next();
         Property property = timeline.getProperty((String)entry.getKey());
         if (property == null) {
            throw new IllegalStateException("Property " + (String)entry.getKey() + " unknown.");
         }

         Optional<Object> newValue = (Optional)entry.getValue();
         this.oldValues.put(entry.getKey(), keyframe.getValue(property));
         if (newValue.isPresent()) {
            keyframe.setValue(property, newValue.get());
         } else {
            keyframe.removeProperty(property);
         }
      }

      this.applied = true;
   }

   public void undo(Timeline timeline) {
      Preconditions.checkState(this.applied, "Not yet applied!");
      Path path = (Path)timeline.getPaths().get(this.path);
      Keyframe keyframe = (Keyframe)Iterables.get(path.getKeyframes(), this.index);
      Iterator var4 = this.oldValues.entrySet().iterator();

      while(var4.hasNext()) {
         Entry<String, Optional<Object>> entry = (Entry)var4.next();
         Property property = timeline.getProperty((String)entry.getKey());
         if (property == null) {
            throw new IllegalStateException("Property " + (String)entry.getKey() + " unknown.");
         }

         Optional<Object> oldValue = (Optional)entry.getValue();
         this.newValues.put(entry.getKey(), keyframe.getValue(property));
         if (oldValue.isPresent()) {
            keyframe.setValue(property, oldValue.get());
         } else {
            keyframe.removeProperty(property);
         }
      }

      this.applied = false;
   }

   public static class Builder {
      private final int path;
      private final int keyframe;
      private final Map<String, Optional<Object>> updates;

      private Builder(int path, int keyframe) {
         this.updates = new HashMap();
         this.path = path;
         this.keyframe = keyframe;
      }

      public <T> UpdateKeyframeProperties.Builder setValue(Property<T> property, T value) {
         this.updates.put(UpdateKeyframeProperties.toId(property), Optional.of(value));
         return this;
      }

      public UpdateKeyframeProperties.Builder removeProperty(Property property) {
         this.updates.put(UpdateKeyframeProperties.toId(property), Optional.empty());
         return this;
      }

      public UpdateKeyframeProperties done() {
         return new UpdateKeyframeProperties(this.path, this.keyframe, this.updates);
      }

      // $FF: synthetic method
      Builder(int x0, int x1, Object x2) {
         this(x0, x1);
      }
   }
}
