package com.replaymod.replaystudio.pathing.path;

import com.replaymod.replaystudio.pathing.change.Change;
import com.replaymod.replaystudio.pathing.property.Property;
import java.util.List;
import java.util.Optional;

public interface Timeline {
   List<Path> getPaths();

   Path createPath();

   <T> Optional<T> getValue(Property<T> var1, long var2);

   void applyToGame(long var1, Object var3);

   void registerProperty(Property var1);

   Property getProperty(String var1);

   void applyChange(Change var1);

   void pushChange(Change var1);

   void undoLastChange();

   void redoLastChange();

   Change peekUndoStack();

   Change peekRedoStack();
}
