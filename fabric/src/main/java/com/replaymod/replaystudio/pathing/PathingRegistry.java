package com.replaymod.replaystudio.pathing;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.replaymod.replaystudio.pathing.interpolation.Interpolator;
import com.replaymod.replaystudio.pathing.path.Timeline;
import java.io.IOException;

public interface PathingRegistry {
   Timeline createTimeline();

   void serializeInterpolator(JsonWriter var1, Interpolator var2) throws IOException;

   Interpolator deserializeInterpolator(JsonReader var1) throws IOException;
}
