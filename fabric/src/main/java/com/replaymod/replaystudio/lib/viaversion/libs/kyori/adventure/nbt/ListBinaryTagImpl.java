package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import org.jetbrains.annotations.Debug.Renderer;

@Renderer(
   text = "\"ListBinaryTag[type=\" + this.type.toString() + \"]\"",
   childrenArray = "this.tags.toArray()",
   hasChildren = "!this.tags.isEmpty()"
)
final class ListBinaryTagImpl extends AbstractBinaryTag implements ListBinaryTag {
   static final ListBinaryTag EMPTY;
   private final List<BinaryTag> tags;
   private final BinaryTagType<? extends BinaryTag> elementType;
   private final int hashCode;

   ListBinaryTagImpl(final BinaryTagType<? extends BinaryTag> elementType, final List<BinaryTag> tags) {
      this.tags = Collections.unmodifiableList(tags);
      this.elementType = elementType;
      this.hashCode = tags.hashCode();
   }

   @NotNull
   public BinaryTagType<? extends BinaryTag> elementType() {
      return this.elementType;
   }

   public int size() {
      return this.tags.size();
   }

   @NotNull
   public BinaryTag get(@Range(from = 0L,to = 2147483647L) final int index) {
      return (BinaryTag)this.tags.get(index);
   }

   @NotNull
   public ListBinaryTag set(final int index, @NotNull final BinaryTag newTag, @Nullable final Consumer<? super BinaryTag> removed) {
      return this.edit((tags) -> {
         BinaryTag oldTag = (BinaryTag)tags.set(index, newTag);
         if (removed != null) {
            removed.accept(oldTag);
         }

      }, newTag.type());
   }

   @NotNull
   public ListBinaryTag remove(final int index, @Nullable final Consumer<? super BinaryTag> removed) {
      return this.edit((tags) -> {
         BinaryTag oldTag = (BinaryTag)tags.remove(index);
         if (removed != null) {
            removed.accept(oldTag);
         }

      }, (BinaryTagType)null);
   }

   @NotNull
   public ListBinaryTag add(final BinaryTag tag) {
      noAddEnd(tag);
      if (this.elementType != BinaryTagTypes.END) {
         mustBeSameType(tag, this.elementType);
      }

      return this.edit((tags) -> {
         tags.add(tag);
      }, tag.type());
   }

   @NotNull
   public ListBinaryTag add(final Iterable<? extends BinaryTag> tagsToAdd) {
      if (tagsToAdd instanceof Collection && ((Collection)tagsToAdd).isEmpty()) {
         return this;
      } else {
         BinaryTagType<?> type = mustBeSameType(tagsToAdd);
         return this.edit((tags) -> {
            Iterator var2 = tagsToAdd.iterator();

            while(var2.hasNext()) {
               BinaryTag tag = (BinaryTag)var2.next();
               tags.add(tag);
            }

         }, type);
      }
   }

   static void noAddEnd(final BinaryTag tag) {
      if (tag.type() == BinaryTagTypes.END) {
         throw new IllegalArgumentException(String.format("Cannot add a %s to a %s", BinaryTagTypes.END, BinaryTagTypes.LIST));
      }
   }

   static BinaryTagType<?> mustBeSameType(final Iterable<? extends BinaryTag> tags) {
      BinaryTagType<?> type = null;
      Iterator var2 = tags.iterator();

      while(var2.hasNext()) {
         BinaryTag tag = (BinaryTag)var2.next();
         if (type == null) {
            type = tag.type();
         } else {
            mustBeSameType(tag, type);
         }
      }

      return type;
   }

   static void mustBeSameType(final BinaryTag tag, final BinaryTagType<? extends BinaryTag> type) {
      if (tag.type() != type) {
         throw new IllegalArgumentException(String.format("Trying to add tag of type %s to list of %s", tag.type(), type));
      }
   }

   private ListBinaryTag edit(final Consumer<List<BinaryTag>> consumer, @Nullable final BinaryTagType<? extends BinaryTag> maybeElementType) {
      List<BinaryTag> tags = new ArrayList(this.tags);
      consumer.accept(tags);
      BinaryTagType<? extends BinaryTag> elementType = this.elementType;
      if (maybeElementType != null && elementType == BinaryTagTypes.END) {
         elementType = maybeElementType;
      }

      return new ListBinaryTagImpl(elementType, tags);
   }

   @NotNull
   public Stream<BinaryTag> stream() {
      return this.tags.stream();
   }

   public Iterator<BinaryTag> iterator() {
      final Iterator<BinaryTag> iterator = this.tags.iterator();
      return new Iterator<BinaryTag>() {
         public boolean hasNext() {
            return iterator.hasNext();
         }

         public BinaryTag next() {
            return (BinaryTag)iterator.next();
         }

         public void forEachRemaining(final Consumer<? super BinaryTag> action) {
            iterator.forEachRemaining(action);
         }
      };
   }

   public void forEach(final Consumer<? super BinaryTag> action) {
      this.tags.forEach(action);
   }

   public Spliterator<BinaryTag> spliterator() {
      return Spliterators.spliterator(this.tags, 1040);
   }

   public boolean equals(final Object that) {
      return this == that || that instanceof ListBinaryTagImpl && this.tags.equals(((ListBinaryTagImpl)that).tags);
   }

   public int hashCode() {
      return this.hashCode;
   }

   @NotNull
   public Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("tags", (Object)this.tags), ExaminableProperty.of("type", (Object)this.elementType));
   }

   static {
      EMPTY = new ListBinaryTagImpl(BinaryTagTypes.END, Collections.emptyList());
   }
}
