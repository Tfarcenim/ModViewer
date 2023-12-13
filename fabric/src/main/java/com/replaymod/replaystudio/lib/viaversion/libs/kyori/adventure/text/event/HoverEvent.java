package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.event;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.internal.Internals;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Keyed;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt.api.BinaryTagHolder;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.ComponentLike;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.Style;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.StyleBuilderApplicable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.renderer.ComponentRenderer;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.Index;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public final class HoverEvent<V> implements Examinable, HoverEventSource<V>, StyleBuilderApplicable {
   private final HoverEvent.Action<V> action;
   private final V value;

   @NotNull
   public static HoverEvent<Component> showText(@NotNull final ComponentLike text) {
      return showText(text.asComponent());
   }

   @NotNull
   public static HoverEvent<Component> showText(@NotNull final Component text) {
      return new HoverEvent(HoverEvent.Action.SHOW_TEXT, text);
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowItem> showItem(@NotNull final Key item, @Range(from = 0L,to = 2147483647L) final int count) {
      return showItem((Key)item, count, (BinaryTagHolder)null);
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowItem> showItem(@NotNull final Keyed item, @Range(from = 0L,to = 2147483647L) final int count) {
      return showItem((Keyed)item, count, (BinaryTagHolder)null);
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowItem> showItem(@NotNull final Key item, @Range(from = 0L,to = 2147483647L) final int count, @Nullable final BinaryTagHolder nbt) {
      return showItem(HoverEvent.ShowItem.of(item, count, nbt));
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowItem> showItem(@NotNull final Keyed item, @Range(from = 0L,to = 2147483647L) final int count, @Nullable final BinaryTagHolder nbt) {
      return showItem(HoverEvent.ShowItem.of(item, count, nbt));
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowItem> showItem(@NotNull final HoverEvent.ShowItem item) {
      return new HoverEvent(HoverEvent.Action.SHOW_ITEM, item);
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowEntity> showEntity(@NotNull final Key type, @NotNull final UUID id) {
      return showEntity((Key)type, id, (Component)null);
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowEntity> showEntity(@NotNull final Keyed type, @NotNull final UUID id) {
      return showEntity((Keyed)type, id, (Component)null);
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowEntity> showEntity(@NotNull final Key type, @NotNull final UUID id, @Nullable final Component name) {
      return showEntity(HoverEvent.ShowEntity.of(type, id, name));
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowEntity> showEntity(@NotNull final Keyed type, @NotNull final UUID id, @Nullable final Component name) {
      return showEntity(HoverEvent.ShowEntity.of(type, id, name));
   }

   @NotNull
   public static HoverEvent<HoverEvent.ShowEntity> showEntity(@NotNull final HoverEvent.ShowEntity entity) {
      return new HoverEvent(HoverEvent.Action.SHOW_ENTITY, entity);
   }

   @NotNull
   public static <V> HoverEvent<V> hoverEvent(@NotNull final HoverEvent.Action<V> action, @NotNull final V value) {
      return new HoverEvent(action, value);
   }

   private HoverEvent(@NotNull final HoverEvent.Action<V> action, @NotNull final V value) {
      this.action = (HoverEvent.Action)Objects.requireNonNull(action, "action");
      this.value = Objects.requireNonNull(value, "value");
   }

   @NotNull
   public HoverEvent.Action<V> action() {
      return this.action;
   }

   @NotNull
   public V value() {
      return this.value;
   }

   @NotNull
   public HoverEvent<V> value(@NotNull final V value) {
      return new HoverEvent(this.action, value);
   }

   @NotNull
   public <C> HoverEvent<V> withRenderedValue(@NotNull final ComponentRenderer<C> renderer, @NotNull final C context) {
      V oldValue = this.value;
      V newValue = this.action.renderer.render(renderer, context, oldValue);
      return newValue != oldValue ? new HoverEvent(this.action, newValue) : this;
   }

   @NotNull
   public HoverEvent<V> asHoverEvent() {
      return this;
   }

   @NotNull
   public HoverEvent<V> asHoverEvent(@NotNull final UnaryOperator<V> op) {
      return op == UnaryOperator.identity() ? this : new HoverEvent(this.action, op.apply(this.value));
   }

   public void styleApply(@NotNull final Style.Builder style) {
      style.hoverEvent(this);
   }

   public boolean equals(@Nullable final Object other) {
      if (this == other) {
         return true;
      } else if (other != null && this.getClass() == other.getClass()) {
         HoverEvent<?> that = (HoverEvent)other;
         return this.action == that.action && this.value.equals(that.value);
      } else {
         return false;
      }
   }

   public int hashCode() {
      int result = this.action.hashCode();
      result = 31 * result + this.value.hashCode();
      return result;
   }

   @NotNull
   public Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("action", (Object)this.action), ExaminableProperty.of("value", this.value));
   }

   public String toString() {
      return Internals.toString(this);
   }

   public static final class Action<V> {
      public static final HoverEvent.Action<Component> SHOW_TEXT = new HoverEvent.Action("show_text", Component.class, true, new HoverEvent.Action.Renderer<Component>() {
         @NotNull
         public <C> Component render(@NotNull final ComponentRenderer<C> renderer, @NotNull final C context, @NotNull final Component value) {
            return renderer.render(value, context);
         }
      });
      public static final HoverEvent.Action<HoverEvent.ShowItem> SHOW_ITEM = new HoverEvent.Action("show_item", HoverEvent.ShowItem.class, true, new HoverEvent.Action.Renderer<HoverEvent.ShowItem>() {
         @NotNull
         public <C> HoverEvent.ShowItem render(@NotNull final ComponentRenderer<C> renderer, @NotNull final C context, @NotNull final HoverEvent.ShowItem value) {
            return value;
         }
      });
      public static final HoverEvent.Action<HoverEvent.ShowEntity> SHOW_ENTITY = new HoverEvent.Action("show_entity", HoverEvent.ShowEntity.class, true, new HoverEvent.Action.Renderer<HoverEvent.ShowEntity>() {
         @NotNull
         public <C> HoverEvent.ShowEntity render(@NotNull final ComponentRenderer<C> renderer, @NotNull final C context, @NotNull final HoverEvent.ShowEntity value) {
            return value.name == null ? value : value.name(renderer.render(value.name, context));
         }
      });
      public static final Index<String, HoverEvent.Action<?>> NAMES;
      private final String name;
      private final Class<V> type;
      private final boolean readable;
      private final HoverEvent.Action.Renderer<V> renderer;

      Action(final String name, final Class<V> type, final boolean readable, final HoverEvent.Action.Renderer<V> renderer) {
         this.name = name;
         this.type = type;
         this.readable = readable;
         this.renderer = renderer;
      }

      @NotNull
      public Class<V> type() {
         return this.type;
      }

      public boolean readable() {
         return this.readable;
      }

      @NotNull
      public String toString() {
         return this.name;
      }

      static {
         NAMES = Index.create((Function)((constant) -> {
            return constant.name;
         }), (Object[])(SHOW_TEXT, SHOW_ITEM, SHOW_ENTITY));
      }

      @FunctionalInterface
      interface Renderer<V> {
         @NotNull
         <C> V render(@NotNull final ComponentRenderer<C> renderer, @NotNull final C context, @NotNull final V value);
      }
   }

   public static final class ShowEntity implements Examinable {
      private final Key type;
      private final UUID id;
      private final Component name;

      @NotNull
      public static HoverEvent.ShowEntity of(@NotNull final Key type, @NotNull final UUID id) {
         return of((Key)type, id, (Component)null);
      }

      @NotNull
      public static HoverEvent.ShowEntity of(@NotNull final Keyed type, @NotNull final UUID id) {
         return of((Keyed)type, id, (Component)null);
      }

      @NotNull
      public static HoverEvent.ShowEntity of(@NotNull final Key type, @NotNull final UUID id, @Nullable final Component name) {
         return new HoverEvent.ShowEntity((Key)Objects.requireNonNull(type, "type"), (UUID)Objects.requireNonNull(id, "id"), name);
      }

      @NotNull
      public static HoverEvent.ShowEntity of(@NotNull final Keyed type, @NotNull final UUID id, @Nullable final Component name) {
         return new HoverEvent.ShowEntity(((Keyed)Objects.requireNonNull(type, "type")).key(), (UUID)Objects.requireNonNull(id, "id"), name);
      }

      private ShowEntity(@NotNull final Key type, @NotNull final UUID id, @Nullable final Component name) {
         this.type = type;
         this.id = id;
         this.name = name;
      }

      @NotNull
      public Key type() {
         return this.type;
      }

      @NotNull
      public HoverEvent.ShowEntity type(@NotNull final Key type) {
         return ((Key)Objects.requireNonNull(type, "type")).equals(this.type) ? this : new HoverEvent.ShowEntity(type, this.id, this.name);
      }

      @NotNull
      public HoverEvent.ShowEntity type(@NotNull final Keyed type) {
         return this.type(((Keyed)Objects.requireNonNull(type, "type")).key());
      }

      @NotNull
      public UUID id() {
         return this.id;
      }

      @NotNull
      public HoverEvent.ShowEntity id(@NotNull final UUID id) {
         return ((UUID)Objects.requireNonNull(id)).equals(this.id) ? this : new HoverEvent.ShowEntity(this.type, id, this.name);
      }

      @Nullable
      public Component name() {
         return this.name;
      }

      @NotNull
      public HoverEvent.ShowEntity name(@Nullable final Component name) {
         return Objects.equals(name, this.name) ? this : new HoverEvent.ShowEntity(this.type, this.id, name);
      }

      public boolean equals(@Nullable final Object other) {
         if (this == other) {
            return true;
         } else if (other != null && this.getClass() == other.getClass()) {
            HoverEvent.ShowEntity that = (HoverEvent.ShowEntity)other;
            return this.type.equals(that.type) && this.id.equals(that.id) && Objects.equals(this.name, that.name);
         } else {
            return false;
         }
      }

      public int hashCode() {
         int result = this.type.hashCode();
         result = 31 * result + this.id.hashCode();
         result = 31 * result + Objects.hashCode(this.name);
         return result;
      }

      @NotNull
      public Stream<? extends ExaminableProperty> examinableProperties() {
         return Stream.of(ExaminableProperty.of("type", (Object)this.type), ExaminableProperty.of("id", (Object)this.id), ExaminableProperty.of("name", (Object)this.name));
      }

      public String toString() {
         return Internals.toString(this);
      }
   }

   public static final class ShowItem implements Examinable {
      private final Key item;
      private final int count;
      @Nullable
      private final BinaryTagHolder nbt;

      @NotNull
      public static HoverEvent.ShowItem of(@NotNull final Key item, @Range(from = 0L,to = 2147483647L) final int count) {
         return of((Key)item, count, (BinaryTagHolder)null);
      }

      @NotNull
      public static HoverEvent.ShowItem of(@NotNull final Keyed item, @Range(from = 0L,to = 2147483647L) final int count) {
         return of((Keyed)item, count, (BinaryTagHolder)null);
      }

      @NotNull
      public static HoverEvent.ShowItem of(@NotNull final Key item, @Range(from = 0L,to = 2147483647L) final int count, @Nullable final BinaryTagHolder nbt) {
         return new HoverEvent.ShowItem((Key)Objects.requireNonNull(item, "item"), count, nbt);
      }

      @NotNull
      public static HoverEvent.ShowItem of(@NotNull final Keyed item, @Range(from = 0L,to = 2147483647L) final int count, @Nullable final BinaryTagHolder nbt) {
         return new HoverEvent.ShowItem(((Keyed)Objects.requireNonNull(item, "item")).key(), count, nbt);
      }

      private ShowItem(@NotNull final Key item, @Range(from = 0L,to = 2147483647L) final int count, @Nullable final BinaryTagHolder nbt) {
         this.item = item;
         this.count = count;
         this.nbt = nbt;
      }

      @NotNull
      public Key item() {
         return this.item;
      }

      @NotNull
      public HoverEvent.ShowItem item(@NotNull final Key item) {
         return ((Key)Objects.requireNonNull(item, "item")).equals(this.item) ? this : new HoverEvent.ShowItem(item, this.count, this.nbt);
      }

      @Range(
         from = 0L,
         to = 2147483647L
      )
      public int count() {
         return this.count;
      }

      @NotNull
      public HoverEvent.ShowItem count(@Range(from = 0L,to = 2147483647L) final int count) {
         return count == this.count ? this : new HoverEvent.ShowItem(this.item, count, this.nbt);
      }

      @Nullable
      public BinaryTagHolder nbt() {
         return this.nbt;
      }

      @NotNull
      public HoverEvent.ShowItem nbt(@Nullable final BinaryTagHolder nbt) {
         return Objects.equals(nbt, this.nbt) ? this : new HoverEvent.ShowItem(this.item, this.count, nbt);
      }

      public boolean equals(@Nullable final Object other) {
         if (this == other) {
            return true;
         } else if (other != null && this.getClass() == other.getClass()) {
            HoverEvent.ShowItem that = (HoverEvent.ShowItem)other;
            return this.item.equals(that.item) && this.count == that.count && Objects.equals(this.nbt, that.nbt);
         } else {
            return false;
         }
      }

      public int hashCode() {
         int result = this.item.hashCode();
         result = 31 * result + Integer.hashCode(this.count);
         result = 31 * result + Objects.hashCode(this.nbt);
         return result;
      }

      @NotNull
      public Stream<? extends ExaminableProperty> examinableProperties() {
         return Stream.of(ExaminableProperty.of("item", (Object)this.item), ExaminableProperty.of("count", this.count), ExaminableProperty.of("nbt", (Object)this.nbt));
      }

      public String toString() {
         return Internals.toString(this);
      }
   }
}
