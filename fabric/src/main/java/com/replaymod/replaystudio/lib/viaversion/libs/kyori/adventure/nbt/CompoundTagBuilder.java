package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class CompoundTagBuilder implements CompoundBinaryTag.Builder {
   @Nullable
   private Map<String, BinaryTag> tags;

   private Map<String, BinaryTag> tags() {
      if (this.tags == null) {
         this.tags = new HashMap();
      }

      return this.tags;
   }

   @NotNull
   public CompoundBinaryTag.Builder put(@NotNull final String key, @NotNull final BinaryTag tag) {
      this.tags().put(key, tag);
      return this;
   }

   @NotNull
   public CompoundBinaryTag.Builder put(@NotNull final CompoundBinaryTag tag) {
      Map<String, BinaryTag> tags = this.tags();
      Iterator var3 = tag.keySet().iterator();

      while(var3.hasNext()) {
         String key = (String)var3.next();
         tags.put(key, tag.get(key));
      }

      return this;
   }

   @NotNull
   public CompoundBinaryTag.Builder put(@NotNull final Map<String, ? extends BinaryTag> tags) {
      this.tags().putAll(tags);
      return this;
   }

   @NotNull
   public CompoundBinaryTag.Builder remove(@NotNull final String key, @Nullable final Consumer<? super BinaryTag> removed) {
      if (this.tags != null) {
         BinaryTag tag = (BinaryTag)this.tags.remove(key);
         if (removed != null) {
            removed.accept(tag);
         }
      }

      return this;
   }

   @NotNull
   public CompoundBinaryTag build() {
      return (CompoundBinaryTag)(this.tags == null ? CompoundBinaryTag.empty() : new CompoundBinaryTagImpl(new HashMap(this.tags)));
   }
}
