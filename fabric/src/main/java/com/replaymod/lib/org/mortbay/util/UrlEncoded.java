package com.replaymod.lib.org.mortbay.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map.Entry;

public class UrlEncoded extends MultiMap {
   public static final String ENCODING = System.getProperty("com.replaymod.lib.org.mortbay.util.UrlEncoding.charset", "UTF-8");

   public UrlEncoded(UrlEncoded url) {
      super(url);
   }

   public UrlEncoded() {
      super(6);
   }

   public UrlEncoded(String s) {
      super(6);
      this.decode(s, ENCODING);
   }

   public UrlEncoded(String s, String charset) {
      super(6);
      this.decode(s, charset);
   }

   public void decode(String query) {
      decodeTo(query, this, ENCODING);
   }

   public void decode(String query, String charset) {
      decodeTo(query, this, charset);
   }

   public String encode() {
      return this.encode(ENCODING, false);
   }

   public String encode(String charset) {
      return this.encode(charset, false);
   }

   public synchronized String encode(String charset, boolean equalsForNullValue) {
      return encode(this, charset, equalsForNullValue);
   }

   public static String encode(MultiMap map, String charset, boolean equalsForNullValue) {
      if (charset == null) {
         charset = ENCODING;
      }

      StringBuffer result = new StringBuffer(128);
      synchronized(result) {
         Iterator iter = map.entrySet().iterator();

         while(iter.hasNext()) {
            Entry entry = (Entry)iter.next();
            String key = entry.getKey().toString();
            Object list = entry.getValue();
            int s = LazyList.size(list);
            if (s == 0) {
               result.append(encodeString(key, charset));
               if (equalsForNullValue) {
                  result.append('=');
               }
            } else {
               for(int i = 0; i < s; ++i) {
                  if (i > 0) {
                     result.append('&');
                  }

                  Object val = LazyList.get(list, i);
                  result.append(encodeString(key, charset));
                  if (val != null) {
                     String str = val.toString();
                     if (str.length() > 0) {
                        result.append('=');
                        result.append(encodeString(str, charset));
                     } else if (equalsForNullValue) {
                        result.append('=');
                     }
                  } else if (equalsForNullValue) {
                     result.append('=');
                  }
               }
            }

            if (iter.hasNext()) {
               result.append('&');
            }
         }

         return result.toString();
      }
   }

   public static void decodeTo(String content, MultiMap map, String charset) {
      if (charset == null) {
         charset = ENCODING;
      }

      synchronized(map) {
         String key = null;
         String value = null;
         int mark = -1;
         boolean encoded = false;

         int i;
         for(i = 0; i < content.length(); ++i) {
            char c = content.charAt(i);
            switch(c) {
            case '%':
               encoded = true;
               break;
            case '&':
               int l = i - mark - 1;
               value = l == 0 ? "" : (encoded ? decodeString(content, mark + 1, l, charset) : content.substring(mark + 1, i));
               mark = i;
               encoded = false;
               if (key != null) {
                  map.add(key, value);
               } else if (value != null && value.length() > 0) {
                  map.add(value, "");
               }

               key = null;
               value = null;
               break;
            case '+':
               encoded = true;
               break;
            case '=':
               if (key == null) {
                  key = encoded ? decodeString(content, mark + 1, i - mark - 1, charset) : content.substring(mark + 1, i);
                  mark = i;
                  encoded = false;
               }
            }
         }

         if (key != null) {
            i = content.length() - mark - 1;
            value = i == 0 ? "" : (encoded ? decodeString(content, mark + 1, i, charset) : content.substring(mark + 1));
            map.add(key, value);
         } else if (mark < content.length()) {
            key = encoded ? decodeString(content, mark + 1, content.length() - mark - 1, charset) : content.substring(mark + 1);
            map.add(key, "");
         }

      }
   }

   public static void decodeUtf8To(byte[] raw, int offset, int length, MultiMap map) {
      decodeUtf8To(raw, offset, length, map, new Utf8StringBuffer());
   }

   public static void decodeUtf8To(byte[] raw, int offset, int length, MultiMap map, Utf8StringBuffer buffer) {
      synchronized(map) {
         String key = null;
         String value = null;
         int end = offset + length;

         for(int i = offset; i < end; ++i) {
            byte b = raw[i];
            switch((char)(255 & b)) {
            case '%':
               if (i + 2 < end) {
                  ++i;
                  int var10001 = TypeUtil.convertHexDigit(raw[i]) << 4;
                  ++i;
                  buffer.append((byte)(var10001 + TypeUtil.convertHexDigit(raw[i])));
               }
               break;
            case '&':
               value = buffer.length() == 0 ? "" : buffer.toString();
               buffer.reset();
               if (key != null) {
                  map.add(key, value);
               } else if (value != null && value.length() > 0) {
                  map.add(value, "");
               }

               key = null;
               value = null;
               break;
            case '+':
               buffer.append((byte)32);
               break;
            case '=':
               if (key != null) {
                  buffer.append(b);
               } else {
                  key = buffer.toString();
                  buffer.reset();
               }
               break;
            default:
               buffer.append(b);
            }
         }

         if (key != null) {
            value = buffer.length() == 0 ? "" : buffer.toString();
            buffer.reset();
            map.add(key, value);
         } else if (buffer.length() > 0) {
            map.add(buffer.toString(), "");
         }

      }
   }

   public static void decode88591To(InputStream in, MultiMap map, int maxLength) throws IOException {
      synchronized(map) {
         StringBuffer buffer = new StringBuffer();
         String key = null;
         String value = null;
         int totalLength = 0;

         int b;
         while((b = in.read()) >= 0) {
            switch((char)b) {
            case '%':
               int dh = in.read();
               int dl = in.read();
               if (dh >= 0 && dl >= 0) {
                  buffer.append((char)((TypeUtil.convertHexDigit((byte)dh) << 4) + TypeUtil.convertHexDigit((byte)dl)));
               }
               break;
            case '&':
               value = buffer.length() == 0 ? "" : buffer.toString();
               buffer.setLength(0);
               if (key != null) {
                  map.add(key, value);
               } else if (value != null && value.length() > 0) {
                  map.add(value, "");
               }

               key = null;
               value = null;
               break;
            case '+':
               buffer.append(' ');
               break;
            case '=':
               if (key != null) {
                  buffer.append((char)b);
               } else {
                  key = buffer.toString();
                  buffer.setLength(0);
               }
               break;
            default:
               buffer.append((char)b);
            }

            if (maxLength >= 0) {
               ++totalLength;
               if (totalLength > maxLength) {
                  throw new IllegalStateException("Form too large");
               }
            }
         }

         if (key != null) {
            value = buffer.length() == 0 ? "" : buffer.toString();
            buffer.setLength(0);
            map.add(key, value);
         } else if (buffer.length() > 0) {
            map.add(buffer.toString(), "");
         }

      }
   }

   public static void decodeUtf8To(InputStream in, MultiMap map, int maxLength) throws IOException {
      synchronized(map) {
         Utf8StringBuffer buffer = new Utf8StringBuffer();
         String key = null;
         String value = null;
         int totalLength = 0;

         int b;
         while((b = in.read()) >= 0) {
            switch((char)b) {
            case '%':
               int dh = in.read();
               int dl = in.read();
               if (dh >= 0 && dl >= 0) {
                  buffer.append((byte)((TypeUtil.convertHexDigit((byte)dh) << 4) + TypeUtil.convertHexDigit((byte)dl)));
               }
               break;
            case '&':
               value = buffer.length() == 0 ? "" : buffer.toString();
               buffer.reset();
               if (key != null) {
                  map.add(key, value);
               } else if (value != null && value.length() > 0) {
                  map.add(value, "");
               }

               key = null;
               value = null;
               break;
            case '+':
               buffer.append((byte)32);
               break;
            case '=':
               if (key != null) {
                  buffer.append((byte)b);
               } else {
                  key = buffer.toString();
                  buffer.reset();
               }
               break;
            default:
               buffer.append((byte)b);
            }

            if (maxLength >= 0) {
               ++totalLength;
               if (totalLength > maxLength) {
                  throw new IllegalStateException("Form too large");
               }
            }
         }

         if (key != null) {
            value = buffer.length() == 0 ? "" : buffer.toString();
            buffer.reset();
            map.add(key, value);
         } else if (buffer.length() > 0) {
            map.add(buffer.toString(), "");
         }

      }
   }

   public static void decodeUtf16To(InputStream in, MultiMap map, int maxLength) throws IOException {
      InputStreamReader input = new InputStreamReader(in, "UTF-16");
      StringBuffer buf = new StringBuffer();
      int length = 0;
      if (maxLength < 0) {
         maxLength = Integer.MAX_VALUE;
      }

      int c;
      while((c = input.read()) > 0 && length++ < maxLength) {
         buf.append((char)c);
      }

      decodeTo(buf.toString(), map, ENCODING);
   }

   public static void decodeTo(InputStream in, MultiMap map, String charset, int maxLength) throws IOException {
      if (charset != null && !"UTF-8".equalsIgnoreCase(charset)) {
         if (StringUtil.__ISO_8859_1.equals(charset)) {
            decode88591To(in, map, maxLength);
         } else if ("UTF-16".equalsIgnoreCase(charset)) {
            decodeUtf16To(in, map, maxLength);
         } else {
            synchronized(map) {
               String key = null;
               String value = null;
               int digit = 0;
               int digits = 0;
               int totalLength = 0;
               ByteArrayOutputStream2 output = new ByteArrayOutputStream2();
               boolean var12 = false;

               do {
                  int c;
                  int size;
                  if ((c = in.read()) <= 0) {
                     size = output.size();
                     if (key != null) {
                        value = size == 0 ? "" : output.toString(charset);
                        output.setCount(0);
                        map.add(key, value);
                     } else if (size > 0) {
                        map.add(output.toString(charset), "");
                     }

                     return;
                  }

                  switch((char)c) {
                  case '%':
                     digits = 2;
                     break;
                  case '&':
                     size = output.size();
                     value = size == 0 ? "" : output.toString(charset);
                     output.setCount(0);
                     if (key != null) {
                        map.add(key, value);
                     } else if (value != null && value.length() > 0) {
                        map.add(value, "");
                     }

                     key = null;
                     value = null;
                     break;
                  case '+':
                     output.write(32);
                     break;
                  case '=':
                     if (key != null) {
                        output.write(c);
                     } else {
                        size = output.size();
                        key = size == 0 ? "" : output.toString(charset);
                        output.setCount(0);
                     }
                     break;
                  default:
                     if (digits == 2) {
                        digit = TypeUtil.convertHexDigit((byte)c);
                        digits = 1;
                     } else if (digits == 1) {
                        output.write((digit << 4) + TypeUtil.convertHexDigit((byte)c));
                        digits = 0;
                     } else {
                        output.write(c);
                     }
                  }

                  ++totalLength;
               } while(maxLength < 0 || totalLength <= maxLength);

               throw new IllegalStateException("Form too large");
            }
         }
      } else {
         decodeUtf8To(in, map, maxLength);
      }
   }

   public static String decodeString(String encoded, int offset, int length, String charset) {
      int i;
      char c;
      if (charset != null && !StringUtil.isUTF8(charset)) {
         StringBuffer buffer = null;

         try {
            for(i = 0; i < length; ++i) {
               c = encoded.charAt(offset + i);
               if (c >= 0 && c <= 255) {
                  if (c == '+') {
                     if (buffer == null) {
                        buffer = new StringBuffer(length);
                        buffer.append(encoded.substring(offset, offset + i));
                     }

                     buffer.append(' ');
                  } else if (c == '%' && i + 2 < length) {
                     if (buffer == null) {
                        buffer = new StringBuffer(length);
                        buffer.append(encoded.substring(offset, offset + i));
                     }

                     byte[] ba = new byte[length];

                     int n;
                     for(n = 0; c >= 0 && c <= 255; c = encoded.charAt(offset + i)) {
                        if (c == '%') {
                           if (i + 2 < length) {
                              try {
                                 ba[n++] = (byte)TypeUtil.parseInt((String)encoded, offset + i + 1, 2, 16);
                                 i += 3;
                              } catch (NumberFormatException var11) {
                                 ba[n - 1] = 37;

                                 while(true) {
                                    ++i;
                                    char next;
                                    if ((next = encoded.charAt(i + offset)) == '%') {
                                       break;
                                    }

                                    ba[n++] = (byte)(next == '+' ? 32 : next);
                                 }
                              }
                           } else {
                              ba[n++] = 37;
                              ++i;
                           }
                        } else if (c == '+') {
                           ba[n++] = 32;
                           ++i;
                        } else {
                           ba[n++] = (byte)c;
                           ++i;
                        }

                        if (i >= length) {
                           break;
                        }
                     }

                     --i;
                     buffer.append(new String(ba, 0, n, charset));
                  } else if (buffer != null) {
                     buffer.append(c);
                  }
               } else if (buffer == null) {
                  buffer = new StringBuffer(length);
                  buffer.append(encoded.substring(offset, offset + i + 1));
               } else {
                  buffer.append(c);
               }
            }

            if (buffer == null) {
               if (offset == 0 && encoded.length() == length) {
                  return encoded;
               } else {
                  return encoded.substring(offset, offset + length);
               }
            } else {
               return buffer.toString();
            }
         } catch (UnsupportedEncodingException var12) {
            throw new RuntimeException(var12);
         }
      } else {
         Utf8StringBuffer buffer = null;

         for(i = 0; i < length; ++i) {
            c = encoded.charAt(offset + i);
            if (c >= 0 && c <= 255) {
               if (c == '+') {
                  if (buffer == null) {
                     buffer = new Utf8StringBuffer(length);
                     buffer.getStringBuffer().append(encoded.substring(offset, offset + i));
                  }

                  buffer.getStringBuffer().append(' ');
               } else if (c == '%' && i + 2 < length) {
                  if (buffer == null) {
                     buffer = new Utf8StringBuffer(length);
                     buffer.getStringBuffer().append(encoded.substring(offset, offset + i));
                  }

                  while(c == '%' && i + 2 < length) {
                     try {
                        byte b = (byte)TypeUtil.parseInt((String)encoded, offset + i + 1, 2, 16);
                        buffer.append(b);
                        i += 3;
                     } catch (NumberFormatException var13) {
                        buffer.getStringBuffer().append('%');

                        while(true) {
                           ++i;
                           char next;
                           if ((next = encoded.charAt(i + offset)) == '%') {
                              break;
                           }

                           buffer.getStringBuffer().append(next == '+' ? ' ' : next);
                        }
                     }

                     if (i < length) {
                        c = encoded.charAt(offset + i);
                     }
                  }

                  --i;
               } else if (buffer != null) {
                  buffer.getStringBuffer().append(c);
               }
            } else if (buffer == null) {
               buffer = new Utf8StringBuffer(length);
               buffer.getStringBuffer().append(encoded.substring(offset, offset + i + 1));
            } else {
               buffer.getStringBuffer().append(c);
            }
         }

         if (buffer == null) {
            if (offset == 0 && encoded.length() == length) {
               return encoded;
            } else {
               return encoded.substring(offset, offset + length);
            }
         } else {
            return buffer.toString();
         }
      }
   }

   public static String encodeString(String string) {
      return encodeString(string, ENCODING);
   }

   public static String encodeString(String string, String charset) {
      if (charset == null) {
         charset = ENCODING;
      }

      Object var2 = null;

      byte[] bytes;
      try {
         bytes = string.getBytes(charset);
      } catch (UnsupportedEncodingException var11) {
         bytes = string.getBytes();
      }

      int len = bytes.length;
      byte[] encoded = new byte[bytes.length * 3];
      int n = 0;
      boolean noEncode = true;

      for(int i = 0; i < len; ++i) {
         byte b = bytes[i];
         if (b == 32) {
            noEncode = false;
            encoded[n++] = 43;
         } else if ((b < 97 || b > 122) && (b < 65 || b > 90) && (b < 48 || b > 57)) {
            noEncode = false;
            encoded[n++] = 37;
            byte nibble = (byte)((b & 240) >> 4);
            if (nibble >= 10) {
               encoded[n++] = (byte)(65 + nibble - 10);
            } else {
               encoded[n++] = (byte)(48 + nibble);
            }

            nibble = (byte)(b & 15);
            if (nibble >= 10) {
               encoded[n++] = (byte)(65 + nibble - 10);
            } else {
               encoded[n++] = (byte)(48 + nibble);
            }
         } else {
            encoded[n++] = b;
         }
      }

      if (noEncode) {
         return string;
      } else {
         try {
            return new String(encoded, 0, n, charset);
         } catch (UnsupportedEncodingException var10) {
            return new String(encoded, 0, n);
         }
      }
   }

   public Object clone() {
      return new UrlEncoded(this);
   }
}
