package com.replaymod.replaystudio.pathing.impl;

import com.replaymod.replaystudio.pathing.interpolation.Interpolator;
import com.replaymod.replaystudio.pathing.path.Keyframe;
import com.replaymod.replaystudio.pathing.path.Path;
import com.replaymod.replaystudio.pathing.path.PathSegment;
import java.beans.ConstructorProperties;

public class PathSegmentImpl implements PathSegment {
   private final Path path;
   private final Keyframe startKeyframe;
   private final Keyframe endKeyframe;
   private Interpolator interpolator;

   public PathSegmentImpl(Path path, Keyframe startKeyframe, Keyframe endKeyframe, Interpolator interpolator) {
      this.path = path;
      this.startKeyframe = startKeyframe;
      this.endKeyframe = endKeyframe;
      this.setInterpolator(interpolator);
   }

   public void setInterpolator(Interpolator interpolator) {
      if (this.interpolator != null) {
         this.interpolator.removeSegment(this);
      }

      this.interpolator = interpolator;
      if (this.interpolator != null) {
         this.interpolator.addSegment(this);
      }

   }

   public Path getPath() {
      return this.path;
   }

   public Keyframe getStartKeyframe() {
      return this.startKeyframe;
   }

   public Keyframe getEndKeyframe() {
      return this.endKeyframe;
   }

   public Interpolator getInterpolator() {
      return this.interpolator;
   }

   @ConstructorProperties({"path", "startKeyframe", "endKeyframe"})
   public PathSegmentImpl(Path path, Keyframe startKeyframe, Keyframe endKeyframe) {
      this.path = path;
      this.startKeyframe = startKeyframe;
      this.endKeyframe = endKeyframe;
   }
}
