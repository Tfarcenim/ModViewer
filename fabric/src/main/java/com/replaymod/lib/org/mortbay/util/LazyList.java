package com.replaymod.lib.org.mortbay.util;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LazyList implements Cloneable, Serializable {
   private static final String[] __EMTPY_STRING_ARRAY = new String[0];

   private LazyList() {
   }

   public static Object add(Object list, Object item) {
      ArrayList l;
      if (list == null) {
         if (!(item instanceof List) && item != null) {
            return item;
         } else {
            l = new ArrayList();
            l.add(item);
            return l;
         }
      } else if (list instanceof List) {
         ((List)list).add(item);
         return list;
      } else {
         l = new ArrayList();
         l.add(list);
         l.add(item);
         return l;
      }
   }

   public static Object add(Object list, int index, Object item) {
      ArrayList l;
      if (list == null) {
         if (index <= 0 && !(item instanceof List) && item != null) {
            return item;
         } else {
            l = new ArrayList();
            l.add(index, item);
            return l;
         }
      } else if (list instanceof List) {
         ((List)list).add(index, item);
         return list;
      } else {
         l = new ArrayList();
         l.add(list);
         l.add(index, item);
         return l;
      }
   }

   public static Object addCollection(Object list, Collection collection) {
      for(Iterator i = collection.iterator(); i.hasNext(); list = add(list, i.next())) {
      }

      return list;
   }

   public static Object addArray(Object list, Object[] array) {
      for(int i = 0; array != null && i < array.length; ++i) {
         list = add(list, array[i]);
      }

      return list;
   }

   public static Object ensureSize(Object list, int initialSize) {
      if (list == null) {
         return new ArrayList(initialSize);
      } else {
         ArrayList ol;
         if (list instanceof ArrayList) {
            ol = (ArrayList)list;
            if (ol.size() > initialSize) {
               return ol;
            } else {
               ArrayList nl = new ArrayList(initialSize);
               nl.addAll(ol);
               return nl;
            }
         } else {
            ol = new ArrayList(initialSize);
            ol.add(list);
            return ol;
         }
      }
   }

   public static Object remove(Object list, Object o) {
      if (list == null) {
         return null;
      } else if (list instanceof List) {
         List l = (List)list;
         l.remove(o);
         return l.size() == 0 ? null : list;
      } else {
         return list.equals(o) ? null : list;
      }
   }

   public static Object remove(Object list, int i) {
      if (list == null) {
         return null;
      } else if (list instanceof List) {
         List l = (List)list;
         l.remove(i);
         return l.size() == 0 ? null : list;
      } else {
         return i == 0 ? null : list;
      }
   }

   public static List getList(Object list) {
      return getList(list, false);
   }

   public static List getList(Object list, boolean nullForEmpty) {
      if (list == null) {
         return nullForEmpty ? null : Collections.EMPTY_LIST;
      } else if (list instanceof List) {
         return (List)list;
      } else {
         List l = new ArrayList(1);
         l.add(list);
         return l;
      }
   }

   public static String[] toStringArray(Object list) {
      if (list == null) {
         return __EMTPY_STRING_ARRAY;
      } else if (list instanceof List) {
         List l = (List)list;
         String[] a = new String[l.size()];
         int i = l.size();

         while(i-- > 0) {
            Object o = l.get(i);
            if (o != null) {
               a[i] = o.toString();
            }
         }

         return a;
      } else {
         return new String[]{list.toString()};
      }
   }

   public static Object toArray(Object list, Class aClass) {
      if (list == null) {
         return (Object[])((Object[])Array.newInstance(aClass, 0));
      } else if (!(list instanceof List)) {
         Object a = Array.newInstance(aClass, 1);
         Array.set(a, 0, list);
         return a;
      } else {
         List l = (List)list;
         if (!aClass.isPrimitive()) {
            return l.toArray((Object[])((Object[])Array.newInstance(aClass, l.size())));
         } else {
            Object a = Array.newInstance(aClass, l.size());

            for(int i = 0; i < l.size(); ++i) {
               Array.set(a, i, l.get(i));
            }

            return a;
         }
      }
   }

   public static int size(Object list) {
      if (list == null) {
         return 0;
      } else {
         return list instanceof List ? ((List)list).size() : 1;
      }
   }

   public static Object get(Object list, int i) {
      if (list == null) {
         throw new IndexOutOfBoundsException();
      } else if (list instanceof List) {
         return ((List)list).get(i);
      } else if (i == 0) {
         return list;
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public static boolean contains(Object list, Object item) {
      if (list == null) {
         return false;
      } else {
         return list instanceof List ? ((List)list).contains(item) : list.equals(item);
      }
   }

   public static Object clone(Object list) {
      if (list == null) {
         return null;
      } else {
         return list instanceof List ? new ArrayList((List)list) : list;
      }
   }

   public static String toString(Object list) {
      if (list == null) {
         return "[]";
      } else {
         return list instanceof List ? ((List)list).toString() : "[" + list + "]";
      }
   }

   public static Iterator iterator(Object list) {
      if (list == null) {
         return Collections.EMPTY_LIST.iterator();
      } else {
         return list instanceof List ? ((List)list).iterator() : getList(list).iterator();
      }
   }

   public static ListIterator listIterator(Object list) {
      if (list == null) {
         return Collections.EMPTY_LIST.listIterator();
      } else {
         return list instanceof List ? ((List)list).listIterator() : getList(list).listIterator();
      }
   }

   public static List array2List(Object[] array) {
      return array != null && array.length != 0 ? new ArrayList(Arrays.asList(array)) : new ArrayList();
   }

   public static Object[] addToArray(Object[] array, Object item, Class type) {
      if (array == null) {
         if (type == null && item != null) {
            type = item.getClass();
         }

         Object[] na = (Object[])((Object[])Array.newInstance(type, 1));
         na[0] = item;
         return na;
      } else {
         Class c = array.getClass().getComponentType();
         Object[] na = (Object[])((Object[])Array.newInstance(c, Array.getLength(array) + 1));
         System.arraycopy(array, 0, na, 0, array.length);
         na[array.length] = item;
         return na;
      }
   }

   public static Object[] removeFromArray(Object[] array, Object item) {
      if (item != null && array != null) {
         int i = array.length;

         do {
            if (i-- <= 0) {
               return array;
            }
         } while(!item.equals(array[i]));

         Class c = array == null ? item.getClass() : array.getClass().getComponentType();
         Object[] na = (Object[])((Object[])Array.newInstance(c, Array.getLength(array) - 1));
         if (i > 0) {
            System.arraycopy(array, 0, na, 0, i);
         }

         if (i + 1 < array.length) {
            System.arraycopy(array, i + 1, na, i, array.length - (i + 1));
         }

         return na;
      } else {
         return array;
      }
   }
}
