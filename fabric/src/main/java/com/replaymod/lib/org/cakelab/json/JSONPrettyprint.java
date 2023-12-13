package com.replaymod.lib.org.cakelab.json;

import com.replaymod.lib.org.cakelab.json.codec.JSONStringFormatter;
import com.replaymod.lib.org.cakelab.json.codec.JSONStringFormatterConfiguration;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class JSONPrettyprint implements JSONStringFormatter {
   public static final int NON_UNICODE_VALUES = 1;
   public static final int SORT_MEMBERS = 2;
   private JSONStringFormatterConfiguration cfg;
   private boolean active;
   private int indent;
   private StringBuffer sb;
   private String indentStr;
   private String currentIndentStr;

   public JSONPrettyprint(JSONStringFormatterConfiguration format) {
      this();
      this.active = format.indenting || format.sortMembers || format.unicodeValues;
      this.cfg = format;
   }

   public JSONPrettyprint() {
      this.sb = new StringBuffer();
      this.indentStr = "  ";
      this.currentIndentStr = "";
      this.deactivate();
      this.cfg = new JSONStringFormatterConfiguration();
   }

   /** @deprecated */
   public JSONPrettyprint(boolean active, int flags) {
      this();
      if (active) {
         this.activate();
      }

      if ((flags & 1) > 0) {
         this.cfg.unicodeValues = false;
      }

      if ((flags & 2) > 0) {
         this.cfg.sortMembers = true;
      }

   }

   public JSONPrettyprint(boolean active) {
      this(active, 0);
   }

   public JSONPrettyprint(JSONPrettyprint formatter) {
      this();
      this.active = formatter.active;
      this.cfg = formatter.cfg;
   }

   public boolean isUnicodeValues() {
      return this.cfg.unicodeValues;
   }

   public boolean isSortMembers() {
      return this.cfg.sortMembers;
   }

   public boolean isActive() {
      return this.active;
   }

   public void activate() {
      this.active = true;
      this.indent = 0;
   }

   public void deactivate() {
      this.active = false;
   }

   public void indentInc() {
      ++this.indent;
      this.currentIndentStr = this.currentIndentStr + this.indentStr;
   }

   public void indentDec() {
      --this.indent;
      this.currentIndentStr = "";

      for(int i = 0; i < this.indent; ++i) {
         this.currentIndentStr = this.currentIndentStr + this.indentStr;
      }

   }

   public void appendIndent() {
      if (this.active) {
         this.sb.append(this.currentIndentStr);
      }

   }

   public void appendNewLine() {
      if (this.active) {
         this.sb.append("\n");
      }

   }

   public int hashCode() {
      return this.sb.hashCode();
   }

   public boolean equals(Object obj) {
      return this.sb.equals(obj);
   }

   public int length() {
      return this.sb.length();
   }

   public int capacity() {
      return this.sb.capacity();
   }

   public void ensureCapacity(int minimumCapacity) {
      this.sb.ensureCapacity(minimumCapacity);
   }

   public void trimToSize() {
      this.sb.trimToSize();
   }

   public void setLength(int newLength) {
      this.sb.setLength(newLength);
   }

   public char charAt(int index) {
      return this.sb.charAt(index);
   }

   public int codePointAt(int index) {
      return this.sb.codePointAt(index);
   }

   public int codePointBefore(int index) {
      return this.sb.codePointBefore(index);
   }

   public int codePointCount(int beginIndex, int endIndex) {
      return this.sb.codePointCount(beginIndex, endIndex);
   }

   public int offsetByCodePoints(int index, int codePointOffset) {
      return this.sb.offsetByCodePoints(index, codePointOffset);
   }

   public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
      this.sb.getChars(srcBegin, srcEnd, dst, dstBegin);
   }

   public void setCharAt(int index, char ch) {
      this.sb.setCharAt(index, ch);
   }

   public StringBuffer append(Object obj) {
      return this.sb.append(obj);
   }

   public StringBuffer append(String str) {
      return this.sb.append(str);
   }

   public StringBuffer append(StringBuffer sb) {
      return sb.append(sb);
   }

   public StringBuffer append(CharSequence s) {
      return this.sb.append(s);
   }

   public StringBuffer append(CharSequence s, int start, int end) {
      return this.sb.append(s, start, end);
   }

   public StringBuffer append(char[] str) {
      return this.sb.append(str);
   }

   public StringBuffer append(char[] str, int offset, int len) {
      return this.sb.append(str, offset, len);
   }

   public StringBuffer append(boolean b) {
      return this.sb.append(b);
   }

   public StringBuffer append(char c) {
      return this.sb.append(c);
   }

   public StringBuffer append(int i) {
      return this.sb.append(i);
   }

   public StringBuffer appendCodePoint(int codePoint) {
      return this.sb.appendCodePoint(codePoint);
   }

   public StringBuffer append(long lng) {
      return this.sb.append(lng);
   }

   public StringBuffer append(float f) {
      return this.sb.append(f);
   }

   public StringBuffer append(double d) {
      return this.sb.append(d);
   }

   public StringBuffer delete(int start, int end) {
      return this.sb.delete(start, end);
   }

   public StringBuffer deleteCharAt(int index) {
      return this.sb.deleteCharAt(index);
   }

   public StringBuffer replace(int start, int end, String str) {
      return this.sb.replace(start, end, str);
   }

   public String substring(int start) {
      return this.sb.substring(start);
   }

   public CharSequence subSequence(int start, int end) {
      return this.sb.subSequence(start, end);
   }

   public String substring(int start, int end) {
      return this.sb.substring(start, end);
   }

   public StringBuffer insert(int index, char[] str, int offset, int len) {
      return this.sb.insert(index, str, offset, len);
   }

   public StringBuffer insert(int offset, Object obj) {
      return this.sb.insert(offset, obj);
   }

   public StringBuffer insert(int offset, String str) {
      return this.sb.insert(offset, str);
   }

   public StringBuffer insert(int offset, char[] str) {
      return this.sb.insert(offset, str);
   }

   public StringBuffer insert(int dstOffset, CharSequence s) {
      return this.sb.insert(dstOffset, s);
   }

   public StringBuffer insert(int dstOffset, CharSequence s, int start, int end) {
      return this.sb.insert(dstOffset, s, start, end);
   }

   public StringBuffer insert(int offset, boolean b) {
      return this.sb.insert(offset, b);
   }

   public StringBuffer insert(int offset, char c) {
      return this.sb.insert(offset, c);
   }

   public StringBuffer insert(int offset, int i) {
      return this.sb.insert(offset, i);
   }

   public StringBuffer insert(int offset, long l) {
      return this.sb.insert(offset, l);
   }

   public StringBuffer insert(int offset, float f) {
      return this.sb.insert(offset, f);
   }

   public StringBuffer insert(int offset, double d) {
      return this.sb.insert(offset, d);
   }

   public int indexOf(String str) {
      return this.sb.indexOf(str);
   }

   public int indexOf(String str, int fromIndex) {
      return this.sb.indexOf(str, fromIndex);
   }

   public int lastIndexOf(String str) {
      return this.sb.lastIndexOf(str);
   }

   public int lastIndexOf(String str, int fromIndex) {
      return this.sb.lastIndexOf(str, fromIndex);
   }

   public StringBuffer reverse() {
      return this.sb.reverse();
   }

   public String toString() {
      return this.sb.toString();
   }

   public Iterator<Entry<String, Object>> iterator(Set<Entry<String, Object>> entrySet) {
      if (this.cfg.sortMembers) {
         ArrayList<Entry<String, Object>> entries = new ArrayList(entrySet);
         Collections.sort(entries, new Comparator<Entry<String, Object>>() {
            public int compare(Entry<String, Object> o1, Entry<String, Object> o2) {
               return String.CASE_INSENSITIVE_ORDER.compare(o1.getKey(), o2.getKey());
            }
         });
         return entries.iterator();
      } else {
         return entrySet.iterator();
      }
   }

   public void appendUnicodeString(String o) {
      StringReader reader = new StringReader(o.toString());

      try {
         int read;
         while((read = reader.read()) > 0) {
            if (Character.isSupplementaryCodePoint(read)) {
               throw new Error("Supplimentary code points (extended unicode) are not supported by JSON");
            }

            this.appendUnicodeCharacter((char)read);
         }

      } catch (Throwable var5) {
         throw new Error(var5);
      }
   }

   protected void appendUnicodeCharacter(char c) {
      switch(c) {
      case '\b':
         this.append("\\b");
         break;
      case '\t':
         this.append("\\t");
         break;
      case '\n':
         this.append("\\n");
         break;
      case '\f':
         this.append("\\f");
         break;
      case '\r':
         this.append("\\r");
         break;
      case '"':
         this.append("\\\"");
         break;
      case '\\':
         this.append("\\\\");
         break;
      default:
         if (this.cfg.unicodeValues && isNonAscii(c)) {
            this.append("\\u");
            String s = Integer.toHexString(c);

            for(int i = s.length(); i < 4; ++i) {
               this.append('0');
            }

            this.append(s);
         } else {
            this.append(c);
         }
      }

   }

   private static boolean isNonAscii(char c) {
      return c > 127;
   }

   public JSONStringFormatter create(JSONStringFormatterConfiguration config) {
      return new JSONPrettyprint(config);
   }
}
