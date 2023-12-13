package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.BufferCache;
import com.replaymod.lib.org.mortbay.io.Connection;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import com.replaymod.lib.org.mortbay.io.RuntimeIOException;
import com.replaymod.lib.org.mortbay.io.nio.SelectChannelEndPoint;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.resource.Resource;
import com.replaymod.lib.org.mortbay.util.QuotedStringTokenizer;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import com.replaymod.lib.org.mortbay.util.ajax.Continuation;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;

public class HttpConnection implements Connection {
   private static int UNKNOWN = -2;
   private static ThreadLocal __currentConnection = new ThreadLocal();
   private long _timeStamp = System.currentTimeMillis();
   private int _requests;
   private boolean _handling;
   private boolean _destroy;
   protected final Connector _connector;
   protected final EndPoint _endp;
   protected final Server _server;
   protected final HttpURI _uri;
   protected final Parser _parser;
   protected final HttpFields _requestFields;
   protected final Request _request;
   protected ServletInputStream _in;
   protected final Generator _generator;
   protected final HttpFields _responseFields;
   protected final Response _response;
   protected HttpConnection.Output _out;
   protected HttpConnection.OutputWriter _writer;
   protected PrintWriter _printWriter;
   int _include;
   private Object _associatedObject;
   private transient int _expect;
   private transient int _version;
   private transient boolean _head;
   private transient boolean _host;
   private transient boolean _delayedHandling;

   public static HttpConnection getCurrentConnection() {
      return (HttpConnection)__currentConnection.get();
   }

   protected static void setCurrentConnection(HttpConnection connection) {
      __currentConnection.set(connection);
   }

   public HttpConnection(Connector connector, EndPoint endpoint, Server server) {
      this._expect = UNKNOWN;
      this._version = UNKNOWN;
      this._head = false;
      this._host = false;
      this._delayedHandling = false;
      this._uri = (HttpURI)(URIUtil.__CHARSET == "UTF-8" ? new HttpURI() : new EncodedHttpURI(URIUtil.__CHARSET));
      this._connector = connector;
      this._endp = endpoint;
      this._parser = new HttpParser(this._connector, endpoint, new HttpConnection.RequestHandler(), this._connector.getHeaderBufferSize(), this._connector.getRequestBufferSize());
      this._requestFields = new HttpFields();
      this._responseFields = new HttpFields();
      this._request = new Request(this);
      this._response = new Response(this);
      this._generator = new HttpGenerator(this._connector, this._endp, this._connector.getHeaderBufferSize(), this._connector.getResponseBufferSize());
      this._generator.setSendServerVersion(server.getSendServerVersion());
      this._server = server;
   }

   protected HttpConnection(Connector connector, EndPoint endpoint, Server server, Parser parser, Generator generator, Request request) {
      this._expect = UNKNOWN;
      this._version = UNKNOWN;
      this._head = false;
      this._host = false;
      this._delayedHandling = false;
      this._uri = (HttpURI)(URIUtil.__CHARSET == "UTF-8" ? new HttpURI() : new EncodedHttpURI(URIUtil.__CHARSET));
      this._connector = connector;
      this._endp = endpoint;
      this._parser = parser;
      this._requestFields = new HttpFields();
      this._responseFields = new HttpFields();
      this._request = request;
      this._response = new Response(this);
      this._generator = generator;
      this._generator.setSendServerVersion(server.getSendServerVersion());
      this._server = server;
   }

   public void destroy() {
      synchronized(this) {
         this._destroy = true;
         if (!this._handling) {
            if (this._parser != null) {
               this._parser.reset(true);
            }

            if (this._generator != null) {
               this._generator.reset(true);
            }

            if (this._requestFields != null) {
               this._requestFields.destroy();
            }

            if (this._responseFields != null) {
               this._responseFields.destroy();
            }
         }

      }
   }

   public Parser getParser() {
      return this._parser;
   }

   public int getRequests() {
      return this._requests;
   }

   public long getTimeStamp() {
      return this._timeStamp;
   }

   public Object getAssociatedObject() {
      return this._associatedObject;
   }

   public void setAssociatedObject(Object associatedObject) {
      this._associatedObject = associatedObject;
   }

   public Connector getConnector() {
      return this._connector;
   }

   public HttpFields getRequestFields() {
      return this._requestFields;
   }

   public HttpFields getResponseFields() {
      return this._responseFields;
   }

   public boolean isConfidential(Request request) {
      return this._connector != null ? this._connector.isConfidential(request) : false;
   }

   public boolean isIntegral(Request request) {
      return this._connector != null ? this._connector.isIntegral(request) : false;
   }

   public EndPoint getEndPoint() {
      return this._endp;
   }

   public boolean getResolveNames() {
      return this._connector.getResolveNames();
   }

   public Request getRequest() {
      return this._request;
   }

   public Response getResponse() {
      return this._response;
   }

   public ServletInputStream getInputStream() {
      if (this._in == null) {
         this._in = new HttpParser.Input((HttpParser)this._parser, (long)this._connector.getMaxIdleTime());
      }

      return this._in;
   }

   public ServletOutputStream getOutputStream() {
      if (this._out == null) {
         this._out = new HttpConnection.Output();
      }

      return this._out;
   }

   public PrintWriter getPrintWriter(String encoding) {
      this.getOutputStream();
      if (this._writer == null) {
         this._writer = new HttpConnection.OutputWriter();
         this._printWriter = new PrintWriter(this._writer) {
            public void close() {
               try {
                  this.out.close();
               } catch (IOException var2) {
                  Log.debug((Throwable)var2);
                  this.setError();
               }

            }
         };
      }

      this._writer.setCharacterEncoding(encoding);
      return this._printWriter;
   }

   public boolean isResponseCommitted() {
      return this._generator.isCommitted();
   }

   public void handle() throws IOException {
      boolean more_in_buffer = true;
      byte no_progress = 0;

      label459:
      while(true) {
         if (more_in_buffer) {
            label451: {
               boolean var23;
               try {
                  synchronized(this) {
                     if (this._handling) {
                        throw new IllegalStateException();
                     }

                     this._handling = true;
                  }

                  setCurrentConnection(this);
                  long io = 0L;
                  Continuation continuation = this._request.getContinuation();
                  if (continuation != null && continuation.isPending()) {
                     Log.debug("resume continuation {}", continuation);
                     if (this._request.getMethod() == null) {
                        throw new IllegalStateException();
                     }

                     this.handleRequest();
                     continue;
                  }

                  if (!this._parser.isComplete()) {
                     io = this._parser.parseAvailable();
                  }

                  while(true) {
                     if (this._generator.isCommitted() && !this._generator.isComplete()) {
                        long written = this._generator.flush();
                        io += written;
                        if (written > 0L) {
                           if (this._endp.isBufferingOutput()) {
                              this._endp.flush();
                           }
                           continue;
                        }
                     }

                     if (this._endp.isBufferingOutput()) {
                        this._endp.flush();
                        if (!this._endp.isBufferingOutput()) {
                           no_progress = 0;
                        }
                     }

                     if (io > 0L) {
                        var23 = false;
                        continue label459;
                     }

                     byte var10000 = no_progress;
                     int var22 = no_progress + 1;
                     if (var10000 < 2) {
                        continue label459;
                     }
                     break;
                  }
               } catch (HttpException var20) {
                  if (Log.isDebugEnabled()) {
                     Log.debug("uri=" + this._uri);
                     Log.debug("fields=" + this._requestFields);
                     Log.debug((Throwable)var20);
                  }

                  this._generator.sendError(var20.getStatus(), var20.getReason(), (String)null, true);
                  this._parser.reset(true);
                  this._endp.close();
                  throw var20;
               } finally {
                  setCurrentConnection((HttpConnection)null);
                  more_in_buffer = this._parser.isMoreInBuffer() || this._endp.isBufferingInput();
                  synchronized(this) {
                     this._handling = false;
                     if (this._destroy) {
                        this.destroy();
                        return;
                     }
                  }

                  if (!this._parser.isComplete() || !this._generator.isComplete() || this._endp.isBufferingOutput()) {
                     break label451;
                  }

                  if (!this._generator.isPersistent()) {
                     this._parser.reset(true);
                     more_in_buffer = false;
                  }

                  if (more_in_buffer) {
                     this.reset(false);
                     boolean var24;
                     if (!this._parser.isMoreInBuffer() && !this._endp.isBufferingInput()) {
                        var24 = false;
                     } else {
                        var24 = true;
                     }
                  } else {
                     this.reset(true);
                  }

                  var23 = false;
                  break label451;
               }

            }

            Continuation continuation = this._request.getContinuation();
            if (continuation == null || !continuation.isPending()) {
               if (this._generator.isCommitted() && !this._generator.isComplete() && this._endp instanceof SelectChannelEndPoint) {
                  ((SelectChannelEndPoint)this._endp).setWritable(false);
               }

            }
         }

         return;
      }
   }

   public void reset(boolean returnBuffers) {
      this._parser.reset(returnBuffers);
      this._requestFields.clear();
      this._request.recycle();
      this._generator.reset(returnBuffers);
      this._responseFields.clear();
      this._response.recycle();
      this._uri.clear();
   }

   protected void handleRequest() throws IOException {
      if (this._server.isRunning()) {
         boolean retrying = false;
         boolean error = false;
         String threadName = null;
         String info = null;

         try {
            info = URIUtil.canonicalPath(this._uri.getDecodedPath());
            if (info == null) {
               throw new HttpException(400);
            }

            this._request.setPathInfo(info);
            if (this._out != null) {
               this._out.reopen();
            }

            if (Log.isDebugEnabled()) {
               threadName = Thread.currentThread().getName();
               Thread.currentThread().setName(threadName + " - " + this._uri);
            }

            this._connector.customize(this._endp, this._request);
            this._server.handle(this);
         } catch (RetryRequest var14) {
            if (Log.isDebugEnabled()) {
               Log.ignore(var14);
            }

            retrying = true;
         } catch (EofException var15) {
            Log.ignore(var15);
            error = true;
         } catch (HttpException var16) {
            Log.debug((Throwable)var16);
            this._request.setHandled(true);
            this._response.sendError(var16.getStatus(), var16.getReason());
            error = true;
         } catch (RuntimeIOException var17) {
            Log.debug((Throwable)var17);
            this._request.setHandled(true);
            error = true;
         } catch (Throwable var18) {
            if (var18 instanceof ThreadDeath) {
               throw (ThreadDeath)var18;
            }

            if (info == null) {
               Log.warn(this._uri + ": " + var18);
               Log.debug(var18);
               this._request.setHandled(true);
               this._generator.sendError(400, (String)null, (String)null, true);
            } else {
               Log.warn("" + this._uri, var18);
               this._request.setHandled(true);
               this._generator.sendError(500, (String)null, (String)null, true);
            }

            error = true;
         } finally {
            if (threadName != null) {
               Thread.currentThread().setName(threadName);
            }

            if (!retrying) {
               if (this._request.getContinuation() != null) {
                  Log.debug("continuation still pending {}");
                  this._request.getContinuation().reset();
               }

               if (this._endp.isOpen()) {
                  if (this._generator.isPersistent()) {
                     this._connector.persist(this._endp);
                  }

                  if (error) {
                     this._endp.close();
                  } else {
                     if (!this._response.isCommitted() && !this._request.isHandled()) {
                        this._response.sendError(404);
                     }

                     this._response.complete();
                  }
               } else {
                  this._response.complete();
               }
            }

         }
      }

   }

   public void commitResponse(boolean last) throws IOException {
      if (!this._generator.isCommitted()) {
         this._generator.setResponse(this._response.getStatus(), this._response.getReason());

         try {
            this._generator.completeHeader(this._responseFields, last);
         } catch (IOException var3) {
            throw var3;
         } catch (RuntimeException var4) {
            Log.warn("header full: " + var4);
            if (Log.isDebugEnabled() && this._generator instanceof HttpGenerator) {
               Log.debug(((HttpGenerator)this._generator)._header.toDetailString(), var4);
            }

            this._response.reset();
            this._generator.reset(true);
            this._generator.setResponse(500, (String)null);
            this._generator.completeHeader(this._responseFields, true);
            this._generator.complete();
            throw var4;
         }
      }

      if (last) {
         this._generator.complete();
      }

   }

   public void completeResponse() throws IOException {
      if (!this._generator.isCommitted()) {
         this._generator.setResponse(this._response.getStatus(), this._response.getReason());

         try {
            this._generator.completeHeader(this._responseFields, true);
         } catch (IOException var2) {
            throw var2;
         } catch (RuntimeException var3) {
            Log.warn("header full: " + var3);
            Log.debug((Throwable)var3);
            this._response.reset();
            this._generator.reset(true);
            this._generator.setResponse(500, (String)null);
            this._generator.completeHeader(this._responseFields, true);
            this._generator.complete();
            throw var3;
         }
      }

      this._generator.complete();
   }

   public void flushResponse() throws IOException {
      try {
         this.commitResponse(false);
         this._generator.flush();
      } catch (IOException var2) {
         throw var2 instanceof EofException ? var2 : new EofException(var2);
      }
   }

   public Generator getGenerator() {
      return this._generator;
   }

   public boolean isIncluding() {
      return this._include > 0;
   }

   public void include() {
      ++this._include;
   }

   public void included() {
      --this._include;
      if (this._out != null) {
         this._out.reopen();
      }

   }

   public boolean isIdle() {
      return this._generator.isIdle() && (this._parser.isIdle() || this._delayedHandling);
   }

   public class OutputWriter extends AbstractGenerator.OutputWriter {
      OutputWriter() {
         super(HttpConnection.this._out);
      }
   }

   public class Output extends AbstractGenerator.Output {
      Output() {
         super((AbstractGenerator)HttpConnection.this._generator, (long)HttpConnection.this._connector.getMaxIdleTime());
      }

      public void close() throws IOException {
         if (!this._closed) {
            if (!HttpConnection.this.isIncluding() && !this._generator.isCommitted()) {
               HttpConnection.this.commitResponse(true);
            } else {
               HttpConnection.this.flushResponse();
            }

            super.close();
         }
      }

      public void flush() throws IOException {
         if (!this._generator.isCommitted()) {
            HttpConnection.this.commitResponse(false);
         }

         super.flush();
      }

      public void print(String s) throws IOException {
         if (this._closed) {
            throw new IOException("Closed");
         } else {
            PrintWriter writer = HttpConnection.this.getPrintWriter((String)null);
            writer.print(s);
         }
      }

      public void sendResponse(Buffer response) throws IOException {
         ((HttpGenerator)this._generator).sendResponse(response);
      }

      public void sendContent(Object content) throws IOException {
         Resource resource = null;
         if (this._closed) {
            throw new IOException("Closed");
         } else if (this._generator.getContentWritten() > 0L) {
            throw new IllegalStateException("!empty");
         } else {
            Buffer buffer;
            if (content instanceof HttpContent) {
               HttpContent c = (HttpContent)content;
               Buffer contentType = c.getContentType();
               if (contentType != null && !HttpConnection.this._responseFields.containsKey(HttpHeaders.CONTENT_TYPE_BUFFER)) {
                  String enc = HttpConnection.this._response.getSetCharacterEncoding();
                  if (enc == null) {
                     HttpConnection.this._responseFields.add(HttpHeaders.CONTENT_TYPE_BUFFER, contentType);
                  } else if (contentType instanceof BufferCache.CachedBuffer) {
                     BufferCache.CachedBuffer content_type = ((BufferCache.CachedBuffer)contentType).getAssociate(enc);
                     if (content_type != null) {
                        HttpConnection.this._responseFields.put((Buffer)HttpHeaders.CONTENT_TYPE_BUFFER, (Buffer)content_type);
                     } else {
                        HttpConnection.this._responseFields.put(HttpHeaders.CONTENT_TYPE_BUFFER, contentType + ";charset=" + QuotedStringTokenizer.quote(enc, ";= "));
                     }
                  } else {
                     HttpConnection.this._responseFields.put(HttpHeaders.CONTENT_TYPE_BUFFER, contentType + ";charset=" + QuotedStringTokenizer.quote(enc, ";= "));
                  }
               }

               if (c.getContentLength() > 0L) {
                  HttpConnection.this._responseFields.putLongField(HttpHeaders.CONTENT_LENGTH_BUFFER, c.getContentLength());
               }

               buffer = c.getLastModified();
               long lml = c.getResource().lastModified();
               if (buffer != null) {
                  HttpConnection.this._responseFields.put(HttpHeaders.LAST_MODIFIED_BUFFER, buffer, lml);
               } else if (c.getResource() != null && lml != -1L) {
                  HttpConnection.this._responseFields.putDateField(HttpHeaders.LAST_MODIFIED_BUFFER, lml);
               }

               content = c.getBuffer();
               if (content == null) {
                  content = c.getInputStream();
               }
            } else if (content instanceof Resource) {
               resource = (Resource)content;
               HttpConnection.this._responseFields.putDateField(HttpHeaders.LAST_MODIFIED_BUFFER, resource.lastModified());
               content = resource.getInputStream();
            }

            if (content instanceof Buffer) {
               this._generator.addContent((Buffer)content, true);
               HttpConnection.this.commitResponse(true);
            } else {
               if (!(content instanceof InputStream)) {
                  throw new IllegalArgumentException("unknown content type?");
               }

               InputStream in = (InputStream)content;

               try {
                  int max = this._generator.prepareUncheckedAddContent();
                  buffer = this._generator.getUncheckedBuffer();

                  for(int len = buffer.readFrom(in, max); len >= 0; len = buffer.readFrom(in, max)) {
                     this._generator.completeUncheckedAddContent();
                     HttpConnection.this._out.flush();
                     max = this._generator.prepareUncheckedAddContent();
                     buffer = this._generator.getUncheckedBuffer();
                  }

                  this._generator.completeUncheckedAddContent();
                  HttpConnection.this._out.flush();
               } finally {
                  if (resource != null) {
                     resource.release();
                  } else {
                     in.close();
                  }

               }
            }

         }
      }
   }

   private class RequestHandler extends HttpParser.EventHandler {
      private String _charset;

      private RequestHandler() {
      }

      public void startRequest(Buffer method, Buffer uri, Buffer version) throws IOException {
         HttpConnection.this._host = false;
         HttpConnection.this._expect = HttpConnection.UNKNOWN;
         HttpConnection.this._delayedHandling = false;
         this._charset = null;
         if (HttpConnection.this._request.getTimeStamp() == 0L) {
            HttpConnection.this._request.setTimeStamp(System.currentTimeMillis());
         }

         HttpConnection.this._request.setMethod(method.toString());

         try {
            HttpConnection.this._uri.parse(uri.array(), uri.getIndex(), uri.length());
            HttpConnection.this._request.setUri(HttpConnection.this._uri);
            if (versionx == null) {
               HttpConnection.this._request.setProtocol("");
               HttpConnection.this._version = 9;
            } else {
               Buffer version = HttpVersions.CACHE.get(versionx);
               HttpConnection.this._version = HttpVersions.CACHE.getOrdinal(version);
               if (HttpConnection.this._version <= 0) {
                  HttpConnection.this._version = 10;
               }

               HttpConnection.this._request.setProtocol(version.toString());
            }

            HttpConnection.this._head = method == HttpMethods.HEAD_BUFFER;
         } catch (Exception var5) {
            Log.debug((Throwable)var5);
            throw new HttpException(400, (String)null, var5);
         }
      }

      public void parsedHeader(Buffer name, Buffer value) {
         int ho = HttpHeaders.CACHE.getOrdinal(name);
         label36:
         switch(ho) {
         case 1:
            int ordinal = HttpHeaderValues.CACHE.getOrdinal(value);
            switch(ordinal) {
            case -1:
               QuotedStringTokenizer tok = new QuotedStringTokenizer(value.toString(), ",");

               while(true) {
                  if (!tok.hasMoreTokens()) {
                     break label36;
                  }

                  BufferCache.CachedBuffer cb = HttpHeaderValues.CACHE.get(tok.nextToken().trim());
                  if (cb != null) {
                     switch(cb.getOrdinal()) {
                     case 1:
                        HttpConnection.this._responseFields.add(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.CLOSE_BUFFER);
                        HttpConnection.this._generator.setPersistent(false);
                        break;
                     case 5:
                        if (HttpConnection.this._version == 10) {
                           HttpConnection.this._responseFields.add(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.KEEP_ALIVE_BUFFER);
                        }
                     }
                  }
               }
            case 1:
               HttpConnection.this._responseFields.put(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.CLOSE_BUFFER);
               HttpConnection.this._generator.setPersistent(false);
               break label36;
            case 5:
               if (HttpConnection.this._version == 10) {
                  HttpConnection.this._responseFields.put(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.KEEP_ALIVE_BUFFER);
               }
            default:
               break label36;
            }
         case 16:
            value = MimeTypes.CACHE.lookup(value);
            this._charset = MimeTypes.getCharsetFromContentType(value);
            break;
         case 21:
         case 40:
            value = HttpHeaderValues.CACHE.lookup(value);
            break;
         case 24:
            value = HttpHeaderValues.CACHE.lookup(value);
            HttpConnection.this._expect = HttpHeaderValues.CACHE.getOrdinal(value);
            break;
         case 27:
            HttpConnection.this._host = true;
         }

         HttpConnection.this._requestFields.add(name, value);
      }

      public void headerComplete() throws IOException {
         if (HttpConnection.this._endp instanceof SelectChannelEndPoint) {
            ((SelectChannelEndPoint)HttpConnection.this._endp).scheduleIdle();
         }

         HttpConnection.this._requests++;
         HttpConnection.this._generator.setVersion(HttpConnection.this._version);
         switch(HttpConnection.this._version) {
         case 9:
         default:
            break;
         case 10:
            HttpConnection.this._generator.setHead(HttpConnection.this._head);
            break;
         case 11:
            HttpConnection.this._generator.setHead(HttpConnection.this._head);
            if (HttpConnection.this._server.getSendDateHeader()) {
               HttpConnection.this._responseFields.put(HttpHeaders.DATE_BUFFER, HttpConnection.this._request.getTimeStampBuffer(), HttpConnection.this._request.getTimeStamp());
            }

            if (!HttpConnection.this._host) {
               HttpConnection.this._generator.setResponse(400, (String)null);
               HttpConnection.this._responseFields.put(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.CLOSE_BUFFER);
               HttpConnection.this._generator.completeHeader(HttpConnection.this._responseFields, true);
               HttpConnection.this._generator.complete();
               return;
            }

            if (HttpConnection.this._expect != HttpConnection.UNKNOWN) {
               if (HttpConnection.this._expect == 6) {
                  if (((HttpParser)HttpConnection.this._parser).getHeaderBuffer() == null || ((HttpParser)HttpConnection.this._parser).getHeaderBuffer().length() < 2) {
                     HttpConnection.this._generator.setResponse(100, (String)null);
                     HttpConnection.this._generator.completeHeader((HttpFields)null, true);
                     HttpConnection.this._generator.complete();
                     HttpConnection.this._generator.reset(false);
                  }
               } else if (HttpConnection.this._expect != 7) {
                  HttpConnection.this._generator.setResponse(417, (String)null);
                  HttpConnection.this._responseFields.put(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.CLOSE_BUFFER);
                  HttpConnection.this._generator.completeHeader(HttpConnection.this._responseFields, true);
                  HttpConnection.this._generator.complete();
                  return;
               }
            }
         }

         if (this._charset != null) {
            HttpConnection.this._request.setCharacterEncodingUnchecked(this._charset);
         }

         if (((HttpParser)HttpConnection.this._parser).getContentLength() <= 0L && !((HttpParser)HttpConnection.this._parser).isChunking()) {
            HttpConnection.this.handleRequest();
         } else {
            HttpConnection.this._delayedHandling = true;
         }

      }

      public void content(Buffer ref) throws IOException {
         if (HttpConnection.this._endp instanceof SelectChannelEndPoint) {
            ((SelectChannelEndPoint)HttpConnection.this._endp).scheduleIdle();
         }

         if (HttpConnection.this._delayedHandling) {
            HttpConnection.this._delayedHandling = false;
            HttpConnection.this.handleRequest();
         }

      }

      public void messageComplete(long contentLength) throws IOException {
         if (HttpConnection.this._delayedHandling) {
            HttpConnection.this._delayedHandling = false;
            HttpConnection.this.handleRequest();
         }

      }

      public void startResponse(Buffer version, int status, Buffer reason) {
         Log.debug("Bad request!: " + version + " " + status + " " + reason);
      }

      // $FF: synthetic method
      RequestHandler(Object x1) {
         this();
      }
   }
}
