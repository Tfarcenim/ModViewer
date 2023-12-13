package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntTag;

public class IntTagConverter implements TagConverter<IntTag, Integer> {
   public Integer convert(IntTag tag) {
      return tag.getValue();
   }

   public IntTag convert(Integer value) {
      return new IntTag(value);
   }
}
