package com.replaymod.lib.org.mortbay.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AttributesMap implements Attributes {
   Map _map;

   public AttributesMap() {
      this._map = new HashMap();
   }

   public AttributesMap(Map map) {
      this._map = map;
   }

   public void removeAttribute(String name) {
      this._map.remove(name);
   }

   public void setAttribute(String name, Object attribute) {
      if (attribute == null) {
         this._map.remove(name);
      } else {
         this._map.put(name, attribute);
      }

   }

   public Object getAttribute(String name) {
      return this._map.get(name);
   }

   public Enumeration getAttributeNames() {
      return Collections.enumeration(this._map.keySet());
   }

   public static Enumeration getAttributeNamesCopy(Attributes attrs) {
      if (attrs instanceof AttributesMap) {
         return Collections.enumeration(((AttributesMap)attrs)._map.keySet());
      } else {
         ArrayList names = new ArrayList();
         Enumeration e = attrs.getAttributeNames();

         while(e.hasMoreElements()) {
            names.add(e.nextElement());
         }

         return Collections.enumeration(names);
      }
   }

   public void clearAttributes() {
      this._map.clear();
   }

   public String toString() {
      return this._map.toString();
   }
}
