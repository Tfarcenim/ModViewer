package com.replaymod.lib.org.mortbay.util;

import java.util.Enumeration;

public interface Attributes {
   void removeAttribute(String var1);

   void setAttribute(String var1, Object var2);

   Object getAttribute(String var1);

   Enumeration getAttributeNames();

   void clearAttributes();
}
