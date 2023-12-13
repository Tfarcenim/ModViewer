package com.replaymod.lib.com.coremedia.iso.boxes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

public interface Container {
   List<Box> getBoxes();

   void setBoxes(List<Box> var1);

   <T extends Box> List<T> getBoxes(Class<T> var1);

   <T extends Box> List<T> getBoxes(Class<T> var1, boolean var2);

   ByteBuffer getByteBuffer(long var1, long var3) throws IOException;

   void writeContainer(WritableByteChannel var1) throws IOException;
}
