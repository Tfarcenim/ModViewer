package com.replaymod.replaystudio.lib.guava.io;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import com.replaymod.replaystudio.lib.guava.annotations.VisibleForTesting;
import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.lib.guava.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import javax.annotation.Nullable;

@Beta
public final class Closer implements Closeable {
   private static final Closer.Suppressor SUPPRESSOR;
   @VisibleForTesting
   final Closer.Suppressor suppressor;
   private final Deque<Closeable> stack = new ArrayDeque(4);
   private Throwable thrown;

   public static Closer create() {
      return new Closer(SUPPRESSOR);
   }

   @VisibleForTesting
   Closer(Closer.Suppressor suppressor) {
      this.suppressor = (Closer.Suppressor)Preconditions.checkNotNull(suppressor);
   }

   public <C extends Closeable> C register(@Nullable C closeable) {
      if (closeable != null) {
         this.stack.addFirst(closeable);
      }

      return closeable;
   }

   public RuntimeException rethrow(Throwable e) throws IOException {
      Preconditions.checkNotNull(e);
      this.thrown = e;
      Throwables.propagateIfPossible(e, IOException.class);
      throw new RuntimeException(e);
   }

   public <X extends Exception> RuntimeException rethrow(Throwable e, Class<X> declaredType) throws IOException, X {
      Preconditions.checkNotNull(e);
      this.thrown = e;
      Throwables.propagateIfPossible(e, IOException.class);
      Throwables.propagateIfPossible(e, declaredType);
      throw new RuntimeException(e);
   }

   public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable e, Class<X1> declaredType1, Class<X2> declaredType2) throws IOException, X1, X2 {
      Preconditions.checkNotNull(e);
      this.thrown = e;
      Throwables.propagateIfPossible(e, IOException.class);
      Throwables.propagateIfPossible(e, declaredType1, declaredType2);
      throw new RuntimeException(e);
   }

   public void close() throws IOException {
      Throwable throwable = this.thrown;

      while(!this.stack.isEmpty()) {
         Closeable closeable = (Closeable)this.stack.removeFirst();

         try {
            closeable.close();
         } catch (Throwable var4) {
            if (throwable == null) {
               throwable = var4;
            } else {
               this.suppressor.suppress(closeable, throwable, var4);
            }
         }
      }

      if (this.thrown == null && throwable != null) {
         Throwables.propagateIfPossible(throwable, IOException.class);
         throw new AssertionError(throwable);
      }
   }

   static {
      SUPPRESSOR = (Closer.Suppressor)(Closer.SuppressingSuppressor.isAvailable() ? Closer.SuppressingSuppressor.INSTANCE : Closer.LoggingSuppressor.INSTANCE);
   }

   @VisibleForTesting
   static final class SuppressingSuppressor implements Closer.Suppressor {
      static final Closer.SuppressingSuppressor INSTANCE = new Closer.SuppressingSuppressor();
      static final Method addSuppressed = getAddSuppressed();

      static boolean isAvailable() {
         return addSuppressed != null;
      }

      private static Method getAddSuppressed() {
         try {
            return Throwable.class.getMethod("addSuppressed", Throwable.class);
         } catch (Throwable var1) {
            return null;
         }
      }

      public void suppress(Closeable closeable, Throwable thrown, Throwable suppressed) {
         if (thrown != suppressed) {
            try {
               addSuppressed.invoke(thrown, suppressed);
            } catch (Throwable var5) {
               Closer.LoggingSuppressor.INSTANCE.suppress(closeable, thrown, suppressed);
            }

         }
      }
   }

   @VisibleForTesting
   static final class LoggingSuppressor implements Closer.Suppressor {
      static final Closer.LoggingSuppressor INSTANCE = new Closer.LoggingSuppressor();

      public void suppress(Closeable closeable, Throwable thrown, Throwable suppressed) {
         Closeables.logger.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, suppressed);
      }
   }

   @VisibleForTesting
   interface Suppressor {
      void suppress(Closeable var1, Throwable var2, Throwable var3);
   }
}
