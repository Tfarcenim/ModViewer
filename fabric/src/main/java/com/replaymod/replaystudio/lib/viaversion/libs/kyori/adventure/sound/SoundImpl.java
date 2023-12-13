package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.sound;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.internal.Internals;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.ShadyPines;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.Objects;
import java.util.OptionalLong;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

abstract class SoundImpl implements Sound {
   static final Sound.Emitter EMITTER_SELF = new Sound.Emitter() {
      public String toString() {
         return "SelfSoundEmitter";
      }
   };
   private final Sound.Source source;
   private final float volume;
   private final float pitch;
   private final OptionalLong seed;
   private SoundStop stop;

   SoundImpl(@NotNull final Sound.Source source, final float volume, final float pitch, final OptionalLong seed) {
      this.source = source;
      this.volume = volume;
      this.pitch = pitch;
      this.seed = seed;
   }

   @NotNull
   public Sound.Source source() {
      return this.source;
   }

   public float volume() {
      return this.volume;
   }

   public float pitch() {
      return this.pitch;
   }

   public OptionalLong seed() {
      return this.seed;
   }

   @NotNull
   public SoundStop asStop() {
      if (this.stop == null) {
         this.stop = SoundStop.namedOnSource(this.name(), this.source());
      }

      return this.stop;
   }

   public boolean equals(@Nullable final Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof SoundImpl)) {
         return false;
      } else {
         SoundImpl that = (SoundImpl)other;
         return this.name().equals(that.name()) && this.source == that.source && ShadyPines.equals(this.volume, that.volume) && ShadyPines.equals(this.pitch, that.pitch) && this.seed.equals(that.seed);
      }
   }

   public int hashCode() {
      int result = this.name().hashCode();
      result = 31 * result + this.source.hashCode();
      result = 31 * result + Float.hashCode(this.volume);
      result = 31 * result + Float.hashCode(this.pitch);
      result = 31 * result + this.seed.hashCode();
      return result;
   }

   @NotNull
   public Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("name", (Object)this.name()), ExaminableProperty.of("source", (Object)this.source), ExaminableProperty.of("volume", this.volume), ExaminableProperty.of("pitch", this.pitch), ExaminableProperty.of("seed", (Object)this.seed));
   }

   public String toString() {
      return Internals.toString(this);
   }

   static final class Lazy extends SoundImpl {
      final Supplier<? extends Sound.Type> supplier;

      Lazy(@NotNull final Supplier<? extends Sound.Type> supplier, @NotNull final Sound.Source source, final float volume, final float pitch, final OptionalLong seed) {
         super(source, volume, pitch, seed);
         this.supplier = supplier;
      }

      @NotNull
      public Key name() {
         return ((Sound.Type)this.supplier.get()).key();
      }
   }

   static final class Eager extends SoundImpl {
      final Key name;

      Eager(@NotNull final Key name, @NotNull final Sound.Source source, final float volume, final float pitch, final OptionalLong seed) {
         super(source, volume, pitch, seed);
         this.name = name;
      }

      @NotNull
      public Key name() {
         return this.name;
      }
   }

   static final class BuilderImpl implements Sound.Builder {
      private static final float DEFAULT_VOLUME = 1.0F;
      private static final float DEFAULT_PITCH = 1.0F;
      private Key eagerType;
      private Supplier<? extends Sound.Type> lazyType;
      private Sound.Source source;
      private float volume;
      private float pitch;
      private OptionalLong seed;

      BuilderImpl() {
         this.source = Sound.Source.MASTER;
         this.volume = 1.0F;
         this.pitch = 1.0F;
         this.seed = OptionalLong.empty();
      }

      BuilderImpl(@NotNull final Sound existing) {
         this.source = Sound.Source.MASTER;
         this.volume = 1.0F;
         this.pitch = 1.0F;
         this.seed = OptionalLong.empty();
         if (existing instanceof SoundImpl.Eager) {
            this.type(((SoundImpl.Eager)existing).name);
         } else {
            if (!(existing instanceof SoundImpl.Lazy)) {
               throw new IllegalArgumentException("Unknown sound type " + existing + ", must be Eager or Lazy");
            }

            this.type(((SoundImpl.Lazy)existing).supplier);
         }

         this.source(existing.source()).volume(existing.volume()).pitch(existing.pitch()).seed(existing.seed());
      }

      @NotNull
      public Sound.Builder type(@NotNull final Key type) {
         this.eagerType = (Key)Objects.requireNonNull(type, "type");
         this.lazyType = null;
         return this;
      }

      @NotNull
      public Sound.Builder type(@NotNull final Sound.Type type) {
         this.eagerType = (Key)Objects.requireNonNull(((Sound.Type)Objects.requireNonNull(type, "type")).key(), "type.key()");
         this.lazyType = null;
         return this;
      }

      @NotNull
      public Sound.Builder type(@NotNull final Supplier<? extends Sound.Type> typeSupplier) {
         this.lazyType = (Supplier)Objects.requireNonNull(typeSupplier, "typeSupplier");
         this.eagerType = null;
         return this;
      }

      @NotNull
      public Sound.Builder source(@NotNull final Sound.Source source) {
         this.source = (Sound.Source)Objects.requireNonNull(source, "source");
         return this;
      }

      @NotNull
      public Sound.Builder source(@NotNull final Sound.Source.Provider source) {
         return this.source(source.soundSource());
      }

      @NotNull
      public Sound.Builder volume(@Range(from = 0L,to = 2147483647L) final float volume) {
         this.volume = volume;
         return this;
      }

      @NotNull
      public Sound.Builder pitch(@Range(from = -1L,to = 1L) final float pitch) {
         this.pitch = pitch;
         return this;
      }

      @NotNull
      public Sound.Builder seed(final long seed) {
         this.seed = OptionalLong.of(seed);
         return this;
      }

      @NotNull
      public Sound.Builder seed(@NotNull final OptionalLong seed) {
         this.seed = (OptionalLong)Objects.requireNonNull(seed, "seed");
         return this;
      }

      @NotNull
      public Sound build() {
         if (this.eagerType != null) {
            return new SoundImpl.Eager(this.eagerType, this.source, this.volume, this.pitch, this.seed);
         } else if (this.lazyType != null) {
            return new SoundImpl.Lazy(this.lazyType, this.source, this.volume, this.pitch, this.seed);
         } else {
            throw new IllegalStateException("A sound type must be provided to build a sound");
         }
      }
   }
}
