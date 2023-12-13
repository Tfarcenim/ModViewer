package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.NotNull;

public interface DoubleBinaryTag extends NumberBinaryTag {
   @NotNull
   static DoubleBinaryTag of(final double value) {
      return new DoubleBinaryTagImpl(value);
   }

   @NotNull
   default BinaryTagType<DoubleBinaryTag> type() {
      return BinaryTagTypes.DOUBLE;
   }

   double value();
}
