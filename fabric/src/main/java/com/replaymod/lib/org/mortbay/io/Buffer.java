package com.replaymod.lib.org.mortbay.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Buffer extends Cloneable {
   int IMMUTABLE = 0;
   int READONLY = 1;
   int READWRITE = 2;
   boolean VOLATILE = true;
   boolean NON_VOLATILE = false;

   byte[] array();

   byte[] asArray();

   Buffer buffer();

   Buffer asNonVolatileBuffer();

   Buffer asReadOnlyBuffer();

   Buffer asImmutableBuffer();

   Buffer asMutableBuffer();

   int capacity();

   int space();

   void clear();

   void compact();

   byte get();

   int get(byte[] var1, int var2, int var3);

   Buffer get(int var1);

   int getIndex();

   boolean hasContent();

   boolean equalsIgnoreCase(Buffer var1);

   boolean isImmutable();

   boolean isReadOnly();

   boolean isVolatile();

   int length();

   void mark();

   void mark(int var1);

   int markIndex();

   byte peek();

   byte peek(int var1);

   Buffer peek(int var1, int var2);

   int peek(int var1, byte[] var2, int var3, int var4);

   int poke(int var1, Buffer var2);

   void poke(int var1, byte var2);

   int poke(int var1, byte[] var2, int var3, int var4);

   int put(Buffer var1);

   void put(byte var1);

   int put(byte[] var1, int var2, int var3);

   int put(byte[] var1);

   int putIndex();

   void reset();

   void setGetIndex(int var1);

   void setMarkIndex(int var1);

   void setPutIndex(int var1);

   int skip(int var1);

   Buffer slice();

   Buffer sliceFromMark();

   Buffer sliceFromMark(int var1);

   String toDetailString();

   void writeTo(OutputStream var1) throws IOException;

   int readFrom(InputStream var1, int var2) throws IOException;

   public interface CaseInsensitve {
   }
}
