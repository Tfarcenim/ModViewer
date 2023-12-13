package com.replaymod.lib.org.cakelab.json;

import com.replaymod.lib.org.cakelab.json.codec.JSONCodec;
import com.replaymod.lib.org.cakelab.json.codec.JSONStringFormatter;
import java.util.ArrayList;

public class JSONArray extends ArrayList<Object> {
   private static final long serialVersionUID = 1L;

   public String toString() {
      return this.toString(JSONCodec.getDefaultStringFormatter());
   }

   public String toString(JSONStringFormatter s) {
      s.append("[");
      if (!this.isEmpty()) {
         s.appendNewLine();
         s.indentInc();
         int i = 0;
         s.appendIndent();
         JSONObject.appendValue(s, this.get(i));

         for(int i = 1; i < this.size(); ++i) {
            s.append(", ");
            s.appendNewLine();
            s.appendIndent();
            JSONObject.appendValue(s, this.get(i));
         }

         s.appendNewLine();
         s.indentDec();
         s.appendIndent();
      }

      s.append("]");
      return s.toString();
   }

   public double getDouble(int index) {
      return JSONObject.doublevalue(this.get(index));
   }

   public long getLong(int index) {
      return JSONObject.longvalue(this.get(index));
   }
}
