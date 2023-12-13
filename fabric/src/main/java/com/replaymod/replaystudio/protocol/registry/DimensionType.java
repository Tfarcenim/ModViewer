package com.replaymod.replaystudio.protocol.registry;

import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.NumberTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.Tag;
import java.util.Objects;

public class DimensionType {
   private final CompoundTag tag;
   private final String name;
   private final int minY;
   private final int height;

   public DimensionType(String name) {
      this(new CompoundTag(), name);
   }

   public DimensionType(CompoundTag tag) {
      this(tag, "");
   }

   public DimensionType(CompoundTag tag, String name) {
      this.tag = tag;
      this.name = name;
      Tag minY = tag.get("min_y");
      this.minY = minY instanceof NumberTag ? ((NumberTag)minY).asInt() : 0;
      Tag height = tag.get("height");
      this.height = height instanceof NumberTag ? ((NumberTag)height).asInt() : 256;
   }

   public String getName() {
      return this.name;
   }

   public CompoundTag getTag() {
      return this.tag;
   }

   public int getMinY() {
      return this.minY;
   }

   public int getMinSectionY() {
      return this.minY >> 4;
   }

   public int getHeight() {
      return this.height;
   }

   public int getSections() {
      return this.height >> 4;
   }

   public int sectionYToIndex(int sectionY) {
      return sectionY - this.getMinSectionY();
   }

   public int indexToSectionY(int index) {
      return index + this.getMinSectionY();
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         DimensionType that = (DimensionType)o;
         return this.tag.equals(that.tag) && this.name.equals(that.name);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.tag, this.name});
   }
}
