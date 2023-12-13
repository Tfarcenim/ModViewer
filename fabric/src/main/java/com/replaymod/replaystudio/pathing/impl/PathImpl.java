package com.replaymod.replaystudio.pathing.impl;

import com.replaymod.replaystudio.pathing.interpolation.InterpolationParameters;
import com.replaymod.replaystudio.pathing.interpolation.Interpolator;
import com.replaymod.replaystudio.pathing.path.Keyframe;
import com.replaymod.replaystudio.pathing.path.Path;
import com.replaymod.replaystudio.pathing.path.PathSegment;
import com.replaymod.replaystudio.pathing.path.Timeline;
import com.replaymod.replaystudio.pathing.property.Property;
import com.replaymod.replaystudio.pathing.property.PropertyPart;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PathImpl implements Path {
   private final Timeline timeline;
   private Map<Long, Keyframe> keyframes = new TreeMap();
   private List<PathSegment> segments = new LinkedList();
   private boolean active = true;

   public PathImpl(Timeline timeline) {
      this.timeline = timeline;
   }

   public Timeline getTimeline() {
      return this.timeline;
   }

   public Collection<Keyframe> getKeyframes() {
      return Collections.unmodifiableCollection(this.keyframes.values());
   }

   public Collection<PathSegment> getSegments() {
      return Collections.unmodifiableCollection(this.segments);
   }

   public void update() {
      this.update(false);
   }

   public void updateAll() {
      this.update(false);
   }

   private void update(boolean force) {
      Interpolator interpolator = null;
      Map<PropertyPart, InterpolationParameters> parameters = new HashMap();
      Iterator var4 = this.segments.iterator();

      while(true) {
         do {
            PathSegment segment;
            do {
               if (!var4.hasNext()) {
                  return;
               }

               segment = (PathSegment)var4.next();
            } while(segment.getInterpolator() == interpolator);

            interpolator = segment.getInterpolator();
         } while(!force && !interpolator.isDirty());

         parameters = interpolator.bake((Map)parameters);
      }
   }

   public <T> Optional<T> getValue(Property<T> property, long time) {
      PathSegment segment = this.getSegment(time);
      if (segment != null) {
         Interpolator interpolator = segment.getInterpolator();
         if (interpolator != null && interpolator.getKeyframeProperties().contains(property)) {
            return interpolator.getValue(property, time);
         }
      }

      return Optional.empty();
   }

   public Keyframe insert(long time) {
      Keyframe keyframe = new KeyframeImpl(time);
      this.insert(keyframe);
      return keyframe;
   }

   public Keyframe getKeyframe(long time) {
      return (Keyframe)this.keyframes.get(time);
   }

   public void insert(Keyframe keyframe) {
      if (this.keyframes.containsKey(keyframe.getTime())) {
         throw new IllegalStateException("A keyframe at " + keyframe.getTime() + " already exists.");
      } else {
         this.keyframes.put(keyframe.getTime(), keyframe);
         if (this.segments.isEmpty()) {
            if (this.keyframes.size() >= 2) {
               Iterator<Keyframe> iter = this.keyframes.values().iterator();
               this.segments.add(new PathSegmentImpl(this, (Keyframe)iter.next(), (Keyframe)iter.next()));
            }

         } else {
            ListIterator<PathSegment> iter = this.segments.listIterator();
            PathSegment next = (PathSegment)iter.next();
            if (keyframe.getTime() < next.getStartKeyframe().getTime()) {
               iter.previous();
               iter.add(new PathSegmentImpl(this, keyframe, next.getStartKeyframe(), next.getInterpolator()));
            } else {
               while(next.getStartKeyframe().getTime() > keyframe.getTime() || next.getEndKeyframe().getTime() < keyframe.getTime()) {
                  if (!iter.hasNext()) {
                     iter.add(new PathSegmentImpl(this, next.getEndKeyframe(), keyframe, next.getInterpolator()));
                     return;
                  }

                  next = (PathSegment)iter.next();
               }

               iter.remove();
               iter.add(new PathSegmentImpl(this, next.getStartKeyframe(), keyframe, next.getInterpolator()));
               iter.add(new PathSegmentImpl(this, keyframe, next.getEndKeyframe(), next.getInterpolator()));
               next.setInterpolator((Interpolator)null);
            }
         }
      }
   }

   public void remove(Keyframe keyframe, boolean useFirstInterpolator) {
      if (this.keyframes.get(keyframe.getTime()) != keyframe) {
         throw new IllegalArgumentException("The keyframe " + keyframe + " is not part of this path.");
      } else {
         this.keyframes.remove(keyframe.getTime());
         PathSegment next;
         if (this.segments.size() >= 2) {
            ListIterator iter = this.segments.listIterator();

            do {
               if (!iter.hasNext()) {
                  throw new AssertionError("No segment for keyframe found!");
               }

               next = (PathSegment)iter.next();
               if (next.getEndKeyframe() == keyframe) {
                  iter.remove();
                  if (iter.hasNext()) {
                     PathSegment next2 = (PathSegment)iter.next();
                     iter.remove();
                     iter.add(new PathSegmentImpl(this, next.getStartKeyframe(), next2.getEndKeyframe(), (useFirstInterpolator ? next : next2).getInterpolator()));
                     next2.setInterpolator((Interpolator)null);
                  }

                  next.setInterpolator((Interpolator)null);
                  return;
               }
            } while(next.getStartKeyframe() != keyframe);

            next.setInterpolator((Interpolator)null);
            iter.remove();
         } else {
            Iterator var3 = this.segments.iterator();

            while(var3.hasNext()) {
               next = (PathSegment)var3.next();
               next.setInterpolator((Interpolator)null);
            }

            this.segments.clear();
         }
      }
   }

   public void setActive(boolean active) {
      this.active = active;
   }

   public boolean isActive() {
      return this.active;
   }

   private PathSegment getSegment(long time) {
      Iterator var3 = this.segments.iterator();

      PathSegment segment;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         segment = (PathSegment)var3.next();
      } while(segment.getStartKeyframe().getTime() > time || segment.getEndKeyframe().getTime() < time);

      return segment;
   }
}
