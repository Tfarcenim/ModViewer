package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.BufferCache;

public class HttpMethods {
   public static final String GET = "GET";
   public static final String POST = "POST";
   public static final String HEAD = "HEAD";
   public static final String PUT = "PUT";
   public static final String OPTIONS = "OPTIONS";
   public static final String DELETE = "DELETE";
   public static final String TRACE = "TRACE";
   public static final String CONNECT = "CONNECT";
   public static final String MOVE = "MOVE";
   public static final int GET_ORDINAL = 1;
   public static final int POST_ORDINAL = 2;
   public static final int HEAD_ORDINAL = 3;
   public static final int PUT_ORDINAL = 4;
   public static final int OPTIONS_ORDINAL = 5;
   public static final int DELETE_ORDINAL = 6;
   public static final int TRACE_ORDINAL = 7;
   public static final int CONNECT_ORDINAL = 8;
   public static final int MOVE_ORDINAL = 9;
   public static final BufferCache CACHE = new BufferCache();
   public static final Buffer GET_BUFFER;
   public static final Buffer POST_BUFFER;
   public static final Buffer HEAD_BUFFER;
   public static final Buffer PUT_BUFFER;
   public static final Buffer OPTIONS_BUFFER;
   public static final Buffer DELETE_BUFFER;
   public static final Buffer TRACE_BUFFER;
   public static final Buffer CONNECT_BUFFER;
   public static final Buffer MOVE_BUFFER;

   static {
      GET_BUFFER = CACHE.add("GET", 1);
      POST_BUFFER = CACHE.add("POST", 2);
      HEAD_BUFFER = CACHE.add("HEAD", 3);
      PUT_BUFFER = CACHE.add("PUT", 4);
      OPTIONS_BUFFER = CACHE.add("OPTIONS", 5);
      DELETE_BUFFER = CACHE.add("DELETE", 6);
      TRACE_BUFFER = CACHE.add("TRACE", 7);
      CONNECT_BUFFER = CACHE.add("CONNECT", 8);
      MOVE_BUFFER = CACHE.add("MOVE", 9);
   }
}
