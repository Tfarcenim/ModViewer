package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ByteTag;

public class ByteTagConverter implements TagConverter<ByteTag, Byte> {
   public Byte convert(ByteTag tag) {
      return tag.getValue();
   }

   public ByteTag convert(Byte value) {
      return new ByteTag(value);
   }
}
