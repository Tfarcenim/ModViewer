package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.FloatTag;

public class FloatTagConverter implements TagConverter<FloatTag, Float> {
   public Float convert(FloatTag tag) {
      return tag.getValue();
   }

   public FloatTag convert(Float value) {
      return new FloatTag(value);
   }
}
