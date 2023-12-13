package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.LongArrayTag;

public class LongArrayTagConverter implements TagConverter<LongArrayTag, long[]> {
   public long[] convert(LongArrayTag tag) {
      return tag.getValue();
   }

   public LongArrayTag convert(long[] value) {
      return new LongArrayTag(value);
   }
}
