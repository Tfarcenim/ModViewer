package com.replaymod.replaystudio.pathing.path;

import com.replaymod.replaystudio.pathing.property.Property;
import java.util.Optional;
import java.util.Set;
import lombok.NonNull;

public interface Keyframe {
   long getTime();

   @NonNull
   <T> Optional<T> getValue(Property<T> var1);

   <T> void setValue(Property<T> var1, T var2);

   void removeProperty(Property var1);

   Set<Property> getProperties();
}
