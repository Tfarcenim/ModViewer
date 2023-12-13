package com.replaymod.lib.org.mortbay.component;

import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.LazyList;
import java.util.EventListener;

public class Container {
   private Object _listeners;

   public synchronized void addEventListener(Container.Listener listener) {
      this._listeners = LazyList.add(this._listeners, listener);
   }

   public synchronized void removeEventListener(Container.Listener listener) {
      this._listeners = LazyList.remove(this._listeners, listener);
   }

   public synchronized void update(Object parent, Object oldChild, Object child, String relationship) {
      if (oldChild != null && !oldChild.equals(child)) {
         this.remove(parent, oldChild, relationship);
      }

      if (child != null && !child.equals(oldChild)) {
         this.add(parent, child, relationship);
      }

   }

   public synchronized void update(Object parent, Object oldChild, Object child, String relationship, boolean addRemove) {
      if (oldChild != null && !oldChild.equals(child)) {
         this.remove(parent, oldChild, relationship);
         if (addRemove) {
            this.removeBean(oldChild);
         }
      }

      if (child != null && !child.equals(oldChild)) {
         if (addRemove) {
            this.addBean(child);
         }

         this.add(parent, child, relationship);
      }

   }

   public synchronized void update(Object parent, Object[] oldChildren, Object[] children, String relationship) {
      this.update(parent, oldChildren, children, relationship, false);
   }

   public synchronized void update(Object parent, Object[] oldChildren, Object[] children, String relationship, boolean addRemove) {
      Object[] newChildren = null;
      int i;
      if (children != null) {
         newChildren = new Object[children.length];
         i = children.length;

         while(i-- > 0) {
            boolean new_child = true;
            if (oldChildren != null) {
               int j = oldChildren.length;

               while(j-- > 0) {
                  if (children[i] != null && children[i].equals(oldChildren[j])) {
                     oldChildren[j] = null;
                     new_child = false;
                  }
               }
            }

            if (new_child) {
               newChildren[i] = children[i];
            }
         }
      }

      if (oldChildren != null) {
         i = oldChildren.length;

         while(i-- > 0) {
            if (oldChildren[i] != null) {
               this.remove(parent, oldChildren[i], relationship);
               if (addRemove) {
                  this.removeBean(oldChildren[i]);
               }
            }
         }
      }

      if (newChildren != null) {
         for(i = 0; i < newChildren.length; ++i) {
            if (newChildren[i] != null) {
               if (addRemove) {
                  this.addBean(newChildren[i]);
               }

               this.add(parent, newChildren[i], relationship);
            }
         }
      }

   }

   public void addBean(Object obj) {
      if (this._listeners != null) {
         for(int i = 0; i < LazyList.size(this._listeners); ++i) {
            Container.Listener listener = (Container.Listener)LazyList.get(this._listeners, i);
            listener.addBean(obj);
         }
      }

   }

   public void removeBean(Object obj) {
      if (this._listeners != null) {
         for(int i = 0; i < LazyList.size(this._listeners); ++i) {
            ((Container.Listener)LazyList.get(this._listeners, i)).removeBean(obj);
         }
      }

   }

   private void add(Object parent, Object child, String relationship) {
      if (Log.isDebugEnabled()) {
         Log.debug("Container " + parent + " + " + child + " as " + relationship);
      }

      if (this._listeners != null) {
         Container.Relationship event = new Container.Relationship(this, parent, child, relationship);

         for(int i = 0; i < LazyList.size(this._listeners); ++i) {
            ((Container.Listener)LazyList.get(this._listeners, i)).add(event);
         }
      }

   }

   private void remove(Object parent, Object child, String relationship) {
      if (Log.isDebugEnabled()) {
         Log.debug("Container " + parent + " - " + child + " as " + relationship);
      }

      if (this._listeners != null) {
         Container.Relationship event = new Container.Relationship(this, parent, child, relationship);

         for(int i = 0; i < LazyList.size(this._listeners); ++i) {
            ((Container.Listener)LazyList.get(this._listeners, i)).remove(event);
         }
      }

   }

   public interface Listener extends EventListener {
      void addBean(Object var1);

      void removeBean(Object var1);

      void add(Container.Relationship var1);

      void remove(Container.Relationship var1);
   }

   public static class Relationship {
      private Object _parent;
      private Object _child;
      private String _relationship;
      private Container _container;

      private Relationship(Container container, Object parent, Object child, String relationship) {
         this._container = container;
         this._parent = parent;
         this._child = child;
         this._relationship = relationship;
      }

      public Container getContainer() {
         return this._container;
      }

      public Object getChild() {
         return this._child;
      }

      public Object getParent() {
         return this._parent;
      }

      public String getRelationship() {
         return this._relationship;
      }

      public String toString() {
         return this._parent + "---" + this._relationship + "-->" + this._child;
      }

      public int hashCode() {
         return this._parent.hashCode() + this._child.hashCode() + this._relationship.hashCode();
      }

      public boolean equals(Object o) {
         if (o != null && o instanceof Container.Relationship) {
            Container.Relationship r = (Container.Relationship)o;
            return r._parent == this._parent && r._child == this._child && r._relationship.equals(this._relationship);
         } else {
            return false;
         }
      }

      // $FF: synthetic method
      Relationship(Container x0, Object x1, Object x2, String x3, Object x4) {
         this(x0, x1, x2, x3);
      }
   }
}
