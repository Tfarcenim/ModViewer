package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.identity;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.internal.Internals;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class IdentityImpl implements Examinable, Identity {
   private final UUID uuid;

   IdentityImpl(final UUID uuid) {
      this.uuid = uuid;
   }

   @NotNull
   public UUID uuid() {
      return this.uuid;
   }

   public String toString() {
      return Internals.toString(this);
   }

   public boolean equals(@Nullable final Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof Identity)) {
         return false;
      } else {
         Identity that = (Identity)other;
         return this.uuid.equals(that.uuid());
      }
   }

   public int hashCode() {
      return this.uuid.hashCode();
   }
}
