package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.component.LifeCycle;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.thread.ThreadPool;
import com.replaymod.lib.org.mortbay.util.ajax.Continuation;
import com.replaymod.lib.org.mortbay.util.ajax.WaitingContinuation;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class AbstractConnector extends AbstractBuffers implements Connector {
   private String _name;
   private Server _server;
   private ThreadPool _threadPool;
   private String _host;
   private int _port = 0;
   private String _integralScheme = "https";
   private int _integralPort = 0;
   private String _confidentialScheme = "https";
   private int _confidentialPort = 0;
   private int _acceptQueueSize = 0;
   private int _acceptors = 1;
   private int _acceptorPriorityOffset = 0;
   private boolean _useDNS;
   private boolean _forwarded;
   private String _hostHeader;
   private String _forwardedHostHeader = "X-Forwarded-Host";
   private String _forwardedServerHeader = "X-Forwarded-Server";
   private String _forwardedForHeader = "X-Forwarded-For";
   private boolean _reuseAddress = true;
   protected int _maxIdleTime = 200000;
   protected int _lowResourceMaxIdleTime = -1;
   protected int _soLingerTime = -1;
   private transient Thread[] _acceptorThread;
   Object _statsLock = new Object();
   transient long _statsStartedAt = -1L;
   transient int _requests;
   transient int _connections;
   transient int _connectionsOpen;
   transient int _connectionsOpenMin;
   transient int _connectionsOpenMax;
   transient long _connectionsDurationMin;
   transient long _connectionsDurationMax;
   transient long _connectionsDurationTotal;
   transient int _connectionsRequestsMin;
   transient int _connectionsRequestsMax;

   public Server getServer() {
      return this._server;
   }

   public void setServer(Server server) {
      this._server = server;
   }

   public ThreadPool getThreadPool() {
      return this._threadPool;
   }

   public void setThreadPool(ThreadPool pool) {
      this._threadPool = pool;
   }

   public void setHost(String host) {
      this._host = host;
   }

   public String getHost() {
      return this._host;
   }

   public void setPort(int port) {
      this._port = port;
   }

   public int getPort() {
      return this._port;
   }

   public int getMaxIdleTime() {
      return this._maxIdleTime;
   }

   public void setMaxIdleTime(int maxIdleTime) {
      this._maxIdleTime = maxIdleTime;
   }

   public int getLowResourceMaxIdleTime() {
      return this._lowResourceMaxIdleTime;
   }

   public void setLowResourceMaxIdleTime(int maxIdleTime) {
      this._lowResourceMaxIdleTime = maxIdleTime;
   }

   public int getSoLingerTime() {
      return this._soLingerTime;
   }

   public int getAcceptQueueSize() {
      return this._acceptQueueSize;
   }

   public void setAcceptQueueSize(int acceptQueueSize) {
      this._acceptQueueSize = acceptQueueSize;
   }

   public int getAcceptors() {
      return this._acceptors;
   }

   public void setAcceptors(int acceptors) {
      this._acceptors = acceptors;
   }

   public void setSoLingerTime(int soLingerTime) {
      this._soLingerTime = soLingerTime;
   }

   protected void doStart() throws Exception {
      if (this._server == null) {
         throw new IllegalStateException("No server");
      } else {
         this.open();
         super.doStart();
         if (this._threadPool == null) {
            this._threadPool = this._server.getThreadPool();
         }

         if (this._threadPool != this._server.getThreadPool() && this._threadPool instanceof LifeCycle) {
            ((LifeCycle)this._threadPool).start();
         }

         synchronized(this) {
            this._acceptorThread = new Thread[this.getAcceptors()];
            int i = 0;

            while(i < this._acceptorThread.length) {
               if (this._threadPool.dispatch(new AbstractConnector.Acceptor(i))) {
                  ++i;
               } else {
                  Log.warn("insufficient maxThreads configured for {}", (Object)this);
                  break;
               }
            }
         }

         Log.info("Started {}", this);
      }
   }

   protected void doStop() throws Exception {
      Log.info("Stopped {}", this);

      try {
         this.close();
      } catch (IOException var5) {
         Log.warn((Throwable)var5);
      }

      if (this._threadPool == this._server.getThreadPool()) {
         this._threadPool = null;
      } else if (this._threadPool instanceof LifeCycle) {
         ((LifeCycle)this._threadPool).stop();
      }

      super.doStop();
      Thread[] acceptors = null;
      synchronized(this) {
         acceptors = this._acceptorThread;
         this._acceptorThread = null;
      }

      if (acceptors != null) {
         for(int i = 0; i < acceptors.length; ++i) {
            Thread thread = acceptors[i];
            if (thread != null) {
               thread.interrupt();
            }
         }
      }

   }

   public void join() throws InterruptedException {
      Thread[] threads = this._acceptorThread;
      if (threads != null) {
         for(int i = 0; i < threads.length; ++i) {
            if (threads[i] != null) {
               threads[i].join();
            }
         }
      }

   }

   protected void configure(Socket socket) throws IOException {
      try {
         socket.setTcpNoDelay(true);
         if (this._maxIdleTime >= 0) {
            socket.setSoTimeout(this._maxIdleTime);
         }

         if (this._soLingerTime >= 0) {
            socket.setSoLinger(true, this._soLingerTime / 1000);
         } else {
            socket.setSoLinger(false, 0);
         }
      } catch (Exception var3) {
         Log.ignore(var3);
      }

   }

   public void customize(EndPoint endpoint, Request request) throws IOException {
      if (this.isForwarded()) {
         this.checkForwardedHeaders(endpoint, request);
      }

   }

   protected void checkForwardedHeaders(EndPoint endpoint, Request request) throws IOException {
      HttpFields httpFields = request.getConnection().getRequestFields();
      String forwardedHost = this.getLeftMostValue(httpFields.getStringField(this.getForwardedHostHeader()));
      String forwardedServer = this.getLeftMostValue(httpFields.getStringField(this.getForwardedServerHeader()));
      String forwardedFor = this.getLeftMostValue(httpFields.getStringField(this.getForwardedForHeader()));
      if (this._hostHeader != null) {
         httpFields.put(HttpHeaders.HOST_BUFFER, this._hostHeader);
         request.setServerName((String)null);
         request.setServerPort(-1);
         request.getServerName();
      } else if (forwardedHost != null) {
         httpFields.put(HttpHeaders.HOST_BUFFER, forwardedHost);
         request.setServerName((String)null);
         request.setServerPort(-1);
         request.getServerName();
      } else if (forwardedServer != null) {
         request.setServerName(forwardedServer);
      }

      if (forwardedFor != null) {
         request.setRemoteAddr(forwardedFor);
         InetAddress inetAddress = null;
         if (this._useDNS) {
            try {
               inetAddress = InetAddress.getByName(forwardedFor);
            } catch (UnknownHostException var9) {
               Log.ignore(var9);
            }
         }

         request.setRemoteHost(inetAddress == null ? forwardedFor : inetAddress.getHostName());
      }

   }

   protected String getLeftMostValue(String headerValue) {
      if (headerValue == null) {
         return null;
      } else {
         int commaIndex = headerValue.indexOf(44);
         return commaIndex == -1 ? headerValue : headerValue.substring(0, commaIndex);
      }
   }

   public void persist(EndPoint endpoint) throws IOException {
   }

   public int getConfidentialPort() {
      return this._confidentialPort;
   }

   public String getConfidentialScheme() {
      return this._confidentialScheme;
   }

   public boolean isIntegral(Request request) {
      return false;
   }

   public int getIntegralPort() {
      return this._integralPort;
   }

   public String getIntegralScheme() {
      return this._integralScheme;
   }

   public boolean isConfidential(Request request) {
      return false;
   }

   public void setConfidentialPort(int confidentialPort) {
      this._confidentialPort = confidentialPort;
   }

   public void setConfidentialScheme(String confidentialScheme) {
      this._confidentialScheme = confidentialScheme;
   }

   public void setIntegralPort(int integralPort) {
      this._integralPort = integralPort;
   }

   public void setIntegralScheme(String integralScheme) {
      this._integralScheme = integralScheme;
   }

   public Continuation newContinuation() {
      return new WaitingContinuation();
   }

   protected abstract void accept(int var1) throws IOException, InterruptedException;

   public void stopAccept(int acceptorID) throws Exception {
   }

   public boolean getResolveNames() {
      return this._useDNS;
   }

   public void setResolveNames(boolean resolve) {
      this._useDNS = resolve;
   }

   public boolean isForwarded() {
      return this._forwarded;
   }

   public void setForwarded(boolean check) {
      if (check) {
         Log.debug(this + " is forwarded");
      }

      this._forwarded = check;
   }

   public String getHostHeader() {
      return this._hostHeader;
   }

   public void setHostHeader(String hostHeader) {
      this._hostHeader = hostHeader;
   }

   public String getForwardedHostHeader() {
      return this._forwardedHostHeader;
   }

   public void setForwardedHostHeader(String forwardedHostHeader) {
      this._forwardedHostHeader = forwardedHostHeader;
   }

   public String getForwardedServerHeader() {
      return this._forwardedServerHeader;
   }

   public void setForwardedServerHeader(String forwardedServerHeader) {
      this._forwardedServerHeader = forwardedServerHeader;
   }

   public String getForwardedForHeader() {
      return this._forwardedForHeader;
   }

   public void setForwardedForHeader(String forwardedRemoteAddressHeader) {
      this._forwardedForHeader = forwardedRemoteAddressHeader;
   }

   public String toString() {
      String name = this.getClass().getName();
      int dot = name.lastIndexOf(46);
      if (dot > 0) {
         name = name.substring(dot + 1);
      }

      return name + "@" + (this.getHost() == null ? "0.0.0.0" : this.getHost()) + ":" + (this.getLocalPort() <= 0 ? this.getPort() : this.getLocalPort());
   }

   public String getName() {
      if (this._name == null) {
         this._name = (this.getHost() == null ? "0.0.0.0" : this.getHost()) + ":" + (this.getLocalPort() <= 0 ? this.getPort() : this.getLocalPort());
      }

      return this._name;
   }

   public void setName(String name) {
      this._name = name;
   }

   public int getRequests() {
      return this._requests;
   }

   public long getConnectionsDurationMin() {
      return this._connectionsDurationMin;
   }

   public long getConnectionsDurationTotal() {
      return this._connectionsDurationTotal;
   }

   public int getConnectionsOpenMin() {
      return this._connectionsOpenMin;
   }

   public int getConnectionsRequestsMin() {
      return this._connectionsRequestsMin;
   }

   public int getConnections() {
      return this._connections;
   }

   public int getConnectionsOpen() {
      return this._connectionsOpen;
   }

   public int getConnectionsOpenMax() {
      return this._connectionsOpenMax;
   }

   public long getConnectionsDurationAve() {
      return this._connections == 0 ? 0L : this._connectionsDurationTotal / (long)this._connections;
   }

   public long getConnectionsDurationMax() {
      return this._connectionsDurationMax;
   }

   public int getConnectionsRequestsAve() {
      return this._connections == 0 ? 0 : this._requests / this._connections;
   }

   public int getConnectionsRequestsMax() {
      return this._connectionsRequestsMax;
   }

   public void statsReset() {
      this._statsStartedAt = this._statsStartedAt == -1L ? -1L : System.currentTimeMillis();
      this._connections = 0;
      this._connectionsOpenMin = this._connectionsOpen;
      this._connectionsOpenMax = this._connectionsOpen;
      this._connectionsOpen = 0;
      this._connectionsDurationMin = 0L;
      this._connectionsDurationMax = 0L;
      this._connectionsDurationTotal = 0L;
      this._requests = 0;
      this._connectionsRequestsMin = 0;
      this._connectionsRequestsMax = 0;
   }

   public void setStatsOn(boolean on) {
      if (!on || this._statsStartedAt == -1L) {
         Log.debug("Statistics on = " + on + " for " + this);
         this.statsReset();
         this._statsStartedAt = on ? System.currentTimeMillis() : -1L;
      }
   }

   public boolean getStatsOn() {
      return this._statsStartedAt != -1L;
   }

   public long getStatsOnMs() {
      return this._statsStartedAt != -1L ? System.currentTimeMillis() - this._statsStartedAt : 0L;
   }

   protected void connectionOpened(HttpConnection connection) {
      if (this._statsStartedAt != -1L) {
         synchronized(this._statsLock) {
            ++this._connectionsOpen;
            if (this._connectionsOpen > this._connectionsOpenMax) {
               this._connectionsOpenMax = this._connectionsOpen;
            }

         }
      }
   }

   protected void connectionClosed(HttpConnection connection) {
      if (this._statsStartedAt >= 0L) {
         long duration = System.currentTimeMillis() - connection.getTimeStamp();
         int requests = connection.getRequests();
         synchronized(this._statsLock) {
            this._requests += requests;
            ++this._connections;
            --this._connectionsOpen;
            this._connectionsDurationTotal += duration;
            if (this._connectionsOpen < 0) {
               this._connectionsOpen = 0;
            }

            if (this._connectionsOpen < this._connectionsOpenMin) {
               this._connectionsOpenMin = this._connectionsOpen;
            }

            if (this._connectionsDurationMin == 0L || duration < this._connectionsDurationMin) {
               this._connectionsDurationMin = duration;
            }

            if (duration > this._connectionsDurationMax) {
               this._connectionsDurationMax = duration;
            }

            if (this._connectionsRequestsMin == 0 || requests < this._connectionsRequestsMin) {
               this._connectionsRequestsMin = requests;
            }

            if (requests > this._connectionsRequestsMax) {
               this._connectionsRequestsMax = requests;
            }
         }
      }

      connection.destroy();
   }

   public int getAcceptorPriorityOffset() {
      return this._acceptorPriorityOffset;
   }

   public void setAcceptorPriorityOffset(int offset) {
      this._acceptorPriorityOffset = offset;
   }

   public boolean getReuseAddress() {
      return this._reuseAddress;
   }

   public void setReuseAddress(boolean reuseAddress) {
      this._reuseAddress = reuseAddress;
   }

   private class Acceptor implements Runnable {
      int _acceptor = 0;

      Acceptor(int id) {
         this._acceptor = id;
      }

      public void run() {
         Thread current = Thread.currentThread();
         String name;
         synchronized(AbstractConnector.this) {
            if (AbstractConnector.this._acceptorThread == null) {
               return;
            }

            AbstractConnector.this._acceptorThread[this._acceptor] = current;
            name = AbstractConnector.this._acceptorThread[this._acceptor].getName();
            current.setName(name + " - Acceptor" + this._acceptor + " " + AbstractConnector.this);
         }

         int old_priority = current.getPriority();

         try {
            current.setPriority(old_priority - AbstractConnector.this._acceptorPriorityOffset);

            while(AbstractConnector.this.isRunning() && AbstractConnector.this.getConnection() != null) {
               try {
                  AbstractConnector.this.accept(this._acceptor);
               } catch (EofException var18) {
                  Log.ignore(var18);
               } catch (IOException var19) {
                  Log.ignore(var19);
               } catch (ThreadDeath var20) {
                  throw var20;
               } catch (Throwable var21) {
                  Log.warn(var21);
               }
            }
         } finally {
            current.setPriority(old_priority);
            current.setName(name);
            synchronized(AbstractConnector.this) {
               if (AbstractConnector.this._acceptorThread != null) {
                  AbstractConnector.this._acceptorThread[this._acceptor] = null;
               }

            }
         }

      }
   }
}
