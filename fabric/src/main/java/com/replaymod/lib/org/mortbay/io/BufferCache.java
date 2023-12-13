package com.replaymod.lib.org.mortbay.io;

import com.replaymod.lib.org.mortbay.util.StringMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class BufferCache {
   private HashMap _bufferMap = new HashMap();
   private StringMap _stringMap = new StringMap(true);
   private ArrayList _index = new ArrayList();

   public BufferCache.CachedBuffer add(String value, int ordinal) {
      BufferCache.CachedBuffer buffer = new BufferCache.CachedBuffer(value, ordinal);
      this._bufferMap.put(buffer, buffer);
      this._stringMap.put((String)value, buffer);

      while(ordinal - this._index.size() > 0) {
         this._index.add((Object)null);
      }

      this._index.add(ordinal, buffer);
      return buffer;
   }

   public BufferCache.CachedBuffer get(int ordinal) {
      return ordinal >= 0 && ordinal < this._index.size() ? (BufferCache.CachedBuffer)this._index.get(ordinal) : null;
   }

   public BufferCache.CachedBuffer get(Buffer buffer) {
      return (BufferCache.CachedBuffer)this._bufferMap.get(buffer);
   }

   public BufferCache.CachedBuffer get(String value) {
      return (BufferCache.CachedBuffer)this._stringMap.get(value);
   }

   public Buffer lookup(Buffer buffer) {
      Buffer b = this.get(buffer);
      if (b == null) {
         return (Buffer)(buffer instanceof Buffer.CaseInsensitve ? buffer : new View.CaseInsensitive(buffer));
      } else {
         return b;
      }
   }

   public BufferCache.CachedBuffer getBest(byte[] value, int offset, int maxLength) {
      Entry entry = this._stringMap.getBestEntry(value, offset, maxLength);
      return entry != null ? (BufferCache.CachedBuffer)entry.getValue() : null;
   }

   public Buffer lookup(String value) {
      Buffer b = this.get(value);
      return b == null ? new BufferCache.CachedBuffer(value, -1) : b;
   }

   public String toString(Buffer buffer) {
      return this.lookup(buffer).toString();
   }

   public int getOrdinal(Buffer buffer) {
      if (buffer instanceof BufferCache.CachedBuffer) {
         return ((BufferCache.CachedBuffer)buffer).getOrdinal();
      } else {
         buffer = this.lookup(buffer);
         return buffer != null && buffer instanceof BufferCache.CachedBuffer ? ((BufferCache.CachedBuffer)buffer).getOrdinal() : -1;
      }
   }

   public String toString() {
      return "CACHE[bufferMap=" + this._bufferMap + ",stringMap=" + this._stringMap + ",index=" + this._index + "]";
   }

   public static class CachedBuffer extends ByteArrayBuffer.CaseInsensitive {
      private int _ordinal;
      private HashMap _associateMap = null;

      public CachedBuffer(String value, int ordinal) {
         super(value);
         this._ordinal = ordinal;
      }

      public int getOrdinal() {
         return this._ordinal;
      }

      public BufferCache.CachedBuffer getAssociate(Object key) {
         return this._associateMap == null ? null : (BufferCache.CachedBuffer)this._associateMap.get(key);
      }

      public void setAssociate(Object key, BufferCache.CachedBuffer associate) {
         if (this._associateMap == null) {
            this._associateMap = new HashMap();
         }

         this._associateMap.put(key, associate);
      }
   }
}
