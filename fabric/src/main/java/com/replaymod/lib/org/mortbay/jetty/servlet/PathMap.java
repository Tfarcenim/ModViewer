package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.SingletonList;
import com.replaymod.lib.org.mortbay.util.StringMap;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class PathMap extends HashMap implements Externalizable {
   private static String __pathSpecSeparators = System.getProperty("com.replaymod.lib.org.mortbay.http.PathMap.separators", ":,");
   StringMap _prefixMap = new StringMap();
   StringMap _suffixMap = new StringMap();
   StringMap _exactMap = new StringMap();
   List _defaultSingletonList = null;
   PathMap.Entry _prefixDefault = null;
   PathMap.Entry _default = null;
   Set _entrySet;
   boolean _nodefault = false;

   public static void setPathSpecSeparators(String s) {
      __pathSpecSeparators = s;
   }

   public PathMap() {
      super(11);
      this._entrySet = this.entrySet();
   }

   public PathMap(boolean nodefault) {
      super(11);
      this._entrySet = this.entrySet();
      this._nodefault = nodefault;
   }

   public PathMap(int capacity) {
      super(capacity);
      this._entrySet = this.entrySet();
   }

   public PathMap(Map m) {
      this.putAll(m);
      this._entrySet = this.entrySet();
   }

   public void writeExternal(ObjectOutput out) throws IOException {
      HashMap map = new HashMap(this);
      out.writeObject(map);
   }

   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      HashMap map = (HashMap)in.readObject();
      this.putAll(map);
   }

   public synchronized Object put(Object pathSpec, Object object) {
      StringTokenizer tok = new StringTokenizer(pathSpec.toString(), __pathSpecSeparators);
      Object old = null;

      while(tok.hasMoreTokens()) {
         String spec = tok.nextToken();
         if (!spec.startsWith("/") && !spec.startsWith("*.")) {
            throw new IllegalArgumentException("PathSpec " + spec + ". must start with '/' or '*.'");
         }

         old = super.put(spec, object);
         PathMap.Entry entry = new PathMap.Entry(spec, object);
         if (entry.getKey().equals(spec)) {
            if (spec.equals("/*")) {
               this._prefixDefault = entry;
            } else if (spec.endsWith("/*")) {
               String mapped = spec.substring(0, spec.length() - 2);
               entry.setMapped(mapped);
               this._prefixMap.put((String)mapped, entry);
               this._exactMap.put((String)mapped, entry);
               this._exactMap.put((String)spec.substring(0, spec.length() - 1), entry);
            } else if (spec.startsWith("*.")) {
               this._suffixMap.put((String)spec.substring(2), entry);
            } else if (spec.equals("/")) {
               if (this._nodefault) {
                  this._exactMap.put((String)spec, entry);
               } else {
                  this._default = entry;
                  this._defaultSingletonList = SingletonList.newSingletonList(this._default);
               }
            } else {
               entry.setMapped(spec);
               this._exactMap.put((String)spec, entry);
            }
         }
      }

      return old;
   }

   public Object match(String path) {
      java.util.Map.Entry entry = this.getMatch(path);
      return entry != null ? entry.getValue() : null;
   }

   public PathMap.Entry getMatch(String path) {
      if (path == null) {
         return null;
      } else {
         int l = path.length();
         java.util.Map.Entry entry = this._exactMap.getEntry((String)path, 0, l);
         if (entry != null) {
            return (PathMap.Entry)entry.getValue();
         } else {
            int i = l;

            do {
               if ((i = path.lastIndexOf(47, i - 1)) < 0) {
                  if (this._prefixDefault != null) {
                     return this._prefixDefault;
                  }

                  i = 0;

                  do {
                     if ((i = path.indexOf(46, i + 1)) <= 0) {
                        return this._default;
                     }

                     entry = this._suffixMap.getEntry(path, i + 1, l - i - 1);
                  } while(entry == null);

                  return (PathMap.Entry)entry.getValue();
               }

               entry = this._prefixMap.getEntry((String)path, 0, i);
            } while(entry == null);

            return (PathMap.Entry)entry.getValue();
         }
      }
   }

   public Object getLazyMatches(String path) {
      Object entries = null;
      if (path == null) {
         return LazyList.getList(entries);
      } else {
         int l = path.length();
         java.util.Map.Entry entry = this._exactMap.getEntry((String)path, 0, l);
         if (entry != null) {
            entries = LazyList.add(entries, entry.getValue());
         }

         int i = l - 1;

         while((i = path.lastIndexOf(47, i - 1)) >= 0) {
            entry = this._prefixMap.getEntry((String)path, 0, i);
            if (entry != null) {
               entries = LazyList.add(entries, entry.getValue());
            }
         }

         if (this._prefixDefault != null) {
            entries = LazyList.add(entries, this._prefixDefault);
         }

         i = 0;

         while((i = path.indexOf(46, i + 1)) > 0) {
            entry = this._suffixMap.getEntry(path, i + 1, l - i - 1);
            if (entry != null) {
               entries = LazyList.add(entries, entry.getValue());
            }
         }

         if (this._default != null) {
            if (entries == null) {
               return this._defaultSingletonList;
            }

            entries = LazyList.add(entries, this._default);
         }

         return entries;
      }
   }

   public List getMatches(String path) {
      return LazyList.getList(this.getLazyMatches(path));
   }

   public boolean containsMatch(String path) {
      PathMap.Entry match = this.getMatch(path);
      return match != null && !match.equals(this._default);
   }

   public synchronized Object remove(Object pathSpec) {
      if (pathSpec != null) {
         String spec = (String)pathSpec;
         if (spec.equals("/*")) {
            this._prefixDefault = null;
         } else if (spec.endsWith("/*")) {
            this._prefixMap.remove(spec.substring(0, spec.length() - 2));
            this._exactMap.remove(spec.substring(0, spec.length() - 1));
            this._exactMap.remove(spec.substring(0, spec.length() - 2));
         } else if (spec.startsWith("*.")) {
            this._suffixMap.remove(spec.substring(2));
         } else if (spec.equals("/")) {
            this._default = null;
            this._defaultSingletonList = null;
         } else {
            this._exactMap.remove(spec);
         }
      }

      return super.remove(pathSpec);
   }

   public void clear() {
      this._exactMap = new StringMap();
      this._prefixMap = new StringMap();
      this._suffixMap = new StringMap();
      this._default = null;
      this._defaultSingletonList = null;
      super.clear();
   }

   public static boolean match(String pathSpec, String path) throws IllegalArgumentException {
      return match(pathSpec, path, false);
   }

   public static boolean match(String pathSpec, String path, boolean noDefault) throws IllegalArgumentException {
      char c = pathSpec.charAt(0);
      if (c == '/') {
         if (!noDefault && pathSpec.length() == 1 || pathSpec.equals(path)) {
            return true;
         }

         if (isPathWildcardMatch(pathSpec, path)) {
            return true;
         }
      } else if (c == '*') {
         return path.regionMatches(path.length() - pathSpec.length() + 1, pathSpec, 1, pathSpec.length() - 1);
      }

      return false;
   }

   private static boolean isPathWildcardMatch(String pathSpec, String path) {
      int cpl = pathSpec.length() - 2;
      return pathSpec.endsWith("/*") && path.regionMatches(0, pathSpec, 0, cpl) && (path.length() == cpl || '/' == path.charAt(cpl));
   }

   public static String pathMatch(String pathSpec, String path) {
      char c = pathSpec.charAt(0);
      if (c == '/') {
         if (pathSpec.length() == 1) {
            return path;
         }

         if (pathSpec.equals(path)) {
            return path;
         }

         if (isPathWildcardMatch(pathSpec, path)) {
            return path.substring(0, pathSpec.length() - 2);
         }
      } else if (c == '*' && path.regionMatches(path.length() - (pathSpec.length() - 1), pathSpec, 1, pathSpec.length() - 1)) {
         return path;
      }

      return null;
   }

   public static String pathInfo(String pathSpec, String path) {
      char c = pathSpec.charAt(0);
      if (c == '/') {
         if (pathSpec.length() == 1) {
            return null;
         }

         boolean wildcard = isPathWildcardMatch(pathSpec, path);
         if (pathSpec.equals(path) && !wildcard) {
            return null;
         }

         if (wildcard) {
            if (path.length() == pathSpec.length() - 2) {
               return null;
            }

            return path.substring(pathSpec.length() - 2);
         }
      }

      return null;
   }

   public static String relativePath(String base, String pathSpec, String path) {
      String info = pathInfo(pathSpec, path);
      if (info == null) {
         info = path;
      }

      if (info.startsWith("./")) {
         info = info.substring(2);
      }

      if (base.endsWith("/")) {
         if (info.startsWith("/")) {
            path = base + info.substring(1);
         } else {
            path = base + info;
         }
      } else if (info.startsWith("/")) {
         path = base + info;
      } else {
         path = base + "/" + info;
      }

      return path;
   }

   public static class Entry implements java.util.Map.Entry {
      private Object key;
      private Object value;
      private String mapped;
      private transient String string;

      Entry(Object key, Object value) {
         this.key = key;
         this.value = value;
      }

      public Object getKey() {
         return this.key;
      }

      public Object getValue() {
         return this.value;
      }

      public Object setValue(Object o) {
         throw new UnsupportedOperationException();
      }

      public String toString() {
         if (this.string == null) {
            this.string = this.key + "=" + this.value;
         }

         return this.string;
      }

      public String getMapped() {
         return this.mapped;
      }

      void setMapped(String mapped) {
         this.mapped = mapped;
      }
   }
}
