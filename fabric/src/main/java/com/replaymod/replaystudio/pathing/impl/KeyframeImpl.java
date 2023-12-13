package com.replaymod.replaystudio.pathing.impl;

import com.replaymod.replaystudio.pathing.path.Keyframe;
import com.replaymod.replaystudio.pathing.property.Property;
import java.beans.ConstructorProperties;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class KeyframeImpl implements Keyframe {
   private final long time;
   private final Map<Property, Object> properties = new HashMap();

   public long getTime() {
      return this.time;
   }

   public <T> Optional<T> getValue(Property<T> property) {
      return this.properties.containsKey(property) ? Optional.of(this.properties.get(property)) : Optional.empty();
   }

   public <T> void setValue(Property<T> property, T value) {
      this.properties.put(property, value);
   }

   public void removeProperty(Property property) {
      this.properties.remove(property);
   }

   public Set<Property> getProperties() {
      return Collections.unmodifiableSet(this.properties.keySet());
   }

   @ConstructorProperties({"time"})
   public KeyframeImpl(long time) {
      this.time = time;
   }
}
