package com.replaymod.lib.org.cakelab.json;

import com.replaymod.lib.org.cakelab.json.codec.JSONCodec;
import com.replaymod.lib.org.cakelab.json.codec.JSONStringFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class JSONObject extends HashMap<String, Object> implements JSONCompoundType {
   private static final long serialVersionUID = 1L;

   public static void appendValue(JSONStringFormatter s, Object o) {
      if (o == null) {
         s.append("null");
      } else if (o instanceof String) {
         s.append('"');
         s.appendUnicodeString((String)o);
         s.append('"');
      } else if (o instanceof JSONArray) {
         ((JSONArray)o).toString(s);
      } else if (o instanceof JSONObject) {
         ((JSONObject)o).toString(s);
      } else {
         s.append(o);
      }

   }

   public String toString() {
      return this.toString(JSONCodec.getDefaultStringFormatter());
   }

   public String toString(JSONStringFormatter s) {
      s.append("{");
      s.indentInc();
      s.appendNewLine();
      Iterator<Entry<String, Object>> it = s.iterator(this.entrySet());
      if (it.hasNext()) {
         s.appendIndent();
         Entry<String, Object> e = (Entry)it.next();
         s.append('"');
         s.append((String)e.getKey());
         s.append("\": ");
         appendValue(s, e.getValue());

         while(it.hasNext()) {
            e = (Entry)it.next();
            s.append(", ");
            s.appendNewLine();
            s.appendIndent();
            s.append('"');
            s.append((String)e.getKey());
            s.append("\": ");
            appendValue(s, e.getValue());
         }

         s.appendNewLine();
      }

      s.indentDec();
      s.appendIndent();
      s.append("}");
      return s.toString();
   }

   public double getDouble(String key) {
      Object o = this.get(key);
      return doublevalue(o);
   }

   public long getLong(String key) {
      Object o = this.get(key);
      return longvalue(o);
   }

   static double doublevalue(Object o) {
      return o instanceof Long ? (double)(Long)o : (Double)o;
   }

   static long longvalue(Object o) {
      return o instanceof Long ? (Long)o : ((Double)o).longValue();
   }

   public String getString(String key) {
      return (String)this.get(key);
   }
}
