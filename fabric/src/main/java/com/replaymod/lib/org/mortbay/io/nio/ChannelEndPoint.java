package com.replaymod.lib.org.mortbay.io.nio;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SocketChannel;

public class ChannelEndPoint implements EndPoint {
   protected final ByteChannel _channel;
   protected final ByteBuffer[] _gather2 = new ByteBuffer[2];
   protected final Socket _socket;
   protected final InetSocketAddress _local;
   protected final InetSocketAddress _remote;

   public ChannelEndPoint(ByteChannel channel) {
      this._channel = channel;
      if (channel instanceof SocketChannel) {
         this._socket = ((SocketChannel)channel).socket();
         this._local = (InetSocketAddress)this._socket.getLocalSocketAddress();
         this._remote = (InetSocketAddress)this._socket.getRemoteSocketAddress();
      } else {
         this._socket = null;
         this._local = null;
         this._remote = null;
      }

   }

   public boolean isBlocking() {
      return this._channel instanceof SelectableChannel ? ((SelectableChannel)this._channel).isBlocking() : true;
   }

   public boolean blockReadable(long millisecs) throws IOException {
      return true;
   }

   public boolean blockWritable(long millisecs) throws IOException {
      return true;
   }

   public boolean isOpen() {
      return this._channel.isOpen();
   }

   public void shutdownOutput() throws IOException {
      if (this._channel.isOpen() && this._channel instanceof SocketChannel) {
         Socket socket = ((SocketChannel)this._channel).socket();
         if (!socket.isClosed() && !socket.isOutputShutdown()) {
            socket.shutdownOutput();
         }
      }

   }

   public void close() throws IOException {
      if (this._socket != null && !this._socket.isOutputShutdown()) {
         this._socket.shutdownOutput();
      }

      this._channel.close();
   }

   public int fill(Buffer buffer) throws IOException {
      Buffer buf = buffer.buffer();
      int len = false;
      if (buf instanceof NIOBuffer) {
         NIOBuffer nbuf = (NIOBuffer)buf;
         ByteBuffer bbuf = nbuf.getByteBuffer();
         synchronized(nbuf) {
            int len;
            try {
               bbuf.position(buffer.putIndex());
               len = this._channel.read(bbuf);
               if (len < 0) {
                  this._channel.close();
               }
            } finally {
               buffer.setPutIndex(bbuf.position());
               bbuf.position(0);
            }

            return len;
         }
      } else {
         throw new IOException("Not Implemented");
      }
   }

   public int flush(Buffer buffer) throws IOException {
      Buffer buf = buffer.buffer();
      int len = 0;
      if (buf instanceof NIOBuffer) {
         NIOBuffer nbuf = (NIOBuffer)buf;
         ByteBuffer bbuf = nbuf.getByteBuffer();
         synchronized(bbuf) {
            try {
               bbuf.position(buffer.getIndex());
               bbuf.limit(buffer.putIndex());
               len = this._channel.write(bbuf);
            } finally {
               if (len > 0) {
                  buffer.skip(len);
               }

               bbuf.position(0);
               bbuf.limit(bbuf.capacity());
            }
         }
      } else {
         if (buffer.array() == null) {
            throw new IOException("Not Implemented");
         }

         ByteBuffer b = ByteBuffer.wrap(buffer.array(), buffer.getIndex(), buffer.length());
         len = this._channel.write(b);
         if (len > 0) {
            buffer.skip(len);
         }
      }

      return len;
   }

   public int flush(Buffer header, Buffer buffer, Buffer trailer) throws IOException {
      int length = 0;
      Buffer buf0 = header == null ? null : header.buffer();
      Buffer buf1 = buffer == null ? null : buffer.buffer();
      if (this._channel instanceof GatheringByteChannel && header != null && header.length() != 0 && header instanceof NIOBuffer && buffer != null && buffer.length() != 0 && buffer instanceof NIOBuffer) {
         NIOBuffer nbuf0 = (NIOBuffer)buf0;
         ByteBuffer bbuf0 = nbuf0.getByteBuffer();
         NIOBuffer nbuf1 = (NIOBuffer)buf1;
         ByteBuffer bbuf1 = nbuf1.getByteBuffer();
         synchronized(this) {
            synchronized(bbuf0) {
               synchronized(bbuf1) {
                  try {
                     bbuf0.position(header.getIndex());
                     bbuf0.limit(header.putIndex());
                     bbuf1.position(buffer.getIndex());
                     bbuf1.limit(buffer.putIndex());
                     this._gather2[0] = bbuf0;
                     this._gather2[1] = bbuf1;
                     length = (int)((GatheringByteChannel)this._channel).write(this._gather2);
                     int hl = header.length();
                     if (length > hl) {
                        header.clear();
                        buffer.skip(length - hl);
                     } else if (length > 0) {
                        header.skip(length);
                     }
                  } finally {
                     if (!header.isImmutable()) {
                        header.setGetIndex(bbuf0.position());
                     }

                     if (!buffer.isImmutable()) {
                        buffer.setGetIndex(bbuf1.position());
                     }

                     bbuf0.position(0);
                     bbuf1.position(0);
                     bbuf0.limit(bbuf0.capacity());
                     bbuf1.limit(bbuf1.capacity());
                  }
               }
            }
         }
      } else {
         if (header != null) {
            if (buffer != null && buffer.length() > 0 && header.space() > buffer.length()) {
               header.put(buffer);
               buffer.clear();
            }

            if (trailer != null && trailer.length() > 0 && header.space() > trailer.length()) {
               header.put(trailer);
               trailer.clear();
            }
         }

         if (header != null && header.length() > 0) {
            length = this.flush(header);
         }

         if ((header == null || header.length() == 0) && buffer != null && buffer.length() > 0) {
            length += this.flush(buffer);
         }

         if ((header == null || header.length() == 0) && (buffer == null || buffer.length() == 0) && trailer != null && trailer.length() > 0) {
            length += this.flush(trailer);
         }
      }

      return length;
   }

   public ByteChannel getChannel() {
      return this._channel;
   }

   public String getLocalAddr() {
      if (this._socket == null) {
         return null;
      } else {
         return this._local != null && this._local.getAddress() != null && !this._local.getAddress().isAnyLocalAddress() ? this._local.getAddress().getHostAddress() : "0.0.0.0";
      }
   }

   public String getLocalHost() {
      if (this._socket == null) {
         return null;
      } else {
         return this._local != null && this._local.getAddress() != null && !this._local.getAddress().isAnyLocalAddress() ? this._local.getAddress().getCanonicalHostName() : "0.0.0.0";
      }
   }

   public int getLocalPort() {
      if (this._socket == null) {
         return 0;
      } else {
         return this._local == null ? -1 : this._local.getPort();
      }
   }

   public String getRemoteAddr() {
      if (this._socket == null) {
         return null;
      } else {
         return this._remote == null ? null : this._remote.getAddress().getHostAddress();
      }
   }

   public String getRemoteHost() {
      if (this._socket == null) {
         return null;
      } else {
         return this._remote == null ? null : this._remote.getAddress().getCanonicalHostName();
      }
   }

   public int getRemotePort() {
      if (this._socket == null) {
         return 0;
      } else if (this._remote == null) {
         return -1;
      } else {
         return this._remote == null ? -1 : this._remote.getPort();
      }
   }

   public Object getTransport() {
      return this._channel;
   }

   public void flush() throws IOException {
   }

   public boolean isBufferingInput() {
      return false;
   }

   public boolean isBufferingOutput() {
      return false;
   }

   public boolean isBufferred() {
      return false;
   }
}
