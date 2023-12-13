package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;

public interface TagConverter<T extends Tag, V> {
   V convert(T var1);

   T convert(V var1);
}
