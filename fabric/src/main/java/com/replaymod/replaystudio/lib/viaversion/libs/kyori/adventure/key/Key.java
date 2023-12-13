package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.Comparator;
import java.util.stream.Stream;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Key extends Comparable<Key>, Examinable, Namespaced, Keyed {
   String MINECRAFT_NAMESPACE = "minecraft";
   char DEFAULT_SEPARATOR = ':';

   @NotNull
   static Key key(@NotNull @Pattern("([a-z0-9_\\-.]+:)?[a-z0-9_\\-./]+") final String string) {
      return key(string, ':');
   }

   @NotNull
   static Key key(@NotNull final String string, final char character) {
      int index = string.indexOf(character);
      String namespace = index >= 1 ? string.substring(0, index) : "minecraft";
      String value = index >= 0 ? string.substring(index + 1) : string;
      return key(namespace, value);
   }

   @NotNull
   static Key key(@NotNull final Namespaced namespaced, @NotNull @Pattern("[a-z0-9_\\-./]+") final String value) {
      return key(namespaced.namespace(), value);
   }

   @NotNull
   static Key key(@NotNull @Pattern("[a-z0-9_\\-.]+") final String namespace, @NotNull @Pattern("[a-z0-9_\\-./]+") final String value) {
      return new KeyImpl(namespace, value);
   }

   @NotNull
   static Comparator<? super Key> comparator() {
      return KeyImpl.COMPARATOR;
   }

   static boolean parseable(@Nullable final String string) {
      if (string == null) {
         return false;
      } else {
         int index = string.indexOf(58);
         String namespace = index >= 1 ? string.substring(0, index) : "minecraft";
         String value = index >= 0 ? string.substring(index + 1) : string;
         return parseableNamespace(namespace) && parseableValue(value);
      }
   }

   static boolean parseableNamespace(@NotNull final String namespace) {
      int i = 0;

      for(int length = namespace.length(); i < length; ++i) {
         if (!allowedInNamespace(namespace.charAt(i))) {
            return false;
         }
      }

      return true;
   }

   static boolean parseableValue(@NotNull final String value) {
      int i = 0;

      for(int length = value.length(); i < length; ++i) {
         if (!allowedInValue(value.charAt(i))) {
            return false;
         }
      }

      return true;
   }

   static boolean allowedInNamespace(final char character) {
      return KeyImpl.allowedInNamespace(character);
   }

   static boolean allowedInValue(final char character) {
      return KeyImpl.allowedInValue(character);
   }

   @NotNull
   String namespace();

   @NotNull
   String value();

   @NotNull
   String asString();

   @NotNull
   default Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("namespace", this.namespace()), ExaminableProperty.of("value", this.value()));
   }

   default int compareTo(@NotNull final Key that) {
      return comparator().compare(this, that);
   }

   @NotNull
   default Key key() {
      return this;
   }
}
