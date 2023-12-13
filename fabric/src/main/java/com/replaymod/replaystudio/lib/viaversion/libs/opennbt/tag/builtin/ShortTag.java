package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.limiter.TagLimiter;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ShortTag extends NumberTag {
   public static final int ID = 2;
   private short value;

   public ShortTag() {
      this((short)0);
   }

   public ShortTag(short value) {
      this.value = value;
   }

   /** @deprecated */
   @Deprecated
   public Short getValue() {
      return this.value;
   }

   public void setValue(short value) {
      this.value = value;
   }

   public void read(DataInput in, TagLimiter tagLimiter, int nestingLevel) throws IOException {
      tagLimiter.countShort();
      this.value = in.readShort();
   }

   public void write(DataOutput out) throws IOException {
      out.writeShort(this.value);
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         ShortTag shortTag = (ShortTag)o;
         return this.value == shortTag.value;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.value;
   }

   public final ShortTag clone() {
      return new ShortTag(this.value);
   }

   public byte asByte() {
      return (byte)this.value;
   }

   public short asShort() {
      return this.value;
   }

   public int asInt() {
      return this.value;
   }

   public long asLong() {
      return (long)this.value;
   }

   public float asFloat() {
      return (float)this.value;
   }

   public double asDouble() {
      return (double)this.value;
   }

   public int getTagId() {
      return 2;
   }
}
