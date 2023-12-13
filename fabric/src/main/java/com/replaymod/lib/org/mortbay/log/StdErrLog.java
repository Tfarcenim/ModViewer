package com.replaymod.lib.org.mortbay.log;

import com.replaymod.lib.org.mortbay.util.DateCache;

public class StdErrLog implements Logger {
   private static DateCache _dateCache;
   private static boolean __debug = System.getProperty("DEBUG", (String)null) != null;
   private String _name;
   StringBuffer _buffer;

   public StdErrLog() {
      this((String)null);
   }

   public StdErrLog(String name) {
      this._buffer = new StringBuffer();
      this._name = name == null ? "" : name;
   }

   public boolean isDebugEnabled() {
      return __debug;
   }

   public void setDebugEnabled(boolean enabled) {
      __debug = enabled;
   }

   public void info(String msg, Object arg0, Object arg1) {
      String d = _dateCache.now();
      int ms = _dateCache.lastMs();
      synchronized(this._buffer) {
         this.tag(d, ms, ":INFO:");
         this.format(msg, arg0, arg1);
         System.err.println(this._buffer.toString());
      }
   }

   public void debug(String msg, Throwable th) {
      if (__debug) {
         String d = _dateCache.now();
         int ms = _dateCache.lastMs();
         synchronized(this._buffer) {
            this.tag(d, ms, ":DBUG:");
            this.format(msg);
            this.format(th);
            System.err.println(this._buffer.toString());
         }
      }

   }

   public void debug(String msg, Object arg0, Object arg1) {
      if (__debug) {
         String d = _dateCache.now();
         int ms = _dateCache.lastMs();
         synchronized(this._buffer) {
            this.tag(d, ms, ":DBUG:");
            this.format(msg, arg0, arg1);
            System.err.println(this._buffer.toString());
         }
      }

   }

   public void warn(String msg, Object arg0, Object arg1) {
      String d = _dateCache.now();
      int ms = _dateCache.lastMs();
      synchronized(this._buffer) {
         this.tag(d, ms, ":WARN:");
         this.format(msg, arg0, arg1);
         System.err.println(this._buffer.toString());
      }
   }

   public void warn(String msg, Throwable th) {
      String d = _dateCache.now();
      int ms = _dateCache.lastMs();
      synchronized(this._buffer) {
         this.tag(d, ms, ":WARN:");
         this.format(msg);
         this.format(th);
         System.err.println(this._buffer.toString());
      }
   }

   private void tag(String d, int ms, String tag) {
      this._buffer.setLength(0);
      this._buffer.append(d);
      if (ms > 99) {
         this._buffer.append('.');
      } else if (ms > 9) {
         this._buffer.append(".0");
      } else {
         this._buffer.append(".00");
      }

      this._buffer.append(ms).append(tag).append(this._name).append(':');
   }

   private void format(String msg, Object arg0, Object arg1) {
      int i0 = msg == null ? -1 : msg.indexOf("{}");
      int i1 = i0 < 0 ? -1 : msg.indexOf("{}", i0 + 2);
      if (i0 >= 0) {
         this.format(msg.substring(0, i0));
         this.format(String.valueOf(arg0 == null ? "null" : arg0));
         if (i1 >= 0) {
            this.format(msg.substring(i0 + 2, i1));
            this.format(String.valueOf(arg1 == null ? "null" : arg1));
            this.format(msg.substring(i1 + 2));
         } else {
            this.format(msg.substring(i0 + 2));
            if (arg1 != null) {
               this._buffer.append(' ');
               this.format(String.valueOf(arg1));
            }
         }
      } else {
         this.format(msg);
         if (arg0 != null) {
            this._buffer.append(' ');
            this.format(String.valueOf(arg0));
         }

         if (arg1 != null) {
            this._buffer.append(' ');
            this.format(String.valueOf(arg1));
         }
      }

   }

   private void format(String msg) {
      if (msg == null) {
         this._buffer.append("null");
      } else {
         for(int i = 0; i < msg.length(); ++i) {
            char c = msg.charAt(i);
            if (Character.isISOControl(c)) {
               if (c == '\n') {
                  this._buffer.append('|');
               } else if (c == '\r') {
                  this._buffer.append('<');
               } else {
                  this._buffer.append('?');
               }
            } else {
               this._buffer.append(c);
            }
         }
      }

   }

   private void format(Throwable th) {
      if (th == null) {
         this._buffer.append("null");
      } else {
         this._buffer.append('\n');
         this.format(th.toString());
         StackTraceElement[] elements = th.getStackTrace();

         for(int i = 0; elements != null && i < elements.length; ++i) {
            this._buffer.append("\n\tat ");
            this.format(elements[i].toString());
         }
      }

   }

   public Logger getLogger(String name) {
      return (name != null || this._name != null) && (name == null || !name.equals(this._name)) ? new StdErrLog(name) : this;
   }

   public String toString() {
      return "STDERR" + this._name;
   }

   static {
      try {
         _dateCache = new DateCache("yyyy-MM-dd HH:mm:ss");
      } catch (Exception var1) {
         var1.printStackTrace();
      }

   }
}
