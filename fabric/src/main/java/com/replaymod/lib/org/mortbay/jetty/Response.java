package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.BufferCache;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.jetty.handler.ErrorHandler;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.ByteArrayISO8859Writer;
import com.replaymod.lib.org.mortbay.util.IO;
import com.replaymod.lib.org.mortbay.util.QuotedStringTokenizer;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Response implements HttpServletResponse {
   public static final int DISABLED = -1;
   public static final int NONE = 0;
   public static final int STREAM = 1;
   public static final int WRITER = 2;
   private static PrintWriter __nullPrintWriter;
   private static ServletOutputStream __nullServletOut;
   private HttpConnection _connection;
   private int _status = 200;
   private String _reason;
   private Locale _locale;
   private String _mimeType;
   private BufferCache.CachedBuffer _cachedMimeType;
   private String _characterEncoding;
   private boolean _explicitEncoding;
   private String _contentType;
   private int _outputState;
   private PrintWriter _writer;

   public Response(HttpConnection connection) {
      this._connection = connection;
   }

   protected void recycle() {
      this._status = 200;
      this._reason = null;
      this._locale = null;
      this._mimeType = null;
      this._cachedMimeType = null;
      this._characterEncoding = null;
      this._explicitEncoding = false;
      this._contentType = null;
      this._outputState = 0;
      this._writer = null;
   }

   public void addCookie(Cookie cookie) {
      this._connection.getResponseFields().addSetCookie(cookie);
   }

   public boolean containsHeader(String name) {
      return this._connection.getResponseFields().containsKey(name);
   }

   public String encodeURL(String url) {
      Request request = this._connection.getRequest();
      SessionManager sessionManager = request.getSessionManager();
      if (sessionManager == null) {
         return url;
      } else {
         String sessionURLPrefix = sessionManager.getSessionURLPrefix();
         if (sessionURLPrefix == null) {
            return url;
         } else if (url != null && request != null && !request.isRequestedSessionIdFromCookie()) {
            HttpSession session = request.getSession(false);
            if (session == null) {
               return url;
            } else if (!sessionManager.isValid(session)) {
               return url;
            } else {
               String id = sessionManager.getNodeId(session);
               int prefix = url.indexOf(sessionURLPrefix);
               int suffix;
               if (prefix != -1) {
                  suffix = url.indexOf("?", prefix);
                  if (suffix < 0) {
                     suffix = url.indexOf("#", prefix);
                  }

                  return suffix <= prefix ? url.substring(0, prefix + sessionURLPrefix.length()) + id : url.substring(0, prefix + sessionURLPrefix.length()) + id + url.substring(suffix);
               } else {
                  suffix = url.indexOf(63);
                  if (suffix < 0) {
                     suffix = url.indexOf(35);
                  }

                  return suffix < 0 ? url + sessionURLPrefix + id : url.substring(0, suffix) + sessionURLPrefix + id + url.substring(suffix);
               }
            }
         } else {
            int prefix = url.indexOf(sessionURLPrefix);
            if (prefix != -1) {
               int suffix = url.indexOf("?", prefix);
               if (suffix < 0) {
                  suffix = url.indexOf("#", prefix);
               }

               return suffix <= prefix ? url.substring(0, prefix) : url.substring(0, prefix) + url.substring(suffix);
            } else {
               return url;
            }
         }
      }
   }

   public String encodeRedirectURL(String url) {
      return this.encodeURL(url);
   }

   public String encodeUrl(String url) {
      return this.encodeURL(url);
   }

   public String encodeRedirectUrl(String url) {
      return this.encodeURL(url);
   }

   public void sendError(int code, String message) throws IOException {
      if (!this._connection.isIncluding()) {
         if (this.isCommitted()) {
            Log.warn("Committed before " + code + " " + message);
         }

         this.resetBuffer();
         this._characterEncoding = null;
         this.setHeader("Expires", (String)null);
         this.setHeader("Last-Modified", (String)null);
         this.setHeader("Cache-Control", (String)null);
         this.setHeader("Content-Type", (String)null);
         this.setHeader("Content-Length", (String)null);
         this._outputState = 0;
         this.setStatus(code, message);
         if (message == null) {
            message = HttpGenerator.getReason(code);
         }

         if (code != 204 && code != 304 && code != 206 && code >= 200) {
            Request request = this._connection.getRequest();
            ErrorHandler error_handler = null;
            ContextHandler.SContext context = request.getContext();
            if (context != null) {
               error_handler = context.getContextHandler().getErrorHandler();
            }

            if (error_handler != null) {
               request.setAttribute("javax.servlet.error.status_code", new Integer(code));
               request.setAttribute("javax.servlet.error.message", message);
               request.setAttribute("javax.servlet.error.request_uri", request.getRequestURI());
               request.setAttribute("javax.servlet.error.servlet_name", request.getServletName());
               error_handler.handle((String)null, this._connection.getRequest(), this, 8);
            } else {
               this.setHeader("Cache-Control", "must-revalidate,no-cache,no-store");
               this.setContentType("text/html; charset=iso-8859-1");
               ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer(2048);
               if (message != null) {
                  message = StringUtil.replace(message, "&", "&amp;");
                  message = StringUtil.replace(message, "<", "&lt;");
                  message = StringUtil.replace(message, ">", "&gt;");
               }

               String uri = request.getRequestURI();
               if (uri != null) {
                  uri = StringUtil.replace(uri, "&", "&amp;");
                  uri = StringUtil.replace(uri, "<", "&lt;");
                  uri = StringUtil.replace(uri, ">", "&gt;");
               }

               writer.write("<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>\n");
               writer.write("<title>Error ");
               writer.write(Integer.toString(code));
               writer.write(' ');
               if (message == null) {
                  message = HttpGenerator.getReason(code);
               }

               writer.write(message);
               writer.write("</title>\n</head>\n<body>\n<h2>HTTP ERROR: ");
               writer.write(Integer.toString(code));
               writer.write("</h2>\n<p>Problem accessing ");
               writer.write(uri);
               writer.write(". Reason:\n<pre>    ");
               writer.write(message);
               writer.write("</pre>");
               writer.write("</p>\n<hr /><i><small>Powered by Jetty://</small></i>");

               for(int i = 0; i < 20; ++i) {
                  writer.write("\n                                                ");
               }

               writer.write("\n</body>\n</html>\n");
               writer.flush();
               this.setContentLength(writer.size());
               writer.writeTo(this.getOutputStream());
               writer.destroy();
            }
         } else if (code != 206) {
            this._connection.getRequestFields().remove(HttpHeaders.CONTENT_TYPE_BUFFER);
            this._connection.getRequestFields().remove(HttpHeaders.CONTENT_LENGTH_BUFFER);
            this._characterEncoding = null;
            this._mimeType = null;
            this._cachedMimeType = null;
         }

         this.complete();
      }
   }

   public void sendError(int sc) throws IOException {
      if (sc == 102) {
         this.sendProcessing();
      } else {
         this.sendError(sc, (String)null);
      }

   }

   public void sendProcessing() throws IOException {
      Generator g = this._connection.getGenerator();
      if (g instanceof HttpGenerator) {
         HttpGenerator generator = (HttpGenerator)g;
         String expect = this._connection.getRequest().getHeader("Expect");
         if (expect != null && expect.startsWith("102") && generator.getVersion() >= 11) {
            boolean was_persistent = generator.isPersistent();
            generator.setResponse(102, (String)null);
            generator.completeHeader((HttpFields)null, true);
            generator.setPersistent(true);
            generator.complete();
            generator.flush();
            generator.reset(false);
            generator.setPersistent(was_persistent);
         }
      }

   }

   public void sendRedirect(String location) throws IOException {
      if (!this._connection.isIncluding()) {
         if (location == null) {
            throw new IllegalArgumentException();
         } else {
            if (!URIUtil.hasScheme(location)) {
               StringBuffer buf = this._connection.getRequest().getRootURL();
               String path;
               if (location.startsWith("/")) {
                  buf.append(location);
               } else {
                  String path = this._connection.getRequest().getRequestURI();
                  path = path.endsWith("/") ? path : URIUtil.parentPath(path);
                  location = URIUtil.addPaths(path, location);
                  if (location == null) {
                     throw new IllegalStateException("path cannot be above root");
                  }

                  if (!location.startsWith("/")) {
                     buf.append('/');
                  }

                  buf.append(location);
               }

               location = buf.toString();
               HttpURI uri = new HttpURI(location);
               path = uri.getDecodedPath();
               String canonical = URIUtil.canonicalPath(path);
               if (canonical == null) {
                  throw new IllegalArgumentException();
               }

               if (!canonical.equals(path)) {
                  buf = this._connection.getRequest().getRootURL();
                  buf.append(canonical);
                  if (uri.getQuery() != null) {
                     buf.append('?');
                     buf.append(uri.getQuery());
                  }

                  if (uri.getFragment() != null) {
                     buf.append('#');
                     buf.append(uri.getFragment());
                  }

                  location = buf.toString();
               }
            }

            this.resetBuffer();
            this.setHeader("Location", location);
            this.setStatus(302);
            this.complete();
         }
      }
   }

   public void setDateHeader(String name, long date) {
      if (!this._connection.isIncluding()) {
         this._connection.getResponseFields().putDateField(name, date);
      }

   }

   public void addDateHeader(String name, long date) {
      if (!this._connection.isIncluding()) {
         this._connection.getResponseFields().addDateField(name, date);
      }

   }

   public void setHeader(String name, String value) {
      if (!this._connection.isIncluding()) {
         this._connection.getResponseFields().put(name, value);
         if ("Content-Length".equalsIgnoreCase(name)) {
            if (value == null) {
               this._connection._generator.setContentLength(-1L);
            } else {
               this._connection._generator.setContentLength(Long.parseLong(value));
            }
         }
      }

   }

   public String getHeader(String name) {
      return this._connection.getResponseFields().getStringField(name);
   }

   public Enumeration getHeaders(String name) {
      Enumeration e = this._connection.getResponseFields().getValues(name);
      return e == null ? Collections.enumeration(Collections.EMPTY_LIST) : e;
   }

   public void addHeader(String name, String value) {
      if (!this._connection.isIncluding()) {
         this._connection.getResponseFields().add(name, value);
         if ("Content-Length".equalsIgnoreCase(name)) {
            this._connection._generator.setContentLength(Long.parseLong(value));
         }
      }

   }

   public void setIntHeader(String name, int value) {
      if (!this._connection.isIncluding()) {
         this._connection.getResponseFields().putLongField(name, (long)value);
         if ("Content-Length".equalsIgnoreCase(name)) {
            this._connection._generator.setContentLength((long)value);
         }
      }

   }

   public void addIntHeader(String name, int value) {
      if (!this._connection.isIncluding()) {
         this._connection.getResponseFields().addLongField(name, (long)value);
         if ("Content-Length".equalsIgnoreCase(name)) {
            this._connection._generator.setContentLength((long)value);
         }
      }

   }

   public void setStatus(int sc) {
      this.setStatus(sc, (String)null);
   }

   public void setStatus(int sc, String sm) {
      if (!this._connection.isIncluding()) {
         this._status = sc;
         this._reason = sm;
      }

   }

   public String getCharacterEncoding() {
      if (this._characterEncoding == null) {
         this._characterEncoding = StringUtil.__ISO_8859_1;
      }

      return this._characterEncoding;
   }

   String getSetCharacterEncoding() {
      return this._characterEncoding;
   }

   public String getContentType() {
      return this._contentType;
   }

   public ServletOutputStream getOutputStream() throws IOException {
      if (this._outputState == -1) {
         return __nullServletOut;
      } else if (this._outputState != 0 && this._outputState != 1) {
         throw new IllegalStateException("WRITER");
      } else {
         this._outputState = 1;
         return this._connection.getOutputStream();
      }
   }

   public boolean isWriting() {
      return this._outputState == 2;
   }

   public PrintWriter getWriter() throws IOException {
      if (this._outputState == -1) {
         return __nullPrintWriter;
      } else if (this._outputState != 0 && this._outputState != 2) {
         throw new IllegalStateException("STREAM");
      } else {
         if (this._writer == null) {
            String encoding = this._characterEncoding;
            if (encoding == null) {
               if (this._mimeType != null) {
                  encoding = null;
               }

               if (encoding == null) {
                  encoding = StringUtil.__ISO_8859_1;
               }

               this.setCharacterEncoding(encoding);
            }

            this._writer = this._connection.getPrintWriter(encoding);
         }

         this._outputState = 2;
         return this._writer;
      }
   }

   public void setCharacterEncoding(String encoding) {
      if (!this._connection.isIncluding()) {
         if (this._outputState == 0 && !this.isCommitted()) {
            this._explicitEncoding = true;
            if (encoding == null) {
               if (this._characterEncoding != null) {
                  this._characterEncoding = null;
                  if (this._cachedMimeType != null) {
                     this._connection.getResponseFields().put((Buffer)HttpHeaders.CONTENT_TYPE_BUFFER, (Buffer)this._cachedMimeType);
                  } else {
                     this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._mimeType);
                  }
               }
            } else {
               this._characterEncoding = encoding;
               if (this._contentType != null) {
                  int i0 = this._contentType.indexOf(59);
                  if (i0 < 0) {
                     this._contentType = null;
                     if (this._cachedMimeType != null) {
                        BufferCache.CachedBuffer content_type = this._cachedMimeType.getAssociate(this._characterEncoding);
                        if (content_type != null) {
                           this._contentType = content_type.toString();
                           this._connection.getResponseFields().put((Buffer)HttpHeaders.CONTENT_TYPE_BUFFER, (Buffer)content_type);
                        }
                     }

                     if (this._contentType == null) {
                        this._contentType = this._mimeType + "; charset=" + QuotedStringTokenizer.quote(this._characterEncoding, ";= ");
                        this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                     }
                  } else {
                     int i1 = this._contentType.indexOf("charset=", i0);
                     if (i1 < 0) {
                        this._contentType = this._contentType + "; charset=" + QuotedStringTokenizer.quote(this._characterEncoding, ";= ");
                     } else {
                        int i8 = i1 + 8;
                        int i2 = this._contentType.indexOf(" ", i8);
                        if (i2 < 0) {
                           this._contentType = this._contentType.substring(0, i8) + QuotedStringTokenizer.quote(this._characterEncoding, ";= ");
                        } else {
                           this._contentType = this._contentType.substring(0, i8) + QuotedStringTokenizer.quote(this._characterEncoding, ";= ") + this._contentType.substring(i2);
                        }
                     }

                     this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                  }
               }
            }
         }

      }
   }

   public void setContentLength(int len) {
      if (!this.isCommitted() && !this._connection.isIncluding()) {
         this._connection._generator.setContentLength((long)len);
         if (len >= 0) {
            this._connection.getResponseFields().putLongField("Content-Length", (long)len);
            if (this._connection._generator.isContentWritten()) {
               if (this._outputState == 2) {
                  this._writer.close();
               } else if (this._outputState == 1) {
                  try {
                     this.getOutputStream().close();
                  } catch (IOException var3) {
                     throw new RuntimeException(var3);
                  }
               }
            }
         }

      }
   }

   public void setLongContentLength(long len) {
      if (!this.isCommitted() && !this._connection.isIncluding()) {
         this._connection._generator.setContentLength(len);
         this._connection.getResponseFields().putLongField("Content-Length", len);
      }
   }

   public void setContentType(String contentType) {
      if (!this.isCommitted() && !this._connection.isIncluding()) {
         if (contentType == null) {
            if (this._locale == null) {
               this._characterEncoding = null;
            }

            this._mimeType = null;
            this._cachedMimeType = null;
            this._contentType = null;
            this._connection.getResponseFields().remove(HttpHeaders.CONTENT_TYPE_BUFFER);
         } else {
            int i0 = contentType.indexOf(59);
            if (i0 > 0) {
               this._mimeType = contentType.substring(0, i0).trim();
               this._cachedMimeType = MimeTypes.CACHE.get(this._mimeType);
               int i1 = contentType.indexOf("charset=", i0 + 1);
               if (i1 >= 0) {
                  this._explicitEncoding = true;
                  int i8 = i1 + 8;
                  int i2 = contentType.indexOf(32, i8);
                  BufferCache.CachedBuffer content_type;
                  if (this._outputState == 2) {
                     if (i1 == i0 + 1 && i2 < 0 || i1 == i0 + 2 && i2 < 0 && contentType.charAt(i0 + 1) == ' ') {
                        if (this._cachedMimeType != null) {
                           content_type = this._cachedMimeType.getAssociate(this._characterEncoding);
                           if (content_type != null) {
                              this._contentType = content_type.toString();
                              this._connection.getResponseFields().put((Buffer)HttpHeaders.CONTENT_TYPE_BUFFER, (Buffer)content_type);
                           } else {
                              this._contentType = this._mimeType + "; charset=" + this._characterEncoding;
                              this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                           }
                        } else {
                           this._contentType = this._mimeType + "; charset=" + this._characterEncoding;
                           this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                        }
                     } else if (i2 < 0) {
                        this._contentType = contentType.substring(0, i1) + " charset=" + QuotedStringTokenizer.quote(this._characterEncoding, ";= ");
                        this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                     } else {
                        this._contentType = contentType.substring(0, i1) + contentType.substring(i2) + " charset=" + QuotedStringTokenizer.quote(this._characterEncoding, ";= ");
                        this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                     }
                  } else if (i1 == i0 + 1 && i2 < 0 || i1 == i0 + 2 && i2 < 0 && contentType.charAt(i0 + 1) == ' ') {
                     this._cachedMimeType = MimeTypes.CACHE.get(this._mimeType);
                     this._characterEncoding = QuotedStringTokenizer.unquote(contentType.substring(i8));
                     if (this._cachedMimeType != null) {
                        content_type = this._cachedMimeType.getAssociate(this._characterEncoding);
                        if (content_type != null) {
                           this._contentType = content_type.toString();
                           this._connection.getResponseFields().put((Buffer)HttpHeaders.CONTENT_TYPE_BUFFER, (Buffer)content_type);
                        } else {
                           this._contentType = contentType;
                           this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                        }
                     } else {
                        this._contentType = contentType;
                        this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                     }
                  } else if (i2 > 0) {
                     this._characterEncoding = QuotedStringTokenizer.unquote(contentType.substring(i8, i2));
                     this._contentType = contentType;
                     this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                  } else {
                     this._characterEncoding = QuotedStringTokenizer.unquote(contentType.substring(i8));
                     this._contentType = contentType;
                     this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                  }
               } else {
                  this._cachedMimeType = null;
                  this._contentType = this._characterEncoding == null ? contentType : contentType + "; charset=" + QuotedStringTokenizer.quote(this._characterEncoding, ";= ");
                  this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
               }
            } else {
               this._mimeType = contentType;
               this._cachedMimeType = MimeTypes.CACHE.get(this._mimeType);
               if (this._characterEncoding != null) {
                  if (this._cachedMimeType != null) {
                     BufferCache.CachedBuffer content_type = this._cachedMimeType.getAssociate(this._characterEncoding);
                     if (content_type != null) {
                        this._contentType = content_type.toString();
                        this._connection.getResponseFields().put((Buffer)HttpHeaders.CONTENT_TYPE_BUFFER, (Buffer)content_type);
                     } else {
                        this._contentType = this._mimeType + "; charset=" + QuotedStringTokenizer.quote(this._characterEncoding, ";= ");
                        this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                     }
                  } else {
                     this._contentType = contentType + "; charset=" + QuotedStringTokenizer.quote(this._characterEncoding, ";= ");
                     this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                  }
               } else if (this._cachedMimeType != null) {
                  this._contentType = this._cachedMimeType.toString();
                  this._connection.getResponseFields().put((Buffer)HttpHeaders.CONTENT_TYPE_BUFFER, (Buffer)this._cachedMimeType);
               } else {
                  this._contentType = contentType;
                  this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
               }
            }
         }

      }
   }

   public void setBufferSize(int size) {
      if (!this.isCommitted() && this.getContentCount() <= 0L) {
         this._connection.getGenerator().increaseContentBufferSize(size);
      } else {
         throw new IllegalStateException("Committed or content written");
      }
   }

   public int getBufferSize() {
      return this._connection.getGenerator().getContentBufferSize();
   }

   public void flushBuffer() throws IOException {
      this._connection.flushResponse();
   }

   public void reset() {
      this.resetBuffer();
      HttpFields response_fields = this._connection.getResponseFields();
      response_fields.clear();
      String connection = this._connection.getRequestFields().getStringField(HttpHeaders.CONNECTION_BUFFER);
      if (connection != null) {
         QuotedStringTokenizer tok = new QuotedStringTokenizer(connection, ",");

         while(tok.hasMoreTokens()) {
            BufferCache.CachedBuffer cb = HttpHeaderValues.CACHE.get(tok.nextToken().trim());
            if (cb != null) {
               switch(cb.getOrdinal()) {
               case 1:
                  response_fields.put(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.CLOSE_BUFFER);
                  break;
               case 5:
                  if ("HTTP/1.0".equalsIgnoreCase(this._connection.getRequest().getProtocol())) {
                     response_fields.put(HttpHeaders.CONNECTION_BUFFER, "keep-alive");
                  }
                  break;
               case 8:
                  response_fields.put(HttpHeaders.CONNECTION_BUFFER, "TE");
               }
            }
         }
      }

      if (this._connection.getConnector().getServer().getSendDateHeader()) {
         Request request = this._connection.getRequest();
         response_fields.put(HttpHeaders.DATE_BUFFER, request.getTimeStampBuffer(), request.getTimeStamp());
      }

      this._status = 200;
      this._reason = null;
      this._mimeType = null;
      this._cachedMimeType = null;
      this._contentType = null;
      this._characterEncoding = null;
      this._explicitEncoding = false;
      this._locale = null;
      this._outputState = 0;
      this._writer = null;
   }

   public void resetBuffer() {
      if (this.isCommitted()) {
         throw new IllegalStateException("Committed");
      } else {
         this._connection.getGenerator().resetBuffer();
      }
   }

   public boolean isCommitted() {
      return this._connection.isResponseCommitted();
   }

   public void setLocale(Locale locale) {
      if (locale != null && !this.isCommitted() && !this._connection.isIncluding()) {
         this._locale = locale;
         this._connection.getResponseFields().put(HttpHeaders.CONTENT_LANGUAGE_BUFFER, locale.toString().replace('_', '-'));
         if (!this._explicitEncoding && this._outputState == 0) {
            if (this._connection.getRequest().getContext() != null) {
               String charset = this._connection.getRequest().getContext().getContextHandler().getLocaleEncoding(locale);
               if (charset != null && charset.length() > 0) {
                  this._characterEncoding = charset;
                  String type = this.getContentType();
                  if (type != null) {
                     this._characterEncoding = charset;
                     int semi = type.indexOf(59);
                     if (semi < 0) {
                        this._mimeType = type;
                        this._contentType = type + "; charset=" + charset;
                     } else {
                        this._mimeType = type.substring(0, semi);
                        this._contentType = this._mimeType = this._mimeType + "; charset=" + charset;
                     }

                     this._cachedMimeType = MimeTypes.CACHE.get(this._mimeType);
                     this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
                  }
               }

            }
         }
      }
   }

   public Locale getLocale() {
      return this._locale == null ? Locale.getDefault() : this._locale;
   }

   public int getStatus() {
      return this._status;
   }

   public String getReason() {
      return this._reason;
   }

   public void complete() throws IOException {
      this._connection.completeResponse();
   }

   public long getContentCount() {
      return this._connection != null && this._connection.getGenerator() != null ? this._connection.getGenerator().getContentWritten() : -1L;
   }

   public HttpFields getHttpFields() {
      return this._connection.getResponseFields();
   }

   public String toString() {
      return "HTTP/1.1 " + this._status + " " + (this._reason == null ? "" : this._reason) + System.getProperty("line.separator") + this._connection.getResponseFields().toString();
   }

   static {
      try {
         __nullPrintWriter = new PrintWriter(IO.getNullWriter());
         __nullServletOut = new Response.NullOutput();
      } catch (Exception var1) {
         Log.warn((Throwable)var1);
      }

   }

   private static class NullOutput extends ServletOutputStream {
      private NullOutput() {
      }

      public void write(int b) throws IOException {
      }

      // $FF: synthetic method
      NullOutput(Object x0) {
         this();
      }
   }
}
