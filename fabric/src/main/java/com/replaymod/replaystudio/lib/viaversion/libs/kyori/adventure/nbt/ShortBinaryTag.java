package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.NotNull;

public interface ShortBinaryTag extends NumberBinaryTag {
   @NotNull
   static ShortBinaryTag of(final short value) {
      return new ShortBinaryTagImpl(value);
   }

   @NotNull
   default BinaryTagType<ShortBinaryTag> type() {
      return BinaryTagTypes.SHORT;
   }

   short value();
}
