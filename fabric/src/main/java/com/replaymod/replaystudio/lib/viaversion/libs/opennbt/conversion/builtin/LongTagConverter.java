package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.LongTag;

public class LongTagConverter implements TagConverter<LongTag, Long> {
   public Long convert(LongTag tag) {
      return tag.getValue();
   }

   public LongTag convert(Long value) {
      return new LongTag(value);
   }
}
