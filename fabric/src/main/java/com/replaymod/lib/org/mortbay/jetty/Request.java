package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.BufferUtil;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import com.replaymod.lib.org.mortbay.io.nio.DirectNIOBuffer;
import com.replaymod.lib.org.mortbay.io.nio.IndirectNIOBuffer;
import com.replaymod.lib.org.mortbay.io.nio.NIOBuffer;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.jetty.security.Authenticator;
import com.replaymod.lib.org.mortbay.jetty.security.SecurityHandler;
import com.replaymod.lib.org.mortbay.jetty.security.UserRealm;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.Attributes;
import com.replaymod.lib.org.mortbay.util.AttributesMap;
import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.MultiMap;
import com.replaymod.lib.org.mortbay.util.QuotedStringTokenizer;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import com.replaymod.lib.org.mortbay.util.UrlEncoded;
import com.replaymod.lib.org.mortbay.util.ajax.Continuation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Request implements HttpServletRequest {
   private static final Collection __defaultLocale = Collections.singleton(Locale.getDefault());
   private static final int __NONE = 0;
   private static final int _STREAM = 1;
   private static final int __READER = 2;
   private boolean _handled = false;
   private HttpConnection _connection;
   private EndPoint _endp;
   private Map _roleMap;
   private Attributes _attributes;
   private String _authType;
   private String _characterEncoding;
   private String _queryEncoding;
   private String _serverName;
   private String _remoteAddr;
   private String _remoteHost;
   private String _method;
   private String _pathInfo;
   private int _port;
   private String _protocol = "HTTP/1.1";
   private String _queryString;
   private String _requestedSessionId;
   private boolean _requestedSessionIdFromCookie = false;
   private String _requestURI;
   private String _scheme = "http";
   private String _contextPath;
   private String _servletPath;
   private String _servletName;
   private HttpURI _uri;
   private Principal _userPrincipal;
   private MultiMap _parameters;
   private MultiMap _baseParameters;
   private boolean _paramsExtracted;
   private int _inputState = 0;
   private BufferedReader _reader;
   private String _readerEncoding;
   private boolean _dns = false;
   private ContextHandler.SContext _context;
   private HttpSession _session;
   private SessionManager _sessionManager;
   private boolean _cookiesExtracted = false;
   private Cookie[] _cookies;
   private String[] _unparsedCookies;
   private long _timeStamp;
   private Buffer _timeStampBuffer;
   private Continuation _continuation;
   private Object _requestAttributeListeners;
   private Object _requestListeners;
   private Map _savedNewSessions;
   private UserRealm _userRealm;

   public Request() {
   }

   public Request(HttpConnection connection) {
      this._connection = connection;
      this._endp = connection.getEndPoint();
      this._dns = this._connection.getResolveNames();
   }

   protected void setConnection(HttpConnection connection) {
      this._connection = connection;
      this._endp = connection.getEndPoint();
      this._dns = connection.getResolveNames();
   }

   protected void recycle() {
      if (this._inputState == 2) {
         try {
            for(int r = this._reader.read(); r != -1; r = this._reader.read()) {
            }
         } catch (Exception var2) {
            Log.ignore(var2);
            this._reader = null;
         }
      }

      this._handled = false;
      if (this._context != null) {
         throw new IllegalStateException("Request in context!");
      } else {
         if (this._attributes != null) {
            this._attributes.clearAttributes();
         }

         this._authType = null;
         this._characterEncoding = null;
         this._queryEncoding = null;
         this._context = null;
         this._serverName = null;
         this._method = null;
         this._pathInfo = null;
         this._port = 0;
         this._protocol = "HTTP/1.1";
         this._queryString = null;
         this._requestedSessionId = null;
         this._requestedSessionIdFromCookie = false;
         this._session = null;
         this._sessionManager = null;
         this._requestURI = null;
         this._scheme = "http";
         this._servletPath = null;
         this._timeStamp = 0L;
         this._timeStampBuffer = null;
         this._uri = null;
         this._userPrincipal = null;
         if (this._baseParameters != null) {
            this._baseParameters.clear();
         }

         this._parameters = null;
         this._paramsExtracted = false;
         this._inputState = 0;
         this._cookiesExtracted = false;
         if (this._savedNewSessions != null) {
            this._savedNewSessions.clear();
         }

         this._savedNewSessions = null;
         if (this._continuation != null && this._continuation.isPending()) {
            this._continuation.reset();
         }

      }
   }

   public Buffer getTimeStampBuffer() {
      if (this._timeStampBuffer == null && this._timeStamp > 0L) {
         this._timeStampBuffer = HttpFields.__dateCache.formatBuffer(this._timeStamp);
      }

      return this._timeStampBuffer;
   }

   public long getTimeStamp() {
      return this._timeStamp;
   }

   public void setTimeStamp(long ts) {
      this._timeStamp = ts;
   }

   public boolean isHandled() {
      return this._handled;
   }

   public void setHandled(boolean h) {
      this._handled = h;
   }

   public Object getAttribute(String name) {
      if ("com.replaymod.lib.org.mortbay.jetty.ajax.Continuation".equals(name)) {
         return this.getContinuation(true);
      } else {
         return this._attributes == null ? null : this._attributes.getAttribute(name);
      }
   }

   public Enumeration getAttributeNames() {
      return this._attributes == null ? Collections.enumeration(Collections.EMPTY_LIST) : AttributesMap.getAttributeNamesCopy(this._attributes);
   }

   public String getAuthType() {
      return this._authType;
   }

   public String getCharacterEncoding() {
      return this._characterEncoding;
   }

   public long getContentRead() {
      return this._connection != null && this._connection.getParser() != null ? ((HttpParser)this._connection.getParser()).getContentRead() : -1L;
   }

   public int getContentLength() {
      return (int)this._connection.getRequestFields().getLongField(HttpHeaders.CONTENT_LENGTH_BUFFER);
   }

   public String getContentType() {
      return this._connection.getRequestFields().getStringField(HttpHeaders.CONTENT_TYPE_BUFFER);
   }

   public void setContentType(String contentType) {
      this._connection.getRequestFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, contentType);
   }

   public String getContextPath() {
      return this._contextPath;
   }

   public Cookie[] getCookies() {
      if (this._cookiesExtracted) {
         return this._cookies;
      } else if (!this._connection.getRequestFields().containsKey(HttpHeaders.COOKIE_BUFFER)) {
         this._cookies = null;
         this._cookiesExtracted = true;
         this._unparsedCookies = null;
         return this._cookies;
      } else {
         if (this._unparsedCookies != null) {
            int last = 0;

            for(Enumeration enm = this._connection.getRequestFields().getValues(HttpHeaders.COOKIE_BUFFER); enm.hasMoreElements(); ++last) {
               String c = (String)enm.nextElement();
               if (last >= this._unparsedCookies.length || !c.equals(this._unparsedCookies[last])) {
                  this._unparsedCookies = null;
                  break;
               }
            }

            if (this._unparsedCookies != null && this._unparsedCookies.length == last) {
               this._cookiesExtracted = true;
               return this._cookies;
            }
         }

         this._cookies = null;
         Object cookies = null;
         Object lastCookies = null;
         int version = 0;
         Enumeration enm = this._connection.getRequestFields().getValues(HttpHeaders.COOKIE_BUFFER);

         while(enm.hasMoreElements()) {
            try {
               String hdr = (String)enm.nextElement();
               lastCookies = LazyList.add(lastCookies, hdr);
               String name = null;
               String value = null;
               Cookie cookie = null;
               boolean invalue = false;
               boolean quoted = false;
               boolean escaped = false;
               int tokenstart = -1;
               int tokenend = -1;
               int i = 0;
               int length = hdr.length();

               for(int last = length - 1; i < length; ++i) {
                  char c = hdr.charAt(i);
                  if (quoted) {
                     if (escaped) {
                        escaped = false;
                        continue;
                     }

                     switch(c) {
                     case '"':
                        tokenend = i;
                        quoted = false;
                        if (i == last) {
                           if (invalue) {
                              value = hdr.substring(tokenstart, i + 1);
                           } else {
                              name = hdr.substring(tokenstart, i + 1);
                              value = "";
                           }
                        }
                        break;
                     case '\\':
                        escaped = true;
                     default:
                        continue;
                     }
                  } else if (invalue) {
                     switch(c) {
                     case '\t':
                     case ' ':
                        continue;
                     case '"':
                        if (tokenstart < 0) {
                           quoted = true;
                           tokenstart = i;
                        }

                        tokenend = i;
                        if (i != last) {
                           continue;
                        }

                        value = hdr.substring(tokenstart, i + 1);
                        break;
                     case ',':
                     case ';':
                        if (tokenstart >= 0) {
                           value = hdr.substring(tokenstart, tokenend + 1);
                        } else {
                           value = "";
                        }

                        tokenstart = -1;
                        invalue = false;
                        break;
                     default:
                        if (tokenstart < 0) {
                           tokenstart = i;
                        }

                        tokenend = i;
                        if (i != last) {
                           continue;
                        }

                        value = hdr.substring(tokenstart, i + 1);
                     }
                  } else {
                     switch(c) {
                     case '\t':
                     case ' ':
                        continue;
                     case '"':
                        if (tokenstart < 0) {
                           quoted = true;
                           tokenstart = i;
                        }

                        tokenend = i;
                        if (i != last) {
                           continue;
                        }

                        name = hdr.substring(tokenstart, i + 1);
                        value = "";
                        break;
                     case ',':
                     case ';':
                        if (tokenstart >= 0) {
                           name = hdr.substring(tokenstart, tokenend + 1);
                           value = "";
                        }

                        tokenstart = -1;
                        break;
                     case '=':
                        if (tokenstart >= 0) {
                           name = hdr.substring(tokenstart, tokenend + 1);
                        }

                        tokenstart = -1;
                        invalue = true;
                        continue;
                     default:
                        if (tokenstart < 0) {
                           tokenstart = i;
                        }

                        tokenend = i;
                        if (i != last) {
                           continue;
                        }

                        name = hdr.substring(tokenstart, i + 1);
                        value = "";
                     }
                  }

                  if (value != null && name != null) {
                     name = QuotedStringTokenizer.unquote(name);
                     value = QuotedStringTokenizer.unquote(value);

                     try {
                        if (name.startsWith("$")) {
                           String lowercaseName = name.toLowerCase();
                           if ("$path".equals(lowercaseName)) {
                              if (cookie != null) {
                                 cookie.setPath(value);
                              }
                           } else if ("$domain".equals(lowercaseName)) {
                              if (cookie != null) {
                                 cookie.setDomain(value);
                              }
                           } else if ("$port".equals(lowercaseName)) {
                              if (cookie != null) {
                                 cookie.setComment("port=" + value);
                              }
                           } else if ("$version".equals(lowercaseName)) {
                              version = Integer.parseInt(value);
                           }
                        } else {
                           cookie = new Cookie(name, value);
                           if (version > 0) {
                              cookie.setVersion(version);
                           }

                           cookies = LazyList.add(cookies, cookie);
                        }
                     } catch (Exception var19) {
                        Log.warn(var19.toString());
                        Log.debug((Throwable)var19);
                     }

                     name = null;
                     value = null;
                  }
               }
            } catch (Exception var20) {
               Log.warn((Throwable)var20);
            }
         }

         int l = LazyList.size(cookies);
         this._cookiesExtracted = true;
         if (l > 0) {
            if (this._cookies == null || this._cookies.length != l) {
               this._cookies = new Cookie[l];
            }

            int i;
            for(i = 0; i < l; ++i) {
               this._cookies[i] = (Cookie)LazyList.get(cookies, i);
            }

            l = LazyList.size(lastCookies);
            this._unparsedCookies = new String[l];

            for(i = 0; i < l; ++i) {
               this._unparsedCookies[i] = (String)LazyList.get(lastCookies, i);
            }
         } else {
            this._cookies = null;
            this._unparsedCookies = null;
         }

         return this._cookies != null && this._cookies.length != 0 ? this._cookies : null;
      }
   }

   public long getDateHeader(String name) {
      return this._connection.getRequestFields().getDateField(name);
   }

   public String getHeader(String name) {
      return this._connection.getRequestFields().getStringField(name);
   }

   public Enumeration getHeaderNames() {
      return this._connection.getRequestFields().getFieldNames();
   }

   public Enumeration getHeaders(String name) {
      Enumeration e = this._connection.getRequestFields().getValues(name);
      return e == null ? Collections.enumeration(Collections.EMPTY_LIST) : e;
   }

   public ServletInputStream getInputStream() throws IOException {
      if (this._inputState != 0 && this._inputState != 1) {
         throw new IllegalStateException("READER");
      } else {
         this._inputState = 1;
         return this._connection.getInputStream();
      }
   }

   public int getIntHeader(String name) {
      return (int)this._connection.getRequestFields().getLongField(name);
   }

   public String getLocalAddr() {
      return this._endp == null ? null : this._endp.getLocalAddr();
   }

   public Locale getLocale() {
      Enumeration enm = this._connection.getRequestFields().getValues("Accept-Language", ", \t");
      if (enm != null && enm.hasMoreElements()) {
         List acceptLanguage = HttpFields.qualityList(enm);
         if (acceptLanguage.size() == 0) {
            return Locale.getDefault();
         } else {
            int size = acceptLanguage.size();
            int i = 0;
            if (i < size) {
               String language = (String)acceptLanguage.get(i);
               language = HttpFields.valueParameters(language, (Map)null);
               String country = "";
               int dash = language.indexOf(45);
               if (dash > -1) {
                  country = language.substring(dash + 1).trim();
                  language = language.substring(0, dash).trim();
               }

               return new Locale(language, country);
            } else {
               return Locale.getDefault();
            }
         }
      } else {
         return Locale.getDefault();
      }
   }

   public Enumeration getLocales() {
      Enumeration enm = this._connection.getRequestFields().getValues("Accept-Language", ", \t");
      if (enm != null && enm.hasMoreElements()) {
         List acceptLanguage = HttpFields.qualityList(enm);
         if (acceptLanguage.size() == 0) {
            return Collections.enumeration(__defaultLocale);
         } else {
            Object langs = null;
            int size = acceptLanguage.size();

            for(int i = 0; i < size; ++i) {
               String language = (String)acceptLanguage.get(i);
               language = HttpFields.valueParameters(language, (Map)null);
               String country = "";
               int dash = language.indexOf(45);
               if (dash > -1) {
                  country = language.substring(dash + 1).trim();
                  language = language.substring(0, dash).trim();
               }

               langs = LazyList.ensureSize(langs, size);
               langs = LazyList.add(langs, new Locale(language, country));
            }

            if (LazyList.size(langs) == 0) {
               return Collections.enumeration(__defaultLocale);
            } else {
               return Collections.enumeration(LazyList.getList(langs));
            }
         }
      } else {
         return Collections.enumeration(__defaultLocale);
      }
   }

   public String getLocalName() {
      if (this._dns) {
         return this._endp == null ? null : this._endp.getLocalHost();
      } else {
         return this._endp == null ? null : this._endp.getLocalAddr();
      }
   }

   public int getLocalPort() {
      return this._endp == null ? 0 : this._endp.getLocalPort();
   }

   public String getMethod() {
      return this._method;
   }

   public String getParameter(String name) {
      if (!this._paramsExtracted) {
         this.extractParameters();
      }

      return (String)this._parameters.getValue(name, 0);
   }

   public Map getParameterMap() {
      if (!this._paramsExtracted) {
         this.extractParameters();
      }

      return Collections.unmodifiableMap(this._parameters.toStringArrayMap());
   }

   public Enumeration getParameterNames() {
      if (!this._paramsExtracted) {
         this.extractParameters();
      }

      return Collections.enumeration(this._parameters.keySet());
   }

   public String[] getParameterValues(String name) {
      if (!this._paramsExtracted) {
         this.extractParameters();
      }

      List vals = this._parameters.getValues(name);
      return vals == null ? null : (String[])((String[])vals.toArray(new String[vals.size()]));
   }

   public String getPathInfo() {
      return this._pathInfo;
   }

   public String getPathTranslated() {
      return this._pathInfo != null && this._context != null ? this._context.getRealPath(this._pathInfo) : null;
   }

   public String getProtocol() {
      return this._protocol;
   }

   public BufferedReader getReader() throws IOException {
      if (this._inputState != 0 && this._inputState != 2) {
         throw new IllegalStateException("STREAMED");
      } else if (this._inputState == 2) {
         return this._reader;
      } else {
         String encoding = this.getCharacterEncoding();
         if (encoding == null) {
            encoding = StringUtil.__ISO_8859_1;
         }

         if (this._reader == null || !encoding.equalsIgnoreCase(this._readerEncoding)) {
            final ServletInputStream in = this.getInputStream();
            this._readerEncoding = encoding;
            this._reader = new BufferedReader(new InputStreamReader(in, encoding)) {
               public void close() throws IOException {
                  in.close();
               }
            };
         }

         this._inputState = 2;
         return this._reader;
      }
   }

   public String getRealPath(String path) {
      return this._context == null ? null : this._context.getRealPath(path);
   }

   public String getRemoteAddr() {
      if (this._remoteAddr != null) {
         return this._remoteAddr;
      } else {
         return this._endp == null ? null : this._endp.getRemoteAddr();
      }
   }

   public String getRemoteHost() {
      if (this._dns) {
         if (this._remoteHost != null) {
            return this._remoteHost;
         } else {
            return this._endp == null ? null : this._endp.getRemoteHost();
         }
      } else {
         return this.getRemoteAddr();
      }
   }

   public int getRemotePort() {
      return this._endp == null ? 0 : this._endp.getRemotePort();
   }

   public String getRemoteUser() {
      Principal p = this.getUserPrincipal();
      return p == null ? null : p.getName();
   }

   public RequestDispatcher getRequestDispatcher(String path) {
      if (path != null && this._context != null) {
         if (!path.startsWith("/")) {
            String relTo = URIUtil.addPaths(this._servletPath, this._pathInfo);
            int slash = relTo.lastIndexOf("/");
            if (slash > 1) {
               relTo = relTo.substring(0, slash + 1);
            } else {
               relTo = "/";
            }

            path = URIUtil.addPaths(relTo, path);
         }

         return this._context.getRequestDispatcher(path);
      } else {
         return null;
      }
   }

   public String getRequestedSessionId() {
      return this._requestedSessionId;
   }

   public String getRequestURI() {
      if (this._requestURI == null && this._uri != null) {
         this._requestURI = this._uri.getPathAndParam();
      }

      return this._requestURI;
   }

   public StringBuffer getRequestURL() {
      StringBuffer url = new StringBuffer(48);
      synchronized(url) {
         String scheme = this.getScheme();
         int port = this.getServerPort();
         url.append(scheme);
         url.append("://");
         url.append(this.getServerName());
         if (this._port > 0 && (scheme.equalsIgnoreCase("http") && port != 80 || scheme.equalsIgnoreCase("https") && port != 443)) {
            url.append(':');
            url.append(this._port);
         }

         url.append(this.getRequestURI());
         return url;
      }
   }

   public String getScheme() {
      return this._scheme;
   }

   public String getServerName() {
      if (this._serverName != null) {
         return this._serverName;
      } else {
         this._serverName = this._uri.getHost();
         this._port = this._uri.getPort();
         if (this._serverName != null) {
            return this._serverName;
         } else {
            Buffer hostPort = this._connection.getRequestFields().get(HttpHeaders.HOST_BUFFER);
            if (hostPort == null) {
               if (this._connection != null) {
                  this._serverName = this.getLocalName();
                  this._port = this.getLocalPort();
                  if (this._serverName != null && !"0.0.0.0".equals(this._serverName)) {
                     return this._serverName;
                  }
               }

               try {
                  this._serverName = InetAddress.getLocalHost().getHostAddress();
               } catch (UnknownHostException var3) {
                  Log.ignore(var3);
               }

               return this._serverName;
            } else {
               int i = hostPort.length();

               while(i-- > 0) {
                  if (hostPort.peek(hostPort.getIndex() + i) == 58) {
                     this._serverName = BufferUtil.to8859_1_String(hostPort.peek(hostPort.getIndex(), i));
                     this._port = BufferUtil.toInt(hostPort.peek(hostPort.getIndex() + i + 1, hostPort.length() - i - 1));
                     return this._serverName;
                  }
               }

               if (this._serverName == null || this._port < 0) {
                  this._serverName = BufferUtil.to8859_1_String(hostPort);
                  this._port = 0;
               }

               return this._serverName;
            }
         }
      }
   }

   public int getServerPort() {
      if (this._port <= 0) {
         if (this._serverName == null) {
            this.getServerName();
         }

         if (this._port <= 0) {
            if (this._serverName != null && this._uri != null) {
               this._port = this._uri.getPort();
            } else {
               this._port = this._endp == null ? 0 : this._endp.getLocalPort();
            }
         }
      }

      if (this._port <= 0) {
         return this.getScheme().equalsIgnoreCase("https") ? 443 : 80;
      } else {
         return this._port;
      }
   }

   public String getServletPath() {
      if (this._servletPath == null) {
         this._servletPath = "";
      }

      return this._servletPath;
   }

   public String getServletName() {
      return this._servletName;
   }

   public HttpSession getSession() {
      return this.getSession(true);
   }

   public HttpSession getSession(boolean create) {
      if (this._sessionManager == null && create) {
         throw new IllegalStateException("No SessionHandler or SessionManager");
      } else if (this._session != null && this._sessionManager != null && this._sessionManager.isValid(this._session)) {
         return this._session;
      } else {
         this._session = null;
         String id = this.getRequestedSessionId();
         if (id != null && this._sessionManager != null) {
            this._session = this._sessionManager.getHttpSession(id);
            if (this._session == null && !create) {
               return null;
            }
         }

         if (this._session == null && this._sessionManager != null && create) {
            this._session = this._sessionManager.newHttpSession(this);
            Cookie cookie = this._sessionManager.getSessionCookie(this._session, this.getContextPath(), this.isSecure());
            if (cookie != null) {
               this._connection.getResponse().addCookie(cookie);
            }
         }

         return this._session;
      }
   }

   public Principal getUserPrincipal() {
      if (this._userPrincipal != null && this._userPrincipal instanceof SecurityHandler.NotChecked) {
         SecurityHandler.NotChecked not_checked = (SecurityHandler.NotChecked)this._userPrincipal;
         this._userPrincipal = SecurityHandler.__NO_USER;
         Authenticator auth = not_checked.getSecurityHandler().getAuthenticator();
         UserRealm realm = not_checked.getSecurityHandler().getUserRealm();
         String pathInContext = this.getPathInfo() == null ? this.getServletPath() : this.getServletPath() + this.getPathInfo();
         if (realm != null && auth != null) {
            try {
               auth.authenticate(realm, pathInContext, this, (Response)null);
            } catch (Exception var6) {
               Log.ignore(var6);
            }
         }
      }

      return this._userPrincipal == SecurityHandler.__NO_USER ? null : this._userPrincipal;
   }

   public String getQueryString() {
      if (this._queryString == null && this._uri != null) {
         if (this._queryEncoding == null) {
            this._queryString = this._uri.getQuery();
         } else {
            this._queryString = this._uri.getQuery(this._queryEncoding);
         }
      }

      return this._queryString;
   }

   public boolean isRequestedSessionIdFromCookie() {
      return this._requestedSessionId != null && this._requestedSessionIdFromCookie;
   }

   public boolean isRequestedSessionIdFromUrl() {
      return this._requestedSessionId != null && !this._requestedSessionIdFromCookie;
   }

   public boolean isRequestedSessionIdFromURL() {
      return this._requestedSessionId != null && !this._requestedSessionIdFromCookie;
   }

   public boolean isRequestedSessionIdValid() {
      if (this._requestedSessionId == null) {
         return false;
      } else {
         HttpSession session = this.getSession(false);
         return session == null ? false : this._sessionManager.getIdManager().getClusterId(this._requestedSessionId).equals(this._sessionManager.getClusterId(session));
      }
   }

   public boolean isSecure() {
      return this._connection.isConfidential(this);
   }

   public boolean isUserInRole(String role) {
      if (this._roleMap != null) {
         String r = (String)this._roleMap.get(role);
         if (r != null) {
            role = r;
         }
      }

      Principal principal = this.getUserPrincipal();
      return this._userRealm != null && principal != null ? this._userRealm.isUserInRole(principal, role) : false;
   }

   public void removeAttribute(String name) {
      Object old_value = this._attributes == null ? null : this._attributes.getAttribute(name);
      if (this._attributes != null) {
         this._attributes.removeAttribute(name);
      }

      if (old_value != null && this._requestAttributeListeners != null) {
         ServletRequestAttributeEvent event = new ServletRequestAttributeEvent(this._context, this, name, old_value);
         int size = LazyList.size(this._requestAttributeListeners);

         for(int i = 0; i < size; ++i) {
            EventListener listener = (ServletRequestAttributeListener)LazyList.get(this._requestAttributeListeners, i);
            if (listener instanceof ServletRequestAttributeListener) {
               ServletRequestAttributeListener l = (ServletRequestAttributeListener)listener;
               l.attributeRemoved(event);
            }
         }
      }

   }

   public void setAttribute(String name, Object value) {
      Object old_value = this._attributes == null ? null : this._attributes.getAttribute(name);
      if ("com.replaymod.lib.org.mortbay.jetty.Request.queryEncoding".equals(name)) {
         this.setQueryEncoding(value == null ? null : value.toString());
      } else if ("com.replaymod.lib.org.mortbay.jetty.ResponseBuffer".equals(name)) {
         try {
            ByteBuffer byteBuffer = (ByteBuffer)value;
            synchronized(byteBuffer) {
               NIOBuffer buffer = byteBuffer.isDirect() ? new DirectNIOBuffer(byteBuffer, true) : new IndirectNIOBuffer(byteBuffer, true);
               ((HttpConnection.Output)this.getServletResponse().getOutputStream()).sendResponse((Buffer)buffer);
            }
         } catch (IOException var10) {
            throw new RuntimeException(var10);
         }
      }

      if (this._attributes == null) {
         this._attributes = new AttributesMap();
      }

      this._attributes.setAttribute(name, value);
      if (this._requestAttributeListeners != null) {
         ServletRequestAttributeEvent event = new ServletRequestAttributeEvent(this._context, this, name, old_value == null ? value : old_value);
         int size = LazyList.size(this._requestAttributeListeners);

         for(int i = 0; i < size; ++i) {
            EventListener listener = (ServletRequestAttributeListener)LazyList.get(this._requestAttributeListeners, i);
            if (listener instanceof ServletRequestAttributeListener) {
               ServletRequestAttributeListener l = (ServletRequestAttributeListener)listener;
               if (old_value == null) {
                  l.attributeAdded(event);
               } else if (value == null) {
                  l.attributeRemoved(event);
               } else {
                  l.attributeReplaced(event);
               }
            }
         }
      }

   }

   public void setCharacterEncoding(String encoding) throws UnsupportedEncodingException {
      if (this._inputState == 0) {
         this._characterEncoding = encoding;
         if (!StringUtil.isUTF8(encoding)) {
            "".getBytes(encoding);
         }

      }
   }

   public void setCharacterEncodingUnchecked(String encoding) {
      this._characterEncoding = encoding;
   }

   private void extractParameters() {
      if (this._baseParameters == null) {
         this._baseParameters = new MultiMap(16);
      }

      if (this._paramsExtracted) {
         if (this._parameters == null) {
            this._parameters = this._baseParameters;
         }

      } else {
         this._paramsExtracted = true;
         if (this._uri != null && this._uri.hasQuery()) {
            if (this._queryEncoding == null) {
               this._uri.decodeQueryTo(this._baseParameters);
            } else {
               try {
                  this._uri.decodeQueryTo(this._baseParameters, this._queryEncoding);
               } catch (UnsupportedEncodingException var9) {
                  if (Log.isDebugEnabled()) {
                     Log.warn((Throwable)var9);
                  } else {
                     Log.warn(var9.toString());
                  }
               }
            }
         }

         String encoding = this.getCharacterEncoding();
         String content_type = this.getContentType();
         if (content_type != null && content_type.length() > 0) {
            content_type = HttpFields.valueParameters(content_type, (Map)null);
            if ("application/x-www-form-urlencoded".equalsIgnoreCase(content_type) && this._inputState == 0 && ("POST".equals(this.getMethod()) || "PUT".equals(this.getMethod()))) {
               int content_length = this.getContentLength();
               if (content_length != 0) {
                  try {
                     int maxFormContentSize = -1;
                     if (this._context != null) {
                        maxFormContentSize = this._context.getContextHandler().getMaxFormContentSize();
                     } else {
                        Integer size = (Integer)this._connection.getConnector().getServer().getAttribute("com.replaymod.lib.org.mortbay.jetty.Request.maxFormContentSize");
                        if (size != null) {
                           maxFormContentSize = size;
                        }
                     }

                     if (content_length > maxFormContentSize && maxFormContentSize > 0) {
                        throw new IllegalStateException("Form too large" + content_length + ">" + maxFormContentSize);
                     }

                     InputStream in = this.getInputStream();
                     UrlEncoded.decodeTo(in, this._baseParameters, encoding, content_length < 0 ? maxFormContentSize : -1);
                  } catch (IOException var8) {
                     if (Log.isDebugEnabled()) {
                        Log.warn((Throwable)var8);
                     } else {
                        Log.warn(var8.toString());
                     }
                  }
               }
            }
         }

         if (this._parameters == null) {
            this._parameters = this._baseParameters;
         } else if (this._parameters != this._baseParameters) {
            Iterator iter = this._baseParameters.entrySet().iterator();

            while(iter.hasNext()) {
               Entry entry = (Entry)iter.next();
               String name = (String)entry.getKey();
               Object values = entry.getValue();

               for(int i = 0; i < LazyList.size(values); ++i) {
                  this._parameters.add(name, LazyList.get(values, i));
               }
            }
         }

      }
   }

   public void setServerName(String host) {
      this._serverName = host;
   }

   public void setServerPort(int port) {
      this._port = port;
   }

   public void setRemoteAddr(String addr) {
      this._remoteAddr = addr;
   }

   public void setRemoteHost(String host) {
      this._remoteHost = host;
   }

   public HttpURI getUri() {
      return this._uri;
   }

   public void setUri(HttpURI uri) {
      this._uri = uri;
   }

   public HttpConnection getConnection() {
      return this._connection;
   }

   public int getInputState() {
      return this._inputState;
   }

   public void setAuthType(String authType) {
      this._authType = authType;
   }

   public void setCookies(Cookie[] cookies) {
      this._cookies = cookies;
   }

   public void setMethod(String method) {
      this._method = method;
   }

   public void setPathInfo(String pathInfo) {
      this._pathInfo = pathInfo;
   }

   public void setProtocol(String protocol) {
      this._protocol = protocol;
   }

   public void setRequestedSessionId(String requestedSessionId) {
      this._requestedSessionId = requestedSessionId;
   }

   public SessionManager getSessionManager() {
      return this._sessionManager;
   }

   public void setSessionManager(SessionManager sessionManager) {
      this._sessionManager = sessionManager;
   }

   public void setRequestedSessionIdFromCookie(boolean requestedSessionIdCookie) {
      this._requestedSessionIdFromCookie = requestedSessionIdCookie;
   }

   public void setSession(HttpSession session) {
      this._session = session;
   }

   public void setScheme(String scheme) {
      this._scheme = scheme;
   }

   public void setQueryString(String queryString) {
      this._queryString = queryString;
   }

   public void setRequestURI(String requestURI) {
      this._requestURI = requestURI;
   }

   public void setContextPath(String contextPath) {
      this._contextPath = contextPath;
   }

   public void setServletPath(String servletPath) {
      this._servletPath = servletPath;
   }

   public void setServletName(String name) {
      this._servletName = name;
   }

   public void setUserPrincipal(Principal userPrincipal) {
      this._userPrincipal = userPrincipal;
   }

   public void setContext(ContextHandler.SContext context) {
      this._context = context;
   }

   public ContextHandler.SContext getContext() {
      return this._context;
   }

   public StringBuffer getRootURL() {
      StringBuffer url = new StringBuffer(48);
      synchronized(url) {
         String scheme = this.getScheme();
         int port = this.getServerPort();
         url.append(scheme);
         url.append("://");
         url.append(this.getServerName());
         if (port > 0 && (scheme.equalsIgnoreCase("http") && port != 80 || scheme.equalsIgnoreCase("https") && port != 443)) {
            url.append(':');
            url.append(port);
         }

         return url;
      }
   }

   public Attributes getAttributes() {
      if (this._attributes == null) {
         this._attributes = new AttributesMap();
      }

      return this._attributes;
   }

   public void setAttributes(Attributes attributes) {
      this._attributes = attributes;
   }

   public Continuation getContinuation() {
      return this._continuation;
   }

   public Continuation getContinuation(boolean create) {
      if (this._continuation == null && create) {
         this._continuation = this.getConnection().getConnector().newContinuation();
      }

      return this._continuation;
   }

   void setContinuation(Continuation cont) {
      this._continuation = cont;
   }

   public MultiMap getParameters() {
      return this._parameters;
   }

   public void setParameters(MultiMap parameters) {
      this._parameters = parameters == null ? this._baseParameters : parameters;
      if (this._paramsExtracted && this._parameters == null) {
         throw new IllegalStateException();
      }
   }

   public String toString() {
      return this.getMethod() + " " + this._uri + " " + this.getProtocol() + "\n" + this._connection.getRequestFields().toString();
   }

   public static Request getRequest(HttpServletRequest request) {
      if (request instanceof Request) {
         return (Request)request;
      } else {
         while(request instanceof ServletRequestWrapper) {
            request = (HttpServletRequest)((ServletRequestWrapper)request).getRequest();
         }

         return request instanceof Request ? (Request)request : HttpConnection.getCurrentConnection().getRequest();
      }
   }

   public void addEventListener(EventListener listener) {
      if (listener instanceof ServletRequestAttributeListener) {
         this._requestAttributeListeners = LazyList.add(this._requestAttributeListeners, listener);
      }

   }

   public void removeEventListener(EventListener listener) {
      this._requestAttributeListeners = LazyList.remove(this._requestAttributeListeners, listener);
   }

   public void setRequestListeners(Object requestListeners) {
      this._requestListeners = requestListeners;
   }

   public Object takeRequestListeners() {
      Object listeners = this._requestListeners;
      this._requestListeners = null;
      return listeners;
   }

   public void saveNewSession(Object key, HttpSession session) {
      if (this._savedNewSessions == null) {
         this._savedNewSessions = new HashMap();
      }

      this._savedNewSessions.put(key, session);
   }

   public HttpSession recoverNewSession(Object key) {
      return this._savedNewSessions == null ? null : (HttpSession)this._savedNewSessions.get(key);
   }

   public UserRealm getUserRealm() {
      return this._userRealm;
   }

   public void setUserRealm(UserRealm userRealm) {
      this._userRealm = userRealm;
   }

   public String getQueryEncoding() {
      return this._queryEncoding;
   }

   public void setQueryEncoding(String queryEncoding) {
      this._queryEncoding = queryEncoding;
      this._queryString = null;
   }

   public void setRoleMap(Map map) {
      this._roleMap = map;
   }

   public Map getRoleMap() {
      return this._roleMap;
   }

   public ServletContext getServletContext() {
      return this._context;
   }

   public ServletResponse getServletResponse() {
      return this._connection.getResponse();
   }
}
