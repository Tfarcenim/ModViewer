package com.replaymod.lib.org.mortbay.jetty;

public interface HttpTokens {
   byte COLON = 58;
   byte SPACE = 32;
   byte CARRIAGE_RETURN = 13;
   byte LINE_FEED = 10;
   byte[] CRLF = new byte[]{13, 10};
   byte SEMI_COLON = 59;
   byte TAB = 9;
   int SELF_DEFINING_CONTENT = -4;
   int UNKNOWN_CONTENT = -3;
   int CHUNKED_CONTENT = -2;
   int EOF_CONTENT = -1;
   int NO_CONTENT = 0;
}
