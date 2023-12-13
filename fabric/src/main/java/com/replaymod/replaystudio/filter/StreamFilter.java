package com.replaymod.replaystudio.filter;

import com.google.gson.JsonObject;
import com.replaymod.replaystudio.PacketData;
import com.replaymod.replaystudio.Studio;
import com.replaymod.replaystudio.stream.PacketStream;
import java.io.IOException;

public interface StreamFilter {
   String getName();

   void init(Studio var1, JsonObject var2);

   void onStart(PacketStream var1) throws IOException;

   boolean onPacket(PacketStream var1, PacketData var2) throws IOException;

   void onEnd(PacketStream var1, long var2) throws IOException;
}
