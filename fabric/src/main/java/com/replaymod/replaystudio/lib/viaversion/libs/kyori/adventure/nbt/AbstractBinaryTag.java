package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.string.StringExaminer;
import org.jetbrains.annotations.NotNull;

abstract class AbstractBinaryTag implements BinaryTag {
   @NotNull
   public final String examinableName() {
      return this.type().toString();
   }

   public final String toString() {
      return (String)this.examine(StringExaminer.simpleEscaping());
   }
}
