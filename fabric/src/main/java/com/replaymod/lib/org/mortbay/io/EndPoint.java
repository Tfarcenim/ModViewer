package com.replaymod.lib.org.mortbay.io;

import java.io.IOException;

public interface EndPoint {
   void shutdownOutput() throws IOException;

   void close() throws IOException;

   int fill(Buffer var1) throws IOException;

   int flush(Buffer var1) throws IOException;

   int flush(Buffer var1, Buffer var2, Buffer var3) throws IOException;

   String getLocalAddr();

   String getLocalHost();

   int getLocalPort();

   String getRemoteAddr();

   String getRemoteHost();

   int getRemotePort();

   boolean isBlocking();

   boolean isBufferred();

   boolean blockReadable(long var1) throws IOException;

   boolean blockWritable(long var1) throws IOException;

   boolean isOpen();

   Object getTransport();

   boolean isBufferingInput();

   boolean isBufferingOutput();

   void flush() throws IOException;
}
