package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ByteArrayTag;

public class ByteArrayTagConverter implements TagConverter<ByteArrayTag, byte[]> {
   public byte[] convert(ByteArrayTag tag) {
      return tag.getValue();
   }

   public ByteArrayTag convert(byte[] value) {
      return new ByteArrayTag(value);
   }
}
