package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.internal.properties.AdventureProperties;
import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;
import org.jetbrains.annotations.NotNull;

public final class Services {
   private static final boolean SERVICE_LOAD_FAILURES_ARE_FATAL;

   private Services() {
   }

   @NotNull
   public static <P> Optional<P> service(@NotNull final Class<P> type) {
      ServiceLoader<P> loader = Services0.loader(type);
      Iterator it = loader.iterator();

      while(true) {
         if (it.hasNext()) {
            Object instance;
            try {
               instance = it.next();
            } catch (Throwable var5) {
               if (!SERVICE_LOAD_FAILURES_ARE_FATAL) {
                  continue;
               }

               throw new IllegalStateException("Encountered an exception loading service " + type, var5);
            }

            if (it.hasNext()) {
               throw new IllegalStateException("Expected to find one service " + type + ", found multiple");
            }

            return Optional.of(instance);
         }

         return Optional.empty();
      }
   }

   static {
      SERVICE_LOAD_FAILURES_ARE_FATAL = Boolean.TRUE.equals(AdventureProperties.SERVICE_LOAD_FAILURES_ARE_FATAL.value());
   }
}
