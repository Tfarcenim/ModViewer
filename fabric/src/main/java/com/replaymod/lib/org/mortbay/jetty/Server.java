package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.component.Container;
import com.replaymod.lib.org.mortbay.component.LifeCycle;
import com.replaymod.lib.org.mortbay.jetty.bio.SocketConnector;
import com.replaymod.lib.org.mortbay.jetty.handler.HandlerCollection;
import com.replaymod.lib.org.mortbay.jetty.handler.HandlerWrapper;
import com.replaymod.lib.org.mortbay.jetty.security.UserRealm;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.thread.QueuedThreadPool;
import com.replaymod.lib.org.mortbay.thread.ThreadPool;
import com.replaymod.lib.org.mortbay.util.Attributes;
import com.replaymod.lib.org.mortbay.util.AttributesMap;
import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.MultiException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.ServletException;

public class Server extends HandlerWrapper implements Attributes {
   public static final String UNKNOWN_VERSION = "6.1.x";
   public static final String SNAPSHOT_VERSION = "6.1-SNAPSHOT";
   private static Server.ShutdownHookThread hookThread = new Server.ShutdownHookThread();
   private static String _version;
   private ThreadPool _threadPool;
   private Connector[] _connectors;
   private UserRealm[] _realms;
   private Container _container = new Container();
   private SessionIdManager _sessionIdManager;
   private boolean _sendServerVersion = true;
   private boolean _sendDateHeader = false;
   private AttributesMap _attributes = new AttributesMap();
   private List _dependentLifeCycles = new ArrayList();
   private int _graceful = 0;

   public Server() {
      this.setServer(this);
   }

   public Server(int port) {
      this.setServer(this);
      Connector connector = new SocketConnector();
      connector.setPort(port);
      this.setConnectors(new Connector[]{connector});
   }

   public static String getVersion() {
      return _version;
   }

   public Container getContainer() {
      return this._container;
   }

   public boolean getStopAtShutdown() {
      return hookThread.contains(this);
   }

   public void setStopAtShutdown(boolean stop) {
      if (stop) {
         hookThread.add(this);
      } else {
         hookThread.remove(this);
      }

   }

   public Connector[] getConnectors() {
      return this._connectors;
   }

   public void addConnector(Connector connector) {
      this.setConnectors((Connector[])((Connector[])LazyList.addToArray(this.getConnectors(), connector, Connector.class)));
   }

   public void removeConnector(Connector connector) {
      this.setConnectors((Connector[])((Connector[])LazyList.removeFromArray(this.getConnectors(), connector)));
   }

   public void setConnectors(Connector[] connectors) {
      if (connectors != null) {
         for(int i = 0; i < connectors.length; ++i) {
            connectors[i].setServer(this);
         }
      }

      this._container.update(this, (Object[])this._connectors, (Object[])connectors, "connector");
      this._connectors = connectors;
   }

   public ThreadPool getThreadPool() {
      return this._threadPool;
   }

   public void setThreadPool(ThreadPool threadPool) {
      this._container.update(this, (Object)this._threadPool, (Object)threadPool, "threadpool", true);
      this._threadPool = threadPool;
   }

   protected void doStart() throws Exception {
      Log.info("jetty-" + _version);
      HttpGenerator.setServerVersion(_version);
      MultiException mex = new MultiException();

      for(int i = 0; this._realms != null && i < this._realms.length; ++i) {
         if (this._realms[i] instanceof LifeCycle) {
            ((LifeCycle)this._realms[i]).start();
         }
      }

      Iterator itor = this._dependentLifeCycles.iterator();

      while(itor.hasNext()) {
         try {
            ((LifeCycle)itor.next()).start();
         } catch (Throwable var8) {
            mex.add(var8);
         }
      }

      if (this._threadPool == null) {
         QueuedThreadPool tp = new QueuedThreadPool();
         this.setThreadPool(tp);
      }

      if (this._sessionIdManager != null) {
         this._sessionIdManager.start();
      }

      try {
         if (this._threadPool instanceof LifeCycle) {
            ((LifeCycle)this._threadPool).start();
         }
      } catch (Throwable var7) {
         mex.add(var7);
      }

      try {
         super.doStart();
      } catch (Throwable var6) {
         Log.warn("Error starting handlers", var6);
      }

      if (this._connectors != null) {
         for(int i = 0; i < this._connectors.length; ++i) {
            try {
               this._connectors[i].start();
            } catch (Throwable var5) {
               mex.add(var5);
            }
         }
      }

      mex.ifExceptionThrow();
   }

   protected void doStop() throws Exception {
      MultiException mex = new MultiException();

      int i;
      for(i = 0; this._realms != null && i < this._realms.length; ++i) {
         if (this._realms[i] instanceof LifeCycle) {
            ((LifeCycle)this._realms[i]).stop();
         }
      }

      if (this._graceful > 0) {
         if (this._connectors != null) {
            i = this._connectors.length;

            while(i-- > 0) {
               Log.info("Graceful shutdown {}", this._connectors[i]);

               try {
                  this._connectors[i].close();
               } catch (Throwable var9) {
                  mex.add(var9);
               }
            }
         }

         Handler[] contexts = this.getChildHandlersByClass(Server.Graceful.class);

         for(int c = 0; c < contexts.length; ++c) {
            Server.Graceful context = (Server.Graceful)contexts[c];
            Log.info("Graceful shutdown {}", context);
            context.setShutdown(true);
         }

         Thread.sleep((long)this._graceful);
      }

      if (this._connectors != null) {
         i = this._connectors.length;

         while(i-- > 0) {
            try {
               this._connectors[i].stop();
            } catch (Throwable var8) {
               mex.add(var8);
            }
         }
      }

      try {
         super.doStop();
      } catch (Throwable var7) {
         mex.add(var7);
      }

      if (this._sessionIdManager != null) {
         this._sessionIdManager.stop();
      }

      try {
         if (this._threadPool instanceof LifeCycle) {
            ((LifeCycle)this._threadPool).stop();
         }
      } catch (Throwable var6) {
         mex.add(var6);
      }

      if (!this._dependentLifeCycles.isEmpty()) {
         ListIterator itor = this._dependentLifeCycles.listIterator(this._dependentLifeCycles.size());

         while(itor.hasPrevious()) {
            try {
               ((LifeCycle)itor.previous()).stop();
            } catch (Throwable var5) {
               mex.add(var5);
            }
         }
      }

      mex.ifExceptionThrow();
   }

   public void handle(HttpConnection connection) throws IOException, ServletException {
      String target = connection.getRequest().getPathInfo();
      if (Log.isDebugEnabled()) {
         Log.debug("REQUEST " + target + " on " + connection);
         this.handle(target, connection.getRequest(), connection.getResponse(), 1);
         Log.debug("RESPONSE " + target + "  " + connection.getResponse().getStatus());
      } else {
         this.handle(target, connection.getRequest(), connection.getResponse(), 1);
      }

   }

   public void join() throws InterruptedException {
      this.getThreadPool().join();
   }

   public UserRealm[] getUserRealms() {
      return this._realms;
   }

   public void setUserRealms(UserRealm[] realms) {
      this._container.update(this, (Object[])this._realms, (Object[])realms, "realm", true);
      this._realms = realms;
   }

   public void addUserRealm(UserRealm realm) {
      this.setUserRealms((UserRealm[])((UserRealm[])LazyList.addToArray(this.getUserRealms(), realm, UserRealm.class)));
   }

   public void removeUserRealm(UserRealm realm) {
      this.setUserRealms((UserRealm[])((UserRealm[])LazyList.removeFromArray(this.getUserRealms(), realm)));
   }

   public SessionIdManager getSessionIdManager() {
      return this._sessionIdManager;
   }

   public void setSessionIdManager(SessionIdManager sessionIdManager) {
      this._container.update(this, (Object)this._sessionIdManager, (Object)sessionIdManager, "sessionIdManager", true);
      this._sessionIdManager = sessionIdManager;
   }

   public void setSendServerVersion(boolean sendServerVersion) {
      this._sendServerVersion = sendServerVersion;
   }

   public boolean getSendServerVersion() {
      return this._sendServerVersion;
   }

   public void setSendDateHeader(boolean sendDateHeader) {
      this._sendDateHeader = sendDateHeader;
   }

   public boolean getSendDateHeader() {
      return this._sendDateHeader;
   }

   public void addLifeCycle(LifeCycle c) {
      if (c != null) {
         if (!this._dependentLifeCycles.contains(c)) {
            this._dependentLifeCycles.add(c);
            this._container.addBean(c);
         }

         try {
            if (this.isStarted()) {
               c.start();
            }

         } catch (Exception var3) {
            throw new RuntimeException(var3);
         }
      }
   }

   public void removeLifeCycle(LifeCycle c) {
      if (c != null) {
         this._dependentLifeCycles.remove(c);
         this._container.removeBean(c);
      }
   }

   public void addHandler(Handler handler) {
      if (this.getHandler() == null) {
         this.setHandler(handler);
      } else if (this.getHandler() instanceof HandlerCollection) {
         ((HandlerCollection)this.getHandler()).addHandler(handler);
      } else {
         HandlerCollection collection = new HandlerCollection();
         collection.setHandlers(new Handler[]{this.getHandler(), handler});
         this.setHandler(collection);
      }

   }

   public void removeHandler(Handler handler) {
      if (this.getHandler() instanceof HandlerCollection) {
         ((HandlerCollection)this.getHandler()).removeHandler(handler);
      }

   }

   public Handler[] getHandlers() {
      return this.getHandler() instanceof HandlerCollection ? ((HandlerCollection)this.getHandler()).getHandlers() : null;
   }

   public void setHandlers(Handler[] handlers) {
      HandlerCollection collection;
      if (this.getHandler() instanceof HandlerCollection) {
         collection = (HandlerCollection)this.getHandler();
      } else {
         collection = new HandlerCollection();
         this.setHandler(collection);
      }

      collection.setHandlers(handlers);
   }

   public void clearAttributes() {
      this._attributes.clearAttributes();
   }

   public Object getAttribute(String name) {
      return this._attributes.getAttribute(name);
   }

   public Enumeration getAttributeNames() {
      return AttributesMap.getAttributeNamesCopy(this._attributes);
   }

   public void removeAttribute(String name) {
      this._attributes.removeAttribute(name);
   }

   public void setAttribute(String name, Object attribute) {
      this._attributes.setAttribute(name, attribute);
   }

   public int getGracefulShutdown() {
      return this._graceful;
   }

   public void setGracefulShutdown(int timeoutMS) {
      this._graceful = timeoutMS;
   }

   static {
      _version = Server.class.getPackage() != null && Server.class.getPackage().getImplementationVersion() != null ? Server.class.getPackage().getImplementationVersion() : "6.1.x";
   }

   public interface Graceful {
      void setShutdown(boolean var1);
   }

   private static class ShutdownHookThread extends Thread {
      private boolean hooked;
      private ArrayList servers;

      private ShutdownHookThread() {
         this.hooked = false;
         this.servers = new ArrayList();
      }

      private void createShutdownHook() {
         if (!Boolean.getBoolean("JETTY_NO_SHUTDOWN_HOOK") && !this.hooked) {
            try {
               Method shutdownHook = Runtime.class.getMethod("addShutdownHook", Thread.class);
               shutdownHook.invoke(Runtime.getRuntime(), this);
               this.hooked = true;
            } catch (Exception var2) {
               if (Log.isDebugEnabled()) {
                  Log.debug("No shutdown hook in JVM ", var2);
               }
            }
         }

      }

      public boolean add(Server server) {
         this.createShutdownHook();
         return this.servers.add(server);
      }

      public boolean contains(Server server) {
         return this.servers.contains(server);
      }

      public boolean addAll(Collection c) {
         this.createShutdownHook();
         return this.servers.addAll(c);
      }

      public void clear() {
         this.createShutdownHook();
         this.servers.clear();
      }

      public boolean remove(Server server) {
         this.createShutdownHook();
         return this.servers.remove(server);
      }

      public boolean removeAll(Collection c) {
         this.createShutdownHook();
         return this.servers.removeAll(c);
      }

      public void run() {
         this.setName("Shutdown");
         Log.info("Shutdown hook executing");
         Iterator it = this.servers.iterator();

         while(it.hasNext()) {
            Server svr = (Server)it.next();
            if (svr != null) {
               try {
                  svr.stop();
               } catch (Exception var5) {
                  Log.warn((Throwable)var5);
               }

               Log.info("Shutdown hook complete");

               try {
                  Thread.sleep(1000L);
               } catch (Exception var4) {
                  Log.warn((Throwable)var4);
               }
            }
         }

      }

      // $FF: synthetic method
      ShutdownHookThread(Object x0) {
         this();
      }
   }
}
