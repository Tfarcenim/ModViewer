package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.NotNull;

public interface ByteArrayBinaryTag extends ArrayBinaryTag, Iterable<Byte> {
   @NotNull
   static ByteArrayBinaryTag of(@NotNull final byte... value) {
      return new ByteArrayBinaryTagImpl(value);
   }

   @NotNull
   default BinaryTagType<ByteArrayBinaryTag> type() {
      return BinaryTagTypes.BYTE_ARRAY;
   }

   @NotNull
   byte[] value();

   int size();

   byte get(final int index);
}
