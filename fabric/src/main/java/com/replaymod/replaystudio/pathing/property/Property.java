package com.replaymod.replaystudio.pathing.property;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collection;
import lombok.NonNull;

public interface Property<T> {
   @NonNull
   String getLocalizedName();

   PropertyGroup getGroup();

   @NonNull
   String getId();

   T getNewValue();

   Collection<PropertyPart<T>> getParts();

   void applyToGame(T var1, Object var2);

   void toJson(JsonWriter var1, T var2) throws IOException;

   T fromJson(JsonReader var1) throws IOException;
}
