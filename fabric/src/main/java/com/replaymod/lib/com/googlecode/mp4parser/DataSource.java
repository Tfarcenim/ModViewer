package com.replaymod.lib.com.googlecode.mp4parser;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public interface DataSource extends Closeable {
   int read(ByteBuffer var1) throws IOException;

   long size() throws IOException;

   long position() throws IOException;

   void position(long var1) throws IOException;

   long transferTo(long var1, long var3, WritableByteChannel var5) throws IOException;

   ByteBuffer map(long var1, long var3) throws IOException;

   void close() throws IOException;
}
