package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.regex.Matcher;
import java.util.stream.Stream;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;

public interface BlockNBTComponent extends NBTComponent<BlockNBTComponent, BlockNBTComponent.Builder>, ScopedComponent<BlockNBTComponent> {
   @NotNull
   BlockNBTComponent.Pos pos();

   @Contract(
      pure = true
   )
   @NotNull
   BlockNBTComponent pos(@NotNull final BlockNBTComponent.Pos pos);

   @Contract(
      pure = true
   )
   @NotNull
   default BlockNBTComponent localPos(final double left, final double up, final double forwards) {
      return this.pos(BlockNBTComponent.LocalPos.localPos(left, up, forwards));
   }

   @Contract(
      pure = true
   )
   @NotNull
   default BlockNBTComponent worldPos(@NotNull final BlockNBTComponent.WorldPos.Coordinate x, @NotNull final BlockNBTComponent.WorldPos.Coordinate y, @NotNull final BlockNBTComponent.WorldPos.Coordinate z) {
      return this.pos(BlockNBTComponent.WorldPos.worldPos(x, y, z));
   }

   @Contract(
      pure = true
   )
   @NotNull
   default BlockNBTComponent absoluteWorldPos(final int x, final int y, final int z) {
      return this.worldPos(BlockNBTComponent.WorldPos.Coordinate.absolute(x), BlockNBTComponent.WorldPos.Coordinate.absolute(y), BlockNBTComponent.WorldPos.Coordinate.absolute(z));
   }

   @Contract(
      pure = true
   )
   @NotNull
   default BlockNBTComponent relativeWorldPos(final int x, final int y, final int z) {
      return this.worldPos(BlockNBTComponent.WorldPos.Coordinate.relative(x), BlockNBTComponent.WorldPos.Coordinate.relative(y), BlockNBTComponent.WorldPos.Coordinate.relative(z));
   }

   @NotNull
   default Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.concat(Stream.of(ExaminableProperty.of("pos", (Object)this.pos())), NBTComponent.super.examinableProperties());
   }

   public interface WorldPos extends BlockNBTComponent.Pos {
      @NotNull
      static BlockNBTComponent.WorldPos worldPos(@NotNull final BlockNBTComponent.WorldPos.Coordinate x, @NotNull final BlockNBTComponent.WorldPos.Coordinate y, @NotNull final BlockNBTComponent.WorldPos.Coordinate z) {
         return new BlockNBTComponentImpl.WorldPosImpl(x, y, z);
      }

      /** @deprecated */
      @Deprecated
      @ScheduledForRemoval(
         inVersion = "5.0.0"
      )
      @NotNull
      static BlockNBTComponent.WorldPos of(@NotNull final BlockNBTComponent.WorldPos.Coordinate x, @NotNull final BlockNBTComponent.WorldPos.Coordinate y, @NotNull final BlockNBTComponent.WorldPos.Coordinate z) {
         return new BlockNBTComponentImpl.WorldPosImpl(x, y, z);
      }

      @NotNull
      BlockNBTComponent.WorldPos.Coordinate x();

      @NotNull
      BlockNBTComponent.WorldPos.Coordinate y();

      @NotNull
      BlockNBTComponent.WorldPos.Coordinate z();

      public interface Coordinate extends Examinable {
         @NotNull
         static BlockNBTComponent.WorldPos.Coordinate absolute(final int value) {
            return coordinate(value, BlockNBTComponent.WorldPos.Coordinate.Type.ABSOLUTE);
         }

         @NotNull
         static BlockNBTComponent.WorldPos.Coordinate relative(final int value) {
            return coordinate(value, BlockNBTComponent.WorldPos.Coordinate.Type.RELATIVE);
         }

         @NotNull
         static BlockNBTComponent.WorldPos.Coordinate coordinate(final int value, @NotNull final BlockNBTComponent.WorldPos.Coordinate.Type type) {
            return new BlockNBTComponentImpl.WorldPosImpl.CoordinateImpl(value, type);
         }

         /** @deprecated */
         @Deprecated
         @ScheduledForRemoval(
            inVersion = "5.0.0"
         )
         @NotNull
         static BlockNBTComponent.WorldPos.Coordinate of(final int value, @NotNull final BlockNBTComponent.WorldPos.Coordinate.Type type) {
            return new BlockNBTComponentImpl.WorldPosImpl.CoordinateImpl(value, type);
         }

         int value();

         @NotNull
         BlockNBTComponent.WorldPos.Coordinate.Type type();

         public static enum Type {
            ABSOLUTE,
            RELATIVE;
         }
      }
   }

   public interface LocalPos extends BlockNBTComponent.Pos {
      @NotNull
      static BlockNBTComponent.LocalPos localPos(final double left, final double up, final double forwards) {
         return new BlockNBTComponentImpl.LocalPosImpl(left, up, forwards);
      }

      /** @deprecated */
      @Deprecated
      @ScheduledForRemoval(
         inVersion = "5.0.0"
      )
      @NotNull
      static BlockNBTComponent.LocalPos of(final double left, final double up, final double forwards) {
         return new BlockNBTComponentImpl.LocalPosImpl(left, up, forwards);
      }

      double left();

      double up();

      double forwards();
   }

   public interface Pos extends Examinable {
      @NotNull
      static BlockNBTComponent.Pos fromString(@NotNull final String input) throws IllegalArgumentException {
         Matcher localMatch = BlockNBTComponentImpl.Tokens.LOCAL_PATTERN.matcher(input);
         if (localMatch.matches()) {
            return BlockNBTComponent.LocalPos.localPos(Double.parseDouble(localMatch.group(1)), Double.parseDouble(localMatch.group(3)), Double.parseDouble(localMatch.group(5)));
         } else {
            Matcher worldMatch = BlockNBTComponentImpl.Tokens.WORLD_PATTERN.matcher(input);
            if (worldMatch.matches()) {
               return BlockNBTComponent.WorldPos.worldPos(BlockNBTComponentImpl.Tokens.deserializeCoordinate(worldMatch.group(1), worldMatch.group(2)), BlockNBTComponentImpl.Tokens.deserializeCoordinate(worldMatch.group(3), worldMatch.group(4)), BlockNBTComponentImpl.Tokens.deserializeCoordinate(worldMatch.group(5), worldMatch.group(6)));
            } else {
               throw new IllegalArgumentException("Cannot convert position specification '" + input + "' into a position");
            }
         }
      }

      @NotNull
      String asString();
   }

   public interface Builder extends NBTComponentBuilder<BlockNBTComponent, BlockNBTComponent.Builder> {
      @Contract("_ -> this")
      @NotNull
      BlockNBTComponent.Builder pos(@NotNull final BlockNBTComponent.Pos pos);

      @Contract("_, _, _ -> this")
      @NotNull
      default BlockNBTComponent.Builder localPos(final double left, final double up, final double forwards) {
         return this.pos(BlockNBTComponent.LocalPos.localPos(left, up, forwards));
      }

      @Contract("_, _, _ -> this")
      @NotNull
      default BlockNBTComponent.Builder worldPos(@NotNull final BlockNBTComponent.WorldPos.Coordinate x, @NotNull final BlockNBTComponent.WorldPos.Coordinate y, @NotNull final BlockNBTComponent.WorldPos.Coordinate z) {
         return this.pos(BlockNBTComponent.WorldPos.worldPos(x, y, z));
      }

      @Contract("_, _, _ -> this")
      @NotNull
      default BlockNBTComponent.Builder absoluteWorldPos(final int x, final int y, final int z) {
         return this.worldPos(BlockNBTComponent.WorldPos.Coordinate.absolute(x), BlockNBTComponent.WorldPos.Coordinate.absolute(y), BlockNBTComponent.WorldPos.Coordinate.absolute(z));
      }

      @Contract("_, _, _ -> this")
      @NotNull
      default BlockNBTComponent.Builder relativeWorldPos(final int x, final int y, final int z) {
         return this.worldPos(BlockNBTComponent.WorldPos.Coordinate.relative(x), BlockNBTComponent.WorldPos.Coordinate.relative(y), BlockNBTComponent.WorldPos.Coordinate.relative(z));
      }
   }
}
