package com.replaymod.lib.org.mortbay.util;

import java.io.UnsupportedEncodingException;

public class URIUtil implements Cloneable {
   public static final String SLASH = "/";
   public static final String HTTP = "http";
   public static final String HTTP_COLON = "http:";
   public static final String HTTPS = "https";
   public static final String HTTPS_COLON = "https:";
   public static final String __CHARSET = System.getProperty("com.replaymod.lib.org.mortbay.util.URI.charset", "UTF-8");

   private URIUtil() {
   }

   public static String encodePath(String path) {
      if (path != null && path.length() != 0) {
         StringBuffer buf = encodePath((StringBuffer)null, path);
         return buf == null ? path : buf.toString();
      } else {
         return path;
      }
   }

   public static StringBuffer encodePath(StringBuffer buf, String path) {
      if (buf == null) {
         int i = 0;

         label47:
         while(i < path.length()) {
            char c = path.charAt(i);
            switch(c) {
            case ' ':
            case '"':
            case '#':
            case '%':
            case '\'':
            case ';':
            case '<':
            case '>':
            case '?':
               buf = new StringBuffer(path.length() << 1);
               break label47;
            case '!':
            case '$':
            case '&':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case ':':
            case '=':
            default:
               ++i;
            }
         }

         if (buf == null) {
            return null;
         }
      }

      synchronized(buf) {
         for(int i = 0; i < path.length(); ++i) {
            char c = path.charAt(i);
            switch(c) {
            case ' ':
               buf.append("%20");
               break;
            case '!':
            case '$':
            case '&':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case ':':
            case '=':
            default:
               buf.append(c);
               break;
            case '"':
               buf.append("%22");
               break;
            case '#':
               buf.append("%23");
               break;
            case '%':
               buf.append("%25");
               break;
            case '\'':
               buf.append("%27");
               break;
            case ';':
               buf.append("%3B");
               break;
            case '<':
               buf.append("%3C");
               break;
            case '>':
               buf.append("%3E");
               break;
            case '?':
               buf.append("%3F");
            }
         }

         return buf;
      }
   }

   public static StringBuffer encodeString(StringBuffer buf, String path, String encode) {
      if (buf == null) {
         for(int i = 0; i < path.length(); ++i) {
            char c = path.charAt(i);
            if (c == '%' || encode.indexOf(c) >= 0) {
               buf = new StringBuffer(path.length() << 1);
               break;
            }
         }

         if (buf == null) {
            return null;
         }
      }

      synchronized(buf) {
         for(int i = 0; i < path.length(); ++i) {
            char c = path.charAt(i);
            if (c != '%' && encode.indexOf(c) < 0) {
               buf.append(c);
            } else {
               buf.append('%');
               StringUtil.append(buf, (byte)(255 & c), 16);
            }
         }

         return buf;
      }
   }

   public static String decodePath(String path) {
      if (path == null) {
         return null;
      } else {
         char[] chars = null;
         int n = 0;
         byte[] bytes = null;
         int b = 0;
         int len = path.length();

         for(int i = 0; i < len; ++i) {
            char c = path.charAt(i);
            if (c == '%' && i + 2 < len) {
               if (chars == null) {
                  chars = new char[len];
                  bytes = new byte[len];
                  path.getChars(0, i, chars, 0);
               }

               bytes[b++] = (byte)(255 & TypeUtil.parseInt((String)path, i + 1, 2, 16));
               i += 2;
            } else if (bytes == null) {
               ++n;
            } else {
               if (b > 0) {
                  String s;
                  try {
                     s = new String(bytes, 0, b, __CHARSET);
                  } catch (UnsupportedEncodingException var11) {
                     s = new String(bytes, 0, b);
                  }

                  s.getChars(0, s.length(), chars, n);
                  n += s.length();
                  b = 0;
               }

               chars[n++] = c;
            }
         }

         if (chars == null) {
            return path;
         } else {
            if (b > 0) {
               String s;
               try {
                  s = new String(bytes, 0, b, __CHARSET);
               } catch (UnsupportedEncodingException var10) {
                  s = new String(bytes, 0, b);
               }

               s.getChars(0, s.length(), chars, n);
               n += s.length();
            }

            return new String(chars, 0, n);
         }
      }
   }

   public static String decodePath(byte[] buf, int offset, int length) {
      byte[] bytes = null;
      int n = 0;

      for(int i = 0; i < length; ++i) {
         byte b = buf[i + offset];
         if (b == 37 && i + 2 < length) {
            b = (byte)(255 & TypeUtil.parseInt((byte[])buf, i + offset + 1, 2, 16));
            i += 2;
         } else if (bytes == null) {
            ++n;
            continue;
         }

         if (bytes == null) {
            bytes = new byte[length];

            for(int j = 0; j < n; ++j) {
               bytes[j] = buf[j + offset];
            }
         }

         bytes[n++] = b;
      }

      if (bytes == null) {
         return StringUtil.toString(buf, offset, length, __CHARSET);
      } else {
         return StringUtil.toString(bytes, 0, n, __CHARSET);
      }
   }

   public static String addPaths(String p1, String p2) {
      if (p1 != null && p1.length() != 0) {
         if (p2 != null && p2.length() != 0) {
            int split = p1.indexOf(59);
            if (split < 0) {
               split = p1.indexOf(63);
            }

            if (split == 0) {
               return p2 + p1;
            } else {
               if (split < 0) {
                  split = p1.length();
               }

               StringBuffer buf = new StringBuffer(p1.length() + p2.length() + 2);
               buf.append(p1);
               if (buf.charAt(split - 1) == '/') {
                  if (p2.startsWith("/")) {
                     buf.deleteCharAt(split - 1);
                     buf.insert(split - 1, p2);
                  } else {
                     buf.insert(split, p2);
                  }
               } else if (p2.startsWith("/")) {
                  buf.insert(split, p2);
               } else {
                  buf.insert(split, '/');
                  buf.insert(split + 1, p2);
               }

               return buf.toString();
            }
         } else {
            return p1;
         }
      } else {
         return p1 != null && p2 == null ? p1 : p2;
      }
   }

   public static String parentPath(String p) {
      if (p != null && !"/".equals(p)) {
         int slash = p.lastIndexOf(47, p.length() - 2);
         return slash >= 0 ? p.substring(0, slash + 1) : null;
      } else {
         return null;
      }
   }

   public static String stripPath(String path) {
      if (path == null) {
         return null;
      } else {
         int semi = path.indexOf(59);
         return semi < 0 ? path : path.substring(0, semi);
      }
   }

   public static String canonicalPath(String path) {
      if (path != null && path.length() != 0) {
         int end = path.length();

         int start;
         label184:
         for(start = path.lastIndexOf(47, end); end > 0; start = path.lastIndexOf(47, start - 1)) {
            switch(end - start) {
            case 2:
               if (path.charAt(start + 1) == '.') {
                  break label184;
               }
               break;
            case 3:
               if (path.charAt(start + 1) == '.' && path.charAt(start + 2) == '.') {
                  break label184;
               }
            }

            end = start;
         }

         if (start >= end) {
            return path;
         } else {
            StringBuffer buf = new StringBuffer(path);
            int delStart = -1;
            int delEnd = -1;
            int skip = 0;

            while(true) {
               while(end > 0) {
                  switch(end - start) {
                  case 2:
                     if (buf.charAt(start + 1) != '.') {
                        if (skip > 0) {
                           --skip;
                           if (skip == 0) {
                              delStart = start >= 0 ? start : 0;
                              if (delStart > 0 && delEnd == buf.length() && buf.charAt(delEnd - 1) == '.') {
                                 ++delStart;
                              }
                           }
                        }
                     } else {
                        if (start < 0 && buf.length() > 2 && buf.charAt(1) == '/' && buf.charAt(2) == '/') {
                           break;
                        }

                        if (delEnd < 0) {
                           delEnd = end;
                        }

                        delStart = start;
                        if (start >= 0 && (start != 0 || buf.charAt(start) != '/')) {
                           if (end == buf.length()) {
                              delStart = start + 1;
                           }

                           for(end = start--; start >= 0 && buf.charAt(start) != '/'; --start) {
                           }
                           continue;
                        }

                        delStart = start + 1;
                        if (delEnd < buf.length() && buf.charAt(delEnd) == '/') {
                           ++delEnd;
                        }
                     }
                     break;
                  case 3:
                     if (buf.charAt(start + 1) == '.' && buf.charAt(start + 2) == '.') {
                        delStart = start;
                        if (delEnd < 0) {
                           delEnd = end;
                        }

                        ++skip;

                        for(end = start--; start >= 0 && buf.charAt(start) != '/'; --start) {
                        }
                        continue;
                     }

                     if (skip > 0) {
                        --skip;
                        if (skip == 0) {
                           delStart = start >= 0 ? start : 0;
                           if (delStart > 0 && delEnd == buf.length() && buf.charAt(delEnd - 1) == '.') {
                              ++delStart;
                           }
                        }
                     }
                     break;
                  default:
                     if (skip > 0) {
                        --skip;
                        if (skip == 0) {
                           delStart = start >= 0 ? start : 0;
                           if (delEnd == buf.length() && buf.charAt(delEnd - 1) == '.') {
                              ++delStart;
                           }
                        }
                     }
                  }

                  if (skip <= 0 && delStart >= 0 && delEnd >= delStart) {
                     buf.delete(delStart, delEnd);
                     delEnd = -1;
                     delStart = -1;
                     if (skip > 0) {
                        delEnd = end;
                     }
                  }

                  for(end = start--; start >= 0 && buf.charAt(start) != '/'; --start) {
                  }
               }

               if (skip > 0) {
                  return null;
               }

               if (delEnd >= 0) {
                  buf.delete(delStart, delEnd);
               }

               return buf.toString();
            }
         }
      } else {
         return path;
      }
   }

   public static String compactPath(String path) {
      if (path != null && path.length() != 0) {
         int state = 0;
         int end = path.length();

         int i;
         label44:
         for(i = 0; i < end; ++i) {
            char c = path.charAt(i);
            switch(c) {
            case '/':
               ++state;
               if (state == 2) {
                  break label44;
               }
               break;
            case '?':
               return path;
            default:
               state = 0;
            }
         }

         if (state < 2) {
            return path;
         } else {
            StringBuffer buf = new StringBuffer(path.length());
            char[] chars = path.toCharArray();
            buf.append(chars, 0, i);

            for(; i < end; ++i) {
               char c = path.charAt(i);
               switch(c) {
               case '/':
                  if (state++ == 0) {
                     buf.append(c);
                  }
                  break;
               case '?':
                  buf.append(chars, i, end - i);
                  return buf.toString();
               default:
                  state = 0;
                  buf.append(c);
               }
            }

            return buf.toString();
         }
      } else {
         return path;
      }
   }

   public static boolean hasScheme(String uri) {
      for(int i = 0; i < uri.length(); ++i) {
         char c = uri.charAt(i);
         if (c == ':') {
            return true;
         }

         if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (i <= 0 || (c < '0' || c > '9') && c != '.' && c != '+' && c != '-')) {
            break;
         }
      }

      return false;
   }
}
