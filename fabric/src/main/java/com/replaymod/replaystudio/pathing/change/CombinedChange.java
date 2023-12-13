package com.replaymod.replaystudio.pathing.change;

import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.pathing.path.Timeline;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import lombok.NonNull;

public class CombinedChange implements Change {
   private final List<Change> changeList;
   private boolean applied;

   @NonNull
   public static CombinedChange create(Change... changes) {
      return new CombinedChange(Arrays.asList(changes), false);
   }

   @NonNull
   public static CombinedChange createFromApplied(Change... changes) {
      return new CombinedChange(Arrays.asList(changes), true);
   }

   CombinedChange(List<Change> changeList, boolean applied) {
      this.changeList = changeList;
      this.applied = applied;
   }

   public void apply(Timeline timeline) {
      Preconditions.checkState(!this.applied, "Already applied!");
      Iterator var2 = this.changeList.iterator();

      while(var2.hasNext()) {
         Change change = (Change)var2.next();
         change.apply(timeline);
      }

      this.applied = true;
   }

   public void undo(Timeline timeline) {
      Preconditions.checkState(this.applied, "Not yet applied!");
      ListIterator iterator = this.changeList.listIterator(this.changeList.size());

      while(iterator.hasPrevious()) {
         ((Change)iterator.previous()).undo(timeline);
      }

      this.applied = false;
   }
}
