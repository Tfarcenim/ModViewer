package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.pointer;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public interface Pointer<V> extends Examinable {
   @NotNull
   static <V> Pointer<V> pointer(@NotNull final Class<V> type, @NotNull final Key key) {
      return new PointerImpl(type, key);
   }

   @NotNull
   Class<V> type();

   @NotNull
   Key key();

   @NotNull
   default Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("type", (Object)this.type()), ExaminableProperty.of("key", (Object)this.key()));
   }
}
