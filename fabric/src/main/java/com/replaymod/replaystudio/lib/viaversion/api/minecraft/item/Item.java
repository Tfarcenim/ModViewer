package com.replaymod.replaystudio.lib.viaversion.api.minecraft.item;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Item {
   int identifier();

   void setIdentifier(int var1);

   int amount();

   void setAmount(int var1);

   default short data() {
      return 0;
   }

   default void setData(short data) {
      throw new UnsupportedOperationException();
   }

   @Nullable
   CompoundTag tag();

   void setTag(@Nullable CompoundTag var1);

   Item copy();
}
