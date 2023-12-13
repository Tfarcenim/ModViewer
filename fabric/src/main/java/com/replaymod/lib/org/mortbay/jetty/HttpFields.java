package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.BufferCache;
import com.replaymod.lib.org.mortbay.io.BufferDateCache;
import com.replaymod.lib.org.mortbay.io.BufferUtil;
import com.replaymod.lib.org.mortbay.io.ByteArrayBuffer;
import com.replaymod.lib.org.mortbay.io.View;
import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.QuotedStringTokenizer;
import com.replaymod.lib.org.mortbay.util.StringMap;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Map.Entry;
import javax.servlet.http.Cookie;

public class HttpFields {
   public static final String __separators = ", \t";
   private static String[] DAYS = new String[]{"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   private static String[] MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan"};
   private static TimeZone __GMT = TimeZone.getTimeZone("GMT");
   public static final BufferDateCache __dateCache;
   private static final String[] __dateReceiveFmt;
   private static int __dateReceiveInit;
   private static SimpleDateFormat[] __dateReceive;
   public static final String __01Jan1970;
   public static final Buffer __01Jan1970_BUFFER;
   protected ArrayList _fields = new ArrayList(20);
   protected int _revision;
   protected HashMap _bufferMap = new HashMap(32);
   protected SimpleDateFormat[] _dateReceive;
   private StringBuffer _dateBuffer;
   private Calendar _calendar;
   private static Float __one;
   private static Float __zero;
   private static StringMap __qualities;

   public static String formatDate(long date, boolean cookie) {
      StringBuffer buf = new StringBuffer(32);
      GregorianCalendar gc = new GregorianCalendar(__GMT);
      gc.setTimeInMillis(date);
      formatDate(buf, gc, cookie);
      return buf.toString();
   }

   public static String formatDate(Calendar calendar, boolean cookie) {
      StringBuffer buf = new StringBuffer(32);
      formatDate(buf, calendar, cookie);
      return buf.toString();
   }

   public static String formatDate(StringBuffer buf, long date, boolean cookie) {
      GregorianCalendar gc = new GregorianCalendar(__GMT);
      gc.setTimeInMillis(date);
      formatDate(buf, gc, cookie);
      return buf.toString();
   }

   public static void formatDate(StringBuffer buf, Calendar calendar, boolean cookie) {
      int day_of_week = calendar.get(7);
      int day_of_month = calendar.get(5);
      int month = calendar.get(2);
      int year = calendar.get(1);
      int century = year / 100;
      year %= 100;
      int epoch = (int)(calendar.getTimeInMillis() / 1000L % 86400L);
      int seconds = epoch % 60;
      epoch /= 60;
      int minutes = epoch % 60;
      int hours = epoch / 60;
      buf.append(DAYS[day_of_week]);
      buf.append(',');
      buf.append(' ');
      StringUtil.append2digits(buf, day_of_month);
      if (cookie) {
         buf.append('-');
         buf.append(MONTHS[month]);
         buf.append('-');
         StringUtil.append2digits(buf, century);
         StringUtil.append2digits(buf, year);
      } else {
         buf.append(' ');
         buf.append(MONTHS[month]);
         buf.append(' ');
         StringUtil.append2digits(buf, century);
         StringUtil.append2digits(buf, year);
      }

      buf.append(' ');
      StringUtil.append2digits(buf, hours);
      buf.append(':');
      StringUtil.append2digits(buf, minutes);
      buf.append(':');
      StringUtil.append2digits(buf, seconds);
      buf.append(" GMT");
   }

   public HttpFields() {
      this._dateReceive = new SimpleDateFormat[__dateReceive.length];
   }

   public Enumeration getFieldNames() {
      final int revision = this._revision;
      return new Enumeration() {
         int i = 0;
         HttpFields.Field field = null;

         public boolean hasMoreElements() {
            if (this.field != null) {
               return true;
            } else {
               HttpFields.Field f;
               do {
                  if (this.i >= HttpFields.this._fields.size()) {
                     return false;
                  }

                  f = (HttpFields.Field)HttpFields.this._fields.get(this.i++);
               } while(f == null || f._prev != null || f._revision != revision);

               this.field = f;
               return true;
            }
         }

         public Object nextElement() throws NoSuchElementException {
            if (this.field == null && !this.hasMoreElements()) {
               throw new NoSuchElementException();
            } else {
               String n = BufferUtil.to8859_1_String(this.field._name);
               this.field = null;
               return n;
            }
         }
      };
   }

   public Iterator getFields() {
      final int revision = this._revision;
      return new Iterator() {
         int i = 0;
         HttpFields.Field field = null;

         public boolean hasNext() {
            if (this.field != null) {
               return true;
            } else {
               HttpFields.Field f;
               do {
                  if (this.i >= HttpFields.this._fields.size()) {
                     return false;
                  }

                  f = (HttpFields.Field)HttpFields.this._fields.get(this.i++);
               } while(f == null || f._revision != revision);

               this.field = f;
               return true;
            }
         }

         public Object next() {
            if (this.field == null && !this.hasNext()) {
               throw new NoSuchElementException();
            } else {
               HttpFields.Field f = this.field;
               this.field = null;
               return f;
            }
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }
      };
   }

   private HttpFields.Field getField(String name) {
      return (HttpFields.Field)this._bufferMap.get(HttpHeaders.CACHE.lookup(name));
   }

   private HttpFields.Field getField(Buffer name) {
      return (HttpFields.Field)this._bufferMap.get(name);
   }

   public boolean containsKey(Buffer name) {
      HttpFields.Field f = this.getField(name);
      return f != null && f._revision == this._revision;
   }

   public boolean containsKey(String name) {
      HttpFields.Field f = this.getField(name);
      return f != null && f._revision == this._revision;
   }

   public String getStringField(String name) {
      HttpFields.Field field = this.getField(name);
      return field != null && field._revision == this._revision ? field.getValue() : null;
   }

   public String getStringField(Buffer name) {
      HttpFields.Field field = this.getField(name);
      return field != null && field._revision == this._revision ? BufferUtil.to8859_1_String(field._value) : null;
   }

   public Buffer get(Buffer name) {
      HttpFields.Field field = this.getField(name);
      return field != null && field._revision == this._revision ? field._value : null;
   }

   public Enumeration getValues(String name) {
      final HttpFields.Field field = this.getField(name);
      if (field == null) {
         return null;
      } else {
         final int revision = this._revision;
         return new Enumeration() {
            HttpFields.Field f = field;

            public boolean hasMoreElements() {
               while(this.f != null && this.f._revision != revision) {
                  this.f = this.f._next;
               }

               return this.f != null;
            }

            public Object nextElement() throws NoSuchElementException {
               if (this.f == null) {
                  throw new NoSuchElementException();
               } else {
                  HttpFields.Field n = this.f;

                  do {
                     this.f = this.f._next;
                  } while(this.f != null && this.f._revision != revision);

                  return n.getValue();
               }
            }
         };
      }
   }

   public Enumeration getValues(Buffer name) {
      final HttpFields.Field field = this.getField(name);
      if (field == null) {
         return null;
      } else {
         final int revision = this._revision;
         return new Enumeration() {
            HttpFields.Field f = field;

            public boolean hasMoreElements() {
               while(this.f != null && this.f._revision != revision) {
                  this.f = this.f._next;
               }

               return this.f != null;
            }

            public Object nextElement() throws NoSuchElementException {
               if (this.f == null) {
                  throw new NoSuchElementException();
               } else {
                  HttpFields.Field n = this.f;

                  for(this.f = this.f._next; this.f != null && this.f._revision != revision; this.f = this.f._next) {
                  }

                  return n.getValue();
               }
            }
         };
      }
   }

   public Enumeration getValues(String name, String separators) {
      final Enumeration e = this.getValues(name);
      return e == null ? null : new Enumeration() {
         QuotedStringTokenizer tok = null;

         public boolean hasMoreElements() {
            if (this.tok != null && this.tok.hasMoreElements()) {
               return true;
            } else {
               do {
                  if (!e.hasMoreElements()) {
                     this.tok = null;
                     return false;
                  }

                  String value = (String)e.nextElement();
                  this.tok = new QuotedStringTokenizer(value, separators, false, false);
               } while(!this.tok.hasMoreElements());

               return true;
            }
         }

         public Object nextElement() throws NoSuchElementException {
            if (!this.hasMoreElements()) {
               throw new NoSuchElementException();
            } else {
               String next = (String)this.tok.nextElement();
               if (next != null) {
                  next = next.trim();
               }

               return next;
            }
         }
      };
   }

   public void put(String name, String value) {
      Buffer n = HttpHeaders.CACHE.lookup(name);
      Buffer v = null;
      if (value != null) {
         v = HttpHeaderValues.CACHE.lookup(value);
      }

      this.put(n, v, -1L);
   }

   public void put(Buffer name, String value) {
      Buffer v = HttpHeaderValues.CACHE.lookup(value);
      this.put(name, v, -1L);
   }

   public void put(Buffer name, Buffer value) {
      this.put(name, value, -1L);
   }

   public void put(Buffer name, Buffer value, long numValue) {
      if (value == null) {
         this.remove(name);
      } else {
         if (!(name instanceof BufferCache.CachedBuffer)) {
            name = HttpHeaders.CACHE.lookup(name);
         }

         HttpFields.Field field = (HttpFields.Field)this._bufferMap.get(name);
         if (field == null) {
            field = new HttpFields.Field(name, value, numValue, this._revision);
            this._fields.add(field);
            this._bufferMap.put(field.getNameBuffer(), field);
         } else {
            field.reset(value, numValue, this._revision);

            for(field = field._next; field != null; field = field._next) {
               field.clear();
            }

         }
      }
   }

   public void put(String name, List list) {
      if (list != null && list.size() != 0) {
         Buffer n = HttpHeaders.CACHE.lookup(name);
         Object v = list.get(0);
         if (v != null) {
            this.put(n, HttpHeaderValues.CACHE.lookup(v.toString()));
         } else {
            this.remove(n);
         }

         if (list.size() > 1) {
            Iterator iter = list.iterator();
            iter.next();

            while(iter.hasNext()) {
               v = iter.next();
               if (v != null) {
                  this.put(n, HttpHeaderValues.CACHE.lookup(v.toString()));
               }
            }
         }

      } else {
         this.remove(name);
      }
   }

   public void add(String name, String value) throws IllegalArgumentException {
      Buffer n = HttpHeaders.CACHE.lookup(name);
      Buffer v = HttpHeaderValues.CACHE.lookup(value);
      this.add(n, v, -1L);
   }

   public void add(Buffer name, Buffer value) throws IllegalArgumentException {
      this.add(name, value, -1L);
   }

   private void add(Buffer name, Buffer value, long numValue) throws IllegalArgumentException {
      if (value == null) {
         throw new IllegalArgumentException("null value");
      } else {
         if (!(name instanceof BufferCache.CachedBuffer)) {
            name = HttpHeaders.CACHE.lookup(name);
         }

         HttpFields.Field field = (HttpFields.Field)this._bufferMap.get(name);
         HttpFields.Field last = null;
         if (field != null) {
            while(field != null && field._revision == this._revision) {
               last = field;
               field = field._next;
            }
         }

         if (field != null) {
            field.reset(value, numValue, this._revision);
         } else {
            field = new HttpFields.Field(name, value, numValue, this._revision);
            if (last != null) {
               field._prev = last;
               last._next = field;
            } else {
               this._bufferMap.put(field.getNameBuffer(), field);
            }

            this._fields.add(field);
         }

      }
   }

   public void remove(String name) {
      this.remove(HttpHeaders.CACHE.lookup(name));
   }

   public void remove(Buffer name) {
      HttpFields.Field field = (HttpFields.Field)this._bufferMap.get(name);
      if (field != null) {
         while(field != null) {
            field.clear();
            field = field._next;
         }
      }

   }

   public long getLongField(String name) throws NumberFormatException {
      HttpFields.Field field = this.getField(name);
      return field != null && field._revision == this._revision ? field.getLongValue() : -1L;
   }

   public long getLongField(Buffer name) throws NumberFormatException {
      HttpFields.Field field = this.getField(name);
      return field != null && field._revision == this._revision ? field.getLongValue() : -1L;
   }

   public long getDateField(String name) {
      HttpFields.Field field = this.getField(name);
      if (field != null && field._revision == this._revision) {
         if (field._numValue != -1L) {
            return field._numValue;
         } else {
            String val = valueParameters(BufferUtil.to8859_1_String(field._value), (Map)null);
            if (val == null) {
               return -1L;
            } else {
               int i = 0;

               Date date;
               while(i < __dateReceiveInit) {
                  if (this._dateReceive[i] == null) {
                     this._dateReceive[i] = (SimpleDateFormat)__dateReceive[i].clone();
                  }

                  try {
                     date = (Date)this._dateReceive[i].parseObject(val);
                     return field._numValue = date.getTime();
                  } catch (Exception var12) {
                     ++i;
                  }
               }

               if (val.endsWith(" GMT")) {
                  val = val.substring(0, val.length() - 4);
                  i = 0;

                  while(i < __dateReceiveInit) {
                     try {
                        date = (Date)this._dateReceive[i].parseObject(val);
                        return field._numValue = date.getTime();
                     } catch (Exception var11) {
                        ++i;
                     }
                  }
               }

               synchronized(__dateReceive) {
                  int i = __dateReceiveInit;

                  while(true) {
                     long var10000;
                     Date date;
                     if (i < this._dateReceive.length) {
                        if (this._dateReceive[i] == null) {
                           if (__dateReceive[i] == null) {
                              __dateReceive[i] = new SimpleDateFormat(__dateReceiveFmt[i], Locale.US);
                              __dateReceive[i].setTimeZone(__GMT);
                           }

                           this._dateReceive[i] = (SimpleDateFormat)__dateReceive[i].clone();
                        }

                        try {
                           date = (Date)this._dateReceive[i].parseObject(val);
                           var10000 = field._numValue = date.getTime();
                        } catch (Exception var9) {
                           ++i;
                           continue;
                        }

                        return var10000;
                     }

                     if (val.endsWith(" GMT")) {
                        val = val.substring(0, val.length() - 4);
                        i = 0;

                        while(i < this._dateReceive.length) {
                           try {
                              date = (Date)this._dateReceive[i].parseObject(val);
                              var10000 = field._numValue = date.getTime();
                              return var10000;
                           } catch (Exception var8) {
                              ++i;
                           }
                        }
                     }
                     break;
                  }
               }

               throw new IllegalArgumentException("Cannot convert date: " + val);
            }
         }
      } else {
         return -1L;
      }
   }

   public void putLongField(Buffer name, long value) {
      Buffer v = BufferUtil.toBuffer(value);
      this.put(name, v, value);
   }

   public void putLongField(String name, long value) {
      Buffer n = HttpHeaders.CACHE.lookup(name);
      Buffer v = BufferUtil.toBuffer(value);
      this.put(n, v, value);
   }

   public void addLongField(String name, long value) {
      Buffer n = HttpHeaders.CACHE.lookup(name);
      Buffer v = BufferUtil.toBuffer(value);
      this.add(n, v, value);
   }

   public void addLongField(Buffer name, long value) {
      Buffer v = BufferUtil.toBuffer(value);
      this.add(name, v, value);
   }

   public void putDateField(Buffer name, long date) {
      if (this._dateBuffer == null) {
         this._dateBuffer = new StringBuffer(32);
         this._calendar = new GregorianCalendar(__GMT);
      }

      this._dateBuffer.setLength(0);
      this._calendar.setTimeInMillis(date);
      formatDate(this._dateBuffer, this._calendar, false);
      Buffer v = new ByteArrayBuffer(this._dateBuffer.toString());
      this.put(name, v, date);
   }

   public void putDateField(String name, long date) {
      Buffer n = HttpHeaders.CACHE.lookup(name);
      this.putDateField(n, date);
   }

   public void addDateField(String name, long date) {
      if (this._dateBuffer == null) {
         this._dateBuffer = new StringBuffer(32);
         this._calendar = new GregorianCalendar(__GMT);
      }

      this._dateBuffer.setLength(0);
      this._calendar.setTimeInMillis(date);
      formatDate(this._dateBuffer, this._calendar, false);
      Buffer n = HttpHeaders.CACHE.lookup(name);
      Buffer v = new ByteArrayBuffer(this._dateBuffer.toString());
      this.add(n, v, date);
   }

   public void addSetCookie(Cookie cookie) {
      String name = cookie.getName();
      String value = cookie.getValue();
      int version = cookie.getVersion();
      if (name != null && name.length() != 0) {
         StringBuffer buf = new StringBuffer(128);
         String name_value_params = null;
         synchronized(buf) {
            QuotedStringTokenizer.quoteIfNeeded(buf, name);
            buf.append('=');
            if (value != null && value.length() > 0) {
               QuotedStringTokenizer.quoteIfNeeded(buf, value);
            }

            String path;
            if (version > 0) {
               buf.append(";Version=");
               buf.append(version);
               path = cookie.getComment();
               if (path != null && path.length() > 0) {
                  buf.append(";Comment=");
                  QuotedStringTokenizer.quoteIfNeeded(buf, path);
               }
            }

            path = cookie.getPath();
            if (path != null && path.length() > 0) {
               buf.append(";Path=");
               if (path.startsWith("\"")) {
                  buf.append(path);
               } else {
                  QuotedStringTokenizer.quoteIfNeeded(buf, path);
               }
            }

            String domain = cookie.getDomain();
            if (domain != null && domain.length() > 0) {
               buf.append(";Domain=");
               QuotedStringTokenizer.quoteIfNeeded(buf, domain.toLowerCase());
            }

            long maxAge = (long)cookie.getMaxAge();
            if (maxAge >= 0L) {
               if (version == 0) {
                  buf.append(";Expires=");
                  if (maxAge == 0L) {
                     buf.append(__01Jan1970);
                  } else {
                     formatDate(buf, System.currentTimeMillis() + 1000L * maxAge, true);
                  }
               } else {
                  buf.append(";Max-Age=");
                  buf.append(maxAge);
               }
            } else if (version > 0) {
               buf.append(";Discard");
            }

            if (cookie.getSecure()) {
               buf.append(";Secure");
            }

            if (cookie instanceof HttpOnlyCookie) {
               buf.append(";HttpOnly");
            }

            name_value_params = buf.toString();
         }

         this.put(HttpHeaders.EXPIRES_BUFFER, __01Jan1970_BUFFER);
         this.add((Buffer)HttpHeaders.SET_COOKIE_BUFFER, (Buffer)(new ByteArrayBuffer(name_value_params)));
      } else {
         throw new IllegalArgumentException("Bad cookie name");
      }
   }

   public void put(Buffer buffer) throws IOException {
      for(int i = 0; i < this._fields.size(); ++i) {
         HttpFields.Field field = (HttpFields.Field)this._fields.get(i);
         if (field != null && field._revision == this._revision) {
            field.put(buffer);
         }
      }

      BufferUtil.putCRLF(buffer);
   }

   public String toString() {
      try {
         StringBuffer buffer = new StringBuffer();

         for(int i = 0; i < this._fields.size(); ++i) {
            HttpFields.Field field = (HttpFields.Field)this._fields.get(i);
            if (field != null && field._revision == this._revision) {
               String tmp = field.getName();
               if (tmp != null) {
                  buffer.append(tmp);
               }

               buffer.append(": ");
               tmp = field.getValue();
               if (tmp != null) {
                  buffer.append(tmp);
               }

               buffer.append("\r\n");
            }
         }

         buffer.append("\r\n");
         return buffer.toString();
      } catch (Exception var5) {
         var5.printStackTrace();
         return null;
      }
   }

   public void clear() {
      ++this._revision;
      if (this._revision > 1000000) {
         this._revision = 0;
         int i = this._fields.size();

         while(i-- > 0) {
            HttpFields.Field field = (HttpFields.Field)this._fields.get(i);
            if (field != null) {
               field.clear();
            }
         }
      }

   }

   public void destroy() {
      if (this._fields != null) {
         int i = this._fields.size();

         while(i-- > 0) {
            HttpFields.Field field = (HttpFields.Field)this._fields.get(i);
            if (field != null) {
               this._bufferMap.remove(field.getNameBuffer());
               field.destroy();
            }
         }
      }

      this._fields = null;
      this._dateBuffer = null;
      this._calendar = null;
      this._dateReceive = null;
   }

   public void add(HttpFields fields) {
      if (fields != null) {
         Enumeration e = fields.getFieldNames();

         while(e.hasMoreElements()) {
            String name = (String)e.nextElement();
            Enumeration values = fields.getValues(name);

            while(values.hasMoreElements()) {
               this.add(name, (String)values.nextElement());
            }
         }

      }
   }

   public static String valueParameters(String value, Map parameters) {
      if (value == null) {
         return null;
      } else {
         int i = value.indexOf(59);
         if (i < 0) {
            return value;
         } else if (parameters == null) {
            return value.substring(0, i).trim();
         } else {
            QuotedStringTokenizer tok1 = new QuotedStringTokenizer(value.substring(i), ";", false, true);

            while(tok1.hasMoreTokens()) {
               String token = tok1.nextToken();
               StringTokenizer tok2 = new QuotedStringTokenizer(token, "= ");
               if (tok2.hasMoreTokens()) {
                  String paramName = tok2.nextToken();
                  String paramVal = null;
                  if (tok2.hasMoreTokens()) {
                     paramVal = tok2.nextToken();
                  }

                  parameters.put(paramName, paramVal);
               }
            }

            return value.substring(0, i).trim();
         }
      }
   }

   public static Float getQuality(String value) {
      if (value == null) {
         return __zero;
      } else {
         int qe = value.indexOf(";");
         if (qe++ >= 0 && qe != value.length()) {
            if (value.charAt(qe++) == 'q') {
               ++qe;
               Entry entry = __qualities.getEntry(value, qe, value.length() - qe);
               if (entry != null) {
                  return (Float)entry.getValue();
               }
            }

            HashMap params = new HashMap(3);
            valueParameters(value, params);
            String qs = (String)params.get("q");
            Float q = (Float)__qualities.get(qs);
            if (q == null) {
               try {
                  q = new Float(qs);
               } catch (Exception var6) {
                  q = __one;
               }
            }

            return q;
         } else {
            return __one;
         }
      }
   }

   public static List qualityList(Enumeration e) {
      if (e != null && e.hasMoreElements()) {
         Object list = null;
         Object qual = null;

         while(e.hasMoreElements()) {
            String v = e.nextElement().toString();
            Float q = getQuality(v);
            if ((double)q >= 0.001D) {
               list = LazyList.add(list, v);
               qual = LazyList.add(qual, q);
            }
         }

         List vl = LazyList.getList(list, false);
         if (vl.size() < 2) {
            return vl;
         } else {
            List ql = LazyList.getList(qual, false);
            Float last = __zero;
            int i = vl.size();

            while(i-- > 0) {
               Float q = (Float)ql.get(i);
               if (last.compareTo(q) > 0) {
                  Object tmp = vl.get(i);
                  vl.set(i, vl.get(i + 1));
                  vl.set(i + 1, tmp);
                  ql.set(i, ql.get(i + 1));
                  ql.set(i + 1, q);
                  last = __zero;
                  i = vl.size();
               } else {
                  last = q;
               }
            }

            ql.clear();
            return vl;
         }
      } else {
         return Collections.EMPTY_LIST;
      }
   }

   static {
      __dateCache = new BufferDateCache("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
      __dateReceiveFmt = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss", "EEE MMM dd HH:mm:ss yyyy", "EEE, dd MMM yyyy HH:mm:ss", "EEE dd MMM yyyy HH:mm:ss zzz", "EEE dd MMM yyyy HH:mm:ss", "EEE MMM dd yyyy HH:mm:ss zzz", "EEE MMM dd yyyy HH:mm:ss", "EEE MMM-dd-yyyy HH:mm:ss zzz", "EEE MMM-dd-yyyy HH:mm:ss", "dd MMM yyyy HH:mm:ss zzz", "dd MMM yyyy HH:mm:ss", "dd-MMM-yy HH:mm:ss zzz", "dd-MMM-yy HH:mm:ss", "MMM dd HH:mm:ss yyyy zzz", "MMM dd HH:mm:ss yyyy", "EEE MMM dd HH:mm:ss yyyy zzz", "EEE, MMM dd HH:mm:ss yyyy zzz", "EEE, MMM dd HH:mm:ss yyyy", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE dd-MMM-yy HH:mm:ss zzz", "EEE dd-MMM-yy HH:mm:ss"};
      __dateReceiveInit = 3;
      __GMT.setID("GMT");
      __dateCache.setTimeZone(__GMT);
      __dateReceive = new SimpleDateFormat[__dateReceiveFmt.length];

      for(int i = 0; i < __dateReceiveInit; ++i) {
         __dateReceive[i] = new SimpleDateFormat(__dateReceiveFmt[i], Locale.US);
         __dateReceive[i].setTimeZone(__GMT);
      }

      __01Jan1970 = formatDate(0L, true).trim();
      __01Jan1970_BUFFER = new ByteArrayBuffer(__01Jan1970);
      __one = new Float("1.0");
      __zero = new Float("0.0");
      __qualities = new StringMap();
      __qualities.put((String)null, __one);
      __qualities.put((String)"1.0", __one);
      __qualities.put((String)"1", __one);
      __qualities.put((String)"0.9", new Float("0.9"));
      __qualities.put((String)"0.8", new Float("0.8"));
      __qualities.put((String)"0.7", new Float("0.7"));
      __qualities.put((String)"0.66", new Float("0.66"));
      __qualities.put((String)"0.6", new Float("0.6"));
      __qualities.put((String)"0.5", new Float("0.5"));
      __qualities.put((String)"0.4", new Float("0.4"));
      __qualities.put((String)"0.33", new Float("0.33"));
      __qualities.put((String)"0.3", new Float("0.3"));
      __qualities.put((String)"0.2", new Float("0.2"));
      __qualities.put((String)"0.1", new Float("0.1"));
      __qualities.put((String)"0", __zero);
      __qualities.put((String)"0.0", __zero);
   }

   public static final class Field {
      private Buffer _name;
      private Buffer _value;
      private String _stringValue;
      private long _numValue;
      private HttpFields.Field _next;
      private HttpFields.Field _prev;
      private int _revision;

      private Field(Buffer name, Buffer value, long numValue, int revision) {
         this._name = name.asImmutableBuffer();
         this._value = (Buffer)(value.isImmutable() ? value : new View(value));
         this._next = null;
         this._prev = null;
         this._revision = revision;
         this._numValue = numValue;
         this._stringValue = null;
      }

      private void clear() {
         this._revision = -1;
      }

      private void destroy() {
         this._name = null;
         this._value = null;
         this._next = null;
         this._prev = null;
         this._stringValue = null;
      }

      private void reset(Buffer value, long numValue, int revision) {
         this._revision = revision;
         if (this._value == null) {
            this._value = (Buffer)(value.isImmutable() ? value : new View(value));
            this._numValue = numValue;
            this._stringValue = null;
         } else if (value.isImmutable()) {
            this._value = value;
            this._numValue = numValue;
            this._stringValue = null;
         } else {
            if (this._value instanceof View) {
               ((View)this._value).update(value);
            } else {
               this._value = new View(value);
            }

            this._numValue = numValue;
            if (this._stringValue != null) {
               if (this._stringValue.length() != value.length()) {
                  this._stringValue = null;
               } else {
                  int i = value.length();

                  while(i-- > 0) {
                     if (value.peek(value.getIndex() + i) != this._stringValue.charAt(i)) {
                        this._stringValue = null;
                        break;
                     }
                  }
               }
            }
         }

      }

      public void put(Buffer buffer) throws IOException {
         int o = this._name instanceof BufferCache.CachedBuffer ? ((BufferCache.CachedBuffer)this._name).getOrdinal() : -1;
         int s;
         int e;
         byte b;
         if (o >= 0) {
            buffer.put(this._name);
         } else {
            s = this._name.getIndex();
            e = this._name.putIndex();

            while(s < e) {
               b = this._name.peek(s++);
               switch(b) {
               case 10:
               case 13:
               case 58:
                  break;
               default:
                  buffer.put(b);
               }
            }
         }

         buffer.put((byte)58);
         buffer.put((byte)32);
         o = this._value instanceof BufferCache.CachedBuffer ? ((BufferCache.CachedBuffer)this._value).getOrdinal() : -1;
         if (o < 0 && this._numValue < 0L) {
            s = this._value.getIndex();
            e = this._value.putIndex();

            while(s < e) {
               b = this._value.peek(s++);
               switch(b) {
               case 10:
               case 13:
                  break;
               default:
                  buffer.put(b);
               }
            }
         } else {
            buffer.put(this._value);
         }

         BufferUtil.putCRLF(buffer);
      }

      public String getName() {
         return BufferUtil.to8859_1_String(this._name);
      }

      Buffer getNameBuffer() {
         return this._name;
      }

      public int getNameOrdinal() {
         return HttpHeaders.CACHE.getOrdinal(this._name);
      }

      public String getValue() {
         if (this._stringValue == null) {
            this._stringValue = BufferUtil.to8859_1_String(this._value);
         }

         return this._stringValue;
      }

      public Buffer getValueBuffer() {
         return this._value;
      }

      public int getValueOrdinal() {
         return HttpHeaderValues.CACHE.getOrdinal(this._value);
      }

      public int getIntValue() {
         return (int)this.getLongValue();
      }

      public long getLongValue() {
         if (this._numValue == -1L) {
            this._numValue = BufferUtil.toLong(this._value);
         }

         return this._numValue;
      }

      public String toString() {
         return "[" + (this._prev == null ? "" : "<-") + this.getName() + "=" + this._revision + "=" + this._value + (this._next == null ? "" : "->") + "]";
      }

      // $FF: synthetic method
      Field(Buffer x0, Buffer x1, long x2, int x3, Object x4) {
         this(x0, x1, x2, x3);
      }
   }
}
