package com.replaymod.replaystudio.pathing.property;

public interface PropertyPart<T> {
   Property<T> getProperty();

   boolean isInterpolatable();

   double getUpperBound();

   double toDouble(T var1);

   T fromDouble(T var1, double var2);
}
