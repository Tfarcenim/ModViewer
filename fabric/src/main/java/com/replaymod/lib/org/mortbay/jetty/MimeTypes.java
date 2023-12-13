package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.BufferCache;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Map.Entry;

public class MimeTypes {
   public static final String FORM_ENCODED = "application/x-www-form-urlencoded";
   public static final String MESSAGE_HTTP = "message/http";
   public static final String MULTIPART_BYTERANGES = "multipart/byteranges";
   public static final String TEXT_HTML = "text/html";
   public static final String TEXT_PLAIN = "text/plain";
   public static final String TEXT_XML = "text/xml";
   public static final String TEXT_HTML_8859_1 = "text/html; charset=iso-8859-1";
   public static final String TEXT_PLAIN_8859_1 = "text/plain; charset=iso-8859-1";
   public static final String TEXT_XML_8859_1 = "text/xml; charset=iso-8859-1";
   public static final String TEXT_HTML_UTF_8 = "text/html; charset=utf-8";
   public static final String TEXT_PLAIN_UTF_8 = "text/plain; charset=utf-8";
   public static final String TEXT_XML_UTF_8 = "text/xml; charset=utf-8";
   public static final String TEXT_JSON = "text/json";
   public static final String TEXT_JSON_UTF_8 = "text/json;charset=UTF-8";
   private static final int FORM_ENCODED_ORDINAL = 1;
   private static final int MESSAGE_HTTP_ORDINAL = 2;
   private static final int MULTIPART_BYTERANGES_ORDINAL = 3;
   private static final int TEXT_HTML_ORDINAL = 4;
   private static final int TEXT_PLAIN_ORDINAL = 5;
   private static final int TEXT_XML_ORDINAL = 6;
   private static final int TEXT_HTML_8859_1_ORDINAL = 7;
   private static final int TEXT_PLAIN_8859_1_ORDINAL = 8;
   private static final int TEXT_XML_8859_1_ORDINAL = 9;
   private static final int TEXT_HTML_UTF_8_ORDINAL = 10;
   private static final int TEXT_PLAIN_UTF_8_ORDINAL = 11;
   private static final int TEXT_XML_UTF_8_ORDINAL = 12;
   private static final int TEXT_JSON_ORDINAL = 13;
   private static final int TEXT_JSON_UTF_8_ORDINAL = 14;
   private static int __index = 15;
   public static final BufferCache CACHE = new BufferCache();
   public static final BufferCache.CachedBuffer FORM_ENCODED_BUFFER;
   public static final BufferCache.CachedBuffer MESSAGE_HTTP_BUFFER;
   public static final BufferCache.CachedBuffer MULTIPART_BYTERANGES_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_HTML_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_PLAIN_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_XML_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_HTML_8859_1_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_PLAIN_8859_1_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_XML_8859_1_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_HTML_UTF_8_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_PLAIN_UTF_8_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_XML_UTF_8_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_JSON_BUFFER;
   public static final BufferCache.CachedBuffer TEXT_JSON_UTF_8_BUFFER;
   private static final Map __dftMimeMap;
   private static final Map __encodings;
   private Map _mimeMap;

   public synchronized Map getMimeMap() {
      return this._mimeMap;
   }

   public void setMimeMap(Map mimeMap) {
      if (mimeMap == null) {
         this._mimeMap = null;
      } else {
         Map m = new HashMap();
         Iterator i = mimeMap.entrySet().iterator();

         while(i.hasNext()) {
            Entry entry = (Entry)i.next();
            m.put(entry.getKey(), normalizeMimeType(entry.getValue().toString()));
         }

         this._mimeMap = m;
      }
   }

   public Buffer getMimeByExtension(String filename) {
      Buffer type = null;
      if (filename != null) {
         int i = -1;

         while(type == null) {
            i = filename.indexOf(".", i + 1);
            if (i < 0 || i >= filename.length()) {
               break;
            }

            String ext = StringUtil.asciiToLowerCase(filename.substring(i + 1));
            if (this._mimeMap != null) {
               type = (Buffer)this._mimeMap.get(ext);
            }

            if (type == null) {
               type = (Buffer)__dftMimeMap.get(ext);
            }
         }
      }

      if (type == null) {
         if (this._mimeMap != null) {
            type = (Buffer)this._mimeMap.get("*");
         }

         if (type == null) {
            type = (Buffer)__dftMimeMap.get("*");
         }
      }

      return type;
   }

   public void addMimeMapping(String extension, String type) {
      if (this._mimeMap == null) {
         this._mimeMap = new HashMap();
      }

      this._mimeMap.put(StringUtil.asciiToLowerCase(extension), normalizeMimeType(type));
   }

   private static synchronized Buffer normalizeMimeType(String type) {
      Buffer b = CACHE.get(type);
      if (b == null) {
         b = CACHE.add(type, __index++);
      }

      return b;
   }

   public static String getCharsetFromContentType(Buffer value) {
      if (value instanceof BufferCache.CachedBuffer) {
         switch(((BufferCache.CachedBuffer)value).getOrdinal()) {
         case 7:
         case 8:
         case 9:
            return StringUtil.__ISO_8859_1;
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
            return "UTF-8";
         }
      }

      int i = value.getIndex();
      int end = value.putIndex();
      int state = 0;
      int start = 0;

      for(boolean quote = false; i < end; ++i) {
         byte b = value.peek(i);
         if (quote && state != 10) {
            if (34 == b) {
               quote = false;
            }
         } else {
            switch(state) {
            case 0:
               if (34 == b) {
                  quote = true;
               } else if (59 == b) {
                  state = 1;
               }
               break;
            case 1:
               if (99 == b) {
                  state = 2;
               } else if (32 != b) {
                  state = 0;
               }
               break;
            case 2:
               if (104 == b) {
                  state = 3;
               } else {
                  state = 0;
               }
               break;
            case 3:
               if (97 == b) {
                  state = 4;
               } else {
                  state = 0;
               }
               break;
            case 4:
               if (114 == b) {
                  state = 5;
               } else {
                  state = 0;
               }
               break;
            case 5:
               if (115 == b) {
                  state = 6;
               } else {
                  state = 0;
               }
               break;
            case 6:
               if (101 == b) {
                  state = 7;
               } else {
                  state = 0;
               }
               break;
            case 7:
               if (116 == b) {
                  state = 8;
               } else {
                  state = 0;
               }
               break;
            case 8:
               if (61 == b) {
                  state = 9;
               } else if (32 != b) {
                  state = 0;
               }
               break;
            case 9:
               if (32 != b) {
                  if (34 == b) {
                     quote = true;
                     start = i + 1;
                     state = 10;
                  } else {
                     start = i;
                     state = 10;
                  }
               }
               break;
            case 10:
               if (!quote && (59 == b || 32 == b) || quote && 34 == b) {
                  return CACHE.lookup(value.peek(start, i - start)).toString();
               }
            }
         }
      }

      if (state == 10) {
         return CACHE.lookup(value.peek(start, i - start)).toString();
      } else {
         return null;
      }
   }

   static {
      FORM_ENCODED_BUFFER = CACHE.add("application/x-www-form-urlencoded", 1);
      MESSAGE_HTTP_BUFFER = CACHE.add("message/http", 2);
      MULTIPART_BYTERANGES_BUFFER = CACHE.add("multipart/byteranges", 3);
      TEXT_HTML_BUFFER = CACHE.add("text/html", 4);
      TEXT_PLAIN_BUFFER = CACHE.add("text/plain", 5);
      TEXT_XML_BUFFER = CACHE.add("text/xml", 6);
      TEXT_HTML_8859_1_BUFFER = new BufferCache.CachedBuffer("text/html; charset=iso-8859-1", 7);
      TEXT_PLAIN_8859_1_BUFFER = new BufferCache.CachedBuffer("text/plain; charset=iso-8859-1", 8);
      TEXT_XML_8859_1_BUFFER = new BufferCache.CachedBuffer("text/xml; charset=iso-8859-1", 9);
      TEXT_HTML_UTF_8_BUFFER = new BufferCache.CachedBuffer("text/html; charset=utf-8", 10);
      TEXT_PLAIN_UTF_8_BUFFER = new BufferCache.CachedBuffer("text/plain; charset=utf-8", 11);
      TEXT_XML_UTF_8_BUFFER = new BufferCache.CachedBuffer("text/xml; charset=utf-8", 12);
      TEXT_JSON_BUFFER = CACHE.add("text/json", 13);
      TEXT_JSON_UTF_8_BUFFER = CACHE.add("text/json;charset=UTF-8", 14);
      __dftMimeMap = new HashMap();
      __encodings = new HashMap();

      ResourceBundle encoding;
      Enumeration i;
      try {
         encoding = ResourceBundle.getBundle("com/replaymod/lib/org/mortbay/jetty/mime");
         i = encoding.getKeys();

         while(i.hasMoreElements()) {
            String ext = (String)i.nextElement();
            String m = encoding.getString(ext);
            __dftMimeMap.put(StringUtil.asciiToLowerCase(ext), normalizeMimeType(m));
         }
      } catch (MissingResourceException var5) {
         Log.warn(var5.toString());
         Log.debug((Throwable)var5);
      }

      try {
         encoding = ResourceBundle.getBundle("com/replaymod/lib/org/mortbay/jetty/encoding");
         i = encoding.getKeys();

         while(i.hasMoreElements()) {
            Buffer type = normalizeMimeType((String)i.nextElement());
            __encodings.put(type, encoding.getString(type.toString()));
         }
      } catch (MissingResourceException var4) {
         Log.warn(var4.toString());
         Log.debug((Throwable)var4);
      }

      TEXT_HTML_BUFFER.setAssociate("ISO-8859-1", TEXT_HTML_8859_1_BUFFER);
      TEXT_HTML_BUFFER.setAssociate("ISO_8859_1", TEXT_HTML_8859_1_BUFFER);
      TEXT_HTML_BUFFER.setAssociate("iso-8859-1", TEXT_HTML_8859_1_BUFFER);
      TEXT_PLAIN_BUFFER.setAssociate("ISO-8859-1", TEXT_PLAIN_8859_1_BUFFER);
      TEXT_PLAIN_BUFFER.setAssociate("ISO_8859_1", TEXT_PLAIN_8859_1_BUFFER);
      TEXT_PLAIN_BUFFER.setAssociate("iso-8859-1", TEXT_PLAIN_8859_1_BUFFER);
      TEXT_XML_BUFFER.setAssociate("ISO-8859-1", TEXT_XML_8859_1_BUFFER);
      TEXT_XML_BUFFER.setAssociate("ISO_8859_1", TEXT_XML_8859_1_BUFFER);
      TEXT_XML_BUFFER.setAssociate("iso-8859-1", TEXT_XML_8859_1_BUFFER);
      TEXT_HTML_BUFFER.setAssociate("UTF-8", TEXT_HTML_UTF_8_BUFFER);
      TEXT_HTML_BUFFER.setAssociate("UTF8", TEXT_HTML_UTF_8_BUFFER);
      TEXT_HTML_BUFFER.setAssociate("utf8", TEXT_HTML_UTF_8_BUFFER);
      TEXT_HTML_BUFFER.setAssociate("utf-8", TEXT_HTML_UTF_8_BUFFER);
      TEXT_PLAIN_BUFFER.setAssociate("UTF-8", TEXT_PLAIN_UTF_8_BUFFER);
      TEXT_PLAIN_BUFFER.setAssociate("UTF8", TEXT_PLAIN_UTF_8_BUFFER);
      TEXT_PLAIN_BUFFER.setAssociate("utf-8", TEXT_PLAIN_UTF_8_BUFFER);
      TEXT_XML_BUFFER.setAssociate("UTF-8", TEXT_XML_UTF_8_BUFFER);
      TEXT_XML_BUFFER.setAssociate("utf8", TEXT_XML_UTF_8_BUFFER);
      TEXT_XML_BUFFER.setAssociate("UTF8", TEXT_XML_UTF_8_BUFFER);
      TEXT_XML_BUFFER.setAssociate("utf-8", TEXT_XML_UTF_8_BUFFER);
      TEXT_JSON_BUFFER.setAssociate("UTF-8", TEXT_JSON_UTF_8_BUFFER);
      TEXT_JSON_BUFFER.setAssociate("utf8", TEXT_JSON_UTF_8_BUFFER);
      TEXT_JSON_BUFFER.setAssociate("UTF8", TEXT_JSON_UTF_8_BUFFER);
      TEXT_JSON_BUFFER.setAssociate("utf-8", TEXT_JSON_UTF_8_BUFFER);
   }
}
