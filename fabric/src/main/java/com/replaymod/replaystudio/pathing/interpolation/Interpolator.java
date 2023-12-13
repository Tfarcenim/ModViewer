package com.replaymod.replaystudio.pathing.interpolation;

import com.replaymod.replaystudio.pathing.path.PathSegment;
import com.replaymod.replaystudio.pathing.property.Property;
import com.replaymod.replaystudio.pathing.property.PropertyPart;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.NonNull;

public interface Interpolator {
   void registerProperty(Property var1);

   void unregisterProperty(Property var1);

   @NonNull
   Collection<Property> getKeyframeProperties();

   void addSegment(PathSegment var1);

   void removeSegment(PathSegment var1);

   @NonNull
   List<PathSegment> getSegments();

   @NonNull
   Map<PropertyPart, InterpolationParameters> bake(Map<PropertyPart, InterpolationParameters> var1);

   boolean isDirty();

   <T> Optional<T> getValue(Property<T> var1, long var2);
}
