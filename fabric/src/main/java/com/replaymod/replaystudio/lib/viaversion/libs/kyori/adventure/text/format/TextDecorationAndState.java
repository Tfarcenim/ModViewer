package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@NonExtendable
public interface TextDecorationAndState extends Examinable, StyleBuilderApplicable {
   @NotNull
   TextDecoration decoration();

   @NotNull
   TextDecoration.State state();

   default void styleApply(@NotNull final Style.Builder style) {
      style.decoration(this.decoration(), this.state());
   }

   @NotNull
   default Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("decoration", (Object)this.decoration()), ExaminableProperty.of("state", (Object)this.state()));
   }
}
