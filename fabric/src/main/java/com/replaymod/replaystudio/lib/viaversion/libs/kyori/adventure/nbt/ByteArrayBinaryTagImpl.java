package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Debug.Renderer;

@Renderer(
   text = "\"byte[\" + this.value.length + \"]\"",
   childrenArray = "this.value",
   hasChildren = "this.value.length > 0"
)
final class ByteArrayBinaryTagImpl extends ArrayBinaryTagImpl implements ByteArrayBinaryTag {
   final byte[] value;

   ByteArrayBinaryTagImpl(final byte[] value) {
      this.value = Arrays.copyOf(value, value.length);
   }

   @NotNull
   public byte[] value() {
      return Arrays.copyOf(this.value, this.value.length);
   }

   public int size() {
      return this.value.length;
   }

   public byte get(final int index) {
      checkIndex(index, this.value.length);
      return this.value[index];
   }

   static byte[] value(final ByteArrayBinaryTag tag) {
      return tag instanceof ByteArrayBinaryTagImpl ? ((ByteArrayBinaryTagImpl)tag).value : tag.value();
   }

   public boolean equals(@Nullable final Object other) {
      if (this == other) {
         return true;
      } else if (other != null && this.getClass() == other.getClass()) {
         ByteArrayBinaryTagImpl that = (ByteArrayBinaryTagImpl)other;
         return Arrays.equals(this.value, that.value);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Arrays.hashCode(this.value);
   }

   @NotNull
   public Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("value", this.value));
   }

   public Iterator<Byte> iterator() {
      return new Iterator<Byte>() {
         private int index;

         public boolean hasNext() {
            return this.index < ByteArrayBinaryTagImpl.this.value.length - 1;
         }

         public Byte next() {
            return ByteArrayBinaryTagImpl.this.value[this.index++];
         }
      };
   }
}
