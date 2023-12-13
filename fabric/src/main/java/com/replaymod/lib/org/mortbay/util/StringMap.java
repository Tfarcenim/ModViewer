package com.replaymod.lib.org.mortbay.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

public class StringMap extends AbstractMap implements Externalizable {
   public static final boolean CASE_INSENSTIVE = true;
   protected static final int __HASH_WIDTH = 17;
   protected int _width;
   protected StringMap.Node _root;
   protected boolean _ignoreCase;
   protected StringMap.NullEntry _nullEntry;
   protected Object _nullValue;
   protected HashSet _entrySet;
   protected Set _umEntrySet;

   public StringMap() {
      this._width = 17;
      this._root = new StringMap.Node();
      this._ignoreCase = false;
      this._nullEntry = null;
      this._nullValue = null;
      this._entrySet = new HashSet(3);
      this._umEntrySet = Collections.unmodifiableSet(this._entrySet);
   }

   public StringMap(boolean ignoreCase) {
      this();
      this._ignoreCase = ignoreCase;
   }

   public StringMap(boolean ignoreCase, int width) {
      this();
      this._ignoreCase = ignoreCase;
      this._width = width;
   }

   public void setIgnoreCase(boolean ic) {
      if (this._root._children != null) {
         throw new IllegalStateException("Must be set before first put");
      } else {
         this._ignoreCase = ic;
      }
   }

   public boolean isIgnoreCase() {
      return this._ignoreCase;
   }

   public void setWidth(int width) {
      this._width = width;
   }

   public int getWidth() {
      return this._width;
   }

   public Object put(Object key, Object value) {
      return key == null ? this.put((String)null, value) : this.put(key.toString(), value);
   }

   public Object put(String key, Object value) {
      if (key == null) {
         Object oldValue = this._nullValue;
         this._nullValue = value;
         if (this._nullEntry == null) {
            this._nullEntry = new StringMap.NullEntry();
            this._entrySet.add(this._nullEntry);
         }

         return oldValue;
      } else {
         StringMap.Node node = this._root;
         int ni = -1;
         StringMap.Node prev = null;
         StringMap.Node parent = null;

         label89:
         for(int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (ni == -1) {
               parent = node;
               prev = null;
               ni = 0;
               node = node._children == null ? null : node._children[c % this._width];
            }

            while(node != null) {
               if (node._char[ni] != c && (!this._ignoreCase || node._ochar[ni] != c)) {
                  if (ni == 0) {
                     prev = node;
                     node = node._next;
                     continue;
                  }

                  node.split(this, ni);
                  --i;
                  ni = -1;
                  continue label89;
               }

               prev = null;
               ++ni;
               if (ni == node._char.length) {
                  ni = -1;
               }
               continue label89;
            }

            node = new StringMap.Node(this._ignoreCase, key, i);
            if (prev != null) {
               prev._next = node;
            } else if (parent != null) {
               if (parent._children == null) {
                  parent._children = new StringMap.Node[this._width];
               }

               parent._children[c % this._width] = node;
               int oi = node._ochar[0] % this._width;
               if (node._ochar != null && node._char[0] % this._width != oi) {
                  if (parent._children[oi] == null) {
                     parent._children[oi] = node;
                  } else {
                     StringMap.Node n;
                     for(n = parent._children[oi]; n._next != null; n = n._next) {
                     }

                     n._next = node;
                  }
               }
            } else {
               this._root = node;
            }
            break;
         }

         if (node != null) {
            if (ni > 0) {
               node.split(this, ni);
            }

            Object old = node._value;
            node._key = key;
            node._value = value;
            this._entrySet.add(node);
            return old;
         } else {
            return null;
         }
      }
   }

   public Object get(Object key) {
      if (key == null) {
         return this._nullValue;
      } else {
         return key instanceof String ? this.get((String)key) : this.get(key.toString());
      }
   }

   public Object get(String key) {
      if (key == null) {
         return this._nullValue;
      } else {
         Entry entry = this.getEntry((String)key, 0, key.length());
         return entry == null ? null : entry.getValue();
      }
   }

   public Entry getEntry(String key, int offset, int length) {
      if (key == null) {
         return this._nullEntry;
      } else {
         StringMap.Node node = this._root;
         int ni = -1;

         label57:
         for(int i = 0; i < length; ++i) {
            char c = key.charAt(offset + i);
            if (ni == -1) {
               ni = 0;
               node = node._children == null ? null : node._children[c % this._width];
            }

            while(node != null) {
               if (node._char[ni] == c || this._ignoreCase && node._ochar[ni] == c) {
                  ++ni;
                  if (ni == node._char.length) {
                     ni = -1;
                  }
                  continue label57;
               }

               if (ni > 0) {
                  return null;
               }

               node = node._next;
            }

            return null;
         }

         if (ni > 0) {
            return null;
         } else if (node != null && node._key == null) {
            return null;
         } else {
            return node;
         }
      }
   }

   public Entry getEntry(char[] key, int offset, int length) {
      if (key == null) {
         return this._nullEntry;
      } else {
         StringMap.Node node = this._root;
         int ni = -1;

         label57:
         for(int i = 0; i < length; ++i) {
            char c = key[offset + i];
            if (ni == -1) {
               ni = 0;
               node = node._children == null ? null : node._children[c % this._width];
            }

            while(node != null) {
               if (node._char[ni] == c || this._ignoreCase && node._ochar[ni] == c) {
                  ++ni;
                  if (ni == node._char.length) {
                     ni = -1;
                  }
                  continue label57;
               }

               if (ni > 0) {
                  return null;
               }

               node = node._next;
            }

            return null;
         }

         if (ni > 0) {
            return null;
         } else if (node != null && node._key == null) {
            return null;
         } else {
            return node;
         }
      }
   }

   public Entry getBestEntry(byte[] key, int offset, int maxLength) {
      if (key == null) {
         return this._nullEntry;
      } else {
         StringMap.Node node = this._root;
         int ni = -1;

         label63:
         for(int i = 0; i < maxLength; ++i) {
            char c = (char)key[offset + i];
            if (ni == -1) {
               ni = 0;
               StringMap.Node child = node._children == null ? null : node._children[c % this._width];
               if (child == null && i > 0) {
                  return node;
               }

               node = child;
            }

            while(node != null) {
               if (node._char[ni] == c || this._ignoreCase && node._ochar[ni] == c) {
                  ++ni;
                  if (ni == node._char.length) {
                     ni = -1;
                  }
                  continue label63;
               }

               if (ni > 0) {
                  return null;
               }

               node = node._next;
            }

            return null;
         }

         if (ni > 0) {
            return null;
         } else if (node != null && node._key == null) {
            return null;
         } else {
            return node;
         }
      }
   }

   public Object remove(Object key) {
      return key == null ? this.remove((String)null) : this.remove(key.toString());
   }

   public Object remove(String key) {
      if (key == null) {
         Object oldValue = this._nullValue;
         if (this._nullEntry != null) {
            this._entrySet.remove(this._nullEntry);
            this._nullEntry = null;
            this._nullValue = null;
         }

         return oldValue;
      } else {
         StringMap.Node node = this._root;
         int ni = -1;

         label61:
         for(int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (ni == -1) {
               ni = 0;
               node = node._children == null ? null : node._children[c % this._width];
            }

            while(node != null) {
               if (node._char[ni] == c || this._ignoreCase && node._ochar[ni] == c) {
                  ++ni;
                  if (ni == node._char.length) {
                     ni = -1;
                  }
                  continue label61;
               }

               if (ni > 0) {
                  return null;
               }

               node = node._next;
            }

            return null;
         }

         if (ni > 0) {
            return null;
         } else if (node != null && node._key == null) {
            return null;
         } else {
            Object old = node._value;
            this._entrySet.remove(node);
            node._value = null;
            node._key = null;
            return old;
         }
      }
   }

   public Set entrySet() {
      return this._umEntrySet;
   }

   public int size() {
      return this._entrySet.size();
   }

   public boolean isEmpty() {
      return this._entrySet.isEmpty();
   }

   public boolean containsKey(Object key) {
      if (key == null) {
         return this._nullEntry != null;
      } else {
         return this.getEntry((String)key.toString(), 0, key == null ? 0 : key.toString().length()) != null;
      }
   }

   public void clear() {
      this._root = new StringMap.Node();
      this._nullEntry = null;
      this._nullValue = null;
      this._entrySet.clear();
   }

   public void writeExternal(ObjectOutput out) throws IOException {
      HashMap map = new HashMap(this);
      out.writeBoolean(this._ignoreCase);
      out.writeObject(map);
   }

   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      boolean ic = in.readBoolean();
      HashMap map = (HashMap)in.readObject();
      this.setIgnoreCase(ic);
      this.putAll(map);
   }

   private class NullEntry implements Entry {
      private NullEntry() {
      }

      public Object getKey() {
         return null;
      }

      public Object getValue() {
         return StringMap.this._nullValue;
      }

      public Object setValue(Object o) {
         Object old = StringMap.this._nullValue;
         StringMap.this._nullValue = o;
         return old;
      }

      public String toString() {
         return "[:null=" + StringMap.this._nullValue + "]";
      }

      // $FF: synthetic method
      NullEntry(Object x1) {
         this();
      }
   }

   private static class Node implements Entry {
      char[] _char;
      char[] _ochar;
      StringMap.Node _next;
      StringMap.Node[] _children;
      String _key;
      Object _value;

      Node() {
      }

      Node(boolean ignoreCase, String s, int offset) {
         int l = s.length() - offset;
         this._char = new char[l];
         this._ochar = new char[l];

         for(int i = 0; i < l; ++i) {
            char c = s.charAt(offset + i);
            this._char[i] = c;
            if (ignoreCase) {
               char o = c;
               if (Character.isUpperCase(c)) {
                  o = Character.toLowerCase(c);
               } else if (Character.isLowerCase(c)) {
                  o = Character.toUpperCase(c);
               }

               this._ochar[i] = o;
            }
         }

      }

      StringMap.Node split(StringMap map, int offset) {
         StringMap.Node split = new StringMap.Node();
         int sl = this._char.length - offset;
         char[] tmp = this._char;
         this._char = new char[offset];
         split._char = new char[sl];
         System.arraycopy(tmp, 0, this._char, 0, offset);
         System.arraycopy(tmp, offset, split._char, 0, sl);
         if (this._ochar != null) {
            tmp = this._ochar;
            this._ochar = new char[offset];
            split._ochar = new char[sl];
            System.arraycopy(tmp, 0, this._ochar, 0, offset);
            System.arraycopy(tmp, offset, split._ochar, 0, sl);
         }

         split._key = this._key;
         split._value = this._value;
         this._key = null;
         this._value = null;
         if (map._entrySet.remove(this)) {
            map._entrySet.add(split);
         }

         split._children = this._children;
         this._children = new StringMap.Node[map._width];
         this._children[split._char[0] % map._width] = split;
         if (split._ochar != null && this._children[split._ochar[0] % map._width] != split) {
            this._children[split._ochar[0] % map._width] = split;
         }

         return split;
      }

      public Object getKey() {
         return this._key;
      }

      public Object getValue() {
         return this._value;
      }

      public Object setValue(Object o) {
         Object old = this._value;
         this._value = o;
         return old;
      }

      public String toString() {
         StringBuffer buf = new StringBuffer();
         synchronized(buf) {
            this.toString(buf);
         }

         return buf.toString();
      }

      private void toString(StringBuffer buf) {
         buf.append("{[");
         int i;
         if (this._char == null) {
            buf.append('-');
         } else {
            for(i = 0; i < this._char.length; ++i) {
               buf.append(this._char[i]);
            }
         }

         buf.append(':');
         buf.append(this._key);
         buf.append('=');
         buf.append(this._value);
         buf.append(']');
         if (this._children != null) {
            for(i = 0; i < this._children.length; ++i) {
               buf.append('|');
               if (this._children[i] != null) {
                  this._children[i].toString(buf);
               } else {
                  buf.append("-");
               }
            }
         }

         buf.append('}');
         if (this._next != null) {
            buf.append(",\n");
            this._next.toString(buf);
         }

      }
   }
}
