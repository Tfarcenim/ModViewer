package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import java.io.IOException;

public interface Generator {
   boolean LAST = true;
   boolean MORE = false;

   void addContent(Buffer var1, boolean var2) throws IOException;

   boolean addContent(byte var1) throws IOException;

   void complete() throws IOException;

   void completeHeader(HttpFields var1, boolean var2) throws IOException;

   long flush() throws IOException;

   int getContentBufferSize();

   long getContentWritten();

   boolean isContentWritten();

   void increaseContentBufferSize(int var1);

   boolean isBufferFull();

   boolean isCommitted();

   boolean isComplete();

   boolean isPersistent();

   void reset(boolean var1);

   void resetBuffer();

   void sendError(int var1, String var2, String var3, boolean var4) throws IOException;

   void setHead(boolean var1);

   void setRequest(String var1, String var2);

   void setResponse(int var1, String var2);

   void setSendServerVersion(boolean var1);

   void setVersion(int var1);

   boolean isIdle();

   void setContentLength(long var1);

   void setPersistent(boolean var1);
}
