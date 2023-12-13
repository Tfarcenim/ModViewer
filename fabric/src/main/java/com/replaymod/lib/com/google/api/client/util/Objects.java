package com.replaymod.lib.com.google.api.client.util;

public final class Objects {
   public static boolean equal(Object a, Object b) {
      return com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Objects.equal(a, b);
   }

   public static Objects.ToStringHelper toStringHelper(Object self) {
      return new Objects.ToStringHelper(self.getClass().getSimpleName());
   }

   private Objects() {
   }

   public static final class ToStringHelper {
      private final String className;
      private Objects.ToStringHelper.ValueHolder holderHead = new Objects.ToStringHelper.ValueHolder();
      private Objects.ToStringHelper.ValueHolder holderTail;
      private boolean omitNullValues;

      ToStringHelper(String className) {
         this.holderTail = this.holderHead;
         this.className = className;
      }

      public Objects.ToStringHelper omitNullValues() {
         this.omitNullValues = true;
         return this;
      }

      public Objects.ToStringHelper add(String name, Object value) {
         return this.addHolder(name, value);
      }

      public String toString() {
         boolean omitNullValuesSnapshot = this.omitNullValues;
         String nextSeparator = "";
         StringBuilder builder = (new StringBuilder(32)).append(this.className).append('{');

         for(Objects.ToStringHelper.ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
            if (!omitNullValuesSnapshot || valueHolder.value != null) {
               builder.append(nextSeparator);
               nextSeparator = ", ";
               if (valueHolder.name != null) {
                  builder.append(valueHolder.name).append('=');
               }

               builder.append(valueHolder.value);
            }
         }

         return builder.append('}').toString();
      }

      private Objects.ToStringHelper.ValueHolder addHolder() {
         Objects.ToStringHelper.ValueHolder valueHolder = new Objects.ToStringHelper.ValueHolder();
         this.holderTail = this.holderTail.next = valueHolder;
         return valueHolder;
      }

      private Objects.ToStringHelper addHolder(String name, Object value) {
         Objects.ToStringHelper.ValueHolder valueHolder = this.addHolder();
         valueHolder.value = value;
         valueHolder.name = (String)Preconditions.checkNotNull(name);
         return this;
      }

      private static final class ValueHolder {
         String name;
         Object value;
         Objects.ToStringHelper.ValueHolder next;

         private ValueHolder() {
         }

         // $FF: synthetic method
         ValueHolder(Object x0) {
            this();
         }
      }
   }
}
