package com.replaymod.lib.org.mortbay.util;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SingletonList extends AbstractList {
   private Object o;

   private SingletonList(Object o) {
      this.o = o;
   }

   public static SingletonList newSingletonList(Object o) {
      return new SingletonList(o);
   }

   public Object get(int i) {
      if (i != 0) {
         throw new IndexOutOfBoundsException("index " + i);
      } else {
         return this.o;
      }
   }

   public int size() {
      return 1;
   }

   public ListIterator listIterator() {
      return new SingletonList.SIterator();
   }

   public ListIterator listIterator(int i) {
      return new SingletonList.SIterator(i);
   }

   public Iterator iterator() {
      return new SingletonList.SIterator();
   }

   private class SIterator implements ListIterator {
      int i;

      SIterator() {
         this.i = 0;
      }

      SIterator(int i) {
         if (i >= 0 && i <= 1) {
            this.i = i;
         } else {
            throw new IndexOutOfBoundsException("index " + i);
         }
      }

      public void add(Object o) {
         throw new UnsupportedOperationException("SingletonList.add()");
      }

      public boolean hasNext() {
         return this.i == 0;
      }

      public boolean hasPrevious() {
         return this.i == 1;
      }

      public Object next() {
         if (this.i != 0) {
            throw new NoSuchElementException();
         } else {
            ++this.i;
            return SingletonList.this.o;
         }
      }

      public int nextIndex() {
         return this.i;
      }

      public Object previous() {
         if (this.i != 1) {
            throw new NoSuchElementException();
         } else {
            --this.i;
            return SingletonList.this.o;
         }
      }

      public int previousIndex() {
         return this.i - 1;
      }

      public void remove() {
         throw new UnsupportedOperationException("SingletonList.remove()");
      }

      public void set(Object o) {
         throw new UnsupportedOperationException("SingletonList.add()");
      }
   }
}
