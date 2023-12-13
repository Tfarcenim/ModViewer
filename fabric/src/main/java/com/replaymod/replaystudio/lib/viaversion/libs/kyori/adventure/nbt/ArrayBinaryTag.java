package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.NotNull;

public interface ArrayBinaryTag extends BinaryTag {
   @NotNull
   BinaryTagType<? extends ArrayBinaryTag> type();
}
