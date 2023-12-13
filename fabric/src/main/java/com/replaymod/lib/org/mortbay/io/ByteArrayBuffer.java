package com.replaymod.lib.org.mortbay.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class ByteArrayBuffer extends AbstractBuffer {
   protected byte[] _bytes;

   protected ByteArrayBuffer(int access, boolean isVolatile) {
      super(access, isVolatile);
   }

   public ByteArrayBuffer(byte[] bytes) {
      this(bytes, 0, bytes.length, 2);
   }

   public ByteArrayBuffer(byte[] bytes, int index, int length) {
      this(bytes, index, length, 2);
   }

   public ByteArrayBuffer(byte[] bytes, int index, int length, int access) {
      super(2, false);
      this._bytes = bytes;
      this.setPutIndex(index + length);
      this.setGetIndex(index);
      this._access = access;
   }

   public ByteArrayBuffer(byte[] bytes, int index, int length, int access, boolean isVolatile) {
      super(2, isVolatile);
      this._bytes = bytes;
      this.setPutIndex(index + length);
      this.setGetIndex(index);
      this._access = access;
   }

   public ByteArrayBuffer(int size) {
      this(new byte[size], 0, size, 2);
      this.setPutIndex(0);
   }

   public ByteArrayBuffer(String value) {
      super(2, false);
      this._bytes = Portable.getBytes(value);
      this.setGetIndex(0);
      this.setPutIndex(this._bytes.length);
      this._access = 0;
      this._string = value;
   }

   public ByteArrayBuffer(String value, String encoding) throws UnsupportedEncodingException {
      super(2, false);
      this._bytes = value.getBytes(encoding);
      this.setGetIndex(0);
      this.setPutIndex(this._bytes.length);
      this._access = 0;
      this._string = value;
   }

   public byte[] array() {
      return this._bytes;
   }

   public int capacity() {
      return this._bytes.length;
   }

   public void compact() {
      if (this.isReadOnly()) {
         throw new IllegalStateException("READONLY");
      } else {
         int s = this.markIndex() >= 0 ? this.markIndex() : this.getIndex();
         if (s > 0) {
            int length = this.putIndex() - s;
            if (length > 0) {
               Portable.arraycopy(this._bytes, s, this._bytes, 0, length);
            }

            if (this.markIndex() > 0) {
               this.setMarkIndex(this.markIndex() - s);
            }

            this.setGetIndex(this.getIndex() - s);
            this.setPutIndex(this.putIndex() - s);
         }

      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (obj != null && obj instanceof Buffer) {
         if (obj instanceof Buffer.CaseInsensitve) {
            return this.equalsIgnoreCase((Buffer)obj);
         } else {
            Buffer b = (Buffer)obj;
            if (b.length() != this.length()) {
               return false;
            } else {
               if (this._hash != 0 && obj instanceof AbstractBuffer) {
                  AbstractBuffer ab = (AbstractBuffer)obj;
                  if (ab._hash != 0 && this._hash != ab._hash) {
                     return false;
                  }
               }

               int get = this.getIndex();
               int bi = b.putIndex();
               int i = this.putIndex();

               byte b1;
               byte b2;
               do {
                  if (i-- <= get) {
                     return true;
                  }

                  b1 = this._bytes[i];
                  --bi;
                  b2 = b.peek(bi);
               } while(b1 == b2);

               return false;
            }
         }
      } else {
         return false;
      }
   }

   public boolean equalsIgnoreCase(Buffer b) {
      if (b == this) {
         return true;
      } else if (b != null && b.length() == this.length()) {
         if (this._hash != 0 && b instanceof AbstractBuffer) {
            AbstractBuffer ab = (AbstractBuffer)b;
            if (ab._hash != 0 && this._hash != ab._hash) {
               return false;
            }
         }

         int get = this.getIndex();
         int bi = b.putIndex();
         byte[] barray = b.array();
         int i;
         byte b1;
         byte b2;
         if (barray == null) {
            i = this.putIndex();

            while(i-- > get) {
               b1 = this._bytes[i];
               --bi;
               b2 = b.peek(bi);
               if (b1 != b2) {
                  if (97 <= b1 && b1 <= 122) {
                     b1 = (byte)(b1 - 97 + 65);
                  }

                  if (97 <= b2 && b2 <= 122) {
                     b2 = (byte)(b2 - 97 + 65);
                  }

                  if (b1 != b2) {
                     return false;
                  }
               }
            }
         } else {
            i = this.putIndex();

            while(i-- > get) {
               b1 = this._bytes[i];
               --bi;
               b2 = barray[bi];
               if (b1 != b2) {
                  if (97 <= b1 && b1 <= 122) {
                     b1 = (byte)(b1 - 97 + 65);
                  }

                  if (97 <= b2 && b2 <= 122) {
                     b2 = (byte)(b2 - 97 + 65);
                  }

                  if (b1 != b2) {
                     return false;
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public byte get() {
      return this._bytes[this._get++];
   }

   public int hashCode() {
      if (this._hash == 0 || this._hashGet != this._get || this._hashPut != this._put) {
         int get = this.getIndex();

         byte b;
         for(int i = this.putIndex(); i-- > get; this._hash = 31 * this._hash + b) {
            b = this._bytes[i];
            if (97 <= b && b <= 122) {
               b = (byte)(b - 97 + 65);
            }
         }

         if (this._hash == 0) {
            this._hash = -1;
         }

         this._hashGet = this._get;
         this._hashPut = this._put;
      }

      return this._hash;
   }

   public byte peek(int index) {
      return this._bytes[index];
   }

   public int peek(int index, byte[] b, int offset, int length) {
      int l = length;
      if (index + length > this.capacity()) {
         l = this.capacity() - index;
         if (l == 0) {
            return -1;
         }
      }

      if (l < 0) {
         return -1;
      } else {
         Portable.arraycopy(this._bytes, index, b, offset, l);
         return l;
      }
   }

   public void poke(int index, byte b) {
      this._bytes[index] = b;
   }

   public int poke(int index, Buffer src) {
      this._hash = 0;
      int length = src.length();
      if (index + length > this.capacity()) {
         length = this.capacity() - index;
      }

      byte[] src_array = src.array();
      if (src_array != null) {
         Portable.arraycopy(src_array, src.getIndex(), this._bytes, index, length);
      } else {
         int s;
         int i;
         if (src_array != null) {
            s = src.getIndex();

            for(i = 0; i < length; ++i) {
               this.poke(index++, src_array[s++]);
            }
         } else {
            s = src.getIndex();

            for(i = 0; i < length; ++i) {
               this._bytes[index++] = src.peek(s++);
            }
         }
      }

      return length;
   }

   public int poke(int index, byte[] b, int offset, int length) {
      this._hash = 0;
      if (index + length > this.capacity()) {
         length = this.capacity() - index;
      }

      Portable.arraycopy(b, offset, this._bytes, index, length);
      return length;
   }

   public void wrap(byte[] b, int off, int len) {
      if (this.isReadOnly()) {
         throw new IllegalStateException("READONLY");
      } else if (this.isImmutable()) {
         throw new IllegalStateException("IMMUTABLE");
      } else {
         this._bytes = b;
         this.clear();
         this.setGetIndex(off);
         this.setPutIndex(off + len);
      }
   }

   public void wrap(byte[] b) {
      if (this.isReadOnly()) {
         throw new IllegalStateException("READONLY");
      } else if (this.isImmutable()) {
         throw new IllegalStateException("IMMUTABLE");
      } else {
         this._bytes = b;
         this.setGetIndex(0);
         this.setPutIndex(b.length);
      }
   }

   public void writeTo(OutputStream out) throws IOException {
      out.write(this._bytes, this.getIndex(), this.length());
      this.clear();
   }

   public int readFrom(InputStream in, int max) throws IOException {
      if (max < 0 || max > this.space()) {
         max = this.space();
      }

      int p = this.putIndex();
      int len = 0;
      int total = 0;
      int available = max;

      while(total < max) {
         len = in.read(this._bytes, p, available);
         if (len < 0) {
            break;
         }

         if (len > 0) {
            p += len;
            total += len;
            available -= len;
            this.setPutIndex(p);
         }

         if (in.available() <= 0) {
            break;
         }
      }

      return len < 0 && total == 0 ? -1 : total;
   }

   public int space() {
      return this._bytes.length - this._put;
   }

   public static class CaseInsensitive extends ByteArrayBuffer implements Buffer.CaseInsensitve {
      public CaseInsensitive(String s) {
         super(s);
      }

      public CaseInsensitive(byte[] b, int o, int l, int rw) {
         super(b, o, l, rw);
      }

      public boolean equals(Object obj) {
         return this.equalsIgnoreCase((Buffer)obj);
      }
   }
}
