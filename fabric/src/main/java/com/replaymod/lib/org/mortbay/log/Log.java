package com.replaymod.lib.org.mortbay.log;

import com.replaymod.lib.org.mortbay.util.Loader;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Log {
   private static final String[] __nestedEx = new String[]{"getTargetException", "getTargetError", "getException", "getRootCause"};
   private static final Class[] __noArgs = new Class[0];
   public static final String EXCEPTION = "EXCEPTION ";
   public static final String IGNORED = "IGNORED";
   public static final String IGNORED_FMT = "IGNORED: {}";
   public static final String NOT_IMPLEMENTED = "NOT IMPLEMENTED ";
   public static String __logClass;
   public static boolean __verbose;
   public static boolean __ignored;
   private static Logger __log;

   public static void setLog(Logger log) {
      __log = log;
   }

   public static Logger getLog() {
      return __log;
   }

   public static void debug(Throwable th) {
      if (__log != null && isDebugEnabled()) {
         __log.debug("EXCEPTION ", th);
         unwind(th);
      }
   }

   public static void debug(String msg) {
      if (__log != null) {
         __log.debug(msg, (Object)null, (Object)null);
      }
   }

   public static void debug(String msg, Object arg) {
      if (__log != null) {
         __log.debug(msg, arg, (Object)null);
      }
   }

   public static void debug(String msg, Object arg0, Object arg1) {
      if (__log != null) {
         __log.debug(msg, arg0, arg1);
      }
   }

   public static void ignore(Throwable th) {
      if (__log != null) {
         if (__ignored) {
            __log.warn("IGNORED", th);
            unwind(th);
         } else if (__verbose) {
            __log.debug("IGNORED", th);
            unwind(th);
         }

      }
   }

   public static void info(String msg) {
      if (__log != null) {
         __log.info(msg, (Object)null, (Object)null);
      }
   }

   public static void info(String msg, Object arg) {
      if (__log != null) {
         __log.info(msg, arg, (Object)null);
      }
   }

   public static void info(String msg, Object arg0, Object arg1) {
      if (__log != null) {
         __log.info(msg, arg0, arg1);
      }
   }

   public static boolean isDebugEnabled() {
      return __log == null ? false : __log.isDebugEnabled();
   }

   public static void warn(String msg) {
      if (__log != null) {
         __log.warn(msg, (Object)null, (Object)null);
      }
   }

   public static void warn(String msg, Object arg) {
      if (__log != null) {
         __log.warn(msg, arg, (Object)null);
      }
   }

   public static void warn(String msg, Object arg0, Object arg1) {
      if (__log != null) {
         __log.warn(msg, arg0, arg1);
      }
   }

   public static void warn(String msg, Throwable th) {
      if (__log != null) {
         __log.warn(msg, th);
         unwind(th);
      }
   }

   public static void warn(Throwable th) {
      if (__log != null) {
         __log.warn("EXCEPTION ", th);
         unwind(th);
      }
   }

   public static Logger getLogger(String name) {
      if (__log == null) {
         return __log;
      } else {
         return name == null ? __log : __log.getLogger(name);
      }
   }

   private static void unwind(Throwable th) {
      if (th != null) {
         for(int i = 0; i < __nestedEx.length; ++i) {
            try {
               Method get_target = th.getClass().getMethod(__nestedEx[i], __noArgs);
               Throwable th2 = (Throwable)get_target.invoke(th, (Object[])null);
               if (th2 != null && th2 != th) {
                  warn("Nested in " + th + ":", th2);
               }
            } catch (Exception var4) {
            }
         }

      }
   }

   static {
      AccessController.doPrivileged(new PrivilegedAction() {
         public Object run() {
            Log.__logClass = System.getProperty("com.replaymod.lib.org.mortbay.log.class", "com.replaymod.lib.org.mortbay.log.Slf4jLog");
            Log.__verbose = System.getProperty("VERBOSE", (String)null) != null;
            Log.__ignored = System.getProperty("IGNORED", (String)null) != null;
            return new Boolean(true);
         }
      });
      Class log_class = null;

      try {
         log_class = Loader.loadClass(Log.class, __logClass);
         __log = (Logger)log_class.newInstance();
      } catch (Throwable var2) {
         log_class = StdErrLog.class;
         __log = new StdErrLog();
         __logClass = log_class.getName();
         if (__verbose) {
            var2.printStackTrace();
         }
      }

      __log.info("Logging to {} via {}", __log, log_class.getName());
   }
}
