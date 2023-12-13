package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.BoxParser;
import com.replaymod.lib.com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public interface Box {
   Container getParent();

   void setParent(Container var1);

   long getSize();

   long getOffset();

   String getType();

   void getBox(WritableByteChannel var1) throws IOException;

   void parse(DataSource var1, ByteBuffer var2, long var3, BoxParser var5) throws IOException;
}
