package com.replaymod.lib.org.mortbay.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractBuffer implements Buffer {
   protected static final String __IMMUTABLE = "IMMUTABLE";
   protected static final String __READONLY = "READONLY";
   protected static final String __READWRITE = "READWRITE";
   protected static final String __VOLATILE = "VOLATILE";
   protected int _access;
   protected boolean _volatile;
   protected int _get;
   protected int _put;
   protected int _hash;
   protected int _hashGet;
   protected int _hashPut;
   protected int _mark;
   protected String _string;
   protected View _view;
   // $FF: synthetic field
   static final boolean $assertionsDisabled;

   public AbstractBuffer(int access, boolean isVolatile) {
      if (access == 0 && isVolatile) {
         throw new IllegalArgumentException("IMMUTABLE && VOLATILE");
      } else {
         this.setMarkIndex(-1);
         this._access = access;
         this._volatile = isVolatile;
      }
   }

   public byte[] asArray() {
      byte[] bytes = new byte[this.length()];
      byte[] array = this.array();
      if (array != null) {
         Portable.arraycopy(array, this.getIndex(), bytes, 0, bytes.length);
      } else {
         this.peek(this.getIndex(), bytes, 0, this.length());
      }

      return bytes;
   }

   public ByteArrayBuffer duplicate(int access) {
      Buffer b = this.buffer();
      return (ByteArrayBuffer)(b instanceof Buffer.CaseInsensitve ? new ByteArrayBuffer.CaseInsensitive(this.asArray(), 0, this.length(), access) : new ByteArrayBuffer(this.asArray(), 0, this.length(), access));
   }

   public Buffer asNonVolatileBuffer() {
      return (Buffer)(!this.isVolatile() ? this : this.duplicate(this._access));
   }

   public Buffer asImmutableBuffer() {
      return (Buffer)(this.isImmutable() ? this : this.duplicate(0));
   }

   public Buffer asReadOnlyBuffer() {
      return (Buffer)(this.isReadOnly() ? this : new View(this, this.markIndex(), this.getIndex(), this.putIndex(), 1));
   }

   public Buffer asMutableBuffer() {
      if (!this.isImmutable()) {
         return this;
      } else {
         Buffer b = this.buffer();
         return (Buffer)(b.isReadOnly() ? this.duplicate(2) : new View(b, this.markIndex(), this.getIndex(), this.putIndex(), this._access));
      }
   }

   public Buffer buffer() {
      return this;
   }

   public void clear() {
      this.setMarkIndex(-1);
      this.setGetIndex(0);
      this.setPutIndex(0);
   }

   public void compact() {
      if (this.isReadOnly()) {
         throw new IllegalStateException("READONLY");
      } else {
         int s = this.markIndex() >= 0 ? this.markIndex() : this.getIndex();
         if (s > 0) {
            byte[] array = this.array();
            int length = this.putIndex() - s;
            if (length > 0) {
               if (array != null) {
                  Portable.arraycopy(this.array(), s, this.array(), 0, length);
               } else {
                  this.poke(0, this.peek(s, length));
               }
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
         Buffer b = (Buffer)obj;
         if (!(this instanceof Buffer.CaseInsensitve) && !(b instanceof Buffer.CaseInsensitve)) {
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

                  b1 = this.peek(i);
                  --bi;
                  b2 = b.peek(bi);
               } while(b1 == b2);

               return false;
            }
         } else {
            return this.equalsIgnoreCase(b);
         }
      } else {
         return false;
      }
   }

   public boolean equalsIgnoreCase(Buffer b) {
      if (b == this) {
         return true;
      } else if (b.length() != this.length()) {
         return false;
      } else {
         if (this._hash != 0 && b instanceof AbstractBuffer) {
            AbstractBuffer ab = (AbstractBuffer)b;
            if (ab._hash != 0 && this._hash != ab._hash) {
               return false;
            }
         }

         int get = this.getIndex();
         int bi = b.putIndex();
         byte[] array = this.array();
         byte[] barray = b.array();
         int i;
         byte b1;
         byte b2;
         if (array != null && barray != null) {
            i = this.putIndex();

            while(i-- > get) {
               b1 = array[i];
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
         } else {
            i = this.putIndex();

            while(i-- > get) {
               b1 = this.peek(i);
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
         }

         return true;
      }
   }

   public byte get() {
      return this.peek(this._get++);
   }

   public int get(byte[] b, int offset, int length) {
      int gi = this.getIndex();
      int l = this.length();
      if (l == 0) {
         return -1;
      } else {
         if (length > l) {
            length = l;
         }

         length = this.peek(gi, b, offset, length);
         if (length > 0) {
            this.setGetIndex(gi + length);
         }

         return length;
      }
   }

   public Buffer get(int length) {
      int gi = this.getIndex();
      Buffer view = this.peek(gi, length);
      this.setGetIndex(gi + length);
      return view;
   }

   public final int getIndex() {
      return this._get;
   }

   public boolean hasContent() {
      return this._put > this._get;
   }

   public int hashCode() {
      if (this._hash == 0 || this._hashGet != this._get || this._hashPut != this._put) {
         int get = this.getIndex();
         byte[] array = this.array();
         int i;
         byte b;
         if (array == null) {
            for(i = this.putIndex(); i-- > get; this._hash = 31 * this._hash + b) {
               b = this.peek(i);
               if (97 <= b && b <= 122) {
                  b = (byte)(b - 97 + 65);
               }
            }
         } else {
            for(i = this.putIndex(); i-- > get; this._hash = 31 * this._hash + b) {
               b = array[i];
               if (97 <= b && b <= 122) {
                  b = (byte)(b - 97 + 65);
               }
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

   public boolean isImmutable() {
      return this._access <= 0;
   }

   public boolean isReadOnly() {
      return this._access <= 1;
   }

   public boolean isVolatile() {
      return this._volatile;
   }

   public int length() {
      return this._put - this._get;
   }

   public void mark() {
      this.setMarkIndex(this._get - 1);
   }

   public void mark(int offset) {
      this.setMarkIndex(this._get + offset);
   }

   public int markIndex() {
      return this._mark;
   }

   public byte peek() {
      return this.peek(this._get);
   }

   public Buffer peek(int index, int length) {
      if (this._view == null) {
         this._view = new View(this, -1, index, index + length, this.isReadOnly() ? 1 : 2);
      } else {
         this._view.update(this.buffer());
         this._view.setMarkIndex(-1);
         this._view.setGetIndex(0);
         this._view.setPutIndex(index + length);
         this._view.setGetIndex(index);
      }

      return this._view;
   }

   public int poke(int index, Buffer src) {
      this._hash = 0;
      int length = src.length();
      if (index + length > this.capacity()) {
         length = this.capacity() - index;
      }

      byte[] src_array = src.array();
      byte[] dst_array = this.array();
      if (src_array != null && dst_array != null) {
         Portable.arraycopy(src_array, src.getIndex(), dst_array, index, length);
      } else {
         int s;
         int i;
         if (src_array != null) {
            s = src.getIndex();

            for(i = 0; i < length; ++i) {
               this.poke(index++, src_array[s++]);
            }
         } else if (dst_array != null) {
            s = src.getIndex();

            for(i = 0; i < length; ++i) {
               dst_array[index++] = src.peek(s++);
            }
         } else {
            s = src.getIndex();

            for(i = 0; i < length; ++i) {
               this.poke(index++, src.peek(s++));
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

      byte[] dst_array = this.array();
      if (dst_array != null) {
         Portable.arraycopy(b, offset, dst_array, index, length);
      } else {
         int s = offset;

         for(int i = 0; i < length; ++i) {
            this.poke(index++, b[s++]);
         }
      }

      return length;
   }

   public int put(Buffer src) {
      int pi = this.putIndex();
      int l = this.poke(pi, src);
      this.setPutIndex(pi + l);
      return l;
   }

   public void put(byte b) {
      int pi = this.putIndex();
      this.poke(pi, b);
      this.setPutIndex(pi + 1);
   }

   public int put(byte[] b, int offset, int length) {
      int pi = this.putIndex();
      int l = this.poke(pi, b, offset, length);
      this.setPutIndex(pi + l);
      return l;
   }

   public int put(byte[] b) {
      int pi = this.putIndex();
      int l = this.poke(pi, b, 0, b.length);
      this.setPutIndex(pi + l);
      return l;
   }

   public final int putIndex() {
      return this._put;
   }

   public void reset() {
      if (this.markIndex() >= 0) {
         this.setGetIndex(this.markIndex());
      }

   }

   public void rewind() {
      this.setGetIndex(0);
      this.setMarkIndex(-1);
   }

   public void setGetIndex(int getIndex) {
      this._get = getIndex;
      this._hash = 0;
   }

   public void setMarkIndex(int index) {
      this._mark = index;
   }

   public void setPutIndex(int putIndex) {
      this._put = putIndex;
      this._hash = 0;
   }

   public int skip(int n) {
      if (this.length() < n) {
         n = this.length();
      }

      this.setGetIndex(this.getIndex() + n);
      return n;
   }

   public Buffer slice() {
      return this.peek(this.getIndex(), this.length());
   }

   public Buffer sliceFromMark() {
      return this.sliceFromMark(this.getIndex() - this.markIndex() - 1);
   }

   public Buffer sliceFromMark(int length) {
      if (this.markIndex() < 0) {
         return null;
      } else {
         Buffer view = this.peek(this.markIndex(), length);
         this.setMarkIndex(-1);
         return view;
      }
   }

   public int space() {
      return this.capacity() - this._put;
   }

   public String toDetailString() {
      StringBuffer buf = new StringBuffer();
      buf.append("[");
      buf.append(super.hashCode());
      buf.append(",");
      buf.append(this.array().hashCode());
      buf.append(",m=");
      buf.append(this.markIndex());
      buf.append(",g=");
      buf.append(this.getIndex());
      buf.append(",p=");
      buf.append(this.putIndex());
      buf.append(",c=");
      buf.append(this.capacity());
      buf.append("]={");
      int i;
      if (this.markIndex() >= 0) {
         for(i = this.markIndex(); i < this.getIndex(); ++i) {
            char c = (char)this.peek(i);
            if (Character.isISOControl(c)) {
               buf.append(c < 16 ? "\\0" : "\\");
               buf.append(Integer.toString(c, 16));
            } else {
               buf.append(c);
            }
         }

         buf.append("}{");
      }

      i = 0;

      for(int i = this.getIndex(); i < this.putIndex(); ++i) {
         char c = (char)this.peek(i);
         if (Character.isISOControl(c)) {
            buf.append(c < 16 ? "\\0" : "\\");
            buf.append(Integer.toString(c, 16));
         } else {
            buf.append(c);
         }

         if (i++ == 50 && this.putIndex() - i > 20) {
            buf.append(" ... ");
            i = this.putIndex() - 20;
         }
      }

      buf.append('}');
      return buf.toString();
   }

   public String toString() {
      if (this.isImmutable()) {
         if (this._string == null) {
            this._string = new String(this.asArray(), 0, this.length());
         }

         return this._string;
      } else {
         return new String(this.asArray(), 0, this.length());
      }
   }

   public String toDebugString() {
      return this.getClass() + "@" + super.hashCode();
   }

   public void writeTo(OutputStream out) throws IOException {
      byte[] array = this.array();
      if (array != null) {
         out.write(array, this.getIndex(), this.length());
      } else {
         int len = this.length();
         byte[] buf = new byte[len > 1024 ? 1024 : len];

         int l;
         for(int offset = this._get; len > 0; len -= l) {
            l = this.peek(offset, buf, 0, len > buf.length ? buf.length : len);
            out.write(buf, 0, l);
            offset += l;
         }
      }

      this.clear();
   }

   public int readFrom(InputStream in, int max) throws IOException {
      byte[] array = this.array();
      int s = this.space();
      if (s > max) {
         s = max;
      }

      if (array != null) {
         int l = in.read(array, this._put, s);
         if (l > 0) {
            this._put += l;
         }

         return l;
      } else {
         byte[] buf = new byte[s > 1024 ? 1024 : s];

         byte total;
         int l;
         for(total = 0; s > 0; s -= l) {
            l = in.read(buf, 0, buf.length);
            if (l < 0) {
               return total > 0 ? total : -1;
            }

            int p = this.put(buf, 0, l);
            if (!$assertionsDisabled && l != p) {
               throw new AssertionError();
            }
         }

         return total;
      }
   }

   static {
      $assertionsDisabled = !AbstractBuffer.class.desiredAssertionStatus();
   }
}
