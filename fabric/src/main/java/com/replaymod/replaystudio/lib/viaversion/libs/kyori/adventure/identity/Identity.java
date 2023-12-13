package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.identity;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.pointer.Pointer;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public interface Identity extends Examinable {
   Pointer<String> NAME = Pointer.pointer(String.class, Key.key("adventure", "name"));
   Pointer<UUID> UUID = Pointer.pointer(UUID.class, Key.key("adventure", "uuid"));
   Pointer<Component> DISPLAY_NAME = Pointer.pointer(Component.class, Key.key("adventure", "display_name"));
   Pointer<Locale> LOCALE = Pointer.pointer(Locale.class, Key.key("adventure", "locale"));

   @NotNull
   static Identity nil() {
      return NilIdentity.INSTANCE;
   }

   @NotNull
   static Identity identity(@NotNull final UUID uuid) {
      return (Identity)(uuid.equals(NilIdentity.NIL_UUID) ? NilIdentity.INSTANCE : new IdentityImpl(uuid));
   }

   @NotNull
   UUID uuid();

   @NotNull
   default Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("uuid", (Object)this.uuid()));
   }
}
