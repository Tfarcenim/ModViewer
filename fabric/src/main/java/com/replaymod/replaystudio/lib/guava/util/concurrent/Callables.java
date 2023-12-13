package com.replaymod.replaystudio.lib.guava.util.concurrent;

import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.lib.guava.base.Supplier;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public final class Callables {
   private Callables() {
   }

   public static <T> Callable<T> returning(@Nullable T value) {
      return new Callable<T>() {
         public T call() {
            return value;
         }
      };
   }

   static <T> Callable<T> threadRenaming(Callable<T> callable, Supplier<String> nameSupplier) {
      Preconditions.checkNotNull(nameSupplier);
      Preconditions.checkNotNull(callable);
      return new Callable<T>() {
         public T call() throws Exception {
            Thread currentThread = Thread.currentThread();
            String oldName = currentThread.getName();
            boolean restoreName = Callables.trySetName((String)nameSupplier.get(), currentThread);

            Object var4;
            try {
               var4 = callable.call();
            } finally {
               if (restoreName) {
                  Callables.trySetName(oldName, currentThread);
               }

            }

            return var4;
         }
      };
   }

   static Runnable threadRenaming(Runnable task, Supplier<String> nameSupplier) {
      Preconditions.checkNotNull(nameSupplier);
      Preconditions.checkNotNull(task);
      return new Runnable() {
         public void run() {
            Thread currentThread = Thread.currentThread();
            String oldName = currentThread.getName();
            boolean restoreName = Callables.trySetName((String)nameSupplier.get(), currentThread);

            try {
               task.run();
            } finally {
               if (restoreName) {
                  Callables.trySetName(oldName, currentThread);
               }

            }

         }
      };
   }

   private static boolean trySetName(String threadName, Thread currentThread) {
      try {
         currentThread.setName(threadName);
         return true;
      } catch (SecurityException var3) {
         return false;
      }
   }
}
