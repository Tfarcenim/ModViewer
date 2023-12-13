package com.replaymod.lib.com.googlecode.mp4parser.util;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LazyList<E> extends AbstractList<E> {
   private static final Logger LOG = Logger.getLogger(LazyList.class);
   List<E> underlying;
   Iterator<E> elementSource;

   public LazyList(List<E> underlying, Iterator<E> elementSource) {
      this.underlying = underlying;
      this.elementSource = elementSource;
   }

   public List<E> getUnderlying() {
      return this.underlying;
   }

   private void blowup() {
      LOG.logDebug("blowup running");

      while(this.elementSource.hasNext()) {
         this.underlying.add(this.elementSource.next());
      }

   }

   public E get(int i) {
      if (this.underlying.size() > i) {
         return this.underlying.get(i);
      } else if (this.elementSource.hasNext()) {
         this.underlying.add(this.elementSource.next());
         return this.get(i);
      } else {
         throw new NoSuchElementException();
      }
   }

   public Iterator<E> iterator() {
      return new Iterator<E>() {
         int pos = 0;

         public boolean hasNext() {
            return this.pos < LazyList.this.underlying.size() || LazyList.this.elementSource.hasNext();
         }

         public E next() {
            if (this.pos < LazyList.this.underlying.size()) {
               return LazyList.this.underlying.get(this.pos++);
            } else {
               LazyList.this.underlying.add(LazyList.this.elementSource.next());
               return this.next();
            }
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }
      };
   }

   public int size() {
      LOG.logDebug("potentially expensive size() call");
      this.blowup();
      return this.underlying.size();
   }
}
