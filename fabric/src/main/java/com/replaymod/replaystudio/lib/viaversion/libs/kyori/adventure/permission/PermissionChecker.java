package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.permission;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.pointer.Pointer;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.TriState;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public interface PermissionChecker extends Predicate<String> {
   Pointer<PermissionChecker> POINTER = Pointer.pointer(PermissionChecker.class, Key.key("adventure", "permission"));

   @NotNull
   static PermissionChecker always(final TriState state) {
      if (state == TriState.TRUE) {
         return PermissionCheckers.TRUE;
      } else {
         return state == TriState.FALSE ? PermissionCheckers.FALSE : PermissionCheckers.NOT_SET;
      }
   }

   @NotNull
   TriState value(final String permission);

   default boolean test(final String permission) {
      return this.value(permission) == TriState.TRUE;
   }
}
