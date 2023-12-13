package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.stream.Stream;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface StorageNBTComponent extends NBTComponent<StorageNBTComponent, StorageNBTComponent.Builder>, ScopedComponent<StorageNBTComponent> {
   @NotNull
   Key storage();

   @Contract(
      pure = true
   )
   @NotNull
   StorageNBTComponent storage(@NotNull final Key storage);

   @NotNull
   default Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.concat(Stream.of(ExaminableProperty.of("storage", (Object)this.storage())), NBTComponent.super.examinableProperties());
   }

   public interface Builder extends NBTComponentBuilder<StorageNBTComponent, StorageNBTComponent.Builder> {
      @Contract("_ -> this")
      @NotNull
      StorageNBTComponent.Builder storage(@NotNull final Key storage);
   }
}
