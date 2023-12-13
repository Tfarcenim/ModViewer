package com.replaymod.replaystudio.pathing.change;

import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.lib.guava.collect.Iterables;
import com.replaymod.replaystudio.pathing.interpolation.Interpolator;
import com.replaymod.replaystudio.pathing.path.Path;
import com.replaymod.replaystudio.pathing.path.PathSegment;
import com.replaymod.replaystudio.pathing.path.Timeline;
import java.util.Collection;
import lombok.NonNull;

public final class SetInterpolator implements Change {
   private final int path;
   private final int index;
   private final Interpolator interpolator;
   private Interpolator oldInterpolator;
   private boolean applied;

   @NonNull
   public static SetInterpolator create(PathSegment segment, Interpolator interpolator) {
      Path path = segment.getPath();
      int var10002 = path.getTimeline().getPaths().indexOf(path);
      Collection var10003 = path.getSegments();
      segment.getClass();
      return new SetInterpolator(var10002, Iterables.indexOf(var10003, segment::equals), interpolator);
   }

   SetInterpolator(int path, int index, Interpolator interpolator) {
      this.path = path;
      this.index = index;
      this.interpolator = interpolator;
   }

   public void apply(Timeline timeline) {
      Preconditions.checkState(!this.applied, "Already applied!");
      Path path = (Path)timeline.getPaths().get(this.path);
      PathSegment segment = (PathSegment)Iterables.get(path.getSegments(), this.index);
      this.oldInterpolator = segment.getInterpolator();
      segment.setInterpolator(this.interpolator);
      this.applied = true;
   }

   public void undo(Timeline timeline) {
      Preconditions.checkState(this.applied, "Not yet applied!");
      Path path = (Path)timeline.getPaths().get(this.path);
      PathSegment segment = (PathSegment)Iterables.get(path.getSegments(), this.index);
      segment.setInterpolator(this.oldInterpolator);
      this.applied = false;
   }
}
