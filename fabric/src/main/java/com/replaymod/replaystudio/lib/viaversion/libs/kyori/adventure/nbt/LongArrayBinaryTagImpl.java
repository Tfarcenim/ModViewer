package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator.OfLong;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Debug.Renderer;

@Renderer(
   text = "\"long[\" + this.value.length + \"]\"",
   childrenArray = "this.value",
   hasChildren = "this.value.length > 0"
)
final class LongArrayBinaryTagImpl extends ArrayBinaryTagImpl implements LongArrayBinaryTag {
   final long[] value;

   LongArrayBinaryTagImpl(final long[] value) {
      this.value = Arrays.copyOf(value, value.length);
   }

   @NotNull
   public long[] value() {
      return Arrays.copyOf(this.value, this.value.length);
   }

   public int size() {
      return this.value.length;
   }

   public long get(final int index) {
      checkIndex(index, this.value.length);
      return this.value[index];
   }

   @NotNull
   public OfLong iterator() {
      return new OfLong() {
         private int index;

         public boolean hasNext() {
            return this.index < LongArrayBinaryTagImpl.this.value.length - 1;
         }

         public long nextLong() {
            if (!this.hasNext()) {
               throw new NoSuchElementException();
            } else {
               return LongArrayBinaryTagImpl.this.value[this.index++];
            }
         }
      };
   }

   @NotNull
   public java.util.Spliterator.OfLong spliterator() {
      return Arrays.spliterator(this.value);
   }

   @NotNull
   public LongStream stream() {
      return Arrays.stream(this.value);
   }

   public void forEachLong(@NotNull final LongConsumer action) {
      int i = 0;

      for(int length = this.value.length; i < length; ++i) {
         action.accept(this.value[i]);
      }

   }

   static long[] value(final LongArrayBinaryTag tag) {
      return tag instanceof LongArrayBinaryTagImpl ? ((LongArrayBinaryTagImpl)tag).value : tag.value();
   }

   public boolean equals(@Nullable final Object other) {
      if (this == other) {
         return true;
      } else if (other != null && this.getClass() == other.getClass()) {
         LongArrayBinaryTagImpl that = (LongArrayBinaryTagImpl)other;
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
}
