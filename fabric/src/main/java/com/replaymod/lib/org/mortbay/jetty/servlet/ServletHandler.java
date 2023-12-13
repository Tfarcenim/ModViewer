package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.io.RuntimeIOException;
import com.replaymod.lib.org.mortbay.jetty.EofException;
import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.HttpException;
import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.RetryRequest;
import com.replaymod.lib.org.mortbay.jetty.Server;
import com.replaymod.lib.org.mortbay.jetty.handler.AbstractHandler;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.MultiException;
import com.replaymod.lib.org.mortbay.util.MultiMap;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletHandler extends AbstractHandler {
   public static final String __DEFAULT_SERVLET = "default";
   public static final String __J_S_CONTEXT_TEMPDIR = "javax.servlet.context.tempdir";
   public static final String __J_S_ERROR_EXCEPTION = "javax.servlet.error.exception";
   public static final String __J_S_ERROR_EXCEPTION_TYPE = "javax.servlet.error.exception_type";
   public static final String __J_S_ERROR_MESSAGE = "javax.servlet.error.message";
   public static final String __J_S_ERROR_REQUEST_URI = "javax.servlet.error.request_uri";
   public static final String __J_S_ERROR_SERVLET_NAME = "javax.servlet.error.servlet_name";
   public static final String __J_S_ERROR_STATUS_CODE = "javax.servlet.error.status_code";
   private ContextHandler _contextHandler;
   private ContextHandler.SContext _servletContext;
   private FilterHolder[] _filters;
   private FilterMapping[] _filterMappings;
   private boolean _filterChainsCached = true;
   private int _maxFilterChainsCacheSize = 1000;
   private boolean _startWithUnavailable = true;
   private ServletHolder[] _servlets;
   private ServletMapping[] _servletMappings;
   private transient Map _filterNameMap = new HashMap();
   private transient List _filterPathMappings;
   private transient MultiMap _filterNameMappings;
   private transient Map _servletNameMap = new HashMap();
   private transient PathMap _servletPathMap;
   protected transient ServletHandler.MruCache[] _chainCache;

   public void setServer(Server server) {
      if (this.getServer() != null && this.getServer() != server) {
         this.getServer().getContainer().update(this, (Object[])this._filters, (Object[])null, "filter", true);
         this.getServer().getContainer().update(this, (Object[])this._filterMappings, (Object[])null, "filterMapping", true);
         this.getServer().getContainer().update(this, (Object[])this._servlets, (Object[])null, "servlet", true);
         this.getServer().getContainer().update(this, (Object[])this._servletMappings, (Object[])null, "servletMapping", true);
      }

      if (server != null && this.getServer() != server) {
         server.getContainer().update(this, (Object[])null, (Object[])this._filters, "filter", true);
         server.getContainer().update(this, (Object[])null, (Object[])this._filterMappings, "filterMapping", true);
         server.getContainer().update(this, (Object[])null, (Object[])this._servlets, "servlet", true);
         server.getContainer().update(this, (Object[])null, (Object[])this._servletMappings, "servletMapping", true);
      }

      super.setServer(server);
      this.invalidateChainsCache();
   }

   protected synchronized void doStart() throws Exception {
      this._servletContext = ContextHandler.getCurrentContext();
      this._contextHandler = this._servletContext == null ? null : this._servletContext.getContextHandler();
      this.updateNameMappings();
      this.updateMappings();
      if (this._filterChainsCached) {
         this._chainCache = new ServletHandler.MruCache[]{null, new ServletHandler.MruCache(this._maxFilterChainsCacheSize), new ServletHandler.MruCache(this._maxFilterChainsCacheSize), null, new ServletHandler.MruCache(this._maxFilterChainsCacheSize), null, null, null, new ServletHandler.MruCache(this._maxFilterChainsCacheSize)};
      }

      super.doStart();
      if (this._contextHandler == null || !(this._contextHandler instanceof Context)) {
         this.initialize();
      }

   }

   protected synchronized void doStop() throws Exception {
      super.doStop();
      int i;
      if (this._filters != null) {
         i = this._filters.length;

         while(i-- > 0) {
            try {
               this._filters[i].stop();
            } catch (Exception var4) {
               Log.warn("EXCEPTION ", (Throwable)var4);
            }
         }
      }

      if (this._servlets != null) {
         i = this._servlets.length;

         while(i-- > 0) {
            try {
               this._servlets[i].stop();
            } catch (Exception var3) {
               Log.warn("EXCEPTION ", (Throwable)var3);
            }
         }
      }

      this._filterPathMappings = null;
      this._filterNameMappings = null;
      this._servletPathMap = null;
      this._chainCache = null;
   }

   public Object getContextLog() {
      return null;
   }

   public FilterMapping[] getFilterMappings() {
      return this._filterMappings;
   }

   public FilterHolder[] getFilters() {
      return this._filters;
   }

   public PathMap.Entry getHolderEntry(String pathInContext) {
      return this._servletPathMap == null ? null : this._servletPathMap.getMatch(pathInContext);
   }

   public boolean matchesPath(String pathInContext) {
      return this._servletPathMap.containsMatch(pathInContext);
   }

   public RequestDispatcher getRequestDispatcher(String uriInContext) {
      if (uriInContext == null) {
         return null;
      } else if (!uriInContext.startsWith("/")) {
         return null;
      } else {
         try {
            String query = null;
            int q = false;
            int q;
            if ((q = uriInContext.indexOf(63)) > 0) {
               query = uriInContext.substring(q + 1);
               uriInContext = uriInContext.substring(0, q);
            }

            if ((q = uriInContext.indexOf(59)) > 0) {
               uriInContext = uriInContext.substring(0, q);
            }

            String pathInContext = URIUtil.canonicalPath(URIUtil.decodePath(uriInContext));
            String uri = URIUtil.addPaths(this._contextHandler.getContextPath(), uriInContext);
            return new Dispatcher(this._contextHandler, uri, pathInContext, query);
         } catch (Exception var6) {
            Log.ignore(var6);
            return null;
         }
      }
   }

   public ServletContext getServletContext() {
      return this._servletContext;
   }

   public ServletMapping[] getServletMappings() {
      return this._servletMappings;
   }

   public ServletHolder[] getServlets() {
      return this._servlets;
   }

   public ServletHolder getServlet(String name) {
      return (ServletHolder)this._servletNameMap.get(name);
   }

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int type) throws IOException, ServletException {
      if (this.isStarted()) {
         Request base_request = request instanceof Request ? (Request)request : HttpConnection.getCurrentConnection().getRequest();
         String old_servlet_name = base_request.getServletName();
         String old_servlet_path = base_request.getServletPath();
         String old_path_info = base_request.getPathInfo();
         Map old_role_map = base_request.getRoleMap();
         Object request_listeners = null;
         ServletRequestEvent request_event = null;
         boolean var27 = false;

         int i;
         ServletRequestListener listener;
         label533: {
            label534: {
               try {
                  try {
                     var27 = true;
                     ServletHolder servlet_holder = null;
                     FilterChain chain = null;
                     if (target.startsWith("/")) {
                        PathMap.Entry entry = this.getHolderEntry(target);
                        if (entry != null) {
                           servlet_holder = (ServletHolder)entry.getValue();
                           base_request.setServletName(servlet_holder.getName());
                           base_request.setRoleMap(servlet_holder.getRoleMap());
                           if (Log.isDebugEnabled()) {
                              Log.debug("servlet=" + servlet_holder);
                           }

                           String servlet_path_spec = (String)entry.getKey();
                           String servlet_path = entry.getMapped() != null ? entry.getMapped() : PathMap.pathMatch(servlet_path_spec, target);
                           String path_info = PathMap.pathInfo(servlet_path_spec, target);
                           if (type == 4) {
                              base_request.setAttribute("javax.servlet.include.servlet_path", servlet_path);
                              base_request.setAttribute("javax.servlet.include.path_info", path_info);
                           } else {
                              base_request.setServletPath(servlet_path);
                              base_request.setPathInfo(path_info);
                           }

                           if (servlet_holder != null && this._filterMappings != null && this._filterMappings.length > 0) {
                              chain = this.getFilterChain(type, target, servlet_holder);
                           }
                        }
                     } else {
                        servlet_holder = (ServletHolder)this._servletNameMap.get(target);
                        if (servlet_holder != null && this._filterMappings != null && this._filterMappings.length > 0) {
                           base_request.setServletName(servlet_holder.getName());
                           chain = this.getFilterChain(type, (String)null, servlet_holder);
                        }
                     }

                     if (Log.isDebugEnabled()) {
                        Log.debug("chain=" + chain);
                        Log.debug("servlet holder=" + servlet_holder);
                     }

                     request_listeners = base_request.takeRequestListeners();
                     if (request_listeners != null) {
                        request_event = new ServletRequestEvent(this.getServletContext(), request);
                        int s = LazyList.size(request_listeners);

                        for(int i = 0; i < s; ++i) {
                           ServletRequestListener listener = (ServletRequestListener)LazyList.get(request_listeners, i);
                           listener.requestInitialized(request_event);
                        }
                     }

                     if (servlet_holder != null) {
                        base_request.setHandled(true);
                        if (chain != null) {
                           chain.doFilter(request, response);
                           var27 = false;
                        } else {
                           servlet_holder.handle(request, response);
                           var27 = false;
                        }
                     } else {
                        this.notFound(request, response);
                        var27 = false;
                     }
                     break label533;
                  } catch (RetryRequest var28) {
                     base_request.setHandled(false);
                     throw var28;
                  } catch (EofException var29) {
                     throw var29;
                  } catch (RuntimeIOException var30) {
                     throw var30;
                  } catch (Exception var31) {
                     if (type != 1) {
                        if (var31 instanceof IOException) {
                           throw (IOException)var31;
                        }

                        if (var31 instanceof RuntimeException) {
                           throw (RuntimeException)var31;
                        }

                        if (var31 instanceof ServletException) {
                           throw (ServletException)var31;
                        }
                     }
                  } catch (Error var32) {
                     if (type != 1) {
                        throw var32;
                     }

                     Log.warn("Error for " + request.getRequestURI(), (Throwable)var32);
                     if (Log.isDebugEnabled()) {
                        Log.debug(request.toString());
                     }

                     if (!response.isCommitted()) {
                        request.setAttribute("javax.servlet.error.exception_type", var32.getClass());
                        request.setAttribute("javax.servlet.error.exception", var32);
                        response.sendError(500, var32.getMessage());
                        var27 = false;
                     } else if (Log.isDebugEnabled()) {
                        Log.debug("Response already committed for handling ", var32);
                        var27 = false;
                     } else {
                        var27 = false;
                     }
                     break label534;
                  }

                  Throwable th = var31;
                  if (var31 instanceof UnavailableException) {
                     Log.debug((Throwable)var31);
                  } else if (var31 instanceof ServletException) {
                     Log.debug((Throwable)var31);
                     Throwable cause = ((ServletException)var31).getRootCause();
                     if (cause != var31 && cause != null) {
                        th = cause;
                     }
                  }

                  if (th instanceof RetryRequest) {
                     base_request.setHandled(false);
                     throw (RetryRequest)th;
                  }

                  if (th instanceof HttpException) {
                     throw (HttpException)th;
                  }

                  if (th instanceof RuntimeIOException) {
                     throw (RuntimeIOException)th;
                  }

                  if (th instanceof EofException) {
                     throw (EofException)th;
                  }

                  if (Log.isDebugEnabled()) {
                     Log.warn(request.getRequestURI(), (Throwable)th);
                     Log.debug(request.toString());
                  } else if (!(th instanceof IOException) && !(th instanceof UnavailableException)) {
                     Log.warn(request.getRequestURI(), (Throwable)th);
                  } else {
                     Log.warn(request.getRequestURI() + ": " + th);
                  }

                  if (!response.isCommitted()) {
                     request.setAttribute("javax.servlet.error.exception_type", th.getClass());
                     request.setAttribute("javax.servlet.error.exception", th);
                     if (th instanceof UnavailableException) {
                        UnavailableException ue = (UnavailableException)th;
                        if (ue.isPermanent()) {
                           response.sendError(404, ((Throwable)th).getMessage());
                           var27 = false;
                        } else {
                           response.sendError(503, ((Throwable)th).getMessage());
                           var27 = false;
                        }
                     } else {
                        response.sendError(500, ((Throwable)th).getMessage());
                        var27 = false;
                     }
                  } else if (Log.isDebugEnabled()) {
                     Log.debug("Response already committed for handling " + th);
                     var27 = false;
                  } else {
                     var27 = false;
                  }
               } finally {
                  if (var27) {
                     if (request_listeners != null) {
                        int i = LazyList.size(request_listeners);

                        while(i-- > 0) {
                           ServletRequestListener listener = (ServletRequestListener)LazyList.get(request_listeners, i);
                           listener.requestDestroyed(request_event);
                        }
                     }

                     base_request.setServletName(old_servlet_name);
                     base_request.setRoleMap(old_role_map);
                     if (type != 4) {
                        base_request.setServletPath(old_servlet_path);
                        base_request.setPathInfo(old_path_info);
                     }

                  }
               }

               if (request_listeners != null) {
                  i = LazyList.size(request_listeners);

                  while(i-- > 0) {
                     listener = (ServletRequestListener)LazyList.get(request_listeners, i);
                     listener.requestDestroyed(request_event);
                  }
               }

               base_request.setServletName(old_servlet_name);
               base_request.setRoleMap(old_role_map);
               if (type != 4) {
                  base_request.setServletPath(old_servlet_path);
                  base_request.setPathInfo(old_path_info);
               }

               return;
            }

            if (request_listeners != null) {
               i = LazyList.size(request_listeners);

               while(i-- > 0) {
                  listener = (ServletRequestListener)LazyList.get(request_listeners, i);
                  listener.requestDestroyed(request_event);
               }
            }

            base_request.setServletName(old_servlet_name);
            base_request.setRoleMap(old_role_map);
            if (type != 4) {
               base_request.setServletPath(old_servlet_path);
               base_request.setPathInfo(old_path_info);
            }

            return;
         }

         if (request_listeners != null) {
            i = LazyList.size(request_listeners);

            while(i-- > 0) {
               listener = (ServletRequestListener)LazyList.get(request_listeners, i);
               listener.requestDestroyed(request_event);
            }
         }

         base_request.setServletName(old_servlet_name);
         base_request.setRoleMap(old_role_map);
         if (type != 4) {
            base_request.setServletPath(old_servlet_path);
            base_request.setPathInfo(old_path_info);
         }

      }
   }

   private FilterChain getFilterChain(int requestType, String pathInContext, ServletHolder servletHolder) {
      String key = pathInContext == null ? servletHolder.getName() : pathInContext;
      if (this._filterChainsCached && this._chainCache != null) {
         synchronized(this) {
            if (this._chainCache[requestType].containsKey(key)) {
               return (FilterChain)this._chainCache[requestType].get(key);
            }
         }
      }

      Object filters = null;
      if (pathInContext != null && this._filterPathMappings != null) {
         for(int i = 0; i < this._filterPathMappings.size(); ++i) {
            FilterMapping mapping = (FilterMapping)this._filterPathMappings.get(i);
            if (mapping.appliesTo(pathInContext, requestType)) {
               filters = LazyList.add(filters, mapping.getFilterHolder());
            }
         }
      }

      Object chain;
      if (servletHolder != null && this._filterNameMappings != null && this._filterNameMappings.size() > 0 && this._filterNameMappings.size() > 0) {
         chain = this._filterNameMappings.get(servletHolder.getName());

         FilterMapping mapping;
         int i;
         for(i = 0; i < LazyList.size(chain); ++i) {
            mapping = (FilterMapping)LazyList.get(chain, i);
            if (mapping.appliesTo(requestType)) {
               filters = LazyList.add(filters, mapping.getFilterHolder());
            }
         }

         chain = this._filterNameMappings.get("*");

         for(i = 0; i < LazyList.size(chain); ++i) {
            mapping = (FilterMapping)LazyList.get(chain, i);
            if (mapping.appliesTo(requestType)) {
               filters = LazyList.add(filters, mapping.getFilterHolder());
            }
         }
      }

      if (filters == null) {
         return null;
      } else {
         chain = null;
         if (this._filterChainsCached) {
            if (LazyList.size(filters) > 0) {
               chain = new ServletHandler.CachedChain(filters, servletHolder);
            }

            synchronized(this) {
               this._chainCache[requestType].put(key, chain);
            }
         } else if (LazyList.size(filters) > 0) {
            chain = new ServletHandler.Chain(filters, servletHolder);
         }

         return (FilterChain)chain;
      }
   }

   private void invalidateChainsCache() {
      this._chainCache = new ServletHandler.MruCache[]{null, new ServletHandler.MruCache(this._maxFilterChainsCacheSize), new ServletHandler.MruCache(this._maxFilterChainsCacheSize), null, new ServletHandler.MruCache(this._maxFilterChainsCacheSize), null, null, null, new ServletHandler.MruCache(this._maxFilterChainsCacheSize)};
   }

   /** @deprecated */
   public boolean isInitializeAtStart() {
      return false;
   }

   /** @deprecated */
   public void setInitializeAtStart(boolean initializeAtStart) {
   }

   public boolean isAvailable() {
      if (!this.isStarted()) {
         return false;
      } else {
         ServletHolder[] holders = this.getServlets();

         for(int i = 0; i < holders.length; ++i) {
            ServletHolder holder = holders[i];
            if (holder != null && !holder.isAvailable()) {
               return false;
            }
         }

         return true;
      }
   }

   public void setStartWithUnavailable(boolean start) {
      this._startWithUnavailable = start;
   }

   public boolean isStartWithUnavailable() {
      return this._startWithUnavailable;
   }

   public void initialize() throws Exception {
      MultiException mx = new MultiException();
      if (this._filters != null) {
         for(int i = 0; i < this._filters.length; ++i) {
            this._filters[i].start();
         }
      }

      if (this._servlets != null) {
         ServletHolder[] servlets = (ServletHolder[])((ServletHolder[])this._servlets.clone());
         Arrays.sort(servlets);

         for(int i = 0; i < servlets.length; ++i) {
            try {
               if (servlets[i].getClassName() == null && servlets[i].getForcedPath() != null) {
                  ServletHolder forced_holder = (ServletHolder)this._servletPathMap.match(servlets[i].getForcedPath());
                  if (forced_holder == null || forced_holder.getClassName() == null) {
                     mx.add(new IllegalStateException("No forced path servlet for " + servlets[i].getForcedPath()));
                     continue;
                  }

                  servlets[i].setClassName(forced_holder.getClassName());
               }

               servlets[i].start();
            } catch (Throwable var5) {
               Log.debug("EXCEPTION ", var5);
               mx.add(var5);
            }
         }

         mx.ifExceptionThrow();
      }

   }

   public boolean isFilterChainsCached() {
      return this._filterChainsCached;
   }

   public ServletHolder newServletHolder() {
      return new ServletHolder();
   }

   public ServletHolder newServletHolder(Class servlet) {
      return new ServletHolder(servlet);
   }

   public ServletHolder addServletWithMapping(String className, String pathSpec) {
      ServletHolder holder = this.newServletHolder((Class)null);
      holder.setName(className + "-" + holder.hashCode());
      holder.setClassName(className);
      this.addServletWithMapping(holder, pathSpec);
      return holder;
   }

   public ServletHolder addServletWithMapping(Class servlet, String pathSpec) {
      ServletHolder holder = this.newServletHolder(servlet);
      this.setServlets((ServletHolder[])((ServletHolder[])LazyList.addToArray(this.getServlets(), holder, ServletHolder.class)));
      this.addServletWithMapping(holder, pathSpec);
      return holder;
   }

   public void addServletWithMapping(ServletHolder servlet, String pathSpec) {
      ServletHolder[] holders = this.getServlets();
      if (holders != null) {
         holders = (ServletHolder[])((ServletHolder[])holders.clone());
      }

      try {
         this.setServlets((ServletHolder[])((ServletHolder[])LazyList.addToArray(holders, servlet, ServletHolder.class)));
         ServletMapping mapping = new ServletMapping();
         mapping.setServletName(servlet.getName());
         mapping.setPathSpec(pathSpec);
         this.setServletMappings((ServletMapping[])((ServletMapping[])LazyList.addToArray(this.getServletMappings(), mapping, ServletMapping.class)));
      } catch (Exception var5) {
         this.setServlets(holders);
         if (var5 instanceof RuntimeException) {
            throw (RuntimeException)var5;
         } else {
            throw new RuntimeException(var5);
         }
      }
   }

   /** @deprecated */
   public ServletHolder addServlet(String className, String pathSpec) {
      return this.addServletWithMapping(className, pathSpec);
   }

   public void addServlet(ServletHolder holder) {
      this.setServlets((ServletHolder[])((ServletHolder[])LazyList.addToArray(this.getServlets(), holder, ServletHolder.class)));
   }

   public void addServletMapping(ServletMapping mapping) {
      this.setServletMappings((ServletMapping[])((ServletMapping[])LazyList.addToArray(this.getServletMappings(), mapping, ServletMapping.class)));
   }

   public FilterHolder newFilterHolder(Class filter) {
      return new FilterHolder(filter);
   }

   public FilterHolder newFilterHolder() {
      return new FilterHolder();
   }

   public FilterHolder getFilter(String name) {
      return (FilterHolder)this._filterNameMap.get(name);
   }

   public FilterHolder addFilterWithMapping(Class filter, String pathSpec, int dispatches) {
      FilterHolder holder = this.newFilterHolder(filter);
      this.addFilterWithMapping(holder, pathSpec, dispatches);
      return holder;
   }

   public FilterHolder addFilterWithMapping(String className, String pathSpec, int dispatches) {
      FilterHolder holder = this.newFilterHolder((Class)null);
      holder.setName(className + "-" + holder.hashCode());
      holder.setClassName(className);
      this.addFilterWithMapping(holder, pathSpec, dispatches);
      return holder;
   }

   public void addFilterWithMapping(FilterHolder holder, String pathSpec, int dispatches) {
      FilterHolder[] holders = this.getFilters();
      if (holders != null) {
         holders = (FilterHolder[])((FilterHolder[])holders.clone());
      }

      try {
         this.setFilters((FilterHolder[])((FilterHolder[])LazyList.addToArray(holders, holder, FilterHolder.class)));
         FilterMapping mapping = new FilterMapping();
         mapping.setFilterName(holder.getName());
         mapping.setPathSpec(pathSpec);
         mapping.setDispatches(dispatches);
         this.setFilterMappings((FilterMapping[])((FilterMapping[])LazyList.addToArray(this.getFilterMappings(), mapping, FilterMapping.class)));
      } catch (RuntimeException var6) {
         this.setFilters(holders);
         throw var6;
      } catch (Error var7) {
         this.setFilters(holders);
         throw var7;
      }
   }

   /** @deprecated */
   public FilterHolder addFilter(String className, String pathSpec, int dispatches) {
      return this.addFilterWithMapping(className, pathSpec, dispatches);
   }

   public void addFilter(FilterHolder filter, FilterMapping filterMapping) {
      if (filter != null) {
         this.setFilters((FilterHolder[])((FilterHolder[])LazyList.addToArray(this.getFilters(), filter, FilterHolder.class)));
      }

      if (filterMapping != null) {
         this.setFilterMappings((FilterMapping[])((FilterMapping[])LazyList.addToArray(this.getFilterMappings(), filterMapping, FilterMapping.class)));
      }

   }

   public void addFilter(FilterHolder filter) {
      if (filter != null) {
         this.setFilters((FilterHolder[])((FilterHolder[])LazyList.addToArray(this.getFilters(), filter, FilterHolder.class)));
      }

   }

   public void addFilterMapping(FilterMapping mapping) {
      if (mapping != null) {
         this.setFilterMappings((FilterMapping[])((FilterMapping[])LazyList.addToArray(this.getFilterMappings(), mapping, FilterMapping.class)));
      }

   }

   protected synchronized void updateNameMappings() {
      this._filterNameMap.clear();
      int i;
      if (this._filters != null) {
         for(i = 0; i < this._filters.length; ++i) {
            this._filterNameMap.put(this._filters[i].getName(), this._filters[i]);
            this._filters[i].setServletHandler(this);
         }
      }

      this._servletNameMap.clear();
      if (this._servlets != null) {
         for(i = 0; i < this._servlets.length; ++i) {
            this._servletNameMap.put(this._servlets[i].getName(), this._servlets[i]);
            this._servlets[i].setServletHandler(this);
         }
      }

   }

   protected synchronized void updateMappings() {
      if (this._filterMappings == null) {
         this._filterPathMappings = null;
         this._filterNameMappings = null;
      } else {
         this._filterPathMappings = new ArrayList();
         this._filterNameMappings = new MultiMap();

         for(int i = 0; i < this._filterMappings.length; ++i) {
            FilterHolder filter_holder = (FilterHolder)this._filterNameMap.get(this._filterMappings[i].getFilterName());
            if (filter_holder == null) {
               throw new IllegalStateException("No filter named " + this._filterMappings[i].getFilterName());
            }

            this._filterMappings[i].setFilterHolder(filter_holder);
            if (this._filterMappings[i].getPathSpecs() != null) {
               this._filterPathMappings.add(this._filterMappings[i]);
            }

            if (this._filterMappings[i].getServletNames() != null) {
               String[] names = this._filterMappings[i].getServletNames();

               for(int j = 0; j < names.length; ++j) {
                  if (names[j] != null) {
                     this._filterNameMappings.add(names[j], this._filterMappings[i]);
                  }
               }
            }
         }
      }

      if (this._servletMappings != null && this._servletNameMap != null) {
         PathMap pm = new PathMap();

         for(int i = 0; i < this._servletMappings.length; ++i) {
            ServletHolder servlet_holder = (ServletHolder)this._servletNameMap.get(this._servletMappings[i].getServletName());
            if (servlet_holder == null) {
               throw new IllegalStateException("No such servlet: " + this._servletMappings[i].getServletName());
            }

            if (this._servletMappings[i].getPathSpecs() != null) {
               String[] pathSpecs = this._servletMappings[i].getPathSpecs();

               for(int j = 0; j < pathSpecs.length; ++j) {
                  if (pathSpecs[j] != null) {
                     pm.put(pathSpecs[j], servlet_holder);
                  }
               }
            }
         }

         this._servletPathMap = pm;
      } else {
         this._servletPathMap = null;
      }

      if (Log.isDebugEnabled()) {
         Log.debug("filterNameMap=" + this._filterNameMap);
         Log.debug("pathFilters=" + this._filterPathMappings);
         Log.debug("servletFilterMap=" + this._filterNameMappings);
         Log.debug("servletPathMap=" + this._servletPathMap);
         Log.debug("servletNameMap=" + this._servletNameMap);
      }

      try {
         if (this.isStarted()) {
            this.initialize();
         }

      } catch (Exception var6) {
         throw new RuntimeException(var6);
      }
   }

   protected void notFound(HttpServletRequest request, HttpServletResponse response) throws IOException {
      if (Log.isDebugEnabled()) {
         Log.debug("Not Found " + request.getRequestURI());
      }

      response.sendError(404);
   }

   public void setFilterChainsCached(boolean filterChainsCached) {
      this._filterChainsCached = filterChainsCached;
   }

   public void setFilterMappings(FilterMapping[] filterMappings) {
      if (this.getServer() != null) {
         this.getServer().getContainer().update(this, (Object[])this._filterMappings, (Object[])filterMappings, "filterMapping", true);
      }

      this._filterMappings = filterMappings;
      this.updateMappings();
      this.invalidateChainsCache();
   }

   public synchronized void setFilters(FilterHolder[] holders) {
      if (this.getServer() != null) {
         this.getServer().getContainer().update(this, (Object[])this._filters, (Object[])holders, "filter", true);
      }

      this._filters = holders;
      this.updateNameMappings();
      this.invalidateChainsCache();
   }

   public void setServletMappings(ServletMapping[] servletMappings) {
      if (this.getServer() != null) {
         this.getServer().getContainer().update(this, (Object[])this._servletMappings, (Object[])servletMappings, "servletMapping", true);
      }

      this._servletMappings = servletMappings;
      this.updateMappings();
      this.invalidateChainsCache();
   }

   public synchronized void setServlets(ServletHolder[] holders) {
      if (this.getServer() != null) {
         this.getServer().getContainer().update(this, (Object[])this._servlets, (Object[])holders, "servlet", true);
      }

      this._servlets = holders;
      this.updateNameMappings();
      this.invalidateChainsCache();
   }

   public int getMaxFilterChainsCacheSize() {
      return this._maxFilterChainsCacheSize;
   }

   public void setMaxFilterChainsCacheSize(int maxFilterChainsCacheSize) {
      this._maxFilterChainsCacheSize = maxFilterChainsCacheSize;

      for(int i = 0; i < this._chainCache.length; ++i) {
         if (this._chainCache[i] != null && this._chainCache[i] instanceof ServletHandler.MruCache) {
            this._chainCache[i].setMaxEntries(maxFilterChainsCacheSize);
         }
      }

   }

   public Servlet customizeServlet(Servlet servlet) throws Exception {
      return servlet;
   }

   public Servlet customizeServletDestroy(Servlet servlet) throws Exception {
      return servlet;
   }

   public Filter customizeFilter(Filter filter) throws Exception {
      return filter;
   }

   public Filter customizeFilterDestroy(Filter filter) throws Exception {
      return filter;
   }

   private class Chain implements FilterChain {
      int _filter = 0;
      Object _chain;
      ServletHolder _servletHolder;

      Chain(Object filters, ServletHolder servletHolder) {
         this._chain = filters;
         this._servletHolder = servletHolder;
      }

      public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
         if (Log.isDebugEnabled()) {
            Log.debug("doFilter " + this._filter);
         }

         if (this._filter < LazyList.size(this._chain)) {
            FilterHolder holder = (FilterHolder)LazyList.get(this._chain, this._filter++);
            if (Log.isDebugEnabled()) {
               Log.debug("call filter " + holder);
            }

            Filter filter = holder.getFilter();
            filter.doFilter(request, response, this);
         } else {
            if (this._servletHolder != null) {
               if (Log.isDebugEnabled()) {
                  Log.debug("call servlet " + this._servletHolder);
               }

               this._servletHolder.handle(request, response);
            } else {
               ServletHandler.this.notFound((HttpServletRequest)request, (HttpServletResponse)response);
            }

         }
      }

      public String toString() {
         StringBuffer b = new StringBuffer();

         for(int i = 0; i < LazyList.size(this._chain); ++i) {
            b.append(LazyList.get(this._chain, i).toString());
            b.append("->");
         }

         b.append(this._servletHolder);
         return b.toString();
      }
   }

   private class CachedChain implements FilterChain {
      FilterHolder _filterHolder;
      ServletHandler.CachedChain _next;
      ServletHolder _servletHolder;

      CachedChain(Object filters, ServletHolder servletHolder) {
         if (LazyList.size(filters) > 0) {
            this._filterHolder = (FilterHolder)LazyList.get(filters, 0);
            filters = LazyList.remove(filters, 0);
            this._next = ServletHandler.this.new CachedChain(filters, servletHolder);
         } else {
            this._servletHolder = servletHolder;
         }

      }

      public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
         if (this._filterHolder != null) {
            if (Log.isDebugEnabled()) {
               Log.debug("call filter " + this._filterHolder);
            }

            Filter filter = this._filterHolder.getFilter();
            filter.doFilter(request, response, this._next);
         } else {
            if (this._servletHolder != null) {
               if (Log.isDebugEnabled()) {
                  Log.debug("call servlet " + this._servletHolder);
               }

               this._servletHolder.handle(request, response);
            } else {
               ServletHandler.this.notFound((HttpServletRequest)request, (HttpServletResponse)response);
            }

         }
      }

      public String toString() {
         if (this._filterHolder != null) {
            return this._filterHolder + "->" + this._next.toString();
         } else {
            return this._servletHolder != null ? this._servletHolder.toString() : "null";
         }
      }
   }

   private class MruCache extends LinkedHashMap {
      private int maxEntries = 1000;

      public MruCache() {
      }

      public MruCache(int maxSize) {
         this.setMaxEntries(maxSize);
      }

      protected boolean removeEldestEntry(Entry eldest) {
         return this.size() > this.maxEntries;
      }

      public void setMaxEntries(int maxEntries) {
         this.maxEntries = maxEntries;
      }
   }
}
