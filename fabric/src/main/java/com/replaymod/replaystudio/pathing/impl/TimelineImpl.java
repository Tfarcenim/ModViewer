package com.replaymod.replaystudio.pathing.impl;

import com.replaymod.replaystudio.pathing.change.Change;
import com.replaymod.replaystudio.pathing.path.Path;
import com.replaymod.replaystudio.pathing.path.Timeline;
import com.replaymod.replaystudio.pathing.property.Property;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TimelineImpl implements Timeline {
   private final List<Path> paths = new ArrayList();
   private Map<String, Property> properties = new HashMap();
   private Deque<Change> undoStack = new ArrayDeque();
   private Deque<Change> redoStack = new ArrayDeque();

   public List<Path> getPaths() {
      return this.paths;
   }

   public Path createPath() {
      Path path = new PathImpl(this);
      this.paths.add(path);
      return path;
   }

   public <T> Optional<T> getValue(Property<T> property, long time) {
      Iterator var4 = this.paths.iterator();

      while(var4.hasNext()) {
         Path path = (Path)var4.next();
         if (path.isActive()) {
            Optional<T> value = path.getValue(property, time);
            if (value.isPresent()) {
               return value;
            }
         }
      }

      return Optional.empty();
   }

   public void applyToGame(long time, Object replayHandler) {
      Iterator var4 = this.properties.values().iterator();

      while(var4.hasNext()) {
         Property<?> property = (Property)var4.next();
         this.applyToGame(time, replayHandler, property);
      }

   }

   private <T> void applyToGame(long time, Object replayHandler, Property<T> property) {
      Optional<T> value = this.getValue(property, time);
      if (value.isPresent()) {
         property.applyToGame(value.get(), replayHandler);
      }

   }

   public void registerProperty(Property property) {
      String id = (property.getGroup() == null ? "" : property.getGroup().getId() + ":") + property.getId();
      this.properties.put(id, property);
   }

   public Property getProperty(String id) {
      return (Property)this.properties.get(id);
   }

   public void applyChange(Change change) {
      change.apply(this);
      this.pushChange(change);
   }

   public void pushChange(Change change) {
      this.undoStack.push(change);
      this.redoStack.clear();
   }

   public void undoLastChange() {
      Change change = (Change)this.undoStack.pop();
      change.undo(this);
      this.redoStack.push(change);
   }

   public void redoLastChange() {
      Change change = (Change)this.redoStack.pop();
      change.apply(this);
      this.undoStack.push(change);
   }

   public Change peekUndoStack() {
      return (Change)this.undoStack.peek();
   }

   public Change peekRedoStack() {
      return (Change)this.redoStack.peek();
   }
}
