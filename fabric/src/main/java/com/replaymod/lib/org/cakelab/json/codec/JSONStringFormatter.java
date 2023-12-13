package com.replaymod.lib.org.cakelab.json.codec;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public interface JSONStringFormatter extends CharSequence {
   JSONStringFormatter create(JSONStringFormatterConfiguration var1);

   void indentInc();

   void indentDec();

   void appendIndent();

   void appendNewLine();

   Iterator<Entry<String, Object>> iterator(Set<Entry<String, Object>> var1);

   StringBuffer append(String var1);

   StringBuffer append(char var1);

   StringBuffer append(Object var1);

   void appendUnicodeString(String var1);
}
