package com.replaymod.lib.org.mortbay.jetty.bio;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.ByteArrayBuffer;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import com.replaymod.lib.org.mortbay.io.bio.SocketEndPoint;
import com.replaymod.lib.org.mortbay.jetty.AbstractConnector;
import com.replaymod.lib.org.mortbay.jetty.EofException;
import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.HttpException;
import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.log.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SocketConnector extends AbstractConnector {
   protected ServerSocket _serverSocket;
   protected Set _connections;

   public Object getConnection() {
      return this._serverSocket;
   }

   public void open() throws IOException {
      if (this._serverSocket == null || this._serverSocket.isClosed()) {
         this._serverSocket = this.newServerSocket(this.getHost(), this.getPort(), this.getAcceptQueueSize());
      }

      this._serverSocket.setReuseAddress(this.getReuseAddress());
   }

   protected ServerSocket newServerSocket(String host, int port, int backlog) throws IOException {
      ServerSocket ss = host == null ? new ServerSocket(port, backlog) : new ServerSocket(port, backlog, InetAddress.getByName(host));
      return ss;
   }

   public void close() throws IOException {
      if (this._serverSocket != null) {
         this._serverSocket.close();
      }

      this._serverSocket = null;
   }

   public void accept(int acceptorID) throws IOException, InterruptedException {
      Socket socket = this._serverSocket.accept();
      this.configure(socket);
      SocketConnector.Connection connection = new SocketConnector.Connection(socket);
      connection.dispatch();
   }

   protected HttpConnection newHttpConnection(EndPoint endpoint) {
      return new HttpConnection(this, endpoint, this.getServer());
   }

   protected Buffer newBuffer(int size) {
      return new ByteArrayBuffer(size);
   }

   public void customize(EndPoint endpoint, Request request) throws IOException {
      SocketConnector.Connection connection = (SocketConnector.Connection)endpoint;
      if (connection._sotimeout != this._maxIdleTime) {
         connection._sotimeout = this._maxIdleTime;
         ((Socket)endpoint.getTransport()).setSoTimeout(this._maxIdleTime);
      }

      super.customize(endpoint, request);
   }

   public int getLocalPort() {
      return this._serverSocket != null && !this._serverSocket.isClosed() ? this._serverSocket.getLocalPort() : -1;
   }

   protected void doStart() throws Exception {
      this._connections = new HashSet();
      super.doStart();
   }

   protected void doStop() throws Exception {
      super.doStop();
      Set set = null;
      synchronized(this._connections) {
         set = new HashSet(this._connections);
      }

      Iterator iter = set.iterator();

      while(iter.hasNext()) {
         SocketConnector.Connection connection = (SocketConnector.Connection)iter.next();
         connection.close();
      }

   }

   protected class Connection extends SocketEndPoint implements Runnable {
      boolean _dispatched = false;
      HttpConnection _connection = SocketConnector.this.newHttpConnection(this);
      int _sotimeout;
      protected Socket _socket;

      public Connection(Socket socket) throws IOException {
         super(socket);
         this._sotimeout = socket.getSoTimeout();
         this._socket = socket;
      }

      public void dispatch() throws InterruptedException, IOException {
         if (SocketConnector.this.getThreadPool() == null || !SocketConnector.this.getThreadPool().dispatch(this)) {
            Log.warn("dispatch failed for {}", (Object)this._connection);
            this.close();
         }

      }

      public int fill(Buffer buffer) throws IOException {
         int l = super.fill(buffer);
         if (l < 0) {
            this.close();
         }

         return l;
      }

      public void run() {
         try {
            SocketConnector.this.connectionOpened(this._connection);
            synchronized(SocketConnector.this._connections) {
               SocketConnector.this._connections.add(this);
            }

            for(; SocketConnector.this.isStarted() && !this.isClosed(); this._connection.handle()) {
               if (this._connection.isIdle() && SocketConnector.this.getServer().getThreadPool().isLowOnThreads()) {
                  int lrmit = SocketConnector.this.getLowResourceMaxIdleTime();
                  if (lrmit >= 0 && this._sotimeout != lrmit) {
                     this._sotimeout = lrmit;
                     this._socket.setSoTimeout(this._sotimeout);
                  }
               }
            }
         } catch (EofException var25) {
            Log.debug("EOF", var25);

            try {
               this.close();
            } catch (IOException var23) {
               Log.ignore(var23);
            }
         } catch (HttpException var26) {
            Log.debug("BAD", var26);

            try {
               this.close();
            } catch (IOException var22) {
               Log.ignore(var22);
            }
         } catch (Throwable var27) {
            Log.warn("handle failed", var27);

            try {
               this.close();
            } catch (IOException var21) {
               Log.ignore(var21);
            }
         } finally {
            SocketConnector.this.connectionClosed(this._connection);
            synchronized(SocketConnector.this._connections) {
               SocketConnector.this._connections.remove(this);
            }
         }

      }
   }
}
