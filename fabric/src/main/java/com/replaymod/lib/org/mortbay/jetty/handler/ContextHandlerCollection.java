package com.replaymod.lib.org.mortbay.jetty.handler;

import com.replaymod.lib.org.mortbay.jetty.Handler;
import com.replaymod.lib.org.mortbay.jetty.HandlerContainer;
import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.servlet.PathMap;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.LazyList;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextHandlerCollection extends HandlerCollection {
   private PathMap _contextMap;
   private Class _contextClass;

   public ContextHandlerCollection() {
      this._contextClass = ContextHandler.class;
   }

   public void mapContexts() {
      PathMap contextMap = new PathMap();
      Handler[] branches = this.getHandlers();

      for(int b = 0; branches != null && b < branches.length; ++b) {
         Handler[] handlers = null;
         if (branches[b] instanceof ContextHandler) {
            handlers = new Handler[]{branches[b]};
         } else {
            if (!(branches[b] instanceof HandlerContainer)) {
               continue;
            }

            handlers = ((HandlerContainer)branches[b]).getChildHandlersByClass(ContextHandler.class);
         }

         for(int i = 0; i < handlers.length; ++i) {
            ContextHandler handler = (ContextHandler)handlers[i];
            String contextPath = handler.getContextPath();
            if (contextPath == null || contextPath.indexOf(44) >= 0 || contextPath.startsWith("*")) {
               throw new IllegalArgumentException("Illegal context spec:" + contextPath);
            }

            if (!contextPath.startsWith("/")) {
               contextPath = '/' + contextPath;
            }

            if (contextPath.length() > 1) {
               if (contextPath.endsWith("/")) {
                  contextPath = contextPath + "*";
               } else if (!contextPath.endsWith("/*")) {
                  contextPath = contextPath + "/*";
               }
            }

            Object contexts = contextMap.get(contextPath);
            String[] vhosts = handler.getVirtualHosts();
            if (vhosts != null && vhosts.length > 0) {
               Object hosts;
               if (contexts instanceof Map) {
                  hosts = (Map)contexts;
               } else {
                  hosts = new HashMap();
                  ((Map)hosts).put("*", contexts);
                  contextMap.put(contextPath, hosts);
               }

               for(int j = 0; j < vhosts.length; ++j) {
                  String vhost = vhosts[j];
                  contexts = ((Map)hosts).get(vhost);
                  contexts = LazyList.add(contexts, branches[b]);
                  ((Map)hosts).put(vhost, contexts);
               }
            } else if (contexts instanceof Map) {
               Map hosts = (Map)contexts;
               contexts = hosts.get("*");
               contexts = LazyList.add(contexts, branches[b]);
               hosts.put("*", contexts);
            } else {
               contexts = LazyList.add(contexts, branches[b]);
               contextMap.put(contextPath, contexts);
            }
         }
      }

      this._contextMap = contextMap;
   }

   public void setHandlers(Handler[] handlers) {
      this._contextMap = null;
      super.setHandlers(handlers);
      if (this.isStarted()) {
         this.mapContexts();
      }

   }

   protected void doStart() throws Exception {
      this.mapContexts();
      super.doStart();
   }

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
      Handler[] handlers = this.getHandlers();
      if (handlers != null && handlers.length != 0) {
         Request base_request = HttpConnection.getCurrentConnection().getRequest();
         PathMap map = this._contextMap;
         if (map != null && target != null && target.startsWith("/")) {
            Object contexts = map.getLazyMatches(target);

            for(int i = 0; i < LazyList.size(contexts); ++i) {
               Entry entry = (Entry)LazyList.get(contexts, i);
               Object list = entry.getValue();
               if (!(list instanceof Map)) {
                  for(int j = 0; j < LazyList.size(list); ++j) {
                     Handler handler = (Handler)LazyList.get(list, j);
                     handler.handle(target, request, response, dispatch);
                     if (base_request.isHandled()) {
                        return;
                     }
                  }
               } else {
                  Map hosts = (Map)list;
                  String host = this.normalizeHostname(request.getServerName());
                  list = hosts.get(host);

                  int j;
                  Handler handler;
                  for(j = 0; j < LazyList.size(list); ++j) {
                     handler = (Handler)LazyList.get(list, j);
                     handler.handle(target, request, response, dispatch);
                     if (base_request.isHandled()) {
                        return;
                     }
                  }

                  list = hosts.get("*." + host.substring(host.indexOf(".") + 1));

                  for(j = 0; j < LazyList.size(list); ++j) {
                     handler = (Handler)LazyList.get(list, j);
                     handler.handle(target, request, response, dispatch);
                     if (base_request.isHandled()) {
                        return;
                     }
                  }

                  list = hosts.get("*");

                  for(j = 0; j < LazyList.size(list); ++j) {
                     handler = (Handler)LazyList.get(list, j);
                     handler.handle(target, request, response, dispatch);
                     if (base_request.isHandled()) {
                        return;
                     }
                  }
               }
            }
         } else {
            for(int i = 0; i < handlers.length; ++i) {
               handlers[i].handle(target, request, response, dispatch);
               if (base_request.isHandled()) {
                  return;
               }
            }
         }

      }
   }

   public ContextHandler addContext(String contextPath, String resourceBase) {
      try {
         ContextHandler context = (ContextHandler)this._contextClass.newInstance();
         context.setContextPath(contextPath);
         context.setResourceBase(resourceBase);
         this.addHandler(context);
         return context;
      } catch (Exception var4) {
         Log.debug((Throwable)var4);
         throw new Error(var4);
      }
   }

   public Class getContextClass() {
      return this._contextClass;
   }

   public void setContextClass(Class contextClass) {
      if (contextClass != null && ContextHandler.class.isAssignableFrom(contextClass)) {
         this._contextClass = contextClass;
      } else {
         throw new IllegalArgumentException();
      }
   }

   private String normalizeHostname(String host) {
      if (host == null) {
         return null;
      } else {
         return host.endsWith(".") ? host.substring(0, host.length() - 1) : host;
      }
   }
}
