package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.resource.Resource;
import java.io.IOException;
import java.io.InputStream;

public interface HttpContent {
   Buffer getContentType();

   Buffer getLastModified();

   Buffer getBuffer();

   Resource getResource();

   long getContentLength();

   InputStream getInputStream() throws IOException;

   void release();
}
