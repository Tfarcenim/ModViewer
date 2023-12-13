package com.replaymod.lib.org.mortbay.io.nio;

import com.replaymod.lib.org.mortbay.io.Buffer;
import java.nio.ByteBuffer;

public interface NIOBuffer extends Buffer {
   ByteBuffer getByteBuffer();

   boolean isDirect();
}
