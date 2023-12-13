package com.replaymod.replaystudio.pathing.change;

import com.replaymod.replaystudio.pathing.path.Timeline;

public interface Change {
   void apply(Timeline var1);

   void undo(Timeline var1);
}
