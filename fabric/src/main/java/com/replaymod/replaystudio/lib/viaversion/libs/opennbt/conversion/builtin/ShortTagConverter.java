package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ShortTag;

public class ShortTagConverter implements TagConverter<ShortTag, Short> {
   public Short convert(ShortTag tag) {
      return tag.getValue();
   }

   public ShortTag convert(Short value) {
      return new ShortTag(value);
   }
}
