package com.replaymod.replaystudio.pathing.path;

import com.replaymod.replaystudio.pathing.property.Property;
import java.util.Collection;
import java.util.Optional;
import lombok.NonNull;

public interface Path {
   Timeline getTimeline();

   @NonNull
   Collection<Keyframe> getKeyframes();

   @NonNull
   Collection<PathSegment> getSegments();

   void update();

   void updateAll();

   <T> Optional<T> getValue(Property<T> var1, long var2);

   Keyframe insert(long var1);

   Keyframe getKeyframe(long var1);

   void insert(Keyframe var1);

   void remove(Keyframe var1, boolean var2);

   void setActive(boolean var1);

   boolean isActive();
}
