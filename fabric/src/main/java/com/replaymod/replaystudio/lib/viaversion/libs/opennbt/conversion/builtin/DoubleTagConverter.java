package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.DoubleTag;

public class DoubleTagConverter implements TagConverter<DoubleTag, Double> {
   public Double convert(DoubleTag tag) {
      return tag.getValue();
   }

   public DoubleTag convert(Double value) {
      return new DoubleTag(value);
   }
}
