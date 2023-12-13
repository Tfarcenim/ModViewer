package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator.OfInt;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Debug.Renderer;

@Renderer(
   text = "\"int[\" + this.value.length + \"]\"",
   childrenArray = "this.value",
   hasChildren = "this.value.length > 0"
)
final class IntArrayBinaryTagImpl extends ArrayBinaryTagImpl implements IntArrayBinaryTag {
   final int[] value;

   IntArrayBinaryTagImpl(final int... value) {
      this.value = Arrays.copyOf(value, value.length);
   }

   @NotNull
   public int[] value() {
      return Arrays.copyOf(this.value, this.value.length);
   }

   public int size() {
      return this.value.length;
   }

   public int get(final int index) {
      checkIndex(index, this.value.length);
      return this.value[index];
   }

   @NotNull
   public OfInt iterator() {
      return new OfInt() {
         private int index;

         public boolean hasNext() {
            return this.index < IntArrayBinaryTagImpl.this.value.length - 1;
         }

         public int nextInt() {
            if (!this.hasNext()) {
               throw new NoSuchElementException();
            } else {
               return IntArrayBinaryTagImpl.this.value[this.index++];
            }
         }
      };
   }

   @NotNull
   public java.util.Spliterator.OfInt spliterator() {
      return Arrays.spliterator(this.value);
   }

   @NotNull
   public IntStream stream() {
      return Arrays.stream(this.value);
   }

   public void forEachInt(@NotNull final IntConsumer action) {
      int i = 0;

      for(int length = this.value.length; i < length; ++i) {
         action.accept(this.value[i]);
      }

   }

   static int[] value(final IntArrayBinaryTag tag) {
      return tag instanceof IntArrayBinaryTagImpl ? ((IntArrayBinaryTagImpl)tag).value : tag.value();
   }

   public boolean equals(@Nullable final Object other) {
      if (this == other) {
         return true;
      } else if (other != null && this.getClass() == other.getClass()) {
         IntArrayBinaryTagImpl that = (IntArrayBinaryTagImpl)other;
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
