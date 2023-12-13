package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.ConverterRegistry;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.TagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTagConverter implements TagConverter<ListTag, List> {
   public List convert(ListTag tag) {
      List<Object> ret = new ArrayList();
      List<? extends Tag> tags = tag.getValue();
      Iterator var4 = tags.iterator();

      while(var4.hasNext()) {
         Tag t = (Tag)var4.next();
         ret.add(ConverterRegistry.convertToValue(t));
      }

      return ret;
   }

   public ListTag convert(List value) {
      List<Tag> tags = new ArrayList();
      Iterator var3 = value.iterator();

      while(var3.hasNext()) {
         Object o = var3.next();
         tags.add(ConverterRegistry.convertToTag(o));
      }

      return new ListTag(tags);
   }
}
