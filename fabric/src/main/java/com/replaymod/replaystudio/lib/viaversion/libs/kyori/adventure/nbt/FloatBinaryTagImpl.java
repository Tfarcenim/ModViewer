package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Debug.Renderer;

@Renderer(
   text = "String.valueOf(this.value) + \"f\"",
   hasChildren = "false"
)
final class FloatBinaryTagImpl extends AbstractBinaryTag implements FloatBinaryTag {
   private final float value;

   FloatBinaryTagImpl(final float value) {
      this.value = value;
   }

   public float value() {
      return this.value;
   }

   public byte byteValue() {
      return (byte)(ShadyPines.floor(this.value) & 255);
   }

   public double doubleValue() {
      return (double)this.value;
   }

   public float floatValue() {
      return this.value;
   }

   public int intValue() {
      return ShadyPines.floor(this.value);
   }

   public long longValue() {
      return (long)this.value;
   }

   public short shortValue() {
      return (short)(ShadyPines.floor(this.value) & '\uffff');
   }

   public boolean equals(@Nullable final Object other) {
      if (this == other) {
         return true;
      } else if (other != null && this.getClass() == other.getClass()) {
         FloatBinaryTagImpl that = (FloatBinaryTagImpl)other;
         return Float.floatToIntBits(this.value) == Float.floatToIntBits(that.value);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Float.hashCode(this.value);
   }

   @NotNull
   public Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("value", this.value));
   }
}
