package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.component.AbstractLifeCycle;
import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.Buffers;

public abstract class AbstractBuffers extends AbstractLifeCycle implements Buffers {
   private int _headerBufferSize = 4096;
   private int _requestBufferSize = 8192;
   private int _responseBufferSize = 24576;
   private static final int __HEADER = 0;
   private static final int __REQUEST = 1;
   private static final int __RESPONSE = 2;
   private static final int __OTHER = 3;
   private final int[] _pool = new int[]{2, 1, 1, 2};
   private final ThreadLocal _buffers = new ThreadLocal() {
      protected Object initialValue() {
         return new AbstractBuffers.ThreadBuffers(AbstractBuffers.this._pool[0], AbstractBuffers.this._pool[1], AbstractBuffers.this._pool[2], AbstractBuffers.this._pool[3]);
      }
   };

   public Buffer getBuffer(int size) {
      int set = size == this._headerBufferSize ? 0 : (size == this._responseBufferSize ? 2 : (size == this._requestBufferSize ? 1 : 3));
      AbstractBuffers.ThreadBuffers thread_buffers = (AbstractBuffers.ThreadBuffers)this._buffers.get();
      Buffer[] buffers = thread_buffers._buffers[set];

      for(int i = 0; i < buffers.length; ++i) {
         Buffer b = buffers[i];
         if (b != null && b.capacity() == size) {
            buffers[i] = null;
            return b;
         }
      }

      return this.newBuffer(size);
   }

   public void returnBuffer(Buffer buffer) {
      buffer.clear();
      if (!buffer.isVolatile() && !buffer.isImmutable()) {
         int size = buffer.capacity();
         int set = size == this._headerBufferSize ? 0 : (size == this._responseBufferSize ? 2 : (size == this._requestBufferSize ? 1 : 3));
         AbstractBuffers.ThreadBuffers thread_buffers = (AbstractBuffers.ThreadBuffers)this._buffers.get();
         Buffer[] buffers = thread_buffers._buffers[set];

         for(int i = 0; i < buffers.length; ++i) {
            if (buffers[i] == null) {
               buffers[i] = buffer;
               return;
            }
         }

      }
   }

   protected void doStart() throws Exception {
      super.doStart();
      int[] var10000;
      if (this._headerBufferSize == this._requestBufferSize && this._headerBufferSize == this._responseBufferSize) {
         var10000 = this._pool;
         var10000[0] += this._pool[1] + this._pool[2];
         this._pool[1] = 0;
         this._pool[2] = 0;
      } else if (this._headerBufferSize == this._requestBufferSize) {
         var10000 = this._pool;
         var10000[0] += this._pool[1];
         this._pool[1] = 0;
      } else if (this._headerBufferSize == this._responseBufferSize) {
         var10000 = this._pool;
         var10000[0] += this._pool[2];
         this._pool[2] = 0;
      } else if (this._requestBufferSize == this._responseBufferSize) {
         var10000 = this._pool;
         var10000[2] += this._pool[1];
         this._pool[1] = 0;
      }

   }

   public int getHeaderBufferSize() {
      return this._headerBufferSize;
   }

   public void setHeaderBufferSize(int headerBufferSize) {
      if (this.isStarted()) {
         throw new IllegalStateException();
      } else {
         this._headerBufferSize = headerBufferSize;
      }
   }

   public int getRequestBufferSize() {
      return this._requestBufferSize;
   }

   public void setRequestBufferSize(int requestBufferSize) {
      if (this.isStarted()) {
         throw new IllegalStateException();
      } else {
         this._requestBufferSize = requestBufferSize;
      }
   }

   public int getResponseBufferSize() {
      return this._responseBufferSize;
   }

   public void setResponseBufferSize(int responseBufferSize) {
      if (this.isStarted()) {
         throw new IllegalStateException();
      } else {
         this._responseBufferSize = responseBufferSize;
      }
   }

   protected abstract Buffer newBuffer(int var1);

   public String toString() {
      return "{{" + this._headerBufferSize + "," + this._requestBufferSize + "," + this._responseBufferSize + "}}";
   }

   protected static class ThreadBuffers {
      final Buffer[][] _buffers = new Buffer[4][];

      ThreadBuffers(int headers, int requests, int responses, int others) {
         this._buffers[0] = new Buffer[headers];
         this._buffers[1] = new Buffer[requests];
         this._buffers[2] = new Buffer[responses];
         this._buffers[3] = new Buffer[others];
      }
   }
}
