package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.Buffers;
import com.replaymod.lib.org.mortbay.io.ByteArrayBuffer;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import com.replaymod.lib.org.mortbay.io.View;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.ByteArrayOutputStream2;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import com.replaymod.lib.org.mortbay.util.TypeUtil;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractGenerator implements Generator {
   public static final int STATE_HEADER = 0;
   public static final int STATE_CONTENT = 2;
   public static final int STATE_FLUSHING = 3;
   public static final int STATE_END = 4;
   private static final byte[] NO_BYTES = new byte[0];
   private static int MAX_OUTPUT_CHARS = 512;
   private static Buffer[] __reasons = new Buffer[505];
   protected int _state = 0;
   protected int _status = 0;
   protected int _version = 11;
   protected Buffer _reason;
   protected Buffer _method;
   protected String _uri;
   protected long _contentWritten = 0L;
   protected long _contentLength = -3L;
   protected boolean _last = false;
   protected boolean _head = false;
   protected boolean _noContent = false;
   protected boolean _close = false;
   protected Buffers _buffers;
   protected EndPoint _endp;
   protected int _headerBufferSize;
   protected int _contentBufferSize;
   protected Buffer _header;
   protected Buffer _buffer;
   protected Buffer _content;
   private boolean _sendServerVersion;

   protected static Buffer getReasonBuffer(int code) {
      Buffer reason = code < __reasons.length ? __reasons[code] : null;
      return reason == null ? null : reason;
   }

   public static String getReason(int code) {
      Buffer reason = code < __reasons.length ? __reasons[code] : null;
      return reason == null ? TypeUtil.toString(code) : reason.toString();
   }

   public AbstractGenerator(Buffers buffers, EndPoint io, int headerBufferSize, int contentBufferSize) {
      this._buffers = buffers;
      this._endp = io;
      this._headerBufferSize = headerBufferSize;
      this._contentBufferSize = contentBufferSize;
   }

   public void reset(boolean returnBuffers) {
      this._state = 0;
      this._status = 0;
      this._version = 11;
      this._reason = null;
      this._last = false;
      this._head = false;
      this._noContent = false;
      this._close = false;
      this._contentWritten = 0L;
      this._contentLength = -3L;
      synchronized(this) {
         if (returnBuffers) {
            if (this._header != null) {
               this._buffers.returnBuffer(this._header);
            }

            this._header = null;
            if (this._buffer != null) {
               this._buffers.returnBuffer(this._buffer);
            }

            this._buffer = null;
         } else {
            if (this._header != null) {
               this._header.clear();
            }

            if (this._buffer != null) {
               this._buffers.returnBuffer(this._buffer);
               this._buffer = null;
            }
         }
      }

      this._content = null;
      this._method = null;
   }

   public void resetBuffer() {
      if (this._state >= 3) {
         throw new IllegalStateException("Flushed");
      } else {
         this._last = false;
         this._close = false;
         this._contentWritten = 0L;
         this._contentLength = -3L;
         this._content = null;
         if (this._buffer != null) {
            this._buffer.clear();
         }

      }
   }

   public int getContentBufferSize() {
      return this._contentBufferSize;
   }

   public void increaseContentBufferSize(int contentBufferSize) {
      if (contentBufferSize > this._contentBufferSize) {
         this._contentBufferSize = contentBufferSize;
         if (this._buffer != null) {
            Buffer nb = this._buffers.getBuffer(this._contentBufferSize);
            nb.put(this._buffer);
            this._buffers.returnBuffer(this._buffer);
            this._buffer = nb;
         }
      }

   }

   public Buffer getUncheckedBuffer() {
      return this._buffer;
   }

   public boolean getSendServerVersion() {
      return this._sendServerVersion;
   }

   public void setSendServerVersion(boolean sendServerVersion) {
      this._sendServerVersion = sendServerVersion;
   }

   public int getState() {
      return this._state;
   }

   public boolean isState(int state) {
      return this._state == state;
   }

   public boolean isComplete() {
      return this._state == 4;
   }

   public boolean isIdle() {
      return this._state == 0 && this._method == null && this._status == 0;
   }

   public boolean isCommitted() {
      return this._state != 0;
   }

   public boolean isHead() {
      return this._head;
   }

   public void setContentLength(long value) {
      if (value < 0L) {
         this._contentLength = -3L;
      } else {
         this._contentLength = value;
      }

   }

   public void setHead(boolean head) {
      this._head = head;
   }

   public boolean isPersistent() {
      return !this._close;
   }

   public void setPersistent(boolean persistent) {
      this._close = !persistent;
   }

   public void setVersion(int version) {
      if (this._state != 0) {
         throw new IllegalStateException("STATE!=START");
      } else {
         this._version = version;
         if (this._version == 9 && this._method != null) {
            this._noContent = true;
         }

      }
   }

   public int getVersion() {
      return this._version;
   }

   public void setRequest(String method, String uri) {
      if (method != null && !"GET".equals(method)) {
         this._method = HttpMethods.CACHE.lookup(method);
      } else {
         this._method = HttpMethods.GET_BUFFER;
      }

      this._uri = uri;
      if (this._version == 9) {
         this._noContent = true;
      }

   }

   public void setResponse(int status, String reason) {
      if (this._state != 0) {
         throw new IllegalStateException("STATE!=START");
      } else {
         this._status = status;
         if (reason != null) {
            int len = reason.length();
            if (len > this._headerBufferSize / 2) {
               len = this._headerBufferSize / 2;
            }

            this._reason = new ByteArrayBuffer(len);

            for(int i = 0; i < len; ++i) {
               char ch = reason.charAt(i);
               if (ch != '\r' && ch != '\n') {
                  this._reason.put((byte)ch);
               } else {
                  this._reason.put((byte)32);
               }
            }
         }

      }
   }

   protected abstract int prepareUncheckedAddContent() throws IOException;

   void uncheckedAddContent(int b) {
      this._buffer.put((byte)b);
   }

   void completeUncheckedAddContent() {
      if (this._noContent) {
         if (this._buffer != null) {
            this._buffer.clear();
         }

      } else {
         this._contentWritten += (long)this._buffer.length();
         if (this._head) {
            this._buffer.clear();
         }

      }
   }

   public boolean isBufferFull() {
      if (this._buffer != null && this._buffer.space() == 0) {
         if (this._buffer.length() == 0 && !this._buffer.isImmutable()) {
            this._buffer.compact();
         }

         return this._buffer.space() == 0;
      } else {
         return this._content != null && this._content.length() > 0;
      }
   }

   public boolean isContentWritten() {
      return this._contentLength >= 0L && this._contentWritten >= this._contentLength;
   }

   public abstract void completeHeader(HttpFields var1, boolean var2) throws IOException;

   public void complete() throws IOException {
      if (this._state == 0) {
         throw new IllegalStateException("State==HEADER");
      } else {
         if (this._contentLength >= 0L && this._contentLength != this._contentWritten && !this._head) {
            if (Log.isDebugEnabled()) {
               Log.debug("ContentLength written==" + this._contentWritten + " != contentLength==" + this._contentLength);
            }

            this._close = true;
         }

      }
   }

   public abstract long flush() throws IOException;

   public void sendError(int code, String reason, String content, boolean close) throws IOException {
      if (close) {
         this._close = close;
      }

      if (!this.isCommitted()) {
         this.setResponse(code, reason);
         this.completeHeader((HttpFields)null, false);
         if (content != null) {
            this.addContent(new View(new ByteArrayBuffer(content)), true);
         }

         this.complete();
      }

   }

   public long getContentWritten() {
      return this._contentWritten;
   }

   static {
      Field[] fields = HttpServletResponse.class.getDeclaredFields();

      for(int i = 0; i < fields.length; ++i) {
         if ((fields[i].getModifiers() & 8) != 0 && fields[i].getName().startsWith("SC_")) {
            try {
               int code = fields[i].getInt((Object)null);
               if (code < __reasons.length) {
                  __reasons[code] = new ByteArrayBuffer(fields[i].getName().substring(3));
               }
            } catch (IllegalAccessException var3) {
            }
         }
      }

   }

   public static class OutputWriter extends Writer {
      private static final int WRITE_CONV = 0;
      private static final int WRITE_ISO1 = 1;
      private static final int WRITE_UTF8 = 2;
      AbstractGenerator.Output _out;
      AbstractGenerator _generator;
      int _writeMode;
      int _surrogate;

      public OutputWriter(AbstractGenerator.Output out) {
         this._out = out;
         this._generator = this._out._generator;
      }

      public void setCharacterEncoding(String encoding) {
         if (encoding != null && !StringUtil.__ISO_8859_1.equalsIgnoreCase(encoding)) {
            if ("UTF-8".equalsIgnoreCase(encoding)) {
               this._writeMode = 2;
            } else {
               this._writeMode = 0;
               if (this._out._characterEncoding == null || !this._out._characterEncoding.equalsIgnoreCase(encoding)) {
                  this._out._converter = null;
               }
            }
         } else {
            this._writeMode = 1;
         }

         this._out._characterEncoding = encoding;
         if (this._out._bytes == null) {
            this._out._bytes = new ByteArrayOutputStream2(AbstractGenerator.MAX_OUTPUT_CHARS);
         }

      }

      public void close() throws IOException {
         this._out.close();
      }

      public void flush() throws IOException {
         this._out.flush();
      }

      public void write(String s, int offset, int length) throws IOException {
         while(length > AbstractGenerator.MAX_OUTPUT_CHARS) {
            this.write(s, offset, AbstractGenerator.MAX_OUTPUT_CHARS);
            offset += AbstractGenerator.MAX_OUTPUT_CHARS;
            length -= AbstractGenerator.MAX_OUTPUT_CHARS;
         }

         if (this._out._chars == null) {
            this._out._chars = new char[AbstractGenerator.MAX_OUTPUT_CHARS];
         }

         char[] chars = this._out._chars;
         s.getChars(offset, offset + length, chars, 0);
         this.write((char[])chars, 0, length);
      }

      public void write(char[] s, int offset, int length) throws IOException {
         int chars;
         for(AbstractGenerator.Output out = this._out; length > 0; offset += chars) {
            out._bytes.reset();
            chars = length > AbstractGenerator.MAX_OUTPUT_CHARS ? AbstractGenerator.MAX_OUTPUT_CHARS : length;
            byte[] buffer;
            int bytes;
            int i;
            char code;
            switch(this._writeMode) {
            case 0:
               Writer converter = this.getConverter();
               converter.write(s, offset, chars);
               converter.flush();
               break;
            case 1:
               buffer = out._bytes.getBuf();
               bytes = out._bytes.getCount();
               if (chars > buffer.length - bytes) {
                  chars = buffer.length - bytes;
               }

               for(i = 0; i < chars; ++i) {
                  code = s[offset + i];
                  buffer[bytes++] = (byte)(code < 256 ? code : 63);
               }

               if (bytes >= 0) {
                  out._bytes.setCount(bytes);
               }
               break;
            case 2:
               buffer = out._bytes.getBuf();
               bytes = out._bytes.getCount();
               if (bytes + chars > buffer.length) {
                  chars = buffer.length - bytes;
               }

               for(i = 0; i < chars; ++i) {
                  code = s[offset + i];
                  if ((code & -128) == 0) {
                     if (bytes + 1 > buffer.length) {
                        chars = i;
                        break;
                     }

                     buffer[bytes++] = (byte)code;
                  } else {
                     if ((code & -2048) == 0) {
                        if (bytes + 2 > buffer.length) {
                           chars = i;
                           break;
                        }

                        buffer[bytes++] = (byte)(192 | code >> 6);
                        buffer[bytes++] = (byte)(128 | code & 63);
                     } else if ((code & -65536) == 0) {
                        if (bytes + 3 > buffer.length) {
                           chars = i;
                           break;
                        }

                        buffer[bytes++] = (byte)(224 | code >> 12);
                        buffer[bytes++] = (byte)(128 | code >> 6 & 63);
                        buffer[bytes++] = (byte)(128 | code & 63);
                     } else if ((code & -14680064) == 0) {
                        if (bytes + 4 > buffer.length) {
                           chars = i;
                           break;
                        }

                        buffer[bytes++] = (byte)(240 | code >> 18);
                        buffer[bytes++] = (byte)(128 | code >> 12 & 63);
                        buffer[bytes++] = (byte)(128 | code >> 6 & 63);
                        buffer[bytes++] = (byte)(128 | code & 63);
                     } else if ((code & -201326592) == 0) {
                        if (bytes + 5 > buffer.length) {
                           chars = i;
                           break;
                        }

                        buffer[bytes++] = (byte)(248 | code >> 24);
                        buffer[bytes++] = (byte)(128 | code >> 18 & 63);
                        buffer[bytes++] = (byte)(128 | code >> 12 & 63);
                        buffer[bytes++] = (byte)(128 | code >> 6 & 63);
                        buffer[bytes++] = (byte)(128 | code & 63);
                     } else if ((code & Integer.MIN_VALUE) == 0) {
                        if (bytes + 6 > buffer.length) {
                           chars = i;
                           break;
                        }

                        buffer[bytes++] = (byte)(252 | code >> 30);
                        buffer[bytes++] = (byte)(128 | code >> 24 & 63);
                        buffer[bytes++] = (byte)(128 | code >> 18 & 63);
                        buffer[bytes++] = (byte)(128 | code >> 12 & 63);
                        buffer[bytes++] = (byte)(128 | code >> 6 & 63);
                        buffer[bytes++] = (byte)(128 | code & 63);
                     } else {
                        buffer[bytes++] = 63;
                     }

                     if (bytes == buffer.length) {
                        chars = i + 1;
                        break;
                     }
                  }
               }

               out._bytes.setCount(bytes);
               break;
            default:
               throw new IllegalStateException();
            }

            out._bytes.writeTo(out);
            length -= chars;
         }

      }

      private Writer getConverter() throws IOException {
         if (this._out._converter == null) {
            this._out._converter = new OutputStreamWriter(this._out._bytes, this._out._characterEncoding);
         }

         return this._out._converter;
      }
   }

   public static class Output extends ServletOutputStream {
      protected AbstractGenerator _generator;
      protected long _maxIdleTime;
      protected ByteArrayBuffer _buf;
      protected boolean _closed;
      String _characterEncoding;
      Writer _converter;
      char[] _chars;
      ByteArrayOutputStream2 _bytes;

      public Output(AbstractGenerator generator, long maxIdleTime) {
         this._buf = new ByteArrayBuffer(AbstractGenerator.NO_BYTES);
         this._generator = generator;
         this._maxIdleTime = maxIdleTime;
      }

      public void close() throws IOException {
         this._closed = true;
      }

      void blockForOutput() throws IOException {
         if (this._generator._endp.isBlocking()) {
            try {
               this.flush();
            } catch (IOException var2) {
               this._generator._endp.close();
               throw var2;
            }
         } else {
            if (!this._generator._endp.blockWritable(this._maxIdleTime)) {
               this._generator._endp.close();
               throw new EofException("timeout");
            }

            this._generator.flush();
         }

      }

      void reopen() {
         this._closed = false;
      }

      public void flush() throws IOException {
         Buffer content = this._generator._content;
         Buffer buffer = this._generator._buffer;
         if (content != null && content.length() > 0 || buffer != null && buffer.length() > 0 || this._generator.isBufferFull()) {
            this._generator.flush();

            while(content != null && content.length() > 0 || buffer != null && buffer.length() > 0) {
               if (!this._generator._endp.isOpen()) {
                  break;
               }

               this.blockForOutput();
            }
         }

      }

      public void write(byte[] b, int off, int len) throws IOException {
         this._buf.wrap(b, off, len);
         this.write((Buffer)this._buf);
         this._buf.wrap(AbstractGenerator.NO_BYTES);
      }

      public void write(byte[] b) throws IOException {
         this._buf.wrap(b);
         this.write((Buffer)this._buf);
         this._buf.wrap(AbstractGenerator.NO_BYTES);
      }

      public void write(int b) throws IOException {
         if (this._closed) {
            throw new IOException("Closed");
         } else if (!this._generator._endp.isOpen()) {
            throw new EofException();
         } else {
            do {
               if (!this._generator.isBufferFull()) {
                  if (this._generator.addContent((byte)b)) {
                     this.flush();
                  }

                  if (this._generator.isContentWritten()) {
                     this.flush();
                     this.close();
                  }

                  return;
               }

               this.blockForOutput();
               if (this._closed) {
                  throw new IOException("Closed");
               }
            } while(this._generator._endp.isOpen());

            throw new EofException();
         }
      }

      private void write(Buffer buffer) throws IOException {
         if (this._closed) {
            throw new IOException("Closed");
         } else if (!this._generator._endp.isOpen()) {
            throw new EofException();
         } else {
            while(this._generator.isBufferFull()) {
               this.blockForOutput();
               if (this._closed) {
                  throw new IOException("Closed");
               }

               if (!this._generator._endp.isOpen()) {
                  throw new EofException();
               }
            }

            this._generator.addContent(buffer, false);
            if (this._generator.isBufferFull()) {
               this.flush();
            }

            if (this._generator.isContentWritten()) {
               this.flush();
               this.close();
            }

            while(buffer.length() > 0 && this._generator._endp.isOpen()) {
               this.blockForOutput();
            }

         }
      }

      public void print(String s) throws IOException {
         this.write(s.getBytes());
      }
   }
}
