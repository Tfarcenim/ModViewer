package com.replaymod.lib.org.cakelab.json.codec;

public class Token {
   static final int TYPE_LEFTBRACE = 123;
   static final int TYPE_RIGHTBRACE = 125;
   static final int TYPE_COMMA = 44;
   static final int TYPE_COLON = 58;
   static final int TYPE_LEFTBRACKET = 91;
   static final int TYPE_RIGHTBRACKET = 93;
   static final int TYPE_DOUBLEQUOTES = 34;
   static final int TYPE_BACKSLASH = 92;
   static final int TYPE_PLUS = 43;
   static final int TYPE_MINUS = 45;
   static final int TYPE_SLASH = 47;
   static final int TYPE_VALUE_TYPE_BASE = 1024;
   static final int TYPE_STRING = 1024;
   static final int TYPE_NUMBER = 1025;
   static final int TYPE_BOOLEAN = 1026;
   static final int TYPE_NULL = 1027;
   static final int TYPE_META_TYPE_BASE = 2048;
   static final int TYPE_NAME = 2048;
   static final int TYPE_OBJECT = 2052;
   static final int TYPE_ARRAY = 2053;
   static final int TYPE_NAME_VALUE_PAIR = 2054;
   static final int TYPE_UNKNOWN = Integer.MAX_VALUE;

   public static boolean isWhitespace(char c) {
      return " \r\n\t\b\f".indexOf(c) >= 0;
   }

   public static boolean isDigit(char c) {
      return "0123456789".indexOf(c) >= 0;
   }

   public static boolean isHexDigit(char c) {
      return "0123456789abcdefABCDEF".indexOf(c) >= 0;
   }

   public static boolean isAlpha(char c) {
      c = Character.toLowerCase(c);
      return c >= 'a' && c <= 'z';
   }

   public static boolean isLegalNameElement(char c) {
      return c == '_';
   }
}
