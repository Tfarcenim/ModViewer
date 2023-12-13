package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.limiter.TagLimiter;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class StringTag extends Tag {
   public static final int ID = 8;
   private String value;

   public StringTag() {
      this("");
   }

   public StringTag(String value) {
      if (value == null) {
         throw new NullPointerException("value cannot be null");
      } else {
         this.value = value;
      }
   }

   public String getValue() {
      return this.value;
   }

   public void setValue(String value) {
      if (value == null) {
         throw new NullPointerException("value cannot be null");
      } else {
         this.value = value;
      }
   }

   public void read(DataInput in, TagLimiter tagLimiter, int nestingLevel) throws IOException {
      this.value = in.readUTF();
      tagLimiter.countBytes(2 * this.value.length());
   }

   public void write(DataOutput out) throws IOException {
      out.writeUTF(this.value);
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         StringTag stringTag = (StringTag)o;
         return this.value.equals(stringTag.value);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.value.hashCode();
   }

   public final StringTag clone() {
      return new StringTag(this.value);
   }

   public int getTagId() {
      return 8;
   }
}
