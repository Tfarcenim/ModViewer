package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntArrayTag;

public class IntArrayTagConverter implements TagConverter<IntArrayTag, int[]> {
   public int[] convert(IntArrayTag tag) {
      return tag.getValue();
   }

   public IntArrayTag convert(int[] value) {
      return new IntArrayTag(value);
   }
}
