package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.BufferCache;
import com.replaymod.lib.org.mortbay.io.BufferUtil;
import com.replaymod.lib.org.mortbay.io.Buffers;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import com.replaymod.lib.org.mortbay.io.Portable;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.QuotedStringTokenizer;
import java.io.IOException;
import java.util.Iterator;

public class HttpGenerator extends AbstractGenerator {
   private static byte[] LAST_CHUNK = new byte[]{48, 13, 10, 13, 10};
   private static byte[] CONTENT_LENGTH_0 = Portable.getBytes("Content-Length: 0\r\n");
   private static byte[] CONNECTION_KEEP_ALIVE = Portable.getBytes("Connection: keep-alive\r\n");
   private static byte[] CONNECTION_CLOSE = Portable.getBytes("Connection: close\r\n");
   private static byte[] CONNECTION_ = Portable.getBytes("Connection: ");
   private static byte[] CRLF = Portable.getBytes("\r\n");
   private static byte[] TRANSFER_ENCODING_CHUNKED = Portable.getBytes("Transfer-Encoding: chunked\r\n");
   private static byte[] SERVER = Portable.getBytes("Server: Jetty(6.0.x)\r\n");
   private static int CHUNK_SPACE = 12;
   private boolean _bypass = false;
   private boolean _needCRLF = false;
   private boolean _needEOC = false;
   private boolean _bufferChunked = false;

   public static void setServerVersion(String version) {
      SERVER = Portable.getBytes("Server: Jetty(" + version + ")\r\n");
   }

   public HttpGenerator(Buffers buffers, EndPoint io, int headerBufferSize, int contentBufferSize) {
      super(buffers, io, headerBufferSize, contentBufferSize);
   }

   public void reset(boolean returnBuffers) {
      super.reset(returnBuffers);
      this._bypass = false;
      this._needCRLF = false;
      this._needEOC = false;
      this._bufferChunked = false;
      this._method = null;
      this._uri = null;
      this._noContent = false;
   }

   public void addContent(Buffer content, boolean last) throws IOException {
      if (this._noContent) {
         throw new IllegalStateException("NO CONTENT");
      } else if (!this._last && this._state != 4) {
         this._last = last;
         if (this._content != null && this._content.length() > 0 || this._bufferChunked) {
            if (!this._endp.isOpen()) {
               throw new EofException();
            }

            this.flush();
            if (this._content != null && this._content.length() > 0 || this._bufferChunked) {
               throw new IllegalStateException("FULL");
            }
         }

         this._content = content;
         this._contentWritten += (long)content.length();
         if (this._head) {
            content.clear();
            this._content = null;
         } else if (this._endp != null && this._buffer == null && content.length() > 0 && this._last) {
            this._bypass = true;
         } else {
            if (this._buffer == null) {
               this._buffer = this._buffers.getBuffer(this._contentBufferSize);
            }

            int len = this._buffer.put(this._content);
            this._content.skip(len);
            if (this._content.length() == 0) {
               this._content = null;
            }
         }

      } else {
         Log.debug("Ignoring extra content {}", content);
         content.clear();
      }
   }

   public void sendResponse(Buffer response) throws IOException {
      if (!this._noContent && this._state == 0 && (this._content == null || this._content.length() <= 0) && !this._bufferChunked && !this._head) {
         this._last = true;
         this._content = response;
         this._bypass = true;
         this._state = 3;
         this._contentLength = this._contentWritten = (long)response.length();
      } else {
         throw new IllegalStateException();
      }
   }

   public boolean addContent(byte b) throws IOException {
      if (this._noContent) {
         throw new IllegalStateException("NO CONTENT");
      } else if (!this._last && this._state != 4) {
         if (this._content != null && this._content.length() > 0 || this._bufferChunked) {
            this.flush();
            if (this._content != null && this._content.length() > 0 || this._bufferChunked) {
               throw new IllegalStateException("FULL");
            }
         }

         ++this._contentWritten;
         if (this._head) {
            return false;
         } else {
            if (this._buffer == null) {
               this._buffer = this._buffers.getBuffer(this._contentBufferSize);
            }

            this._buffer.put(b);
            return this._buffer.space() <= (this._contentLength == -2L ? CHUNK_SPACE : 0);
         }
      } else {
         Log.debug("Ignoring extra content {}", new Byte(b));
         return false;
      }
   }

   protected int prepareUncheckedAddContent() throws IOException {
      if (this._noContent) {
         return -1;
      } else if (!this._last && this._state != 4) {
         Buffer content = this._content;
         if (content != null && content.length() > 0 || this._bufferChunked) {
            this.flush();
            if (content != null && content.length() > 0 || this._bufferChunked) {
               throw new IllegalStateException("FULL");
            }
         }

         if (this._buffer == null) {
            this._buffer = this._buffers.getBuffer(this._contentBufferSize);
         }

         this._contentWritten -= (long)this._buffer.length();
         if (this._head) {
            return Integer.MAX_VALUE;
         } else {
            return this._buffer.space() - (this._contentLength == -2L ? CHUNK_SPACE : 0);
         }
      } else {
         return -1;
      }
   }

   public boolean isBufferFull() {
      boolean full = super.isBufferFull() || this._bufferChunked || this._bypass || this._contentLength == -2L && this._buffer != null && this._buffer.space() < CHUNK_SPACE;
      return full;
   }

   public void completeHeader(HttpFields fields, boolean allContentAdded) throws IOException {
      if (this._state == 0) {
         if (this._method == null && this._status == 0) {
            throw new EofException();
         } else if (this._last && !allContentAdded) {
            throw new IllegalStateException("last?");
         } else {
            this._last |= allContentAdded;
            if (this._header == null) {
               this._header = this._buffers.getBuffer(this._headerBufferSize);
            }

            boolean has_server = false;
            if (this._method != null) {
               this._close = false;
               if (this._version == 9) {
                  this._contentLength = 0L;
                  this._header.put(this._method);
                  this._header.put((byte)32);
                  this._header.put(this._uri.getBytes("utf-8"));
                  this._header.put(HttpTokens.CRLF);
                  this._state = 3;
                  this._noContent = true;
                  return;
               }

               this._header.put(this._method);
               this._header.put((byte)32);
               this._header.put(this._uri.getBytes("utf-8"));
               this._header.put((byte)32);
               this._header.put(this._version == 10 ? HttpVersions.HTTP_1_0_BUFFER : HttpVersions.HTTP_1_1_BUFFER);
               this._header.put(HttpTokens.CRLF);
            } else {
               if (this._version == 9) {
                  this._close = true;
                  this._contentLength = -1L;
                  this._state = 2;
                  return;
               }

               if (this._version == 10) {
                  this._close = true;
               }

               Buffer line = HttpStatus.getResponseLine(this._status);
               if (line == null) {
                  if (this._reason == null) {
                     this._reason = getReasonBuffer(this._status);
                  }

                  this._header.put(HttpVersions.HTTP_1_1_BUFFER);
                  this._header.put((byte)32);
                  this._header.put((byte)(48 + this._status / 100));
                  this._header.put((byte)(48 + this._status % 100 / 10));
                  this._header.put((byte)(48 + this._status % 10));
                  this._header.put((byte)32);
                  if (this._reason == null) {
                     this._header.put((byte)(48 + this._status / 100));
                     this._header.put((byte)(48 + this._status % 100 / 10));
                     this._header.put((byte)(48 + this._status % 10));
                  } else {
                     this._header.put(this._reason);
                  }

                  this._header.put(HttpTokens.CRLF);
               } else if (this._reason == null) {
                  this._header.put(line);
               } else {
                  this._header.put(line.array(), 0, HttpVersions.HTTP_1_1_BUFFER.length() + 5);
                  this._header.put(this._reason);
                  this._header.put(HttpTokens.CRLF);
               }

               if (this._status < 200 && this._status >= 100) {
                  this._noContent = true;
                  this._content = null;
                  if (this._buffer != null) {
                     this._buffer.clear();
                  }

                  this._header.put(HttpTokens.CRLF);
                  this._state = 2;
                  return;
               }

               if (this._status == 204 || this._status == 304) {
                  this._noContent = true;
                  this._content = null;
                  if (this._buffer != null) {
                     this._buffer.clear();
                  }
               }
            }

            HttpFields.Field content_length = null;
            HttpFields.Field transfer_encoding = null;
            boolean keep_alive = false;
            boolean close = false;
            boolean content_type = false;
            StringBuffer connection = null;
            if (fields != null) {
               Iterator iter = fields.getFields();

               label294:
               while(true) {
                  label292:
                  while(true) {
                     if (!iter.hasNext()) {
                        break label294;
                     }

                     HttpFields.Field field = (HttpFields.Field)iter.next();
                     switch(field.getNameOrdinal()) {
                     case 1:
                        if (this._method != null) {
                           field.put(this._header);
                        }

                        int connection_value = field.getValueOrdinal();
                        switch(connection_value) {
                        case -1:
                           QuotedStringTokenizer tok = new QuotedStringTokenizer(field.getValue(), ",");

                           while(true) {
                              if (!tok.hasMoreTokens()) {
                                 continue label292;
                              }

                              String token = tok.nextToken().trim();
                              BufferCache.CachedBuffer cb = HttpHeaderValues.CACHE.get(token);
                              if (cb != null) {
                                 switch(cb.getOrdinal()) {
                                 case 1:
                                    close = true;
                                    if (this._method == null) {
                                       this._close = true;
                                    }

                                    keep_alive = false;
                                    if (this._close && this._method == null && this._contentLength == -3L) {
                                       this._contentLength = -1L;
                                    }
                                    break;
                                 case 5:
                                    if (this._version == 10) {
                                       keep_alive = true;
                                       if (this._method == null) {
                                          this._close = false;
                                       }
                                    }
                                    break;
                                 default:
                                    if (connection == null) {
                                       connection = new StringBuffer();
                                    } else {
                                       connection.append(',');
                                    }

                                    connection.append(token);
                                 }
                              } else {
                                 if (connection == null) {
                                    connection = new StringBuffer();
                                 } else {
                                    connection.append(',');
                                 }

                                 connection.append(token);
                              }
                           }
                        case 1:
                           close = true;
                           if (this._method == null) {
                              this._close = true;
                           }

                           if (this._close && this._method == null && this._contentLength == -3L) {
                              this._contentLength = -1L;
                           }
                           continue;
                        case 5:
                           if (this._version == 10) {
                              keep_alive = true;
                              if (this._method == null) {
                                 this._close = false;
                              }
                           }
                           continue;
                        default:
                           if (connection == null) {
                              connection = new StringBuffer();
                           } else {
                              connection.append(',');
                           }

                           connection.append(field.getValue());
                           continue;
                        }
                     case 5:
                        if (this._version == 11) {
                           transfer_encoding = field;
                        }
                        break;
                     case 12:
                        content_length = field;
                        this._contentLength = field.getLongValue();
                        if (this._contentLength < this._contentWritten || this._last && this._contentLength != this._contentWritten) {
                           content_length = null;
                        }

                        field.put(this._header);
                        break;
                     case 16:
                        if (BufferUtil.isPrefix(MimeTypes.MULTIPART_BYTERANGES_BUFFER, field.getValueBuffer())) {
                           this._contentLength = -4L;
                        }

                        content_type = true;
                        field.put(this._header);
                        break;
                     case 48:
                        if (this.getSendServerVersion()) {
                           has_server = true;
                           field.put(this._header);
                        }
                        break;
                     default:
                        field.put(this._header);
                     }
                  }
               }
            }

            switch((int)this._contentLength) {
            case -3:
               if (this._contentWritten != 0L || this._method != null || this._status >= 200 && this._status != 204 && this._status != 304) {
                  if (this._last) {
                     this._contentLength = this._contentWritten;
                     if (content_length == null && (this._method == null || content_type || this._contentLength > 0L)) {
                        this._header.put(HttpHeaders.CONTENT_LENGTH_BUFFER);
                        this._header.put((byte)58);
                        this._header.put((byte)32);
                        BufferUtil.putDecLong(this._header, this._contentLength);
                        this._header.put(HttpTokens.CRLF);
                     }
                  } else {
                     this._contentLength = !this._close && this._version >= 11 ? -2L : -1L;
                     if (this._method != null && this._contentLength == -1L) {
                        this._contentLength = 0L;
                        this._noContent = true;
                     }
                  }
               } else {
                  this._contentLength = 0L;
               }
            case -2:
            default:
               break;
            case -1:
               this._close = this._method == null;
               break;
            case 0:
               if (content_length == null && this._method == null && this._status >= 200 && this._status != 204 && this._status != 304) {
                  this._header.put(CONTENT_LENGTH_0);
               }
            }

            if (this._contentLength == -2L) {
               if (transfer_encoding != null && 2 != transfer_encoding.getValueOrdinal()) {
                  String c = transfer_encoding.getValue();
                  if (!c.endsWith("chunked")) {
                     throw new IllegalArgumentException("BAD TE");
                  }

                  transfer_encoding.put(this._header);
               } else {
                  this._header.put(TRANSFER_ENCODING_CHUNKED);
               }
            }

            if (this._contentLength == -1L) {
               keep_alive = false;
               this._close = true;
            }

            if (this._method == null) {
               if (this._close && (close || this._version > 10)) {
                  this._header.put(CONNECTION_CLOSE);
                  if (connection != null) {
                     this._header.setPutIndex(this._header.putIndex() - 2);
                     this._header.put((byte)44);
                     this._header.put(connection.toString().getBytes());
                     this._header.put(CRLF);
                  }
               } else if (keep_alive) {
                  this._header.put(CONNECTION_KEEP_ALIVE);
                  if (connection != null) {
                     this._header.setPutIndex(this._header.putIndex() - 2);
                     this._header.put((byte)44);
                     this._header.put(connection.toString().getBytes());
                     this._header.put(CRLF);
                  }
               } else if (connection != null) {
                  this._header.put(CONNECTION_);
                  this._header.put(connection.toString().getBytes());
                  this._header.put(CRLF);
               }
            }

            if (!has_server && this._status > 100 && this.getSendServerVersion()) {
               this._header.put(SERVER);
            }

            this._header.put(HttpTokens.CRLF);
            this._state = 2;
         }
      }
   }

   public void complete() throws IOException {
      if (this._state != 4) {
         super.complete();
         if (this._state < 3) {
            this._state = 3;
            if (this._contentLength == -2L) {
               this._needEOC = true;
            }
         }

         this.flush();
      }
   }

   public long flush() throws IOException {
      try {
         if (this._state == 0) {
            throw new IllegalStateException("State==HEADER");
         } else {
            this.prepareBuffers();
            if (this._endp == null) {
               if (this._needCRLF && this._buffer != null) {
                  this._buffer.put(HttpTokens.CRLF);
               }

               if (this._needEOC && this._buffer != null && !this._head) {
                  this._buffer.put(LAST_CHUNK);
               }

               this._needCRLF = false;
               this._needEOC = false;
               return 0L;
            } else {
               int total = 0;
               long var2 = -1L;

               while(true) {
                  int len = -1;
                  int to_flush = (this._header != null && this._header.length() > 0 ? 4 : 0) | (this._buffer != null && this._buffer.length() > 0 ? 2 : 0) | (this._bypass && this._content != null && this._content.length() > 0 ? 1 : 0);
                  switch(to_flush) {
                  case 0:
                     if (this._header != null) {
                        this._header.clear();
                     }

                     this._bypass = false;
                     this._bufferChunked = false;
                     if (this._buffer != null) {
                        this._buffer.clear();
                        if (this._contentLength == -2L) {
                           this._buffer.setPutIndex(CHUNK_SPACE);
                           this._buffer.setGetIndex(CHUNK_SPACE);
                           if (this._content != null && this._content.length() < this._buffer.space() && this._state != 3) {
                              this._buffer.put(this._content);
                              this._content.clear();
                              this._content = null;
                              return (long)total;
                           }
                        }
                     }

                     if (!this._needCRLF && !this._needEOC && (this._content == null || this._content.length() == 0)) {
                        if (this._state == 3) {
                           this._state = 4;
                        }

                        if (this._state == 4 && this._close && this._status != 100) {
                           this._endp.shutdownOutput();
                        }

                        return (long)total;
                     }

                     this.prepareBuffers();
                     break;
                  case 1:
                     len = this._endp.flush(this._content);
                     break;
                  case 2:
                     len = this._endp.flush(this._buffer);
                     break;
                  case 3:
                     throw new IllegalStateException();
                  case 4:
                     len = this._endp.flush(this._header);
                     break;
                  case 5:
                     len = this._endp.flush(this._header, this._content, (Buffer)null);
                     break;
                  case 6:
                     len = this._endp.flush(this._header, this._buffer, (Buffer)null);
                     break;
                  case 7:
                     throw new IllegalStateException();
                  }

                  if (len <= 0) {
                     return (long)total;
                  }

                  total += len;
                  var2 = (long)len;
               }
            }
         }
      } catch (IOException var6) {
         Log.ignore(var6);
         throw var6 instanceof EofException ? var6 : new EofException(var6);
      }
   }

   private void prepareBuffers() {
      if (!this._bufferChunked) {
         int size;
         if (this._content != null && this._content.length() > 0 && this._buffer != null && this._buffer.space() > 0) {
            size = this._buffer.put(this._content);
            this._content.skip(size);
            if (this._content.length() == 0) {
               this._content = null;
            }
         }

         if (this._contentLength == -2L) {
            size = this._buffer == null ? 0 : this._buffer.length();
            if (size > 0) {
               this._bufferChunked = true;
               if (this._buffer.getIndex() == CHUNK_SPACE) {
                  this._buffer.poke(this._buffer.getIndex() - 2, HttpTokens.CRLF, 0, 2);
                  this._buffer.setGetIndex(this._buffer.getIndex() - 2);
                  BufferUtil.prependHexInt(this._buffer, size);
                  if (this._needCRLF) {
                     this._buffer.poke(this._buffer.getIndex() - 2, HttpTokens.CRLF, 0, 2);
                     this._buffer.setGetIndex(this._buffer.getIndex() - 2);
                     this._needCRLF = false;
                  }
               } else {
                  if (this._needCRLF) {
                     if (this._header.length() > 0) {
                        throw new IllegalStateException("EOC");
                     }

                     this._header.put(HttpTokens.CRLF);
                     this._needCRLF = false;
                  }

                  BufferUtil.putHexInt(this._header, size);
                  this._header.put(HttpTokens.CRLF);
               }

               if (this._buffer.space() >= 2) {
                  this._buffer.put(HttpTokens.CRLF);
               } else {
                  this._needCRLF = true;
               }
            }

            if (this._needEOC && (this._content == null || this._content.length() == 0)) {
               if (this._needCRLF) {
                  if (this._buffer == null && this._header.space() >= 2) {
                     this._header.put(HttpTokens.CRLF);
                     this._needCRLF = false;
                  } else if (this._buffer != null && this._buffer.space() >= 2) {
                     this._buffer.put(HttpTokens.CRLF);
                     this._needCRLF = false;
                  }
               }

               if (!this._needCRLF && this._needEOC) {
                  if (this._buffer == null && this._header.space() >= LAST_CHUNK.length) {
                     if (!this._head) {
                        this._header.put(LAST_CHUNK);
                        this._bufferChunked = true;
                     }

                     this._needEOC = false;
                  } else if (this._buffer != null && this._buffer.space() >= LAST_CHUNK.length) {
                     if (!this._head) {
                        this._buffer.put(LAST_CHUNK);
                        this._bufferChunked = true;
                     }

                     this._needEOC = false;
                  }
               }
            }
         }
      }

      if (this._content != null && this._content.length() == 0) {
         this._content = null;
      }

   }

   public int getBytesBuffered() {
      return (this._header == null ? 0 : this._header.length()) + (this._buffer == null ? 0 : this._buffer.length()) + (this._content == null ? 0 : this._content.length());
   }

   public boolean isEmpty() {
      return (this._header == null || this._header.length() == 0) && (this._buffer == null || this._buffer.length() == 0) && (this._content == null || this._content.length() == 0);
   }

   public String toString() {
      return "HttpGenerator s=" + this._state + " h=" + (this._header == null ? "null" : "" + this._header.length()) + " b=" + (this._buffer == null ? "null" : "" + this._buffer.length()) + " c=" + (this._content == null ? "null" : "" + this._content.length());
   }
}
