package com.replaymod.replaystudio.rar;

import com.replaymod.replaystudio.rar.cache.ReadableCache;
import java.io.IOException;

public interface RandomAccessState {
   void load(PacketSink var1, ReadableCache var2) throws IOException;

   void unload(PacketSink var1, ReadableCache var2) throws IOException;

   void play(PacketSink var1, int var2, int var3) throws IOException;

   void rewind(PacketSink var1, int var2, int var3) throws IOException;
}
