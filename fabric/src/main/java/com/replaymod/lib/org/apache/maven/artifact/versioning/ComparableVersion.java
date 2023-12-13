package com.replaymod.lib.org.apache.maven.artifact.versioning;

import com.replaymod.lib.org.apache.commons.lang3.StringUtils;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class ComparableVersion implements Comparable<ComparableVersion> {
   private static final int MAX_INTITEM_LENGTH = 9;
   private static final int MAX_LONGITEM_LENGTH = 18;
   private String value;
   private String canonical;
   private ComparableVersion.ListItem items;

   public ComparableVersion(String version) {
      this.parseVersion(version);
   }

   public final void parseVersion(String version) {
      this.value = version;
      this.items = new ComparableVersion.ListItem();
      version = version.toLowerCase(Locale.ENGLISH);
      ComparableVersion.ListItem list = this.items;
      Deque<ComparableVersion.Item> stack = new ArrayDeque();
      stack.push(list);
      boolean isDigit = false;
      int startIndex = 0;

      for(int i = 0; i < version.length(); ++i) {
         char c = version.charAt(i);
         if (c == '.') {
            if (i == startIndex) {
               list.add(ComparableVersion.IntItem.ZERO);
            } else {
               list.add(parseItem(isDigit, version.substring(startIndex, i)));
            }

            startIndex = i + 1;
         } else if (c == '-') {
            if (i == startIndex) {
               list.add(ComparableVersion.IntItem.ZERO);
            } else {
               list.add(parseItem(isDigit, version.substring(startIndex, i)));
            }

            startIndex = i + 1;
            list.add(list = new ComparableVersion.ListItem());
            stack.push(list);
         } else if (Character.isDigit(c)) {
            if (!isDigit && i > startIndex) {
               list.add(new ComparableVersion.StringItem(version.substring(startIndex, i), true));
               startIndex = i;
               list.add(list = new ComparableVersion.ListItem());
               stack.push(list);
            }

            isDigit = true;
         } else {
            if (isDigit && i > startIndex) {
               list.add(parseItem(true, version.substring(startIndex, i)));
               startIndex = i;
               list.add(list = new ComparableVersion.ListItem());
               stack.push(list);
            }

            isDigit = false;
         }
      }

      if (version.length() > startIndex) {
         list.add(parseItem(isDigit, version.substring(startIndex)));
      }

      while(!stack.isEmpty()) {
         list = (ComparableVersion.ListItem)stack.pop();
         list.normalize();
      }

      this.canonical = this.items.toString();
   }

   private static ComparableVersion.Item parseItem(boolean isDigit, String buf) {
      if (isDigit) {
         buf = stripLeadingZeroes(buf);
         if (buf.length() <= 9) {
            return new ComparableVersion.IntItem(buf);
         } else {
            return (ComparableVersion.Item)(buf.length() <= 18 ? new ComparableVersion.LongItem(buf) : new ComparableVersion.BigIntegerItem(buf));
         }
      } else {
         return new ComparableVersion.StringItem(buf, false);
      }
   }

   private static String stripLeadingZeroes(String buf) {
      String strippedBuf = StringUtils.stripStart(buf, "0");
      return strippedBuf.isEmpty() ? "0" : strippedBuf;
   }

   public int compareTo(ComparableVersion o) {
      return this.items.compareTo(o.items);
   }

   public String toString() {
      return this.value;
   }

   public String getCanonical() {
      return this.canonical;
   }

   public boolean equals(Object o) {
      return o instanceof ComparableVersion && this.canonical.equals(((ComparableVersion)o).canonical);
   }

   public int hashCode() {
      return this.canonical.hashCode();
   }

   public static void main(String... args) {
      System.out.println("Display parameters as parsed by Maven (in canonical form) and comparison result:");
      if (args.length != 0) {
         ComparableVersion prev = null;
         int i = 1;
         String[] var3 = args;
         int var4 = args.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String version = var3[var5];
            ComparableVersion c = new ComparableVersion(version);
            if (prev != null) {
               int compare = prev.compareTo(c);
               System.out.println("   " + prev.toString() + ' ' + (compare == 0 ? "==" : (compare < 0 ? "<" : ">")) + ' ' + version);
            }

            System.out.println(i++ + ". " + version + " == " + c.getCanonical());
            prev = c;
         }

      }
   }

   private static class ListItem extends ArrayList<ComparableVersion.Item> implements ComparableVersion.Item {
      private ListItem() {
      }

      public int getType() {
         return 2;
      }

      public boolean isNull() {
         return this.size() == 0;
      }

      void normalize() {
         for(int i = this.size() - 1; i >= 0; --i) {
            ComparableVersion.Item lastItem = (ComparableVersion.Item)this.get(i);
            if (lastItem.isNull()) {
               this.remove(i);
            } else if (!(lastItem instanceof ComparableVersion.ListItem)) {
               break;
            }
         }

      }

      public int compareTo(ComparableVersion.Item item) {
         if (item == null) {
            if (this.size() == 0) {
               return 0;
            } else {
               ComparableVersion.Item first = (ComparableVersion.Item)this.get(0);
               return first.compareTo((ComparableVersion.Item)null);
            }
         } else {
            switch(item.getType()) {
            case 0:
            case 3:
            case 4:
               return -1;
            case 1:
               return 1;
            case 2:
               Iterator<ComparableVersion.Item> left = this.iterator();
               Iterator right = ((ComparableVersion.ListItem)item).iterator();

               int result;
               do {
                  if (!left.hasNext() && !right.hasNext()) {
                     return 0;
                  }

                  ComparableVersion.Item l = left.hasNext() ? (ComparableVersion.Item)left.next() : null;
                  ComparableVersion.Item r = right.hasNext() ? (ComparableVersion.Item)right.next() : null;
                  result = l == null ? (r == null ? 0 : -1 * r.compareTo(l)) : l.compareTo(r);
               } while(result == 0);

               return result;
            default:
               throw new IllegalStateException("invalid item: " + item.getClass());
            }
         }
      }

      public String toString() {
         StringBuilder buffer = new StringBuilder();

         ComparableVersion.Item item;
         for(Iterator var2 = this.iterator(); var2.hasNext(); buffer.append(item)) {
            item = (ComparableVersion.Item)var2.next();
            if (buffer.length() > 0) {
               buffer.append((char)(item instanceof ComparableVersion.ListItem ? '-' : '.'));
            }
         }

         return buffer.toString();
      }

      // $FF: synthetic method
      ListItem(Object x0) {
         this();
      }
   }

   private static class StringItem implements ComparableVersion.Item {
      private static final List<String> QUALIFIERS = Arrays.asList("alpha", "beta", "milestone", "rc", "snapshot", "", "sp");
      private static final Properties ALIASES = new Properties();
      private static final String RELEASE_VERSION_INDEX;
      private final String value;

      StringItem(String value, boolean followedByDigit) {
         if (followedByDigit && value.length() == 1) {
            switch(value.charAt(0)) {
            case 'a':
               value = "alpha";
               break;
            case 'b':
               value = "beta";
               break;
            case 'm':
               value = "milestone";
            }
         }

         this.value = ALIASES.getProperty(value, value);
      }

      public int getType() {
         return 1;
      }

      public boolean isNull() {
         return comparableQualifier(this.value).compareTo(RELEASE_VERSION_INDEX) == 0;
      }

      public static String comparableQualifier(String qualifier) {
         int i = QUALIFIERS.indexOf(qualifier);
         return i == -1 ? QUALIFIERS.size() + "-" + qualifier : String.valueOf(i);
      }

      public int compareTo(ComparableVersion.Item item) {
         if (item == null) {
            return comparableQualifier(this.value).compareTo(RELEASE_VERSION_INDEX);
         } else {
            switch(item.getType()) {
            case 0:
            case 3:
            case 4:
               return -1;
            case 1:
               return comparableQualifier(this.value).compareTo(comparableQualifier(((ComparableVersion.StringItem)item).value));
            case 2:
               return -1;
            default:
               throw new IllegalStateException("invalid item: " + item.getClass());
            }
         }
      }

      public String toString() {
         return this.value;
      }

      static {
         ALIASES.put("ga", "");
         ALIASES.put("final", "");
         ALIASES.put("cr", "rc");
         RELEASE_VERSION_INDEX = String.valueOf(QUALIFIERS.indexOf(""));
      }
   }

   private static class BigIntegerItem implements ComparableVersion.Item {
      private final BigInteger value;

      BigIntegerItem(String str) {
         this.value = new BigInteger(str);
      }

      public int getType() {
         return 0;
      }

      public boolean isNull() {
         return BigInteger.ZERO.equals(this.value);
      }

      public int compareTo(ComparableVersion.Item item) {
         if (item == null) {
            return BigInteger.ZERO.equals(this.value) ? 0 : 1;
         } else {
            switch(item.getType()) {
            case 0:
               return this.value.compareTo(((ComparableVersion.BigIntegerItem)item).value);
            case 1:
               return 1;
            case 2:
               return 1;
            case 3:
            case 4:
               return 1;
            default:
               throw new IllegalStateException("invalid item: " + item.getClass());
            }
         }
      }

      public String toString() {
         return this.value.toString();
      }
   }

   private static class LongItem implements ComparableVersion.Item {
      private final long value;

      LongItem(String str) {
         this.value = Long.parseLong(str);
      }

      public int getType() {
         return 4;
      }

      public boolean isNull() {
         return this.value == 0L;
      }

      public int compareTo(ComparableVersion.Item item) {
         if (item == null) {
            return this.value == 0L ? 0 : 1;
         } else {
            switch(item.getType()) {
            case 0:
               return -1;
            case 1:
               return 1;
            case 2:
               return 1;
            case 3:
               return 1;
            case 4:
               long itemValue = ((ComparableVersion.LongItem)item).value;
               return this.value < itemValue ? -1 : (this.value == itemValue ? 0 : 1);
            default:
               throw new IllegalStateException("invalid item: " + item.getClass());
            }
         }
      }

      public String toString() {
         return Long.toString(this.value);
      }
   }

   private static class IntItem implements ComparableVersion.Item {
      private final int value;
      public static final ComparableVersion.IntItem ZERO = new ComparableVersion.IntItem();

      private IntItem() {
         this.value = 0;
      }

      IntItem(String str) {
         this.value = Integer.parseInt(str);
      }

      public int getType() {
         return 3;
      }

      public boolean isNull() {
         return this.value == 0;
      }

      public int compareTo(ComparableVersion.Item item) {
         if (item == null) {
            return this.value == 0 ? 0 : 1;
         } else {
            switch(item.getType()) {
            case 0:
            case 4:
               return -1;
            case 1:
               return 1;
            case 2:
               return 1;
            case 3:
               int itemValue = ((ComparableVersion.IntItem)item).value;
               return this.value < itemValue ? -1 : (this.value == itemValue ? 0 : 1);
            default:
               throw new IllegalStateException("invalid item: " + item.getClass());
            }
         }
      }

      public String toString() {
         return Integer.toString(this.value);
      }
   }

   private interface Item {
      int INT_ITEM = 3;
      int LONG_ITEM = 4;
      int BIGINTEGER_ITEM = 0;
      int STRING_ITEM = 1;
      int LIST_ITEM = 2;

      int compareTo(ComparableVersion.Item var1);

      int getType();

      boolean isNull();
   }
}
