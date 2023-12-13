package com.replaymod.lib.org.mortbay.io.bio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketEndPoint extends StreamEndPoint {
   final Socket _socket;
   final InetSocketAddress _local;
   final InetSocketAddress _remote;

   public SocketEndPoint(Socket socket) throws IOException {
      super(socket.getInputStream(), socket.getOutputStream());
      this._socket = socket;
      this._local = (InetSocketAddress)this._socket.getLocalSocketAddress();
      this._remote = (InetSocketAddress)this._socket.getRemoteSocketAddress();
   }

   public boolean isOpen() {
      return super.isOpen() && this._socket != null && !this._socket.isClosed() && !this._socket.isInputShutdown() && !this._socket.isOutputShutdown();
   }

   public void shutdownOutput() throws IOException {
      if (!this._socket.isClosed() && !this._socket.isOutputShutdown()) {
         this._socket.shutdownOutput();
      }

   }

   public void close() throws IOException {
      this._socket.close();
      this._in = null;
      this._out = null;
   }

   public String getLocalAddr() {
      return this._local != null && this._local.getAddress() != null && !this._local.getAddress().isAnyLocalAddress() ? this._local.getAddress().getHostAddress() : "0.0.0.0";
   }

   public String getLocalHost() {
      return this._local != null && this._local.getAddress() != null && !this._local.getAddress().isAnyLocalAddress() ? this._local.getAddress().getCanonicalHostName() : "0.0.0.0";
   }

   public int getLocalPort() {
      return this._local == null ? -1 : this._local.getPort();
   }

   public String getRemoteAddr() {
      if (this._remote == null) {
         return null;
      } else {
         InetAddress addr = this._remote.getAddress();
         return addr == null ? null : addr.getHostAddress();
      }
   }

   public String getRemoteHost() {
      return this._remote == null ? null : this._remote.getAddress().getCanonicalHostName();
   }

   public int getRemotePort() {
      return this._remote == null ? -1 : this._remote.getPort();
   }

   public Object getTransport() {
      return this._socket;
   }
}
