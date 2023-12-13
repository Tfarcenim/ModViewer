package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import org.jetbrains.annotations.NotNull;

public interface BinaryTag extends BinaryTagLike, Examinable {
   @NotNull
   BinaryTagType<? extends BinaryTag> type();

   @NotNull
   default BinaryTag asBinaryTag() {
      return this;
   }
}
